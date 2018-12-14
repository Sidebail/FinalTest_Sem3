/**
 * Vladimir Vatsurin
 * 200363172
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class Menu {
    private TreeMap<String, TreeSet<FoodItem>> menu;


    public Menu(){

        menu = new TreeMap<>();
    }

    public void setMenu(TreeMap<String, TreeSet<FoodItem>> tm){

        menu = tm;

    }

    public ArrayList<String> getCategories(){
        ArrayList<String> al = new ArrayList<>();
        al.add("All Categories");
        for (String category:menu.keySet()){
           al.add(category);
        }
        return al;
    }

    public TreeSet<FoodItem> getMenuItems(String key){
        if(key.equals("All Categories")){
            TreeSet<FoodItem> menuTemp = new TreeSet<>();
            for (TreeSet<FoodItem> itemList:menu.values()){
                for (FoodItem item:itemList) {
                    menuTemp.add(item);
                }
            }
            return menuTemp;
        }else {
            TreeSet<FoodItem> menuTemp = new TreeSet<>();
            for (FoodItem item:menu.get(key)){
                    menuTemp.add(item);
            }
            return menuTemp;
        }

    }
}
