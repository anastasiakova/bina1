import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PureHeuristicSearch  extends ASearch
{
	// Define lists here ...
	Queue<ASearchNode> open;
	Queue<ASearchNode> closed;
	
	
	@Override
	public String getSolverName() 
	{
		return "PHS";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		open = new PriorityQueue<ASearchNode>(new Comparator<ASearchNode>(){
			@Override
			public int compare(ASearchNode o1, ASearchNode o2) {
				if (o1 instanceof HeuristicSearchNode && o2 instanceof HeuristicSearchNode) {
					HeuristicSearchNode o1H = (HeuristicSearchNode)o1;
					HeuristicSearchNode o2H = (HeuristicSearchNode )o2;
					return Double.compare(o1H.getH(), o2H.getH());
				}
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
		if(open != null) {
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
		return open.size();
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