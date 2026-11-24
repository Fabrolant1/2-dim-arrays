public class Stacktest {

    Stack<String> toDo = new Stack<>();
    //String[] toDO = new String[2];

    public Stacktest(){
        toDo.push("Zimmer aufräumen");
        toDo.push("Müll rausbringen");
        toDo.push("Hausaufgaben machen");
        toDo.push("Info lernen");
        System.out.println(toDo.top());
        for (int i=0; i<4; i++){
            System.out.println(toDo.top());
            toDo.pop();
        }
        toDo.push("Zimmer aufräumen");
        toDo.push("Müll rausbringen");
        toDo.push("Hausaufgaben machen");
        toDo.push("Info lernen");
        System.out.println(toDo.length());
        int x=toDo.length();
        for (int i=0; i<x; i++){
            System.out.println(toDo.top());
            toDo.pop();
        }
        toDo.push("Zimmer aufräumen");
        toDo.push("Müll rausbringen");
        toDo.push("Hausaufgaben machen");
        toDo.push("Info lernen");
        System.out.println(toDo.length());
    }

}
