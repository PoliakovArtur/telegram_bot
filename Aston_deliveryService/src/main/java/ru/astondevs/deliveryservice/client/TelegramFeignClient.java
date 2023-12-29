package ru.astondevs.deliveryservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.astondevs.deliveryservice.dto.message.MessageDto;

@FeignClient(value = "telegramClient", url = "http://localhost:8080/user/")
public interface TelegramFeignClient {

    @PostMapping("/{chat_id}")
    void sendMessageToTgChatCourier(@PathVariable("chat_id") Long id, @RequestBody MessageDto messageDto);

    @PostMapping("/{chat_id}")
    void sendMessageToTgChatClient(@PathVariable("chat_id") Long id, @RequestBody MessageDto messageDto);
}
