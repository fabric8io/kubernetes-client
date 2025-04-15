
package io.fabric8.openshift.api.model.operator.v1;

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
 * AWSEFSVolumeMetrics defines the configuration for volume metrics in the EFS CSI Driver.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "recursiveWalk",
    "state"
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
public class AWSEFSVolumeMetrics implements Editable<AWSEFSVolumeMetricsBuilder>, KubernetesResource
{

    @JsonProperty("recursiveWalk")
    private AWSEFSVolumeMetricsRecursiveWalkConfig recursiveWalk;
    @JsonProperty("state")
    private String state;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSEFSVolumeMetrics() {
    }

    public AWSEFSVolumeMetrics(AWSEFSVolumeMetricsRecursiveWalkConfig recursiveWalk, String state) {
        super();
        this.recursiveWalk = recursiveWalk;
        this.state = state;
    }

    /**
     * AWSEFSVolumeMetrics defines the configuration for volume metrics in the EFS CSI Driver.
     */
    @JsonProperty("recursiveWalk")
    public AWSEFSVolumeMetricsRecursiveWalkConfig getRecursiveWalk() {
        return recursiveWalk;
    }

    /**
     * AWSEFSVolumeMetrics defines the configuration for volume metrics in the EFS CSI Driver.
     */
    @JsonProperty("recursiveWalk")
    public void setRecursiveWalk(AWSEFSVolumeMetricsRecursiveWalkConfig recursiveWalk) {
        this.recursiveWalk = recursiveWalk;
    }

    /**
     * state defines the state of metric collection in the AWS EFS CSI Driver. This field is required and must be set to one of the following values: Disabled or RecursiveWalk. Disabled means no metrics collection will be performed. This is the default value. RecursiveWalk means the AWS EFS CSI Driver will recursively scan volumes to collect metrics. This process may result in high CPU and memory usage, depending on the volume size.
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * state defines the state of metric collection in the AWS EFS CSI Driver. This field is required and must be set to one of the following values: Disabled or RecursiveWalk. Disabled means no metrics collection will be performed. This is the default value. RecursiveWalk means the AWS EFS CSI Driver will recursively scan volumes to collect metrics. This process may result in high CPU and memory usage, depending on the volume size.
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnore
    public AWSEFSVolumeMetricsBuilder edit() {
        return new AWSEFSVolumeMetricsBuilder(this);
    }

    @JsonIgnore
    public AWSEFSVolumeMetricsBuilder toBuilder() {
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
