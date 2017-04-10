/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MPiece;
import MBoard.Grid;
import Exception.MyException;
/**
 *
 * @author admin
 */
public class Pawn extends Piece{
    private boolean firstMove;
    private boolean forward;
    
    public Pawn(boolean forward){
        firstMove=true;
        this.forward=forward;
    }
    
    public void move(int x, int y){
        firstMove=false;
        super.move(x,y);
    }
    
    @Override
    public boolean can_Move(int x, int y, int PlayerNum, Grid[][] grid){
        boolean result=false;
        try{
            if(x>8 && x<0){
                throw new MyException("Error on X");
            }
            else if(y>8 && y<0){
                throw new MyException("Error on Y");
            }
            else if(pos.getX()==x && pos.getY()==y){
                throw new MyException("Erreur X=Xnew and Y=Ynew");
            }
            else{
                if((pos.getX()==x||pos.getY()==y)&&(Math.abs(pos.getX()-x)==2 || Math.abs(pos.getY()-y)==2) && firstMove){
                    firstMove=false;
                    return true;
                }// first move
                else if(pos.getX()==x && (y-pos.getY()==1) && forward){
                    return true;
                }// normal move forward
                
                else if (pos.getX()==x && (pos.getY()-y==1) && !forward){
                    return true;
                }// normal move forward
                else if(Math.abs(pos.getX()-x)==1 && (y-pos.getY()==1) && grid[x][y].playerNum != PlayerNum  && grid[x][y].occupied && forward){
                    return true;
                }
                else if(Math.abs(pos.getX()-x)==1 && (pos.getY()-y==1) && grid[x][y].playerNum != PlayerNum && grid[x][y].occupied && !forward){
                    return true;
                }
                else {
                    return false;
                }   
            }     
        }
        catch(MyException exp){
            System.out.print(exp.toString());
        }
        return result;
    }  
}
