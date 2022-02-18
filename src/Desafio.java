import java.util.Arrays;
public class Desafio {

    /*
     *   Este programa foi criado para atender os requisitos da Academia Capgemini 2022,
     *   respondendo as questões encontradas em: https://docs.google.com/document/d/1fAzE01t6hEyg8JrbRo7vOA3K2W-NYisF/
    */

    static void questao01(int n){

        /*
         *   Esta função recebe um valor n e imprime na tela uma escada de asteriscos 
         *   cuja base e altura sejam iguais a n.
        */

        //Executa o laço n vezes
        for (int i = 0; i < n; i++) {

            //imprime espaços vazios em ordem decrescente
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
    
            //imprime asteriscos em ordem crescente
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    static int questao02(String senha){

        /*
         *   Esta função recebe uma senha e faz um tratamento, segundo os requisitos, para
         *   encontrar a quantidade de caracteres que devem ser adicionados à ela para
         *   torná-la segura.
         *
         *   Por motivos didáticos, esta implementação não utiliza expressões regulares.
        */

        String charEspeciais = "!@#$%^&*";
        final int QTD_MINIMA_CHAR = 6;
        boolean temEspecial=false, temMinusculo=false, temMaiusculo=false, temDigito=false;
        int contador=0;

        //Percorre a senha e identifica se ela cumpre os requisitos
        for (int i = 0; i < senha.length(); i++) {

            if (charEspeciais.contains(senha.substring(i, i+1)))
                temEspecial = true; 
            if (Character.isLowerCase(senha.charAt(i)))
                temMinusculo = true;
            if (Character.isUpperCase(senha.charAt(i)))
                temMaiusculo = true;
            if (Character.isDigit(senha.charAt(i)))
                temDigito = true;
        }

        //Adiciona um a cada requisito que não foi atendido
        if (!temEspecial)
            contador ++;
        if (!temMinusculo)
            contador ++;
        if (!temMaiusculo)
            contador ++;
        if (!temDigito)
            contador ++;

        //Checa se a senha possui a quantidade mínima de caracteres
        //e imprime na tela a quantidade de caracteres a serem adicionados
        if (senha.length() + contador < QTD_MINIMA_CHAR){
            System.out.println(contador + QTD_MINIMA_CHAR-(senha.length()+contador));
            return contador + QTD_MINIMA_CHAR-(senha.length()+contador);
        }else{    
            System.out.println(contador);
            return contador;
        }
    }

    static int questao03(String palavra){

        /*
         *  Esta função recebe uma palavra e checa se ela possui substrings que sejam
         *  anagramas, e então imprime a quantidade de anagramas encontrados. 
        */

        int contador = 0;
        
        //Percorre a palavra na forma de uma matriz vertical
        for (int i = 0; i < palavra.length(); i++) {
            for (int j = 0; j < palavra.length(); j++) {
                for (int k=j+1; k < palavra.length()-i; k++){
                    //Converte as substrings para vetores de char
                    char str1[] = palavra.substring(j,j+i+1).toCharArray();
                    char str2[] = palavra.substring(k,k+i+1).toCharArray();
                    //Checa se possuem o mesmo tamanho e as ordena
                    if (str1.length == str2.length){
                        Arrays.sort(str1);
                        Arrays.sort(str2);
                        //Checa se são iguais e adiciona ao contador
                        if (Arrays.equals(str1,str2)){
                            contador++;
                        }
                    }
                }                
            }
        }
        System.out.println(contador);
        return contador;
    }
    public static void main(String[] args) throws Exception {

        if (args != null && args.length > 1) {
            switch(Integer.parseInt(args[0])){
                case 1:
                    questao01(Integer.parseInt(args[1]));
                    break;
                case 2:
                    questao02(args[1]);
                    break;
                case 3:
                    questao03(args[1]);
                    break;
            }
        }
    }
}