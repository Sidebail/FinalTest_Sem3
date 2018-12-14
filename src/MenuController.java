/**
 * Vladimir Vatsurin
 * 200363172
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class MenuController implements Initializable {

    Menu menu;

        @FXML
        private ComboBox<String> cbCategories;

        @FXML
        private ListView<FoodItem> lvMenu;

        @FXML
        private ListView<FoodItem> lvCart;

        @FXML
        private Label lTotalCals;

        @FXML
        private Label lTotalCost;

        @FXML
        private Label lCalories;

        @FXML
        private Label lCost;

        @FXML
        private ImageView image;

        @FXML
        private Button bAddToOrder;

    /**
     * Listener for AddToOrder button. Handles the management of labels and uses addToCartView method to add an item to a cart
     * @param event
     */
    @FXML
        void onAddToOrderClick(ActionEvent event) {
            if(!lvMenu.getSelectionModel().isEmpty()){
                totalCals = totalCals + lvMenu.getSelectionModel().getSelectedItem().getCalories();
                totalCost = totalCost + lvMenu.getSelectionModel().getSelectedItem().getPrice();



                cart.add(lvMenu.getSelectionModel().getSelectedItem());

                addToCartView(lvMenu.getSelectionModel().getSelectedItem());

                lTotalCost.setText(" $" + String.format("%1$,.2f",cart.stream().mapToDouble(lb -> lb.getPrice()).sum()));
                lTotalCals.setText(""+cart.stream().mapToDouble(lb -> lb.getCalories()).sum());
            }

        }

    /**
     * ComboBox category change listener
     * @param event
     */
    @FXML
    void onCategoryChosen (ActionEvent event) {
        updateView(menu.getMenuItems(cbCategories.getValue()));
    }

    /**
     * ListView click listener, handles labels and image
     * @param event
     */
    @FXML
    void onListViewClick(MouseEvent event) {
        if(!lvMenu.getSelectionModel().isEmpty()){
            lCalories.setText(" " + lvMenu.getSelectionModel().getSelectedItem().getCalories());
            //lCalories.setText(" " + menu.get().get(chosenCategory).stream().mapToDouble(lb -> lb.getPrice() * lb.getNumInStock()).sum());
            lCost.setText(" $" + lvMenu.getSelectionModel().getSelectedItem().getPrice());

            image.setImage(lvMenu.getSelectionModel().getSelectedItem().getImage());

        }

    }



    private ArrayList<FoodItem> cart;
    private double totalCals;
    private double totalCost;

    /**
     * Initialize method for MenuController. Sets all variables
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            lCost.setText("0");
            lCalories.setText("0");
            lTotalCals.setText("0");
            lTotalCost.setText("0");
            menu = new Menu();
            cart = new ArrayList<>();

            try {
                menu.setMenu(MenuLoader.loadFoodItems());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            cbCategories.getItems().addAll(menu.getCategories());

    }

    /**
     * Custom method to update the listView
     * @param ts
     */
    public void updateView(TreeSet<FoodItem> ts){
        image.setImage(null);
        lCost.setText("0");
        lCalories.setText("0");
        lvMenu.getItems().clear();


            for (FoodItem item:ts){
                lvMenu.getItems().add(item);
            }


    }

    /**
     * Custom method to update the cart list view
     * @param foodItem
     */
    public void addToCartView(FoodItem foodItem){
        lvCart.getItems().add(foodItem);
    }


}
