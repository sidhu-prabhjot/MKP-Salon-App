package sidhu.graph;

/**
 *
 * @author Prabh
 */
public class ComboItem {
    private String label;
    private int value;

    public ComboItem(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public int getValue() {
        return value;
    }

    //need to create a toString because the combobox uses the toString to create label
    @Override
    public String toString() {
        return label;
    }
}
