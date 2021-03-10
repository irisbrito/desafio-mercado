package br.com.zup.desafio.exceptions;

public class ExcecaoBasica extends RuntimeException {
    private int status;
    private String campo;
    private String razaoDoErro;
    private String tipoDoErro;

    public ExcecaoBasica(String message, int status, String campo, String razaoDoErro, String tipoDoErro) {
        super(message);
        this.status = status;
        this.campo = campo;
        this.razaoDoErro = razaoDoErro;
        this.tipoDoErro = tipoDoErro;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getRazaoDoErro() {
        return razaoDoErro;
    }

    public void setRazaoDoErro(String razaoDoErro) {
        this.razaoDoErro = razaoDoErro;
    }

    public String getTipoDoErro() {
        return tipoDoErro;
    }

    public void setTipoDoErro(String tipoDoErro) {
        this.tipoDoErro = tipoDoErro;
    }

}
