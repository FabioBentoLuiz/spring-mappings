package fabio.springframework.demo.repositories;

import fabio.springframework.demo.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
}
