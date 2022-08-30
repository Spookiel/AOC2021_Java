package utils;

import utils.Point2D;
public class Test {

    public static void main(String args[]){


        test_point2D();


    }

    public static boolean test_point2D(){
        Point2D myPoint = new Point2D(1, 5);
        myPoint.foldalong_x(5);

        int failed = 0;
        final int TESTS = 4;

        System.out.println("Testing Point2D with "+TESTS+ " test(s).");
        if(myPoint.x != 9 || myPoint.y != 5){
            System.out.println("--------------------"); // 20
            System.out.println("Failed test one. Reflect point (1,5) in line x");
            System.out.println("Should give (9,5), instead gives "+myPoint);
            System.out.println("--------------------"); // 20
            failed++;
        }

        Point2D myPoint2 = new Point2D(-1,5);
        myPoint2.foldalong_x(5);
        if(myPoint2.x != 11 || myPoint2.y != 5){
            System.out.println("--------------------"); // 20
            System.out.println("Failed test two. Reflect point (-1,5) in line x= 5");
            System.out.println("Should give (11,5), instead gives "+myPoint2);
            System.out.println("--------------------"); // 20
            failed++;
        }

        Point2D myPoint3 = new Point2D(-1,5);
        myPoint3.foldalong_x(-5);
        if(myPoint3.x != -9 || myPoint3.y != 5){
            System.out.println("--------------------"); // 20
            System.out.println("Failed test three. Reflect point (-1,5) in line x = -5");
            System.out.println("Should give (-9,5), instead gives "+myPoint3);
            System.out.println("--------------------"); // 20
            failed++;
        }


        Point2D myPoint4 = new Point2D(11,-1);
        myPoint4.foldalong_x(9, true);
        myPoint4.foldalong_y(1, true);
        if(myPoint4.x != -9 || myPoint4.y != 5){
            System.out.println("--------------------"); // 20
            System.out.println("Failed test four. Reflect point (-1,5) in line x = -5");
            System.out.println("Should give (-9,5), instead gives "+myPoint4);
            System.out.println("--------------------"); // 20
            failed++;
        }




        System.out.println("--------------------");
        if(failed > 0){
            System.out.println("Failed "+failed+"/"+TESTS+" tests.");
            return false;
        }else{
            System.out.println("Passed "+ TESTS+ " test(s).");
            return true;
        }







    }

}
