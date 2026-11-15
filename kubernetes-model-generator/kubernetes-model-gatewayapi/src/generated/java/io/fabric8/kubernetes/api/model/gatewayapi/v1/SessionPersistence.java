
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * SessionPersistence defines the desired state of SessionPersistence.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "absoluteTimeout",
    "cookie",
    "header",
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
    @JsonProperty("cookie")
    private CookieConfig cookie;
    @JsonProperty("header")
    private HeaderConfig header;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SessionPersistence() {
    }

    public SessionPersistence(String absoluteTimeout, CookieConfig cookie, HeaderConfig header, String type) {
        super();
        this.absoluteTimeout = absoluteTimeout;
        this.cookie = cookie;
        this.header = header;
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
    @JsonProperty("cookie")
    public CookieConfig getCookie() {
        return cookie;
    }

    /**
     * SessionPersistence defines the desired state of SessionPersistence.
     */
    @JsonProperty("cookie")
    public void setCookie(CookieConfig cookie) {
        this.cookie = cookie;
    }

    /**
     * SessionPersistence defines the desired state of SessionPersistence.
     */
    @JsonProperty("header")
    public HeaderConfig getHeader() {
        return header;
    }

    /**
     * SessionPersistence defines the desired state of SessionPersistence.
     */
    @JsonProperty("header")
    public void setHeader(HeaderConfig header) {
        this.header = header;
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

}
