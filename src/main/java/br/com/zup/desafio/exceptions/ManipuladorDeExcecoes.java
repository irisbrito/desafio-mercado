package br.com.zup.desafio.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ManipuladorDeExcecoes extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ObjetoDeErro> objetosDeErro = getErros(ex);
        RespostaDeErro respostaDeErro = new RespostaDeErro("Validação", status.value(),
                status.getReasonPhrase(), objetosDeErro);

        return ResponseEntity.status(status).body(respostaDeErro);
    }

    private List<ObjetoDeErro> getErros(MethodArgumentNotValidException exception){
        List<ObjetoDeErro> objetosDeErro = exception.getBindingResult()
                .getFieldErrors().stream()
                .map(erro -> new ObjetoDeErro(erro.getDefaultMessage(), erro.getField()))
                .collect(Collectors.toList());

        return objetosDeErro;
    }

    @ExceptionHandler({ExcecaoBasica.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespostaDeErro manipularRuntimeException(ExcecaoBasica erro){
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(erro.getMessage(), erro.getCampo());
        RespostaDeErro respostaDeErro = new RespostaDeErro(erro.getTipoDoErro(), erro.getStatus(), erro.getRazaoDoErro(),
                Arrays.asList(objetoDeErro));

        return respostaDeErro;
    }

    @ExceptionHandler({ClienteExistenteException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaDeErro manipularClienteExistenteException(ExcecaoBasica erro){
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(erro.getMessage(), erro.getCampo());
        RespostaDeErro respostaDeErro = new RespostaDeErro(erro.getTipoDoErro(), erro.getStatus(), erro.getRazaoDoErro(),
                Arrays.asList(objetoDeErro));

        return respostaDeErro;
    }

    @ExceptionHandler({ClienteNaoEncontradoException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespostaDeErro manipularClienteNaoEncontrado(ExcecaoBasica erro){
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(erro.getMessage(), erro.getCampo());
        RespostaDeErro respostaDeErro = new RespostaDeErro(erro.getTipoDoErro(), erro.getStatus(), erro.getRazaoDoErro(),
                Arrays.asList(objetoDeErro));

        return respostaDeErro;
    }

    @ExceptionHandler({ClienteExistenteEmailException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaDeErro manipularClienteExistente(ExcecaoBasica erro){
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(erro.getMessage(), erro.getCampo());
        RespostaDeErro respostaDeErro = new RespostaDeErro(erro.getTipoDoErro(), erro.getStatus(), erro.getRazaoDoErro(),
                Arrays.asList(objetoDeErro));

        return respostaDeErro;
    }

    @ExceptionHandler({ProdutoNaoEncontradoException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespostaDeErro manipularProdutoNaoEncontrado(ExcecaoBasica erro){
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(erro.getMessage(), erro.getCampo());
        RespostaDeErro respostaDeErro = new RespostaDeErro(erro.getTipoDoErro(), erro.getStatus(), erro.getRazaoDoErro(),
                Arrays.asList(objetoDeErro));

        return respostaDeErro;
    }

    @ExceptionHandler({ProdutoExistenteException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaDeErro manipularProdutoExistente(ExcecaoBasica erro){
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(erro.getMessage(), erro.getCampo());
        RespostaDeErro respostaDeErro = new RespostaDeErro(erro.getTipoDoErro(), erro.getStatus(), erro.getRazaoDoErro(),
                Arrays.asList(objetoDeErro));

        return respostaDeErro;
    }


}
