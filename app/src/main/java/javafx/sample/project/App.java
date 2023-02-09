/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javafx.sample.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private Image userPic = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image dukePic = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScrollPane scrollPane = new ScrollPane(); // ScrollPane is a Node (prop)
        VBox dialogBox = new VBox(); // Vertical Box is another Node 
        TextField input = new TextField(); // text box
        Button button = new Button("Sex"); // button defaults to (0,0) position (top left)
        AnchorPane anchorPane = new AnchorPane(); // This is the Scene!
        Scene scene = new Scene(anchorPane); // set root as root node of scene

        anchorPane.getChildren().addAll(scrollPane, input, button); // add nodes as children to scene (We have a tree!)
        configurePrimaryStage(primaryStage); // configuring this makes launch window 600x600
        configureAnchorPane(anchorPane, scrollPane, button, input);
        configureScrollPane(scrollPane, dialogBox);
        configureButton(button, dialogBox, input);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void configureButton(Button button, VBox dialogBox, TextField input) {
        EventHandler<Event> f = e -> {
            handleUserInput(input, dialogBox);
        };

        EventHandler<ActionEvent> g = e -> {
            handleUserInput(input, dialogBox);
        };

        button.setOnMouseClicked(f);

        // This method does not accept EventHandler<Event>, where SECS?
        button.setOnAction(g);
    }

    private void handleUserInput(TextField input, VBox dialogBox) {
        String inputString = input.getText();
        Label userText = new Label(inputString);
        DialogBox userBox = new DialogBox(userText, new ImageView(userPic));
        Label dukeText = new Label(getResponse(inputString));
        DialogBox dukeBox = new DialogBox(dukeText, new ImageView(dukePic));

        dialogBox.getChildren().addAll(userBox, dukeBox);
        input.clear();
    }

    private String getResponse(String input) {
        return "Sex sex " + input;
    }

    private void configurePrimaryStage(Stage primaryStage) {
        primaryStage.setTitle("Sex");
        primaryStage.setMinHeight(600); // in pixels probably? Documentation not clear?
        primaryStage.setMinWidth(600); // square
    }

    /**
     * Configures the root node
     */
    private void configureAnchorPane(AnchorPane root, ScrollPane scrollPane, Button button, TextField input) {
        root.setPrefSize(400, 600);

        // Static methods because a stage can have only 1 scene (AnchorPane is a scene, not a node!)
        AnchorPane.setTopAnchor(scrollPane, 0.0); // put scroll box on top

        // combination of both is putting button in bottom right!
        AnchorPane.setBottomAnchor(button, 0.0); // put button at the bottom
        AnchorPane.setRightAnchor(button, 0.0); // put buttom on the right

        // combination of both is putting in bottom left!
        AnchorPane.setBottomAnchor(input, 0.0); // put input box in bottom
        AnchorPane.setLeftAnchor(input, 0.0); // put input box in left
    }

    private void configureScrollPane(ScrollPane scrollPane, VBox box) {
        scrollPane.setContent(box); // set vertical box as content of scroll box
        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);
    }
}
