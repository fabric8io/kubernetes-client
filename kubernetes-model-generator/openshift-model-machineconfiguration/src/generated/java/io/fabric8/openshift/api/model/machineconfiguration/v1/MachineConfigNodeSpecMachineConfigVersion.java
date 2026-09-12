
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * MachineConfigNodeSpecMachineConfigVersion holds the desired config version for the current observed machine config node. When Current is not equal to Desired, the MachineConfigOperator is in an upgrade phase and the machine config node will take account of upgrade related events. Otherwise, they will be ignored given that certain operations happen both during the MCO's upgrade mode and the daily operations mode.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "desired"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class MachineConfigNodeSpecMachineConfigVersion implements Editable<MachineConfigNodeSpecMachineConfigVersionBuilder>, KubernetesResource
{

    @JsonProperty("desired")
    private String desired;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineConfigNodeSpecMachineConfigVersion() {
    }

    public MachineConfigNodeSpecMachineConfigVersion(String desired) {
        super();
        this.desired = desired;
    }

    /**
     * desired is the name of the machine config that the the node should be upgraded to. This value is set when the machine config pool generates a new version of its rendered configuration. When this value is changed, the machine config daemon starts the node upgrade process. This value gets set in the machine config node spec once the machine config has been targeted for upgrade and before it is validated. Must be a lowercase RFC-1123 subdomain name (https://tools.ietf.org/html/rfc1123) consisting of only lowercase alphanumeric characters, hyphens (-), and periods (.), and must start and end with an alphanumeric character, and be at most 253 characters in length.
     */
    @JsonProperty("desired")
    public String getDesired() {
        return desired;
    }

    /**
     * desired is the name of the machine config that the the node should be upgraded to. This value is set when the machine config pool generates a new version of its rendered configuration. When this value is changed, the machine config daemon starts the node upgrade process. This value gets set in the machine config node spec once the machine config has been targeted for upgrade and before it is validated. Must be a lowercase RFC-1123 subdomain name (https://tools.ietf.org/html/rfc1123) consisting of only lowercase alphanumeric characters, hyphens (-), and periods (.), and must start and end with an alphanumeric character, and be at most 253 characters in length.
     */
    @JsonProperty("desired")
    public void setDesired(String desired) {
        this.desired = desired;
    }

    @JsonIgnore
    public MachineConfigNodeSpecMachineConfigVersionBuilder edit() {
        return new MachineConfigNodeSpecMachineConfigVersionBuilder(this);
    }

    @JsonIgnore
    public MachineConfigNodeSpecMachineConfigVersionBuilder toBuilder() {
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
        if (!(o instanceof MachineConfigNodeSpecMachineConfigVersion)) {
            return false;
        }
        MachineConfigNodeSpecMachineConfigVersion other = (MachineConfigNodeSpecMachineConfigVersion) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$desired = this.getDesired();
        Object other$desired = other.getDesired();
        if (this$desired == null ? other$desired != null : !this$desired.equals(other$desired)) {
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
        return other instanceof MachineConfigNodeSpecMachineConfigVersion;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $desired = this.getDesired();
        result = result * prime + ($desired == null ? 43 : $desired.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineConfigNodeSpecMachineConfigVersion(" + "desired=" + this.getDesired() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
