
package io.fabric8.openshift.api.model.installer.azure.v1;

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
 * SecuritySettings define the security type and the UEFI settings of the virtual machine.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "confidentialVM",
    "securityType",
    "trustedLaunch"
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
     * SecurityType specifies the SecurityType of the virtual machine. It has to be set to any specified value to enable secure boot and vTPM. The default behavior is: secure boot and vTPM will not be enabled unless this property is set.
     */
    @JsonProperty("securityType")
    public String getSecurityType() {
        return securityType;
    }

    /**
     * SecurityType specifies the SecurityType of the virtual machine. It has to be set to any specified value to enable secure boot and vTPM. The default behavior is: secure boot and vTPM will not be enabled unless this property is set.
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

}
