package com.dijon.emailduplicated;

import java.io.Serializable;

public class Node implements Serializable {
    private Person person;
    private Node next;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(Person person) {
        this.person = person;
        this.next = null;
    }

}