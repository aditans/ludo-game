import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.Random;

public class App extends Application {
    GridPane board;
    int winner=0;

    private final int TILE_SIZE = 40;
    private final int BOARD_SIZE = 15; // Ludo is typically played on a 15x15 board.
    //private int player1Pos = 0;
    //private int player2Pos = 0;
    private boolean player1Turn = true;
    private boolean player2Turn = false;
    private boolean player3Turn = false;
    private boolean player4Turn = false;
    int currp1=0;
    int currp2=0;
    int currp3=0;
    int currp4=0;
    int safezonerow[]={1,2,6,6,8,8,12,13};
    int safezonecol[]={8,6,1,12,2,13,8,6};
    int P1playzonerow[]={13,12,11,10,9,8,8,8,8,8,8,8,7,6,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,6,7,8,8,8,8,8,8,8,9,10,11,12,13,14,14,13,12,11,10,9,8,7};
    int P1playzonecol[]={6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,6,7,8,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,8,7,7,7,7,7,7,7,7};
    int P2playzonerow[]={6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,6,7,8,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,8,7,7,7,7,7,7,7,7};
    int P2playzonecol[]={1,2,3,4,5,6,6,6,6,6,6,6,7,8,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,8,7,6,6,6,6,6,6,6,5,4,3,2,1,0,0,1,2,3,4,5,6,7};
    int P3playzonerow[]={1,2,3,4,5,6,6,6,6,6,6,6,7,8,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,8,7,6,6,6,6,6,6,6,5,4,3,2,1,0,0,1,2,3,4,5,6,7};
    int P3playzonecol[]={8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7,7,7};
    int P4playzonerow[]={8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 14, 14, 14, 13, 12, 11, 10, 9, 8, 8, 8, 8, 8, 8, 8, 7, 6, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7,7,7};
    int P4playzonecol[]={13,12,11,10,9,8,8,8,8,8,8,8,7,6,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,6,7,8,8,8,8,8,8,8,9,10,11,12,13,14,14,13,12,11,10,9,8,7};

    private Label statusLabel;
    private Button diceButton;
    private Rectangle[][] cells = new Rectangle[BOARD_SIZE][BOARD_SIZE]; // Board cells
    private Label player1Token, player2Token,player3Token,player4Token;
    Rectangle P1rect = new Rectangle(TILE_SIZE, TILE_SIZE);
    Rectangle P2rect = new Rectangle(TILE_SIZE, TILE_SIZE); 
    Rectangle P3rect = new Rectangle(TILE_SIZE, TILE_SIZE);
    Rectangle P4rect = new Rectangle(TILE_SIZE, TILE_SIZE);// Player tokens

    public static void main(String[] args) {
        launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) {
        // Main layout
        P1rect.setFill(Color.GREENYELLOW);
        P2rect.setFill(Color.MAROON);
        BorderPane root = new BorderPane();
        root.setPrefSize(750, 750);

        // Ludo Board (GridPane)
        board = createBoard();
        root.setCenter(board);

        // Controls (Bottom section)
        HBox controls = createControls();
        root.setBottom(controls);

        // Setting up the scene
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ludo Game");
        primaryStage.show();
    }

    // Create the Ludo board with cross-shaped path and player zones
    private GridPane createBoard() {
        GridPane board = new GridPane();
        board.setPrefSize(750, 750);
    
            

        // Creating the 15x15 Ludo grid with specific color zones
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Rectangle rect = new Rectangle(TILE_SIZE, TILE_SIZE);

                if (isPlayerHomeZone(row, col, 0, 0)) 
                {
                    rect.setFill(Color.RED);
                    rect.setStroke(Color.RED); // Player 1 home zone
                } 
                else if (isPlayerHomeZone(row, col, 9, 0)) 
                {
                    rect.setFill(Color.GREEN);
                    rect.setStroke(Color.GREEN); // Player 2 home zone
                } 
                else if (isPlayerHomeZone(row, col, 0, 9)) 
                {
                    rect.setFill(Color.GOLD);
                    rect.setStroke(Color.GOLD); // Player 3 home zone
                } 
                else if (isPlayerHomeZone(row, col, 9, 9)) 
                {
                    rect.setFill(Color.BLUE);
                    rect.setStroke(Color.BLUE); // Player 4 home zone
                } 
                else if (isCrossPath(row, col)) 
                {
                    rect.setFill(Color.WHITE);
                    rect.setStroke(Color.GRAY); // Cross-path where pieces move
                }
                else {
                    rect.setFill(Color.LIGHTGRAY);
                    rect.setStroke(Color.BLACK); // Outer area of the board
                }
                if (isPlayerSafeZone(row, col))
                {
                    rect.setFill(Color.LIGHTGREY);
                    rect.setStroke(Color.BLACK);

                }
                if (row==P1playzonerow[0] && col==P1playzonecol[0])
                {
                    rect.setFill(Color.KHAKI);

                }
                if (row==P2playzonerow[0] && col==P2playzonecol[0])
                {
                    rect.setFill(Color.KHAKI);

                }  
                if (row==P3playzonerow[0] && col==P3playzonecol[0])
                {
                    rect.setFill(Color.KHAKI);

                }
                if (row==P4playzonerow[0] && col==P4playzonecol[0])
                {
                    rect.setFill(Color.KHAKI);

                }

                
                cells[row][col] = rect; // Store cell references
                board.add(rect, col, row);
            }
        }
        P1rect.setFill(Color.GREENYELLOW);
        P2rect.setFill(Color.INDIANRED);
        P3rect.setFill(Color.YELLOW);
        P4rect.setFill(Color.LIGHTBLUE);

        board.add(P1rect, P1playzonecol[currp1], P1playzonerow[currp1]);
        board.add(P2rect, P2playzonecol[currp2], P2playzonerow[currp2]);
        board.add(P3rect, P3playzonecol[currp3], P3playzonerow[currp3]);
        board.add(P4rect, P4playzonecol[currp4], P4playzonerow[currp4]);

        // Adding player tokens
        player1Token = new Label("P1");
        player1Token.setFont(Font.font(20));
        player1Token.setTextFill(Color.GREEN);
        board.add(player1Token, P1playzonecol[currp1], P1playzonerow[currp1]); // Start position of player 1

        player2Token = new Label("P2");
        player2Token.setFont(Font.font(20));
        player2Token.setTextFill(Color.DARKRED);
        board.add(player2Token, P2playzonecol[currp2], P2playzonerow[currp2]);

        player3Token = new Label("P3");
        player3Token.setFont(Font.font(20));
        player3Token.setTextFill(Color.DARKGOLDENROD);
        board.add(player3Token, P3playzonecol[currp3], P3playzonerow[currp3]); // Start position of player 1

        player4Token = new Label("P4");
        player4Token.setFont(Font.font(20));
        player4Token.setTextFill(Color.DARKSLATEBLUE);
        board.add(player4Token, P4playzonecol[currp4], P4playzonerow[currp4]); // Start position of player 2

        return board;
    }

    // Create control buttons and dice rolling area
    private HBox createControls() {
        HBox controls = new HBox(10);
        controls.setPrefHeight(100);
        controls.setStyle("-fx-alignment: center;");

        // Status label to show player turns
        statusLabel = new Label("Player 1's turn");
        statusLabel.setFont(Font.font(18));

        // Dice roll button
        diceButton = new Button("Roll Dice");
        diceButton.setFont(Font.font(18));
        diceButton.setOnAction(e -> rollDice());
        

        controls.getChildren().addAll(statusLabel, diceButton);
        return controls;
    }

    // Roll the dice and move the current player's token
    private void rollDice() {
        Random random = new Random();
        int diceRoll = random.nextInt(6) + 1;

        if (player1Turn) 
        {
            
            if(currp1+diceRoll<P1playzonecol.length)
            currp1=currp1+diceRoll;
            movePlayer(1, diceRoll);
            if(currp1==P1playzonecol.length-1)
            {
                winner=1;
                Platform.runLater(() -> statusLabel.setText("Player 1 won"));
                diceButton.setDisable(true);
            }
            // cutting of tokens
            if(P1playzonecol[currp1]==P2playzonecol[currp2] && P1playzonerow[currp1]==P2playzonerow[currp2] && !isPlayerSafeZone(P1playzonerow[currp1],P1playzonecol[currp1]))
            {
                currp2=0;
                movePlayer(2, diceRoll);
            }
            if(P1playzonecol[currp1]==P3playzonecol[currp3] && P1playzonerow[currp1]==P3playzonerow[currp3] && !isPlayerSafeZone(P1playzonerow[currp1],P1playzonecol[currp1]))
            {
                currp3=0;
                movePlayer(3, diceRoll);
            }
            if(P1playzonecol[currp1]==P4playzonecol[currp4] && P1playzonerow[currp1]==P4playzonerow[currp4] && !isPlayerSafeZone(P1playzonerow[currp1],P1playzonecol[currp1]))
            {
                currp4=0;
                movePlayer(4, diceRoll);
            }
         
        } 
        else if(player2Turn)
        {
            
            if(currp2+diceRoll<P2playzonecol.length)
            currp2=currp2+diceRoll;
            movePlayer(2, diceRoll);
            if(currp2==P2playzonecol.length-1)
            {
                winner=2;
                Platform.runLater(() -> statusLabel.setText("Player 2 won"));
                diceButton.setDisable(true);
            }
            if(P2playzonecol[currp2]==P1playzonecol[currp1] && P2playzonerow[currp2]==P1playzonerow[currp1] && !isPlayerSafeZone(P2playzonerow[currp2],P2playzonecol[currp2]))
            {
                currp1=0;
                movePlayer(1, diceRoll);
            }
            if(P2playzonecol[currp2]==P3playzonecol[currp3] && P2playzonerow[currp2]==P3playzonerow[currp3] && !isPlayerSafeZone(P2playzonerow[currp2],P2playzonecol[currp2]))
            {
                currp3=0;
                movePlayer(3, diceRoll);
            }
            if(P2playzonecol[currp2]==P4playzonecol[currp4] && P2playzonerow[currp2]==P4playzonerow[currp4] && !isPlayerSafeZone(P2playzonerow[currp2],P2playzonecol[currp2]))
            {
                currp4=0;
                movePlayer(4, diceRoll);
            }
           
        }
        else if(player3Turn)
        {
            
            if(currp3+diceRoll<P3playzonecol.length)
            currp3=currp3+diceRoll;
            movePlayer(3, diceRoll);
            if(currp3==P3playzonecol.length-1)
            {
                winner=3;
                Platform.runLater(() -> statusLabel.setText("Player 3 won"));
                diceButton.setDisable(true);
            }
            if(P3playzonecol[currp3]==P2playzonecol[currp2] && P3playzonerow[currp3]==P2playzonerow[currp2] && !isPlayerSafeZone(P3playzonerow[currp3],P3playzonecol[currp3]))
            {
                currp2=0;
                movePlayer(2, diceRoll);
            }
            if(P3playzonecol[currp3]==P1playzonecol[currp1] && P3playzonerow[currp3]==P1playzonerow[currp1] && !isPlayerSafeZone(P3playzonerow[currp3],P3playzonecol[currp3]))
            {
                currp1=0;
                movePlayer(1, diceRoll);
            }
            if(P3playzonecol[currp3]==P4playzonecol[currp4] && P3playzonerow[currp3]==P4playzonerow[currp4] && !isPlayerSafeZone(P3playzonerow[currp3],P3playzonecol[currp3]))
            {
                currp4=0;
                movePlayer(4, diceRoll);
            }
          
        }
        else if(player4Turn)
        {
            
            if(currp4+diceRoll<P4playzonecol.length)
            currp4=currp4+diceRoll;
            movePlayer(4, diceRoll);
         if(currp4==P4playzonecol.length-1)
            {
                winner=4;
                Platform.runLater(() -> statusLabel.setText("Player 4 won"));
                diceButton.setDisable(true);
            }
            if(P4playzonecol[currp4]==P2playzonecol[currp2] && P4playzonerow[currp4]==P2playzonerow[currp2] && !isPlayerSafeZone(P4playzonerow[currp4],P4playzonecol[currp4]))
            {
                currp2=0;
                movePlayer(2, diceRoll);
            }
            if(P4playzonecol[currp4]==P3playzonecol[currp3] && P4playzonerow[currp4]==P3playzonerow[currp3] && !isPlayerSafeZone(P4playzonerow[currp4],P4playzonecol[currp4]))
            {
                currp3=0;
                movePlayer(3, diceRoll);
            }
            if(P4playzonecol[currp4]==P1playzonecol[currp1] && P4playzonerow[currp4]==P1playzonerow[currp1] && !isPlayerSafeZone(P4playzonerow[currp4],P4playzonecol[currp4]))
            {
                currp1=0;
                movePlayer(1, diceRoll);
            }
        }







        // changing turns
        if(player1Turn)
        {
            player1Turn = !player1Turn;
            player2Turn = true;
            statusLabel.setText("Player 2's turn");

        }
        else if (player2Turn)
        {
            player2Turn = !player2Turn;
            player3Turn = true;
            statusLabel.setText("Player 3's turn");

        }
        else if (player3Turn)
        {
            player3Turn = !player3Turn;
            player4Turn = true;
            statusLabel.setText("Player 4's turn");

        }
        else if(player4Turn)
        {
            player4Turn = !player4Turn;
            player1Turn = true;
            statusLabel.setText("Player 1's turn");

        }

    }

    // Move the player's token
    private void movePlayer(int player, int diceRoll) {
        if (player == 1) 
        {
        // Update the position for player 1 without re-adding the Rectangle
            GridPane.setConstraints(P1rect, P1playzonecol[currp1], P1playzonerow[currp1]);
            GridPane.setConstraints(player1Token, P1playzonecol[currp1], P1playzonerow[currp1]);
        } 
        else if(player==2) 
        {
            // Update the position for player 2 without re-adding the Rectangle
            GridPane.setConstraints(P2rect, P2playzonecol[currp2], P2playzonerow[currp2]);
            GridPane.setConstraints(player2Token, P2playzonecol[currp2], P2playzonerow[currp2]);
        }
        else if(player==3) 
        {
            // Update the position for player 2 without re-adding the Rectangle
            GridPane.setConstraints(P3rect, P3playzonecol[currp3], P3playzonerow[currp3]);
            GridPane.setConstraints(player3Token, P3playzonecol[currp3], P3playzonerow[currp3]);
        }
        else if(player==4) 
        {
            // Update the position for player 2 without re-adding the Rectangle
            GridPane.setConstraints(P4rect, P4playzonecol[currp4], P4playzonerow[currp4]);
            GridPane.setConstraints(player4Token, P4playzonecol[currp4], P4playzonerow[currp4]);
        }

        // Check if a player has reached the end of their path
        /*if (player1Pos == 71 || player2Pos == 71) {
            diceButton.setDisable(true);
            statusLabel.setText("Player " + player + " wins!");
        }*/
    }


    // Check if a position is in a player's home zone
    private boolean isPlayerHomeZone(int row, int col, int startRow, int startCol) {
        return (row >= startRow && row < startRow + 6) && (col >= startCol && col < startCol + 6);
    }
    private boolean isPlayerSafeZone(int row, int col) {
        for(int i=0;i<safezonerow.length;i++)
        {
            if(safezonerow[i]==row && safezonecol[i]==col)return true;

        }    
            return false; 
    }


    // Check if a position is part of the cross-shaped path
    private boolean isCrossPath(int row, int col) {
        // Middle row and column as cross
        return (row >= 6 && row <= 8) || (col >= 6 && col <= 8);
    }
}



