
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PodMonitorSpec contains specification parameters for a PodMonitor.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attachMetadata",
    "bodySizeLimit",
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
    "scrapeProtocols",
    "selector",
    "selectorMechanism",
    "targetLimit"
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

    public PodMonitorSpec(AttachMetadata attachMetadata, String bodySizeLimit, String fallbackScrapeProtocol, String jobLabel, Long keepDroppedTargets, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, NamespaceSelector namespaceSelector, Long nativeHistogramBucketLimit, Quantity nativeHistogramMinBucketFactor, List<PodMetricsEndpoint> podMetricsEndpoints, List<String> podTargetLabels, Long sampleLimit, String scrapeClass, Boolean scrapeClassicHistograms, List<String> scrapeProtocols, LabelSelector selector, String selectorMechanism, Long targetLimit) {
        super();
        this.attachMetadata = attachMetadata;
        this.bodySizeLimit = bodySizeLimit;
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
     * When defined, bodySizeLimit specifies a job level limit on the size of uncompressed response body that will be accepted by Prometheus.<br><p> <br><p> It requires Prometheus &gt;= v2.28.0.
     */
    @JsonProperty("bodySizeLimit")
    public String getBodySizeLimit() {
        return bodySizeLimit;
    }

    /**
     * When defined, bodySizeLimit specifies a job level limit on the size of uncompressed response body that will be accepted by Prometheus.<br><p> <br><p> It requires Prometheus &gt;= v2.28.0.
     */
    @JsonProperty("bodySizeLimit")
    public void setBodySizeLimit(String bodySizeLimit) {
        this.bodySizeLimit = bodySizeLimit;
    }

    /**
     * The protocol to use if a scrape returns blank, unparseable, or otherwise invalid Content-Type.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("fallbackScrapeProtocol")
    public String getFallbackScrapeProtocol() {
        return fallbackScrapeProtocol;
    }

    /**
     * The protocol to use if a scrape returns blank, unparseable, or otherwise invalid Content-Type.<br><p> <br><p> It requires Prometheus &gt;= v3.0.0.
     */
    @JsonProperty("fallbackScrapeProtocol")
    public void setFallbackScrapeProtocol(String fallbackScrapeProtocol) {
        this.fallbackScrapeProtocol = fallbackScrapeProtocol;
    }

    /**
     * The label to use to retrieve the job name from. `jobLabel` selects the label from the associated Kubernetes `Pod` object which will be used as the `job` label for all metrics.<br><p> <br><p> For example if `jobLabel` is set to `foo` and the Kubernetes `Pod` object is labeled with `foo: bar`, then Prometheus adds the `job="bar"` label to all ingested metrics.<br><p> <br><p> If the value of this field is empty, the `job` label of the metrics defaults to the namespace and name of the PodMonitor object (e.g. `&lt;namespace&gt;/&lt;name&gt;`).
     */
    @JsonProperty("jobLabel")
    public String getJobLabel() {
        return jobLabel;
    }

    /**
     * The label to use to retrieve the job name from. `jobLabel` selects the label from the associated Kubernetes `Pod` object which will be used as the `job` label for all metrics.<br><p> <br><p> For example if `jobLabel` is set to `foo` and the Kubernetes `Pod` object is labeled with `foo: bar`, then Prometheus adds the `job="bar"` label to all ingested metrics.<br><p> <br><p> If the value of this field is empty, the `job` label of the metrics defaults to the namespace and name of the PodMonitor object (e.g. `&lt;namespace&gt;/&lt;name&gt;`).
     */
    @JsonProperty("jobLabel")
    public void setJobLabel(String jobLabel) {
        this.jobLabel = jobLabel;
    }

    /**
     * Per-scrape limit on the number of targets dropped by relabeling that will be kept in memory. 0 means no limit.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.
     */
    @JsonProperty("keepDroppedTargets")
    public Long getKeepDroppedTargets() {
        return keepDroppedTargets;
    }

    /**
     * Per-scrape limit on the number of targets dropped by relabeling that will be kept in memory. 0 means no limit.<br><p> <br><p> It requires Prometheus &gt;= v2.47.0.
     */
    @JsonProperty("keepDroppedTargets")
    public void setKeepDroppedTargets(Long keepDroppedTargets) {
        this.keepDroppedTargets = keepDroppedTargets;
    }

    /**
     * Per-scrape limit on number of labels that will be accepted for a sample.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.
     */
    @JsonProperty("labelLimit")
    public Long getLabelLimit() {
        return labelLimit;
    }

    /**
     * Per-scrape limit on number of labels that will be accepted for a sample.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.
     */
    @JsonProperty("labelLimit")
    public void setLabelLimit(Long labelLimit) {
        this.labelLimit = labelLimit;
    }

    /**
     * Per-scrape limit on length of labels name that will be accepted for a sample.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.
     */
    @JsonProperty("labelNameLengthLimit")
    public Long getLabelNameLengthLimit() {
        return labelNameLengthLimit;
    }

    /**
     * Per-scrape limit on length of labels name that will be accepted for a sample.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.
     */
    @JsonProperty("labelNameLengthLimit")
    public void setLabelNameLengthLimit(Long labelNameLengthLimit) {
        this.labelNameLengthLimit = labelNameLengthLimit;
    }

    /**
     * Per-scrape limit on length of labels value that will be accepted for a sample.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.
     */
    @JsonProperty("labelValueLengthLimit")
    public Long getLabelValueLengthLimit() {
        return labelValueLengthLimit;
    }

    /**
     * Per-scrape limit on length of labels value that will be accepted for a sample.<br><p> <br><p> It requires Prometheus &gt;= v2.27.0.
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
     * If there are more than this many buckets in a native histogram, buckets will be merged to stay within the limit. It requires Prometheus &gt;= v2.45.0.
     */
    @JsonProperty("nativeHistogramBucketLimit")
    public Long getNativeHistogramBucketLimit() {
        return nativeHistogramBucketLimit;
    }

    /**
     * If there are more than this many buckets in a native histogram, buckets will be merged to stay within the limit. It requires Prometheus &gt;= v2.45.0.
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
     * Defines how to scrape metrics from the selected pods.
     */
    @JsonProperty("podMetricsEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodMetricsEndpoint> getPodMetricsEndpoints() {
        return podMetricsEndpoints;
    }

    /**
     * Defines how to scrape metrics from the selected pods.
     */
    @JsonProperty("podMetricsEndpoints")
    public void setPodMetricsEndpoints(List<PodMetricsEndpoint> podMetricsEndpoints) {
        this.podMetricsEndpoints = podMetricsEndpoints;
    }

    /**
     * `podTargetLabels` defines the labels which are transferred from the associated Kubernetes `Pod` object onto the ingested metrics.
     */
    @JsonProperty("podTargetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPodTargetLabels() {
        return podTargetLabels;
    }

    /**
     * `podTargetLabels` defines the labels which are transferred from the associated Kubernetes `Pod` object onto the ingested metrics.
     */
    @JsonProperty("podTargetLabels")
    public void setPodTargetLabels(List<String> podTargetLabels) {
        this.podTargetLabels = podTargetLabels;
    }

    /**
     * `sampleLimit` defines a per-scrape limit on the number of scraped samples that will be accepted.
     */
    @JsonProperty("sampleLimit")
    public Long getSampleLimit() {
        return sampleLimit;
    }

    /**
     * `sampleLimit` defines a per-scrape limit on the number of scraped samples that will be accepted.
     */
    @JsonProperty("sampleLimit")
    public void setSampleLimit(Long sampleLimit) {
        this.sampleLimit = sampleLimit;
    }

    /**
     * The scrape class to apply.
     */
    @JsonProperty("scrapeClass")
    public String getScrapeClass() {
        return scrapeClass;
    }

    /**
     * The scrape class to apply.
     */
    @JsonProperty("scrapeClass")
    public void setScrapeClass(String scrapeClass) {
        this.scrapeClass = scrapeClass;
    }

    /**
     * Whether to scrape a classic histogram that is also exposed as a native histogram. It requires Prometheus &gt;= v2.45.0.
     */
    @JsonProperty("scrapeClassicHistograms")
    public Boolean getScrapeClassicHistograms() {
        return scrapeClassicHistograms;
    }

    /**
     * Whether to scrape a classic histogram that is also exposed as a native histogram. It requires Prometheus &gt;= v2.45.0.
     */
    @JsonProperty("scrapeClassicHistograms")
    public void setScrapeClassicHistograms(Boolean scrapeClassicHistograms) {
        this.scrapeClassicHistograms = scrapeClassicHistograms;
    }

    /**
     * `scrapeProtocols` defines the protocols to negotiate during a scrape. It tells clients the protocols supported by Prometheus in order of preference (from most to least preferred).<br><p> <br><p> If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.
     */
    @JsonProperty("scrapeProtocols")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScrapeProtocols() {
        return scrapeProtocols;
    }

    /**
     * `scrapeProtocols` defines the protocols to negotiate during a scrape. It tells clients the protocols supported by Prometheus in order of preference (from most to least preferred).<br><p> <br><p> If unset, Prometheus uses its default value.<br><p> <br><p> It requires Prometheus &gt;= v2.49.0.
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
     * Mechanism used to select the endpoints to scrape. By default, the selection process relies on relabel configurations to filter the discovered targets. Alternatively, you can opt in for role selectors, which may offer better efficiency in large clusters. Which strategy is best for your use case needs to be carefully evaluated.<br><p> <br><p> It requires Prometheus &gt;= v2.17.0.
     */
    @JsonProperty("selectorMechanism")
    public String getSelectorMechanism() {
        return selectorMechanism;
    }

    /**
     * Mechanism used to select the endpoints to scrape. By default, the selection process relies on relabel configurations to filter the discovered targets. Alternatively, you can opt in for role selectors, which may offer better efficiency in large clusters. Which strategy is best for your use case needs to be carefully evaluated.<br><p> <br><p> It requires Prometheus &gt;= v2.17.0.
     */
    @JsonProperty("selectorMechanism")
    public void setSelectorMechanism(String selectorMechanism) {
        this.selectorMechanism = selectorMechanism;
    }

    /**
     * `targetLimit` defines a limit on the number of scraped targets that will be accepted.
     */
    @JsonProperty("targetLimit")
    public Long getTargetLimit() {
        return targetLimit;
    }

    /**
     * `targetLimit` defines a limit on the number of scraped targets that will be accepted.
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

}
