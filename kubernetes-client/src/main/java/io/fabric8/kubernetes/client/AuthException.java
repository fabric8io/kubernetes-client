package io.fabric8.kubernetes.client;

/**
 * @author Sergey.Pak
 * Date: 24.02.22
 */
public class AuthException extends DetailedMessageException {
  public AuthException(String message, String details) {
    super(message, details);
  }
}
