package ru.antunovichpyu.RepeatBot.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "vk.properties")
data class VkProperties(
    val accessToken: String,
    val confirmationToken: String,
    val v: String,
)
