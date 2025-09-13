package com.pm.zomatoClone;

import com.pm.zomatoClone.models.*;
import com.pm.zomatoClone.strategies.UpiPaymentStrategy;

public class ZomatoCloneAppMain {
    public static void main(String[] args) {
        // Simulating a happy flow
        // Create TomatoApp Object
        ZomatoCloneApp zomatoClone = new ZomatoCloneApp();

        // Simulate a user coming in (Happy Flow)
        User user = new User(101, "Aditya", "Delhi");
        System.out.println("User: " + user.getName() + " is active.");

        // User searches for restaurants by location
        java.util.List<Restaurant> restaurantList = zomatoClone.searchRestaurants("Delhi");

        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Found Restaurants:");
        for (Restaurant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getName());
        }

        // User selects a restaurant
        zomatoClone.selectRestaurant(user, restaurantList.get(0));
        System.out.println("Selected restaurant: " + restaurantList.get(0).getName());

        // User adds items to the cart
        zomatoClone.addToCart(user, "P1");
        zomatoClone.addToCart(user, "P2");

        zomatoClone.printUserCart(user);

        // User checkout the cart
        Order order = zomatoClone.checkoutNow(user, "Delivery", new UpiPaymentStrategy("1234567890"));

        // User pays for the cart. If payment is successful, notification is sent.
        zomatoClone.payForOrder(user, order);
    }
}
