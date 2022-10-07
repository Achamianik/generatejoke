package com.generate;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class Joke {
    private final String uuid;
    private String value;
    private String category;

    private Joke() {
        this.uuid = UUID.randomUUID().toString();
    }

    public Joke(String value, String category) {
        this.value = value;
        this.category = category;
        this.uuid = UUID.randomUUID().toString();
    }

    protected Joke(String value, String category, String uuid) {
        this.value = value;
        this.category = category;
        this.uuid = uuid;
    }

    public static Joke generateRandomJoke(int i) {
        if (i % 2 == 0) {
            return new Joke(i + ") Q: Where does a sick fish go? A: The dock. ", "daddy's joke");
        }
        return new Joke(i + ") Where are average things manufactured? The satisfactory.", "modern");
    }
}
