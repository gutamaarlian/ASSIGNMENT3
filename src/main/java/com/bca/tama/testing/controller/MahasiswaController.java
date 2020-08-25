package com.bca.tama.testing.controller;

import com.bca.tama.testing.Entity.Mahasiswa;
import com.bca.tama.testing.util.MahasiswaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MahasiswaController {

    @Autowired
    private MahasiswaDAO mahasiswaRepository;

    @GetMapping({"/", "/student"})
    public String index(@PageableDefault(size=3)Pageable pageable, Model model) {
        Page<Mahasiswa> page = mahasiswaRepository.findAll(pageable);


        model.addAttribute("page",page);
        model.addAttribute("total",page.getTotalElements());
        return "student";
    }

    @PostMapping(path = "/student/add")
    String addNewMahasiswa(@RequestParam String jurusan, @RequestParam String name, @RequestParam String nim, @RequestParam float ipk){
        Mahasiswa m = new Mahasiswa();
        m.setIpk(ipk);
        m.setJurusan(jurusan);
        m.setName(name);
        m.setNim(nim);
        mahasiswaRepository.save(m);
        return "redirect:/student";
    }



    @GetMapping(path ="/all-student")
    public @ResponseBody
    Iterable <Mahasiswa> getAllStudent(){
        return mahasiswaRepository.findAll();
    }


    @PostMapping("/student/{id}" )
        public String updateMahasiswa (@PathVariable("id") int id, @RequestParam String jurusan, @RequestParam String name, @RequestParam String nim, @RequestParam float ipk){
        Mahasiswa m = mahasiswaRepository.findById(id).get();
        System.out.println(m.getName());
        m.setIpk(ipk);
        m.setJurusan(jurusan);
        m.setName(name);
        m.setNim(nim);
        mahasiswaRepository.save(m);
        return "redirect:/student";
    }

    @PostMapping("/student/delete/{id}" )
    public String deleteMahasiswa (@PathVariable("id") int id){
      Mahasiswa m = mahasiswaRepository.findById(id).get();
        mahasiswaRepository.delete(m);
        return "redirect:/student";
    }





//    @DeleteMapping("/student/{id}" )
//    public ResponseEntity <Mahasiswa> deleteMahasiswa (@PathVariable("id") int id){
//        Mahasiswa m = mahasiswaRepository.findById(id).get();
//        mahasiswaRepository.delete(m);
//        return ResponseEntity.ok().body(m);
//    }

//    @PutMapping("/student/{id}" )
//    public ResponseEntity <Mahasiswa> updateMahasiswa (@PathVariable("id") int id, @RequestParam String jurusan, @RequestParam String name, @RequestParam String nim, @RequestParam float ipk){
//        Mahasiswa m = mahasiswaRepository.findById(id).get();
//        System.out.println(m.getName());
//        m.setIpk(45);
//        m.setJurusan("IPAAA");
//        m.setName("google");
//        m.setNim("00000000000000");
//        mahasiswaRepository.save(m);
//        return ResponseEntity.ok().body(m);
//    }
}
