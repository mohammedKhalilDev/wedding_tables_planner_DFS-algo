import java.util.*;
public class Number_of_tables {
static class Graph {
int vertices;
LinkedList<Integer>[] the_guests;
public Graph(int vertices) {
this.vertices = vertices;
            the_guests = new LinkedList[vertices];
for (int i = 0; i < vertices; i++) {
                the_guests[i] = new LinkedList<>();
            }
        }
public void add_edge(int source, int destination) {
            the_guests[source].addFirst(destination);
            the_guests[destination].addFirst(source);
        }
public int count_tables() {
boolean[] done = new boolean[vertices];
int vertex,count = 0;
while((vertex = check_table_visited(done))!=-1){
                dfs(vertex, done);
                count++;
            }
return count;
        }
public int check_table_visited(boolean[] done){
for (int i = 0; i <done.length ; i++) {
if(!done[i])
return i;
            }
return -1;
        }
public void dfs(int vertex, boolean[] done) {
            done[vertex] = true;
for (int i = 0; i < the_guests[vertex].size(); i++) {
int destination = the_guests[vertex].get(i);
if (!done[destination])
                    dfs(destination, done);
            }
        }
    }
public static void main(String[] args) {
    Scanner get=new Scanner(System.in);
    System.out.println("please enter the number of all guests");
        int all=get.nextInt();
        Graph graph = new Graph(all);
        int i,f;
        char fr;
        char guest;
        char []guests=new char[all];
        for(i=0;i<all;i++){
            System.out.println("please enter the guest number"+ i+1);
             guest=get.next().charAt(0);
             guests[i]=guest;
        }
                for(i=0;i<all;i++){
                            System.out.println("please enter the number of friends of guest "+ i+1);
                            f =get.nextInt();
                            for(int j=0;j<f;j++){
                                System.out.println("please enter the  friend number :"+f+1+" of guest :"+guests[i]);
                                fr=get.next().charAt(0);
                                for(int k=0;k<all;k++){
                                    if(guests[k]==fr)
                                graph.add_edge(i,k);    
                            }
                            }
                }

    
System.out.println("Number of needed tables is: " + graph.count_tables());
    }
}
