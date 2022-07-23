# [JLogo](https://github.com/LucaBianchi28/JLogo)

A Java project that implements the Logo Language.
(University Project)

## About
This Java project implements interpeter for a Logo Language.
Basically, the goal is to take in input a new Logo Program (so a sequence of instructions) then return the result.

Both **input** and **output** are files that needs to be specified.

## Program
A simple program is for example:
SETPENCOLOR 255 127 0
SETFILLCOLOR 255 127 0
HOME
PENUP
RIGHT 180
FORWARD 50
RIGHT 90
FORWARD 80
LEFT 270
PENDOWN
RIPETI 36 [RIPETI 90 [FORWARD 5 RIGHT 4] RIGHT 10]

## Execution
To execute the given program we need respectively:

 1. The input file (where is stored the program)
 2. The output file (where will be written the resulting drawn shapes)
 3. The width (of the drawing that will be used)
 4. The height (of the drawing that will be used)

So for example, to execute the program by **console** a possible execution is:

    $ ./gradlew :console:run --args="../../inputFile.txt ../../outputFile.logo 1000 1000"

This will execute the program stored in the file `inputFile.txt`, prints the output in file `outputFile.logo`, with dimensions: *1000x1000*.

## Modules

About the modules:
 - `API`: This module has everything releated to the backend, so the interpreter itself. It manages all the logic behind the application.
 - `Console`: This module represents the execution by console.
 - `GUI`: This module represents the Graphical User Interface to execute the program, but **it still doesn't work properly**.
