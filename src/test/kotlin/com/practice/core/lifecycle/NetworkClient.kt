package com.practice.core.lifecycle

import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

class NetworkClient(
    private val url: String
) {

    init {
        println("생성자 호출, url=$url")
    }

    @PostConstruct
    fun init() {
        println("NetworkClient.init")
        connect()
        call("초기화 연결 메시지")
    }

    @PreDestroy
    fun close() {
        println("NetworkClient.close")
        disconnect()
    }

    private fun connect() {
        println("connect $url")
    }

    private fun call(message: String) {
        println("call: $url message=$message")
    }

    private fun disconnect() {
        println("close:$url")
    }
}