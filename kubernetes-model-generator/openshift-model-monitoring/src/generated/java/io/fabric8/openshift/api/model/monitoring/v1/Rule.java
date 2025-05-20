
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
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Rule describes an alerting or recording rule See Prometheus documentation: [alerting](https://www.prometheus.io/docs/prometheus/latest/configuration/alerting_rules/) or [recording](https://www.prometheus.io/docs/prometheus/latest/configuration/recording_rules/#recording-rules) rule
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alert",
    "annotations",
    "expr",
    "for",
    "keep_firing_for",
    "labels",
    "record"
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
public class Rule implements Editable<RuleBuilder>, KubernetesResource
{

    @JsonProperty("alert")
    private String alert;
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("expr")
    private IntOrString expr;
    @JsonProperty("for")
    private String _for;
    @JsonProperty("keep_firing_for")
    private String keepFiringFor;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("record")
    private String record;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Rule() {
    }

    public Rule(String alert, Map<String, String> annotations, IntOrString expr, String _for, String keepFiringFor, Map<String, String> labels, String record) {
        super();
        this.alert = alert;
        this.annotations = annotations;
        this.expr = expr;
        this._for = _for;
        this.keepFiringFor = keepFiringFor;
        this.labels = labels;
        this.record = record;
    }

    /**
     * Name of the alert. Must be a valid label value. Only one of `record` and `alert` must be set.
     */
    @JsonProperty("alert")
    public String getAlert() {
        return alert;
    }

    /**
     * Name of the alert. Must be a valid label value. Only one of `record` and `alert` must be set.
     */
    @JsonProperty("alert")
    public void setAlert(String alert) {
        this.alert = alert;
    }

    /**
     * Annotations to add to each alert. Only valid for alerting rules.
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * Annotations to add to each alert. Only valid for alerting rules.
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    /**
     * Rule describes an alerting or recording rule See Prometheus documentation: [alerting](https://www.prometheus.io/docs/prometheus/latest/configuration/alerting_rules/) or [recording](https://www.prometheus.io/docs/prometheus/latest/configuration/recording_rules/#recording-rules) rule
     */
    @JsonProperty("expr")
    public IntOrString getExpr() {
        return expr;
    }

    /**
     * Rule describes an alerting or recording rule See Prometheus documentation: [alerting](https://www.prometheus.io/docs/prometheus/latest/configuration/alerting_rules/) or [recording](https://www.prometheus.io/docs/prometheus/latest/configuration/recording_rules/#recording-rules) rule
     */
    @JsonProperty("expr")
    public void setExpr(IntOrString expr) {
        this.expr = expr;
    }

    /**
     * Alerts are considered firing once they have been returned for this long.
     */
    @JsonProperty("for")
    public String getFor() {
        return _for;
    }

    /**
     * Alerts are considered firing once they have been returned for this long.
     */
    @JsonProperty("for")
    public void setFor(String _for) {
        this._for = _for;
    }

    /**
     * KeepFiringFor defines how long an alert will continue firing after the condition that triggered it has cleared.
     */
    @JsonProperty("keep_firing_for")
    public String getKeepFiringFor() {
        return keepFiringFor;
    }

    /**
     * KeepFiringFor defines how long an alert will continue firing after the condition that triggered it has cleared.
     */
    @JsonProperty("keep_firing_for")
    public void setKeepFiringFor(String keepFiringFor) {
        this.keepFiringFor = keepFiringFor;
    }

    /**
     * Labels to add or overwrite.
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * Labels to add or overwrite.
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * Name of the time series to output to. Must be a valid metric name. Only one of `record` and `alert` must be set.
     */
    @JsonProperty("record")
    public String getRecord() {
        return record;
    }

    /**
     * Name of the time series to output to. Must be a valid metric name. Only one of `record` and `alert` must be set.
     */
    @JsonProperty("record")
    public void setRecord(String record) {
        this.record = record;
    }

    @JsonIgnore
    public RuleBuilder edit() {
        return new RuleBuilder(this);
    }

    @JsonIgnore
    public RuleBuilder toBuilder() {
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
