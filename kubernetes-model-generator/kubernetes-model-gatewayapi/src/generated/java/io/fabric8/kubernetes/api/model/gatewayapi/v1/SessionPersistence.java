
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
 * SessionPersistence defines the desired state of SessionPersistence.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "absoluteTimeout",
    "cookieConfig",
    "sessionName",
    "type"
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
public class SessionPersistence implements Editable<SessionPersistenceBuilder>, KubernetesResource
{

    @JsonProperty("absoluteTimeout")
    private String absoluteTimeout;
    @JsonProperty("cookieConfig")
    private CookieConfig cookieConfig;
    @JsonProperty("sessionName")
    private String sessionName;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SessionPersistence() {
    }

    public SessionPersistence(String absoluteTimeout, CookieConfig cookieConfig, String sessionName, String type) {
        super();
        this.absoluteTimeout = absoluteTimeout;
        this.cookieConfig = cookieConfig;
        this.sessionName = sessionName;
        this.type = type;
    }

    /**
     * AbsoluteTimeout defines the absolute timeout of the persistent session. Once the AbsoluteTimeout duration has elapsed, the session becomes invalid.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("absoluteTimeout")
    public String getAbsoluteTimeout() {
        return absoluteTimeout;
    }

    /**
     * AbsoluteTimeout defines the absolute timeout of the persistent session. Once the AbsoluteTimeout duration has elapsed, the session becomes invalid.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("absoluteTimeout")
    public void setAbsoluteTimeout(String absoluteTimeout) {
        this.absoluteTimeout = absoluteTimeout;
    }

    /**
     * SessionPersistence defines the desired state of SessionPersistence.
     */
    @JsonProperty("cookieConfig")
    public CookieConfig getCookieConfig() {
        return cookieConfig;
    }

    /**
     * SessionPersistence defines the desired state of SessionPersistence.
     */
    @JsonProperty("cookieConfig")
    public void setCookieConfig(CookieConfig cookieConfig) {
        this.cookieConfig = cookieConfig;
    }

    /**
     * SessionName defines the name of the persistent session token which may be reflected in the cookie or the header. Users should avoid reusing session names to prevent unintended consequences, such as rejection or unpredictable behavior.<br><p> <br><p> Support: Implementation-specific
     */
    @JsonProperty("sessionName")
    public String getSessionName() {
        return sessionName;
    }

    /**
     * SessionName defines the name of the persistent session token which may be reflected in the cookie or the header. Users should avoid reusing session names to prevent unintended consequences, such as rejection or unpredictable behavior.<br><p> <br><p> Support: Implementation-specific
     */
    @JsonProperty("sessionName")
    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    /**
     * Type defines the type of session persistence such as through the use of a header or cookie. Defaults to cookie based session persistence.<br><p> <br><p> Support: Core for "Cookie" type<br><p> <br><p> Support: Extended for "Header" type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type defines the type of session persistence such as through the use of a header or cookie. Defaults to cookie based session persistence.<br><p> <br><p> Support: Core for "Cookie" type<br><p> <br><p> Support: Extended for "Header" type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public SessionPersistenceBuilder edit() {
        return new SessionPersistenceBuilder(this);
    }

    @JsonIgnore
    public SessionPersistenceBuilder toBuilder() {
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
        if (!(o instanceof SessionPersistence)) {
            return false;
        }
        SessionPersistence other = (SessionPersistence) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$absoluteTimeout = this.getAbsoluteTimeout();
        Object other$absoluteTimeout = other.getAbsoluteTimeout();
        if (this$absoluteTimeout == null ? other$absoluteTimeout != null : !this$absoluteTimeout.equals(other$absoluteTimeout)) {
            return false;
        }
        Object this$cookieConfig = this.getCookieConfig();
        Object other$cookieConfig = other.getCookieConfig();
        if (this$cookieConfig == null ? other$cookieConfig != null : !this$cookieConfig.equals(other$cookieConfig)) {
            return false;
        }
        Object this$sessionName = this.getSessionName();
        Object other$sessionName = other.getSessionName();
        if (this$sessionName == null ? other$sessionName != null : !this$sessionName.equals(other$sessionName)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof SessionPersistence;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $absoluteTimeout = this.getAbsoluteTimeout();
        result = result * prime + ($absoluteTimeout == null ? 43 : $absoluteTimeout.hashCode());
        Object $cookieConfig = this.getCookieConfig();
        result = result * prime + ($cookieConfig == null ? 43 : $cookieConfig.hashCode());
        Object $sessionName = this.getSessionName();
        result = result * prime + ($sessionName == null ? 43 : $sessionName.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SessionPersistence(" + "absoluteTimeout=" + this.getAbsoluteTimeout() + ", cookieConfig=" + this.getCookieConfig() + ", sessionName=" + this.getSessionName() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
