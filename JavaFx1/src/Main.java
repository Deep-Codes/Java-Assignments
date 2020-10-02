import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
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
    String asterisk;
    String choiceSelected;
    String genWord;
    int initDashed = 1;
    String hint = "hint to show";
    String word = "dashed word to show";
    Label dashWord = new Label(word);
    Label hintWord  = new Label(hint);
    Label lifeLabel = new Label("Lives Remaining: 6");
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
        VBox landingPage = new VBox();
        landingPage.setAlignment(Pos.CENTER);
        landingPage.setSpacing(20);

        VBox gamePage = new VBox();
        gamePage.setAlignment(Pos.CENTER);
        gamePage.setSpacing(20);

        // Game Over Page
        VBox gameOverPage = new VBox();
        gameOverPage.setAlignment(Pos.CENTER);
        gameOverPage.setSpacing(20);


        // Help Page
        VBox helpPage = new VBox();
        helpPage.setAlignment(Pos.CENTER);
        helpPage.setSpacing(20);

        Button helpButton = new Button("Help");
        helpButton.getStyleClass().add("helpButton");

        Button homeButton = new Button("Home");
        homeButton.getStyleClass().add("homeButton");

        // Credits Page

        // Scenes
        Scene landingScene = new Scene(landingPage);
        landingScene.getStylesheets().add("stylesheets/landingPage.css");
        Scene gameScene = new Scene(gamePage);
        gameScene.getStylesheets().add("stylesheets/landingPage.css");
        Scene gameOverScene = new Scene(gameOverPage);
        Scene helpScene = new Scene(helpPage);
        helpScene.getStylesheets().add("stylesheets/landingPage.css");


        // vGuess LOGO
        ImageView logo  = new ImageView("vguessLogo.png");
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
        MenuItem lang3 = new MenuItem("Python");
        MenuItem lang4 = new MenuItem("HTML");
        MenuItem lang5 = new MenuItem("CSS");

        MenuButton menu1 = new MenuButton("Select a Language",null,lang1,lang2,lang3,lang4,lang5);
        landingPage.getChildren().add(menu1);

        lang1.setOnAction(actionEvent -> {
            choiceSelected = lang1.getText();
            System.out.println(choiceSelected);
            selectedLang.setText("Selected Language : "+lang1.getText());
        });
        lang2.setOnAction(actionEvent -> {
            choiceSelected = lang2.getText();
            System.out.println(choiceSelected);
            selectedLang.setText("Selected Language : "+lang2.getText());
        });
        lang2.setOnAction(actionEvent -> {
            choiceSelected = lang2.getText();
            System.out.println(choiceSelected);
            selectedLang.setText("Selected Language : "+lang2.getText());
        });
        lang3.setOnAction(actionEvent -> {
            choiceSelected = lang3.getText();
            System.out.println(choiceSelected);
            selectedLang.setText("Selected Language : "+lang3.getText());
        });
        lang4.setOnAction(actionEvent -> {
            choiceSelected = lang4.getText();
            System.out.println(choiceSelected);
            selectedLang.setText("Selected Language : "+lang4.getText());
        });
        lang5.setOnAction(actionEvent -> {
            choiceSelected = lang5.getText();
            System.out.println(choiceSelected);
            selectedLang.setText("Selected Language : "+lang5.getText());
        });

        Button startGameBtn = new Button("Start Game");
        startGameBtn.getStyleClass().add("startGameBtn");
        landingPage.getChildren().add(startGameBtn);

        landingPage.getChildren().add(helpButton);

        helpButton.setOnAction(actionEvent -> {
                    //Change Scene
                    stage.setScene(helpScene);
                    //Help Page
                    Label helpLabel = new Label("Welcome to Vguess!!!!\n\n" +
                            "This Application is designed to help you learn your programming syntax\n\n\n" +
                            "Here are the Rules\n" +
                            "1). Chose the language you want to learn.\n\n" +
                            "2). You will be given a random word related to the Language.\n\n" +
                            "3). The Hint to the word will also be given.\n\n" +
                            "4). You will have to guess the words before you run out of lives.\n" +
                            "\n" +
                            "Have Fun!!");
                    helpPage.getChildren().add(homeButton);
                    helpPage.getChildren().add(helpLabel);
                    helpLabel.getStyleClass().add("helpPage");
                });

        homeButton.setOnAction(actionEvent -> {
            stage.setScene(landingScene);
        });

        /* GAME PAGE */
        dashWord.getStyleClass().add("dashWord");
        landingPage.getChildren().add(dashWord);

        dashWord.setLineSpacing(20);
        gamePage.getChildren().add(dashWord);

        lifeLabel.setLayoutX(260);
        lifeLabel.setLayoutY(350);
        lifeLabel.getStyleClass().add("lifeLabel");
        gamePage.getChildren().add(lifeLabel);

        hintWord.getStyleClass().add("hintWord");
        landingPage.getChildren().add(hintWord);
        hintWord.setLayoutX(260);
        hintWord.setLayoutY(230);
        gamePage.getChildren().add(userInput);
        gamePage.getChildren().add(hintWord);

        userInput.setLayoutX(260);
        userInput.setLayoutY(270);
        userInput.setMaxWidth(160);

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
            checkGuess(genWord,userInput.getText());
        });

        startGameBtn.setOnAction(actionEvent ->{
           // Change Scene
            stage.setScene(gameScene);
            genWord = generateWord(choiceSelected);
        });

        ImageView winningGif  = new ImageView("vguessLogo.png");
        gameOverPage.getChildren().add(winningGif);

        // Set up the Scene
        stage.setScene(landingScene);

        /* END OF THE LANDING PAGE */

        stage.show();
    }

    public String generateWord(String choiceSelected) {
        System.out.println(choiceSelected);
        switch (choiceSelected) {
            case "Python": {
                ArrayList<String> wordsList = new ArrayList<String>();
                wordsList.add("py");
                wordsList.add("lambda");
                wordsList.add("ArithmeticError");
                wordsList.add("remove");
                wordsList.add("capitalize");

                Random rand = new Random();
                int random = (int) (Math.random() * (wordsList.size()));
                randomGenWord = wordsList.get(random);

                Dictionary list = new Hashtable();
                list.put("py", "What is the correct file extension for Python files?");
                list.put("lambda", "what is used to create an anonymous function? ");
                list.put("ArithmeticError", "Raised when an error occurs in numeric calculations.");
                list.put("remove", "Removes the specified element of a set/list.");
                list.put("capitalize", " used to convert the first character to upper case.");
                genWord = randomGenWord;
                hint = (String) list.get(randomGenWord);
                System.out.println(randomGenWord);
                System.out.println("Hint: " + list.get(randomGenWord));

                if (initDashed == 1) {
                    initDashed--;
                    System.out.println("I run only once");
                    asterisk = new String(new char[genWord.length()]).replace("\0", "*");
                    dashWord.setText(asterisk.replace("", "  ").trim());
                }

                hintWord.setText(hint);
                break;
            }
            case "JavaScript": {
                ArrayList<String> wordsList = new ArrayList<String>();
                wordsList.add("promise");
                wordsList.add("this");
                wordsList.add("react");
                wordsList.add("parseint");
                wordsList.add("tostring");
                wordsList.add("addeventlistener");
                wordsList.add("setinterval");
                wordsList.add("settimeout");
                wordsList.add("getComputedStyle");
                wordsList.add("alert");

                Random rand = new Random();
                int random = (int) (Math.random() * (wordsList.size()));
                randomGenWord = wordsList.get(random);

                Dictionary list = new Hashtable();
                list.put("promise", "object represents the eventual completion  of an asynchronous operation");
                list.put("react", "Most Popular Javascript Framework");
                list.put("parseint", "parses a string and returns an integer");
                list.put("tostring", "method returns the string representation of the object");
                list.put("addeventlistener", "method attaches an event handler to the document.");
                list.put("setinterval", "method calls a function or evaluates an expression at specified intervals ");
                list.put("settimeout", "method calls a function after a specified number of milliseconds");
                list.put("getComputedStyle", "method gets all the actual CSS property");
                list.put("alert", "method displays an alert box with a specified message");
                genWord = randomGenWord;
                hint = (String) list.get(randomGenWord);
                System.out.println(randomGenWord);
                System.out.println("Hint: " + list.get(randomGenWord));

                if (initDashed == 1) {
                    initDashed--;
                    System.out.println("I run only once");
                    asterisk = new String(new char[genWord.length()]).replace("\0", "*");
                    dashWord.setText(asterisk.replace("", "  ").trim());
                }

                hintWord.setText(hint);
                break;
            }
            case "Java": {
                ArrayList<String> wordsList = new ArrayList<String>();
                wordsList.add("scanner");
                wordsList.add("arraylist");
                wordsList.add("length");
                wordsList.add("decimalformat");
                wordsList.add("stringbuilder");
                wordsList.add("stage");
                wordsList.add("wrapper");
                wordsList.add("interface");
                wordsList.add("getComputedStyle");
                wordsList.add("alert");

                Random rand = new Random();
                int random = (int) (Math.random() * (wordsList.size()));
                randomGenWord = wordsList.get(random);

                Dictionary list = new Hashtable();
                list.put("scanner", "Class for taking user input");
                list.put("arraylist", "Datatype for creating list");
                list.put("length", "method to find the length of a string");
                list.put("decimalformat", "limiting decimal counts");
                list.put("stringbuilder", "A mutable sequence of characters.");
                list.put("stage", "Used to Create a JavaFx Window");
                list.put("wrapper", "class contains primitive data types");
                list.put("interface", "way to achieve abstraction in Java");
                list.put("final", "used in several contexts to define an entity that can only be assigned once");
                genWord = randomGenWord;
                hint = (String) list.get(randomGenWord);
                System.out.println(randomGenWord);
                System.out.println("Hint: " + list.get(randomGenWord));

                if (initDashed == 1) {
                    initDashed--;
                    System.out.println("I run only once");
                    asterisk = new String(new char[genWord.length()]).replace("\0", "*");
                    dashWord.setText(asterisk.replace("", "  ").trim());
                }

                hintWord.setText(hint);
                break;
            }
            case "CSS": {
                ArrayList<String> wordsList = new ArrayList<String>();
                wordsList.add("style");
                wordsList.add("color");
                wordsList.add("positioned");
                wordsList.add("transition");
                wordsList.add("linear");
                wordsList.add("keyframes");

                Random rand = new Random();
                int random = (int) (Math.random() * (wordsList.size()));
                randomGenWord = wordsList.get(random);

                Dictionary list = new Hashtable();
                list.put("style", "HTML tag is used to define an internal style sheet");
                list.put("color", "CSS property is used to change the text color of an element");
                list.put("positioned", "one of the 4 layout modes before flex-box");
                list.put("transition", "limiting decimal counts");
                list.put("linear", "transition effect with same speed start-end");
                list.put("keyframes", "KeyWord Css Animation");
                genWord = randomGenWord;
                hint = (String) list.get(randomGenWord);
                System.out.println(randomGenWord);
                System.out.println("Hint: " + list.get(randomGenWord));

                if (initDashed == 1) {
                    initDashed--;
                    System.out.println("I run only once");
                    asterisk = new String(new char[genWord.length()]).replace("\0", "*");
                    dashWord.setText(asterisk.replace("", "  ").trim());
                }

                hintWord.setText(hint);
                break;
            }
            case "HTML": {
                ArrayList<String> wordsList = new ArrayList<String>();
                wordsList.add("image");
                wordsList.add("anchor");
                wordsList.add("div");

                Random rand = new Random();
                int random = (int) (Math.random() * (wordsList.size()));
                randomGenWord = wordsList.get(random);

                Dictionary list = new Hashtable();
                list.put("image", "add images and gifs");
                list.put("anchor", "links and all stuff");
                list.put("div", "box");
                genWord = randomGenWord;
                hint = (String) list.get(randomGenWord);
                System.out.println(randomGenWord);
                System.out.println("Hint: " + list.get(randomGenWord));

                if (initDashed == 1) {
                    initDashed--;
                    System.out.println("I run only once");
                    asterisk = new String(new char[genWord.length()]).replace("\0", "*");
                    dashWord.setText(asterisk.replace("", "  ").trim());
                }

                hintWord.setText(hint);
                break;
            }
        }
        return randomGenWord;
    }

    int livesRemaining = 6;
    public void checkGuess(String realWord , String userGuess ) {
        String newasterisk = "";
        for (int i = 0; i < realWord.length(); i++) {
            if (realWord.charAt(i) == userGuess.charAt(0)) {
                newasterisk += userGuess.charAt(0);
            } else if (asterisk.charAt(i) != '*') {
                newasterisk += realWord.charAt(i);
            } else {
                newasterisk += "*";
            }
        }
        if (asterisk.equals(newasterisk)) {
            livesRemaining--;
            lifeLabel.setText("Lives Remaining: "+livesRemaining);
            System.out.println("Lives Remaining: "+livesRemaining);
        } else {
            asterisk = newasterisk;
        }
        if (asterisk.equals(realWord)) {
            System.out.println("Correct! You win! The word was " + realWord);
        }
        System.out.println(asterisk);
        dashWord.setText(asterisk.replace("", "  ").trim());
    }

    public static void main(String[] args) {
        System.out.println("Init vGuess game");
        launch(args);
        System.out.println("Closing vGuess game");
    }
}

