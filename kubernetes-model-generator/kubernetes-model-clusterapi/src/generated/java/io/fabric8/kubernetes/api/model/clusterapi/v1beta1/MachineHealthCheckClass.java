
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * MachineHealthCheckClass defines a MachineHealthCheck for a group of Machines.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxUnhealthy",
    "nodeStartupTimeout",
    "remediationTemplate",
    "unhealthyConditions",
    "unhealthyRange"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class MachineHealthCheckClass implements Editable<MachineHealthCheckClassBuilder>, KubernetesResource
{

    @JsonProperty("maxUnhealthy")
    private IntOrString maxUnhealthy;
    @JsonProperty("nodeStartupTimeout")
    private String nodeStartupTimeout;
    @JsonProperty("remediationTemplate")
    private ObjectReference remediationTemplate;
    @JsonProperty("unhealthyConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UnhealthyCondition> unhealthyConditions = new ArrayList<>();
    @JsonProperty("unhealthyRange")
    private String unhealthyRange;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineHealthCheckClass() {
    }

    public MachineHealthCheckClass(IntOrString maxUnhealthy, String nodeStartupTimeout, ObjectReference remediationTemplate, List<UnhealthyCondition> unhealthyConditions, String unhealthyRange) {
        super();
        this.maxUnhealthy = maxUnhealthy;
        this.nodeStartupTimeout = nodeStartupTimeout;
        this.remediationTemplate = remediationTemplate;
        this.unhealthyConditions = unhealthyConditions;
        this.unhealthyRange = unhealthyRange;
    }

    /**
     * MachineHealthCheckClass defines a MachineHealthCheck for a group of Machines.
     */
    @JsonProperty("maxUnhealthy")
    public IntOrString getMaxUnhealthy() {
        return maxUnhealthy;
    }

    /**
     * MachineHealthCheckClass defines a MachineHealthCheck for a group of Machines.
     */
    @JsonProperty("maxUnhealthy")
    public void setMaxUnhealthy(IntOrString maxUnhealthy) {
        this.maxUnhealthy = maxUnhealthy;
    }

    /**
     * MachineHealthCheckClass defines a MachineHealthCheck for a group of Machines.
     */
    @JsonProperty("nodeStartupTimeout")
    public String getNodeStartupTimeout() {
        return nodeStartupTimeout;
    }

    /**
     * MachineHealthCheckClass defines a MachineHealthCheck for a group of Machines.
     */
    @JsonProperty("nodeStartupTimeout")
    public void setNodeStartupTimeout(String nodeStartupTimeout) {
        this.nodeStartupTimeout = nodeStartupTimeout;
    }

    /**
     * MachineHealthCheckClass defines a MachineHealthCheck for a group of Machines.
     */
    @JsonProperty("remediationTemplate")
    public ObjectReference getRemediationTemplate() {
        return remediationTemplate;
    }

    /**
     * MachineHealthCheckClass defines a MachineHealthCheck for a group of Machines.
     */
    @JsonProperty("remediationTemplate")
    public void setRemediationTemplate(ObjectReference remediationTemplate) {
        this.remediationTemplate = remediationTemplate;
    }

    /**
     * unhealthyConditions contains a list of the conditions that determine whether a node is considered unhealthy. The conditions are combined in a logical OR, i.e. if any of the conditions is met, the node is unhealthy.
     */
    @JsonProperty("unhealthyConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<UnhealthyCondition> getUnhealthyConditions() {
        return unhealthyConditions;
    }

    /**
     * unhealthyConditions contains a list of the conditions that determine whether a node is considered unhealthy. The conditions are combined in a logical OR, i.e. if any of the conditions is met, the node is unhealthy.
     */
    @JsonProperty("unhealthyConditions")
    public void setUnhealthyConditions(List<UnhealthyCondition> unhealthyConditions) {
        this.unhealthyConditions = unhealthyConditions;
    }

    /**
     * unhealthyRange specifies the range of unhealthy machines allowed. Any further remediation is only allowed if the number of machines selected by "selector" as not healthy is within the range of "unhealthyRange". Takes precedence over maxUnhealthy. Eg. "[3-5]" - This means that remediation will be allowed only when: (a) there are at least 3 unhealthy machines (and) (b) there are at most 5 unhealthy machines
     */
    @JsonProperty("unhealthyRange")
    public String getUnhealthyRange() {
        return unhealthyRange;
    }

    /**
     * unhealthyRange specifies the range of unhealthy machines allowed. Any further remediation is only allowed if the number of machines selected by "selector" as not healthy is within the range of "unhealthyRange". Takes precedence over maxUnhealthy. Eg. "[3-5]" - This means that remediation will be allowed only when: (a) there are at least 3 unhealthy machines (and) (b) there are at most 5 unhealthy machines
     */
    @JsonProperty("unhealthyRange")
    public void setUnhealthyRange(String unhealthyRange) {
        this.unhealthyRange = unhealthyRange;
    }

    @JsonIgnore
    public MachineHealthCheckClassBuilder edit() {
        return new MachineHealthCheckClassBuilder(this);
    }

    @JsonIgnore
    public MachineHealthCheckClassBuilder toBuilder() {
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
