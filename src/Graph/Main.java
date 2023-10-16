/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        
    
    int[][]e={//a b c d e f g h i
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 0, 0, 0, 0},
                {1, 0, 0, 0 ,1, 0 ,0 ,0, 0},
                {0 ,1, 0, 0, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 1 ,0, 0, 0},
                {0 ,0 ,0 ,0, 0, 1, 0, 0 ,0},
                {0, 0, 0, 0, 0 ,0, 0, 0, 0},
            };
    int n = 9;
    MyGraph g = new MyGraph(n, e);
        System.out.println("breadth");
    g.breadth(2);
        System.out.println("\ndepth");
    g.Depth(2);
        System.out.println("\ndepth2");
    g.Depth2(2);
        System.out.println("\ndepth3");
    g.Depth3(2);
   }
}
