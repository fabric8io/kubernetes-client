
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
    "remoteCluster",
    "selector",
    "value",
    "volumePath"
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
public class IOChaosSpec implements Editable<IOChaosSpecBuilder>, KubernetesResource
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("attr")
    private AttrOverrideSpec attr;
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> containerNames = new ArrayList<>();
    @JsonProperty("delay")
    private String delay;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("errno")
    private Long errno;
    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> methods = new ArrayList<>();
    @JsonProperty("mistake")
    private MistakeSpec mistake;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("path")
    private String path;
    @JsonProperty("percent")
    private Integer percent;
    @JsonProperty("remoteCluster")
    private String remoteCluster;
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("value")
    private String value;
    @JsonProperty("volumePath")
    private String volumePath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IOChaosSpec() {
    }

    public IOChaosSpec(String action, AttrOverrideSpec attr, List<String> containerNames, String delay, String duration, Long errno, List<String> methods, MistakeSpec mistake, String mode, String path, Integer percent, String remoteCluster, PodSelectorSpec selector, String value, String volumePath) {
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
        this.remoteCluster = remoteCluster;
        this.selector = selector;
        this.value = value;
        this.volumePath = volumePath;
    }

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getContainerNames() {
        return containerNames;
    }

    @JsonProperty("containerNames")
    public void setContainerNames(List<String> containerNames) {
        this.containerNames = containerNames;
    }

    @JsonProperty("delay")
    public String getDelay() {
        return delay;
    }

    @JsonProperty("delay")
    public void setDelay(String delay) {
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
    public Long getErrno() {
        return errno;
    }

    @JsonProperty("errno")
    public void setErrno(Long errno) {
        this.errno = errno;
    }

    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMethods() {
        return methods;
    }

    @JsonProperty("methods")
    public void setMethods(List<String> methods) {
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
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
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

    @JsonProperty("remoteCluster")
    public String getRemoteCluster() {
        return remoteCluster;
    }

    @JsonProperty("remoteCluster")
    public void setRemoteCluster(String remoteCluster) {
        this.remoteCluster = remoteCluster;
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
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("volumePath")
    public String getVolumePath() {
        return volumePath;
    }

    @JsonProperty("volumePath")
    public void setVolumePath(String volumePath) {
        this.volumePath = volumePath;
    }

    @JsonIgnore
    public IOChaosSpecBuilder edit() {
        return new IOChaosSpecBuilder(this);
    }

    @JsonIgnore
    public IOChaosSpecBuilder toBuilder() {
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
