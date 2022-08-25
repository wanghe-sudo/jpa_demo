package com.jpa.jpa_demo.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author
 * @Date 2022/8/25
 * @DESC
 */
@Aspect
public class SelectAspects {

    /**
     * 定义切点,定义的方法就是切点
     */
    @Pointcut("execution(public * com.jpa.jpa_demo.service.UserService.find(..))")
    public void selectAllPointCut() {
    }

    /**
     * 定义切面
     */
    @Pointcut("execution(public * com.jpa.jpa_demo.service.UserService.findByUserContractAddress(..))")
    public void findOnePointCut() {
    }

//    @Before(value = "pointCut()")
//    public void before(JoinPoint joinpoint) {
//        Object[] args = joinpoint.getArgs();
//        System.out.println("=================================");
//        System.out.println(joinpoint.getTarget());
//        System.out.println(args);
//        System.out.println("=================================");
//    }
//
//    @AfterReturning(value = "pointCut()", returning = "returnValue")
//    public void after(JoinPoint joinpoint, Object returnValue) {
//        System.out.println(returnValue);
//    }

    @Around(value = "selectAllPointCut()")
    public Object selectAllAround(ProceedingJoinPoint joinPoint) {
        Object proceed;
        try {
            System.out.println("before");
            // 返回值直接有
            proceed = joinPoint.proceed();
            System.out.println("after");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println(proceed);
        return proceed;
    }

    @Around(value = "findOnePointCut()")
    public Object findOneAround(ProceedingJoinPoint joinPoint) {
        Object proceed;
        try {
            System.out.println("before");
            // 返回值直接有
            proceed = joinPoint.proceed();
            System.out.println("after");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println(proceed);
        return proceed;
    }
}
