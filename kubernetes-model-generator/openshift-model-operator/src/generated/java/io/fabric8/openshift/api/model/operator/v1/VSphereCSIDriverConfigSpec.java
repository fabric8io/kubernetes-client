
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
public class VSphereCSIDriverConfigSpec implements Editable<VSphereCSIDriverConfigSpecBuilder> , KubernetesResource
{

    @JsonProperty("globalMaxSnapshotsPerBlockVolume")
    private Long globalMaxSnapshotsPerBlockVolume;
    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVSAN")
    private Long granularMaxSnapshotsPerBlockVolumeInVSAN;
    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVVOL")
    private Long granularMaxSnapshotsPerBlockVolumeInVVOL;
    @JsonProperty("topologyCategories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> topologyCategories = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VSphereCSIDriverConfigSpec() {
    }

    public VSphereCSIDriverConfigSpec(Long globalMaxSnapshotsPerBlockVolume, Long granularMaxSnapshotsPerBlockVolumeInVSAN, Long granularMaxSnapshotsPerBlockVolumeInVVOL, List<String> topologyCategories) {
        super();
        this.globalMaxSnapshotsPerBlockVolume = globalMaxSnapshotsPerBlockVolume;
        this.granularMaxSnapshotsPerBlockVolumeInVSAN = granularMaxSnapshotsPerBlockVolumeInVSAN;
        this.granularMaxSnapshotsPerBlockVolumeInVVOL = granularMaxSnapshotsPerBlockVolumeInVVOL;
        this.topologyCategories = topologyCategories;
    }

    @JsonProperty("globalMaxSnapshotsPerBlockVolume")
    public Long getGlobalMaxSnapshotsPerBlockVolume() {
        return globalMaxSnapshotsPerBlockVolume;
    }

    @JsonProperty("globalMaxSnapshotsPerBlockVolume")
    public void setGlobalMaxSnapshotsPerBlockVolume(Long globalMaxSnapshotsPerBlockVolume) {
        this.globalMaxSnapshotsPerBlockVolume = globalMaxSnapshotsPerBlockVolume;
    }

    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVSAN")
    public Long getGranularMaxSnapshotsPerBlockVolumeInVSAN() {
        return granularMaxSnapshotsPerBlockVolumeInVSAN;
    }

    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVSAN")
    public void setGranularMaxSnapshotsPerBlockVolumeInVSAN(Long granularMaxSnapshotsPerBlockVolumeInVSAN) {
        this.granularMaxSnapshotsPerBlockVolumeInVSAN = granularMaxSnapshotsPerBlockVolumeInVSAN;
    }

    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVVOL")
    public Long getGranularMaxSnapshotsPerBlockVolumeInVVOL() {
        return granularMaxSnapshotsPerBlockVolumeInVVOL;
    }

    @JsonProperty("granularMaxSnapshotsPerBlockVolumeInVVOL")
    public void setGranularMaxSnapshotsPerBlockVolumeInVVOL(Long granularMaxSnapshotsPerBlockVolumeInVVOL) {
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
    public VSphereCSIDriverConfigSpecBuilder edit() {
        return new VSphereCSIDriverConfigSpecBuilder(this);
    }

    @JsonIgnore
    public VSphereCSIDriverConfigSpecBuilder toBuilder() {
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
