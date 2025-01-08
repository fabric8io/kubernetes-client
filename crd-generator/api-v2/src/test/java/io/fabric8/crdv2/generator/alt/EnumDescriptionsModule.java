package io.fabric8.crdv2.generator.alt;

import java.lang.reflect.Field;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.github.victools.jsonschema.generator.Module;
import com.github.victools.jsonschema.generator.SchemaGenerationContext;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;
import com.github.victools.jsonschema.generator.TypeScope;

/**
 * Module that injects descriptions for enum constants declared using the {@code @JsonPropertyDescription} annotation. This
 * should be registered after any modules that would resolve the property description.
 */
public class EnumDescriptionsModule implements Module {

  @Override
  public void applyToConfigBuilder(SchemaGeneratorConfigBuilder builder) {
    builder.forTypesInGeneral().withTypeAttributeOverride(this::overrideAttributes);
    builder.forFields().withInstanceAttributeOverride(this::overrideAttributes);
    builder.forMethods().withInstanceAttributeOverride(this::overrideAttributes);
  }

  protected void overrideAttributes(
      ObjectNode attributes, TypeScope scope, SchemaGenerationContext context) {
    // if description was resolved for property of type enum, resolve descriptions
    // for enum constants and add them to the description
    JsonNode node = attributes.get("description");
    if (node == null || !node.isTextual()) {
      return;
    }
    Class<?> clazz = scope.getType().getErasedType();
    if (!clazz.isEnum()) {
      return;
    }
    StringBuilder sb = new StringBuilder();
    for (Object obj : clazz.getEnumConstants()) {
      if (obj instanceof Enum<?>) {
        try {
          Field field = clazz.getField(((Enum<?>) obj).name());
          JsonPropertyDescription description = field.getAnnotation(JsonPropertyDescription.class);
          if (description != null) {
            String propertyName = Optional.ofNullable(field.getAnnotation(JsonProperty.class))
                .map(ann -> ann.value())
                .orElse(obj.toString());
            sb.append("\n  * `").append(propertyName)
                .append("` - ").append(description.value());
          }
        } catch (ReflectiveOperationException e) {
          // do nothing
        }
      }
    }
    if (sb.length() != 0) {
      attributes.set("description", TextNode.valueOf(node.asText() + sb.toString()));
    }
  }
}