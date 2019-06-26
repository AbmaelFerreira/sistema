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



@RequestMapping("empresa")
@Controller
public class EmpresaController {




    @Autowired
    private EmpresaServico empresaServico;

   /* @GetMapping("/login")
    public ModelAndView login(ModelMap model){
        model.addAttribute("empresas", empresaServico.recuperar());
        return new ModelAndView("/empresa/listaEmpresa");
    }
*/

    @GetMapping("/login")
    public String login(){

        return "login";
    }


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



    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvar(@Valid @ModelAttribute("empresa") Empresa empresa, BindingResult result, RedirectAttributes attr, ModelMap model)
    {

        if (result.hasErrors()){

            model.addAttribute("estados", empresaServico.recuperarEstado());
            model.addAttribute("municipios", empresaServico.recuperarMunicipio());
            return  "/empresa/add";
        }

        empresaServico.salvar(empresa);
        attr.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso");
        return  "redirect:/empresa/listar";
    }



    @GetMapping("/{id}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model){

        Empresa empresa = empresaServico.recuperarPorId(id);


        model.addAttribute("empresa", empresa);
        model.addAttribute("estados", empresaServico.recuperarEstado());
        model.addAttribute("municipios", empresaServico.recuperarMunicipio());
        return  new ModelAndView("/empresa/add", model);
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.PUT)
    public String atualizar(@Valid @ModelAttribute("empresa") Empresa empresa, BindingResult result, RedirectAttributes attr){
        if (result.hasErrors()){
            return  "/empresa/add";
        }
        empresaServico.atualizar(empresa);
        attr.addFlashAttribute("mensagem", "Cliente atualizado com sucesso");
        return  "redirect:/empresa/listar";
    }

    @GetMapping("/{id}/remover")
    public String remover(@PathVariable("id") long id,
                          RedirectAttributes attr) {
       empresaServico.excluir(id);
        attr.addFlashAttribute("mensagem", "Cliente excluído com sucesso.");
        return "redirect:/empresa/listar";
    }

}
