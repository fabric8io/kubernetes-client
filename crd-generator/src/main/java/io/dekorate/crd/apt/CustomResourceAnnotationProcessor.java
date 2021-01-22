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

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;

import io.dekorate.config.MultiConfiguration;
import io.dekorate.crd.adapter.CustomResourceConfigAdapter;
import io.dekorate.crd.annotation.Crd;
import io.dekorate.crd.config.Keys;
import io.dekorate.crd.config.Scope;
import io.dekorate.crd.config.CustomResourceConfig;
import io.dekorate.crd.config.CustomResourceConfigBuilder;
import io.dekorate.crd.configurator.AddClassNameConfigurator;
import io.dekorate.crd.generator.CustomResourceGenerator;
import io.dekorate.crd.util.Types;
import io.dekorate.processor.AbstractAnnotationProcessor;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.sundr.codegen.CodegenContext;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.utils.ModelUtils;
import io.sundr.codegen.utils.TypeUtils;

@SupportedAnnotationTypes({
    "io.fabric8.kubernetes.model.annotation.Group",
    "io.fabric8.kubernetes.model.annotation.Version",
    "io.fabric8.kubernetes.model.annotation.Kind",
    "io.fabric8.kubernetes.model.annotation.Plural",
    "io.fabric8.kubernetes.model.annotation.Singular",
    "io.dekorate.crd.annotation.Crd"})
public class CustomResourceAnnotationProcessor extends AbstractAnnotationProcessor implements CustomResourceGenerator {

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if (roundEnv.processingOver()) {
      getSession().close();
      return true;
    }

    CodegenContext.create(processingEnv.getElementUtils(), processingEnv.getTypeUtils());
    Set<TypeElement> annotatedTypes = new LinkedHashSet<>();

    //Collect all annotated types.
    for (TypeElement annotation : annotations) {
      for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
        if (element instanceof TypeElement)
          annotatedTypes.add((TypeElement) element);
      }
    }

    //Add annotated types
    for (TypeElement type : annotatedTypes) {
      add(type);
    }
    return false;
  }


  public static <T> T firstOf(Optional<T>... optionals) {
    return Arrays.stream(optionals).filter(Optional::isPresent).map(Optional::get).findFirst().orElse(null);
  }

  @Override
  public void add(Element element) {
    Optional<Crd> crd = Optional.ofNullable(element.getAnnotation(Crd.class));
    Optional<Group> group = Optional.ofNullable(element.getAnnotation(Group.class));
    Optional<Version> version = Optional.ofNullable(element.getAnnotation(Version.class));
    Optional<Kind> kind = Optional.ofNullable(element.getAnnotation(Kind.class));
    Optional<Plural> plural = Optional.ofNullable(element.getAnnotation(Plural.class));
    Optional<Singular> singular = Optional.ofNullable(element.getAnnotation(Singular.class));

    String statusClassName = null;
      try {
        statusClassName = crd.map(Crd::status).map(Class::getCanonicalName).get();
      } catch (MirroredTypeException e) {
        statusClassName = e.getTypeMirror().toString();
      } catch (Exception e) {
        // ignore
      }
 

    if (element instanceof TypeElement) {
      TypeDef definition = ElementTo.TYPEDEF.apply((TypeElement) element);
      String className = ModelUtils.getClassName(element);

      CustomResourceConfigBuilder builder = new CustomResourceConfigBuilder()
        .withKind(firstOf(kind.map(Kind::value), crd.map(Crd::kind)))
        .withGroup(firstOf(group.map(Group::value), crd.map(Crd::group)))
        .withVersion(firstOf(version.map(Version::value), crd.map(Crd::version)))
        .withPlural(firstOf(plural.map(Plural::value), crd.map(Crd::plural)))
        .withName(firstOf(singular.map(Singular::value), crd.map(Crd::name)))
        .withScope(firstOf(crd.map(Crd::scope), Optional.of(Types.isNamespaced(definition) ? Scope.Namespaced : Scope.Cluster)))
        .withServed(firstOf(crd.map(Crd::served), Optional.of(true)))
        .withStorage(firstOf(crd.map(Crd::storage), Optional.of(false)))
        .withStatusClassName(statusClassName)
        .withNewScale()
        .endScale()
        .accept(new AddClassNameConfigurator(className))
        .addToAttributes(Keys.TYPE_DEFINITION, definition);

      on(new MultiConfiguration<CustomResourceConfig>(builder));
    }
  }


}
