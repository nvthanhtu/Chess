package Vue;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import java.io.InputStream;

import static application.Main.TILE_SIZE;

import java.io.File;
public class Piece extends StackPane {
	
	  private PieceType type;
	  

	    private double mouseX, mouseY;
	    private double oldX, oldY;

	    public PieceType getType() {
	        return type;
	    }

	    public double getOldX() {
	        return oldX;
	    }

	    public double getOldY() {
	        return oldY;
	    }
	  public Piece(PieceType type, int x, int y) {
	        this.type = type;

	        move(x, y);
	        Class<?> clazz = this.getClass();
	       if(type ==  PieceType.BLACK_CASTLE){
	  
	        
	        InputStream input = clazz.getResourceAsStream("/ChessPieces/Black_castle.png");
	 
	        Image image = new Image(input);
	        ImageView imageView = new ImageView(image);
	        this.getChildren().add(imageView);
	       }
	       
	       if(type ==  PieceType.BLACK_HORSE){
	    		  
		        
		        InputStream input = clazz.getResourceAsStream("/ChessPieces/Black_horse.png");
		 
		        Image image = new Image(input);
		        ImageView imageView = new ImageView(image);
		        this.getChildren().add(imageView);
		       }
		 
	       if(type ==  PieceType.BLACK_BISHOP){
	    		  
		        
		        InputStream input = clazz.getResourceAsStream("/ChessPieces/Black_bishop.png");
		 
		        Image image = new Image(input);
		        ImageView imageView = new ImageView(image);
		        this.getChildren().add(imageView);
		       }
	 

	       if(type ==  PieceType.BLACK_KING){
	    		  
		        
		        InputStream input = clazz.getResourceAsStream("/ChessPieces/Black_king.png");
		 
		        Image image = new Image(input);
		        ImageView imageView = new ImageView(image);
		        this.getChildren().add(imageView);
		       }
	       
	       
	       if(type ==  PieceType.BLACK_QUEEN){
	    		  
		        
		        InputStream input = clazz.getResourceAsStream("/ChessPieces/Black_queen.png");
		 
		        Image image = new Image(input);
		        ImageView imageView = new ImageView(image);
		        this.getChildren().add(imageView);
		       }
	 
	       if(type ==  PieceType.BLACK_PAWN){
	    		  
		        
		        InputStream input = clazz.getResourceAsStream("/ChessPieces/Black_pawn.png");
		 
		        Image image = new Image(input);
		        ImageView imageView = new ImageView(image);
		        this.getChildren().add(imageView);
		       }
	       
	       if(type ==  PieceType.WHITE_CASTLE){
	    		  
		        
		        InputStream input = clazz.getResourceAsStream("/ChessPieces/White_castle.png");
		 
		        Image image = new Image(input);
		        ImageView imageView = new ImageView(image);
		        this.getChildren().add(imageView);
		       }
		       
		       if(type ==  PieceType.WHITE_HORSE){
		    		  
			        
			        InputStream input = clazz.getResourceAsStream("/ChessPieces/White_horse.png");
			 
			        Image image = new Image(input);
			        ImageView imageView = new ImageView(image);
			        this.getChildren().add(imageView);
			       }
			 
		       if(type ==  PieceType.WHITE_BISHOP){
		    		  
			        
			        InputStream input = clazz.getResourceAsStream("/ChessPieces/White_bishop.png");
			 
			        Image image = new Image(input);
			        ImageView imageView = new ImageView(image);
			        this.getChildren().add(imageView);
			       }
		 

		       if(type ==  PieceType.WHITE_KING){
		    		  
			        
			        InputStream input = clazz.getResourceAsStream("/ChessPieces/White_king.png");
			 
			        Image image = new Image(input);
			        ImageView imageView = new ImageView(image);
			        this.getChildren().add(imageView);
			       }
		       
		       
		       if(type ==  PieceType.WHITE_QUEEN){
		    		  
			        
			        InputStream input = clazz.getResourceAsStream("/ChessPieces/White_queen.png");
			 
			        Image image = new Image(input);
			        ImageView imageView = new ImageView(image);
			        this.getChildren().add(imageView);
			       }
		 
		       if(type ==  PieceType.WHITE_PAWN){
		    		  
			        
			        InputStream input = clazz.getResourceAsStream("/ChessPieces/White_pawn.png");
			 
			        Image image = new Image(input);
			        ImageView imageView = new ImageView(image);
			        this.getChildren().add(imageView);
			       }

	        setOnMousePressed(e -> {
	            mouseX = e.getSceneX();
	            mouseY = e.getSceneY();
	        });

	        setOnMouseDragged(e -> {
	            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
	        });
	    }

	    public void move(int x, int y) {
	        oldX = x * TILE_SIZE;
	        oldY = y * TILE_SIZE;
	        relocate(oldX, oldY);
	    }

	    public void abortMove() {
	        relocate(oldX, oldY);
	    }

}
