package TestVariant7;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Variant7.Variant7;
import Variant7.Variant7.WEIGHT;

public class TestVariant7 {

    public static double EPS = 0.0000001;


    @Test(dataProvider = "inputOutputProvider")
    public void inputOutputTest(int p1, Variant7.Pair<Integer> p) {
        assertEquals(new Variant7().inputOutputTask(p1), p);
    }

    @DataProvider
    public Object[][] inputOutputProvider() {
        Variant7.Pair pair1 = new Variant7.Pair(6, 3);
        Variant7.Pair pair2 = new Variant7.Pair(12,12);
        return new Object[][]{{1, pair1}, {2, pair2}};
    }

    ////////////////////////////////////////////

    @Test(dataProvider = "integerNumbersProvider")
    public void integerNumbersTest(int p1, Variant7.Pair<Integer> p) {
        assertEquals(new Variant7().integerNumbersTask(p1), p);
    }

    @DataProvider
    public Object[][] integerNumbersProvider() {
        Variant7.Pair pair1 = new Variant7.Pair(2, 3);
        Variant7.Pair pair2 = new Variant7.Pair(4, 5);
        return new Object[][]{{12, pair1}, {41, pair2}};
    }



    ////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int p3) { assertEquals(new Variant7().ifTask(p1,p2),p3); }
    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 2, 3,1 }, { 0, 0 ,1}, { 3, -3,2 } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1,int p2,int p3, boolean p4) {
        assertEquals(new Variant7().booleanTask(p1,p2,p3),p4);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 5,3,6,true }, { 4,7,8, false }, { -3,12,9, false } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(float p1, Variant7.WEIGHT p2, float p3) {
        assertEquals(new Variant7().switchTask(p1,p2), p3);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 3, WEIGHT.KILOGRAMM,3 }, { 6, WEIGHT.CENTNER,600 } };
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int n,int m , double p2) {
        assertEquals(new Variant7().forTask(n,m), p2);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { { 3,6, 18 }, { 7,10,34 }, { 12,19,124} };
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "whileProvider")
    public void whileTest(int a, int b) {
        assertEquals(new Variant7().whileTask(a),b );
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 10, 4 }, { 24,5 }, { 63, 8 }, { 25, 6 } };
    }
    ///////////////////////////////////////////////////

    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int[] array, int []arr) {
        assertEquals(new Variant7().arrayTask(array), arr);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        int [] input13= { 10, 2, 3,5,9,8,7,1,0,4 };
        int[]input133= {4,0,1,7,8,9, 5,3,2,10 };

        return new Object[][] { { input13, input133}};
    }

    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, int elem, int[] output) {
        assertEquals(new Variant7().twoDimensionArrayTask(input, elem), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input1 = {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, 1},
                {-4, 2, 1, 6, 1},
                {-98, 8, 1, 5, 3}};

        int [][]input2= { {1,2,4,5,7},
                {5,8,2,1,2},
                {1,5,7,9,9},
                {7,5,1,7,1}};

        int[] input11 =  {34, 98, -9, 2, 1};
        int[] input22 =  {7,5,1,7,1};

        return new Object[][] { {input1, 2,  input11}, { input2, 4, input22 } };

    }


}
