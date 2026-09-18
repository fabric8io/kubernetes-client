
package io.fabric8.openshift.api.model.config.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * RegistrySources holds cluster-wide information about how to handle the registries config.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowedRegistries",
    "blockedRegistries",
    "containerRuntimeSearchRegistries",
    "insecureRegistries"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RegistrySources implements Editable<RegistrySourcesBuilder>, KubernetesResource
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

    /**
     * allowedRegistries are the only registries permitted for image pull and push actions. All other registries are denied.<br><p> <br><p> Only one of BlockedRegistries or AllowedRegistries may be set.
     */
    @JsonProperty("allowedRegistries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedRegistries() {
        return allowedRegistries;
    }

    /**
     * allowedRegistries are the only registries permitted for image pull and push actions. All other registries are denied.<br><p> <br><p> Only one of BlockedRegistries or AllowedRegistries may be set.
     */
    @JsonProperty("allowedRegistries")
    public void setAllowedRegistries(List<String> allowedRegistries) {
        this.allowedRegistries = allowedRegistries;
    }

    /**
     * blockedRegistries cannot be used for image pull and push actions. All other registries are permitted.<br><p> <br><p> Only one of BlockedRegistries or AllowedRegistries may be set.
     */
    @JsonProperty("blockedRegistries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBlockedRegistries() {
        return blockedRegistries;
    }

    /**
     * blockedRegistries cannot be used for image pull and push actions. All other registries are permitted.<br><p> <br><p> Only one of BlockedRegistries or AllowedRegistries may be set.
     */
    @JsonProperty("blockedRegistries")
    public void setBlockedRegistries(List<String> blockedRegistries) {
        this.blockedRegistries = blockedRegistries;
    }

    /**
     * containerRuntimeSearchRegistries are registries that will be searched when pulling images that do not have fully qualified domains in their pull specs. Registries will be searched in the order provided in the list. Note: this search list only works with the container runtime, i.e CRI-O. Will NOT work with builds or imagestream imports.
     */
    @JsonProperty("containerRuntimeSearchRegistries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getContainerRuntimeSearchRegistries() {
        return containerRuntimeSearchRegistries;
    }

    /**
     * containerRuntimeSearchRegistries are registries that will be searched when pulling images that do not have fully qualified domains in their pull specs. Registries will be searched in the order provided in the list. Note: this search list only works with the container runtime, i.e CRI-O. Will NOT work with builds or imagestream imports.
     */
    @JsonProperty("containerRuntimeSearchRegistries")
    public void setContainerRuntimeSearchRegistries(List<String> containerRuntimeSearchRegistries) {
        this.containerRuntimeSearchRegistries = containerRuntimeSearchRegistries;
    }

    /**
     * insecureRegistries are registries which do not have a valid TLS certificates or only support HTTP connections.
     */
    @JsonProperty("insecureRegistries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getInsecureRegistries() {
        return insecureRegistries;
    }

    /**
     * insecureRegistries are registries which do not have a valid TLS certificates or only support HTTP connections.
     */
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RegistrySources)) {
            return false;
        }
        RegistrySources other = (RegistrySources) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowedRegistries = this.getAllowedRegistries();
        Object other$allowedRegistries = other.getAllowedRegistries();
        if (this$allowedRegistries == null ? other$allowedRegistries != null : !this$allowedRegistries.equals(other$allowedRegistries)) {
            return false;
        }
        Object this$blockedRegistries = this.getBlockedRegistries();
        Object other$blockedRegistries = other.getBlockedRegistries();
        if (this$blockedRegistries == null ? other$blockedRegistries != null : !this$blockedRegistries.equals(other$blockedRegistries)) {
            return false;
        }
        Object this$containerRuntimeSearchRegistries = this.getContainerRuntimeSearchRegistries();
        Object other$containerRuntimeSearchRegistries = other.getContainerRuntimeSearchRegistries();
        if (this$containerRuntimeSearchRegistries == null ? other$containerRuntimeSearchRegistries != null : !this$containerRuntimeSearchRegistries.equals(other$containerRuntimeSearchRegistries)) {
            return false;
        }
        Object this$insecureRegistries = this.getInsecureRegistries();
        Object other$insecureRegistries = other.getInsecureRegistries();
        if (this$insecureRegistries == null ? other$insecureRegistries != null : !this$insecureRegistries.equals(other$insecureRegistries)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof RegistrySources;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowedRegistries = this.getAllowedRegistries();
        result = result * prime + ($allowedRegistries == null ? 43 : $allowedRegistries.hashCode());
        Object $blockedRegistries = this.getBlockedRegistries();
        result = result * prime + ($blockedRegistries == null ? 43 : $blockedRegistries.hashCode());
        Object $containerRuntimeSearchRegistries = this.getContainerRuntimeSearchRegistries();
        result = result * prime + ($containerRuntimeSearchRegistries == null ? 43 : $containerRuntimeSearchRegistries.hashCode());
        Object $insecureRegistries = this.getInsecureRegistries();
        result = result * prime + ($insecureRegistries == null ? 43 : $insecureRegistries.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RegistrySources(" + "allowedRegistries=" + this.getAllowedRegistries() + ", blockedRegistries=" + this.getBlockedRegistries() + ", containerRuntimeSearchRegistries=" + this.getContainerRuntimeSearchRegistries() + ", insecureRegistries=" + this.getInsecureRegistries() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
