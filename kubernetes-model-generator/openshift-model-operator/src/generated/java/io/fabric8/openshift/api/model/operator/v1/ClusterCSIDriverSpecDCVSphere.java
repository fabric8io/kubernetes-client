
package io.fabric8.openshift.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "globalMaxSnapshotsPerBlockVolume",
    "granularMaxSnapshotsPerBlockVolumeInVSAN",
    "granularMaxSnapshotsPerBlockVolumeInVVOL",
    "topologyCategories"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ClusterCSIDriverSpecDCVSphere implements Editable<ClusterCSIDriverSpecDCVSphereBuilder> , KubernetesResource
{

    @JsonProperty("globalMaxSnapshotsPerBlockVolume")
    private Integer globalMaxSnapshotsPerBlockVolume;
    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVSAN")
    private Integer granularMaxSnapshotsPerBlockVolumeInVSAN;
    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVVOL")
    private Integer granularMaxSnapshotsPerBlockVolumeInVVOL;
    @JsonProperty("topologyCategories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> topologyCategories = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterCSIDriverSpecDCVSphere() {
    }

    public ClusterCSIDriverSpecDCVSphere(Integer globalMaxSnapshotsPerBlockVolume, Integer granularMaxSnapshotsPerBlockVolumeInVSAN, Integer granularMaxSnapshotsPerBlockVolumeInVVOL, List<String> topologyCategories) {
        super();
        this.globalMaxSnapshotsPerBlockVolume = globalMaxSnapshotsPerBlockVolume;
        this.granularMaxSnapshotsPerBlockVolumeInVSAN = granularMaxSnapshotsPerBlockVolumeInVSAN;
        this.granularMaxSnapshotsPerBlockVolumeInVVOL = granularMaxSnapshotsPerBlockVolumeInVVOL;
        this.topologyCategories = topologyCategories;
    }

    @JsonProperty("globalMaxSnapshotsPerBlockVolume")
    public Integer getGlobalMaxSnapshotsPerBlockVolume() {
        return globalMaxSnapshotsPerBlockVolume;
    }

    @JsonProperty("globalMaxSnapshotsPerBlockVolume")
    public void setGlobalMaxSnapshotsPerBlockVolume(Integer globalMaxSnapshotsPerBlockVolume) {
        this.globalMaxSnapshotsPerBlockVolume = globalMaxSnapshotsPerBlockVolume;
    }

    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVSAN")
    public Integer getGranularMaxSnapshotsPerBlockVolumeInVSAN() {
        return granularMaxSnapshotsPerBlockVolumeInVSAN;
    }

    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVSAN")
    public void setGranularMaxSnapshotsPerBlockVolumeInVSAN(Integer granularMaxSnapshotsPerBlockVolumeInVSAN) {
        this.granularMaxSnapshotsPerBlockVolumeInVSAN = granularMaxSnapshotsPerBlockVolumeInVSAN;
    }

    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVVOL")
    public Integer getGranularMaxSnapshotsPerBlockVolumeInVVOL() {
        return granularMaxSnapshotsPerBlockVolumeInVVOL;
    }

    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVVOL")
    public void setGranularMaxSnapshotsPerBlockVolumeInVVOL(Integer granularMaxSnapshotsPerBlockVolumeInVVOL) {
        this.granularMaxSnapshotsPerBlockVolumeInVVOL = granularMaxSnapshotsPerBlockVolumeInVVOL;
    }

    @JsonProperty("topologyCategories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTopologyCategories() {
        return topologyCategories;
    }

    @JsonProperty("topologyCategories")
    public void setTopologyCategories(List<String> topologyCategories) {
        this.topologyCategories = topologyCategories;
    }

    @JsonIgnore
    public ClusterCSIDriverSpecDCVSphereBuilder edit() {
        return new ClusterCSIDriverSpecDCVSphereBuilder(this);
    }

    @JsonIgnore
    public ClusterCSIDriverSpecDCVSphereBuilder toBuilder() {
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
