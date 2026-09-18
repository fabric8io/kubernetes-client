
package io.fabric8.autoscaling.api.model.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ContainerResourcePolicy controls how autoscaler computes the recommended resources for a specific container.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerName",
    "maxAllowed",
    "minAllowed",
    "mode"
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
public class ContainerResourcePolicy implements Editable<ContainerResourcePolicyBuilder>, KubernetesResource
{

    @JsonProperty("containerName")
    private String containerName;
    @JsonProperty("maxAllowed")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> maxAllowed = new LinkedHashMap<>();
    @JsonProperty("minAllowed")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> minAllowed = new LinkedHashMap<>();
    @JsonProperty("mode")
    private String mode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerResourcePolicy() {
    }

    public ContainerResourcePolicy(String containerName, Map<String, Quantity> maxAllowed, Map<String, Quantity> minAllowed, String mode) {
        super();
        this.containerName = containerName;
        this.maxAllowed = maxAllowed;
        this.minAllowed = minAllowed;
        this.mode = mode;
    }

    /**
     * Name of the container or DefaultContainerResourcePolicy, in which case the policy is used by the containers that don't have their own policy specified.
     */
    @JsonProperty("containerName")
    public String getContainerName() {
        return containerName;
    }

    /**
     * Name of the container or DefaultContainerResourcePolicy, in which case the policy is used by the containers that don't have their own policy specified.
     */
    @JsonProperty("containerName")
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * Specifies the maximum amount of resources that will be recommended for the container. The default is no maximum.
     */
    @JsonProperty("maxAllowed")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getMaxAllowed() {
        return maxAllowed;
    }

    /**
     * Specifies the maximum amount of resources that will be recommended for the container. The default is no maximum.
     */
    @JsonProperty("maxAllowed")
    public void setMaxAllowed(Map<String, Quantity> maxAllowed) {
        this.maxAllowed = maxAllowed;
    }

    /**
     * Specifies the minimal amount of resources that will be recommended for the container. The default is no minimum.
     */
    @JsonProperty("minAllowed")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getMinAllowed() {
        return minAllowed;
    }

    /**
     * Specifies the minimal amount of resources that will be recommended for the container. The default is no minimum.
     */
    @JsonProperty("minAllowed")
    public void setMinAllowed(Map<String, Quantity> minAllowed) {
        this.minAllowed = minAllowed;
    }

    /**
     * Whether autoscaler is enabled for the container. The default is "Auto".
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Whether autoscaler is enabled for the container. The default is "Auto".
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonIgnore
    public ContainerResourcePolicyBuilder edit() {
        return new ContainerResourcePolicyBuilder(this);
    }

    @JsonIgnore
    public ContainerResourcePolicyBuilder toBuilder() {
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
        if (!(o instanceof ContainerResourcePolicy)) {
            return false;
        }
        ContainerResourcePolicy other = (ContainerResourcePolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containerName = this.getContainerName();
        Object other$containerName = other.getContainerName();
        if (this$containerName == null ? other$containerName != null : !this$containerName.equals(other$containerName)) {
            return false;
        }
        Object this$maxAllowed = this.getMaxAllowed();
        Object other$maxAllowed = other.getMaxAllowed();
        if (this$maxAllowed == null ? other$maxAllowed != null : !this$maxAllowed.equals(other$maxAllowed)) {
            return false;
        }
        Object this$minAllowed = this.getMinAllowed();
        Object other$minAllowed = other.getMinAllowed();
        if (this$minAllowed == null ? other$minAllowed != null : !this$minAllowed.equals(other$minAllowed)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
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
        return other instanceof ContainerResourcePolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containerName = this.getContainerName();
        result = result * prime + ($containerName == null ? 43 : $containerName.hashCode());
        Object $maxAllowed = this.getMaxAllowed();
        result = result * prime + ($maxAllowed == null ? 43 : $maxAllowed.hashCode());
        Object $minAllowed = this.getMinAllowed();
        result = result * prime + ($minAllowed == null ? 43 : $minAllowed.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ContainerResourcePolicy(" + "containerName=" + this.getContainerName() + ", maxAllowed=" + this.getMaxAllowed() + ", minAllowed=" + this.getMinAllowed() + ", mode=" + this.getMode() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
