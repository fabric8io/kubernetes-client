
package io.fabric8.openshift.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.Condition;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "managedBootImagesStatus",
    "nodeDisruptionPolicyStatus",
    "observedGeneration"
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
public class MachineConfigurationStatus implements Editable<MachineConfigurationStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("managedBootImagesStatus")
    private ManagedBootImages managedBootImagesStatus;
    @JsonProperty("nodeDisruptionPolicyStatus")
    private NodeDisruptionPolicyStatus nodeDisruptionPolicyStatus;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineConfigurationStatus() {
    }

    public MachineConfigurationStatus(List<Condition> conditions, ManagedBootImages managedBootImagesStatus, NodeDisruptionPolicyStatus nodeDisruptionPolicyStatus, Long observedGeneration) {
        super();
        this.conditions = conditions;
        this.managedBootImagesStatus = managedBootImagesStatus;
        this.nodeDisruptionPolicyStatus = nodeDisruptionPolicyStatus;
        this.observedGeneration = observedGeneration;
    }

    /**
     * conditions is a list of conditions and their status
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions is a list of conditions and their status
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("managedBootImagesStatus")
    public ManagedBootImages getManagedBootImagesStatus() {
        return managedBootImagesStatus;
    }

    @JsonProperty("managedBootImagesStatus")
    public void setManagedBootImagesStatus(ManagedBootImages managedBootImagesStatus) {
        this.managedBootImagesStatus = managedBootImagesStatus;
    }

    @JsonProperty("nodeDisruptionPolicyStatus")
    public NodeDisruptionPolicyStatus getNodeDisruptionPolicyStatus() {
        return nodeDisruptionPolicyStatus;
    }

    @JsonProperty("nodeDisruptionPolicyStatus")
    public void setNodeDisruptionPolicyStatus(NodeDisruptionPolicyStatus nodeDisruptionPolicyStatus) {
        this.nodeDisruptionPolicyStatus = nodeDisruptionPolicyStatus;
    }

    /**
     * observedGeneration is the last generation change you've dealt with
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration is the last generation change you've dealt with
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonIgnore
    public MachineConfigurationStatusBuilder edit() {
        return new MachineConfigurationStatusBuilder(this);
    }

    @JsonIgnore
    public MachineConfigurationStatusBuilder toBuilder() {
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
        if (!(o instanceof MachineConfigurationStatus)) {
            return false;
        }
        MachineConfigurationStatus other = (MachineConfigurationStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$managedBootImagesStatus = this.getManagedBootImagesStatus();
        Object other$managedBootImagesStatus = other.getManagedBootImagesStatus();
        if (this$managedBootImagesStatus == null ? other$managedBootImagesStatus != null : !this$managedBootImagesStatus.equals(other$managedBootImagesStatus)) {
            return false;
        }
        Object this$nodeDisruptionPolicyStatus = this.getNodeDisruptionPolicyStatus();
        Object other$nodeDisruptionPolicyStatus = other.getNodeDisruptionPolicyStatus();
        if (this$nodeDisruptionPolicyStatus == null ? other$nodeDisruptionPolicyStatus != null : !this$nodeDisruptionPolicyStatus.equals(other$nodeDisruptionPolicyStatus)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
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
        return other instanceof MachineConfigurationStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $managedBootImagesStatus = this.getManagedBootImagesStatus();
        result = result * prime + ($managedBootImagesStatus == null ? 43 : $managedBootImagesStatus.hashCode());
        Object $nodeDisruptionPolicyStatus = this.getNodeDisruptionPolicyStatus();
        result = result * prime + ($nodeDisruptionPolicyStatus == null ? 43 : $nodeDisruptionPolicyStatus.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineConfigurationStatus(" + "conditions=" + this.getConditions() + ", managedBootImagesStatus=" + this.getManagedBootImagesStatus() + ", nodeDisruptionPolicyStatus=" + this.getNodeDisruptionPolicyStatus() + ", observedGeneration=" + this.getObservedGeneration() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
