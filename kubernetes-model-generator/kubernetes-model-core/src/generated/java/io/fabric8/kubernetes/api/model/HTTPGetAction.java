
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * HTTPGetAction describes an action based on HTTP Get requests.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "host",
    "httpHeaders",
    "path",
    "port",
    "protocol",
    "scheme"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class HTTPGetAction implements Editable<HTTPGetActionBuilder>, KubernetesResource
{

    @JsonProperty("host")
    private String host;
    @JsonProperty("httpHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPHeader> httpHeaders = new ArrayList<>();
    @JsonProperty("path")
    private String path;
    @JsonProperty("port")
    private IntOrString port;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("scheme")
    private String scheme;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPGetAction() {
    }

    public HTTPGetAction(String host, List<HTTPHeader> httpHeaders, String path, IntOrString port, String protocol, String scheme) {
        super();
        this.host = host;
        this.httpHeaders = httpHeaders;
        this.path = path;
        this.port = port;
        this.protocol = protocol;
        this.scheme = scheme;
    }

    /**
     * Host name to connect to, defaults to the pod IP. You probably want to set "Host" in httpHeaders instead.
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * Host name to connect to, defaults to the pod IP. You probably want to set "Host" in httpHeaders instead.
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Custom headers to set in the request. HTTP allows repeated headers.
     */
    @JsonProperty("httpHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPHeader> getHttpHeaders() {
        return httpHeaders;
    }

    /**
     * Custom headers to set in the request. HTTP allows repeated headers.
     */
    @JsonProperty("httpHeaders")
    public void setHttpHeaders(List<HTTPHeader> httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    /**
     * Path to access on the HTTP server.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path to access on the HTTP server.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * HTTPGetAction describes an action based on HTTP Get requests.
     */
    @JsonProperty("port")
    public IntOrString getPort() {
        return port;
    }

    /**
     * HTTPGetAction describes an action based on HTTP Get requests.
     */
    @JsonProperty("port")
    public void setPort(IntOrString port) {
        this.port = port;
    }

    /**
     * Protocol selects the wire protocol for the probe connection. Nil defaults to HTTP/1.1.
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * Protocol selects the wire protocol for the probe connection. Nil defaults to HTTP/1.1.
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Scheme to use for connecting to the host. Defaults to HTTP.
     */
    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    /**
     * Scheme to use for connecting to the host. Defaults to HTTP.
     */
    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @JsonIgnore
    public HTTPGetActionBuilder edit() {
        return new HTTPGetActionBuilder(this);
    }

    @JsonIgnore
    public HTTPGetActionBuilder toBuilder() {
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
        if (!(o instanceof HTTPGetAction)) {
            return false;
        }
        HTTPGetAction other = (HTTPGetAction) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$host = this.getHost();
        Object other$host = other.getHost();
        if (this$host == null ? other$host != null : !this$host.equals(other$host)) {
            return false;
        }
        Object this$httpHeaders = this.getHttpHeaders();
        Object other$httpHeaders = other.getHttpHeaders();
        if (this$httpHeaders == null ? other$httpHeaders != null : !this$httpHeaders.equals(other$httpHeaders)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$protocol = this.getProtocol();
        Object other$protocol = other.getProtocol();
        if (this$protocol == null ? other$protocol != null : !this$protocol.equals(other$protocol)) {
            return false;
        }
        Object this$scheme = this.getScheme();
        Object other$scheme = other.getScheme();
        if (this$scheme == null ? other$scheme != null : !this$scheme.equals(other$scheme)) {
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
        return other instanceof HTTPGetAction;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $host = this.getHost();
        result = result * prime + ($host == null ? 43 : $host.hashCode());
        Object $httpHeaders = this.getHttpHeaders();
        result = result * prime + ($httpHeaders == null ? 43 : $httpHeaders.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $protocol = this.getProtocol();
        result = result * prime + ($protocol == null ? 43 : $protocol.hashCode());
        Object $scheme = this.getScheme();
        result = result * prime + ($scheme == null ? 43 : $scheme.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPGetAction(" + "host=" + this.getHost() + ", httpHeaders=" + this.getHttpHeaders() + ", path=" + this.getPath() + ", port=" + this.getPort() + ", protocol=" + this.getProtocol() + ", scheme=" + this.getScheme() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
