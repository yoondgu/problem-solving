import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] temp;
    static int count = 0;
    static int result = -1;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] sizeAndCount = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(sizeAndCount[0]);
        K = Integer.parseInt(sizeAndCount[1]);
        temp = new int[N];

        String[] numbersInput = bufferedReader.readLine().split(" ");
        int[] numbers = Arrays.stream(numbersInput)
                .mapToInt(Integer::parseInt)
                .toArray();

        mergeSort(numbers, 0, numbers.length - 1);
        System.out.println(result);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        int tempIndex = 0;

        // arr 배열에서 양쪽으로 분할하여 비교 -> 작은 쪽을 temp에 저장하기를 반복한다.
        while (leftIndex <= mid && rightIndex <= end) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[tempIndex++] = arr[leftIndex++];
            } else {
                temp[tempIndex++] = arr[rightIndex++];
            }
        }

        // 왼쪽, 오른쪽 배열의 부분이 남은 경우 temp에 저장한다.
        while (leftIndex <= mid) {
            temp[tempIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[tempIndex++] = arr[rightIndex++];
        }

        // temp에 저장한 결과를 배열에 저장한다.
        leftIndex = start;
        tempIndex = 0;
        while (leftIndex <= end) {
            // K번째 저장되는 수를 찾기 위해 count값을 증가시킨다.
            count++;
            if (count == K) {
                result = temp[tempIndex];
                break;
            }
            arr[leftIndex++] = temp[tempIndex++];
        }
    }
}
