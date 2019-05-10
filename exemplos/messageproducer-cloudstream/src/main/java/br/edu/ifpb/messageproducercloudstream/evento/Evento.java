package br.edu.ifpb.messageproducercloudstream.evento;

public class Evento {

    private String nome;

    private Long objetoID;

    public Evento(String nome, Long objetoID) {
        this.nome = nome;
        this.objetoID = objetoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getObjetoID() {
        return objetoID;
    }

    public void setObjetoID(Long objetoID) {
        this.objetoID = objetoID;
    }
}
