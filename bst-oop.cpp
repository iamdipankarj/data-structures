#include<iostream>
using namespace std;

class Node {
private:
    int data;
    Node *left;
    Node *right;
public:
    Node(int key) {
        data = key;
        left = NULL;
        right = NULL;
    }

    int getData() {
        return data;
    }

    Node *getLeft() {
        return left;
    }

    Node *getRight() {
        return right;
    }

    void setLeft(Node *lhs) {
        left = lhs;
    }

    void setRight(Node *rhs) {
        right = rhs;
    }

    Node *setData(int key) {
        data = key;
        return this;
    }
};

class Tree {
private:
    Node *root;
    Node *addHelper(Node *root, const int & key) {
        if(root == NULL) {
            root = new Node(key);
            return root;
        }
        if(key < root->getData())
            root->setLeft(addHelper(root->getLeft(), key));
        else
            root->setRight(addHelper(root->getRight(), key));
    }

    void inorderHelper(Node *root) {
        if (root) {
            inorderHelper(root->getLeft());
            cout << root->getData() << " ";
            inorderHelper(root->getRight());
        }
    }

public:
    Tree() {
        root = NULL;
    }

    Node *getRoot() {
        return root;
    }

    void add(int key) {
        if (root == NULL) {
            root = new Node(key);
            return;
        }
        addHelper(root, key);
    }

    void inorder() {
        if (root) inorderHelper(root);
    }
};


int main() {

    Tree tree;
    tree.add(50);
    tree.add(30);
    tree.add(20);
    tree.add(40);
    tree.add(70);
    tree.add(60);
    tree.add(80);
    tree.add(10);

    cout << tree.getRoot()->getLeft()->getLeft()->getLeft()->getData() << endl;

    tree.inorder();

    return 0;
}
