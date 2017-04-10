/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chessgame;

import java.util.Observable;
import MBoard.BoardChess;
import MBoard.Grid;
import MPiece.Piece;
import MPiece.King;

/**
 *
 * @author admin
 */
public class Chessgame extends Observable{
    BoardChess board;
    
    public int player=0;
    
    public boolean moved = false;
    public boolean kill =false;
    public boolean finalmove=false;
    
    public Chessgame(){
        board = new BoardChess();
        player = 1;
    }
    
    int playerSuivant(){
        if(player==1){
            player=2;
        }
        else
            player=1;
        return player;
    }
    
    // function to move and notify to observer
    public void move (int xOld,int yOld,int xNew,int yNew){
        
        Grid gOld = board.grid[xOld][yOld];
        Grid gNew = board.grid[xNew][yNew];
        
        if(gOld.playerNum==player){
            Piece selectedPiece = gOld.getPiece();
            if(selectedPiece.can_Move(xNew, yNew, player, board.grid)){
                if(gNew.occupied){
                    if(gNew.p.is_King){
                        finalmove=true;
                    }
                    gNew.p.killed=true;
                    gNew.takePieceAway();
                    kill=true;
                }
                moved=true;
                gNew.putPiece(player, selectedPiece);
                gOld.p.pos.setPos(xNew, yNew);
                gOld.takePieceAway();
                
                
                playerSuivant();
                
            }
        }
        else{
            // do nothing
        }
        
        setChanged();
        notifyObservers();
    }
    
    public void resetStatus(){
        moved=false;
        kill=false;
    }
    
}
