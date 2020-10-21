import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestVariant8 {

    @Test(dataProvider = "integerProvider")
    public void inputTest(int p1, int p3) {
        assertEquals(new Variant8().integerNumbersTask(p1), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][]{{79, 97}, {36, 63}, {31, 13}, {17, 71}, {10, 1}};
    }

    /////////////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void boolTest(int p1, int p2) {
        assertTrue(new Variant8().booleanTask(p1, p2));
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][]{{1379, 97}, {-37, 63}, {31, 11}, {17, -71}, {101, 1}};
    }
    //////////////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(Variant8.fPosition input, Variant8.fPosition output) {
        //assertEquals(new Variant8().ifTask(input.a, input.b), output);
        //input.equals(output);
        assertTrue(new Variant8().ifTask(input.a, input.b).equals(output));
    }

    @DataProvider Object[][] ifProvider() {
        Variant8.fPosition input1 = new Variant8.fPosition(13, 400);
        Variant8.fPosition output1 = new Variant8.fPosition(400, 13);

        Variant8.fPosition input2 = new Variant8.fPosition(20, 20);
        Variant8.fPosition output2 = new Variant8.fPosition(20, 20);

        Variant8.fPosition input3 = new Variant8.fPosition(-52.5f, 90);
        Variant8.fPosition output3 = new Variant8.fPosition(90, -52.5f);

        Variant8.fPosition input4 = new Variant8.fPosition(-9, -4.64f);
        Variant8.fPosition output4 = new Variant8.fPosition(-4.64f, -9);

        Variant8.fPosition input5 = new Variant8.fPosition(-4.8f, -7.6f);
        Variant8.fPosition output5 = new Variant8.fPosition(-4.8f, -7.6f);

        Variant8.fPosition input6 = new Variant8.fPosition(9, -65);
        Variant8.fPosition output6 = new Variant8.fPosition(9, -65);

        return new Object[][]{{input1, output1}, {input2, output2}, {input3, output3}, {input4, output4},
                {input5, output5}, {input6, output6}};
    }

    //////////////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(Variant8.Date input, Variant8.Date output) {
        assertTrue(new Variant8().switchTask(input.day, input.month).equals(output));
    }

    @DataProvider Object[][] switchProvider() {
        Variant8.Date input1 = new Variant8.Date(13, 2);
        Variant8.Date output1 = new Variant8.Date(12, 2);

        Variant8.Date input2 = new Variant8.Date(1, 1);
        Variant8.Date output2 = new Variant8.Date(31, 12);

        Variant8.Date input3 = new Variant8.Date(21, 7);
        Variant8.Date output3 = new Variant8.Date(20, 7);

        Variant8.Date input4 = new Variant8.Date(1, 8);
        Variant8.Date output4 = new Variant8.Date(31, 7);

        Variant8.Date input5 = new Variant8.Date(1, 3);
        Variant8.Date output5 = new Variant8.Date(28, 2);

        Variant8.Date input6 = new Variant8.Date(1, 12);
        Variant8.Date output6 = new Variant8.Date(30, 11);

        return new Object[][]{{input1, output1}, {input2, output2}, {input3, output3}, {input4, output4},
                {input5, output5}, {input6, output6}};
    }
    ////////////////////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int p1, int p2, int p3) {
        assertEquals(new Variant8().forTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][]{{5, 10, 151200}, {-37, -35, -46620}, {-1, 4, 0}, {0, 1, 0}};
    }

    ////////////////////////////////////////////////////////////////

    @Test(dataProvider = "whileProvider")
    public void whileTest(int p1, int p2) {
        assertEquals(new Variant8().whileTask(p1), p2);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][]{{5, 2}, {36, 5}, {100, 9}, {1, 0}};
    }

    ///////////////////////////////////////////////////////////////

    @Test(dataProvider = "minMaxProvider")
    public void minMaxTest(int input, int[] inputArr, Variant8.Position output) {
        assertTrue(new Variant8().minMaxTask(input, inputArr).equals(output));
    }

    @DataProvider Object[][] minMaxProvider() {
        Variant8.Position output1 = new Variant8.Position(0, 4);
        Variant8.Position output2 = new Variant8.Position(1, 6);
        Variant8.Position output3 = new Variant8.Position(2, 3);
        Variant8.Position output4 = new Variant8.Position(0, 4);
        Variant8.Position output5 = new Variant8.Position(3, -1);

        int[] arr1 = new int[] {2, 3, 2, 5, 2};
        int[] arr2 = new int[] {6, 5, 7, 10, 11, 5, 5, 7, 6};
        int[] arr3 = new int[] {5, 5, -3, -3, 3, 0, 2};
        int[] arr4 = new int[] {1, 1, 1, 1, 1};
        int[] arr5 = new int[] {5, 3, 2, 1, 5};

        return new Object[][]{{5, arr1, output1}, {9, arr2, output2}, {7, arr3, output3}, {5, arr4, output4},
                {5, arr5, output5}};
    }
    //////////////////////////////////////////////////////////////
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int[] inputArr, Variant8.ArrayClass output) {
        assertTrue(new Variant8().arrayTask(inputArr).equals(output));
    }

    @DataProvider Object[][] arrayProvider() {
        Variant8.ArrayClass output1 = new Variant8.ArrayClass(4, new int[] {3, 1, 7, 5});
        Variant8.ArrayClass output2 = new Variant8.ArrayClass(3, new int[] {-1, -5, -3});
        Variant8.ArrayClass output3 = new Variant8.ArrayClass(1, new int[] {1});
        Variant8.ArrayClass output4 = new Variant8.ArrayClass(0, new int[] {});

        int[] arr1 = new int[] {2, 3, 4, 1, 7, 4, 5, 6};
        int[] arr2 = new int[] {-1, 2, -4, -5, 6, -3, 10, 8};
        int[] arr3 = new int[] {2, 4, 1, 6, 10};
        int[] arr4 = new int[] {2, 4, 6, 8};

        return new Object[][]{{arr1, output1}, {arr2, output2}, {arr3, output3}, {arr4, output4}};
    }
    ///////////////////////////////////////////////////////

    @Test(dataProvider = "twoDimensionArrayProvider")
    public void twoDimensionArrayTest(int[][] matrix, int k, int n, int m, int[] output) {
        assertEquals(new Variant8().twoDimensionArrayTask(matrix, k, n, m), output);
    }

    @DataProvider
    public Object[][] twoDimensionArrayProvider() {
        int[][] input1 = new int[][] {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, -1},
                {-4, 2, 1, 6, -1},
                {-98, 8, 1, 5, -3}};

        int[][] input2 = new int[][] {{-2, 3, -6, 9, 9},
                {-4, 2, -1, 6, -1},
                {-34, 98, -9, 2, -1},
                {-98, 8, -1, 5, -3}};

        int[][] input3 = new int[][]{{-2, 3, -6, 9, 9},
                {-4, 2, -1, 6, -1},
                {-34, 98, 9, 2, -1},
                {-98, 8, -1, 5, -3}};

        int[][] input4 = new int[][]{{2, 3, -6, 9, 9},
                {-4, 2, -1, 6, -1},
                {-34, 98, 9, 2, -1},
                {-98, 8, -1, 5, -3}};

        int[] output1 = new int[] {6, -9, 1, 1};
        int[] output2 = new int[] {3, 2, 98, 8};
        int[] output3 = new int[] {-2, -4, -34, -98};
        int[] output4 = new int[] {9, -1, -1, -3};

        return new Object[][]{{input1, 2, 5, 4, output1}, {input2, 1, 5, 4, output2},
                {input3, 0, 5, 4, output3}, {input4, 4, 5, 4, output4}};
    }

    @Test(dataProvider = "twoDimensionArrayProviderWrongData")
    public void twoDimensionArrayTestWrongData(int[][] matrix, int k, int n, int m, int[] output) {
        assertEquals(new Variant8().twoDimensionArrayTask(matrix, k, n, m), output);
    }

    @DataProvider
    public Object[][] twoDimensionArrayProviderWrongData() {
        int[][] input1 = new int[][] {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, -1},
                {-4, 2, 1, 6, -1},
                {-98, 8, 1, 5, -3}};

        int[][] input2 = new int[][] {{-2, 3, -6, 9, 9},
                {-4, 2, -1, 6, -1},
                {-34, 98, -9, 2, -1},
                {-98, 8, -1, 5, -3}};

        int[] output = new int[] {0};

        return new Object[][]{{input1,-1, 5, 4, output}, {input2, 5, 5, 4, output}};
    }

}
