
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "host",
    "httpHeaders",
    "path",
    "port",
    "scheme"
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
public class HTTPHealthCheckConfig implements Editable<HTTPHealthCheckConfigBuilder>, KubernetesResource
{

    @JsonProperty("host")
    private String host;
    @JsonProperty("httpHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPHeader> httpHeaders = new ArrayList<>();
    @JsonProperty("path")
    private String path;
    @JsonProperty("port")
    private Long port;
    @JsonProperty("scheme")
    private String scheme;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPHealthCheckConfig() {
    }

    public HTTPHealthCheckConfig(String host, List<HTTPHeader> httpHeaders, String path, Long port, String scheme) {
        super();
        this.host = host;
        this.httpHeaders = httpHeaders;
        this.path = path;
        this.port = port;
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
     * Headers the proxy will pass on to make the request. Allows repeated headers.
     */
    @JsonProperty("httpHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPHeader> getHttpHeaders() {
        return httpHeaders;
    }

    /**
     * Headers the proxy will pass on to make the request. Allows repeated headers.
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
     * Port on which the endpoint lives.
     */
    @JsonProperty("port")
    public Long getPort() {
        return port;
    }

    /**
     * Port on which the endpoint lives.
     */
    @JsonProperty("port")
    public void setPort(Long port) {
        this.port = port;
    }

    /**
     * HTTP or HTTPS, defaults to HTTP
     */
    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    /**
     * HTTP or HTTPS, defaults to HTTP
     */
    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @JsonIgnore
    public HTTPHealthCheckConfigBuilder edit() {
        return new HTTPHealthCheckConfigBuilder(this);
    }

    @JsonIgnore
    public HTTPHealthCheckConfigBuilder toBuilder() {
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
        if (!(o instanceof HTTPHealthCheckConfig)) {
            return false;
        }
        HTTPHealthCheckConfig other = (HTTPHealthCheckConfig) o;
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
        return other instanceof HTTPHealthCheckConfig;
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
        Object $scheme = this.getScheme();
        result = result * prime + ($scheme == null ? 43 : $scheme.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPHealthCheckConfig(" + "host=" + this.getHost() + ", httpHeaders=" + this.getHttpHeaders() + ", path=" + this.getPath() + ", port=" + this.getPort() + ", scheme=" + this.getScheme() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
