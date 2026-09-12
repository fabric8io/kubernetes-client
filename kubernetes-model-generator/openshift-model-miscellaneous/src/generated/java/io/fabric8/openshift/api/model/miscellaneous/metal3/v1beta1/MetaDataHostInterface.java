
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * MetaDataHostInterface contains the information to render the object name.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fromBootMAC",
    "interface",
    "key"
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
public class MetaDataHostInterface implements Editable<MetaDataHostInterfaceBuilder>, KubernetesResource
{

    @JsonProperty("fromBootMAC")
    private Boolean fromBootMAC;
    @JsonProperty("interface")
    private String _interface;
    @JsonProperty("key")
    private String key;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MetaDataHostInterface() {
    }

    public MetaDataHostInterface(Boolean fromBootMAC, String _interface, String key) {
        super();
        this.fromBootMAC = fromBootMAC;
        this._interface = _interface;
        this.key = key;
    }

    /**
     * FromBootMAC will fetch the MAC address from the BareMetalHost Spec BootMACAddress field.
     */
    @JsonProperty("fromBootMAC")
    public Boolean getFromBootMAC() {
        return fromBootMAC;
    }

    /**
     * FromBootMAC will fetch the MAC address from the BareMetalHost Spec BootMACAddress field.
     */
    @JsonProperty("fromBootMAC")
    public void setFromBootMAC(Boolean fromBootMAC) {
        this.fromBootMAC = fromBootMAC;
    }

    /**
     * Interface is the name of the interface in the BareMetalHost Status Hardware Details list of interfaces from which to fetch the MAC address.
     */
    @JsonProperty("interface")
    public String getInterface() {
        return _interface;
    }

    /**
     * Interface is the name of the interface in the BareMetalHost Status Hardware Details list of interfaces from which to fetch the MAC address.
     */
    @JsonProperty("interface")
    public void setInterface(String _interface) {
        this._interface = _interface;
    }

    /**
     * Key will be used as the key to set in the metadata map for cloud-init
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * Key will be used as the key to set in the metadata map for cloud-init
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonIgnore
    public MetaDataHostInterfaceBuilder edit() {
        return new MetaDataHostInterfaceBuilder(this);
    }

    @JsonIgnore
    public MetaDataHostInterfaceBuilder toBuilder() {
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
        if (!(o instanceof MetaDataHostInterface)) {
            return false;
        }
        MetaDataHostInterface other = (MetaDataHostInterface) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fromBootMAC = this.getFromBootMAC();
        Object other$fromBootMAC = other.getFromBootMAC();
        if (this$fromBootMAC == null ? other$fromBootMAC != null : !this$fromBootMAC.equals(other$fromBootMAC)) {
            return false;
        }
        Object this$_interface = this.getInterface();
        Object other$_interface = other.getInterface();
        if (this$_interface == null ? other$_interface != null : !this$_interface.equals(other$_interface)) {
            return false;
        }
        Object this$key = this.getKey();
        Object other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
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
        return other instanceof MetaDataHostInterface;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fromBootMAC = this.getFromBootMAC();
        result = result * prime + ($fromBootMAC == null ? 43 : $fromBootMAC.hashCode());
        Object $_interface = this.getInterface();
        result = result * prime + ($_interface == null ? 43 : $_interface.hashCode());
        Object $key = this.getKey();
        result = result * prime + ($key == null ? 43 : $key.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MetaDataHostInterface(" + "fromBootMAC=" + this.getFromBootMAC() + ", _interface=" + this.getInterface() + ", key=" + this.getKey() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
