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
public class Queen extends Piece{
    @Override
    public boolean can_Move(int x, int y, int playerNum, Grid[][] grid){
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
                if(pos.getX()==x){
                    //move vertically
                    return this.can_MoveVertically(x, y, playerNum, grid);
                }
                else if (pos.getY()==y){
                    //move horizontally
                    return this.can_MoveHorizontally(x, y, playerNum, grid);
                }
                else {
                    // move digonally
                    return this.can_MoveDiagonally(x, y, playerNum, grid);
                }
            }     
        }
        catch(MyException exp){
            System.out.print(exp.toString());
        }
        return result;
    }
}
