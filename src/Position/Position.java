package Position;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Position {
    private int x,y;
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public void setPos(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
