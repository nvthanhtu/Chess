/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBoard;

import Position.Position;
import MPiece.Bishop;
import MPiece.Pawn;
import MPiece.King;
import MPiece.Knight;
import MPiece.Piece;
import MPiece.Queen;
import MPiece.Rook;
/**
 *
 * @author admin
 */
public class Grid {
    public boolean occupied;
    public int playerNum;
    public Piece p;
    
    public Grid(){
        this.occupied=false;
        this.playerNum=0;
        p=null;
    }

    public Grid(int playerNum,Piece p){
        this.occupied=true;
        this.playerNum=playerNum;
        this.p=p;
    }
    
    public boolean putPiece(int playerNum,Piece p){
        if(occupied)
            return false;
        else{
            if(playerNum==this.playerNum){
                return false;
            }
            else{
                this.occupied=true;
                this.playerNum=playerNum;
                this.p=p;
                return true;
            }
        }
    }
    
    public void takePieceAway(){
        this.occupied=false;
        this.playerNum=0;
        this.p=null;
    }
    
    public int getPlayerNum(){
        return playerNum;
    }
    public Piece getPiece(){
        return this.p;
    }
}
