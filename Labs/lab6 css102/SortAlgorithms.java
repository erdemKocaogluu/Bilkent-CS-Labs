import java.util.Random;

public class SortAlgorithms {

    public static <T extends Comparable<T>> void bubbleSort(T[] dataSequence) {
        int size = dataSequence.length;
        boolean devam = true;

        for (int i = 0; i < size - 1 && devam; i++) {
            boolean degistiMi = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (dataSequence[j].compareTo(dataSequence[j + 1]) > 0) {
                    swapElements(dataSequence, j, j + 1);
                    degistiMi = true;
                }
            }
            if (!degistiMi) {
                devam = false;
            }
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] dataSequence) {
        int size = dataSequence.length;
        if (size < 2) {
            return;
        } 
            
        int midPoint = size / 2;

        T[] leftSide = (T[]) (new Comparable[midPoint]);
        T[] rightSide = (T[]) (new Comparable[size - midPoint]);

        for (int i = 0; i < midPoint; i++) {
            leftSide[i] = dataSequence[i];
        }
        for (int i = 0; i < size - midPoint; i++) {
            rightSide[i] = dataSequence[i + midPoint];
        }

        mergeSort(leftSide);
        mergeSort(rightSide);
        mergeAndConquer(dataSequence, leftSide, rightSide);
    }

    private static <T extends Comparable<T>> void mergeAndConquer(T[] target, T[] left, T[] right) {
        int lIdx = 0;
        int rIdx = 0;
        int tIdx = 0;

        while (lIdx < left.length && rIdx < right.length) {
            if (left[lIdx].compareTo(right[rIdx]) <= 0) {
                target[tIdx] = left[lIdx];
                lIdx++;
            } else {
                target[tIdx] = right[rIdx];
                rIdx++;
            }
            tIdx++;
        }

        while (lIdx < left.length) {
            target[tIdx] = left[lIdx];
            lIdx++;
            tIdx++;
        }
        
        while (rIdx < right.length) {
            target[tIdx] = right[rIdx];
            rIdx++;
            tIdx++;
        }
    }

    public static <T extends Comparable<T>> void quickSortStandard(T[] arr) {
        runQuickSort(arr, 0, arr.length - 1, "STD");
    }

    public static <T extends Comparable<T>> void quickSortRandom(T[] arr) {
        runQuickSort(arr, 0, arr.length - 1, "RND");
    }

    public static <T extends Comparable<T>> void quickSortMedian(T[] arr) {
        runQuickSort(arr, 0, arr.length - 1, "MED");
    }

    private static <T extends Comparable<T>> void runQuickSort(T[] arr, int low, int high, String strategy) {
        if (low < high) {
            int pIndex = 0;
            if (strategy.equals("STD")) {
                pIndex = partitionLowPivot(arr, low, high);
            } else if (strategy.equals("RND")) {
                pIndex = partitionRandom(arr, low, high);
            } else if (strategy.equals("MED")) {
                pIndex = partitionMedian(arr, low, high);
            }
            
            runQuickSort(arr, low, pIndex - 1, strategy);
            runQuickSort(arr, pIndex + 1, high, strategy);
        }
    }

    private static <T extends Comparable<T>> int partitionLowPivot(T[] arr, int low, int high) {
        int pivotLoc = low;
        T pivotVal = arr[pivotLoc];
        
        int i = low + 1; 
        int j = high;    
        boolean scanning = true;

        while (scanning) {
            while (i <= high && arr[i].compareTo(pivotVal) <= 0) {
                i++;
            }
            while (j >= i && arr[j].compareTo(pivotVal) > 0) {
                j--;
            }

            if (i > j) {
                scanning = false;
            } else {
                swapElements(arr, i, j);
                i++;
                j--;
            }
        }
        
        swapElements(arr, low, j);
        return j;
    }

    private static <T extends Comparable<T>> int partitionRandom(T[] arr, int low, int high) {
        Random rng = new Random();
        int rIdx = rng.nextInt(high - low + 1) + low;
        
        swapElements(arr, low, rIdx); 
        return partitionLowPivot(arr, low, high);
    }

    private static <T extends Comparable<T>> int partitionMedian(T[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        
        if (arr[low].compareTo(arr[mid]) > 0) swapElements(arr, low, mid);
        if (arr[low].compareTo(arr[high]) > 0) swapElements(arr, low, high);
        if (arr[mid].compareTo(arr[high]) > 0) swapElements(arr, mid, high);
        
        swapElements(arr, low, mid);
        return partitionLowPivot(arr, low, high);
    }

    private static <T> void swapElements(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}