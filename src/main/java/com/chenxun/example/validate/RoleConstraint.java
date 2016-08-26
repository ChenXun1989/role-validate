/**
 * Project Name:chenxun-cros
 * File Name:RoleConstraint.java
 * Package Name:com.chenxun.validate
 * Date:2016年8月26日上午10:42:53
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.example.validate;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

/**
 * ClassName:RoleConstraint <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月26日 上午10:42:53 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=RoleConstraintValidator.class)
public @interface RoleConstraint {

	String message() default "ACCESS DENIED !";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
	/**
	 * 
	 * values:(角色列表). <br/>
	 * ROLE_ADMIN,ROLE_USER
	 * @author 陈勋
	 * @return
	 * @since JDK 1.7
	 */
	String[] value();
	
	
	
	

}

