
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
