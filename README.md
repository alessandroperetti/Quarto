# Quarto
Quarto!  ( board game) https://en.wikipedia.org/wiki/Quarto_(board_game) 

This project is just a draft of the Quarto board game. Indeed, it is a ready to use version of the game. There is no GUI and any sort of AI.

The structure of the java project is the following:

1)<strong> Pedine.txt </strong>: it represents a list of the pawns which will be used in the game;<br>
2) <strong>Scacchiera.txt</strong>: it represents the physical area of the game in which the pawns will be located during the game.<br>
3) <strong>Quarto.java</strong>: it represents the main of the Java program.<br> 
4) <strong>Pedina.java</strong>: It represents the pedina object. Each pedina object or spawn has 4 features: height, colour, shape and volume.<br>
5) <strong>Scacchiera.java</strong>: it is used to print out on file each configuration of the chessboard and for each turn it checks if there is a victory or a draw.<br>
6) <strong>CheckPedine.java</strong>: it checks wheater or not the pedine.txt is complied with rules.<br>
7) <strong>CheckScacchiera.java</strong>: it checks wheater or not the scacchiera.txt is complied with rules. <br>
8) <strong>Parser.java</strong>: it represents the java class used to transform a string object in a pedina object. <br>  
