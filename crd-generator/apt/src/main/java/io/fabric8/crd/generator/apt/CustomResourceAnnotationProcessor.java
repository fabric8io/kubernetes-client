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
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.utils.Pluralize;
import io.fabric8.kubernetes.model.Scope;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.codegen.CodegenContext;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeRef;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
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

  final CRDGenerator generator = new CRDGenerator();

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if (roundEnv.processingOver()) {
      generator.withOutput(new FileObjectCRDOutput()).generate();
      return true;
    }

    CodegenContext.create(processingEnv.getElementUtils(), processingEnv.getTypeUtils());

    //Collect all annotated types.
    for (TypeElement annotation : annotations) {
      for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
        if (element instanceof TypeElement) {
          generator.customResources(toCustomResourceInfo((TypeElement) element));
        }
      }
    }

    return false;
  }

  private static final String CUSTOM_RESOURCE_NAME = CustomResource.class.getCanonicalName();
  private CustomResourceInfo toCustomResourceInfo(TypeElement customResource) {
    final DeclaredType superclass = (DeclaredType) customResource.getSuperclass();
    final Name crClassName = customResource.getQualifiedName();
    if (superclass.asElement().toString().equals(CUSTOM_RESOURCE_NAME)) {
      final List<? extends TypeMirror> typeArguments = superclass.getTypeArguments();
      if (typeArguments.size() != 2) {
        System.out.println("Ignoring " + crClassName + " because it isn't parameterized");
        return null;
      }
      final TypeElement spec = ((TypeElement) ((DeclaredType) typeArguments.get(0)).asElement());
      final TypeElement status = ((TypeElement) ((DeclaredType) typeArguments.get(1)).asElement());
      Optional<TypeRef> statusType = Optional.empty();
      if (!status.getQualifiedName().contentEquals(Void.class.getCanonicalName())) {
        statusType = Optional.of(ElementTo.TYPEDEF.apply(status).toReference());
      }

      final String group = customResource.getAnnotation(Group.class).value();
      final String version = customResource.getAnnotation(Version.class).value();

      final String kind = Optional.ofNullable(customResource.getAnnotation(Kind.class))
        .map(Kind::value)
        .orElse(customResource.getSimpleName().toString());

      final String singular = Optional.ofNullable(customResource.getAnnotation(Singular.class))
        .map(Singular::value)
        .orElse(kind.toLowerCase(Locale.ROOT));

      final String plural = Optional.ofNullable(customResource.getAnnotation(Plural.class))
        .map(Plural::value)
        .map(s -> s.toLowerCase(Locale.ROOT))
        .orElse(Pluralize.toPlural(singular));

      final String[] shortNames = Optional
        .ofNullable(customResource.getAnnotation(ShortNames.class))
        .map(ShortNames::value)
        .orElse(new String[]{});

      final boolean storage = customResource.getAnnotation(Version.class).storage();
      final boolean served = customResource.getAnnotation(Version.class).served();

      final Scope scope = customResource.getInterfaces().stream()
        .filter(t -> t.toString().equals(Namespaced.class.getTypeName()))
        .map(t -> Scope.NAMESPACED).findFirst().orElse(Scope.CLUSTER);

      final TypeDef definition = ElementTo.TYPEDEF.apply(customResource);

      return new CustomResourceInfo(group, version, kind, singular, plural, shortNames, storage,
        served, scope, statusType, definition, crClassName.toString(),
        spec.getQualifiedName().toString(), status.getQualifiedName().toString());
    } else {
      System.out.println(
        "Ignoring " + crClassName + " because it doesn't extend " + CUSTOM_RESOURCE_NAME);
      return null;
    }
  }

  private class FileObjectCRDOutput implements CRDOutput {

    private FileObject yml;
    private OutputStream out;

    @Override
    public OutputStream outputFor(String crdFileName) throws IOException {
      yml = processingEnv.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "",
        "META-INF/fabric8/" + crdFileName);
      out = yml.openOutputStream();
      return out;
    }

    @Override
    public URI crdURI() {
      return yml.toUri();
    }

    @Override
    public void close() throws IOException {
      out.close();
    }
  }
}
