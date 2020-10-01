import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;


public class Main extends Application {
    String randomGenWord;

    String choiceSelected;
    String genWord;
//    int livesRemaining = 6;
    String userGuess;
    String hint = "hint to show";
    String word = "dashed word to show";
    Label dashWord = new Label(word);
    Label hintWord  = new Label(hint);
    TextField userInput = new TextField();

    @Override
    public void start(Stage stage) throws Exception {

        // Steps to Create JavaFx Scenes

        // 1. Create a layout ( Anchor Pane )
        // Must end with 'Page'
        // AnchorPane landingPage = new AnchorPane();

        // 2. Creating a Scene
        // Must end with 'Scene'
        //  landingScene = new Scene(parent);

        // 3. Add Elements in the Layout
        // landingScene.getChildren().add(logo);

        // 4. Setting up Styling
        // landingScene.getStylesheets().add("stylesheets/landingPage.css");

        // Adding a Style
        // test.getStyleClass().add("test");

        // 4. Setting up the Scene into the Stage
        // stage.setScene(landingScene);

        // Game Hierarchy
        // Landing Scene ->
        // Start Game ->

        // Not to be altered
        stage.setTitle("vGuess");
        stage.setWidth(700);
        stage.setHeight(500);

        /* START OF THE LANDING PAGE */

        // Parent layouts
        AnchorPane landingPage = new AnchorPane();
        AnchorPane gamePage = new AnchorPane();

        // Scenes
        Scene landingScene = new Scene(landingPage);
        landingScene.getStylesheets().add("stylesheets/landingPage.css");
        Scene gameScene = new Scene(gamePage);
        gameScene.getStylesheets().add("stylesheets/landingPage.css");

        // vGuess LOGO
        ImageView logo  = new ImageView("vguessLogo.png");
        logo.setX(140);
        logo.setY(40);
        landingPage.getChildren().add(logo);


        //  Language
        Label selectedLang = new Label("Selected Language : None");
        selectedLang.getStyleClass().add("selectedLang");
        landingPage.getChildren().add(selectedLang);
        selectedLang.setLayoutX(260);
        selectedLang.setLayoutY(180);

        // Menu Items
        MenuItem lang1 = new MenuItem("Java");
        MenuItem lang2 = new MenuItem("JavaScript");
        MenuItem lang3 = new MenuItem("React");
        MenuItem lang4 = new MenuItem("HTML");
        MenuItem lang5 = new MenuItem("CSS");
        MenuItem lang6 = new MenuItem("Python");

        MenuButton menu1 = new MenuButton("Select a Language",null,lang1,lang2,lang3,lang4,lang5,lang6);
        menu1.setLayoutX(280);
        menu1.setLayoutY(220);
        landingPage.getChildren().add(menu1);

        lang6.setOnAction(actionEvent -> {
            choiceSelected = lang6.getText();
//            System.out.println(choiceSelected);
            selectedLang.setText("Selected Language : "+lang6.getText());
        });

        Button startGameBtn = new Button("Start Game");
        startGameBtn.setLayoutX(280);
        startGameBtn.setLayoutY(270);
        startGameBtn.getStyleClass().add("startGameBtn");
        landingPage.getChildren().add(startGameBtn);

        /* GAME PAGE */
        dashWord.getStyleClass().add("dashWord");
        landingPage.getChildren().add(dashWord);
        dashWord.setLayoutX(260);
        dashWord.setLayoutY(180);
        dashWord.setLineSpacing(20);
        gamePage.getChildren().add(dashWord);

        hintWord.getStyleClass().add("hintWord");
        landingPage.getChildren().add(hintWord);
        hintWord.setLayoutX(260);
        hintWord.setLayoutY(230);
        gamePage.getChildren().add(userInput);
        gamePage.getChildren().add(hintWord);

        userInput.setLayoutX(260);
        userInput.setLayoutY(270);
        Pattern pattern = Pattern.compile("[a-zA-Z]*");
        UnaryOperator<TextFormatter.Change> filter = c -> {
            if (pattern.matcher(c.getControlNewText()).matches()) {
                return c ;
            } else {
                return null;
            }
        };
        TextFormatter<String> formatter = new TextFormatter<>(filter);
        userInput.setTextFormatter(formatter);

        Button submitLetterBtn = new Button("Check Letter");
        submitLetterBtn.setLayoutX(280);
        submitLetterBtn.setLayoutY(310);
        submitLetterBtn.getStyleClass().add("submitLetterBtn");
        gamePage.getChildren().add(submitLetterBtn);

        submitLetterBtn.setOnAction(actionEvent -> {
            System.out.println(userInput.getText());
            checkGuess(genWord);
        });

        startGameBtn.setOnAction(actionEvent ->{
           // Change Scene
            stage.setScene(gameScene);
            genWord = generateWord(choiceSelected);
        });



        // Set up the Scene
        stage.setScene(landingScene);

        /* END OF THE LANDING PAGE */

        stage.show();
    }

    public String generateWord(String choiceSelected) {
        System.out.println(choiceSelected);
        if (choiceSelected.equals("Python")){
            ArrayList<String> wordsList = new ArrayList<String>();
            wordsList.add("py");
            wordsList.add("lambda");
            wordsList.add("ArithmeticError");
            wordsList.add("remove");
            wordsList.add("capitalize");

            Random rand = new Random();
            int random = (int)(Math.random() * (wordsList.size()));
            randomGenWord = wordsList.get(random);

            Dictionary list = new Hashtable();
            list.put("py","What is the correct file extension for Python files?");
            list.put("lambda","what is used to create an anonymous function? ");
            list.put("ArithmeticError","Raised when an error occurs in numeric calculations.");
            list.put("remove","Removes the specified element of a set/list.");
            list.put("capitalize"," used to convert the first character to upper case.");
            genWord = randomGenWord;
            hint = (String) list.get(randomGenWord);
            System.out.println(randomGenWord);
            System.out.println("Hint: "+list.get(randomGenWord));

            dashWord.setText(genWord);
            hintWord.setText(hint);

        }
        return randomGenWord;
    }

    char[] filler ;
    int livesRemaining = 6;
    public void checkGuess(String s ) {
        filler =new char[s.length()];
        System.out.println(filler);
        System.out.println("String: "+s+ "Lives Remanining: "+livesRemaining);
        livesRemaining--;
        System.out.println("String: "+s+ "Lives Remanining: "+livesRemaining);
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("Init vGuess game");

    }
}

