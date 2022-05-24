package cours.odc.ugb.scolarite.dao;

import cours.odc.ugb.scolarite.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
}
