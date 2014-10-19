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

int main() {

    /** Root node: (2) **/
    TreeNode *root = new TreeNode(1);

    /** Left node: (5) **/
    TreeNode *two = root->left = new TreeNode(2, root);

    /** Right node: (8) **/
    TreeNode *three = root->right = new TreeNode(3, root);

    return 0;
}



