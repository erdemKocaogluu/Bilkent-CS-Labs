import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
                
        System.out.print("Enter initial seed number: ");
        String string = scan.next();
        
        System.out.print("number sayıyı gir: ");
        int count = scan.nextInt();
        
        MyBigInt seed = new MyBigInt(string);
        System.out.println("Generating numbers...");
        MyBigInt[] originalList = Uretici.generateList(seed, count);
        System.out.println(Arrays.toString(originalList));
        System.out.println("Generation complete.");

        boolean exit = false;
        while (!exit) {
            System.out.println("Select Sorting Algorithm:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quicksort (Standard)");
            System.out.println("4. Quicksort (Random Pivot)");
            System.out.println("5. Quicksort (Median Pivot)");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            
            int choice = scan.nextInt();
            
            if (choice == 6) {
                exit = true;
            } else {
                MyBigInt[] listToSort = new MyBigInt[originalList.length];
                for (int i = 0; i < originalList.length; i++) {
                    listToSort[i] = originalList[i];
                    System.out.println(listToSort[i]);
                    System.out.println( originalList[i]);
                }

                long startTime = System.currentTimeMillis();
                boolean validChoice = true;

                if (choice == 1) {
                    SortAlgroitma.bubbleSort(listToSort);
                } else if (choice == 2) {
                    SortAlgroitma.mergeSort(listToSort);
                } else if (choice == 3) {
                    SortAlgroitma.quickSortStandard(listToSort);
                } else if (choice == 4) {
                    SortAlgroitma.quickSortRandom(listToSort);
                } else if (choice == 5) {
                    SortAlgroitma.quickSortMedian(listToSort);
                } else {
                    System.out.println("Invalid choice.");
                    validChoice = false;
                }
                
                if (validChoice) {
                    long endTime = System.currentTimeMillis();
                    double elapsed = (endTime - startTime) / 1000.0;

                    printResults(originalList, listToSort);
                    
                    boolean isSorted = verifySorted(listToSort);
                    
                    System.out.println("Algorithm Code: " + choice);
                    System.out.println("Time taken: " + elapsed + " seconds");
                    String status = "FAILED";
                    if (isSorted) {
                        status = "SUCCESS";
                    }
                    System.out.println("Sort Status: " + status);
                    System.out.println("--------------------------------------------------");
                }
            }
        }
        
        scan.close();
    }

    private static void printResults(MyBigInt[] original, MyBigInt[] sorted) {
        int limit = original.length;
        if (limit > 50) {
            limit = 50;
        }

        System.out.println("\n--- First " + limit + " Numbers ---");
        System.out.printf("%-30s | %-30s\n", "Original", "Sorted");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < limit; i++) {
            String o = original[i].toString();
            String s = sorted[i].toString();
            
            if (o.length() > 25) o = o.substring(0, 25) + "...";
            if (s.length() > 25) s = s.substring(0, 25) + "...";
            System.out.printf("%-30s | %-30s\n", o, s);
        }
        System.out.println();
    }

    private static boolean verifySorted(MyBigInt[] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                isSorted = false;
            }
        }
        return isSorted;
    }
}