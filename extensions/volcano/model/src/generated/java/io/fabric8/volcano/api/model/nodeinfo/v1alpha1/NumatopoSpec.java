
package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

import java.util.LinkedHashMap;
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
 * NumatopoSpec defines the desired state of Numatopology
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cpuDetail",
    "numares",
    "policies",
    "resReserved"
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
public class NumatopoSpec implements Editable<NumatopoSpecBuilder>, KubernetesResource
{

    @JsonProperty("cpuDetail")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, CPUInfo> cpuDetail = new LinkedHashMap<>();
    @JsonProperty("numares")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, ResourceInfo> numares = new LinkedHashMap<>();
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> policies = new LinkedHashMap<>();
    @JsonProperty("resReserved")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> resReserved = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NumatopoSpec() {
    }

    public NumatopoSpec(Map<String, CPUInfo> cpuDetail, Map<String, ResourceInfo> numares, Map<String, String> policies, Map<String, String> resReserved) {
        super();
        this.cpuDetail = cpuDetail;
        this.numares = numares;
        this.policies = policies;
        this.resReserved = resReserved;
    }

    /**
     * Specifies the cpu topology info Key is cpu id
     */
    @JsonProperty("cpuDetail")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, CPUInfo> getCpuDetail() {
        return cpuDetail;
    }

    /**
     * Specifies the cpu topology info Key is cpu id
     */
    @JsonProperty("cpuDetail")
    public void setCpuDetail(Map<String, CPUInfo> cpuDetail) {
        this.cpuDetail = cpuDetail;
    }

    /**
     * Specifies the numa info for the resource Key is resource name
     */
    @JsonProperty("numares")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, ResourceInfo> getNumares() {
        return numares;
    }

    /**
     * Specifies the numa info for the resource Key is resource name
     */
    @JsonProperty("numares")
    public void setNumares(Map<String, ResourceInfo> numares) {
        this.numares = numares;
    }

    /**
     * Specifies the policy of the manager
     */
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getPolicies() {
        return policies;
    }

    /**
     * Specifies the policy of the manager
     */
    @JsonProperty("policies")
    public void setPolicies(Map<String, String> policies) {
        this.policies = policies;
    }

    /**
     * Specifies the reserved resource of the node Key is resource name
     */
    @JsonProperty("resReserved")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getResReserved() {
        return resReserved;
    }

    /**
     * Specifies the reserved resource of the node Key is resource name
     */
    @JsonProperty("resReserved")
    public void setResReserved(Map<String, String> resReserved) {
        this.resReserved = resReserved;
    }

    @JsonIgnore
    public NumatopoSpecBuilder edit() {
        return new NumatopoSpecBuilder(this);
    }

    @JsonIgnore
    public NumatopoSpecBuilder toBuilder() {
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
