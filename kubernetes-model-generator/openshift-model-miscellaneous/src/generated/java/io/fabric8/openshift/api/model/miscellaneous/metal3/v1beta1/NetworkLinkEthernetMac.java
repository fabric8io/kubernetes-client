
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
 * NetworkLinkEthernetMac represents the Mac address content.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fromAnnotation",
    "fromHostInterface",
    "string"
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
public class NetworkLinkEthernetMac implements Editable<NetworkLinkEthernetMacBuilder>, KubernetesResource
{

    @JsonProperty("fromAnnotation")
    private NetworkLinkEthernetMacFromAnnotation fromAnnotation;
    @JsonProperty("fromHostInterface")
    private String fromHostInterface;
    @JsonProperty("string")
    private String string;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkLinkEthernetMac() {
    }

    public NetworkLinkEthernetMac(NetworkLinkEthernetMacFromAnnotation fromAnnotation, String fromHostInterface, String string) {
        super();
        this.fromAnnotation = fromAnnotation;
        this.fromHostInterface = fromHostInterface;
        this.string = string;
    }

    /**
     * NetworkLinkEthernetMac represents the Mac address content.
     */
    @JsonProperty("fromAnnotation")
    public NetworkLinkEthernetMacFromAnnotation getFromAnnotation() {
        return fromAnnotation;
    }

    /**
     * NetworkLinkEthernetMac represents the Mac address content.
     */
    @JsonProperty("fromAnnotation")
    public void setFromAnnotation(NetworkLinkEthernetMacFromAnnotation fromAnnotation) {
        this.fromAnnotation = fromAnnotation;
    }

    /**
     * FromHostInterface contains the name of the interface in the BareMetalHost Introspection details from which to fetch the MAC address
     */
    @JsonProperty("fromHostInterface")
    public String getFromHostInterface() {
        return fromHostInterface;
    }

    /**
     * FromHostInterface contains the name of the interface in the BareMetalHost Introspection details from which to fetch the MAC address
     */
    @JsonProperty("fromHostInterface")
    public void setFromHostInterface(String fromHostInterface) {
        this.fromHostInterface = fromHostInterface;
    }

    /**
     * String contains the MAC address given as a string
     */
    @JsonProperty("string")
    public String getString() {
        return string;
    }

    /**
     * String contains the MAC address given as a string
     */
    @JsonProperty("string")
    public void setString(String string) {
        this.string = string;
    }

    @JsonIgnore
    public NetworkLinkEthernetMacBuilder edit() {
        return new NetworkLinkEthernetMacBuilder(this);
    }

    @JsonIgnore
    public NetworkLinkEthernetMacBuilder toBuilder() {
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
        if (!(o instanceof NetworkLinkEthernetMac)) {
            return false;
        }
        NetworkLinkEthernetMac other = (NetworkLinkEthernetMac) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fromAnnotation = this.getFromAnnotation();
        Object other$fromAnnotation = other.getFromAnnotation();
        if (this$fromAnnotation == null ? other$fromAnnotation != null : !this$fromAnnotation.equals(other$fromAnnotation)) {
            return false;
        }
        Object this$fromHostInterface = this.getFromHostInterface();
        Object other$fromHostInterface = other.getFromHostInterface();
        if (this$fromHostInterface == null ? other$fromHostInterface != null : !this$fromHostInterface.equals(other$fromHostInterface)) {
            return false;
        }
        Object this$string = this.getString();
        Object other$string = other.getString();
        if (this$string == null ? other$string != null : !this$string.equals(other$string)) {
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
        return other instanceof NetworkLinkEthernetMac;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fromAnnotation = this.getFromAnnotation();
        result = result * prime + ($fromAnnotation == null ? 43 : $fromAnnotation.hashCode());
        Object $fromHostInterface = this.getFromHostInterface();
        result = result * prime + ($fromHostInterface == null ? 43 : $fromHostInterface.hashCode());
        Object $string = this.getString();
        result = result * prime + ($string == null ? 43 : $string.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkLinkEthernetMac(" + "fromAnnotation=" + this.getFromAnnotation() + ", fromHostInterface=" + this.getFromHostInterface() + ", string=" + this.getString() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
