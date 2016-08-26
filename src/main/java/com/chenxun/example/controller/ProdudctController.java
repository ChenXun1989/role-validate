package com.chenxun.example.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.chenxun.example.entity.Product;

/**
 * 
 * ClassName: ProdudctController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年8月26日 下午12:58:23 <br/>
 *
 * @author 陈勋
 * @version 
 * @since JDK 1.7
 */
@RestController
public class ProdudctController {
	
	@PostMapping("/product")
	public ResponseEntity<String> product(@Valid  @RequestBody Product product,BindingResult result){
		if(result.hasErrors()){
			return ResponseEntity.ok(result.getFieldError().getDefaultMessage());
		}
		return ResponseEntity.ok("SUCCESS");
	}
	
	
	
	

}
