package com.hmservicos.sqslistener.domain.model;

public record NotificationRequest(String from, String to, String content) {

    public NotificationMessage toDomain() {
        return new NotificationMessage(this.from, this.to, this.content);
    }
}

