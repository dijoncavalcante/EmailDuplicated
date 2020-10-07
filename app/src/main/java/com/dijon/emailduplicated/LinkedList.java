package com.dijon.emailduplicated;

import java.io.Serializable;
import java.util.Collection;
import java.util.EmptyStackException;

public class LinkedList implements Serializable {
    Node head;
    private Node first;
    private Node last;
    private int quantity;

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.quantity = 0;
    }

    public void insertFirst(Person p) {
        Node newNode = new Node(p);

        if (this.listNull()) {
            this.last = newNode;
        }

        newNode.setnext(this.first);
        this.first = newNode;
        this.quantity++;
    }

    public void inserirLast(Person p) {
        Node newNode = new Node(p);

        if (listNull()) {
            this.first = newNode;
        } else {
            this.last.setnext(newNode);
        }
        this.last = newNode;
        this.quantity++;
    }

    public boolean removeNo(String email) {
        Node current = this.first;
        Node previous = null;

        if (listNull()) {
            return false;
        } else {
            while ((current != null) && (!current.getPerson().getEmail().equals(email))) {
                previous = current;
                current = current.getnext();
            }

            if (current == this.first) {
                if (this.first == this.last) {
                    this.last = null;
                }
                this.first = this.first.getnext();
            } else {
                if (current == this.last) {
                    this.last = previous;
                }
                previous.setnext(current.getnext());
            }
            this.quantity--;
            return true;
        }
    }

    public String searchNode(String email) {
        String message = "";
        Node current = this.first;
        while ((current !=null) && (!current.getPerson().getEmail().equals(email))){
            current = current.getnext();
        }
        return message = "Email: "+current.getPerson().getEmail();
    }


    public boolean listNull() {
        return (this.first == null);
    }

//    public void insert(int date) {
//        Node node = new Node();
//        node.date = date;
//        node.next = null;
//
//        if (head == null) {
//            head = node;
//        } else {
//            Node n = head;
//            while (n.next != null) {
//                n = n.next;
//            }
//            n.next = node;
//        }
//    }
//
//    public void insertAtStart(int data) {
//        Node node = new Node();
//        node.date = data;
//        node.next = null;
//        node.next = head;
//        head = node;
//    }
//
//    public void insertAt(int index, int data) {
//        if (index == 0) {
//            insertAtStart(data);
//        } else {
//            Node node = new Node();
//            node.date = data;
//            node.next = null;
//            Node n = head;
//            for (int i = 0; i < index - 1; i++) {
//                n = n.next;
//            }
//            node.next = n.next;
//            n.next = node;
//        }
//    }
//
//    public void deleteAt(int index) {
//        if (index == 0) {
//            head = head.next;
//        } else {
//            Node n = head;
//            Node n1 = null;
//            for (int i = 0; i < index - 1; i++) {
//                n = n.next;
//            }
//            n1 = n.next;
//            n.next = n1.next;
//        }
//    }
//
//    public void show() {
//        Node n = head;
//        while (n.next != null) {
//            System.out.println(n.date);
//            n = n.next;
//        }
//        System.out.println(n.date);
//    }
}
