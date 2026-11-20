package biblioteca.biblioteca.controller;


import biblioteca.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class LivroController {

    private List<Livro> estante = new ArrayList<>();


    public LivroController() { //para testar o R
        Livro livro1 = new Livro();
        livro1.setTitulo("pedro alvares");
        livro1.setAutor("vasco");
        livro1.setIsbn("999-3131231");

        Livro livro2 = new Livro();
        livro2.setTitulo("cuzcuz");
        livro2.setAutor("acai");
        livro2.setIsbn("2026");

        estante.add(livro1);
        estante.add(livro2);
    }



    @GetMapping("/") //esta relacionado as requisisos HTTP
    public String inicio(){

        return "livros/inicio";
    }

    @GetMapping("/livros")
    public String listarLivros(Model model) {
        model.addAttribute("estante", estante); // prepara o objeto vazio para o formulário de cadastro)
        model.addAttribute("livro", new Livro()); // Objeto vazio para o form preencher
        // so vai ser usado se chamado nos arquivos HTML usando o $,
        return "livros/livro";
    }

    @GetMapping("/livros/novo")
    public String telaCadastro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/cadastrarLivro";
    }

    //adiciona dados
    @PostMapping ("/livro/adicionarLivro")// set o tipo de aplicacao HTTP para POST( a qual cria um dado)
    public String adicionarLivro(@ModelAttribute Livro livro){ //o tipo de parametro passado, para mostrar que eu estou pegando coisa da model
        estante.add(livro);
        return "redirect:/livros"; // manda para uma pagina HTMl, para aparecer algo na tela do usuario
    }


    @GetMapping("/livros/listarLivros") //R do CRUD read
    public String exibirLivro(Model model){

        System.out.println("Ëntrou na funcao exibirLivros");
        model.addAttribute("estante", estante); //é oque leva os dados para o thmeleaf e por decorrencia para o HTML

        return "livros/listaDeLivros";

    }

    @DeleteMapping("/livros/excluir/{indice}") //o caminho URL / esse {indice} é passado como parametro para o metodo por causa do PathVariable
    public String excluir(@PathVariable int indice){ // o @PathVariable serve para pegar do proprio URL
        if( indice >= 0 && indice < estante.size()){
            estante.remove(indice);
        }

        return "redirect:/livros"; //(Com redirect): Vai para uma URL do Controller (@GetMapping("/livros")), nunca para um arquivo HTML.
    }


}
