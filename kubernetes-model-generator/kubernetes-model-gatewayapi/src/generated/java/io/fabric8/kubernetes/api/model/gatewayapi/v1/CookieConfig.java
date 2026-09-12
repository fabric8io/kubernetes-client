
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * CookieConfig defines the configuration for cookie-based session persistence.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lifetimeType"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class CookieConfig implements Editable<CookieConfigBuilder>, KubernetesResource
{

    @JsonProperty("lifetimeType")
    private String lifetimeType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CookieConfig() {
    }

    public CookieConfig(String lifetimeType) {
        super();
        this.lifetimeType = lifetimeType;
    }

    /**
     * LifetimeType specifies whether the cookie has a permanent or session-based lifetime. A permanent cookie persists until its specified expiry time, defined by the Expires or Max-Age cookie attributes, while a session cookie is deleted when the current session ends.<br><p> <br><p> When set to "Permanent", AbsoluteTimeout indicates the cookie's lifetime via the Expires or Max-Age cookie attributes and is required.<br><p> <br><p> When set to "Session", AbsoluteTimeout indicates the absolute lifetime of the cookie tracked by the gateway and is optional.<br><p> <br><p> Defaults to "Session".<br><p> <br><p> Support: Core for "Session" type<br><p> <br><p> Support: Extended for "Permanent" type
     */
    @JsonProperty("lifetimeType")
    public String getLifetimeType() {
        return lifetimeType;
    }

    /**
     * LifetimeType specifies whether the cookie has a permanent or session-based lifetime. A permanent cookie persists until its specified expiry time, defined by the Expires or Max-Age cookie attributes, while a session cookie is deleted when the current session ends.<br><p> <br><p> When set to "Permanent", AbsoluteTimeout indicates the cookie's lifetime via the Expires or Max-Age cookie attributes and is required.<br><p> <br><p> When set to "Session", AbsoluteTimeout indicates the absolute lifetime of the cookie tracked by the gateway and is optional.<br><p> <br><p> Defaults to "Session".<br><p> <br><p> Support: Core for "Session" type<br><p> <br><p> Support: Extended for "Permanent" type
     */
    @JsonProperty("lifetimeType")
    public void setLifetimeType(String lifetimeType) {
        this.lifetimeType = lifetimeType;
    }

    @JsonIgnore
    public CookieConfigBuilder edit() {
        return new CookieConfigBuilder(this);
    }

    @JsonIgnore
    public CookieConfigBuilder toBuilder() {
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
        if (!(o instanceof CookieConfig)) {
            return false;
        }
        CookieConfig other = (CookieConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$lifetimeType = this.getLifetimeType();
        Object other$lifetimeType = other.getLifetimeType();
        if (this$lifetimeType == null ? other$lifetimeType != null : !this$lifetimeType.equals(other$lifetimeType)) {
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
        return other instanceof CookieConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $lifetimeType = this.getLifetimeType();
        result = result * prime + ($lifetimeType == null ? 43 : $lifetimeType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CookieConfig(" + "lifetimeType=" + this.getLifetimeType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
