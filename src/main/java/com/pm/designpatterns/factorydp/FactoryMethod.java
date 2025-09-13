package com.pm.designpatterns.factorydp;

// Factory Method Design Pattern: defines an interface for creating objects but allows
//  subclass to decide which concrete class to instantiate.

// Product Interface and subclasses
interface BurgerFM {
    void prepare();
}

class BasicBurgerFM implements BurgerFM {
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

class StandardBurgerFM implements BurgerFM {
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumBurgerFM implements BurgerFM {
    public void prepare() {
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

class BasicWheatBurgerFM implements BurgerFM {
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger with bun, patty, and ketchup!");
    }
}

class StandardWheatBurgerFM implements BurgerFM {
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumWheatBurgerFM implements BurgerFM {
    public void prepare() {
        System.out.println("Preparing Premium Wheat Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

// Factory Interface and Concrete Factories
interface BurgerFactoryFM {
    BurgerFM createBurger(String type);
}

class SinghBurgerFM implements BurgerFactoryFM {
    public BurgerFM createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurgerFM();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurgerFM();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurgerFM();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}

class KingBurgerFM implements BurgerFactoryFM {
    public BurgerFM createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatBurgerFM();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardWheatBurgerFM();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumWheatBurgerFM();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}

// Main Class
public class FactoryMethod {
    public static void main(String[] args) {
        String type = "basic";

        BurgerFactoryFM myFactory = new SinghBurgerFM();
        BurgerFM burger = myFactory.createBurger(type);

        if (burger != null) {
            burger.prepare();
        }
    }
}