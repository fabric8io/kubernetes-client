
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
 * CookieConfig defines the configuration for cookie-based session persistence.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lifetimeType",
    "name",
    "path"
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
public class CookieConfig implements Editable<CookieConfigBuilder>, KubernetesResource
{

    @JsonProperty("lifetimeType")
    private String lifetimeType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("path")
    private String path;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CookieConfig() {
    }

    public CookieConfig(String lifetimeType, String name, String path) {
        super();
        this.lifetimeType = lifetimeType;
        this.name = name;
        this.path = path;
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

    /**
     * Name defines the name of the cookie used for session persistence. If not specified, a unique cookie name SHOULD be generated. Users should avoid reusing cookie names to prevent unintended consequences, such as rejection or unpredictable behavior.<br><p> <br><p> &lt;gateway:util:excludeFromCRD&gt; This field is Extended because not all implementations can control the cookie name. Implementations SHOULD support this field if the underlying dataplane allows configuring the cookie name. &lt;/gateway:util:excludeFromCRD&gt;<br><p> <br><p> Support: Extended
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name defines the name of the cookie used for session persistence. If not specified, a unique cookie name SHOULD be generated. Users should avoid reusing cookie names to prevent unintended consequences, such as rejection or unpredictable behavior.<br><p> <br><p> &lt;gateway:util:excludeFromCRD&gt; This field is Extended because not all implementations can control the cookie name. Implementations SHOULD support this field if the underlying dataplane allows configuring the cookie name. &lt;/gateway:util:excludeFromCRD&gt;<br><p> <br><p> Support: Extended
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Path defines the cookie Path attribute. When not specified, implementations MUST default the cookie path to "/".<br><p> <br><p> &lt;gateway:util:excludeFromCRD&gt; This field is Extended because not all dataplanes support configuring the cookie path (e.g. HAProxy hardcodes path=/). Implementations SHOULD support this field if the underlying dataplane allows setting the cookie path attribute. &lt;/gateway:util:excludeFromCRD&gt;<br><p> <br><p> Support: Extended
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path defines the cookie Path attribute. When not specified, implementations MUST default the cookie path to "/".<br><p> <br><p> &lt;gateway:util:excludeFromCRD&gt; This field is Extended because not all dataplanes support configuring the cookie path (e.g. HAProxy hardcodes path=/). Implementations SHOULD support this field if the underlying dataplane allows setting the cookie path attribute. &lt;/gateway:util:excludeFromCRD&gt;<br><p> <br><p> Support: Extended
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
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

}
