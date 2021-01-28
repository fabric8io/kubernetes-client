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
import io.dekorate.crd.annotation.Autodetect;
import io.dekorate.crd.annotation.Crd;
import io.dekorate.crd.config.CustomResourceConfig;
import io.dekorate.crd.config.CustomResourceConfigBuilder;
import io.dekorate.crd.config.Keys;
import io.dekorate.crd.config.Scope;
import io.dekorate.crd.handler.CustomResourceHandler;
import io.dekorate.crd.util.Types;
import io.dekorate.utils.Serialization;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.codegen.CodegenContext;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.utils.ModelUtils;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;

@SupportedAnnotationTypes({
  "io.fabric8.kubernetes.model.annotation.Group",
  "io.fabric8.kubernetes.model.annotation.Version"})
public class CustomResourceAnnotationProcessor extends AbstractProcessor {

  private final Resources resources = new Resources();

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if (roundEnv.processingOver()) {
      // write files
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


  public static <T> T firstOf(Optional<T>... optionals) {
    return Arrays.stream(optionals).filter(Optional::isPresent).map(Optional::get).findFirst()
      .orElse(null);
  }

  public void add(Element element) {
    System.out.println("Generating " + element.getSimpleName());
    Optional<Crd> crd = Optional.ofNullable(element.getAnnotation(Crd.class));
    Optional<Group> group = Optional.ofNullable(element.getAnnotation(Group.class));
    Optional<Version> version = Optional.ofNullable(element.getAnnotation(Version.class));
    Optional<Kind> kind = Optional.ofNullable(element.getAnnotation(Kind.class));
    Optional<Plural> plural = Optional.ofNullable(element.getAnnotation(Plural.class));
    Optional<Singular> singular = Optional.ofNullable(element.getAnnotation(Singular.class));

    String statusClassName;
    try {
      statusClassName = crd.map(Crd::status).map(Class::getCanonicalName)
        .orElse(Autodetect.class.getCanonicalName());
    } catch (MirroredTypeException e) {
      statusClassName = e.getTypeMirror().toString();
    }

    if (element instanceof TypeElement) {
      TypeDef definition = ElementTo.TYPEDEF.apply((TypeElement) element);
      String className = ModelUtils.getClassName(element);

      CustomResourceConfig config = new CustomResourceConfigBuilder()
        .withKind(firstOf(kind.map(Kind::value), crd.map(Crd::kind)))
        .withGroup(firstOf(group.map(Group::value), crd.map(Crd::group)))
        .withVersion(firstOf(version.map(Version::value), crd.map(Crd::version)))
        .withPlural(firstOf(plural.map(Plural::value), crd.map(Crd::plural)))
        .withName(firstOf(singular.map(Singular::value), crd.map(Crd::name)))
        .withScope(firstOf(crd.map(Crd::scope),
          Optional.of(Types.isNamespaced(definition) ? Scope.Namespaced : Scope.Cluster)))
        .withServed(firstOf(crd.map(Crd::served), Optional.of(true)))
        .withStorage(firstOf(crd.map(Crd::storage), Optional.of(false)))
        .withStatusClassName(statusClassName)
        .withNewScale()
        .endScale()
//        .accept(new AddClassNameConfigurator(className))
        .addToAttributes(Keys.TYPE_DEFINITION, definition).build();

      final var resources = new CustomResourceHandler(this.resources).handle(config);
      System.out.println(Serialization.asYaml(resources.get("kubernetes")));
    }
  }


}
