
package io.fabric8.knative.duck.v1alpha1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxAllowedVReplicas",
    "placements"
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
public class PlaceableStatus implements Editable<PlaceableStatusBuilder>, KubernetesResource
{

    @JsonProperty("maxAllowedVReplicas")
    private Integer maxAllowedVReplicas;
    @JsonProperty("placements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Placement> placements = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PlaceableStatus() {
    }

    public PlaceableStatus(Integer maxAllowedVReplicas, List<Placement> placements) {
        super();
        this.maxAllowedVReplicas = maxAllowedVReplicas;
        this.placements = placements;
    }

    @JsonProperty("maxAllowedVReplicas")
    public Integer getMaxAllowedVReplicas() {
        return maxAllowedVReplicas;
    }

    @JsonProperty("maxAllowedVReplicas")
    public void setMaxAllowedVReplicas(Integer maxAllowedVReplicas) {
        this.maxAllowedVReplicas = maxAllowedVReplicas;
    }

    @JsonProperty("placements")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Placement> getPlacements() {
        return placements;
    }

    @JsonProperty("placements")
    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }

    @JsonIgnore
    public PlaceableStatusBuilder edit() {
        return new PlaceableStatusBuilder(this);
    }

    @JsonIgnore
    public PlaceableStatusBuilder toBuilder() {
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
        if (!(o instanceof PlaceableStatus)) {
            return false;
        }
        PlaceableStatus other = (PlaceableStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$maxAllowedVReplicas = this.getMaxAllowedVReplicas();
        Object other$maxAllowedVReplicas = other.getMaxAllowedVReplicas();
        if (this$maxAllowedVReplicas == null ? other$maxAllowedVReplicas != null : !this$maxAllowedVReplicas.equals(other$maxAllowedVReplicas)) {
            return false;
        }
        Object this$placements = this.getPlacements();
        Object other$placements = other.getPlacements();
        if (this$placements == null ? other$placements != null : !this$placements.equals(other$placements)) {
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
        return other instanceof PlaceableStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $maxAllowedVReplicas = this.getMaxAllowedVReplicas();
        result = result * prime + ($maxAllowedVReplicas == null ? 43 : $maxAllowedVReplicas.hashCode());
        Object $placements = this.getPlacements();
        result = result * prime + ($placements == null ? 43 : $placements.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PlaceableStatus(" + "maxAllowedVReplicas=" + this.getMaxAllowedVReplicas() + ", placements=" + this.getPlacements() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
