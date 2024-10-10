package io.fabric8.crdv2.generator.alt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that allows additionalPrinterColumns entries to be created with arbitrary JSONPaths.
 */
@Repeatable(AdditionalPrinterColumn.List.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AdditionalPrinterColumn {

  String name();

  String jsonPath();

  AdditionalPrinterColumn.Type type() default Type.STRING;

  AdditionalPrinterColumn.Format format() default Format.NONE;

  String description() default "";

  int priority() default 0;

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @interface List {

    AdditionalPrinterColumn[] value();
  }

  // https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#type
  public static enum Type {

    STRING("string"),
    INTEGER("integer"),
    NUMBER("number"),
    BOOLEAN("boolean"),
    DATE("date");

    public final String value;

    Type(String value) {
      this.value = value;
    }
  }

  // https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#format
  public static enum Format {

    NONE(""),
    INT32("int32"),
    INT64("int64"),
    FLOAT("float"),
    DOUBLE("double"),
    BYTE("byte"),
    BINARY("binary"),
    DATE("date"),
    DATE_TIME("date-time"),
    PASSWORD("password");

    public final String value;

    Format(String value) {
      this.value = value;
    }
  }
}