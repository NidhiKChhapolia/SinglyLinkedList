package com.test;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;
        Node(int d){
            data= d;
            next=null;
        }
    }
    public void push(int newdata){
        Node newnode = new Node(newdata);
        newnode.next=head;
        head=newnode;
    }
    public void insertAfter (Node prevnode,int newdata){
        Node newnode = new Node(newdata);
        if(prevnode == null){
            System.out.println("The previous node cannot be null");
            return;
        }
        newnode.next = prevnode.next;
        prevnode.next=newnode;
    }
    public void append(int newdata){
        Node newnode = new Node(newdata);
        if(head == null){
            head = newnode;
            return;
        }
        Node last = head;
        while (last.next != null){
            last = last.next;
        }
        last.next = newnode;
        return;
    }
    public void printList(){
         Node n = head;
         while(n != null){
            System.out.print(n.data + " ");
            n=n.next;
        }
    }
    public void reverseList(){
        Node prev = null,temp=head,next=null;
        if(temp.next==null)
            head=temp;
        while (temp!=null){
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        head=prev;

    }
    public void deleteNode(int key){
        Node temp = head, prev=null;
        if(temp != null && temp.data== key){
            head= temp.next;
            return;
        }
        while(temp != null && temp.data!=key){
            prev= temp;
            temp= temp.next;
        }
        if(temp==null) return;

        prev.next=temp.next;
    }
    public void deletePosition(int pos){
        Node temp = head,prev=null;
        int count=0;
        if(pos == 0 && temp != null){
            head = head.next;
            return;
        }
        if(temp==null){
            System.out.println("temp is null cannot be deleted.");
            return;
        }
        for(int i=0; temp!=null && i<pos-1;i++){
            temp=temp.next;
        }
        prev = temp.next.next;
         temp.next=prev;
        /*while(temp!= null){
            prev=temp;
            temp = temp.next;
            count++;
            if(count == pos){
                prev.next=temp.next;
            }
        }*/
    }
    public boolean search(int x){
        Node temp = head;
        while (temp!=null){
            if(temp.data == x)
                return true;
            temp=temp.next;
       }
       if (temp==null) return false;
       return false;
    }
    public boolean searchreccur(Node node,int x){
        if (node == null)
            return false;
         if(node.data == x && node!=null)
                return true;
         else
             return (searchreccur(node.next,x));
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node (3);
        list1.head.next = second;
        second.next=third;
        list1.printList();
        System.out.println("instert element in first");
        list1.push(4);
        list1.push(5);
        list1.append(7);
        list1.printList();
        System.out.println("instert element in middle");
        list1.insertAfter(list1.head.next,10);
        list1.printList();
        System.out.println("instert element in last");
        list1.append(9);
        list1.printList();
        list1.deletePosition(5);
        System.out.println("delete the position");
        list1.printList();
        System.out.println("Searched data is " + list1.searchreccur(list1.head,7));
        System.out.println("Reverse string is ");
        list1.reverseList();
        list1.printList();
    }
}
