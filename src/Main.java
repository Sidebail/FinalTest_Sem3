/**
 * Vladimir Vatsurin
 * 200363172
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        primaryStage.setTitle("Charlie's Menu");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {





        Thread r1 = new Thread() {
            @Override
            public void run() {
                do {
                    System.out.println("Ben stop gaming and get to Jaret's class " + System.currentTimeMillis());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }while (true);
            }
        };
        r1.start();
        launch(args);



    }
}
