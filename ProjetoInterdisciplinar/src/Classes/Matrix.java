package Classes;

import java.text.DecimalFormat;

/**
 * Classe que representa matrizes numéricas
 */
public class Matrix {
    private int rows; //Número de linhas da matriz
    private int cols; //Número de colunas da matriz
    private double[][] elements; //Matriz de elementos
    public boolean error; //Se ocorreu algum erro na operação
    public String error_dsc = "Erro desconhecido"; //Descrição do erro ocorrido
    private int rows_change = 0; //Número de vezes que as linhas foram trocadas de posição
    private static DecimalFormat _dF = new DecimalFormat("#####0.0000"); //Atributos para formatação de números decimais
    private static DecimalFormat _dF_int = new DecimalFormat("######0"); //Atributos para formatação de números inteiros
    
    ///// Construtor /////
    /**
     *  Método construtor da classe de matrizes
     * @param rows Número de linhas da matriz
     * @param cols Número de colunas da matriz
     */
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.elements = new double[rows][cols];
    }
    
    /**
     *  Retorna uma matriz identidade
     * @param rows Número de linhas da matriz
     * @param cols Número de colunas da matriz
     * @return Matriz identidade
     */
    public static Matrix identity(int rows, int cols) {
        Matrix r = new Matrix(rows, cols);
        for (int irow=0; irow < r.rows; irow++) {
            for (int icol=0; icol < r.cols; icol++) {
                if (irow == icol)
                    r.elements[irow][icol] = 1;
                else 
                    r.elements[irow][icol] = 0;
            }
        }
        return r;
    }
    
    /**
     *  Retorna uma matriz com elementos aleatórios
     * @param rows Número de linhas da matriz
     * @param cols Número de colunas da matriz
     * @return Matriz com elementos aleatórios
     */
    public static Matrix random(int rows, int cols) {
        Matrix r = new Matrix(rows, cols);
        for (int irow=0; irow < r.rows; irow++) {
            for (int icol=0; icol < r.cols; icol++) {
                double v = Math.random() * 1000;
                v = formatNumber(v);
//                v = formatInt(v);
                r.setElements(irow, icol, v);
            }
        }
        return r;
    }
    
    /**
     *  Sobrescreve o método de clonar o objeto
     * @return Uma cópia (clone) da matriz
     */
    @Override
    public Matrix clone() {
        Matrix m = new Matrix(this.rows, this.cols);
        for (int irow=0; irow < this.rows; irow++) {
            for (int icol=0; icol < this.cols; icol++) {
                m.setElements(irow, icol, this.getElements(irow, icol));
            }
        }
        return m;
    }
    
    ///// Debug /////
    /**
     *  Retorna um texto que demonstra a matriz na forma visual
     * @return Texto demonstração da matriz
     */
    public String showMatrix() {
        String r = "";
        for (int row=0; row < this.rows; row++) {
            for (int col=0; col < this.cols; col++) {
                r += formatNumber(this.getElements(row, col)) + "\t";
            }
            r += "\n";
        }
        return r;
    }
    
    ///// Acesso aos dados /////
    /**
     *  Retorna o número de linhas da matriz
     * @return Número de linhas
     */
    public int getRows() {
        return this.rows;
    }
    
    /**
     *  Retorna o número de colunas da matriz
     * @return Número de colunas
     */
    public int getCols() {
        return this.cols;
    }
    
    /**
     *  Retorna um elemento específico da matriz com o índice iniciando em 1
     * @param row Número da linha do elemento
     * @param col Número da coluna do elemento
     * @return Elemento
     */
    public double getElement(int row, int col) {
        double r = 0;
        if (row <= this.rows && col <= this.cols) {
            r = this.elements[row-1][col-1];
        } else {
            this.error = true;
            this.error_dsc = "O elemento requisitado é maior do que o tamanho da matriz";
        }
        return r;
    }
    
    /**
     *  Retorna um elemento específico da matriz com o índice iniciando em 0
     * @param row Número da linha do elemento
     * @param col Número da coluna do elemento
     * @return Elemento
     */
    public double getElements(int row, int col) {
        double r = 0;
        if (row < this.rows && col < this.cols) {
            r = this.elements[row][col];
        } else {
            this.error = true;
            this.error_dsc = "O elemento requisitado é maior do que o tamanho da matriz";
        }
        return r;
    }
    
    /**
     *  Retorna a matriz de elementos da matriz
     * @return Matriz de elementos
     */
    public double[][] getElements() {
        return this.elements;
    }
    
    /**
     *  Retorna quantas vezes as linhas da matriz foram trocadas de posição
     * @return Número de vezes que as linhas da matriz foram trocadas de posição
     */
    public int getRowsChange() {
        return this.rows_change;
    }
    
    ///// Preenchimento de dados /////
    /**
     *  Define um elemento na matriz com o índice iniciando em 1
     * @param row Número da linha do elemento
     * @param col Número da coluna do elemento
     * @param value Valor do elemento
     */
    public void setElement(int row, int col, double value) {
        this.elements[row-1][col-1] = value;
    }
    
    /**
     *  Define um elemento na matriz com o índice iniciando em 0
     * @param row Número da linha do elemento
     * @param col Número da coluna do elemento
     * @param value Valor do elemento
     */
    public void setElements(int row, int col, double value) {
        this.elements[row][col] = value;
    }
    
    /**
     *  Define uma linha inteira da matriz
     * @param values Valores da linha
     * @param row Número da linha a ser definida
     */
    public void setRow(double[] values, int row) {
        if (values.length == this.cols) {
            this.elements[row-1] = values;
        } else {
            this.error = true;
            this.error_dsc = "O número de elementos informados para a linha " + row + " é diferente do número de colunas da matriz";
        }
    }
    
    /**
     *  Define uma coluna inteira da matriz
     * @param values Valores da coluna
     * @param col Número da coluna a ser definida
     */
    public void setColumn(double[] column, int col) {
        if (column.length == this.rows) {
            for (int row=0; row < this.rows; row++) {
                this.elements[row][col-1] = column[row];
            }
        } else {
            this.error = true;
            this.error_dsc = "O número de elementos informados para a coluna é diferente do número de linhas da matriz";
        }
    }
    
    /**
     *  Exclui uma linha da matriz
     * @param row Linha a ser excluída
     */
    public void dropRow(int row) {
        int new_row;
        boolean passed = false;
        if (this.rows > 1) {
            double[][] new_elements = new double[this.rows-1][this.cols];
            for (int irow=0; irow < this.rows; irow++) {
                if (row-1 == irow) {
                    passed = true;
                    continue;
                }
                for (int icol=0; icol < this.cols; icol++) {
                    new_row = irow;
                    if (passed) 
                        new_row = irow-1;
                    new_elements[new_row][icol] = this.getElements(irow, icol);
                }
            }
            this.rows -= 1;
            this.elements = new_elements;
        } else {
            this.error = true;
            this.error_dsc = "A matriz precisa ter ao menos uma linha";
        }
    }
    
    /**
     *  Exclui uma coluna da matriz
     * @param col Coluna a ser excluída
     */
    public void dropColumn(int col) {
        int new_col;
        boolean passed;
        if (this.cols > 1) {
            double[][] new_elements = new double[this.rows][this.cols-1];
            for (int irow=0; irow < this.rows; irow++) {
                passed = false;
                for (int icol=0; icol < this.cols; icol++) {
                    if (col-1 == icol) {
                        passed = true;
                        continue;
                    }
                    new_col = icol;
                    if (passed) 
                        new_col -= 1;
                    new_elements[irow][new_col] = this.getElements(irow, icol);
                }
            }
            this.cols -= 1;
            this.elements = new_elements;
        } else {
            this.error = true;
            this.error_dsc = "A matriz precisa ter ao menos uma coluna";
        }
    }
    
    ///// Operações /////
    /**
     *  Transpõe a matriz
     * @return Matriz transposta
     */
    public Matrix transpose() {
        Matrix arrT = new Matrix(this.cols, this.rows);
        for (int row=0; row < this.rows; row++) {
            for (int col=0; col < this.cols; col++) {
                arrT.setElements(col, row, this.getElements(row, col));
            }
        }
        return arrT;
    }
    
    /**
     *  Efetua a operação de adição de matrizes
     * @param matrix Matriz a ser somada
     * @return Matriz resultado da operação
     */
    public Matrix sum(Matrix matrix) {
        Matrix r = new Matrix(matrix.getRows(), matrix.getCols());
        if (this.equalSize(matrix)) {
            for (int row=0; row < r.getRows(); row++) {
                for (int col=0; col < r.getCols(); col++) {
                    r.setElements(row, col, this.getElements(row, col) + matrix.getElements(row, col));;
                }
            }
        } else {
            this.error = true;
            this.error_dsc = "As matrizes somadas precisam ser da mesma ordem";
        }
        return r;
    }
    
    /**
     *  Efetua a operação de subtração de matrizes
     * @param matrix Matriz subtraendo da operação
     * @return Matriz resultado da operação
     */
    public Matrix minus(Matrix matrix) {
        Matrix r = new Matrix(matrix.getRows(), matrix.getCols());
        if (this.equalSize(matrix)) {
            for (int row=0; row < r.getRows(); row++) {
                for (int col=0; col < r.getCols(); col++) {
                    r.setElements(row, col, this.getElements(row, col) - matrix.getElements(row, col));
                }
            }
        } else {
            this.error = true;
            this.error_dsc = "As matrizes subtraídas precisam ser da mesma ordem";
        }
        return r;
    }
    
    /**
     *  Efetua a operação de multiplicação de matriz por constante
     * @param number Constante a ser multiplicada pela matriz
     * @return Matriz resultado da operação
     */
    public Matrix multiply(double number) {
        Matrix r = this.clone();
        for (int row=0; row < r.getRows(); row++) {
            for (int col=0; col < r.getCols(); col++) {
                r.setElements(row, col, this.getElements(row, col) * number);
            }
        }
        return r;
    }
    
    /**
     *  Efetua a operação de multiplicação de matrizes
     * @param matrix Matriz a ser multiplicada
     * @return Matriz resultado da operação
     */
    public Matrix multiply(Matrix matrix) {
        // Revisar este método
        Matrix r = new Matrix(this.rows, matrix.cols);
        if (this.cols == matrix.rows) {
            for (int row=0; row < r.rows; row++) { //para cada linha da matriz nova
                for (int col=0; col < r.cols; col++) { //para cada coluna da matriz nova
                    r.elements[row][col] = 0;
                    for (int icol=0; icol < this.cols; icol++) { //pela linha inteira da matriz original
                        r.elements[row][col] += this.elements[row][icol] * matrix.elements[icol][col];
                    }
                }
            }
        } else {
            this.error = true;
            this.error_dsc = "O número de colunas da matriz multiplicando é diferente do número de linhas da matriz multiplicadora";
        }
        return r;
    }
    
    /**
     *  Calcula o determinante da matriz
     * @return Determinante
     */
    public double determinant() {
        double r = 0;
        if (this.isSquareMatrix()) {
            if (this.isUpperTriangularMatrix() || this.isLowerTriangularMatrix()) {
                // Matriz triangular, o determinante é o produto da diagonal principal
                r = this.getElements(0,0);
                for (int irow=1; irow < this.rows; irow++) {
                    r *= this.getElements(irow,irow);
                }
            } else {
                switch(this.rows) {
                    case 2: //simples, matriz de ordem 2
                        r = this.getElements(0,0)*this.getElements(1,1) - this.getElements(0,1)*this.getElements(1,0);
                        break;
                    case 3: //regra de sarrus
                        double d1 = this.getElements(0,0)*this.getElements(1,1)*this.getElements(2,2) + 
                                this.getElements(0,1)*this.getElements(1,2)*this.getElements(2,0) + 
                                this.getElements(1,0)*this.getElements(2,1)*this.getElements(0,2);
                        double d2 = this.getElements(2,0)*this.getElements(1,1)*this.getElements(0,2) + 
                                this.getElements(0,0)*this.getElements(1,2)*this.getElements(2,1) + 
                                this.getElements(2,2)*this.getElements(0,1)*this.getElements(1,0);
                        r = d1 - d2;
                        break;
                    default:
//                        r = this.determinantCofactor();
                        r = this.determinantGauss();
                        break;
                }
            }
        } else {
            this.error = true;
            this.error_dsc = "A matriz não é quadrada, não é possível calcular seu determinante";
        }
        return r;
    }
    
    /**
     *  Calcula o determinante da matriz através do método de cofatores
     * @return Determinante
     */
    public double determinantCofactor() {
        double r = 0;
        double[] chosen = new double[this.rows];
        for (int i=0; i < this.rows; i++) {
            chosen[i] = this.cofactor(i, 0)*this.getElements(i,0); //sempre primeira colunae
        }
        r = 0;
        for (int cof=0; cof < chosen.length; cof++) {
            r += chosen[cof];
        }
        return r;
    }
    
    /**
     *  Calcula o determinante da matriz através do método de Gauss
     * @return Determinante
     */
    public double determinantGauss() {
        double r = 0;
        double factors = 0;
        Matrix work_copy = this.clone();
        
        // A última linha não precisa
        for (int work_col = 0; work_col < (work_copy.cols-1); work_col++) {
            if (work_copy.getElements(work_col, work_col) != 1) {
                // Navega nas linhas posteriores procurando um 1
                for (int irow = work_col; irow < work_copy.cols; irow++) {
                    if (work_copy.getElements(irow, work_col) == 1) {
                        work_copy.changeRow(irow, work_col);
                        break;
                    }
                }
                
                if (work_copy.getElements(work_col, work_col) != 1) {
                    // Não encontrou nas linhas, faz a conta
                    double factor = 1/work_copy.getElements(work_col, work_col);
                    if (factors == 0) 
                        factors = work_copy.getElements(work_col, work_col);
                    else 
                        factors *= work_copy.getElements(work_col, work_col);
                    for (int icol = 0; icol < work_copy.cols; icol++) {
                        work_copy.setElements(work_col, icol, work_copy.getElements(work_col, icol) * factor);
                    }
                }
            }

            // Temos o elemento matrix.elements[work_row][work_row] = 1
            for (int irow = work_col+1; irow < work_copy.rows; irow++) {
                if (work_copy.getElements(irow, work_col) != 0) {
                    double factor = work_copy.getElements(irow, work_col) * -1;
                    work_copy.multiplyAndSumRow(work_col, factor, irow);
                }
            }
        }
        // Podemos pegar apenas o último elemento, pois o restante da diagonal principal é 0
        r = work_copy.getElement(work_copy.rows, work_copy.cols) * Math.pow(-1, work_copy.getRowsChange());
        r *= factors;
        return r;
    }
    
    /**
     *  Calcula a inversa da matriz
     * @return A matriz inversa
     */
    public Matrix inverse() {
        Matrix r = new Matrix(this.rows, this.cols);
        if (this.isSquareMatrix()) {
            double det = this.determinant();
            if (det != 0) {
                switch(this.rows) {
                    case 2: //simples, matriz de ordem 2
                        double[] row = {this.getElements(1,1), this.getElements(0,1)*-1};
                        r.setRow(row, 1);
                        double[] row2 = {this.getElements(1,0)*-1, this.getElements(0,0)};
                        r.setRow(row2, 2);
                        r = r.multiply(Math.pow(det, -1));
                        break;
                    default:
//                        r = this.inverseAdjunta();
                        r = this.inverseGauss();
                        break;
                }
            } else {
                this.error = true;
                this.error_dsc = "O determinante da matriz é zero, portanto ela não possui inversa";
            }
        } else {
            this.error = true;
            this.error_dsc = "A matriz não é quadrada, não é possível calcular sua inversa";
        }
        return r;
    }
    
    /**
     *  Calcula a inversa da matriz através do método da Adjunta
     * É uma função recursiva, pois ela chama o método de determinante e é chamada por ele
     * @return A matriz inversa
     */
    private Matrix inverseAdjunta() {
        double det = this.determinant();
        Matrix cof = this.cofactor();
        Matrix cofT = cof.transpose();
        cofT.multiply(Math.pow(det, -1));
        return cofT;
    }
    
    /**
     *  Calcula a inversa da matriz através do método de Gauss
     * @return A matriz inversa
     */
    private Matrix inverseGauss() {
        Matrix r = this.clone();
        Matrix i = identity(r.rows, r.cols);
        
        for (int work_row = 0; work_row < r.rows; work_row++) {
            if (r.elements[work_row][work_row] != 1) {
                // Navega nas linhas posteriores procurando um 1
                for (int irow = work_row; irow < r.cols; irow++) {
                    if (r.elements[irow][work_row] == 1) {
                        r.changeRow(irow, work_row);
                        i.changeRow(irow, work_row);
                        break;
                    }
                }
                
                if (r.elements[work_row][work_row] != 1) {
                    // Não encontrou nas linhas, faz a conta
                    double factor = 1/r.elements[work_row][work_row];
                    for (int icol = 0; icol < r.cols; icol++) {
                        r.elements[work_row][icol] *= factor;
                        i.elements[work_row][icol] *= factor;
                    }
                }
            }

            // Temos o elemento this.elements[work_row][work_row] = 1
            for (int irow = 0; irow < r.rows; irow++) {
                if (irow == work_row) 
                    continue; // Este elemento vale 1
                if (r.elements[irow][work_row] != 0) {
                    double factor = r.elements[irow][work_row]*-1;
                    r.multiplyAndSumRow(work_row, factor, irow);
                    i.multiplyAndSumRow(work_row, factor, irow);
                }
            }
        }
        return i;
    }
    
    ///// Checagens /////
    /**
     *  Checa se a matriz é da mesma ordem
     * @param matrix Matriz a ser comparada
     * @return Se a matriz é da mesma ordem
     */
    public boolean equalSize(Matrix matrix) {
        boolean r = false;
        if (matrix.rows == this.rows && matrix.cols == this.cols) 
            r = true;
        return r;
    }
    
    /**
     *  Checa se a matriz é idêntica
     * @param matrix Matriz a ser comparada
     * @return Se a matriz é idêntica
     */
    public boolean equals(Matrix matrix) {
        boolean r = false;
        if (matrix.rows == this.rows && matrix.cols == this.cols) {
            for (int row = 0; row < this.rows; row++) {
                for (int col = 0; col < this.rows; col++) {
                    if (this.elements[row][col] != matrix.getElements(row, col)) 
                        return r; //false
                }
            }
            r = true;
        }
        return r;
    }
    
    /**
     *  Checa se a matriz é uma matriz linha
     * @return Se a matriz é uma matriz linha
     */
    public boolean isRowMatrix() {
        if (this.rows == 1) 
            return true;
        else 
            return false;
    }
    
    /**
     *  Checa se a matriz é uma matriz coluna
     * @return Se a matriz é uma matriz coluna
     */
    public boolean isColumnMatrix() {
        if (this.cols == 1) 
            return true;
        else 
            return false;
    }
    
    /**
     *  Checa se a matriz é uma matriz quadrada
     * @return Se a matriz é uma matriz quadrada
     */
    public boolean isSquareMatrix() {
        if (this.rows == this.cols) 
            return true;
        else 
            return false;
    }
    
    /**
     *  Checa se a matriz é uma matriz nula
     * @return Se a matriz é uma matriz nula
     */
    public boolean isZeroMatrix() {
        for (int row=0; row < this.rows; row++) {
            for (int col=0; col < this.cols; col++) {
                if (this.elements[row][col] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     *  Checa se a matriz é uma matriz triangular superior
     * @return Se a matriz é uma matriz triangular superior
     */
    public boolean isUpperTriangularMatrix() {
        for (int irow=0; irow < this.rows; irow++) {
            for (int icol=0; icol < this.cols; icol++) {
                if (irow < icol && this.elements[irow][icol] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     *  Checa se a matriz é uma matriz triangular inferior
     * @return Se a matriz é uma matriz triangular inferior
     */
    public boolean isLowerTriangularMatrix() {
        for (int irow=0; irow < this.rows; irow++) {
            for (int icol=0; icol < this.cols; icol++) {
                if (irow > icol && this.elements[irow][icol] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     *  Checa se a matriz é uma matriz diagonal
     * @return Se a matriz é uma matriz diagonal
     */
    public boolean isDiagonalMatrix() {
        for (int row=0; row < this.rows; row++) {
            for (int col=0; col < this.cols; col++) {
                if (row != col && this.elements[row][col] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     *  Checa se a matriz é uma matriz identidade
     * @return Se a matriz é uma matriz identidade
     */
    public boolean isIdentityMatrix() {
        for (int row=0; row < this.rows; row++) {
            for (int col=0; col < this.cols; col++) {
                if ((row == col && this.elements[row][col] != 1) 
                    || (row != col && this.elements[row][col] != 0)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     *  Checa se a matriz é inversível
     * @return Se a matriz é inversível
     */
    public boolean isInversible() {
        if (this.determinant() == 0) {
            return false;
        }
        return true;
    }
    
    ///// Auxiliares /////
    /**
     *  Método auxiliar para o cálculo de cofatores
     * O método é recursivo e exclui uma linha e uma coluna e calcula o determinante da matriz restante
     * @param row Linha do elemento a ser utilizado como pivô
     * @param col Coluna do elemento a ser utilizado como pivô
     * @return O determinante do cofator
     */
    public double cofactor(int row, int col) {
        Matrix ma = this.clone();
        ma.dropRow(row+1);
        ma.dropColumn(col+1);
        return ma.determinant() * Math.pow(-1, row+col+2);
    }
    
    /**
     *  Método auxiliar que chama o método para o cálculo de cofatores para cada elemento da matriz
     * @return A matriz de cofatores
     */
    public Matrix cofactor() {
        Matrix cof = new Matrix(this.rows, this.cols);
        for (int irow=0; irow < this.rows; irow++) { //para cada linha da matriz nova
            for (int icol=0; icol < this.cols; icol++) { //para cada coluna da matriz nova
                cof.elements[irow][icol] = this.cofactor(irow, icol);
            }
        }
        return cof;
    }
    
    /**
     *  Troca uma linha de lugar
     * @param row_org Origem da linha
     * @param row_dest Destino da linha
     */
    public void changeRow(int row_org, int row_dest) {
        double[] line_aux = this.elements[row_dest];
        this.elements[row_dest] = this.elements[row_org];
        this.elements[row_org] = line_aux;
        this.rows_change++;
    }
    
    /**
     *  Método auxiliar que multiplica uma linha por um constante e soma com outra
     * @param row_org Linha origem
     * @param factor Fator de multiplicação
     * @param row_dest Linha destino
     */
    public void multiplyAndSumRow(int row_org, double factor, int row_dest) {
        for (int icol = 0; icol < this.cols; icol++) {
            this.elements[row_dest][icol] += this.elements[row_org][icol] * factor;
        }
    }
    
    /**
     *  Formata um número decimal de acordo com o atributo de formatação da classe
     * @param number O número a ser formatado
     * @return O número formatado
     */
    public static double formatNumber(double number) {
        return Double.parseDouble(_dF.format(number).replace(",", "."));
    }
    
    /**
     *  Formata um número inteiro de acordo com o atributo de formatação da classe
     * @param number O número a ser formatado
     * @return O número inteiro formatado
     */
    public static int formatInt(double number) {
        return Integer.parseInt(_dF_int.format(number));
    }
}
