package pe.com.ncquality.sad.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.nio.charset.StandardCharsets;
import pe.com.ncquality.sad.dto.PersonasDTO;


@Component
public class JwtTokenUtil implements Serializable {
	private static Logger depurador = Logger.getLogger(JwtTokenUtil.class.getName());
	private static final long serialVersionUID = -2550185165626007488L;

	public static final int JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;

	// Obtiene el username del jwt token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	// Obtiene el la fecha de expiracion del jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	// Para recuperar cualquier información del token necesitaremos la clave secreta
	private Claims getAllClaimsFromToken(String token) {
		//return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
                return Jwts.parser()
        .setSigningKey(secret.getBytes(StandardCharsets.UTF_8))
        .parseClaimsJws(token)
        .getBody();
	}

	// revisa si el token ah expirado
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	// genera el token para el usuario
	public String generateToken(UserDetails userDetails, PersonasDTO persona) {
		depurador.info("generateToken ::::::");
		final String authorities = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
		Map<String, Object> claims = new HashMap<>();
                claims.put("authorities", authorities);
                if(persona!=null){
                    claims.put("idPersona", persona.getIdPersona());
                    claims.put("nombres", persona.getvNombRazon());
                    claims.put("apellidoPaterno", persona.getvApelPaterno());
                    claims.put("apellidoMaterno", persona.getvApelMaterno());
                    claims.put("nroDocumento", persona.getvNumDocumento());
                    claims.put("idEmpleado", persona.getIdEmpleado());
                }
		String token = doGenerateToken(claims, userDetails.getUsername(), authorities);
		depurador.info("TOKEN ::: "+token);
		depurador.info("USUARIO TOKEN :::: "+getUsernameFromToken(token)); 
		depurador.info("FECHA TOKEN ::: "+ getExpirationDateFromToken(token));
		return token;
	}

	// while creating the token -
	// 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
	// 2. Sign the JWT using the HS512 algorithm and secret key.
	// 3. According to JWS Compact
	// Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	// compaction of the JWT to a URL-safe string
	private String doGenerateToken(Map<String, Object> claims, String subject, String authorities) {
		
		/*return Jwts.builder()
				.setClaims(claims)
				.claim("role", authorities)
				.setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();*/
                return Jwts.builder()
                        .setClaims(claims)
                        .claim("role", authorities)
                        .setSubject(subject)
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                        .signWith(SignatureAlgorithm.HS512, secret.getBytes(StandardCharsets.UTF_8))
                        .compact();
	}

	// Valida token
	public Boolean validateToken(String token, UserDetails userDetails) {
		/*final String username = getUsernameFromToken(token);
		System.out.println("USER NAME 1==>"+username);
		System.out.println("USER NAME 2==>"+userDetails.getUsername());
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));*/
                try {
                    final String username = getUsernameFromToken(token);
                    System.out.println("USER NAME 1==>"+username);
		    System.out.println("USER NAME 2==>"+userDetails.getUsername());
                    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
                } catch (Exception e) {
                    //depurador.warning("Error al validar el token: " + e.getMessage());
                    return false;
                }
	}

}
