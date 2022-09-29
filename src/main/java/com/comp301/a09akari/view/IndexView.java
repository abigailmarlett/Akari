package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ControllerImpl;
import com.comp301.a09akari.model.Puzzle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class IndexView implements FXComponent {
  private final ControllerImpl controller;

  public IndexView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    Puzzle puzzle = controller.getActivePuzzle();
    HBox layout = new HBox();
    layout.setAlignment(Pos.TOP_CENTER);
    // "puzzle"
    Text puzzleText = new Text("Puzzle: ");
    puzzleText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
    layout.getChildren().add(puzzleText);
    puzzleText.setFill(Color.GOLD);

    // which puzzle?
    int index = controller.getIndex();
    String indexS = Integer.toString(index + 1);
    Text indexText = new Text(indexS);
    indexText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
    layout.getChildren().add(indexText);
    indexText.setFill(Color.GOLD);

    // "of"
    Text ofText = new Text(" of ");
    ofText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
    layout.getChildren().add(ofText);
    ofText.setFill(Color.GOLD);

    // how many puzzles?
    int numPuzzles = controller.getNumberOfPuzzles();
    String numPuzzlesS = Integer.toString(numPuzzles);
    Text totalNum = new Text(numPuzzlesS);
    totalNum.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
    layout.getChildren().add(totalNum);
    totalNum.setFill(Color.GOLD);
    layout.setPadding(new Insets(10, 10, 10, 10));

    return layout;
  }
}
