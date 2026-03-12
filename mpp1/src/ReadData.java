import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
    public static List<Point> readData(String fileName) {
        List<Point> points = new ArrayList<>();
        String filePath = "/Users/karo/Desktop/Ćwiczenia 1 - kNN/" + fileName;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                double[] values = new double[parts.length-1];
                for(int i = 0; i < parts.length-1; i++){
                    values[i] = Double.parseDouble(parts[i]);
                }
                String label = parts[parts.length-1];

                Point point = new Point(values, label);
                points.add(point);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return points;
    }
}