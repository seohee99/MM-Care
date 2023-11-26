package com.service.spring.vo;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Pet {
    private long petSeq;
    private long groupSeq;
    private String petName;
    private Timestamp petBirthday;
    private char petGender;
    private String petImg;
    private char petNeutering;
    private String petDisease;
    private String petKind;
    private String petColor;
    private List<Weight> weights;
    private List<Care> cares;
    private List<Calendar> calendars;

    public Pet() {}
}
