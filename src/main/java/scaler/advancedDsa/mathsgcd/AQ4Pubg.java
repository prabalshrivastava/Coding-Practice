package scaler.advancedDsa.mathsgcd;

public class AQ4Pubg {
//    Problem Description
//    There are N players, each with strength A[i]. when player i attack player j, player j strength reduces to max(0, A[j]-A[i]). When a player's strength reaches zero, it loses the game, and the game continues in the same manner among other players until only 1 survivor remains.
//    Can you tell the minimum health last surviving person can have?
//    Problem Constraints
//1 <= N <= 100000
//            1 <= A[i] <= 1000000
//    Input Format
//    First and only argument of input contains a single integer array A.
//    Output Format
//    Return a single integer denoting minimum health of last person.
//    Example Input
//    Input 1:
//    A = [6, 4]
//    Input 2:
//    A = [2, 3, 4]
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//    Given strength array A = [6, 4]
//    Second player attack first player, A =  [2, 4]
//    First player attack second player twice. [2, 0]
//    Explanation 2:
//    Given strength array A = [2, 3, 4]
//    First player attack third player twice. [2, 3, 0]
//    First player attack second player. [2, 1, 0]
//    Second player attack first player twice. [0, 1, 0]

    public static void main(String[] args) {
        int[] input1A = {6, 4};
        System.out.println(new AQ4Pubg().solve(input1A));
        int[] input2A = {2, 3, 4};
        System.out.println(new AQ4Pubg().solve(input2A));
        int[] input3A = {2, 3, 4};
        System.out.println(new AQ4Pubg().solve(input3A));
    }

    public int solve(int[] A) {
        if (A.length < 2) {
            return A[0];
        }
        int ans = gcd(A[0], A[1]);
        for (int i = 2; i < A.length; i++) {
            ans = gcd(ans, A[i]);
        }
        return ans;
    }

    public int gcd(int A, int B) {
        if (A == 0)
            return B;
        if (B == 0)
            return A;
        if (A <= B) {
            return gcd(B % A, A);
        } else {
            return gcd(A % B, B);
        }
    }
}
