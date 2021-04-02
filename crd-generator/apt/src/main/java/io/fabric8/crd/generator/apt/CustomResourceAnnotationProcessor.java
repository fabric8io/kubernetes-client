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
import io.sundr.builder.TypedVisitor;
import io.sundr.codegen.CodegenContext;
import io.sundr.codegen.Constants;
import io.sundr.codegen.functions.ClassTo;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.ClassRef;
import io.sundr.codegen.model.ClassRefBuilder;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeDefBuilder;
import io.sundr.codegen.model.TypeParamDef;
import io.sundr.codegen.model.TypeParamRef;
import io.sundr.codegen.model.TypeRef;
import io.sundr.codegen.utils.TypeUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

@SupportedAnnotationTypes({"io.fabric8.kubernetes.model.annotation.Version"})
public class CustomResourceAnnotationProcessor extends AbstractProcessor {

  private static final TypeDef CUSTOM_RESOURCE_DEF = ClassTo.TYPEDEF.apply(CustomResource.class);
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

  /**
   * Gets the definition of the {@link ClassRef} but projects type arguments to the definiton.
   */
  public TypeDef projectDefinition(ClassRef ref) {
    List<TypeRef> arguments = ref.getArguments();
    TypeDef definition = ref.getDefinition();
    if (arguments.isEmpty()) {
      return definition;
    }

    Map<String, TypeRef> genericMap = new HashMap<>();
    for (int i=0; i < arguments.size(); i++) {
      String name = definition.getParameters().get(i).getName();
      TypeRef typeRef = ref.getArguments().get(i);
      genericMap.put(name, typeRef);
    }

    definition.getParameters().stream().collect(Collectors.toMap(TypeParamDef::getName, TypeParamDef::getBounds));
    return new TypeDefBuilder(definition)
      .accept(new TypedVisitor<ClassRefBuilder>() {
          @Override
          public void visit(ClassRefBuilder c) {
            List<TypeRef> arguments = new ArrayList<>();
            for (TypeRef arg : c.buildArguments()) {
              TypeRef mappedRef = arg;
              if (arg instanceof TypeParamRef) {
                TypeParamRef typeParamRef = (TypeParamRef) arg;
                TypeRef mapping = genericMap.get(typeParamRef.getName());
                if (mapping != null) {
                  mappedRef = mapping;
                }
              }
              arguments.add(mappedRef);
            }
            c.withArguments(arguments);
          }
        }).build();
  }

  private static final String CUSTOM_RESOURCE_NAME = CustomResource.class.getCanonicalName();
  private CustomResourceInfo toCustomResourceInfo(TypeElement customResource) {
    final TypeDef definition = ElementTo.TYPEDEF.apply(customResource);
    final Name crClassName = customResource.getQualifiedName();

    TypeRef specType = null;
    String specClassName = null;
    String statusClassName = null;
    TypeRef statusType = null;
    boolean unreliable = true;


    Set<ClassRef> superClasses = definition.getExtendsList().stream().flatMap(s -> Stream.concat(Stream.of(s), projectDefinition(s).getExtendsList().stream()))
                                                                              .collect(Collectors.toSet());

    Optional<ClassRef> optionalCustomResourceRef = superClasses.stream().filter(s -> s.getFullyQualifiedName().equals(CUSTOM_RESOURCE_NAME)).findFirst();
    if (optionalCustomResourceRef.isPresent()) {
      ClassRef customResourceRef = optionalCustomResourceRef.get();
      if (customResourceRef.getArguments().size() == 2) {
        unreliable = false;
        specType = customResourceRef.getArguments().get(0);
        specClassName = specType instanceof ClassRef ? ((ClassRef)specType).getFullyQualifiedName() : null;
        statusType = customResourceRef.getArguments().get(1);
        statusClassName = statusType instanceof ClassRef ? ((ClassRef)statusType).getFullyQualifiedName() : null;
      }
    }

    if (unreliable) {
      System.out.println("Cannot reliably determine status types for  " + crClassName
        + " because it isn't parameterized with only spec and status types. Status replicas detection will be deactivated.");
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

    //TypeUtils.unrollHierarchy only return the classes, so we will use nested streaming to also get the interfaces
    final Scope scope = TypeUtils.unrollHierarchy(definition).stream()
      .flatMap(s -> Stream.concat(Stream.of(s), s.getImplementsList().stream().flatMap(i -> TypeUtils.unrollHierarchy(i.getDefinition()).stream())))
      .filter(d -> d.getFullyQualifiedName().equals(Namespaced.class.getName()))
      .map(d -> Scope.NAMESPACED)
      .findAny()
      .orElse(Scope.CLUSTER);

    return new CustomResourceInfo(group, version, kind, singular, plural, shortNames, storage, served, scope, definition, crClassName.toString(),
      specClassName, statusClassName);
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

  private static Optional<ClassRef> getCustomResourceRef(TypeDef typeDef) {
    return superClassStream(typeDef)
      .filter(s -> s.getDefinition().getFullyQualifiedName().equals(CustomResource.class.getName()))
      .findFirst();
  }

  private static Optional<ClassRef> getCustomResourceSpec(Optional<ClassRef> customResourceRef) {
    return getCustomResourceTypeParam(customResourceRef, 0);
  }

  private static Optional<ClassRef> getCustomResourceStatus(Optional<ClassRef> customResourceRef) {
    return getCustomResourceTypeParam(customResourceRef, 1);
  }

  private static Optional<ClassRef> getCustomResourceTypeParam(Optional<ClassRef> customResourceRef,
    int parameterIndex) {
    return customResourceRef
      .filter(c -> c.getArguments() != null && c.getArguments().size() == 2)
      .map(c -> c.getArguments().get(parameterIndex))
      .filter(t -> t instanceof ClassRef)
      .map(t -> (ClassRef) t);
  }

  public static Stream<ClassRef> superClassStream(TypeDef typeDef) {
    if (Constants.OBJECT.equals(typeDef)) {
      return Stream.empty();
    }
    return typeDef.getExtendsList().stream().flatMap(s -> superClassStream(s.getDefinition()));
  }
}

