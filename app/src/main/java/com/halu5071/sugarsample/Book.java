package com.halu5071.sugarsample;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by HALU on 2017/05/08.
 */

public class Book extends SugarRecord implements Serializable{

    String title;
    String content;
    int isbn;

    public Book(){
    }

    public Book(int isbn, String title, String content){
        this.title = title;
        this.content = content;
        this.isbn = isbn;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getContentBook() {
        return content;
    }

    public void setContentBook(String content) {
        this.content = content;
    }

    /*
    public static final class Builder{

        String title = "";

        public Builder addTitle(String title){
            this.title = title;
            return this;
        }

        public Book build(){
            return
        }
    }
    */
}
