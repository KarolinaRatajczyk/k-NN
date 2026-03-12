import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Point> training = ReadData.readData("iris.train.data");
        List<Point> testing = ReadData.readData("iris.test.data");

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        ;
        System.out.println("Podaj k: ");
        int k = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Wyniki przewidywań dla zbioru testowego: ");
        int counter = 1;
        for (Point p : testing) {
            String nazwa;
            nazwa = KNN.knn(training, p, k);
            System.out.println(counter + ": " + nazwa);
            counter++;
        }

        System.out.println("\nEwaluacja: ");
        Evaluator evaluator = new Evaluator("iris.train.data", "iris.test.data");
        evaluator.evaluate();




        while (true) {
            System.out.println("Podaj wektor odpowiedniej długości (lub 'exit' aby zakończyć): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Program zakończył działanie.");
                break;
            }
            String[] parts = input.split("\\s+"); //wielokrotne spacje
            double[] values = new double[parts.length];

            System.out.println("Podaj k: ");
            int parametr = scanner.nextInt();
            scanner.nextLine();

            try {
                for (int i = 0; i < parts.length; i++) {
                    values[i] = Double.parseDouble(parts[i]);
                }

                Point userPoint = new Point(values, "unknown");

                String predict = KNN.knn(training, userPoint, parametr);
                System.out.println("Przewidziana nazwa dla podanego wektora: " + predict + "\n");
            } catch (NumberFormatException e){
                System.out.println("Podaj poprawne wartości liczbowe.");
            }
        }
        scanner.close();
    }
}