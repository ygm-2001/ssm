package com.zking.ssm.controller;

import com.zking.ssm.model.JiaKu;
import com.zking.ssm.model.User;
import com.zking.ssm.service.IJiaKuService;
import com.zking.ssm.service.IUserService;
import com.zking.ssm.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Pattern;


/**
 * @author ygm
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IJiaKuService iJiaKuService;

    @Autowired
    private IUserService userService;

    @RequestMapping("/listBy")
    public String listById(Model model,User user){
        System.out.println("查询（id）");
        User u = userService.selectByPrimaryKey(user.getId());
        model.addAttribute("user",u);
        return "index";
    }

    @RequestMapping("/listById")
    @ResponseBody
    public User list(Model model,User user){
        System.out.println("查询（id）11");
        User u = userService.selectByPrimaryKey(user.getId());
        model.addAttribute("user",u);
        return u;
    }

    @RequestMapping("/add")
    public String Add(Model model,User user,JiaKu jiaKu){
        String mgs = "无操作";
        //防空指针~身份证号
        if(null!=jiaKu.getjIdentity() && !"".equals(jiaKu.getjIdentity())){
            //防空指针~身份名
            if(null!=jiaKu.getjName()&& !"".equals(jiaKu.getjName())){
                //这里进行正则验证
                String line = jiaKu.getjIdentity();
                String pattern = "^[1-9]\\d{5}[1-9]\\d{3}((0[1-9])|(1[0-2]))(0[1-9]|([1|2][0-9])|3[0-1])((\\d{4})|\\d{3}X)$";
                boolean isMatch = Pattern.matches(pattern, line);
                if(isMatch){
                    //保存用户身份信息与假库中
                    JiaKu ju = iJiaKuService.listByIdentity(jiaKu);
                        if(null==ju){
                            //信息匹配中
                            User u = new User();
                            u.setIdentity(jiaKu.getjIdentity());
                            u.setName(jiaKu.getjName());
                            //一个事件~保存身份信息~生成用户信息
                            userService.intoUserAndJiaKu(jiaKu,u);
                            mgs="注册成功";
                        }else{
                            //信息匹配中
                            user.setIdentity(ju.getjIdentity());
                            user.setName(ju.getjName());
                            //防止注册重复
                            int cofu = userService.selectByIdentity(user);
                            if(0==cofu) {
                                int i = userService.insertSelective(user);
                                if (1 == i) {
                                    mgs = "注册成功";
                                    model.addAttribute("addUser", user);
                                } else {
                                    mgs = "注册失败";
                                }
                            }else{
                                mgs="已注册";
                            }
                        }
                }else{
                  mgs="无效身份证";
                }
            }else{
                mgs="身份名不能为空";
            }
        }else{
            mgs="身份号不能为空";
        }
        model.addAttribute("mgs",mgs);
        return "index";
    }

    @RequestMapping("/updPwd")
    public String updPassMd5Salt(Model model,User user,String oldPwd,String newPwd){
        String mgs = "无操作";
        if(null!=user.getIdentity() && !"".equals(user.getIdentity())){
            //查询用户是否存在
            User usr = userService.selectByIdentityUser(user);
            if(null!=usr){
                //查看是否已经激活
                if(!"未激活".equals(usr.getState()) && null!=usr.getState()){
                    //防止空指针
                    if(null!=oldPwd && !"".equals(oldPwd) && null!=newPwd && !"".equals(newPwd)){
                        //查询用户是否进行了盐加密
                        if(null!=usr.getSalt()){
                            //进行了盐加密
                            boolean b = PasswordHelper.checkCredentials(oldPwd, usr.getSalt(), usr.getPassword());
                            //判断盐密码是否相同
                            if(b){
                                /**修改后进行盐加密
                                 *       用户或网管 修改成功后进行盐加密
                                 *       生成随机盐
                                 */
                                String salt = PasswordHelper.createSalt();
                                //生成的随机MD5加密后的密码
                                String credentials = PasswordHelper.createCredentials(newPwd, salt);
                                usr.setPassword(credentials);
                                usr.setSalt(salt);
                                int i = userService.updateByPrimaryKeySelective(usr);
                                if(1 == i){
                                    mgs="密码加密+修改成功";
                                    model.addAttribute("updPwdUser", usr);
                                }else{
                                    mgs="密码加密失败";
                                }
                            }else{
                                mgs="盐密码匹配失败";
                            }
                        }else{
                            //没有进行盐加密
                            //简单的判断密码是否相同
                            if(usr.getPassword().equals(oldPwd)){
                                /**修改后进行盐加密
                                *       用户或网管 修改成功后进行盐加密
                                 *       生成随机盐
                                */
                                 String salt = PasswordHelper.createSalt();
                                //生成的随机MD5加密后的密码
                                String credentials = PasswordHelper.createCredentials(newPwd, salt);
                                usr.setPassword(credentials);
                                usr.setSalt(salt);
                                int i = userService.updateByPrimaryKeySelective(usr);
                                if(1 == i){
                                    mgs="密码加密+修改成功";
                                    model.addAttribute("updPwdUser", usr);
                                }else{
                                    mgs="密码加密失败";
                                }
                            }else{
                                mgs="没盐密码匹配失败";
                            }
                        }
                    }else{
                        mgs = "原密码获取失败"+oldPwd;
                    }
                }else{
                    mgs="用户状态"+usr.getState()+"操作失败";
                }
            }else{
                mgs="未查询到该用户"+usr;
            }
        }else{
            mgs="身份号获取失败"+user.getIdentity();
        }
        model.addAttribute("mgs",mgs);
        return "index";
    }


}
