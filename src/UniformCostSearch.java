import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearch   extends ASearch
{
	Queue<ASearchNode> open;
	Queue<ASearchNode> closed;
	
	@Override
	public String getSolverName() 
	{
		return "UCS";
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
		open = new PriorityQueue<ASearchNode>(new Comparator<ASearchNode>(){
			@Override
			public int compare(ASearchNode o1, ASearchNode o2) {
				return Double.compare(o1.getG(), o2.getG()) ;
			}
		});
		closed = new PriorityQueue<ASearchNode>(new Comparator<ASearchNode>(){
			@Override
			public int compare(ASearchNode o1, ASearchNode o2) {
				return Double.compare(o1.getG(), o2.getG()) ;
			}
		});
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		if(isOpen(node)) {
			return node;
		}
		return null;
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	) 
	{
		if(open != null) {
			return open.contains(node);
		}
		return false;
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		if(closed != null) {
			return closed.contains(node);
		}
		return false;
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
		if(open != null) {
			return open.size();
		}
		return 0;
	}

	@Override
	public ASearchNode getBest() 
	{
		if(open != null) {
			return open.remove();
		}
		return null;
	}

}
