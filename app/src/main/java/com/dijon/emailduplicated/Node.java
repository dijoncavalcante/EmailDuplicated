package com.dijon.emailduplicated;

public class Node {
    Object date;
    Node next;
    private Person person;
    private Node next_;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Node getNext_() {
        return next_;
    }

    public void setNext_(Node next_) {
        this.next_ = next_;
    }

    public Node(Person person) {
        this.person = person;
        this.next_ = null;
    }
}
