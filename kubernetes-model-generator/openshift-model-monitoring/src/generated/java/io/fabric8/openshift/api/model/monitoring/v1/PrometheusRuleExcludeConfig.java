
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
 * PrometheusRuleExcludeConfig enables users to configure excluded PrometheusRule names and their namespaces to be ignored while enforcing namespace label for alerts and metrics.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ruleName",
    "ruleNamespace"
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
public class PrometheusRuleExcludeConfig implements Editable<PrometheusRuleExcludeConfigBuilder>, KubernetesResource
{

    @JsonProperty("ruleName")
    private String ruleName;
    @JsonProperty("ruleNamespace")
    private String ruleNamespace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PrometheusRuleExcludeConfig() {
    }

    public PrometheusRuleExcludeConfig(String ruleName, String ruleNamespace) {
        super();
        this.ruleName = ruleName;
        this.ruleNamespace = ruleNamespace;
    }

    /**
     * ruleName defines the name of the excluded PrometheusRule object.
     */
    @JsonProperty("ruleName")
    public String getRuleName() {
        return ruleName;
    }

    /**
     * ruleName defines the name of the excluded PrometheusRule object.
     */
    @JsonProperty("ruleName")
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    /**
     * ruleNamespace defines the namespace of the excluded PrometheusRule object.
     */
    @JsonProperty("ruleNamespace")
    public String getRuleNamespace() {
        return ruleNamespace;
    }

    /**
     * ruleNamespace defines the namespace of the excluded PrometheusRule object.
     */
    @JsonProperty("ruleNamespace")
    public void setRuleNamespace(String ruleNamespace) {
        this.ruleNamespace = ruleNamespace;
    }

    @JsonIgnore
    public PrometheusRuleExcludeConfigBuilder edit() {
        return new PrometheusRuleExcludeConfigBuilder(this);
    }

    @JsonIgnore
    public PrometheusRuleExcludeConfigBuilder toBuilder() {
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
        if (!(o instanceof PrometheusRuleExcludeConfig)) {
            return false;
        }
        PrometheusRuleExcludeConfig other = (PrometheusRuleExcludeConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ruleName = this.getRuleName();
        Object other$ruleName = other.getRuleName();
        if (this$ruleName == null ? other$ruleName != null : !this$ruleName.equals(other$ruleName)) {
            return false;
        }
        Object this$ruleNamespace = this.getRuleNamespace();
        Object other$ruleNamespace = other.getRuleNamespace();
        if (this$ruleNamespace == null ? other$ruleNamespace != null : !this$ruleNamespace.equals(other$ruleNamespace)) {
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
        return other instanceof PrometheusRuleExcludeConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ruleName = this.getRuleName();
        result = result * prime + ($ruleName == null ? 43 : $ruleName.hashCode());
        Object $ruleNamespace = this.getRuleNamespace();
        result = result * prime + ($ruleNamespace == null ? 43 : $ruleNamespace.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PrometheusRuleExcludeConfig(" + "ruleName=" + this.getRuleName() + ", ruleNamespace=" + this.getRuleNamespace() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
