
package io.fabric8.openshift.api.model.installer.ovirt.v1;

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
 * AffinityGroup defines the affinity group that the installer will create
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "enforcing",
    "name",
    "priority"
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
public class AffinityGroup implements Editable<AffinityGroupBuilder>, KubernetesResource
{

    @JsonProperty("description")
    private String description;
    @JsonProperty("enforcing")
    private Boolean enforcing;
    @JsonProperty("name")
    private String name;
    @JsonProperty("priority")
    private Integer priority;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AffinityGroup() {
    }

    public AffinityGroup(String description, Boolean enforcing, String name, Integer priority) {
        super();
        this.description = description;
        this.enforcing = enforcing;
        this.name = name;
        this.priority = priority;
    }

    /**
     * Description of the affinity group
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Description of the affinity group
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Enforcing whether to create a hard affinity rule, default is false
     */
    @JsonProperty("enforcing")
    public Boolean getEnforcing() {
        return enforcing;
    }

    /**
     * Enforcing whether to create a hard affinity rule, default is false
     */
    @JsonProperty("enforcing")
    public void setEnforcing(Boolean enforcing) {
        this.enforcing = enforcing;
    }

    /**
     * Name name of the affinity group
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name name of the affinity group
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Priority of the affinity group, needs to be between 1 (lowest) - 5 (highest)
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * Priority of the affinity group, needs to be between 1 (lowest) - 5 (highest)
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @JsonIgnore
    public AffinityGroupBuilder edit() {
        return new AffinityGroupBuilder(this);
    }

    @JsonIgnore
    public AffinityGroupBuilder toBuilder() {
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
        if (!(o instanceof AffinityGroup)) {
            return false;
        }
        AffinityGroup other = (AffinityGroup) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$enforcing = this.getEnforcing();
        Object other$enforcing = other.getEnforcing();
        if (this$enforcing == null ? other$enforcing != null : !this$enforcing.equals(other$enforcing)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$priority = this.getPriority();
        Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) {
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
        return other instanceof AffinityGroup;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $enforcing = this.getEnforcing();
        result = result * prime + ($enforcing == null ? 43 : $enforcing.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $priority = this.getPriority();
        result = result * prime + ($priority == null ? 43 : $priority.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AffinityGroup(" + "description=" + this.getDescription() + ", enforcing=" + this.getEnforcing() + ", name=" + this.getName() + ", priority=" + this.getPriority() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
