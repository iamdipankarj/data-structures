#include<iostream>
using namespace std;

struct TreeNode {
    TreeNode(const int & item, TreeNode *parentNode = NULL) : left(NULL), right(NULL) {
        data = item;
        parent = parentNode;
    }
    int data;
    TreeNode *left, *right, *parent;
};

TreeNode *add(TreeNode *root, int key, TreeNode *parent = NULL) {

    if (root == NULL) return new TreeNode(key, parent);

    parent = root;

    if (key < root->data) {
        root->left = add(root->left, key, parent);
    }

    else if (key > root->data) {
        root->right = add(root->right, key, parent);
    }

    return root;
}

void inorder(TreeNode *root) {
    if (root == NULL) return;

    inorder(root->left);
    cout << root->data << " ";
    inorder(root->right);
}

int main() {

    TreeNode *root = new TreeNode(50);
    add(root, 30);
    add(root, 20);
    add(root, 40);
    add(root, 70);
    add(root, 60);
    add(root, 80);

    cout << root->left->left->parent->data;

    cout << endl;
    inorder(root);


    return 0;
}
