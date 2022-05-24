
package io.fabric8.chaosmesh.v1alpha1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "action",
    "duration",
    "flags",
    "matchers",
    "mode",
    "scheduler",
    "selector",
    "target",
    "value"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class JVMChaosSpec implements KubernetesResource
{

    @JsonProperty("action")
    private java.lang.String action;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("flags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> flags = new LinkedHashMap<String, String>();
    @JsonProperty("matchers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> matchers = new LinkedHashMap<String, String>();
    @JsonProperty("mode")
    private java.lang.String mode;
    @JsonProperty("scheduler")
    private SchedulerSpec scheduler;
    @JsonProperty("selector")
    private SelectorSpec selector;
    @JsonProperty("target")
    private java.lang.String target;
    @JsonProperty("value")
    private java.lang.String value;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public JVMChaosSpec() {
    }

    /**
     * 
     * @param duration
     * @param mode
     * @param scheduler
     * @param matchers
     * @param flags
     * @param action
     * @param selector
     * @param value
     * @param target
     */
    public JVMChaosSpec(java.lang.String action, String duration, Map<String, String> flags, Map<String, String> matchers, java.lang.String mode, SchedulerSpec scheduler, SelectorSpec selector, java.lang.String target, java.lang.String value) {
        super();
        this.action = action;
        this.duration = duration;
        this.flags = flags;
        this.matchers = matchers;
        this.mode = mode;
        this.scheduler = scheduler;
        this.selector = selector;
        this.target = target;
        this.value = value;
    }

    @JsonProperty("action")
    public java.lang.String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(java.lang.String action) {
        this.action = action;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("flags")
    public Map<String, String> getFlags() {
        return flags;
    }

    @JsonProperty("flags")
    public void setFlags(Map<String, String> flags) {
        this.flags = flags;
    }

    @JsonProperty("matchers")
    public Map<String, String> getMatchers() {
        return matchers;
    }

    @JsonProperty("matchers")
    public void setMatchers(Map<String, String> matchers) {
        this.matchers = matchers;
    }

    @JsonProperty("mode")
    public java.lang.String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(java.lang.String mode) {
        this.mode = mode;
    }

    @JsonProperty("scheduler")
    public SchedulerSpec getScheduler() {
        return scheduler;
    }

    @JsonProperty("scheduler")
    public void setScheduler(SchedulerSpec scheduler) {
        this.scheduler = scheduler;
    }

    @JsonProperty("selector")
    public SelectorSpec getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(SelectorSpec selector) {
        this.selector = selector;
    }

    @JsonProperty("target")
    public java.lang.String getTarget() {
        return target;
    }

    @JsonProperty("target")
    public void setTarget(java.lang.String target) {
        this.target = target;
    }

    @JsonProperty("value")
    public java.lang.String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
