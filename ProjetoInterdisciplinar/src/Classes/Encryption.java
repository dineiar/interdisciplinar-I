package Classes;

/**
 * Classe que faz a criptografia de informações utilizando matrizes inversas
 */
public class Encryption {
    private Matrix matrix; //A matriz a ser utilizada na criptografia
    private Matrix matrixInverse; //A inversa da matriz, para a descriprografia
    //A matriz alfabética de caracteres suportados pela criptografia
    private String[][] alphabetical = {
        {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"},
        {"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"},
        {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"},
        {"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"},
        {"ç", "á", "à", "â", "ã", "ä", "é", "è", "ê", "ë", "ú", "ù", "û"},
        {"ü", "í", "ì", "î", "ï", "Ç", "Á", "À", "Â", "Ã", "Ä", "É", "È"},
        {"Ê", "Ë", "Ú", "Ù", "Û", "Ü", "Í", "Ì", "Î", "Ï", "Ó", "Ò", "Õ"},
        {"Ô", " ", ",", ".", ";", ":", "/", "\\", "|", "(", ")", "[", "]"},
        {"{", "}", "-", "_", "+", "=", "1", "2", "3", "4", "5", "6", "7"},
        {"8", "9", "0", "\n", "´", "`", "~", "^", "ª", "º", "°", "<", ">"},
        {"%", "$", "#", "\t", "'", "\"", "!", "@", "§", "¹", "²", "³", "£"},
        {"¢", "¬", "¨", "&", "*", "®", "¯", "±", "©", "æ", "Ö", "", ""},
    };
    //A matriz que contêm os números relacionados aos caracteres do atributo alphabetical
    public Matrix alphmat;
    public boolean error; //Se ocorreu algum erro na operação
    public String error_dsc = "Erro desconhecido"; //Descrição do erro ocorrido
    
    /**
     *  Método construtor da classe de criptografia
     * @param matrix Matriz utilizada para a criptografia
     */
    public Encryption(Matrix matrix) {
        // Define os valores numéricos correspondentes
        this.alphmat = new Matrix(this.alphabetical.length, this.alphabetical[0].length);
        double val = 0;
        for (int row = 0; row < this.alphmat.getRows(); row++) {
            for (int col = 0; col < this.alphmat.getCols(); col++) {
                val++;
                this.alphmat.setElements(row, col, val);
            }
        }
        
        this.matrix = matrix; //Salva a matriz
        //Calcula a inversa da matriz, utilizada para a descriptografia
        this.matrixInverse = matrix.inverse();
        
        //Se houve algum erro na inversão da matriz, salva ele no atributo da classe
        this.error = matrix.error;
        this.error_dsc = matrix.error_dsc;
    }
    
    /**
     *  Método que faz a criptografia de textos
     * @param text O texto a ser criptografado
     * @return Matriz dos dados criptografados, em forma numérica
     */
    public Matrix encrypt(String text) {
        int cols = this.matrix.getCols();
        
        //Preenche com espaço em branco até fechar o número de caracteres
        if ((text.length() % cols) != 0)
            text = String.format("%1$-"+(text.length() + cols-(text.length() % cols))+"s", text);
        
        Matrix maText = this.textToMatrix(text); //Transforma o texto em uma matriz numérica correspondente
        Matrix r = this.matrix.multiply(maText); //Multiplica a matriz da criptografia pela do texto
        //Se houve algum erro na multiplicação, salva ele no atributo da classe
        this.error = this.matrix.error;
        this.error_dsc = this.matrix.error_dsc;
        
        return r;
    }
    
    /**
     *  Método que faz a descriptografia da matriz criptografada para o texto original
     * @param text Matriz do texto criptografado
     * @return Texto original descriptografado
     */
    public String decrypt(Matrix text) {
        //Multiplica a inversa da matriz chave da criptografia pela matriz do texto criptografado
        Matrix maText = this.matrixInverse.multiply(text);
        //Se houve algum erro na multiplicação, salva ele no atributo da classe
        this.error = this.matrix.error;
        this.error_dsc = this.matrix.error_dsc;
        
        //Transforma a matriz numérica de volta em texto
        return this.matrixToText(maText).trim();
    }
    
    /**
     *  Transforma textos para matrizes numéricas utilizando os atributos da classe
     * @param text Texto
     * @return Matriz numérica equivalente ao texto
     */
    public Matrix textToMatrix(String text) {
        int cols = this.matrix.getCols();
        // Cria uma nova matriz com linhas igual às colunas da matriz chave e 
        // colunas igual ao comprimento do texto dividido pelo número de colunas
        Matrix maText = new Matrix(cols, text.length()/cols);
        // Passa preenchendo a matriz
        int row = 0; //Variável que guarda a linha do elemento a ser preenchido
        int col = 0; //Variável que guarda a coluna do elemento a ser preenchido
        for (int workAt=0; workAt < text.length(); workAt++) { //Passa por todo o comprimento do texto
            // Se a posição do caractere sendo trabalhado for divisível pelo 
            // número de colunas da matriz, passa para a próxima linha
            if (workAt != 0 && (workAt % maText.getCols() == 0)) {
                row++;
            }
            // Define a coluna como a posição sendo trabalhada menos a linha multiplicada pelo número de colunas da matriz
            col = workAt - (row * (maText.getCols()));
            String c = String.valueOf(text.charAt(workAt));
            // Procura o texto na matriz alfabética
            for (int alphrow=0; alphrow < this.alphmat.getRows(); alphrow++) {
                boolean found = false; // Variável que guarda se localizou o caractere, para poder quebrar o loop
                for (int alphcol=0; alphcol < this.alphmat.getCols(); alphcol++) { // Passa por todas as colunas de caracteres suportados
                    if (this.alphabetical[alphrow][alphcol].equals(c)) {
                        // Se encontrou o caractere, seta ele na matriz
                        maText.setElements(row, col, this.alphmat.getElements(alphrow, alphcol));
                        found = true;
                        break;
                    }
                }
                if (found) 
                    break;
            }
        }
        
        return maText;
    }
    
    /**
     *  Transforma uma matriz em texto
     * @param maText Matriz numérica equivalente ao texto
     * @return Texto original
     */
    public String matrixToText(Matrix maText) {
        String r = ""; // Texto que será retornado
        for (int irow=0; irow < maText.getRows(); irow++) { //Passa por todas as linhas
            for (int icol=0; icol < maText.getCols(); icol++) { //Passa por todas as colunas
                // Procuro o número na matriz numérica do alfabeto
                for (int alphrow=0; alphrow < this.alphmat.getRows(); alphrow++) {
                    boolean found = false; // Variável que guarda se localizou o caractere, para poder quebrar o loop
                    for (int alphcol=0; alphcol < this.alphmat.getCols(); alphcol++) {
                        double alphElement = Matrix.formatNumber(this.alphmat.getElements(alphrow, alphcol));
                        double matextElement = Matrix.formatNumber(maText.getElements(irow, icol));
                        if (alphElement == matextElement) {
                            // Se encontrou o caractere, concatena ele com o resultado final
                            r += this.alphabetical[alphrow][alphcol];
                            found = true;
                            break;
                        }
                    }
                    if (found) 
                        break;
                }
            }
        }
        return r;
    }
}
