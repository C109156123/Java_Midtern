/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbtree;

/**
 *
 * @author User
 */
class Node {
    int key;
    boolean color;
    Node left, right, parent;

    public Node(int key) {
        this.key = key;
        color = true;
        left = right = parent = null;
    }
}

class RedBlackTree {

    Node root;

    public RedBlackTree() {
        root = null;
    }

    void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            root.color = false;
            return;
        }
        Node temp = root;
        Node parent = null;

