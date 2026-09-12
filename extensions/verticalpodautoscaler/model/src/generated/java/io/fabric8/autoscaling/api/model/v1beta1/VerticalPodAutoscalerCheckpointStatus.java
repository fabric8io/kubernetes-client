
package io.fabric8.autoscaling.api.model.v1beta1;

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
 * VerticalPodAutoscalerCheckpointStatus contains data of the checkpoint.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cpuHistogram",
    "firstSampleStart",
    "lastSampleStart",
    "lastUpdateTime",
    "memoryHistogram",
    "totalSamplesCount",
    "version"
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
public class VerticalPodAutoscalerCheckpointStatus implements Editable<VerticalPodAutoscalerCheckpointStatusBuilder>, KubernetesResource
{

    @JsonProperty("cpuHistogram")
    private HistogramCheckpoint cpuHistogram;
    @JsonProperty("firstSampleStart")
    private String firstSampleStart;
    @JsonProperty("lastSampleStart")
    private String lastSampleStart;
    @JsonProperty("lastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("memoryHistogram")
    private HistogramCheckpoint memoryHistogram;
    @JsonProperty("totalSamplesCount")
    private Integer totalSamplesCount;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VerticalPodAutoscalerCheckpointStatus() {
    }

    public VerticalPodAutoscalerCheckpointStatus(HistogramCheckpoint cpuHistogram, String firstSampleStart, String lastSampleStart, String lastUpdateTime, HistogramCheckpoint memoryHistogram, Integer totalSamplesCount, String version) {
        super();
        this.cpuHistogram = cpuHistogram;
        this.firstSampleStart = firstSampleStart;
        this.lastSampleStart = lastSampleStart;
        this.lastUpdateTime = lastUpdateTime;
        this.memoryHistogram = memoryHistogram;
        this.totalSamplesCount = totalSamplesCount;
        this.version = version;
    }

    /**
     * VerticalPodAutoscalerCheckpointStatus contains data of the checkpoint.
     */
    @JsonProperty("cpuHistogram")
    public HistogramCheckpoint getCpuHistogram() {
        return cpuHistogram;
    }

    /**
     * VerticalPodAutoscalerCheckpointStatus contains data of the checkpoint.
     */
    @JsonProperty("cpuHistogram")
    public void setCpuHistogram(HistogramCheckpoint cpuHistogram) {
        this.cpuHistogram = cpuHistogram;
    }

    /**
     * VerticalPodAutoscalerCheckpointStatus contains data of the checkpoint.
     */
    @JsonProperty("firstSampleStart")
    public String getFirstSampleStart() {
        return firstSampleStart;
    }

    /**
     * VerticalPodAutoscalerCheckpointStatus contains data of the checkpoint.
     */
    @JsonProperty("firstSampleStart")
    public void setFirstSampleStart(String firstSampleStart) {
        this.firstSampleStart = firstSampleStart;
    }

    /**
     * VerticalPodAutoscalerCheckpointStatus contains data of the checkpoint.
     */
    @JsonProperty("lastSampleStart")
    public String getLastSampleStart() {
        return lastSampleStart;
    }

    /**
     * VerticalPodAutoscalerCheckpointStatus contains data of the checkpoint.
     */
    @JsonProperty("lastSampleStart")
    public void setLastSampleStart(String lastSampleStart) {
        this.lastSampleStart = lastSampleStart;
    }

    /**
     * VerticalPodAutoscalerCheckpointStatus contains data of the checkpoint.
     */
    @JsonProperty("lastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * VerticalPodAutoscalerCheckpointStatus contains data of the checkpoint.
     */
    @JsonProperty("lastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * VerticalPodAutoscalerCheckpointStatus contains data of the checkpoint.
     */
    @JsonProperty("memoryHistogram")
    public HistogramCheckpoint getMemoryHistogram() {
        return memoryHistogram;
    }

    /**
     * VerticalPodAutoscalerCheckpointStatus contains data of the checkpoint.
     */
    @JsonProperty("memoryHistogram")
    public void setMemoryHistogram(HistogramCheckpoint memoryHistogram) {
        this.memoryHistogram = memoryHistogram;
    }

    /**
     * Total number of samples in the histograms.
     */
    @JsonProperty("totalSamplesCount")
    public Integer getTotalSamplesCount() {
        return totalSamplesCount;
    }

    /**
     * Total number of samples in the histograms.
     */
    @JsonProperty("totalSamplesCount")
    public void setTotalSamplesCount(Integer totalSamplesCount) {
        this.totalSamplesCount = totalSamplesCount;
    }

    /**
     * Version of the format of the stored data.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version of the format of the stored data.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public VerticalPodAutoscalerCheckpointStatusBuilder edit() {
        return new VerticalPodAutoscalerCheckpointStatusBuilder(this);
    }

    @JsonIgnore
    public VerticalPodAutoscalerCheckpointStatusBuilder toBuilder() {
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
        if (!(o instanceof VerticalPodAutoscalerCheckpointStatus)) {
            return false;
        }
        VerticalPodAutoscalerCheckpointStatus other = (VerticalPodAutoscalerCheckpointStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cpuHistogram = this.getCpuHistogram();
        Object other$cpuHistogram = other.getCpuHistogram();
        if (this$cpuHistogram == null ? other$cpuHistogram != null : !this$cpuHistogram.equals(other$cpuHistogram)) {
            return false;
        }
        Object this$firstSampleStart = this.getFirstSampleStart();
        Object other$firstSampleStart = other.getFirstSampleStart();
        if (this$firstSampleStart == null ? other$firstSampleStart != null : !this$firstSampleStart.equals(other$firstSampleStart)) {
            return false;
        }
        Object this$lastSampleStart = this.getLastSampleStart();
        Object other$lastSampleStart = other.getLastSampleStart();
        if (this$lastSampleStart == null ? other$lastSampleStart != null : !this$lastSampleStart.equals(other$lastSampleStart)) {
            return false;
        }
        Object this$lastUpdateTime = this.getLastUpdateTime();
        Object other$lastUpdateTime = other.getLastUpdateTime();
        if (this$lastUpdateTime == null ? other$lastUpdateTime != null : !this$lastUpdateTime.equals(other$lastUpdateTime)) {
            return false;
        }
        Object this$memoryHistogram = this.getMemoryHistogram();
        Object other$memoryHistogram = other.getMemoryHistogram();
        if (this$memoryHistogram == null ? other$memoryHistogram != null : !this$memoryHistogram.equals(other$memoryHistogram)) {
            return false;
        }
        Object this$totalSamplesCount = this.getTotalSamplesCount();
        Object other$totalSamplesCount = other.getTotalSamplesCount();
        if (this$totalSamplesCount == null ? other$totalSamplesCount != null : !this$totalSamplesCount.equals(other$totalSamplesCount)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        return other instanceof VerticalPodAutoscalerCheckpointStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cpuHistogram = this.getCpuHistogram();
        result = result * prime + ($cpuHistogram == null ? 43 : $cpuHistogram.hashCode());
        Object $firstSampleStart = this.getFirstSampleStart();
        result = result * prime + ($firstSampleStart == null ? 43 : $firstSampleStart.hashCode());
        Object $lastSampleStart = this.getLastSampleStart();
        result = result * prime + ($lastSampleStart == null ? 43 : $lastSampleStart.hashCode());
        Object $lastUpdateTime = this.getLastUpdateTime();
        result = result * prime + ($lastUpdateTime == null ? 43 : $lastUpdateTime.hashCode());
        Object $memoryHistogram = this.getMemoryHistogram();
        result = result * prime + ($memoryHistogram == null ? 43 : $memoryHistogram.hashCode());
        Object $totalSamplesCount = this.getTotalSamplesCount();
        result = result * prime + ($totalSamplesCount == null ? 43 : $totalSamplesCount.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VerticalPodAutoscalerCheckpointStatus(" + "cpuHistogram=" + this.getCpuHistogram() + ", firstSampleStart=" + this.getFirstSampleStart() + ", lastSampleStart=" + this.getLastSampleStart() + ", lastUpdateTime=" + this.getLastUpdateTime() + ", memoryHistogram=" + this.getMemoryHistogram() + ", totalSamplesCount=" + this.getTotalSamplesCount() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
