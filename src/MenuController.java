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
        private ListView<String> lvMenu;

        @FXML
        private ListView<String> lvCart;

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

        @FXML
        void onAddToOrderClick(ActionEvent event) {
            if(!lvMenu.getSelectionModel().isEmpty()){
                lCalories.setText(" " + menuHelper.get(lvMenu.getSelectionModel().getSelectedIndex()).getCalories());
                lCost.setText(" $" + menuHelper.get(lvMenu.getSelectionModel().getSelectedIndex()).getPrice());

                image.setImage(menuHelper.get(lvMenu.getSelectionModel().getSelectedIndex()).getImage());



            }
        }

    @FXML
    void onCategoryChosen (ActionEvent event) {
        updateView(menu.getMenuItems(cbCategories.getValue()));
    }

    @FXML
    void onListViewClick(MouseEvent event) {
        if(!lvMenu.getSelectionModel().isEmpty()){
            lCalories.setText(" " + menuHelper.get(lvMenu.getSelectionModel().getSelectedIndex()).getCalories());
            lCost.setText(" $" + menuHelper.get(lvMenu.getSelectionModel().getSelectedIndex()).getPrice());

            image.setImage(menuHelper.get(lvMenu.getSelectionModel().getSelectedIndex()).getImage());

        }

    }


    ArrayList<FoodItem> menuHelper;
    ArrayList<FoodItem> cart;
    double totalCals;
    double totalCost;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            lCost.setText("0");
            lCalories.setText("0");
            lTotalCals.setText("0");
            lTotalCost.setText("0");
            menu = new Menu();
            cart = new ArrayList<>();
            menuHelper = new ArrayList<>();
            try {
                menu.setMenu(MenuLoader.loadFoodItems());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            cbCategories.getItems().addAll(menu.getCategories());

    }

    public void updateView(TreeSet<FoodItem> ts){
            lvMenu.getItems().clear();

            for (FoodItem item:ts){
                lvMenu.getItems().add(item.toString());
            }

        for (FoodItem item:ts){
            menuHelper.add(item);
        }

    }


}
