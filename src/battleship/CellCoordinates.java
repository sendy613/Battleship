package battleship;

public class CellCoordinates {

	private int x;
	private int y;
	
	public CellCoordinates(Cell cell){
		x = cell.getX();
		y = cell.getY();
	}
	public CellCoordinates getCoord(){
		return this;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
