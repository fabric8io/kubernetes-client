
package io.fabric8.knative.internal.autoscaling.v1alpha1;

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
    "containerConcurrency",
    "protocolType",
    "reachability",
    "scaleTargetRef"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class PodAutoscalerSpec implements Editable<PodAutoscalerSpecBuilder> , KubernetesResource
{

    @JsonProperty("containerConcurrency")
    private Long containerConcurrency;
    @JsonProperty("protocolType")
    private String protocolType;
    @JsonProperty("reachability")
    private String reachability;
    @JsonProperty("scaleTargetRef")
    private io.fabric8.kubernetes.api.model.ObjectReference scaleTargetRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodAutoscalerSpec() {
    }

    public PodAutoscalerSpec(Long containerConcurrency, String protocolType, String reachability, io.fabric8.kubernetes.api.model.ObjectReference scaleTargetRef) {
        super();
        this.containerConcurrency = containerConcurrency;
        this.protocolType = protocolType;
        this.reachability = reachability;
        this.scaleTargetRef = scaleTargetRef;
    }

    @JsonProperty("containerConcurrency")
    public Long getContainerConcurrency() {
        return containerConcurrency;
    }

    @JsonProperty("containerConcurrency")
    public void setContainerConcurrency(Long containerConcurrency) {
        this.containerConcurrency = containerConcurrency;
    }

    @JsonProperty("protocolType")
    public String getProtocolType() {
        return protocolType;
    }

    @JsonProperty("protocolType")
    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    @JsonProperty("reachability")
    public String getReachability() {
        return reachability;
    }

    @JsonProperty("reachability")
    public void setReachability(String reachability) {
        this.reachability = reachability;
    }

    @JsonProperty("scaleTargetRef")
    public io.fabric8.kubernetes.api.model.ObjectReference getScaleTargetRef() {
        return scaleTargetRef;
    }

    @JsonProperty("scaleTargetRef")
    public void setScaleTargetRef(io.fabric8.kubernetes.api.model.ObjectReference scaleTargetRef) {
        this.scaleTargetRef = scaleTargetRef;
    }

    @JsonIgnore
    public PodAutoscalerSpecBuilder edit() {
        return new PodAutoscalerSpecBuilder(this);
    }

    @JsonIgnore
    public PodAutoscalerSpecBuilder toBuilder() {
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

}
