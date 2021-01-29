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
import io.dekorate.crd.config.CustomResourceConfig;
import io.dekorate.crd.config.CustomResourceConfigBuilder;
import io.dekorate.crd.config.Keys;
import io.dekorate.crd.config.Scope;
import io.dekorate.crd.handler.CustomResourceHandler;
import io.dekorate.utils.Serialization;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.utils.Pluralize;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.codegen.CodegenContext;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.TypeDef;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

@SupportedAnnotationTypes({
  "io.fabric8.kubernetes.model.annotation.Group",
  "io.fabric8.kubernetes.model.annotation.Version"})
public class CustomResourceAnnotationProcessor extends AbstractProcessor {

  private static final String CUSTOM_RESOURCE_NAME = CustomResource.class.getCanonicalName();
  private final Resources resources = new Resources();

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if (roundEnv.processingOver()) {
      // write files
      resources.generate().forEach( (k, v) -> {
          try {
            FileObject yml = processingEnv.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "", "META-INF/dekorate/" + k + ".yml");
            try (Writer writer = yml.openWriter()) {
              final String yamlValue = Serialization.asYaml(v);
              writer.write(yamlValue);
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


  public static <T> T firstOf(Optional<T>... optionals) {
    return Arrays.stream(optionals).filter(Optional::isPresent).map(Optional::get).findFirst()
      .orElse(null);
  }

  private CRInfo add(TypeElement element) {

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
      final var info = new CRInfo(element, spec, status, processingEnv);
      System.out.println(
        "Generating '"
          + info.crdName()
          + "' version '"
          + info.version
          + "' with "
          + crClassName
          + " (spec: "
          + spec.getQualifiedName()
          + " / status: "
          + status.getQualifiedName()
          + ")");

      TypeDef definition = ElementTo.TYPEDEF.apply(element);
      CustomResourceConfig config = new CustomResourceConfigBuilder()
        .withKind(info.kind())
        .withGroup(info.group)
        .withVersion(info.version)
        .withPlural(info.plural())
        .withName(info.crdName())
        .withScope(info.scope())
        .withServed(info.served())
        .withStorage(info.storage())
        .withStatusClassName(info.status.getQualifiedName().toString())
        .withNewScale()
        .endScale()
        .addToAttributes(Keys.TYPE_DEFINITION, definition).build();

      final var resources = new CustomResourceHandler(this.resources).handle(config);
      System.out.println(Serialization.asYaml(resources.get("kubernetes")));
      return info;
    } else {
      System.out.println(
        "Ignoring " + crClassName + " because it doesn't extend " + CUSTOM_RESOURCE_NAME);
      return null;
    }
  }

  private static class CRInfo {

    private final TypeElement customResource;
    private final TypeElement spec;
    private final TypeElement status;
    private final String group;
    private final String version;
    private final ProcessingEnvironment env;

    public CRInfo(
      TypeElement customResource,
      TypeElement spec,
      TypeElement status,
      ProcessingEnvironment env) {
      this.customResource = customResource;
      this.spec = spec;
      this.status = status;
      this.group = customResource.getAnnotation(Group.class).value();
      this.version = customResource.getAnnotation(Version.class).value();
      this.env = env;
    }


    private boolean storage() {
      return customResource.getAnnotation(Version.class).storage();
    }

    private boolean served() {
      return customResource.getAnnotation(Version.class).served();
    }

    private String key() {
      return crdName();
    }

    private Scope scope() {
      return customResource.getInterfaces().stream()
        .filter(t -> t.toString().equals(Namespaced.class.getTypeName()))
        .map(t -> Scope.Namespaced).findFirst().orElse(Scope.Cluster);
    }

    private String crdName() {
      return plural() + "." + group;
    }

    private String[] shortNames() {
      return Optional.ofNullable(customResource.getAnnotation(ShortNames.class))
        .map(ShortNames::value)
        .orElse(new String[]{});
    }

    private String singular() {
      return Optional.ofNullable(customResource.getAnnotation(Singular.class))
        .map(Singular::value)
        .orElse(kind().toLowerCase(Locale.ROOT));
    }

    private String plural() {
      return Optional.ofNullable(customResource.getAnnotation(Plural.class))
        .map(Plural::value)
        .map(s -> s.toLowerCase(Locale.ROOT))
        .orElse(Pluralize.toPlural(singular()));
    }

    private String kind() {
      return Optional.ofNullable(customResource.getAnnotation(Kind.class))
        .map(Kind::value)
        .orElse(customResource.getSimpleName().toString());
    }

    private boolean deprecated() {
      return env.getElementUtils().isDeprecated(customResource);
    }
  }
}
