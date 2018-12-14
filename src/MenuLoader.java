/**
 * Vladimir Vatsurin
 * 200363172
 */

import javafx.scene.image.Image;

import java.io.FileNotFoundException;
import java.util.TreeMap;
import java.util.TreeSet;

public class MenuLoader {
    public static TreeMap<String, TreeSet<FoodItem>> loadFoodItems() throws FileNotFoundException {
        TreeMap<String, TreeSet<FoodItem>> menu = new TreeMap<>();

        //FoodItem constructor should accept arguments in the order
        //food name, calories, Image object, price

        menu.put("beverages", new TreeSet<FoodItem>());
        menu.get("beverages").add(new FoodItem("Strawberry Shake",500,new Image("./images/Strawberry-McCafe-Shake-Medium.png"),3.45));
        menu.get("beverages").add(new FoodItem("Chocolate Shake",530,new Image("./images/Chocolate-McCafe-Shake-Medium.png"),3.45));
        menu.get("beverages").add(new FoodItem("Coca Cola",150,new Image("./images/t-mcdonalds-Coca-Cola-Classic-Small.png"),1.79));
        menu.get("beverages").add(new FoodItem("Sweet Iced Tea",90,new Image("./images/t-mcdonalds-Iced-Tea-Large.png"),2.59));

        menu.put("breakfast", new TreeSet<FoodItem>());
        menu.get("breakfast").add(new FoodItem("Hash Browns",150,new Image("./images/HASH-BROWNS.png"),1.69));
        menu.get("breakfast").add(new FoodItem("Mcmuffin Triplestack",780,new Image("./images/mcmuffin-triplestack.png"),3.89));
        menu.get("breakfast").add(new FoodItem("Fruit & Maple Oatmeal",310,new Image("./images/Fruit-Maple-Oatmeal.png"),4.79));
        menu.get("breakfast").add(new FoodItem("Egg McMuffin",300,new Image("./images/Egg-McMuffin.png"),3.99));

        menu.put("beef", new TreeSet<FoodItem>());
        menu.get("beef").add(new FoodItem("Big Mac",520,new Image("./images/Big-Mac.png"),3.99));
        menu.get("beef").add(new FoodItem("1/4 Pounder with Cheese",530,new Image("./images/Quarter-Pounder-with-Cheese.png"),3.79));

        menu.put("chicken", new TreeSet<FoodItem>());
        menu.get("chicken").add(new FoodItem("Artisan Grilled Chicken",510,new Image("./images/Artisan-Grilled-Chicken-Sandwich.png"),4.39));
        menu.get("chicken").add(new FoodItem("Buttermilk Crispy Chicken",520,new Image("./images/Buttermilk-Crispy-Chicken-Deluxe-Sandwich.png"),4.49));







        return menu;
    }
}