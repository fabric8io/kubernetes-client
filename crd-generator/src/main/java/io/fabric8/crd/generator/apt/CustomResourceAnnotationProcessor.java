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
package io.fabric8.crd.generator.apt;

import io.fabric8.crd.generator.CRDGenerator;
import io.fabric8.crd.generator.CRDGenerator.CRDOutput;
import io.fabric8.crd.generator.CustomResourceInfo;
import io.sundr.codegen.CodegenContext;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

@SupportedAnnotationTypes({"io.fabric8.kubernetes.model.annotation.Version"})
public class CustomResourceAnnotationProcessor extends AbstractProcessor {

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if (roundEnv.processingOver()) {

      CRDGenerator.generateAt(new CRDOutput() {
        private FileObject yml;
        @Override
        public OutputStream outputFor(String crdFileName) throws IOException {
          yml = processingEnv.getFiler()
            .createResource(StandardLocation.CLASS_OUTPUT, "",
              "META-INF/fabric8/" + crdFileName);
          return yml.openOutputStream();
        }

        @Override
        public URI crdURI() {
          return yml.toUri();
        }
      });
      return true;
    }

    CodegenContext.create(processingEnv.getElementUtils(), processingEnv.getTypeUtils());
    Set<TypeElement> annotatedTypes = new LinkedHashSet<>();

    //Collect all annotated types.
    for (TypeElement annotation : annotations) {
      for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
        if (element instanceof TypeElement) {
          annotatedTypes.add((TypeElement) element);
        }
      }
    }

    //Add annotated types
    for (TypeElement type : annotatedTypes) {
      CustomResourceInfo info = CustomResourceInfo.fromTypeElement(type);
      if (info != null) {
        CRDGenerator.add(info);
      }
    }
    return false;
  }
}
