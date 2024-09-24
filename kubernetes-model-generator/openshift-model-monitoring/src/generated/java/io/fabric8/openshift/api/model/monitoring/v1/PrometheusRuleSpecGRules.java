
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class PrometheusRuleSpecGRules implements Editable<PrometheusRuleSpecGRulesBuilder> , KubernetesResource
{

    @JsonProperty("alert")
    private String alert;
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("expr")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object expr;
    @JsonProperty("for")
    private String _for;
    @JsonProperty("keep_firing_for")
    private String keep_firing_for;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("record")
    private String record;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PrometheusRuleSpecGRules() {
    }

    public PrometheusRuleSpecGRules(String alert, Map<String, String> annotations, Object expr, String _for, String keep_firing_for, Map<String, String> labels, String record) {
        super();
        this.alert = alert;
        this.annotations = annotations;
        this.expr = expr;
        this._for = _for;
        this.keep_firing_for = keep_firing_for;
        this.labels = labels;
        this.record = record;
    }

    @JsonProperty("alert")
    public String getAlert() {
        return alert;
    }

    @JsonProperty("alert")
    public void setAlert(String alert) {
        this.alert = alert;
    }

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("expr")
    public Object getExpr() {
        return expr;
    }

    @JsonProperty("expr")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setExpr(Object expr) {
        this.expr = expr;
    }

    @JsonProperty("for")
    public String getFor() {
        return _for;
    }

    @JsonProperty("for")
    public void setFor(String _for) {
        this._for = _for;
    }

    @JsonProperty("keep_firing_for")
    public String getKeep_firing_for() {
        return keep_firing_for;
    }

    @JsonProperty("keep_firing_for")
    public void setKeep_firing_for(String keep_firing_for) {
        this.keep_firing_for = keep_firing_for;
    }

    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @JsonProperty("record")
    public String getRecord() {
        return record;
    }

    @JsonProperty("record")
    public void setRecord(String record) {
        this.record = record;
    }

    @JsonIgnore
    public PrometheusRuleSpecGRulesBuilder edit() {
        return new PrometheusRuleSpecGRulesBuilder(this);
    }

    @JsonIgnore
    public PrometheusRuleSpecGRulesBuilder toBuilder() {
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
