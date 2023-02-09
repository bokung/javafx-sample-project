package javafx.sample.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Custom reusable UI component! Works like a horizontal box component
 */
public class DialogBox extends HBox {
    private Label text;
    private ImageView picView;

    private DialogBox(Label text, ImageView picView) {
        this.text = text;
        this.picView = picView;

        picView.setFitWidth(100);
        picView.setFitHeight(100);
        this.setAlignment(Pos.TOP_RIGHT);
        this.getChildren().addAll(text, picView);
    }

    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> temp = FXCollections.observableArrayList(this.getChildren()); // why must we use this weird thing?
        FXCollections.reverse(temp);
        this.getChildren().setAll(temp); // Clears original children and add new collection of children
    }

    /**
     * User on the right
     * 
     * @param text
     * @param picView
     * @return
     */
    public static DialogBox getUserDialogBox(Label text, ImageView picView) {
        return new DialogBox(text, picView);
    }
    
    /**
     * Duke on the left, reverse all elements then return a dialog box
     * 
     * @param text
     * @param picView
     * @return
     */
    public static DialogBox getDukeDialogBox(Label text, ImageView picView) {
        DialogBox db = new DialogBox(text, picView);
        db.flip();
        return db;
    }
}
