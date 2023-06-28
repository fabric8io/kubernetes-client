
package io.fabric8.chaosmesh.v1alpha1;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "duration",
    "failKernRequest",
    "mode",
    "selector",
    "value"
})
@ToString
@EqualsAndHashCode
@Setter
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
@Generated("jsonschema2pojo")
public class KernelChaosSpec implements KubernetesResource
{

    @JsonProperty("duration")
    private String duration;
    @JsonProperty("failKernRequest")
    private FailKernRequest failKernRequest;
    @JsonProperty("mode")
    private java.lang.String mode;
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("value")
    private java.lang.String value;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KernelChaosSpec() {
    }

    public KernelChaosSpec(String duration, FailKernRequest failKernRequest, java.lang.String mode, PodSelectorSpec selector, java.lang.String value) {
        super();
        this.duration = duration;
        this.failKernRequest = failKernRequest;
        this.mode = mode;
        this.selector = selector;
        this.value = value;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("failKernRequest")
    public FailKernRequest getFailKernRequest() {
        return failKernRequest;
    }

    @JsonProperty("failKernRequest")
    public void setFailKernRequest(FailKernRequest failKernRequest) {
        this.failKernRequest = failKernRequest;
    }

    @JsonProperty("mode")
    public java.lang.String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(java.lang.String mode) {
        this.mode = mode;
    }

    @JsonProperty("selector")
    public PodSelectorSpec getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(PodSelectorSpec selector) {
        this.selector = selector;
    }

    @JsonProperty("value")
    public java.lang.String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
