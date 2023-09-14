public class MyLinkedList {

    //双链表
    class LinkNode{
        int val;
        LinkNode next;
        LinkNode prev;
        LinkNode(LinkNode prev,int val,LinkNode next){
            this.val=val;
            this.next=next;
            this.prev=prev;
        }

    }
    LinkNode head;//头哨兵
    LinkNode tail;//尾哨兵
    public MyLinkedList() {
        //初始化
        head=new LinkNode(null,66,null);
        tail=new LinkNode(null,66,null);
        head.next=tail;
        tail.prev=head;
    }

    public int get(int index) {
        int i=0;//遍历时链表的索引
        for(LinkNode p=head.next;p!=tail;p=p.next){
            if(i==index){
                return p.val;
            }
            i++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        LinkNode a=head;
        LinkNode b=head.next;
        LinkNode added=new LinkNode(a,val,b);
        a.next=added;
        b.prev=added;

    }

    public void addAtTail(int val) {
        LinkNode a=tail.prev;
        LinkNode added=new LinkNode(a,val,tail);
        a.next=added;
        tail.prev=added;
    }

    public void addAtIndex(int index, int val) {
        LinkNode p=head.next;
        int i=0;//遍历时链表的索引
        while(p!=tail){
            if(i==index){
                LinkNode a=p.prev;
                LinkNode b=p;
                LinkNode added=new LinkNode(a,val,b);
                a.next=added;
                b.prev=added;
            }
            i++;
            p=p.next;
        }
        if(i==index){
            addAtTail(val);
        }
    }


    public void deleteAtIndex(int index) {
        LinkNode p=head.next;
        int i=0;//遍历时链表的索引
        while(p!=tail){
            if(i==index){
                LinkNode a=p.prev;
                LinkNode b=p.next;
                a.next=b;
                b.prev=a;
                return;
            }
            i++;
            p=p.next;
        }
    }
}
