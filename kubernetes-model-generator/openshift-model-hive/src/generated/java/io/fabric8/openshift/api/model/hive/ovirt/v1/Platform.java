
package io.fabric8.openshift.api.model.hive.ovirt.v1;

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
 * Platform stores all the global oVirt configuration
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certificatesSecretRef",
    "credentialsSecretRef",
    "ovirt_cluster_id",
    "ovirt_network_name",
    "storage_domain_id"
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
public class Platform implements Editable<PlatformBuilder>, KubernetesResource
{

    @JsonProperty("certificatesSecretRef")
    private LocalObjectReference certificatesSecretRef;
    @JsonProperty("credentialsSecretRef")
    private LocalObjectReference credentialsSecretRef;
    @JsonProperty("ovirt_cluster_id")
    private String ovirtClusterId;
    @JsonProperty("ovirt_network_name")
    private String ovirtNetworkName;
    @JsonProperty("storage_domain_id")
    private String storageDomainId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(LocalObjectReference certificatesSecretRef, LocalObjectReference credentialsSecretRef, String ovirtClusterId, String ovirtNetworkName, String storageDomainId) {
        super();
        this.certificatesSecretRef = certificatesSecretRef;
        this.credentialsSecretRef = credentialsSecretRef;
        this.ovirtClusterId = ovirtClusterId;
        this.ovirtNetworkName = ovirtNetworkName;
        this.storageDomainId = storageDomainId;
    }

    /**
     * Platform stores all the global oVirt configuration
     */
    @JsonProperty("certificatesSecretRef")
    public LocalObjectReference getCertificatesSecretRef() {
        return certificatesSecretRef;
    }

    /**
     * Platform stores all the global oVirt configuration
     */
    @JsonProperty("certificatesSecretRef")
    public void setCertificatesSecretRef(LocalObjectReference certificatesSecretRef) {
        this.certificatesSecretRef = certificatesSecretRef;
    }

    /**
     * Platform stores all the global oVirt configuration
     */
    @JsonProperty("credentialsSecretRef")
    public LocalObjectReference getCredentialsSecretRef() {
        return credentialsSecretRef;
    }

    /**
     * Platform stores all the global oVirt configuration
     */
    @JsonProperty("credentialsSecretRef")
    public void setCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
        this.credentialsSecretRef = credentialsSecretRef;
    }

    /**
     * The target cluster under which all VMs will run
     */
    @JsonProperty("ovirt_cluster_id")
    public String getOvirtClusterId() {
        return ovirtClusterId;
    }

    /**
     * The target cluster under which all VMs will run
     */
    @JsonProperty("ovirt_cluster_id")
    public void setOvirtClusterId(String ovirtClusterId) {
        this.ovirtClusterId = ovirtClusterId;
    }

    /**
     * The target network of all the network interfaces of the nodes. Omitting defaults to ovirtmgmt network which is a default network for evert ovirt cluster.
     */
    @JsonProperty("ovirt_network_name")
    public String getOvirtNetworkName() {
        return ovirtNetworkName;
    }

    /**
     * The target network of all the network interfaces of the nodes. Omitting defaults to ovirtmgmt network which is a default network for evert ovirt cluster.
     */
    @JsonProperty("ovirt_network_name")
    public void setOvirtNetworkName(String ovirtNetworkName) {
        this.ovirtNetworkName = ovirtNetworkName;
    }

    /**
     * The target storage domain under which all VM disk would be created.
     */
    @JsonProperty("storage_domain_id")
    public String getStorageDomainId() {
        return storageDomainId;
    }

    /**
     * The target storage domain under which all VM disk would be created.
     */
    @JsonProperty("storage_domain_id")
    public void setStorageDomainId(String storageDomainId) {
        this.storageDomainId = storageDomainId;
    }

    @JsonIgnore
    public PlatformBuilder edit() {
        return new PlatformBuilder(this);
    }

    @JsonIgnore
    public PlatformBuilder toBuilder() {
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
        if (!(o instanceof Platform)) {
            return false;
        }
        Platform other = (Platform) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$certificatesSecretRef = this.getCertificatesSecretRef();
        Object other$certificatesSecretRef = other.getCertificatesSecretRef();
        if (this$certificatesSecretRef == null ? other$certificatesSecretRef != null : !this$certificatesSecretRef.equals(other$certificatesSecretRef)) {
            return false;
        }
        Object this$credentialsSecretRef = this.getCredentialsSecretRef();
        Object other$credentialsSecretRef = other.getCredentialsSecretRef();
        if (this$credentialsSecretRef == null ? other$credentialsSecretRef != null : !this$credentialsSecretRef.equals(other$credentialsSecretRef)) {
            return false;
        }
        Object this$ovirtClusterId = this.getOvirtClusterId();
        Object other$ovirtClusterId = other.getOvirtClusterId();
        if (this$ovirtClusterId == null ? other$ovirtClusterId != null : !this$ovirtClusterId.equals(other$ovirtClusterId)) {
            return false;
        }
        Object this$ovirtNetworkName = this.getOvirtNetworkName();
        Object other$ovirtNetworkName = other.getOvirtNetworkName();
        if (this$ovirtNetworkName == null ? other$ovirtNetworkName != null : !this$ovirtNetworkName.equals(other$ovirtNetworkName)) {
            return false;
        }
        Object this$storageDomainId = this.getStorageDomainId();
        Object other$storageDomainId = other.getStorageDomainId();
        if (this$storageDomainId == null ? other$storageDomainId != null : !this$storageDomainId.equals(other$storageDomainId)) {
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
        return other instanceof Platform;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $certificatesSecretRef = this.getCertificatesSecretRef();
        result = result * prime + ($certificatesSecretRef == null ? 43 : $certificatesSecretRef.hashCode());
        Object $credentialsSecretRef = this.getCredentialsSecretRef();
        result = result * prime + ($credentialsSecretRef == null ? 43 : $credentialsSecretRef.hashCode());
        Object $ovirtClusterId = this.getOvirtClusterId();
        result = result * prime + ($ovirtClusterId == null ? 43 : $ovirtClusterId.hashCode());
        Object $ovirtNetworkName = this.getOvirtNetworkName();
        result = result * prime + ($ovirtNetworkName == null ? 43 : $ovirtNetworkName.hashCode());
        Object $storageDomainId = this.getStorageDomainId();
        result = result * prime + ($storageDomainId == null ? 43 : $storageDomainId.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Platform(" + "certificatesSecretRef=" + this.getCertificatesSecretRef() + ", credentialsSecretRef=" + this.getCredentialsSecretRef() + ", ovirtClusterId=" + this.getOvirtClusterId() + ", ovirtNetworkName=" + this.getOvirtNetworkName() + ", storageDomainId=" + this.getStorageDomainId() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
