package io.fabric8.crd.generator.cli;

class CRDGeneratorCliException extends RuntimeException {
  CRDGeneratorCliException(String message) {
    super(message);
  }

  CRDGeneratorCliException(String message, Throwable cause) {
    super(message, cause);
  }
}
