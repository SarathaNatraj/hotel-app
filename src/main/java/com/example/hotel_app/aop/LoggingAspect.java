package com.example.hotel_app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy 

@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Pointcut for all controllers in your package
    @Pointcut("within(com.example.hotel_app.controller..*)")
    public void controllerMethods() {}
   
    // Pointcut for all controllers in your package
    @Pointcut("within(com.example.hotel_app.service..*)")
    public void serviceMethods() {}
   
    
    
    @Pointcut("execution(* com.example.hotel_app.exception.ExceptionController.*(..))")
    public void exceptionHandlers() {}

    // Before method execution
    @Before("controllerMethods()")
    public void logBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("Entering method: {}.{}() with args={}",
                signature.getDeclaringTypeName(),
                signature.getName(),
                joinPoint.getArgs());
    }

    // After method returns successfully
    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method {}.{}() returned={}",
                signature.getDeclaringTypeName(),
                signature.getName(),
                result);
    }

    // After method throws exception
    @AfterThrowing(pointcut = "controllerMethods()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, RuntimeException ex) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.error("Method {}.{}() threw exception JoinPoint ={}",
                signature.getDeclaringTypeName(),
                signature.getName(),
                ex.getMessage(), ex);
    }
    @Around("controllerMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Exception ex) {
            logger.error("Method {}.{}() threw exception ProceedingJoinPoint={}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                ex.getMessage(), ex);
            throw ex; // rethrow so ControllerAdvice can still handle it
        }
    }

    // After method completes (finally)
    @After("controllerMethods()")
    public void logAfterFinally(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("Exiting method: {}.{}()",
                signature.getDeclaringTypeName(),
                signature.getName());
    }
}
