package Programs.Sorting;

import java.util.Arrays;

public class MergeSort extends BaseClass{

    // Constructors

    public MergeSort() {
        this.testID = totalTest;
        this.testCases = 0;
        this.keyCompare = new long[50];
        this.timeTaken = new long[50];
        totalTest++;
    }

    public MergeSort(int maxCases) {
        this.testID = totalTest;
        this.testCases = 0;
        this.keyCompare = new long[maxCases];
        this.timeTaken = new long[maxCases];
        totalTest++;
    }

    // Methods

    public void printDetails() {
        System.out.println("Merge Sort");
        System.out.println("testID: " + this.testID + " testCases: " + this.testCases);
        for (int i = 0; i < this.testCases; i++) {
            System.out.println("MSort Case " + i + ": KeyCompare-" + this.keyCompare[i]+ " timeTaken-" + this.timeTaken[i]);
        }
    }

    public void runTest(int[] array){
        long startTime = System.currentTimeMillis();
        int[] answer = mergeSort(array);

        for (int i = 0; i < answer.length-1;i++) {
            if (answer[i] > answer[i+1]) {
                System.out.println("Fail");
                return;
            }
        }
        //System.out.println(Arrays.toString(answer));
        this.timeTaken[this.testCases] = System.currentTimeMillis() - startTime;
        //System.out.println(System.currentTimeMillis() - startTime);
        System.out.println("MSort Case " + this.testCases + ": KeyCompare-" + this.keyCompare[this.testCases]+ " timeTaken-" + this.timeTaken[this.testCases]);
        this.testCases++;
    }

    public void printAverage() {
        double keyTotal = 0, timeTotal = 0;
        for (int i = 0; i < this.testCases; i++){
            keyTotal += this.keyCompare[i];
            timeTotal += this.timeTaken[i];
        }
        System.out.println("------------------------------");
        System.out.println("MergeSort ID: " + this.testID);
        System.out.println("Average Comparison: " + (long)(keyTotal/this.testCases));
        System.out.println("Average Time Taken: " + (timeTotal/this.testCases));
        System.out.println("------------------------------");
    }

    private int[] mergeSort(int[] array){
        // Base Case
        if (array.length == 1) return array;

        int[] returnArray = new int[array.length];

        // Divide and Conquer
        int[] leftRecursion = mergeSort(Arrays.copyOfRange(array,0,array.length/2));
        int[] rightRecursion = mergeSort(Arrays.copyOfRange(array,array.length/2,array.length));

        // Merging
        int left = 0, right = 0, index = 0;
        while (left < leftRecursion.length && right<rightRecursion.length) {
            if (leftRecursion[left] == rightRecursion[right]) {
                returnArray[index++] = leftRecursion[left++];
                returnArray[index++] = rightRecursion[right++];
                this.keyCompare[this.testCases]++; // Considered 1 Key comparison?
            }
            else if (leftRecursion[left] < rightRecursion[right]) {
                returnArray[index++] = leftRecursion[left++];
                this.keyCompare[this.testCases]++; // Incrementing the key compare count
            } else {
                returnArray[index++] = rightRecursion[right++];
                this.keyCompare[this.testCases]++; // Incrementing the key compare count
            }
        }
        // Merging when 1 array is emptied
        if (right < rightRecursion.length){
            while (right < rightRecursion.length){
                returnArray[index++] = rightRecursion[right++];
            }
        } else {
            while (left < leftRecursion.length){
                returnArray[index++] = leftRecursion[left++];
            }
        }
        return returnArray;
    }
}
