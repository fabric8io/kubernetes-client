
package io.fabric8.openclustermanagement.api.model.operator.v1;

import java.util.LinkedHashMap;
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
    "addOnManagerConfiguration",
    "addOnManagerImagePullSpec",
    "deployOption",
    "nodePlacement",
    "placementImagePullSpec",
    "registrationConfiguration",
    "registrationImagePullSpec",
    "resourceRequirement",
    "workConfiguration",
    "workImagePullSpec"
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
public class ClusterManagerSpec implements Editable<ClusterManagerSpecBuilder> , KubernetesResource
{

    @JsonProperty("addOnManagerConfiguration")
    private AddOnManagerConfiguration addOnManagerConfiguration;
    @JsonProperty("addOnManagerImagePullSpec")
    private String addOnManagerImagePullSpec;
    @JsonProperty("deployOption")
    private ClusterManagerDeployOption deployOption;
    @JsonProperty("nodePlacement")
    private NodePlacement nodePlacement;
    @JsonProperty("placementImagePullSpec")
    private String placementImagePullSpec;
    @JsonProperty("registrationConfiguration")
    private RegistrationHubConfiguration registrationConfiguration;
    @JsonProperty("registrationImagePullSpec")
    private String registrationImagePullSpec;
    @JsonProperty("resourceRequirement")
    private ResourceRequirement resourceRequirement;
    @JsonProperty("workConfiguration")
    private WorkConfiguration workConfiguration;
    @JsonProperty("workImagePullSpec")
    private String workImagePullSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterManagerSpec() {
    }

    public ClusterManagerSpec(AddOnManagerConfiguration addOnManagerConfiguration, String addOnManagerImagePullSpec, ClusterManagerDeployOption deployOption, NodePlacement nodePlacement, String placementImagePullSpec, RegistrationHubConfiguration registrationConfiguration, String registrationImagePullSpec, ResourceRequirement resourceRequirement, WorkConfiguration workConfiguration, String workImagePullSpec) {
        super();
        this.addOnManagerConfiguration = addOnManagerConfiguration;
        this.addOnManagerImagePullSpec = addOnManagerImagePullSpec;
        this.deployOption = deployOption;
        this.nodePlacement = nodePlacement;
        this.placementImagePullSpec = placementImagePullSpec;
        this.registrationConfiguration = registrationConfiguration;
        this.registrationImagePullSpec = registrationImagePullSpec;
        this.resourceRequirement = resourceRequirement;
        this.workConfiguration = workConfiguration;
        this.workImagePullSpec = workImagePullSpec;
    }

    @JsonProperty("addOnManagerConfiguration")
    public AddOnManagerConfiguration getAddOnManagerConfiguration() {
        return addOnManagerConfiguration;
    }

    @JsonProperty("addOnManagerConfiguration")
    public void setAddOnManagerConfiguration(AddOnManagerConfiguration addOnManagerConfiguration) {
        this.addOnManagerConfiguration = addOnManagerConfiguration;
    }

    @JsonProperty("addOnManagerImagePullSpec")
    public String getAddOnManagerImagePullSpec() {
        return addOnManagerImagePullSpec;
    }

    @JsonProperty("addOnManagerImagePullSpec")
    public void setAddOnManagerImagePullSpec(String addOnManagerImagePullSpec) {
        this.addOnManagerImagePullSpec = addOnManagerImagePullSpec;
    }

    @JsonProperty("deployOption")
    public ClusterManagerDeployOption getDeployOption() {
        return deployOption;
    }

    @JsonProperty("deployOption")
    public void setDeployOption(ClusterManagerDeployOption deployOption) {
        this.deployOption = deployOption;
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

    @JsonProperty("registrationConfiguration")
    public RegistrationHubConfiguration getRegistrationConfiguration() {
        return registrationConfiguration;
    }

    @JsonProperty("registrationConfiguration")
    public void setRegistrationConfiguration(RegistrationHubConfiguration registrationConfiguration) {
        this.registrationConfiguration = registrationConfiguration;
    }

    @JsonProperty("registrationImagePullSpec")
    public String getRegistrationImagePullSpec() {
        return registrationImagePullSpec;
    }

    @JsonProperty("registrationImagePullSpec")
    public void setRegistrationImagePullSpec(String registrationImagePullSpec) {
        this.registrationImagePullSpec = registrationImagePullSpec;
    }

    @JsonProperty("resourceRequirement")
    public ResourceRequirement getResourceRequirement() {
        return resourceRequirement;
    }

    @JsonProperty("resourceRequirement")
    public void setResourceRequirement(ResourceRequirement resourceRequirement) {
        this.resourceRequirement = resourceRequirement;
    }

    @JsonProperty("workConfiguration")
    public WorkConfiguration getWorkConfiguration() {
        return workConfiguration;
    }

    @JsonProperty("workConfiguration")
    public void setWorkConfiguration(WorkConfiguration workConfiguration) {
        this.workConfiguration = workConfiguration;
    }

    @JsonProperty("workImagePullSpec")
    public String getWorkImagePullSpec() {
        return workImagePullSpec;
    }

    @JsonProperty("workImagePullSpec")
    public void setWorkImagePullSpec(String workImagePullSpec) {
        this.workImagePullSpec = workImagePullSpec;
    }

    @JsonIgnore
    public ClusterManagerSpecBuilder edit() {
        return new ClusterManagerSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterManagerSpecBuilder toBuilder() {
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
