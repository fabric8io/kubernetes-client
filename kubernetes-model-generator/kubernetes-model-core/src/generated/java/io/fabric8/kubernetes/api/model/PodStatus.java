
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
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
    "conditions",
    "containerStatuses",
    "ephemeralContainerStatuses",
    "hostIP",
    "initContainerStatuses",
    "message",
    "nominatedNodeName",
    "phase",
    "podIP",
    "podIPs",
    "qosClass",
    "reason",
    "resize",
    "startTime"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class PodStatus implements KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodCondition> conditions = new ArrayList<PodCondition>();
    @JsonProperty("containerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerStatus> containerStatuses = new ArrayList<ContainerStatus>();
    @JsonProperty("ephemeralContainerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerStatus> ephemeralContainerStatuses = new ArrayList<ContainerStatus>();
    @JsonProperty("hostIP")
    private java.lang.String hostIP;
    @JsonProperty("initContainerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerStatus> initContainerStatuses = new ArrayList<ContainerStatus>();
    @JsonProperty("message")
    private java.lang.String message;
    @JsonProperty("nominatedNodeName")
    private java.lang.String nominatedNodeName;
    @JsonProperty("phase")
    private java.lang.String phase;
    @JsonProperty("podIP")
    private java.lang.String podIP;
    @JsonProperty("podIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodIP> podIPs = new ArrayList<PodIP>();
    @JsonProperty("qosClass")
    private java.lang.String qosClass;
    @JsonProperty("reason")
    private java.lang.String reason;
    @JsonProperty("resize")
    private java.lang.String resize;
    @JsonProperty("startTime")
    private String startTime;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodStatus() {
    }

    public PodStatus(List<PodCondition> conditions, List<ContainerStatus> containerStatuses, List<ContainerStatus> ephemeralContainerStatuses, java.lang.String hostIP, List<ContainerStatus> initContainerStatuses, java.lang.String message, java.lang.String nominatedNodeName, java.lang.String phase, java.lang.String podIP, List<PodIP> podIPs, java.lang.String qosClass, java.lang.String reason, java.lang.String resize, String startTime) {
        super();
        this.conditions = conditions;
        this.containerStatuses = containerStatuses;
        this.ephemeralContainerStatuses = ephemeralContainerStatuses;
        this.hostIP = hostIP;
        this.initContainerStatuses = initContainerStatuses;
        this.message = message;
        this.nominatedNodeName = nominatedNodeName;
        this.phase = phase;
        this.podIP = podIP;
        this.podIPs = podIPs;
        this.qosClass = qosClass;
        this.reason = reason;
        this.resize = resize;
        this.startTime = startTime;
    }

    @JsonProperty("conditions")
    public List<PodCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<PodCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("containerStatuses")
    public List<ContainerStatus> getContainerStatuses() {
        return containerStatuses;
    }

    @JsonProperty("containerStatuses")
    public void setContainerStatuses(List<ContainerStatus> containerStatuses) {
        this.containerStatuses = containerStatuses;
    }

    @JsonProperty("ephemeralContainerStatuses")
    public List<ContainerStatus> getEphemeralContainerStatuses() {
        return ephemeralContainerStatuses;
    }

    @JsonProperty("ephemeralContainerStatuses")
    public void setEphemeralContainerStatuses(List<ContainerStatus> ephemeralContainerStatuses) {
        this.ephemeralContainerStatuses = ephemeralContainerStatuses;
    }

    @JsonProperty("hostIP")
    public java.lang.String getHostIP() {
        return hostIP;
    }

    @JsonProperty("hostIP")
    public void setHostIP(java.lang.String hostIP) {
        this.hostIP = hostIP;
    }

    @JsonProperty("initContainerStatuses")
    public List<ContainerStatus> getInitContainerStatuses() {
        return initContainerStatuses;
    }

    @JsonProperty("initContainerStatuses")
    public void setInitContainerStatuses(List<ContainerStatus> initContainerStatuses) {
        this.initContainerStatuses = initContainerStatuses;
    }

    @JsonProperty("message")
    public java.lang.String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    @JsonProperty("nominatedNodeName")
    public java.lang.String getNominatedNodeName() {
        return nominatedNodeName;
    }

    @JsonProperty("nominatedNodeName")
    public void setNominatedNodeName(java.lang.String nominatedNodeName) {
        this.nominatedNodeName = nominatedNodeName;
    }

    @JsonProperty("phase")
    public java.lang.String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(java.lang.String phase) {
        this.phase = phase;
    }

    @JsonProperty("podIP")
    public java.lang.String getPodIP() {
        return podIP;
    }

    @JsonProperty("podIP")
    public void setPodIP(java.lang.String podIP) {
        this.podIP = podIP;
    }

    @JsonProperty("podIPs")
    public List<PodIP> getPodIPs() {
        return podIPs;
    }

    @JsonProperty("podIPs")
    public void setPodIPs(List<PodIP> podIPs) {
        this.podIPs = podIPs;
    }

    @JsonProperty("qosClass")
    public java.lang.String getQosClass() {
        return qosClass;
    }

    @JsonProperty("qosClass")
    public void setQosClass(java.lang.String qosClass) {
        this.qosClass = qosClass;
    }

    @JsonProperty("reason")
    public java.lang.String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }

    @JsonProperty("resize")
    public java.lang.String getResize() {
        return resize;
    }

    @JsonProperty("resize")
    public void setResize(java.lang.String resize) {
        this.resize = resize;
    }

    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
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
