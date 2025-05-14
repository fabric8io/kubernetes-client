
package io.fabric8.knative.internal.autoscaling.v1alpha1;

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
 * PodAutoscalerSpec holds the desired state of the PodAutoscaler (from the client).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerConcurrency",
    "protocolType",
    "reachability",
    "scaleTargetRef"
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
public class PodAutoscalerSpec implements Editable<PodAutoscalerSpecBuilder>, KubernetesResource
{

    @JsonProperty("containerConcurrency")
    private Long containerConcurrency;
    @JsonProperty("protocolType")
    private String protocolType;
    @JsonProperty("reachability")
    private String reachability;
    @JsonProperty("scaleTargetRef")
    private ObjectReference scaleTargetRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodAutoscalerSpec() {
    }

    public PodAutoscalerSpec(Long containerConcurrency, String protocolType, String reachability, ObjectReference scaleTargetRef) {
        super();
        this.containerConcurrency = containerConcurrency;
        this.protocolType = protocolType;
        this.reachability = reachability;
        this.scaleTargetRef = scaleTargetRef;
    }

    /**
     * ContainerConcurrency specifies the maximum allowed in-flight (concurrent) requests per container of the Revision. Defaults to `0` which means unlimited concurrency.
     */
    @JsonProperty("containerConcurrency")
    public Long getContainerConcurrency() {
        return containerConcurrency;
    }

    /**
     * ContainerConcurrency specifies the maximum allowed in-flight (concurrent) requests per container of the Revision. Defaults to `0` which means unlimited concurrency.
     */
    @JsonProperty("containerConcurrency")
    public void setContainerConcurrency(Long containerConcurrency) {
        this.containerConcurrency = containerConcurrency;
    }

    /**
     * The application-layer protocol. Matches `ProtocolType` inferred from the revision spec.
     */
    @JsonProperty("protocolType")
    public String getProtocolType() {
        return protocolType;
    }

    /**
     * The application-layer protocol. Matches `ProtocolType` inferred from the revision spec.
     */
    @JsonProperty("protocolType")
    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    /**
     * Reachability specifies whether or not the `ScaleTargetRef` can be reached (ie. has a route). Defaults to `ReachabilityUnknown`
     */
    @JsonProperty("reachability")
    public String getReachability() {
        return reachability;
    }

    /**
     * Reachability specifies whether or not the `ScaleTargetRef` can be reached (ie. has a route). Defaults to `ReachabilityUnknown`
     */
    @JsonProperty("reachability")
    public void setReachability(String reachability) {
        this.reachability = reachability;
    }

    /**
     * PodAutoscalerSpec holds the desired state of the PodAutoscaler (from the client).
     */
    @JsonProperty("scaleTargetRef")
    public ObjectReference getScaleTargetRef() {
        return scaleTargetRef;
    }

    /**
     * PodAutoscalerSpec holds the desired state of the PodAutoscaler (from the client).
     */
    @JsonProperty("scaleTargetRef")
    public void setScaleTargetRef(ObjectReference scaleTargetRef) {
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
