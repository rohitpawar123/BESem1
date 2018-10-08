import java.util.*;
class ElectionCo {

    static ArrayList<Integer> process;
    static Queue<Integer> q=new LinkedList<Integer>();
    void startElection(int nodeNumber){
        int i, response=-1;
        boolean flag=false;
        System.out.println("\n===Node Number "+nodeNumber+"===");

        for(i=0;i<process.size();i++){

        	if(i!=nodeNumber)
        		System.out.println("Msg sent to Node "+i+" from Node "+nodeNumber);

            if(process.get(i)>process.get(nodeNumber) && process.get(i)!=-1){
                System.out.println("Node "+i+" is active");

                if(!q.contains(i)) {
                    q.add(i);
                }
                flag=true;
            }
            else {
                if(process.get(i)==-1 )
                    System.out.println("Node "+i+" is not active");

                else
                	if(i!=nodeNumber)
                		System.out.println("Node "+i+" is active");
            }
            
        }
        	System.out.println(q);
        if(!flag){
            
            System.out.println(nodeNumber+" is new coordinator");
            q.clear();

        }
    
        if(!q.isEmpty())
        	response=q.poll();
        if(response!=-1)
        {
        System.out.println("Node "+response+" sent OK Msg.");
        System.out.println("Node "+response+" is new coordinatior");

        	startElection(response);
        }
    }
    
    public static void main(String ...s){
        Scanner sc= new Scanner(System.in);
        process=new ArrayList<Integer>();
        System.out.println("Enter initial processes in nodes: ");
        for(int i=0;i<5;i++){
            System.out.print("Node "+(i)+": ");
            process.add(sc.nextInt());
            System.out.println();
        }
        int highestP= Collections.max(process);
        System.out.println("Node: "+process.indexOf(highestP)+" has highest no of processes");
        
        process.set(process.indexOf(highestP),-1);
        System.out.println("Node: "+process.indexOf(-1)+" is down. :"+process.get(process.indexOf(-1)));

        System.out.println("Enter Node to start relection: ");
        int initElectNode=sc.nextInt();

        
        new ElectionCo().startElection(initElectNode);
        System.out.println("Finally");
        
//        process.set(process.indexOf(-1),23);
//        new ElectionCo().startElection(initElectNode);
//        System.out.println("Finally");
         
    }
}



