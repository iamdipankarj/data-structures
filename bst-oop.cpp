#include<iostream>
using namespace std;

class Node {
private:
    int data;
    Node *left, *right, *parent;
public:
    Node(int key, Node *parentNode = NULL) : left(NULL), right(NULL) {
        data = key;
        parent = parentNode;
    }

    int getData() {
        return data;
    }

    Node *getParent() {
        return parent;
    }

    Node *getLeft() {
        return left;
    }

    Node *getRight() {
        return right;
    }

    Node * setLeft(Node *lhs) {
        left = lhs;
        return this;
    }

    Node * setRight(Node *rhs) {
        right = rhs;
        return this;
    }

    Node *setData(int key) {
        data = key;
        return this;
    }
};

class Tree {
private:
    Node *root;
    Node *addHelper(Node *root, const int & key, Node *parent = NULL) {
        if(root == NULL) {
            root = new Node(key, parent);
            return root;
        }
        parent = root;
        if(key < root->getData())
            root->setLeft(addHelper(root->getLeft(), key, parent));
        else
            root->setRight(addHelper(root->getRight(), key, parent));
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

    cout << tree.getRoot()->getLeft()->getLeft()->getParent()->getData() << endl;

    tree.inorder();

    return 0;
}
