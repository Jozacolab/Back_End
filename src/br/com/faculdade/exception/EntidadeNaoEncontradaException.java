package br.com.faculdade.exception;

// Herda de 'Exception' para indicar que é um erro que precisa ser tratado no sistema
public class EntidadeNaoEncontradaException extends Exception {
    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}