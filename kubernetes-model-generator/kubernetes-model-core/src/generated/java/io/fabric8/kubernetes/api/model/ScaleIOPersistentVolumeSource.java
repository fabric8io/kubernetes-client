
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "fsType",
    "gateway",
    "protectionDomain",
    "readOnly",
    "secretRef",
    "sslEnabled",
    "storageMode",
    "storagePool",
    "system",
    "volumeName"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class ScaleIOPersistentVolumeSource implements KubernetesResource
{

    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("gateway")
    private String gateway;
    @JsonProperty("protectionDomain")
    private String protectionDomain;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("secretRef")
    private SecretReference secretRef;
    @JsonProperty("sslEnabled")
    private Boolean sslEnabled;
    @JsonProperty("storageMode")
    private String storageMode;
    @JsonProperty("storagePool")
    private String storagePool;
    @JsonProperty("system")
    private String system;
    @JsonProperty("volumeName")
    private String volumeName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ScaleIOPersistentVolumeSource() {
    }

    /**
     * 
     * @param system
     * @param protectionDomain
     * @param sslEnabled
     * @param storageMode
     * @param volumeName
     * @param secretRef
     * @param readOnly
     * @param fsType
     * @param storagePool
     * @param gateway
     */
    public ScaleIOPersistentVolumeSource(String fsType, String gateway, String protectionDomain, Boolean readOnly, SecretReference secretRef, Boolean sslEnabled, String storageMode, String storagePool, String system, String volumeName) {
        super();
        this.fsType = fsType;
        this.gateway = gateway;
        this.protectionDomain = protectionDomain;
        this.readOnly = readOnly;
        this.secretRef = secretRef;
        this.sslEnabled = sslEnabled;
        this.storageMode = storageMode;
        this.storagePool = storagePool;
        this.system = system;
        this.volumeName = volumeName;
    }

    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    @JsonProperty("gateway")
    public String getGateway() {
        return gateway;
    }

    @JsonProperty("gateway")
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    @JsonProperty("protectionDomain")
    public String getProtectionDomain() {
        return protectionDomain;
    }

    @JsonProperty("protectionDomain")
    public void setProtectionDomain(String protectionDomain) {
        this.protectionDomain = protectionDomain;
    }

    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonProperty("secretRef")
    public SecretReference getSecretRef() {
        return secretRef;
    }

    @JsonProperty("secretRef")
    public void setSecretRef(SecretReference secretRef) {
        this.secretRef = secretRef;
    }

    @JsonProperty("sslEnabled")
    public Boolean getSslEnabled() {
        return sslEnabled;
    }

    @JsonProperty("sslEnabled")
    public void setSslEnabled(Boolean sslEnabled) {
        this.sslEnabled = sslEnabled;
    }

    @JsonProperty("storageMode")
    public String getStorageMode() {
        return storageMode;
    }

    @JsonProperty("storageMode")
    public void setStorageMode(String storageMode) {
        this.storageMode = storageMode;
    }

    @JsonProperty("storagePool")
    public String getStoragePool() {
        return storagePool;
    }

    @JsonProperty("storagePool")
    public void setStoragePool(String storagePool) {
        this.storagePool = storagePool;
    }

    @JsonProperty("system")
    public String getSystem() {
        return system;
    }

    @JsonProperty("system")
    public void setSystem(String system) {
        this.system = system;
    }

    @JsonProperty("volumeName")
    public String getVolumeName() {
        return volumeName;
    }

    @JsonProperty("volumeName")
    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
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
