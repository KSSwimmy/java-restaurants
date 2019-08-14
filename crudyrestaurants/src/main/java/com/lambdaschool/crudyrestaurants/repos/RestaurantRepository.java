package com.lambdaschool.crudyrestaurants.repos;

// repos - connection between database and java

        import com.lambdaschool.crudyrestaurants.model.Restaurant;
        import org.springframework.data.repository.CrudRepository;
                                                            //object 1    //object 2
public interface RestaurantRepository extends CrudRepository<Restaurant, Long>
{
    Restaurant findByName(String name);
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