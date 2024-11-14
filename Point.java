import java.util.*;

public class Point {
    private int x = 0;
    private int y = 0;
    private int z = 0;

    public Point() {
        Scanner sx = new Scanner(System.in);
        try {
            System.out.print("Введите x: ");
            x = sx.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введены некорректные данные! Будет заменено на 0!\n");
        }
        Scanner sy = new Scanner(System.in);
        try {
            System.out.print("Введите y: ");
            y = sy.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введены некорректные данные! Будет заменено на 0!\n");
        }
        Scanner sz = new Scanner(System.in);
        try {
            System.out.print("Введите z: ");
            z = sz.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введены некорректные данные! Будет заменено на 0!\n");
        }
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("{%d;%d;%d}", x, y, z);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getZ() { return z; }
}