
package io.fabric8.openshift.api.model.operator.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "nodeDisruptionPolicyStatus",
    "observedGeneration"
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class MachineConfigurationStatus implements Editable<MachineConfigurationStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
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

    public MachineConfigurationStatus(List<Condition> conditions, NodeDisruptionPolicyStatus nodeDisruptionPolicyStatus, Long observedGeneration) {
        super();
        this.conditions = conditions;
        this.nodeDisruptionPolicyStatus = nodeDisruptionPolicyStatus;
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("nodeDisruptionPolicyStatus")
    public NodeDisruptionPolicyStatus getNodeDisruptionPolicyStatus() {
        return nodeDisruptionPolicyStatus;
    }

    @JsonProperty("nodeDisruptionPolicyStatus")
    public void setNodeDisruptionPolicyStatus(NodeDisruptionPolicyStatus nodeDisruptionPolicyStatus) {
        this.nodeDisruptionPolicyStatus = nodeDisruptionPolicyStatus;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

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
