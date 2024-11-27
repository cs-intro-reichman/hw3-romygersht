public class App {
    public static void main(String[] args) throws Exception {
       
       // String string = (args[0]);
        System.out.println(+arrys+);
    }
public static int[] moveArry(int arry[], int element) {
    int[] arryS = new int [0];
    int count =0; 
    for (int i=0; i < arry.length; i++) {
         count++;
        arryS[i] = arryS [count];
        if (arry[i] != element) {
            int j = 0;
            arryS[j] =i;
            j++;
        }
    }
    return arryS;
}
}

