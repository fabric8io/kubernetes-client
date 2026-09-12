
package io.fabric8.chaosmesh.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "method",
    "path",
    "port",
    "request_headers",
    "response_headers"
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
public class PodHttpChaosSelector implements Editable<PodHttpChaosSelectorBuilder>, KubernetesResource
{

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("method")
    private String method;
    @JsonProperty("path")
    private String path;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("request_headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> requestHeaders = new LinkedHashMap<>();
    @JsonProperty("response_headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> responseHeaders = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodHttpChaosSelector() {
    }

    public PodHttpChaosSelector(Integer code, String method, String path, Integer port, Map<String, String> requestHeaders, Map<String, String> responseHeaders) {
        super();
        this.code = code;
        this.method = method;
        this.path = path;
        this.port = port;
        this.requestHeaders = requestHeaders;
        this.responseHeaders = responseHeaders;
    }

    /**
     * Code is a rule to select target by http status code in response.
     */
    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    /**
     * Code is a rule to select target by http status code in response.
     */
    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Method is a rule to select target by http method in request.
     */
    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    /**
     * Method is a rule to select target by http method in request.
     */
    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Path is a rule to select target by uri path in http request.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path is a rule to select target by uri path in http request.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Port is a rule to select server listening on specific port.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * Port is a rule to select server listening on specific port.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * RequestHeaders is a rule to select target by http headers in request. The key-value pairs represent header name and header value pairs.
     */
    @JsonProperty("request_headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    /**
     * RequestHeaders is a rule to select target by http headers in request. The key-value pairs represent header name and header value pairs.
     */
    @JsonProperty("request_headers")
    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    /**
     * ResponseHeaders is a rule to select target by http headers in response. The key-value pairs represent header name and header value pairs.
     */
    @JsonProperty("response_headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    /**
     * ResponseHeaders is a rule to select target by http headers in response. The key-value pairs represent header name and header value pairs.
     */
    @JsonProperty("response_headers")
    public void setResponseHeaders(Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    @JsonIgnore
    public PodHttpChaosSelectorBuilder edit() {
        return new PodHttpChaosSelectorBuilder(this);
    }

    @JsonIgnore
    public PodHttpChaosSelectorBuilder toBuilder() {
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
        if (!(o instanceof PodHttpChaosSelector)) {
            return false;
        }
        PodHttpChaosSelector other = (PodHttpChaosSelector) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$code = this.getCode();
        Object other$code = other.getCode();
        if (this$code == null ? other$code != null : !this$code.equals(other$code)) {
            return false;
        }
        Object this$method = this.getMethod();
        Object other$method = other.getMethod();
        if (this$method == null ? other$method != null : !this$method.equals(other$method)) {
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
        Object this$requestHeaders = this.getRequestHeaders();
        Object other$requestHeaders = other.getRequestHeaders();
        if (this$requestHeaders == null ? other$requestHeaders != null : !this$requestHeaders.equals(other$requestHeaders)) {
            return false;
        }
        Object this$responseHeaders = this.getResponseHeaders();
        Object other$responseHeaders = other.getResponseHeaders();
        if (this$responseHeaders == null ? other$responseHeaders != null : !this$responseHeaders.equals(other$responseHeaders)) {
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
        return other instanceof PodHttpChaosSelector;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $code = this.getCode();
        result = result * prime + ($code == null ? 43 : $code.hashCode());
        Object $method = this.getMethod();
        result = result * prime + ($method == null ? 43 : $method.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $requestHeaders = this.getRequestHeaders();
        result = result * prime + ($requestHeaders == null ? 43 : $requestHeaders.hashCode());
        Object $responseHeaders = this.getResponseHeaders();
        result = result * prime + ($responseHeaders == null ? 43 : $responseHeaders.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodHttpChaosSelector(" + "code=" + this.getCode() + ", method=" + this.getMethod() + ", path=" + this.getPath() + ", port=" + this.getPort() + ", requestHeaders=" + this.getRequestHeaders() + ", responseHeaders=" + this.getResponseHeaders() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
