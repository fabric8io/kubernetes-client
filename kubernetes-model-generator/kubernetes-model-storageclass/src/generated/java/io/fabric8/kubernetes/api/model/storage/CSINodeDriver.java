
package io.fabric8.kubernetes.api.model.storage;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "allocatable",
    "name",
    "nodeID",
    "topologyKeys"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class CSINodeDriver implements KubernetesResource
{

    @JsonProperty("allocatable")
    private VolumeNodeResources allocatable;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nodeID")
    private String nodeID;
    @JsonProperty("topologyKeys")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> topologyKeys = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CSINodeDriver() {
    }

    public CSINodeDriver(VolumeNodeResources allocatable, String name, String nodeID, List<String> topologyKeys) {
        super();
        this.allocatable = allocatable;
        this.name = name;
        this.nodeID = nodeID;
        this.topologyKeys = topologyKeys;
    }

    @JsonProperty("allocatable")
    public VolumeNodeResources getAllocatable() {
        return allocatable;
    }

    @JsonProperty("allocatable")
    public void setAllocatable(VolumeNodeResources allocatable) {
        this.allocatable = allocatable;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("nodeID")
    public String getNodeID() {
        return nodeID;
    }

    @JsonProperty("nodeID")
    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    @JsonProperty("topologyKeys")
    public List<String> getTopologyKeys() {
        return topologyKeys;
    }

    @JsonProperty("topologyKeys")
    public void setTopologyKeys(List<String> topologyKeys) {
        this.topologyKeys = topologyKeys;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
