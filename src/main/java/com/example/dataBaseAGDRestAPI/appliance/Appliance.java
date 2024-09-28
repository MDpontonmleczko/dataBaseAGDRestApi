package com.example.dataBaseAGDRestAPI.appliance;

import jakarta.persistence.*;

@Entity
@Table(name = "appliances")
public class Appliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item")
    private String item;

    @Column(name = "description")
    private String description;

    @Column(name = "item_value")
    private double item_value;

    public Appliance(String item, String description, double item_value){
        this.description = description;
        this.item = item;
        this.item_value = item_value;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getItem(){
        return item;
    }

    public void setItem(String item){
        this.item = item;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public double getItem_value(){
        return item_value;
    }

    public void setItem_value(double item_value){
        this.item_value = item_value;
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", description='" + description + '\'' +
                ", item_value=" + item_value +
                '}';
    }
}
