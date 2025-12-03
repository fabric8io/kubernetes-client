
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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

/**
 * HTTPAuthConfig contains configuration for communication with HTTP-speaking backends.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowedHeaders",
    "allowedResponseHeaders",
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
public class HTTPAuthConfig implements Editable<HTTPAuthConfigBuilder>, KubernetesResource
{

    @JsonProperty("allowedHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedHeaders = new ArrayList<>();
    @JsonProperty("allowedResponseHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowedResponseHeaders = new ArrayList<>();
    @JsonProperty("path")
    private String path;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPAuthConfig() {
    }

    public HTTPAuthConfig(List<String> allowedHeaders, List<String> allowedResponseHeaders, String path) {
        super();
        this.allowedHeaders = allowedHeaders;
        this.allowedResponseHeaders = allowedResponseHeaders;
        this.path = path;
    }

    /**
     * AllowedRequestHeaders specifies what additional headers from the client request will be sent to the authorization server.<br><p> <br><p> The following headers must always be sent to the authorization server, regardless of this setting:<br><p> <br><p> &#42; `Host` &#42; `Method` &#42; `Path` &#42; `Content-Length` &#42; `Authorization`<br><p> <br><p> If this list is empty, then only those headers must be sent.<br><p> <br><p> Note that `Content-Length` has a special behavior, in that the length sent must be correct for the actual request to the external authorization server - that is, it must reflect the actual number of bytes sent in the body of the request to the authorization server.<br><p> <br><p> So if the `forwardBody` stanza is unset, or `forwardBody.maxSize` is set to `0`, then `Content-Length` must be `0`. If `forwardBody.maxSize` is set to anything other than `0`, then the `Content-Length` of the authorization request must be set to the actual number of bytes forwarded.
     */
    @JsonProperty("allowedHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedHeaders() {
        return allowedHeaders;
    }

    /**
     * AllowedRequestHeaders specifies what additional headers from the client request will be sent to the authorization server.<br><p> <br><p> The following headers must always be sent to the authorization server, regardless of this setting:<br><p> <br><p> &#42; `Host` &#42; `Method` &#42; `Path` &#42; `Content-Length` &#42; `Authorization`<br><p> <br><p> If this list is empty, then only those headers must be sent.<br><p> <br><p> Note that `Content-Length` has a special behavior, in that the length sent must be correct for the actual request to the external authorization server - that is, it must reflect the actual number of bytes sent in the body of the request to the authorization server.<br><p> <br><p> So if the `forwardBody` stanza is unset, or `forwardBody.maxSize` is set to `0`, then `Content-Length` must be `0`. If `forwardBody.maxSize` is set to anything other than `0`, then the `Content-Length` of the authorization request must be set to the actual number of bytes forwarded.
     */
    @JsonProperty("allowedHeaders")
    public void setAllowedHeaders(List<String> allowedHeaders) {
        this.allowedHeaders = allowedHeaders;
    }

    /**
     * AllowedResponseHeaders specifies what headers from the authorization response will be copied into the request to the backend.<br><p> <br><p> If this list is empty, then all headers from the authorization server except Authority or Host must be copied.
     */
    @JsonProperty("allowedResponseHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowedResponseHeaders() {
        return allowedResponseHeaders;
    }

    /**
     * AllowedResponseHeaders specifies what headers from the authorization response will be copied into the request to the backend.<br><p> <br><p> If this list is empty, then all headers from the authorization server except Authority or Host must be copied.
     */
    @JsonProperty("allowedResponseHeaders")
    public void setAllowedResponseHeaders(List<String> allowedResponseHeaders) {
        this.allowedResponseHeaders = allowedResponseHeaders;
    }

    /**
     * Path sets the prefix that paths from the client request will have added when forwarded to the authorization server.<br><p> <br><p> When empty or unspecified, no prefix is added.<br><p> <br><p> Valid values are the same as the "value" regex for path values in the `match` stanza, and the validation regex will screen out invalid paths in the same way. Even with the validation, implementations MUST sanitize this input before using it directly.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path sets the prefix that paths from the client request will have added when forwarded to the authorization server.<br><p> <br><p> When empty or unspecified, no prefix is added.<br><p> <br><p> Valid values are the same as the "value" regex for path values in the `match` stanza, and the validation regex will screen out invalid paths in the same way. Even with the validation, implementations MUST sanitize this input before using it directly.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonIgnore
    public HTTPAuthConfigBuilder edit() {
        return new HTTPAuthConfigBuilder(this);
    }

    @JsonIgnore
    public HTTPAuthConfigBuilder toBuilder() {
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
