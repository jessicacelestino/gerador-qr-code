package br.com.unisagradoworks;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class GeradorQRCode {
    private GeradorQRCode() { super(); }
    private static final Logger logger = Logger.getLogger(GeradorQRCode.class.getName());

    public static void gerarQRCode(String texto, int largura, int altura, String formatoImagem, String caminhoImagem) {
        try {
            // Configurar parâmetros para gerar o QR Code
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix matriz = writer.encode(texto, BarcodeFormat.QR_CODE, largura, altura);

            // Criar imagem do QR Code
            BufferedImage imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < largura; x++) {
                for (int y = 0; y < altura; y++) {
                    int valor = (matriz.get(x, y) ? 0 : 0xFFFFFF);
                    imagem.setRGB(x, y, valor);
                }
            }
            // Salvar a imagem do QR Code dentro do diretório do projeto
            File arquivo = new File(caminhoImagem);
            ImageIO.write(imagem, formatoImagem, arquivo);
            logger.info("QR Code gerado com sucesso!");

        } catch (WriterException | IOException e) {
            logger.severe("Erro ao gerar QR Code: " + e.getMessage());
        }
    }
}
