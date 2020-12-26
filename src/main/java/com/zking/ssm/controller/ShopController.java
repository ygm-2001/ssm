package com.zking.ssm.controller;

import com.zking.ssm.mapper.ShopMapper;
import com.zking.ssm.model.Shop;
import com.zking.ssm.service.IShopService;
import com.zking.ssm.util.JsonData;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private IShopService iShopService;

    @RequestMapping("/listAllShop")
    @ResponseBody
    public JsonData listAllShop(Model model, Shop shop , HttpServletRequest req){
        JsonData jsonData = new JsonData();
        String mgs = "未操作";
        if(null!=shop){
            PageBean pageBean = new PageBean();
            //默认10
//             初始5条数据
            pageBean.setRows(5);
            pageBean.initPageBean(req,pageBean);
//            目前不使用分页
            pageBean.setPagination(false);
            List<Shop> shops = iShopService.selectShopAllPager(shop, pageBean);
            jsonData.setResult(shops);
            mgs="商品种类:"+shop.getShopType();
            jsonData.setMessage(mgs);
        }else{
            mgs="无法识别：商品";
            jsonData.setMessage(mgs);
            jsonData.setCode(400);
        }
        return jsonData;
    }
}
