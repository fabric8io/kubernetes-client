
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * Describes the retry policy to use when a HTTP request fails. For example, the following rule sets the maximum number of retries to 3 when calling ratings:v1 service, with a 2s timeout per retry attempt. A retry will be attempted if there is a connect-failure, refused_stream or when the upstream server responds with Service Unavailable(503).<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  retries:<br><p> 	    attempts: 3<br><p> 	    perTryTimeout: 2s<br><p> 	    retryOn: gateway-error,connect-failure,refused-stream<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attempts",
    "perTryTimeout",
    "retryOn",
    "retryRemoteLocalities"
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
public class HTTPRetry implements Editable<HTTPRetryBuilder>, KubernetesResource
{

    @JsonProperty("attempts")
    private Integer attempts;
    @JsonProperty("perTryTimeout")
    private String perTryTimeout;
    @JsonProperty("retryOn")
    private String retryOn;
    @JsonProperty("retryRemoteLocalities")
    private Boolean retryRemoteLocalities;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRetry() {
    }

    public HTTPRetry(Integer attempts, String perTryTimeout, String retryOn, Boolean retryRemoteLocalities) {
        super();
        this.attempts = attempts;
        this.perTryTimeout = perTryTimeout;
        this.retryOn = retryOn;
        this.retryRemoteLocalities = retryRemoteLocalities;
    }

    /**
     * Number of retries to be allowed for a given request. The interval between retries will be determined automatically (25ms+). When request `timeout` of the [HTTP route](https://istio.io/docs/reference/config/networking/virtual-service/#HTTPRoute) or `per_try_timeout` is configured, the actual number of retries attempted also depends on the specified request `timeout` and `per_try_timeout` values. MUST be &gt;= 0. If `0`, retries will be disabled. The maximum possible number of requests made will be 1 + `attempts`.
     */
    @JsonProperty("attempts")
    public Integer getAttempts() {
        return attempts;
    }

    /**
     * Number of retries to be allowed for a given request. The interval between retries will be determined automatically (25ms+). When request `timeout` of the [HTTP route](https://istio.io/docs/reference/config/networking/virtual-service/#HTTPRoute) or `per_try_timeout` is configured, the actual number of retries attempted also depends on the specified request `timeout` and `per_try_timeout` values. MUST be &gt;= 0. If `0`, retries will be disabled. The maximum possible number of requests made will be 1 + `attempts`.
     */
    @JsonProperty("attempts")
    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    /**
     * Describes the retry policy to use when a HTTP request fails. For example, the following rule sets the maximum number of retries to 3 when calling ratings:v1 service, with a 2s timeout per retry attempt. A retry will be attempted if there is a connect-failure, refused_stream or when the upstream server responds with Service Unavailable(503).<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  retries:<br><p> 	    attempts: 3<br><p> 	    perTryTimeout: 2s<br><p> 	    retryOn: gateway-error,connect-failure,refused-stream<br><p> <br><p> ```
     */
    @JsonProperty("perTryTimeout")
    public String getPerTryTimeout() {
        return perTryTimeout;
    }

    /**
     * Describes the retry policy to use when a HTTP request fails. For example, the following rule sets the maximum number of retries to 3 when calling ratings:v1 service, with a 2s timeout per retry attempt. A retry will be attempted if there is a connect-failure, refused_stream or when the upstream server responds with Service Unavailable(503).<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  retries:<br><p> 	    attempts: 3<br><p> 	    perTryTimeout: 2s<br><p> 	    retryOn: gateway-error,connect-failure,refused-stream<br><p> <br><p> ```
     */
    @JsonProperty("perTryTimeout")
    public void setPerTryTimeout(String perTryTimeout) {
        this.perTryTimeout = perTryTimeout;
    }

    /**
     * Specifies the conditions under which retry takes place. One or more policies can be specified using a ‘,’ delimited list. See the [retry policies](https://www.envoyproxy.io/docs/envoy/latest/configuration/http/http_filters/router_filter#x-envoy-retry-on) and [gRPC retry policies](https://www.envoyproxy.io/docs/envoy/latest/configuration/http/http_filters/router_filter#x-envoy-retry-grpc-on) for more details.<br><p> <br><p> In addition to the policies specified above, a list of HTTP status codes can be passed, such as `retryOn: "503,reset"`. Note these status codes refer to the actual responses received from the destination. For example, if a connection is reset, Istio will translate this to 503 for it's response. However, the destination did not return a 503 error, so this would not match `"503"` (it would, however, match `"reset"`).<br><p> <br><p> If not specified, this defaults to `connect-failure,refused-stream,unavailable,cancelled`.
     */
    @JsonProperty("retryOn")
    public String getRetryOn() {
        return retryOn;
    }

    /**
     * Specifies the conditions under which retry takes place. One or more policies can be specified using a ‘,’ delimited list. See the [retry policies](https://www.envoyproxy.io/docs/envoy/latest/configuration/http/http_filters/router_filter#x-envoy-retry-on) and [gRPC retry policies](https://www.envoyproxy.io/docs/envoy/latest/configuration/http/http_filters/router_filter#x-envoy-retry-grpc-on) for more details.<br><p> <br><p> In addition to the policies specified above, a list of HTTP status codes can be passed, such as `retryOn: "503,reset"`. Note these status codes refer to the actual responses received from the destination. For example, if a connection is reset, Istio will translate this to 503 for it's response. However, the destination did not return a 503 error, so this would not match `"503"` (it would, however, match `"reset"`).<br><p> <br><p> If not specified, this defaults to `connect-failure,refused-stream,unavailable,cancelled`.
     */
    @JsonProperty("retryOn")
    public void setRetryOn(String retryOn) {
        this.retryOn = retryOn;
    }

    /**
     * Describes the retry policy to use when a HTTP request fails. For example, the following rule sets the maximum number of retries to 3 when calling ratings:v1 service, with a 2s timeout per retry attempt. A retry will be attempted if there is a connect-failure, refused_stream or when the upstream server responds with Service Unavailable(503).<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  retries:<br><p> 	    attempts: 3<br><p> 	    perTryTimeout: 2s<br><p> 	    retryOn: gateway-error,connect-failure,refused-stream<br><p> <br><p> ```
     */
    @JsonProperty("retryRemoteLocalities")
    public Boolean getRetryRemoteLocalities() {
        return retryRemoteLocalities;
    }

    /**
     * Describes the retry policy to use when a HTTP request fails. For example, the following rule sets the maximum number of retries to 3 when calling ratings:v1 service, with a 2s timeout per retry attempt. A retry will be attempted if there is a connect-failure, refused_stream or when the upstream server responds with Service Unavailable(503).<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> 	      subset: v1<br><p> 	  retries:<br><p> 	    attempts: 3<br><p> 	    perTryTimeout: 2s<br><p> 	    retryOn: gateway-error,connect-failure,refused-stream<br><p> <br><p> ```
     */
    @JsonProperty("retryRemoteLocalities")
    public void setRetryRemoteLocalities(Boolean retryRemoteLocalities) {
        this.retryRemoteLocalities = retryRemoteLocalities;
    }

    @JsonIgnore
    public HTTPRetryBuilder edit() {
        return new HTTPRetryBuilder(this);
    }

    @JsonIgnore
    public HTTPRetryBuilder toBuilder() {
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
