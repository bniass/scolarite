package cours.odc.ugb.scolarite.controller;

import cours.odc.ugb.scolarite.model.Etudiant;
import cours.odc.ugb.scolarite.model.Inscription;
import cours.odc.ugb.scolarite.service.EtudiantService;
import cours.odc.ugb.scolarite.service.IEtudiant;
import cours.odc.ugb.scolarite.service.IInscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscription")
public class InscriptionController {
    @Autowired
    private IInscription inscriptionService;
    @Autowired
    private IEtudiant etudiantService;

    @PostMapping("/update")
    @ResponseBody
    public Inscription save(@RequestBody Inscription inscription){
        if(inscription.getEtudiant().getId() != 0){
            Etudiant e = etudiantService.find(inscription.getEtudiant().getId());
            inscription.setEtudiant(e);
        }
        return inscriptionService.save(inscription);
    }

    @GetMapping("/edit/{id}")
    @ResponseBody
    public Inscription find(@PathVariable("id") long inscription_id){
        return inscriptionService.find(inscription_id);
    }


    @GetMapping("/list")
    @ResponseBody
    public List<Inscription> findInscriptions(){
        return inscriptionService.findAll();
    }


}
