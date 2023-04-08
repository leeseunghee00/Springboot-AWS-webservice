package com.seunghee.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)      //PARAMETER로 지정하면, 메소드의 파라미터로 선언된 객체에서만 사용할 수 있다.
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {       //어노테이션 클래스를 지정한다; LoginUser 이름을 가진 어노테이션이 생성되었다.
}
