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
package io.fabric8.crd.example.k8svalidation;

import io.fabric8.generator.annotation.Required;
import io.fabric8.generator.annotation.ValidationRule;
import lombok.Data;

@Data
@ValidationRule(value = "self.minReplicas <= self.replicas && self.replicas <= self.maxReplicas", fieldPath = ".replicas")
public class K8sValidationSpec {
  @Required
  String namePrefix;
  @Required
  Integer replicas;
  @Required
  Integer minReplicas;
  @Required
  Integer maxReplicas;

  @Required
  @ValidationRule("self.startsWith('simple-')")
  private String simple;

  // see getter
  private String onGetter;

  @Required
  @ValidationRule("self.startsWith('start-')")
  @ValidationRule("self.endsWith('-end')")
  private String multiple;

  @Required
  @ValidationRule("self.startsWith('start-')")
  private String onAttributeAndGetter;

  @Required
  @ValidationRule(value = "self.valueL1 == self.deepLevel2.valueL2", messageExpression = "'valueL1 (' + self.valueL1 + ') must be equal to deepLevel2.valueL2 (' + self.deepLevel2.valueL2 + ')'")
  private DeepLevel1 deepLevel1;

  @Required
  @ValidationRule("self.dummy.startsWith('on-attr-')")
  private OnClass onAttributeAndClass;

  @Required
  private ClassWithValidationsFromAbstractClass onAbstractClass;

  // transition rules
  @ValidationRule(value = "self == oldSelf", message = "cannot be changed once set")
  private String immutable;
  @Required
  @ValidationRule(value = "!(self == 'high' && oldSelf == 'low') && !(self == 'low' && oldSelf == 'high')", message = "cannot transition directly between 'low' and 'high'")
  private Priority priority;
  @ValidationRule(value = "self >= oldSelf", message = "cannot decrease value once set", reason = "FieldValueForbidden")
  private Integer monotonicCounter;

  @Required
  @ValidationRule("self.startsWith('on-getter-')")
  public String getOnGetter() {
    return onGetter;
  }

  @ValidationRule("self.endsWith('-end')")
  public String getOnAttributeAndGetter() {
    return onAttributeAndGetter;
  }

  enum Priority {
    low,
    medium,
    high
  }

  @Data
  static class DeepLevel1 {
    @Required
    private String valueL1;

    @Required
    private DeepLevel2 deepLevel2;
  }

  @Data
  static class DeepLevel2 {
    @Required
    private String valueL2;

    @ValidationRule("self.startsWith('deep-')")
    private String simple;

  }

  @Data
  @ValidationRule("self.dummy.startsWith('on-class-')")
  static class OnClass {
    @Required
    private String dummy;
  }

  static class ClassWithValidationsFromAbstractClass extends AbstractBase {

  }

  @Data
  @ValidationRule("self.dummy.startsWith('abstract-')")
  static abstract class AbstractBase {
    @Required
    private String dummy;
  }
}
