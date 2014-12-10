package z.v.qc.lab1a.mtx;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuadraticNumericalMatrixTransformerTests {

    private final QuadraticNumericalMatrixTransformer transformer = new QuadraticNumericalMatrixTransformer();

    @Test (expected = NullPointerException.class)
    public void testZeroingDiagonalsPassingNull() {
        transformer.zeroizeDiagonals(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroingDiagonalsSizeIsEven() {
        Double[][] input = {
                {1.0, 2.0, 3.0},
                {6.0, 6.0},
                {6.9, 7.2, 9.6},
        };
        transformer.zeroizeDiagonals(input, input, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroingDiagonalsWhenMatrixIsRectangular() {
        Double[][] input = {
                {1.0, 2.0, 3.0},
                {6.0, 6.0, 5.6},
                {6.9, 7.2, 9.6},
                {6.9, 7.2, 9.8}
        };
        transformer.zeroizeDiagonals(input, input, 0.0);
    }

    @Test
    public void testZeroingDiagonalsPassingZeroMatrix() {
        Double[][] input = new Double[0][0];
        Double[][] answer = new Double[0][0];
        Double value = 0.0;
        assertArrayEquals(input, transformer.zeroizeDiagonals(input, answer, value));
    }

    @Test
    public void testZeroingDiagonalsPassingRighParameters() {
        Double[][] input = {
                {1.0, 2.0, 3.0, 4.0},
                {6.0, 6.0, 5.0, 10.0},
                {6.0, 7.0, 9.0, 1.0},
                {7.0, 8.0, -2.0, 20.0},
        };
        Double[][] expected = {
                {0.0, 2.0, 3.0, 0.0},
                {6.0, 0.0, 0.0, 10.0},
                {6.0, 0.0, 0.0, 1.0},
                {0.0, 8.0, -2.0, 0.0},
        };
        Double[][] output = transformer.zeroizeDiagonals(input, new Double[4][4], 0.0);
        assertArrayEquals(output, expected);
    }

    @Test (expected = NullPointerException.class)
    public void testChangingSectorsPassingNull() {
        transformer.changeSectors(null, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangingSectorsSizeIsEven() {
        Double[][] input = {
                {1.0, 2.0, 3.0},
                {6.0, 6.0},
                {6.9, 7.2, 9.6},
        };
        transformer.changeSectors(input, input, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangingSectorsWhenMatrixIsRectangular() {
        Double[][] input = {
                {1.0, 2.0, 3.0},
                {6.0, 6.0, 5.6},
                {6.9, 7.2, 9.6},
                {6.9, 7.2, 9.8}
        };
        transformer.changeSectors(input, input, 0.0);
    }

    @Test
    public void testChangingSectorsPassingZeroMatrix() {
        Double[][] input = new Double[0][0];
        Double[][] answer = new Double[0][0];
        assertArrayEquals(input, transformer.changeSectors(input, answer, 0.0));
    }

    @Test
    public void testChangingSectorsPassingRightParameters() {
        Integer[][] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        Integer[][] answer = new Integer[4][4];
        Integer[][] expected = {
                {1, 5, 9, 13},
                {2, 6, 10, 14},
                {3, 7, 11, 15},
                {4, 8, 12, 16},
        };
        Integer[][] output = transformer.changeSectors(input, answer, 0);
        assertArrayEquals(expected, output);
    }
}
