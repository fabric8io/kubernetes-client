
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
 * Represents a Ceph Filesystem mount that lasts the lifetime of a pod Cephfs volumes do not support ownership management or SELinux relabeling.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "monitors",
    "path",
    "readOnly",
    "secretFile",
    "secretRef",
    "user"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class CephFSPersistentVolumeSource implements Editable<CephFSPersistentVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("monitors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> monitors = new ArrayList<>();
    @JsonProperty("path")
    private String path;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("secretFile")
    private String secretFile;
    @JsonProperty("secretRef")
    private SecretReference secretRef;
    @JsonProperty("user")
    private String user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CephFSPersistentVolumeSource() {
    }

    public CephFSPersistentVolumeSource(List<String> monitors, String path, Boolean readOnly, String secretFile, SecretReference secretRef, String user) {
        super();
        this.monitors = monitors;
        this.path = path;
        this.readOnly = readOnly;
        this.secretFile = secretFile;
        this.secretRef = secretRef;
        this.user = user;
    }

    /**
     * monitors is Required: Monitors is a collection of Ceph monitors More info: https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
     */
    @JsonProperty("monitors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMonitors() {
        return monitors;
    }

    /**
     * monitors is Required: Monitors is a collection of Ceph monitors More info: https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
     */
    @JsonProperty("monitors")
    public void setMonitors(List<String> monitors) {
        this.monitors = monitors;
    }

    /**
     * path is Optional: Used as the mounted root, rather than the full Ceph tree, default is /
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * path is Optional: Used as the mounted root, rather than the full Ceph tree, default is /
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * readOnly is Optional: Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts. More info: https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * readOnly is Optional: Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts. More info: https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * secretFile is Optional: SecretFile is the path to key ring for User, default is /etc/ceph/user.secret More info: https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
     */
    @JsonProperty("secretFile")
    public String getSecretFile() {
        return secretFile;
    }

    /**
     * secretFile is Optional: SecretFile is the path to key ring for User, default is /etc/ceph/user.secret More info: https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
     */
    @JsonProperty("secretFile")
    public void setSecretFile(String secretFile) {
        this.secretFile = secretFile;
    }

    /**
     * Represents a Ceph Filesystem mount that lasts the lifetime of a pod Cephfs volumes do not support ownership management or SELinux relabeling.
     */
    @JsonProperty("secretRef")
    public SecretReference getSecretRef() {
        return secretRef;
    }

    /**
     * Represents a Ceph Filesystem mount that lasts the lifetime of a pod Cephfs volumes do not support ownership management or SELinux relabeling.
     */
    @JsonProperty("secretRef")
    public void setSecretRef(SecretReference secretRef) {
        this.secretRef = secretRef;
    }

    /**
     * user is Optional: User is the rados user name, default is admin More info: https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
     */
    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    /**
     * user is Optional: User is the rados user name, default is admin More info: https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
     */
    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonIgnore
    public CephFSPersistentVolumeSourceBuilder edit() {
        return new CephFSPersistentVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public CephFSPersistentVolumeSourceBuilder toBuilder() {
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
        if (!(o instanceof CephFSPersistentVolumeSource)) {
            return false;
        }
        CephFSPersistentVolumeSource other = (CephFSPersistentVolumeSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$monitors = this.getMonitors();
        Object other$monitors = other.getMonitors();
        if (this$monitors == null ? other$monitors != null : !this$monitors.equals(other$monitors)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$readOnly = this.getReadOnly();
        Object other$readOnly = other.getReadOnly();
        if (this$readOnly == null ? other$readOnly != null : !this$readOnly.equals(other$readOnly)) {
            return false;
        }
        Object this$secretFile = this.getSecretFile();
        Object other$secretFile = other.getSecretFile();
        if (this$secretFile == null ? other$secretFile != null : !this$secretFile.equals(other$secretFile)) {
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
        return other instanceof CephFSPersistentVolumeSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $monitors = this.getMonitors();
        result = result * prime + ($monitors == null ? 43 : $monitors.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $secretFile = this.getSecretFile();
        result = result * prime + ($secretFile == null ? 43 : $secretFile.hashCode());
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
        return "CephFSPersistentVolumeSource(" + "monitors=" + this.getMonitors() + ", path=" + this.getPath() + ", readOnly=" + this.getReadOnly() + ", secretFile=" + this.getSecretFile() + ", secretRef=" + this.getSecretRef() + ", user=" + this.getUser() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
