
package io.fabric8.openshift.api.model.hive.v1;

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
 * SyncSetObjectStatus describes the status of resources created or patches that have been applied from a SyncSet or SelectorSyncSet.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "name",
    "patches",
    "resourceApplyMode",
    "resources",
    "secrets"
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
public class SyncSetObjectStatus implements Editable<SyncSetObjectStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SyncCondition> conditions = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("patches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SyncStatus> patches = new ArrayList<>();
    @JsonProperty("resourceApplyMode")
    private String resourceApplyMode;
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SyncStatus> resources = new ArrayList<>();
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SyncStatus> secrets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SyncSetObjectStatus() {
    }

    public SyncSetObjectStatus(List<SyncCondition> conditions, String name, List<SyncStatus> patches, String resourceApplyMode, List<SyncStatus> resources, List<SyncStatus> secrets) {
        super();
        this.conditions = conditions;
        this.name = name;
        this.patches = patches;
        this.resourceApplyMode = resourceApplyMode;
        this.resources = resources;
        this.secrets = secrets;
    }

    /**
     * Conditions is the list of SyncConditions used to indicate UnknownObject when a resource type cannot be determined from a SyncSet resource.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SyncCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions is the list of SyncConditions used to indicate UnknownObject when a resource type cannot be determined from a SyncSet resource.
     */
    @JsonProperty("conditions")
    public void setConditions(List<SyncCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Name is the name of the SyncSet.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the SyncSet.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Patches is the list of SyncStatus for patches that have been applied.
     */
    @JsonProperty("patches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SyncStatus> getPatches() {
        return patches;
    }

    /**
     * Patches is the list of SyncStatus for patches that have been applied.
     */
    @JsonProperty("patches")
    public void setPatches(List<SyncStatus> patches) {
        this.patches = patches;
    }

    /**
     * ResourceApplyMode indicates if the Resource apply mode is "Upsert" (default) or "Sync". ApplyMode "Upsert" indicates create and update. ApplyMode "Sync" indicates create, update and delete.
     */
    @JsonProperty("resourceApplyMode")
    public String getResourceApplyMode() {
        return resourceApplyMode;
    }

    /**
     * ResourceApplyMode indicates if the Resource apply mode is "Upsert" (default) or "Sync". ApplyMode "Upsert" indicates create and update. ApplyMode "Sync" indicates create, update and delete.
     */
    @JsonProperty("resourceApplyMode")
    public void setResourceApplyMode(String resourceApplyMode) {
        this.resourceApplyMode = resourceApplyMode;
    }

    /**
     * Resources is the list of SyncStatus for objects that have been synced.
     */
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SyncStatus> getResources() {
        return resources;
    }

    /**
     * Resources is the list of SyncStatus for objects that have been synced.
     */
    @JsonProperty("resources")
    public void setResources(List<SyncStatus> resources) {
        this.resources = resources;
    }

    /**
     * Secrets is the list of SyncStatus for secrets that have been synced.
     */
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SyncStatus> getSecrets() {
        return secrets;
    }

    /**
     * Secrets is the list of SyncStatus for secrets that have been synced.
     */
    @JsonProperty("secrets")
    public void setSecrets(List<SyncStatus> secrets) {
        this.secrets = secrets;
    }

    @JsonIgnore
    public SyncSetObjectStatusBuilder edit() {
        return new SyncSetObjectStatusBuilder(this);
    }

    @JsonIgnore
    public SyncSetObjectStatusBuilder toBuilder() {
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
        if (!(o instanceof SyncSetObjectStatus)) {
            return false;
        }
        SyncSetObjectStatus other = (SyncSetObjectStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$patches = this.getPatches();
        Object other$patches = other.getPatches();
        if (this$patches == null ? other$patches != null : !this$patches.equals(other$patches)) {
            return false;
        }
        Object this$resourceApplyMode = this.getResourceApplyMode();
        Object other$resourceApplyMode = other.getResourceApplyMode();
        if (this$resourceApplyMode == null ? other$resourceApplyMode != null : !this$resourceApplyMode.equals(other$resourceApplyMode)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$secrets = this.getSecrets();
        Object other$secrets = other.getSecrets();
        if (this$secrets == null ? other$secrets != null : !this$secrets.equals(other$secrets)) {
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
        return other instanceof SyncSetObjectStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $patches = this.getPatches();
        result = result * prime + ($patches == null ? 43 : $patches.hashCode());
        Object $resourceApplyMode = this.getResourceApplyMode();
        result = result * prime + ($resourceApplyMode == null ? 43 : $resourceApplyMode.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $secrets = this.getSecrets();
        result = result * prime + ($secrets == null ? 43 : $secrets.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SyncSetObjectStatus(" + "conditions=" + this.getConditions() + ", name=" + this.getName() + ", patches=" + this.getPatches() + ", resourceApplyMode=" + this.getResourceApplyMode() + ", resources=" + this.getResources() + ", secrets=" + this.getSecrets() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
