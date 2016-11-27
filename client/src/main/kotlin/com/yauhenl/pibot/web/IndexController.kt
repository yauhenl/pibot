package com.yauhenl.pibot.web

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus.OK
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import java.net.HttpURLConnection
import java.net.URL

@Controller
class IndexController {

    private val LOG = LoggerFactory.getLogger(IndexController::class.java)

    @Value("\${botHost}")
    private val host: String? = null

    @GetMapping("/")
    fun view(): String = "index"

    @GetMapping("/action/{actionName}")
    @ResponseStatus(OK)
    fun action(@PathVariable actionName: String) = request(host + "/action/" + actionName)

    private fun request(url: String) {
        try {
            val obj = URL(url)
            val con = obj.openConnection() as HttpURLConnection
            con.responseCode
            con.disconnect()
        } catch (e: Exception) {
            LOG.error("Connection exception!", e)
        }
    }
}
