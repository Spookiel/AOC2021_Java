package utils;
import java.util.*;
import java.lang.Comparable;
public class Point2D implements Comparable<Point2D> {

    public int x;
    public int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;



    }
    @Override
    public int compareTo(Point2D o){
        if(o.x == this.x){
            return (o.y > this.y) ? -1: 1;
        }

        return (o.x > this.x) ? -1: 1;


    }



    @Override
    public String toString(){


        return "{"+this.x+","+this.y+"}";
    }

    public void add(Point2D ap){
        this.x += ap.x;
        this.y += ap.y;

    }

    public void sub(Point2D ap){
        this.x -= ap.x;
        this.y -= ap.y;

    }
    public void foldalong_x(int x){
        //Fold along line x = x


        this.x = x+(x-this.x);
    }

    public void foldalong_x(int x, boolean lhalf){
        //Fold objects on right of line only along line x = x


        if(this.x >= x) this.x = x+(x-this.x);
    }

    public void foldalong_y(int y){
        // Fold along line y = ...
        this.y = y+(y-this.y);
    }
    public void foldalong_y(int y, boolean uhalf){
        // Fold objects below this line up along line y = ...
        if(this.y >= y) this.y = y+(y-this.y);
    }



}
