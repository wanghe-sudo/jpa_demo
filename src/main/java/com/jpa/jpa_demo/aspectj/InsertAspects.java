package com.jpa.jpa_demo.aspectj;

import com.jpa.jpa_demo.annotition.InsertLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Modifier;

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
    @Pointcut(value = "@annotation(com.jpa.jpa_demo.annotition.InsertLog)")
    public void pointCut() {
    }

    /**
     * 定义切面
     *
     * @param joinPoint
     * @return
     */
    @Around(value = "pointCut()&& @annotation(insertLog)")
    //@Order(value = 1000) 这个注解是在多切面情况下改变切面的执行顺序的,如果不设置,则安装方法名,由字母a-z执行
    //虽然order改变了切面的执行顺序,但是谁会在一个方法中添加超过3层切面呢?,考验自己的逻辑能力吗?
    public Object insertAround(ProceedingJoinPoint joinPoint, InsertLog insertLog) {
        Object proceed;
        try {
            System.out.println("userRepo.save before");
            System.out.println("******拦截前的逻辑******");
            System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
            System.out.println("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
            System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
            System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
            //获取传入目标方法的参数
            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < args.length; i++) {
                System.out.println("第" + (i + 1) + "个参数为:" + args[i]);
            }
            System.out.println("被代理的对象:" + joinPoint.getTarget());
            System.out.println("代理对象自己:" + joinPoint.getThis());
            System.out.println("拦截的注解的参数：" + insertLog.value());
            proceed = joinPoint.proceed();
            System.out.println("userRepo.save after");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return proceed;
    }
}
