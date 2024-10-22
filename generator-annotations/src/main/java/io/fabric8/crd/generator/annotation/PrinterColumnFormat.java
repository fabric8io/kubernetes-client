package io.fabric8.crd.generator.annotation;

/**
 * The format of a printer column.
 *
 * @see <a href=
 *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#format">Kubernetes
 *      Docs - CRD - Printer Column - Format</a>
 */
public enum PrinterColumnFormat {

  NONE(""),
  INT32("int32"),
  INT64("int64"),
  FLOAT("float"),
  DOUBLE("double"),
  BYTE("byte"),
  DATE("date"),
  DATE_TIME("date-time"),
  PASSWORD("password");

  public final String value;

  PrinterColumnFormat(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
