package com.jpa.jpa_demo.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * @Author
 * @Date 2022/8/25
 * @DESC 基于注解的切面定义
 */
@Aspect
public class InsertAspects {
    /**
     * 定义切点,以后主要方法上有这个注解,它就是一个切点
     */
    @Pointcut("@annotation(com.jpa.jpa_demo.annotition.InsertLog)")
    public void pointCut() {
    }

    /**
     * 定义切面
     * @param joinPoint
     * @return
     */
    @Around(value = "pointCut()")
    //@Order(value = 1000) 这个注解是在多切面情况下改变切面的执行顺序的,如果不设置,则安装方法名,由字母a-z执行
    //虽然order改变了切面的执行顺序,但是谁会在一个方法中添加超过3层切面呢?,考验自己的逻辑能力吗?
    public Object insertAround(ProceedingJoinPoint joinPoint) {
        Object proceed;
        try {
            System.out.println("userRepo.save before");

            proceed = joinPoint.proceed();
            System.out.println("userRepo.save after");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return proceed;
    }
}
