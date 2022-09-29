package com.comp301.a09akari.controller;

import com.comp301.a09akari.model.CellType;
import com.comp301.a09akari.model.Model;
import com.comp301.a09akari.model.Puzzle;

public class ControllerImpl implements AlternateMvcController {
  private final Model model;

  public ControllerImpl(Model model) {
    this.model = model;
  }

  @Override
  public void clickNextPuzzle() {
    /*System.out.println(model.getActivePuzzleIndex());
        int next = model.getActivePuzzleIndex() + 1;
        if (next == model.getPuzzleLibrarySize()){
          model.setActivePuzzleIndex(0);
        }
        model.setActivePuzzleIndex(next);
        model.resetPuzzle();
        System.out.println(getActivePuzzle().getHeight() + " " + getActivePuzzle().getWidth());
    */
    /*if (model.getActivePuzzleIndex() + 1 < model.getPuzzleLibrarySize()) {
      model.setActivePuzzleIndex(model.getActivePuzzleIndex() + 1);
    } else {
      model.setActivePuzzleIndex(0);
    }*/
    model.setActivePuzzleIndex((model.getActivePuzzleIndex() + 1) % model.getPuzzleLibrarySize());
  }

  @Override
  public void clickPrevPuzzle() {
    if (model.getActivePuzzleIndex() - 1 >= 0) {
      model.setActivePuzzleIndex(model.getActivePuzzleIndex() - 1);
    } else {
      model.setActivePuzzleIndex(model.getPuzzleLibrarySize() - 1);
    }
  }

  @Override
  public void clickRandPuzzle() {
    int index = model.getActivePuzzleIndex();
    while (index == model.getActivePuzzleIndex()) {
      index = (int) Math.floor(Math.random() * ((model.getPuzzleLibrarySize() - 1) + 1));
    }
    model.setActivePuzzleIndex(index);
  }

  @Override
  public void clickResetPuzzle() {
    model.resetPuzzle();
  }

  @Override
  public void clickCell(int r, int c) {
    if (model.getActivePuzzle().getCellType(r, c) == CellType.CORRIDOR) {
      if (model.isLamp(r, c)) {
        model.removeLamp(r, c);
      } else {
        model.addLamp(r, c);
      }
    }
  }

  @Override
  public boolean isLit(int r, int c) {
    return model.isLit(r, c);
  }

  @Override
  public boolean isLamp(int r, int c) {
    return model.isLamp(r, c);
  }

  @Override
  public boolean isClueSatisfied(int r, int c) {
    return model.isClueSatisfied(r, c);
  }

  @Override
  public boolean isSolved() {
    return model.isSolved();
  }

  @Override
  public Puzzle getActivePuzzle() {
    return model.getActivePuzzle();
  }

  public int getIndex() {
    return model.getActivePuzzleIndex();
  }

  public int getNumberOfPuzzles() {
    return model.getPuzzleLibrarySize();
  }

  public boolean getIsIllegal(int r, int c) {
    return model.isLampIllegal(r, c);
  }
}
