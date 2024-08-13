package br.com.etechoracio.blog.controller;

import br.com.etechoracio.blog.entity.Post;
import br.com.etechoracio.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController //define que está classe escutará qualquer requisição que chegar no app
@RequestMapping("/posts") //responsábilizará está classe para escutar um determinado endpoint (backend);
public class PostController {
    @Autowired //o spring fará o autowired, ou seja "diz" pro java que ele deve instanciar/injetar o objeto
    private PostRepository repository;
    @GetMapping //define que a função abaixo será responsável por escutar a requisição GET
    public List<Post> listarPosts(){
        return repository.findAll();
    }

    @GetMapping("/{id}") //esse uso do @GetMapping define uma váriavel na URL; @PathVariable
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id){
        var resposta = repository.findById(id);
        if(!resposta.isEmpty()){
            return ResponseEntity.ok(resposta.get());
        }else {
            return ResponseEntity.notFound().build();
        }
        //ResponseEntity => configura a resposta do app
        //              .ok(retorno) => deu certo e manda algo
        //              .notFound().build() => não encontrado
    }
}
//classes controller "ouvem" requisições HTTP, para isso usamos o rest controller
//Nota: use uma notação até o final