
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class NodeSystemInfo implements KubernetesResource
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
     * 
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

    @JsonProperty("architecture")
    public String getArchitecture() {
        return architecture;
    }

    @JsonProperty("architecture")
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    @JsonProperty("bootID")
    public String getBootID() {
        return bootID;
    }

    @JsonProperty("bootID")
    public void setBootID(String bootID) {
        this.bootID = bootID;
    }

    @JsonProperty("containerRuntimeVersion")
    public String getContainerRuntimeVersion() {
        return containerRuntimeVersion;
    }

    @JsonProperty("containerRuntimeVersion")
    public void setContainerRuntimeVersion(String containerRuntimeVersion) {
        this.containerRuntimeVersion = containerRuntimeVersion;
    }

    @JsonProperty("kernelVersion")
    public String getKernelVersion() {
        return kernelVersion;
    }

    @JsonProperty("kernelVersion")
    public void setKernelVersion(String kernelVersion) {
        this.kernelVersion = kernelVersion;
    }

    @JsonProperty("kubeProxyVersion")
    public String getKubeProxyVersion() {
        return kubeProxyVersion;
    }

    @JsonProperty("kubeProxyVersion")
    public void setKubeProxyVersion(String kubeProxyVersion) {
        this.kubeProxyVersion = kubeProxyVersion;
    }

    @JsonProperty("kubeletVersion")
    public String getKubeletVersion() {
        return kubeletVersion;
    }

    @JsonProperty("kubeletVersion")
    public void setKubeletVersion(String kubeletVersion) {
        this.kubeletVersion = kubeletVersion;
    }

    @JsonProperty("machineID")
    public String getMachineID() {
        return machineID;
    }

    @JsonProperty("machineID")
    public void setMachineID(String machineID) {
        this.machineID = machineID;
    }

    @JsonProperty("operatingSystem")
    public String getOperatingSystem() {
        return operatingSystem;
    }

    @JsonProperty("operatingSystem")
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @JsonProperty("osImage")
    public String getOsImage() {
        return osImage;
    }

    @JsonProperty("osImage")
    public void setOsImage(String osImage) {
        this.osImage = osImage;
    }

    @JsonProperty("systemUUID")
    public String getSystemUUID() {
        return systemUUID;
    }

    @JsonProperty("systemUUID")
    public void setSystemUUID(String systemUUID) {
        this.systemUUID = systemUUID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
