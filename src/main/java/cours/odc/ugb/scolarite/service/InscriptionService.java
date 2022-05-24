package cours.odc.ugb.scolarite.service;

import cours.odc.ugb.scolarite.dao.InscriptionRepository;
import cours.odc.ugb.scolarite.model.Etudiant;
import cours.odc.ugb.scolarite.model.Inscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InscriptionService implements IInscription {
    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Override
    public Inscription save(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription find(Long inscription_id) {
        Optional<Inscription> inscription = inscriptionRepository.findById(inscription_id);
        if(inscription.isPresent())
            return  inscription.get();
        return null;
    }

    @Override
    public List<Inscription> findAll() {
        return inscriptionRepository.findAll();
    }
}
