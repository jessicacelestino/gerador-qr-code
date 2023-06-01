package br.com.unisagradoworks;

import static br.com.unisagradoworks.GeradorQRCode.gerarQRCode;

public class Main {

    public static void main(String[] args) {
        String texto = "https://www.canva.com/design/DAFkU9dzOWA/a9Zq9e7YbKnX-aUTNlyLwQ/edit?utm_content=DAFkU9dzOWA&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton";
        int largura = 600;
        int altura = 600;
        String formatoImagem = "png";
        String caminhoImagem = "src/main/resources/imagem.png";

        gerarQRCode(texto, largura, altura, formatoImagem, caminhoImagem);
    }
}
