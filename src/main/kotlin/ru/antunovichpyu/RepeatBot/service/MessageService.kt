package ru.antunovichpyu.RepeatBot.service

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import ru.antunovichpyu.RepeatBot.configuration.VkProperties
import ru.antunovichpyu.RepeatBot.dto.RequestDto
import kotlin.math.min

@Service
class MessageService(val vkProperties: VkProperties) {

    fun handleRequest(requestDto: RequestDto): String {
        when(requestDto.type) {
            "confirmation" -> return vkProperties.confirmationToken
            "message_new" -> {
                formNewMessage(requestDto)
                return "ok"
            }
            else -> throw IllegalArgumentException()
        }
    }

    private fun formNewMessage(requestDto: RequestDto) {
        val maxMessageLength = 3500
        val userMessage = requestDto.objects.message
        val userId = userMessage.fromId
        val randomId = 0
        val message = "Вы написали: " + userMessage.text
        for (i in 0..message.length / maxMessageLength) {
            val startIndex = i * maxMessageLength
            val endIndex = min((i + 1) * maxMessageLength, message.length)
            postMessage(userId, randomId, message.substring(startIndex, endIndex))
        }

    }

    private fun postMessage(userId: Int, randomId: Int, message: String) {
        val uri = UriComponentsBuilder.fromHttpUrl("https://api.vk.com/method/messages.send")
            .queryParam("access_token", vkProperties.accessToken)
            .queryParam("v", vkProperties.v)
            .queryParam("user_id", userId)
            .queryParam("random_id", randomId)
            .queryParam("message", message)
            .build()
            .toUri()
        val restTemplate = RestTemplate()
        restTemplate.postForObject(uri, null, String::class.java)
    }

}