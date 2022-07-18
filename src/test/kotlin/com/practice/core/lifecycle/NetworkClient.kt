package com.practice.core.lifecycle

class NetworkClient(
    private val url: String
) {

    init {
        println("생성자 호출, url=$url")
    }

    fun init() {
        println("NetworkClient.init")
        connect()
        call("초기화 연결 메시지")
    }

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