import java.util.*;

public class KNN {
    public static String knn(List<Point> training, Point target, int k) {
        List<Map.Entry<Double, String>> distances = new ArrayList<>();
        for (Point p : training) {
            double dist = LinAlg.odlegloscEuklidesowaMiedzyWektorami(p.values, target.values);
            distances.add(new AbstractMap.SimpleEntry<>(dist, p.label));
        }

        distances.sort(Map.Entry.comparingByKey());

        List<String> labels = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            labels.add(distances.get(i).getValue());
        }

        String mostCommonLabel = labels.getFirst();
        int maxCount = 0;
        for (String label : labels) {
            int count = Collections.frequency(labels, label);
            if (count > maxCount) {
                maxCount = count;
                mostCommonLabel = label;
            }
        }

        return mostCommonLabel;
    }
}