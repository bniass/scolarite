package cours.odc.ugb.scolarite.service;

import cours.odc.ugb.scolarite.model.Classe;
import cours.odc.ugb.scolarite.model.Etudiant;

import java.util.List;

public interface IEtudiant {
    public Etudiant update(Etudiant etudiant);
    public Etudiant find(Long etudiant_d);
    public List<Etudiant> findAll();
    public Etudiant findByMatricule(String matricule);
}
