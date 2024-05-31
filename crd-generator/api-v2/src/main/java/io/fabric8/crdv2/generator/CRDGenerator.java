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
package io.fabric8.crdv2.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.crdv2.generator.v1.CustomResourceHandler;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;

public class CRDGenerator {

  private static final Logger LOGGER = LoggerFactory.getLogger(CRDGenerator.class);
  private final Map<String, AbstractCustomResourceHandler> handlers = new HashMap<>(2);
  private CRDOutput<? extends OutputStream> output;
  private boolean parallel;
  private boolean implicitPreserveUnknownFields;
  private ObjectMapper objectMapper;
  private KubernetesSerialization kubernetesSerialization;
  private Map<String, CustomResourceInfo> infos;

  public CRDGenerator inOutputDir(File outputDir) {
    output = new DirCRDOutput(outputDir);
    return this;
  }

  public CRDGenerator withOutput(CRDOutput<? extends OutputStream> output) {
    this.output = output;
    return this;
  }

  public CRDGenerator withImplicitPreserveUnknownFields(boolean implicitPreserveUnknownFields) {
    this.implicitPreserveUnknownFields = implicitPreserveUnknownFields;
    return this;
  }

  public CRDGenerator withParallelGenerationEnabled(boolean parallel) {
    this.parallel = parallel;
    return this;
  }

  public CRDGenerator withObjectMapper(ObjectMapper mapper, KubernetesSerialization kubernetesSerialization) {
    this.objectMapper = mapper;
    this.kubernetesSerialization = kubernetesSerialization;
    return this;
  }

  public CRDGenerator forCRDVersions(List<String> versions) {
    return versions != null && !versions.isEmpty() ? forCRDVersions(versions.toArray(new String[0]))
        : this;
  }

  public CRDGenerator forCRDVersions(String... versions) {
    if (versions != null) {
      for (String version : versions) {
        if (version != null) {
          switch (version) {
            case CustomResourceHandler.VERSION:
              handlers.computeIfAbsent(CustomResourceHandler.VERSION,
                  s -> new CustomResourceHandler());
              break;
            default:
              LOGGER.warn("Ignoring unsupported CRD version: {}", version);
          }
        }
      }
    }
    return this;
  }

  Map<String, AbstractCustomResourceHandler> getHandlers() {
    return handlers;
  }

  // this is public API, so we cannot change the signature, so there is no way to prevent the possible heap pollution
  // (we also cannot use @SafeVarargs, because that requires the method to be final, which is another signature change)
  @SuppressWarnings("unchecked")
  public final CRDGenerator customResourceClasses(Class<? extends HasMetadata>... crClasses) {
    if (crClasses == null) {
      return this;
    }
    return customResourceClasses(Arrays.asList(crClasses));
  }

  public CRDGenerator customResourceClasses(Collection<Class<? extends HasMetadata>> crClasses) {
    if (crClasses == null) {
      return this;
    }
    return customResources(crClasses.stream()
        .filter(Objects::nonNull)
        .map(CustomResourceInfo::fromClass)
        .toArray(CustomResourceInfo[]::new));
  }

  public CRDGenerator customResources(Collection<CustomResourceInfo> infos) {
    if (infos == null) {
      return this;
    }
    return customResources(infos.toArray(new CustomResourceInfo[0]));
  }

  public CRDGenerator customResources(CustomResourceInfo... infos) {
    if (infos != null && infos.length > 0) {
      if (this.infos == null) {
        this.infos = new HashMap<>(infos.length);
      }
      Arrays.stream(infos)
          .filter(Objects::nonNull)
          // make sure we record all versions of the CR
          .forEach(info -> this.infos.put(getOutputName(info.crdName(), info.version()), info));
    }
    return this;
  }

  Set<CustomResourceInfo> getCustomResourceInfos() {
    return this.infos == null ? Collections.emptySet() : new HashSet<>(infos.values());
  }

  public int generate() {
    return detailedGenerate().numberOfGeneratedCRDs();
  }

  public CRDGenerationInfo detailedGenerate() {
    if (getCustomResourceInfos().isEmpty()) {
      LOGGER.warn("No resources were registered with the 'customResources' method to be generated");
      return CRDGenerationInfo.EMPTY;
    }

    if (output == null) {
      LOGGER.warn(
          "No output option was selected either using 'inOutputDir' or 'withOutput' methods. Skipping generation.");
      return CRDGenerationInfo.EMPTY;
    }

    // if no CRD version is specified, generate for all supported versions
    if (handlers.isEmpty()) {
      forCRDVersions(CustomResourceHandler.VERSION);
    }

    final ResolvingContext context;
    if (this.objectMapper == null) {
      context = ResolvingContext.defaultResolvingContext(implicitPreserveUnknownFields);
      this.kubernetesSerialization = context.kubernetesSerialization;
    } else {
      context = new ResolvingContext(this.objectMapper, this.kubernetesSerialization, implicitPreserveUnknownFields);
    }

    for (CustomResourceInfo info : infos.values()) {
      if (info != null) {
        if (LOGGER.isInfoEnabled()) {
          LOGGER.info("Generating '{}' version '{}' with {} (spec: {} / status {})...",
              info.crdName(), info.version(), info.crClassName(),
              info.specClassName().orElse("undetermined"),
              info.statusClassName().orElse("undetermined"));
        }

        if (parallel) {
          handlers.values().stream().map(h -> ForkJoinPool.commonPool().submit(() -> h.handle(info, context.forkContext())))
              .collect(Collectors.toList()).stream().forEach(ForkJoinTask::join);
        } else {
          handlers.values().stream().forEach(h -> h.handle(info, context.forkContext()));
        }
      }
    }

    final CRDGenerationInfo crdGenerationInfo = new CRDGenerationInfo();
    handlers.values().stream().flatMap(AbstractCustomResourceHandler::finish)
        .forEach(crd -> emitCrd(crd.getKey(), crd.getValue(), crdGenerationInfo));
    return crdGenerationInfo;
  }

  public void emitCrd(HasMetadata crd, Set<String> dependentClassNames, CRDGenerationInfo crdGenerationInfo) {
    final String version = ApiVersionUtil.trimVersion(crd.getApiVersion());
    final String crdName = crd.getMetadata().getName();
    try {
      final String outputName = getOutputName(crdName, version);
      try (final OutputStreamWriter writer = new OutputStreamWriter(output.outputFor(outputName), StandardCharsets.UTF_8)) {
        writer.write("# Generated by Fabric8 CRDGenerator, manual edits might get overwritten!\n");
        String yaml = kubernetesSerialization.asYaml(crd);
        // strip the explicit start added by default
        writer.write(yaml.substring(4));
        final URI fileURI = output.crdURI(outputName);
        crdGenerationInfo.add(crdName, version, fileURI, dependentClassNames);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static String getOutputName(String crdName, String crdSpecVersion) {
    return crdName + "-" + crdSpecVersion;
  }

  public interface CRDOutput<T extends OutputStream> extends Closeable {
    T outputFor(String crdName) throws IOException;

    default URI crdURI(String crdName) {
      return URI.create("file:///" + crdName);
    }
  }

  public abstract static class AbstractCRDOutput<T extends OutputStream> implements CRDOutput<T> {
    private final Map<String, T> crds = new HashMap<>();

    @Override
    public T outputFor(String crdName) throws IOException {
      final T outputStream = createStreamFor(crdName);
      crds.put(crdName, outputStream);
      return outputStream;
    }

    protected abstract T createStreamFor(String crdName) throws IOException;

    protected T getStreamFor(String crdName) {
      return crds.get(crdName);
    }

    @Override
    public void close() throws IOException {
      for (T stream : crds.values()) {
        stream.close();
      }
    }
  }

  static class DirCRDOutput extends AbstractCRDOutput<FileOutputStream> {
    private final File dir;

    public DirCRDOutput(File dir) {
      if (!dir.isDirectory() || !dir.canWrite() || !dir.exists()) {
        throw new IllegalArgumentException(dir + " must exist, be a writeable output directory");
      }
      this.dir = dir;
    }

    @Override
    protected FileOutputStream createStreamFor(String crdName) throws IOException {
      final File file = getCRDFile(crdName);
      return new FileOutputStream(file);
    }

    private File getCRDFile(String crdName) {
      return new File(dir, crdName + ".yml");
    }

    @Override
    public URI crdURI(String crdName) {
      return getCRDFile(crdName).toURI();
    }
  }
}
