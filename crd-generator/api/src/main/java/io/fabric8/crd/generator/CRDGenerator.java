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
package io.fabric8.crd.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
import io.fabric8.crd.generator.v1.CustomResourceHandler;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.utils.ApiVersionUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class CRDGenerator {

  private final Resources resources;
  private final CustomResourceHandler v1Handler;
  private final io.fabric8.crd.generator.v1beta1.CustomResourceHandler v1beta1Handler;
  private CRDOutput output;
  private boolean hasResources;

  private static final ObjectMapper YAML_MAPPER = new ObjectMapper(
    new YAMLFactory()
      .enable(Feature.MINIMIZE_QUOTES)
      .enable(Feature.ALWAYS_QUOTE_NUMBERS_AS_STRINGS)
      .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
  );

  static {
    YAML_MAPPER.configure(SerializationFeature.INDENT_OUTPUT, true);
    YAML_MAPPER.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
    YAML_MAPPER.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
  }

  public CRDGenerator() {
    resources = new Resources();
    v1Handler = new CustomResourceHandler(resources);
    v1beta1Handler = new io.fabric8.crd.generator.v1beta1.CustomResourceHandler(resources);
  }

  public CRDGenerator inOutputDir(File outputDir) {
    output = new DirCRDOutput(outputDir);
    return this;
  }

  public CRDGenerator withOutput(CRDOutput output) {
    this.output = output;
    return this;
  }

  public CRDGenerator customResources(CustomResourceInfo... infos) {
    for (CustomResourceInfo info : infos) {
      if (info != null) {
        hasResources = true;
        System.out.println(
          "Generating '"
            + info.crdName()
            + "' version '"
            + info.version()
            + "' with "
            + info.crClassName()
            + " (spec: "
            + info.specClassName().orElse("undetermined")
            + " / status: "
            + info.statusClassName().orElse("undetermined")
            + ")");

        v1Handler.handle(info);
        v1beta1Handler.handle(info);
      }
    }
    return this;
  }

  public void generate() {
    if (hasResources) {
      if (output == null) {
        System.out.println("No output option was selected either using 'inOutputDir' or 'withOutput' methods. Skipping generation.");
      } else {
        final KubernetesList list = resources.generate();
        list.getItems().forEach(crd -> {
          final String version = ApiVersionUtil.trimVersion(crd.getApiVersion());
          try {
            try (final OutputStream outputStream = output.outputFor(crd.getMetadata().getName() + "-" + version + ".yml")){
              YAML_MAPPER.writeValue(outputStream, crd);
              System.out.println("Created " + output.crdURI());
            }
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        });
      }
    } else {
      System.out.println("No resources were registered with the 'customResources' method to be generated");
    }
  }

  public interface CRDOutput extends Closeable {
    OutputStream outputFor(String crdFileName) throws IOException;
    URI crdURI();
  }

  static class DirCRDOutput implements CRDOutput {
    private final File dir;
    private OutputStream output;
    private URI uri;

    public DirCRDOutput(File dir) {
      if (!dir.isDirectory() || !dir.canWrite() || !dir.exists()) {
        throw new IllegalArgumentException(dir + " must exist, be a writeable output directory");
      }
      this.dir = dir;
    }

    @Override
    public OutputStream outputFor(String crdFileName) throws IOException {
      final File file = new File(dir, crdFileName);
      uri = file.toURI();
      output = new FileOutputStream(file);
      return output;
    }

    @Override
    public URI crdURI() {
      return uri;
    }

    @Override
    public void close() throws IOException {
      output.close();
    }
  }
}
