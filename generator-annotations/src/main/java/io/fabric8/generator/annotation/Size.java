package io.fabric8.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Decorates the resulting property with size limits.
 * <p>
 * The annotation can be used on strings, list/arrays and maps and will result in an appropriate JSON Schema constraint:
 * <ul>
 * <li>{@code minLength} and/or {@code maxLength} for a String</li>
 * <li>{@code minItems} and/or {@code maxItems} for a list/array</li>
 * <li>{@code minProperties} and/or {@code maxProperties} for a map</li>
 * </ul>
 * </p>
 *
 * @see <a href=
 *      "https://kubernetes.io/docs/reference/kubernetes-api/extend-resources/custom-resource-definition-v1/#JSONSchemaProps">
 *      Kubernetes Docs - API Reference - CRD v1 - JSONSchemaProps
 *      </a>
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Size {
  long min() default 0;

  long max() default Long.MAX_VALUE;
}
