package cours.odc.ugb.scolarite.service;

import cours.odc.ugb.scolarite.model.Classe;

import java.util.List;

public interface IClasse {
    public Classe save(Classe classe);
    public Classe find(Long classe_d);
    public List<Classe> findAll();
    public void remove(Classe classe);
}
