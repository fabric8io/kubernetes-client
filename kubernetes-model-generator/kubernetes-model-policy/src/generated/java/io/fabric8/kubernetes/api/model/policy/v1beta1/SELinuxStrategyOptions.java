
package io.fabric8.kubernetes.api.model.policy.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SELinuxOptions;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * SELinuxStrategyOptions defines the strategy type and any options used to create the strategy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rule",
    "seLinuxOptions"
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
public class SELinuxStrategyOptions implements Editable<SELinuxStrategyOptionsBuilder>, KubernetesResource
{

    @JsonProperty("rule")
    private String rule;
    @JsonProperty("seLinuxOptions")
    private SELinuxOptions seLinuxOptions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SELinuxStrategyOptions() {
    }

    public SELinuxStrategyOptions(String rule, SELinuxOptions seLinuxOptions) {
        super();
        this.rule = rule;
        this.seLinuxOptions = seLinuxOptions;
    }

    /**
     * rule is the strategy that will dictate the allowable labels that may be set.
     */
    @JsonProperty("rule")
    public String getRule() {
        return rule;
    }

    /**
     * rule is the strategy that will dictate the allowable labels that may be set.
     */
    @JsonProperty("rule")
    public void setRule(String rule) {
        this.rule = rule;
    }

    /**
     * SELinuxStrategyOptions defines the strategy type and any options used to create the strategy.
     */
    @JsonProperty("seLinuxOptions")
    public SELinuxOptions getSeLinuxOptions() {
        return seLinuxOptions;
    }

    /**
     * SELinuxStrategyOptions defines the strategy type and any options used to create the strategy.
     */
    @JsonProperty("seLinuxOptions")
    public void setSeLinuxOptions(SELinuxOptions seLinuxOptions) {
        this.seLinuxOptions = seLinuxOptions;
    }

    @JsonIgnore
    public SELinuxStrategyOptionsBuilder edit() {
        return new SELinuxStrategyOptionsBuilder(this);
    }

    @JsonIgnore
    public SELinuxStrategyOptionsBuilder toBuilder() {
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
        if (!(o instanceof SELinuxStrategyOptions)) {
            return false;
        }
        SELinuxStrategyOptions other = (SELinuxStrategyOptions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$rule = this.getRule();
        Object other$rule = other.getRule();
        if (this$rule == null ? other$rule != null : !this$rule.equals(other$rule)) {
            return false;
        }
        Object this$seLinuxOptions = this.getSeLinuxOptions();
        Object other$seLinuxOptions = other.getSeLinuxOptions();
        if (this$seLinuxOptions == null ? other$seLinuxOptions != null : !this$seLinuxOptions.equals(other$seLinuxOptions)) {
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
        return other instanceof SELinuxStrategyOptions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $rule = this.getRule();
        result = result * prime + ($rule == null ? 43 : $rule.hashCode());
        Object $seLinuxOptions = this.getSeLinuxOptions();
        result = result * prime + ($seLinuxOptions == null ? 43 : $seLinuxOptions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SELinuxStrategyOptions(" + "rule=" + this.getRule() + ", seLinuxOptions=" + this.getSeLinuxOptions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
