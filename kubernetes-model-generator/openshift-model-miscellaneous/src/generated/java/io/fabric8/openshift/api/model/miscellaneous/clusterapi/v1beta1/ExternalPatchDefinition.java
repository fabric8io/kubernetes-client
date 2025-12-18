
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ExternalPatchDefinition defines an external patch. Note: At least one of GenerateExtension or ValidateExtension must be set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "discoverVariablesExtension",
    "generateExtension",
    "settings",
    "validateExtension"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ExternalPatchDefinition implements Editable<ExternalPatchDefinitionBuilder>, KubernetesResource
{

    @JsonProperty("discoverVariablesExtension")
    private String discoverVariablesExtension;
    @JsonProperty("generateExtension")
    private String generateExtension;
    @JsonProperty("settings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> settings = new LinkedHashMap<>();
    @JsonProperty("validateExtension")
    private String validateExtension;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExternalPatchDefinition() {
    }

    public ExternalPatchDefinition(String discoverVariablesExtension, String generateExtension, Map<String, String> settings, String validateExtension) {
        super();
        this.discoverVariablesExtension = discoverVariablesExtension;
        this.generateExtension = generateExtension;
        this.settings = settings;
        this.validateExtension = validateExtension;
    }

    /**
     * discoverVariablesExtension references an extension which is called to discover variables.
     */
    @JsonProperty("discoverVariablesExtension")
    public String getDiscoverVariablesExtension() {
        return discoverVariablesExtension;
    }

    /**
     * discoverVariablesExtension references an extension which is called to discover variables.
     */
    @JsonProperty("discoverVariablesExtension")
    public void setDiscoverVariablesExtension(String discoverVariablesExtension) {
        this.discoverVariablesExtension = discoverVariablesExtension;
    }

    /**
     * generateExtension references an extension which is called to generate patches.
     */
    @JsonProperty("generateExtension")
    public String getGenerateExtension() {
        return generateExtension;
    }

    /**
     * generateExtension references an extension which is called to generate patches.
     */
    @JsonProperty("generateExtension")
    public void setGenerateExtension(String generateExtension) {
        this.generateExtension = generateExtension;
    }

    /**
     * settings defines key value pairs to be passed to the extensions. Values defined here take precedence over the values defined in the corresponding ExtensionConfig.
     */
    @JsonProperty("settings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getSettings() {
        return settings;
    }

    /**
     * settings defines key value pairs to be passed to the extensions. Values defined here take precedence over the values defined in the corresponding ExtensionConfig.
     */
    @JsonProperty("settings")
    public void setSettings(Map<String, String> settings) {
        this.settings = settings;
    }

    /**
     * validateExtension references an extension which is called to validate the topology.
     */
    @JsonProperty("validateExtension")
    public String getValidateExtension() {
        return validateExtension;
    }

    /**
     * validateExtension references an extension which is called to validate the topology.
     */
    @JsonProperty("validateExtension")
    public void setValidateExtension(String validateExtension) {
        this.validateExtension = validateExtension;
    }

    @JsonIgnore
    public ExternalPatchDefinitionBuilder edit() {
        return new ExternalPatchDefinitionBuilder(this);
    }

    @JsonIgnore
    public ExternalPatchDefinitionBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
