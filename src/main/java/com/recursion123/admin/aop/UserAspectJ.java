package com.recursion123.admin.aop;

import com.recursion123.admin.model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class UserAspectJ {
    @Pointcut("execution(* com.recursion123.admin.dao.UserDao.*(..))")
    public void chooseMethod() {
    }

    @Around("chooseMethod()")
    public Object aroundChooseMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        for (Object object : joinPoint.getArgs()) {
            if (object instanceof User) {
                User user = ((User) object);
                if (user.getPassword() != null) {
                    user.setPassword(new Md5PasswordEncoder().encodePassword(user.getPassword(), null));
                }
            }
        }
        return joinPoint.proceed(joinPoint.getArgs());
    }
}
