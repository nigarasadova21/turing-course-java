package algorithms;

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;        // Matrisin sətir sayı
        int n = matrix[0].length;     // Matrisin sütun sayı

        // İlk sətir və ilk sütunda 0 olub-olmadığını yoxlamaq üçün
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // İlk sətirdə 0 var mı?
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // İlk sütunda 0 var mı?
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Matrisi tərəfləyərək 0-ları işarələ
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Sətirin ilk elementini 0 et
                    matrix[0][j] = 0; // Sütunun ilk elementini 0 et
                }
            }
        }

        // İşarələnən sətirləri 0-la
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // İşarələnən sütunları 0-la
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // İlk sətiri 0-la (əgər lazımdırsa)
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // İlk sütunu 0-la (əgər lazımdırsa)
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        setZeroes(matrix); // Matrisi dəyişdir

        // Dəyişdirilmiş matrisi çap et
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

