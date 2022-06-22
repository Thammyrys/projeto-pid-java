package com.projetoloja.controllers;

import com.projetoloja.models.*;
import com.projetoloja.repository.AparelhoRepository;
import com.projetoloja.repository.ClienteRepository;
import com.projetoloja.repository.FuncionarioRepository;
import com.projetoloja.repository.OrdemServicoRepository;
import com.projetoloja.services.AparelhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AparelhoController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private AparelhoRepository aparelhoRepository;

    @RequestMapping(value="/novaOrdemServico")
    public String form() {
        return "/novaOrdemServico";
    }

    @RequestMapping(value="/novaOrdemServico", method = RequestMethod.POST)
    public String form(@Valid OrdemServicoDao ordemServicoDao, BindingResult result, RedirectAttributes attributes) throws Exception {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/novaOrdemServico";
        }

        ClienteModel cliente = clienteRepository.findById(ordemServicoDao.getCliente());
        FuncionarioModel funcionario = funcionarioRepository.findById(ordemServicoDao.getFuncionario());
        OrdemServicoModel ordem = new OrdemServicoModel();
        ordem.setDataEntrada(LocalDateTime.now());
        ordem.setCliente(cliente);
        ordem.setFuncionario(funcionario);
        ordemServicoRepository.save(ordem);
        return "redirect:/cadastrarAparelhos/" + ordem.getId();
    }

    @RequestMapping(value = "/novaOrdemServico", method = RequestMethod.GET)
    public ModelAndView listarClientes() {
        Iterable<ClienteModel> clienteLista = clienteRepository.findAll();
        Iterable<FuncionarioModel> funcionarioLista = funcionarioRepository.findAll();
        ModelAndView mv = new ModelAndView("aparelho/formOrdemServico");
        mv.addObject("clientes", clienteLista);
        mv.addObject("funcionarios", funcionarioLista);
        mv.addObject("ordemServico", new OrdemServicoDao());
        return mv;
    }

    @RequestMapping(value="/aparelhos/{codigo}", method=RequestMethod.GET)
    public ModelAndView detalhesAparelho(@PathVariable("codigo") long codigo){
        OrdemServicoModel ordem = ordemServicoRepository.findById(codigo);
        Iterable<AparelhoModel> listaAparelhos = aparelhoRepository.findByOrdemServico(ordem);
        ModelAndView mv = new ModelAndView("aparelho/listaAparelhos");
        mv.addObject("listaAparelhos", listaAparelhos);
        return mv;
    }

    @RequestMapping(value = "/cadastrarAparelhos/{codigoOs}", method = RequestMethod.GET)
    public ModelAndView cadastrarAparelhos(@PathVariable("codigoOs") long codigoOs) {
        OrdemServicoModel ordemServico = ordemServicoRepository.findById(codigoOs);
        ModelAndView mv = new ModelAndView("aparelho/formAparelhos");
        mv.addObject("ordemServico", ordemServico);
        mv.addObject("aparelhoServicoDao", new AparelhoServicoDao());
        return mv;
    }

    @RequestMapping(value="/cadastrarAparelhos", method = RequestMethod.POST)
    public String form(@Valid AparelhoServicoDao aparelhoServicoDao, BindingResult result, RedirectAttributes attributes) throws Exception {
        if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/cadastrarAparelhos/" + aparelhoServicoDao.getNumOrdemServico();
        }
        ClienteModel cliente = clienteRepository.findByNomeCliente(aparelhoServicoDao.getCliente());
        FuncionarioModel funcionario = funcionarioRepository.findByNomeFunc(aparelhoServicoDao.getAtendente());
        OrdemServicoModel ordem = ordemServicoRepository.findById(aparelhoServicoDao.getNumOrdemServico());
        AparelhoModel aparelhoModel = new AparelhoModel();
        aparelhoModel.setNomeAparelho(aparelhoServicoDao.getNomeAparelho());
        aparelhoModel.setModeloAparelho(aparelhoServicoDao.getModeloAparelho());
        aparelhoModel.setMarcaAparelho(aparelhoServicoDao.getMarcaAparelho());
        aparelhoModel.setNumeroSerie(aparelhoServicoDao.getNumeroSerie());
        aparelhoModel.setDescricaoDefeito(aparelhoServicoDao.getDescricaoDefeito());
        aparelhoModel.setCliente(cliente);
        aparelhoModel.setFuncionario(funcionario);
        aparelhoModel.setOrdemServico(ordem);
        aparelhoRepository.save(aparelhoModel);
        return "redirect:/cadastrarAparelhos/" + ordem.getId();
    }
}

