import java.util.*;


public class Solution {

    static void displayPathtoPrincess(int n, String [] grid){


        String[] splittedGrid = new String[n*n];
        int j=0;
        int princesse = -1;
        int hero = -1;
        int[][] positions= new int[2][2];

        for(int i=0;i<grid.length;i++){
            String[] temp = grid[i].split("");
            for(int t=0;t<temp.length;t++) {
                splittedGrid[j] = temp[t];
                if(temp[t].equals("p"))
                    princesse = j;
                if(temp[t].equals("m"))
                    hero = j;
                j++;
            }


        }

        positions[0][0] = get(hero,true,n);
        positions[0][1] = get(hero,false,n);
        positions[1][0] = get(princesse,true,n);
        positions[1][1] = get(princesse,false,n);

        int idiff = positions[0][0] - positions[1][0];
        int jdiff = positions[0][1] - positions[1][1];

        display(idiff,jdiff);



    }

    static int get(int index,boolean x,int n)
    {
        return x?(index/n):(index%n);
    }

    static void display(int idiff,int jdiff){
        StringBuilder sb = new StringBuilder();
        if(idiff < 0){
            int i = 0;
            while(i< -idiff){
                sb.append("DOWN\n");
                i++;
            }
        }
        else {
            int i = 0;
            while(i< idiff){
                sb.append("UP\n");
                i++;
            }
        }

        if(jdiff < 0){
            int i = 0;
            while(i< -jdiff){
                sb.append("RIGHT\n");
                i++;
            }
        }
        else {
            int i = 0;
            while(i< jdiff){
                sb.append("LEFT\n");
                i++;
            }
        }
        System.out.println(sb);
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

        displayPathtoPrincess(m,grid);
    }
}
