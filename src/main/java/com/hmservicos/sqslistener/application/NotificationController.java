package com.hmservicos.sqslistener.application;

import com.hmservicos.sqslistener.domain.service.NotificationService;
import com.hmservicos.sqslistener.domain.model.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationService service;

    @PostMapping("/topic")
    public void topic(@RequestBody NotificationRequest request) {
        log.info("sending message toward SNS... {}");
        service.notifyTopic(request.toDomain());
        log.info("Message sent {}");
    }

    @PostMapping("/queue")
    public void queue(@RequestBody NotificationRequest request) {
        log.info("sending message toward SQS...");
        service.notifyQueue(request.toDomain());
        log.info("Message sent");
    }
}