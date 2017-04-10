package MPiece;

import Position.Position;
import MBoard.Grid;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public abstract class Piece {
    
    public Position pos;
    public boolean killed;
    public boolean is_King=false;

    
    public Piece(){
        killed = false;
        pos=new Position(0,0);
    }
    public void move(int x, int y){
        pos.setPos(x, y);
    }
    public abstract boolean can_Move(int x, int y, int PlayerNum, Grid[][] grid);
    
    public boolean can_MoveHorizontally(int x, int y, int playerNum,Grid[][] grid){
        if(pos.getX() < x){
            //move horizontally to right
            for (int i=pos.getX()+1; i<=x;i++){
                if(grid[i][y].occupied && grid[i][y].playerNum == playerNum){
                    return false;
                }
            }
            return true;
        }
        else{
        //move horizontally to left
            for (int i=pos.getX()-1; i>=x;i--){
                if(grid[i][y].occupied && grid[i][y].playerNum == playerNum){
                    return false;
                }
            }
            return true;
        }
    }
    public boolean can_MoveVertically(int x, int y, int playerNum, Grid[][] grid){
        if (pos.getY() <y){
            //move verrtically up
            for(int i=pos.getY()+1; i <= y ;i++){
                if(grid[x][i].occupied && grid[x][i].playerNum == playerNum)
                    return false;
            }  
            return true;
        }
        else {
            //move vertically down
            for(int i=pos.getY()-1; i>=y;i--){
                if(grid[x][i].occupied && grid[x][i].playerNum == playerNum)
                    return false;
            }
            return true;
        }
    }
    public boolean can_MoveDiagonally(int x, int y, int playerNum, Grid[][] grid){
        int temp = Math.abs(pos.getX()-x);
        // quick check if the point user want is on the diagonal
        if ( temp !=  Math.abs(pos.getY()-y)){
            //the point is not on the diagonal
            //shame on you user
            return false;
        }
        else{
            // its on the diagonal
            // now checking for obstacle on the path
            if ( pos.getY() > y && pos.getX() > x){
                // bottom left
                int i=pos.getX()-1;
                int j=pos.getY()-1;
                while (i != x && j != y){
                    if(grid[i][j].occupied || grid[i][j].playerNum == playerNum)
                        return false;
                    i--; 
                    j--;
                }
                return true;
            }
            else if ( pos.getY() < y && pos.getX() > x){
                // top left
                int i=pos.getX()-1;
                int j=pos.getY()+1;
                while (i != x && j != y){
                    if(grid[i][j].occupied || grid[i][j].playerNum == playerNum)
                        return false;
                    i--; 
                    j++;
                }
                return true;
            }
            else if ( pos.getY() < y && pos.getX() < x){
                // top right
                int i=pos.getX()+1;
                int j=pos.getY()+1;
                while (i != x && j != y){
                    if(grid[i][j].occupied || grid[i][j].playerNum == playerNum)
                        return false;
                    i++; 
                    j++;
                }
                return true;
            }
            else {
                // bottom right
                int i=pos.getX()+1;
                int j=pos.getY()-1;
                while (i != x && j != y){
                    if(grid[i][j].occupied || grid[i][j].playerNum == playerNum)
                        return false;
                    i++; 
                    j--;
                }
                return true;
            }
        }
    }
}
