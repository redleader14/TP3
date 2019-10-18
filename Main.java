import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static int SIZE = Integer.MAX_VALUE / 10000;
    static int[] tableau = new int[SIZE];

    public static void main(String[] args) {
        initialiserTableau();
        int[] tableauSelection = new int[SIZE];
        // arraycopy(src, startIndex, dest, startIndex, size)
        System.arraycopy(tableau, 0, tableauSelection, 0, SIZE);
        triSelection(tableauSelection);
        int[] tableauInsertion = new int[SIZE];
        System.arraycopy(tableau, 0, tableauInsertion, 0, SIZE);
        triInsertion(tableauInsertion);
        int[] tableauBulles = new int[SIZE];
        System.arraycopy(tableau, 0, tableauBulles, 0, SIZE);
        triBulles(tableauBulles);
        int[] tableauQuickSort = new int[SIZE];
        System.arraycopy(tableau, 0, tableauQuickSort, 0, SIZE);
        quicksortbis(tableauQuickSort, 0, tableauQuickSort.length - 1);
        int[] tableauSort = new int[SIZE];
        System.arraycopy(tableau, 0, tableauSort, 0, SIZE);
        triJava(tableauSort);


    }

    public static void initialiserTableau() {
        Instant start = Instant.now();
        System.out.println("Debut d’initialisation...");
        Random random = new Random();
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = random.nextInt(SIZE);
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("L’initialisation a pris " + duration + " ms");
    }

    public static void triSelection(int[] tableau) {
        Instant start = Instant.now();
        for (int i = 0; i < tableau.length - 1; i++) {
            int indiceMin = i;
            for (int j = i; j < tableau.length; j++) {
                if (tableau[j] < tableau[indiceMin]) {
                    indiceMin = j;
                }
            }
            int swap = tableau[i];
            tableau[i] = tableau[indiceMin];
            tableau[indiceMin] = swap;
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("Le tri par sélection a pris " + duration + " ms");
    }

    public static void triInsertion(int[] tableau) {
        Instant start = Instant.now();
        for (int i = 1; i < tableau.length; i++) {
            int elementATrier = tableau[i];
            int j = i;
            while (j > 0 && tableau[j - 1] > elementATrier) {
                tableau[j] = tableau[j - 1];
                j--;
            }
            tableau[j] = elementATrier;
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("Le tri par insertion a pris " + duration + " ms");

    }

    public static void triBulles(int[] tableau) {
        Instant start = Instant.now();
        boolean estTrie = false;
        while (!estTrie) {
            estTrie = true;
            for (int i = 1; i < tableau.length; i++) {
                if (tableau[i - 1] > tableau[i]) {
                    int swap = tableau[i - 1];
                    tableau[i - 1] = tableau[i];
                    tableau[i] = swap;
                    estTrie = false;
                }
            }
        }
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("Le tri à bulles a pris " + duration + " ms");

    }

    public static void quicksort(int[] tableau, int indGauche, int indDroit) {

        if (indGauche < indDroit) {
            int indicePartition = partition(tableau, indGauche, indDroit);
            quicksort(tableau, indGauche, indicePartition);
            quicksort(tableau, indicePartition + 1, indDroit);
        }
    }

    public static void quicksortbis(int[] tableau, int indGauche, int indDroit) {
        Instant start = Instant.now();
        quicksort(tableau, indGauche, indDroit);
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("Le tri quicksort a pris " + duration + " ms");

    }

    public static int partition(int[] tableau, int indGauche, int indDroit) {
        int elementPivot = tableau[indGauche + (indDroit - indGauche) / 2];
        int left = indGauche - 1;
        int right = indDroit + 1;
        while (true) {
            do {
                left++;
            } while (tableau[left] < elementPivot);
            do {
                right--;
            } while (tableau[right] > elementPivot);
            if (left >= right) {
                return right;
            }
            int tmp = tableau[left];
            tableau[left] = tableau[right];
            tableau[right] = tmp;
        }

    }

    public static void triJava(int[] tableau) {
        Instant start = Instant.now();
        Arrays.sort(tableau);
        Instant end = Instant.now();
        long duration = Duration.between(start, end).toMillis();
        System.out.println("Le tri Java a pris " + duration + " ms");


    }


}
