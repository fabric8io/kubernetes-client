
package io.fabric8.openshift.api.model.machine.v1beta1;

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
 * GCPShieldedInstanceConfig describes the shielded VM configuration of the instance on GCP. Shielded VM configuration allow users to enable and disable Secure Boot, vTPM, and Integrity Monitoring.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "integrityMonitoring",
    "secureBoot",
    "virtualizedTrustedPlatformModule"
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
public class GCPShieldedInstanceConfig implements Editable<GCPShieldedInstanceConfigBuilder>, KubernetesResource
{

    @JsonProperty("integrityMonitoring")
    private String integrityMonitoring;
    @JsonProperty("secureBoot")
    private String secureBoot;
    @JsonProperty("virtualizedTrustedPlatformModule")
    private String virtualizedTrustedPlatformModule;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPShieldedInstanceConfig() {
    }

    public GCPShieldedInstanceConfig(String integrityMonitoring, String secureBoot, String virtualizedTrustedPlatformModule) {
        super();
        this.integrityMonitoring = integrityMonitoring;
        this.secureBoot = secureBoot;
        this.virtualizedTrustedPlatformModule = virtualizedTrustedPlatformModule;
    }

    /**
     * IntegrityMonitoring determines whether the instance should have integrity monitoring that verify the runtime boot integrity. Compares the most recent boot measurements to the integrity policy baseline and return a pair of pass/fail results depending on whether they match or not. If omitted, the platform chooses a default, which is subject to change over time, currently that default is Enabled.
     */
    @JsonProperty("integrityMonitoring")
    public String getIntegrityMonitoring() {
        return integrityMonitoring;
    }

    /**
     * IntegrityMonitoring determines whether the instance should have integrity monitoring that verify the runtime boot integrity. Compares the most recent boot measurements to the integrity policy baseline and return a pair of pass/fail results depending on whether they match or not. If omitted, the platform chooses a default, which is subject to change over time, currently that default is Enabled.
     */
    @JsonProperty("integrityMonitoring")
    public void setIntegrityMonitoring(String integrityMonitoring) {
        this.integrityMonitoring = integrityMonitoring;
    }

    /**
     * SecureBoot Defines whether the instance should have secure boot enabled. Secure Boot verify the digital signature of all boot components, and halting the boot process if signature verification fails. If omitted, the platform chooses a default, which is subject to change over time, currently that default is Disabled.
     */
    @JsonProperty("secureBoot")
    public String getSecureBoot() {
        return secureBoot;
    }

    /**
     * SecureBoot Defines whether the instance should have secure boot enabled. Secure Boot verify the digital signature of all boot components, and halting the boot process if signature verification fails. If omitted, the platform chooses a default, which is subject to change over time, currently that default is Disabled.
     */
    @JsonProperty("secureBoot")
    public void setSecureBoot(String secureBoot) {
        this.secureBoot = secureBoot;
    }

    /**
     * VirtualizedTrustedPlatformModule enable virtualized trusted platform module measurements to create a known good boot integrity policy baseline. The integrity policy baseline is used for comparison with measurements from subsequent VM boots to determine if anything has changed. This is required to be set to "Enabled" if IntegrityMonitoring is enabled. If omitted, the platform chooses a default, which is subject to change over time, currently that default is Enabled.
     */
    @JsonProperty("virtualizedTrustedPlatformModule")
    public String getVirtualizedTrustedPlatformModule() {
        return virtualizedTrustedPlatformModule;
    }

    /**
     * VirtualizedTrustedPlatformModule enable virtualized trusted platform module measurements to create a known good boot integrity policy baseline. The integrity policy baseline is used for comparison with measurements from subsequent VM boots to determine if anything has changed. This is required to be set to "Enabled" if IntegrityMonitoring is enabled. If omitted, the platform chooses a default, which is subject to change over time, currently that default is Enabled.
     */
    @JsonProperty("virtualizedTrustedPlatformModule")
    public void setVirtualizedTrustedPlatformModule(String virtualizedTrustedPlatformModule) {
        this.virtualizedTrustedPlatformModule = virtualizedTrustedPlatformModule;
    }

    @JsonIgnore
    public GCPShieldedInstanceConfigBuilder edit() {
        return new GCPShieldedInstanceConfigBuilder(this);
    }

    @JsonIgnore
    public GCPShieldedInstanceConfigBuilder toBuilder() {
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
