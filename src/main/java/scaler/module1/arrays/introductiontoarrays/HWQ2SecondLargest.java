package scaler.module1.arrays.introductiontoarrays;

public class HWQ2SecondLargest {
  //  Problem Description
  //  You are given an integer array A. You have to find the second largest element/value in the
  // array or report that no such element exists.
  //      Problem Constraints
  // 1 <= |A| <= 105
  //      0 <= A[i] <= 109
  //  Input Format
  //  The first argument is an integer array A.
  //  Output Format
  //  Return the second largest element. If no such element exist then return -1.
  //  Example Input
  //  Input 1:
  //  A = [2, 1, 2]
  //  Input 2:
  //  A = [2]
  //  Example Output
  //  Output 1:
  //      2
  //  Output 2:
  //      -1
  //  Example Explanation
  //  Explanation 1:
  //  First largest element = 2
  //  Second largest element = 2
  //  Third largest element = 1
  //  Explanation 2:
  //  There is no second largest element in the array.
  public int solve(int[] A) {
    if (A == null || A.length == 1) {
      return -1;
    }
    int firstMax;
    int secondMax;
    if (A[0] > A[1]) {
      firstMax = A[0];
      secondMax = A[1];
    } else {
      firstMax = A[1];
      secondMax = A[0];
    }
    //3,1,2
    for (int i = 2; i < A.length; i++) {
      if (A[i] >= firstMax) {
        secondMax = firstMax;
        firstMax = A[i];
      } else if (A[i] > secondMax) {
        secondMax = A[i];
      }
    }
    return secondMax;
  }

  public static void main(String[] args) {
    int[] array = {2, 1, 2};
    System.out.println(new HWQ2SecondLargest().solve(array));
    array = new int[] {2};
    System.out.println(new HWQ2SecondLargest().solve(array));
    array =
        new int[] {
          325915837, 411417670, 470756962, 871352620, 384112813, 94286197, 85455506, 25984657,
          706598537, 767366984, 668227196, 920161872, 586257991, 498802355, 741191251, 238792980,
          166008052, 522624194, 499897610, 781256741, 499097003, 683148934, 116894890, 393525910,
          217552712, 722510112, 965553357, 48997591, 318957398, 558868379, 162384858, 771047734,
          315954882, 432330613, 359390604, 285751008, 516672937, 265769722, 951666358, 789849904,
          707914527, 867671619, 784252459, 819546137, 643066198, 777180925, 984485347, 526474508,
          508217606, 488623472, 633860560, 942936103, 294666622, 95472490, 157163318, 608944225,
          223597511, 328142272, 692137549, 838623512, 323898544, 994327756, 918179085, 253296694,
          262809541, 511062901, 591634244, 267620888, 155265866, 229132987, 86512414, 831457566,
          240060872, 907861949, 249882847, 794031109, 978467413, 937476645, 436874907, 933541394,
          344675187, 65258013, 493897814, 221074410, 910624091, 334078551, 9347979, 978884644,
          633772201, 227913657, 421508281, 165949915, 673245468, 342114696, 353581937, 756424638,
          187194432, 687210408, 585476213, 564349027, 899037956, 718295211, 30518486, 912989254,
          715121753, 882002079, 55214229, 480117151, 347366481, 103623098, 592162896, 759430882,
          760181417, 871796082, 912323145, 322247025, 498385708, 822271675, 442350926, 97249248,
          276365734, 786321711, 512644922, 445076928, 622068453, 457193099, 41842842, 975551799,
          182316703, 376510607, 305246231, 617920021, 398932219, 431318588, 992570968, 688642012,
          907982199, 729938485, 552080549, 809273724, 621873037, 836994924, 409249412, 443410778,
          730094834, 270992181, 387719274, 265016712, 781194413, 603543683, 858488880, 507282759,
          160281629, 284063304, 90476958, 44878799, 247507807, 423179927, 832295801
        };
    //    Arrays.sort(array);
    //    System.out.println(Arrays.toString(array));
    System.out.println(new HWQ2SecondLargest().solve(array));
  }
}
