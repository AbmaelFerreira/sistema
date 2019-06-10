package br.com.sistema.controller;

import br.com.sistema.domain.Empresa;
import br.com.sistema.domain.Pessoa;
import br.com.sistema.servico.EmpresaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("empresa")
public class EmpresaController {

    @Autowired
    private EmpresaServico empresaServico;


    @GetMapping("/listar")
    public ModelAndView listaEmpresa(ModelMap model){
            model.addAttribute("empresas", empresaServico.recuperar());
        return  new ModelAndView("/empresa/listaEmpresa", model);
    }

    /*Esse metodo redireciona para a pagina onde será adicionado as listas*/
    @GetMapping("/cadastro")
    public ModelAndView preSalvar( ModelMap model){
        Empresa empresa = new Empresa();
        model.addAttribute("estados", empresaServico.recuperarEstado());
        model.addAttribute("municipios", empresaServico.recuperarMunicipio());
        model.addAttribute("empresa", empresa);
        return  new ModelAndView("/empresa/add", model);
    }


    @ModelAttribute("pessoas")
    public Pessoa[] pessoa() {
        return Pessoa.values();
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("empresaCadastrada") Empresa empresaCadastrada, BindingResult result, RedirectAttributes attr){
        if (result.hasErrors()){
            return  "/empresa/add";
        }
        empresaServico.salvar(empresaCadastrada);
        attr.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso");
        return  "redirect:/empresa/listaEmpresa";
    }



}
