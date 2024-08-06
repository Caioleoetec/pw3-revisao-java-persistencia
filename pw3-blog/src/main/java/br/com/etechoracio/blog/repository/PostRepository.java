package br.com.etechoracio.blog.repository;

import br.com.etechoracio.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
//Resposnvaél por fazer a manipulação do bd (analogo ao DML do BD); manipulação dos dados
public interface PostRepository extends JpaRepository<Post,Long> {

}
