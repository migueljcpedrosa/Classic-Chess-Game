package Game.BasicClasses;

public class Position {
    private int x, y;

    public int getX(){
       return(this.x);
    }

    public int getY(){
        return(this.y);
    }

    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    /*public Position(){
        this(0,0);
    }*/

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Position)) return false;
        Position pos = (Position) obj;
        return(pos.getX()==this.getX() && pos.getY() == this.getY());
    }

    public Position move(int x, int y){
        return(new Position(this.x+x,this.y+y));
    }

    public boolean isValid(){
        return(this.x>=0 && this.x<8 && this.y>=0 && this.y<8);
    }

    public String printPos(){
        return "[" + x + "," + y + "]";
    }
}
