/**
 * Copyright 2018 The original authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.dekorate.crd.apt;


import java.util.Set;

import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import io.dekorate.config.AnnotationConfiguration;
import io.dekorate.crd.adapter.CustomResourceConfigAdapter;
import io.dekorate.crd.annotation.CustomResource;
import io.dekorate.crd.confg.Keys;
import io.dekorate.crd.config.CustomResourceConfig;
import io.dekorate.crd.config.CustomResourceConfigBuilder;
import io.dekorate.crd.configurator.AddClassNameConfigurator;
import io.dekorate.crd.generator.CustomResourceGenerator;
import io.dekorate.processor.AbstractAnnotationProcessor;
import io.sundr.codegen.CodegenContext;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.utils.ModelUtils;

@SupportedAnnotationTypes({"io.dekorate.crd.annotation.CustomResource"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CustomResourceAnnotationProcessor extends AbstractAnnotationProcessor implements CustomResourceGenerator {

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if (roundEnv.processingOver()) {
      getSession().close();
      return true;
    }
    CodegenContext.create(processingEnv.getElementUtils(), processingEnv.getTypeUtils());
    for (TypeElement typeElement : annotations) {
      for (Element mainClass : roundEnv.getElementsAnnotatedWith(typeElement)) {
        add(mainClass);
      }
    }
    return false;
  }

  @Override
  public void add(Element element) {
    CustomResource customResource = element.getAnnotation(CustomResource.class);
    if (element instanceof TypeElement) {
      TypeDef definition = ElementTo.TYPEDEF.apply((TypeElement) element);
      String className = ModelUtils.getClassName(element);

      on(customResource != null
        ? new AnnotationConfiguration<CustomResourceConfig>(CustomResourceConfigAdapter.newBuilder(customResource).addToAttributes(Keys.TYPE_DEFINITION, definition).accept(new AddClassNameConfigurator(className)))
        : new AnnotationConfiguration<CustomResourceConfig>(new CustomResourceConfigBuilder().addToAttributes(Keys.TYPE_DEFINITION, definition).accept(new AddClassNameConfigurator(className))));
    }
  }
}
