
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "highestTierAllowed",
    "highestTierName",
    "mode"
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

}
