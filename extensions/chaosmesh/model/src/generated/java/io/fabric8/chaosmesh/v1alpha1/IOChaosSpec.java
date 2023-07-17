
package io.fabric8.chaosmesh.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
    "attr",
    "containerNames",
    "delay",
    "duration",
    "errno",
    "methods",
    "mistake",
    "mode",
    "path",
    "percent",
    "selector",
    "value",
    "volumePath"
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
@Generated("jsonschema2pojo")
public class IOChaosSpec implements KubernetesResource
{

    @JsonProperty("action")
    private java.lang.String action;
    @JsonProperty("attr")
    private AttrOverrideSpec attr;
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> containerNames = new ArrayList<java.lang.String>();
    @JsonProperty("delay")
    private java.lang.String delay;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("errno")
    private Integer errno;
    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> methods = new ArrayList<java.lang.String>();
    @JsonProperty("mistake")
    private MistakeSpec mistake;
    @JsonProperty("mode")
    private java.lang.String mode;
    @JsonProperty("path")
    private java.lang.String path;
    @JsonProperty("percent")
    private Integer percent;
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("value")
    private java.lang.String value;
    @JsonProperty("volumePath")
    private java.lang.String volumePath;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IOChaosSpec() {
    }

    public IOChaosSpec(java.lang.String action, AttrOverrideSpec attr, List<java.lang.String> containerNames, java.lang.String delay, String duration, Integer errno, List<java.lang.String> methods, MistakeSpec mistake, java.lang.String mode, java.lang.String path, Integer percent, PodSelectorSpec selector, java.lang.String value, java.lang.String volumePath) {
        super();
        this.action = action;
        this.attr = attr;
        this.containerNames = containerNames;
        this.delay = delay;
        this.duration = duration;
        this.errno = errno;
        this.methods = methods;
        this.mistake = mistake;
        this.mode = mode;
        this.path = path;
        this.percent = percent;
        this.selector = selector;
        this.value = value;
        this.volumePath = volumePath;
    }

    @JsonProperty("action")
    public java.lang.String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(java.lang.String action) {
        this.action = action;
    }

    @JsonProperty("attr")
    public AttrOverrideSpec getAttr() {
        return attr;
    }

    @JsonProperty("attr")
    public void setAttr(AttrOverrideSpec attr) {
        this.attr = attr;
    }

    @JsonProperty("containerNames")
    public List<java.lang.String> getContainerNames() {
        return containerNames;
    }

    @JsonProperty("containerNames")
    public void setContainerNames(List<java.lang.String> containerNames) {
        this.containerNames = containerNames;
    }

    @JsonProperty("delay")
    public java.lang.String getDelay() {
        return delay;
    }

    @JsonProperty("delay")
    public void setDelay(java.lang.String delay) {
        this.delay = delay;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("errno")
    public Integer getErrno() {
        return errno;
    }

    @JsonProperty("errno")
    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    @JsonProperty("methods")
    public List<java.lang.String> getMethods() {
        return methods;
    }

    @JsonProperty("methods")
    public void setMethods(List<java.lang.String> methods) {
        this.methods = methods;
    }

    @JsonProperty("mistake")
    public MistakeSpec getMistake() {
        return mistake;
    }

    @JsonProperty("mistake")
    public void setMistake(MistakeSpec mistake) {
        this.mistake = mistake;
    }

    @JsonProperty("mode")
    public java.lang.String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(java.lang.String mode) {
        this.mode = mode;
    }

    @JsonProperty("path")
    public java.lang.String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(java.lang.String path) {
        this.path = path;
    }

    @JsonProperty("percent")
    public Integer getPercent() {
        return percent;
    }

    @JsonProperty("percent")
    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    @JsonProperty("selector")
    public PodSelectorSpec getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(PodSelectorSpec selector) {
        this.selector = selector;
    }

    @JsonProperty("value")
    public java.lang.String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    @JsonProperty("volumePath")
    public java.lang.String getVolumePath() {
        return volumePath;
    }

    @JsonProperty("volumePath")
    public void setVolumePath(java.lang.String volumePath) {
        this.volumePath = volumePath;
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
