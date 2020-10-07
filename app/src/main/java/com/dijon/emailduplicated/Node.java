package com.dijon.emailduplicated;

public class Node {
//    Object date;
//    Node next;
    private Person person;
    private Node next;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Node getnext() {
        return next;
    }

    public void setnext(Node next) {
        this.next = next;
    }

    public Node(Person person) {
        this.person = person;
        this.next = null;
    }
}
