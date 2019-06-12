# Conway's Game of Life
**v.0.3**<br>

[![License](https://img.shields.io/badge/license-Unlicense-brightgreen.svg)](https://unlicense.org/)
[![JDK](https://img.shields.io/badge/JDK-%3E%3D%201.7-d36e6e.svg?style=flat-circle)](https://docs.oracle.com/javase/8/docs/)
[![Join the chat](https://badges.gitter.im/conways-game-of-life.svg)](https://gitter.im/conways-game-of-life/community)
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
<b>1. With bash/bat files:</b>

Run ``compile.sh`` to compile and run ``run.sh`` to run for *nix.<br>
Run ``compile.bat`` to compile and run ``run.bat`` to run for Windows.
<br>
<br>

<b>2. With CLI:</b>
<br>

Compile using
```
javac -sourcepath src -classpath lib/stdlib-package.jar -d out src/mamadaliev/GameRunner.java
```

Run using
```
java -classpath out:lib/stdlib-package.jar mamadaliev.GameRunner
```
<br>

## Algorithm
<b>Life:</b>
neighbors = 3 OR neighbors = 2 AND life cell.

<b>Dead:</b>
neighbors = (-ထ; 2) ∪ (2; 3) ∪ (3; +ထ) OR neighbors = 2 AND dead cell.
<br>
<br>

## UML Diagram
<img width="320" src="https://i.ibb.co/7WdFk25/uml.png">
<br>

## Demo
<img src="https://i.ibb.co/xXjp5dV/demo.gif">
<br>

## Change Log
A change log for the entire project can be found under [CHANGELOG.md](https://github.com/mamadaliev/game-of-life/blob/master/CHANGELOG.md).
<br>

## Contribute
For any problems, comments, or feedback please create an issue [here on GitHub](https://github.com/mamadaliev/game-of-life/issues).
<br>

## Licence
Game of Life is released under the [Unlicense](http://unlicense.org/).
