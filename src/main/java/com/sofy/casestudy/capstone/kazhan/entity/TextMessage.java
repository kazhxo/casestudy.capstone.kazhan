package com.sofy.casestudy.capstone.kazhan.entity;

//For further development purposes
public class TextMessage {

    private String content;
    private String sender;
    private String recipient;

    private MessageType type;
    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public TextMessage() {
    }

    public TextMessage(String content, String sender, String recipient, MessageType type) {
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
        this.type = type;
    }
    public TextMessage(String content, String sender, String recipient) {
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
