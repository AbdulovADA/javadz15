package ru.netology.domain;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String msg) {
        super(msg);
    }
}