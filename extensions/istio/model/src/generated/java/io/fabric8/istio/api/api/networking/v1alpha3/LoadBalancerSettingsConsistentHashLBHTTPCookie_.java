
package io.fabric8.istio.api.api.networking.v1alpha3;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Describes a HTTP cookie that will be used as the hash key for the Consistent Hash load balancer.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attributes",
    "name",
    "path",
    "ttl"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class LoadBalancerSettingsConsistentHashLBHTTPCookie_ implements Editable<LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder>, KubernetesResource
{

    @JsonProperty("attributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LoadBalancerSettingsConsistentHashLBHTTPCookieAttribute> attributes = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("path")
    private String path;
    @JsonProperty("ttl")
    private String ttl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LoadBalancerSettingsConsistentHashLBHTTPCookie_() {
    }

    public LoadBalancerSettingsConsistentHashLBHTTPCookie_(List<LoadBalancerSettingsConsistentHashLBHTTPCookieAttribute> attributes, String name, String path, String ttl) {
        super();
        this.attributes = attributes;
        this.name = name;
        this.path = path;
        this.ttl = ttl;
    }

    /**
     * Additional attributes for the cookie. They will be used when generating a new cookie.
     */
    @JsonProperty("attributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LoadBalancerSettingsConsistentHashLBHTTPCookieAttribute> getAttributes() {
        return attributes;
    }

    /**
     * Additional attributes for the cookie. They will be used when generating a new cookie.
     */
    @JsonProperty("attributes")
    public void setAttributes(List<LoadBalancerSettingsConsistentHashLBHTTPCookieAttribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * Name of the cookie.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the cookie.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Path to set for the cookie.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path to set for the cookie.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Describes a HTTP cookie that will be used as the hash key for the Consistent Hash load balancer.
     */
    @JsonProperty("ttl")
    public String getTtl() {
        return ttl;
    }

    /**
     * Describes a HTTP cookie that will be used as the hash key for the Consistent Hash load balancer.
     */
    @JsonProperty("ttl")
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    @JsonIgnore
    public LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder edit() {
        return new LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder(this);
    }

    @JsonIgnore
    public LoadBalancerSettingsConsistentHashLBHTTPCookie_Builder toBuilder() {
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
        if (!(o instanceof LoadBalancerSettingsConsistentHashLBHTTPCookie_)) {
            return false;
        }
        LoadBalancerSettingsConsistentHashLBHTTPCookie_ other = (LoadBalancerSettingsConsistentHashLBHTTPCookie_) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$attributes = this.getAttributes();
        Object other$attributes = other.getAttributes();
        if (this$attributes == null ? other$attributes != null : !this$attributes.equals(other$attributes)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$ttl = this.getTtl();
        Object other$ttl = other.getTtl();
        if (this$ttl == null ? other$ttl != null : !this$ttl.equals(other$ttl)) {
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
        return other instanceof LoadBalancerSettingsConsistentHashLBHTTPCookie_;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $attributes = this.getAttributes();
        result = result * prime + ($attributes == null ? 43 : $attributes.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $ttl = this.getTtl();
        result = result * prime + ($ttl == null ? 43 : $ttl.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LoadBalancerSettingsConsistentHashLBHTTPCookie_(" + "attributes=" + this.getAttributes() + ", name=" + this.getName() + ", path=" + this.getPath() + ", ttl=" + this.getTtl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
