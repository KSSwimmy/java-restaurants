package com.lambdaschool.crudyrestaurants.repos;

// repos - connection between database and java

import com.lambdaschool.crudyrestaurants.model.Menu;
import org.springframework.data.repository.CrudRepository;
                                                      //o1   //o2
public interface MenuRepository extends CrudRepository<Menu, Long> // Long - is a class for ID
{
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