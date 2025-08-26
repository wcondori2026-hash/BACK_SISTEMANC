package pe.com.ncquality.sad.mpd;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class MpdApplicationTests {

	//@Test
	void contextLoads() {
	}
public static void main(String[] args) {
        String secret = "NCQuality232Constructora$$123";

        // Generar el token
        String token = Jwts.builder()
                .setSubject("usuarioDePrueba")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 1 hora
                .signWith(SignatureAlgorithm.HS512, secret.getBytes(StandardCharsets.UTF_8))
                .compact();

        System.out.println("TOKEN GENERADO:");
        System.out.println(token);

        // Validar el token
        Claims claims = Jwts.parser()
                .setSigningKey(secret.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();

        System.out.println("\nUSUARIO EXTRAÍDO DEL TOKEN:");
        System.out.println(claims.getSubject());
    }
}
