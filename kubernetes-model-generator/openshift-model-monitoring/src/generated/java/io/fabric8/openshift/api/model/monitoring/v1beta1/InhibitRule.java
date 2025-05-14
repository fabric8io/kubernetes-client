
package io.fabric8.openshift.api.model.monitoring.v1beta1;

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
 * InhibitRule defines an inhibition rule that allows to mute alerts when other alerts are already firing. See https://prometheus.io/docs/alerting/latest/configuration/#inhibit_rule
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "equal",
    "sourceMatch",
    "targetMatch"
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
public class InhibitRule implements Editable<InhibitRuleBuilder>, KubernetesResource
{

    @JsonProperty("equal")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> equal = new ArrayList<>();
    @JsonProperty("sourceMatch")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Matcher> sourceMatch = new ArrayList<>();
    @JsonProperty("targetMatch")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Matcher> targetMatch = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public InhibitRule() {
    }

    public InhibitRule(List<String> equal, List<Matcher> sourceMatch, List<Matcher> targetMatch) {
        super();
        this.equal = equal;
        this.sourceMatch = sourceMatch;
        this.targetMatch = targetMatch;
    }

    /**
     * Labels that must have an equal value in the source and target alert for the inhibition to take effect.
     */
    @JsonProperty("equal")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEqual() {
        return equal;
    }

    /**
     * Labels that must have an equal value in the source and target alert for the inhibition to take effect.
     */
    @JsonProperty("equal")
    public void setEqual(List<String> equal) {
        this.equal = equal;
    }

    /**
     * Matchers for which one or more alerts have to exist for the inhibition to take effect. The operator enforces that the alert matches the resource's namespace.
     */
    @JsonProperty("sourceMatch")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Matcher> getSourceMatch() {
        return sourceMatch;
    }

    /**
     * Matchers for which one or more alerts have to exist for the inhibition to take effect. The operator enforces that the alert matches the resource's namespace.
     */
    @JsonProperty("sourceMatch")
    public void setSourceMatch(List<Matcher> sourceMatch) {
        this.sourceMatch = sourceMatch;
    }

    /**
     * Matchers that have to be fulfilled in the alerts to be muted. The operator enforces that the alert matches the resource's namespace.
     */
    @JsonProperty("targetMatch")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Matcher> getTargetMatch() {
        return targetMatch;
    }

    /**
     * Matchers that have to be fulfilled in the alerts to be muted. The operator enforces that the alert matches the resource's namespace.
     */
    @JsonProperty("targetMatch")
    public void setTargetMatch(List<Matcher> targetMatch) {
        this.targetMatch = targetMatch;
    }

    @JsonIgnore
    public InhibitRuleBuilder edit() {
        return new InhibitRuleBuilder(this);
    }

    @JsonIgnore
    public InhibitRuleBuilder toBuilder() {
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
