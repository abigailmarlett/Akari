package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ControllerImpl;
import com.comp301.a09akari.model.Puzzle;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TitleView implements FXComponent {
  private final ControllerImpl controller;

  public TitleView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    Puzzle puzzle = controller.getActivePuzzle();
    VBox title = new VBox();
    Text text = new Text("AKARI GAME");
    text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
    // Label akari = new Label(text);
    title.getChildren().add(text);
    title.setAlignment(Pos.TOP_CENTER);

    return title;
  }
}
