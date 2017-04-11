package application;
	
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.FlowPane;
import MBoard.BoardChess;
import Vue.MoveResult;
import Vue.MoveType;
import Vue.Piece;
import Vue.PieceType;
import Vue.Tile;

import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import Chessgame.Chessgame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import java.lang.String;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCombination;

public class Main extends Application {
	  // Tạo MenuBar
          Label textField;
    public static final int TILE_SIZE = 80;
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    public static Node root;
    private String player = null;
    private String current = "Current: ";
    private String affText = null;
    Scene scene = new Scene(new VBox());
    Alert alert = new Alert(AlertType.CONFIRMATION);
    private Stage stage = new Stage();
    
    private Tile[][] board = new Tile[WIDTH][HEIGHT];

    
    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();
    
    Chessgame chess = new Chessgame();
    
    MoveResult result;
    
    int x0,y0,newX,newY;
    
    Piece currentP;
    
    Stage stagePrim;
    
    private Node createContent() {
		
    	
	    Pane root = new Pane();
	    //root.getChildren().add(menu);
        root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        
        root.getChildren().addAll(tileGroup, pieceGroup);
        

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
            	Tile tile = new Tile((x + y) % 2 == 0, x, y);
            	 board[x][y] = tile;
            	
            	
            	  tileGroup.getChildren().add(tile);
            	  
            	  Piece piece = null;

                  if (y == 0) {
                	  if(x==0 || x==WIDTH-1)
                      piece = makePiece(PieceType.BLACK_CASTLE, x, y);
                	  
                	  if(x==1 ||  x==WIDTH-2)
                          piece = makePiece(PieceType.BLACK_HORSE, x, y);
                	  
                	  if(x==2 ||  x==WIDTH-3)
                          piece = makePiece(PieceType.BLACK_BISHOP, x, y);
                	  
                	  if(x==3)
                          piece = makePiece(PieceType.BLACK_QUEEN, x, y);
                	  if(x==4)
                          piece = makePiece(PieceType.BLACK_KING, x, y);
                  }
                  
                  if(y == 1)
                  {
                	  piece = makePiece(PieceType.BLACK_PAWN, x, y);
                  }

                  if (y == 7) {
                	  
                	  if(x==0 || x==WIDTH-1)
                          piece = makePiece(PieceType.WHITE_CASTLE, x, y);
                    	  
                    	  if(x==1 ||  x==WIDTH-2)
                              piece = makePiece(PieceType.WHITE_HORSE, x, y);
                    	  
                    	  if(x==2 ||  x==WIDTH-3)
                              piece = makePiece(PieceType.WHITE_BISHOP, x, y);
                    	  
                    	  if(x==3)
                              piece = makePiece(PieceType.WHITE_QUEEN, x, y);
                    	  if(x==4)
                              piece = makePiece(PieceType.WHITE_KING, x, y);
                  }
                  
                  if (y == 6) {
                	  piece = makePiece(PieceType.WHITE_PAWN, x, y);
                  }

                  if (piece != null) {
                      tile.setPiece(piece);
                     
                      pieceGroup.getChildren().add(piece);
            }
          }
        }
        return root;
	}
	
	 private void tryMove(Piece piece, int newX, int newY) {
	  /*      if (board[newX][newY].hasPiece() || (newX + newY) % 2 == 0) {
	            return new MoveResult(MoveType.NONE);
	        }

	        int x0 = toBoard(piece.getOldX());
	        int y0 = toBoard(piece.getOldY());

	        if (Math.abs(newX - x0) == 1 && newY - y0 == piece.getType().moveDir) {
	            return new MoveResult(MoveType.NORMAL);
	        } else if (Math.abs(newX - x0) == 2 && newY - y0 == piece.getType().moveDir * 2) {

	            int x1 = x0 + (newX - x0) / 2;
	            int y1 = y0 + (newY - y0) / 2;

	            if (board[x1][y1].hasPiece() && board[x1][y1].getPiece().getType() != piece.getType()) {
	                return new MoveResult(MoveType.KILL, board[x1][y1].getPiece());
	            }
	        }
	        */
          
                int x0 = toBoard(piece.getOldX());
	        int y0 = toBoard(piece.getOldY());
                chess.move(x0,y0, newX,newY);         
                
	       // return new MoveResult(MoveType.NORMAL);
	    }
	 
	  private int toBoard(double pixel) {
	        return (int) ((pixel + TILE_SIZE) / TILE_SIZE) - 1;
	    }

	  void cleanup() {
		    // stop animations reset model ect.
		}

	  void startGame(Stage stage) {
		    // initialisation from start method goes here

		  stage.setResizable(false);
          //primaryStage.initStyle(StageStyle.UNDECORATED);
          chess.addObserver(new Observer() {
              @Override
              public void update(Observable o, Object arg) {
                  // update the board when boardchess notify
                  
                    if(chess.moved){
                        if(chess.kill){
                            
                       //  int x1 = x0 + (newX - x0) / 2;
                        // int y1 = y0 + (newY - y0) / 2;
                             result =new MoveResult(MoveType.KILL, board[newX][newY].getPiece());
                        }
                        else{
                             result = new MoveResult(MoveType.NORMAL);
                        }
                    }
                    else{
                       result= new MoveResult(MoveType.NONE);
                    }
                    //----------------------------------
                    
                    
                    switch (result.getType()) {
	                case NONE:
	                    currentP.abortMove();
	                    break;
	                case NORMAL:
	                    currentP.move(newX, newY);
	                    board[x0][y0].setPiece(null);
	                    board[newX][newY].setPiece(currentP);
                            
	                    break;
	                case KILL:
                            Piece otherPiece = result.getPiece();
	                    board[toBoard(otherPiece.getOldX())][toBoard(otherPiece.getOldY())].setPiece(null);
	                    pieceGroup.getChildren().remove(otherPiece);
	                    
                            currentP.move(newX, newY);
	                    board[x0][y0].setPiece(null);
	                    board[newX][newY].setPiece(currentP);
	                    break;
                        default:break;
	            }
                    if(chess.finalmove){
                    	textField.setTextFill(Color.web("#f44242"));
                         affText = null;
                         alert.setHeaderText(player+ " Win");
                         Optional<ButtonType> result1 = alert.showAndWait();
                         if (result1.get() == ButtonType.OK){
                            restart(stagePrim);
                         } else {
                        	 System.exit(0);
                         }
                    }
                    else{
                    if(chess.player==1){
                        player="Black";
                        affText = current + player;
                       
                    }
                    else
                     {
                         player="White";
                        affText = current + player;
                     }
                    }
                    
                     textField.setText(affText);
                     
                     chess.resetStatus();
              }
          });
          
          	MenuBar menuBar = new MenuBar();
  

  // Tạo các Menu
          	Menu fileMenu = new Menu("File");
          	Menu editMenu = new Menu("Edit");
          	Menu helpMenu = new Menu("Help");
 

  // Tạo các MenuItem
          	MenuItem newItem = new MenuItem("New");
          	MenuItem exitItem = new MenuItem("Exit");
 
          	MenuItem undoItem = new MenuItem("Undo");
          
          // Sét đặt phím tắt cho MenuItem Exit.
           exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));

//Thiết lập sự kiện khi người dùng chọn vào Exit.
           exitItem.setOnAction(new EventHandler<ActionEvent>() {

        	   @Override
        	   public void handle(ActionEvent event) {
        		   System.exit(0);
        	   }
           });

  // Thêm các MenuItem vào Menu.
           	fileMenu.getItems().addAll(newItem, exitItem);
           	editMenu.getItems().addAll(undoItem);

  // Thêm các Menu vào MenuBar
           	menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
  
           	BorderPane menu = new BorderPane();
           	menu.setTop(menuBar);
           
           	 // root = createContent();
           	
           	
           textField = new Label("Current: Black");
          
           textField.setFont(Font.font("Cambria", 32));

           HBox container  = new HBox(textField);
               container.setAlignment(Pos.CENTER);
              

              // Set Hgrow for TextField
               HBox.setHgrow(textField, Priority.ALWAYS);

               BorderPane pane = new BorderPane();
                pane.setCenter(container);
//root.autosize();
//Scene scene = new Scene(createContent());
            scene = new Scene(new VBox());
           	((VBox) scene.getRoot()).getChildren().addAll(menu,pane,createContent());
           	((VBox) scene.getRoot()).setAlignment(Pos.CENTER);
            newItem.setOnAction(new EventHandler<ActionEvent>() {

         	   @Override
         	   public void handle(ActionEvent event) {
         		 restart(stage);
         		   //
         	   }
            });

			stage.setTitle("Chess");
			stage.setScene(scene);
			stage.show();
          

		    
		}

		void restart(Stage stage) {
			  ((VBox) scene.getRoot()).getChildren().clear();
     		  board = new Tile[WIDTH][HEIGHT];
     		  tileGroup = new Group();
     		  pieceGroup = new Group();
     		  chess = new Chessgame();
		     startGame(stage);
		    
		}


	@Override
	public void start(Stage primaryStage) {
                        this.stage = primaryStage;
                        // make the windows unresizable
		
		alert.setTitle("Message!");
		alert.setHeaderText(null);
		alert.setContentText("Do you want to play a new game ?");

		

		startGame(this.stage);
 
                     

	}
	
	
	  private Piece makePiece(PieceType type, int x, int y) {
	        Piece piece = new Piece(type, x, y);
	        
	        piece.setOnMouseReleased(e -> {
                    currentP=piece;
                    stagePrim=this.stage;
	            newX = toBoard(piece.getLayoutX());
	            newY = toBoard(piece.getLayoutY());
                    
                    
                    if((newX<0  || newX >8) || (newY<0  || newY >8)){
                         x0 = toBoard(piece.getOldX());
	                 y0 = toBoard(piece.getOldY());
                            piece.abortMove();
                    }
                    else{
                    x0 = toBoard(piece.getOldX());
	            y0 = toBoard(piece.getOldY());
                    
	            //MoveResult result = tryMove(piece, newX, newY);
                  /*  MoveResult result ;
                    
                    chess.move(x0,y0, newX,newY);
                    
                    if(chess.moved){
                        if(chess.kill){
                            result=new MoveResult(MoveType.KILL);
                        }
                        else{
                            result = new MoveResult(MoveType.NORMAL);
                        }
                    }
                    else{
                        result = new MoveResult(MoveType.NONE);
                    }
                    
                    chess.resetStatus();
	            */ // doan nay cua Tu'
                    
                    //------Test------------------------
                        tryMove(piece, newX, newY);
                         /*chess.resetStatus();
                    //----------------------------------
                    
                    
                    switch (result.getType()) {
	                case NONE:
	                    piece.abortMove();
	                    break;
	                case NORMAL:
	                    piece.move(newX, newY);
	                    board[x0][y0].setPiece(null);
	                    board[newX][newY].setPiece(piece);
                            
	                    break;
	                case KILL:
                            Piece otherPiece = result.getPiece();
	                    board[toBoard(otherPiece.getOldX())][toBoard(otherPiece.getOldY())].setPiece(null);
	                    pieceGroup.getChildren().remove(otherPiece);
	                    
                            piece.move(newX, newY);
	                    board[x0][y0].setPiece(null);
	                    board[newX][newY].setPiece(piece);

	                   
	                    break;
	            }
                    if(chess.finalmove){
                    	textField.setTextFill(Color.web("#f44242"));
                         affText = null;
                         alert.setHeaderText(player+ " Win");
                         Optional<ButtonType> result1 = alert.showAndWait();
                         if (result1.get() == ButtonType.OK){
                            restart(this.stage);
                         } else {
                        	 System.exit(0);
                         }
                    }
                    else{
                    if(chess.player==1){
                        player="Black";
                        affText = current + player;
                       
                    }
                    else
                     {
                         player="White";
                        affText = current + player;
                     }
                    }
                    
                     textField.setText(affText);*/
                    }
	        });

	        	return piece;
	  }
	
	public static void main(String[] args) {
		launch(args);
	}
}
