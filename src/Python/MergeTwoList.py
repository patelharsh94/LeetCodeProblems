class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def buildList(nums):

    listNodes = []

    for i in nums:
        listNodes.append(ListNode(i, None))

    for i in range(len(listNodes)):

        if i < len(listNodes)-1:
            listNodes[i].next = listNodes[i+1]


    return listNodes[0]

def testMergeTwoList():

    list1 = buildList([1, 2, 4])
    list2 = buildList([1, 3, 5])

    l1, l2 = list1, list2
    while l1 and l2:

        if l1.val <= l2.val:
            temp = l1.next
            l1.next = l2
            l2 = temp
            l1 = l1.next
        else:
            temp = l2.next
            list2.next = l1
            l1 = temp
            l2 = l2.next

    if l1:
        return list1
    else:
        return list2


def testReOrderList():

    head = buildList([1, 2, 3])
    # head = buildList([0, 1, 2, 3, 4, 5, 6])

    slow, fast = head, head.next

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    prev, curr = None, slow.next
    while curr:
        temp = curr.next
        curr.next = prev
        prev = curr
        curr = temp

    slow.next = None
    slow = head

    while prev:
        tmp1 = slow.next
        tmp2 = prev.next

        slow.next = prev
        prev.next = tmp1
        prev = tmp2
        slow = tmp1

    return head


def testLinkedListCycle():
    four = ListNode(4, None)
    three = ListNode(3, four)
    two = ListNode(2, three)
    head = ListNode(1, two)

    four.next = two

    visited = []
    a = head

    while a:
        if a.val not in visited:
            visited.append(a.val)
        else:
            return True

        a = a.next

    return False



