
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.LinkedHashMap;
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
 * A Circuit breaker implementation that tracks the status of each individual host in the upstream service.  Applicable to both HTTP and TCP services.  For HTTP services, hosts that continually return 5xx errors for API calls are ejected from the pool for a pre-defined period of time. For TCP services, connection timeouts or connection failures to a given host counts as an error when measuring the consecutive errors metric. See Envoy's [outlier detection](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/outlier) for more details.<br><p> <br><p> The following rule sets a connection pool size of 100 HTTP1 connections with no more than 10 req/connection to the "reviews" service. In addition, it sets a limit of 1000 concurrent HTTP2 requests and configures upstream hosts to be scanned every 5 mins so that any host that fails 7 consecutive times with a 502, 503, or 504 error code will be ejected for 15 minutes.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-cb-policy<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	    http:<br><p> 	      http2MaxRequests: 1000<br><p> 	      maxRequestsPerConnection: 10<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 7<br><p> 	    interval: 5m<br><p> 	    baseEjectionTime: 15m<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "baseEjectionTime",
    "consecutive5xxErrors",
    "consecutiveErrors",
    "consecutiveGatewayErrors",
    "consecutiveLocalOriginFailures",
    "interval",
    "maxEjectionPercent",
    "minHealthPercent",
    "splitExternalLocalOriginErrors"
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
public class OutlierDetection implements Editable<OutlierDetectionBuilder>, KubernetesResource
{

    @JsonProperty("baseEjectionTime")
    private String baseEjectionTime;
    @JsonProperty("consecutive5xxErrors")
    private Integer consecutive5xxErrors;
    @JsonProperty("consecutiveErrors")
    private Integer consecutiveErrors;
    @JsonProperty("consecutiveGatewayErrors")
    private Integer consecutiveGatewayErrors;
    @JsonProperty("consecutiveLocalOriginFailures")
    private Integer consecutiveLocalOriginFailures;
    @JsonProperty("interval")
    private String interval;
    @JsonProperty("maxEjectionPercent")
    private Integer maxEjectionPercent;
    @JsonProperty("minHealthPercent")
    private Integer minHealthPercent;
    @JsonProperty("splitExternalLocalOriginErrors")
    private Boolean splitExternalLocalOriginErrors;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OutlierDetection() {
    }

    public OutlierDetection(String baseEjectionTime, Integer consecutive5xxErrors, Integer consecutiveErrors, Integer consecutiveGatewayErrors, Integer consecutiveLocalOriginFailures, String interval, Integer maxEjectionPercent, Integer minHealthPercent, Boolean splitExternalLocalOriginErrors) {
        super();
        this.baseEjectionTime = baseEjectionTime;
        this.consecutive5xxErrors = consecutive5xxErrors;
        this.consecutiveErrors = consecutiveErrors;
        this.consecutiveGatewayErrors = consecutiveGatewayErrors;
        this.consecutiveLocalOriginFailures = consecutiveLocalOriginFailures;
        this.interval = interval;
        this.maxEjectionPercent = maxEjectionPercent;
        this.minHealthPercent = minHealthPercent;
        this.splitExternalLocalOriginErrors = splitExternalLocalOriginErrors;
    }

    /**
     * A Circuit breaker implementation that tracks the status of each individual host in the upstream service.  Applicable to both HTTP and TCP services.  For HTTP services, hosts that continually return 5xx errors for API calls are ejected from the pool for a pre-defined period of time. For TCP services, connection timeouts or connection failures to a given host counts as an error when measuring the consecutive errors metric. See Envoy's [outlier detection](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/outlier) for more details.<br><p> <br><p> The following rule sets a connection pool size of 100 HTTP1 connections with no more than 10 req/connection to the "reviews" service. In addition, it sets a limit of 1000 concurrent HTTP2 requests and configures upstream hosts to be scanned every 5 mins so that any host that fails 7 consecutive times with a 502, 503, or 504 error code will be ejected for 15 minutes.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-cb-policy<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	    http:<br><p> 	      http2MaxRequests: 1000<br><p> 	      maxRequestsPerConnection: 10<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 7<br><p> 	    interval: 5m<br><p> 	    baseEjectionTime: 15m<br><p> <br><p> ```
     */
    @JsonProperty("baseEjectionTime")
    public String getBaseEjectionTime() {
        return baseEjectionTime;
    }

    /**
     * A Circuit breaker implementation that tracks the status of each individual host in the upstream service.  Applicable to both HTTP and TCP services.  For HTTP services, hosts that continually return 5xx errors for API calls are ejected from the pool for a pre-defined period of time. For TCP services, connection timeouts or connection failures to a given host counts as an error when measuring the consecutive errors metric. See Envoy's [outlier detection](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/outlier) for more details.<br><p> <br><p> The following rule sets a connection pool size of 100 HTTP1 connections with no more than 10 req/connection to the "reviews" service. In addition, it sets a limit of 1000 concurrent HTTP2 requests and configures upstream hosts to be scanned every 5 mins so that any host that fails 7 consecutive times with a 502, 503, or 504 error code will be ejected for 15 minutes.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-cb-policy<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	    http:<br><p> 	      http2MaxRequests: 1000<br><p> 	      maxRequestsPerConnection: 10<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 7<br><p> 	    interval: 5m<br><p> 	    baseEjectionTime: 15m<br><p> <br><p> ```
     */
    @JsonProperty("baseEjectionTime")
    public void setBaseEjectionTime(String baseEjectionTime) {
        this.baseEjectionTime = baseEjectionTime;
    }

    /**
     * A Circuit breaker implementation that tracks the status of each individual host in the upstream service.  Applicable to both HTTP and TCP services.  For HTTP services, hosts that continually return 5xx errors for API calls are ejected from the pool for a pre-defined period of time. For TCP services, connection timeouts or connection failures to a given host counts as an error when measuring the consecutive errors metric. See Envoy's [outlier detection](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/outlier) for more details.<br><p> <br><p> The following rule sets a connection pool size of 100 HTTP1 connections with no more than 10 req/connection to the "reviews" service. In addition, it sets a limit of 1000 concurrent HTTP2 requests and configures upstream hosts to be scanned every 5 mins so that any host that fails 7 consecutive times with a 502, 503, or 504 error code will be ejected for 15 minutes.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-cb-policy<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	    http:<br><p> 	      http2MaxRequests: 1000<br><p> 	      maxRequestsPerConnection: 10<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 7<br><p> 	    interval: 5m<br><p> 	    baseEjectionTime: 15m<br><p> <br><p> ```
     */
    @JsonProperty("consecutive5xxErrors")
    public Integer getConsecutive5xxErrors() {
        return consecutive5xxErrors;
    }

    /**
     * A Circuit breaker implementation that tracks the status of each individual host in the upstream service.  Applicable to both HTTP and TCP services.  For HTTP services, hosts that continually return 5xx errors for API calls are ejected from the pool for a pre-defined period of time. For TCP services, connection timeouts or connection failures to a given host counts as an error when measuring the consecutive errors metric. See Envoy's [outlier detection](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/outlier) for more details.<br><p> <br><p> The following rule sets a connection pool size of 100 HTTP1 connections with no more than 10 req/connection to the "reviews" service. In addition, it sets a limit of 1000 concurrent HTTP2 requests and configures upstream hosts to be scanned every 5 mins so that any host that fails 7 consecutive times with a 502, 503, or 504 error code will be ejected for 15 minutes.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-cb-policy<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	    http:<br><p> 	      http2MaxRequests: 1000<br><p> 	      maxRequestsPerConnection: 10<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 7<br><p> 	    interval: 5m<br><p> 	    baseEjectionTime: 15m<br><p> <br><p> ```
     */
    @JsonProperty("consecutive5xxErrors")
    public void setConsecutive5xxErrors(Integer consecutive5xxErrors) {
        this.consecutive5xxErrors = consecutive5xxErrors;
    }

    /**
     * Number of errors before a host is ejected from the connection pool. Defaults to 5. When the upstream host is accessed over HTTP, a 502, 503, or 504 return code qualifies as an error. When the upstream host is accessed over an opaque TCP connection, connect timeouts and connection error/failure events qualify as an error. $hide_from_docs<br><p> <br><p> Deprecated: Marked as deprecated in networking/v1alpha3/destination_rule.proto.
     */
    @JsonProperty("consecutiveErrors")
    public Integer getConsecutiveErrors() {
        return consecutiveErrors;
    }

    /**
     * Number of errors before a host is ejected from the connection pool. Defaults to 5. When the upstream host is accessed over HTTP, a 502, 503, or 504 return code qualifies as an error. When the upstream host is accessed over an opaque TCP connection, connect timeouts and connection error/failure events qualify as an error. $hide_from_docs<br><p> <br><p> Deprecated: Marked as deprecated in networking/v1alpha3/destination_rule.proto.
     */
    @JsonProperty("consecutiveErrors")
    public void setConsecutiveErrors(Integer consecutiveErrors) {
        this.consecutiveErrors = consecutiveErrors;
    }

    /**
     * A Circuit breaker implementation that tracks the status of each individual host in the upstream service.  Applicable to both HTTP and TCP services.  For HTTP services, hosts that continually return 5xx errors for API calls are ejected from the pool for a pre-defined period of time. For TCP services, connection timeouts or connection failures to a given host counts as an error when measuring the consecutive errors metric. See Envoy's [outlier detection](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/outlier) for more details.<br><p> <br><p> The following rule sets a connection pool size of 100 HTTP1 connections with no more than 10 req/connection to the "reviews" service. In addition, it sets a limit of 1000 concurrent HTTP2 requests and configures upstream hosts to be scanned every 5 mins so that any host that fails 7 consecutive times with a 502, 503, or 504 error code will be ejected for 15 minutes.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-cb-policy<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	    http:<br><p> 	      http2MaxRequests: 1000<br><p> 	      maxRequestsPerConnection: 10<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 7<br><p> 	    interval: 5m<br><p> 	    baseEjectionTime: 15m<br><p> <br><p> ```
     */
    @JsonProperty("consecutiveGatewayErrors")
    public Integer getConsecutiveGatewayErrors() {
        return consecutiveGatewayErrors;
    }

    /**
     * A Circuit breaker implementation that tracks the status of each individual host in the upstream service.  Applicable to both HTTP and TCP services.  For HTTP services, hosts that continually return 5xx errors for API calls are ejected from the pool for a pre-defined period of time. For TCP services, connection timeouts or connection failures to a given host counts as an error when measuring the consecutive errors metric. See Envoy's [outlier detection](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/outlier) for more details.<br><p> <br><p> The following rule sets a connection pool size of 100 HTTP1 connections with no more than 10 req/connection to the "reviews" service. In addition, it sets a limit of 1000 concurrent HTTP2 requests and configures upstream hosts to be scanned every 5 mins so that any host that fails 7 consecutive times with a 502, 503, or 504 error code will be ejected for 15 minutes.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-cb-policy<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	    http:<br><p> 	      http2MaxRequests: 1000<br><p> 	      maxRequestsPerConnection: 10<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 7<br><p> 	    interval: 5m<br><p> 	    baseEjectionTime: 15m<br><p> <br><p> ```
     */
    @JsonProperty("consecutiveGatewayErrors")
    public void setConsecutiveGatewayErrors(Integer consecutiveGatewayErrors) {
        this.consecutiveGatewayErrors = consecutiveGatewayErrors;
    }

    /**
     * A Circuit breaker implementation that tracks the status of each individual host in the upstream service.  Applicable to both HTTP and TCP services.  For HTTP services, hosts that continually return 5xx errors for API calls are ejected from the pool for a pre-defined period of time. For TCP services, connection timeouts or connection failures to a given host counts as an error when measuring the consecutive errors metric. See Envoy's [outlier detection](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/outlier) for more details.<br><p> <br><p> The following rule sets a connection pool size of 100 HTTP1 connections with no more than 10 req/connection to the "reviews" service. In addition, it sets a limit of 1000 concurrent HTTP2 requests and configures upstream hosts to be scanned every 5 mins so that any host that fails 7 consecutive times with a 502, 503, or 504 error code will be ejected for 15 minutes.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-cb-policy<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	    http:<br><p> 	      http2MaxRequests: 1000<br><p> 	      maxRequestsPerConnection: 10<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 7<br><p> 	    interval: 5m<br><p> 	    baseEjectionTime: 15m<br><p> <br><p> ```
     */
    @JsonProperty("consecutiveLocalOriginFailures")
    public Integer getConsecutiveLocalOriginFailures() {
        return consecutiveLocalOriginFailures;
    }

    /**
     * A Circuit breaker implementation that tracks the status of each individual host in the upstream service.  Applicable to both HTTP and TCP services.  For HTTP services, hosts that continually return 5xx errors for API calls are ejected from the pool for a pre-defined period of time. For TCP services, connection timeouts or connection failures to a given host counts as an error when measuring the consecutive errors metric. See Envoy's [outlier detection](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/outlier) for more details.<br><p> <br><p> The following rule sets a connection pool size of 100 HTTP1 connections with no more than 10 req/connection to the "reviews" service. In addition, it sets a limit of 1000 concurrent HTTP2 requests and configures upstream hosts to be scanned every 5 mins so that any host that fails 7 consecutive times with a 502, 503, or 504 error code will be ejected for 15 minutes.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-cb-policy<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	    http:<br><p> 	      http2MaxRequests: 1000<br><p> 	      maxRequestsPerConnection: 10<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 7<br><p> 	    interval: 5m<br><p> 	    baseEjectionTime: 15m<br><p> <br><p> ```
     */
    @JsonProperty("consecutiveLocalOriginFailures")
    public void setConsecutiveLocalOriginFailures(Integer consecutiveLocalOriginFailures) {
        this.consecutiveLocalOriginFailures = consecutiveLocalOriginFailures;
    }

    /**
     * A Circuit breaker implementation that tracks the status of each individual host in the upstream service.  Applicable to both HTTP and TCP services.  For HTTP services, hosts that continually return 5xx errors for API calls are ejected from the pool for a pre-defined period of time. For TCP services, connection timeouts or connection failures to a given host counts as an error when measuring the consecutive errors metric. See Envoy's [outlier detection](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/outlier) for more details.<br><p> <br><p> The following rule sets a connection pool size of 100 HTTP1 connections with no more than 10 req/connection to the "reviews" service. In addition, it sets a limit of 1000 concurrent HTTP2 requests and configures upstream hosts to be scanned every 5 mins so that any host that fails 7 consecutive times with a 502, 503, or 504 error code will be ejected for 15 minutes.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-cb-policy<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	    http:<br><p> 	      http2MaxRequests: 1000<br><p> 	      maxRequestsPerConnection: 10<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 7<br><p> 	    interval: 5m<br><p> 	    baseEjectionTime: 15m<br><p> <br><p> ```
     */
    @JsonProperty("interval")
    public String getInterval() {
        return interval;
    }

    /**
     * A Circuit breaker implementation that tracks the status of each individual host in the upstream service.  Applicable to both HTTP and TCP services.  For HTTP services, hosts that continually return 5xx errors for API calls are ejected from the pool for a pre-defined period of time. For TCP services, connection timeouts or connection failures to a given host counts as an error when measuring the consecutive errors metric. See Envoy's [outlier detection](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/outlier) for more details.<br><p> <br><p> The following rule sets a connection pool size of 100 HTTP1 connections with no more than 10 req/connection to the "reviews" service. In addition, it sets a limit of 1000 concurrent HTTP2 requests and configures upstream hosts to be scanned every 5 mins so that any host that fails 7 consecutive times with a 502, 503, or 504 error code will be ejected for 15 minutes.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: DestinationRule metadata:<br><p> <br><p> 	name: reviews-cb-policy<br><p> <br><p> spec:<br><p> <br><p> 	host: reviews.prod.svc.cluster.local<br><p> 	trafficPolicy:<br><p> 	  connectionPool:<br><p> 	    tcp:<br><p> 	      maxConnections: 100<br><p> 	    http:<br><p> 	      http2MaxRequests: 1000<br><p> 	      maxRequestsPerConnection: 10<br><p> 	  outlierDetection:<br><p> 	    consecutive5xxErrors: 7<br><p> 	    interval: 5m<br><p> 	    baseEjectionTime: 15m<br><p> <br><p> ```
     */
    @JsonProperty("interval")
    public void setInterval(String interval) {
        this.interval = interval;
    }

    /**
     * Maximum % of hosts in the load balancing pool for the upstream service that can be ejected. Defaults to 10%.
     */
    @JsonProperty("maxEjectionPercent")
    public Integer getMaxEjectionPercent() {
        return maxEjectionPercent;
    }

    /**
     * Maximum % of hosts in the load balancing pool for the upstream service that can be ejected. Defaults to 10%.
     */
    @JsonProperty("maxEjectionPercent")
    public void setMaxEjectionPercent(Integer maxEjectionPercent) {
        this.maxEjectionPercent = maxEjectionPercent;
    }

    /**
     * Outlier detection will be enabled as long as the associated load balancing pool has at least `minHealthPercent` hosts in healthy mode. When the percentage of healthy hosts in the load balancing pool drops below this threshold, outlier detection will be disabled and the proxy will load balance across all hosts in the pool (healthy and unhealthy). The threshold can be disabled by setting it to 0%. The default is 0% as it's not typically applicable in k8s environments with few pods per service.
     */
    @JsonProperty("minHealthPercent")
    public Integer getMinHealthPercent() {
        return minHealthPercent;
    }

    /**
     * Outlier detection will be enabled as long as the associated load balancing pool has at least `minHealthPercent` hosts in healthy mode. When the percentage of healthy hosts in the load balancing pool drops below this threshold, outlier detection will be disabled and the proxy will load balance across all hosts in the pool (healthy and unhealthy). The threshold can be disabled by setting it to 0%. The default is 0% as it's not typically applicable in k8s environments with few pods per service.
     */
    @JsonProperty("minHealthPercent")
    public void setMinHealthPercent(Integer minHealthPercent) {
        this.minHealthPercent = minHealthPercent;
    }

    /**
     * Determines whether to distinguish local origin failures from external errors. If set to true `consecutiveLocalOriginFailures` is taken into account for outlier detection calculations. This should be used when you want to derive the outlier detection status based on the errors seen locally such as failure to connect, timeout while connecting etc. rather than the status code returned by upstream service. This is especially useful when the upstream service explicitly returns a 5xx for some requests and you want to ignore those responses from upstream service while determining the outlier detection status of a host. Defaults to false.
     */
    @JsonProperty("splitExternalLocalOriginErrors")
    public Boolean getSplitExternalLocalOriginErrors() {
        return splitExternalLocalOriginErrors;
    }

    /**
     * Determines whether to distinguish local origin failures from external errors. If set to true `consecutiveLocalOriginFailures` is taken into account for outlier detection calculations. This should be used when you want to derive the outlier detection status based on the errors seen locally such as failure to connect, timeout while connecting etc. rather than the status code returned by upstream service. This is especially useful when the upstream service explicitly returns a 5xx for some requests and you want to ignore those responses from upstream service while determining the outlier detection status of a host. Defaults to false.
     */
    @JsonProperty("splitExternalLocalOriginErrors")
    public void setSplitExternalLocalOriginErrors(Boolean splitExternalLocalOriginErrors) {
        this.splitExternalLocalOriginErrors = splitExternalLocalOriginErrors;
    }

    @JsonIgnore
    public OutlierDetectionBuilder edit() {
        return new OutlierDetectionBuilder(this);
    }

    @JsonIgnore
    public OutlierDetectionBuilder toBuilder() {
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
