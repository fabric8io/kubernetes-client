
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * MachineConfigNodeStatusMachineConfigVersion holds the current and desired config versions as last updated in the MCN status. When the current and desired versions are not matched, the machine config pool is processing an upgrade and the machine config node will monitor the upgrade process. When the current and desired versions do not match, the machine config node will ignore these events given that certain operations happen both during the MCO's upgrade mode and the daily operations mode.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "current",
    "desired"
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
public class MachineConfigNodeStatusMachineConfigVersion implements Editable<MachineConfigNodeStatusMachineConfigVersionBuilder>, KubernetesResource
{

    @JsonProperty("current")
    private String current;
    @JsonProperty("desired")
    private String desired;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineConfigNodeStatusMachineConfigVersion() {
    }

    public MachineConfigNodeStatusMachineConfigVersion(String current, String desired) {
        super();
        this.current = current;
        this.desired = desired;
    }

    /**
     * current is the name of the machine config currently in use on the node. This value is updated once the machine config daemon has completed the update of the configuration for the node. This value should match the desired version unless an upgrade is in progress. Must be a lowercase RFC-1123 hostname (https://tools.ietf.org/html/rfc1123) It may consist of only alphanumeric characters, hyphens (-) and periods (.) and must be at most 253 characters in length.
     */
    @JsonProperty("current")
    public String getCurrent() {
        return current;
    }

    /**
     * current is the name of the machine config currently in use on the node. This value is updated once the machine config daemon has completed the update of the configuration for the node. This value should match the desired version unless an upgrade is in progress. Must be a lowercase RFC-1123 hostname (https://tools.ietf.org/html/rfc1123) It may consist of only alphanumeric characters, hyphens (-) and periods (.) and must be at most 253 characters in length.
     */
    @JsonProperty("current")
    public void setCurrent(String current) {
        this.current = current;
    }

    /**
     * desired is the MachineConfig the node wants to upgrade to. This value gets set in the machine config node status once the machine config has been validated against the current machine config. Must be a lowercase RFC-1123 hostname (https://tools.ietf.org/html/rfc1123) It may consist of only alphanumeric characters, hyphens (-) and periods (.) and must be at most 253 characters in length.
     */
    @JsonProperty("desired")
    public String getDesired() {
        return desired;
    }

    /**
     * desired is the MachineConfig the node wants to upgrade to. This value gets set in the machine config node status once the machine config has been validated against the current machine config. Must be a lowercase RFC-1123 hostname (https://tools.ietf.org/html/rfc1123) It may consist of only alphanumeric characters, hyphens (-) and periods (.) and must be at most 253 characters in length.
     */
    @JsonProperty("desired")
    public void setDesired(String desired) {
        this.desired = desired;
    }

    @JsonIgnore
    public MachineConfigNodeStatusMachineConfigVersionBuilder edit() {
        return new MachineConfigNodeStatusMachineConfigVersionBuilder(this);
    }

    @JsonIgnore
    public MachineConfigNodeStatusMachineConfigVersionBuilder toBuilder() {
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
