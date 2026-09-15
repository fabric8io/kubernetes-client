
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * VerticalPodAutoscalerCheckpointSpec is the specification of the checkpoint object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerName",
    "vpaObjectName"
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
public class VerticalPodAutoscalerCheckpointSpec implements Editable<VerticalPodAutoscalerCheckpointSpecBuilder>, KubernetesResource
{

    @JsonProperty("containerName")
    private String containerName;
    @JsonProperty("vpaObjectName")
    private String vpaObjectName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VerticalPodAutoscalerCheckpointSpec() {
    }

    public VerticalPodAutoscalerCheckpointSpec(String containerName, String vpaObjectName) {
        super();
        this.containerName = containerName;
        this.vpaObjectName = vpaObjectName;
    }

    /**
     * Name of the checkpointed container.
     */
    @JsonProperty("containerName")
    public String getContainerName() {
        return containerName;
    }

    /**
     * Name of the checkpointed container.
     */
    @JsonProperty("containerName")
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * Name of the VPA object that stored VerticalPodAutoscalerCheckpoint object.
     */
    @JsonProperty("vpaObjectName")
    public String getVpaObjectName() {
        return vpaObjectName;
    }

    /**
     * Name of the VPA object that stored VerticalPodAutoscalerCheckpoint object.
     */
    @JsonProperty("vpaObjectName")
    public void setVpaObjectName(String vpaObjectName) {
        this.vpaObjectName = vpaObjectName;
    }

    @JsonIgnore
    public VerticalPodAutoscalerCheckpointSpecBuilder edit() {
        return new VerticalPodAutoscalerCheckpointSpecBuilder(this);
    }

    @JsonIgnore
    public VerticalPodAutoscalerCheckpointSpecBuilder toBuilder() {
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
        if (!(o instanceof VerticalPodAutoscalerCheckpointSpec)) {
            return false;
        }
        VerticalPodAutoscalerCheckpointSpec other = (VerticalPodAutoscalerCheckpointSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containerName = this.getContainerName();
        Object other$containerName = other.getContainerName();
        if (this$containerName == null ? other$containerName != null : !this$containerName.equals(other$containerName)) {
            return false;
        }
        Object this$vpaObjectName = this.getVpaObjectName();
        Object other$vpaObjectName = other.getVpaObjectName();
        if (this$vpaObjectName == null ? other$vpaObjectName != null : !this$vpaObjectName.equals(other$vpaObjectName)) {
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
        return other instanceof VerticalPodAutoscalerCheckpointSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containerName = this.getContainerName();
        result = result * prime + ($containerName == null ? 43 : $containerName.hashCode());
        Object $vpaObjectName = this.getVpaObjectName();
        result = result * prime + ($vpaObjectName == null ? 43 : $vpaObjectName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VerticalPodAutoscalerCheckpointSpec(" + "containerName=" + this.getContainerName() + ", vpaObjectName=" + this.getVpaObjectName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
