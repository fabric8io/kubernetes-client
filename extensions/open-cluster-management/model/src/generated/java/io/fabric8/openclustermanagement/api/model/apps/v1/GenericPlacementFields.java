
package io.fabric8.openclustermanagement.api.model.apps.v1;

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

/**
 * GenericPlacementFields - in alignment with kubefed
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterSelector",
    "clusters"
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
public class GenericPlacementFields implements Editable<GenericPlacementFieldsBuilder>, KubernetesResource
{

    @JsonProperty("clusterSelector")
    private LabelSelector clusterSelector;
    @JsonProperty("clusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GenericClusterReference> clusters = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GenericPlacementFields() {
    }

    public GenericPlacementFields(LabelSelector clusterSelector, List<GenericClusterReference> clusters) {
        super();
        this.clusterSelector = clusterSelector;
        this.clusters = clusters;
    }

    /**
     * GenericPlacementFields - in alignment with kubefed
     */
    @JsonProperty("clusterSelector")
    public LabelSelector getClusterSelector() {
        return clusterSelector;
    }

    /**
     * GenericPlacementFields - in alignment with kubefed
     */
    @JsonProperty("clusterSelector")
    public void setClusterSelector(LabelSelector clusterSelector) {
        this.clusterSelector = clusterSelector;
    }

    /**
     * GenericPlacementFields - in alignment with kubefed
     */
    @JsonProperty("clusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GenericClusterReference> getClusters() {
        return clusters;
    }

    /**
     * GenericPlacementFields - in alignment with kubefed
     */
    @JsonProperty("clusters")
    public void setClusters(List<GenericClusterReference> clusters) {
        this.clusters = clusters;
    }

    @JsonIgnore
    public GenericPlacementFieldsBuilder edit() {
        return new GenericPlacementFieldsBuilder(this);
    }

    @JsonIgnore
    public GenericPlacementFieldsBuilder toBuilder() {
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
        if (!(o instanceof GenericPlacementFields)) {
            return false;
        }
        GenericPlacementFields other = (GenericPlacementFields) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterSelector = this.getClusterSelector();
        Object other$clusterSelector = other.getClusterSelector();
        if (this$clusterSelector == null ? other$clusterSelector != null : !this$clusterSelector.equals(other$clusterSelector)) {
            return false;
        }
        Object this$clusters = this.getClusters();
        Object other$clusters = other.getClusters();
        if (this$clusters == null ? other$clusters != null : !this$clusters.equals(other$clusters)) {
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
        return other instanceof GenericPlacementFields;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterSelector = this.getClusterSelector();
        result = result * prime + ($clusterSelector == null ? 43 : $clusterSelector.hashCode());
        Object $clusters = this.getClusters();
        result = result * prime + ($clusters == null ? 43 : $clusters.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GenericPlacementFields(" + "clusterSelector=" + this.getClusterSelector() + ", clusters=" + this.getClusters() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
