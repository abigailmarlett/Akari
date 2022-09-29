package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ControllerImpl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlView implements FXComponent {
  private final ControllerImpl controller;

  public ControlView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox layout = new HBox();
    // layout.getStyleClass().add("controls-layout");
    layout.setAlignment(Pos.TOP_CENTER);
    // random button
    Button randomize = new Button("Random");
    randomize.setOnAction(
        (javafx.event.ActionEvent event) -> {
          controller.clickRandPuzzle();
        });
    layout.getChildren().add(randomize);

    // previous button
    Button previous = new Button("\u261C Previous");
    previous.setOnAction(
        (javafx.event.ActionEvent event) -> {
          controller.clickPrevPuzzle();
        });
    layout.getChildren().add(previous);

    // next button
    Button next = new Button("Next \u261E");
    next.setOnAction(
        (javafx.event.ActionEvent event) -> {
          controller.clickNextPuzzle();
        });
    layout.getChildren().add(next);

    // reset button
    Button reset = new Button("Reset \u21BA");
    reset.setOnAction(
        (javafx.event.ActionEvent event) -> {
          controller.clickResetPuzzle();
        });
    layout.getChildren().add(reset);
    layout.setSpacing(10.0);
    layout.setPadding(new Insets(20, 20, 20, 20));
    return layout;
  }
}
