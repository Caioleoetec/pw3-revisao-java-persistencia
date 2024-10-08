package br.com.etechoracio.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter //gera getters
@Setter //gera setters para as propriedades
@Entity
@Table(name = "TBL_COMENTARIO")
public class Comentario {
    @Id
    @Column(name = "ID_COMENTARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TX_CONTEUDO")
    private String conteudo;
    @Column(name = "TX_AUTOR")
    private String autor;
    @Column(name = "DT_CRIACAO")
    private LocalDateTime dataCriacao;
    @Column(name = "ID_POST")
    //@ManyToOne(targetEntity = Post.class)
    private Long idPost;
}
