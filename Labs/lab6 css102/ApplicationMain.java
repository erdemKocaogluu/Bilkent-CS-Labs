import java.util.Scanner;

public class ApplicationMain {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("### Big Integer Sorting Application ###");
        
        System.out.print("Enter initial seed number: ");
        String girisSeed = inputReader.next();
        
        System.out.print("Enter count of numbers to generate: ");
        int totalNums = inputReader.nextInt();
        
        MyBigInt startSeed = new MyBigInt(girisSeed);
        System.out.println("Generating numbers...");
        
        MyBigInt[] rawList = RngGenerator.createSequence(startSeed, totalNums);
        System.out.println("Generation complete.\n");

        boolean appRunning = true;
        
        while (appRunning) {
            System.out.println("Select Sorting Algorithm:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quicksort (Standard)");
            System.out.println("4. Quicksort (Random Pivot)");
            System.out.println("5. Quicksort (Median Pivot)");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            
            int userChoice = inputReader.nextInt();
            
            if (userChoice == 6) {
                appRunning = false;
            } else {
                MyBigInt[] sortableList = new MyBigInt[rawList.length];
                for (int i = 0; i < rawList.length; i++) {
                    sortableList[i] = rawList[i];
                }

                long tStart = System.currentTimeMillis(); 
                boolean validSelection = true;

                if (userChoice == 1) {
                    SortAlgorithms.bubbleSort(sortableList);
                } else if (userChoice == 2) {
                    SortAlgorithms.mergeSort(sortableList);
                } else if (userChoice == 3) {
                    SortAlgorithms.quickSortStandard(sortableList);
                } else if (userChoice == 4) {
                    SortAlgorithms.quickSortRandom(sortableList);
                } else if (userChoice == 5) {
                    SortAlgorithms.quickSortMedian(sortableList);
                } else {
                    System.out.println("Invalid selection.");
                    validSelection = false;
                }
                
                if (validSelection) {
                    long tEnd = System.currentTimeMillis(); 
                    double duration = (tEnd - tStart) / 1000.0; 

                    displaySubset(rawList, sortableList);
                    
                    boolean sortedCorrectly = checkOrder(sortableList);
                    
                    System.out.println("Algorithm Code: " + userChoice);
                    System.out.println("Time taken: " + duration + " seconds");
                    
                    String msg = "FAILED";
                    if (sortedCorrectly) {
                        msg = "SUCCESS";
                    }
                    System.out.println("Sort Status: " + msg);
                    System.out.println("--------------------------------------------------");
                }
            }
        }
        
        inputReader.close();
    }

    private static void displaySubset(MyBigInt[] src, MyBigInt[] sorted) {
        int showLimit = src.length;
        if (showLimit > 50) {
            showLimit = 50;
        }

        System.out.println("\n--- First " + showLimit + " Numbers ---");
        System.out.printf("%-30s | %-30s\n", "Original", "Sorted");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < showLimit; i++) {
            String oStr = src[i].toString();
            String sStr = sorted[i].toString();
            
            if (oStr.length() > 25) oStr = oStr.substring(0, 25) + "...";
            if (sStr.length() > 25) sStr = sStr.substring(0, 25) + "...";
            
            System.out.printf("%-30s | %-30s\n", oStr, sStr);
        }
        System.out.println();
    }

    private static boolean checkOrder(MyBigInt[] arr) {
        boolean inOrder = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                inOrder = false;
            }
        }
        return inOrder;
    }
}