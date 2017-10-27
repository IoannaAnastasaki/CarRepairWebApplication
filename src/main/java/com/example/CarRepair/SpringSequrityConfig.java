package com.example.CarRepair;


import com.example.CarRepair.SpringSecurity.LoginSuccessHandler;
import com.example.CarRepair.SpringSecurity.LoginAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SpringSequrityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginAuthenticationProvider loginAuthenticationProvider;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()

                .formLogin()
                .loginPage("/login")
                .successHandler(loginSuccessHandler)
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll()

                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .antMatchers("/userInfo").hasAnyAuthority("USER")

                .and()
                .authenticationProvider(loginAuthenticationProvider);
    }
}
