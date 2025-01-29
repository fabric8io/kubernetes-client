
package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

import java.util.LinkedHashMap;
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

/**
 * PolicyAutomationSpec defines how and when automation is initiated for the referenced policy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "automationDef",
    "delayAfterRunSeconds",
    "eventHook",
    "mode",
    "policyRef",
    "rescanAfter"
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
public class PolicyAutomationSpec implements Editable<PolicyAutomationSpecBuilder>, KubernetesResource
{

    @JsonProperty("automationDef")
    private AutomationDef automationDef;
    @JsonProperty("delayAfterRunSeconds")
    private Integer delayAfterRunSeconds;
    @JsonProperty("eventHook")
    private String eventHook;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("policyRef")
    private String policyRef;
    @JsonProperty("rescanAfter")
    private String rescanAfter;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PolicyAutomationSpec() {
    }

    public PolicyAutomationSpec(AutomationDef automationDef, Integer delayAfterRunSeconds, String eventHook, String mode, String policyRef, String rescanAfter) {
        super();
        this.automationDef = automationDef;
        this.delayAfterRunSeconds = delayAfterRunSeconds;
        this.eventHook = eventHook;
        this.mode = mode;
        this.policyRef = policyRef;
        this.rescanAfter = rescanAfter;
    }

    /**
     * PolicyAutomationSpec defines how and when automation is initiated for the referenced policy.
     */
    @JsonProperty("automationDef")
    public AutomationDef getAutomationDef() {
        return automationDef;
    }

    /**
     * PolicyAutomationSpec defines how and when automation is initiated for the referenced policy.
     */
    @JsonProperty("automationDef")
    public void setAutomationDef(AutomationDef automationDef) {
        this.automationDef = automationDef;
    }

    /**
     * DelayAfterRunSeconds sets the minimum number of seconds before an automation can run again due to a new violation on the same managed cluster. This only applies to the EveryEvent mode. The default value is "0".
     */
    @JsonProperty("delayAfterRunSeconds")
    public Integer getDelayAfterRunSeconds() {
        return delayAfterRunSeconds;
    }

    /**
     * DelayAfterRunSeconds sets the minimum number of seconds before an automation can run again due to a new violation on the same managed cluster. This only applies to the EveryEvent mode. The default value is "0".
     */
    @JsonProperty("delayAfterRunSeconds")
    public void setDelayAfterRunSeconds(Integer delayAfterRunSeconds) {
        this.delayAfterRunSeconds = delayAfterRunSeconds;
    }

    /**
     * EventHook specifies the compliance state that initiates automation. This must be set to "noncompliant".
     */
    @JsonProperty("eventHook")
    public String getEventHook() {
        return eventHook;
    }

    /**
     * EventHook specifies the compliance state that initiates automation. This must be set to "noncompliant".
     */
    @JsonProperty("eventHook")
    public void setEventHook(String eventHook) {
        this.eventHook = eventHook;
    }

    /**
     * PolicyAutomationSpec defines how and when automation is initiated for the referenced policy.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * PolicyAutomationSpec defines how and when automation is initiated for the referenced policy.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * PolicyRef is the name of the policy that this automation resource is bound to.
     */
    @JsonProperty("policyRef")
    public String getPolicyRef() {
        return policyRef;
    }

    /**
     * PolicyRef is the name of the policy that this automation resource is bound to.
     */
    @JsonProperty("policyRef")
    public void setPolicyRef(String policyRef) {
        this.policyRef = policyRef;
    }

    /**
     * RescanAfter is reserved for future use and should not be set.
     */
    @JsonProperty("rescanAfter")
    public String getRescanAfter() {
        return rescanAfter;
    }

    /**
     * RescanAfter is reserved for future use and should not be set.
     */
    @JsonProperty("rescanAfter")
    public void setRescanAfter(String rescanAfter) {
        this.rescanAfter = rescanAfter;
    }

    @JsonIgnore
    public PolicyAutomationSpecBuilder edit() {
        return new PolicyAutomationSpecBuilder(this);
    }

    @JsonIgnore
    public PolicyAutomationSpecBuilder toBuilder() {
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
