
package io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.placementrule.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
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
    "clusterSelector",
    "clusters",
    "local",
    "placementRef"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
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
public class Placement implements KubernetesResource
{

    @JsonProperty("clusterSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector clusterSelector;
    @JsonProperty("clusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GenericClusterReference> clusters = new ArrayList<GenericClusterReference>();
    @JsonProperty("local")
    private Boolean local;
    @JsonProperty("placementRef")
    private io.fabric8.kubernetes.api.model.ObjectReference placementRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Placement() {
    }

    /**
     * 
     * @param placementRef
     * @param clusterSelector
     * @param clusters
     * @param local
     */
    public Placement(io.fabric8.kubernetes.api.model.LabelSelector clusterSelector, List<GenericClusterReference> clusters, Boolean local, io.fabric8.kubernetes.api.model.ObjectReference placementRef) {
        super();
        this.clusterSelector = clusterSelector;
        this.clusters = clusters;
        this.local = local;
        this.placementRef = placementRef;
    }

    @JsonProperty("clusterSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getClusterSelector() {
        return clusterSelector;
    }

    @JsonProperty("clusterSelector")
    public void setClusterSelector(io.fabric8.kubernetes.api.model.LabelSelector clusterSelector) {
        this.clusterSelector = clusterSelector;
    }

    @JsonProperty("clusters")
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
    public io.fabric8.kubernetes.api.model.ObjectReference getPlacementRef() {
        return placementRef;
    }

    @JsonProperty("placementRef")
    public void setPlacementRef(io.fabric8.kubernetes.api.model.ObjectReference placementRef) {
        this.placementRef = placementRef;
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
