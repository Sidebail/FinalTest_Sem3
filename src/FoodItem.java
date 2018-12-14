/**
 * Vladimir Vatsurin
 * 200363172
 */

import javafx.scene.image.Image;

public class FoodItem implements Comparable<FoodItem> {

    private String name;
    private int calories;
    private Image image;
    private double price;

    public FoodItem(String name, int calories, Image image, double price){
        setName(name);
        setCalories(calories);
        setImage(image);
        setPrice(price);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!name.equals("")&&name.length()<=30){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Name has to be less tha 30 chars and cant be blank");
        }

    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        if(calories >= 0 && calories <= 3000){
            this.calories = calories;
        }else {
            throw new IllegalArgumentException("Calories number has to be in range 0-3000");
        }

    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price >= 0 && price <= 50){
            this.price = price;
        }else {
            throw new IllegalArgumentException("Price has to be in range of 0-50");
        }


    }

    @Override
    public int compareTo(FoodItem o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return name + "    $" + String.format("%1$,.2f",price);
    }
}
