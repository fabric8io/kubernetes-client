
package io.fabric8.autoscaling.api.model.v1beta2;

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
import io.fabric8.kubernetes.api.model.autoscaling.v1.CrossVersionObjectReference;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * VerticalPodAutoscalerSpec is the specification of the behavior of the autoscaler.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resourcePolicy",
    "targetRef",
    "updatePolicy"
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
public class VerticalPodAutoscalerSpec implements Editable<VerticalPodAutoscalerSpecBuilder>, KubernetesResource
{

    @JsonProperty("resourcePolicy")
    private PodResourcePolicy resourcePolicy;
    @JsonProperty("targetRef")
    private CrossVersionObjectReference targetRef;
    @JsonProperty("updatePolicy")
    private PodUpdatePolicy updatePolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VerticalPodAutoscalerSpec() {
    }

    public VerticalPodAutoscalerSpec(PodResourcePolicy resourcePolicy, CrossVersionObjectReference targetRef, PodUpdatePolicy updatePolicy) {
        super();
        this.resourcePolicy = resourcePolicy;
        this.targetRef = targetRef;
        this.updatePolicy = updatePolicy;
    }

    /**
     * VerticalPodAutoscalerSpec is the specification of the behavior of the autoscaler.
     */
    @JsonProperty("resourcePolicy")
    public PodResourcePolicy getResourcePolicy() {
        return resourcePolicy;
    }

    /**
     * VerticalPodAutoscalerSpec is the specification of the behavior of the autoscaler.
     */
    @JsonProperty("resourcePolicy")
    public void setResourcePolicy(PodResourcePolicy resourcePolicy) {
        this.resourcePolicy = resourcePolicy;
    }

    /**
     * VerticalPodAutoscalerSpec is the specification of the behavior of the autoscaler.
     */
    @JsonProperty("targetRef")
    public CrossVersionObjectReference getTargetRef() {
        return targetRef;
    }

    /**
     * VerticalPodAutoscalerSpec is the specification of the behavior of the autoscaler.
     */
    @JsonProperty("targetRef")
    public void setTargetRef(CrossVersionObjectReference targetRef) {
        this.targetRef = targetRef;
    }

    /**
     * VerticalPodAutoscalerSpec is the specification of the behavior of the autoscaler.
     */
    @JsonProperty("updatePolicy")
    public PodUpdatePolicy getUpdatePolicy() {
        return updatePolicy;
    }

    /**
     * VerticalPodAutoscalerSpec is the specification of the behavior of the autoscaler.
     */
    @JsonProperty("updatePolicy")
    public void setUpdatePolicy(PodUpdatePolicy updatePolicy) {
        this.updatePolicy = updatePolicy;
    }

    @JsonIgnore
    public VerticalPodAutoscalerSpecBuilder edit() {
        return new VerticalPodAutoscalerSpecBuilder(this);
    }

    @JsonIgnore
    public VerticalPodAutoscalerSpecBuilder toBuilder() {
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
        if (!(o instanceof VerticalPodAutoscalerSpec)) {
            return false;
        }
        VerticalPodAutoscalerSpec other = (VerticalPodAutoscalerSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$resourcePolicy = this.getResourcePolicy();
        Object other$resourcePolicy = other.getResourcePolicy();
        if (this$resourcePolicy == null ? other$resourcePolicy != null : !this$resourcePolicy.equals(other$resourcePolicy)) {
            return false;
        }
        Object this$targetRef = this.getTargetRef();
        Object other$targetRef = other.getTargetRef();
        if (this$targetRef == null ? other$targetRef != null : !this$targetRef.equals(other$targetRef)) {
            return false;
        }
        Object this$updatePolicy = this.getUpdatePolicy();
        Object other$updatePolicy = other.getUpdatePolicy();
        if (this$updatePolicy == null ? other$updatePolicy != null : !this$updatePolicy.equals(other$updatePolicy)) {
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
        return other instanceof VerticalPodAutoscalerSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $resourcePolicy = this.getResourcePolicy();
        result = result * prime + ($resourcePolicy == null ? 43 : $resourcePolicy.hashCode());
        Object $targetRef = this.getTargetRef();
        result = result * prime + ($targetRef == null ? 43 : $targetRef.hashCode());
        Object $updatePolicy = this.getUpdatePolicy();
        result = result * prime + ($updatePolicy == null ? 43 : $updatePolicy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VerticalPodAutoscalerSpec(" + "resourcePolicy=" + this.getResourcePolicy() + ", targetRef=" + this.getTargetRef() + ", updatePolicy=" + this.getUpdatePolicy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
