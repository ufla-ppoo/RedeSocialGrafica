package feed;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Subclasse da classe Mensagem que define uma Mensagem que possui foto.
 * Como a Rede Social é de linha de comando :) na verdade guarda apenas o nome
 * do arquivo da foto e um texto de legenda
 * 
 * Este é um exemplo do livro: Programação Orientada a Objetos com Java - uma 
 * introdução prática utilizando BlueJ.
 * 
 * @author  Michael Kölling and David J. Barnes
 *          Traduzido e adaptado por Julio Cesar Alves
 */
class MensagemFoto extends Mensagem {
    // Bytes da foto
    private byte[] bytesDaFoto;
    // Legenda da foto a ser usada na rede social
    private String legenda;

    /**
     * Cria uma mensagem com foto a partir do nome do autor, bytes da foto
     * e legenda da foto.
     * 
     * @param autor Nome do autor da mensagem
     * @param bytesDaFoto Bytes da foto
     * @param legenda Legenda da foto
     */
    public MensagemFoto(String autor, byte[] bytesDaFoto, String legenda) {
        super(autor);
        this.bytesDaFoto = bytesDaFoto;
        this.legenda = legenda;
    }

    @Override
    /**
     * Retorna o conteúdo da mensagem (nesse caso a legenda da foto)
     * 
     * @return O conteúdo da mensagem
     */
    protected String getConteudoTextoExibicao() {
        return legenda;
    }

    /**
     * Retorna os bytes da foto.
     * 
     * @return Bytes da foto
     */
    public byte[] getBytesDaFoto() {
        return bytesDaFoto;
    }

    public boolean temfoto() {
        return true;
    }
}
