package br.com.etechoracio.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDateTime;

@Getter //gera getters
@Setter //gera setters para as propriedades
@Entity //define que a tabela está persistindo no banco
@Table(name = "TBL_POST")//define qual tabela a classe está persistindo
public class Post {
    @Id
    @Column(name = "ID_POST") //relaciona a propriedade com a coluna da tabela no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) //define a estratégia para gerar o id de uma classe/tabela
    private Long id;
    @Column(name = "TX_TITULO")
    private String titulo;
    @Column(name = "TX_CONTEUDO")
    private String conteudo;
    @Column(name = "DT_CRIACAO")
    private LocalDateTime dataCriacao;
}
//Caso o nome de tabela e colunas sejam iguais no banco de dados, não há necessidade de declarar @Collum e @Table