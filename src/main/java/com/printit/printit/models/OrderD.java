package com.printit.printit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class OrderD {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, description, imageurl, color, material, parameters, stlFile, phoneNumber;

    public OrderD() {
    }

    public OrderD(String title, String description, String imageurl, String color, String material, String parameters, String stlFile, String phoneNumber) {
        this.title = title;
        this.description = description;
        this.imageurl = imageurl;
        this.color = color;
        this.material = material;
        this.parameters = parameters;
        this.stlFile = stlFile;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getStlFile() {
        return stlFile;
    }

    public void setStlFile(String stlFile) {
        this.stlFile = stlFile;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, imageurl, color, material, parameters, stlFile, phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", parameters='" + parameters + '\'' +
                ", stlFile='" + stlFile + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

