 class TilePuzzleHeuristic implements IHeuristic
{
	@Override
	public double getHeuristic
	(
		IProblemState problemState
	) 
	{
		int manhattanDistance = 0;
		if (problemState instanceof TilePuzzleState ) {
			TilePuzzleState tilePuzzleState = (TilePuzzleState)problemState;
			int[][] currentStatus = tilePuzzleState._tilePuzzle;
			for (int y = 0 ; y < currentStatus.length ; y++) {
				for (int x = 0 ; x < currentStatus.length ; x++) {
					if (currentStatus[y][x] != 0) {
						manhattanDistance += currentStatus[y][x] * Math.abs((currentStatus[y][x] - 1)/currentStatus[0].length - y);
						manhattanDistance += currentStatus[y][x] * Math.abs((currentStatus[y][x] - 1)%currentStatus.length - x);
					}
				}
			}
		}
		
		return manhattanDistance;
		
	}
}