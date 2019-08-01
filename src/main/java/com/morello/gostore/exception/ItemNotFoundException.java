package com.morello.gostore.exception;

public class ItemNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Item not found";
    }
}
