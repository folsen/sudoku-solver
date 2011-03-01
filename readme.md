Sudoku solver
=============  
The solver is written entirely in Java, tests with JUnit and GUI with AWT and Swing.

To run the application, compile
    javac -d bin/ src/sudoku/ClearButton.java src/sudoku/SolveButton.java src/sudoku/SudokuGUI.java src/sudoku/Main.java src/sudoku/Sudoku.java

assemble a jar (it is important to be in the bin directory)
    cd bin
    jar cfe SudokuSolver.jar sudoku.Main sudoku/

and run the jar
    java -jar SudokuSolver.jar

A precompiled .jar is included in the root directory.

License is GPLv3