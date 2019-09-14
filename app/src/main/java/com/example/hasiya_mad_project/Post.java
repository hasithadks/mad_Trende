package com.example.hasiya_mad_project;

import android.net.Uri;

public class Post {

    private String company;
    private String category;
    private String location;
    private String phoneno;
    private String title;
    private Double prrice;
    private String description;
    private String mImageUrl;
    private String image01Add;
    private String image02Add;
    private String image03Add;


    public Post() {

    }

                            //, String image01Add, String image02Add, String image03Add, String company
    public Post(String category, String location, String phoneno, String title, Double prrice, String description, String mImageUrl)  {
        this.category = category;
        this.location = location;
        this.phoneno = phoneno;
        this.title = title;
        this.prrice = prrice;
        this.description = description;
        this.mImageUrl = mImageUrl;
       // this.image01Add = image01Add;
      //  this.image02Add = image02Add;
       // this.image03Add = image03Add;
       // this.company = company;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrrice() {
        return prrice;
    }

    public void setPrrice(Double prrice) {
        this.prrice = prrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainImageAdd() {
        return mImageUrl;
    }

    public void setMainImageAdd(String mainImageAdd) {
        this.mImageUrl = mImageUrl;
    }

    public String getImage01Add() {
        return image01Add;
    }

    public void setImage01Add(String image01Add) {
        this.image01Add = image01Add;
    }

    public String getImage02Add() {
        return image02Add;
    }

    public void setImage02Add(String image02Add) {
        this.image02Add = image02Add;
    }

    public String getImage03Add() {
        return image03Add;
    }

    public void setImage03Add(String image03Add) {
        this.image03Add = image03Add;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }



}
