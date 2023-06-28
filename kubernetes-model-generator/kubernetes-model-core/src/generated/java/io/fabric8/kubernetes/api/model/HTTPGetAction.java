
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "host",
    "httpHeaders",
    "path",
    "port",
    "scheme"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class HTTPGetAction implements KubernetesResource
{

    @JsonProperty("host")
    private String host;
    @JsonProperty("httpHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPHeader> httpHeaders = new ArrayList<HTTPHeader>();
    @JsonProperty("path")
    private String path;
    @JsonProperty("port")
    private IntOrString port;
    @JsonProperty("scheme")
    private String scheme;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HTTPGetAction() {
    }

    public HTTPGetAction(String host, List<HTTPHeader> httpHeaders, String path, IntOrString port, String scheme) {
        super();
        this.host = host;
        this.httpHeaders = httpHeaders;
        this.path = path;
        this.port = port;
        this.scheme = scheme;
    }

    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty("httpHeaders")
    public List<HTTPHeader> getHttpHeaders() {
        return httpHeaders;
    }

    @JsonProperty("httpHeaders")
    public void setHttpHeaders(List<HTTPHeader> httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("port")
    public IntOrString getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(IntOrString port) {
        this.port = port;
    }

    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
