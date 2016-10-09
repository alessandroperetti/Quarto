# Quarto
Quarto!  ( board game) https://en.wikipedia.org/wiki/Quarto_(board_game) 

This project is just a draft of the Quarto board game. Indeed, it is a ready to use version of the game. There is no GUI and any sort of AI.

The structure of the java project is the following:

1) Pedine.txt: it represents a list of the pawns which will be used in the game;<br>
2) Scacchiera.txt: it represents the physical area of the game in which the pawns will be located during the game.
3) Quarto.java: it represents the main of the Java program. 
4) Pedina.java: It represents the pedina object. Each pedina object or spawn has 4 features: height, colour, shape and volume.
5) Scacchiera.java: it is used to print out on file each configuration of the chessboard and for each turn it checks if there is a victory or a draw.
6) CheckPedine.java: it checks wheater or not the pedine.txt is complied with rules.  
7) CheckScacchiera.java: it checks wheater or not the scacchiera.txt is complied with rules. 
8) Parser.java: it represents the java class used to transform a string object in a pedina object.  
