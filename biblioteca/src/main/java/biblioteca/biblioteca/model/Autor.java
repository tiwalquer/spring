package biblioteca.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {

    private String nome;
    private String nacionalidade;
    private List<String> obrasPublicadas = new ArrayList<>();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<String> getObrasPublicadas() {

        return obrasPublicadas;
    }

    public void adicionarItem(String obrasPublicada) {
        this.obrasPublicadas.add(obrasPublicada);

    }
}
