
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

/**
 * HTTPRouteMatch defines the predicate used to match requests to a given action. Multiple match types are ANDed together, i.e. the match will evaluate to true only if all conditions are satisfied.<br><p> <br><p> For example, the match below will match a HTTP request only if its path starts with `/foo` AND it contains the `version: v1` header:<br><p> <br><p> ``` match:<br><p> <br><p> 	path:<br><p> 	  value: "/foo"<br><p> 	headers:<br><p> 	- name: "version"<br><p> 	  value "v1"<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "headers",
    "method",
    "path",
    "queryParams"
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
public class HTTPRouteMatch implements Editable<HTTPRouteMatchBuilder>, KubernetesResource
{

    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPHeaderMatch> headers = new ArrayList<>();
    @JsonProperty("method")
    private String method;
    @JsonProperty("path")
    private HTTPPathMatch path;
    @JsonProperty("queryParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPQueryParamMatch> queryParams = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRouteMatch() {
    }

    public HTTPRouteMatch(List<HTTPHeaderMatch> headers, String method, HTTPPathMatch path, List<HTTPQueryParamMatch> queryParams) {
        super();
        this.headers = headers;
        this.method = method;
        this.path = path;
        this.queryParams = queryParams;
    }

    /**
     * Headers specifies HTTP request header matchers. Multiple match values are ANDed together, meaning, a request must match all the specified headers to select the route.
     */
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPHeaderMatch> getHeaders() {
        return headers;
    }

    /**
     * Headers specifies HTTP request header matchers. Multiple match values are ANDed together, meaning, a request must match all the specified headers to select the route.
     */
    @JsonProperty("headers")
    public void setHeaders(List<HTTPHeaderMatch> headers) {
        this.headers = headers;
    }

    /**
     * Method specifies HTTP method matcher. When specified, this route will be matched only if the request has the specified method.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    /**
     * Method specifies HTTP method matcher. When specified, this route will be matched only if the request has the specified method.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * HTTPRouteMatch defines the predicate used to match requests to a given action. Multiple match types are ANDed together, i.e. the match will evaluate to true only if all conditions are satisfied.<br><p> <br><p> For example, the match below will match a HTTP request only if its path starts with `/foo` AND it contains the `version: v1` header:<br><p> <br><p> ``` match:<br><p> <br><p> 	path:<br><p> 	  value: "/foo"<br><p> 	headers:<br><p> 	- name: "version"<br><p> 	  value "v1"<br><p> <br><p> ```
     */
    @JsonProperty("path")
    public HTTPPathMatch getPath() {
        return path;
    }

    /**
     * HTTPRouteMatch defines the predicate used to match requests to a given action. Multiple match types are ANDed together, i.e. the match will evaluate to true only if all conditions are satisfied.<br><p> <br><p> For example, the match below will match a HTTP request only if its path starts with `/foo` AND it contains the `version: v1` header:<br><p> <br><p> ``` match:<br><p> <br><p> 	path:<br><p> 	  value: "/foo"<br><p> 	headers:<br><p> 	- name: "version"<br><p> 	  value "v1"<br><p> <br><p> ```
     */
    @JsonProperty("path")
    public void setPath(HTTPPathMatch path) {
        this.path = path;
    }

    /**
     * QueryParams specifies HTTP query parameter matchers. Multiple match values are ANDed together, meaning, a request must match all the specified query parameters to select the route.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("queryParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPQueryParamMatch> getQueryParams() {
        return queryParams;
    }

    /**
     * QueryParams specifies HTTP query parameter matchers. Multiple match values are ANDed together, meaning, a request must match all the specified query parameters to select the route.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("queryParams")
    public void setQueryParams(List<HTTPQueryParamMatch> queryParams) {
        this.queryParams = queryParams;
    }

    @JsonIgnore
    public HTTPRouteMatchBuilder edit() {
        return new HTTPRouteMatchBuilder(this);
    }

    @JsonIgnore
    public HTTPRouteMatchBuilder toBuilder() {
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
        if (!(o instanceof HTTPRouteMatch)) {
            return false;
        }
        HTTPRouteMatch other = (HTTPRouteMatch) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$headers = this.getHeaders();
        Object other$headers = other.getHeaders();
        if (this$headers == null ? other$headers != null : !this$headers.equals(other$headers)) {
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
        Object this$queryParams = this.getQueryParams();
        Object other$queryParams = other.getQueryParams();
        if (this$queryParams == null ? other$queryParams != null : !this$queryParams.equals(other$queryParams)) {
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
        return other instanceof HTTPRouteMatch;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $headers = this.getHeaders();
        result = result * prime + ($headers == null ? 43 : $headers.hashCode());
        Object $method = this.getMethod();
        result = result * prime + ($method == null ? 43 : $method.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $queryParams = this.getQueryParams();
        result = result * prime + ($queryParams == null ? 43 : $queryParams.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPRouteMatch(" + "headers=" + this.getHeaders() + ", method=" + this.getMethod() + ", path=" + this.getPath() + ", queryParams=" + this.getQueryParams() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
