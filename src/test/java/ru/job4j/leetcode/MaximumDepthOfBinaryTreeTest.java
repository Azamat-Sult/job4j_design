package ru.job4j.leetcode;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MaximumDepthOfBinaryTreeTest {

    @Test
    public void test1() {
        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
        MaximumDepthOfBinaryTree.TreeNode node15 = new MaximumDepthOfBinaryTree.TreeNode(15, null, null);
        MaximumDepthOfBinaryTree.TreeNode node7 = new MaximumDepthOfBinaryTree.TreeNode(7, null, null);
        MaximumDepthOfBinaryTree.TreeNode node20 = new MaximumDepthOfBinaryTree.TreeNode(20, node15, node7);
        MaximumDepthOfBinaryTree.TreeNode node9 = new MaximumDepthOfBinaryTree.TreeNode(9, null, null);
        MaximumDepthOfBinaryTree.TreeNode root3 = new MaximumDepthOfBinaryTree.TreeNode(3, node9, node20);
        assertThat(tree.maxDepth(root3), is(3));
    }

}