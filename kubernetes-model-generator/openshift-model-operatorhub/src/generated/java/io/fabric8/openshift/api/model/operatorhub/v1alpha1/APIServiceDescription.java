
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
 * APIServiceDescription provides details to OLM about apis provided via aggregation
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "actionDescriptors",
    "containerPort",
    "deploymentName",
    "description",
    "displayName",
    "group",
    "name",
    "resources",
    "specDescriptors",
    "statusDescriptors",
    "version"
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
public class APIServiceDescription implements Editable<APIServiceDescriptionBuilder>, KubernetesResource
{

    @JsonProperty("actionDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ActionDescriptor> actionDescriptors = new ArrayList<>();
    @JsonProperty("containerPort")
    private Integer containerPort;
    @JsonProperty("deploymentName")
    private String deploymentName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("group")
    private String group;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("name")
    private String name;
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<APIResourceReference> resources = new ArrayList<>();
    @JsonProperty("specDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SpecDescriptor> specDescriptors = new ArrayList<>();
    @JsonProperty("statusDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StatusDescriptor> statusDescriptors = new ArrayList<>();
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public APIServiceDescription() {
    }

    public APIServiceDescription(List<ActionDescriptor> actionDescriptors, Integer containerPort, String deploymentName, String description, String displayName, String group, String kind, String name, List<APIResourceReference> resources, List<SpecDescriptor> specDescriptors, List<StatusDescriptor> statusDescriptors, String version) {
        super();
        this.actionDescriptors = actionDescriptors;
        this.containerPort = containerPort;
        this.deploymentName = deploymentName;
        this.description = description;
        this.displayName = displayName;
        this.group = group;
        this.kind = kind;
        this.name = name;
        this.resources = resources;
        this.specDescriptors = specDescriptors;
        this.statusDescriptors = statusDescriptors;
        this.version = version;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("actionDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ActionDescriptor> getActionDescriptors() {
        return actionDescriptors;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("actionDescriptors")
    public void setActionDescriptors(List<ActionDescriptor> actionDescriptors) {
        this.actionDescriptors = actionDescriptors;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("containerPort")
    public Integer getContainerPort() {
        return containerPort;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("containerPort")
    public void setContainerPort(Integer containerPort) {
        this.containerPort = containerPort;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("deploymentName")
    public String getDeploymentName() {
        return deploymentName;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("deploymentName")
    public void setDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<APIResourceReference> getResources() {
        return resources;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("resources")
    public void setResources(List<APIResourceReference> resources) {
        this.resources = resources;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("specDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SpecDescriptor> getSpecDescriptors() {
        return specDescriptors;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("specDescriptors")
    public void setSpecDescriptors(List<SpecDescriptor> specDescriptors) {
        this.specDescriptors = specDescriptors;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("statusDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StatusDescriptor> getStatusDescriptors() {
        return statusDescriptors;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("statusDescriptors")
    public void setStatusDescriptors(List<StatusDescriptor> statusDescriptors) {
        this.statusDescriptors = statusDescriptors;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * APIServiceDescription provides details to OLM about apis provided via aggregation
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public APIServiceDescriptionBuilder edit() {
        return new APIServiceDescriptionBuilder(this);
    }

    @JsonIgnore
    public APIServiceDescriptionBuilder toBuilder() {
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
        if (!(o instanceof APIServiceDescription)) {
            return false;
        }
        APIServiceDescription other = (APIServiceDescription) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$actionDescriptors = this.getActionDescriptors();
        Object other$actionDescriptors = other.getActionDescriptors();
        if (this$actionDescriptors == null ? other$actionDescriptors != null : !this$actionDescriptors.equals(other$actionDescriptors)) {
            return false;
        }
        Object this$containerPort = this.getContainerPort();
        Object other$containerPort = other.getContainerPort();
        if (this$containerPort == null ? other$containerPort != null : !this$containerPort.equals(other$containerPort)) {
            return false;
        }
        Object this$deploymentName = this.getDeploymentName();
        Object other$deploymentName = other.getDeploymentName();
        if (this$deploymentName == null ? other$deploymentName != null : !this$deploymentName.equals(other$deploymentName)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$displayName = this.getDisplayName();
        Object other$displayName = other.getDisplayName();
        if (this$displayName == null ? other$displayName != null : !this$displayName.equals(other$displayName)) {
            return false;
        }
        Object this$group = this.getGroup();
        Object other$group = other.getGroup();
        if (this$group == null ? other$group != null : !this$group.equals(other$group)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$specDescriptors = this.getSpecDescriptors();
        Object other$specDescriptors = other.getSpecDescriptors();
        if (this$specDescriptors == null ? other$specDescriptors != null : !this$specDescriptors.equals(other$specDescriptors)) {
            return false;
        }
        Object this$statusDescriptors = this.getStatusDescriptors();
        Object other$statusDescriptors = other.getStatusDescriptors();
        if (this$statusDescriptors == null ? other$statusDescriptors != null : !this$statusDescriptors.equals(other$statusDescriptors)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        return other instanceof APIServiceDescription;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $actionDescriptors = this.getActionDescriptors();
        result = result * prime + ($actionDescriptors == null ? 43 : $actionDescriptors.hashCode());
        Object $containerPort = this.getContainerPort();
        result = result * prime + ($containerPort == null ? 43 : $containerPort.hashCode());
        Object $deploymentName = this.getDeploymentName();
        result = result * prime + ($deploymentName == null ? 43 : $deploymentName.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $displayName = this.getDisplayName();
        result = result * prime + ($displayName == null ? 43 : $displayName.hashCode());
        Object $group = this.getGroup();
        result = result * prime + ($group == null ? 43 : $group.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $specDescriptors = this.getSpecDescriptors();
        result = result * prime + ($specDescriptors == null ? 43 : $specDescriptors.hashCode());
        Object $statusDescriptors = this.getStatusDescriptors();
        result = result * prime + ($statusDescriptors == null ? 43 : $statusDescriptors.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "APIServiceDescription(" + "actionDescriptors=" + this.getActionDescriptors() + ", containerPort=" + this.getContainerPort() + ", deploymentName=" + this.getDeploymentName() + ", description=" + this.getDescription() + ", displayName=" + this.getDisplayName() + ", group=" + this.getGroup() + ", kind=" + this.getKind() + ", name=" + this.getName() + ", resources=" + this.getResources() + ", specDescriptors=" + this.getSpecDescriptors() + ", statusDescriptors=" + this.getStatusDescriptors() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
