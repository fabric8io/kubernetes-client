
package io.fabric8.kubernetes.api.model.apiextensions.v1;

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
 * CustomResourceDefinitionStatus indicates the state of the CustomResourceDefinition
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acceptedNames",
    "conditions",
    "observedGeneration",
    "storedVersions"
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
public class CustomResourceDefinitionStatus implements Editable<CustomResourceDefinitionStatusBuilder>, KubernetesResource
{

    @JsonProperty("acceptedNames")
    private CustomResourceDefinitionNames acceptedNames;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CustomResourceDefinitionCondition> conditions = new ArrayList<>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("storedVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> storedVersions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CustomResourceDefinitionStatus() {
    }

    public CustomResourceDefinitionStatus(CustomResourceDefinitionNames acceptedNames, List<CustomResourceDefinitionCondition> conditions, Long observedGeneration, List<String> storedVersions) {
        super();
        this.acceptedNames = acceptedNames;
        this.conditions = conditions;
        this.observedGeneration = observedGeneration;
        this.storedVersions = storedVersions;
    }

    /**
     * CustomResourceDefinitionStatus indicates the state of the CustomResourceDefinition
     */
    @JsonProperty("acceptedNames")
    public CustomResourceDefinitionNames getAcceptedNames() {
        return acceptedNames;
    }

    /**
     * CustomResourceDefinitionStatus indicates the state of the CustomResourceDefinition
     */
    @JsonProperty("acceptedNames")
    public void setAcceptedNames(CustomResourceDefinitionNames acceptedNames) {
        this.acceptedNames = acceptedNames;
    }

    /**
     * conditions indicate state for particular aspects of a CustomResourceDefinition
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CustomResourceDefinitionCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions indicate state for particular aspects of a CustomResourceDefinition
     */
    @JsonProperty("conditions")
    public void setConditions(List<CustomResourceDefinitionCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * The generation observed by the CRD controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * The generation observed by the CRD controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * storedVersions lists all versions of CustomResources that were ever persisted. Tracking these versions allows a migration path for stored versions in etcd. The field is mutable so a migration controller can finish a migration to another version (ensuring no old objects are left in storage), and then remove the rest of the versions from this list. Versions may not be removed from `spec.versions` while they exist in this list.
     */
    @JsonProperty("storedVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getStoredVersions() {
        return storedVersions;
    }

    /**
     * storedVersions lists all versions of CustomResources that were ever persisted. Tracking these versions allows a migration path for stored versions in etcd. The field is mutable so a migration controller can finish a migration to another version (ensuring no old objects are left in storage), and then remove the rest of the versions from this list. Versions may not be removed from `spec.versions` while they exist in this list.
     */
    @JsonProperty("storedVersions")
    public void setStoredVersions(List<String> storedVersions) {
        this.storedVersions = storedVersions;
    }

    @JsonIgnore
    public CustomResourceDefinitionStatusBuilder edit() {
        return new CustomResourceDefinitionStatusBuilder(this);
    }

    @JsonIgnore
    public CustomResourceDefinitionStatusBuilder toBuilder() {
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
        if (!(o instanceof CustomResourceDefinitionStatus)) {
            return false;
        }
        CustomResourceDefinitionStatus other = (CustomResourceDefinitionStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$acceptedNames = this.getAcceptedNames();
        Object other$acceptedNames = other.getAcceptedNames();
        if (this$acceptedNames == null ? other$acceptedNames != null : !this$acceptedNames.equals(other$acceptedNames)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$storedVersions = this.getStoredVersions();
        Object other$storedVersions = other.getStoredVersions();
        if (this$storedVersions == null ? other$storedVersions != null : !this$storedVersions.equals(other$storedVersions)) {
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
        return other instanceof CustomResourceDefinitionStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $acceptedNames = this.getAcceptedNames();
        result = result * prime + ($acceptedNames == null ? 43 : $acceptedNames.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $storedVersions = this.getStoredVersions();
        result = result * prime + ($storedVersions == null ? 43 : $storedVersions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CustomResourceDefinitionStatus(" + "acceptedNames=" + this.getAcceptedNames() + ", conditions=" + this.getConditions() + ", observedGeneration=" + this.getObservedGeneration() + ", storedVersions=" + this.getStoredVersions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
