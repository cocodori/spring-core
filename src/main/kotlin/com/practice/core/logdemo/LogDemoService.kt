package com.practice.core.logdemo

import com.practice.core.common.MyLogger
import org.springframework.beans.factory.ObjectProvider
import org.springframework.stereotype.Service

@Service
class LogDemoService(
    private val myLoggerProvider: ObjectProvider<MyLogger>
) {
    fun logic(id: String) {
        val myLogger = myLoggerProvider.getObject()

        myLogger.log("service id = $id")
    }


}