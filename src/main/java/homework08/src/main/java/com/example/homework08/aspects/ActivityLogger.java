package com.example.homework08.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
public class ActivityLogger {
    private Logger logger = Logger.getLogger(ActivityLogger.class.getName());

    @Before("@annotation(com.example.homework08.aspects.TrackUserAction)")
    public void log(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        String logMessage = "Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute";

        System.out.println(" --- " + logMessage);
        logger.info(logMessage);
    }
}
