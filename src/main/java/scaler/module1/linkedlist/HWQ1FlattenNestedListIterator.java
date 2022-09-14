package scaler.module1.linkedlist;

import java.util.ArrayList;

public class HWQ1FlattenNestedListIterator {
//    You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.
//    Implement the NestedIterator class:
//    NestedIterator(List nestedList) Initializes the iterator with the nested list nestedList.
//    int next() Returns the next integer in the nested list.
//    boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
//            Example 1:
//    Input: nestedList = [[1,1],2,[1,1]]
//    Output: [1,1,2,1,1]
//    Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
//    Example 2:
//    Input: nestedList = [1,[4,[6]]]
//    Output: [1,4,6]
//    Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
//    Constraints:
//    The sum of integers in all cases does not exceed 1e5.
//    The values of the integers in the nested list are in the range [-1e6, 1e6].




//     // This is the interface that allows for creating nested lists.
//     // You should not implement it, or speculate about its implementation.

    class NestedIterator {
        NestedIterator(ArrayList<NestedInteger> nestedList) {
        }
        int next() {
            return 0;
        }

        boolean hasNext() {
            return false;
        }
    }

    class NestedInteger {

        NestedInteger(int x) {
        }

        // Return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger() {
            return false;
        }

        // Return the single integer that this NestedInteger holds, if it holds a single integer.
        // The result is 1e9 if this NestedInteger holds a nested list.
        int getInteger() {
            return 0;
        }

        // Return the nested list that this NestedInteger holds, if it holds a nested list.
        // The result is an empty ArrayList if this NestedInteger holds a single integer.
        ArrayList<NestedInteger> getList() {
            return null;
        }
    }
}
