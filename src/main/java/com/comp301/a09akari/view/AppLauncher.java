package com.comp301.a09akari.view;

import com.comp301.a09akari.SamplePuzzles;
import com.comp301.a09akari.controller.ControllerImpl;
import com.comp301.a09akari.model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLauncher extends Application {
  @Override
  public void start(Stage stage) {
    // TODO: Create your Model, View, and Controller instances and launch your GUI
    // Inside the start() method, you should create a Model instance and a Controller instance.
    // To instantiate ModelImpl, you need to pass a PuzzleLibrary object to the constructor.
    // Use the puzzle data provided in the SamplePuzzles class and the provided PuzzleLibraryImpl
    // class to construct
    // and populate a suitable PuzzleLibrary which can be passed to the model. Add all puzzles from
    // SamplePuzzles to
    // the PuzzleLibrary. In addition, you may choose to encode and include more puzzles if you want
    // to support a larger
    // puzzle library.
    PuzzleLibrary library = new PuzzleLibraryImpl();
    Puzzle puzzle1 = new PuzzleImpl(SamplePuzzles.PUZZLE_01);
    Puzzle puzzle2 = new PuzzleImpl(SamplePuzzles.PUZZLE_02);
    Puzzle puzzle3 = new PuzzleImpl(SamplePuzzles.PUZZLE_03);
    Puzzle puzzle4 = new PuzzleImpl(SamplePuzzles.PUZZLE_04);
    library.addPuzzle(puzzle1);
    library.addPuzzle(puzzle2);
    library.addPuzzle(puzzle3);
    library.addPuzzle(puzzle4);

    // model instance
    Model model = new ModelImpl(library);

    // controller instance
    ControllerImpl controller = new ControllerImpl(model);

    // view
    View view = new View(controller);

    // scene
    Scene scene = new Scene(view.render(), 700, 700);
    stage.setScene(scene);
    scene.getStylesheets().add("main.css");

    // updating the screen
    model.addObserver(
        (Model m) -> {
          scene.setRoot(view.render());
          stage.sizeToScene();
        });
    // show
    stage.setTitle("Akari");
    stage.show();
  }
}
