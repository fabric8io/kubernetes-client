package io.fabric8.crdv2.generator.alt.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.github.victools.jsonschema.module.swagger2.Swagger2Module;

import io.fabric8.crdv2.generator.alt.ConfigurableCrdGenerator;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

public class SwaggerTest {

  public static final YAMLMapper YAML_MAPPER = new YAMLMapper();

  private ConfigurableCrdGenerator generator;

  public SwaggerTest() {
    generator = new ConfigurableCrdGenerator()
        .register(new Swagger2Module());
  }

  @Test
  public void test() throws IOException {
    CustomResourceDefinition crd = generator.generateCrd(Resource.class);
    System.out.println(YAML_MAPPER.writeValueAsString(crd));
    Assertions.assertThat(crd.getSpec().getVersions()).hasSize(1).element(0)
        .satisfies(v -> {
          // check required properties
          Assertions.assertThat(v)
              .extracting("schema.openAPIV3Schema.properties.spec.required")
              .asInstanceOf(InstanceOfAssertFactories.list(String.class))
              .containsExactlyInAnyOrder("stringAlpha", "stringDigit");
        })
        .extracting("schema.openAPIV3Schema.properties.spec.properties")
        .hasFieldOrPropertyWithValue("stringAlpha.description", "Non-empty string of alphabetical characters")
        .hasFieldOrPropertyWithValue("stringAlpha.minLength", 1L)
        .hasFieldOrPropertyWithValue("stringAlpha.pattern", "[A-Za-z]*")
        .hasFieldOrPropertyWithValue("stringAlpha.type", "string")
        .hasFieldOrPropertyWithValue("stringDigit.description", "Non-empty list of digits")
        .hasFieldOrPropertyWithValue("stringDigit.minItems", 1L)
        .hasFieldOrPropertyWithValue("stringDigit.maxItems", 10L)
        .hasFieldOrPropertyWithValue("stringDigit.type", "array")
        .hasFieldOrPropertyWithValue("stringDigit.items.schema.pattern", "[0-9]")
        .hasFieldOrPropertyWithValue("stringDigit.items.schema.type", "string")
        .hasFieldOrPropertyWithValue("nestedProps.description", "Optional nested properties")
        .hasFieldOrPropertyWithValue("nestedProps.properties.floatValue.maximum", 99.0)
        .hasFieldOrPropertyWithValue("nestedProps.properties.floatValue.type", "number")
        .hasFieldOrPropertyWithValue("nestedProps.properties.map.minProperties", 3L)
        .hasFieldOrPropertyWithValue("nestedProps.properties.map.additionalProperties.schema.type", "string")
        .hasFieldOrPropertyWithValue("nestedProps.properties.map.type", "object")
        .hasFieldOrPropertyWithValue("nestedProps.type", "object");
  }

  @Group("io.fabric8.test")
  @Version("v1alpha1")
  public static class Resource extends CustomResource<Spec, Void> {

    private static final long serialVersionUID = -9088417009209691746L;
  }

  public static class Spec {

    @Schema(description = "Non-empty string of alphabetical characters", pattern = "[A-Za-z]*", minLength = 1, requiredMode = RequiredMode.REQUIRED)
    public String stringAlpha;

    @Schema(description = "Non-empty list of digits", requiredMode = RequiredMode.REQUIRED)
    @ArraySchema(schema = @Schema(pattern = "[0-9]"), minItems = 1, maxItems = 10)
    public List<String> stringDigit;

    @Schema(description = "Optional nested properties")
    public NestedProperties nestedProps;
  }

  public static class NestedProperties {

    public Boolean booleanValue;
    public Integer intValue;
    @Schema(maximum = "99.0")
    public Double floatValue;
    @Schema(minProperties = 3)
    public Map<String, String> map;
  }
}
