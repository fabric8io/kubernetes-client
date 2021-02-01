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
package io.fabric8.crd.apt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
import io.fabric8.Resources;
import io.fabric8.crd.v1.CustomResourceHandler;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
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
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

@SupportedAnnotationTypes({"io.fabric8.kubernetes.model.annotation.Version"})
public class CustomResourceAnnotationProcessor extends AbstractProcessor {

  private static final ObjectMapper YAML_MAPPER = new ObjectMapper(
    new YAMLFactory()
      .enable(Feature.MINIMIZE_QUOTES)
      .enable(Feature.ALWAYS_QUOTE_NUMBERS_AS_STRINGS)
      .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
  ) {
    {
      configure(SerializationFeature.INDENT_OUTPUT, true);
      configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
      configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
    }
  };

  private static final String CUSTOM_RESOURCE_NAME = CustomResource.class.getCanonicalName();
  private final Resources resources = new Resources();
  private final CustomResourceHandler v1Handler = new CustomResourceHandler(resources);
  private final io.fabric8.crd.v1beta1.CustomResourceHandler v1beta1Handler = new io.fabric8.crd.v1beta1.CustomResourceHandler(
    resources);

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if (roundEnv.processingOver()) {
      // write files
      final KubernetesList list = resources.generate();
      list.getItems().forEach(crd -> {
        final String version = ApiVersionUtil.trimVersion(crd.getApiVersion());
        try {
          FileObject yml = processingEnv.getFiler()
            .createResource(StandardLocation.CLASS_OUTPUT, "",
              "META-INF/fabric8/" + crd.getMetadata().getName() + "-" + version + ".yml");
          try (Writer writer = yml.openWriter()) {
            final String yamlValue = YAML_MAPPER.writeValueAsString(crd);
            writer.write(yamlValue);
            writer.flush();
            System.out.println("Created " + yml.toUri());
          }
        } catch (IOException e) {
          throw new RuntimeException(e);
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
    final DeclaredType superclass = (DeclaredType) element.getSuperclass();
    final Name crClassName = element.getQualifiedName();
    if (superclass.asElement().toString().equals(CUSTOM_RESOURCE_NAME)) {
      final List<? extends TypeMirror> typeArguments = superclass.getTypeArguments();
      if (typeArguments.size() != 2) {
        System.out.println("Ignoring " + crClassName + " because it isn't parameterized");
        return null;
      }
      final TypeElement spec = ((TypeElement) ((DeclaredType) typeArguments.get(0)).asElement());
      final TypeElement status = ((TypeElement) ((DeclaredType) typeArguments.get(1)).asElement());
      final CustomResourceInfo info = new CustomResourceInfo(element, spec, status, processingEnv);
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
      v1Handler.handle(info, definition);
      v1beta1Handler.handle(info, definition);
      return info;
    } else {
      System.out.println(
        "Ignoring " + crClassName + " because it doesn't extend " + CUSTOM_RESOURCE_NAME);
      return null;
    }
  }

}
