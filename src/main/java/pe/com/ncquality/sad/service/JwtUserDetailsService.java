package pe.com.ncquality.sad.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.com.ncquality.sad.bean.Role;

@Service("jwtUserDetailsService")
public class JwtUserDetailsService implements UserDetailsService{
	private static final Log logger = LogFactory.getLog(JwtUserDetailsService.class);
//	@Autowired
//	@Qualifier("usuarioRepositorio")
//	private UsuarioRepositorio usuarioRepositorio;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info(":::::::::::::::::: loadUserByUsernam :::::::::::::::::::::");

		List<Role> lista = new ArrayList<>();
		Role role = new Role();
                if ("PUBLIC".equals(username)) {
                    role.setName("ROLE_PUBLIC"); 
                }
                else{
                    role.setName("ROLE_OPERADOR"); 
                }		
		lista.add(role);
		return new User(username, "$2a$10$hrCgWUDEwKir3jCa7V6SruWbqP3a1UWv036Xs6cgdWvkaIpD6MIxe",true, true, true, true, getAuthorities(lista));
	}
	

	private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles) {
			System.out.println("ROLE ==>" + role.getName());
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

		
		
}
