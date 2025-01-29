
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * SessionPersistence defines the desired state of SessionPersistence.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "absoluteTimeout",
    "cookieConfig",
    "idleTimeout",
    "sessionName",
    "type"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
public class SessionPersistence implements Editable<SessionPersistenceBuilder>, KubernetesResource
{

    @JsonProperty("absoluteTimeout")
    private String absoluteTimeout;
    @JsonProperty("cookieConfig")
    private CookieConfig cookieConfig;
    @JsonProperty("idleTimeout")
    private String idleTimeout;
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

    public SessionPersistence(String absoluteTimeout, CookieConfig cookieConfig, String idleTimeout, String sessionName, String type) {
        super();
        this.absoluteTimeout = absoluteTimeout;
        this.cookieConfig = cookieConfig;
        this.idleTimeout = idleTimeout;
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
     * IdleTimeout defines the idle timeout of the persistent session. Once the session has been idle for more than the specified IdleTimeout duration, the session becomes invalid.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("idleTimeout")
    public String getIdleTimeout() {
        return idleTimeout;
    }

    /**
     * IdleTimeout defines the idle timeout of the persistent session. Once the session has been idle for more than the specified IdleTimeout duration, the session becomes invalid.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("idleTimeout")
    public void setIdleTimeout(String idleTimeout) {
        this.idleTimeout = idleTimeout;
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
     * Type defines the type of session persistence such as through the use a header or cookie. Defaults to cookie based session persistence.<br><p> <br><p> Support: Core for "Cookie" type<br><p> <br><p> Support: Extended for "Header" type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type defines the type of session persistence such as through the use a header or cookie. Defaults to cookie based session persistence.<br><p> <br><p> Support: Core for "Cookie" type<br><p> <br><p> Support: Extended for "Header" type
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
