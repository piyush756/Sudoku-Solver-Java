# Sudoku Solver 🧩

A command-line Sudoku solver written in Java using **recursion and backtracking**. Enter your puzzle row by row and the program solves it instantly.

---

## How it works

The solver uses a classic **backtracking algorithm**:

1. Scan the board cell by cell (left to right, top to bottom)
2. When an empty cell (`.`) is found, try placing digits `1–9`
3. Before placing, check if the digit is safe — no conflict in the same row, column, or 3×3 grid
4. If safe, place the digit and move to the next cell recursively
5. If no digit works, **backtrack** — reset the cell to `.` and try the next digit in the previous cell
6. Repeat until the board is completely filled

---

## Features

- Interactive command-line input — enter your own puzzle
- Validates each row input (must be exactly 9 characters)
- Displays the puzzle before and after solving
- Nicely formatted board output with grid borders
- Handles unsolvable puzzles gracefully

---

## Getting started

### Prerequisites

- Java JDK 8 or above

### Run it

```bash
# Compile
javac Sudoku.java

# Run
java Sudoku
```

---

## Usage

Enter each row of the puzzle one at a time. Use digits `1–9` for known cells and `.` for empty cells — **no spaces**.

```
SUDOKU PUZZLE
enter digit 1-9 for the known cells and '.' for empty space

row 1 : 53..7....
row 2 : 6..195...
row 3 : .98....6.
row 4 : 8...6...3
row 5 : 4..8.3..1
row 6 : 7...2...6
row 7 : .6....28.
row 8 : ...419..5
row 9 : ....8..79
```

### Output

```
Your Puzzle :
+-------+-------+-------+
| 5 3 . | . 7 . | . . . |
| 6 . . | 1 9 5 | . . . |
| . 9 8 | . . . | . 6 . |
+-------+-------+-------+
| 8 . . | . 6 . | . . 3 |
| 4 . . | 8 . 3 | . . 1 |
| 7 . . | . 2 . | . . 6 |
+-------+-------+-------+
| . 6 . | . . . | 2 8 . |
| . . . | 4 1 9 | . . 5 |
| . . . | . 8 . | . 7 9 |
+-------+-------+-------+

sudoku solved :
+-------+-------+-------+
| 5 3 4 | 6 7 8 | 9 1 2 |
| 6 7 2 | 1 9 5 | 3 4 8 |
| 1 9 8 | 3 4 2 | 5 6 7 |
+-------+-------+-------+
| 8 5 9 | 7 6 1 | 4 2 3 |
| 4 2 6 | 8 5 3 | 7 9 1 |
| 7 1 3 | 9 2 4 | 8 5 6 |
+-------+-------+-------+
| 9 6 1 | 5 3 7 | 2 8 4 |
| 2 8 7 | 4 1 9 | 6 3 5 |
| 3 4 5 | 2 8 6 | 1 7 9 |
+-------+-------+-------+
```

---

## Code structure

```
Sudoku.java
│
├── isSafe()       → checks row, column, and 3×3 grid for conflicts
├── helper()       → recursive backtracking engine
├── SudokuSolver() → entry point for the solver
├── PrintBoard()   → formats and prints the board with grid borders
└── main()         → handles user input and drives the program
```

---

## Concepts used

- Recursion
- Backtracking
- 2D character arrays
- ASCII arithmetic (`ch - '0'` and `ch + '0'`)
- Java Scanner for input

---

## Example test puzzle

```
53..7....
6..195...
.98....6.
8...6...3
4..8.3..1
7...2...6
.6....28.
...419..5
....8..79
```

---

## Author

Made by a first-year CSE/AIML student 
