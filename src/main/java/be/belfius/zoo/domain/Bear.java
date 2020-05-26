package be.belfius.zoo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

//    private  FoodType foodType  = FoodType.FISH;

    //make use of the builder pattern in Animal class
    public Bear() {
    }



//    public FoodType getFoodType() {
//        return foodType;
//    }
//
//    public void setFoodType(FoodType foodType) {
//        this.foodType = foodType;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
