package com.projetoloja.controllers;

import com.projetoloja.models.ClienteModel;
import com.projetoloja.models.FuncionarioModel;
import com.projetoloja.repository.FuncionarioRepository;
import com.projetoloja.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @RequestMapping(value = "/novoFuncionario", method = RequestMethod.GET)
    public String getFormFuncionario() {
        return"funcionario/formFuncionario";
    }

    @RequestMapping(value = "/novoFuncionario", method = RequestMethod.POST)
    public String cadastrarCliente(@Valid FuncionarioModel funcionario, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/novoFuncionario";
        }
        funcionarioRepository.save(funcionario);
        return"redirect:/listarClientes";
    }

}
