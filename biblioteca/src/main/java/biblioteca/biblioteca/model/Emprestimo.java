package biblioteca.biblioteca.model;

public class Emprestimo {



    private boolean situacaoDoLivro = true;

    public void retirarLivro(){
        this.situacaoDoLivro = false;
    }

    public void devolverLivro(){
        this.situacaoDoLivro = true;
    }

}
