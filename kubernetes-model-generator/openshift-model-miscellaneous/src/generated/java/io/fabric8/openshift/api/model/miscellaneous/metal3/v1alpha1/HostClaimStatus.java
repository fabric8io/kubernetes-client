
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * HostClaimStatus defines the observed state of HostClaim.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bareMetalHost",
    "conditions",
    "hardwareData",
    "lastUpdated",
    "poweredOn"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class HostClaimStatus implements Editable<HostClaimStatusBuilder>, KubernetesResource
{

    @JsonProperty("bareMetalHost")
    private ObjectReference bareMetalHost;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("hardwareData")
    private ObjectReference hardwareData;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("poweredOn")
    private Boolean poweredOn;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HostClaimStatus() {
    }

    public HostClaimStatus(ObjectReference bareMetalHost, List<Condition> conditions, ObjectReference hardwareData, String lastUpdated, Boolean poweredOn) {
        super();
        this.bareMetalHost = bareMetalHost;
        this.conditions = conditions;
        this.hardwareData = hardwareData;
        this.lastUpdated = lastUpdated;
        this.poweredOn = poweredOn;
    }

    /**
     * HostClaimStatus defines the observed state of HostClaim.
     */
    @JsonProperty("bareMetalHost")
    public ObjectReference getBareMetalHost() {
        return bareMetalHost;
    }

    /**
     * HostClaimStatus defines the observed state of HostClaim.
     */
    @JsonProperty("bareMetalHost")
    public void setBareMetalHost(ObjectReference bareMetalHost) {
        this.bareMetalHost = bareMetalHost;
    }

    /**
     * Conditions defines current service state of the HostClaim.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions defines current service state of the HostClaim.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * HostClaimStatus defines the observed state of HostClaim.
     */
    @JsonProperty("hardwareData")
    public ObjectReference getHardwareData() {
        return hardwareData;
    }

    /**
     * HostClaimStatus defines the observed state of HostClaim.
     */
    @JsonProperty("hardwareData")
    public void setHardwareData(ObjectReference hardwareData) {
        this.hardwareData = hardwareData;
    }

    /**
     * HostClaimStatus defines the observed state of HostClaim.
     */
    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * HostClaimStatus defines the observed state of HostClaim.
     */
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * The currently detected power state of the host. This field may get briefly out of sync with the actual state of the hardware while provisioning processes are running.
     */
    @JsonProperty("poweredOn")
    public Boolean getPoweredOn() {
        return poweredOn;
    }

    /**
     * The currently detected power state of the host. This field may get briefly out of sync with the actual state of the hardware while provisioning processes are running.
     */
    @JsonProperty("poweredOn")
    public void setPoweredOn(Boolean poweredOn) {
        this.poweredOn = poweredOn;
    }

    @JsonIgnore
    public HostClaimStatusBuilder edit() {
        return new HostClaimStatusBuilder(this);
    }

    @JsonIgnore
    public HostClaimStatusBuilder toBuilder() {
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
        if (!(o instanceof HostClaimStatus)) {
            return false;
        }
        HostClaimStatus other = (HostClaimStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bareMetalHost = this.getBareMetalHost();
        Object other$bareMetalHost = other.getBareMetalHost();
        if (this$bareMetalHost == null ? other$bareMetalHost != null : !this$bareMetalHost.equals(other$bareMetalHost)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$hardwareData = this.getHardwareData();
        Object other$hardwareData = other.getHardwareData();
        if (this$hardwareData == null ? other$hardwareData != null : !this$hardwareData.equals(other$hardwareData)) {
            return false;
        }
        Object this$lastUpdated = this.getLastUpdated();
        Object other$lastUpdated = other.getLastUpdated();
        if (this$lastUpdated == null ? other$lastUpdated != null : !this$lastUpdated.equals(other$lastUpdated)) {
            return false;
        }
        Object this$poweredOn = this.getPoweredOn();
        Object other$poweredOn = other.getPoweredOn();
        if (this$poweredOn == null ? other$poweredOn != null : !this$poweredOn.equals(other$poweredOn)) {
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
        return other instanceof HostClaimStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bareMetalHost = this.getBareMetalHost();
        result = result * prime + ($bareMetalHost == null ? 43 : $bareMetalHost.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $hardwareData = this.getHardwareData();
        result = result * prime + ($hardwareData == null ? 43 : $hardwareData.hashCode());
        Object $lastUpdated = this.getLastUpdated();
        result = result * prime + ($lastUpdated == null ? 43 : $lastUpdated.hashCode());
        Object $poweredOn = this.getPoweredOn();
        result = result * prime + ($poweredOn == null ? 43 : $poweredOn.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HostClaimStatus(" + "bareMetalHost=" + this.getBareMetalHost() + ", conditions=" + this.getConditions() + ", hardwareData=" + this.getHardwareData() + ", lastUpdated=" + this.getLastUpdated() + ", poweredOn=" + this.getPoweredOn() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
