package fabio.springframework.demo.repositories;

import fabio.springframework.demo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
