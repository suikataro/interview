package LinkedList.RemoveDuplicates;
/*
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node. Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

Hint: 只给要被删除的结点和没有前继指针？怎么删？其实变相思考，不删结点而是交换值就好了。一开始把所有要删除结点之后的结点值都往前移动一位，实际上复杂了。只需将要删除结点的下一个结点值拷过来，然后删掉下一个结点就可以了。
 */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
