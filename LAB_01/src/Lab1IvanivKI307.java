import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab1IvanivKI307 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитування розміру квадратної матриці
        System.out.print("Введіть розмір квадратної матриці: ");
        int matrixSize = scanner.nextInt();

        // Перевірка на коректність розміру матриці
        if (matrixSize <= 0) {
            System.out.println("Некоректний розмір матриці.");
            return;
        }

        // Зчитування символу-заповнювача
        System.out.print("Введіть символ-заповнювач: ");
        String fillSymbol = scanner.next();

        // Перевірка на коректність символу-заповнювача
        if (fillSymbol.length() != 1) {
            System.out.println("Некоректний символ-заповнювач.");
            return;
        }

        // Генерування та заповнення зубчатого масиву
        char[][] jaggedArray = new char[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize - i; j++) {
                jaggedArray[i][j] = fillSymbol.charAt(0);
            }
        }

        // Виведення масиву на екран
        System.out.println("Зубчатий масив:");
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (j < matrixSize - i) {
                    System.out.print(jaggedArray[i][j]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // Запис масиву у текстовий файл
        try (FileWriter fileWriter = new FileWriter("output.txt")) {
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    if (j < matrixSize - i) {
                        fileWriter.write(jaggedArray[i][j]);
                    } else {
                        fileWriter.write(" ");
                    }
                }
                fileWriter.write("\n");
            }
            System.out.println("Масив записано в файл 'output.txt'.");
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл.");
        }
    }
}



