package cours.odc.ugb.scolarite.controller;

import cours.odc.ugb.scolarite.dao.ClasseRepository;
import cours.odc.ugb.scolarite.model.Classe;
import cours.odc.ugb.scolarite.service.IClasse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classe")
public class ClasseController {

    @Autowired
    private IClasse iClasse;


    @PostMapping("/add")
    @ResponseBody
    public Classe save(@RequestBody Classe classe){
        return iClasse.save(classe);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Classe> list(){
        return iClasse.findAll();
    }

    @GetMapping("/edit/{id}")
    @ResponseBody
    public Classe edit(@PathVariable("id") long id){
        return iClasse.find(id);
    }

    @GetMapping("/remove/{id}")
    @ResponseBody
    public List<Classe> remove(@PathVariable("id") long classe_id){
        Classe classe = iClasse.find(classe_id);
        iClasse.remove(classe);
        return iClasse.findAll();
    }
}
