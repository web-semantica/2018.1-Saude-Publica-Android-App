package com.web.saude.model;

public class Medic {

    public int profileImage;
    public String name;
    public String crm;


    public Medic(String name, int profileImage, String crm) {
        this.name = name;
        this.profileImage = profileImage;
        this.crm = crm;
    }
}
