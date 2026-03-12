public class Point {
    public double[] values;
    public String label;

    public Point(double[] values, String label) {
        this.values = values;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String toString() {
        String tab = "[";
        for(int i = 0; i < values.length; i++) {
            tab += values[i] + ", ";
        }
        tab += "]";
        return tab + "  label: " + label;
    }
}