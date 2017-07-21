package com.example.joebuntu.notepaddemo;

/**
 * Created by joebuntu on 7/20/17.
 */

public class NoteContent {
    private String header;
    private String body;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public NoteContent(String header, String body) {

        this.header = header;
        this.body = body;
    }
}
