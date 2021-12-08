package Employee.config;

import Employee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityServiceConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(generateEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,
                        "/api/customers",
                        "/api/count/**",
                        "/api/car/maxMileage",
                        "api/all/reservation").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.PUT, "/api/rental/{rentalId}",
                        "/api/car/{id}",
                        "api/car-status/{carStatusId}",
                        "api/assign/**",
                        "api/update/revenue/{revenueId}").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.DELETE, "/api/branch/{branchId}").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.POST,
                        "/api/branch",
                        "api/refund",
                        "api/loan").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.POST, "/api/reservation").hasRole("CUSTOMER")
                .antMatchers(
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/webjars/**",
                        "/h2/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                .and().formLogin().and().logout()
                .and().headers().frameOptions().disable()
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder generateEncoder() {
        return new BCryptPasswordEncoder();
    }
}

