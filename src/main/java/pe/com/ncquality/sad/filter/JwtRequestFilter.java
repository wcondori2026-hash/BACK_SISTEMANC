package pe.com.ncquality.sad.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import pe.com.ncquality.sad.service.JwtUserDetailsService;
import pe.com.ncquality.sad.util.JwtTokenUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	private static Logger depurador = Logger.getLogger(JwtRequestFilter.class.getName());

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		depurador.info(":::::::::::::::::::: 0001 ::::::::::::::::::");
		final String requestTokenHeader = request.getHeader("Authorization");
		depurador.info("requestTokenHeader :::::"+requestTokenHeader);
		String username = null;
		String jwtToken = null;		
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			depurador.info("ENTRA 1 :::::");
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				depurador.info("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				depurador.info("JWT Token has expired");
				request.setAttribute("expired", "Token Expirado");
			}
		} else {
			logger.warn("JWT Token does not begin with Bearer String");
		}

		// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			depurador.info("ENTRA 2 :::::");
			try {
				UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
				
				// if token is valid configure Spring Security to manually set
				// authentication
				if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					// After setting the Authentication in the context, we specify
					// that the current user is authenticated. So it passes the
					// Spring Security Configurations successfully.
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			} catch (UsernameNotFoundException e) {
				request.setAttribute("nofound", "Usuario inválido");
			}
		}
		chain.doFilter(request, response);

	}

}
