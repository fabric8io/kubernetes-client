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
package io.fabric8.crdv2.generator.v1;

import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface SchemaCustomizer {

  public interface Customizer {

    /**
     * Customizes the given {@link JSONSchemaProps}
     * 
     * @param props the {@link JSONSchemaProps} to customize
     * @param input the input String from the {@link SchemaCustomizer} annotation
     * @param kubernetesSerialization
     * @return the customized {@link JSONSchemaProps}
     */
    JSONSchemaProps apply(JSONSchemaProps props, String input, KubernetesSerialization kubernetesSerialization);

  }

  /**
   * Replace the incoming schema with the given the input of JSONSchemaProps in yaml or json,
   */
  public static class RawCustomizer implements Customizer {

    @Override
    public JSONSchemaProps apply(JSONSchemaProps props, String input, KubernetesSerialization kubernetesSerialization) {
      return kubernetesSerialization.unmarshal(input, JSONSchemaProps.class);
    }

  }

  /**
   * Patch the incoming schema with the given JSON merge patch input.
   */
  public static class MergePatchCustomizer implements Customizer {

    @Override
    public JSONSchemaProps apply(JSONSchemaProps props, String input, KubernetesSerialization kubernetesSerialization) {
      kubernetesSerialization.mergePatch(props, input);
      return props;
    }

  }

  Class<? extends Customizer> value();

  String input() default "";

}
