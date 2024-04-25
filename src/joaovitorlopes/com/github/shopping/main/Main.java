package joaovitorlopes.com.github.shopping.main;

import joaovitorlopes.com.github.shopping.models.CreditCard;
import joaovitorlopes.com.github.shopping.models.Purchase;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reading = new Scanner(System.in);
        System.out.println("Enter a credit card limit: ");
        double limit = reading.nextDouble();
        CreditCard card = new CreditCard(limit);

        int exit = 1;
        while (exit != 0) {
            System.out.println("Enter a purchase description:");
            String description = reading.next();

            System.out.println("Enter a purchase value:");
            double value = reading.nextDouble();

            Purchase purchase = new Purchase(description, value);
            boolean purchaseMade = card.purchaseIssuance(purchase);

            if (purchaseMade) {
                System.out.println("Purchase made!");
                System.out.println("Enter 0 to exit or 1 to continue");
                exit = reading.nextInt();
            } else {
                System.out.println("Insufficient funds!");
                exit = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("PURCHASES MADE:\n");
        Collections.sort(card.getShopping());

        for (Purchase p : card.getShopping()) {
            System.out.println(p.getDescription() + " - " + p.getValue());
        }
        System.out.println("\n***********************");

        System.out.println("\nCard balance: " + card.getBalance());
    }
}
