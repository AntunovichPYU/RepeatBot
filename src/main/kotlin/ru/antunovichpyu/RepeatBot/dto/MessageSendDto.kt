package ru.antunovichpyu.RepeatBot.dto

data class MessageSendDto(
    val userId: Int,
    val randomId: Int,
    val message: String
)