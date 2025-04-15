
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
 * HTTPRequestRedirect defines a filter that redirects a request. This filter MUST NOT be used on the same Route rule as a HTTPURLRewrite filter.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hostname",
    "path",
    "port",
    "scheme",
    "statusCode"
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
public class HTTPRequestRedirectFilter implements Editable<HTTPRequestRedirectFilterBuilder>, KubernetesResource
{

    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("path")
    private HTTPPathModifier path;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("scheme")
    private String scheme;
    @JsonProperty("statusCode")
    private Integer statusCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRequestRedirectFilter() {
    }

    public HTTPRequestRedirectFilter(String hostname, HTTPPathModifier path, Integer port, String scheme, Integer statusCode) {
        super();
        this.hostname = hostname;
        this.path = path;
        this.port = port;
        this.scheme = scheme;
        this.statusCode = statusCode;
    }

    /**
     * Hostname is the hostname to be used in the value of the `Location` header in the response. When empty, the hostname in the `Host` header of the request is used.<br><p> <br><p> Support: Core
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * Hostname is the hostname to be used in the value of the `Location` header in the response. When empty, the hostname in the `Host` header of the request is used.<br><p> <br><p> Support: Core
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * HTTPRequestRedirect defines a filter that redirects a request. This filter MUST NOT be used on the same Route rule as a HTTPURLRewrite filter.
     */
    @JsonProperty("path")
    public HTTPPathModifier getPath() {
        return path;
    }

    /**
     * HTTPRequestRedirect defines a filter that redirects a request. This filter MUST NOT be used on the same Route rule as a HTTPURLRewrite filter.
     */
    @JsonProperty("path")
    public void setPath(HTTPPathModifier path) {
        this.path = path;
    }

    /**
     * Port is the port to be used in the value of the `Location` header in the response.<br><p> <br><p> If no port is specified, the redirect port MUST be derived using the following rules:<br><p> <br><p> &#42; If redirect scheme is not-empty, the redirect port MUST be the well-known<br><p>   port associated with the redirect scheme. Specifically "http" to port 80<br><p>   and "https" to port 443. If the redirect scheme does not have a<br><p>   well-known port, the listener port of the Gateway SHOULD be used.<br><p> &#42; If redirect scheme is empty, the redirect port MUST be the Gateway<br><p>   Listener port.<br><p> <br><p> Implementations SHOULD NOT add the port number in the 'Location' header in the following cases:<br><p> <br><p> &#42; A Location header that will use HTTP (whether that is determined via<br><p>   the Listener protocol or the Scheme field) _and_ use port 80.<br><p> &#42; A Location header that will use HTTPS (whether that is determined via<br><p>   the Listener protocol or the Scheme field) _and_ use port 443.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * Port is the port to be used in the value of the `Location` header in the response.<br><p> <br><p> If no port is specified, the redirect port MUST be derived using the following rules:<br><p> <br><p> &#42; If redirect scheme is not-empty, the redirect port MUST be the well-known<br><p>   port associated with the redirect scheme. Specifically "http" to port 80<br><p>   and "https" to port 443. If the redirect scheme does not have a<br><p>   well-known port, the listener port of the Gateway SHOULD be used.<br><p> &#42; If redirect scheme is empty, the redirect port MUST be the Gateway<br><p>   Listener port.<br><p> <br><p> Implementations SHOULD NOT add the port number in the 'Location' header in the following cases:<br><p> <br><p> &#42; A Location header that will use HTTP (whether that is determined via<br><p>   the Listener protocol or the Scheme field) _and_ use port 80.<br><p> &#42; A Location header that will use HTTPS (whether that is determined via<br><p>   the Listener protocol or the Scheme field) _and_ use port 443.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * Scheme is the scheme to be used in the value of the `Location` header in the response. When empty, the scheme of the request is used.<br><p> <br><p> Scheme redirects can affect the port of the redirect, for more information, refer to the documentation for the port field of this filter.<br><p> <br><p> Note that values may be added to this enum, implementations must ensure that unknown values will not cause a crash.<br><p> <br><p> Unknown values here must result in the implementation setting the Accepted Condition for the Route to `status: False`, with a Reason of `UnsupportedValue`.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    /**
     * Scheme is the scheme to be used in the value of the `Location` header in the response. When empty, the scheme of the request is used.<br><p> <br><p> Scheme redirects can affect the port of the redirect, for more information, refer to the documentation for the port field of this filter.<br><p> <br><p> Note that values may be added to this enum, implementations must ensure that unknown values will not cause a crash.<br><p> <br><p> Unknown values here must result in the implementation setting the Accepted Condition for the Route to `status: False`, with a Reason of `UnsupportedValue`.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    /**
     * StatusCode is the HTTP status code to be used in response.<br><p> <br><p> Note that values may be added to this enum, implementations must ensure that unknown values will not cause a crash.<br><p> <br><p> Unknown values here must result in the implementation setting the Accepted Condition for the Route to `status: False`, with a Reason of `UnsupportedValue`.<br><p> <br><p> Support: Core
     */
    @JsonProperty("statusCode")
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * StatusCode is the HTTP status code to be used in response.<br><p> <br><p> Note that values may be added to this enum, implementations must ensure that unknown values will not cause a crash.<br><p> <br><p> Unknown values here must result in the implementation setting the Accepted Condition for the Route to `status: False`, with a Reason of `UnsupportedValue`.<br><p> <br><p> Support: Core
     */
    @JsonProperty("statusCode")
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @JsonIgnore
    public HTTPRequestRedirectFilterBuilder edit() {
        return new HTTPRequestRedirectFilterBuilder(this);
    }

    @JsonIgnore
    public HTTPRequestRedirectFilterBuilder toBuilder() {
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
