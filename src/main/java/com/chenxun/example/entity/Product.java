/**
 * Project Name:validate-role
 * File Name:Product.java
 * Package Name:com.chenxun.example.entity
 * Date:2016年8月26日下午12:59:12
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.example.entity;

import lombok.Data;

import com.chenxun.example.validate.RoleConstraint;

/**
 * ClassName:Product <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月26日 下午12:59:12 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Data
public class Product {
	
	private String name;
	
	@RoleConstraint("ROLE_USER")
	private String password;
	
	@RoleConstraint("ROLE_ADMIN")
	private String desc;
	
	

}

