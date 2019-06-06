package br.com.sistema.controller;

import br.com.sistema.domain.Empresa;
import br.com.sistema.servico.EmpresaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
/*
    @GetMapping("/visualizar/{id}")
    public ModelAndView preVisualizar(@PathVariable("id") long id, ModelMap model){
        Empresa empresa = empresaServico.recuperarPorId(id);
        model.addAttribute("empresaId", empresa);
        return  new ModelAndView("/empresa/listaEmpresa", model);
    }

*/


}
