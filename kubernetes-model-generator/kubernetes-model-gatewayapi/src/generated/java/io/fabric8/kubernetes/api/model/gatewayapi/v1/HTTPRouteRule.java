
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
 * HTTPRouteRule defines semantics for matching an HTTP request based on conditions (matches), processing it (filters), and forwarding the request to an API object (backendRefs).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backendRefs",
    "filters",
    "matches",
    "name",
    "retry",
    "sessionPersistence",
    "timeouts"
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
public class HTTPRouteRule implements Editable<HTTPRouteRuleBuilder>, KubernetesResource
{

    @JsonProperty("backendRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPBackendRef> backendRefs = new ArrayList<>();
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPRouteFilter> filters = new ArrayList<>();
    @JsonProperty("matches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPRouteMatch> matches = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("retry")
    private HTTPRouteRetry retry;
    @JsonProperty("sessionPersistence")
    private SessionPersistence sessionPersistence;
    @JsonProperty("timeouts")
    private HTTPRouteTimeouts timeouts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRouteRule() {
    }

    public HTTPRouteRule(List<HTTPBackendRef> backendRefs, List<HTTPRouteFilter> filters, List<HTTPRouteMatch> matches, String name, HTTPRouteRetry retry, SessionPersistence sessionPersistence, HTTPRouteTimeouts timeouts) {
        super();
        this.backendRefs = backendRefs;
        this.filters = filters;
        this.matches = matches;
        this.name = name;
        this.retry = retry;
        this.sessionPersistence = sessionPersistence;
        this.timeouts = timeouts;
    }

    /**
     * BackendRefs defines the backend(s) where matching requests should be sent.<br><p> <br><p> Failure behavior here depends on how many BackendRefs are specified and how many are invalid.<br><p> <br><p> If &#42;all&#42; entries in BackendRefs are invalid, and there are also no filters specified in this route rule, &#42;all&#42; traffic which matches this rule MUST receive a 500 status code.<br><p> <br><p> See the HTTPBackendRef definition for the rules about what makes a single HTTPBackendRef invalid.<br><p> <br><p> When a HTTPBackendRef is invalid, 500 status codes MUST be returned for requests that would have otherwise been routed to an invalid backend. If multiple backends are specified, and some are invalid, the proportion of requests that would otherwise have been routed to an invalid backend MUST receive a 500 status code.<br><p> <br><p> For example, if two backends are specified with equal weights, and one is invalid, 50 percent of traffic must receive a 500. Implementations may choose how that 50 percent is determined.<br><p> <br><p> When a HTTPBackendRef refers to a Service that has no ready endpoints, implementations SHOULD return a 503 for requests to that backend instead. If an implementation chooses to do this, all of the above rules for 500 responses MUST also apply for responses that return a 503.<br><p> <br><p> Support: Core for Kubernetes Service<br><p> <br><p> Support: Extended for Kubernetes ServiceImport<br><p> <br><p> Support: Implementation-specific for any other resource<br><p> <br><p> Support for weight: Core
     */
    @JsonProperty("backendRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPBackendRef> getBackendRefs() {
        return backendRefs;
    }

    /**
     * BackendRefs defines the backend(s) where matching requests should be sent.<br><p> <br><p> Failure behavior here depends on how many BackendRefs are specified and how many are invalid.<br><p> <br><p> If &#42;all&#42; entries in BackendRefs are invalid, and there are also no filters specified in this route rule, &#42;all&#42; traffic which matches this rule MUST receive a 500 status code.<br><p> <br><p> See the HTTPBackendRef definition for the rules about what makes a single HTTPBackendRef invalid.<br><p> <br><p> When a HTTPBackendRef is invalid, 500 status codes MUST be returned for requests that would have otherwise been routed to an invalid backend. If multiple backends are specified, and some are invalid, the proportion of requests that would otherwise have been routed to an invalid backend MUST receive a 500 status code.<br><p> <br><p> For example, if two backends are specified with equal weights, and one is invalid, 50 percent of traffic must receive a 500. Implementations may choose how that 50 percent is determined.<br><p> <br><p> When a HTTPBackendRef refers to a Service that has no ready endpoints, implementations SHOULD return a 503 for requests to that backend instead. If an implementation chooses to do this, all of the above rules for 500 responses MUST also apply for responses that return a 503.<br><p> <br><p> Support: Core for Kubernetes Service<br><p> <br><p> Support: Extended for Kubernetes ServiceImport<br><p> <br><p> Support: Implementation-specific for any other resource<br><p> <br><p> Support for weight: Core
     */
    @JsonProperty("backendRefs")
    public void setBackendRefs(List<HTTPBackendRef> backendRefs) {
        this.backendRefs = backendRefs;
    }

    /**
     * Filters define the filters that are applied to requests that match this rule.<br><p> <br><p> Wherever possible, implementations SHOULD implement filters in the order they are specified.<br><p> <br><p> Implementations MAY choose to implement this ordering strictly, rejecting any combination or order of filters that cannot be supported. If implementations choose a strict interpretation of filter ordering, they MUST clearly document that behavior.<br><p> <br><p> To reject an invalid combination or order of filters, implementations SHOULD consider the Route Rules with this configuration invalid. If all Route Rules in a Route are invalid, the entire Route would be considered invalid. If only a portion of Route Rules are invalid, implementations MUST set the "PartiallyInvalid" condition for the Route.<br><p> <br><p> Conformance-levels at this level are defined based on the type of filter:<br><p> <br><p> - ALL core filters MUST be supported by all implementations. - Implementers are encouraged to support extended filters. - Implementation-specific custom filters have no API guarantees across<br><p>   implementations.<br><p> <br><p> Specifying the same filter multiple times is not supported unless explicitly indicated in the filter.<br><p> <br><p> All filters are expected to be compatible with each other except for the URLRewrite and RequestRedirect filters, which may not be combined. If an implementation cannot support other combinations of filters, they must clearly document that limitation. In cases where incompatible or unsupported filters are specified and cause the `Accepted` condition to be set to status `False`, implementations may use the `IncompatibleFilters` reason to specify this configuration error.<br><p> <br><p> Support: Core
     */
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPRouteFilter> getFilters() {
        return filters;
    }

    /**
     * Filters define the filters that are applied to requests that match this rule.<br><p> <br><p> Wherever possible, implementations SHOULD implement filters in the order they are specified.<br><p> <br><p> Implementations MAY choose to implement this ordering strictly, rejecting any combination or order of filters that cannot be supported. If implementations choose a strict interpretation of filter ordering, they MUST clearly document that behavior.<br><p> <br><p> To reject an invalid combination or order of filters, implementations SHOULD consider the Route Rules with this configuration invalid. If all Route Rules in a Route are invalid, the entire Route would be considered invalid. If only a portion of Route Rules are invalid, implementations MUST set the "PartiallyInvalid" condition for the Route.<br><p> <br><p> Conformance-levels at this level are defined based on the type of filter:<br><p> <br><p> - ALL core filters MUST be supported by all implementations. - Implementers are encouraged to support extended filters. - Implementation-specific custom filters have no API guarantees across<br><p>   implementations.<br><p> <br><p> Specifying the same filter multiple times is not supported unless explicitly indicated in the filter.<br><p> <br><p> All filters are expected to be compatible with each other except for the URLRewrite and RequestRedirect filters, which may not be combined. If an implementation cannot support other combinations of filters, they must clearly document that limitation. In cases where incompatible or unsupported filters are specified and cause the `Accepted` condition to be set to status `False`, implementations may use the `IncompatibleFilters` reason to specify this configuration error.<br><p> <br><p> Support: Core
     */
    @JsonProperty("filters")
    public void setFilters(List<HTTPRouteFilter> filters) {
        this.filters = filters;
    }

    /**
     * Matches define conditions used for matching the rule against incoming HTTP requests. Each match is independent, i.e. this rule will be matched if &#42;&#42;any&#42;&#42; one of the matches is satisfied.<br><p> <br><p> For example, take the following matches configuration:<br><p> <br><p> ``` matches: - path:<br><p>     value: "/foo"<br><p>   headers:<br><p>   - name: "version"<br><p>     value: "v2"<br><p> - path:<br><p>     value: "/v2/foo"<br><p> ```<br><p> <br><p> For a request to match against this rule, a request must satisfy EITHER of the two conditions:<br><p> <br><p> - path prefixed with `/foo` AND contains the header `version: v2` - path prefix of `/v2/foo`<br><p> <br><p> See the documentation for HTTPRouteMatch on how to specify multiple match conditions that should be ANDed together.<br><p> <br><p> If no matches are specified, the default is a prefix path match on "/", which has the effect of matching every HTTP request.<br><p> <br><p> Proxy or Load Balancer routing configuration generated from HTTPRoutes MUST prioritize matches based on the following criteria, continuing on ties. Across all rules specified on applicable Routes, precedence must be given to the match having:<br><p> <br><p> &#42; "Exact" path match. &#42; "Prefix" path match with largest number of characters. &#42; Method match. &#42; Largest number of header matches. &#42; Largest number of query param matches.<br><p> <br><p> Note: The precedence of RegularExpression path matches are implementation-specific.<br><p> <br><p> If ties still exist across multiple Routes, matching precedence MUST be determined in order of the following criteria, continuing on ties:<br><p> <br><p> &#42; The oldest Route based on creation timestamp. &#42; The Route appearing first in alphabetical order by<br><p>   "{namespace}/{name}".<br><p> <br><p> If ties still exist within an HTTPRoute, matching precedence MUST be granted to the FIRST matching rule (in list order) with a match meeting the above criteria.<br><p> <br><p> When no rules matching a request have been successfully attached to the parent a request is coming from, a HTTP 404 status code MUST be returned.
     */
    @JsonProperty("matches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HTTPRouteMatch> getMatches() {
        return matches;
    }

    /**
     * Matches define conditions used for matching the rule against incoming HTTP requests. Each match is independent, i.e. this rule will be matched if &#42;&#42;any&#42;&#42; one of the matches is satisfied.<br><p> <br><p> For example, take the following matches configuration:<br><p> <br><p> ``` matches: - path:<br><p>     value: "/foo"<br><p>   headers:<br><p>   - name: "version"<br><p>     value: "v2"<br><p> - path:<br><p>     value: "/v2/foo"<br><p> ```<br><p> <br><p> For a request to match against this rule, a request must satisfy EITHER of the two conditions:<br><p> <br><p> - path prefixed with `/foo` AND contains the header `version: v2` - path prefix of `/v2/foo`<br><p> <br><p> See the documentation for HTTPRouteMatch on how to specify multiple match conditions that should be ANDed together.<br><p> <br><p> If no matches are specified, the default is a prefix path match on "/", which has the effect of matching every HTTP request.<br><p> <br><p> Proxy or Load Balancer routing configuration generated from HTTPRoutes MUST prioritize matches based on the following criteria, continuing on ties. Across all rules specified on applicable Routes, precedence must be given to the match having:<br><p> <br><p> &#42; "Exact" path match. &#42; "Prefix" path match with largest number of characters. &#42; Method match. &#42; Largest number of header matches. &#42; Largest number of query param matches.<br><p> <br><p> Note: The precedence of RegularExpression path matches are implementation-specific.<br><p> <br><p> If ties still exist across multiple Routes, matching precedence MUST be determined in order of the following criteria, continuing on ties:<br><p> <br><p> &#42; The oldest Route based on creation timestamp. &#42; The Route appearing first in alphabetical order by<br><p>   "{namespace}/{name}".<br><p> <br><p> If ties still exist within an HTTPRoute, matching precedence MUST be granted to the FIRST matching rule (in list order) with a match meeting the above criteria.<br><p> <br><p> When no rules matching a request have been successfully attached to the parent a request is coming from, a HTTP 404 status code MUST be returned.
     */
    @JsonProperty("matches")
    public void setMatches(List<HTTPRouteMatch> matches) {
        this.matches = matches;
    }

    /**
     * Name is the name of the route rule. This name MUST be unique within a Route if it is set.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the route rule. This name MUST be unique within a Route if it is set.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * HTTPRouteRule defines semantics for matching an HTTP request based on conditions (matches), processing it (filters), and forwarding the request to an API object (backendRefs).
     */
    @JsonProperty("retry")
    public HTTPRouteRetry getRetry() {
        return retry;
    }

    /**
     * HTTPRouteRule defines semantics for matching an HTTP request based on conditions (matches), processing it (filters), and forwarding the request to an API object (backendRefs).
     */
    @JsonProperty("retry")
    public void setRetry(HTTPRouteRetry retry) {
        this.retry = retry;
    }

    /**
     * HTTPRouteRule defines semantics for matching an HTTP request based on conditions (matches), processing it (filters), and forwarding the request to an API object (backendRefs).
     */
    @JsonProperty("sessionPersistence")
    public SessionPersistence getSessionPersistence() {
        return sessionPersistence;
    }

    /**
     * HTTPRouteRule defines semantics for matching an HTTP request based on conditions (matches), processing it (filters), and forwarding the request to an API object (backendRefs).
     */
    @JsonProperty("sessionPersistence")
    public void setSessionPersistence(SessionPersistence sessionPersistence) {
        this.sessionPersistence = sessionPersistence;
    }

    /**
     * HTTPRouteRule defines semantics for matching an HTTP request based on conditions (matches), processing it (filters), and forwarding the request to an API object (backendRefs).
     */
    @JsonProperty("timeouts")
    public HTTPRouteTimeouts getTimeouts() {
        return timeouts;
    }

    /**
     * HTTPRouteRule defines semantics for matching an HTTP request based on conditions (matches), processing it (filters), and forwarding the request to an API object (backendRefs).
     */
    @JsonProperty("timeouts")
    public void setTimeouts(HTTPRouteTimeouts timeouts) {
        this.timeouts = timeouts;
    }

    @JsonIgnore
    public HTTPRouteRuleBuilder edit() {
        return new HTTPRouteRuleBuilder(this);
    }

    @JsonIgnore
    public HTTPRouteRuleBuilder toBuilder() {
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
