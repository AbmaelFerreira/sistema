package br.com.sistema.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Websecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.
              authorizeRequests()
              .antMatchers("/login","/static/**", "/css/**", "/js/**","webjars/**").permitAll()
              .anyRequest()
                .authenticated()
                .and()
              .formLogin()
                    .loginPage("/empresa/login")
                    .permitAll()
                .and()
      .logout()
        .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
        builder
                .inMemoryAuthentication()
                .withUser("Administrador").password("123456").roles("EDITOR","ADMIN")
                .and()
                .withUser("Ana Paula").password("141620").roles("EDITOR");
    }

    public PasswordEncoder passwordencoder (){
        return  new BCryptPasswordEncoder();
    }
}
