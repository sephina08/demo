package com.ntut.practice.demo.controller.product;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ntut.practice.demo.model.product.ProductFormBean;
import com.ntut.practice.demo.service.product.ProductService;

@Controller
// URL輸入的值 add (add = product)
// 預設使用是GET方法
@RequestMapping(value = "add")

public class ProductController {
	@Autowired ProductService productService;
	/* 
	URL輸入的值 product (productd = productAdd)
	 如果要用URL導頁一定要用GET
	*/

	@RequestMapping(value = "product") /* 第二個參數 method = RequestMethod.GET */
	// ↓此方法導入聲請帳號的頁面
	public String productAdd() {
		return "product/productAdd";
		// 回傳值為路徑"/WEB-INF/views/"與".jsp" 此部分已設定好預設
		// 所以只要回傳"資料夾/jsp檔名不須加.jsp"
	}
	//↓此方法導入登入商品頁面的submit
	//只要使用到@Mapping bean的名子會自動跟jsp標籤的name自動合併
	@PostMapping("addProduct")
	//ModelAndView 可以同時傳值和導頁
	public ModelAndView addProduct(ProductFormBean bean){
		Map<String,String> checkResult = productService.check(bean);
		if(checkResult.size() != 0 ){
			ModelAndView mav = new ModelAndView("product/productAdd");
			mav.addObject("errorMsg",checkResult);
			//↑將錯誤訊息放到errorMsg裡面,addObject方法類似setAttribute方法
			return mav;
		}
		productService.insertProduct(bean);
		ModelAndView mav = new ModelAndView("product/productSuccess");
		return mav;
	}
}
