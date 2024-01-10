package com.sofy.casestudy.capstone.kazhan.dto;
//For further development purposes
public class TextMessageDTO {

    private String content;
    private String sender;
    private String recipient;

    public TextMessageDTO() {
    }


    public TextMessageDTO(String content, String sender, String recipient) {
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
