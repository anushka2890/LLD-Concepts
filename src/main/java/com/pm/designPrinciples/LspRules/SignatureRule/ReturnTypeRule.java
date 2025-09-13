package com.pm.designPrinciples.LspRules.SignatureRule;

// Return Type Rule :
// Subtype overridden method return type should be either identical
// or narrower than the parent method's return type.
// This is also called return type covariance.
// Java supports this out of the box.

class Animal {
    // some common Animal methods
}

class Dog extends Animal {
    // Additional Dog methods specific to Dogs.
}

class ParentRT {
    public Animal getAnimal() {
        System.out.println("Parent : Returning Animal instance");
        return new Animal();
    }
}

class ChildRT extends ParentRT {
    @Override
    public Animal getAnimal() {
        System.out.println("Child : Returning Dog instance");
        return new Dog();
    }
}

class ClientRT {
    private ParentRT p;

    public ClientRT(ParentRT p) {
        this.p = p;
    }

    public void takeAnimal() {
        p.getAnimal();
    }
}

public class ReturnTypeRule {
    public static void main(String[] args) {
        ParentRT parent = new ParentRT();
        ChildRT child   = new ChildRT();

        ClientRT client = new ClientRT(child);
        //Client client = new Client(parent);
        client.takeAnimal();
    }
}
