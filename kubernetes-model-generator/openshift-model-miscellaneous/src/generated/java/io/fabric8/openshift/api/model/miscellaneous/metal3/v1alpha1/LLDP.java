
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
 * LLDP represents Link Layer Discovery Protocol data for a network interface.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "portID",
    "switchID",
    "switchSystemName"
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
public class LLDP implements Editable<LLDPBuilder>, KubernetesResource
{

    @JsonProperty("portID")
    private String portID;
    @JsonProperty("switchID")
    private String switchID;
    @JsonProperty("switchSystemName")
    private String switchSystemName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LLDP() {
    }

    public LLDP(String portID, String switchID, String switchSystemName) {
        super();
        this.portID = portID;
        this.switchID = switchID;
        this.switchSystemName = switchSystemName;
    }

    /**
     * The switch port ID from LLDP
     */
    @JsonProperty("portID")
    public String getPortID() {
        return portID;
    }

    /**
     * The switch port ID from LLDP
     */
    @JsonProperty("portID")
    public void setPortID(String portID) {
        this.portID = portID;
    }

    /**
     * The switch chassis ID from LLDP
     */
    @JsonProperty("switchID")
    public String getSwitchID() {
        return switchID;
    }

    /**
     * The switch chassis ID from LLDP
     */
    @JsonProperty("switchID")
    public void setSwitchID(String switchID) {
        this.switchID = switchID;
    }

    /**
     * The switch system name from LLDP
     */
    @JsonProperty("switchSystemName")
    public String getSwitchSystemName() {
        return switchSystemName;
    }

    /**
     * The switch system name from LLDP
     */
    @JsonProperty("switchSystemName")
    public void setSwitchSystemName(String switchSystemName) {
        this.switchSystemName = switchSystemName;
    }

    @JsonIgnore
    public LLDPBuilder edit() {
        return new LLDPBuilder(this);
    }

    @JsonIgnore
    public LLDPBuilder toBuilder() {
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
        if (!(o instanceof LLDP)) {
            return false;
        }
        LLDP other = (LLDP) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$portID = this.getPortID();
        Object other$portID = other.getPortID();
        if (this$portID == null ? other$portID != null : !this$portID.equals(other$portID)) {
            return false;
        }
        Object this$switchID = this.getSwitchID();
        Object other$switchID = other.getSwitchID();
        if (this$switchID == null ? other$switchID != null : !this$switchID.equals(other$switchID)) {
            return false;
        }
        Object this$switchSystemName = this.getSwitchSystemName();
        Object other$switchSystemName = other.getSwitchSystemName();
        if (this$switchSystemName == null ? other$switchSystemName != null : !this$switchSystemName.equals(other$switchSystemName)) {
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
        return other instanceof LLDP;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $portID = this.getPortID();
        result = result * prime + ($portID == null ? 43 : $portID.hashCode());
        Object $switchID = this.getSwitchID();
        result = result * prime + ($switchID == null ? 43 : $switchID.hashCode());
        Object $switchSystemName = this.getSwitchSystemName();
        result = result * prime + ($switchSystemName == null ? 43 : $switchSystemName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LLDP(" + "portID=" + this.getPortID() + ", switchID=" + this.getSwitchID() + ", switchSystemName=" + this.getSwitchSystemName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
