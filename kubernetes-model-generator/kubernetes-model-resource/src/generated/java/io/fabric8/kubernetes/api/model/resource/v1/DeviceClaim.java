
package io.fabric8.kubernetes.api.model.resource.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * DeviceClaim defines how to request devices with a ResourceClaim.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "config",
    "constraints",
    "requests"
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
public class DeviceClaim implements Editable<DeviceClaimBuilder>, KubernetesResource
{

    @JsonProperty("config")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeviceClaimConfiguration> config = new ArrayList<>();
    @JsonProperty("constraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeviceConstraint> constraints = new ArrayList<>();
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeviceRequest> requests = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeviceClaim() {
    }

    public DeviceClaim(List<DeviceClaimConfiguration> config, List<DeviceConstraint> constraints, List<DeviceRequest> requests) {
        super();
        this.config = config;
        this.constraints = constraints;
        this.requests = requests;
    }

    /**
     * This field holds configuration for multiple potential drivers which could satisfy requests in this claim. It is ignored while allocating the claim.
     */
    @JsonProperty("config")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceClaimConfiguration> getConfig() {
        return config;
    }

    /**
     * This field holds configuration for multiple potential drivers which could satisfy requests in this claim. It is ignored while allocating the claim.
     */
    @JsonProperty("config")
    public void setConfig(List<DeviceClaimConfiguration> config) {
        this.config = config;
    }

    /**
     * These constraints must be satisfied by the set of devices that get allocated for the claim.
     */
    @JsonProperty("constraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceConstraint> getConstraints() {
        return constraints;
    }

    /**
     * These constraints must be satisfied by the set of devices that get allocated for the claim.
     */
    @JsonProperty("constraints")
    public void setConstraints(List<DeviceConstraint> constraints) {
        this.constraints = constraints;
    }

    /**
     * Requests represent individual requests for distinct devices which must all be satisfied. If empty, nothing needs to be allocated.
     */
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DeviceRequest> getRequests() {
        return requests;
    }

    /**
     * Requests represent individual requests for distinct devices which must all be satisfied. If empty, nothing needs to be allocated.
     */
    @JsonProperty("requests")
    public void setRequests(List<DeviceRequest> requests) {
        this.requests = requests;
    }

    @JsonIgnore
    public DeviceClaimBuilder edit() {
        return new DeviceClaimBuilder(this);
    }

    @JsonIgnore
    public DeviceClaimBuilder toBuilder() {
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
