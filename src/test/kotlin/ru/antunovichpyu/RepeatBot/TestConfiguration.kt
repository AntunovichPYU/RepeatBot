package ru.antunovichpyu.RepeatBot

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.antunovichpyu.RepeatBot.configuration.VkProperties
import ru.antunovichpyu.RepeatBot.service.MessageService

@Configuration
class TestConfiguration {

    @Bean
    fun vkProperties(): VkProperties =
        VkProperties("", "abcd", "")

    @Bean
    fun messageService(vkProperties: VkProperties): MessageService =
        MessageService(vkProperties)

}