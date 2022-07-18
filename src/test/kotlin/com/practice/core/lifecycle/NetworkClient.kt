package com.practice.core.lifecycle

import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean

class NetworkClient(
    private val url: String
): InitializingBean, DisposableBean {

    init {
        println("생성자 호출, url=$url")
        connect()
        call("초기화 연결 메시지")
    }

    override fun afterPropertiesSet() {
        connect()
        call("초기화 연결 메시지")
    }

    override fun destroy() {
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