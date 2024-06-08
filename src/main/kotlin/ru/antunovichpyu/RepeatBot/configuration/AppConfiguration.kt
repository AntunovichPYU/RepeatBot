package ru.antunovichpyu.RepeatBot.configuration

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(VkProperties::class)
class AppConfiguration
