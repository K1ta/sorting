package ru.mail.polis.sort;

public class QuickSort1<T extends Comparable<T>> {

    public T[] sort(T[] a) {
        quicksort(a, 0, a.length - 1);
        return a;
    }

    private void quicksort(T[] a, int left, int right) {
        if(right - left < 15)
        {
            int k = 0;
            int index = 0;
            for (int i = 0; i < a.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j].compareTo(a[min]) < 0) {
                        min = j;
                    }
                }
                if (i != min) {
                    if (i == index) {
                        k++;
                        index = min;
                    } else if (min == index) {
                        k++;
                        index = i;
                    }
                    T temp = a[i];
                    a[i] = a[min];
                    a[min] = temp;
                }
            }
            return;
        }
        if (left >= right) return;
        T p = a[(int)(Math.random() * a.length)];
        int i = left;
        int j = right;
        while (i <= j) {
            while (a[i].compareTo(p) < 0) i++;
            while (a[j].compareTo(p) > 0) j--;
            if (i <= j) {
                T temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        quicksort(a, left, j);
        quicksort(a, i, right);
    }
}