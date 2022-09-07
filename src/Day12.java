
import java.util.*;
import java.io.*;
import java.lang.*;
public class Day12 {


    Map<String, ArrayList<String>> graph = new HashMap<>();


    public void parse() throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("Day12.in"));


        String curline;

        while((curline = br.readLine()) != null){
            ArrayList<String> spl = new ArrayList<>(Arrays.stream(curline.split("-")).toList());
            String left = spl.get(0);
            String right = spl.get(1);
            if(graph.containsKey(left)){
                ArrayList<String> curvals = graph.get(left);
                curvals.add(right);
                graph.put(left, curvals);
            }else{
                ArrayList<String> newvals = new ArrayList<>();
                newvals.add(right);
                graph.put(left, newvals);

            }

            if(graph.containsKey(right)){
                ArrayList<String> curvals = graph.get(right);
                curvals.add(left);
                graph.put(right, curvals);
            }else{
                ArrayList<String> newvals = new ArrayList<>();
                newvals.add(left);
                graph.put(right, newvals);

            }



        }






    }


    public void run1(){

        for(String node: graph.keySet()){
            System.out.println(node+ " "+ graph.get(node));
        }

        //System.out.println(is_small("abc"));

        bfs();




    }

    public void bfs(){


        ArrayList<ArrayList<String>> q = new ArrayList<>();

        ArrayList<String> start = new ArrayList<>();
        start.add("start");


        q.add(start);
        int count = 0;

        while(!q.isEmpty()){
            //System.out.println(q + " CURRENT STATE");
            ArrayList<String> ne = q.remove(0);

            String last = ne.get(ne.size()-1);
            //System.out.println("REMOVED "+ne+ " LAST: "+last);

            for(String pos: graph.getOrDefault(last, new ArrayList<String>())){
                //System.out.println("CHECKING "+pos+ " "+ne+ " "+ is_small(pos));
                if(is_small(pos) && !ne.contains(pos)){
                    ArrayList<String> cop = new ArrayList<>(ne);
                    cop.add(pos);

                    if(pos.equals("end")){

                        System.out.println(cop);
                        count++;
                    }else{
                        //System.out.println("ADDED "+cop);
                        q.add(new ArrayList<>(cop));
                    }


                }
                else if(!is_small(pos)){
                    ArrayList<String> cop = new ArrayList<>(ne);
                    cop.add(pos);
                    q.add(new ArrayList<>(cop));

                }


            }




        }



        System.out.println(count);

    }


    public void bfs2(){



        ArrayList<ArrayList<String>> q = new ArrayList<>();

        ArrayList<String> start = new ArrayList<>();
        start.add("0");
        start.add("start");


        q.add(start);
        int count = 0;

        while(!q.isEmpty()){
            //System.out.println(q + " CURRENT STATE");
            ArrayList<String> ne = q.remove(0);

            String last = ne.get(ne.size()-1);
            //System.out.println("REMOVED "+ne+ " LAST: "+last);

            for(String pos: graph.getOrDefault(last, new ArrayList<String>())){
                //System.out.println("CHECKING "+pos+ " "+ne+ " "+ is_small(pos));
                if(is_small(pos) && !pos.equals("start")){
                    // Two cases, one if the first element is a 1 and one if it's a zero

                    if(ne.get(0).equals("0")){
                        // Valid to have two occs of small saves
                        // Two cases, if pos is not in ne, then zero doesn't change
                        ArrayList<String> cop = new ArrayList<>(ne);

                        if(!ne.contains(pos)){
                            // Don't change the flag;
                            cop.add(pos);
                            if(pos.equals("end")){
                                System.out.println(cop);
                                count++;
                            }else{
                                q.add(new ArrayList<>(cop));
                            }


                        }else{
                            cop.set(0, "1");
                            cop.add(pos);
                            if(pos.equals("end")){
                                System.out.println(cop);
                                count++;
                            }else{
                                q.add(new ArrayList<>(cop));
                            }


                        }




                    }else{
                        // valid to have one small cave only

                        if(!ne.contains(pos)){
                            ArrayList<String> cop = new ArrayList<>(ne);
                            cop.add(pos);

                            if(pos.equals("end")){

                                System.out.println(cop);
                                count++;
                            }else{
                                //System.out.println("ADDED "+cop);
                                q.add(new ArrayList<>(cop));
                            }



                        }
                    }





                }
                else if(!is_small(pos)){
                    ArrayList<String> cop = new ArrayList<>(ne);
                    cop.add(pos);
                    q.add(new ArrayList<>(cop));

                }


            }




        }



        System.out.println(count);

    }

    public void run2(){
        bfs2();
    }
    public boolean is_small(String cavename){
        return cavename.toLowerCase().equals(cavename);


    }


    public static void main(String[] args) throws IOException{
        Day12 day = new Day12();
        day.parse();
        day.run1();
        day.run2();

    }
}
