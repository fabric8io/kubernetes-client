
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
     * alert defines the name of the alert. Must be a valid label value. Only one of `record` and `alert` must be set.
     */
    @JsonProperty("alert")
    public String getAlert() {
        return alert;
    }

    /**
     * alert defines the name of the alert. Must be a valid label value. Only one of `record` and `alert` must be set.
     */
    @JsonProperty("alert")
    public void setAlert(String alert) {
        this.alert = alert;
    }

    /**
     * annotations defines annotations to add to each alert. Only valid for alerting rules.
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * annotations defines annotations to add to each alert. Only valid for alerting rules.
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
     * for defines how alerts are considered firing once they have been returned for this long.
     */
    @JsonProperty("for")
    public String getFor() {
        return _for;
    }

    /**
     * for defines how alerts are considered firing once they have been returned for this long.
     */
    @JsonProperty("for")
    public void setFor(String _for) {
        this._for = _for;
    }

    /**
     * keep_firing_for defines how long an alert will continue firing after the condition that triggered it has cleared.
     */
    @JsonProperty("keep_firing_for")
    public String getKeepFiringFor() {
        return keepFiringFor;
    }

    /**
     * keep_firing_for defines how long an alert will continue firing after the condition that triggered it has cleared.
     */
    @JsonProperty("keep_firing_for")
    public void setKeepFiringFor(String keepFiringFor) {
        this.keepFiringFor = keepFiringFor;
    }

    /**
     * labels defines labels to add or overwrite.
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * labels defines labels to add or overwrite.
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * record defines the name of the time series to output to. Must be a valid metric name. Only one of `record` and `alert` must be set.
     */
    @JsonProperty("record")
    public String getRecord() {
        return record;
    }

    /**
     * record defines the name of the time series to output to. Must be a valid metric name. Only one of `record` and `alert` must be set.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Rule)) {
            return false;
        }
        Rule other = (Rule) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$alert = this.getAlert();
        Object other$alert = other.getAlert();
        if (this$alert == null ? other$alert != null : !this$alert.equals(other$alert)) {
            return false;
        }
        Object this$annotations = this.getAnnotations();
        Object other$annotations = other.getAnnotations();
        if (this$annotations == null ? other$annotations != null : !this$annotations.equals(other$annotations)) {
            return false;
        }
        Object this$expr = this.getExpr();
        Object other$expr = other.getExpr();
        if (this$expr == null ? other$expr != null : !this$expr.equals(other$expr)) {
            return false;
        }
        Object this$_for = this.getFor();
        Object other$_for = other.getFor();
        if (this$_for == null ? other$_for != null : !this$_for.equals(other$_for)) {
            return false;
        }
        Object this$keepFiringFor = this.getKeepFiringFor();
        Object other$keepFiringFor = other.getKeepFiringFor();
        if (this$keepFiringFor == null ? other$keepFiringFor != null : !this$keepFiringFor.equals(other$keepFiringFor)) {
            return false;
        }
        Object this$labels = this.getLabels();
        Object other$labels = other.getLabels();
        if (this$labels == null ? other$labels != null : !this$labels.equals(other$labels)) {
            return false;
        }
        Object this$record = this.getRecord();
        Object other$record = other.getRecord();
        if (this$record == null ? other$record != null : !this$record.equals(other$record)) {
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
        return other instanceof Rule;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $alert = this.getAlert();
        result = result * prime + ($alert == null ? 43 : $alert.hashCode());
        Object $annotations = this.getAnnotations();
        result = result * prime + ($annotations == null ? 43 : $annotations.hashCode());
        Object $expr = this.getExpr();
        result = result * prime + ($expr == null ? 43 : $expr.hashCode());
        Object $_for = this.getFor();
        result = result * prime + ($_for == null ? 43 : $_for.hashCode());
        Object $keepFiringFor = this.getKeepFiringFor();
        result = result * prime + ($keepFiringFor == null ? 43 : $keepFiringFor.hashCode());
        Object $labels = this.getLabels();
        result = result * prime + ($labels == null ? 43 : $labels.hashCode());
        Object $record = this.getRecord();
        result = result * prime + ($record == null ? 43 : $record.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Rule(" + "alert=" + this.getAlert() + ", annotations=" + this.getAnnotations() + ", expr=" + this.getExpr() + ", _for=" + this.getFor() + ", keepFiringFor=" + this.getKeepFiringFor() + ", labels=" + this.getLabels() + ", record=" + this.getRecord() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
