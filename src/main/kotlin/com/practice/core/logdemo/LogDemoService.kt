package com.practice.core.logdemo

import com.practice.core.common.MyLogger
import org.springframework.beans.factory.ObjectProvider
import org.springframework.stereotype.Service

@Service
class LogDemoService(
    private val myLogger: MyLogger,
) {
    fun logic(id: String) {
        myLogger.log("service id = $id")
    }


}