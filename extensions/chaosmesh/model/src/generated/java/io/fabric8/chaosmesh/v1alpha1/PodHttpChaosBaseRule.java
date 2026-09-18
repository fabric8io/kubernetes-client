
package io.fabric8.chaosmesh.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PodHttpChaosBaseRule defines the injection rule without source and port.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "actions",
    "selector",
    "target"
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
public class PodHttpChaosBaseRule implements Editable<PodHttpChaosBaseRuleBuilder>, KubernetesResource
{

    @JsonProperty("actions")
    private PodHttpChaosActions actions;
    @JsonProperty("selector")
    private PodHttpChaosSelector selector;
    @JsonProperty("target")
    private String target;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodHttpChaosBaseRule() {
    }

    public PodHttpChaosBaseRule(PodHttpChaosActions actions, PodHttpChaosSelector selector, String target) {
        super();
        this.actions = actions;
        this.selector = selector;
        this.target = target;
    }

    /**
     * PodHttpChaosBaseRule defines the injection rule without source and port.
     */
    @JsonProperty("actions")
    public PodHttpChaosActions getActions() {
        return actions;
    }

    /**
     * PodHttpChaosBaseRule defines the injection rule without source and port.
     */
    @JsonProperty("actions")
    public void setActions(PodHttpChaosActions actions) {
        this.actions = actions;
    }

    /**
     * PodHttpChaosBaseRule defines the injection rule without source and port.
     */
    @JsonProperty("selector")
    public PodHttpChaosSelector getSelector() {
        return selector;
    }

    /**
     * PodHttpChaosBaseRule defines the injection rule without source and port.
     */
    @JsonProperty("selector")
    public void setSelector(PodHttpChaosSelector selector) {
        this.selector = selector;
    }

    /**
     * Target is the object to be selected and injected, &lt;Request|Response&gt;.
     */
    @JsonProperty("target")
    public String getTarget() {
        return target;
    }

    /**
     * Target is the object to be selected and injected, &lt;Request|Response&gt;.
     */
    @JsonProperty("target")
    public void setTarget(String target) {
        this.target = target;
    }

    @JsonIgnore
    public PodHttpChaosBaseRuleBuilder edit() {
        return new PodHttpChaosBaseRuleBuilder(this);
    }

    @JsonIgnore
    public PodHttpChaosBaseRuleBuilder toBuilder() {
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
        if (!(o instanceof PodHttpChaosBaseRule)) {
            return false;
        }
        PodHttpChaosBaseRule other = (PodHttpChaosBaseRule) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$actions = this.getActions();
        Object other$actions = other.getActions();
        if (this$actions == null ? other$actions != null : !this$actions.equals(other$actions)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$target = this.getTarget();
        Object other$target = other.getTarget();
        if (this$target == null ? other$target != null : !this$target.equals(other$target)) {
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
        return other instanceof PodHttpChaosBaseRule;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $actions = this.getActions();
        result = result * prime + ($actions == null ? 43 : $actions.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $target = this.getTarget();
        result = result * prime + ($target == null ? 43 : $target.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodHttpChaosBaseRule(" + "actions=" + this.getActions() + ", selector=" + this.getSelector() + ", target=" + this.getTarget() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
