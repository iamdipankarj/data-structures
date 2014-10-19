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
    bool rightThread;

    /** Thread **/
};

bool isIdentical(TreeNode *a, TreeNode * b) {
    if (a == NULL && b == NULL) return true;
    if (a!=NULL && b!=NULL)
        return a->data == b->data && isIdentical(a->left, b->left) && isIdentical(a->right, b->right);
    return false;
}

/** Get size of tree **/
int getSize(TreeNode *root) {
    if (root == NULL) return 0;
    return getSize(root->left) + getSize(root->right) + 1;
}

/** Inorder **/
void inorder(TreeNode *root) {
    if (root == NULL) return;

    inorder(root->left);
    cout << root->data << " ";
    inorder(root->right);
}

int height(TreeNode *root) {
    if (root == NULL) return 0;
    unsigned lheight = height(root->left);
    unsigned rheight = height(root->right);

    if (lheight > rheight)
        return lheight+1;
    else
        return rheight+1;
}

void mirror(TreeNode *root) {
    if (root == NULL) return;
    TreeNode *temp = root;

    mirror(root->left);
    mirror(root->right);

    temp = root->left;
    root->right = root->left;
    root->left = temp;
}

bool isSumTree(TreeNode *root) {
    int left_data = 0, right_data = 0;

    if(root == NULL || (root->left == NULL && root->right == NULL)){
        return true;
    } else {

        if(root->left != NULL)
            left_data = root->left->data;

        if(root->right != NULL)
            right_data = root->right->data;

        if ((root->data == left_data + right_data) && isSumTree(root->left) && isSumTree(root->right))
            return true;
        else
            return false;
    }
}

int main() {

    TreeNode *root = new TreeNode(10);

    root->left = new TreeNode(8);
    root->right = new TreeNode(2);

    root->left->left = new TreeNode(3);
    root->left->right = new TreeNode(5);

    cout << isSumTree(root);


    return 0;
}


