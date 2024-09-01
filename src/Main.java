import Programs.Randomizer;
import Programs.Sorting.BaseClass;
import Programs.Sorting.InsertionSort;
import Programs.Sorting.MergeInsertSort;
import Programs.Sorting.MergeSort;

import java.util.*;

public  class Main {
    public static void main(String[] args) {
//        int test = 0;
//
//        long start = System.currentTimeMillis();
//        long end = System.currentTimeMillis();
//        System.out.println(start);
//        System.out.println(end);
//        System.out.println(end-start);

//        int[] array = {1,2,5,7,38,4,7,9,2,43,6,53,2};
//        int[] leftRecursion = Arrays.copyOfRange(array,0,array.length/2);
//        int[] rightRecursion =Arrays.copyOfRange(array,array.length/2,array.length );
//        System.out.println(array.length);
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(leftRecursion));
//        System.out.println(Arrays.toString(rightRecursion));

        // Random Distinct
//        List<Integer> Data2 = new ArrayList<>();
//        for (int i = 0; i < 100000; i++){
//            Data2.add(i);
//        }
//        Collections.shuffle(Data2);
//        int[] Data3 = new int[100000];
//        for (int i = 0; i < 100000; i++){
//            Data3[i] = Data2.get(i);
//        }

        // Random Non-distinct
        //Data3 = Randomizer.randomArray(10,100);

        // MergeSort Testing

//        MergeSort test1 = new MergeSort();
//        test1.runTest(Arrays.copyOf(Data3,Data3.length));
//        test1.runTest(new int[] {1,4,3,2});
//        System.out.println(Arrays.toString(Data3));

        // InsertionSort Testing

//        InsertionSort test2 = new InsertionSort();
//        test2.runTest(Arrays.copyOf(Data3,Data3.length));
//        test2.runTest(new int[] {4,3,2,1});

        // MergeInsertionSort Testing

//        MergeInsertSort test3 = new MergeInsertSort(8);
//        test3.runTest(Arrays.copyOf(Data3,Data3.length));

        // Multiple Testing
        BaseClass[] TestObjects = new BaseClass[3];
        TestObjects[0] = new MergeSort();
        TestObjects[1] = new MergeInsertSort(8);
        TestObjects[2] = new MergeInsertSort(16);

        for (int i = 0; i < 10; i++) {
            List<Integer> Data2 = new ArrayList<>();
            for (int j = 0; j < 10000000; j++){
                Data2.add(i);
            }
            Collections.shuffle(Data2);
            int[] Data3 = new int[10000000];
            for (int j = 0; j < 10000000; j++){
                Data3[i] = Data2.get(i);
            }

            for (BaseClass o: TestObjects) {
                o.runTest(Arrays.copyOf(Data3,Data3.length));
            }
        }
        for (BaseClass o: TestObjects) {
            o.printAverage();
        }
    }
}