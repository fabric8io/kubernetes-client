
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "fsType",
    "image",
    "keyring",
    "monitors",
    "pool",
    "readOnly",
    "secretRef",
    "user"
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
public class RBDPersistentVolumeSource implements KubernetesResource
{

    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("image")
    private String image;
    @JsonProperty("keyring")
    private String keyring;
    @JsonProperty("monitors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> monitors = new ArrayList<String>();
    @JsonProperty("pool")
    private String pool;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("secretRef")
    private SecretReference secretRef;
    @JsonProperty("user")
    private String user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RBDPersistentVolumeSource() {
    }

    public RBDPersistentVolumeSource(String fsType, String image, String keyring, List<String> monitors, String pool, Boolean readOnly, SecretReference secretRef, String user) {
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

    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("keyring")
    public String getKeyring() {
        return keyring;
    }

    @JsonProperty("keyring")
    public void setKeyring(String keyring) {
        this.keyring = keyring;
    }

    @JsonProperty("monitors")
    public List<String> getMonitors() {
        return monitors;
    }

    @JsonProperty("monitors")
    public void setMonitors(List<String> monitors) {
        this.monitors = monitors;
    }

    @JsonProperty("pool")
    public String getPool() {
        return pool;
    }

    @JsonProperty("pool")
    public void setPool(String pool) {
        this.pool = pool;
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

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
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
