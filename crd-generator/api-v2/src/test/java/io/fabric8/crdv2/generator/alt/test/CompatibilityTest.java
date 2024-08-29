package io.fabric8.crdv2.generator.alt.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import io.fabric8.crdv2.example.joke.JokeRequest;
import io.fabric8.crdv2.generator.CRDGenerator;
import io.fabric8.crdv2.generator.CRDGenerator.CRDOutput;
import io.fabric8.crdv2.generator.CustomResourceInfo;
import io.fabric8.crdv2.generator.alt.ConfigurableCrdGenerator;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceColumnDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.CustomResource;

public class CompatibilityTest {

  private static final YAMLMapper YAML_MAPPER = new YAMLMapper();

  private static CustomResourceDefinition standardGenerate(Class<? extends CustomResource<?, ?>> crdClass) throws IOException {
    Map<String, ByteArrayOutputStream> outputs = new HashMap<>();
    CRDGenerator generator = new CRDGenerator().withOutput(new CRDOutput<ByteArrayOutputStream>() {

      @Override
      public void close() throws IOException {
      }

      @Override
      public ByteArrayOutputStream outputFor(String crdName) throws IOException {
        return outputs.computeIfAbsent(crdName, key -> new ByteArrayOutputStream());
      }
    }).forCRDVersions("v1").customResources(CustomResourceInfo.fromClass(crdClass));

    Assertions.assertThat(generator.generate())
        .isEqualTo(outputs.size())
        .isEqualTo(1);

    ByteArrayOutputStream out = outputs.values().iterator().next();
    return YAML_MAPPER.readValue(out.toByteArray(), CustomResourceDefinition.class);
  }

  private static <SPEC, STATUS> CustomResourceDefinition generate(Class<? extends CustomResource<SPEC, STATUS>> crdClass) {
    return new ConfigurableCrdGenerator().generateCrd(crdClass);
  }

  @Test
  void compareToStandardGenerator() throws IOException {
    CustomResourceDefinition expected = standardGenerate(JokeRequest.class);
    CustomResourceDefinition actual = generate(JokeRequest.class);
    // drop shortNames and additionalPrinterColumns; shortNames is not set by ConfigurableCrdGenerator,
    // and additionalPrinterColumns is set using different annotation
    expected.getSpec().getNames().setShortNames(Collections.emptyList());
    expected.getSpec().getVersions().forEach(v -> v.setAdditionalPrinterColumns(Collections.emptyList()));
    Assertions.assertThat(actual)
        .usingRecursiveComparison()
        .ignoringFieldsOfTypes(CustomResourceColumnDefinition.class)
        .ignoringCollectionOrder()
        .isEqualTo(expected);
  }
}
