package com.example.demo.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class ConcurrentOperationExecutor implements Ordered {

    public static final Log logger = LogFactory.getLog(ConcurrentOperationExecutor.class);

    private static final int DEFAULT_MAX_RETRIES = 2;

    @Value("100")
    private int order = 1;
    @Value("3")
    private int maxRetries = DEFAULT_MAX_RETRIES;

    public void setMaxRetries(int order) {
        this.order = order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    @Pointcut("execution(* com.example.demo.service.*.*(..))")
    public void idempotentOperation() { }

    @Around(value="idempotentOperation()")
    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("pjp is " + pjp.getTarget().getClass());
        logger.info("order = " + order + ", max = " + maxRetries);

        int numAttempts = 0;
        IllegalArgumentException exception;
        do {
            numAttempts++;
            try {
                return pjp.proceed();
            } catch (IllegalArgumentException ex) {
                exception = ex;
            }
        } while(numAttempts <= this.maxRetries) ;
        throw exception;
    }
}