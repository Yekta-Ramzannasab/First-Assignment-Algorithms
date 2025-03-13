import java.util.ArrayList;
import java.util.List;


public class Exercises {

    public int[] productIndices(int[] values, int target) {

        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i]*values[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    public int[] spiralTraversal(int[][] values, int rows, int cols) {
        if (values == null || rows == 0 || cols == 0)
            return null;
        if (values.length == 0 || values[0].length == 0)
            return null;
        int[] result = new int[rows * cols];
        int index = 0;

        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                result[index++] = values[top][j]; // left to right
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result[index++] = values[i][right]; // top to bottom
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result[index++] = values[bottom][j]; // right to left
                }
                bottom--;
            }


            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[index++] = values[i][left]; // bottom to
                    // top
                }
                left++;
            }
        }
        return result;
    }


    public int[][] intPartitions(int n) {
        if (n <= 0) {
            return null;
        }

        List<List<Integer>> partitions = generatePartitions(n);
        int[][] result = new int[partitions.size()][];
        for (int i = 0; i < partitions.size(); i++) {
            List<Integer> partition = partitions.get(i);
            result[i] = new int[partition.size()];
            for (int j = 0; j < partition.size(); j++) {
                result[i][j] = partition.get(j);
            }
        }
        return result;
    }

    private static List<List<Integer>> generatePartitions(int n) {
        List<List<Integer>> result = new ArrayList<>();
        generatePartitions(n, n, new ArrayList<>(), result);
        return result;
    }

    private static void generatePartitions(int n, int max, List<Integer> current, List<List<Integer>> result) {
        if (n == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = Math.min(max, n); i >= 1; i--) {
            current.add(i);
            generatePartitions(n - i, i, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
