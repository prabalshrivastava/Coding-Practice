package scaler.module1.subsequencesAndSubsets;

public class HWQ3FindSubsequence {
//  Given two strings A and B, find if A is a subsequence of B.
//  Return "YES" if A is a subsequence of B, else return "NO".
//  Input Format
//  The first argument given is the string A.
//  The second argument given is the string B.
//  Output Format
//  Return "YES" if A is a subsequence of B, else return "NO".
//  Constraints
//1 <= lenght(A), length(B) <= 100000
//      'a' <= A[i], B[i] <= 'z'
//  For Example
//  Input 1:
//  A = "bit"
//  B = "dfbkjijgbbiihbmmt"
//  Output 1:
//  YES
//  Input 2:
//  A = "apple"
//  B = "appel"
//  Output 2:
//      "NO"

  public static void main(String[] args) {
    String input1A = "bit";
    String input1B = "dfbkjijgbbiihbmmt";
    System.out.println(new HWQ3FindSubsequence().solve(input1A, input1B));

    String input2A = "apple";
    String input2B = "appel";
    System.out.println(new HWQ3FindSubsequence().solve(input2A, input2B));
    System.out.println(new HWQ3FindSubsequence().solve("gsb",
        "jgksobmxtoxajbpbganpbgsdpgmhozuxlfxmwmabnfmcsmsjnvwgswzrmtmzsolifelqppadhaitwplcypwdcquwocfdahzrkyhqxtpwbypfgwpzmccwmtgefijeggnmzjqoockojxyngykdbflvntrfxymiqke"));
  }

  public String solve(String A, String B) {
    int index = 0;
    int i = 0;
    for (; i < B.length(); i++) {
      if (index < A.length() && A.charAt(index) == B.charAt(i)) {
        System.out.println(A.charAt(index));
        index++;
      }
    }
    if (index == A.length()) {
      return "YES";
    } else {
      return "NO";
    }
  }
}