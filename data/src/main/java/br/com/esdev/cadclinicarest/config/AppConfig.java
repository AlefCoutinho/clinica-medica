/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.esdev.cadclinicarest.config;

import br.com.esdev.cadclinicarest.filter.AutFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Aluno
 */
@Configuration
public class AppConfig {
    //injetamos um filtro de autenticações

    @Autowired
    private AutFilter autFilter;

    /**
     * adicionamos o filtro de login na navegação
     *
     * * @return
     */
    @Bean
    public FilterRegistrationBean<AutFilter> filterRegistrationBean() {
        FilterRegistrationBean<AutFilter> registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(autFilter);
//aplica-se apenas ao endpoint pessoa

        registrationBean.addUrlPatterns("/pessoa");
        registrationBean.addUrlPatterns("/paciente/*","/medicamento/*","/medico/*");

//define a ordem de precedencia do filtro
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
