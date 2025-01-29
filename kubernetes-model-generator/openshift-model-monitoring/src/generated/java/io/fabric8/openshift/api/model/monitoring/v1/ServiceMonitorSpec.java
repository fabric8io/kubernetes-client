
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attachMetadata",
    "bodySizeLimit",
    "endpoints",
    "fallbackScrapeProtocol",
    "jobLabel",
    "keepDroppedTargets",
    "labelLimit",
    "labelNameLengthLimit",
    "labelValueLengthLimit",
    "namespaceSelector",
    "nativeHistogramBucketLimit",
    "nativeHistogramMinBucketFactor",
    "podTargetLabels",
    "sampleLimit",
    "scrapeClass",
    "scrapeClassicHistograms",
    "scrapeProtocols",
    "selector",
    "selectorMechanism",
    "targetLabels",
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ServiceMonitorSpec implements Editable<ServiceMonitorSpecBuilder>, KubernetesResource
{

    @JsonProperty("attachMetadata")
    private AttachMetadata attachMetadata;
    @JsonProperty("bodySizeLimit")
    private String bodySizeLimit;
    @JsonProperty("endpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Endpoint> endpoints = new ArrayList<>();
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
    @JsonProperty("targetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> targetLabels = new ArrayList<>();
    @JsonProperty("targetLimit")
    private Long targetLimit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServiceMonitorSpec() {
    }

    public ServiceMonitorSpec(AttachMetadata attachMetadata, String bodySizeLimit, List<Endpoint> endpoints, String fallbackScrapeProtocol, String jobLabel, Long keepDroppedTargets, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, NamespaceSelector namespaceSelector, Long nativeHistogramBucketLimit, Quantity nativeHistogramMinBucketFactor, List<String> podTargetLabels, Long sampleLimit, String scrapeClass, Boolean scrapeClassicHistograms, List<String> scrapeProtocols, LabelSelector selector, String selectorMechanism, List<String> targetLabels, Long targetLimit) {
        super();
        this.attachMetadata = attachMetadata;
        this.bodySizeLimit = bodySizeLimit;
        this.endpoints = endpoints;
        this.fallbackScrapeProtocol = fallbackScrapeProtocol;
        this.jobLabel = jobLabel;
        this.keepDroppedTargets = keepDroppedTargets;
        this.labelLimit = labelLimit;
        this.labelNameLengthLimit = labelNameLengthLimit;
        this.labelValueLengthLimit = labelValueLengthLimit;
        this.namespaceSelector = namespaceSelector;
        this.nativeHistogramBucketLimit = nativeHistogramBucketLimit;
        this.nativeHistogramMinBucketFactor = nativeHistogramMinBucketFactor;
        this.podTargetLabels = podTargetLabels;
        this.sampleLimit = sampleLimit;
        this.scrapeClass = scrapeClass;
        this.scrapeClassicHistograms = scrapeClassicHistograms;
        this.scrapeProtocols = scrapeProtocols;
        this.selector = selector;
        this.selectorMechanism = selectorMechanism;
        this.targetLabels = targetLabels;
        this.targetLimit = targetLimit;
    }

    @JsonProperty("attachMetadata")
    public AttachMetadata getAttachMetadata() {
        return attachMetadata;
    }

    @JsonProperty("attachMetadata")
    public void setAttachMetadata(AttachMetadata attachMetadata) {
        this.attachMetadata = attachMetadata;
    }

    @JsonProperty("bodySizeLimit")
    public String getBodySizeLimit() {
        return bodySizeLimit;
    }

    @JsonProperty("bodySizeLimit")
    public void setBodySizeLimit(String bodySizeLimit) {
        this.bodySizeLimit = bodySizeLimit;
    }

    @JsonProperty("endpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

    @JsonProperty("endpoints")
    public void setEndpoints(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }

    @JsonProperty("fallbackScrapeProtocol")
    public String getFallbackScrapeProtocol() {
        return fallbackScrapeProtocol;
    }

    @JsonProperty("fallbackScrapeProtocol")
    public void setFallbackScrapeProtocol(String fallbackScrapeProtocol) {
        this.fallbackScrapeProtocol = fallbackScrapeProtocol;
    }

    @JsonProperty("jobLabel")
    public String getJobLabel() {
        return jobLabel;
    }

    @JsonProperty("jobLabel")
    public void setJobLabel(String jobLabel) {
        this.jobLabel = jobLabel;
    }

    @JsonProperty("keepDroppedTargets")
    public Long getKeepDroppedTargets() {
        return keepDroppedTargets;
    }

    @JsonProperty("keepDroppedTargets")
    public void setKeepDroppedTargets(Long keepDroppedTargets) {
        this.keepDroppedTargets = keepDroppedTargets;
    }

    @JsonProperty("labelLimit")
    public Long getLabelLimit() {
        return labelLimit;
    }

    @JsonProperty("labelLimit")
    public void setLabelLimit(Long labelLimit) {
        this.labelLimit = labelLimit;
    }

    @JsonProperty("labelNameLengthLimit")
    public Long getLabelNameLengthLimit() {
        return labelNameLengthLimit;
    }

    @JsonProperty("labelNameLengthLimit")
    public void setLabelNameLengthLimit(Long labelNameLengthLimit) {
        this.labelNameLengthLimit = labelNameLengthLimit;
    }

    @JsonProperty("labelValueLengthLimit")
    public Long getLabelValueLengthLimit() {
        return labelValueLengthLimit;
    }

    @JsonProperty("labelValueLengthLimit")
    public void setLabelValueLengthLimit(Long labelValueLengthLimit) {
        this.labelValueLengthLimit = labelValueLengthLimit;
    }

    @JsonProperty("namespaceSelector")
    public NamespaceSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(NamespaceSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    @JsonProperty("nativeHistogramBucketLimit")
    public Long getNativeHistogramBucketLimit() {
        return nativeHistogramBucketLimit;
    }

    @JsonProperty("nativeHistogramBucketLimit")
    public void setNativeHistogramBucketLimit(Long nativeHistogramBucketLimit) {
        this.nativeHistogramBucketLimit = nativeHistogramBucketLimit;
    }

    @JsonProperty("nativeHistogramMinBucketFactor")
    public Quantity getNativeHistogramMinBucketFactor() {
        return nativeHistogramMinBucketFactor;
    }

    @JsonProperty("nativeHistogramMinBucketFactor")
    public void setNativeHistogramMinBucketFactor(Quantity nativeHistogramMinBucketFactor) {
        this.nativeHistogramMinBucketFactor = nativeHistogramMinBucketFactor;
    }

    @JsonProperty("podTargetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPodTargetLabels() {
        return podTargetLabels;
    }

    @JsonProperty("podTargetLabels")
    public void setPodTargetLabels(List<String> podTargetLabels) {
        this.podTargetLabels = podTargetLabels;
    }

    @JsonProperty("sampleLimit")
    public Long getSampleLimit() {
        return sampleLimit;
    }

    @JsonProperty("sampleLimit")
    public void setSampleLimit(Long sampleLimit) {
        this.sampleLimit = sampleLimit;
    }

    @JsonProperty("scrapeClass")
    public String getScrapeClass() {
        return scrapeClass;
    }

    @JsonProperty("scrapeClass")
    public void setScrapeClass(String scrapeClass) {
        this.scrapeClass = scrapeClass;
    }

    @JsonProperty("scrapeClassicHistograms")
    public Boolean getScrapeClassicHistograms() {
        return scrapeClassicHistograms;
    }

    @JsonProperty("scrapeClassicHistograms")
    public void setScrapeClassicHistograms(Boolean scrapeClassicHistograms) {
        this.scrapeClassicHistograms = scrapeClassicHistograms;
    }

    @JsonProperty("scrapeProtocols")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getScrapeProtocols() {
        return scrapeProtocols;
    }

    @JsonProperty("scrapeProtocols")
    public void setScrapeProtocols(List<String> scrapeProtocols) {
        this.scrapeProtocols = scrapeProtocols;
    }

    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    @JsonProperty("selectorMechanism")
    public String getSelectorMechanism() {
        return selectorMechanism;
    }

    @JsonProperty("selectorMechanism")
    public void setSelectorMechanism(String selectorMechanism) {
        this.selectorMechanism = selectorMechanism;
    }

    @JsonProperty("targetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTargetLabels() {
        return targetLabels;
    }

    @JsonProperty("targetLabels")
    public void setTargetLabels(List<String> targetLabels) {
        this.targetLabels = targetLabels;
    }

    @JsonProperty("targetLimit")
    public Long getTargetLimit() {
        return targetLimit;
    }

    @JsonProperty("targetLimit")
    public void setTargetLimit(Long targetLimit) {
        this.targetLimit = targetLimit;
    }

    @JsonIgnore
    public ServiceMonitorSpecBuilder edit() {
        return new ServiceMonitorSpecBuilder(this);
    }

    @JsonIgnore
    public ServiceMonitorSpecBuilder toBuilder() {
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
