package com.pm.LspRules.SignatureRule;

//1. Method Argument Rule
//• The overridden method in the subclass must accept the same argument types as the parent, or wider (a "broader" type up the inheritance chain).
//• Example: If the parent method takes a String, the child override must also take String (or a supertype, e.g., Object), never an unrelated type like Integer.

class Parent {
    public void print(String msg) {
        System.out.println("Parent: " + msg);
    }
}

class Child extends Parent {
    @Override
    public void print(String msg) {
        System.out.println("Child: " + msg);
    }
}


// Client that passes a String msg as the client expects.
class Client {
    private Parent p;

    public Client(Parent p) {
        this.p = p;
    }

    public void printMsg() {
        p.print("Hello");
    }
}

public class MethodArgumentRule {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent child  = new Child();

        Client client = new Client(parent);
        //Client client = new Client(child);

        client.printMsg();
    }
}
