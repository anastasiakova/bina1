import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
	private Queue<ASearchNode> open;
	private Queue<ASearchNode> closed;
	
	@Override
	public String getSolverName() 
	{
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		open = new LinkedBlockingQueue<ASearchNode>();
		closed = new LinkedBlockingQueue<ASearchNode>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		if(isOpen(node)){
			return node;//to-do
		}
		return null;
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	) 
	{
		return open.contains(node);
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		return closed.contains(node);
	}

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{
		open.add(node);
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
		closed.add(node);
	}

	@Override
	public int openSize() 
	{
		if(open != null){
			return open.size();
		}
		return 0;
	}

	@Override
	public ASearchNode getBest() 
	{
		return open.poll();
	}

	

}
