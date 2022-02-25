package io.fabric8.kubernetes.client;

/**
 * @author Sergey.Pak
 * Date: 24.02.22
 */
public class DetailedMessageException extends Exception {

  private final String message;
  private final String details;

  public DetailedMessageException(String message, String details) {
    super(String.format("%s (details follow)\nDetails:\n%s", message, details));
    this.message = message;
    this.details = details;
  }
}
