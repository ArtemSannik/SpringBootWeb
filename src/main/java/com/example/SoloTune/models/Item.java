package com.example.SoloTune.models;


import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title,info,image;

    private int price;

    public Item() {
    }

    public Item(String title, String info, String image, int price) {
        this.title = title;
        this.info = info;
        this.image = image;
        this.price = price;
    }
}
