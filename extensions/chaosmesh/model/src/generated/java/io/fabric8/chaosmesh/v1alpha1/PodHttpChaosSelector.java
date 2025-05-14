
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
