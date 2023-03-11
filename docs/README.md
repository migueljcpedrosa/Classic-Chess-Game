# project-l02gr04
project-l02gr04 created by GitHub Classroom

## LDTS_<L02><Gr04> - CLASSIC GAME OF CHESS

In this exciting game you can play chess with your friends, using a clean but effective piece design.

This project was developed by *Miguel Pedrosa* (*up202108809*@fe.up.pt), *Luís Sousa* (*up202005832*@fc.up.pt) and *Xavier Santos* (*up202108894*@fe.up.pt) for LDTS 2021⁄2022.

### IMPLEMENTED FEATURES

> This section contains a list of implemented features and their descriptions.

**Examples**:

- **Draw chess board** - The chess board is drawn in the screen using Lanterna.
- **Draw chess piece** - A text file with 'x' and 'e' characters is read (each character corresponds to a different color). A piece is drawn with several small squares generated in the respective positions of the text file characters, using Lanterna. White pieces have black contour and white filling. Black pieces have white contour and black filling.
- **Move piece** - The chess piece moves to the selected position with the keyboard or mouse, according to the game rules.
- **Capture pieces** - A piece is eliminated from a list of pieces.
- **Checkmate** - A player captures the other's king and wins the game.
- **New game** - You can start a new game after finishing one by pressing "R"

![ChessBoard](https://user-images.githubusercontent.com/93871576/208133551-e4f2f6df-e292-4a91-9c40-454dd0d25d3a.jpg)


### DESIGN
------

#### ALL PIECES HAVE COMMON ATTRIBUTES, BUT SOME FUNCTIONS ARE DIFFERENT DEPENDING ON THE PIECE.

**Problem in Context**

For this game, we needed to create an object for each chess piece. However, the different pieces have some common characteristics.

**The Pattern**

We have applied the **Strategy Design** pattern. This design pattern allowed us to create a "Piece" abstract class, in which we declared the attributes which were common to every chess piece, such as position, piece color and piece type. In this class, we also declared and defined the piece constructor and some other functions, which were then overridden by each piece in their respective class, according to necessity.
Naturally, each piece has its respective class ("King", "Queen", "Pawn", etc) which extends the "Piece" abstract class.

The following figure shows how the pattern’s roles were mapped to the application classes.

![Strategy drawio](https://user-images.githubusercontent.com/93871576/209415015-775ffb61-bb54-44a4-8221-3531eed488b6.jpeg)

  
We also used the **Factory Design** pattern to create the pieces in the Board.

These classes can be found in the following files:

- [Bishop](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/intermediate-delivery/src/main/java/Bishop.java)
- [Horse](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/intermediate-delivery/src/main/java/Horse.java)
- [King](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/intermediate-delivery/src/main/java/King.java)
- [Queen](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/intermediate-delivery/src/main/java/Queen.java)
- [Pawn](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/intermediate-delivery/src/main/java/Pawn.java)
- [Rook](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/intermediate-delivery/src/main/java/Rook.java)

**Consequences**

The use of the Strategy Design Pattern in the current design allows the following benefits:

- The code is not repetitive.
- There isn't a need to redeclare piece attributes or redefine functions which are common to all pieces.
- We don’t need to have a long set of conditional if or switch statements associated with the various pieces; instead, polimorphism is used to activate the right behavior.
- The code is easier to understand and modify for future features.
  
#### QUEEN'S MOVEMENT

**Problem in Context**

The Queen's movement is a junction of the Rook and the Bishop's movement.

**The Pattern**

We have applied the **Composite Design** pattern. Since the Queen's movement is a junction of the Rook and the Bishop's movement, we decided to make the Queen a complex element, composed of a Rook and a Bishop.
The client works with all elements through the same interface. As a result, the client can work in the same way with both simple or complex pieces of our element "tree".
The following figure shows how the pattern’s roles were mapped to the application classes.

![Composite drawio](https://user-images.githubusercontent.com/93871576/209413772-c4c583c8-b55d-432b-948b-87fc008322a7.jpg)


These classes can be found in the following files:

- [Bishop](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/intermediate-delivery/src/main/java/Bishop.java)
- [Queen](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/intermediate-delivery/src/main/java/Queen.java)
- [Rook](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/intermediate-delivery/src/main/java/Rook.java)

**Consequences**

The use of the Composite Design Pattern in the current design allows the following benefits:

- The code is not repetitive.
- We are able to work with complex tree structures more conveniently, using polymorphism and recursion.
- We respect the Open/Closed Principle. New element types can be introduced into the game without breaking the existing code.
  
#### SELECTOR BUTTON

**Problem in Context**

We needed to create a piece selector with various operations for the player. 

**The Pattern**

We have applied the **Command Design** pattern by creating several classes that implement the SelectorCommand interface: SelectorDeselect, SelectorS, SelectorW, SelectorD, and SelectorA. The SelectorCommand interface defines a single method, execute, which takes in a Selector object and a Board object as arguments.

The SelectorDeselect class implements the execute method by calling the deselect method on the Selector object.

The SelectorS, SelectorW, SelectorD, and SelectorA classes all implement the execute method by calling the move method on the Selector object with different arguments. The SelectorS class moves the Selector object one position down, the SelectorW class moves it one position to the left, the SelectorD class moves it one position to the right, and the SelectorA class moves it one position up.
The following figure shows how the pattern’s roles were mapped to the application classes.
  
![CommandDesignPatternUML](https://user-images.githubusercontent.com/93871576/209417114-c8e9f506-184e-487a-b946-78bf207b8b4a.jpg)

These classes can be found in the following files:
- [SelectorCommand](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/master/src/main/java/Game/Selector/SelectorCommand.java)
- [SelectorA](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/master/src/main/java/Game/Selector/SelectorA.java)
- [SelectorD](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/master/src/main/java/Game/Selector/SelectorD.java)
- [SelectorS](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/master/src/main/java/Game/Selector/SelectorS.java)
- [SelectorW](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/master/src/main/java/Game/Selector/SelectorW.java)
- [SelectorDeselect](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/master/src/main/java/Game/Selector/SelectorDeselect.java)
- [Board](https://github.com/FEUP-LDTS-2022/project-l02gr04/blob/master/src/main/java/Game/Board.java)
  

**Consequences**

The use of the Command Design Pattern in the current design allows the following benefits:

- The Single Responsibility Principle is respected. We are able to decouple classes that invoke operations from classes that perform those operations.
- The Open/Closed Principle is respected. We introduce new commands into our chess game without altering the already existing code.
- We were able to implement select/deselect.
  


#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

### NEW GAME DETECTION
  This is currently done by polling, it would be improved if done by an observer instead.

### LAZY CLASS
  Classes such as SelectorDeselect, SelectorS, SelectorW, SelectorD, and SelectorA which were used in the command design pattern have one single function.
  
### FEATURE ENVY
  Methods in the Board class are frequently accessed by the SelectorDeselect, SelectorS, SelectorW, SelectorD, and SelectorA classes, instead of using its own methods or fields. 


### TESTING

![Coverage Report](https://user-images.githubusercontent.com/93871576/209416829-74bffab5-7fbc-4bba-be43-823b55572fde.png)


### SELF-EVALUATION

- Luís Sousa: 33.3%
- Miguel Pedrosa: 33.3%
- Xavier Santos: 33.3%
