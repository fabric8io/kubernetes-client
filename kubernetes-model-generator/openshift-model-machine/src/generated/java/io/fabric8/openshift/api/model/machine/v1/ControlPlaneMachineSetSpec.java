
package io.fabric8.openshift.api.model.machine.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ControlPlaneMachineSet represents the configuration of the ControlPlaneMachineSet.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "machineNamePrefix",
    "replicas",
    "selector",
    "state",
    "strategy",
    "template"
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
public class ControlPlaneMachineSetSpec implements Editable<ControlPlaneMachineSetSpecBuilder>, KubernetesResource
{

    @JsonProperty("machineNamePrefix")
    private String machineNamePrefix;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonProperty("state")
    private String state;
    @JsonProperty("strategy")
    private ControlPlaneMachineSetStrategy strategy;
    @JsonProperty("template")
    private ControlPlaneMachineSetTemplate template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ControlPlaneMachineSetSpec() {
    }

    public ControlPlaneMachineSetSpec(String machineNamePrefix, Integer replicas, LabelSelector selector, String state, ControlPlaneMachineSetStrategy strategy, ControlPlaneMachineSetTemplate template) {
        super();
        this.machineNamePrefix = machineNamePrefix;
        this.replicas = replicas;
        this.selector = selector;
        this.state = state;
        this.strategy = strategy;
        this.template = template;
    }

    /**
     * machineNamePrefix is the prefix used when creating machine names. Each machine name will consist of this prefix, followed by a randomly generated string of 5 characters, and the index of the machine. It must be a lowercase RFC 1123 subdomain, consisting of lowercase alphanumeric characters, hyphens ('-'), and periods ('.'). Each block, separated by periods, must start and end with an alphanumeric character. Hyphens are not allowed at the start or end of a block, and consecutive periods are not permitted. The prefix must be between 1 and 245 characters in length. For example, if machineNamePrefix is set to 'control-plane', and three machines are created, their names might be: control-plane-abcde-0, control-plane-fghij-1, control-plane-klmno-2
     */
    @JsonProperty("machineNamePrefix")
    public String getMachineNamePrefix() {
        return machineNamePrefix;
    }

    /**
     * machineNamePrefix is the prefix used when creating machine names. Each machine name will consist of this prefix, followed by a randomly generated string of 5 characters, and the index of the machine. It must be a lowercase RFC 1123 subdomain, consisting of lowercase alphanumeric characters, hyphens ('-'), and periods ('.'). Each block, separated by periods, must start and end with an alphanumeric character. Hyphens are not allowed at the start or end of a block, and consecutive periods are not permitted. The prefix must be between 1 and 245 characters in length. For example, if machineNamePrefix is set to 'control-plane', and three machines are created, their names might be: control-plane-abcde-0, control-plane-fghij-1, control-plane-klmno-2
     */
    @JsonProperty("machineNamePrefix")
    public void setMachineNamePrefix(String machineNamePrefix) {
        this.machineNamePrefix = machineNamePrefix;
    }

    /**
     * replicas defines how many Control Plane Machines should be created by this ControlPlaneMachineSet. This field is immutable and cannot be changed after cluster installation. The ControlPlaneMachineSet only operates with 3 or 5 node control planes, 3 and 5 are the only valid values for this field.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas defines how many Control Plane Machines should be created by this ControlPlaneMachineSet. This field is immutable and cannot be changed after cluster installation. The ControlPlaneMachineSet only operates with 3 or 5 node control planes, 3 and 5 are the only valid values for this field.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * ControlPlaneMachineSet represents the configuration of the ControlPlaneMachineSet.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * ControlPlaneMachineSet represents the configuration of the ControlPlaneMachineSet.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    /**
     * state defines whether the ControlPlaneMachineSet is Active or Inactive. When Inactive, the ControlPlaneMachineSet will not take any action on the state of the Machines within the cluster. When Active, the ControlPlaneMachineSet will reconcile the Machines and will update the Machines as necessary. Once Active, a ControlPlaneMachineSet cannot be made Inactive. To prevent further action please remove the ControlPlaneMachineSet.
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * state defines whether the ControlPlaneMachineSet is Active or Inactive. When Inactive, the ControlPlaneMachineSet will not take any action on the state of the Machines within the cluster. When Active, the ControlPlaneMachineSet will reconcile the Machines and will update the Machines as necessary. Once Active, a ControlPlaneMachineSet cannot be made Inactive. To prevent further action please remove the ControlPlaneMachineSet.
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * ControlPlaneMachineSet represents the configuration of the ControlPlaneMachineSet.
     */
    @JsonProperty("strategy")
    public ControlPlaneMachineSetStrategy getStrategy() {
        return strategy;
    }

    /**
     * ControlPlaneMachineSet represents the configuration of the ControlPlaneMachineSet.
     */
    @JsonProperty("strategy")
    public void setStrategy(ControlPlaneMachineSetStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * ControlPlaneMachineSet represents the configuration of the ControlPlaneMachineSet.
     */
    @JsonProperty("template")
    public ControlPlaneMachineSetTemplate getTemplate() {
        return template;
    }

    /**
     * ControlPlaneMachineSet represents the configuration of the ControlPlaneMachineSet.
     */
    @JsonProperty("template")
    public void setTemplate(ControlPlaneMachineSetTemplate template) {
        this.template = template;
    }

    @JsonIgnore
    public ControlPlaneMachineSetSpecBuilder edit() {
        return new ControlPlaneMachineSetSpecBuilder(this);
    }

    @JsonIgnore
    public ControlPlaneMachineSetSpecBuilder toBuilder() {
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
        if (!(o instanceof ControlPlaneMachineSetSpec)) {
            return false;
        }
        ControlPlaneMachineSetSpec other = (ControlPlaneMachineSetSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$machineNamePrefix = this.getMachineNamePrefix();
        Object other$machineNamePrefix = other.getMachineNamePrefix();
        if (this$machineNamePrefix == null ? other$machineNamePrefix != null : !this$machineNamePrefix.equals(other$machineNamePrefix)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
            return false;
        }
        Object this$strategy = this.getStrategy();
        Object other$strategy = other.getStrategy();
        if (this$strategy == null ? other$strategy != null : !this$strategy.equals(other$strategy)) {
            return false;
        }
        Object this$template = this.getTemplate();
        Object other$template = other.getTemplate();
        if (this$template == null ? other$template != null : !this$template.equals(other$template)) {
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
        return other instanceof ControlPlaneMachineSetSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $machineNamePrefix = this.getMachineNamePrefix();
        result = result * prime + ($machineNamePrefix == null ? 43 : $machineNamePrefix.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
        Object $strategy = this.getStrategy();
        result = result * prime + ($strategy == null ? 43 : $strategy.hashCode());
        Object $template = this.getTemplate();
        result = result * prime + ($template == null ? 43 : $template.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ControlPlaneMachineSetSpec(" + "machineNamePrefix=" + this.getMachineNamePrefix() + ", replicas=" + this.getReplicas() + ", selector=" + this.getSelector() + ", state=" + this.getState() + ", strategy=" + this.getStrategy() + ", template=" + this.getTemplate() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
