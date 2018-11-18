import java.util.Dictionary;
import java.util.Hashtable;

public class TilePuzzleHeuristic implements IHeuristic
{
	Dictionary< Integer, MyPair > positionsThreeByThree;
	Dictionary< Integer, MyPair> positionsFourByFour;
	
	public TilePuzzleHeuristic() {
		positionsThreeByThree = new Hashtable< Integer, MyPair>();
		/*positionsThreeByThree.put(1, new MyPair(0, 0));
		positionsThreeByThree.put(2, new MyPair(1, 0));
		positionsThreeByThree.put(3, new MyPair(2, 0));
		
		positionsThreeByThree.put(4, new MyPair(0, 1));
		positionsThreeByThree.put(5, new MyPair(1, 1));
		positionsThreeByThree.put(6, new MyPair(2, 1));
		
		positionsThreeByThree.put(7, new MyPair(0, 2));
		positionsThreeByThree.put(8, new MyPair(1, 2));*/
		
		positionsFourByFour = new Hashtable< Integer, MyPair>();
		/*positionsThreeByThree.put(1, new MyPair(0, 0));
		positionsThreeByThree.put(2, new MyPair(1, 0));
		positionsThreeByThree.put(3, new MyPair(2, 0));
		positionsThreeByThree.put(4, new MyPair(3, 0));
		
		positionsThreeByThree.put(5, new MyPair(0, 1));
		positionsThreeByThree.put(6, new MyPair(1, 1));
		positionsThreeByThree.put(7, new MyPair(2, 1));
		positionsThreeByThree.put(8, new MyPair(3, 1));
		
		positionsThreeByThree.put(9, new MyPair(0, 2));
		positionsThreeByThree.put(10, new MyPair(1, 2));
		positionsThreeByThree.put(11, new MyPair(2, 2));
		positionsThreeByThree.put(12, new MyPair(3, 2));
		
		positionsThreeByThree.put(13, new MyPair(0, 3));
		positionsThreeByThree.put(14, new MyPair(1, 3));
		positionsThreeByThree.put(15, new MyPair(2, 3));*/

	}

	@Override
	public double getHeuristic
	(
		IProblemState problemState
	) 
	{
		int manhattanDistance = 0;
		//problemState.getStateLastMove().
		if (problemState instanceof TilePuzzleState ) {
			TilePuzzleState tilePuzzleState = (TilePuzzleState)problemState;
			int[][] currentStatus = tilePuzzleState._tilePuzzle;
			//tilePuzzleState._lastMove.
			
			
			if (currentStatus.length == 3) {
				for (int y = 0 ; y < currentStatus.length ; y++) {
					for (int x = 0 ; x < currentStatus.length ; x++) {
						int nu = currentStatus[y][x];
						if (currentStatus[y][x] != 0) {
							manhattanDistance += Math.abs(currentStatus[y][x]/3 - y);
							manhattanDistance += Math.abs(currentStatus[y][x]%3 - x) - 1;
						}
					}
				}
			} else if (currentStatus.length == 4) {
				for (int x = 0 ; x < currentStatus.length ; x++) {
					for (int y = 0 ; y < currentStatus.length ; y++) {
						if (currentStatus[x][y] != 0) {
							manhattanDistance += Math.abs(positionsFourByFour.get(currentStatus[x][y]).getX() - y);
							manhattanDistance += Math.abs(positionsFourByFour.get(currentStatus[x][y]).getY() - x);
						}
					}
				}					
			}
		}
		
		return manhattanDistance;
		
	}
}

class MyPair{
	private int x;
	private int y;
	
	public MyPair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
