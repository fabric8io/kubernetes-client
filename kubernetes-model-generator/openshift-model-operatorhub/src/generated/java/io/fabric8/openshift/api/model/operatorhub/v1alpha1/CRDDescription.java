
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
 * CRDDescription provides details to OLM about the CRDs
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "actionDescriptors",
    "description",
    "displayName",
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
public class CRDDescription implements Editable<CRDDescriptionBuilder>, KubernetesResource
{

    @JsonProperty("actionDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ActionDescriptor> actionDescriptors = new ArrayList<>();
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
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
    public CRDDescription() {
    }

    public CRDDescription(List<ActionDescriptor> actionDescriptors, String description, String displayName, String kind, String name, List<APIResourceReference> resources, List<SpecDescriptor> specDescriptors, List<StatusDescriptor> statusDescriptors, String version) {
        super();
        this.actionDescriptors = actionDescriptors;
        this.description = description;
        this.displayName = displayName;
        this.kind = kind;
        this.name = name;
        this.resources = resources;
        this.specDescriptors = specDescriptors;
        this.statusDescriptors = statusDescriptors;
        this.version = version;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("actionDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ActionDescriptor> getActionDescriptors() {
        return actionDescriptors;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("actionDescriptors")
    public void setActionDescriptors(List<ActionDescriptor> actionDescriptors) {
        this.actionDescriptors = actionDescriptors;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<APIResourceReference> getResources() {
        return resources;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("resources")
    public void setResources(List<APIResourceReference> resources) {
        this.resources = resources;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("specDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SpecDescriptor> getSpecDescriptors() {
        return specDescriptors;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("specDescriptors")
    public void setSpecDescriptors(List<SpecDescriptor> specDescriptors) {
        this.specDescriptors = specDescriptors;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("statusDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StatusDescriptor> getStatusDescriptors() {
        return statusDescriptors;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("statusDescriptors")
    public void setStatusDescriptors(List<StatusDescriptor> statusDescriptors) {
        this.statusDescriptors = statusDescriptors;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * CRDDescription provides details to OLM about the CRDs
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public CRDDescriptionBuilder edit() {
        return new CRDDescriptionBuilder(this);
    }

    @JsonIgnore
    public CRDDescriptionBuilder toBuilder() {
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
        if (!(o instanceof CRDDescription)) {
            return false;
        }
        CRDDescription other = (CRDDescription) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$actionDescriptors = this.getActionDescriptors();
        Object other$actionDescriptors = other.getActionDescriptors();
        if (this$actionDescriptors == null ? other$actionDescriptors != null : !this$actionDescriptors.equals(other$actionDescriptors)) {
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
        return other instanceof CRDDescription;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $actionDescriptors = this.getActionDescriptors();
        result = result * prime + ($actionDescriptors == null ? 43 : $actionDescriptors.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $displayName = this.getDisplayName();
        result = result * prime + ($displayName == null ? 43 : $displayName.hashCode());
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
        return "CRDDescription(" + "actionDescriptors=" + this.getActionDescriptors() + ", description=" + this.getDescription() + ", displayName=" + this.getDisplayName() + ", kind=" + this.getKind() + ", name=" + this.getName() + ", resources=" + this.getResources() + ", specDescriptors=" + this.getSpecDescriptors() + ", statusDescriptors=" + this.getStatusDescriptors() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
