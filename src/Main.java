import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Matrix matr1 = new Matrix(4, 4);
        matr1.initM();
        matr1.printM();
        System.out.println();
        Matrix matr2 = new Matrix(4, 4);
        matr2.initM();
        matr2.printM();
        System.out.println();

        (Matrix.sum(matr1, matr2)).printM(); //сложение матриц
        System.out.println();
        Matrix.multiM(matr1, matr2).printM(); //умножение
        System.out.println();
        Matrix.transM(matr1).printM(); //транспонирование
        System.out.println();
        Matrix.detM(matr1.getArr(), matr1.m, matr1.n).printC(); //детерминант

    }
}