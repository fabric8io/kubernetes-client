
package io.fabric8.openshift.api.model.autoscaling.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "max",
    "min",
    "type"
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
public class ClusterAutoscalerSpecRLGpus implements Editable<ClusterAutoscalerSpecRLGpusBuilder>, KubernetesResource
{

    @JsonProperty("max")
    private Integer max;
    @JsonProperty("min")
    private Integer min;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterAutoscalerSpecRLGpus() {
    }

    public ClusterAutoscalerSpecRLGpus(Integer max, Integer min, String type) {
        super();
        this.max = max;
        this.min = min;
        this.type = type;
    }

    @JsonProperty("max")
    public Integer getMax() {
        return max;
    }

    @JsonProperty("max")
    public void setMax(Integer max) {
        this.max = max;
    }

    @JsonProperty("min")
    public Integer getMin() {
        return min;
    }

    @JsonProperty("min")
    public void setMin(Integer min) {
        this.min = min;
    }

    /**
     * The type of GPU to associate with the minimum and maximum limits.<br><p> This value is used by the Cluster Autoscaler to identify Nodes that will have GPU capacity by searching<br><p> for it as a label value on the Node objects. For example, Nodes that carry the label key<br><p> `cluster-api/accelerator` with the label value being the same as the Type field will be counted towards<br><p> the resource limits by the Cluster Autoscaler.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * The type of GPU to associate with the minimum and maximum limits.<br><p> This value is used by the Cluster Autoscaler to identify Nodes that will have GPU capacity by searching<br><p> for it as a label value on the Node objects. For example, Nodes that carry the label key<br><p> `cluster-api/accelerator` with the label value being the same as the Type field will be counted towards<br><p> the resource limits by the Cluster Autoscaler.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public ClusterAutoscalerSpecRLGpusBuilder edit() {
        return new ClusterAutoscalerSpecRLGpusBuilder(this);
    }

    @JsonIgnore
    public ClusterAutoscalerSpecRLGpusBuilder toBuilder() {
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
        if (!(o instanceof ClusterAutoscalerSpecRLGpus)) {
            return false;
        }
        ClusterAutoscalerSpecRLGpus other = (ClusterAutoscalerSpecRLGpus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$max = this.getMax();
        Object other$max = other.getMax();
        if (this$max == null ? other$max != null : !this$max.equals(other$max)) {
            return false;
        }
        Object this$min = this.getMin();
        Object other$min = other.getMin();
        if (this$min == null ? other$min != null : !this$min.equals(other$min)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof ClusterAutoscalerSpecRLGpus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $max = this.getMax();
        result = result * prime + ($max == null ? 43 : $max.hashCode());
        Object $min = this.getMin();
        result = result * prime + ($min == null ? 43 : $min.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterAutoscalerSpecRLGpus(" + "max=" + this.getMax() + ", min=" + this.getMin() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
