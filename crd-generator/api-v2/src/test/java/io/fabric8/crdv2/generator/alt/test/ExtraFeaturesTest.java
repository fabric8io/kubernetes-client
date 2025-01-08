package io.fabric8.crdv2.generator.alt.test;

import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import io.fabric8.crdv2.generator.alt.AdditionalPrinterColumn;
import io.fabric8.crdv2.generator.alt.ConfigurableCrdGenerator;
import io.fabric8.crdv2.generator.alt.EnumDescriptionsModule;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

public class ExtraFeaturesTest {

  public static final YAMLMapper YAML_MAPPER = new YAMLMapper();

  private ConfigurableCrdGenerator generator;

  public ExtraFeaturesTest() {
    generator = new ConfigurableCrdGenerator()
        .register(new EnumDescriptionsModule());
  }

  @Test
  public void test() throws IOException {
    CustomResourceDefinition crd = generator.generateCrd(Resource.class);
    System.out.println(YAML_MAPPER.writeValueAsString(crd));
    Assertions.assertThat(crd.getSpec().getVersions()).hasSize(1).element(0)
        .satisfies(v -> {
          // check additionalPrinterColumns
          Assertions.assertThat(v.getAdditionalPrinterColumns()).allSatisfy(col -> {
            Assertions.assertThat(col)
                .hasFieldOrPropertyWithValue("jsonPath", ".status.state")
                .hasFieldOrPropertyWithValue("name", "State");
          });
        })
        .extracting("schema.openAPIV3Schema.properties.status.properties")
        .hasFieldOrPropertyWithValue("state.description", "The state of the resource\n"
            + "  * `Good` - Indicates the resource is good\n"
            + "  * `NotGood` - Indicates the resource is not good")
        .extracting("state.enum")
        .asInstanceOf(InstanceOfAssertFactories.list(TextNode.class))
        .map(v -> v.asText())
        .containsExactly("Good", "NotGood");
  }

  @Group("io.fabric8.test")
  @Version("v1alpha1")
  @AdditionalPrinterColumn(jsonPath = ".status.state", name = "State")
  public static class Resource extends CustomResource<Void, Status> {

    private static final long serialVersionUID = -9088417009209691746L;
  }

  public static class Status {

    @JsonPropertyDescription("The state of the resource")
    public State state;
  }

  public static enum State {

    @JsonPropertyDescription("Indicates the resource is good")
    @JsonProperty("Good")
    GOOD,
    @JsonPropertyDescription("Indicates the resource is not good")
    @JsonProperty("NotGood")
    NOT_GOOD
  }
}
