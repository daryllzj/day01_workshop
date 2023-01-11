package sdf;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList {

public static void main(String[] args) {
    System.out.println("Welcome to your shopping cart");

    Console cons = System.console();
    
    List <String> list = new ArrayList<>();

    boolean flag = true;

    while (flag) {
        String input = cons.readLine("> ").trim().toLowerCase();
        String[] command = input.split(" ");
        String newCommand = command[0];
        switch (newCommand) {
            case "exit" -> flag = false;
            case "list" -> listItems(list);
            case "add" -> addItems(list, input);
            case "delete" -> deleteItems(list, input);   
        }     
    }
 
}
        
public static List <String> listItems(List <String> list) {

    if (list.isEmpty()) {
        System.out.println("Cart is empty\n");
    } else {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s\n", i+1, list.get(i));
        }
    }

    return list;
}
        
public static List<String> addItems(List <String> list, String input) {
    String[] shoppingItems = input.split(" ");

    for (int i = 1; i < shoppingItems.length; i++) {
        if (list.contains(shoppingItems[i])) {
            System.out.printf("The cart already has %s\n", shoppingItems[i]);
        } else {
            list.add(shoppingItems[i]);
            System.out.printf("%s was added to cart\n", shoppingItems[i]);
        }
    }
    return list;
    
}

public static List<String> deleteItems(List <String> list, String input) {
    String[] delete = input.split(" ");
    int indexInt = Integer.parseInt(delete[1]);

    if (indexInt>list.size()) {
        System.out.println("Incorrect index\n");
    } else {
        System.out.printf("%s was deleted\n", list.get(indexInt-1));
        list.remove(list.get(indexInt-1));
    }
    
    return list;
    
}
}

   