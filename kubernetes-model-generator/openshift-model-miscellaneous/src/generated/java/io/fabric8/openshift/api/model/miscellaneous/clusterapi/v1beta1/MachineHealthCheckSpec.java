
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

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
 * MachineHealthCheckSpec defines the desired state of MachineHealthCheck.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterName",
    "maxUnhealthy",
    "nodeStartupTimeout",
    "remediationTemplate",
    "selector",
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
public class MachineHealthCheckSpec implements Editable<MachineHealthCheckSpecBuilder>, KubernetesResource
{

    @JsonProperty("clusterName")
    private String clusterName;
    @JsonProperty("maxUnhealthy")
    private IntOrString maxUnhealthy;
    @JsonProperty("nodeStartupTimeout")
    private String nodeStartupTimeout;
    @JsonProperty("remediationTemplate")
    private ObjectReference remediationTemplate;
    @JsonProperty("selector")
    private LabelSelector selector;
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
    public MachineHealthCheckSpec() {
    }

    public MachineHealthCheckSpec(String clusterName, IntOrString maxUnhealthy, String nodeStartupTimeout, ObjectReference remediationTemplate, LabelSelector selector, List<UnhealthyCondition> unhealthyConditions, String unhealthyRange) {
        super();
        this.clusterName = clusterName;
        this.maxUnhealthy = maxUnhealthy;
        this.nodeStartupTimeout = nodeStartupTimeout;
        this.remediationTemplate = remediationTemplate;
        this.selector = selector;
        this.unhealthyConditions = unhealthyConditions;
        this.unhealthyRange = unhealthyRange;
    }

    /**
     * clusterName is the name of the Cluster this object belongs to.
     */
    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    /**
     * clusterName is the name of the Cluster this object belongs to.
     */
    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck.
     */
    @JsonProperty("maxUnhealthy")
    public IntOrString getMaxUnhealthy() {
        return maxUnhealthy;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck.
     */
    @JsonProperty("maxUnhealthy")
    public void setMaxUnhealthy(IntOrString maxUnhealthy) {
        this.maxUnhealthy = maxUnhealthy;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck.
     */
    @JsonProperty("nodeStartupTimeout")
    public String getNodeStartupTimeout() {
        return nodeStartupTimeout;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck.
     */
    @JsonProperty("nodeStartupTimeout")
    public void setNodeStartupTimeout(String nodeStartupTimeout) {
        this.nodeStartupTimeout = nodeStartupTimeout;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck.
     */
    @JsonProperty("remediationTemplate")
    public ObjectReference getRemediationTemplate() {
        return remediationTemplate;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck.
     */
    @JsonProperty("remediationTemplate")
    public void setRemediationTemplate(ObjectReference remediationTemplate) {
        this.remediationTemplate = remediationTemplate;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * unhealthyConditions contains a list of the conditions that determine whether a node is considered unhealthy.  The conditions are combined in a logical OR, i.e. if any of the conditions is met, the node is unhealthy.
     */
    @JsonProperty("unhealthyConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<UnhealthyCondition> getUnhealthyConditions() {
        return unhealthyConditions;
    }

    /**
     * unhealthyConditions contains a list of the conditions that determine whether a node is considered unhealthy.  The conditions are combined in a logical OR, i.e. if any of the conditions is met, the node is unhealthy.
     */
    @JsonProperty("unhealthyConditions")
    public void setUnhealthyConditions(List<UnhealthyCondition> unhealthyConditions) {
        this.unhealthyConditions = unhealthyConditions;
    }

    /**
     * unhealthyRange specifies the range of unhealthy machines allowed. Any further remediation is only allowed if the number of machines selected by "selector" as not healthy is within the range of "unhealthyRange". Takes precedence over maxUnhealthy. Eg. "[3-5]" - This means that remediation will be allowed only when: (a) there are at least 3 unhealthy machines (and) (b) there are at most 5 unhealthy machines<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/issues/10722 for more details.
     */
    @JsonProperty("unhealthyRange")
    public String getUnhealthyRange() {
        return unhealthyRange;
    }

    /**
     * unhealthyRange specifies the range of unhealthy machines allowed. Any further remediation is only allowed if the number of machines selected by "selector" as not healthy is within the range of "unhealthyRange". Takes precedence over maxUnhealthy. Eg. "[3-5]" - This means that remediation will be allowed only when: (a) there are at least 3 unhealthy machines (and) (b) there are at most 5 unhealthy machines<br><p> <br><p> Deprecated: This field is deprecated and is going to be removed in the next apiVersion. Please see https://github.com/kubernetes-sigs/cluster-api/issues/10722 for more details.
     */
    @JsonProperty("unhealthyRange")
    public void setUnhealthyRange(String unhealthyRange) {
        this.unhealthyRange = unhealthyRange;
    }

    @JsonIgnore
    public MachineHealthCheckSpecBuilder edit() {
        return new MachineHealthCheckSpecBuilder(this);
    }

    @JsonIgnore
    public MachineHealthCheckSpecBuilder toBuilder() {
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
