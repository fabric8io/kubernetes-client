package io.fabric8.crd.generator.cli;

/**
 * Exception to indicate that no custom resource classes have been retained after scanning and
 * filtering.
 */
class CustomResourceClassNotFoundException extends CRDGeneratorCliException {
  CustomResourceClassNotFoundException() {
    super("No Custom Resource class retained after filtering");
  }
}
