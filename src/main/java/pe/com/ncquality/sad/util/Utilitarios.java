package pe.com.ncquality.sad.util;

import java.security.MessageDigest;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Utilitarios {
	
	public static String getAleatorioNumero() {
		Random numAleatorio = new Random();
		int numero = numAleatorio.nextInt(20000-10000+1) + 25;
		return String.valueOf(numero);
	}

	public static String getAleatorioLetra() {
		StringBuffer sBuffer = new StringBuffer("");
		for (int i = 0; i < 5; i++) {
			char randomCharacter = getRandomCharacter();
			sBuffer.append(randomCharacter);
		}

		return sBuffer.toString();
	}

	static char getRandomCharacter() {
		switch ((int) (Math.random() * 2)) {
		case 0:
			return (char) (Math.random() * 26 + 'A');

		case 1:
			return (char) (Math.random() * 26 + 'a');
		}
		return 0;
	}

	public static String validarCodigoVerificadorDni(String DNI) {
		try {
			Integer[] Serie = { 3, 2, 7, 6, 5, 4, 3, 2 };
			String[] ArrayValidador = { "6", "7", "8", "9", "0", "1", "1", "2", "3", "4", "5", "6" };
			int Suma = 0;

			char[] arrayDni = DNI.toCharArray();
			for (int i = 0; i < arrayDni.length; i++) {
				Suma += Integer.valueOf(String.valueOf(arrayDni[i])) * Serie[i];
			}
			int Residuo = 11 - (Suma % 11);

			return ArrayValidador[Residuo];
		} catch (Exception e) {
			throw e;
		}

	}

	public static String cifrar(String sinCifrar, String key) throws Exception {
		final byte[] bytes = sinCifrar.getBytes("UTF-8");
		final Cipher aes = obtieneCipher(true, key);
		final byte[] cifrado = aes.doFinal(bytes);
		return DatatypeConverter.printHexBinary(cifrado);
	}

	private static Cipher obtieneCipher(boolean paraCifrar, String keyString) throws Exception {
		final MessageDigest digest = MessageDigest.getInstance("SHA");
		digest.update(keyString.getBytes("UTF-8"));
		final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

		final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
		if (paraCifrar) {
			aes.init(Cipher.ENCRYPT_MODE, key);
		} else {
			aes.init(Cipher.DECRYPT_MODE, key);
		}

		return aes;
	}
}
