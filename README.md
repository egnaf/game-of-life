# Conway's Game of Life
Version: 0.1<br>

[![License](https://img.shields.io/badge/license-MIT-brightgreen.svg)](https://en.wikipedia.org/wiki/MIT_License)
[![JDK](https://img.shields.io/badge/JDK-%3E%3D%201.8-d36e6e.svg?style=flat-circle)](https://docs.oracle.com/javase/8/docs/)
<br>

1. [Task](#task)
2. [How to run?](#how-to-run)
3. [Algorithm](#algorithm)
4. [Demo](#demo)
<br>

## Task
Create the [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life) application with the [stdlib](https://introcs.cs.princeton.edu/java/stdlib/) library.
<br>
<br>

## How to run?
Compile using:
```
javac -sourcepath src -classpath lib/stdlib-package.jar -d out src/mamadaliev/Run.java
```

Run using:
```
java -classpath out:lib/stdlib-package.jar mamadaliev.Run
```
<br>

## Algorithm
<b>Life:</b>
neighbors = 3 OR neighbors = 2 and life cell

<b>Dead:</b>
neighbors = (-ထ; 2) ∪ (2; 3) ∪ (3; +ထ) OR neighbors = 2 AND dead cell
<br>

## Demo
<img src="https://i.ibb.co/S5xhXmG/gol.gif">
<br>