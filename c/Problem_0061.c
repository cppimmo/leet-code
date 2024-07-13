static size_t ListLength(struct ListNode *const pNode);
static struct ListNode *PeekLast(struct ListNode *const pHead);
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* rotateRight(struct ListNode* head, int k) {
    typedef struct ListNode ListNode_t;
    // No changes needed for NULL head, single-node list, or zero rotations
    if (head == NULL || head->next == NULL || k == 0)
    {
        return head;
    }

    const size_t kLength = ListLength(head);
    k = k % kLength; // Cap the rotations to the list length
    // Evenly disivible by length means that no changes are needed
    if (k == 0)
    {
        return head;
    }

    ListNode_t *pOldTail = PeekLast(head);
    // Find the new tail node which will be before the tail node prior to rotation
    ListNode_t *pNewTail = head;
    for (int i = 0; i < (kLength - k - 1); i++)
    {
        pNewTail = pNewTail->next;
    }

    ListNode_t *pNewHead = pNewTail->next; // Connect the new tail to the head (kLength - k)
    pOldTail->next = head; // Make the list circular
    pNewTail->next = NULL; // Snap off the new tail
    return pNewHead;
}

size_t ListLength(struct ListNode *const pNode)
{
    size_t length = 0;
    for (struct ListNode *pHead = pNode; pHead != NULL; pHead = pHead->next, length++);
    return length;
}

struct ListNode *PeekLast(struct ListNode *const pHead)
{
    struct ListNode *pResult = pHead;
    for (; pResult->next != NULL; pResult = pResult->next);
    return pResult;
}
