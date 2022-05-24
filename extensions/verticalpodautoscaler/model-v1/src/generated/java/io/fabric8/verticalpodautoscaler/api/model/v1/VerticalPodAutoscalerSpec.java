
package io.fabric8.verticalpodautoscaler.api.model.v1;

import java.util.HashMap;
import java.util.Map;
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
import io.fabric8.kubernetes.api.model.autoscaling.v1.CrossVersionObjectReference;
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
    "resourcePolicy",
    "targetRef",
    "updatePolicy"
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
public class VerticalPodAutoscalerSpec implements KubernetesResource
{

    @JsonProperty("resourcePolicy")
    private PodResourcePolicy resourcePolicy;
    @JsonProperty("targetRef")
    private CrossVersionObjectReference targetRef;
    @JsonProperty("updatePolicy")
    private PodUpdatePolicy updatePolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public VerticalPodAutoscalerSpec() {
    }

    /**
     * 
     * @param targetRef
     * @param resourcePolicy
     * @param updatePolicy
     */
    public VerticalPodAutoscalerSpec(PodResourcePolicy resourcePolicy, CrossVersionObjectReference targetRef, PodUpdatePolicy updatePolicy) {
        super();
        this.resourcePolicy = resourcePolicy;
        this.targetRef = targetRef;
        this.updatePolicy = updatePolicy;
    }

    @JsonProperty("resourcePolicy")
    public PodResourcePolicy getResourcePolicy() {
        return resourcePolicy;
    }

    @JsonProperty("resourcePolicy")
    public void setResourcePolicy(PodResourcePolicy resourcePolicy) {
        this.resourcePolicy = resourcePolicy;
    }

    @JsonProperty("targetRef")
    public CrossVersionObjectReference getTargetRef() {
        return targetRef;
    }

    @JsonProperty("targetRef")
    public void setTargetRef(CrossVersionObjectReference targetRef) {
        this.targetRef = targetRef;
    }

    @JsonProperty("updatePolicy")
    public PodUpdatePolicy getUpdatePolicy() {
        return updatePolicy;
    }

    @JsonProperty("updatePolicy")
    public void setUpdatePolicy(PodUpdatePolicy updatePolicy) {
        this.updatePolicy = updatePolicy;
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
