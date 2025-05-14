
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
 * PodHttpChaosRule defines the injection rule for http.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "actions",
    "port",
    "selector",
    "source",
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
public class PodHttpChaosRule implements Editable<PodHttpChaosRuleBuilder>, KubernetesResource
{

    @JsonProperty("actions")
    private PodHttpChaosActions actions;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("selector")
    private PodHttpChaosSelector selector;
    @JsonProperty("source")
    private String source;
    @JsonProperty("target")
    private String target;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodHttpChaosRule() {
    }

    public PodHttpChaosRule(PodHttpChaosActions actions, Integer port, PodHttpChaosSelector selector, String source, String target) {
        super();
        this.actions = actions;
        this.port = port;
        this.selector = selector;
        this.source = source;
        this.target = target;
    }

    /**
     * PodHttpChaosRule defines the injection rule for http.
     */
    @JsonProperty("actions")
    public PodHttpChaosActions getActions() {
        return actions;
    }

    /**
     * PodHttpChaosRule defines the injection rule for http.
     */
    @JsonProperty("actions")
    public void setActions(PodHttpChaosActions actions) {
        this.actions = actions;
    }

    /**
     * Port represents the target port to be proxy of.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * Port represents the target port to be proxy of.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * PodHttpChaosRule defines the injection rule for http.
     */
    @JsonProperty("selector")
    public PodHttpChaosSelector getSelector() {
        return selector;
    }

    /**
     * PodHttpChaosRule defines the injection rule for http.
     */
    @JsonProperty("selector")
    public void setSelector(PodHttpChaosSelector selector) {
        this.selector = selector;
    }

    /**
     * Source represents the source of current rules
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * Source represents the source of current rules
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
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
    public PodHttpChaosRuleBuilder edit() {
        return new PodHttpChaosRuleBuilder(this);
    }

    @JsonIgnore
    public PodHttpChaosRuleBuilder toBuilder() {
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
