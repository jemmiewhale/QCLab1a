package z.v.qc.lab1a.mtx;

public class QuadraticNumericalMatrixTransformer {

    private <T extends Number> void  verificateInput(T[][] inputMatrix, T[][] answer, T value) {
        if (inputMatrix == null) {
            throw new NullPointerException();
        }

        if (answer == null) {
            throw new NullPointerException();
        }

        if (value == null) {
            throw new NullPointerException();
        }

        for (T[] r : inputMatrix) {
            if (inputMatrix.length != r.length) {
                throw new IllegalArgumentException();
            }
        }

        for (T[] r : answer) {
            if (answer.length != r.length) {
                throw new IllegalArgumentException();
            }
        }

        if (inputMatrix.length != answer.length) {
            throw new IllegalArgumentException();
        }
    }

    private <T extends Number> T[][] copyMatrix(T[][] inputMatrix, T[][] answer) {
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix.length; j++) {
                answer[i][j] = inputMatrix[i][j];
            }
        }
        return answer;
    }

    public <T extends Number>  T[][] zeroizeDiagonals(T[][] inputMatrix, T[][] answer, T value) {

        verificateInput(inputMatrix, answer, value);

        copyMatrix(inputMatrix, answer);

        for (int i = 0; i < answer.length; i++) {
            answer[i][i] = value;
            answer[answer.length - i - 1][i] = value;
        }

        return answer;
    }

    public <T extends Number>  T[][] changeSectors(T[][] inputMatrix, T[][] answer, T value) {

        verificateInput(inputMatrix, answer, value);

        copyMatrix(inputMatrix, answer);

        for (int i = 0; i < answer.length; i++) {

            for (int j = i + 1; j < answer.length; j++) {
                answer[i][j] = inputMatrix[j][i];
                answer[j][i] = inputMatrix[i][j];
            }
        }

        return answer;
    }

}

