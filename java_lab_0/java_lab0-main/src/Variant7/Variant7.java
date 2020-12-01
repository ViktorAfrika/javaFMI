package Variant7;

import java.util.Arrays;
import java.util.Objects;
public class Variant7 {

    public enum WEIGHT {
        KILOGRAMM, MILLIGRAMM, GRAMM, TON, CENTNER
    }

    public static class Pair<T> {
        private  T a;
        private  T b;

        public Pair(T a, T b) {
            this.a = a;
            this.b = b;
        }

        public T first() {
            return a;
        }
        public T second() {
            return b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair p = (Pair) o;
            return a == p.a && b == p.b;
        }


    }


    /**
     * @param r radius
     * @return circuit, area
     */
    public Pair<Integer> inputOutputTask(int r) {
        assert r > 0 : "r should be more than 0";
        int pi = 3;
        int a = 2 * pi * r;
        int b = pi * r * r;
        Pair rez = new Pair<Integer>(a, b);
        return rez;
    }


    /**
     * @param k
     * @return Find the sum  of its numbers.
     */
    public Pair<Integer> integerNumbersTask(int k) {
        assert k > 0 : "k should be more than 0";
        int a;
        int b;
        int first = k / 10;
        int second = k % 10;
        a = first * second;
        b = first + second;
        Pair rez = new Pair<Integer>(a, b);
        return rez;
    }

//    /**
//     * @param k
//     * @return Find the Mult  of its numbers.
//     */
//    public int integerNumbersTask1(int k) {
//        assert k > 0 : "k should be more than 0";
//        int first = k / 10;
//        int second = k % 10;
//
//        return first * second;
//    }


    /**
     * @param b number between a and c
     * @param c right limit
     * @param a left limit
     * @return The number B is between the numbers A and C”.
     */

    public boolean booleanTask(int b, int c, int a) {

        return (((b > a) && (b < c)) || ((b > c) && (b < a)));
    }


    /**
     * @param t first number
     * @param p second number
     * @return Print the serial number of the smaller of them.
     */
    public int ifTask(int t, int p) {
        if (t <= p)
            return 1;

        return 2;
    }

    /**
     * @param m number of units of mass
     * @return body weight in kilograms
     */
    public float switchTask(float m, WEIGHT n) {
        switch (n) {
            case KILOGRAMM:
                return m;

            case MILLIGRAMM:
                return m / 1000000;

            case GRAMM:
                return m / 1000;

            case TON:
                return m * 1000;

            case CENTNER:
                return m * 100;

            default:
                return 0;

        }

    }


    /**
     * @param a integer number, left limit
     * @param b integer number, right limit
     * @return sum of all integers from A to B inclusive.
     */

    public double forTask(int a, int b) {
        int sum = 0;
        assert a > 0 : "Argument should be more than zero";
        assert a < b : "Argument should be less than b";
        for (int i = a; i < b + 1; i++) {
            sum = sum + i;
        }
        return sum;
    }


    /**
     * @param n integer number
     * @return Find the smallest positive integer K whose square exceeds N: K2> N.
     */

    public int whileTask(int n) {
        int k = 0;
        assert (n > 0) : "Argument should be more than zero";
        while (k * k <= n)
            k++;
        return k;
    }

    /**
     * @param array input array
     * @return reverse array
     */
    public int[] arrayTask(int[] array) {
        int[] revers = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            revers[i] = array[array.length - 1 - i];

        }
        return revers;
    }

    /**
     *
     * @param array matrix
     * @param k matrix row
     * @return k row OF MATRIX
     */
    public int[] twoDimensionArrayTask(int[][] array, int k) {
        return array[k - 1];
    }


}

