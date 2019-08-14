package com.lambdaschool.crudyrestaurants.model;

//2nd

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Annotations apply to the next line of code

@Entity //
@Table(name = "restaurant")
public class Restaurant
{
    @Id // primary key for the table
    @GeneratedValue(strategy = GenerationType.AUTO) // Every time a new restaurant is created this line of code will generate a new ID AUTOmatically
    private long restaurantid; // connects to @JoinColumn(name = "restaurantid"

    @Column(unique = true, //forces the name to be unique. If you try to add a restaurant with the same name it will give an err
            nullable = false) // Name has to have a value (Can't create a restaurant that doesn't have a value)
    private String name;
    // field name will be column name
    private String address;
    private String city;
    private String state;
    private String telephone;

    // @OneToMany tells that we can only have one restaurant but can have 0 or more menu items
    @OneToMany(mappedBy = "restaurant", // "restaurant" connects to restaurant field in Menu.java

               cascade = CascadeType.ALL, // cascade - is for whatever effects the restaurant affects the menu items.
                                          // Whenever CRUD is happening the menu items will also be affected.

               orphanRemoval = true) // in the background spring data is going to run and check to see do we have any menu items
                                    // that aren't associated with a restaurant and if they are if we have some it's going to delete them automatically

    // The following annotation will prevent the infinite loop when trying to perform a GET Request
    @JsonIgnoreProperties("restaurant")

    private List<Menu> menus = new ArrayList<>();

    public Restaurant() // Right click: Generate -> Constructor -> Default
    {
    }

    public Restaurant(String name, String address, String city, String state, String telephone) // Right click: Generate -> Constructor -> Select All except the (List<Menu> menus) getter and setter
                                                                                                // WHEN THERE IS A LIST YOU DO NOT PUT IT INSIDE OF CONSTRUCTOR
    {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.telephone = telephone;
    }

    public long getRestaurantid() // Right click: Generate -> Getter and Setter -> Select All
    {
        return restaurantid;
    }

    public void setRestaurantid(long restaurantid)
    {
        this.restaurantid = restaurantid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public List<Menu> getMenus()
    {
        return menus;
    }

    public void setMenus(List<Menu> menus) // WHEN THERE IS A LIST YOU DO NOT PUT IT INSIDE OF CONSTRUCTOR
    {
        this.menus = menus;
    }
}

// C creating - POST
// R reading - GET
// U updating - PUT
// D deleting - DELETE

// The basic 4 packages that will be in the app:

// model - database
// repos - connection between database and java
// services - java code to manipulate our database
// controllers - outside world interface (User Interface)

