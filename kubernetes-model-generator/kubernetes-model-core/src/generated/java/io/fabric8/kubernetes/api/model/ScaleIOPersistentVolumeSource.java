
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
 * ScaleIOPersistentVolumeSource represents a persistent ScaleIO volume
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ScaleIOPersistentVolumeSource implements Editable<ScaleIOPersistentVolumeSourceBuilder>, KubernetesResource
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
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ScaleIOPersistentVolumeSource() {
    }

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

    /**
     * fsType is the filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". Default is "xfs"
     */
    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    /**
     * fsType is the filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". Default is "xfs"
     */
    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    /**
     * gateway is the host address of the ScaleIO API Gateway.
     */
    @JsonProperty("gateway")
    public String getGateway() {
        return gateway;
    }

    /**
     * gateway is the host address of the ScaleIO API Gateway.
     */
    @JsonProperty("gateway")
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    /**
     * protectionDomain is the name of the ScaleIO Protection Domain for the configured storage.
     */
    @JsonProperty("protectionDomain")
    public String getProtectionDomain() {
        return protectionDomain;
    }

    /**
     * protectionDomain is the name of the ScaleIO Protection Domain for the configured storage.
     */
    @JsonProperty("protectionDomain")
    public void setProtectionDomain(String protectionDomain) {
        this.protectionDomain = protectionDomain;
    }

    /**
     * readOnly defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * readOnly defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * ScaleIOPersistentVolumeSource represents a persistent ScaleIO volume
     */
    @JsonProperty("secretRef")
    public SecretReference getSecretRef() {
        return secretRef;
    }

    /**
     * ScaleIOPersistentVolumeSource represents a persistent ScaleIO volume
     */
    @JsonProperty("secretRef")
    public void setSecretRef(SecretReference secretRef) {
        this.secretRef = secretRef;
    }

    /**
     * sslEnabled is the flag to enable/disable SSL communication with Gateway, default false
     */
    @JsonProperty("sslEnabled")
    public Boolean getSslEnabled() {
        return sslEnabled;
    }

    /**
     * sslEnabled is the flag to enable/disable SSL communication with Gateway, default false
     */
    @JsonProperty("sslEnabled")
    public void setSslEnabled(Boolean sslEnabled) {
        this.sslEnabled = sslEnabled;
    }

    /**
     * storageMode indicates whether the storage for a volume should be ThickProvisioned or ThinProvisioned. Default is ThinProvisioned.
     */
    @JsonProperty("storageMode")
    public String getStorageMode() {
        return storageMode;
    }

    /**
     * storageMode indicates whether the storage for a volume should be ThickProvisioned or ThinProvisioned. Default is ThinProvisioned.
     */
    @JsonProperty("storageMode")
    public void setStorageMode(String storageMode) {
        this.storageMode = storageMode;
    }

    /**
     * storagePool is the ScaleIO Storage Pool associated with the protection domain.
     */
    @JsonProperty("storagePool")
    public String getStoragePool() {
        return storagePool;
    }

    /**
     * storagePool is the ScaleIO Storage Pool associated with the protection domain.
     */
    @JsonProperty("storagePool")
    public void setStoragePool(String storagePool) {
        this.storagePool = storagePool;
    }

    /**
     * system is the name of the storage system as configured in ScaleIO.
     */
    @JsonProperty("system")
    public String getSystem() {
        return system;
    }

    /**
     * system is the name of the storage system as configured in ScaleIO.
     */
    @JsonProperty("system")
    public void setSystem(String system) {
        this.system = system;
    }

    /**
     * volumeName is the name of a volume already created in the ScaleIO system that is associated with this volume source.
     */
    @JsonProperty("volumeName")
    public String getVolumeName() {
        return volumeName;
    }

    /**
     * volumeName is the name of a volume already created in the ScaleIO system that is associated with this volume source.
     */
    @JsonProperty("volumeName")
    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
    }

    @JsonIgnore
    public ScaleIOPersistentVolumeSourceBuilder edit() {
        return new ScaleIOPersistentVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public ScaleIOPersistentVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof ScaleIOPersistentVolumeSource)) {
            return false;
        }
        ScaleIOPersistentVolumeSource other = (ScaleIOPersistentVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fsType = this.getFsType();
        Object other$fsType = other.getFsType();
        if (this$fsType == null ? other$fsType != null : !this$fsType.equals(other$fsType)) {
            return false;
        }
        Object this$gateway = this.getGateway();
        Object other$gateway = other.getGateway();
        if (this$gateway == null ? other$gateway != null : !this$gateway.equals(other$gateway)) {
            return false;
        }
        Object this$protectionDomain = this.getProtectionDomain();
        Object other$protectionDomain = other.getProtectionDomain();
        if (this$protectionDomain == null ? other$protectionDomain != null : !this$protectionDomain.equals(other$protectionDomain)) {
            return false;
        }
        Object this$readOnly = this.getReadOnly();
        Object other$readOnly = other.getReadOnly();
        if (this$readOnly == null ? other$readOnly != null : !this$readOnly.equals(other$readOnly)) {
            return false;
        }
        Object this$secretRef = this.getSecretRef();
        Object other$secretRef = other.getSecretRef();
        if (this$secretRef == null ? other$secretRef != null : !this$secretRef.equals(other$secretRef)) {
            return false;
        }
        Object this$sslEnabled = this.getSslEnabled();
        Object other$sslEnabled = other.getSslEnabled();
        if (this$sslEnabled == null ? other$sslEnabled != null : !this$sslEnabled.equals(other$sslEnabled)) {
            return false;
        }
        Object this$storageMode = this.getStorageMode();
        Object other$storageMode = other.getStorageMode();
        if (this$storageMode == null ? other$storageMode != null : !this$storageMode.equals(other$storageMode)) {
            return false;
        }
        Object this$storagePool = this.getStoragePool();
        Object other$storagePool = other.getStoragePool();
        if (this$storagePool == null ? other$storagePool != null : !this$storagePool.equals(other$storagePool)) {
            return false;
        }
        Object this$system = this.getSystem();
        Object other$system = other.getSystem();
        if (this$system == null ? other$system != null : !this$system.equals(other$system)) {
            return false;
        }
        Object this$volumeName = this.getVolumeName();
        Object other$volumeName = other.getVolumeName();
        if (this$volumeName == null ? other$volumeName != null : !this$volumeName.equals(other$volumeName)) {
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
        return other instanceof ScaleIOPersistentVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fsType = this.getFsType();
        result = result * prime + ($fsType == null ? 43 : $fsType.hashCode());
        Object $gateway = this.getGateway();
        result = result * prime + ($gateway == null ? 43 : $gateway.hashCode());
        Object $protectionDomain = this.getProtectionDomain();
        result = result * prime + ($protectionDomain == null ? 43 : $protectionDomain.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $secretRef = this.getSecretRef();
        result = result * prime + ($secretRef == null ? 43 : $secretRef.hashCode());
        Object $sslEnabled = this.getSslEnabled();
        result = result * prime + ($sslEnabled == null ? 43 : $sslEnabled.hashCode());
        Object $storageMode = this.getStorageMode();
        result = result * prime + ($storageMode == null ? 43 : $storageMode.hashCode());
        Object $storagePool = this.getStoragePool();
        result = result * prime + ($storagePool == null ? 43 : $storagePool.hashCode());
        Object $system = this.getSystem();
        result = result * prime + ($system == null ? 43 : $system.hashCode());
        Object $volumeName = this.getVolumeName();
        result = result * prime + ($volumeName == null ? 43 : $volumeName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ScaleIOPersistentVolumeSource(" + "fsType=" + this.getFsType() + ", gateway=" + this.getGateway() + ", protectionDomain=" + this.getProtectionDomain() + ", readOnly=" + this.getReadOnly() + ", secretRef=" + this.getSecretRef() + ", sslEnabled=" + this.getSslEnabled() + ", storageMode=" + this.getStorageMode() + ", storagePool=" + this.getStoragePool() + ", system=" + this.getSystem() + ", volumeName=" + this.getVolumeName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
