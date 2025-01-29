
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
