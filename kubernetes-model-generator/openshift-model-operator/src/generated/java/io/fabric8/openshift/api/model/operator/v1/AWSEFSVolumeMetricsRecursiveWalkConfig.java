
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
 * AWSEFSVolumeMetricsRecursiveWalkConfig defines options for volume metrics in the EFS CSI Driver.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fsRateLimit",
    "refreshPeriodMinutes"
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
public class AWSEFSVolumeMetricsRecursiveWalkConfig implements Editable<AWSEFSVolumeMetricsRecursiveWalkConfigBuilder>, KubernetesResource
{

    @JsonProperty("fsRateLimit")
    private Integer fsRateLimit;
    @JsonProperty("refreshPeriodMinutes")
    private Integer refreshPeriodMinutes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSEFSVolumeMetricsRecursiveWalkConfig() {
    }

    public AWSEFSVolumeMetricsRecursiveWalkConfig(Integer fsRateLimit, Integer refreshPeriodMinutes) {
        super();
        this.fsRateLimit = fsRateLimit;
        this.refreshPeriodMinutes = refreshPeriodMinutes;
    }

    /**
     * fsRateLimit defines the rate limit, in goroutines per file system, for processing volume metrics. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is 5. The valid range is from 1 to 100 goroutines.
     */
    @JsonProperty("fsRateLimit")
    public Integer getFsRateLimit() {
        return fsRateLimit;
    }

    /**
     * fsRateLimit defines the rate limit, in goroutines per file system, for processing volume metrics. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is 5. The valid range is from 1 to 100 goroutines.
     */
    @JsonProperty("fsRateLimit")
    public void setFsRateLimit(Integer fsRateLimit) {
        this.fsRateLimit = fsRateLimit;
    }

    /**
     * refreshPeriodMinutes specifies the frequency, in minutes, at which volume metrics are refreshed. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is 240. The valid range is from 1 to 43200 minutes (30 days).
     */
    @JsonProperty("refreshPeriodMinutes")
    public Integer getRefreshPeriodMinutes() {
        return refreshPeriodMinutes;
    }

    /**
     * refreshPeriodMinutes specifies the frequency, in minutes, at which volume metrics are refreshed. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is 240. The valid range is from 1 to 43200 minutes (30 days).
     */
    @JsonProperty("refreshPeriodMinutes")
    public void setRefreshPeriodMinutes(Integer refreshPeriodMinutes) {
        this.refreshPeriodMinutes = refreshPeriodMinutes;
    }

    @JsonIgnore
    public AWSEFSVolumeMetricsRecursiveWalkConfigBuilder edit() {
        return new AWSEFSVolumeMetricsRecursiveWalkConfigBuilder(this);
    }

    @JsonIgnore
    public AWSEFSVolumeMetricsRecursiveWalkConfigBuilder toBuilder() {
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
