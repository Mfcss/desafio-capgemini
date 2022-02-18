import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DesafioTests {

    @Test
    public void Questao02TestePadrao() throws Exception {

        int resposta = Desafio.questao02("Ya3");

        //Teste padrão do desafio
        assertEquals(3, resposta);
    }

    @Test
    public void Questao02SoMinusculo() throws Exception {

        int resposta = Desafio.questao02("aaa");

        //Deveria retornar maiuscula, char especial, digito
        assertEquals(3, resposta);
    }

    @Test
    public void Questao02MuitoCurta() throws Exception {

        int resposta = Desafio.questao02("Aa#1");

        //Senha muito curta, deveria completar
        assertEquals(2, resposta);
    }

    @Test
    public void Questao02SoAtendeRequisitos() throws Exception {

        int resposta = Desafio.questao02("A#e123oi");

        //Atende todos os requisitos
        assertEquals(0, resposta);
    }

    @Test
    public void Questao03TestePadrao() throws Exception {

        int resposta = Desafio.questao03("ovo");

        //Teste padrão do desafio
        assertEquals(2, resposta);
    }

    @Test
    public void Questao03TestePadrao2() throws Exception {

        int resposta = Desafio.questao03("ifailuhkqq");

        //Teste padrão do desafio
        assertEquals(2, resposta);
    }

    @Test
    public void Questao03Anagrama() throws Exception {

        int resposta = Desafio.questao03("peace");

        //Existem 2 anagramas [e,e],[eac,ace]
        assertEquals(2, resposta);
    }

    @Test
    public void Questao03MuitosAnagramas() throws Exception {

        int resposta = Desafio.questao03("anaana");

        //Existem 21 anagramas : [a,a], [a,a],[a,a],[n,n],[a,a],[a,a],[a,a]
        //[an,na],[an,an],[an,na],[na,an],[na,na][an,na],[ana,naa],[ana,aan],[ana,ana]
        //[naa,aan],[naa,ana],[aan,ana],[anaa,aana],[anaan,naana]
        assertEquals(21, resposta);
    }

    @Test
    public void Questao03SemAnagrama() throws Exception {

        int resposta = Desafio.questao03("feijao");

        //Nao existe anagrama
        assertEquals(0, resposta);
    }
}