/**
 * Copyright 2018 The original authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.dekorate.crd.apt;

import io.dekorate.Resources;
import io.dekorate.crd.v1.CustomResourceHandler;
import io.dekorate.utils.Serialization;
import io.fabric8.kubernetes.client.CustomResource;
import io.sundr.codegen.CodegenContext;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.TypeDef;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

@SupportedAnnotationTypes({"io.fabric8.kubernetes.model.annotation.Version"})
public class CustomResourceAnnotationProcessor extends AbstractProcessor {

  private static final String CUSTOM_RESOURCE_NAME = CustomResource.class.getCanonicalName();
  private final Resources resources = new Resources();
  private final CustomResourceHandler handler = new CustomResourceHandler(resources);

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if (roundEnv.processingOver()) {
      // write files
      final var list = resources.generate();
      list.getItems().forEach(crd -> {
        try {
          FileObject yml = processingEnv.getFiler()
            .createResource(StandardLocation.CLASS_OUTPUT, "",
              "META-INF/dekorate/" + crd.getMetadata().getName() + ".yml");
          try (Writer writer = yml.openWriter()) {
            final String yamlValue = Serialization.asYaml(crd);
            writer.write(yamlValue);
            writer.flush();
            System.out.println("Created " + yml.toUri());
          }
        } catch (IOException e) {
          e.printStackTrace();
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
      add(type);
    }
    return false;
  }

  private CustomResourceInfo add(TypeElement element) {

    final var superclass = (DeclaredType) element.getSuperclass();
    final var crClassName = element.getQualifiedName();
    if (superclass.asElement().toString().equals(CUSTOM_RESOURCE_NAME)) {
      final List<? extends TypeMirror> typeArguments = superclass.getTypeArguments();
      if (typeArguments.size() != 2) {
        System.out.println("Ignoring " + crClassName + " because it isn't parameterized");
        return null;
      }
      var spec = ((TypeElement) ((DeclaredType) typeArguments.get(0)).asElement());
      var status = ((TypeElement) ((DeclaredType) typeArguments.get(1)).asElement());
      final var info = new CustomResourceInfo(element, spec, status, processingEnv);
      System.out.println(
        "Generating '"
          + info.crdName()
          + "' version '"
          + info.version()
          + "' with "
          + crClassName
          + " (spec: "
          + spec.getQualifiedName()
          + " / status: "
          + status.getQualifiedName()
          + ")");

      TypeDef definition = ElementTo.TYPEDEF.apply(element);
      handler.handle(info, definition);
      return info;
    } else {
      System.out.println(
        "Ignoring " + crClassName + " because it doesn't extend " + CUSTOM_RESOURCE_NAME);
      return null;
    }
  }

}
