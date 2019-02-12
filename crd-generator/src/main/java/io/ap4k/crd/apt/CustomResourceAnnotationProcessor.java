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
 * 
 **/
package io.ap4k.crd.apt;


import io.ap4k.crd.generator.CustomResourceGenerator;
import io.ap4k.processor.AbstractAnnotationProcessor;
import io.sundr.codegen.CodegenContext;

import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes({"io.ap4k.crd.annotation.CustomResource"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CustomResourceAnnotationProcessor extends AbstractAnnotationProcessor implements CustomResourceGenerator {

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if  (roundEnv.processingOver()) {
      session.close();
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
}
