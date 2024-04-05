package CountConformingBitMask;

public class count {
    public int solution(int A,int B,int C){
        int combined = A | B | C;
        int combinedAnd = A & B & C;
        int count = Integer.bitCount(combined);
        System.out.println("Combined "+Integer.toBinaryString(combined));
        System.out.println("Combined And "+Integer.toBinaryString(combinedAnd));
        // Calculate the number of conforming integers as 2^count - 1
        System.out.println(Integer.bitCount(combined));
        System.out.println(Integer.bitCount(combinedAnd));
        return (1 << count) - 1;
    }
public static void main(String[] args) {
    count c1 = new count();
    System.out.println(c1.solution(1073741727, 1073741631, 1073741679));
}    

}

