
package projetointerdisciplinar;

import Classes.Encryption;
import Classes.Matrix;

/**
 *
 * @author Dinei A. Rockenbach
 */
public class ProjetoInterdisciplinar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
//        Matrix ma24 = new Matrix(2, 4);
//        double[] line = {2,4,6,8};
//        ma24.setRow(line, 1);
//        double[] line2 = {10,12,14,16};
//        ma24.setRow(line2, 2);
//        ma24.showMatrix();
//        ma24.transpose();
//        ma24.showMatrix();
        
//        double[] line1= {4,4,5,2,1,2,5,2,1,1,7,8};
//        double[] line2= {5,4,2,2,1,3,2,3,2,2,5,6};
//        double[] line3= {8,5,2,2,2,1,1,5,4,2,2,1};
//        double[] line4= {4,8,0,2,2,1,1,4,5,2,2,3};
//        double[] line5= {0,4,2,2,0,5,2,8,2,5,21,9};
//        double[] line6= {1,1,4,2,0,0,8,0,8,2,5,1};
//        double[] line7= {3,4,4,4,4,7,8,7,8,4,4,1};
//        double[] line8= {1,3,2,1,3,2,2,2,2,22,3,1};
//        double[] line9= {3,21,2,3,2,2,2,2,2,3,2,1};
//        double[] line10= {3,12,2,2,2,22,2,7,2,2,2,1};
//        double[] line11= {3,3,3,2,2,2,2,2,2,2,2,2};
//        double[] line12= {3,3,12,2,2,1,2,1,2,8,7,9};
//
//        Matrix mat = new Matrix(12, 12);
//        mat.setRow(line1, 1);
//        mat.setRow(line2, 2);
//        mat.setRow(line3, 3);
//        mat.setRow(line4, 4);
//        mat.setRow(line5, 5);
//        mat.setRow(line6, 6);
//        mat.setRow(line7, 7);
//        mat.setRow(line8, 8);
//        mat.setRow(line9, 9);
//        mat.setRow(line10, 10);
//        mat.setRow(line11, 11);
//        mat.setRow(line12, 12);

//        double[] line1 = {2,3,1,0,5};
//        double[] line2 = {4,5,6,2,2};
//        double[] line3 = {-1,0,2,-3,3};
//        double[] line4 = {1,2,3,4,4};
//        double[] line5 = {1,54,1,2,4};
//        
//        Matrix mat = new Matrix(5, 5);
//        mat.setRow(line1, 1);
//        mat.setRow(line2, 2);
//        mat.setRow(line3, 3);
//        mat.setRow(line4, 4);
//        mat.setRow(line5, 5);
        
//        double[] line1 = {2,1};
//        double[] line2 = {-3,1};
//        double[] line3 = {4,0};
//        Matrix mat = new Matrix(3, 2);
//        mat.setRow(line1, 1);
//        mat.setRow(line2, 2);
//        mat.setRow(line3, 3);
//        
//        double[] line21 = {3,-3,4};
//        double[] line22 = {2,4,8};
//        Matrix mat2 = new Matrix(2, 3);
//        mat2.setRow(line21, 1);
//        mat2.setRow(line22, 2);
//        
//        Matrix newmat = mat.multiply(mat2);
//        newmat.showMatrix();
        
        
//        double[] line1 = {2,5,-3,-2};
//        double[] line2 = {-2,-3,2,-5};
//        double[] line3 = {1,3,-2,2};
//        double[] line4 = {-1,-6,4,3};
//        Matrix mat = new Matrix(4, 4);
//        mat.setRow(line1, 1);
//        mat.setRow(line2, 2);
//        mat.setRow(line3, 3);
//        mat.setRow(line4, 4);
//        System.out.println(mat.inverse());
//        System.out.println(mat.error);
        
//        double[] line1 = {6,2,0,-3};
//        double[] line2 = {4,-1,-2,2};
//        double[] line3 = {3,-2,0,5};
//        double[] line4 = {1,2,3,-2};
//        Matrix mat = new Matrix(4, 4);
//        mat.setRow(line1, 1);
//        mat.setRow(line2, 2);
//        mat.setRow(line3, 3);
//        mat.setRow(line4, 4);
////        System.out.println(mat.determinant());
//        Matrix ot = mat.inverse();
//        System.out.println(mat.error);
//        System.out.println(ot.showMatrix());
        
//        Matrix mat = new Matrix(3,3);
//        double[] line1 = {1,1,0};
//        mat.setRow(line1, 1);
//        double[] line2 = {1,0,1};
//        mat.setRow(line2, 2);
//        double[] line3 = {0,1,1};
//        mat.setRow(line3, 3);
//        double[] line4 = {-1,0,0,3};
//        mat.setRow(line4, 4);
//        Matrix inv = mat.inverse();
//        System.out.println(inv.showMatrix());
        
//        Matrix inv = new Matrix(2,2);
//        double[] inv_line1 = {2,1};
//        inv.setRow(inv_line1, 1);
//        double[] inv_line2 = {1,3};
//        inv.setRow(inv_line2, 2);
//        double[] inv_line3 = {-1/3, 4/3, -1/3};
//        inv.setRow(inv_line3, 3);
        
//        Matrix ot = mat.multiply(inv); // Isto tem que ser uma matrix identidade
//        System.out.println(ot.showMatrix());
        
//        int row = 3;
//        int col = 3;
//        System.out.println(mat.cofactor(row-1, col-1)*mat.getElement(row, col));
        
//        Matrix mat = new Matrix(11, 11);
//        double[] line1 = {2,4,0,5,3,7,8,9,4,1,2};
//        mat.setRow(line1, 1);
//        double[] line2 = {0,2,1,2,4,4,5,6,7,8,1};
//        mat.setRow(line2, 2);
//        double[] line3 = {3,1,2,1,12,3,-2,2,4,0,2};
//        mat.setRow(line3, 3);
//        double[] line4 = {1,2,3,1,5,4,0,5,6,7,2};
//        mat.setRow(line4, 4);
//        double[] line5 = {2,4,0,1,1,1,-2,2,4,0,2};
//        mat.setRow(line5, 5);
//        double[] line6 = {0,2,1,2,12,1,1,2,-3,-1,2};
//        mat.setRow(line6, 6);
//        double[] line7 = {3,1,2,2,4,0,1,2,1,-2,2};
//        mat.setRow(line7, 7);
//        double[] line8 = {1,2,1,-2,2,4,0,1,22,3,2};
//        mat.setRow(line8, 8);
//        double[] line9 = {2,4,0,1,4,0,1,2,13,-2,2};
//        mat.setRow(line9, 9);
//        double[] line10 = {0,2,1,2,1,0,11,2,3,-2,2};
//        mat.setRow(line10, 10);
//        double[] line11 = {3,1,2,8,7,5,4,8,9,5,7};
//        mat.setRow(line11, 11);
//        Matrix mat = new Matrix(15, 15);
//        double[] line1 = {2.123,4.412,0.123,5.454,3.548,7,8,9,4,1,2,5,6,8,7};
//        mat.setRow(line1, 1);
//        double[] line2 = {0,2,1,2,4,4,5,6,7,8,2,4,0,5,3};
//        mat.setRow(line2, 2);
//        double[] line3 = {3,1,2,1,12,3,-2,2,4,0,2,4,0,5,3};
//        mat.setRow(line3, 3);
//        double[] line4 = {1,2,3,1,5,4,0,5,6,7,2,4,0,5,3};
//        mat.setRow(line4, 4);
//        double[] line5 = {2,4,0,1,1,1,-2,2.15,4,0,2,4,0,5,3};
//        mat.setRow(line5, 5);
//        double[] line6 = {0,2,1,2,12,1,1,2,-3,-52,2,4,0,5,1};
//        mat.setRow(line6, 6);
//        double[] line7 = {3,1445,2,2,4,0,1,2,1233,-2,2,4,0,5,3};
//        mat.setRow(line7, 7);
//        double[] line8 = {1,2,123,-2,2,4,0,1,22,3,2,4,0,5,3};
//        mat.setRow(line8, 8);
//        double[] line9 = {2,4,0,2154,4,0,1,2,13,-2,2,4,0,5,3};
//        mat.setRow(line9, 9);
//        double[] line10 = {0,2,1,2,412,0,11,2,3,-2,2,4,0,1,3};
//        mat.setRow(line10, 10);
//        double[] line11 = {3,1,2,8,7,5,4,8,9,5,7,4,1,5,7};
//        mat.setRow(line11, 11);
//        double[] line12 = {1,2,3,-2,-4,5,8,7,6.2,5,4,2.1,2,5,8};
//        mat.setRow(line12, 12);
//        double[] line13 = {2,4,0,12,5,4,7,8,5,2,1,4,5,8,7};
//        mat.setRow(line13, 13);
//        double[] line14 = {0,2,1,1,4,5,8,7,9,5,4,124,54,24,13};
//        mat.setRow(line14, 14);
//        double[] line15 = {3,1,2,245,543,121,32,64,1,98,543,1,31,4,57};
//        mat.setRow(line15, 15);
//        double[] line16 = {1,2,3,-2};
//        mat.setRow(line16, 4);
//        double[] line17 = {2,4,0};
//        mat.setRow(line17, 1);
//        double[] line18 = {0,2,1};
//        mat.setRow(line18, 2);
//        double[] line19 = {3,1,2};
//        mat.setRow(line19, 3);
//        double[] line20 = {3,1,2};
//        mat.setRow(line20, 3);
        
//        double[] line1 = {2,3,1,0,5};
//        double[] line2 = {4,5,6,2,2};
//        double[] line3 = {-1,0,2,-3,3};
//        double[] line4 = {1,2,3,4,4};
//        double[] line5 = {1,54,1,2,4};
//        
//        Matrix mat = new Matrix(5, 5);
//        mat.setRow(line1, 1);
//        mat.setRow(line2, 2);
//        mat.setRow(line3, 3);
//        mat.setRow(line4, 4);
//        mat.setRow(line5, 5);
        
//        System.out.println(mat.showMatrix());
//        Matrix ot = mat.inverse();
//        System.out.println(mat.error + " - " + mat.error_dsc);
//        System.out.println(ot.showMatrix());
        
        
//        Matrix t = Matrix.random(200, 200);
//        System.out.println(t.showMatrix());
//        Matrix ot = t.inverse();
//        System.out.println(t.error + " - " + t.error_dsc);
//        System.out.println(ot.showMatrix());
        
//        Matrix mat = new Matrix(2,2);
//        double[] line1 = {3,1};
//        mat.setRow(line1, 1);
//        double[] line2 = {5,2};
//        mat.setRow(line2, 2);
        
//        Matrix mat = Matrix.random(20, 20);
//        
//        Encryption enc = new Encryption(mat);
//        String text = "DINEI ANDRÉ ROCKENBACH";
//        Matrix crypted = enc.encrypt(text);
//        System.out.println("Texto: " + enc.decrypt(crypted));

//        java.util.Timer tm = new java.util.Timer();
//        TimeUnit mc1 = TimeUnit.MICROSECONDS;
//        double r = 0;
//        for (int i = 0; i <= 10000000; i++) {
//            r = i/10;
//        }
//        long start, end;
        
        
        Matrix m7 = Matrix.random(7, 7);
        time(m7);
        time(m7);
        time(m7);
//        Matrix m8 = Matrix.random(8, 8);
//        time(m8);
//        time(m8);
//        time(m8);
//        Matrix m9 = Matrix.random(9, 9);
//        time(m9);
//        time(m9);
//        time(m9);
//        Matrix m10 = Matrix.random(10, 10);
//        time(m10);
//        time(m10);
//        time(m10);
//        Matrix m11 = Matrix.random(11, 11);
//        time(m11);
//        time(m11);
//        time(m11);
        
//        Matrix m20 = Matrix.random(20, 20);
////        System.out.println(m20.showMatrix());
//        time(m20);
//        time(m20);
//        time(m20);
//        Matrix m100 = Matrix.random(100, 100);
//        time(m100);
//        time(m100);
//        time(m100);
//        Matrix m200 = Matrix.random(200, 200);
//        time(m200);
//        time(m200);
//        time(m200);
//        Matrix m500 = Matrix.random(500, 500);
//        time(m500);
//        time(m500);
//        time(m500);
//        Matrix m600 = Matrix.random(600, 600);
//        time(m600);
//        time(m600);
//        time(m600);
//        Matrix m700 = Matrix.random(700, 700);
//        time(m700);
//        time(m700);
//        time(m700);
//        Matrix m800 = Matrix.random(800, 800);
//        time(m800);
//        time(m800);
//        time(m800);
//        Matrix m900 = Matrix.random(900, 900);
//        time(m900);
//        time(m900);
//        time(m900);
//        Matrix m1000 = Matrix.random(1000, 1000);
//        time(m1000);
//        time(m1000);
//        time(m1000);
        
//        start = System.nanoTime();
//        m700.inverse();
//        end = (System.nanoTime()-start);
//        System.out.println("Tempo Ordem " + m700.getRows() + ": " + end);
//        TimeUnit mc2 = TimeUnit.MICROSECONDS;
//        System.out.println("CompareTo: " + mc1.compareTo(mc2));
        
        
        
        
    }
    public static void time(Matrix m) {
        long start, end;
        start = System.nanoTime();
        m.inverse();
        end = (System.nanoTime()-start);
        System.out.println("Tempo Ordem " + m.getRows() + ": " + end);
    }
}
