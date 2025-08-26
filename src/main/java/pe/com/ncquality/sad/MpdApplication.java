package pe.com.ncquality.sad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpMethod;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import pe.com.ncquality.sad.filter.JwtRequestFilter;
 
import pe.com.ncquality.sad.util.JwtAuthenticationEntryPoint;
 

@EnableAsync
@SpringBootApplication
@Import(MvcConfig.class) 
public class MpdApplication extends AsyncConfigurerSupport{
 
	public static void main(String[] args) {
		SpringApplication.run(MpdApplication.class, args);
	}
	
	@Override
    @Bean(name = "AsyncPool")
    public TaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(50);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(50);
        executor.setWaitForTasksToCompleteOnShutdown(false);
        executor.setThreadNamePrefix("Async-");
        executor.initialize();
        return executor;
    }

	@EnableWebSecurity
	@Configuration
	@EnableGlobalMethodSecurity(prePostEnabled = true)

	@Order(1000) 
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		@Autowired
		private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
		@Autowired
		private UserDetailsService jwtUserDetailsService;
		@Autowired
		private JwtRequestFilter jwtRequestFilter;

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
		}

		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}

		@Override
		protected void configure(HttpSecurity httpSecurity) throws Exception {
			
                        httpSecurity.cors().and().csrf().disable()
                        .authorizeRequests()
                        .antMatchers("/v1/auth/**").permitAll() // Permitir acceso sin autenticación a la ruta de autenticación
                        //.antMatchers("/v1/cotizacion/**").hasRole("OPERADOR") //PUBLIC
                        .antMatchers("/v1/compras/**").permitAll()                  
                        .antMatchers("/v1/objects/**").permitAll()//hasRole("OPERADOR")
                        .antMatchers("/v1/proyectos/**").permitAll()
                       // .antMatchers("/swagger-ui.html/**").permitAll()
                       // .antMatchers("/webjars/**").permitAll()
                      //  .antMatchers("/swagger-resources/**").permitAll()
                      //  .antMatchers("/v2/api-docs/**").permitAll()
                        .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
                        .and()
                        .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint) // Manejo de excepciones de autenticación
                        .and()
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Configurar política de creación de sesiones
  
            httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

         
		}
		
		
	}
}
