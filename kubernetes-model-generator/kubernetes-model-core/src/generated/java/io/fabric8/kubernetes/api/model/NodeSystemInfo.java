
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    "systemUUID"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
    @JsonProperty("systemUUID")
    private String systemUUID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeSystemInfo() {
    }

    public NodeSystemInfo(String architecture, String bootID, String containerRuntimeVersion, String kernelVersion, String kubeProxyVersion, String kubeletVersion, String machineID, String operatingSystem, String osImage, String systemUUID) {
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
