package com.zking.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zking.ssm.dto.UserDto;
import com.zking.ssm.model.JiaKu;
import com.zking.ssm.model.User;
import com.zking.ssm.model.UserVip;
import com.zking.ssm.service.IJiaKuService;
import com.zking.ssm.service.IUserService;
import com.zking.ssm.service.IUserVipService;
import com.zking.ssm.util.JsonData;
import com.zking.ssm.util.MyUtil;
import com.zking.ssm.util.PageBean;
import com.zking.ssm.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.scheduling.annotation.Scheduled;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private IUserVipService iUserVipService;

    @ModelAttribute
    public void initUser(HttpServletRequest req){
        System.out.println("UserController初始化中......");
//        初始化所有用户card-->vip
        List<UserVip> userVips = iUserVipService.selectVIPALL();
        req.setAttribute("VIP",userVips);
    }

    @RequestMapping("/listBy")
    public String listById(Model model,User user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<String> json = new ArrayList<String>();
        String mgs = "未操作";
        System.out.println("查询（id）");
        User u = userService.selectByPrimaryKey(user.getId());
        mgs="查询完毕";
        json.add(mgs);
        String s = mapper.writeValueAsString(json);
        model.addAttribute("user",u);
        return "index";
    }

    @RequestMapping("/listById")
    @ResponseBody
    public JsonData list(Model model, User user) throws JsonProcessingException {
//        ----------
        JsonData jsonData = new JsonData();
        String mgs = "未操作";
        System.out.println("查询（id）11");
        User u = userService.selectByPrimaryKey(user.getId());
        mgs="查询完毕";
//        ---------
        jsonData.setMessage(mgs);
        jsonData.setResult(u);
        return jsonData;
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
//                    判断是否成年
                    boolean adult = MyUtil.isAdult(line);
                    if(adult){
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
                        mgs="未成年无法注册，好好读书，敲代码";
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


    @RequestMapping("/login")
    public String loginUser(Model model,User user){
        String mgs = "无操作";
//        首先就是防空null,身份证号，以及密码
        if(null!=user.getIdentity()&&!"".equals(user.getIdentity())){
            if(null!=user.getPassword()&&!"".equals(user.getPassword())){
//                其次，判断身份证号，是否成年
                boolean adult = MyUtil.isAdult(user.getIdentity());
                if(adult){
//                    再次，判断用户是否被注册
                    User usr = userService.selectByIdentityUser(user);
                    if(usr!=null){
//                        然后，判断是否用户被激活了
                        if(null!=usr.getState()&& !"未激活".equals(usr.getState())){
//           注意：                 加一步，判断卡中是否还有余额
//                            如果余额为0则，无法登陆 0 or 小于0 都不能登陆
                            if(null!=usr.getMoney() && 0<usr.getMoney()){
//                            需要对密码，是否进行了盐加密
                                if(null!=usr.getSalt()){
//                                进行了盐加密
                                    boolean b = PasswordHelper.checkCredentials(user.getPassword(), usr.getSalt(), usr.getPassword());
                                    if(b){
//                                    成功后修改状态-->已上机
                                        usr.setState("已上机");
                                        int i = userService.updateByPrimaryKeySelective(usr);
                                        if(1==i){
                                            User cxusr = userService.selectByPrimaryKey(usr.getId());
                                            model.addAttribute("updStatusUser",cxusr);
                                            mgs="修改状态成功（已上机）";
                                        }else{
                                            mgs="修改用户状态失败（检查SQL）";
                                        }
                                    }else{
                                        mgs="盐密码匹配失败，'傻眼'了吧";
                                    }
                                }else{
//                                没有进行盐加密的
                                    if(usr.getPassword().equals(user.getPassword())){
//                                    成功后修改状态-->已上机
                                        usr.setState("已上机");
                                        int i = userService.updateByPrimaryKeySelective(usr);
                                        if(1==i){
                                            User cxusr = userService.selectByPrimaryKey(usr.getId());
                                            model.addAttribute("updStatusUser",cxusr);
                                            mgs="修改状态成功（已上机）";
                                        }else{
                                            mgs="修改用户状态失败（检查SQL）";
                                        }
                                    }else{
                                        mgs="密码匹配失败，仔细是一种态度";
                                    }
                                }
                            }else if(usr.getMoney()<0){
                                mgs="余额已经透支了"+usr.getMoney()+"元";
                            }else{
                                mgs="余额不足:"+usr.getMoney()+"元";
                            }
                        }else{
                            mgs="用户状态："+usr.getState();
                        }
                    }else{
                        mgs="未注册，你可以选择快速注册（目前：不支持快速注册）";
                    }
                }else{
                    mgs="操作失败，可能（①无效身份证，②未成年）";
                }
            }else{
                mgs="密码不能为空";
            }
        }else{
            mgs="身份ID不能为空";
        }

        model.addAttribute("mgs", mgs);
        return "index";
    }


    @RequestMapping("/actStatus")
    public String actUserStatus(Model model,User user){
        String mgs = "未操作";
        if(null!=user.getIdentity() && !"".equals(user.getIdentity())){
            //      一个按钮激活事件，将用户状态修改为已激活状态
//        这个按钮定义在查询中，根据具体的身份证号激活指定的用户
            User usr = userService.selectByIdentityUser(user);
            usr.setState("已激活");
            int i = userService.updateByPrimaryKeySelective(usr);
            if(1==i){
                User auser = userService.selectByPrimaryKey(usr.getId());
                model.addAttribute("actUser", auser);
                mgs="用户激活成功";
            }else{
                mgs="激活失败"+usr.getId();
            }
        }else{
            mgs="获取身份证号失败";
        }
        model.addAttribute("mgs",mgs);
        return "index";
    }

//    修改用户状态
    @RequestMapping("/actStatusDown")
    public String actStatusDown(Model model,User user){
        String mgs = "未操作";
        if(null!=user.getIdentity() && !"".equals(user.getIdentity())){
            //      一个按钮激活事件，将用户状态修改为已激活状态
//        这个按钮定义在查询中，根据具体的身份证号激活指定的用户
            User usr = userService.selectByIdentityUser(user);
            usr.setState("未激活");
            int i = userService.updateByPrimaryKeySelective(usr);
            if(1==i){
                User auser = userService.selectByPrimaryKey(usr.getId());
                model.addAttribute("actUser", auser);
                mgs="操作成功，欢迎下次使用";
            }else{
                mgs="操作失败，获取Id:"+usr.getId();
            }
        }else{
            mgs="获取身份证号失败";
        }
        model.addAttribute("mgs",mgs);
        return "index";
    }

    //查询用户所有，不分页
    @RequestMapping("/listUserNoPager")
    public String listUser(Model model,User user,HttpServletRequest req){
//       查询所有（支持模糊查询，字段为，名字，身份证号）
        String mgs = "未操作";
        PageBean pageBean = new PageBean();
//        初始5条数据
        pageBean.setRows(5);
        pageBean.initPageBean(req,pageBean);
//        这里不分页
        pageBean.setPagination(false);
        List<User> listUser = userService.selectUserAllPager(user, pageBean);
//        查询用户内容
        if(null!=listUser && 0!=listUser.size()){
            model.addAttribute("listUserAll",listUser);
            boolean pagination = pageBean.isPagination();
            if(pagination){
                mgs="查询共计"+pageBean.getTotal()+"条";
            }else{
                mgs="未启用分页：（默认查询所有）"+pageBean.isPagination();
            }
        }else{
            mgs="网吧刚开，没有忠实用户";
        }
        model.addAttribute("mgs",mgs);
        return "index";
    }

//    查询用户所有，分页，支持模糊查询
    @RequestMapping("/listUserBy")
    public String actUserStatusDown(Model model,User user,HttpServletRequest req){
        //       查询所有（支持模糊查询，字段为，名字，身份证号）
        String mgs = "未操作";
        //        这个api,目前只能接受一个字段的~模糊查询
        try {
            PageBean pageBean = new PageBean();
        //        初始5条数据
            pageBean.setRows(5);
            pageBean.initPageBean(req,pageBean);
            List<User> listUser = userService.selectUserAllPager(user, pageBean);
        //        查询用户内容
            if(null!=listUser && 0!=listUser.size()){
                model.addAttribute("listUserTab",listUser);
                boolean pagination = pageBean.isPagination();
                if(pagination){
                    mgs="查询共计"+pageBean.getTotal()+"条";
                }else{
                    mgs="未启用分页：（默认查询所有）"+pageBean.isPagination();
                }
            }else{
                mgs="没有查询到用户";
            }
        }catch (Exception e){
            mgs="亲爱的用户:目前只能接受一个字段的~模糊查询，开发者正在努力的梳头发中...";
        }
        model.addAttribute("mgs",mgs);
        return "index";
    }

//    查询用户vip账号
    @RequestMapping("/checkVip")
    public String checkVip(Model model,User user,UserVip userVip){
        String mgs= "无操作";
        if(null!=user.getVipid()){
            //        将user表中的vipid-->赋给VIP表中查看，具体字段！
            userVip.setVid(user.getVipid());
            UserVip vip = iUserVipService.selectVIP(userVip);
            model.addAttribute("userVip",vip);
            mgs="尊敬的 "+vip.getVipName()+" 欢迎来到强强网咖2.0";
        }else{
            mgs="查看详情失败，vip："+user.getVipid();
        }
        model.addAttribute("mgs",mgs);
        return "index";
    }

//    查询vip用户
    @RequestMapping("/checkVipUser")
    public String checkVipUser(Model model, UserDto userDto,HttpServletRequest req){
        String mgs= "无操作";
        if(null!=userDto.getVipId()){
            PageBean pageBean = new PageBean();
            //        初始5条数据
            pageBean.setRows(5);
            pageBean.initPageBean(req,pageBean);
            List<User> users = userService.selectUserByVipPager(userDto,pageBean);
            model.addAttribute("listUserTab",users);
            boolean pagination = pageBean.isPagination();
            if(pagination){
                mgs="尊敬的会员朋友们:查询共计"+pageBean.getTotal()+"条";
            }else{
                mgs="未启用分页：（默认查询所有）"+pageBean.isPagination();
            }
        }else{
            mgs="查看详情失败，vip："+userDto.getVipId();
        }
        model.addAttribute("mgs",mgs);
        return "index";
    }

}
