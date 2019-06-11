package br.com.sistema.converter;

import br.com.sistema.domain.Pessoa;
import org.springframework.core.convert.converter.Converter;

public class PessoaConverter implements Converter<String, Pessoa> {


        public Pessoa convert(String value) {
            String  tipo = value.toString();
            return tipo == Pessoa.JURIDICA.getDesc() ? Pessoa.JURIDICA : Pessoa.FISICA;
        }
}
