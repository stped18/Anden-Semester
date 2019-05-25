package mmmi.UI.Main.createCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

/**
 *
 * them in a Map< String , String> nodeMap with key = node.getid and value =
 * node.get text
 */
public class NodeFinder {

	List<RadioButton> radioButtonsList;
	Map<String, ToggleGroup> tGroupName;
	Map<String, String> nodeMap = new HashMap<>();
	public Map<String, String> contents = new HashMap<>();
	private Map<String, Map<String, String>> fullContentsMap = new HashMap<>();
	private static NodeFinder nodeFinder;

	/**
	 * 
	 */
	private NodeFinder() {
	}

	/**
	 *
	 * @return
	 */
	public boolean isFullMapEmtpy() {
		return fullContentsMap.isEmpty();
	}

	/**
	 *
	 * @return
	 */
	public Map<String, Map<String, String>> getFullContentsMap() {
		return fullContentsMap;
	}

	/**
	 *
	 * @return
	 */
	public static NodeFinder getInstance() {
		if (nodeFinder == null) {
			nodeFinder = new NodeFinder();
		}
		return nodeFinder;
	}

	/**
	 *
	 * @return
	 */
	public Map<String, String> getContents() {
		return contents;
	}

	/**
	 *
	 * @param contents
	 */
	public void addContents(Map<String, String> contents) {
		this.contents.putAll(contents);
		fullContentsMap.put("caseContents", this.contents);
	}

	/**
	 *
	 * @param map
	 * @param keyString
	 */
	public void addmap(Map<String, String> map, String keyString) {
		fullContentsMap.put(keyString, map);
	}

	/**
	 *
	 * @return
	 */
	public Map<String, String> getNodeMap() {
		return nodeMap;
	}

	/**
	 *
	 * @param nodeMap
	 */
	public void setNodeMap(Map<String, String> nodeMap) {
		this.nodeMap = nodeMap;
	}

	/**
	 *
	 * @param parent This method makes a sleep funktion to allow the program
	 * time to load all nodes and then call getAllRadioNodes().
	 */
	public void runRadioFinder(Parent parent) {

		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
				}
				getAllRadioNodes(parent);
			}
		}.start();
	}

	/**
	 *
	 * This method must be called from the controller where it will store all
	 * nodes in a Map and prints them in the console
	 *
	 * @param parent
	 * @return
	 */
	public Map<String, String> findNodehandler(Parent parent) {
		getAllNodesFromRoot(parent);
		return nodeMap;
	}

	/**
	 * This method find alle nodes and add them tho addTadiobuton.
	 * addRadiobutton sort and find all radioboton and save them in a toggle
	 * groop for a spicifice gruppe of radiobutton.
	 *
	 * @param root
	 * @return
	 */
	public static ArrayList<Node> getAllRadioNodes(Parent root) {
		ArrayList<Node> n = new ArrayList<>();
		addRadiobutton(root, n);
		return n;
	}

	/**
	 * 
	 * @param parent
	 * @param n 
	 */
	private static void addRadiobutton(Parent parent, ArrayList<Node> n) {

		List<RadioButton> radioButtonsList = new ArrayList<>();
		Map<String, ToggleGroup> tName = new HashMap<>();
		for (Node node : parent.getChildrenUnmodifiable()) {
			n.add(node);
			if (node instanceof Parent) {
				if (node instanceof RadioButton) {
					radioButtonsList.add(((RadioButton) node));
				}
				addRadiobutton((Parent) node, n);
			}
		}

		for (RadioButton radioButton : radioButtonsList) {
			String r = radioButton.getId().substring(5, radioButton.getId().length() - 1);
			if (tName.containsKey(r)) {
				radioButton.setToggleGroup(tName.get(r));
			} else {
				tName.put(r, new ToggleGroup());
				radioButton.setToggleGroup(tName.get(r));
			}
		}
	}

	/**
	 * Find all nods in the Parent. and adds them in map.
	 *
	 * @param root
	 * @return
	 */
	public ArrayList<Node> getAllNodesFromRoot(Parent root) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		addAllDescendentsFromNode(root, nodes);
		return nodes;
	}
    
	private void addAllDescendentsFromNode(Parent parent, ArrayList<Node> nodes) {

		for (Node node : parent.getChildrenUnmodifiable()) {
			nodes.add(node);
			if (node instanceof Parent) {
				if (node instanceof TextInputControl) {
					if (!((TextInputControl) node).getText().isEmpty()) {
						String key = node.getId().substring(5);
						nodeMap.put(key, ((TextInputControl) node).getText());
					}
				}
				if (node instanceof RadioButton) {
					if (((Toggle) node).isSelected()) {

						String key = ((RadioButton) node).getId().substring(5, 
                                ((RadioButton) node).getId().length() - 1);
						nodeMap.put(key, ((Labeled) node).getText());
					}
				}
				addAllDescendentsFromNode((Parent) node, nodes);
			}
	    }
	}
}

