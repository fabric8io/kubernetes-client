
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * Metal3RemediationStatus defines the observed state of Metal3Remediation.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastRemediated",
    "phase",
    "retryCount"
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
public class Metal3RemediationStatus implements Editable<Metal3RemediationStatusBuilder>, KubernetesResource
{

    @JsonProperty("lastRemediated")
    private String lastRemediated;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("retryCount")
    private Integer retryCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metal3RemediationStatus() {
    }

    public Metal3RemediationStatus(String lastRemediated, String phase, Integer retryCount) {
        super();
        this.lastRemediated = lastRemediated;
        this.phase = phase;
        this.retryCount = retryCount;
    }

    /**
     * Metal3RemediationStatus defines the observed state of Metal3Remediation.
     */
    @JsonProperty("lastRemediated")
    public String getLastRemediated() {
        return lastRemediated;
    }

    /**
     * Metal3RemediationStatus defines the observed state of Metal3Remediation.
     */
    @JsonProperty("lastRemediated")
    public void setLastRemediated(String lastRemediated) {
        this.lastRemediated = lastRemediated;
    }

    /**
     * Phase represents the current phase of machine remediation. E.g. Pending, Running, Done etc.
     */
    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    /**
     * Phase represents the current phase of machine remediation. E.g. Pending, Running, Done etc.
     */
    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * RetryCount can be used as a counter during the remediation. Field can hold number of reboots etc.
     */
    @JsonProperty("retryCount")
    public Integer getRetryCount() {
        return retryCount;
    }

    /**
     * RetryCount can be used as a counter during the remediation. Field can hold number of reboots etc.
     */
    @JsonProperty("retryCount")
    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    @JsonIgnore
    public Metal3RemediationStatusBuilder edit() {
        return new Metal3RemediationStatusBuilder(this);
    }

    @JsonIgnore
    public Metal3RemediationStatusBuilder toBuilder() {
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
        if (!(o instanceof Metal3RemediationStatus)) {
            return false;
        }
        Metal3RemediationStatus other = (Metal3RemediationStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$lastRemediated = this.getLastRemediated();
        Object other$lastRemediated = other.getLastRemediated();
        if (this$lastRemediated == null ? other$lastRemediated != null : !this$lastRemediated.equals(other$lastRemediated)) {
            return false;
        }
        Object this$phase = this.getPhase();
        Object other$phase = other.getPhase();
        if (this$phase == null ? other$phase != null : !this$phase.equals(other$phase)) {
            return false;
        }
        Object this$retryCount = this.getRetryCount();
        Object other$retryCount = other.getRetryCount();
        if (this$retryCount == null ? other$retryCount != null : !this$retryCount.equals(other$retryCount)) {
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
        return other instanceof Metal3RemediationStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $lastRemediated = this.getLastRemediated();
        result = result * prime + ($lastRemediated == null ? 43 : $lastRemediated.hashCode());
        Object $phase = this.getPhase();
        result = result * prime + ($phase == null ? 43 : $phase.hashCode());
        Object $retryCount = this.getRetryCount();
        result = result * prime + ($retryCount == null ? 43 : $retryCount.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metal3RemediationStatus(" + "lastRemediated=" + this.getLastRemediated() + ", phase=" + this.getPhase() + ", retryCount=" + this.getRetryCount() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
