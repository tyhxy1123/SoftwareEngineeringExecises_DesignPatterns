public class QuickSort {

    public void exange(int[] folge, int a, int b){
        int t = folge[a];
        folge[a] = folge[b];
        folge[b] = t;
    }

    public void sort(int[] folge, int L, int R){
        int i = L;
        int j = R;
        int S = folge[(L + R) / 2];
        System.out.println("into a new Recursive!");
        System.out.println("L = " + L + " R = " + R);
        while((i >= L) && (j <= R) && (i <= j)){
            System.out.println("into while Schleife!");
            System.out.println("i = " + i + " j = " + j);
            System.out.println("i <= j is " + (i <= j));
            if (i <= j) {
                System.out.println("into if i <= j");
                while(folge[i] < S){
                    System.out.println("into i Schleife" + " i = " + i);
                    i++;
                    System.out.println("folge[i] = " + folge[i] + " S = " + S);
                }
                while(folge[j] > S){
                    System.out.println("into j Schleife" + " j = " + j);
                    j--;
                    System.out.println("folge[j] = " + folge[j] + " S = " + S);
                }
                if(i <= j){
                    System.out.println("into exchange()!");

                    this.exange(folge, i, j);
                    i++;
                    j--;
                    System.out.println("After exchange i = " + i + " j = " + j);

                }
                for(int k = 0; k < folge.length; k++){
                    System.out.print(folge[k] + " ");
                }
                System.out.println();

            }
        }

        if(L <= R){
            sort(folge, L, j);
            sort(folge, i, R);
        }


    }

    public void quickSort(int[] folge){

        this.sort(folge, 0, folge.length - 1);

    }

    public static void main(String[] args){
        int[] folge = {5, 1, 3, 7, 6, 2, 8, 9, 0, 34, 1, -5, -24};
        QuickSort a = new QuickSort();
        a.quickSort(folge);
        for(int i = 0; i < folge.length; i++){
            System.out.print(folge[i] + " ");
            if((i + 1) % 4 == 0){
                System.out.println();
            }
        }
    }
}
