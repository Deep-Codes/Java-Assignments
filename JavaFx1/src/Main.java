import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
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
    Button startGameBtn = new Button("Start Game");
    int livesRemaining = 6;
    Boolean isGameOver = false;
    int levelCounter = 1;
    int scoreCounter = 0;
    int questionCounter = 1;
    Label levelLabel = new Label("Level: "+levelCounter);
    Label scoreLabel = new Label("Score: "+scoreCounter);
    Label gameOverScoreLabel = new Label();
    ImageView sprite ;






    @Override
    public void start(Stage stage) throws Exception {
        /*
            TO DO Error List!!!!!
            Error in states after first game
            Mystery of Home Button in About Page
            Mystery of Home Button in Game Page
            Set fixed Width & Height
         */

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
        stage.setHeight(550);

        /* START OF THE LANDING PAGE */

        // Parent layouts
        VBox landingPage = new VBox();
        landingPage.setAlignment(Pos.CENTER);
        landingPage.setSpacing(20);
        landingPage.getStyleClass().add("landingPage");

        VBox gamePage = new VBox();
        gamePage.setAlignment(Pos.CENTER);
        gamePage.setSpacing(20);
        gamePage.getStyleClass().add("gamePage");

        // Game Over Page
        VBox gameOverPage = new VBox();
        gameOverPage.setAlignment(Pos.CENTER);
        gameOverPage.setSpacing(20);
        gameOverPage.getStyleClass().add("gameOverPage");

        // Help Page
        VBox helpPage = new VBox();
        helpPage.setAlignment(Pos.CENTER);
        helpPage.setSpacing(20);
        helpPage.getStyleClass().add("helpPage");

        Button helpButton = new Button("Help");
        helpButton.getStyleClass().add("helpButton");
        startGameBtn.getStyleClass().add("startGameBtn");
        startGameBtn.setDisable(true);

        Button aboutButton = new Button("About");
        aboutButton.getStyleClass().add("helpButton");

        HBox helpAndAbout = new HBox(helpButton,aboutButton);
        helpAndAbout.setSpacing(20);
        helpAndAbout.setAlignment(Pos.BASELINE_CENTER);

        HBox scoreAndLevel = new HBox(scoreLabel,levelLabel);
        scoreAndLevel.setSpacing(20);
        scoreAndLevel.setAlignment(Pos.BASELINE_CENTER);

        Button homeButton = new Button("Home");
        homeButton.getStyleClass().add("homeButton");

        Button secondHomeButton = new Button("Home");
        secondHomeButton.getStyleClass().add("homeButton");

        // About Page
        VBox aboutPage  = new VBox();
        aboutPage.setAlignment(Pos.CENTER);
        aboutPage.setSpacing(20);
        aboutPage.getChildren().add(secondHomeButton);
        aboutPage.getStyleClass().add("aboutPage");

        ImageView aboutHead = new ImageView("about.png");
        aboutPage.getChildren().add(aboutHead);
        aboutHead.getStyleClass().add("aboutHead");

        Label aboutMade = new Label("Project Completed with Java,JavaFx and CSS");
        aboutPage.getChildren().add(aboutMade);
        aboutMade.getStyleClass().add("aboutMade");

        Label aboutLabel = new Label(
                "1) 19101A0004 Mohit Santosh \n\n" +
                        "2) 19101A0028 Aman Singh \n\n" +
                        "3) 19101A0029 Kaartik Nayak \n\n" +
                        "4) 19101A0033 Deepankar Bhade\n");
        aboutLabel.getStyleClass().add("aboutLabel");
        aboutPage.getChildren().add(aboutLabel);

        Label aboutVersion = new Label("VGUESS v1.0.0");
        aboutPage.getChildren().add(aboutVersion);
        aboutVersion.getStyleClass().add("aboutVersion");


        // Scenes
        Scene landingScene = new Scene(landingPage);
        landingScene.getStylesheets().add("stylesheets/landingPage.css");
        Scene gameScene = new Scene(gamePage);
        gameScene.getStylesheets().add("stylesheets/landingPage.css");
        Scene gameOverScene = new Scene(gameOverPage);
        gameOverScene.getStylesheets().add("stylesheets/landingPage.css");
        Scene helpScene = new Scene(helpPage);
        helpScene.getStylesheets().add("stylesheets/landingPage.css");

        Scene aboutScene = new Scene(aboutPage);
        aboutScene.getStylesheets().add("stylesheets/landingPage.css");


        // vGuess LOGO
        ImageView logo  = new ImageView("logo1.png");
        landingPage.getChildren().add(logo);
        //Game Over Logo
        ImageView gameOverImage = new ImageView("gameOver.png");
        gameOverPage.getChildren().add(gameOverImage);
        gameOverPage.getChildren().add(gameOverScoreLabel);
        gameOverScoreLabel.getStyleClass().add("gameOverScoreLabel");
        gameOverPage.getChildren().add(secondHomeButton);

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
            startGameBtn.setDisable(false);
            startGameBtn.getStyleClass().add("clickedStartGameBtn");
            choiceSelected = lang1.getText();
            System.out.println(choiceSelected);
            selectedLang.setText("Selected Language : "+lang1.getText());
        });
        lang2.setOnAction(actionEvent -> {
            startGameBtn.setDisable(false);
            startGameBtn.getStyleClass().add("clickedStartGameBtn");
            choiceSelected = lang2.getText();
            System.out.println(choiceSelected);
            selectedLang.setText("Selected Language : "+lang2.getText());
        });
        lang3.setOnAction(actionEvent -> {
            startGameBtn.setDisable(false);
            startGameBtn.getStyleClass().add("clickedStartGameBtn");
            choiceSelected = lang3.getText();
            System.out.println(choiceSelected);
            selectedLang.setText("Selected Language : "+lang3.getText());
        });
        lang4.setOnAction(actionEvent -> {
            startGameBtn.setDisable(false);
            startGameBtn.getStyleClass().add("clickedStartGameBtn");
            choiceSelected = lang4.getText();
            System.out.println(choiceSelected);
            selectedLang.setText("Selected Language : "+lang4.getText());
        });
        lang5.setOnAction(actionEvent -> {
            startGameBtn.setDisable(false);
            startGameBtn.getStyleClass().add("clickedStartGameBtn");
            choiceSelected = lang5.getText();
            System.out.println(choiceSelected);
            selectedLang.setText("Selected Language : "+lang5.getText());
        });

        landingPage.getChildren().add(startGameBtn);

        landingPage.getChildren().add(helpAndAbout);

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
            helpLabel.getStyleClass().add("helpLabel");
        });

        homeButton.setOnAction(actionEvent -> {
            stage.setScene(landingScene);
        });
        secondHomeButton.setOnAction(actionEvent -> {
            stage.setScene(landingScene);
        });

        aboutButton.setOnAction(actionEvent -> {
            stage.setScene(aboutScene);
        });

        /* GAME PAGE */

//      SPRITE
        sprite = new ImageView("sp6.png");
        sprite.setFitWidth(120);
        sprite.setPreserveRatio(true);
        gamePage.getChildren().add(sprite);

        dashWord.getStyleClass().add("dashWord");
        landingPage.getChildren().add(dashWord);

        dashWord.setLineSpacing(20);
        gamePage.getChildren().add(dashWord);

        levelLabel.getStyleClass().add("levelLabel");
//        gamePage.getChildren().add(levelLabel);

        scoreLabel.getStyleClass().add("scoreLabel");
//        gamePage.getChildren().add(scoreLabel);

        gamePage.getChildren().add(scoreAndLevel);

        lifeLabel.getStyleClass().add("lifeLabel");
        gamePage.getChildren().add(lifeLabel);

        hintWord.getStyleClass().add("hintWord");
        landingPage.getChildren().add(hintWord);
        gamePage.getChildren().add(userInput);
        gamePage.getChildren().add(hintWord);

        userInput.setMaxWidth(160);
        userInput.setPromptText("Enter a Guess!");

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
        gamePage.getChildren().add(homeButton);
        submitLetterBtn.setOnAction(actionEvent -> {
            if(!userInput.getText().trim().isEmpty()) {
                System.out.println(userInput.getText());
                checkGuess(genWord, userInput.getText());
                userInput.clear();
                if(isGameOver)
                {
                    System.out.println("Game Over");

                    if(scoreCounter < 9){
                        gameOverScoreLabel.setText("You Lose:  \n Your Score : "+scoreCounter);
                    } else if(scoreCounter == 9) {
                        gameOverScoreLabel.setText("Congratulations!!: \n Your Score : "+scoreCounter);
                    }


                    stage.setScene(gameOverScene);
                }
            }
            else
            {
                userInput.setPromptText("Enter a Guess!");
                System.out.println("No Input");
            }

        });
        userInput.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER){
                System.out.println("Enter works");
                System.out.println(userInput.getText());
                checkGuess(genWord,userInput.getText());
                userInput.clear();
                if(isGameOver)
                {
                    System.out.println("Game Over");
                    if(scoreCounter < 9){
                        gameOverScoreLabel.setText("You Lose  Your Score : "+scoreCounter);
                    } else if(scoreCounter == 9) {
                        gameOverScoreLabel.setText("Congratulations!! Your Score : "+scoreCounter);
                    }
                    stage.setScene(gameOverScene);
                }
            }
        });

        startGameBtn.setOnAction(actionEvent ->{
            // Init Score Counter
            scoreCounter = 0;
            // Init Level Label
            levelCounter = 1;
            levelLabel.setText("Level: "+levelCounter);
            // Init Dashed Boolean to Create new star string string
            if ( initDashed == 0){
                initDashed = 1;
            }
            // Init the Sprite to Sp6;
            Image sp6 = new Image("sp6.png");
            sprite.setImage(sp6);
            // Init the Lives 6;
            livesRemaining = 6;
            lifeLabel.setText("Life Remaining: "+livesRemaining);
            // Init gameOver
            isGameOver = false;
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
        switch (choiceSelected) {
            case "Python": {
                ArrayList<String> wordsList = new ArrayList<String>();
                wordsList.add("py");
                wordsList.add("lambda");
                wordsList.add("ArithmeticError");
                wordsList.add("remove");
                wordsList.add("capitalize");
                wordsList.add("yield");
                wordsList.add("from");
                wordsList.add("elif");
                wordsList.add("NameError");
                wordsList.add("numpy");
                wordsList.add("finally");

                Random rand = new Random();
                int random = (int) (Math.random() * (wordsList.size()));
                randomGenWord = wordsList.get(random);

                Dictionary list = new Hashtable();
                list.put("py", "What is the correct file extension for Python files?");
                list.put("lambda", "what is used to create an anonymous function? ");
                list.put("ArithmeticError", "Raised when an error occurs in numeric calculations.");
                list.put("remove", "Removes the specified element of a set/list.");
                list.put("capitalize", " used to convert the first character to upper case.");
                list.put("finally","the block of code is always executed no matter if the try block raises an error or not.");
                list.put("numpy", "library for the adding support for large, multi-dimensional arrays and matrices");
                list.put("NameError", "Raised when a variable does not exist");
                list.put("yield", "Used to end a function and returns a generator");
                list.put("from", "Used To import specific parts of a module");
                list.put("elif", "Used in conditional statements");

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
                wordsList.add("addEventListener");
                wordsList.add("setinterval");
                wordsList.add("settimeout");
                wordsList.add("alert");
                wordsList.add("angular");
                wordsList.add("instanceof");
                wordsList.add("innerHTML");
                wordsList.add("appendChild");
                wordsList.add("object");
                wordsList.add("ajax");

                Random rand = new Random();
                int random = (int) (Math.random() * (wordsList.size()));
                randomGenWord = wordsList.get(random);

                Dictionary list = new Hashtable();
                list.put("promise", "object represents the eventual completion  of an asynchronous operation");
                list.put("react", "Most Popular Javascript Framework");
                list.put("parseint", "parses a string and returns an integer");
                list.put("tostring", "method returns the string representation of the object");
                list.put("addEventListener", "method attaches an event handler to the document.");
                list.put("setinterval", "method calls a function or evaluates an expression at specified intervals ");
                list.put("settimeout", "method calls a function after a specified number of milliseconds");
                list.put("alert", "method displays an alert box with a specified message");
                list.put("appendChild", "Appends a node as the last child of a node.");
                list.put("innerHTML", "used to access the inner script of a html element");
                list.put("instanceof", "checks whether an object is an instance of a specific class or an interface.");
                list.put("angular", "Popular JavaScript Framework");
                list.put("ajax","set of web development techniques to create asynchronous web applications.");
                list.put("object", "abbreviations of O in JSON");

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
                wordsList.add("final");
                wordsList.add("throws");
                wordsList.add("synchronized");
                wordsList.add("static");
                wordsList.add("extends");
                wordsList.add("enum");

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
                list.put("final", "Indicates that a variable holds a constant value");
                list.put("throws", "Indicates what exceptions may be thrown by a method");
                list.put("synchronized", "Specifies critical sections or methods in multithreaded code");
                list.put("static", "Indicates that a variable or method is a class method ");
                list.put("extends", "Indicates that a class is derived from another class or interface");
                list.put("enum", "A Java keyword used to declare an enumerated type.");


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
            if ( levelCounter == 1){
                if(livesRemaining == 5){
                    Image sp5 = new Image("sp5.png");
                    sprite.setImage(sp5);
                }
                if(livesRemaining == 4){
                    Image sp4 = new Image("sp4.png");
                    sprite.setImage(sp4);
                }
                if(livesRemaining == 3){
                    Image sp3 = new Image("sp3.png");
                    sprite.setImage(sp3);
                }
                if(livesRemaining == 2){
                    Image sp2 = new Image("sp2.png");
                    sprite.setImage(sp2);
                }
                if(livesRemaining == 1){
                    Image sp1 = new Image("sp1.png");
                    sprite.setImage(sp1);
                }
            } else if (levelCounter == 2){
                if(livesRemaining == 4){
                    Image sp6 = new Image("sp6.png");
                    sprite.setImage(sp6);
                }
                if(livesRemaining == 3){
                    Image sp4 = new Image("sp4.png");
                    sprite.setImage(sp4);
                }
                if(livesRemaining == 2){
                    Image sp2 = new Image("sp2.png");
                    sprite.setImage(sp2);
                }
                if(livesRemaining == 1){
                    Image sp1 = new Image("sp1.png");
                    sprite.setImage(sp1);
                }
            } else if (levelCounter == 3){
                if(livesRemaining == 2){
                    Image sp6 = new Image("sp6.png");
                    sprite.setImage(sp6);
                }
                if(livesRemaining == 1){
                    Image sp2 = new Image("sp2.png");
                    sprite.setImage(sp2);
                }
            }

            lifeLabel.setText("Lives Remaining: "+livesRemaining);
            System.out.println("Lives Remaining: "+livesRemaining);
            if(livesRemaining==0)
            {
                System.out.println("You Lose");
                isGameOver = true;
            }
        } else {
            asterisk = newasterisk;
        }
        if (asterisk.equals(realWord)) {
            System.out.println("Correct! You win! The word was " + realWord);
            scoreCounter++;
            scoreLabel.setText("Score: " +scoreCounter);
            questionCounter++;
            if(questionCounter == 2)
            {
                livesRemaining = 6;
                lifeLabel.setText("Life Remaining: "+livesRemaining);
                levelLabel.setText("Level: "+levelCounter);
            }
            if(questionCounter == 3)
            {
                livesRemaining = 6;
                lifeLabel.setText("Life Remaining: "+livesRemaining);
                levelLabel.setText("Level: "+levelCounter);
            }
            if(questionCounter == 4) {
                levelCounter++;
                questionCounter = 1;
            }
            initDashed++;
            if ( levelCounter == 2){
                livesRemaining = 4;
                lifeLabel.setText("Life Remaining: "+livesRemaining);
                levelLabel.setText("Level: "+levelCounter);
            } else if (levelCounter == 3) {
                livesRemaining = 2;
                lifeLabel.setText("Life Remaining: "+livesRemaining);
                levelLabel.setText("Level: "+levelCounter);
            } else if (levelCounter == 4){
                isGameOver = true;
            }
            genWord = generateWord(choiceSelected);
            System.out.println("Level: " +levelCounter+"started");
        }
        System.out.println(asterisk);
        dashWord.setText(asterisk.replace("", "  ").trim());

    }
//    MediaPlayer mediaPlayer;
//    public void music()
//    {
//        String path = "backgroundMusic.mp3";
//        Media media = new Media(new File(path).toURI().toString());
//        mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.play();
//    }

    public static void main(String[] args) {
        System.out.println("Init vGuess game");
        launch(args);
        System.out.println("Closing vGuess game");
    }
}