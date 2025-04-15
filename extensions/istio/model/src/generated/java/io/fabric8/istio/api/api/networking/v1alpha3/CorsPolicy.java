
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Describes the Cross-Origin Resource Sharing (CORS) policy, for a given service. Refer to [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS) for further details about cross origin resource sharing. For example, the following rule restricts cross origin requests to those originating from example.com domain using HTTP POST/GET, and sets the `Access-Control-Allow-Credentials` header to false. In addition, it only exposes `X-Foo-bar` header and sets an expiry period of 1 day.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  corsPolicy:<br><p> 	    allowOrigins:<br><p> 	    - exact: https://example.com<br><p> 	    allowMethods:<br><p> 	    - POST<br><p> 	    - GET<br><p> 	    allowCredentials: false<br><p> 	    allowHeaders:<br><p> 	    - X-Foo-Bar<br><p> 	    maxAge: "24h"<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowCredentials",
    "allowHeaders",
    "allowMethods",
    "allowOrigin",
    "allowOrigins",
    "exposeHeaders",
    "maxAge",
    "unmatchedPreflights"
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
public class CorsPolicy implements Editable<CorsPolicyBuilder>, KubernetesResource
{

    @JsonProperty("allowCredentials")
    private Boolean allowCredentials;
    @JsonProperty("allowHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowHeaders = new ArrayList<>();
    @JsonProperty("allowMethods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowMethods = new ArrayList<>();
    @JsonProperty("allowOrigin")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> deprecatedAllowOrigin = new ArrayList<>();
    @JsonProperty("allowOrigins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StringMatch> allowOrigins = new ArrayList<>();
    @JsonProperty("exposeHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> exposeHeaders = new ArrayList<>();
    @JsonProperty("maxAge")
    private String maxAge;
    @JsonProperty("unmatchedPreflights")
    private CorsPolicyUnmatchedPreflights unmatchedPreflights;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CorsPolicy() {
    }

    public CorsPolicy(Boolean allowCredentials, List<String> allowHeaders, List<String> allowMethods, List<String> deprecatedAllowOrigin, List<StringMatch> allowOrigins, List<String> exposeHeaders, String maxAge, CorsPolicyUnmatchedPreflights unmatchedPreflights) {
        super();
        this.allowCredentials = allowCredentials;
        this.allowHeaders = allowHeaders;
        this.allowMethods = allowMethods;
        this.deprecatedAllowOrigin = deprecatedAllowOrigin;
        this.allowOrigins = allowOrigins;
        this.exposeHeaders = exposeHeaders;
        this.maxAge = maxAge;
        this.unmatchedPreflights = unmatchedPreflights;
    }

    /**
     * Describes the Cross-Origin Resource Sharing (CORS) policy, for a given service. Refer to [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS) for further details about cross origin resource sharing. For example, the following rule restricts cross origin requests to those originating from example.com domain using HTTP POST/GET, and sets the `Access-Control-Allow-Credentials` header to false. In addition, it only exposes `X-Foo-bar` header and sets an expiry period of 1 day.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  corsPolicy:<br><p> 	    allowOrigins:<br><p> 	    - exact: https://example.com<br><p> 	    allowMethods:<br><p> 	    - POST<br><p> 	    - GET<br><p> 	    allowCredentials: false<br><p> 	    allowHeaders:<br><p> 	    - X-Foo-Bar<br><p> 	    maxAge: "24h"<br><p> <br><p> ```
     */
    @JsonProperty("allowCredentials")
    public Boolean getAllowCredentials() {
        return allowCredentials;
    }

    /**
     * Describes the Cross-Origin Resource Sharing (CORS) policy, for a given service. Refer to [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS) for further details about cross origin resource sharing. For example, the following rule restricts cross origin requests to those originating from example.com domain using HTTP POST/GET, and sets the `Access-Control-Allow-Credentials` header to false. In addition, it only exposes `X-Foo-bar` header and sets an expiry period of 1 day.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  corsPolicy:<br><p> 	    allowOrigins:<br><p> 	    - exact: https://example.com<br><p> 	    allowMethods:<br><p> 	    - POST<br><p> 	    - GET<br><p> 	    allowCredentials: false<br><p> 	    allowHeaders:<br><p> 	    - X-Foo-Bar<br><p> 	    maxAge: "24h"<br><p> <br><p> ```
     */
    @JsonProperty("allowCredentials")
    public void setAllowCredentials(Boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    /**
     * List of HTTP headers that can be used when requesting the resource. Serialized to Access-Control-Allow-Headers header.
     */
    @JsonProperty("allowHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowHeaders() {
        return allowHeaders;
    }

    /**
     * List of HTTP headers that can be used when requesting the resource. Serialized to Access-Control-Allow-Headers header.
     */
    @JsonProperty("allowHeaders")
    public void setAllowHeaders(List<String> allowHeaders) {
        this.allowHeaders = allowHeaders;
    }

    /**
     * List of HTTP methods allowed to access the resource. The content will be serialized into the Access-Control-Allow-Methods header.
     */
    @JsonProperty("allowMethods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowMethods() {
        return allowMethods;
    }

    /**
     * List of HTTP methods allowed to access the resource. The content will be serialized into the Access-Control-Allow-Methods header.
     */
    @JsonProperty("allowMethods")
    public void setAllowMethods(List<String> allowMethods) {
        this.allowMethods = allowMethods;
    }

    /**
     * The list of origins that are allowed to perform CORS requests. The content will be serialized into the Access-Control-Allow-Origin header. Wildcard &#42; will allow all origins. $hide_from_docs<br><p> <br><p> Deprecated: Marked as deprecated in networking/v1alpha3/virtual_service.proto.
     */
    @JsonProperty("allowOrigin")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowOrigin() {
        return deprecatedAllowOrigin;
    }

    /**
     * The list of origins that are allowed to perform CORS requests. The content will be serialized into the Access-Control-Allow-Origin header. Wildcard &#42; will allow all origins. $hide_from_docs<br><p> <br><p> Deprecated: Marked as deprecated in networking/v1alpha3/virtual_service.proto.
     */
    @JsonProperty("allowOrigin")
    public void setAllowOrigin(List<String> deprecatedAllowOrigin) {
        this.deprecatedAllowOrigin = deprecatedAllowOrigin;
    }

    /**
     * String patterns that match allowed origins. An origin is allowed if any of the string matchers match. If a match is found, then the outgoing Access-Control-Allow-Origin would be set to the origin as provided by the client.
     */
    @JsonProperty("allowOrigins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StringMatch> getAllowOrigins() {
        return allowOrigins;
    }

    /**
     * String patterns that match allowed origins. An origin is allowed if any of the string matchers match. If a match is found, then the outgoing Access-Control-Allow-Origin would be set to the origin as provided by the client.
     */
    @JsonProperty("allowOrigins")
    public void setAllowOrigins(List<StringMatch> allowOrigins) {
        this.allowOrigins = allowOrigins;
    }

    /**
     * A list of HTTP headers that the browsers are allowed to access. Serialized into Access-Control-Expose-Headers header.
     */
    @JsonProperty("exposeHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExposeHeaders() {
        return exposeHeaders;
    }

    /**
     * A list of HTTP headers that the browsers are allowed to access. Serialized into Access-Control-Expose-Headers header.
     */
    @JsonProperty("exposeHeaders")
    public void setExposeHeaders(List<String> exposeHeaders) {
        this.exposeHeaders = exposeHeaders;
    }

    /**
     * Describes the Cross-Origin Resource Sharing (CORS) policy, for a given service. Refer to [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS) for further details about cross origin resource sharing. For example, the following rule restricts cross origin requests to those originating from example.com domain using HTTP POST/GET, and sets the `Access-Control-Allow-Credentials` header to false. In addition, it only exposes `X-Foo-bar` header and sets an expiry period of 1 day.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  corsPolicy:<br><p> 	    allowOrigins:<br><p> 	    - exact: https://example.com<br><p> 	    allowMethods:<br><p> 	    - POST<br><p> 	    - GET<br><p> 	    allowCredentials: false<br><p> 	    allowHeaders:<br><p> 	    - X-Foo-Bar<br><p> 	    maxAge: "24h"<br><p> <br><p> ```
     */
    @JsonProperty("maxAge")
    public String getMaxAge() {
        return maxAge;
    }

    /**
     * Describes the Cross-Origin Resource Sharing (CORS) policy, for a given service. Refer to [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS) for further details about cross origin resource sharing. For example, the following rule restricts cross origin requests to those originating from example.com domain using HTTP POST/GET, and sets the `Access-Control-Allow-Credentials` header to false. In addition, it only exposes `X-Foo-bar` header and sets an expiry period of 1 day.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  corsPolicy:<br><p> 	    allowOrigins:<br><p> 	    - exact: https://example.com<br><p> 	    allowMethods:<br><p> 	    - POST<br><p> 	    - GET<br><p> 	    allowCredentials: false<br><p> 	    allowHeaders:<br><p> 	    - X-Foo-Bar<br><p> 	    maxAge: "24h"<br><p> <br><p> ```
     */
    @JsonProperty("maxAge")
    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }

    /**
     * Describes the Cross-Origin Resource Sharing (CORS) policy, for a given service. Refer to [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS) for further details about cross origin resource sharing. For example, the following rule restricts cross origin requests to those originating from example.com domain using HTTP POST/GET, and sets the `Access-Control-Allow-Credentials` header to false. In addition, it only exposes `X-Foo-bar` header and sets an expiry period of 1 day.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  corsPolicy:<br><p> 	    allowOrigins:<br><p> 	    - exact: https://example.com<br><p> 	    allowMethods:<br><p> 	    - POST<br><p> 	    - GET<br><p> 	    allowCredentials: false<br><p> 	    allowHeaders:<br><p> 	    - X-Foo-Bar<br><p> 	    maxAge: "24h"<br><p> <br><p> ```
     */
    @JsonProperty("unmatchedPreflights")
    public CorsPolicyUnmatchedPreflights getUnmatchedPreflights() {
        return unmatchedPreflights;
    }

    /**
     * Describes the Cross-Origin Resource Sharing (CORS) policy, for a given service. Refer to [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS) for further details about cross origin resource sharing. For example, the following rule restricts cross origin requests to those originating from example.com domain using HTTP POST/GET, and sets the `Access-Control-Allow-Credentials` header to false. In addition, it only exposes `X-Foo-bar` header and sets an expiry period of 1 day.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  corsPolicy:<br><p> 	    allowOrigins:<br><p> 	    - exact: https://example.com<br><p> 	    allowMethods:<br><p> 	    - POST<br><p> 	    - GET<br><p> 	    allowCredentials: false<br><p> 	    allowHeaders:<br><p> 	    - X-Foo-Bar<br><p> 	    maxAge: "24h"<br><p> <br><p> ```
     */
    @JsonProperty("unmatchedPreflights")
    public void setUnmatchedPreflights(CorsPolicyUnmatchedPreflights unmatchedPreflights) {
        this.unmatchedPreflights = unmatchedPreflights;
    }

    @JsonIgnore
    public CorsPolicyBuilder edit() {
        return new CorsPolicyBuilder(this);
    }

    @JsonIgnore
    public CorsPolicyBuilder toBuilder() {
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
