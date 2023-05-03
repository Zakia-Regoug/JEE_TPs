package ma.enset.mvc_web.web;

import lombok.AllArgsConstructor;
import ma.enset.mvc_web.entities.Patient;
import ma.enset.mvc_web.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller @AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String patients(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String key){
        //Page<Patient> pagePatients =patientRepository.findAll(PageRequest.of(page,size));
        Page<Patient> pagePatients =patientRepository.findByNomContains(key,PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",key);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id, int page, String keyword){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/update")
    public String update(Long id, int page, String keyword){
        patientRepository.findById(id);
        //je dois creer une vue pour modifier le patient selectionner puis l'enregistrer dans patientRepository
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
}
