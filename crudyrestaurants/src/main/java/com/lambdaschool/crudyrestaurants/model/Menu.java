package com.lambdaschool.crudyrestaurants.model;

//1st
// For each model you have there is a corresponding repo file in repo


import javax.persistence.*;

@Entity //Menu is an Entity
@Table(name = "menu")
public class Menu
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //You do not put a semicolon after an annotation
    private long menuid;



    @Column(nullable = false)
    private String dish;
    private double price;

    @ManyToOne //
    @JoinColumn(name = "restaurantid", // connects to the private long restaurantid; in Restaurant.java
                nullable = false)

    // The following annotation will prevent the infinite loop that is called when you send a GET Request
    @JsonIgnoreProperties("menu")


    private Restaurant restaurant; // the field that connects

    public Menu()
    {
    }

    public Menu(String dish, double price, Restaurant restaurant)
    {
        this.dish = dish;
        this.price = price;
        this.restaurant = restaurant;
    }

    public long getMenuid()
    {
        return menuid;
    }

    public void setMenuid(long menuid)
    {
        this.menuid = menuid;
    }

    public String getDish()
    {
        return dish;
    }

    public void setDish(String dish)
    {
        this.dish = dish;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Restaurant getRestaurant()
    {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant)
    {
        this.restaurant = restaurant;
    }
}
