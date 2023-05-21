package br.com.recycleplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.recycleplus.DTO.MaterialDTO;
import br.com.recycleplus.repository.MaterialRepository;

@RestController
@RequestMapping("/materials")
public class MaterialController {

    @Autowired
    MaterialRepository repository;

    @GetMapping
    public List<MaterialDTO> listAll() {
        return repository.findAll().stream().map(MaterialDTO::new).toList();
    }

}
