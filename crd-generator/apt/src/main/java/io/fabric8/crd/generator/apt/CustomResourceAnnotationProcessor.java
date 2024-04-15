/*
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

import io.fabric8.crd.generator.CRDGenerationInfo;
import io.fabric8.crd.generator.CRDGenerator;
import io.fabric8.crd.generator.CRDGenerator.AbstractCRDOutput;
import io.fabric8.crd.generator.CustomResourceInfo;
import io.fabric8.crd.generator.annotation.Annotations;
import io.fabric8.crd.generator.annotation.Labels;
import io.fabric8.crd.generator.utils.Types;
import io.fabric8.crd.generator.utils.Types.SpecAndStatus;
import io.fabric8.kubernetes.api.Pluralize;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.model.Scope;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.adapter.api.Adapters;
import io.sundr.adapter.apt.AptContext;
import io.sundr.model.TypeDef;
import io.sundr.model.repo.DefinitionRepository;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

@SupportedAnnotationTypes({ "io.fabric8.kubernetes.model.annotation.Version" })
public class CustomResourceAnnotationProcessor extends AbstractProcessor {

  /**
   * use CustomResourceAnnotationProcessorOptions.OPTION_PARALLEL instead
   */
  @Deprecated
  public static final String PROCESSOR_OPTION_PARALLEL = CustomResourceAnnotationProcessorOptions.OPTION_PARALLEL;

  private static final String SYSTEM_PROPERTY_DISABLED = "io.fabric8.crd.generator.disabled";

  private final CRDGenerator generator = new CRDGenerator();

  private boolean enabled = true;

  private CustomResourceAnnotationProcessorOptions options;

  @Override
  public SourceVersion getSupportedSourceVersion() {
    return SourceVersion.latestSupported();
  }

  @Override
  public Set<String> getSupportedOptions() {
    return CustomResourceAnnotationProcessorOptions.SUPPORTED_OPTIONS;
  }

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    super.init(processingEnv);
    if (Boolean.parseBoolean(System.getProperty(SYSTEM_PROPERTY_DISABLED))) {
      enabled = false;
      return;
    }
    options = CustomResourceAnnotationProcessorOptions.from(processingEnv);
    generator.withParallelGenerationEnabled(options.isParallelEnabled());
    generator.forCRDVersions(options.getVersions());
    generator.withHeader(options.getHeader());
  }

  @SuppressWarnings("unchecked")
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if (!enabled)
      return false;
    if (roundEnv.processingOver()) {
      final Messager messager = processingEnv.getMessager();
      if (options.hasUserProvidedOptions()) {
        messager.printMessage(Diagnostic.Kind.NOTE,
            String.format("Found processor options %s. Using %s", options.getOwnOptionsRaw(), options));
      }

      final CRDGenerator crdGenerator = generator
          .withOutput(new FileObjectCRDOutput(processingEnv, options.getOutputPath()));

      final CRDGenerationInfo allCRDs = crdGenerator
          .detailedGenerate();
      allCRDs.getCRDDetailsPerNameAndVersion().forEach((crdName, versionToInfo) -> {
        messager.printMessage(Diagnostic.Kind.NOTE, "Generating CRD " + crdName + ":\n");
        versionToInfo.forEach(
            (version, info) -> messager.printMessage(Diagnostic.Kind.NOTE, "  - " + version + " -> " + info.getFilePath()));
      });
      return true;
    }

    // make sure we create the context before using it
    AptContext.create(processingEnv.getElementUtils(), processingEnv.getTypeUtils(), DefinitionRepository.getRepository());

    //Collect all annotated types.
    for (TypeElement annotation : annotations) {
      for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
        if (element instanceof TypeElement) {
          try {
            // The annotation is loaded with reflection for compatibility with Java 8
            Class<Annotation> generatedAnnotation = (Class<Annotation>) Class.forName("javax.annotation.processing.Generated");
            if (element.getAnnotationsByType(generatedAnnotation).length > 0) {
              continue;
            }
          } catch (ClassNotFoundException e) {
            // ignore
          }
          generator.customResources(toCustomResourceInfo((TypeElement) element, options));
        }
      }
    }

    return false;
  }

  private CustomResourceInfo toCustomResourceInfo(TypeElement customResource,
      CustomResourceAnnotationProcessorOptions options) {
    TypeDef definition = Adapters.adaptType(customResource, AptContext.getContext());
    definition = Types.unshallow(definition);

    if (options.isDescribeDefinitionsEnabled()) {
      Types.output(definition);
    }
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
        .orElse(new String[] {});

    final String[] annotationsFromAnnotation = Optional
        .ofNullable(customResource.getAnnotation(Annotations.class))
        .map(Annotations::value)
        .orElse(new String[] {});

    final List<String> annotations = new LinkedList<>(Arrays.asList(annotationsFromAnnotation));
    annotations.addAll(options.getAnnotations());

    final String[] labelsFromAnnotation = Optional
        .ofNullable(customResource.getAnnotation(Labels.class))
        .map(Labels::value)
        .orElse(new String[] {});

    final List<String> labels = new LinkedList<>(Arrays.asList(labelsFromAnnotation));
    labels.addAll(options.getLabels());

    final boolean storage = customResource.getAnnotation(Version.class).storage();
    final boolean served = customResource.getAnnotation(Version.class).served();
    final boolean deprecated = customResource.getAnnotation(Version.class).deprecated();
    final String deprecationWarning = Optional.ofNullable(customResource.getAnnotation(Version.class).deprecationWarning())
        .filter(s -> deprecated)
        .filter(Utils::isNotNullOrEmpty)
        .orElse(null);

    final Scope scope = Types.isNamespaced(definition) ? Scope.NAMESPACED : Scope.CLUSTER;

    return new CustomResourceInfo(group, version, kind, singular, plural, shortNames, storage, served,
        deprecated, deprecationWarning,
        scope, definition, crClassName.toString(),
        specAndStatus.getSpecClassName(), specAndStatus.getStatusClassName(),
        annotations.toArray(new String[0]), labels.toArray(new String[0]));
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
    private final String outputLocation;

    public FileObjectCRDOutput(ProcessingEnvironment processingEnv, String outputLocation) {
      this.processingEnv = processingEnv;
      this.outputLocation = outputLocation;
    }

    @Override
    protected FileObjectOutputStream createStreamFor(String crdName) throws IOException {
      return new FileObjectOutputStream(
          processingEnv.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "",
              outputLocation + crdName + ".yml"));
    }

    @Override
    public URI crdURI(String crdName) {
      return getStreamFor(crdName).toUri();
    }
  }
}
