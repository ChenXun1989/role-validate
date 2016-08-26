/**
 * Project Name:chenxun-cros
 * File Name:RoleConstraintValidator.java
 * Package Name:com.chenxun.validate
 * Date:2016年8月26日上午10:39:29
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
 */

package com.chenxun.example.validate;

import java.lang.annotation.Annotation;
import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * ClassName:RoleConstraintValidator <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年8月26日 上午10:39:29 <br/>
 * 
 * @author 陈勋
 * @version
 * @since JDK 1.7
 * @see
 */
public class RoleConstraintValidator implements
		ConstraintValidator<Annotation, Object> {

	@Override
	public void initialize(Annotation constraintAnnotation) {

		// 初始化动作 可以提升性能。缓存用户的 所有字段。 优化下个方法调用

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
        //默认值处理
		if (value == null) {
			return true;
		}
		if (value instanceof Number) {

			Number num = (Number) value;
			if (num.byteValue() == 0) {
				return true;
			}
		}

		// 获取当前用户的角色列表
		ConstraintValidatorContextImpl cvci = (ConstraintValidatorContextImpl) context;

		RoleConstraint rc = (RoleConstraint) cvci.getConstraintDescriptor()
				.getAnnotation();
		String[] roles = rc.value();
		// 执行相关逻辑 角色和资源的关系（是否拥有资源权限）
		// 注意该校验与 value值无关
		Collection<? extends GrantedAuthority> auths = SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority auth : auths) {
			// 简单原则，有其中一个角色即可
			for (String role : roles) {
				if (role.equals(auth.getAuthority())) {
					return true;
				}
			}
		}

		return false;
	}

}
