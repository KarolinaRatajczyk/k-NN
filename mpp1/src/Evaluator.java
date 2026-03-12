import java.util.*;

public class Evaluator {
    //    KNN knn;
    List<Point> training;
    List<Point> testData;

    public Evaluator(String trainingFile, String testFile) {
        this.training = ReadData.readData(trainingFile);
        this.testData = ReadData.readData(testFile);
    }

//    public void setKNN(KNN knn) {
//        this.knn = knn;
//    }

    public void evaluate() {
        Set<String> classSet = new HashSet<String>();
        for (Point point : testData) {
            classSet.add(point.label);
        }

        List<String> classList = new ArrayList<String>(classSet);
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < classList.size(); i++) {
            indexMap.put(classList.get(i), i);
        }

        int numberOfClasses = classSet.size();
        int[][] macierzPomylek = new int[numberOfClasses][numberOfClasses];

        for (Point point : testData) {
            String rzeczywiste = point.label;
            String przewidziane = KNN.knn(training, point, 1);

            int rzeczywistyIndex = indexMap.get(rzeczywiste);
            int przewidzianyIndex = indexMap.get(przewidziane);

            macierzPomylek[rzeczywistyIndex][przewidzianyIndex]++;
        }
        printMacierzPomylek(macierzPomylek, classList);
    }

    public void printMacierzPomylek(int[][] macierzPomylek, List<String> classList) {
        int maxLength = classList.stream().mapToInt(String::length).max().orElse(0);

        System.out.println("Macierz Pomylek:");

        System.out.print(" ".repeat(maxLength + 1));
        for (String label : classList) {
            System.out.printf("%-" + (maxLength + 2) + "s", label);  //wyrównanie tekstu do lewej z szerokością maxLenght
        }
        System.out.println();

        for (int i = 0; i < macierzPomylek.length; i++) {
            System.out.printf("%-" + (maxLength + 2) + "s", classList.get(i));

            for (int j = 0; j < macierzPomylek[i].length; j++) {
                ///wyrównanie liczb w kolumnach
                System.out.printf("%" + (maxLength - 3) + "d", macierzPomylek[i][j]);
            }
            System.out.println();
        }
    }
}