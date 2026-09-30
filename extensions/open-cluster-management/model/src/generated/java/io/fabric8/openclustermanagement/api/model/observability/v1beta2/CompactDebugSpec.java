
package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "blockMetaFetchConcurrency",
    "downsampleConcurrency",
    "logLevel",
    "waitInterval"
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
public class CompactDebugSpec implements Editable<CompactDebugSpecBuilder>, KubernetesResource
{

    @JsonProperty("blockMetaFetchConcurrency")
    private Integer blockMetaFetchConcurrency;
    @JsonProperty("downsampleConcurrency")
    private Integer downsampleConcurrency;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("waitInterval")
    private String waitInterval;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CompactDebugSpec() {
    }

    public CompactDebugSpec(Integer blockMetaFetchConcurrency, Integer downsampleConcurrency, String logLevel, String waitInterval) {
        super();
        this.blockMetaFetchConcurrency = blockMetaFetchConcurrency;
        this.downsampleConcurrency = downsampleConcurrency;
        this.logLevel = logLevel;
        this.waitInterval = waitInterval;
    }

    /**
     * BlockMetaFetchConcurrency is the number of concurrent requests to fetch block metadata.
     */
    @JsonProperty("blockMetaFetchConcurrency")
    public Integer getBlockMetaFetchConcurrency() {
        return blockMetaFetchConcurrency;
    }

    /**
     * BlockMetaFetchConcurrency is the number of concurrent requests to fetch block metadata.
     */
    @JsonProperty("blockMetaFetchConcurrency")
    public void setBlockMetaFetchConcurrency(Integer blockMetaFetchConcurrency) {
        this.blockMetaFetchConcurrency = blockMetaFetchConcurrency;
    }

    /**
     * DownsampleConcurrency is the number of goroutines to use when downsampling blocks.
     */
    @JsonProperty("downsampleConcurrency")
    public Integer getDownsampleConcurrency() {
        return downsampleConcurrency;
    }

    /**
     * DownsampleConcurrency is the number of goroutines to use when downsampling blocks.
     */
    @JsonProperty("downsampleConcurrency")
    public void setDownsampleConcurrency(Integer downsampleConcurrency) {
        this.downsampleConcurrency = downsampleConcurrency;
    }

    /**
     * LogLevel for the compactor (e.g., debug, info, warn, error).
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * LogLevel for the compactor (e.g., debug, info, warn, error).
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * WaitInterval is the time to wait between compaction cycles. Setting this will also synchronize --compact.cleanup-interval and --compact.progress-interval.
     */
    @JsonProperty("waitInterval")
    public String getWaitInterval() {
        return waitInterval;
    }

    /**
     * WaitInterval is the time to wait between compaction cycles. Setting this will also synchronize --compact.cleanup-interval and --compact.progress-interval.
     */
    @JsonProperty("waitInterval")
    public void setWaitInterval(String waitInterval) {
        this.waitInterval = waitInterval;
    }

    @JsonIgnore
    public CompactDebugSpecBuilder edit() {
        return new CompactDebugSpecBuilder(this);
    }

    @JsonIgnore
    public CompactDebugSpecBuilder toBuilder() {
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
        if (!(o instanceof CompactDebugSpec)) {
            return false;
        }
        CompactDebugSpec other = (CompactDebugSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$blockMetaFetchConcurrency = this.getBlockMetaFetchConcurrency();
        Object other$blockMetaFetchConcurrency = other.getBlockMetaFetchConcurrency();
        if (this$blockMetaFetchConcurrency == null ? other$blockMetaFetchConcurrency != null : !this$blockMetaFetchConcurrency.equals(other$blockMetaFetchConcurrency)) {
            return false;
        }
        Object this$downsampleConcurrency = this.getDownsampleConcurrency();
        Object other$downsampleConcurrency = other.getDownsampleConcurrency();
        if (this$downsampleConcurrency == null ? other$downsampleConcurrency != null : !this$downsampleConcurrency.equals(other$downsampleConcurrency)) {
            return false;
        }
        Object this$logLevel = this.getLogLevel();
        Object other$logLevel = other.getLogLevel();
        if (this$logLevel == null ? other$logLevel != null : !this$logLevel.equals(other$logLevel)) {
            return false;
        }
        Object this$waitInterval = this.getWaitInterval();
        Object other$waitInterval = other.getWaitInterval();
        if (this$waitInterval == null ? other$waitInterval != null : !this$waitInterval.equals(other$waitInterval)) {
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
        return other instanceof CompactDebugSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $blockMetaFetchConcurrency = this.getBlockMetaFetchConcurrency();
        result = result * prime + ($blockMetaFetchConcurrency == null ? 43 : $blockMetaFetchConcurrency.hashCode());
        Object $downsampleConcurrency = this.getDownsampleConcurrency();
        result = result * prime + ($downsampleConcurrency == null ? 43 : $downsampleConcurrency.hashCode());
        Object $logLevel = this.getLogLevel();
        result = result * prime + ($logLevel == null ? 43 : $logLevel.hashCode());
        Object $waitInterval = this.getWaitInterval();
        result = result * prime + ($waitInterval == null ? 43 : $waitInterval.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CompactDebugSpec(" + "blockMetaFetchConcurrency=" + this.getBlockMetaFetchConcurrency() + ", downsampleConcurrency=" + this.getDownsampleConcurrency() + ", logLevel=" + this.getLogLevel() + ", waitInterval=" + this.getWaitInterval() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
