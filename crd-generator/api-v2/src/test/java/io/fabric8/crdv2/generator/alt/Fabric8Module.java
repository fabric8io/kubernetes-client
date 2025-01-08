package io.fabric8.crdv2.generator.alt;

import static io.fabric8.crdv2.generator.alt.GeneratorUtils.convertValue;
import static io.fabric8.crdv2.generator.alt.GeneratorUtils.emptyToNull;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.victools.jsonschema.generator.MemberScope;
import com.github.victools.jsonschema.generator.Module;
import com.github.victools.jsonschema.generator.SchemaGenerationContext;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;
import com.github.victools.jsonschema.generator.TypeScope;

import io.fabric8.generator.annotation.Default;
import io.fabric8.generator.annotation.Max;
import io.fabric8.generator.annotation.Min;
import io.fabric8.generator.annotation.Nullable;
import io.fabric8.generator.annotation.Pattern;
import io.fabric8.generator.annotation.Required;
import io.fabric8.generator.annotation.ValidationRule;
import io.fabric8.generator.annotation.ValidationRules;
import io.fabric8.kubernetes.api.model.apiextensions.v1.ValidationRuleBuilder;

/**
 * Module that enables injection of attributes from Fabric8 annotations, e.g. {@code @ValidationRule}.
 */
public class Fabric8Module implements Module {

  @Override
  public void applyToConfigBuilder(SchemaGeneratorConfigBuilder builder) {
    builder.forTypesInGeneral().withTypeAttributeOverride(this::overrideTypeAttributes);

    builder.forFields().withDefaultResolver(this::resolveDefault);
    builder.forFields().withStringMaxLengthResolver(this::resolveMaxLength);
    builder.forFields().withStringMinLengthResolver(this::resolveMinLength);
    builder.forFields().withStringPatternResolver(this::resolvePattern);
    builder.forFields().withNullableCheck(this::checkNullable);
    builder.forFields().withRequiredCheck(this::checkRequired);
    builder.forFields().withInstanceAttributeOverride(this::overrideInstanceAttributes);

    builder.forMethods().withDefaultResolver(this::resolveDefault);
    builder.forMethods().withStringMaxLengthResolver(this::resolveMaxLength);
    builder.forMethods().withStringMinLengthResolver(this::resolveMinLength);
    builder.forMethods().withStringPatternResolver(this::resolvePattern);
    builder.forMethods().withNullableCheck(this::checkNullable);
    builder.forMethods().withRequiredCheck(this::checkRequired);
    builder.forMethods().withInstanceAttributeOverride(this::overrideInstanceAttributes);
  }

  public Object resolveDefault(MemberScope<?, ?> member) {
    return getFromAnnotation(member, Default.class, Default::value).orElse(null);
  }

  public Integer resolveMaxLength(MemberScope<?, ?> member) {
    return getFromAnnotation(member, Max.class, ann -> (int) ann.value()).orElse(null);
  }

  public Integer resolveMinLength(MemberScope<?, ?> member) {
    return getFromAnnotation(member, Min.class, ann -> (int) ann.value()).orElse(null);
  }

  public String resolvePattern(MemberScope<?, ?> member) {
    return getFromAnnotation(member, Pattern.class, Pattern::value).orElse(null);
  }

  public Boolean checkNullable(MemberScope<?, ?> member) {
    return getFromAnnotation(member, Nullable.class, Function.identity()).isPresent();
  }

  public Boolean checkRequired(MemberScope<?, ?> member) {
    return getFromAnnotation(member, Required.class, Function.identity()).isPresent();
  }

  protected void overrideTypeAttributes(
      ObjectNode collectedTypeAttributes, TypeScope scope, SchemaGenerationContext context) {
    // attach CEL validation rules to node
    ValidationRule[] annotations = scope.getType().getErasedType().getAnnotationsByType(ValidationRule.class);
    if (annotations.length != 0) {
      addValidationRules(collectedTypeAttributes, annotations);
    }
  }

  protected void overrideInstanceAttributes(
      ObjectNode memberAttributes, MemberScope<?, ?> member, SchemaGenerationContext context) {
    // attach CEL validation rules to node
    ValidationRule[] annotations = getFromAnnotation(member, ValidationRules.class, ValidationRules::value).orElseGet(() -> {
      return getFromAnnotation(member, ValidationRule.class, ann -> new ValidationRule[] { ann })
          .orElse(new ValidationRule[0]);
    });
    if (annotations.length != 0) {
      addValidationRules(memberAttributes, annotations);
    }
  }

  protected static <A extends Annotation, T> Optional<T> getFromAnnotation(
      MemberScope<?, ?> member, Class<A> clazz, Function<A, T> fn) {
    return Optional.ofNullable(member.getAnnotationConsideringFieldAndGetter(clazz)).map(fn);
  }

  protected static void addValidationRules(ObjectNode node, ValidationRule... annotations) {
    List<io.fabric8.kubernetes.api.model.apiextensions.v1.ValidationRule> rules = Stream.of(annotations).map(ann -> {
      return new ValidationRuleBuilder()
          .withRule(ann.value())
          .withFieldPath(emptyToNull(ann.fieldPath()))
          .withMessage(emptyToNull(ann.message()))
          .withMessageExpression(emptyToNull(ann.messageExpression()))
          .withOptionalOldSelf(ann.optionalOldSelf() ? true : null)
          .withReason(emptyToNull(ann.reason()))
          .build();
    }).collect(Collectors.toList());
    node.set("x-kubernetes-validations", convertValue(rules, JsonNode.class));
  }
}