package TreeLongestZigZag;

import java.util.ArrayList;

public class TreeLongestZigZagV1 {
    /*
    In this problem we consider binary trees. Let's define a turn on a path as a change in the direction of
    the path (i.e. a switch from right to left or vice versa). A zigzag is simply a sequence of turns
    (it can start with either right or left). The length of a zigzag is equal to the number of turns.

There are two turns on the marked path. The first one is at [15]; the second is at [30].
That means that the length of this zigzag is equal to 2. This is also the longest zigzag in the
tree under consideration. In this problem you should find the longest zigzag that starts at the
root of any given binary tree and form a downwards path.

Note that a zigzag containing only one edge or one node has length 0.

Problem
Write a function:

class Solution { public int solution(Tree T); }

that, given a non-empty binary tree T consisting of N nodes, returns the length of the longest zigzag
starting at the root.

For example, given tree T shown in the figure above, the function should return 2, as explained above.
Note that the values contained in the nodes are not relevant in this task.

Technical details
A binary tree can be specified using a pointer data structure. Assume that the following
declarations are given:

class Tree {
  public int x;
  public Tree l;
  public Tree r;
}

An empty tree is represented by an empty pointer (denoted by null). A non-empty tree is represented
by a pointer to an object representing its root. The attribute x holds the integer contained in the root,
whereas attributes l and r hold the left and right subtrees of the binary tree, respectively.

For the purpose of entering your own test cases, you can denote a tree recursively in the following way.
An empty binary tree is denoted by None. A non-empty tree is denoted as (X, L, R), where X is the
value contained in the root and L and R denote the left and right subtrees, respectively.
The tree from the above figure can be denoted as:

  (5, (3, (20, (6, None, None), None), None), (10, (1, None, None), (15, (30, None, (9, None, None)),
  (8, None, None))))
Assumptions
Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
the height of tree T (number of edges on the longest path from root to leaf) is within the range [0..800].
     */


    static class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }

    static Tree newTree(int x) {
        Tree temp = new Tree();

        temp.x = x;
        temp.l = null;
        temp.r = null;

        return temp;
    }

    public static int solution(Tree T) {
        // write your code in Java SE 8

        ArrayList<Tree> output = longestPath(T);
        int n = output.size();

        System.out.println("");
        System.out.print(output.get(n - 1).x);
        for(int i = n - 2; i >= 0; i--)
        {
            System.out.print(" -> " + output.get(i).x);
        }
        System.out.println();
        int count = getCount(output);

        return count;
    }

//    public static void changeStatus(){
//        if (status == 1)
//            status = 0;
//        else
//            status = 1;
//    }

    public static int getCount(ArrayList<Tree> path) {

        int count = 0;

        int n = path.size();

        Tree root = new Tree(), parent = new Tree(), parentsParent;
        for (int i = n - 1; i >= 0; i--) {

            if (i - 1 >= 0 && i - 2 >= 0) {
                root = path.get(i - 2);
                parent = path.get(i - 1);
            }
            parentsParent = path.get(i);

            if ((parentsParent.r == parent && parent.l == root) || (parentsParent.l == parent && parent.r == root))
                count++;
        }

        return count;
    }

    public static int reverseStatus(int status) {
        if (status == 1)
            status = 0;
        else
            status = 1;
        return status;
    }

//    public static int longestPath(Tree root, Tree parent, Tree parentsParent, int count) // 1 for right and 0 for left
//    {
//
//        // If root is null means there
//        // is no binary tree so
//        // return a empty vector
//        if (root == null) {
////            count--;
//            ArrayList<Tree> output = new ArrayList<>();
//            return count;
//        }
//
////        changeStatus();
//        // Recursive call on root.right
//        count = longestPath(root.r, root, root.parent, count);
//
//        if (parentsParent.r == parent && parent.l == root)
//            count++;
//
////        changeStatus();
//        // Recursive call on root.left
////        ArrayList<Tree> left = longestPath(root.l, root, root.parent, count);
//        count = longestPath(root.l, root, root.parent, count);
//
//        if (parentsParent.l == parent && parent.r == root)
//            count++;
//
//
//        // Compare the size of the two ArrayList
//        // and insert current node accordingly
////        if(right.size() < left.size())
////        {
////            left.add(root);
////        }
////        else
////        {
////            right.add(root);
////        }
//
////        Tree countTree = new Tree();
////        countTree.x = count;
////
////        left.add(countTree);
////        right.add(countTree);
//
//
//        // Return the appropriate ArrayList
////        return (left.size() > right.size() ? left :right);
//        return count;
//    }

    public static ArrayList<Tree> longestPath(Tree root) {

        // If root is null means there
        // is no binary tree so
        // return a empty vector
        if (root == null) {
            ArrayList<Tree> output = new ArrayList<>();
            return output;
        }

        // Recursive call on root.right
        ArrayList<Tree> right = longestPath(root.r);

        // Recursive call on root.left
        ArrayList<Tree> left = longestPath(root.l);

        // Compare the size of the two ArrayList
        // and insert current node accordingly
        if (right.size() < left.size()) {
            left.add(root);
        } else {
            right.add(root);
        }

        // Return the appropriate ArrayList
        return (left.size() >
                right.size() ? left : right);
    }

    public static void main(String[] args) {

        Tree root = newTree(5);
//        root.parent.parent = new Tree();
        root.l = newTree(3);
        root.l.l = newTree(20);
        root.l.l.l = newTree(6);
        root.r = newTree(10);
        root.r.l = newTree(1);
        root.r.r = newTree(15);
        root.r.r.l = newTree(30);
        root.r.r.r = newTree(8);
        root.r.r.l.r = newTree(9);

//        ArrayList<Tree> output = longestPath(root, root, root);
//
//        int n = output.size();
//
//        int count = output.get(1).x;
////        int rightCount = output.get(2).x;
//
//        System.out.print("this is count: " + count);
////        System.out.print(" this is left count: " + leftCount);
//
//        System.out.println("");
//        System.out.print(output.get(n - 1).x);
//        for(int i = n - 2; i >= 0; i--)
//        {
//            System.out.print(" -> " + output.get(i).x);
//        }

        System.out.println(solution(root));
    }

}
