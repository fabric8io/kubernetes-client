
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
 * HTTPCORSFilter defines a filter that that configures Cross-Origin Request Sharing (CORS).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowCredentials",
    "allowHeaders",
    "allowMethods",
    "allowOrigins",
    "exposeHeaders",
    "maxAge"
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
public class HTTPCORSFilter implements Editable<HTTPCORSFilterBuilder>, KubernetesResource
{

    @JsonProperty("allowCredentials")
    private Boolean allowCredentials;
    @JsonProperty("allowHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowHeaders = new ArrayList<>();
    @JsonProperty("allowMethods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowMethods = new ArrayList<>();
    @JsonProperty("allowOrigins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowOrigins = new ArrayList<>();
    @JsonProperty("exposeHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> exposeHeaders = new ArrayList<>();
    @JsonProperty("maxAge")
    private Integer maxAge;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPCORSFilter() {
    }

    public HTTPCORSFilter(Boolean allowCredentials, List<String> allowHeaders, List<String> allowMethods, List<String> allowOrigins, List<String> exposeHeaders, Integer maxAge) {
        super();
        this.allowCredentials = allowCredentials;
        this.allowHeaders = allowHeaders;
        this.allowMethods = allowMethods;
        this.allowOrigins = allowOrigins;
        this.exposeHeaders = exposeHeaders;
        this.maxAge = maxAge;
    }

    /**
     * AllowCredentials indicates whether the actual cross-origin request allows to include credentials.<br><p> <br><p> When set to true, the gateway will include the `Access-Control-Allow-Credentials` response header with value true (case-sensitive).<br><p> <br><p> When set to false or omitted the gateway will omit the header `Access-Control-Allow-Credentials` entirely (this is the standard CORS behavior).<br><p> <br><p> Support: Extended
     */
    @JsonProperty("allowCredentials")
    public Boolean getAllowCredentials() {
        return allowCredentials;
    }

    /**
     * AllowCredentials indicates whether the actual cross-origin request allows to include credentials.<br><p> <br><p> When set to true, the gateway will include the `Access-Control-Allow-Credentials` response header with value true (case-sensitive).<br><p> <br><p> When set to false or omitted the gateway will omit the header `Access-Control-Allow-Credentials` entirely (this is the standard CORS behavior).<br><p> <br><p> Support: Extended
     */
    @JsonProperty("allowCredentials")
    public void setAllowCredentials(Boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    /**
     * AllowHeaders indicates which HTTP request headers are supported for accessing the requested resource.<br><p> <br><p> Header names are not case sensitive.<br><p> <br><p> Multiple header names in the value of the `Access-Control-Allow-Headers` response header are separated by a comma (",").<br><p> <br><p> When the `AllowHeaders` field is configured with one or more headers, the gateway must return the `Access-Control-Allow-Headers` response header which value is present in the `AllowHeaders` field.<br><p> <br><p> If any header name in the `Access-Control-Request-Headers` request header is not included in the list of header names specified by the response header `Access-Control-Allow-Headers`, it will present an error on the client side.<br><p> <br><p> If any header name in the `Access-Control-Allow-Headers` response header does not recognize by the client, it will also occur an error on the client side.<br><p> <br><p> A wildcard indicates that the requests with all HTTP headers are allowed. The `Access-Control-Allow-Headers` response header can only use `&#42;` wildcard as value when the `AllowCredentials` field is false or omitted.<br><p> <br><p> When the `AllowCredentials` field is true and `AllowHeaders` field specified with the `&#42;` wildcard, the gateway must specify one or more HTTP headers in the value of the `Access-Control-Allow-Headers` response header. The value of the header `Access-Control-Allow-Headers` is same as the `Access-Control-Request-Headers` header provided by the client. If the header `Access-Control-Request-Headers` is not included in the request, the gateway will omit the `Access-Control-Allow-Headers` response header, instead of specifying the `&#42;` wildcard. A Gateway implementation may choose to add implementation-specific default headers.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("allowHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowHeaders() {
        return allowHeaders;
    }

    /**
     * AllowHeaders indicates which HTTP request headers are supported for accessing the requested resource.<br><p> <br><p> Header names are not case sensitive.<br><p> <br><p> Multiple header names in the value of the `Access-Control-Allow-Headers` response header are separated by a comma (",").<br><p> <br><p> When the `AllowHeaders` field is configured with one or more headers, the gateway must return the `Access-Control-Allow-Headers` response header which value is present in the `AllowHeaders` field.<br><p> <br><p> If any header name in the `Access-Control-Request-Headers` request header is not included in the list of header names specified by the response header `Access-Control-Allow-Headers`, it will present an error on the client side.<br><p> <br><p> If any header name in the `Access-Control-Allow-Headers` response header does not recognize by the client, it will also occur an error on the client side.<br><p> <br><p> A wildcard indicates that the requests with all HTTP headers are allowed. The `Access-Control-Allow-Headers` response header can only use `&#42;` wildcard as value when the `AllowCredentials` field is false or omitted.<br><p> <br><p> When the `AllowCredentials` field is true and `AllowHeaders` field specified with the `&#42;` wildcard, the gateway must specify one or more HTTP headers in the value of the `Access-Control-Allow-Headers` response header. The value of the header `Access-Control-Allow-Headers` is same as the `Access-Control-Request-Headers` header provided by the client. If the header `Access-Control-Request-Headers` is not included in the request, the gateway will omit the `Access-Control-Allow-Headers` response header, instead of specifying the `&#42;` wildcard. A Gateway implementation may choose to add implementation-specific default headers.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("allowHeaders")
    public void setAllowHeaders(List<String> allowHeaders) {
        this.allowHeaders = allowHeaders;
    }

    /**
     * AllowMethods indicates which HTTP methods are supported for accessing the requested resource.<br><p> <br><p> Valid values are any method defined by RFC9110, along with the special value `&#42;`, which represents all HTTP methods are allowed.<br><p> <br><p> Method names are case sensitive, so these values are also case-sensitive. (See https://www.rfc-editor.org/rfc/rfc2616#section-5.1.1)<br><p> <br><p> Multiple method names in the value of the `Access-Control-Allow-Methods` response header are separated by a comma (",").<br><p> <br><p> A CORS-safelisted method is a method that is `GET`, `HEAD`, or `POST`. (See https://fetch.spec.whatwg.org/#cors-safelisted-method) The CORS-safelisted methods are always allowed, regardless of whether they are specified in the `AllowMethods` field.<br><p> <br><p> When the `AllowMethods` field is configured with one or more methods, the gateway must return the `Access-Control-Allow-Methods` response header which value is present in the `AllowMethods` field.<br><p> <br><p> If the HTTP method of the `Access-Control-Request-Method` request header is not included in the list of methods specified by the response header `Access-Control-Allow-Methods`, it will present an error on the client side.<br><p> <br><p> The `Access-Control-Allow-Methods` response header can only use `&#42;` wildcard as value when the `AllowCredentials` field is false or omitted.<br><p> <br><p> When the `AllowCredentials` field is true and `AllowMethods` field specified with the `&#42;` wildcard, the gateway must specify one HTTP method in the value of the Access-Control-Allow-Methods response header. The value of the header `Access-Control-Allow-Methods` is same as the `Access-Control-Request-Method` header provided by the client. If the header `Access-Control-Request-Method` is not included in the request, the gateway will omit the `Access-Control-Allow-Methods` response header, instead of specifying the `&#42;` wildcard. A Gateway implementation may choose to add implementation-specific default methods.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("allowMethods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowMethods() {
        return allowMethods;
    }

    /**
     * AllowMethods indicates which HTTP methods are supported for accessing the requested resource.<br><p> <br><p> Valid values are any method defined by RFC9110, along with the special value `&#42;`, which represents all HTTP methods are allowed.<br><p> <br><p> Method names are case sensitive, so these values are also case-sensitive. (See https://www.rfc-editor.org/rfc/rfc2616#section-5.1.1)<br><p> <br><p> Multiple method names in the value of the `Access-Control-Allow-Methods` response header are separated by a comma (",").<br><p> <br><p> A CORS-safelisted method is a method that is `GET`, `HEAD`, or `POST`. (See https://fetch.spec.whatwg.org/#cors-safelisted-method) The CORS-safelisted methods are always allowed, regardless of whether they are specified in the `AllowMethods` field.<br><p> <br><p> When the `AllowMethods` field is configured with one or more methods, the gateway must return the `Access-Control-Allow-Methods` response header which value is present in the `AllowMethods` field.<br><p> <br><p> If the HTTP method of the `Access-Control-Request-Method` request header is not included in the list of methods specified by the response header `Access-Control-Allow-Methods`, it will present an error on the client side.<br><p> <br><p> The `Access-Control-Allow-Methods` response header can only use `&#42;` wildcard as value when the `AllowCredentials` field is false or omitted.<br><p> <br><p> When the `AllowCredentials` field is true and `AllowMethods` field specified with the `&#42;` wildcard, the gateway must specify one HTTP method in the value of the Access-Control-Allow-Methods response header. The value of the header `Access-Control-Allow-Methods` is same as the `Access-Control-Request-Method` header provided by the client. If the header `Access-Control-Request-Method` is not included in the request, the gateway will omit the `Access-Control-Allow-Methods` response header, instead of specifying the `&#42;` wildcard. A Gateway implementation may choose to add implementation-specific default methods.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("allowMethods")
    public void setAllowMethods(List<String> allowMethods) {
        this.allowMethods = allowMethods;
    }

    /**
     * AllowOrigins indicates whether the response can be shared with requested resource from the given `Origin`.<br><p> <br><p> The `Origin` consists of a scheme and a host, with an optional port, and takes the form `&lt;scheme&gt;://&lt;host&gt;(:&lt;port&gt;)`.<br><p> <br><p> Valid values for scheme are: `http` and `https`.<br><p> <br><p> Valid values for port are any integer between 1 and 65535 (the list of available TCP/UDP ports). Note that, if not included, port `80` is assumed for `http` scheme origins, and port `443` is assumed for `https` origins. This may affect origin matching.<br><p> <br><p> The host part of the origin may contain the wildcard character `&#42;`. These wildcard characters behave as follows:<br><p> <br><p> &#42; `&#42;` is a greedy match to the _left_, including any number of<br><p>   DNS labels to the left of its position. This also means that<br><p>   `&#42;` will include any number of period `.` characters to the<br><p>   left of its position.<br><p> &#42; A wildcard by itself matches all hosts.<br><p> <br><p> An origin value that includes _only_ the `&#42;` character indicates requests from all `Origin`s are allowed.<br><p> <br><p> When the `AllowOrigins` field is configured with multiple origins, it means the server supports clients from multiple origins. If the request `Origin` matches the configured allowed origins, the gateway must return the given `Origin` and sets value of the header `Access-Control-Allow-Origin` same as the `Origin` header provided by the client.<br><p> <br><p> The status code of a successful response to a "preflight" request is always an OK status (i.e., 204 or 200).<br><p> <br><p> If the request `Origin` does not match the configured allowed origins, the gateway returns 204/200 response but doesn't set the relevant cross-origin response headers. Alternatively, the gateway responds with 403 status to the "preflight" request is denied, coupled with omitting the CORS headers. The cross-origin request fails on the client side. Therefore, the client doesn't attempt the actual cross-origin request.<br><p> <br><p> The `Access-Control-Allow-Origin` response header can only use `&#42;` wildcard as value when the `AllowCredentials` field is false or omitted.<br><p> <br><p> When the `AllowCredentials` field is true and `AllowOrigins` field specified with the `&#42;` wildcard, the gateway must return a single origin in the value of the `Access-Control-Allow-Origin` response header, instead of specifying the `&#42;` wildcard. The value of the header `Access-Control-Allow-Origin` is same as the `Origin` header provided by the client.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("allowOrigins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowOrigins() {
        return allowOrigins;
    }

    /**
     * AllowOrigins indicates whether the response can be shared with requested resource from the given `Origin`.<br><p> <br><p> The `Origin` consists of a scheme and a host, with an optional port, and takes the form `&lt;scheme&gt;://&lt;host&gt;(:&lt;port&gt;)`.<br><p> <br><p> Valid values for scheme are: `http` and `https`.<br><p> <br><p> Valid values for port are any integer between 1 and 65535 (the list of available TCP/UDP ports). Note that, if not included, port `80` is assumed for `http` scheme origins, and port `443` is assumed for `https` origins. This may affect origin matching.<br><p> <br><p> The host part of the origin may contain the wildcard character `&#42;`. These wildcard characters behave as follows:<br><p> <br><p> &#42; `&#42;` is a greedy match to the _left_, including any number of<br><p>   DNS labels to the left of its position. This also means that<br><p>   `&#42;` will include any number of period `.` characters to the<br><p>   left of its position.<br><p> &#42; A wildcard by itself matches all hosts.<br><p> <br><p> An origin value that includes _only_ the `&#42;` character indicates requests from all `Origin`s are allowed.<br><p> <br><p> When the `AllowOrigins` field is configured with multiple origins, it means the server supports clients from multiple origins. If the request `Origin` matches the configured allowed origins, the gateway must return the given `Origin` and sets value of the header `Access-Control-Allow-Origin` same as the `Origin` header provided by the client.<br><p> <br><p> The status code of a successful response to a "preflight" request is always an OK status (i.e., 204 or 200).<br><p> <br><p> If the request `Origin` does not match the configured allowed origins, the gateway returns 204/200 response but doesn't set the relevant cross-origin response headers. Alternatively, the gateway responds with 403 status to the "preflight" request is denied, coupled with omitting the CORS headers. The cross-origin request fails on the client side. Therefore, the client doesn't attempt the actual cross-origin request.<br><p> <br><p> The `Access-Control-Allow-Origin` response header can only use `&#42;` wildcard as value when the `AllowCredentials` field is false or omitted.<br><p> <br><p> When the `AllowCredentials` field is true and `AllowOrigins` field specified with the `&#42;` wildcard, the gateway must return a single origin in the value of the `Access-Control-Allow-Origin` response header, instead of specifying the `&#42;` wildcard. The value of the header `Access-Control-Allow-Origin` is same as the `Origin` header provided by the client.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("allowOrigins")
    public void setAllowOrigins(List<String> allowOrigins) {
        this.allowOrigins = allowOrigins;
    }

    /**
     * ExposeHeaders indicates which HTTP response headers can be exposed to client-side scripts in response to a cross-origin request.<br><p> <br><p> A CORS-safelisted response header is an HTTP header in a CORS response that it is considered safe to expose to the client scripts. The CORS-safelisted response headers include the following headers: `Cache-Control` `Content-Language` `Content-Length` `Content-Type` `Expires` `Last-Modified` `Pragma` (See https://fetch.spec.whatwg.org/#cors-safelisted-response-header-name) The CORS-safelisted response headers are exposed to client by default.<br><p> <br><p> When an HTTP header name is specified using the `ExposeHeaders` field, this additional header will be exposed as part of the response to the client.<br><p> <br><p> Header names are not case sensitive.<br><p> <br><p> Multiple header names in the value of the `Access-Control-Expose-Headers` response header are separated by a comma (",").<br><p> <br><p> A wildcard indicates that the responses with all HTTP headers are exposed to clients. The `Access-Control-Expose-Headers` response header can only use `&#42;` wildcard as value when the `AllowCredentials` field is false or omitted.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("exposeHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExposeHeaders() {
        return exposeHeaders;
    }

    /**
     * ExposeHeaders indicates which HTTP response headers can be exposed to client-side scripts in response to a cross-origin request.<br><p> <br><p> A CORS-safelisted response header is an HTTP header in a CORS response that it is considered safe to expose to the client scripts. The CORS-safelisted response headers include the following headers: `Cache-Control` `Content-Language` `Content-Length` `Content-Type` `Expires` `Last-Modified` `Pragma` (See https://fetch.spec.whatwg.org/#cors-safelisted-response-header-name) The CORS-safelisted response headers are exposed to client by default.<br><p> <br><p> When an HTTP header name is specified using the `ExposeHeaders` field, this additional header will be exposed as part of the response to the client.<br><p> <br><p> Header names are not case sensitive.<br><p> <br><p> Multiple header names in the value of the `Access-Control-Expose-Headers` response header are separated by a comma (",").<br><p> <br><p> A wildcard indicates that the responses with all HTTP headers are exposed to clients. The `Access-Control-Expose-Headers` response header can only use `&#42;` wildcard as value when the `AllowCredentials` field is false or omitted.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("exposeHeaders")
    public void setExposeHeaders(List<String> exposeHeaders) {
        this.exposeHeaders = exposeHeaders;
    }

    /**
     * MaxAge indicates the duration (in seconds) for the client to cache the results of a "preflight" request.<br><p> <br><p> The information provided by the `Access-Control-Allow-Methods` and `Access-Control-Allow-Headers` response headers can be cached by the client until the time specified by `Access-Control-Max-Age` elapses.<br><p> <br><p> The default value of `Access-Control-Max-Age` response header is 5 (seconds).
     */
    @JsonProperty("maxAge")
    public Integer getMaxAge() {
        return maxAge;
    }

    /**
     * MaxAge indicates the duration (in seconds) for the client to cache the results of a "preflight" request.<br><p> <br><p> The information provided by the `Access-Control-Allow-Methods` and `Access-Control-Allow-Headers` response headers can be cached by the client until the time specified by `Access-Control-Max-Age` elapses.<br><p> <br><p> The default value of `Access-Control-Max-Age` response header is 5 (seconds).
     */
    @JsonProperty("maxAge")
    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    @JsonIgnore
    public HTTPCORSFilterBuilder edit() {
        return new HTTPCORSFilterBuilder(this);
    }

    @JsonIgnore
    public HTTPCORSFilterBuilder toBuilder() {
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
