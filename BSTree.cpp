#include<iostream>
using namespace std;

class BST {
private:
    struct Node {
        Node(const int & key) : left(NULL), right(NULL) {
            data = key;
        }
        int data;
        Node *left, *right;
    };

    Node *root;
public:
    BST() {
        root = NULL;
    }

    void add(const int & key) {
        Node *node = new Node(key);
    }

    void leftView() {
        Node *temp = root;
        while(temp!=NULL) {
            cout << temp->data;
            temp = temp->left;
        }
    }

};

int main() {

    BST tree;

    tree.add(50);
    tree.add(30);
    tree.add(20);
    tree.add(40);
    tree.add(70);
    tree.add(60);
    tree.add(80);

    tree.leftView();

    return 0;
}
