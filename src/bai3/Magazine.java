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
public class Magazine extends Document{
    private int publishNum;
    private int publishMon;

    public Magazine(int id, String publisher, int numberRelease, int publishNum, int publishMon) {
        super(id, publisher, numberRelease);
        this.publishNum = publishNum;
        this.publishMon = publishMon;
    }

    public int getPublishNum() {
        return publishNum;
    }

    public void setPublishNum(int publishNum) {
        this.publishNum = publishNum;
    }

    public int getPublishMon() {
        return publishMon;
    }

    public void setPublishMon(int publishMon) {
        this.publishMon = publishMon;
    }

    @Override
    public String toString() {
        return "Magazine{" + "id=" + this.getId() + ", publisher=" + this.getPublisher() + ", numberRelease=" + this.getNumberRelease() + "publishNum=" + publishNum + ", publishMon=" + publishMon + '}';
    }
    
}
