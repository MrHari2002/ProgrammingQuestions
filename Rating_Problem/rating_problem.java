package Rating_Problem;
import java.util.Scanner;
public class rating_problem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numJudge = s.nextInt();
        int numRated = s.nextInt();
        int[] rates = new int[numRated];
        for(int i = 0; i< numRated;i++){
            rates[i] = s.nextInt();
        }
        
        int curRate = 0;
        for (int i : rates) {
            curRate+= i;
        }

        float maximum = ((float)curRate + 3 * (float)(numJudge-numRated)) / (float)numJudge;
        float minimum = ((float)curRate + -3 * (float)(numJudge-numRated)) / (float)numJudge;

        System.out.println(minimum + " "+ maximum);
        s.close();
    }
}
