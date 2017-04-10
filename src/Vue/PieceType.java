package application;

public enum PieceType {
	
	BLACK_CASTLE(1),BLACK_HORSE(2),BLACK_BISHOP(3)
	 ,BLACK_KING(4),BLACK_QUEEN(5),BLACK_PAWN(6),
	 WHITE_CASTLE(-1),WHITE_HORSE(-2),WHITE_BISHOP(-3)
	 ,WHITE_KING(-4),WHITE_QUEEN(-5),WHITE_PAWN(-6);
    
	final int moveDir;

    PieceType(int moveDir) {
        this.moveDir = moveDir;
    }
	
}
