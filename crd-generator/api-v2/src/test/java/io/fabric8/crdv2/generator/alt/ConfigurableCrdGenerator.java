package io.fabric8.crdv2.generator.alt;

import static io.fabric8.crdv2.generator.alt.GeneratorUtils.convertValue;
import static io.fabric8.crdv2.generator.alt.GeneratorUtils.getPrinterColumns;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.victools.jsonschema.generator.Module;
import com.github.victools.jsonschema.generator.Option;
import com.github.victools.jsonschema.generator.OptionPreset;
import com.github.victools.jsonschema.generator.SchemaGenerator;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;
import com.github.victools.jsonschema.generator.SchemaVersion;
import com.github.victools.jsonschema.module.jackson.JacksonModule;
import com.github.victools.jsonschema.module.jackson.JacksonOption;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;

/**
 * Alternative CRD generator implementation that uses victools/jsonschema-generator and allows schema generation to be
 * customized via modules.
 * <p>
 * 
 * Support for Jakarta Validation API annotations can be enabled using victools/jsonschema-module-jakarta-validation.
 * <p>
 * 
 * Support for Swagger annotations can be enabled using victools/jsonschema-module-swagger-2.
 */
public class ConfigurableCrdGenerator {

  private final List<Module> modules = new ArrayList<>();
  private SchemaGenerator schemaGenerator = null;

  public ConfigurableCrdGenerator register(Module module) {
    if (schemaGenerator != null) {
      throw new IllegalStateException("Already created schema generator");
    }
    modules.add(module);
    return this;
  }

  protected SchemaGeneratorConfigBuilder baseConfig() {
    return new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_6, OptionPreset.PLAIN_JSON)
        .with(Option.ENUM_KEYWORD_FOR_SINGLE_VALUES)
        .with(Option.INLINE_ALL_SCHEMAS)
        .with(Option.MAP_VALUES_AS_ADDITIONAL_PROPERTIES)
        .with(new JacksonModule(
            JacksonOption.FLATTENED_ENUMS_FROM_JSONPROPERTY,
            JacksonOption.RESPECT_JSONPROPERTY_ORDER))
        .with(new Fabric8Module());
  }

  protected synchronized SchemaGenerator schemaGenerator() {
    if (schemaGenerator == null) {
      SchemaGeneratorConfigBuilder configBuilder = baseConfig();
      for (Module module : modules) {
        configBuilder = configBuilder.with(module);
      }
      configBuilder = configBuilder.with(new CrdComplianceModule());
      schemaGenerator = new SchemaGenerator(configBuilder.build());
    }
    return schemaGenerator;
  }

  public ObjectNode getSchema(Type type) {
    ObjectNode schema = schemaGenerator().generateSchema(type);
    schema.remove("$schema");
    return schema;
  }

  public <SPEC, STATUS> CustomResourceDefinition generateCrd(Class<? extends CustomResource<SPEC, STATUS>> crdClass) {
    Type genericClass = crdClass.getGenericSuperclass();
    if (!(genericClass instanceof ParameterizedType)) {
      throw new IllegalArgumentException(crdClass.getName() + " is not a parameterize type");
    }
    Type[] typeParams = ((ParameterizedType) genericClass).getActualTypeArguments();
    if (typeParams.length != 2) {
      throw new IllegalArgumentException(
          "Unexpected number of type parameters for class " + crdClass.getName() + ": " + typeParams.length);
    }
    @SuppressWarnings("unchecked")
    Class<SPEC> specClass = (Class<SPEC>) typeParams[0];
    @SuppressWarnings("unchecked")
    Class<STATUS> statusClass = (Class<STATUS>) typeParams[1];
    return generateCrd(crdClass, specClass, statusClass);
  }

  public <SPEC, STATUS> CustomResourceDefinition generateCrd(
      Class<? extends CustomResource<SPEC, STATUS>> crdClass,
      Class<SPEC> specClass, Class<STATUS> statusClass) {
    String kind = Optional.ofNullable(crdClass.getAnnotation(Kind.class))
        .map(ann -> ann.value())
        .orElseGet(crdClass::getSimpleName);
    String singular = Optional.ofNullable(crdClass.getAnnotation(Singular.class))
        .map(ann -> ann.value())
        .orElseGet(() -> kind.toLowerCase(Locale.US));
    String plural = Optional.ofNullable(crdClass.getAnnotation(Plural.class))
        .map(ann -> ann.value())
        .orElseGet(() -> singular + "s");
    String group = Optional.ofNullable(crdClass.getAnnotation(Group.class))
        .map(ann -> ann.value())
        .orElse(crdClass.getPackage().getName());
    String version = Optional.ofNullable(crdClass.getAnnotation(Version.class))
        .map(ann -> ann.value())
        .orElse("v1beta1");
    String scope = Namespaced.class.isAssignableFrom(crdClass) ? "Namespaced" : "Cluster";
    JsonNode specSchema = getSchema(specClass);
    JsonNode statusSchema = getSchema(statusClass);
    return new CustomResourceDefinition().edit()
        .withNewMetadata()
        .withName(plural + "." + group)
        .endMetadata()
        .withNewSpec()
        .withGroup(group)
        .withNewNames()
        .withKind(kind)
        .withPlural(plural)
        .withSingular(singular)
        .endNames()
        .withScope(scope)
        .addNewVersion()
        .withName(version)
        .withAdditionalPrinterColumns(getPrinterColumns(crdClass))
        .withNewSchema()
        .withNewOpenAPIV3Schema()
        .addToProperties("spec", convertValue(specSchema, JSONSchemaProps.class))
        .addToProperties("status", convertValue(statusSchema, JSONSchemaProps.class))
        .withType("object")
        .endOpenAPIV3Schema()
        .endSchema()
        .withServed()
        .withStorage()
        .withNewSubresources()
        .withNewStatus()
        .endStatus()
        .endSubresources()
        .endVersion()
        .endSpec()
        .build();
  }
}
