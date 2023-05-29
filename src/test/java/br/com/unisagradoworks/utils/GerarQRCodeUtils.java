package br.com.unisagradoworks.utils;

import java.io.File;

public class GerarQRCodeUtils {

    /*
     * Construtor privado: classe utilitária não deve ser instanciada, para evitar o uso de memória desnecessário
     */
    private GerarQRCodeUtils(){ super(); }

    /*
     * Método para obter a extensão do arquivo
     * @param file Arquivo a ser verificado
     * @return String com a extensão do arquivo
     */
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex >= 0 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex + 1);
        }
        return "";
    }

}
