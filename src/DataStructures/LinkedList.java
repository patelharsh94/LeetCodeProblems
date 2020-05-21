package DataStructures;

import org.junit.Test;

import javax.swing.*;
import javax.swing.event.ListDataListener;

class ListNode {

    int val;
    ListNode next;

    ListNode() {
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        super();
        this.val = val;
    }
}

public class LinkedList {

    ListNode head = null;

    LinkedList(int val) {
        this.head = new ListNode(val);
    }

    public void addInFront(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        head = newHead;
    }

    public void addInBack(int val) {

        ListNode tail = new ListNode(val);
        ListNode curr = head;

        while (curr.next != null)
            curr = curr.next;

        curr.next = tail;
    }

    public void addBeforeNum(int num, int val) {

        ListNode addedNode = new ListNode(val);

        ListNode curr = head;

        if (curr == null) {
            head = addedNode;
        }

        if (curr != null && curr.val == num) {
            addedNode.next = head;
            head = addedNode;
        }

        while (curr != null) {
            addedNode = new ListNode(val);
            if (curr.next != null && curr.next.val == num) {
                addedNode.next = curr.next;
                curr.next = addedNode;
                curr = curr.next;
            }
            curr = curr.next;
        }

    }

    public void deleteAllOccurance(int val) {

        ListNode curr = head;

        if (curr == null) {
            return;
        } else if (curr.val == val) {

            ListNode trav = curr;

            while (trav.next != null && trav.val == val) {
                trav = trav.next;
            }

            head = trav;

        } else {

            while (curr != null) {

                if (curr.next != null && curr.next.val == val) {

                    ListNode trav = curr;

                    while (trav.next != null && trav.next.val == val) {
                        trav = trav.next;
                    }

                    curr.next = trav.next;
                }
                curr = curr.next;
            }
        }

    }

    public void printList() {

        ListNode curr = head;

        while (curr != null) {
            System.out.print(" " + curr.val + " --> ");
            curr = curr.next;
        }

        System.out.print("/-");
        System.out.println();
    }

    public static void addInFrontTest() {

        System.out.println("Adding in front start ");
        LinkedList list = new LinkedList(5);
        list.addInFront(4);
        list.addInFront(3);
        list.addInFront(2);
        list.addInFront(1);

        list.printList();

        System.out.println("Adding in front end");
    }

    public static void addInBackTest() {

        System.out.println("Adding in back start");

        LinkedList list = new LinkedList(1);
        list.addInBack(2);
        list.addInBack(3);
        list.addInBack(4);
        list.addInBack(5);

        list.printList();

        System.out.println("Adding in back end");
    }

    public static void addBeforeTest() {
        System.out.println("Adding before start ");
        LinkedList list = new LinkedList(5);
        list.addInFront(3);
        list.addInFront(2);
        list.addInFront(1);
        list.addInFront(5);

        list.addBeforeNum(5, 4);
        list.printList();

        System.out.println("Adding before end");
    }

    public static void deleteTest() {
        System.out.println("Delete start ");
        LinkedList list = new LinkedList(5);
        list.addInFront(4);
        list.addInFront(4);
        list.addInFront(4);
        list.addInFront(3);
        list.addInFront(2);
        list.addInFront(1);


        list.deleteAllOccurance(4);
        list.deleteAllOccurance(5);
        list.deleteAllOccurance(1);
        list.printList();

        System.out.println("Delete end");
    }



    public static void main(String[] args) {
        addInFrontTest();
        addInBackTest();
        addBeforeTest();
        deleteTest();
    }
}

