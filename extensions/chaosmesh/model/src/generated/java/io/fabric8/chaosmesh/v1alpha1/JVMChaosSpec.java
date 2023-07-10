
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
    "class",
    "containerNames",
    "cpuCount",
    "duration",
    "exception",
    "latency",
    "memType",
    "method",
    "mode",
    "name",
    "port",
    "ruleData",
    "selector",
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
@Generated("jsonschema2pojo")
public class JVMChaosSpec implements KubernetesResource
{

    @JsonProperty("action")
    private java.lang.String action;
    @JsonProperty("class")
    private java.lang.String className;
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> containerNames = new ArrayList<java.lang.String>();
    @JsonProperty("cpuCount")
    private Integer cpuCount;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("exception")
    private java.lang.String exception;
    @JsonProperty("latency")
    private Integer latency;
    @JsonProperty("memType")
    private java.lang.String memType;
    @JsonProperty("method")
    private java.lang.String method;
    @JsonProperty("mode")
    private java.lang.String mode;
    @JsonProperty("name")
    private java.lang.String name;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("ruleData")
    private java.lang.String ruleData;
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("value")
    private java.lang.String value;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public JVMChaosSpec() {
    }

    public JVMChaosSpec(java.lang.String action, java.lang.String className, List<java.lang.String> containerNames, Integer cpuCount, String duration, java.lang.String exception, Integer latency, java.lang.String memType, java.lang.String method, java.lang.String mode, java.lang.String name, Integer port, java.lang.String ruleData, PodSelectorSpec selector, java.lang.String value) {
        super();
        this.action = action;
        this.className = className;
        this.containerNames = containerNames;
        this.cpuCount = cpuCount;
        this.duration = duration;
        this.exception = exception;
        this.latency = latency;
        this.memType = memType;
        this.method = method;
        this.mode = mode;
        this.name = name;
        this.port = port;
        this.ruleData = ruleData;
        this.selector = selector;
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

    @JsonProperty("class")
    public java.lang.String getClassName() {
        return className;
    }

    @JsonProperty("class")
    public void setClassName(java.lang.String className) {
        this.className = className;
    }

    @JsonProperty("containerNames")
    public List<java.lang.String> getContainerNames() {
        return containerNames;
    }

    @JsonProperty("containerNames")
    public void setContainerNames(List<java.lang.String> containerNames) {
        this.containerNames = containerNames;
    }

    @JsonProperty("cpuCount")
    public Integer getCpuCount() {
        return cpuCount;
    }

    @JsonProperty("cpuCount")
    public void setCpuCount(Integer cpuCount) {
        this.cpuCount = cpuCount;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("exception")
    public java.lang.String getException() {
        return exception;
    }

    @JsonProperty("exception")
    public void setException(java.lang.String exception) {
        this.exception = exception;
    }

    @JsonProperty("latency")
    public Integer getLatency() {
        return latency;
    }

    @JsonProperty("latency")
    public void setLatency(Integer latency) {
        this.latency = latency;
    }

    @JsonProperty("memType")
    public java.lang.String getMemType() {
        return memType;
    }

    @JsonProperty("memType")
    public void setMemType(java.lang.String memType) {
        this.memType = memType;
    }

    @JsonProperty("method")
    public java.lang.String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(java.lang.String method) {
        this.method = method;
    }

    @JsonProperty("mode")
    public java.lang.String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(java.lang.String mode) {
        this.mode = mode;
    }

    @JsonProperty("name")
    public java.lang.String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(java.lang.String name) {
        this.name = name;
    }

    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    @JsonProperty("ruleData")
    public java.lang.String getRuleData() {
        return ruleData;
    }

    @JsonProperty("ruleData")
    public void setRuleData(java.lang.String ruleData) {
        this.ruleData = ruleData;
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

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
