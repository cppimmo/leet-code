static size_t ListLength(struct ListNode *const pNode);
static struct ListNode *PeekLast(struct ListNode *const pNode);
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
    typedef struct ListNode ListNode_t;
    // Tail nodes differ, thus there is no intersection
    if (PeekLast(headA) != PeekLast(headB))
    {
        return NULL;
    }
    // Get the lengths of each list
    const size_t kLengthA = ListLength(headA), kLengthB = ListLength(headB);
    //printf("%ld %ld\n", kLengthA, kLengthB);
    ListNode_t *pA = headA, *pB = headB;
    if (kLengthA > kLengthB)
    {
        for (int i = 0; i < (kLengthA - kLengthB); i++)
            pA = pA->next;
    }
    else
    {
        for (int i = 0; i < (kLengthB - kLengthA); i++)
            pB = pB->next;
    }
    // Continue traversing the lists until the intersection is found
    while (pA != NULL && pB != NULL)
    {
        if (pA == pB)
            return pA;

        pA = pA->next;
        pB = pB->next;
    }
    return NULL; // No intersection
}

size_t ListLength(struct ListNode *const pNode)
{
    size_t length = 0;
    for (struct ListNode *pHead = pNode; pHead != NULL; pHead = pHead->next, length++);
    return length;
}

struct ListNode *PeekLast(struct ListNode *const pNode)
{
    struct ListNode *pHead = pNode;
    for (; pHead != NULL; pHead = pHead->next);
    return pHead;
}
