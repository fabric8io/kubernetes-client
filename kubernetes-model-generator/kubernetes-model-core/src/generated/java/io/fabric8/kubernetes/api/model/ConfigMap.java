
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
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.PackageSuffix;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.transform.annotations.VelocityTransformation;
import io.sundr.transform.annotations.VelocityTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "binaryData",
    "data",
    "immutable"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Version("v1")
@Group("")
@PackageSuffix(".core.v1")
@VelocityTransformations({
    @VelocityTransformation(value = "/manifest.vm", outputPath = "core.properties", gather = true)
})
public class ConfigMap implements HasMetadata, Namespaced
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private java.lang.String apiVersion = "v1";
    @JsonProperty("binaryData")
    private Map<String, String> binaryData;
    @JsonProperty("data")
    private Map<String, String> data;
    @JsonProperty("immutable")
    private Boolean immutable;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private java.lang.String kind = "ConfigMap";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConfigMap() {
    }

    /**
     * 
     * @param immutable
     * @param metadata
     * @param apiVersion
     * @param data
     * @param binaryData
     * @param kind
     */
    public ConfigMap(java.lang.String apiVersion, Map<String, String> binaryData, Map<String, String> data, Boolean immutable, java.lang.String kind, ObjectMeta metadata) {
        super();
        this.apiVersion = apiVersion;
        this.binaryData = binaryData;
        this.data = data;
        this.immutable = immutable;
        this.kind = kind;
        this.metadata = metadata;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public java.lang.String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(java.lang.String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("binaryData")
    public Map<String, String> getBinaryData() {
        return binaryData;
    }

    @JsonProperty("binaryData")
    public void setBinaryData(Map<String, String> binaryData) {
        this.binaryData = binaryData;
    }

    @JsonProperty("data")
    public Map<String, String> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Map<String, String> data) {
        this.data = data;
    }

    @JsonProperty("immutable")
    public Boolean getImmutable() {
        return immutable;
    }

    @JsonProperty("immutable")
    public void setImmutable(Boolean immutable) {
        this.immutable = immutable;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public java.lang.String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(java.lang.String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
