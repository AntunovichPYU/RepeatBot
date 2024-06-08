package ru.antunovichpyu.RepeatBot

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import ru.antunovichpyu.RepeatBot.dto.MessageDto
import ru.antunovichpyu.RepeatBot.dto.RequestDto
import ru.antunovichpyu.RepeatBot.dto.RequestObjectDto
import ru.antunovichpyu.RepeatBot.service.MessageService
import kotlin.test.assertEquals

@SpringBootTest
@ContextConfiguration(classes = [TestConfiguration::class])
class ServiceTest {

    @Autowired
    lateinit var messageService: MessageService

    @Test
    fun confirmationTest() {
        val dto = RequestDto("confirmation")
        val result = messageService.handleRequest(dto)
        assertEquals("abcd", result)
    }

    @Test
    fun messageNewTest() {
        val dto = RequestDto("message_new", "1.199", RequestObjectDto(MessageDto(1234, "hello")))
        val result = messageService.handleRequest(dto)
        assertEquals("ok", result)
    }

    @Test
    fun invalidDtoTest() {
        val dto = RequestDto("")
        assertThrows<IllegalArgumentException> {
            messageService.handleRequest(dto)
        }
    }


}