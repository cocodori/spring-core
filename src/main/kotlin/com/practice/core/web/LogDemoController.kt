package com.practice.core.web

import com.practice.core.common.MyLogger
import com.practice.core.logdemo.LogDemoService
import org.springframework.beans.factory.ObjectProvider
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
class LogDemoController(
    private val logDemoService: LogDemoService,
    private val myLoggerProvider: ObjectProvider<MyLogger>
) {

    @RequestMapping("log-demo")
    @ResponseBody
    fun logDemo(request: HttpServletRequest): String {
        val requestURL = request.requestURL
        val myLogger = myLoggerProvider.getObject()

        myLogger.requestURL = "$requestURL"
        myLogger.log("controller test")

        logDemoService.logic("testId")

        return "OK"
    }
}