

public class Stack<ContentType> {
    
    private class Stacknode{ //innere Klasse
        private ContentType content;
        private Stacknode nextNode;

        private Stacknode(ContentType pContent){
            content = pContent;
            nextNode = null;
        }
        public void setNext(Stacknode pNext){
            nextNode=pNext;
        }
        public Stacknode getNext(){
            return nextNode;
        }
        public ContentType getContent(){
            return content;
        }
    }

    private Stacknode head;
    public Stack(){
        head = null;
    }
    public boolean isEmpty(){
        return (head==null);
    }
    public void push(ContentType pContent){
        if (pContent != null){
            Stacknode node = new Stacknode(pContent);
            node.setNext(head);
            head=node;
        }
    }
    public ContentType top(){
        if (!this.isEmpty()){
            return head.getContent();
        }else{
            return null ;
        }
    }






}