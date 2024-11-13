
package io.fabric8.openclustermanagement.api.model.apps.v1;

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
    "clusterSelector",
    "clusters",
    "local",
    "placementRef"
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
@Generated("jsonschema2pojo")
public class Placement implements Editable<PlacementBuilder> , KubernetesResource
{

    @JsonProperty("clusterSelector")
    private LabelSelector clusterSelector;
    @JsonProperty("clusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GenericClusterReference> clusters = new ArrayList<>();
    @JsonProperty("local")
    private Boolean local;
    @JsonProperty("placementRef")
    private ObjectReference placementRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Placement() {
    }

    public Placement(LabelSelector clusterSelector, List<GenericClusterReference> clusters, Boolean local, ObjectReference placementRef) {
        super();
        this.clusterSelector = clusterSelector;
        this.clusters = clusters;
        this.local = local;
        this.placementRef = placementRef;
    }

    @JsonProperty("clusterSelector")
    public LabelSelector getClusterSelector() {
        return clusterSelector;
    }

    @JsonProperty("clusterSelector")
    public void setClusterSelector(LabelSelector clusterSelector) {
        this.clusterSelector = clusterSelector;
    }

    @JsonProperty("clusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GenericClusterReference> getClusters() {
        return clusters;
    }

    @JsonProperty("clusters")
    public void setClusters(List<GenericClusterReference> clusters) {
        this.clusters = clusters;
    }

    @JsonProperty("local")
    public Boolean getLocal() {
        return local;
    }

    @JsonProperty("local")
    public void setLocal(Boolean local) {
        this.local = local;
    }

    @JsonProperty("placementRef")
    public ObjectReference getPlacementRef() {
        return placementRef;
    }

    @JsonProperty("placementRef")
    public void setPlacementRef(ObjectReference placementRef) {
        this.placementRef = placementRef;
    }

    @JsonIgnore
    public PlacementBuilder edit() {
        return new PlacementBuilder(this);
    }

    @JsonIgnore
    public PlacementBuilder toBuilder() {
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
