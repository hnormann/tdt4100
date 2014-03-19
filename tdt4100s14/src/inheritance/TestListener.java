package inheritance;

import java.util.List;
import java.util.ArrayList;

public class TestListener implements ListListener {

	private List<Comparable> internalList;
	
	public TestListener(HighscoreList list) {
		internalList = new ArrayList<Comparable>();
		updateList(list);
	}
	
	private void updateList(HighscoreList list) {
		internalList.clear();
		for (Comparable a : list) {
			internalList.add(a);
		}
	}
	
	public List getList() {
		return internalList;
	}
	
	@Override
	public void listChanged(AbstractObservableList list, int start, int end) {
		if (list instanceof HighscoreList) {
			updateList( (HighscoreList) list);			
		}
	}
}
