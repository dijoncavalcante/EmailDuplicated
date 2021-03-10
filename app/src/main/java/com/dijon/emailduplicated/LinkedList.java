package com.dijon.emailduplicated;

import java.io.Serializable;

public class LinkedList implements Serializable {

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

        newNode.setNext(this.first);
        this.first = newNode;
        this.quantity++;
    }

    public void inserirLast(Person p) {
        Node newNode = new Node(p);

        if (listNull()) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
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
                current = current.getNext();
            }

            if (current == this.first) {
                if (this.first == this.last) {
                    this.last = null;
                }
                this.first = this.first.getNext();
            } else {
                if (current == this.last) {
                    this.last = previous;
                }
                previous.setNext(current.getNext());
            }
            this.quantity--;
            return true;
        }
    }

    public String searchNode(String email) {
        Node current = this.first;
        while ((current != null) && (!current.getPerson().getEmail().equals(email))) {
            current = current.getNext();
        }
        return "Email: " + current.getPerson().getEmail();
    }

    public String showList() {
        String message = "";

        if (listNull()) {
            message = "List is null";
        } else {
            Node current = this.first;

            while (current != null) {
                message += current.getPerson().getEmail() + "\n";
                current = current.getNext();
            }
        }

        return message;
    }


    public boolean listNull() {
        return (this.first == null);
    }

}