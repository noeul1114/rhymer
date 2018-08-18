package com.biggerThanGreater.willy.rhymer;

/**
 * Created by willy on 2017-07-30.
 */

public class Word {

    String result;
    String popular;
    String mark;
    String property;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPopular() {
        return popular;
    }

    public void setPopular(String popular) { this.popular = popular;  }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Word(String result, String popular, String mark, String property) {
        this.result = result;
        this.popular = popular;
        this.mark = mark;
        this.property = property;
    }
}
