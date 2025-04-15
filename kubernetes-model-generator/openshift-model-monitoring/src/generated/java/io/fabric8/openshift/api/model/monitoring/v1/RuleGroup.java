
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
 * RuleGroup is a list of sequentially evaluated recording and alerting rules.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "interval",
    "labels",
    "limit",
    "name",
    "partial_response_strategy",
    "query_offset",
    "rules"
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
public class RuleGroup implements Editable<RuleGroupBuilder>, KubernetesResource
{

    @JsonProperty("interval")
    private String interval;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("name")
    private String name;
    @JsonProperty("partial_response_strategy")
    private String partialResponseStrategy;
    @JsonProperty("query_offset")
    private String queryOffset;
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Rule> rules = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RuleGroup() {
    }

    public RuleGroup(String interval, Map<String, String> labels, Integer limit, String name, String partialResponseStrategy, String queryOffset, List<Rule> rules) {
        super();
        this.interval = interval;
        this.labels = labels;
        this.limit = limit;
        this.name = name;
        this.partialResponseStrategy = partialResponseStrategy;
        this.queryOffset = queryOffset;
        this.rules = rules;
    }

    /**
     * Interval determines how often rules in the group are evaluated.
     */
    @JsonProperty("interval")
    public String getInterval() {
        return interval;
    }

    /**
     * Interval determines how often rules in the group are evaluated.
     */
    @JsonProperty("interval")
    public void setInterval(String interval) {
        this.interval = interval;
    }

    /**
     * Labels to add or overwrite before storing the result for its rules. The labels defined at the rule level take precedence.<br><p> <br><p> It requires Prometheus &gt;= 3.0.0. The field is ignored for Thanos Ruler.
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * Labels to add or overwrite before storing the result for its rules. The labels defined at the rule level take precedence.<br><p> <br><p> It requires Prometheus &gt;= 3.0.0. The field is ignored for Thanos Ruler.
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * Limit the number of alerts an alerting rule and series a recording rule can produce. Limit is supported starting with Prometheus &gt;= 2.31 and Thanos Ruler &gt;= 0.24.
     */
    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    /**
     * Limit the number of alerts an alerting rule and series a recording rule can produce. Limit is supported starting with Prometheus &gt;= 2.31 and Thanos Ruler &gt;= 0.24.
     */
    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * Name of the rule group.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the rule group.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * PartialResponseStrategy is only used by ThanosRuler and will be ignored by Prometheus instances. More info: https://github.com/thanos-io/thanos/blob/main/docs/components/rule.md#partial-response
     */
    @JsonProperty("partial_response_strategy")
    public String getPartialResponseStrategy() {
        return partialResponseStrategy;
    }

    /**
     * PartialResponseStrategy is only used by ThanosRuler and will be ignored by Prometheus instances. More info: https://github.com/thanos-io/thanos/blob/main/docs/components/rule.md#partial-response
     */
    @JsonProperty("partial_response_strategy")
    public void setPartialResponseStrategy(String partialResponseStrategy) {
        this.partialResponseStrategy = partialResponseStrategy;
    }

    /**
     * Defines the offset the rule evaluation timestamp of this particular group by the specified duration into the past.<br><p> <br><p> It requires Prometheus &gt;= v2.53.0. It is not supported for ThanosRuler.
     */
    @JsonProperty("query_offset")
    public String getQueryOffset() {
        return queryOffset;
    }

    /**
     * Defines the offset the rule evaluation timestamp of this particular group by the specified duration into the past.<br><p> <br><p> It requires Prometheus &gt;= v2.53.0. It is not supported for ThanosRuler.
     */
    @JsonProperty("query_offset")
    public void setQueryOffset(String queryOffset) {
        this.queryOffset = queryOffset;
    }

    /**
     * List of alerting and recording rules.
     */
    @JsonProperty("rules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Rule> getRules() {
        return rules;
    }

    /**
     * List of alerting and recording rules.
     */
    @JsonProperty("rules")
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    @JsonIgnore
    public RuleGroupBuilder edit() {
        return new RuleGroupBuilder(this);
    }

    @JsonIgnore
    public RuleGroupBuilder toBuilder() {
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
