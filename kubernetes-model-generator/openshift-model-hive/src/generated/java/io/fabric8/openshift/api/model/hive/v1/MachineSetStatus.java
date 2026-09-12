
package io.fabric8.openshift.api.model.hive.v1;

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
 * MachineSetStatus is the status of a machineset in the remote cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "errorMessage",
    "errorReason",
    "maxReplicas",
    "minReplicas",
    "name",
    "readyReplicas",
    "replicas"
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
public class MachineSetStatus implements Editable<MachineSetStatusBuilder>, KubernetesResource
{

    @JsonProperty("errorMessage")
    private String errorMessage;
    @JsonProperty("errorReason")
    private String errorReason;
    @JsonProperty("maxReplicas")
    private Integer maxReplicas;
    @JsonProperty("minReplicas")
    private Integer minReplicas;
    @JsonProperty("name")
    private String name;
    @JsonProperty("readyReplicas")
    private Integer readyReplicas;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineSetStatus() {
    }

    public MachineSetStatus(String errorMessage, String errorReason, Integer maxReplicas, Integer minReplicas, String name, Integer readyReplicas, Integer replicas) {
        super();
        this.errorMessage = errorMessage;
        this.errorReason = errorReason;
        this.maxReplicas = maxReplicas;
        this.minReplicas = minReplicas;
        this.name = name;
        this.readyReplicas = readyReplicas;
        this.replicas = replicas;
    }

    /**
     * MachineSetStatus is the status of a machineset in the remote cluster.
     */
    @JsonProperty("errorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * MachineSetStatus is the status of a machineset in the remote cluster.
     */
    @JsonProperty("errorMessage")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * In the event that there is a terminal problem reconciling the replicas, both ErrorReason and ErrorMessage will be set. ErrorReason will be populated with a succinct value suitable for machine interpretation, while ErrorMessage will contain a more verbose string suitable for logging and human consumption.
     */
    @JsonProperty("errorReason")
    public String getErrorReason() {
        return errorReason;
    }

    /**
     * In the event that there is a terminal problem reconciling the replicas, both ErrorReason and ErrorMessage will be set. ErrorReason will be populated with a succinct value suitable for machine interpretation, while ErrorMessage will contain a more verbose string suitable for logging and human consumption.
     */
    @JsonProperty("errorReason")
    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    /**
     * MaxReplicas is the maximum number of replicas for the machine set.
     */
    @JsonProperty("maxReplicas")
    public Integer getMaxReplicas() {
        return maxReplicas;
    }

    /**
     * MaxReplicas is the maximum number of replicas for the machine set.
     */
    @JsonProperty("maxReplicas")
    public void setMaxReplicas(Integer maxReplicas) {
        this.maxReplicas = maxReplicas;
    }

    /**
     * MinReplicas is the minimum number of replicas for the machine set.
     */
    @JsonProperty("minReplicas")
    public Integer getMinReplicas() {
        return minReplicas;
    }

    /**
     * MinReplicas is the minimum number of replicas for the machine set.
     */
    @JsonProperty("minReplicas")
    public void setMinReplicas(Integer minReplicas) {
        this.minReplicas = minReplicas;
    }

    /**
     * Name is the name of the machine set.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the machine set.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The number of ready replicas for this MachineSet. A machine is considered ready when the node has been created and is "Ready". It is transferred as-is from the MachineSet from remote cluster.
     */
    @JsonProperty("readyReplicas")
    public Integer getReadyReplicas() {
        return readyReplicas;
    }

    /**
     * The number of ready replicas for this MachineSet. A machine is considered ready when the node has been created and is "Ready". It is transferred as-is from the MachineSet from remote cluster.
     */
    @JsonProperty("readyReplicas")
    public void setReadyReplicas(Integer readyReplicas) {
        this.readyReplicas = readyReplicas;
    }

    /**
     * Replicas is the current number of replicas for the machine set.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Replicas is the current number of replicas for the machine set.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonIgnore
    public MachineSetStatusBuilder edit() {
        return new MachineSetStatusBuilder(this);
    }

    @JsonIgnore
    public MachineSetStatusBuilder toBuilder() {
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
        if (!(o instanceof MachineSetStatus)) {
            return false;
        }
        MachineSetStatus other = (MachineSetStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$errorMessage = this.getErrorMessage();
        Object other$errorMessage = other.getErrorMessage();
        if (this$errorMessage == null ? other$errorMessage != null : !this$errorMessage.equals(other$errorMessage)) {
            return false;
        }
        Object this$errorReason = this.getErrorReason();
        Object other$errorReason = other.getErrorReason();
        if (this$errorReason == null ? other$errorReason != null : !this$errorReason.equals(other$errorReason)) {
            return false;
        }
        Object this$maxReplicas = this.getMaxReplicas();
        Object other$maxReplicas = other.getMaxReplicas();
        if (this$maxReplicas == null ? other$maxReplicas != null : !this$maxReplicas.equals(other$maxReplicas)) {
            return false;
        }
        Object this$minReplicas = this.getMinReplicas();
        Object other$minReplicas = other.getMinReplicas();
        if (this$minReplicas == null ? other$minReplicas != null : !this$minReplicas.equals(other$minReplicas)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$readyReplicas = this.getReadyReplicas();
        Object other$readyReplicas = other.getReadyReplicas();
        if (this$readyReplicas == null ? other$readyReplicas != null : !this$readyReplicas.equals(other$readyReplicas)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
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
        return other instanceof MachineSetStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $errorMessage = this.getErrorMessage();
        result = result * prime + ($errorMessage == null ? 43 : $errorMessage.hashCode());
        Object $errorReason = this.getErrorReason();
        result = result * prime + ($errorReason == null ? 43 : $errorReason.hashCode());
        Object $maxReplicas = this.getMaxReplicas();
        result = result * prime + ($maxReplicas == null ? 43 : $maxReplicas.hashCode());
        Object $minReplicas = this.getMinReplicas();
        result = result * prime + ($minReplicas == null ? 43 : $minReplicas.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $readyReplicas = this.getReadyReplicas();
        result = result * prime + ($readyReplicas == null ? 43 : $readyReplicas.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineSetStatus(" + "errorMessage=" + this.getErrorMessage() + ", errorReason=" + this.getErrorReason() + ", maxReplicas=" + this.getMaxReplicas() + ", minReplicas=" + this.getMinReplicas() + ", name=" + this.getName() + ", readyReplicas=" + this.getReadyReplicas() + ", replicas=" + this.getReplicas() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
