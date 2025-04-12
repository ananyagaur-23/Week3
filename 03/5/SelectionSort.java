public class SelectionSort {
    public static void sortExamScores(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] examScores = {88, 73, 92, 60, 81, 77};
        sortExamScores(examScores);

        System.out.print("Sorted Exam Scores: ");
        for (int score : examScores) {
            System.out.print(score + " ");
        }
    }
}
