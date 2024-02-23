package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name="messages")
public class Message {

    public Message() {};
    public Message(String message, String authorMessage, String createdAt) {
        this.message = message;
        this.authorMessage = authorMessage;
        this.createdAt =  createdAt;
    }

    @Id
    @Column(name="id_message")
    private int idMessage;

    @Column(name="author_message")
    private String authorMessage;

    @Column(name="created_at")
    private String createdAt;

    private String message;

    public int getIdMessage() {
        return idMessage;
    }

    public String getAuthorMessage() {
        return authorMessage;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public void setAuthorMessage(String authorMessage) {
        this.authorMessage = authorMessage;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "Message{" +
                "idMessage=" + idMessage +
                ", authorMessage='" + authorMessage + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
