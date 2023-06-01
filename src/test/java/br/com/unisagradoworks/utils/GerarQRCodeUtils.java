package br.com.unisagradoworks.utils;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class GerarQRCodeUtils {

    /*
     * Construtor privado: classe utilitária não deve ser instanciada, para evitar o uso de memória desnecessário
     */
    private GerarQRCodeUtils(){ super(); }

    /*
     * Método para obter a extensão do arquivo
     * @param file Arquivo a ser verificado
     * @return ‘String’ com a extensão do arquivo
     */
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex >= 0 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex + 1);
        }
        return "";
    }

    public static String lerConteudoQRCode(String caminhoImagem) {
        try {
            BufferedImage imagem = ImageIO.read(new File(caminhoImagem));
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new RGBLuminanceSource(imagem.getWidth(), imagem.getHeight(), imagem.getRGB(0, 0, imagem.getWidth(), imagem.getHeight(), null, 0, imagem.getWidth()))));

            Result resultado = new MultiFormatReader().decode(bitmap);
            if (resultado != null) {
                return resultado.getText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
