
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Minimum and maximum number of cores in cluster, in the format &lt;min&gt;:&lt;max&gt;. Cluster autoscaler will not scale the cluster beyond these numbers.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "max",
    "min"
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
public class ClusterAutoscalerSpecRLCores implements Editable<ClusterAutoscalerSpecRLCoresBuilder>, KubernetesResource
{

    @JsonProperty("max")
    private Integer max;
    @JsonProperty("min")
    private Integer min;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterAutoscalerSpecRLCores() {
    }

    public ClusterAutoscalerSpecRLCores(Integer max, Integer min) {
        super();
        this.max = max;
        this.min = min;
    }

    /**
     * Minimum and maximum number of cores in cluster, in the format &lt;min&gt;:&lt;max&gt;. Cluster autoscaler will not scale the cluster beyond these numbers.
     */
    @JsonProperty("max")
    public Integer getMax() {
        return max;
    }

    /**
     * Minimum and maximum number of cores in cluster, in the format &lt;min&gt;:&lt;max&gt;. Cluster autoscaler will not scale the cluster beyond these numbers.
     */
    @JsonProperty("max")
    public void setMax(Integer max) {
        this.max = max;
    }

    /**
     * Minimum and maximum number of cores in cluster, in the format &lt;min&gt;:&lt;max&gt;. Cluster autoscaler will not scale the cluster beyond these numbers.
     */
    @JsonProperty("min")
    public Integer getMin() {
        return min;
    }

    /**
     * Minimum and maximum number of cores in cluster, in the format &lt;min&gt;:&lt;max&gt;. Cluster autoscaler will not scale the cluster beyond these numbers.
     */
    @JsonProperty("min")
    public void setMin(Integer min) {
        this.min = min;
    }

    @JsonIgnore
    public ClusterAutoscalerSpecRLCoresBuilder edit() {
        return new ClusterAutoscalerSpecRLCoresBuilder(this);
    }

    @JsonIgnore
    public ClusterAutoscalerSpecRLCoresBuilder toBuilder() {
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
