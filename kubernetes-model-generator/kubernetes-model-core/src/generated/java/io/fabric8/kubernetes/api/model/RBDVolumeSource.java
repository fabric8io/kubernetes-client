
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
 * Represents a Rados Block Device mount that lasts the lifetime of a pod. RBD volumes support ownership management and SELinux relabeling.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fsType",
    "image",
    "keyring",
    "monitors",
    "pool",
    "readOnly",
    "secretRef",
    "user"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RBDVolumeSource implements Editable<RBDVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("image")
    private String image;
    @JsonProperty("keyring")
    private String keyring;
    @JsonProperty("monitors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> monitors = new ArrayList<>();
    @JsonProperty("pool")
    private String pool;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("secretRef")
    private LocalObjectReference secretRef;
    @JsonProperty("user")
    private String user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RBDVolumeSource() {
    }

    public RBDVolumeSource(String fsType, String image, String keyring, List<String> monitors, String pool, Boolean readOnly, LocalObjectReference secretRef, String user) {
        super();
        this.fsType = fsType;
        this.image = image;
        this.keyring = keyring;
        this.monitors = monitors;
        this.pool = pool;
        this.readOnly = readOnly;
        this.secretRef = secretRef;
        this.user = user;
    }

    /**
     * fsType is the filesystem type of the volume that you want to mount. Tip: Ensure that the filesystem type is supported by the host operating system. Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified. More info: https://kubernetes.io/docs/concepts/storage/volumes#rbd
     */
    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    /**
     * fsType is the filesystem type of the volume that you want to mount. Tip: Ensure that the filesystem type is supported by the host operating system. Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified. More info: https://kubernetes.io/docs/concepts/storage/volumes#rbd
     */
    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    /**
     * image is the rados image name. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image is the rados image name. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * keyring is the path to key ring for RBDUser. Default is /etc/ceph/keyring. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @JsonProperty("keyring")
    public String getKeyring() {
        return keyring;
    }

    /**
     * keyring is the path to key ring for RBDUser. Default is /etc/ceph/keyring. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @JsonProperty("keyring")
    public void setKeyring(String keyring) {
        this.keyring = keyring;
    }

    /**
     * monitors is a collection of Ceph monitors. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @JsonProperty("monitors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMonitors() {
        return monitors;
    }

    /**
     * monitors is a collection of Ceph monitors. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @JsonProperty("monitors")
    public void setMonitors(List<String> monitors) {
        this.monitors = monitors;
    }

    /**
     * pool is the rados pool name. Default is rbd. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @JsonProperty("pool")
    public String getPool() {
        return pool;
    }

    /**
     * pool is the rados pool name. Default is rbd. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @JsonProperty("pool")
    public void setPool(String pool) {
        this.pool = pool;
    }

    /**
     * readOnly here will force the ReadOnly setting in VolumeMounts. Defaults to false. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * readOnly here will force the ReadOnly setting in VolumeMounts. Defaults to false. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * Represents a Rados Block Device mount that lasts the lifetime of a pod. RBD volumes support ownership management and SELinux relabeling.
     */
    @JsonProperty("secretRef")
    public LocalObjectReference getSecretRef() {
        return secretRef;
    }

    /**
     * Represents a Rados Block Device mount that lasts the lifetime of a pod. RBD volumes support ownership management and SELinux relabeling.
     */
    @JsonProperty("secretRef")
    public void setSecretRef(LocalObjectReference secretRef) {
        this.secretRef = secretRef;
    }

    /**
     * user is the rados user name. Default is admin. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    /**
     * user is the rados user name. Default is admin. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonIgnore
    public RBDVolumeSourceBuilder edit() {
        return new RBDVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public RBDVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof RBDVolumeSource)) {
            return false;
        }
        RBDVolumeSource other = (RBDVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fsType = this.getFsType();
        Object other$fsType = other.getFsType();
        if (this$fsType == null ? other$fsType != null : !this$fsType.equals(other$fsType)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$keyring = this.getKeyring();
        Object other$keyring = other.getKeyring();
        if (this$keyring == null ? other$keyring != null : !this$keyring.equals(other$keyring)) {
            return false;
        }
        Object this$monitors = this.getMonitors();
        Object other$monitors = other.getMonitors();
        if (this$monitors == null ? other$monitors != null : !this$monitors.equals(other$monitors)) {
            return false;
        }
        Object this$pool = this.getPool();
        Object other$pool = other.getPool();
        if (this$pool == null ? other$pool != null : !this$pool.equals(other$pool)) {
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
        Object this$user = this.getUser();
        Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) {
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
        return other instanceof RBDVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fsType = this.getFsType();
        result = result * prime + ($fsType == null ? 43 : $fsType.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $keyring = this.getKeyring();
        result = result * prime + ($keyring == null ? 43 : $keyring.hashCode());
        Object $monitors = this.getMonitors();
        result = result * prime + ($monitors == null ? 43 : $monitors.hashCode());
        Object $pool = this.getPool();
        result = result * prime + ($pool == null ? 43 : $pool.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $secretRef = this.getSecretRef();
        result = result * prime + ($secretRef == null ? 43 : $secretRef.hashCode());
        Object $user = this.getUser();
        result = result * prime + ($user == null ? 43 : $user.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RBDVolumeSource(" + "fsType=" + this.getFsType() + ", image=" + this.getImage() + ", keyring=" + this.getKeyring() + ", monitors=" + this.getMonitors() + ", pool=" + this.getPool() + ", readOnly=" + this.getReadOnly() + ", secretRef=" + this.getSecretRef() + ", user=" + this.getUser() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
