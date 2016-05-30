package kpi.study.epam.strategy;

import java.util.Arrays;

/**
 * Patterns
 * Created 5/30/16, with IntelliJ IDEA
 *
 * @author Alex
 */
class Runner {
    public static void main(String[] args) {
        Client client = new Client();
        int[] a0 = {1001,3,11,2,22,1,-5};
        client.setStrategy(new QuickSort());
        client.executeStrategy(a0);

        int[] a1={11,4,2,52,7,8};
        client.setStrategy(new InsertionSort());
        client.executeStrategy(a1);

        int[] a2 ={3,-7,2,0,33,1,3,1};
        client.setStrategy(new BubbleSort());
        client.executeStrategy(a2);
    }
}
interface Sorting{
    void sort(int arr[]);
}
class Client{ // Context
    private Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] arr){
        strategy.sort(arr);
    }
}

class QuickSort implements Sorting{
    @Override
    public void sort(int[] arr) {
        System.out.println("Quick Sort");
        System.out.println(Arrays.toString(arr));
        QuickSortIm(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void QuickSortIm(int[] a, int first, int last)
    {
        int i = first, j = last, x = a[(first + last) / 2];
        do {
            while (a[i] < x) i++;
            while (a[j] > x) j--;

            if(i <= j) {
                if (i < j){
                    int tmp=a[j];
                    a[j]=a[i];
                    a[i]=tmp;}
                i++;
                j--;
            }
        } while (i <= j);
        if (i < last)
            QuickSortIm(a, i, last);
        if (first < j)
            QuickSortIm(a, first,j);
    }
}
class BubbleSort implements Sorting{
    public void sort(int[] a){
        System.out.println("Bubble Sort");
        System.out.println(Arrays.toString(a));
        for (int i=a.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (a[j]>a[j+1]){
                    int tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
    class InsertionSort implements Sorting{
        @Override
        public void sort(int[] a) {
            System.out.println("Insertion Sort");
            System.out.println(Arrays.toString(a));
            int i,j,value;
            for (i=1;i<a.length;i++){
                value=a[i];
                for (j=i-1;j>=0 && a[j]>value;j--){
                    a[j+1] = a[j];
                }
                a[j+1]=value;
            }
            System.out.println(Arrays.toString(a));
        }
    }

