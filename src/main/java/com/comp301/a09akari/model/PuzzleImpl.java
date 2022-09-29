package com.comp301.a09akari.model;

public class PuzzleImpl implements Puzzle {
  private final int[][] board;
  // Each cell on the grid is one of three types: corridor, wall, or clue.
  // If a cell is a clue, then it is associated with a number between 0-4.
  // The number indicates the number of lamps that should be placed by the user adjacent to the cell
  // to solve the puzzle.
  public PuzzleImpl(int[][] board) {
    if (board == null) {
      throw new IllegalArgumentException("Null board");
    }
    this.board = board;
  }

  @Override
  public int getWidth() {
    return this.board[0].length;
  }

  @Override
  public int getHeight() {
    return this.board.length;
  }

  @Override
  public CellType getCellType(int r, int c) {
    /**
     * Getter method for the type of the cell located at row r, column c. Throws an IndexOutOfBounds
     * exception if r or c is out of bounds
     */
    if (r > getWidth() - 1 || c > getHeight() - 1 || r < 0 || c < 0) {
      // System.out.println(r + " " + c);
      throw new IndexOutOfBoundsException("Index out of bounds.");
    }
    if (board[r][c] == 0
        || board[r][c] == 1
        || board[r][c] == 2
        || board[r][c] == 3
        || board[r][c] == 4) {
      // System.out.println("Clue: " + board[r][c]);
      return CellType.CLUE;
    } else if (board[r][c] == 5) {
      // System.out.println("Wall: " + board[r][c]);
      return CellType.WALL;
    } else {
      // System.out.println("Corridor: " + board[r][c]);
      return CellType.CORRIDOR;
    }
  }

  @Override
  public int getClue(int r, int c) {
    /**
     * Getter method for the clue number of the cell located at row r, column c. Throws an
     * IndexOutOfBounds exception if r or c is out of bounds, or an IllegalArgumentException if the
     * cell is not type CLUE
     */
    if (r > getWidth() - 1 || c > getHeight() - 1 || r < 0 || c < 0) {
      throw new IndexOutOfBoundsException("Index out of bounds.");
    }
    if (!(getCellType(r, c) == CellType.CLUE)) {
      throw new IllegalArgumentException("Cell is not type CLUE");
    }
    if (board[r][c] == 0) {
      return 0;
    }
    if (board[r][c] == 1) {
      return 1;
    }
    if (board[r][c] == 2) {
      return 2;
    }
    if (board[r][c] == 3) {
      return 3;
    }
    if (board[r][c] == 4) {
      return 4;
    }
    return 0;
  }
}
