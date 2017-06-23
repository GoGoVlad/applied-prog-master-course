package main;

import java.io.Serializable;

public final class Message implements Serializable {
    public int number;
    public Message(int number) {
        this.number = number;
    }
}
