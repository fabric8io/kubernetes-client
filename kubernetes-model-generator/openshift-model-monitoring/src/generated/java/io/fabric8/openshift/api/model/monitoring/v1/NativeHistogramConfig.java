
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * NativeHistogramConfig extends the native histogram configuration settings.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "convertClassicHistogramsToNHCB",
    "nativeHistogramBucketLimit",
    "nativeHistogramMinBucketFactor",
    "scrapeClassicHistograms",
    "scrapeNativeHistograms"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NativeHistogramConfig implements Editable<NativeHistogramConfigBuilder>, KubernetesResource
{

    @JsonProperty("convertClassicHistogramsToNHCB")
    private Boolean convertClassicHistogramsToNHCB;
    @JsonProperty("nativeHistogramBucketLimit")
    private Long nativeHistogramBucketLimit;
    @JsonProperty("nativeHistogramMinBucketFactor")
    private Quantity nativeHistogramMinBucketFactor;
    @JsonProperty("scrapeClassicHistograms")
    private Boolean scrapeClassicHistograms;
    @JsonProperty("scrapeNativeHistograms")
    private Boolean scrapeNativeHistograms;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NativeHistogramConfig() {
    }

    public NativeHistogramConfig(Boolean convertClassicHistogramsToNHCB, Long nativeHistogramBucketLimit, Quantity nativeHistogramMinBucketFactor, Boolean scrapeClassicHistograms, Boolean scrapeNativeHistograms) {
        super();
        this.convertClassicHistogramsToNHCB = convertClassicHistogramsToNHCB;
        this.nativeHistogramBucketLimit = nativeHistogramBucketLimit;
        this.nativeHistogramMinBucketFactor = nativeHistogramMinBucketFactor;
        this.scrapeClassicHistograms = scrapeClassicHistograms;
        this.scrapeNativeHistograms = scrapeNativeHistograms;
    }

    /**
     * convertClassicHistogramsToNHCB defines whether to convert all scraped classic histograms into a native histogram with custom buckets. It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("convertClassicHistogramsToNHCB")
    public Boolean getConvertClassicHistogramsToNHCB() {
        return convertClassicHistogramsToNHCB;
    }

    /**
     * convertClassicHistogramsToNHCB defines whether to convert all scraped classic histograms into a native histogram with custom buckets. It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("convertClassicHistogramsToNHCB")
    public void setConvertClassicHistogramsToNHCB(Boolean convertClassicHistogramsToNHCB) {
        this.convertClassicHistogramsToNHCB = convertClassicHistogramsToNHCB;
    }

    /**
     * nativeHistogramBucketLimit defines ff there are more than this many buckets in a native histogram, buckets will be merged to stay within the limit. It requires Prometheus &gt;= v2.45.0.
     */
    @JsonProperty("nativeHistogramBucketLimit")
    public Long getNativeHistogramBucketLimit() {
        return nativeHistogramBucketLimit;
    }

    /**
     * nativeHistogramBucketLimit defines ff there are more than this many buckets in a native histogram, buckets will be merged to stay within the limit. It requires Prometheus &gt;= v2.45.0.
     */
    @JsonProperty("nativeHistogramBucketLimit")
    public void setNativeHistogramBucketLimit(Long nativeHistogramBucketLimit) {
        this.nativeHistogramBucketLimit = nativeHistogramBucketLimit;
    }

    /**
     * NativeHistogramConfig extends the native histogram configuration settings.
     */
    @JsonProperty("nativeHistogramMinBucketFactor")
    public Quantity getNativeHistogramMinBucketFactor() {
        return nativeHistogramMinBucketFactor;
    }

    /**
     * NativeHistogramConfig extends the native histogram configuration settings.
     */
    @JsonProperty("nativeHistogramMinBucketFactor")
    public void setNativeHistogramMinBucketFactor(Quantity nativeHistogramMinBucketFactor) {
        this.nativeHistogramMinBucketFactor = nativeHistogramMinBucketFactor;
    }

    /**
     * scrapeClassicHistograms defines whether to scrape a classic histogram that is also exposed as a native histogram. It requires Prometheus &gt;= v2.45.0.<br><p> <br><p> Notice: `scrapeClassicHistograms` corresponds to the `always_scrape_classic_histograms` field in the Prometheus configuration.
     */
    @JsonProperty("scrapeClassicHistograms")
    public Boolean getScrapeClassicHistograms() {
        return scrapeClassicHistograms;
    }

    /**
     * scrapeClassicHistograms defines whether to scrape a classic histogram that is also exposed as a native histogram. It requires Prometheus &gt;= v2.45.0.<br><p> <br><p> Notice: `scrapeClassicHistograms` corresponds to the `always_scrape_classic_histograms` field in the Prometheus configuration.
     */
    @JsonProperty("scrapeClassicHistograms")
    public void setScrapeClassicHistograms(Boolean scrapeClassicHistograms) {
        this.scrapeClassicHistograms = scrapeClassicHistograms;
    }

    /**
     * scrapeNativeHistograms defines whether to enable scraping of native histograms. It requires Prometheus &gt;= v3.8.0.
     */
    @JsonProperty("scrapeNativeHistograms")
    public Boolean getScrapeNativeHistograms() {
        return scrapeNativeHistograms;
    }

    /**
     * scrapeNativeHistograms defines whether to enable scraping of native histograms. It requires Prometheus &gt;= v3.8.0.
     */
    @JsonProperty("scrapeNativeHistograms")
    public void setScrapeNativeHistograms(Boolean scrapeNativeHistograms) {
        this.scrapeNativeHistograms = scrapeNativeHistograms;
    }

    @JsonIgnore
    public NativeHistogramConfigBuilder edit() {
        return new NativeHistogramConfigBuilder(this);
    }

    @JsonIgnore
    public NativeHistogramConfigBuilder toBuilder() {
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
        if (!(o instanceof NativeHistogramConfig)) {
            return false;
        }
        NativeHistogramConfig other = (NativeHistogramConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$convertClassicHistogramsToNHCB = this.getConvertClassicHistogramsToNHCB();
        Object other$convertClassicHistogramsToNHCB = other.getConvertClassicHistogramsToNHCB();
        if (this$convertClassicHistogramsToNHCB == null ? other$convertClassicHistogramsToNHCB != null : !this$convertClassicHistogramsToNHCB.equals(other$convertClassicHistogramsToNHCB)) {
            return false;
        }
        Object this$nativeHistogramBucketLimit = this.getNativeHistogramBucketLimit();
        Object other$nativeHistogramBucketLimit = other.getNativeHistogramBucketLimit();
        if (this$nativeHistogramBucketLimit == null ? other$nativeHistogramBucketLimit != null : !this$nativeHistogramBucketLimit.equals(other$nativeHistogramBucketLimit)) {
            return false;
        }
        Object this$nativeHistogramMinBucketFactor = this.getNativeHistogramMinBucketFactor();
        Object other$nativeHistogramMinBucketFactor = other.getNativeHistogramMinBucketFactor();
        if (this$nativeHistogramMinBucketFactor == null ? other$nativeHistogramMinBucketFactor != null : !this$nativeHistogramMinBucketFactor.equals(other$nativeHistogramMinBucketFactor)) {
            return false;
        }
        Object this$scrapeClassicHistograms = this.getScrapeClassicHistograms();
        Object other$scrapeClassicHistograms = other.getScrapeClassicHistograms();
        if (this$scrapeClassicHistograms == null ? other$scrapeClassicHistograms != null : !this$scrapeClassicHistograms.equals(other$scrapeClassicHistograms)) {
            return false;
        }
        Object this$scrapeNativeHistograms = this.getScrapeNativeHistograms();
        Object other$scrapeNativeHistograms = other.getScrapeNativeHistograms();
        if (this$scrapeNativeHistograms == null ? other$scrapeNativeHistograms != null : !this$scrapeNativeHistograms.equals(other$scrapeNativeHistograms)) {
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
        return other instanceof NativeHistogramConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $convertClassicHistogramsToNHCB = this.getConvertClassicHistogramsToNHCB();
        result = result * prime + ($convertClassicHistogramsToNHCB == null ? 43 : $convertClassicHistogramsToNHCB.hashCode());
        Object $nativeHistogramBucketLimit = this.getNativeHistogramBucketLimit();
        result = result * prime + ($nativeHistogramBucketLimit == null ? 43 : $nativeHistogramBucketLimit.hashCode());
        Object $nativeHistogramMinBucketFactor = this.getNativeHistogramMinBucketFactor();
        result = result * prime + ($nativeHistogramMinBucketFactor == null ? 43 : $nativeHistogramMinBucketFactor.hashCode());
        Object $scrapeClassicHistograms = this.getScrapeClassicHistograms();
        result = result * prime + ($scrapeClassicHistograms == null ? 43 : $scrapeClassicHistograms.hashCode());
        Object $scrapeNativeHistograms = this.getScrapeNativeHistograms();
        result = result * prime + ($scrapeNativeHistograms == null ? 43 : $scrapeNativeHistograms.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NativeHistogramConfig(" + "convertClassicHistogramsToNHCB=" + this.getConvertClassicHistogramsToNHCB() + ", nativeHistogramBucketLimit=" + this.getNativeHistogramBucketLimit() + ", nativeHistogramMinBucketFactor=" + this.getNativeHistogramMinBucketFactor() + ", scrapeClassicHistograms=" + this.getScrapeClassicHistograms() + ", scrapeNativeHistograms=" + this.getScrapeNativeHistograms() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
