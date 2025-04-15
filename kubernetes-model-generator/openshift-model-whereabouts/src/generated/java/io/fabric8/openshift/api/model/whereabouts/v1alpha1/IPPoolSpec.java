
package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * IPPoolSpec defines the desired state of IPPool
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocations",
    "range"
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
public class IPPoolSpec implements Editable<IPPoolSpecBuilder>, KubernetesResource
{

    @JsonProperty("allocations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, IPPoolSpecAllocations> allocations = new LinkedHashMap<>();
    @JsonProperty("range")
    private String range;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IPPoolSpec() {
    }

    public IPPoolSpec(Map<String, IPPoolSpecAllocations> allocations, String range) {
        super();
        this.allocations = allocations;
        this.range = range;
    }

    /**
     * Allocations is the set of allocated IPs for the given range. Its` indices are a direct mapping to the<br><p> IP with the same index/offset for the pool's range.
     */
    @JsonProperty("allocations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, IPPoolSpecAllocations> getAllocations() {
        return allocations;
    }

    /**
     * Allocations is the set of allocated IPs for the given range. Its` indices are a direct mapping to the<br><p> IP with the same index/offset for the pool's range.
     */
    @JsonProperty("allocations")
    public void setAllocations(Map<String, IPPoolSpecAllocations> allocations) {
        this.allocations = allocations;
    }

    /**
     * Range is a RFC 4632/4291-style string that represents an IP address and prefix length in CIDR notation
     */
    @JsonProperty("range")
    public String getRange() {
        return range;
    }

    /**
     * Range is a RFC 4632/4291-style string that represents an IP address and prefix length in CIDR notation
     */
    @JsonProperty("range")
    public void setRange(String range) {
        this.range = range;
    }

    @JsonIgnore
    public IPPoolSpecBuilder edit() {
        return new IPPoolSpecBuilder(this);
    }

    @JsonIgnore
    public IPPoolSpecBuilder toBuilder() {
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
