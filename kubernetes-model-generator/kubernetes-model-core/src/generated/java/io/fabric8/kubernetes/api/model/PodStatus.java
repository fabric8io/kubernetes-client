
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "containerStatuses",
    "ephemeralContainerStatuses",
    "hostIP",
    "hostIPs",
    "initContainerStatuses",
    "message",
    "nominatedNodeName",
    "phase",
    "podIP",
    "podIPs",
    "qosClass",
    "reason",
    "resize",
    "resourceClaimStatuses",
    "startTime"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodStatus implements Editable<PodStatusBuilder> , KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodCondition> conditions = new ArrayList<>();
    @JsonProperty("containerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerStatus> containerStatuses = new ArrayList<>();
    @JsonProperty("ephemeralContainerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerStatus> ephemeralContainerStatuses = new ArrayList<>();
    @JsonProperty("hostIP")
    private String hostIP;
    @JsonProperty("hostIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HostIP> hostIPs = new ArrayList<>();
    @JsonProperty("initContainerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerStatus> initContainerStatuses = new ArrayList<>();
    @JsonProperty("message")
    private String message;
    @JsonProperty("nominatedNodeName")
    private String nominatedNodeName;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("podIP")
    private String podIP;
    @JsonProperty("podIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodIP> podIPs = new ArrayList<>();
    @JsonProperty("qosClass")
    private String qosClass;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("resize")
    private String resize;
    @JsonProperty("resourceClaimStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodResourceClaimStatus> resourceClaimStatuses = new ArrayList<>();
    @JsonProperty("startTime")
    private String startTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodStatus() {
    }

    public PodStatus(List<PodCondition> conditions, List<ContainerStatus> containerStatuses, List<ContainerStatus> ephemeralContainerStatuses, String hostIP, List<HostIP> hostIPs, List<ContainerStatus> initContainerStatuses, String message, String nominatedNodeName, String phase, String podIP, List<PodIP> podIPs, String qosClass, String reason, String resize, List<PodResourceClaimStatus> resourceClaimStatuses, String startTime) {
        super();
        this.conditions = conditions;
        this.containerStatuses = containerStatuses;
        this.ephemeralContainerStatuses = ephemeralContainerStatuses;
        this.hostIP = hostIP;
        this.hostIPs = hostIPs;
        this.initContainerStatuses = initContainerStatuses;
        this.message = message;
        this.nominatedNodeName = nominatedNodeName;
        this.phase = phase;
        this.podIP = podIP;
        this.podIPs = podIPs;
        this.qosClass = qosClass;
        this.reason = reason;
        this.resize = resize;
        this.resourceClaimStatuses = resourceClaimStatuses;
        this.startTime = startTime;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<PodCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("containerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerStatus> getContainerStatuses() {
        return containerStatuses;
    }

    @JsonProperty("containerStatuses")
    public void setContainerStatuses(List<ContainerStatus> containerStatuses) {
        this.containerStatuses = containerStatuses;
    }

    @JsonProperty("ephemeralContainerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerStatus> getEphemeralContainerStatuses() {
        return ephemeralContainerStatuses;
    }

    @JsonProperty("ephemeralContainerStatuses")
    public void setEphemeralContainerStatuses(List<ContainerStatus> ephemeralContainerStatuses) {
        this.ephemeralContainerStatuses = ephemeralContainerStatuses;
    }

    @JsonProperty("hostIP")
    public String getHostIP() {
        return hostIP;
    }

    @JsonProperty("hostIP")
    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    @JsonProperty("hostIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HostIP> getHostIPs() {
        return hostIPs;
    }

    @JsonProperty("hostIPs")
    public void setHostIPs(List<HostIP> hostIPs) {
        this.hostIPs = hostIPs;
    }

    @JsonProperty("initContainerStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerStatus> getInitContainerStatuses() {
        return initContainerStatuses;
    }

    @JsonProperty("initContainerStatuses")
    public void setInitContainerStatuses(List<ContainerStatus> initContainerStatuses) {
        this.initContainerStatuses = initContainerStatuses;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("nominatedNodeName")
    public String getNominatedNodeName() {
        return nominatedNodeName;
    }

    @JsonProperty("nominatedNodeName")
    public void setNominatedNodeName(String nominatedNodeName) {
        this.nominatedNodeName = nominatedNodeName;
    }

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    @JsonProperty("podIP")
    public String getPodIP() {
        return podIP;
    }

    @JsonProperty("podIP")
    public void setPodIP(String podIP) {
        this.podIP = podIP;
    }

    @JsonProperty("podIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodIP> getPodIPs() {
        return podIPs;
    }

    @JsonProperty("podIPs")
    public void setPodIPs(List<PodIP> podIPs) {
        this.podIPs = podIPs;
    }

    @JsonProperty("qosClass")
    public String getQosClass() {
        return qosClass;
    }

    @JsonProperty("qosClass")
    public void setQosClass(String qosClass) {
        this.qosClass = qosClass;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("resize")
    public String getResize() {
        return resize;
    }

    @JsonProperty("resize")
    public void setResize(String resize) {
        this.resize = resize;
    }

    @JsonProperty("resourceClaimStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodResourceClaimStatus> getResourceClaimStatuses() {
        return resourceClaimStatuses;
    }

    @JsonProperty("resourceClaimStatuses")
    public void setResourceClaimStatuses(List<PodResourceClaimStatus> resourceClaimStatuses) {
        this.resourceClaimStatuses = resourceClaimStatuses;
    }

    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonIgnore
    public PodStatusBuilder edit() {
        return new PodStatusBuilder(this);
    }

    @JsonIgnore
    public PodStatusBuilder toBuilder() {
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
