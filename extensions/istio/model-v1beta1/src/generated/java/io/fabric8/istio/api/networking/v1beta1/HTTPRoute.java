
package io.fabric8.istio.api.networking.v1beta1;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
@Setter
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
@Generated("jsonschema2pojo")
public class HTTPRoute implements Editable<HTTPRouteBuilder> , KubernetesResource
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
    private List<HTTPMatchRequest> match = new ArrayList<HTTPMatchRequest>();
    @JsonProperty("mirror")
    private Destination mirror;
    @JsonProperty("mirrorPercent")
    private Integer mirrorPercent;
    @JsonProperty("mirrorPercentage")
    private Percent mirrorPercentage;
    @JsonProperty("mirrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPMirrorPolicy> mirrors = new ArrayList<HTTPMirrorPolicy>();
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
    private List<HTTPRouteDestination> route = new ArrayList<HTTPRouteDestination>();
    @JsonProperty("timeout")
    private String timeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
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

    @JsonProperty("corsPolicy")
    public CorsPolicy getCorsPolicy() {
        return corsPolicy;
    }

    @JsonProperty("corsPolicy")
    public void setCorsPolicy(CorsPolicy corsPolicy) {
        this.corsPolicy = corsPolicy;
    }

    @JsonProperty("delegate")
    public Delegate getDelegate() {
        return delegate;
    }

    @JsonProperty("delegate")
    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    @JsonProperty("directResponse")
    public HTTPDirectResponse getDirectResponse() {
        return directResponse;
    }

    @JsonProperty("directResponse")
    public void setDirectResponse(HTTPDirectResponse directResponse) {
        this.directResponse = directResponse;
    }

    @JsonProperty("fault")
    public HTTPFaultInjection getFault() {
        return fault;
    }

    @JsonProperty("fault")
    public void setFault(HTTPFaultInjection fault) {
        this.fault = fault;
    }

    @JsonProperty("headers")
    public Headers getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    @JsonProperty("match")
    public List<HTTPMatchRequest> getMatch() {
        return match;
    }

    @JsonProperty("match")
    public void setMatch(List<HTTPMatchRequest> match) {
        this.match = match;
    }

    @JsonProperty("mirror")
    public Destination getMirror() {
        return mirror;
    }

    @JsonProperty("mirror")
    public void setMirror(Destination mirror) {
        this.mirror = mirror;
    }

    @JsonProperty("mirrorPercent")
    public Integer getMirrorPercent() {
        return mirrorPercent;
    }

    @JsonProperty("mirrorPercent")
    public void setMirrorPercent(Integer mirrorPercent) {
        this.mirrorPercent = mirrorPercent;
    }

    @JsonProperty("mirrorPercentage")
    public Percent getMirrorPercentage() {
        return mirrorPercentage;
    }

    @JsonProperty("mirrorPercentage")
    public void setMirrorPercentage(Percent mirrorPercentage) {
        this.mirrorPercentage = mirrorPercentage;
    }

    @JsonProperty("mirrors")
    public List<HTTPMirrorPolicy> getMirrors() {
        return mirrors;
    }

    @JsonProperty("mirrors")
    public void setMirrors(List<HTTPMirrorPolicy> mirrors) {
        this.mirrors = mirrors;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("redirect")
    public HTTPRedirect getRedirect() {
        return redirect;
    }

    @JsonProperty("redirect")
    public void setRedirect(HTTPRedirect redirect) {
        this.redirect = redirect;
    }

    @JsonProperty("retries")
    public HTTPRetry getRetries() {
        return retries;
    }

    @JsonProperty("retries")
    public void setRetries(HTTPRetry retries) {
        this.retries = retries;
    }

    @JsonProperty("rewrite")
    public HTTPRewrite getRewrite() {
        return rewrite;
    }

    @JsonProperty("rewrite")
    public void setRewrite(HTTPRewrite rewrite) {
        this.rewrite = rewrite;
    }

    @JsonProperty("route")
    public List<HTTPRouteDestination> getRoute() {
        return route;
    }

    @JsonProperty("route")
    public void setRoute(List<HTTPRouteDestination> route) {
        this.route = route;
    }

    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

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
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
