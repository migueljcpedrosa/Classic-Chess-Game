package Game.BasicClasses;

public class SamePair<T> {
    public T t1;
    public T t2;

    public T first(){
        return(t1);
    }
    public T second(){
        return(t2);
    }

    public SamePair(T t1in, T t2in){
        this.t1 = t1in;
        this.t2 = t2in;
    }

    public T get(boolean l){
        if(l) return this.first();
        return this.second();
    }
}
