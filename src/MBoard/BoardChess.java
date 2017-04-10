/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBoard;

import java.util.Observable;
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
public final class BoardChess{
    
    public Grid[][] grid= new Grid[8][8];
    
    boolean moved = true;
    
    public Pawn pawn []= new Pawn[8];
    public Bishop bishop [] = new Bishop[2];
    public Rook rook [] = new Rook[2];
    public Knight knight[]=new Knight[2];
    public King king;
    public Queen queen;
    
    public Pawn pawn2 []= new Pawn[8];
    public Bishop bishop2 [] = new Bishop[2];
    public Rook rook2 [] = new Rook[2];
    public Knight knight2[]=new Knight[2];
    public King king2;
    public Queen queen2;
    
        
    public BoardChess(){

        
        for(int i=0; i<8;i++){
            for(int j=0;j<8;j++){
                grid[i][j]=new Grid();
            }
        }
        
        // init all the piece
        for (int i=0; i<8;i++){
            if(i<2){
                // first set
                bishop[i]=new Bishop();
                knight[i]=new Knight();
                pawn[i]=new Pawn(true);
                rook[i]=new Rook();
                //second set
                bishop2[i]=new Bishop();
                knight2[i]=new Knight();
                pawn2[i]=new Pawn(false);
                rook2[i]=new Rook();
            }
            else{
            // continue to init pawn
            pawn[i]=new Pawn(true); // white
                        
            pawn2[i]=new Pawn(false);//black
            }
            // init king queen
            king=new King();
            king2=new King();
            queen = new Queen();
            queen2=new Queen();
            
        }
        
        // set up white  piece
        setWhitePiece();
        // set up black piece
        setBlackPiece();
    }
    
    public void setWhitePiece(){
        int y=0;
        int player = 1;
        Piece curPiece;
        //set rook
        for(int i=0;i<8;i++){
            switch(i){
                case 0: {
                    curPiece=new Rook();
                    curPiece=rook[0];
                    break;
                }
                case 1: {
                    curPiece=new Knight();
                    curPiece=knight[0];
                    break;
                }
                case 2: {
                    curPiece = new Bishop();
                    curPiece=bishop[0];
                    break;
                }
                case 3: {
                    curPiece = new Queen();
                    curPiece=queen;
                    break;
                }
                case 4: {
                    curPiece = new King();
                    curPiece=king;
                    curPiece.is_King=true;
                    break;
                }
                case 5: {
                    curPiece = new Bishop();
                    curPiece=bishop[1];
                    break;
                }
                case 6: {
                    curPiece = new Knight();
                    curPiece=knight[1];
                    break;
                }
                case 7: {
                    curPiece=new Rook();
                    curPiece=rook[1];
                    break;
                }
                default:
                    curPiece=null;
                    break;
            }
            curPiece.pos.setPos(i, y);
            grid[i][y].putPiece(player, curPiece);
            
            // create pawn in the same loop
            pawn[i].pos.setPos(i, y+1);
            grid[i][y+1].putPiece(player, pawn[i]);
        }
    }
    
    public void setBlackPiece(){
        int y=7;
        int player = 2;
        Piece curPiece = null;
        //set rook
        for(int i=0;i<8;i++){
            switch(i){
                case 0: {
                    curPiece=new Rook();
                    curPiece=rook2[0];
                    break;
                }
                case 1: {
                    curPiece=new Knight();
                    curPiece=knight2[0];
                    break;
                }
                case 2: {
                    curPiece = new Bishop();
                    curPiece=bishop2[0];
                    break;
                }
                case 3: {
                    curPiece = new Queen();
                    curPiece=queen2;
                    break;
                }
                case 4: {
                    curPiece = new King();
                    curPiece=king2;
                    curPiece.is_King=true;
                    break;
                }
                case 5: {
                    curPiece = new Bishop();
                    curPiece=bishop2[1];
                    break;
                }
                case 6: {
                    curPiece = new Knight();
                    curPiece=knight2[1];
                    break;
                }
                case 7: {
                    curPiece=new Rook();
                    curPiece=rook2[1];
                    break;
                }
                
                default:
                    curPiece=null;
                    break;
            }
            curPiece.pos.setPos(i, y);
            grid[i][y].putPiece(player, curPiece);
            
            // create pawn in the same loop
            pawn2[i].pos.setPos(i, y-1);
            grid[i][y-1].putPiece(player, pawn2[i]);
        }   
    }
    
}
