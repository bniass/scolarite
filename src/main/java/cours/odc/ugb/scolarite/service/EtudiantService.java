package cours.odc.ugb.scolarite.service;

import cours.odc.ugb.scolarite.dao.ClasseRepository;
import cours.odc.ugb.scolarite.dao.EtudiantRepository;
import cours.odc.ugb.scolarite.model.Classe;
import cours.odc.ugb.scolarite.model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService implements IEtudiant {
    @Autowired
    private EtudiantRepository etudiantRepository;


    @Override
    public Etudiant update(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant find(Long etudiant_id) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(etudiant_id);
        if(etudiant.isPresent())
            return  etudiant.get();
        return null;
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findByMatricule(String matricule) {
        return etudiantRepository.findByMatricule(matricule);
    }


}
