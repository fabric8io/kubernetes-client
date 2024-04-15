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
package io.fabric8.crd.generator.apt.options;

import io.fabric8.crd.generator.apt.AbstractCRDGeneratorCompilerTest;

public class AnnotationsTest extends AbstractCRDGeneratorCompilerTest {
  @Override
  protected String[] getJavaSources() {
    return new String[] {
        "Option.java"
    };
  }

  @Override
  protected String[] getExpectedCRDs() {
    return new String[] {
        "options.samples.fabric8.io-v1.yml",
        "options.samples.fabric8.io-v1beta1.yml"
    };
  }

  @Override
  protected String[] additionalCompilerOptions() {
    return new String[] {
        "-Aio.fabric8.crd.generator.annotations=my-annotation1=my-value1,my-annotation2=my-value2"
    };
  }
}
