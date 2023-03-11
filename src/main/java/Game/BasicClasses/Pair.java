package Game.BasicClasses;

public class Pair<T1,T2> {
    public T1 t1;
    public T2 t2;

    public T1 first(){
        return(t1);
    }
    public T2 second(){
        return(t2);
    }

    public Pair(T1 t1in, T2 t2in){
        this.t1 = t1in;
        this.t2 = t2in;
    }
}
