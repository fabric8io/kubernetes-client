
package io.fabric8.openshift.api.model.machine.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "credentialsSecret",
    "image",
    "keyPairName",
    "loadBalancers",
    "memoryGiB",
    "network",
    "processorType",
    "processors",
    "serviceInstance",
    "systemType",
    "userDataSecret"
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
@Version("v1")
@Group("machine.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PowerVSMachineProviderConfig implements Editable<PowerVSMachineProviderConfigBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "machine.openshift.io/v1";
    @JsonProperty("credentialsSecret")
    private PowerVSSecretReference credentialsSecret;
    @JsonProperty("image")
    private PowerVSResource image;
    @JsonProperty("keyPairName")
    private String keyPairName;
    @JsonProperty("kind")
    private String kind = "PowerVSMachineProviderConfig";
    @JsonProperty("loadBalancers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LoadBalancerReference> loadBalancers = new ArrayList<>();
    @JsonProperty("memoryGiB")
    private Integer memoryGiB;
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("network")
    private PowerVSResource network;
    @JsonProperty("processorType")
    private String processorType;
    @JsonProperty("processors")
    private IntOrString processors;
    @JsonProperty("serviceInstance")
    private PowerVSResource serviceInstance;
    @JsonProperty("systemType")
    private String systemType;
    @JsonProperty("userDataSecret")
    private PowerVSSecretReference userDataSecret;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PowerVSMachineProviderConfig() {
    }

    public PowerVSMachineProviderConfig(String apiVersion, PowerVSSecretReference credentialsSecret, PowerVSResource image, String keyPairName, String kind, List<LoadBalancerReference> loadBalancers, Integer memoryGiB, ObjectMeta metadata, PowerVSResource network, String processorType, IntOrString processors, PowerVSResource serviceInstance, String systemType, PowerVSSecretReference userDataSecret) {
        super();
        this.apiVersion = apiVersion;
        this.credentialsSecret = credentialsSecret;
        this.image = image;
        this.keyPairName = keyPairName;
        this.kind = kind;
        this.loadBalancers = loadBalancers;
        this.memoryGiB = memoryGiB;
        this.metadata = metadata;
        this.network = network;
        this.processorType = processorType;
        this.processors = processors;
        this.serviceInstance = serviceInstance;
        this.systemType = systemType;
        this.userDataSecret = userDataSecret;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public PowerVSSecretReference getCredentialsSecret() {
        return credentialsSecret;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public void setCredentialsSecret(PowerVSSecretReference credentialsSecret) {
        this.credentialsSecret = credentialsSecret;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("image")
    public PowerVSResource getImage() {
        return image;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("image")
    public void setImage(PowerVSResource image) {
        this.image = image;
    }

    /**
     * keyPairName is the name of the KeyPair to use for SSH. The key pair will be exposed to the instance via the instance metadata service. On boot, the OS will copy the public keypair into the authorized keys for the core user.
     */
    @JsonProperty("keyPairName")
    public String getKeyPairName() {
        return keyPairName;
    }

    /**
     * keyPairName is the name of the KeyPair to use for SSH. The key pair will be exposed to the instance via the instance metadata service. On boot, the OS will copy the public keypair into the authorized keys for the core user.
     */
    @JsonProperty("keyPairName")
    public void setKeyPairName(String keyPairName) {
        this.keyPairName = keyPairName;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * loadBalancers is the set of load balancers to which the new control plane instance should be added once it is created.
     */
    @JsonProperty("loadBalancers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LoadBalancerReference> getLoadBalancers() {
        return loadBalancers;
    }

    /**
     * loadBalancers is the set of load balancers to which the new control plane instance should be added once it is created.
     */
    @JsonProperty("loadBalancers")
    public void setLoadBalancers(List<LoadBalancerReference> loadBalancers) {
        this.loadBalancers = loadBalancers;
    }

    /**
     * memoryGiB is the size of a virtual machine's memory, in GiB. maximum value for the MemoryGiB depends on the selected SystemType. when SystemType is set to e880 maximum MemoryGiB value is 7463 GiB. when SystemType is set to e980 maximum MemoryGiB value is 15307 GiB. when SystemType is set to s922 maximum MemoryGiB value is 942 GiB. The minimum memory is 32 GiB. When omitted, this means the user has no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is 32.
     */
    @JsonProperty("memoryGiB")
    public Integer getMemoryGiB() {
        return memoryGiB;
    }

    /**
     * memoryGiB is the size of a virtual machine's memory, in GiB. maximum value for the MemoryGiB depends on the selected SystemType. when SystemType is set to e880 maximum MemoryGiB value is 7463 GiB. when SystemType is set to e980 maximum MemoryGiB value is 15307 GiB. when SystemType is set to s922 maximum MemoryGiB value is 942 GiB. The minimum memory is 32 GiB. When omitted, this means the user has no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is 32.
     */
    @JsonProperty("memoryGiB")
    public void setMemoryGiB(Integer memoryGiB) {
        this.memoryGiB = memoryGiB;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("network")
    public PowerVSResource getNetwork() {
        return network;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("network")
    public void setNetwork(PowerVSResource network) {
        this.network = network;
    }

    /**
     * processorType is the VM instance processor type. It must be set to one of the following values: Dedicated, Capped or Shared. Dedicated: resources are allocated for a specific client, The hypervisor makes a 1:1 binding of a partition’s processor to a physical processor core. Shared: Shared among other clients. Capped: Shared, but resources do not expand beyond those that are requested, the amount of CPU time is Capped to the value specified for the entitlement. if the processorType is selected as Dedicated, then processors value cannot be fractional. When omitted, this means that the user has no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is Shared.
     */
    @JsonProperty("processorType")
    public String getProcessorType() {
        return processorType;
    }

    /**
     * processorType is the VM instance processor type. It must be set to one of the following values: Dedicated, Capped or Shared. Dedicated: resources are allocated for a specific client, The hypervisor makes a 1:1 binding of a partition’s processor to a physical processor core. Shared: Shared among other clients. Capped: Shared, but resources do not expand beyond those that are requested, the amount of CPU time is Capped to the value specified for the entitlement. if the processorType is selected as Dedicated, then processors value cannot be fractional. When omitted, this means that the user has no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is Shared.
     */
    @JsonProperty("processorType")
    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("processors")
    public IntOrString getProcessors() {
        return processors;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("processors")
    public void setProcessors(IntOrString processors) {
        this.processors = processors;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("serviceInstance")
    public PowerVSResource getServiceInstance() {
        return serviceInstance;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("serviceInstance")
    public void setServiceInstance(PowerVSResource serviceInstance) {
        this.serviceInstance = serviceInstance;
    }

    /**
     * systemType is the System type used to host the instance. systemType determines the number of cores and memory that is available. Few of the supported SystemTypes are s922,e880,e980. e880 systemType available only in Dallas Datacenters. e980 systemType available in Datacenters except Dallas and Washington. When omitted, this means that the user has no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is s922 which is generally available.
     */
    @JsonProperty("systemType")
    public String getSystemType() {
        return systemType;
    }

    /**
     * systemType is the System type used to host the instance. systemType determines the number of cores and memory that is available. Few of the supported SystemTypes are s922,e880,e980. e880 systemType available only in Dallas Datacenters. e980 systemType available in Datacenters except Dallas and Washington. When omitted, this means that the user has no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is s922 which is generally available.
     */
    @JsonProperty("systemType")
    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public PowerVSSecretReference getUserDataSecret() {
        return userDataSecret;
    }

    /**
     * PowerVSMachineProviderConfig is the type that will be embedded in a Machine.Spec.ProviderSpec field for a PowerVS virtual machine. It is used by the PowerVS machine actuator to create a single Machine.<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public void setUserDataSecret(PowerVSSecretReference userDataSecret) {
        this.userDataSecret = userDataSecret;
    }

    @JsonIgnore
    public PowerVSMachineProviderConfigBuilder edit() {
        return new PowerVSMachineProviderConfigBuilder(this);
    }

    @JsonIgnore
    public PowerVSMachineProviderConfigBuilder toBuilder() {
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
        if (!(o instanceof PowerVSMachineProviderConfig)) {
            return false;
        }
        PowerVSMachineProviderConfig other = (PowerVSMachineProviderConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$credentialsSecret = this.getCredentialsSecret();
        Object other$credentialsSecret = other.getCredentialsSecret();
        if (this$credentialsSecret == null ? other$credentialsSecret != null : !this$credentialsSecret.equals(other$credentialsSecret)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$keyPairName = this.getKeyPairName();
        Object other$keyPairName = other.getKeyPairName();
        if (this$keyPairName == null ? other$keyPairName != null : !this$keyPairName.equals(other$keyPairName)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$loadBalancers = this.getLoadBalancers();
        Object other$loadBalancers = other.getLoadBalancers();
        if (this$loadBalancers == null ? other$loadBalancers != null : !this$loadBalancers.equals(other$loadBalancers)) {
            return false;
        }
        Object this$memoryGiB = this.getMemoryGiB();
        Object other$memoryGiB = other.getMemoryGiB();
        if (this$memoryGiB == null ? other$memoryGiB != null : !this$memoryGiB.equals(other$memoryGiB)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$network = this.getNetwork();
        Object other$network = other.getNetwork();
        if (this$network == null ? other$network != null : !this$network.equals(other$network)) {
            return false;
        }
        Object this$processorType = this.getProcessorType();
        Object other$processorType = other.getProcessorType();
        if (this$processorType == null ? other$processorType != null : !this$processorType.equals(other$processorType)) {
            return false;
        }
        Object this$processors = this.getProcessors();
        Object other$processors = other.getProcessors();
        if (this$processors == null ? other$processors != null : !this$processors.equals(other$processors)) {
            return false;
        }
        Object this$serviceInstance = this.getServiceInstance();
        Object other$serviceInstance = other.getServiceInstance();
        if (this$serviceInstance == null ? other$serviceInstance != null : !this$serviceInstance.equals(other$serviceInstance)) {
            return false;
        }
        Object this$systemType = this.getSystemType();
        Object other$systemType = other.getSystemType();
        if (this$systemType == null ? other$systemType != null : !this$systemType.equals(other$systemType)) {
            return false;
        }
        Object this$userDataSecret = this.getUserDataSecret();
        Object other$userDataSecret = other.getUserDataSecret();
        if (this$userDataSecret == null ? other$userDataSecret != null : !this$userDataSecret.equals(other$userDataSecret)) {
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
        return other instanceof PowerVSMachineProviderConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $credentialsSecret = this.getCredentialsSecret();
        result = result * prime + ($credentialsSecret == null ? 43 : $credentialsSecret.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $keyPairName = this.getKeyPairName();
        result = result * prime + ($keyPairName == null ? 43 : $keyPairName.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $loadBalancers = this.getLoadBalancers();
        result = result * prime + ($loadBalancers == null ? 43 : $loadBalancers.hashCode());
        Object $memoryGiB = this.getMemoryGiB();
        result = result * prime + ($memoryGiB == null ? 43 : $memoryGiB.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $network = this.getNetwork();
        result = result * prime + ($network == null ? 43 : $network.hashCode());
        Object $processorType = this.getProcessorType();
        result = result * prime + ($processorType == null ? 43 : $processorType.hashCode());
        Object $processors = this.getProcessors();
        result = result * prime + ($processors == null ? 43 : $processors.hashCode());
        Object $serviceInstance = this.getServiceInstance();
        result = result * prime + ($serviceInstance == null ? 43 : $serviceInstance.hashCode());
        Object $systemType = this.getSystemType();
        result = result * prime + ($systemType == null ? 43 : $systemType.hashCode());
        Object $userDataSecret = this.getUserDataSecret();
        result = result * prime + ($userDataSecret == null ? 43 : $userDataSecret.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PowerVSMachineProviderConfig(" + "apiVersion=" + this.getApiVersion() + ", credentialsSecret=" + this.getCredentialsSecret() + ", image=" + this.getImage() + ", keyPairName=" + this.getKeyPairName() + ", kind=" + this.getKind() + ", loadBalancers=" + this.getLoadBalancers() + ", memoryGiB=" + this.getMemoryGiB() + ", metadata=" + this.getMetadata() + ", network=" + this.getNetwork() + ", processorType=" + this.getProcessorType() + ", processors=" + this.getProcessors() + ", serviceInstance=" + this.getServiceInstance() + ", systemType=" + this.getSystemType() + ", userDataSecret=" + this.getUserDataSecret() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
