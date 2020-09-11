package lab14;

package ua.khpi.oop.osetrov14;

public class MainClass {

    public static void main(String[] args) {
        try {
            Helper.starter(args);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }
}