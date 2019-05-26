package mmmi.UI.Main.CreateCase;

import java.util.Map;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class RadioButtonChangeListener {

    private ToggleGroup toggleGroup;
    private String outputText;
    private static RadioButtonChangeListener rbcl;
    private Map<Integer, String> contentsOfToggels;
    private static Integer count = 0;

    public RadioButtonChangeListener() {

    }

    public static RadioButtonChangeListener getInstance() {
        if (rbcl == null) {
            rbcl = new RadioButtonChangeListener();
        }
        return rbcl;
    }

    public ToggleGroup getToggleGroup() {
        return toggleGroup;
    }

    public void setToggleGroup(ToggleGroup toggleGroup) {
        this.toggleGroup = toggleGroup;
    }

    public String getOutputText() {
        return outputText;
    }

    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }

    public Map<Integer, String> radionButtonChangeListener() {

        this.toggleGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
            RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
            outputText = rb.getText();
            contentsOfToggels.put(count, outputText);

        });
        count++;
        return contentsOfToggels;
    }

    public Map<Integer, String> getContentsOfToggels() {
        return contentsOfToggels;
    }

}
