
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "driver",
    "fsType",
    "options",
    "readOnly",
    "secretRef"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class FlexPersistentVolumeSource implements Editable<FlexPersistentVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("driver")
    private String driver;
    @JsonProperty("fsType")
    private String fsType;
    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> options = new LinkedHashMap<>();
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("secretRef")
    private SecretReference secretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FlexPersistentVolumeSource() {
    }

    public FlexPersistentVolumeSource(String driver, String fsType, Map<String, String> options, Boolean readOnly, SecretReference secretRef) {
        super();
        this.driver = driver;
        this.fsType = fsType;
        this.options = options;
        this.readOnly = readOnly;
        this.secretRef = secretRef;
    }

    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    @JsonProperty("fsType")
    public String getFsType() {
        return fsType;
    }

    @JsonProperty("fsType")
    public void setFsType(String fsType) {
        this.fsType = fsType;
    }

    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(Map<String, String> options) {
        this.options = options;
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

    @JsonIgnore
    public FlexPersistentVolumeSourceBuilder edit() {
        return new FlexPersistentVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public FlexPersistentVolumeSourceBuilder toBuilder() {
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
