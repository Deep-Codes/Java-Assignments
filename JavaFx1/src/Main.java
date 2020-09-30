import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("vGuess");
        stage.setWidth(700);
        stage.setHeight(500);

        // Parent layout
        AnchorPane parent = new AnchorPane();

        AnchorPane game = new AnchorPane();

        // Showing an Image
        ImageView img1  = new ImageView("vguessLogo.png");
        img1.setX(50);
        img1.setY(50);
        parent.getChildren().add(img1);




        // Creating a Label
        Label label1 = new Label("Selected Language : None");
        label1.setTextFill(Color.WHEAT);
        parent.getChildren().add(label1);

        // Menu Items
        MenuItem lang1 = new MenuItem("Java");
        MenuItem lang2 = new MenuItem("JavaScript");
        MenuItem lang3 = new MenuItem("React");
        MenuItem lang4 = new MenuItem("HTML");
        MenuItem lang5 = new MenuItem("CSS");
        MenuItem lang6 = new MenuItem("Python");

        lang1.setOnAction(actionEvent -> {
            System.out.println(lang1.getText());
            label1.setText("Selected : "+lang1.getText());
        });

        MenuButton menu1 = new MenuButton("Select a Language",null,lang1,lang2,lang3,lang4,lang5,lang6);
        parent.getChildren().add(menu1);



        // Creating a Scene
        Scene scene1 = new Scene(parent);
        scene1.getStylesheets().add("stylesheets/styles.css");

        // Setting up the Scene
        stage.setScene(scene1);

        ImageView img2  = new ImageView("vguessLogo.png");
        img2.setX(50);
        img2.setY(50);
        game.getChildren().add(img2);

        // Scene 2
        Scene start = new Scene(game);


        // Button
        Button btn1 = new Button("Click Me");
        btn1.setStyle(" -fx-font-size: 15px");
        btn1.setTranslateY(168);
        parent.getChildren().add(btn1);
        btn1.setOnAction(actionEvent ->{
            System.out.println("BUtton is CLikced");
            stage.setScene(start);
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("Hello World");

    }
}

