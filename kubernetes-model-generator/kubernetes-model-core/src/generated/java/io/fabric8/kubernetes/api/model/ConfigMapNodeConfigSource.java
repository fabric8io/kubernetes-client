
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
 * ConfigMapNodeConfigSource contains the information to reference a ConfigMap as a config source for the Node. This API is deprecated since 1.22: https://git.k8s.io/enhancements/keps/sig-node/281-dynamic-kubelet-configuration
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kubeletConfigKey",
    "name",
    "namespace",
    "resourceVersion",
    "uid"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ConfigMapNodeConfigSource implements Editable<ConfigMapNodeConfigSourceBuilder>, KubernetesResource
{

    @JsonProperty("kubeletConfigKey")
    private String kubeletConfigKey;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("resourceVersion")
    private String resourceVersion;
    @JsonProperty("uid")
    private String uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConfigMapNodeConfigSource() {
    }

    public ConfigMapNodeConfigSource(String kubeletConfigKey, String name, String namespace, String resourceVersion, String uid) {
        super();
        this.kubeletConfigKey = kubeletConfigKey;
        this.name = name;
        this.namespace = namespace;
        this.resourceVersion = resourceVersion;
        this.uid = uid;
    }

    /**
     * KubeletConfigKey declares which key of the referenced ConfigMap corresponds to the KubeletConfiguration structure This field is required in all cases.
     */
    @JsonProperty("kubeletConfigKey")
    public String getKubeletConfigKey() {
        return kubeletConfigKey;
    }

    /**
     * KubeletConfigKey declares which key of the referenced ConfigMap corresponds to the KubeletConfiguration structure This field is required in all cases.
     */
    @JsonProperty("kubeletConfigKey")
    public void setKubeletConfigKey(String kubeletConfigKey) {
        this.kubeletConfigKey = kubeletConfigKey;
    }

    /**
     * Name is the metadata.name of the referenced ConfigMap. This field is required in all cases.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the metadata.name of the referenced ConfigMap. This field is required in all cases.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Namespace is the metadata.namespace of the referenced ConfigMap. This field is required in all cases.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * Namespace is the metadata.namespace of the referenced ConfigMap. This field is required in all cases.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * ResourceVersion is the metadata.ResourceVersion of the referenced ConfigMap. This field is forbidden in Node.Spec, and required in Node.Status.
     */
    @JsonProperty("resourceVersion")
    public String getResourceVersion() {
        return resourceVersion;
    }

    /**
     * ResourceVersion is the metadata.ResourceVersion of the referenced ConfigMap. This field is forbidden in Node.Spec, and required in Node.Status.
     */
    @JsonProperty("resourceVersion")
    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    /**
     * UID is the metadata.UID of the referenced ConfigMap. This field is forbidden in Node.Spec, and required in Node.Status.
     */
    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    /**
     * UID is the metadata.UID of the referenced ConfigMap. This field is forbidden in Node.Spec, and required in Node.Status.
     */
    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public ConfigMapNodeConfigSourceBuilder edit() {
        return new ConfigMapNodeConfigSourceBuilder(this);
    }

    @JsonIgnore
    public ConfigMapNodeConfigSourceBuilder toBuilder() {
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
        if (!(o instanceof ConfigMapNodeConfigSource)) {
            return false;
        }
        ConfigMapNodeConfigSource other = (ConfigMapNodeConfigSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$kubeletConfigKey = this.getKubeletConfigKey();
        Object other$kubeletConfigKey = other.getKubeletConfigKey();
        if (this$kubeletConfigKey == null ? other$kubeletConfigKey != null : !this$kubeletConfigKey.equals(other$kubeletConfigKey)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$resourceVersion = this.getResourceVersion();
        Object other$resourceVersion = other.getResourceVersion();
        if (this$resourceVersion == null ? other$resourceVersion != null : !this$resourceVersion.equals(other$resourceVersion)) {
            return false;
        }
        Object this$uid = this.getUid();
        Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) {
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
        return other instanceof ConfigMapNodeConfigSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $kubeletConfigKey = this.getKubeletConfigKey();
        result = result * prime + ($kubeletConfigKey == null ? 43 : $kubeletConfigKey.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $resourceVersion = this.getResourceVersion();
        result = result * prime + ($resourceVersion == null ? 43 : $resourceVersion.hashCode());
        Object $uid = this.getUid();
        result = result * prime + ($uid == null ? 43 : $uid.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConfigMapNodeConfigSource(" + "kubeletConfigKey=" + this.getKubeletConfigKey() + ", name=" + this.getName() + ", namespace=" + this.getNamespace() + ", resourceVersion=" + this.getResourceVersion() + ", uid=" + this.getUid() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
