
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * SecuritySettings define the security type and the UEFI settings of the virtual machine.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "confidentialVM",
    "securityType",
    "trustedLaunch"
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
public class SecuritySettings implements Editable<SecuritySettingsBuilder>, KubernetesResource
{

    @JsonProperty("confidentialVM")
    private ConfidentialVM confidentialVM;
    @JsonProperty("securityType")
    private String securityType;
    @JsonProperty("trustedLaunch")
    private TrustedLaunch trustedLaunch;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SecuritySettings() {
    }

    public SecuritySettings(ConfidentialVM confidentialVM, String securityType, TrustedLaunch trustedLaunch) {
        super();
        this.confidentialVM = confidentialVM;
        this.securityType = securityType;
        this.trustedLaunch = trustedLaunch;
    }

    /**
     * SecuritySettings define the security type and the UEFI settings of the virtual machine.
     */
    @JsonProperty("confidentialVM")
    public ConfidentialVM getConfidentialVM() {
        return confidentialVM;
    }

    /**
     * SecuritySettings define the security type and the UEFI settings of the virtual machine.
     */
    @JsonProperty("confidentialVM")
    public void setConfidentialVM(ConfidentialVM confidentialVM) {
        this.confidentialVM = confidentialVM;
    }

    /**
     * securityType specifies the SecurityType of the virtual machine. It has to be set to any specified value to enable UEFISettings. The default behavior is: UEFISettings will not be enabled unless this property is set.
     */
    @JsonProperty("securityType")
    public String getSecurityType() {
        return securityType;
    }

    /**
     * securityType specifies the SecurityType of the virtual machine. It has to be set to any specified value to enable UEFISettings. The default behavior is: UEFISettings will not be enabled unless this property is set.
     */
    @JsonProperty("securityType")
    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    /**
     * SecuritySettings define the security type and the UEFI settings of the virtual machine.
     */
    @JsonProperty("trustedLaunch")
    public TrustedLaunch getTrustedLaunch() {
        return trustedLaunch;
    }

    /**
     * SecuritySettings define the security type and the UEFI settings of the virtual machine.
     */
    @JsonProperty("trustedLaunch")
    public void setTrustedLaunch(TrustedLaunch trustedLaunch) {
        this.trustedLaunch = trustedLaunch;
    }

    @JsonIgnore
    public SecuritySettingsBuilder edit() {
        return new SecuritySettingsBuilder(this);
    }

    @JsonIgnore
    public SecuritySettingsBuilder toBuilder() {
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
        if (!(o instanceof SecuritySettings)) {
            return false;
        }
        SecuritySettings other = (SecuritySettings) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$confidentialVM = this.getConfidentialVM();
        Object other$confidentialVM = other.getConfidentialVM();
        if (this$confidentialVM == null ? other$confidentialVM != null : !this$confidentialVM.equals(other$confidentialVM)) {
            return false;
        }
        Object this$securityType = this.getSecurityType();
        Object other$securityType = other.getSecurityType();
        if (this$securityType == null ? other$securityType != null : !this$securityType.equals(other$securityType)) {
            return false;
        }
        Object this$trustedLaunch = this.getTrustedLaunch();
        Object other$trustedLaunch = other.getTrustedLaunch();
        if (this$trustedLaunch == null ? other$trustedLaunch != null : !this$trustedLaunch.equals(other$trustedLaunch)) {
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
        return other instanceof SecuritySettings;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $confidentialVM = this.getConfidentialVM();
        result = result * prime + ($confidentialVM == null ? 43 : $confidentialVM.hashCode());
        Object $securityType = this.getSecurityType();
        result = result * prime + ($securityType == null ? 43 : $securityType.hashCode());
        Object $trustedLaunch = this.getTrustedLaunch();
        result = result * prime + ($trustedLaunch == null ? 43 : $trustedLaunch.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SecuritySettings(" + "confidentialVM=" + this.getConfidentialVM() + ", securityType=" + this.getSecurityType() + ", trustedLaunch=" + this.getTrustedLaunch() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
