package com.projetoloja.controllers;

import com.projetoloja.models.AparelhoModel;
import com.projetoloja.models.ClienteModel;
import com.projetoloja.models.OrdemServicoModel;
import com.projetoloja.repository.AparelhoRepository;
import com.projetoloja.repository.ClienteRepository;
import com.projetoloja.repository.OrdemServicoRepository;
import com.projetoloja.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private AparelhoRepository aparelhoRepository;

	@RequestMapping(value="/listar")
	public String form() {
		return "index";
	}

	@RequestMapping(value = "/listarClientes", method = RequestMethod.GET)
	public ModelAndView listarClientes() {
		Iterable<ClienteModel> clienteLista = clienteRepository.findAll();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("clienteLista", clienteLista);
		return mv;
	}

	@RequestMapping(value = "/novoCliente", method = RequestMethod.GET)
	public String getFormCliente() {
		return"cliente/formCliente";
	}

	@RequestMapping(value = "/novoCliente", method = RequestMethod.POST)
	public String cadastrarCliente(@Valid ClienteModel cliente, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/novoCliente";
		}
		clienteRepository.save(cliente);
		return"redirect:/listarClientes";
	}

	@RequestMapping(value="/detalhesCliente/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesCliente(@PathVariable("codigo") long codigo){
		ClienteModel cliente = clienteRepository.findById(codigo);
		Iterable<OrdemServicoModel> listOrder = ordemServicoRepository.findBycliente(cliente);
		ModelAndView mv = new ModelAndView("cliente/detalhesCliente");
		mv.addObject("cliente", cliente);
		mv.addObject("listaOrdemServico", listOrder);
		return mv;
	}
}
