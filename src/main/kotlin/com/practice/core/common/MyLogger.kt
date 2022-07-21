package com.practice.core.common

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.util.UUID
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

@Component
@Scope(value = "request")
class MyLogger {
    lateinit var uuid: String
    lateinit var requestURL: String

    fun log(message: String) {
        println("[$uuid][$requestURL]$message")
    }

    @PostConstruct
    fun init() {
        uuid = "${UUID.randomUUID()}"
        println("[$uuid]request scope bean create: $this")
    }

    @PreDestroy
    fun close() {
        println("[$uuid]request scope bean close: $this")
    }

}