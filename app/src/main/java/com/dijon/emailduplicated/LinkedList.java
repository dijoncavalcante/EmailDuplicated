package com.dijon.emailduplicated;

import java.io.Serializable;
import java.util.Collection;

public class LinkedList  implements Serializable {
    Node head;

    public LinkedList() {

    }

    public LinkedList(Collection collection) {

    }

    public void insert(int date) {
        Node node = new Node();
        node.date = date;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void insertAtStart(int data) {
        Node node = new Node();
        node.date = data;
        node.next = null;
        node.next = head;
        head = node;
    }

    public void insertAt(int index, int data) {
        if (index == 0) {
            insertAtStart(data);
        } else {
            Node node = new Node();
            node.date = data;
            node.next = null;
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    public void deleteAt(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node n = head;
            Node n1 = null;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
        }
    }

    public void show() {
        Node n = head;
        while (n.next != null) {
            System.out.println(n.date);
            n = n.next;
        }
        System.out.println(n.date);
    }
}
