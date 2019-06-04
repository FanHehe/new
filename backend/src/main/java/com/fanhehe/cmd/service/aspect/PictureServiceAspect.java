package com.fanhehe.cmd.service.aspect;

import org.aspectj.lang.annotation.Pointcut;

class PictureServiceAspect {

    @Pointcut("** com.fanhehe.cmd.service.aspect.PictureServiceAspect.excuete(..)")
    public void excuete() {}

    public void writePictureLog() {}
}
