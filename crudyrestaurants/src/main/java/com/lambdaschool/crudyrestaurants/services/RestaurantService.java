package com.lambdaschool.crudyrestaurants.services;

//1st

//// services - java code to manipulate our database

import com.lambdaschool.crudyrestaurants.model.Restaurant;

// a service pair is created for each model

import java.util.List;

public interface RestaurantService
{
    List<Restaurant> findAll();

    Restaurant findRestaurantById(long id);

    Restaurant findRestaurantByName(String name);

    void delete(long id);

    Restaurant save(Restaurant restaurant);

    Restaurant update(Restaurant restaurant, long id);
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