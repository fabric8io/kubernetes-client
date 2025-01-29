
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
 * AdditionalNetworkDefinition configures an extra network that is available but not created by default. Instead, pods must request them by name. type must be specified, along with exactly one "Config" that matches the type.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "namespace",
    "rawCNIConfig",
    "simpleMacvlanConfig",
    "type"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
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
public class AdditionalNetworkDefinition implements Editable<AdditionalNetworkDefinitionBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("rawCNIConfig")
    private String rawCNIConfig;
    @JsonProperty("simpleMacvlanConfig")
    private SimpleMacvlanConfig simpleMacvlanConfig;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AdditionalNetworkDefinition() {
    }

    public AdditionalNetworkDefinition(String name, String namespace, String rawCNIConfig, SimpleMacvlanConfig simpleMacvlanConfig, String type) {
        super();
        this.name = name;
        this.namespace = namespace;
        this.rawCNIConfig = rawCNIConfig;
        this.simpleMacvlanConfig = simpleMacvlanConfig;
        this.type = type;
    }

    /**
     * name is the name of the network. This will be populated in the resulting CRD This must be unique.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the name of the network. This will be populated in the resulting CRD This must be unique.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * namespace is the namespace of the network. This will be populated in the resulting CRD If not given the network will be created in the default namespace.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * namespace is the namespace of the network. This will be populated in the resulting CRD If not given the network will be created in the default namespace.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * rawCNIConfig is the raw CNI configuration json to create in the NetworkAttachmentDefinition CRD
     */
    @JsonProperty("rawCNIConfig")
    public String getRawCNIConfig() {
        return rawCNIConfig;
    }

    /**
     * rawCNIConfig is the raw CNI configuration json to create in the NetworkAttachmentDefinition CRD
     */
    @JsonProperty("rawCNIConfig")
    public void setRawCNIConfig(String rawCNIConfig) {
        this.rawCNIConfig = rawCNIConfig;
    }

    /**
     * AdditionalNetworkDefinition configures an extra network that is available but not created by default. Instead, pods must request them by name. type must be specified, along with exactly one "Config" that matches the type.
     */
    @JsonProperty("simpleMacvlanConfig")
    public SimpleMacvlanConfig getSimpleMacvlanConfig() {
        return simpleMacvlanConfig;
    }

    /**
     * AdditionalNetworkDefinition configures an extra network that is available but not created by default. Instead, pods must request them by name. type must be specified, along with exactly one "Config" that matches the type.
     */
    @JsonProperty("simpleMacvlanConfig")
    public void setSimpleMacvlanConfig(SimpleMacvlanConfig simpleMacvlanConfig) {
        this.simpleMacvlanConfig = simpleMacvlanConfig;
    }

    /**
     * type is the type of network The supported values are NetworkTypeRaw, NetworkTypeSimpleMacvlan
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the type of network The supported values are NetworkTypeRaw, NetworkTypeSimpleMacvlan
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public AdditionalNetworkDefinitionBuilder edit() {
        return new AdditionalNetworkDefinitionBuilder(this);
    }

    @JsonIgnore
    public AdditionalNetworkDefinitionBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
