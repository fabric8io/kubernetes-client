
package io.fabric8.openshift.api.model.config.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowedRegistries",
    "blockedRegistries",
    "containerRuntimeSearchRegistries",
    "insecureRegistries"
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
public class RegistrySources implements Editable<RegistrySourcesBuilder> , KubernetesResource
{

    @JsonProperty("allowedRegistries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedRegistries = new ArrayList<>();
    @JsonProperty("blockedRegistries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> blockedRegistries = new ArrayList<>();
    @JsonProperty("containerRuntimeSearchRegistries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> containerRuntimeSearchRegistries = new ArrayList<>();
    @JsonProperty("insecureRegistries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> insecureRegistries = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RegistrySources() {
    }

    public RegistrySources(List<String> allowedRegistries, List<String> blockedRegistries, List<String> containerRuntimeSearchRegistries, List<String> insecureRegistries) {
        super();
        this.allowedRegistries = allowedRegistries;
        this.blockedRegistries = blockedRegistries;
        this.containerRuntimeSearchRegistries = containerRuntimeSearchRegistries;
        this.insecureRegistries = insecureRegistries;
    }

    @JsonProperty("allowedRegistries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedRegistries() {
        return allowedRegistries;
    }

    @JsonProperty("allowedRegistries")
    public void setAllowedRegistries(List<String> allowedRegistries) {
        this.allowedRegistries = allowedRegistries;
    }

    @JsonProperty("blockedRegistries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBlockedRegistries() {
        return blockedRegistries;
    }

    @JsonProperty("blockedRegistries")
    public void setBlockedRegistries(List<String> blockedRegistries) {
        this.blockedRegistries = blockedRegistries;
    }

    @JsonProperty("containerRuntimeSearchRegistries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getContainerRuntimeSearchRegistries() {
        return containerRuntimeSearchRegistries;
    }

    @JsonProperty("containerRuntimeSearchRegistries")
    public void setContainerRuntimeSearchRegistries(List<String> containerRuntimeSearchRegistries) {
        this.containerRuntimeSearchRegistries = containerRuntimeSearchRegistries;
    }

    @JsonProperty("insecureRegistries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getInsecureRegistries() {
        return insecureRegistries;
    }

    @JsonProperty("insecureRegistries")
    public void setInsecureRegistries(List<String> insecureRegistries) {
        this.insecureRegistries = insecureRegistries;
    }

    @JsonIgnore
    public RegistrySourcesBuilder edit() {
        return new RegistrySourcesBuilder(this);
    }

    @JsonIgnore
    public RegistrySourcesBuilder toBuilder() {
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
