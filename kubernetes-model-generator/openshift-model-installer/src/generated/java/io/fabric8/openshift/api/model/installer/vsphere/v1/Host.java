
package io.fabric8.openshift.api.model.installer.vsphere.v1;

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
 * Host defines host VMs to generate as part of the installation.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "failureDomain",
    "networkDevice",
    "role"
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
public class Host implements Editable<HostBuilder>, KubernetesResource
{

    @JsonProperty("failureDomain")
    private String failureDomain;
    @JsonProperty("networkDevice")
    private NetworkDeviceSpec networkDevice;
    @JsonProperty("role")
    private String role;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Host() {
    }

    public Host(String failureDomain, NetworkDeviceSpec networkDevice, String role) {
        super();
        this.failureDomain = failureDomain;
        this.networkDevice = networkDevice;
        this.role = role;
    }

    /**
     * FailureDomain refers to the name of a FailureDomain as described in https://github.com/openshift/enhancements/blob/master/enhancements/installer/vsphere-ipi-zonal.md
     */
    @JsonProperty("failureDomain")
    public String getFailureDomain() {
        return failureDomain;
    }

    /**
     * FailureDomain refers to the name of a FailureDomain as described in https://github.com/openshift/enhancements/blob/master/enhancements/installer/vsphere-ipi-zonal.md
     */
    @JsonProperty("failureDomain")
    public void setFailureDomain(String failureDomain) {
        this.failureDomain = failureDomain;
    }

    /**
     * Host defines host VMs to generate as part of the installation.
     */
    @JsonProperty("networkDevice")
    public NetworkDeviceSpec getNetworkDevice() {
        return networkDevice;
    }

    /**
     * Host defines host VMs to generate as part of the installation.
     */
    @JsonProperty("networkDevice")
    public void setNetworkDevice(NetworkDeviceSpec networkDevice) {
        this.networkDevice = networkDevice;
    }

    /**
     * Role defines the role of the node
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * Role defines the role of the node
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonIgnore
    public HostBuilder edit() {
        return new HostBuilder(this);
    }

    @JsonIgnore
    public HostBuilder toBuilder() {
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
        if (!(o instanceof Host)) {
            return false;
        }
        Host other = (Host) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$failureDomain = this.getFailureDomain();
        Object other$failureDomain = other.getFailureDomain();
        if (this$failureDomain == null ? other$failureDomain != null : !this$failureDomain.equals(other$failureDomain)) {
            return false;
        }
        Object this$networkDevice = this.getNetworkDevice();
        Object other$networkDevice = other.getNetworkDevice();
        if (this$networkDevice == null ? other$networkDevice != null : !this$networkDevice.equals(other$networkDevice)) {
            return false;
        }
        Object this$role = this.getRole();
        Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) {
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
        return other instanceof Host;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $failureDomain = this.getFailureDomain();
        result = result * prime + ($failureDomain == null ? 43 : $failureDomain.hashCode());
        Object $networkDevice = this.getNetworkDevice();
        result = result * prime + ($networkDevice == null ? 43 : $networkDevice.hashCode());
        Object $role = this.getRole();
        result = result * prime + ($role == null ? 43 : $role.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Host(" + "failureDomain=" + this.getFailureDomain() + ", networkDevice=" + this.getNetworkDevice() + ", role=" + this.getRole() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
