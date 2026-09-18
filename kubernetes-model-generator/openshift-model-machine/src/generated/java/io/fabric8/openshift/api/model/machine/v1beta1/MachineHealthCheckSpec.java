
package io.fabric8.openshift.api.model.machine.v1beta1;

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

/**
 * MachineHealthCheckSpec defines the desired state of MachineHealthCheck
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxUnhealthy",
    "nodeStartupTimeout",
    "remediationTemplate",
    "selector",
    "unhealthyConditions"
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineHealthCheckSpec() {
    }

    public MachineHealthCheckSpec(IntOrString maxUnhealthy, String nodeStartupTimeout, ObjectReference remediationTemplate, LabelSelector selector, List<UnhealthyCondition> unhealthyConditions) {
        super();
        this.maxUnhealthy = maxUnhealthy;
        this.nodeStartupTimeout = nodeStartupTimeout;
        this.remediationTemplate = remediationTemplate;
        this.selector = selector;
        this.unhealthyConditions = unhealthyConditions;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck
     */
    @JsonProperty("maxUnhealthy")
    public IntOrString getMaxUnhealthy() {
        return maxUnhealthy;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck
     */
    @JsonProperty("maxUnhealthy")
    public void setMaxUnhealthy(IntOrString maxUnhealthy) {
        this.maxUnhealthy = maxUnhealthy;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck
     */
    @JsonProperty("nodeStartupTimeout")
    public String getNodeStartupTimeout() {
        return nodeStartupTimeout;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck
     */
    @JsonProperty("nodeStartupTimeout")
    public void setNodeStartupTimeout(String nodeStartupTimeout) {
        this.nodeStartupTimeout = nodeStartupTimeout;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck
     */
    @JsonProperty("remediationTemplate")
    public ObjectReference getRemediationTemplate() {
        return remediationTemplate;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck
     */
    @JsonProperty("remediationTemplate")
    public void setRemediationTemplate(ObjectReference remediationTemplate) {
        this.remediationTemplate = remediationTemplate;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * MachineHealthCheckSpec defines the desired state of MachineHealthCheck
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MachineHealthCheckSpec)) {
            return false;
        }
        MachineHealthCheckSpec other = (MachineHealthCheckSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$maxUnhealthy = this.getMaxUnhealthy();
        Object other$maxUnhealthy = other.getMaxUnhealthy();
        if (this$maxUnhealthy == null ? other$maxUnhealthy != null : !this$maxUnhealthy.equals(other$maxUnhealthy)) {
            return false;
        }
        Object this$nodeStartupTimeout = this.getNodeStartupTimeout();
        Object other$nodeStartupTimeout = other.getNodeStartupTimeout();
        if (this$nodeStartupTimeout == null ? other$nodeStartupTimeout != null : !this$nodeStartupTimeout.equals(other$nodeStartupTimeout)) {
            return false;
        }
        Object this$remediationTemplate = this.getRemediationTemplate();
        Object other$remediationTemplate = other.getRemediationTemplate();
        if (this$remediationTemplate == null ? other$remediationTemplate != null : !this$remediationTemplate.equals(other$remediationTemplate)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$unhealthyConditions = this.getUnhealthyConditions();
        Object other$unhealthyConditions = other.getUnhealthyConditions();
        if (this$unhealthyConditions == null ? other$unhealthyConditions != null : !this$unhealthyConditions.equals(other$unhealthyConditions)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof MachineHealthCheckSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $maxUnhealthy = this.getMaxUnhealthy();
        result = result * prime + ($maxUnhealthy == null ? 43 : $maxUnhealthy.hashCode());
        Object $nodeStartupTimeout = this.getNodeStartupTimeout();
        result = result * prime + ($nodeStartupTimeout == null ? 43 : $nodeStartupTimeout.hashCode());
        Object $remediationTemplate = this.getRemediationTemplate();
        result = result * prime + ($remediationTemplate == null ? 43 : $remediationTemplate.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $unhealthyConditions = this.getUnhealthyConditions();
        result = result * prime + ($unhealthyConditions == null ? 43 : $unhealthyConditions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineHealthCheckSpec(" + "maxUnhealthy=" + this.getMaxUnhealthy() + ", nodeStartupTimeout=" + this.getNodeStartupTimeout() + ", remediationTemplate=" + this.getRemediationTemplate() + ", selector=" + this.getSelector() + ", unhealthyConditions=" + this.getUnhealthyConditions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
