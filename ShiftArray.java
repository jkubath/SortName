/* CLASS:  Shift Array Object
 * AUTHOR: Jonah
 * DESCRIPTION:  
 ******************************************************************************/
package sortname;

import java.io.*;

public class ShiftArray {

    // WRITE CODE HERE
    private final int SIZE = 100;
    private final int WIDTH = 3;
    private String[][] shiftA = new String[SIZE][WIDTH];
    private String[][] shiftB = new String[SIZE][WIDTH];
    private String[][] shiftC = new String[SIZE][WIDTH];
    private String[][] shiftD = new String[SIZE][WIDTH];

    public ShiftArray() {

    }

    public ShiftArray(String[] pName, String[] pPager, String[] pShift, int count)
            throws FileNotFoundException {
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        int indexD = 0;
        initializeArray();
        for (int i = 0; i < count; i++) {
            if (pShift[i].compareToIgnoreCase("A") == 0) {
                shiftA[indexA][0] = pName[i];
                shiftA[indexA][1] = pPager[i];
                shiftA[indexA][2] = pShift[i];
                indexA++;
            }
            if (pShift[i].compareToIgnoreCase("B") == 0) {
                shiftB[indexB][0] = pName[i];
                shiftB[indexB][1] = pPager[i];
                shiftB[indexB][2] = pShift[i];
                indexB++;
            }
            if (pShift[i].compareToIgnoreCase("C") == 0) {
                shiftC[indexC][0] = pName[i];
                shiftC[indexC][1] = pPager[i];
                shiftC[indexC][2] = pShift[i];
                indexC++;
            }
            if (pShift[i].compareToIgnoreCase("D") == 0) {
                shiftD[indexD][0] = pName[i];
                shiftD[indexD][1] = pPager[i];
                shiftD[indexD][2] = pShift[i];
                indexD++;
            }
//        }
//        System.out.println("Unsorted------------------------------------");
//        System.out.println("Shift A");
//        for (int i = 0; i < indexA; i++) {
//            for (int j = 0; j < WIDTH; j++) {
//                System.out.print(shiftA[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("Shift B");
//        for (int i = 0; i < indexB; i++) {
//            for (int j = 0; j < WIDTH; j++) {
//                System.out.print(shiftB[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("Shift C");
//        for (int i = 0; i < indexC; i++) {
//            for (int j = 0; j < WIDTH; j++) {
//                System.out.print(shiftC[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("Shift D");
//        for (int i = 0; i < indexD; i++) {
//            for (int j = 0; j < WIDTH; j++) {
//                System.out.print(shiftD[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("Sorted------------------------------------");
//        copyArray(shiftA, insertionSort(shiftA, indexA), indexA);
//        copyArray(shiftB, insertionSort(shiftB, indexB), indexB);
//        copyArray(shiftC, insertionSort(shiftC, indexC), indexC);
//        copyArray(shiftD, insertionSort(shiftD, indexD), indexD);
//
//        for (int i = 0; i < indexA; i++) {
//            for (int j = 0; j < WIDTH; j++) {
//                System.out.print(shiftA[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("Shift B");
//        for (int i = 0; i < indexB; i++) {
//            for (int j = 0; j < WIDTH; j++) {
//                System.out.print(shiftB[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("Shift C");
//        for (int i = 0; i < indexC; i++) {
//            for (int j = 0; j < WIDTH; j++) {
//                System.out.print(shiftC[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("Shift D");
//        for (int i = 0; i < indexD; i++) {
//            for (int j = 0; j < WIDTH; j++) {
//                System.out.print(shiftD[i][j] + " ");
//            }
//            System.out.println();
//        }
        }
        writeSortFile(shiftA, shiftB, shiftC, shiftD, indexA, indexB, indexC, indexD);
        writeInputFile(shiftA, shiftB, shiftC, shiftD, indexA, indexB, indexC, indexD);

    }

    public void initializeArray() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < WIDTH; j++) {
                shiftA[i][j] = "NA";
                shiftB[i][j] = "NA";
                shiftC[i][j] = "NA";
                shiftD[i][j] = "NA";
            }
        }
    }

    public String[][] insertionSort(String[][] array, int index) {
        String save0;
        String save1;
        String save2;
        int i;

        for (int iNextEl = 1; iNextEl < index; iNextEl++) {
            save0 = array[iNextEl][0];
            save1 = array[iNextEl][1];
            save2 = array[iNextEl][2];

            i = iNextEl;

            while ((i > 0) && (array[i - 1][0].compareTo(save0) > 0)) {
                array[i][0] = array[i - 1][0];
                array[i][1] = array[i - 1][1];
                array[i][2] = array[i - 1][2];
                i--;
            }
            array[i][0] = save0;
            array[i][1] = save1;
            array[i][2] = save2;

        }
        return array;
    }

    public void copyArray(String[][] pActual, String[][] pArray, int index) {
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < WIDTH; j++) {

                pActual[i][j] = pArray[i][j];
            }
        }
    }

    /**
     *
     * @param shift1
     * @param shift2
     * @param shift3
     * @param shift4
     * @throws java.io.FileNotFoundException
     */
    public void writeSortFile(String[][] shift1, String[][] shift2, String[][] shift3,
            String[][] shift4, int indexA, int indexB, int indexC, int indexD)
            throws FileNotFoundException {
        PrintWriter print = new PrintWriter("NameSort.txt");
        //print.printf("%-10s%4s %s\r", "Name", "Pager", "Shift");
        print.print("------------------------------\r");
        for (int i = 0; i < indexA; i++) {
            print.printf("%-10s%-4s", shift1[i][0], shift1[i][1]);

            i++;
            print.printf("\t%-10s%-4s", shift1[i][0], shift1[i][1]);

            print.print("\r");
        }
        print.print("------------------------------\r");
        for (int i = 0; i < indexB; i++) {
            print.printf("%-10s%-4s", shift2[i][0], shift2[i][1]);

            i++;
            print.printf("\t%-10s%-4s", shift2[i][0], shift2[i][1]);

            print.print("\r");

        }

        print.print("\n\n\n"
                + "------------FOLD-------------\r"
                + "\n\n\n");

        print.print("------------------------------\r");
        for (int i = 0; i < indexC || i < indexD; i++) {
            print.printf("%-10s%-4s", shift3[i][0], shift3[i][1]);

            i++;
            print.printf("\t%-10s%-4s", shift3[i][0], shift3[i][1]);

            print.print("\r");
        }
        print.print("------------------------------\r\n");
        for (int i = 0; i < indexD; i++) {
            print.printf("%-10s%-4s", shift4[i][0], shift4[i][1]);

            i++;
            print.printf("\t%-10s%-4s", shift4[i][0], shift4[i][1]);

            print.print("\r");
        }

        print.close();
    }

    public void writeInputFile(String[][] shift1, String[][] shift2, String[][] shift3,
            String[][] shift4, int indexA, int indexB, int indexC, int indexD)
            throws FileNotFoundException {
        PrintWriter printInput = new PrintWriter("name.csv");
        int i;
        for (i = 0; i < indexA; i++) {
            printInput.print(shift1[i][0] + "," + shift1[i][1] + "," + shift1[i][2]);
            printInput.print("\r");
        }

        for (i = 0; i < indexB; i++) {
            printInput.print(shift2[i][0] + "," + shift2[i][1] + "," + shift2[i][2]);
            printInput.print("\r");
        }

        for (i = 0; i < indexC; i++) {
            printInput.print(shift3[i][0] + "," + shift3[i][1] + "," + shift3[i][2]);
            printInput.print("\r");
        }

        for (i = 0; i < indexD; i++) {
            printInput.print(shift4[i][0] + "," + shift4[i][1] + "," + shift4[i][2]);
            printInput.print("\r");
        }

        printInput.close();
    }

}
