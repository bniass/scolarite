package cours.odc.ugb.scolarite.controller;

import cours.odc.ugb.scolarite.model.Classe;
import cours.odc.ugb.scolarite.model.Etudiant;
import cours.odc.ugb.scolarite.service.IEtudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {
    @Autowired
    private IEtudiant etudiantService;

    @PostMapping("/update")
    @ResponseBody
    public Etudiant update(@RequestBody Etudiant etudiant){
        return etudiantService.update(etudiant);
    }
    @GetMapping("/edit/{id}")
    @ResponseBody
    public Etudiant find(@PathVariable("id") long etudiant_id){
        return etudiantService.find(etudiant_id);
    }
    @GetMapping("/find/{matricule}")
    @ResponseBody
    public Etudiant findbymatricule(@PathVariable("matricule") String matricule){
        return etudiantService.findByMatricule(matricule);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Etudiant> findEtudiants(){
        return etudiantService.findAll();
    }


}
