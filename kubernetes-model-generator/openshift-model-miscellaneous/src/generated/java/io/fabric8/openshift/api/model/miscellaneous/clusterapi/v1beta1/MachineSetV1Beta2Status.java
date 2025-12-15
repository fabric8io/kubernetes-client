
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

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

/**
 * MachineSetV1Beta2Status groups all the fields that will be added or modified in MachineSetStatus with the V1Beta2 version. See https://github.com/kubernetes-sigs/cluster-api/blob/main/docs/proposals/20240916-improve-status-in-CAPI-resources.md for more context.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availableReplicas",
    "conditions",
    "readyReplicas",
    "upToDateReplicas"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class MachineSetV1Beta2Status implements Editable<MachineSetV1Beta2StatusBuilder>, KubernetesResource
{

    @JsonProperty("availableReplicas")
    private Integer availableReplicas;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("readyReplicas")
    private Integer readyReplicas;
    @JsonProperty("upToDateReplicas")
    private Integer upToDateReplicas;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineSetV1Beta2Status() {
    }

    public MachineSetV1Beta2Status(Integer availableReplicas, List<Condition> conditions, Integer readyReplicas, Integer upToDateReplicas) {
        super();
        this.availableReplicas = availableReplicas;
        this.conditions = conditions;
        this.readyReplicas = readyReplicas;
        this.upToDateReplicas = upToDateReplicas;
    }

    /**
     * availableReplicas is the number of available replicas for this MachineSet. A machine is considered available when Machine's Available condition is true.
     */
    @JsonProperty("availableReplicas")
    public Integer getAvailableReplicas() {
        return availableReplicas;
    }

    /**
     * availableReplicas is the number of available replicas for this MachineSet. A machine is considered available when Machine's Available condition is true.
     */
    @JsonProperty("availableReplicas")
    public void setAvailableReplicas(Integer availableReplicas) {
        this.availableReplicas = availableReplicas;
    }

    /**
     * conditions represents the observations of a MachineSet's current state. Known condition types are MachinesReady, MachinesUpToDate, ScalingUp, ScalingDown, Remediating, Deleting, Paused.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions represents the observations of a MachineSet's current state. Known condition types are MachinesReady, MachinesUpToDate, ScalingUp, ScalingDown, Remediating, Deleting, Paused.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * readyReplicas is the number of ready replicas for this MachineSet. A machine is considered ready when Machine's Ready condition is true.
     */
    @JsonProperty("readyReplicas")
    public Integer getReadyReplicas() {
        return readyReplicas;
    }

    /**
     * readyReplicas is the number of ready replicas for this MachineSet. A machine is considered ready when Machine's Ready condition is true.
     */
    @JsonProperty("readyReplicas")
    public void setReadyReplicas(Integer readyReplicas) {
        this.readyReplicas = readyReplicas;
    }

    /**
     * upToDateReplicas is the number of up-to-date replicas for this MachineSet. A machine is considered up-to-date when Machine's UpToDate condition is true.
     */
    @JsonProperty("upToDateReplicas")
    public Integer getUpToDateReplicas() {
        return upToDateReplicas;
    }

    /**
     * upToDateReplicas is the number of up-to-date replicas for this MachineSet. A machine is considered up-to-date when Machine's UpToDate condition is true.
     */
    @JsonProperty("upToDateReplicas")
    public void setUpToDateReplicas(Integer upToDateReplicas) {
        this.upToDateReplicas = upToDateReplicas;
    }

    @JsonIgnore
    public MachineSetV1Beta2StatusBuilder edit() {
        return new MachineSetV1Beta2StatusBuilder(this);
    }

    @JsonIgnore
    public MachineSetV1Beta2StatusBuilder toBuilder() {
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

}
