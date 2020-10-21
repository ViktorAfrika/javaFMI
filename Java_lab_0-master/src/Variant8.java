public class Variant8 {

    public static class Date {
        public int day;
        public int month;

        public Date(int day, int month) {
            this.day = day;
            this.month = month;
        }

        public boolean equals(Date date) {
            return this.day == date.day && this.month == date.month;
        }
    }

    public static class Position {
        public int a;
        public int b;

        public Position(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public boolean equals(Position numbers) {
            return this.a == numbers.a && this.b == numbers.b;
        }
    }

    public static class fPosition {
        public double a;
        public double b;

        public fPosition(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public boolean equals(fPosition numbers) {
            return this.a == numbers.a && this.b == numbers.b;
        }
    }

    public static class ArrayClass {
        public int count;
        public int[] array;

        public ArrayClass(int count, int[] array) {
            this.count = count;
            this.array = new int[this.count];
            if (this.count >= 0)
                System.arraycopy(array, 0, this.array, 0, this.count);
        }

        public boolean equals(ArrayClass elem) {
            if (this.count == elem.count) {
                for (int i = 0; i < this.array.length && i < elem.array.length; i++) {
                    if (this.array[i] != elem.array[i])
                        return false;
                }
                return true;
            }
            return false;
        }
    }

    public int integerNumbersTask(int k) {
        int number = k % 10;
        k /= 10;
        number *= 10;
        number += k;
        return number;
    }

    public boolean booleanTask(int a, int b) {

        return Math.abs(a) % 2 == 1 && Math.abs(b) % 2 == 1;
    }

    public fPosition ifTask(double a, double b) {
        if (a >= b) {
            return new fPosition(a, b);
        }
        else {
            return new fPosition(b, a);
        }
    }

    public Date switchTask(int day, int month) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                if (day > 1) {
                    day -= 1;
                }
                else if (day == 1 && month > 1) {
                    if (month == 3) {
                        day = 28;
                    }
                    else if (month == 8) {
                        day = 31;
                    }
                    else {
                        day = 30;
                    }
                    month -= 1;
                }
                else if (day == 1) {
                    day = 31;
                    month = 12;
                }
                break;
            case 2, 4, 6, 9, 11:
                if (day > 1) {
                    day -= 1;
                }
                else {
                    day = 31;
                    month -= 1;
                }
                break;
        }
        return new Date(day, month);
    }

    public int forTask(int a, int b) {
        int res = 1;
        for (int i = a; i <= b; i++ ) {
            res *= i;
        }
        return res;
    }

    public int whileTask(int n) {
        int k = 0;
        while (k * k < n) {
            k++;
        }
        return k - 1;
    }

    public Position minMaxTask(int n, int[] mas) {
        int min = mas[0];
        int start = -1;
        int end = -1;
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] < min) {
                min = mas[i];
            }
        }
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == min && start == -1) {
                start = i;
            }
            else if (mas[i] == min) {
                end = i;
            }
        }
        return new Position(start, end);
    }

    public ArrayClass arrayTask(int[] array) {
        int k = 0;
        int[] result = new int[array.length];
        for (int j : array) {
            if (Math.abs(j % 2) == 1) {
                result[k] = j;
                k++;
            }
        }
        return new ArrayClass(k, result);
    }

    public int[] twoDimensionArrayTask(int[][] array, int k, int n, int m) {
        if (k < 0 || k > n - 1) {
            return new int[] {0};
        }
        int[] result = new int[m];
        for(int i = 0; i < m; i++) {
            result[i] = array[i][k];
        }
        return result;
    }
}
