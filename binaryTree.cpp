#include<iostream>
#include<string>

using namespace std;

 struct TreeNode {
    TreeNode(const int & item, TreeNode *parentNode = NULL) : left(NULL), right(NULL) {
        data = item;
        parent = parentNode;
    }
    int data;
    TreeNode *left, *right, *parent;
};

int main() {

    TreeNode *root = new TreeNode(1);

    TreeNode *two = root->left = new TreeNode(2, root);

    TreeNode *three = root->right = new TreeNode(3, root);

    TreeNode *four = two->left = new TreeNode(4, root);

    return 0;
}


