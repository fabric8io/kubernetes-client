/**
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
package io.fabric8.kubernetes.api.model.validators;

import io.fabric8.kubernetes.api.model.ObjectMeta;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ObjectMetaValidator implements ConstraintValidator<CheckObjectMeta, ObjectMeta> {

  private String regexp;
  private int max;
  private boolean minimal;

  private static final String[] NAME_MAY_NOT_BE = new String[]{".", ".."};
  private static final String[] NAME_MAY_NOT_CONTAIN = new String[]{"/", "%"};

  @Override
  public void initialize(CheckObjectMeta constraintAnnotation) {
    regexp = constraintAnnotation.regexp();
    max = constraintAnnotation.max();
    minimal = constraintAnnotation.minimal();
  }

  @Override
  public boolean isValid(ObjectMeta value, ConstraintValidatorContext context) {
    if (value == null || value.getName() == null) {
      return true;
    }

    String name = value.getName();

    if (minimal) {
      return validateMinimal(name, context);
    }

    return validateRegex(name, context);
  }

  private boolean validateRegex(String name, ConstraintValidatorContext context) {
    if (!name.matches(regexp)) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(
          "{io.fabric8.kubernetes.api.model.Pattern.message}")
          .addPropertyNode("name")
          .addConstraintViolation();

      return false;
    }
    if (0 <= max && max < name.length()) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(
          "{io.fabric8.kubernetes.api.model.MaxLength.message}")
          .addPropertyNode("name")
          .addConstraintViolation();

      return false;
    }

    return true;
  }

  private boolean validateMinimal(String name, ConstraintValidatorContext context) {
    for (String illegalName : NAME_MAY_NOT_BE) {
      if (illegalName.equals(name)) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(
            "name may not be " + illegalName)
            .addPropertyNode("name")
            .addConstraintViolation();

        return false;
      }
    }

    for (String illegalContent : NAME_MAY_NOT_CONTAIN) {
      if (name.contains(illegalContent)) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(
            "name may not contain " + illegalContent)
            .addPropertyNode("name")
            .addConstraintViolation();

        return false;
      }
    }

    return true;
  }
}
