//Dupla: Leonardo Sirpa, Caio dos Santos
package br.com.etechoracio.blog.controller;
import br.com.etechoracio.blog.entity.Comentario;
import br.com.etechoracio.blog.entity.Post;
import br.com.etechoracio.blog.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    @Autowired
    ComentarioRepository comentarioRepository;

    @GetMapping
    public List<Comentario> listarComentarios(){
        return comentarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Comentario> inserir(@RequestBody Comentario comentario){
        return ResponseEntity.ok(comentarioRepository.save(comentario));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Comentario> alterar(@PathVariable Long id, @RequestBody Comentario comentario){
        var caixa = comentarioRepository.findById(id);
        if(caixa.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(comentarioRepository.save(comentario));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comentario> excluir(@PathVariable Long id){
        var caixa = comentarioRepository.findById(id);
        if(caixa.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            comentarioRepository.deleteById(id);
            return  ResponseEntity.status(HttpStatus.CREATED).body(caixa.get());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comentario> buscarPorId(@PathVariable Long id){
        var caixa = comentarioRepository.findById(id);
        if(caixa.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(caixa.get());
    }

}
