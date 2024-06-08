package ru.antunovichpyu.RepeatBot.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.antunovichpyu.RepeatBot.dto.RequestDto
import ru.antunovichpyu.RepeatBot.service.MessageService

@RestController
class Controller(val messageService: MessageService) {

    @PostMapping("/")
    fun handleRequest(@RequestBody requestDto: RequestDto): String =
        messageService.handleRequest(requestDto)

}