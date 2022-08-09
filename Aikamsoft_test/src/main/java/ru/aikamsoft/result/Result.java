package ru.aikamsoft.result;

public abstract class Result {
    protected String type;

    protected String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }
}
