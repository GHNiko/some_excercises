package com.reddit.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String url;
    private LocalDateTime timestamp;
    private Long score;

    public Post() {
        this.score = 0L;
        this.timestamp = LocalDateTime.now();
    }

    public void decreaseScoreByOne() {
        this.score--;
    }

    public void increaseScoreByOne() {
        this.score++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}