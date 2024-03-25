/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A Kubernetes validation rule.
 *
 * @see <a href=
 *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#validation-rules">
 *      Kubernetes Docs - CRD Validation
 *      </a>
 */
@Repeatable(ValidationRules.class)
@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidationRule {

  /**
   * The validation rule.
   *
   * @return the validation rule
   *         <a href=
   *         "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#validation-rules">
   *         Kubernetes Docs - CRD Validation - rule
   *         </a>
   */
  String value();

  /**
   * The static message of the validation rule.
   * <p>
   * If you want to set a static message, you can supply {@code message} rather than {@link ValidationRule#messageExpression()}.
   * The value of {@code message} is used as an opaque error string if validation fails
   * </p>
   *
   * @return the message
   * @see <a href=
   *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#field-message">
   *      Kubernetes Docs - CRD Validation - message
   *      </a>
   */
  String message() default "";

  /**
   * The messageExpression of the validation rule.
   * <p>
   * Similar to the {@link ValidationRule#message()} field, which defines the string reported for a validation rule failure,
   * {@code messageExpression} allows you to use a CEL expression to construct the message string.
   * </p>
   *
   * @return the messageExpression
   * @see <a href=
   *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#the-messageexpression-field">
   *      Kubernetes Docs - CRD Validation - messageExpression
   *      </a>
   */
  String messageExpression() default "";

  /**
   * The machine-readable validation failure reason.
   * <p>
   * The currently supported reasons are: "FieldValueInvalid", "FieldValueForbidden", "FieldValueRequired",
   * "FieldValueDuplicate".
   * If not set or for unknown reasons, it defaults to "FieldValueInvalid".
   * </p>
   *
   * @return the reason
   * @see <a href=
   *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#field-reason">
   *      Kubernetes Docs - CRD Validation - reason
   *      </a>
   */
  String reason() default "";

  /**
   * The field path of the validation rule.
   * <p>
   * Specifies the field to be returned when the validation fails.
   * </p>
   *
   * @return the fieldPath
   * @see <a href=
   *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#field-field-path">
   *      Kubernetes Docs - CRD Validation - fieldPath
   *      </a>
   */
  String fieldPath() default "";

  /**
   * The {@code optionalOldSelf} field is a boolean field that alters the behavior of Transition Rules described below.
   * Normally, a transition rule will not evaluate if {@code oldSelf} cannot be determined: during object creation or
   * when a new value is introduced in an update.
   * If {@code optionalOldSelf} is set to true, then transition rules will always be evaluated and the type
   * of {@code oldSelf} will be changed to a CEL
   * <a href="https://pkg.go.dev/github.com/google/cel-go/cel#OptionalTypes">Optional</a> type.
   * The feature
   * <a href=
   * "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#validation-ratcheting">CRDValidationRatcheting</a>
   * must be enabled in order to make use of this field.
   *
   * @return optionalOldSelf
   * @see <a href=
   *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#field-optional-oldself">
   *      Kubernetes Docs - CRD Validation - optionalOldSelf
   *      </a>
   */
  boolean optionalOldSelf() default false;
}
