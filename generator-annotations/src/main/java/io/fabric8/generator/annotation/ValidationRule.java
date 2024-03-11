package io.fabric8.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Repeatable(ValidationRules.class)
@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidationRule {

  /**
   * @return the validation rule
   *         <a href=
   *         "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#validation-rules">
   *         Kubernetes Docs - CRD Validation - rule
   *         </a>
   */
  String value();

  /**
   * @return the message
   * @see <a href=
   *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#field-message">
   *      Kubernetes Docs - CRD Validation - message
   *      </a>
   */
  String message() default "";

  /**
   * @return the messageExpression
   * @see <a href=
   *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#the-messageexpression-field">
   *      Kubernetes Docs - CRD Validation - messageExpression
   *      </a>
   */
  String messageExpression() default "";

  /**
   * @return the reason
   * @see <a href=
   *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#field-reason">
   *      Kubernetes Docs - CRD Validation - reason
   *      </a>
   */
  String reason() default "";

  /**
   * @return the fieldPath
   * @see <a href=
   *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#field-field-path">
   *      Kubernetes Docs - CRD Validation - fieldPath
   *      </a>
   */
  String fieldPath() default "";

  /**
   * @return optionalOldSelf
   * @see <a href=
   *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#field-optional-oldself">
   *      Kubernetes Docs - CRD Validation - optionalOldSelf
   *      </a>
   */
  boolean optionalOldSelf() default false;
}
