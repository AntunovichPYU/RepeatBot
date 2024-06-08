package ru.antunovichpyu.RepeatBot.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class RequestDto(
    val type: String,
    val v: String = "",
    @JsonProperty(value = "object") val objects: RequestObjectDto =
        RequestObjectDto(MessageDto(0, ""))
)

data class RequestObjectDto(
    val message: MessageDto
)

data class MessageDto(
    @JsonProperty(value = "from_id") val fromId: Int,
    val text: String
)