
package mmmi.UI.Main.createCase;

import com.jfoenix.controls.JFXTextField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import mmmi.UI.Main.RunFxmlLoader;

/**
 *
 * @author steffeffen Vitten Pedersen
 */
public class NodeFinder {
    List<RadioButton> radioButtonsList;
    Map<String, ToggleGroup> tName;
    Map<String, String> nodeMap = new HashMap<>();

    /**
     *
     * @return
     */
    public Map<String, String> getCaseInvestigation() {
        return nodeMap;
    }

    public Map<String, String> getNodeMap() {
        return nodeMap;
    }

    public void putAllNodeMap(Map<String, String> Map) {
        Map.putAll(this.nodeMap);
    }
    

    /**
     *
     * @param parent
     * This method makes a sleep funktion to allow the program time to load all nodes and then call getAllRadioNodes.
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
     * @param parent
     * @return 
     */
    public Map<String, String> findeNodehandler(Parent parent) {
        getAllNodes(parent);
        for (Map.Entry<String, String> entry : nodeMap.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println(key + "  :  " + val);
        }
        return nodeMap;
    }

    /**
     *
     * @param root
     * @return
     */
    public static ArrayList<Node> getAllRadioNodes(Parent root) {
        ArrayList<Node> n = new ArrayList<>();
        addRadiobutton(root, n);
        return n;
    }

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
     *
     * @param root
     * @return
     */
    public ArrayList<Node> getAllNodes(Parent root) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        addAllDescendents(root, nodes);
        return nodes;
    }

    private void addAllDescendents(Parent parent, ArrayList<Node> nodes) {

        for (Node node : parent.getChildrenUnmodifiable()) {
            nodes.add(node);
            if (node instanceof Parent) {

                if (node instanceof TextArea) {
                    if (!((TextInputControl) node).getText().isEmpty()) {
                        String key = node.getId().substring(5);
                        nodeMap.put(key, ((TextInputControl) node).getText());

                    }
                }
                if (node instanceof JFXTextField) {
                    if (!((TextInputControl) node).getText().isEmpty()) {
                        String key = node.getId().substring(5);
                        nodeMap.put(key, ((TextInputControl) node).getText());

                    }
                }
                if (node instanceof RadioButton) {
                    if (((Toggle) node).isSelected()) {

                        String key = ((RadioButton) node).getId().substring(5, ((RadioButton) node).getId().length() - 1);
                        nodeMap.put(key, ((Labeled) node).getText());

                    }
                }
                addAllDescendents((Parent) node, nodes);
            }

        }

    }

}


