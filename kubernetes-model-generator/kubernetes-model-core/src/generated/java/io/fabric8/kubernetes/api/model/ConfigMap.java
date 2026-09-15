
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
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;

/**
 * ConfigMap holds configuration data for pods to consume.
 */
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
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Version("v1")
@Group("")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ConfigMap implements Editable<ConfigMapBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "v1";
    @JsonProperty("binaryData")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> binaryData = new LinkedHashMap<>();
    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> data = new LinkedHashMap<>();
    @JsonProperty("immutable")
    private Boolean immutable;
    @JsonProperty("kind")
    private String kind = "ConfigMap";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConfigMap() {
    }

    public ConfigMap(String apiVersion, Map<String, String> binaryData, Map<String, String> data, Boolean immutable, String kind, ObjectMeta metadata) {
        super();
        this.apiVersion = apiVersion;
        this.binaryData = binaryData;
        this.data = data;
        this.immutable = immutable;
        this.kind = kind;
        this.metadata = metadata;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * BinaryData contains the binary data. Each key must consist of alphanumeric characters, '-', '_' or '.'. BinaryData can contain byte sequences that are not in the UTF-8 range. The keys stored in BinaryData must not overlap with the ones in the Data field, this is enforced during validation process. Using this field will require 1.10+ apiserver and kubelet. Note: BinaryData keys are not currently propagated to container env vars via ConfigMapKeyRef or ConfigMapRef env sources; only Data keys are used.
     */
    @JsonProperty("binaryData")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getBinaryData() {
        return binaryData;
    }

    /**
     * BinaryData contains the binary data. Each key must consist of alphanumeric characters, '-', '_' or '.'. BinaryData can contain byte sequences that are not in the UTF-8 range. The keys stored in BinaryData must not overlap with the ones in the Data field, this is enforced during validation process. Using this field will require 1.10+ apiserver and kubelet. Note: BinaryData keys are not currently propagated to container env vars via ConfigMapKeyRef or ConfigMapRef env sources; only Data keys are used.
     */
    @JsonProperty("binaryData")
    public void setBinaryData(Map<String, String> binaryData) {
        this.binaryData = binaryData;
    }

    /**
     * Data contains the configuration data. Each key must consist of alphanumeric characters, '-', '_' or '.'. Values with non-UTF-8 byte sequences must use the BinaryData field. The keys stored in Data must not overlap with the keys in the BinaryData field, this is enforced during validation process.
     */
    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getData() {
        return data;
    }

    /**
     * Data contains the configuration data. Each key must consist of alphanumeric characters, '-', '_' or '.'. Values with non-UTF-8 byte sequences must use the BinaryData field. The keys stored in Data must not overlap with the keys in the BinaryData field, this is enforced during validation process.
     */
    @JsonProperty("data")
    public void setData(Map<String, String> data) {
        this.data = data;
    }

    /**
     * Immutable, if set to true, ensures that data stored in the ConfigMap cannot be updated (only object metadata can be modified). If not set to true, the field can be modified at any time. Defaulted to nil.
     */
    @JsonProperty("immutable")
    public Boolean getImmutable() {
        return immutable;
    }

    /**
     * Immutable, if set to true, ensures that data stored in the ConfigMap cannot be updated (only object metadata can be modified). If not set to true, the field can be modified at any time. Defaulted to nil.
     */
    @JsonProperty("immutable")
    public void setImmutable(Boolean immutable) {
        this.immutable = immutable;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * ConfigMap holds configuration data for pods to consume.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * ConfigMap holds configuration data for pods to consume.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonIgnore
    public ConfigMapBuilder edit() {
        return new ConfigMapBuilder(this);
    }

    @JsonIgnore
    public ConfigMapBuilder toBuilder() {
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
        if (!(o instanceof ConfigMap)) {
            return false;
        }
        ConfigMap other = (ConfigMap) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$binaryData = this.getBinaryData();
        Object other$binaryData = other.getBinaryData();
        if (this$binaryData == null ? other$binaryData != null : !this$binaryData.equals(other$binaryData)) {
            return false;
        }
        Object this$data = this.getData();
        Object other$data = other.getData();
        if (this$data == null ? other$data != null : !this$data.equals(other$data)) {
            return false;
        }
        Object this$immutable = this.getImmutable();
        Object other$immutable = other.getImmutable();
        if (this$immutable == null ? other$immutable != null : !this$immutable.equals(other$immutable)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
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
        return other instanceof ConfigMap;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $binaryData = this.getBinaryData();
        result = result * prime + ($binaryData == null ? 43 : $binaryData.hashCode());
        Object $data = this.getData();
        result = result * prime + ($data == null ? 43 : $data.hashCode());
        Object $immutable = this.getImmutable();
        result = result * prime + ($immutable == null ? 43 : $immutable.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConfigMap(" + "apiVersion=" + this.getApiVersion() + ", binaryData=" + this.getBinaryData() + ", data=" + this.getData() + ", immutable=" + this.getImmutable() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
