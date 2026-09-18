
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * ISCSIPersistentVolumeSource represents an ISCSI disk. ISCSI volumes can only be mounted as read/write once. ISCSI volumes support ownership management and SELinux relabeling.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "chapAuthDiscovery",
    "chapAuthSession",
    "fsType",
    "initiatorName",
    "iqn",
    "iscsiInterface",
    "lun",
    "portals",
    "readOnly",
    "secretRef",
    "targetPortal"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ISCSIPersistentVolumeSource implements Editable<ISCSIPersistentVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("chapAuthDiscovery")
    private Boolean chapAuthDiscovery;
    @JsonProperty("chapAuthSession")
    private Boolean chapAuthSession;
    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("initiatorName")
    private String initiatorName;
    @JsonProperty("iqn")
    private String iqn;
    @JsonProperty("iscsiInterface")
    private String iscsiInterface;
    @JsonProperty("lun")
    private Integer lun;
    @JsonProperty("portals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> portals = new ArrayList<>();
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("secretRef")
    private SecretReference secretRef;
    @JsonProperty("targetPortal")
    private String targetPortal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ISCSIPersistentVolumeSource() {
    }

    public ISCSIPersistentVolumeSource(Boolean chapAuthDiscovery, Boolean chapAuthSession, String fsType, String initiatorName, String iqn, String iscsiInterface, Integer lun, List<String> portals, Boolean readOnly, SecretReference secretRef, String targetPortal) {
        super();
        this.chapAuthDiscovery = chapAuthDiscovery;
        this.chapAuthSession = chapAuthSession;
        this.fsType = fsType;
        this.initiatorName = initiatorName;
        this.iqn = iqn;
        this.iscsiInterface = iscsiInterface;
        this.lun = lun;
        this.portals = portals;
        this.readOnly = readOnly;
        this.secretRef = secretRef;
        this.targetPortal = targetPortal;
    }

    /**
     * chapAuthDiscovery defines whether support iSCSI Discovery CHAP authentication
     */
    @JsonProperty("chapAuthDiscovery")
    public Boolean getChapAuthDiscovery() {
        return chapAuthDiscovery;
    }

    /**
     * chapAuthDiscovery defines whether support iSCSI Discovery CHAP authentication
     */
    @JsonProperty("chapAuthDiscovery")
    public void setChapAuthDiscovery(Boolean chapAuthDiscovery) {
        this.chapAuthDiscovery = chapAuthDiscovery;
    }

    /**
     * chapAuthSession defines whether support iSCSI Session CHAP authentication
     */
    @JsonProperty("chapAuthSession")
    public Boolean getChapAuthSession() {
        return chapAuthSession;
    }

    /**
     * chapAuthSession defines whether support iSCSI Session CHAP authentication
     */
    @JsonProperty("chapAuthSession")
    public void setChapAuthSession(Boolean chapAuthSession) {
        this.chapAuthSession = chapAuthSession;
    }

    /**
     * fsType is the filesystem type of the volume that you want to mount. Tip: Ensure that the filesystem type is supported by the host operating system. Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified. More info: https://kubernetes.io/docs/concepts/storage/volumes#iscsi
     */
    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    /**
     * fsType is the filesystem type of the volume that you want to mount. Tip: Ensure that the filesystem type is supported by the host operating system. Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified. More info: https://kubernetes.io/docs/concepts/storage/volumes#iscsi
     */
    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    /**
     * initiatorName is the custom iSCSI Initiator Name. If initiatorName is specified with iscsiInterface simultaneously, new iSCSI interface &lt;target portal&gt;:&lt;volume name&gt; will be created for the connection.
     */
    @JsonProperty("initiatorName")
    public String getInitiatorName() {
        return initiatorName;
    }

    /**
     * initiatorName is the custom iSCSI Initiator Name. If initiatorName is specified with iscsiInterface simultaneously, new iSCSI interface &lt;target portal&gt;:&lt;volume name&gt; will be created for the connection.
     */
    @JsonProperty("initiatorName")
    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    /**
     * iqn is Target iSCSI Qualified Name.
     */
    @JsonProperty("iqn")
    public String getIqn() {
        return iqn;
    }

    /**
     * iqn is Target iSCSI Qualified Name.
     */
    @JsonProperty("iqn")
    public void setIqn(String iqn) {
        this.iqn = iqn;
    }

    /**
     * iscsiInterface is the interface Name that uses an iSCSI transport. Defaults to 'default' (tcp).
     */
    @JsonProperty("iscsiInterface")
    public String getIscsiInterface() {
        return iscsiInterface;
    }

    /**
     * iscsiInterface is the interface Name that uses an iSCSI transport. Defaults to 'default' (tcp).
     */
    @JsonProperty("iscsiInterface")
    public void setIscsiInterface(String iscsiInterface) {
        this.iscsiInterface = iscsiInterface;
    }

    /**
     * lun is iSCSI Target Lun number.
     */
    @JsonProperty("lun")
    public Integer getLun() {
        return lun;
    }

    /**
     * lun is iSCSI Target Lun number.
     */
    @JsonProperty("lun")
    public void setLun(Integer lun) {
        this.lun = lun;
    }

    /**
     * portals is the iSCSI Target Portal List. The Portal is either an IP or ip_addr:port if the port is other than default (typically TCP ports 860 and 3260).
     */
    @JsonProperty("portals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPortals() {
        return portals;
    }

    /**
     * portals is the iSCSI Target Portal List. The Portal is either an IP or ip_addr:port if the port is other than default (typically TCP ports 860 and 3260).
     */
    @JsonProperty("portals")
    public void setPortals(List<String> portals) {
        this.portals = portals;
    }

    /**
     * readOnly here will force the ReadOnly setting in VolumeMounts. Defaults to false.
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * readOnly here will force the ReadOnly setting in VolumeMounts. Defaults to false.
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * ISCSIPersistentVolumeSource represents an ISCSI disk. ISCSI volumes can only be mounted as read/write once. ISCSI volumes support ownership management and SELinux relabeling.
     */
    @JsonProperty("secretRef")
    public SecretReference getSecretRef() {
        return secretRef;
    }

    /**
     * ISCSIPersistentVolumeSource represents an ISCSI disk. ISCSI volumes can only be mounted as read/write once. ISCSI volumes support ownership management and SELinux relabeling.
     */
    @JsonProperty("secretRef")
    public void setSecretRef(SecretReference secretRef) {
        this.secretRef = secretRef;
    }

    /**
     * targetPortal is iSCSI Target Portal. The Portal is either an IP or ip_addr:port if the port is other than default (typically TCP ports 860 and 3260).
     */
    @JsonProperty("targetPortal")
    public String getTargetPortal() {
        return targetPortal;
    }

    /**
     * targetPortal is iSCSI Target Portal. The Portal is either an IP or ip_addr:port if the port is other than default (typically TCP ports 860 and 3260).
     */
    @JsonProperty("targetPortal")
    public void setTargetPortal(String targetPortal) {
        this.targetPortal = targetPortal;
    }

    @JsonIgnore
    public ISCSIPersistentVolumeSourceBuilder edit() {
        return new ISCSIPersistentVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public ISCSIPersistentVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof ISCSIPersistentVolumeSource)) {
            return false;
        }
        ISCSIPersistentVolumeSource other = (ISCSIPersistentVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$chapAuthDiscovery = this.getChapAuthDiscovery();
        Object other$chapAuthDiscovery = other.getChapAuthDiscovery();
        if (this$chapAuthDiscovery == null ? other$chapAuthDiscovery != null : !this$chapAuthDiscovery.equals(other$chapAuthDiscovery)) {
            return false;
        }
        Object this$chapAuthSession = this.getChapAuthSession();
        Object other$chapAuthSession = other.getChapAuthSession();
        if (this$chapAuthSession == null ? other$chapAuthSession != null : !this$chapAuthSession.equals(other$chapAuthSession)) {
            return false;
        }
        Object this$fsType = this.getFsType();
        Object other$fsType = other.getFsType();
        if (this$fsType == null ? other$fsType != null : !this$fsType.equals(other$fsType)) {
            return false;
        }
        Object this$initiatorName = this.getInitiatorName();
        Object other$initiatorName = other.getInitiatorName();
        if (this$initiatorName == null ? other$initiatorName != null : !this$initiatorName.equals(other$initiatorName)) {
            return false;
        }
        Object this$iqn = this.getIqn();
        Object other$iqn = other.getIqn();
        if (this$iqn == null ? other$iqn != null : !this$iqn.equals(other$iqn)) {
            return false;
        }
        Object this$iscsiInterface = this.getIscsiInterface();
        Object other$iscsiInterface = other.getIscsiInterface();
        if (this$iscsiInterface == null ? other$iscsiInterface != null : !this$iscsiInterface.equals(other$iscsiInterface)) {
            return false;
        }
        Object this$lun = this.getLun();
        Object other$lun = other.getLun();
        if (this$lun == null ? other$lun != null : !this$lun.equals(other$lun)) {
            return false;
        }
        Object this$portals = this.getPortals();
        Object other$portals = other.getPortals();
        if (this$portals == null ? other$portals != null : !this$portals.equals(other$portals)) {
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
        Object this$targetPortal = this.getTargetPortal();
        Object other$targetPortal = other.getTargetPortal();
        if (this$targetPortal == null ? other$targetPortal != null : !this$targetPortal.equals(other$targetPortal)) {
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
        return other instanceof ISCSIPersistentVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $chapAuthDiscovery = this.getChapAuthDiscovery();
        result = result * prime + ($chapAuthDiscovery == null ? 43 : $chapAuthDiscovery.hashCode());
        Object $chapAuthSession = this.getChapAuthSession();
        result = result * prime + ($chapAuthSession == null ? 43 : $chapAuthSession.hashCode());
        Object $fsType = this.getFsType();
        result = result * prime + ($fsType == null ? 43 : $fsType.hashCode());
        Object $initiatorName = this.getInitiatorName();
        result = result * prime + ($initiatorName == null ? 43 : $initiatorName.hashCode());
        Object $iqn = this.getIqn();
        result = result * prime + ($iqn == null ? 43 : $iqn.hashCode());
        Object $iscsiInterface = this.getIscsiInterface();
        result = result * prime + ($iscsiInterface == null ? 43 : $iscsiInterface.hashCode());
        Object $lun = this.getLun();
        result = result * prime + ($lun == null ? 43 : $lun.hashCode());
        Object $portals = this.getPortals();
        result = result * prime + ($portals == null ? 43 : $portals.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $secretRef = this.getSecretRef();
        result = result * prime + ($secretRef == null ? 43 : $secretRef.hashCode());
        Object $targetPortal = this.getTargetPortal();
        result = result * prime + ($targetPortal == null ? 43 : $targetPortal.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ISCSIPersistentVolumeSource(" + "chapAuthDiscovery=" + this.getChapAuthDiscovery() + ", chapAuthSession=" + this.getChapAuthSession() + ", fsType=" + this.getFsType() + ", initiatorName=" + this.getInitiatorName() + ", iqn=" + this.getIqn() + ", iscsiInterface=" + this.getIscsiInterface() + ", lun=" + this.getLun() + ", portals=" + this.getPortals() + ", readOnly=" + this.getReadOnly() + ", secretRef=" + this.getSecretRef() + ", targetPortal=" + this.getTargetPortal() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
