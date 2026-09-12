
package io.fabric8.openclustermanagement.api.model.operator.v1;

import java.util.LinkedHashMap;
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
 * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addOnManagerConfiguration",
    "addOnManagerImagePullSpec",
    "deployOption",
    "nodePlacement",
    "placementConfiguration",
    "placementImagePullSpec",
    "registrationConfiguration",
    "registrationImagePullSpec",
    "resourceRequirement",
    "serverConfiguration",
    "workConfiguration",
    "workImagePullSpec"
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
public class ClusterManagerSpec implements Editable<ClusterManagerSpecBuilder>, KubernetesResource
{

    @JsonProperty("addOnManagerConfiguration")
    private AddOnManagerConfiguration addOnManagerConfiguration;
    @JsonProperty("addOnManagerImagePullSpec")
    private String addOnManagerImagePullSpec;
    @JsonProperty("deployOption")
    private ClusterManagerDeployOption deployOption;
    @JsonProperty("nodePlacement")
    private NodePlacement nodePlacement;
    @JsonProperty("placementConfiguration")
    private PlacementConfiguration placementConfiguration;
    @JsonProperty("placementImagePullSpec")
    private String placementImagePullSpec;
    @JsonProperty("registrationConfiguration")
    private RegistrationHubConfiguration registrationConfiguration;
    @JsonProperty("registrationImagePullSpec")
    private String registrationImagePullSpec;
    @JsonProperty("resourceRequirement")
    private ResourceRequirement resourceRequirement;
    @JsonProperty("serverConfiguration")
    private ServerConfiguration serverConfiguration;
    @JsonProperty("workConfiguration")
    private WorkConfiguration workConfiguration;
    @JsonProperty("workImagePullSpec")
    private String workImagePullSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterManagerSpec() {
    }

    public ClusterManagerSpec(AddOnManagerConfiguration addOnManagerConfiguration, String addOnManagerImagePullSpec, ClusterManagerDeployOption deployOption, NodePlacement nodePlacement, PlacementConfiguration placementConfiguration, String placementImagePullSpec, RegistrationHubConfiguration registrationConfiguration, String registrationImagePullSpec, ResourceRequirement resourceRequirement, ServerConfiguration serverConfiguration, WorkConfiguration workConfiguration, String workImagePullSpec) {
        super();
        this.addOnManagerConfiguration = addOnManagerConfiguration;
        this.addOnManagerImagePullSpec = addOnManagerImagePullSpec;
        this.deployOption = deployOption;
        this.nodePlacement = nodePlacement;
        this.placementConfiguration = placementConfiguration;
        this.placementImagePullSpec = placementImagePullSpec;
        this.registrationConfiguration = registrationConfiguration;
        this.registrationImagePullSpec = registrationImagePullSpec;
        this.resourceRequirement = resourceRequirement;
        this.serverConfiguration = serverConfiguration;
        this.workConfiguration = workConfiguration;
        this.workImagePullSpec = workImagePullSpec;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("addOnManagerConfiguration")
    public AddOnManagerConfiguration getAddOnManagerConfiguration() {
        return addOnManagerConfiguration;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("addOnManagerConfiguration")
    public void setAddOnManagerConfiguration(AddOnManagerConfiguration addOnManagerConfiguration) {
        this.addOnManagerConfiguration = addOnManagerConfiguration;
    }

    /**
     * addOnManagerImagePullSpec represents the desired image configuration of addon manager controller/webhook installed on hub.
     */
    @JsonProperty("addOnManagerImagePullSpec")
    public String getAddOnManagerImagePullSpec() {
        return addOnManagerImagePullSpec;
    }

    /**
     * addOnManagerImagePullSpec represents the desired image configuration of addon manager controller/webhook installed on hub.
     */
    @JsonProperty("addOnManagerImagePullSpec")
    public void setAddOnManagerImagePullSpec(String addOnManagerImagePullSpec) {
        this.addOnManagerImagePullSpec = addOnManagerImagePullSpec;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("deployOption")
    public ClusterManagerDeployOption getDeployOption() {
        return deployOption;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("deployOption")
    public void setDeployOption(ClusterManagerDeployOption deployOption) {
        this.deployOption = deployOption;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("nodePlacement")
    public NodePlacement getNodePlacement() {
        return nodePlacement;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("nodePlacement")
    public void setNodePlacement(NodePlacement nodePlacement) {
        this.nodePlacement = nodePlacement;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("placementConfiguration")
    public PlacementConfiguration getPlacementConfiguration() {
        return placementConfiguration;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("placementConfiguration")
    public void setPlacementConfiguration(PlacementConfiguration placementConfiguration) {
        this.placementConfiguration = placementConfiguration;
    }

    /**
     * placementImagePullSpec represents the desired image configuration of placement controller/webhook installed on hub.
     */
    @JsonProperty("placementImagePullSpec")
    public String getPlacementImagePullSpec() {
        return placementImagePullSpec;
    }

    /**
     * placementImagePullSpec represents the desired image configuration of placement controller/webhook installed on hub.
     */
    @JsonProperty("placementImagePullSpec")
    public void setPlacementImagePullSpec(String placementImagePullSpec) {
        this.placementImagePullSpec = placementImagePullSpec;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("registrationConfiguration")
    public RegistrationHubConfiguration getRegistrationConfiguration() {
        return registrationConfiguration;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("registrationConfiguration")
    public void setRegistrationConfiguration(RegistrationHubConfiguration registrationConfiguration) {
        this.registrationConfiguration = registrationConfiguration;
    }

    /**
     * registrationImagePullSpec represents the desired image of registration controller/webhook installed on hub.
     */
    @JsonProperty("registrationImagePullSpec")
    public String getRegistrationImagePullSpec() {
        return registrationImagePullSpec;
    }

    /**
     * registrationImagePullSpec represents the desired image of registration controller/webhook installed on hub.
     */
    @JsonProperty("registrationImagePullSpec")
    public void setRegistrationImagePullSpec(String registrationImagePullSpec) {
        this.registrationImagePullSpec = registrationImagePullSpec;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("resourceRequirement")
    public ResourceRequirement getResourceRequirement() {
        return resourceRequirement;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("resourceRequirement")
    public void setResourceRequirement(ResourceRequirement resourceRequirement) {
        this.resourceRequirement = resourceRequirement;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("serverConfiguration")
    public ServerConfiguration getServerConfiguration() {
        return serverConfiguration;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("serverConfiguration")
    public void setServerConfiguration(ServerConfiguration serverConfiguration) {
        this.serverConfiguration = serverConfiguration;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("workConfiguration")
    public WorkConfiguration getWorkConfiguration() {
        return workConfiguration;
    }

    /**
     * ClusterManagerSpec represents a desired deployment configuration of controllers that govern registration and work distribution for attached Klusterlets.
     */
    @JsonProperty("workConfiguration")
    public void setWorkConfiguration(WorkConfiguration workConfiguration) {
        this.workConfiguration = workConfiguration;
    }

    /**
     * workImagePullSpec represents the desired image configuration of work controller/webhook installed on hub.
     */
    @JsonProperty("workImagePullSpec")
    public String getWorkImagePullSpec() {
        return workImagePullSpec;
    }

    /**
     * workImagePullSpec represents the desired image configuration of work controller/webhook installed on hub.
     */
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
        if (!(o instanceof ClusterManagerSpec)) {
            return false;
        }
        ClusterManagerSpec other = (ClusterManagerSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$addOnManagerConfiguration = this.getAddOnManagerConfiguration();
        Object other$addOnManagerConfiguration = other.getAddOnManagerConfiguration();
        if (this$addOnManagerConfiguration == null ? other$addOnManagerConfiguration != null : !this$addOnManagerConfiguration.equals(other$addOnManagerConfiguration)) {
            return false;
        }
        Object this$addOnManagerImagePullSpec = this.getAddOnManagerImagePullSpec();
        Object other$addOnManagerImagePullSpec = other.getAddOnManagerImagePullSpec();
        if (this$addOnManagerImagePullSpec == null ? other$addOnManagerImagePullSpec != null : !this$addOnManagerImagePullSpec.equals(other$addOnManagerImagePullSpec)) {
            return false;
        }
        Object this$deployOption = this.getDeployOption();
        Object other$deployOption = other.getDeployOption();
        if (this$deployOption == null ? other$deployOption != null : !this$deployOption.equals(other$deployOption)) {
            return false;
        }
        Object this$nodePlacement = this.getNodePlacement();
        Object other$nodePlacement = other.getNodePlacement();
        if (this$nodePlacement == null ? other$nodePlacement != null : !this$nodePlacement.equals(other$nodePlacement)) {
            return false;
        }
        Object this$placementConfiguration = this.getPlacementConfiguration();
        Object other$placementConfiguration = other.getPlacementConfiguration();
        if (this$placementConfiguration == null ? other$placementConfiguration != null : !this$placementConfiguration.equals(other$placementConfiguration)) {
            return false;
        }
        Object this$placementImagePullSpec = this.getPlacementImagePullSpec();
        Object other$placementImagePullSpec = other.getPlacementImagePullSpec();
        if (this$placementImagePullSpec == null ? other$placementImagePullSpec != null : !this$placementImagePullSpec.equals(other$placementImagePullSpec)) {
            return false;
        }
        Object this$registrationConfiguration = this.getRegistrationConfiguration();
        Object other$registrationConfiguration = other.getRegistrationConfiguration();
        if (this$registrationConfiguration == null ? other$registrationConfiguration != null : !this$registrationConfiguration.equals(other$registrationConfiguration)) {
            return false;
        }
        Object this$registrationImagePullSpec = this.getRegistrationImagePullSpec();
        Object other$registrationImagePullSpec = other.getRegistrationImagePullSpec();
        if (this$registrationImagePullSpec == null ? other$registrationImagePullSpec != null : !this$registrationImagePullSpec.equals(other$registrationImagePullSpec)) {
            return false;
        }
        Object this$resourceRequirement = this.getResourceRequirement();
        Object other$resourceRequirement = other.getResourceRequirement();
        if (this$resourceRequirement == null ? other$resourceRequirement != null : !this$resourceRequirement.equals(other$resourceRequirement)) {
            return false;
        }
        Object this$serverConfiguration = this.getServerConfiguration();
        Object other$serverConfiguration = other.getServerConfiguration();
        if (this$serverConfiguration == null ? other$serverConfiguration != null : !this$serverConfiguration.equals(other$serverConfiguration)) {
            return false;
        }
        Object this$workConfiguration = this.getWorkConfiguration();
        Object other$workConfiguration = other.getWorkConfiguration();
        if (this$workConfiguration == null ? other$workConfiguration != null : !this$workConfiguration.equals(other$workConfiguration)) {
            return false;
        }
        Object this$workImagePullSpec = this.getWorkImagePullSpec();
        Object other$workImagePullSpec = other.getWorkImagePullSpec();
        if (this$workImagePullSpec == null ? other$workImagePullSpec != null : !this$workImagePullSpec.equals(other$workImagePullSpec)) {
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
        return other instanceof ClusterManagerSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $addOnManagerConfiguration = this.getAddOnManagerConfiguration();
        result = result * prime + ($addOnManagerConfiguration == null ? 43 : $addOnManagerConfiguration.hashCode());
        Object $addOnManagerImagePullSpec = this.getAddOnManagerImagePullSpec();
        result = result * prime + ($addOnManagerImagePullSpec == null ? 43 : $addOnManagerImagePullSpec.hashCode());
        Object $deployOption = this.getDeployOption();
        result = result * prime + ($deployOption == null ? 43 : $deployOption.hashCode());
        Object $nodePlacement = this.getNodePlacement();
        result = result * prime + ($nodePlacement == null ? 43 : $nodePlacement.hashCode());
        Object $placementConfiguration = this.getPlacementConfiguration();
        result = result * prime + ($placementConfiguration == null ? 43 : $placementConfiguration.hashCode());
        Object $placementImagePullSpec = this.getPlacementImagePullSpec();
        result = result * prime + ($placementImagePullSpec == null ? 43 : $placementImagePullSpec.hashCode());
        Object $registrationConfiguration = this.getRegistrationConfiguration();
        result = result * prime + ($registrationConfiguration == null ? 43 : $registrationConfiguration.hashCode());
        Object $registrationImagePullSpec = this.getRegistrationImagePullSpec();
        result = result * prime + ($registrationImagePullSpec == null ? 43 : $registrationImagePullSpec.hashCode());
        Object $resourceRequirement = this.getResourceRequirement();
        result = result * prime + ($resourceRequirement == null ? 43 : $resourceRequirement.hashCode());
        Object $serverConfiguration = this.getServerConfiguration();
        result = result * prime + ($serverConfiguration == null ? 43 : $serverConfiguration.hashCode());
        Object $workConfiguration = this.getWorkConfiguration();
        result = result * prime + ($workConfiguration == null ? 43 : $workConfiguration.hashCode());
        Object $workImagePullSpec = this.getWorkImagePullSpec();
        result = result * prime + ($workImagePullSpec == null ? 43 : $workImagePullSpec.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterManagerSpec(" + "addOnManagerConfiguration=" + this.getAddOnManagerConfiguration() + ", addOnManagerImagePullSpec=" + this.getAddOnManagerImagePullSpec() + ", deployOption=" + this.getDeployOption() + ", nodePlacement=" + this.getNodePlacement() + ", placementConfiguration=" + this.getPlacementConfiguration() + ", placementImagePullSpec=" + this.getPlacementImagePullSpec() + ", registrationConfiguration=" + this.getRegistrationConfiguration() + ", registrationImagePullSpec=" + this.getRegistrationImagePullSpec() + ", resourceRequirement=" + this.getResourceRequirement() + ", serverConfiguration=" + this.getServerConfiguration() + ", workConfiguration=" + this.getWorkConfiguration() + ", workImagePullSpec=" + this.getWorkImagePullSpec() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
