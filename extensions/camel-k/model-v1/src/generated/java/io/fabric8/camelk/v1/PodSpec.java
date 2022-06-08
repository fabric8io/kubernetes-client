
package io.fabric8.camelk.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EphemeralContainer;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.TopologySpreadConstraint;
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
    "activeDeadlineSeconds",
    "containers",
    "dnsPolicy",
    "ephemeralContainers",
    "initContainers",
    "nodeSelector",
    "restartPolicy",
    "terminationGracePeriodSeconds",
    "topologySpreadConstraints",
    "volumes"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class PodSpec implements KubernetesResource
{

    @JsonProperty("activeDeadlineSeconds")
    private Long activeDeadlineSeconds;
    @JsonProperty("containers")
    private List<io.fabric8.kubernetes.api.model.Container> containers = new ArrayList<io.fabric8.kubernetes.api.model.Container>();
    @JsonProperty("dnsPolicy")
    private java.lang.String dnsPolicy;
    @JsonProperty("ephemeralContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EphemeralContainer> ephemeralContainers = new ArrayList<EphemeralContainer>();
    @JsonProperty("initContainers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.Container> initContainers = new ArrayList<io.fabric8.kubernetes.api.model.Container>();
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<String, String>();
    @JsonProperty("restartPolicy")
    private java.lang.String restartPolicy;
    @JsonProperty("terminationGracePeriodSeconds")
    private Long terminationGracePeriodSeconds;
    @JsonProperty("topologySpreadConstraints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TopologySpreadConstraint> topologySpreadConstraints = new ArrayList<TopologySpreadConstraint>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.Volume> volumes = new ArrayList<io.fabric8.kubernetes.api.model.Volume>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodSpec() {
    }

    /**
     * 
     * @param dnsPolicy
     * @param terminationGracePeriodSeconds
     * @param topologySpreadConstraints
     * @param volumes
     * @param containers
     * @param ephemeralContainers
     * @param restartPolicy
     * @param activeDeadlineSeconds
     * @param initContainers
     * @param nodeSelector
     */
    public PodSpec(Long activeDeadlineSeconds, List<io.fabric8.kubernetes.api.model.Container> containers, java.lang.String dnsPolicy, List<EphemeralContainer> ephemeralContainers, List<io.fabric8.kubernetes.api.model.Container> initContainers, Map<String, String> nodeSelector, java.lang.String restartPolicy, Long terminationGracePeriodSeconds, List<TopologySpreadConstraint> topologySpreadConstraints, List<io.fabric8.kubernetes.api.model.Volume> volumes) {
        super();
        this.activeDeadlineSeconds = activeDeadlineSeconds;
        this.containers = containers;
        this.dnsPolicy = dnsPolicy;
        this.ephemeralContainers = ephemeralContainers;
        this.initContainers = initContainers;
        this.nodeSelector = nodeSelector;
        this.restartPolicy = restartPolicy;
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
        this.topologySpreadConstraints = topologySpreadConstraints;
        this.volumes = volumes;
    }

    @JsonProperty("activeDeadlineSeconds")
    public Long getActiveDeadlineSeconds() {
        return activeDeadlineSeconds;
    }

    @JsonProperty("activeDeadlineSeconds")
    public void setActiveDeadlineSeconds(Long activeDeadlineSeconds) {
        this.activeDeadlineSeconds = activeDeadlineSeconds;
    }

    @JsonProperty("containers")
    public List<io.fabric8.kubernetes.api.model.Container> getContainers() {
        return containers;
    }

    @JsonProperty("containers")
    public void setContainers(List<io.fabric8.kubernetes.api.model.Container> containers) {
        this.containers = containers;
    }

    @JsonProperty("dnsPolicy")
    public java.lang.String getDnsPolicy() {
        return dnsPolicy;
    }

    @JsonProperty("dnsPolicy")
    public void setDnsPolicy(java.lang.String dnsPolicy) {
        this.dnsPolicy = dnsPolicy;
    }

    @JsonProperty("ephemeralContainers")
    public List<EphemeralContainer> getEphemeralContainers() {
        return ephemeralContainers;
    }

    @JsonProperty("ephemeralContainers")
    public void setEphemeralContainers(List<EphemeralContainer> ephemeralContainers) {
        this.ephemeralContainers = ephemeralContainers;
    }

    @JsonProperty("initContainers")
    public List<io.fabric8.kubernetes.api.model.Container> getInitContainers() {
        return initContainers;
    }

    @JsonProperty("initContainers")
    public void setInitContainers(List<io.fabric8.kubernetes.api.model.Container> initContainers) {
        this.initContainers = initContainers;
    }

    @JsonProperty("nodeSelector")
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("restartPolicy")
    public java.lang.String getRestartPolicy() {
        return restartPolicy;
    }

    @JsonProperty("restartPolicy")
    public void setRestartPolicy(java.lang.String restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    @JsonProperty("terminationGracePeriodSeconds")
    public Long getTerminationGracePeriodSeconds() {
        return terminationGracePeriodSeconds;
    }

    @JsonProperty("terminationGracePeriodSeconds")
    public void setTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    }

    @JsonProperty("topologySpreadConstraints")
    public List<TopologySpreadConstraint> getTopologySpreadConstraints() {
        return topologySpreadConstraints;
    }

    @JsonProperty("topologySpreadConstraints")
    public void setTopologySpreadConstraints(List<TopologySpreadConstraint> topologySpreadConstraints) {
        this.topologySpreadConstraints = topologySpreadConstraints;
    }

    @JsonProperty("volumes")
    public List<io.fabric8.kubernetes.api.model.Volume> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<io.fabric8.kubernetes.api.model.Volume> volumes) {
        this.volumes = volumes;
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
