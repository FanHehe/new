package com.fanhehe.cmd.service.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
class PictureServiceAspect {

    private static final Logger logger = LoggerFactory.getLogger(PictureServiceAspect.class);

    @Pointcut("execution(* com.fanhehe.cmd.service.HomeService.handleIndex(..))")
    public void handleIndex() {}

    @Before("execution(* com.fanhehe.cmd.service.HomeService.handleIndex(..))")
    public void target() {
        logger.info("------------ aop executed !!!!!!!!!!");
    }

    @Before(value="handleIndex()")
    public void beforeHandleIndex() {
        logger.info("------------ before execute !!!!!!!!");
    }

}
