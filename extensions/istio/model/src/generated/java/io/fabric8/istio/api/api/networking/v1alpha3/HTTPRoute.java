
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
 * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "corsPolicy",
    "delegate",
    "directResponse",
    "fault",
    "headers",
    "match",
    "mirror",
    "mirrorPercent",
    "mirrorPercentage",
    "mirrors",
    "name",
    "redirect",
    "retries",
    "rewrite",
    "route",
    "timeout"
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
public class HTTPRoute implements Editable<HTTPRouteBuilder>, KubernetesResource
{

    @JsonProperty("corsPolicy")
    private CorsPolicy corsPolicy;
    @JsonProperty("delegate")
    private Delegate delegate;
    @JsonProperty("directResponse")
    private HTTPDirectResponse directResponse;
    @JsonProperty("fault")
    private HTTPFaultInjection fault;
    @JsonProperty("headers")
    private Headers headers;
    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPMatchRequest> match = new ArrayList<>();
    @JsonProperty("mirror")
    private Destination mirror;
    @JsonProperty("mirrorPercent")
    private Integer mirrorPercent;
    @JsonProperty("mirrorPercentage")
    private Percent mirrorPercentage;
    @JsonProperty("mirrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPMirrorPolicy> mirrors = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("redirect")
    private HTTPRedirect redirect;
    @JsonProperty("retries")
    private HTTPRetry retries;
    @JsonProperty("rewrite")
    private HTTPRewrite rewrite;
    @JsonProperty("route")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPRouteDestination> route = new ArrayList<>();
    @JsonProperty("timeout")
    private String timeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRoute() {
    }

    public HTTPRoute(CorsPolicy corsPolicy, Delegate delegate, HTTPDirectResponse directResponse, HTTPFaultInjection fault, Headers headers, List<HTTPMatchRequest> match, Destination mirror, Integer mirrorPercent, Percent mirrorPercentage, List<HTTPMirrorPolicy> mirrors, String name, HTTPRedirect redirect, HTTPRetry retries, HTTPRewrite rewrite, List<HTTPRouteDestination> route, String timeout) {
        super();
        this.corsPolicy = corsPolicy;
        this.delegate = delegate;
        this.directResponse = directResponse;
        this.fault = fault;
        this.headers = headers;
        this.match = match;
        this.mirror = mirror;
        this.mirrorPercent = mirrorPercent;
        this.mirrorPercentage = mirrorPercentage;
        this.mirrors = mirrors;
        this.name = name;
        this.redirect = redirect;
        this.retries = retries;
        this.rewrite = rewrite;
        this.route = route;
        this.timeout = timeout;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("corsPolicy")
    public CorsPolicy getCorsPolicy() {
        return corsPolicy;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("corsPolicy")
    public void setCorsPolicy(CorsPolicy corsPolicy) {
        this.corsPolicy = corsPolicy;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("delegate")
    public Delegate getDelegate() {
        return delegate;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("delegate")
    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("directResponse")
    public HTTPDirectResponse getDirectResponse() {
        return directResponse;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("directResponse")
    public void setDirectResponse(HTTPDirectResponse directResponse) {
        this.directResponse = directResponse;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("fault")
    public HTTPFaultInjection getFault() {
        return fault;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("fault")
    public void setFault(HTTPFaultInjection fault) {
        this.fault = fault;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("headers")
    public Headers getHeaders() {
        return headers;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("headers")
    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    /**
     * Match conditions to be satisfied for the rule to be activated. All conditions inside a single match block have AND semantics, while the list of match blocks have OR semantics. The rule is matched if any one of the match blocks succeed.
     */
    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPMatchRequest> getMatch() {
        return match;
    }

    /**
     * Match conditions to be satisfied for the rule to be activated. All conditions inside a single match block have AND semantics, while the list of match blocks have OR semantics. The rule is matched if any one of the match blocks succeed.
     */
    @JsonProperty("match")
    public void setMatch(List<HTTPMatchRequest> match) {
        this.match = match;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("mirror")
    public Destination getMirror() {
        return mirror;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("mirror")
    public void setMirror(Destination mirror) {
        this.mirror = mirror;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("mirrorPercent")
    public Integer getMirrorPercent() {
        return mirrorPercent;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("mirrorPercent")
    public void setMirrorPercent(Integer mirrorPercent) {
        this.mirrorPercent = mirrorPercent;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("mirrorPercentage")
    public Percent getMirrorPercentage() {
        return mirrorPercentage;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("mirrorPercentage")
    public void setMirrorPercentage(Percent mirrorPercentage) {
        this.mirrorPercentage = mirrorPercentage;
    }

    /**
     * Specifies the destinations to mirror HTTP traffic in addition to the original destination. Mirrored traffic is on a best effort basis where the sidecar/gateway will not wait for the mirrored destinations to respond before returning the response from the original destination. Statistics will be generated for the mirrored destination.
     */
    @JsonProperty("mirrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPMirrorPolicy> getMirrors() {
        return mirrors;
    }

    /**
     * Specifies the destinations to mirror HTTP traffic in addition to the original destination. Mirrored traffic is on a best effort basis where the sidecar/gateway will not wait for the mirrored destinations to respond before returning the response from the original destination. Statistics will be generated for the mirrored destination.
     */
    @JsonProperty("mirrors")
    public void setMirrors(List<HTTPMirrorPolicy> mirrors) {
        this.mirrors = mirrors;
    }

    /**
     * The name assigned to the route for debugging purposes. The route's name will be concatenated with the match's name and will be logged in the access logs for requests matching this route/match.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The name assigned to the route for debugging purposes. The route's name will be concatenated with the match's name and will be logged in the access logs for requests matching this route/match.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("redirect")
    public HTTPRedirect getRedirect() {
        return redirect;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("redirect")
    public void setRedirect(HTTPRedirect redirect) {
        this.redirect = redirect;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("retries")
    public HTTPRetry getRetries() {
        return retries;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("retries")
    public void setRetries(HTTPRetry retries) {
        this.retries = retries;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("rewrite")
    public HTTPRewrite getRewrite() {
        return rewrite;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("rewrite")
    public void setRewrite(HTTPRewrite rewrite) {
        this.rewrite = rewrite;
    }

    /**
     * A HTTP rule can either return a direct_response, redirect or forward (default) traffic. The forwarding target can be one of several versions of a service (see glossary in beginning of document). Weights associated with the service version determine the proportion of traffic it receives.
     */
    @JsonProperty("route")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPRouteDestination> getRoute() {
        return route;
    }

    /**
     * A HTTP rule can either return a direct_response, redirect or forward (default) traffic. The forwarding target can be one of several versions of a service (see glossary in beginning of document). Weights associated with the service version determine the proportion of traffic it receives.
     */
    @JsonProperty("route")
    public void setRoute(List<HTTPRouteDestination> route) {
        this.route = route;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    /**
     * Describes match conditions and actions for routing HTTP/1.1, HTTP2, and gRPC traffic. See VirtualService for usage examples.
     */
    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    @JsonIgnore
    public HTTPRouteBuilder edit() {
        return new HTTPRouteBuilder(this);
    }

    @JsonIgnore
    public HTTPRouteBuilder toBuilder() {
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
