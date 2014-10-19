#include<iostream>

class List {
private:
    struct ListNode {
        ListNode(const int & item) {
            data = item;
        }
        int data;
        ListNode *prev, *next;
    };
    ListNode *head, *last;

public:
    List() {
        head = NULL;
    }

    const int getFront() {
        if (head != NULL) return head->data;
        return 0;
    }

    void add(const int & item) {

        /** Allocate memory for new node**/
        ListNode *node = new ListNode(item);

        /** Set next field to null **/
        node->next = NULL;

        /** If list is empty make it head node **/
        if (head == NULL) {
            head = node;
            head->prev = NULL;
            last = head;
            return;
        }

        /** add new element to last **/
        last->next = node;

        /** new node's previous is the last **/
        node->prev = last;

        /** make this last the node of linked list **/
        last = node;
    }

    void del(const int & item) {
        if (head == NULL) return;

        /** If this is the head node **/
        if (head->data == item) {

            if (head->next == NULL) { /// If only one element in the list
                head = NULL;
            } else {
                head->next->prev = NULL;
                delete head;
                head = head->next;
            }
            return;
        }

        /** Else traverse through the list **/
        ListNode *temp = head, *current;

        while(temp != NULL && temp->data != item) {
            temp = temp->next;
            if (temp->next == NULL && temp->data != item) return;
        }

        /** Set prev pointer **/
        if (temp->next != NULL) { /// If this is not the last node
            temp->next->prev = temp->prev;
            temp->prev->next = temp->next;
            delete temp;
        }
        else { /// If this is the last node
            current = last;
            current->prev->next = NULL;
            current = current->prev;
            delete last;
            last = current;
        }
    }

    const int getBack() {
        if (head == NULL) return -1;
        return last->data;
    }

    void delBack() {
        ListNode *temp;
        last->prev->next = NULL;
        temp = last->prev;
        delete last;
        last = temp;
    }

    void print() {
        if (head == NULL) return;
        std::cout << "[";
        ListNode *temp = head;
        while(temp != NULL) {
            std::cout << temp->data;
            temp = temp->next;
            if(temp) std::cout << ", ";
        }

        std::cout << "]";
    }

    void printReverse() {
        if (head == NULL) return;
        std::cout << "[";
        ListNode *temp = last;
        while(temp != NULL) {
            std::cout << temp->data;
            temp = temp->prev;
            if(temp) std::cout << ", ";
        }

        std::cout << "]";
    }

};

int main() {

    List mylist;
    mylist.add(10);
    mylist.add(25);
    mylist.add(22);
    mylist.add(75);
    mylist.add(54);
    mylist.add(50);
    mylist.del(10);

    std::cout << std::endl << std::endl;

	return 0;
}

