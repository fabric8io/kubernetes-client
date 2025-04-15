
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
