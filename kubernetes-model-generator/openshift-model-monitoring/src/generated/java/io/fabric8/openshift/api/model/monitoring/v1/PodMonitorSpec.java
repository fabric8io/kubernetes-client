
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "jobLabel",
    "keepDroppedTargets",
    "labelLimit",
    "labelNameLengthLimit",
    "labelValueLengthLimit",
    "namespaceSelector",
    "podMetricsEndpoints",
    "podTargetLabels",
    "sampleLimit",
    "scrapeClass",
    "scrapeProtocols",
    "selector",
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class PodMonitorSpec implements Editable<PodMonitorSpecBuilder> , KubernetesResource
{

    @JsonProperty("attachMetadata")
    private PodMonitorSpecAttachMetadata attachMetadata;
    @JsonProperty("bodySizeLimit")
    private String bodySizeLimit;
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
    private PodMonitorSpecNamespaceSelector namespaceSelector;
    @JsonProperty("podMetricsEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodMonitorSpecPodMetricsEndpoints> podMetricsEndpoints = new ArrayList<>();
    @JsonProperty("podTargetLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> podTargetLabels = new ArrayList<>();
    @JsonProperty("sampleLimit")
    private Long sampleLimit;
    @JsonProperty("scrapeClass")
    private String scrapeClass;
    @JsonProperty("scrapeProtocols")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> scrapeProtocols = new ArrayList<>();
    @JsonProperty("selector")
    private PodMonitorSpecSelector selector;
    @JsonProperty("targetLimit")
    private Long targetLimit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodMonitorSpec() {
    }

    public PodMonitorSpec(PodMonitorSpecAttachMetadata attachMetadata, String bodySizeLimit, String jobLabel, Long keepDroppedTargets, Long labelLimit, Long labelNameLengthLimit, Long labelValueLengthLimit, PodMonitorSpecNamespaceSelector namespaceSelector, List<PodMonitorSpecPodMetricsEndpoints> podMetricsEndpoints, List<String> podTargetLabels, Long sampleLimit, String scrapeClass, List<String> scrapeProtocols, PodMonitorSpecSelector selector, Long targetLimit) {
        super();
        this.attachMetadata = attachMetadata;
        this.bodySizeLimit = bodySizeLimit;
        this.jobLabel = jobLabel;
        this.keepDroppedTargets = keepDroppedTargets;
        this.labelLimit = labelLimit;
        this.labelNameLengthLimit = labelNameLengthLimit;
        this.labelValueLengthLimit = labelValueLengthLimit;
        this.namespaceSelector = namespaceSelector;
        this.podMetricsEndpoints = podMetricsEndpoints;
        this.podTargetLabels = podTargetLabels;
        this.sampleLimit = sampleLimit;
        this.scrapeClass = scrapeClass;
        this.scrapeProtocols = scrapeProtocols;
        this.selector = selector;
        this.targetLimit = targetLimit;
    }

    @JsonProperty("attachMetadata")
    public PodMonitorSpecAttachMetadata getAttachMetadata() {
        return attachMetadata;
    }

    @JsonProperty("attachMetadata")
    public void setAttachMetadata(PodMonitorSpecAttachMetadata attachMetadata) {
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
    public PodMonitorSpecNamespaceSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(PodMonitorSpecNamespaceSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    @JsonProperty("podMetricsEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodMonitorSpecPodMetricsEndpoints> getPodMetricsEndpoints() {
        return podMetricsEndpoints;
    }

    @JsonProperty("podMetricsEndpoints")
    public void setPodMetricsEndpoints(List<PodMonitorSpecPodMetricsEndpoints> podMetricsEndpoints) {
        this.podMetricsEndpoints = podMetricsEndpoints;
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
    public PodMonitorSpecSelector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(PodMonitorSpecSelector selector) {
        this.selector = selector;
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
    public PodMonitorSpecBuilder edit() {
        return new PodMonitorSpecBuilder(this);
    }

    @JsonIgnore
    public PodMonitorSpecBuilder toBuilder() {
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
