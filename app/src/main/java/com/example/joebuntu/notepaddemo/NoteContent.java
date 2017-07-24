package com.example.joebuntu.notepaddemo;

/**
 * Created by joebuntu on 7/20/17.
 */

public class NoteContent {

    private String no;
    private String header;
    private String body;
    private String file_Name;

    public String getFile_Name() {
        return file_Name;
    }

    public void setFile_Name(String file_Name) {
        this.file_Name = file_Name;
    }

    public NoteContent() {
    }

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

    public NoteContent(String id, String header, String body, String fn) {

        this.header = header;
        this.body = body;
        this.no = id;
        this.file_Name = fn;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
