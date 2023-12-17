package com.service.spring.vo;

import lombok.Data;

@Data
public class Eat extends Care{
    private long eatSeq;

    public Eat() {}

    @Override
    public String toString() {
        return "Eat{" +
                "petSeq= " + getPetSeq() + " date= " + getDate() + " memo= " + getMemo() + " cnt= " + getCnt() + " nickname= " + getNickname() +
                '}';
    }
}
