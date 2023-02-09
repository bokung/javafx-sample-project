package javafx.sample.project;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Custom reusable UI component! Works like a horizontal box component
 */
public class DialogBox extends HBox {
    private Label text;
    private ImageView pic;

    public DialogBox(Label text, ImageView pic) {
        this.text = text;
        this.pic = pic;

        pic.setFitWidth(100);
        pic.setFitHeight(100);
        this.setAlignment(Pos.TOP_RIGHT);
        this.getChildren().addAll(text, pic);
    }
    
    
}
