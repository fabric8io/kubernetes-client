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

@Repeatable(ValidationRules.class)
@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })
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
