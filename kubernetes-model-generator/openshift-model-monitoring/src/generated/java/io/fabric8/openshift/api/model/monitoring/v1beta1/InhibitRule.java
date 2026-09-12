
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
     * equal defines labels that must have an equal value in the source and target alert for the inhibition to take effect. This ensures related alerts are properly grouped.
     */
    @JsonProperty("equal")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEqual() {
        return equal;
    }

    /**
     * equal defines labels that must have an equal value in the source and target alert for the inhibition to take effect. This ensures related alerts are properly grouped.
     */
    @JsonProperty("equal")
    public void setEqual(List<String> equal) {
        this.equal = equal;
    }

    /**
     * sourceMatch defines matchers for which one or more alerts have to exist for the inhibition to take effect. The operator enforces that the alert matches the resource's namespace. These are the "trigger" alerts that cause other alerts to be inhibited.
     */
    @JsonProperty("sourceMatch")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Matcher> getSourceMatch() {
        return sourceMatch;
    }

    /**
     * sourceMatch defines matchers for which one or more alerts have to exist for the inhibition to take effect. The operator enforces that the alert matches the resource's namespace. These are the "trigger" alerts that cause other alerts to be inhibited.
     */
    @JsonProperty("sourceMatch")
    public void setSourceMatch(List<Matcher> sourceMatch) {
        this.sourceMatch = sourceMatch;
    }

    /**
     * targetMatch defines matchers that have to be fulfilled in the alerts to be muted. The operator enforces that the alert matches the resource's namespace. When these conditions are met, matching alerts will be inhibited (silenced).
     */
    @JsonProperty("targetMatch")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Matcher> getTargetMatch() {
        return targetMatch;
    }

    /**
     * targetMatch defines matchers that have to be fulfilled in the alerts to be muted. The operator enforces that the alert matches the resource's namespace. When these conditions are met, matching alerts will be inhibited (silenced).
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof InhibitRule)) {
            return false;
        }
        InhibitRule other = (InhibitRule) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$equal = this.getEqual();
        Object other$equal = other.getEqual();
        if (this$equal == null ? other$equal != null : !this$equal.equals(other$equal)) {
            return false;
        }
        Object this$sourceMatch = this.getSourceMatch();
        Object other$sourceMatch = other.getSourceMatch();
        if (this$sourceMatch == null ? other$sourceMatch != null : !this$sourceMatch.equals(other$sourceMatch)) {
            return false;
        }
        Object this$targetMatch = this.getTargetMatch();
        Object other$targetMatch = other.getTargetMatch();
        if (this$targetMatch == null ? other$targetMatch != null : !this$targetMatch.equals(other$targetMatch)) {
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
        return other instanceof InhibitRule;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $equal = this.getEqual();
        result = result * prime + ($equal == null ? 43 : $equal.hashCode());
        Object $sourceMatch = this.getSourceMatch();
        result = result * prime + ($sourceMatch == null ? 43 : $sourceMatch.hashCode());
        Object $targetMatch = this.getTargetMatch();
        result = result * prime + ($targetMatch == null ? 43 : $targetMatch.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "InhibitRule(" + "equal=" + this.getEqual() + ", sourceMatch=" + this.getSourceMatch() + ", targetMatch=" + this.getTargetMatch() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
