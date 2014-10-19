#include<iostream>

 struct TreeNode {
    TreeNode(const int & item) {
        data = item;
    }
    int data;
    TreeNode *left, *right, *parent;
};

int main() {

    TreeNode *root = new TreeNode(2);
    root->left = NULL;
    root->right = NULL;

    return 0;
}



