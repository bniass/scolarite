package cours.odc.ugb.scolarite.service;

import cours.odc.ugb.scolarite.model.Inscription;

import java.util.List;

public interface IInscription {
    public Inscription save(Inscription inscription);
    public Inscription find(Long inscription_d);
    public List<Inscription> findAll();

}
