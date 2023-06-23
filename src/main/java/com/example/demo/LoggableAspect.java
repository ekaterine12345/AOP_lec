package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggableAspect {

    @Pointcut("@annotation(Loggable)")   // romel anotaciazec gvinda rom Pointcut moxeds is unda gadavcet argumentad
    public void loggableMethod(){

    }

    @Around("loggableMethod()")
    public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature)  pjp.getSignature();
        String className = signature.getDeclaringType().getName();
        String methodName = signature.getName();

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try{
            return  pjp.proceed();
        }
        finally {
            stopWatch.stop();
            System.out.println("Execution time for class " + className + "  and method "+
                    methodName + " is " + stopWatch.getTotalTimeMillis());
        }


    } //pucqciis mushaobis drois datvla

    @Before("loggableMethod()")
    public void before(){
        System.out.println("Before     ");
    }
}
// throws exception anotaciashi ar sheiudzleba