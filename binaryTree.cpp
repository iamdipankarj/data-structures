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

    /** Get size of tree **/
    int getSize(TreeNode *root) {
        if (root == NULL) return 0;
        return getSize(root->left) + getSize(root->right) + 1;
    }
};

int main() {

    TreeNode *root = new TreeNode(1);

    TreeNode *two = root->left = new TreeNode(2, root);

    TreeNode *three = root->right = new TreeNode(3, root);

    TreeNode *four = two->left = new TreeNode(4, root);

    std::cout << root->getSize(root);

    return 0;
}


