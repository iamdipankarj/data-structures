#include<iostream>

class BinaryTree {
private:
    struct TreeNode {
        TreeNode(const int & item) {
            data = item;
        }
        int data;
        TreeNode *left, *right, *parent;
    };

    TreeNode *root;
public:
    BinaryTree(const int & item) {
        TreeNode *node = new TreeNode(item);
        node->data = item;
        node->parent = NULL;
        node->left = NULL;
        node->right = NULL;
        root = node;
    }

    int addLeft(const int & item) {
        TreeNode *node = new TreeNode(item);
        node->left = NULL;
        node->right = NULL;
    }
};

int main() {

    BinaryTree tree(2);
    tree.addLeft(25);

    return 0;
}
