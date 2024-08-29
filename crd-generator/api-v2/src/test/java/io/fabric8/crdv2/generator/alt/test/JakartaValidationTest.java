package io.fabric8.crdv2.generator.alt.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.github.victools.jsonschema.module.jakarta.validation.JakartaValidationModule;
import com.github.victools.jsonschema.module.jakarta.validation.JakartaValidationOption;

import io.fabric8.crdv2.generator.alt.ConfigurableCrdGenerator;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class JakartaValidationTest {

  public static final YAMLMapper YAML_MAPPER = new YAMLMapper();

  private ConfigurableCrdGenerator generator;

  public JakartaValidationTest() {
    generator = new ConfigurableCrdGenerator()
        .register(new JakartaValidationModule(
            JakartaValidationOption.INCLUDE_PATTERN_EXPRESSIONS,
            JakartaValidationOption.NOT_NULLABLE_FIELD_IS_REQUIRED,
            JakartaValidationOption.NOT_NULLABLE_METHOD_IS_REQUIRED));
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

    @JsonPropertyDescription("Non-empty string of alphabetical characters")
    @Pattern(regexp = "[A-Za-z]*")
    @NotEmpty
    @NotNull
    public String stringAlpha;

    @JsonPropertyDescription("Non-empty list of digits")
    @NotEmpty
    @Size(max = 10)
    public List<@Pattern(regexp = "[0-9]") String> stringDigit;

    @JsonPropertyDescription("Optional nested properties")
    public NestedProperties nestedProps;
  }

  public static class NestedProperties {

    public Boolean booleanValue;
    public Integer intValue;
    @Max(99)
    public Double floatValue;
    @Size(min = 3)
    public Map<String, String> map;
  }
}
