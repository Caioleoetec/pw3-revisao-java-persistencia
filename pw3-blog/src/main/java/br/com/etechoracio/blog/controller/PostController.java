package br.com.etechoracio.blog.controller;

import br.com.etechoracio.blog.entity.Post;
import br.com.etechoracio.blog.repository.PostRepository;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController //define que está classe escutará qualquer requisição que chegar no app
@RequestMapping("/posts") //responsábilizará está classe para escutar um determinado endpoint (backend);
//Rest => faz a conecção via JSON
public class PostController {
    @Autowired //o spring fará o autowired, ou seja "diz" pro java que ele deve instanciar/injetar o objeto
    private PostRepository repository;
    @GetMapping //define que a função aqbaixo será responsável por escutar a requisição GET
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
    @PostMapping
    public ResponseEntity<Post> inserir(@RequestBody Post post){//@RequestBody => indica para "pegar" algo (no caso um POST)
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Delete> excluir(@PathVariable Long id){
        var resposta = repository.findById(id);
        if(resposta.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Post post = resposta.get();
            repository.deleteById(id);
            return null;
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@RequestBody Post post, @PathVariable Long id){
        var existe = repository.findById(id);
        if(!existe.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(repository.save(post));
    }
}
//ResponseEntity.
//
//classes controller "ouvem" requisições HTTP, para isso usamos o rest controller
//Nota: use uma notação até o final
//verbo HTTP da requisição => DELETE,GET,PUT,PATCH,POST => informa o controler (@GetMapping, @PostMapping, ... que será ativado
//body (em formato JSON) => é body (conteúdo relevante) do site