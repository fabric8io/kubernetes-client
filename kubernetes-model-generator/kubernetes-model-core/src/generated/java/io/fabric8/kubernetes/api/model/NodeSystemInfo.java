
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * NodeSystemInfo is a set of ids/uuids to uniquely identify the node.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "architecture",
    "bootID",
    "containerRuntimeVersion",
    "kernelVersion",
    "kubeProxyVersion",
    "kubeletVersion",
    "machineID",
    "operatingSystem",
    "osImage",
    "runningInUserNamespace",
    "swap",
    "systemUUID"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NodeSystemInfo implements Editable<NodeSystemInfoBuilder>, KubernetesResource
{

    @JsonProperty("architecture")
    private String architecture;
    @JsonProperty("bootID")
    private String bootID;
    @JsonProperty("containerRuntimeVersion")
    private String containerRuntimeVersion;
    @JsonProperty("kernelVersion")
    private String kernelVersion;
    @JsonProperty("kubeProxyVersion")
    private String kubeProxyVersion;
    @JsonProperty("kubeletVersion")
    private String kubeletVersion;
    @JsonProperty("machineID")
    private String machineID;
    @JsonProperty("operatingSystem")
    private String operatingSystem;
    @JsonProperty("osImage")
    private String osImage;
    @JsonProperty("runningInUserNamespace")
    private Boolean runningInUserNamespace;
    @JsonProperty("swap")
    private NodeSwapStatus swap;
    @JsonProperty("systemUUID")
    private String systemUUID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeSystemInfo() {
    }

    public NodeSystemInfo(String architecture, String bootID, String containerRuntimeVersion, String kernelVersion, String kubeProxyVersion, String kubeletVersion, String machineID, String operatingSystem, String osImage, Boolean runningInUserNamespace, NodeSwapStatus swap, String systemUUID) {
        super();
        this.architecture = architecture;
        this.bootID = bootID;
        this.containerRuntimeVersion = containerRuntimeVersion;
        this.kernelVersion = kernelVersion;
        this.kubeProxyVersion = kubeProxyVersion;
        this.kubeletVersion = kubeletVersion;
        this.machineID = machineID;
        this.operatingSystem = operatingSystem;
        this.osImage = osImage;
        this.runningInUserNamespace = runningInUserNamespace;
        this.swap = swap;
        this.systemUUID = systemUUID;
    }

    /**
     * The Architecture reported by the node
     */
    @JsonProperty("architecture")
    public String getArchitecture() {
        return architecture;
    }

    /**
     * The Architecture reported by the node
     */
    @JsonProperty("architecture")
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    /**
     * Boot ID reported by the node.
     */
    @JsonProperty("bootID")
    public String getBootID() {
        return bootID;
    }

    /**
     * Boot ID reported by the node.
     */
    @JsonProperty("bootID")
    public void setBootID(String bootID) {
        this.bootID = bootID;
    }

    /**
     * ContainerRuntime Version reported by the node through runtime remote API (e.g. containerd://1.4.2).
     */
    @JsonProperty("containerRuntimeVersion")
    public String getContainerRuntimeVersion() {
        return containerRuntimeVersion;
    }

    /**
     * ContainerRuntime Version reported by the node through runtime remote API (e.g. containerd://1.4.2).
     */
    @JsonProperty("containerRuntimeVersion")
    public void setContainerRuntimeVersion(String containerRuntimeVersion) {
        this.containerRuntimeVersion = containerRuntimeVersion;
    }

    /**
     * Kernel Version reported by the node from 'uname -r' (e.g. 3.16.0-0.bpo.4-amd64).
     */
    @JsonProperty("kernelVersion")
    public String getKernelVersion() {
        return kernelVersion;
    }

    /**
     * Kernel Version reported by the node from 'uname -r' (e.g. 3.16.0-0.bpo.4-amd64).
     */
    @JsonProperty("kernelVersion")
    public void setKernelVersion(String kernelVersion) {
        this.kernelVersion = kernelVersion;
    }

    /**
     * Deprecated: KubeProxy Version reported by the node.
     */
    @JsonProperty("kubeProxyVersion")
    public String getKubeProxyVersion() {
        return kubeProxyVersion;
    }

    /**
     * Deprecated: KubeProxy Version reported by the node.
     */
    @JsonProperty("kubeProxyVersion")
    public void setKubeProxyVersion(String kubeProxyVersion) {
        this.kubeProxyVersion = kubeProxyVersion;
    }

    /**
     * Kubelet Version reported by the node.
     */
    @JsonProperty("kubeletVersion")
    public String getKubeletVersion() {
        return kubeletVersion;
    }

    /**
     * Kubelet Version reported by the node.
     */
    @JsonProperty("kubeletVersion")
    public void setKubeletVersion(String kubeletVersion) {
        this.kubeletVersion = kubeletVersion;
    }

    /**
     * MachineID reported by the node. For unique machine identification in the cluster this field is preferred. Learn more from man(5) machine-id: http://man7.org/linux/man-pages/man5/machine-id.5.html
     */
    @JsonProperty("machineID")
    public String getMachineID() {
        return machineID;
    }

    /**
     * MachineID reported by the node. For unique machine identification in the cluster this field is preferred. Learn more from man(5) machine-id: http://man7.org/linux/man-pages/man5/machine-id.5.html
     */
    @JsonProperty("machineID")
    public void setMachineID(String machineID) {
        this.machineID = machineID;
    }

    /**
     * The Operating System reported by the node
     */
    @JsonProperty("operatingSystem")
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * The Operating System reported by the node
     */
    @JsonProperty("operatingSystem")
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * OS Image reported by the node from /etc/os-release (e.g. Debian GNU/Linux 7 (wheezy)).
     */
    @JsonProperty("osImage")
    public String getOsImage() {
        return osImage;
    }

    /**
     * OS Image reported by the node from /etc/os-release (e.g. Debian GNU/Linux 7 (wheezy)).
     */
    @JsonProperty("osImage")
    public void setOsImage(String osImage) {
        this.osImage = osImage;
    }

    /**
     * Whether the node is running in a user namespace.
     */
    @JsonProperty("runningInUserNamespace")
    public Boolean getRunningInUserNamespace() {
        return runningInUserNamespace;
    }

    /**
     * Whether the node is running in a user namespace.
     */
    @JsonProperty("runningInUserNamespace")
    public void setRunningInUserNamespace(Boolean runningInUserNamespace) {
        this.runningInUserNamespace = runningInUserNamespace;
    }

    /**
     * NodeSystemInfo is a set of ids/uuids to uniquely identify the node.
     */
    @JsonProperty("swap")
    public NodeSwapStatus getSwap() {
        return swap;
    }

    /**
     * NodeSystemInfo is a set of ids/uuids to uniquely identify the node.
     */
    @JsonProperty("swap")
    public void setSwap(NodeSwapStatus swap) {
        this.swap = swap;
    }

    /**
     * SystemUUID reported by the node. For unique machine identification MachineID is preferred. This field is specific to Red Hat hosts https://access.redhat.com/documentation/en-us/red_hat_subscription_management/1/html/rhsm/uuid
     */
    @JsonProperty("systemUUID")
    public String getSystemUUID() {
        return systemUUID;
    }

    /**
     * SystemUUID reported by the node. For unique machine identification MachineID is preferred. This field is specific to Red Hat hosts https://access.redhat.com/documentation/en-us/red_hat_subscription_management/1/html/rhsm/uuid
     */
    @JsonProperty("systemUUID")
    public void setSystemUUID(String systemUUID) {
        this.systemUUID = systemUUID;
    }

    @JsonIgnore
    public NodeSystemInfoBuilder edit() {
        return new NodeSystemInfoBuilder(this);
    }

    @JsonIgnore
    public NodeSystemInfoBuilder toBuilder() {
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
        if (!(o instanceof NodeSystemInfo)) {
            return false;
        }
        NodeSystemInfo other = (NodeSystemInfo) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$architecture = this.getArchitecture();
        Object other$architecture = other.getArchitecture();
        if (this$architecture == null ? other$architecture != null : !this$architecture.equals(other$architecture)) {
            return false;
        }
        Object this$bootID = this.getBootID();
        Object other$bootID = other.getBootID();
        if (this$bootID == null ? other$bootID != null : !this$bootID.equals(other$bootID)) {
            return false;
        }
        Object this$containerRuntimeVersion = this.getContainerRuntimeVersion();
        Object other$containerRuntimeVersion = other.getContainerRuntimeVersion();
        if (this$containerRuntimeVersion == null ? other$containerRuntimeVersion != null : !this$containerRuntimeVersion.equals(other$containerRuntimeVersion)) {
            return false;
        }
        Object this$kernelVersion = this.getKernelVersion();
        Object other$kernelVersion = other.getKernelVersion();
        if (this$kernelVersion == null ? other$kernelVersion != null : !this$kernelVersion.equals(other$kernelVersion)) {
            return false;
        }
        Object this$kubeProxyVersion = this.getKubeProxyVersion();
        Object other$kubeProxyVersion = other.getKubeProxyVersion();
        if (this$kubeProxyVersion == null ? other$kubeProxyVersion != null : !this$kubeProxyVersion.equals(other$kubeProxyVersion)) {
            return false;
        }
        Object this$kubeletVersion = this.getKubeletVersion();
        Object other$kubeletVersion = other.getKubeletVersion();
        if (this$kubeletVersion == null ? other$kubeletVersion != null : !this$kubeletVersion.equals(other$kubeletVersion)) {
            return false;
        }
        Object this$machineID = this.getMachineID();
        Object other$machineID = other.getMachineID();
        if (this$machineID == null ? other$machineID != null : !this$machineID.equals(other$machineID)) {
            return false;
        }
        Object this$operatingSystem = this.getOperatingSystem();
        Object other$operatingSystem = other.getOperatingSystem();
        if (this$operatingSystem == null ? other$operatingSystem != null : !this$operatingSystem.equals(other$operatingSystem)) {
            return false;
        }
        Object this$osImage = this.getOsImage();
        Object other$osImage = other.getOsImage();
        if (this$osImage == null ? other$osImage != null : !this$osImage.equals(other$osImage)) {
            return false;
        }
        Object this$runningInUserNamespace = this.getRunningInUserNamespace();
        Object other$runningInUserNamespace = other.getRunningInUserNamespace();
        if (this$runningInUserNamespace == null ? other$runningInUserNamespace != null : !this$runningInUserNamespace.equals(other$runningInUserNamespace)) {
            return false;
        }
        Object this$swap = this.getSwap();
        Object other$swap = other.getSwap();
        if (this$swap == null ? other$swap != null : !this$swap.equals(other$swap)) {
            return false;
        }
        Object this$systemUUID = this.getSystemUUID();
        Object other$systemUUID = other.getSystemUUID();
        if (this$systemUUID == null ? other$systemUUID != null : !this$systemUUID.equals(other$systemUUID)) {
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
        return other instanceof NodeSystemInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $architecture = this.getArchitecture();
        result = result * prime + ($architecture == null ? 43 : $architecture.hashCode());
        Object $bootID = this.getBootID();
        result = result * prime + ($bootID == null ? 43 : $bootID.hashCode());
        Object $containerRuntimeVersion = this.getContainerRuntimeVersion();
        result = result * prime + ($containerRuntimeVersion == null ? 43 : $containerRuntimeVersion.hashCode());
        Object $kernelVersion = this.getKernelVersion();
        result = result * prime + ($kernelVersion == null ? 43 : $kernelVersion.hashCode());
        Object $kubeProxyVersion = this.getKubeProxyVersion();
        result = result * prime + ($kubeProxyVersion == null ? 43 : $kubeProxyVersion.hashCode());
        Object $kubeletVersion = this.getKubeletVersion();
        result = result * prime + ($kubeletVersion == null ? 43 : $kubeletVersion.hashCode());
        Object $machineID = this.getMachineID();
        result = result * prime + ($machineID == null ? 43 : $machineID.hashCode());
        Object $operatingSystem = this.getOperatingSystem();
        result = result * prime + ($operatingSystem == null ? 43 : $operatingSystem.hashCode());
        Object $osImage = this.getOsImage();
        result = result * prime + ($osImage == null ? 43 : $osImage.hashCode());
        Object $runningInUserNamespace = this.getRunningInUserNamespace();
        result = result * prime + ($runningInUserNamespace == null ? 43 : $runningInUserNamespace.hashCode());
        Object $swap = this.getSwap();
        result = result * prime + ($swap == null ? 43 : $swap.hashCode());
        Object $systemUUID = this.getSystemUUID();
        result = result * prime + ($systemUUID == null ? 43 : $systemUUID.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeSystemInfo(" + "architecture=" + this.getArchitecture() + ", bootID=" + this.getBootID() + ", containerRuntimeVersion=" + this.getContainerRuntimeVersion() + ", kernelVersion=" + this.getKernelVersion() + ", kubeProxyVersion=" + this.getKubeProxyVersion() + ", kubeletVersion=" + this.getKubeletVersion() + ", machineID=" + this.getMachineID() + ", operatingSystem=" + this.getOperatingSystem() + ", osImage=" + this.getOsImage() + ", runningInUserNamespace=" + this.getRunningInUserNamespace() + ", swap=" + this.getSwap() + ", systemUUID=" + this.getSystemUUID() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
