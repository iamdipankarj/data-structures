#include<iostream>
#include<string>

using namespace std;

class Node {
private:
    int data;
    Node *left, *right, *parent;
public:
    Node(const int & key) : left(NULL), right(NULL), parent(NULL) {
        data = key;
    }

    Node *getLeft() {
        return left;
    }

    Node *getRight() {
        return right;
    }

    Node *setLeft(Node *lhs) {
        left = lhs;
        return left;
    }

    Node *setRight(Node *rhs) {
        right = rhs;
        return right;
    }

    Node *getParent() {
        return parent;
    }

    int getData() {
        return data;
    }
};

class Tree {
private:
    Node *root;
public:
    Tree(const int & key) {
        root = new Node(key);
    }

    Node* getRoot() const {
        return root;
    }

    Node *add(const int & key) {
        return new Node(key);
    }

};

int main() {

    Tree tree(50);
    tree.getRoot()  ->setLeft(new Node(30)) ->setRight(new Node(18)) ->setLeft(new Node(20));

    cout << tree.getRoot()->getLeft()->getRight()->getLeft()->getData();

    return 0;
}


