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
import io.fabric8.crd.generator.CRDGenerator.AbstractCRDOutput;
import io.fabric8.crd.generator.CustomResourceInfo;
import io.fabric8.crd.generator.utils.Types;
import io.fabric8.crd.generator.utils.Types.SpecAndStatus;
import io.fabric8.kubernetes.api.Pluralize;
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
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

@SupportedAnnotationTypes({"io.fabric8.kubernetes.model.annotation.Version"})
public class CustomResourceAnnotationProcessor extends AbstractProcessor {
  
  private final CRDGenerator generator = new CRDGenerator();

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if (roundEnv.processingOver()) {
      generator.withOutput(new FileObjectCRDOutput(processingEnv)).generate();
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
  
  private CustomResourceInfo toCustomResourceInfo(TypeElement customResource) {
    final TypeDef definition = ElementTo.TYPEDEF.apply(customResource);
    final Name crClassName = customResource.getQualifiedName();

    SpecAndStatus specAndStatus = Types.resolveSpecAndStatusTypes(definition);
    if (specAndStatus.isUnreliable()) {
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
    
    final Scope scope = Types.isNamespaced(definition) ? Scope.NAMESPACED : Scope.CLUSTER;

    return new CustomResourceInfo(group, version, kind, singular, plural, shortNames, storage, served, scope, definition, crClassName.toString(),
      specAndStatus.getSpecClassName(), specAndStatus.getStatusClassName());
  }

  private static class FileObjectOutputStream extends OutputStream {

    private final FileObject yml;
    private final OutputStream out;

    public FileObjectOutputStream(FileObject yml) throws IOException {
      this.yml = yml;
      this.out = yml.openOutputStream();
    }

    @Override
    public void write(byte[] b) throws IOException {
      out.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
      out.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
      out.flush();
    }

    @Override
    public void close() throws IOException {
      out.close();
    }

    @Override
    public void write(int b) throws IOException {
      out.write(b);
    }

    public URI toUri() {
      return yml.toUri();
    }
  }

  private static class FileObjectCRDOutput extends AbstractCRDOutput<FileObjectOutputStream> {

    private final ProcessingEnvironment processingEnv;

    public FileObjectCRDOutput(ProcessingEnvironment processingEnv) {
      this.processingEnv = processingEnv;
    }

    @Override
    protected FileObjectOutputStream createStreamFor(String crdName) throws IOException {
      return new FileObjectOutputStream(
        processingEnv.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "",
          "META-INF/fabric8/" + crdName + ".yml"));
    }

    @Override
    public URI crdURI(String crdName) {
      return getStreamFor(crdName).toUri();
    }
  }
}

