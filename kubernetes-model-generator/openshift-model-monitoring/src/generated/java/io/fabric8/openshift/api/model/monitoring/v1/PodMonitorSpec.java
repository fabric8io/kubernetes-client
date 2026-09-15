
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * PodMonitorSpec contains specification parameters for a PodMonitor.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attachMetadata",
    "bodySizeLimit",
    "convertClassicHistogramsToNHCB",
    "fallbackScrapeProtocol",
    "jobLabel",
    "keepDroppedTargets",
    "labelLimit",
    "labelNameLengthLimit",
    "labelValueLengthLimit",
    "namespaceSelector",
    "nativeHistogramBucketLimit",
    "nativeHistogramMinBucketFactor",
    "podMetricsEndpoints",
    "podTargetLabels",
    "sampleLimit",
    "scrapeClass",
    "scrapeClassicHistograms",
    "scrapeNativeHistograms",
    "scrapeProtocols",
    "selector",
    "selectorMechanism",
    "targetLimit"
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
public class PodMonitorSpec implements Editable<PodMonitorSpecBuilder>, KubernetesResource
{

    @JsonProperty("attachMetadata")
    private AttachMetadata attachMetadata;
    @JsonProperty("bodySizeLimit")
    private String bodySizeLimit;
    @JsonProperty("convertClassicHistogramsToNHCB")
    private Boolean convertClassicHistogramsToNHCB;
    @JsonProperty("fallbackScrapeProtocol")
    private String fallbackScrapeProtocol;
    @JsonProperty("jobLabel")
    private String jobLabel;
    @JsonProperty("keepDroppedTargets")
    private Long keepDroppedTargets;
    @JsonProperty("labelLimit")
    private Long labelLimit;
    @JsonProperty("labelNameLengthLimit")
    private Long labelNameLengthLimit;
    @JsonProperty("labelValueLengthLimit")
    private Long labelValueLengthLimit;
    @JsonProperty("namespaceSelector")
    private NamespaceSelector namespaceSelector;
    @JsonProperty("nativeHistogramBucketLimit")
    private Long nativeHistogramBucketLimit;
    @JsonProperty("nativeHistogramMinBucketFactor")
    private Quantity nativeHistogramMinBucketFactor;
    @JsonProperty("podMetricsEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodMetricsEndpoint> podMetricsEndpoints = new ArrayList<>();
    @JsonProperty("podTargetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> podTargetLabels = new ArrayList<>();
    @JsonProperty("sampleLimit")
    private Long sampleLimit;
    @JsonProperty("scrapeClass")
    private String scrapeClass;
    @JsonProperty("scrapeClassicHistograms")
    private Boolean scrapeClassicHistograms;
    @JsonProperty("scrapeNativeHistograms")
    private Boolean scrapeNativeHistograms;
    @JsonProperty("scrapeProtocols")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scrapeProtocols = new ArrayList<>();
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("selectorMechanism")
    private String selectorMechanism;
    @JsonProperty("targetLimit")
    private Long targetLimit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodMonitorSpec() {
    }

    public PodMonitorSpec(AttachMetadata attachMetadata, String bodySizeLimit, Boolean convertClassicHistogramsToNHCB, String fallbackScrapeProtocol, String jobLabel, Long keepDroppedTargets, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, NamespaceSelector namespaceSelector, Long nativeHistogramBucketLimit, Quantity nativeHistogramMinBucketFactor, List<PodMetricsEndpoint> podMetricsEndpoints, List<String> podTargetLabels, Long sampleLimit, String scrapeClass, Boolean scrapeClassicHistograms, Boolean scrapeNativeHistograms, List<String> scrapeProtocols, LabelSelector selector, String selectorMechanism, Long targetLimit) {
        super();
        this.attachMetadata = attachMetadata;
        this.bodySizeLimit = bodySizeLimit;
        this.convertClassicHistogramsToNHCB = convertClassicHistogramsToNHCB;
        this.fallbackScrapeProtocol = fallbackScrapeProtocol;
        this.jobLabel = jobLabel;
        this.keepDroppedTargets = keepDroppedTargets;
        this.labelLimit = labelLimit;
        this.labelNameLengthLimit = labelNameLengthLimit;
        this.labelValueLengthLimit = labelValueLengthLimit;
        this.namespaceSelector = namespaceSelector;
        this.nativeHistogramBucketLimit = nativeHistogramBucketLimit;
        this.nativeHistogramMinBucketFactor = nativeHistogramMinBucketFactor;
        this.podMetricsEndpoints = podMetricsEndpoints;
        this.podTargetLabels = podTargetLabels;
        this.sampleLimit = sampleLimit;
        this.scrapeClass = scrapeClass;
        this.scrapeClassicHistograms = scrapeClassicHistograms;
        this.scrapeNativeHistograms = scrapeNativeHistograms;
        this.scrapeProtocols = scrapeProtocols;
        this.selector = selector;
        this.selectorMechanism = selectorMechanism;
        this.targetLimit = targetLimit;
    }

    /**
     * PodMonitorSpec contains specification parameters for a PodMonitor.
     */
    @JsonProperty("attachMetadata")
    public AttachMetadata getAttachMetadata() {
        return attachMetadata;
    }

    /**
     * PodMonitorSpec contains specification parameters for a PodMonitor.
     */
    @JsonProperty("attachMetadata")
    public void setAttachMetadata(AttachMetadata attachMetadata) {
        this.attachMetadata = attachMetadata;
    }

    /**
     * bodySizeLimit when defined specifies a job level limit on the size of uncompressed response body that will be accepted by Prometheus.<br><p> <br><p> It requires Prometheus &gt;= v2.28.0.
     */
    @JsonProperty("bodySizeLimit")
    public String getBodySizeLimit() {
        return bodySizeLimit;
    }

    /**
     * bodySizeLimit when defined specifies a job level limit on the size of uncompressed response body that will be accepted by Prometheus.<br><p> <br><p> It requires Prometheus &gt;= v2.28.0.
     */
    @JsonProperty("bodySizeLimit")
    public void setBodySizeLimit(String bodySizeLimit) {
        this.bodySizeLimit = bodySizeLimit;
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
     * fallbackScrapeProtocol defines the protocol to use if a scrape returns blank, unparseable, or otherwise invalid Content-Type.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("fallbackScrapeProtocol")
    public String getFallbackScrapeProtocol() {
        return fallbackScrapeProtocol;
    }

    /**
     * fallbackScrapeProtocol defines the protocol to use if a scrape returns blank, unparseable, or otherwise invalid Content-Type.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("fallbackScrapeProtocol")
    public void setFallbackScrapeProtocol(String fallbackScrapeProtocol) {
        this.fallbackScrapeProtocol = fallbackScrapeProtocol;
    }

    /**
     * jobLabel defines the label to use to retrieve the job name from. `jobLabel` selects the label from the associated Kubernetes `Pod` object which will be used as the `job` label for all metrics.<br><p> <br><p> For example if `jobLabel` is set to `foo` and the Kubernetes `Pod` object is labeled with `foo: bar`, then Prometheus adds the `job="bar"` label to all ingested metrics.<br><p> <br><p> If the value of this field is empty, the `job` label of the metrics defaults to the namespace and name of the PodMonitor object (e.g. `&lt;namespace&gt;/&lt;name&gt;`).
     */
    @JsonProperty("jobLabel")
    public String getJobLabel() {
        return jobLabel;
    }

    /**
     * jobLabel defines the label to use to retrieve the job name from. `jobLabel` selects the label from the associated Kubernetes `Pod` object which will be used as the `job` label for all metrics.<br><p> <br><p> For example if `jobLabel` is set to `foo` and the Kubernetes `Pod` object is labeled with `foo: bar`, then Prometheus adds the `job="bar"` label to all ingested metrics.<br><p> <br><p> If the value of this field is empty, the `job` label of the metrics defaults to the namespace and name of the PodMonitor object (e.g. `&lt;namespace&gt;/&lt;name&gt;`).
     */
    @JsonProperty("jobLabel")
    public void setJobLabel(String jobLabel) {
        this.jobLabel = jobLabel;
    }

    /**
     * keepDroppedTargets defines the per-scrape limit on the number of targets dropped by relabeling that will be kept in memory. 0 means no limit.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.
     */
    @JsonProperty("keepDroppedTargets")
    public Long getKeepDroppedTargets() {
        return keepDroppedTargets;
    }

    /**
     * keepDroppedTargets defines the per-scrape limit on the number of targets dropped by relabeling that will be kept in memory. 0 means no limit.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.
     */
    @JsonProperty("keepDroppedTargets")
    public void setKeepDroppedTargets(Long keepDroppedTargets) {
        this.keepDroppedTargets = keepDroppedTargets;
    }

    /**
     * labelLimit defines the per-scrape limit on number of labels that will be accepted for a sample.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.
     */
    @JsonProperty("labelLimit")
    public Long getLabelLimit() {
        return labelLimit;
    }

    /**
     * labelLimit defines the per-scrape limit on number of labels that will be accepted for a sample.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.
     */
    @JsonProperty("labelLimit")
    public void setLabelLimit(Long labelLimit) {
        this.labelLimit = labelLimit;
    }

    /**
     * labelNameLengthLimit defines the per-scrape limit on length of labels name that will be accepted for a sample.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.
     */
    @JsonProperty("labelNameLengthLimit")
    public Long getLabelNameLengthLimit() {
        return labelNameLengthLimit;
    }

    /**
     * labelNameLengthLimit defines the per-scrape limit on length of labels name that will be accepted for a sample.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.
     */
    @JsonProperty("labelNameLengthLimit")
    public void setLabelNameLengthLimit(Long labelNameLengthLimit) {
        this.labelNameLengthLimit = labelNameLengthLimit;
    }

    /**
     * labelValueLengthLimit defines the per-scrape limit on length of labels value that will be accepted for a sample.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.
     */
    @JsonProperty("labelValueLengthLimit")
    public Long getLabelValueLengthLimit() {
        return labelValueLengthLimit;
    }

    /**
     * labelValueLengthLimit defines the per-scrape limit on length of labels value that will be accepted for a sample.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.
     */
    @JsonProperty("labelValueLengthLimit")
    public void setLabelValueLengthLimit(Long labelValueLengthLimit) {
        this.labelValueLengthLimit = labelValueLengthLimit;
    }

    /**
     * PodMonitorSpec contains specification parameters for a PodMonitor.
     */
    @JsonProperty("namespaceSelector")
    public NamespaceSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * PodMonitorSpec contains specification parameters for a PodMonitor.
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(NamespaceSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
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
     * PodMonitorSpec contains specification parameters for a PodMonitor.
     */
    @JsonProperty("nativeHistogramMinBucketFactor")
    public Quantity getNativeHistogramMinBucketFactor() {
        return nativeHistogramMinBucketFactor;
    }

    /**
     * PodMonitorSpec contains specification parameters for a PodMonitor.
     */
    @JsonProperty("nativeHistogramMinBucketFactor")
    public void setNativeHistogramMinBucketFactor(Quantity nativeHistogramMinBucketFactor) {
        this.nativeHistogramMinBucketFactor = nativeHistogramMinBucketFactor;
    }

    /**
     * podMetricsEndpoints defines how to scrape metrics from the selected pods.
     */
    @JsonProperty("podMetricsEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodMetricsEndpoint> getPodMetricsEndpoints() {
        return podMetricsEndpoints;
    }

    /**
     * podMetricsEndpoints defines how to scrape metrics from the selected pods.
     */
    @JsonProperty("podMetricsEndpoints")
    public void setPodMetricsEndpoints(List<PodMetricsEndpoint> podMetricsEndpoints) {
        this.podMetricsEndpoints = podMetricsEndpoints;
    }

    /**
     * podTargetLabels defines the labels which are transferred from the associated Kubernetes `Pod` object onto the ingested metrics.
     */
    @JsonProperty("podTargetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPodTargetLabels() {
        return podTargetLabels;
    }

    /**
     * podTargetLabels defines the labels which are transferred from the associated Kubernetes `Pod` object onto the ingested metrics.
     */
    @JsonProperty("podTargetLabels")
    public void setPodTargetLabels(List<String> podTargetLabels) {
        this.podTargetLabels = podTargetLabels;
    }

    /**
     * sampleLimit defines a per-scrape limit on the number of scraped samples that will be accepted.
     */
    @JsonProperty("sampleLimit")
    public Long getSampleLimit() {
        return sampleLimit;
    }

    /**
     * sampleLimit defines a per-scrape limit on the number of scraped samples that will be accepted.
     */
    @JsonProperty("sampleLimit")
    public void setSampleLimit(Long sampleLimit) {
        this.sampleLimit = sampleLimit;
    }

    /**
     * scrapeClass defines the scrape class to apply.
     */
    @JsonProperty("scrapeClass")
    public String getScrapeClass() {
        return scrapeClass;
    }

    /**
     * scrapeClass defines the scrape class to apply.
     */
    @JsonProperty("scrapeClass")
    public void setScrapeClass(String scrapeClass) {
        this.scrapeClass = scrapeClass;
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

    /**
     * scrapeProtocols defines the protocols to negotiate during a scrape. It tells clients the protocols supported by Prometheus in order of preference (from most to least preferred).<br><p> <br><p> If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.
     */
    @JsonProperty("scrapeProtocols")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScrapeProtocols() {
        return scrapeProtocols;
    }

    /**
     * scrapeProtocols defines the protocols to negotiate during a scrape. It tells clients the protocols supported by Prometheus in order of preference (from most to least preferred).<br><p> <br><p> If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.
     */
    @JsonProperty("scrapeProtocols")
    public void setScrapeProtocols(List<String> scrapeProtocols) {
        this.scrapeProtocols = scrapeProtocols;
    }

    /**
     * PodMonitorSpec contains specification parameters for a PodMonitor.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * PodMonitorSpec contains specification parameters for a PodMonitor.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * selectorMechanism defines the mechanism used to select the endpoints to scrape. By default, the selection process relies on relabel configurations to filter the discovered targets. Alternatively, you can opt in for role selectors, which may offer better efficiency in large clusters. Which strategy is best for your use case needs to be carefully evaluated.<br><p> <br><p> It requires Prometheus &gt;= v2.17.0.
     */
    @JsonProperty("selectorMechanism")
    public String getSelectorMechanism() {
        return selectorMechanism;
    }

    /**
     * selectorMechanism defines the mechanism used to select the endpoints to scrape. By default, the selection process relies on relabel configurations to filter the discovered targets. Alternatively, you can opt in for role selectors, which may offer better efficiency in large clusters. Which strategy is best for your use case needs to be carefully evaluated.<br><p> <br><p> It requires Prometheus &gt;= v2.17.0.
     */
    @JsonProperty("selectorMechanism")
    public void setSelectorMechanism(String selectorMechanism) {
        this.selectorMechanism = selectorMechanism;
    }

    /**
     * targetLimit defines a limit on the number of scraped targets that will be accepted.
     */
    @JsonProperty("targetLimit")
    public Long getTargetLimit() {
        return targetLimit;
    }

    /**
     * targetLimit defines a limit on the number of scraped targets that will be accepted.
     */
    @JsonProperty("targetLimit")
    public void setTargetLimit(Long targetLimit) {
        this.targetLimit = targetLimit;
    }

    @JsonIgnore
    public PodMonitorSpecBuilder edit() {
        return new PodMonitorSpecBuilder(this);
    }

    @JsonIgnore
    public PodMonitorSpecBuilder toBuilder() {
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
        if (!(o instanceof PodMonitorSpec)) {
            return false;
        }
        PodMonitorSpec other = (PodMonitorSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$attachMetadata = this.getAttachMetadata();
        Object other$attachMetadata = other.getAttachMetadata();
        if (this$attachMetadata == null ? other$attachMetadata != null : !this$attachMetadata.equals(other$attachMetadata)) {
            return false;
        }
        Object this$bodySizeLimit = this.getBodySizeLimit();
        Object other$bodySizeLimit = other.getBodySizeLimit();
        if (this$bodySizeLimit == null ? other$bodySizeLimit != null : !this$bodySizeLimit.equals(other$bodySizeLimit)) {
            return false;
        }
        Object this$convertClassicHistogramsToNHCB = this.getConvertClassicHistogramsToNHCB();
        Object other$convertClassicHistogramsToNHCB = other.getConvertClassicHistogramsToNHCB();
        if (this$convertClassicHistogramsToNHCB == null ? other$convertClassicHistogramsToNHCB != null : !this$convertClassicHistogramsToNHCB.equals(other$convertClassicHistogramsToNHCB)) {
            return false;
        }
        Object this$fallbackScrapeProtocol = this.getFallbackScrapeProtocol();
        Object other$fallbackScrapeProtocol = other.getFallbackScrapeProtocol();
        if (this$fallbackScrapeProtocol == null ? other$fallbackScrapeProtocol != null : !this$fallbackScrapeProtocol.equals(other$fallbackScrapeProtocol)) {
            return false;
        }
        Object this$jobLabel = this.getJobLabel();
        Object other$jobLabel = other.getJobLabel();
        if (this$jobLabel == null ? other$jobLabel != null : !this$jobLabel.equals(other$jobLabel)) {
            return false;
        }
        Object this$keepDroppedTargets = this.getKeepDroppedTargets();
        Object other$keepDroppedTargets = other.getKeepDroppedTargets();
        if (this$keepDroppedTargets == null ? other$keepDroppedTargets != null : !this$keepDroppedTargets.equals(other$keepDroppedTargets)) {
            return false;
        }
        Object this$labelLimit = this.getLabelLimit();
        Object other$labelLimit = other.getLabelLimit();
        if (this$labelLimit == null ? other$labelLimit != null : !this$labelLimit.equals(other$labelLimit)) {
            return false;
        }
        Object this$labelNameLengthLimit = this.getLabelNameLengthLimit();
        Object other$labelNameLengthLimit = other.getLabelNameLengthLimit();
        if (this$labelNameLengthLimit == null ? other$labelNameLengthLimit != null : !this$labelNameLengthLimit.equals(other$labelNameLengthLimit)) {
            return false;
        }
        Object this$labelValueLengthLimit = this.getLabelValueLengthLimit();
        Object other$labelValueLengthLimit = other.getLabelValueLengthLimit();
        if (this$labelValueLengthLimit == null ? other$labelValueLengthLimit != null : !this$labelValueLengthLimit.equals(other$labelValueLengthLimit)) {
            return false;
        }
        Object this$namespaceSelector = this.getNamespaceSelector();
        Object other$namespaceSelector = other.getNamespaceSelector();
        if (this$namespaceSelector == null ? other$namespaceSelector != null : !this$namespaceSelector.equals(other$namespaceSelector)) {
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
        Object this$podMetricsEndpoints = this.getPodMetricsEndpoints();
        Object other$podMetricsEndpoints = other.getPodMetricsEndpoints();
        if (this$podMetricsEndpoints == null ? other$podMetricsEndpoints != null : !this$podMetricsEndpoints.equals(other$podMetricsEndpoints)) {
            return false;
        }
        Object this$podTargetLabels = this.getPodTargetLabels();
        Object other$podTargetLabels = other.getPodTargetLabels();
        if (this$podTargetLabels == null ? other$podTargetLabels != null : !this$podTargetLabels.equals(other$podTargetLabels)) {
            return false;
        }
        Object this$sampleLimit = this.getSampleLimit();
        Object other$sampleLimit = other.getSampleLimit();
        if (this$sampleLimit == null ? other$sampleLimit != null : !this$sampleLimit.equals(other$sampleLimit)) {
            return false;
        }
        Object this$scrapeClass = this.getScrapeClass();
        Object other$scrapeClass = other.getScrapeClass();
        if (this$scrapeClass == null ? other$scrapeClass != null : !this$scrapeClass.equals(other$scrapeClass)) {
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
        Object this$scrapeProtocols = this.getScrapeProtocols();
        Object other$scrapeProtocols = other.getScrapeProtocols();
        if (this$scrapeProtocols == null ? other$scrapeProtocols != null : !this$scrapeProtocols.equals(other$scrapeProtocols)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$selectorMechanism = this.getSelectorMechanism();
        Object other$selectorMechanism = other.getSelectorMechanism();
        if (this$selectorMechanism == null ? other$selectorMechanism != null : !this$selectorMechanism.equals(other$selectorMechanism)) {
            return false;
        }
        Object this$targetLimit = this.getTargetLimit();
        Object other$targetLimit = other.getTargetLimit();
        if (this$targetLimit == null ? other$targetLimit != null : !this$targetLimit.equals(other$targetLimit)) {
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
        return other instanceof PodMonitorSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $attachMetadata = this.getAttachMetadata();
        result = result * prime + ($attachMetadata == null ? 43 : $attachMetadata.hashCode());
        Object $bodySizeLimit = this.getBodySizeLimit();
        result = result * prime + ($bodySizeLimit == null ? 43 : $bodySizeLimit.hashCode());
        Object $convertClassicHistogramsToNHCB = this.getConvertClassicHistogramsToNHCB();
        result = result * prime + ($convertClassicHistogramsToNHCB == null ? 43 : $convertClassicHistogramsToNHCB.hashCode());
        Object $fallbackScrapeProtocol = this.getFallbackScrapeProtocol();
        result = result * prime + ($fallbackScrapeProtocol == null ? 43 : $fallbackScrapeProtocol.hashCode());
        Object $jobLabel = this.getJobLabel();
        result = result * prime + ($jobLabel == null ? 43 : $jobLabel.hashCode());
        Object $keepDroppedTargets = this.getKeepDroppedTargets();
        result = result * prime + ($keepDroppedTargets == null ? 43 : $keepDroppedTargets.hashCode());
        Object $labelLimit = this.getLabelLimit();
        result = result * prime + ($labelLimit == null ? 43 : $labelLimit.hashCode());
        Object $labelNameLengthLimit = this.getLabelNameLengthLimit();
        result = result * prime + ($labelNameLengthLimit == null ? 43 : $labelNameLengthLimit.hashCode());
        Object $labelValueLengthLimit = this.getLabelValueLengthLimit();
        result = result * prime + ($labelValueLengthLimit == null ? 43 : $labelValueLengthLimit.hashCode());
        Object $namespaceSelector = this.getNamespaceSelector();
        result = result * prime + ($namespaceSelector == null ? 43 : $namespaceSelector.hashCode());
        Object $nativeHistogramBucketLimit = this.getNativeHistogramBucketLimit();
        result = result * prime + ($nativeHistogramBucketLimit == null ? 43 : $nativeHistogramBucketLimit.hashCode());
        Object $nativeHistogramMinBucketFactor = this.getNativeHistogramMinBucketFactor();
        result = result * prime + ($nativeHistogramMinBucketFactor == null ? 43 : $nativeHistogramMinBucketFactor.hashCode());
        Object $podMetricsEndpoints = this.getPodMetricsEndpoints();
        result = result * prime + ($podMetricsEndpoints == null ? 43 : $podMetricsEndpoints.hashCode());
        Object $podTargetLabels = this.getPodTargetLabels();
        result = result * prime + ($podTargetLabels == null ? 43 : $podTargetLabels.hashCode());
        Object $sampleLimit = this.getSampleLimit();
        result = result * prime + ($sampleLimit == null ? 43 : $sampleLimit.hashCode());
        Object $scrapeClass = this.getScrapeClass();
        result = result * prime + ($scrapeClass == null ? 43 : $scrapeClass.hashCode());
        Object $scrapeClassicHistograms = this.getScrapeClassicHistograms();
        result = result * prime + ($scrapeClassicHistograms == null ? 43 : $scrapeClassicHistograms.hashCode());
        Object $scrapeNativeHistograms = this.getScrapeNativeHistograms();
        result = result * prime + ($scrapeNativeHistograms == null ? 43 : $scrapeNativeHistograms.hashCode());
        Object $scrapeProtocols = this.getScrapeProtocols();
        result = result * prime + ($scrapeProtocols == null ? 43 : $scrapeProtocols.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $selectorMechanism = this.getSelectorMechanism();
        result = result * prime + ($selectorMechanism == null ? 43 : $selectorMechanism.hashCode());
        Object $targetLimit = this.getTargetLimit();
        result = result * prime + ($targetLimit == null ? 43 : $targetLimit.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodMonitorSpec(" + "attachMetadata=" + this.getAttachMetadata() + ", bodySizeLimit=" + this.getBodySizeLimit() + ", convertClassicHistogramsToNHCB=" + this.getConvertClassicHistogramsToNHCB() + ", fallbackScrapeProtocol=" + this.getFallbackScrapeProtocol() + ", jobLabel=" + this.getJobLabel() + ", keepDroppedTargets=" + this.getKeepDroppedTargets() + ", labelLimit=" + this.getLabelLimit() + ", labelNameLengthLimit=" + this.getLabelNameLengthLimit() + ", labelValueLengthLimit=" + this.getLabelValueLengthLimit() + ", namespaceSelector=" + this.getNamespaceSelector() + ", nativeHistogramBucketLimit=" + this.getNativeHistogramBucketLimit() + ", nativeHistogramMinBucketFactor=" + this.getNativeHistogramMinBucketFactor() + ", podMetricsEndpoints=" + this.getPodMetricsEndpoints() + ", podTargetLabels=" + this.getPodTargetLabels() + ", sampleLimit=" + this.getSampleLimit() + ", scrapeClass=" + this.getScrapeClass() + ", scrapeClassicHistograms=" + this.getScrapeClassicHistograms() + ", scrapeNativeHistograms=" + this.getScrapeNativeHistograms() + ", scrapeProtocols=" + this.getScrapeProtocols() + ", selector=" + this.getSelector() + ", selectorMechanism=" + this.getSelectorMechanism() + ", targetLimit=" + this.getTargetLimit() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
