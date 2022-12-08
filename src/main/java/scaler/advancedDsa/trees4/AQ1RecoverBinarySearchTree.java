package scaler.advancedDsa.trees4;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AQ1RecoverBinarySearchTree {
//    Problem Description
//    Two elements of a binary search tree (BST), represented by root A are swapped by mistake. Tell us the 2 values swapping which the tree will be restored.
//    A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
//    Problem Constraints
//1 <= size of tree <= 100000
//    Input Format
//    First and only argument is the head of the tree,A
//    Output Format
//    Return the 2 elements which need to be swapped.
//    Example Input
//    Input 1:
//            1
//            / \
//            2   3
//    Input 2:
//            2
//            / \
//            3   1
//    Example Output
//    Output 1:
//            [2, 1]
//    Output 2:
//            [3, 1]
//    Example Explanation
//    Explanation 1:
//    Swapping 1 and 2 will change the BST to be
//         2
//                 / \
//                 1   3
//    which is a valid BST
//    Explanation 2:
//    Swapping 1 and 3 will change the BST to be
//         2
//                 / \
//                 1   3
//    which is a valid BST

    public static void main(String[] args) {
        int[] input1A = {1, 2, 3};
        System.out.println(Arrays.toString(new AQ1RecoverBinarySearchTree().recoverTree(TreeUtils.mapArrayToTree(input1A))));//2,1

        int[] input2A = {2, 3, 1};
        System.out.println(Arrays.toString(new AQ1RecoverBinarySearchTree().recoverTree(TreeUtils.mapArrayToTree(input2A))));//3,1

        int[] input3A = {15, 10, 13, 5, 24, 18, 35, 3, 8, 11, 16, 20};
        System.out.println(Arrays.toString(new AQ1RecoverBinarySearchTree().recoverTree(TreeUtils.mapArrayToTree(input3A))));

        int[] input4A = {535, 344, 162, 345, 152, 181, -1, -1, 106, 161, 173, 261, 92, 133, 157, -1, 165, 178, 256, 329, 86, 104, 108, 137, 154, 160, 163, 171, 174, 179, 210, 258, 265, 335, 83, 87, 102, 105, 107, 114, 134, 147, 153, 155, 159, -1, -1, 164, 170, 172, -1, 176, -1, 180, 182, 221, 257, 259, 264, 311, 334, 337, 80, 85, -1, 90, 96, 103, -1, -1, -1, -1, 109, 132, -1, 135, 144, 148, -1, -1, -1, 156, 158, -1, -1, -1, 167, -1, -1, -1, 175, 177, -1, -1, -1, 202, 219, 223, -1, -1, -1, 260, 262, -1, 278, 314, 331, -1, 336, 339, 79, 82, 84, -1, 88, 91, 93, 97, -1, -1, -1, 113, 117, -1, -1, 136, 139, 145, -1, 150, -1, -1, -1, -1, 166, 168, -1, -1, -1, -1, 186, 208, 214, 220, 222, 245, -1, -1, -1, 263, 269, 304, 313, 319, 330, 333, -1, -1, 338, 341, -1, -1, 81, -1, -1, -1, -1, 89, -1, -1, -1, 95, -1, 98, 110, -1, 115, 125, -1, -1, 138, 141, -1, 146, 149, 151, -1, -1, -1, 169, 185, 193, 203, 209, 213, 218, -1, -1, -1, -1, 241, 247, -1, -1, 268, 276, 297, 307, 312, -1, 317, 328, -1, -1, 332, -1, -1, -1, 340, 343, -1, -1, -1, -1, 94, -1, -1, 99, -1, 111, 116, -1, 120, 128, -1, -1, 140, 142, -1, -1, -1, -1, -1, -1, -1, -1, 184, -1, 192, 198, -1, 206, -1, -1, 211, -1, 215, -1, 224, 244, 246, 250, 267, -1, 275, 277, 291, 299, 306, 308, -1, -1, 316, 318, 320, -1, -1, -1, -1, -1, 342, -1, -1, -1, -1, 101, -1, 112, -1, -1, 118, 122, 126, 130, -1, -1, -1, 143, 183, -1, 189, -1, 195, 200, 205, 207, -1, 212, -1, 217, -1, 227, 243, -1, -1, -1, 248, 251, 266, -1, 274, -1, -1, -1, 281, 295, 298, 301, 305, -1, -1, 309, 315, -1, -1, -1, -1, 323, -1, -1, 100, -1, -1, -1, -1, 119, 121, 124, -1, 127, 129, 131, -1, -1, -1, -1, 187, 190, 194, 196, 199, 201, 204, -1, -1, -1, -1, -1, 216, -1, 226, 239, 242, -1, -1, 249, -1, 253, -1, -1, 270, -1, 280, 290, 294, 296, -1, -1, 300, 302, -1, -1, -1, 310, -1, -1, 321, 325, -1, -1, -1, -1, -1, -1, 123, -1, -1, -1, -1, -1, -1, -1, -1, 188, -1, 191, -1, -1, -1, 197, -1, -1, -1, -1, -1, -1, -1, -1, 225, -1, 231, 240, -1, -1, -1, -1, 252, 254, -1, 272, 279, -1, 283, -1, 292, -1, -1, -1, -1, -1, -1, 303, -1, -1, -1, 322, 324, 327, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 228, 232, -1, -1, -1, -1, -1, 255, 271, 273, -1, -1, 282, 284, -1, 293, -1, -1, -1, -1, -1, -1, 326, -1, -1, 229, -1, 238, -1, -1, -1, -1, -1, -1, -1, -1, -1, 285, -1, -1, -1, -1, -1, 230, 237, -1, -1, 287, -1, -1, 235, -1, 286, 288, 233, 236, -1, -1, -1, 289, -1, 234, -1, -1, -1, -1, -1, -1};
        System.out.println(Arrays.toString(new AQ1RecoverBinarySearchTree().recoverTree(TreeUtils.mapArrayToTree(input4A))));//115 116
    }

    public int[] recoverTreeBF(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        inorderBF(A, list);
        int firstCulprit = Integer.MAX_VALUE;
        int secondCulprit = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                //correct condition
            } else {
                if (firstCulprit == Integer.MAX_VALUE && secondCulprit == Integer.MAX_VALUE) {
                    firstCulprit = list.get(i);
                    secondCulprit = list.get(i + 1);
                } else {
                    secondCulprit = list.get(i + 1);
                }
            }
        }
        System.out.println(list);
        return new int[]{firstCulprit, secondCulprit};
    }

    private void inorderBF(TreeNode A, List<Integer> list) {
        if (A == null)
            return;
        inorderBF(A.left, list);
        list.add(A.val);
        inorderBF(A.right, list);
    }

    public int[] recoverTree(TreeNode A) {
        TreeNode[] culprits = recover(A);
        return new int[]{culprits[1] == null ? 0 : culprits[1].val, culprits[0] == null ? 0 : culprits[0].val};
    }

    TreeNode previous;
    TreeNode firstCulprit = null;
    TreeNode secondCulprit = null;

    private TreeNode[] recover(TreeNode curr) {
        if (curr == null) return null;
        recover(curr.left);

        if (previous != null && previous.val > curr.val) {
//            System.out.println("previous.val > curr.val : " + previous.val + " > " + curr.val);
            if (firstCulprit == null) {
                firstCulprit = previous;
                secondCulprit = curr;
            } else {
                secondCulprit = curr;
            }
        }
        previous = curr;
        recover(curr.right);
        return new TreeNode[]{firstCulprit, secondCulprit};
    }
}
