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

        /* Verificação */
        if (arquivoImagem.exists()) {
            arquivoImagem.delete(); /* Deleta o arquivo antes de cada teste */
        }

        /* Configuração para o teste */
        texto = "https://www.canva.com/design/DAFkU9dzOWA/a9Zq9e7YbKnX-aUTNlyLwQ/edit?utm_content=DAFkU9dzOWA&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton";
        largura = 600;
        altura = 600;
        formatoImagem = "png";
        caminhoImagem = "src/main/resources/imagem.png";
    }

    @Test
    @DisplayName("Dado que eu informe os valores corretos" +
                 "então deve ser gerado o QR Code com sucesso")
    void testeGerarQrCodeComSucesso() {
        // Execução do método
        GeradorQRCode.gerarQRCode(texto, largura, altura, formatoImagem, caminhoImagem);

        // Verificação do resultado
        File arquivoImagem = new File(caminhoImagem);
        assertTrue(arquivoImagem.exists());
    }

    @Test
    @DisplayName("Dado que eu informe o formato da imagem em PNG" +
                "então deve ser gerado o QR Code com a extensão .png")
    void testeGerarQrCodeComFormatoPng() {
        // Execução do método
        GeradorQRCode.gerarQRCode(texto, largura, altura, formatoImagem, caminhoImagem);

        // Verificação do resultado
        File arquivoImagem = new File(caminhoImagem);
        assertTrue(arquivoImagem.exists());

        Assertions.assertEquals(formatoImagem, GerarQRCodeUtils.getFileExtension(arquivoImagem));
    }

    @Test
    @DisplayName("Dado que eu informe a url do QR Code" +
                 "então deve ser gerado o QR Code com a url que foi informada")
    void testeGerarQrCodeComUrl() {
        // Execução do método
        GeradorQRCode.gerarQRCode(texto, largura, altura, formatoImagem, caminhoImagem);

        // Verificação do resultado
        File arquivoImagem = new File(caminhoImagem);
        assertTrue(arquivoImagem.exists());

        String textoQrGerado = GerarQRCodeUtils.lerConteudoQRCode(caminhoImagem);
        Assertions.assertEquals(texto, textoQrGerado);
    }
}
