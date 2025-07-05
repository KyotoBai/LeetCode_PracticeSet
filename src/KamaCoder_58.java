import java.util.Scanner;

public class KamaCoder_58 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] vec = new int[n];
        int[] prefix = new int[n];

        int presum = 0;
        for(int i = 0; i < n; i++){
            int num = scanner.nextInt();
            vec[i] = num;
            presum += num;
            prefix[i] = presum;
        }

        while(scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int sum = 0;
            if(a == 0){
                sum = prefix[b];
            }else{
                sum = prefix[b] - prefix[a - 1];
            }
            System.out.println("Sum from " + a + " to " + b + " is: " + sum);
        }
    }
}
