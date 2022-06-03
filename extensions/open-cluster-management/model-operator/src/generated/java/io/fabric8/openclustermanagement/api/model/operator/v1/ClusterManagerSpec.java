
package io.fabric8.openclustermanagement.api.model.operator.v1;

import java.util.HashMap;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "nodePlacement",
    "placementImagePullSpec",
    "registrationImagePullSpec",
    "workImagePullSpec"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class ClusterManagerSpec implements KubernetesResource
{

    @JsonProperty("nodePlacement")
    private NodePlacement nodePlacement;
    @JsonProperty("placementImagePullSpec")
    private String placementImagePullSpec;
    @JsonProperty("registrationImagePullSpec")
    private String registrationImagePullSpec;
    @JsonProperty("workImagePullSpec")
    private String workImagePullSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterManagerSpec() {
    }

    /**
     * 
     * @param nodePlacement
     * @param placementImagePullSpec
     * @param workImagePullSpec
     * @param registrationImagePullSpec
     */
    public ClusterManagerSpec(NodePlacement nodePlacement, String placementImagePullSpec, String registrationImagePullSpec, String workImagePullSpec) {
        super();
        this.nodePlacement = nodePlacement;
        this.placementImagePullSpec = placementImagePullSpec;
        this.registrationImagePullSpec = registrationImagePullSpec;
        this.workImagePullSpec = workImagePullSpec;
    }

    @JsonProperty("nodePlacement")
    public NodePlacement getNodePlacement() {
        return nodePlacement;
    }

    @JsonProperty("nodePlacement")
    public void setNodePlacement(NodePlacement nodePlacement) {
        this.nodePlacement = nodePlacement;
    }

    @JsonProperty("placementImagePullSpec")
    public String getPlacementImagePullSpec() {
        return placementImagePullSpec;
    }

    @JsonProperty("placementImagePullSpec")
    public void setPlacementImagePullSpec(String placementImagePullSpec) {
        this.placementImagePullSpec = placementImagePullSpec;
    }

    @JsonProperty("registrationImagePullSpec")
    public String getRegistrationImagePullSpec() {
        return registrationImagePullSpec;
    }

    @JsonProperty("registrationImagePullSpec")
    public void setRegistrationImagePullSpec(String registrationImagePullSpec) {
        this.registrationImagePullSpec = registrationImagePullSpec;
    }

    @JsonProperty("workImagePullSpec")
    public String getWorkImagePullSpec() {
        return workImagePullSpec;
    }

    @JsonProperty("workImagePullSpec")
    public void setWorkImagePullSpec(String workImagePullSpec) {
        this.workImagePullSpec = workImagePullSpec;
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
