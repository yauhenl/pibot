package com.yauhenl.pibot.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

import java.net.HttpURLConnection
import java.net.URL

import org.springframework.web.bind.annotation.RequestMethod.GET

@Controller
class IndexController {
    @Value("\${botHost}")
    private val host: String? = null

    @RequestMapping(value = "/")
    fun view(): String {
        return "index"
    }

    @RequestMapping(value = "/switch/{state}", method = arrayOf(GET))
    @ResponseStatus(HttpStatus.OK)
    fun state(@PathVariable state: String) {
        request(host + "/switch/" + state)
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/move/{direction}", method = arrayOf(GET))
    fun move(@PathVariable direction: String) {
        request(host + "/move/" + direction)
    }

    private fun request(url: String) {
        try {
            val obj = URL(url)
            val con = obj.openConnection() as HttpURLConnection
            con.responseCode
            con.disconnect()
        } catch (ignore: Exception) {
        }

    }
}
