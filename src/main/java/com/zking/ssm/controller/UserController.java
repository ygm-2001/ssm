package com.zking.ssm.controller;

import com.zking.ssm.model.JiaKu;
import com.zking.ssm.model.User;
import com.zking.ssm.service.IJiaKuService;
import com.zking.ssm.service.IUserService;
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
        String mgs = "NUll";
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
                            //信息初始化User中
                            User u = new User();
                            u.setIdentity(jiaKu.getjIdentity());
                            u.setName(jiaKu.getjName());
                            //一个事件~保存身份信息~生成用户信息
                            userService.intoUserAndJiaKu(jiaKu,u);
                            mgs="注册成功";
                        }else{
                            //信息初始化User中
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



}
