package br.com.unisagradoworks;

import static br.com.unisagradoworks.GeradorQRCode.gerarQRCode;

public class Main {

    public static void main(String[] args) {
        String texto = "URL DE TESTE";
        int largura = 600;
        int altura = 600;
        String formatoImagem = "png";
        String caminhoImagem = "src/main/resources/imagem.png";

        gerarQRCode(texto, largura, altura, formatoImagem, caminhoImagem);
    }
}
