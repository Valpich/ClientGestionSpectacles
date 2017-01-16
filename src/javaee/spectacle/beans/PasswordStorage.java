package javaee.spectacle.beans;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

public class PasswordStorage {

  static public class InvalidHashException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidHashException(String message) {
      super(message);
    }

    public InvalidHashException(String message, Throwable source) {
      super(message, source);
    }
  }

  static public class CannotPerformOperationException extends Exception {

    private static final long serialVersionUID = 1L;

    public CannotPerformOperationException(String message) {
      super(message);
    }

    public CannotPerformOperationException(String message, Throwable source) {
      super(message, source);
    }
  }

  public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

  public static final int SALT_BYTE_SIZE = 24;
  public static final int HASH_BYTE_SIZE = 64;
  public static final int PBKDF2_ITERATIONS = 64000;
  public static final int HASH_SECTIONS = 5;
  public static final int HASH_ALGORITHM_INDEX = 0;
  public static final int ITERATION_INDEX = 1;
  public static final int HASH_SIZE_INDEX = 2;
  public static final int SALT_INDEX = 3;
  public static final int PBKDF2_INDEX = 4;

  public static String createHash(String password) throws CannotPerformOperationException {
    return createHash(password.toCharArray());
  }

  public static String createHash(char[] password) throws CannotPerformOperationException {
    // Genere un sel aleatoire
    final SecureRandom random = new SecureRandom();
    final byte[] salt = new byte[SALT_BYTE_SIZE];
    random.nextBytes(salt);
    // Hash le mot de passe
    final byte[] hash = pbkdf2(password, salt, PBKDF2_ITERATIONS, HASH_BYTE_SIZE);
    final int hashSize = hash.length;
    // Formatte suivant le model : algorithme:iterations:tailleDuHash:sel:hash
    final String parts =
        "sha1:" + PBKDF2_ITERATIONS + ":" + hashSize + ":" + toBase64(salt) + ":" + toBase64(hash);
    return parts;
  }

  public static boolean verifyPassword(String password, String correctHash)
      throws CannotPerformOperationException, InvalidHashException {
    return verifyPassword(password.toCharArray(), correctHash);
  }

  public static boolean verifyPassword(char[] password, String correctHash)
      throws CannotPerformOperationException, InvalidHashException {
    // Decode le hash en ses parameters
    final String[] params = correctHash.split(":");
    if (params.length != HASH_SECTIONS) {
      throw new InvalidHashException("Il manque des champs dans le hash.");
    }
    if (!params[HASH_ALGORITHM_INDEX].equals("sha1")) {
      throw new CannotPerformOperationException("Type de hash incorrect.");
    }
    int iterations = 0;
    try {
      iterations = Integer.parseInt(params[ITERATION_INDEX]);
    } catch (final NumberFormatException ex) {
      throw new InvalidHashException("Impossible d'obtenir un entier.", ex);
    }
    if (iterations < 1) {
      throw new InvalidHashException("Nombre d'iteration invalide, doit être >= 1.");
    }
    byte[] salt = null;
    try {
      salt = fromBase64(params[SALT_INDEX]);
    } catch (final IllegalArgumentException ex) {
      throw new InvalidHashException("Echec du decodage du sel depuis la base64.", ex);
    }
    byte[] hash = null;
    try {
      hash = fromBase64(params[PBKDF2_INDEX]);
    } catch (final IllegalArgumentException ex) {
      throw new InvalidHashException("Echec du decodage du hash depuis la base64.", ex);
    }

    int storedHashSize = 0;
    try {
      storedHashSize = Integer.parseInt(params[HASH_SIZE_INDEX]);
    } catch (final NumberFormatException ex) {
      throw new InvalidHashException("La taille du hash n'est pas un entier.", ex);
    }

    if (storedHashSize != hash.length) {
      throw new InvalidHashException("La taille du hash n'est pas celle stockee.");
    }
    // Reproduit le hashage sur le mot de passe
    final byte[] testHash = pbkdf2(password, salt, iterations, hash.length);
    // Compare les deux hashs
    return slowEquals(hash, testHash);
  }

  private static boolean slowEquals(byte[] a, byte[] b) {
    int diff = a.length ^ b.length;
    for (int i = 0; i < a.length && i < b.length; i++) {
      diff |= a[i] ^ b[i];
    }
    return diff == 0;
  }

  private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes)
      throws CannotPerformOperationException {
    try {
      final PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
      final SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
      return skf.generateSecret(spec).getEncoded();
    } catch (final NoSuchAlgorithmException ex) {
      throw new CannotPerformOperationException("Algorithme de hash non supporte.", ex);
    } catch (final InvalidKeySpecException ex) {
      throw new CannotPerformOperationException("Mauvaise KeySpec.", ex);
    }
  }

  private static byte[] fromBase64(String hex) throws IllegalArgumentException {
    return DatatypeConverter.parseBase64Binary(hex);
  }

  private static String toBase64(byte[] array) {
    return DatatypeConverter.printBase64Binary(array);
  }

}
