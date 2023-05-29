package br.com.unisagradoworks;

import br.com.unisagradoworks.utils.GerarQRCodeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GeradorQRCodeTest {

    private String texto;
    private int largura;
    private int altura;
    private String formatoImagem;
    private String caminhoImagem;

    /*
     * @BeforeEach roda antes de cada método de teste.
     * Nesse caso se faz necessário para limpar o arquivo de imagem antes de cada teste.
     */
    @BeforeEach
    public void setUp() {
        File arquivoImagem = new File("src/main/resources/imagem.png");

        // Verificação
        if (arquivoImagem.exists()) {
            arquivoImagem.delete(); // Deleta o arquivo antes de cada teste
        }

        // Configuração para o teste
        texto = "Texto a ser codificado no QR Code";
        largura = 600;
        altura = 600;
        formatoImagem = "png";
        caminhoImagem = "src/main/resources/imagem.png";
    }

    @Test
    @DisplayName("Dado que eu informe os valores  " +
                 "então deve ser gerado o QR Code com sucesso")
    public void testeGerarQrCodeComSucesso() {
        // Execução do método
        GeradorQRCode.gerarQRCode(texto, largura, altura, formatoImagem, caminhoImagem);

        // Verificação do resultado
        File arquivoImagem = new File(caminhoImagem);

        assertTrue(arquivoImagem.exists());
        assertTrue(arquivoImagem.isFile());
        Assertions.assertEquals(largura, arquivoImagem.length());
        Assertions.assertEquals(altura, arquivoImagem.length());
        Assertions.assertEquals(texto, arquivoImagem.getName());
        Assertions.assertEquals(formatoImagem, GerarQRCodeUtils.getFileExtension(arquivoImagem));

        //TESTE DE PARAMETRO PARA VERIFICAR SE OS VALORES ESTAO NULOS OU VAZIOS
        //METODO QUE LE O CONTEUDO PARA ler o conteudo do qrcode
    }


}
