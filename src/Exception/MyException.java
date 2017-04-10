/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author admin
 */
public class MyException extends Exception {
    public String message;
    public MyException(String mess){
        this.message=mess;
    }
    @Override
    public String toString(){
        return this.message;
    }
}
