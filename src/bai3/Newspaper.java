/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

/**
 *
 * @author Le Van Hieu CE160866
 */
public class Newspaper extends Document{
    private String date;

    public Newspaper(int id, String publisher, int numberRelease, String date) {
        super(id, publisher, numberRelease);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
