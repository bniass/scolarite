package cours.odc.ugb.scolarite.dao;

import cours.odc.ugb.scolarite.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    public Etudiant findByMatricule(String matricule);
}
