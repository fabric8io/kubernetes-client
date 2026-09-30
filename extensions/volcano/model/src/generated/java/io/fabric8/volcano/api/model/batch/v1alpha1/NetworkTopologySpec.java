
package io.fabric8.volcano.api.model.batch.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "highestTierAllowed",
    "highestTierName",
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
public class NetworkTopologySpec implements Editable<NetworkTopologySpecBuilder>, KubernetesResource
{

    @JsonProperty("highestTierAllowed")
    private Integer highestTierAllowed;
    @JsonProperty("highestTierName")
    private String highestTierName;
    @JsonProperty("mode")
    private String mode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkTopologySpec() {
    }

    public NetworkTopologySpec(Integer highestTierAllowed, String highestTierName, String mode) {
        super();
        this.highestTierAllowed = highestTierAllowed;
        this.highestTierName = highestTierName;
        this.mode = mode;
    }

    /**
     * HighestTierAllowed specifies the highest tier that a job allowed to cross when scheduling.
     */
    @JsonProperty("highestTierAllowed")
    public Integer getHighestTierAllowed() {
        return highestTierAllowed;
    }

    /**
     * HighestTierAllowed specifies the highest tier that a job allowed to cross when scheduling.
     */
    @JsonProperty("highestTierAllowed")
    public void setHighestTierAllowed(Integer highestTierAllowed) {
        this.highestTierAllowed = highestTierAllowed;
    }

    /**
     * HighestTierName specifies the highest tier name that a job allowed to cross when scheduling. HighestTierName and HighestTierAllowed cannot be set simultaneously.
     */
    @JsonProperty("highestTierName")
    public String getHighestTierName() {
        return highestTierName;
    }

    /**
     * HighestTierName specifies the highest tier name that a job allowed to cross when scheduling. HighestTierName and HighestTierAllowed cannot be set simultaneously.
     */
    @JsonProperty("highestTierName")
    public void setHighestTierName(String highestTierName) {
        this.highestTierName = highestTierName;
    }

    /**
     * Mode specifies the mode of the network topology constrain.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode specifies the mode of the network topology constrain.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonIgnore
    public NetworkTopologySpecBuilder edit() {
        return new NetworkTopologySpecBuilder(this);
    }

    @JsonIgnore
    public NetworkTopologySpecBuilder toBuilder() {
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
        if (!(o instanceof NetworkTopologySpec)) {
            return false;
        }
        NetworkTopologySpec other = (NetworkTopologySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$highestTierAllowed = this.getHighestTierAllowed();
        Object other$highestTierAllowed = other.getHighestTierAllowed();
        if (this$highestTierAllowed == null ? other$highestTierAllowed != null : !this$highestTierAllowed.equals(other$highestTierAllowed)) {
            return false;
        }
        Object this$highestTierName = this.getHighestTierName();
        Object other$highestTierName = other.getHighestTierName();
        if (this$highestTierName == null ? other$highestTierName != null : !this$highestTierName.equals(other$highestTierName)) {
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
        return other instanceof NetworkTopologySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $highestTierAllowed = this.getHighestTierAllowed();
        result = result * prime + ($highestTierAllowed == null ? 43 : $highestTierAllowed.hashCode());
        Object $highestTierName = this.getHighestTierName();
        result = result * prime + ($highestTierName == null ? 43 : $highestTierName.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkTopologySpec(" + "highestTierAllowed=" + this.getHighestTierAllowed() + ", highestTierName=" + this.getHighestTierName() + ", mode=" + this.getMode() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
