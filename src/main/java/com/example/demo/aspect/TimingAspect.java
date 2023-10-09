package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimingAspect {

    private static final Logger logger = LoggerFactory.getLogger(TimingAspect.class);

    @Around("execution(* com.example.demo.service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Clazz.Method [{}.{}] took {} ms", this.sanitizeClazzName(pjp.getTarget().getClass().getName()), pjp.getSignature().getName(), elapsedTime);
        return output;
    }
    @Around("execution(* com.example.demo.api.*.*(..))")
    public Object caller(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Clazz.Method [{}.{}] took {} ms", this.sanitizeClazzName(pjp.getTarget().getClass().getName()), pjp.getSignature().getName(), elapsedTime);
        return output;
    }
    
    private String sanitizeClazzName(String canonical) {
     String className = canonical;

     // Comprobamos si es un proxy de CGLIB y, en caso afirmativo, lo limpiamos
     if (className.contains("$$")) {
         className = className.substring(0, className.indexOf("$$")).substring(className.lastIndexOf("."));
     }
     if (className.contains(".")) {
         className = className.substring(className.lastIndexOf(".") + 1);
     }
     return className;
    }
}
