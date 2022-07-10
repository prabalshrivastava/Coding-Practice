package scaler.arrays.carryforward;

public class HWQ1AmazingSubarrays {
  //  You are given a string S, and you have to find all the amazing substrings of S.
  //  An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
  //  Input
  //  Only argument given is string S.
  //  Output
  //  Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the
  // string.
  //  Constraints
  // 1 <= length(S) <= 1e6
  //  S can have special characters
  //      Example
  //  Input
  //      ABEC
  //  Output
  //    6
  //  Explanation
  //  Amazing substrings of given string are :
  //    1. A
  //    2. AB
  //    3. ABE
  //    4. ABEC
  //    5. E
  //    6. EC
  //  here number of substrings are 6 and 6 % 10003 = 6.
  public int solve(String A) {
    char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    int count = 0;
    int vowel = 0;
    for (int i = 0; i < A.length(); i++) {
      for (int j = 0; j < vowels.length; j++) {
        if (A.charAt(i) == vowels[j]) {
          vowel++;
          break;
        }
      }
      if (vowel > 0) count = count + vowel;
    }
    return count % 10003;
  }

  public static void main(String[] args) {
    System.out.println(new HWQ1AmazingSubarrays().solve("ABEC"));
  }
}
