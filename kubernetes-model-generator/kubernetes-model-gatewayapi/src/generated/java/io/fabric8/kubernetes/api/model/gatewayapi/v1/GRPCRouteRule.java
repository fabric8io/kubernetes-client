
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
 * GRPCRouteRule defines the semantics for matching a gRPC request based on conditions (matches), processing it (filters), and forwarding the request to an API object (backendRefs).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backendRefs",
    "filters",
    "matches",
    "name",
    "sessionPersistence"
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
public class GRPCRouteRule implements Editable<GRPCRouteRuleBuilder>, KubernetesResource
{

    @JsonProperty("backendRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GRPCBackendRef> backendRefs = new ArrayList<>();
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GRPCRouteFilter> filters = new ArrayList<>();
    @JsonProperty("matches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GRPCRouteMatch> matches = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("sessionPersistence")
    private SessionPersistence sessionPersistence;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GRPCRouteRule() {
    }

    public GRPCRouteRule(List<GRPCBackendRef> backendRefs, List<GRPCRouteFilter> filters, List<GRPCRouteMatch> matches, String name, SessionPersistence sessionPersistence) {
        super();
        this.backendRefs = backendRefs;
        this.filters = filters;
        this.matches = matches;
        this.name = name;
        this.sessionPersistence = sessionPersistence;
    }

    /**
     * BackendRefs defines the backend(s) where matching requests should be sent.<br><p> <br><p> Failure behavior here depends on how many BackendRefs are specified and how many are invalid.<br><p> <br><p> If &#42;all&#42; entries in BackendRefs are invalid, and there are also no filters specified in this route rule, &#42;all&#42; traffic which matches this rule MUST receive an `UNAVAILABLE` status.<br><p> <br><p> See the GRPCBackendRef definition for the rules about what makes a single GRPCBackendRef invalid.<br><p> <br><p> When a GRPCBackendRef is invalid, `UNAVAILABLE` statuses MUST be returned for requests that would have otherwise been routed to an invalid backend. If multiple backends are specified, and some are invalid, the proportion of requests that would otherwise have been routed to an invalid backend MUST receive an `UNAVAILABLE` status.<br><p> <br><p> For example, if two backends are specified with equal weights, and one is invalid, 50 percent of traffic MUST receive an `UNAVAILABLE` status. Implementations may choose how that 50 percent is determined.<br><p> <br><p> Support: Core for Kubernetes Service<br><p> <br><p> Support: Implementation-specific for any other resource<br><p> <br><p> Support for weight: Core
     */
    @JsonProperty("backendRefs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GRPCBackendRef> getBackendRefs() {
        return backendRefs;
    }

    /**
     * BackendRefs defines the backend(s) where matching requests should be sent.<br><p> <br><p> Failure behavior here depends on how many BackendRefs are specified and how many are invalid.<br><p> <br><p> If &#42;all&#42; entries in BackendRefs are invalid, and there are also no filters specified in this route rule, &#42;all&#42; traffic which matches this rule MUST receive an `UNAVAILABLE` status.<br><p> <br><p> See the GRPCBackendRef definition for the rules about what makes a single GRPCBackendRef invalid.<br><p> <br><p> When a GRPCBackendRef is invalid, `UNAVAILABLE` statuses MUST be returned for requests that would have otherwise been routed to an invalid backend. If multiple backends are specified, and some are invalid, the proportion of requests that would otherwise have been routed to an invalid backend MUST receive an `UNAVAILABLE` status.<br><p> <br><p> For example, if two backends are specified with equal weights, and one is invalid, 50 percent of traffic MUST receive an `UNAVAILABLE` status. Implementations may choose how that 50 percent is determined.<br><p> <br><p> Support: Core for Kubernetes Service<br><p> <br><p> Support: Implementation-specific for any other resource<br><p> <br><p> Support for weight: Core
     */
    @JsonProperty("backendRefs")
    public void setBackendRefs(List<GRPCBackendRef> backendRefs) {
        this.backendRefs = backendRefs;
    }

    /**
     * Filters define the filters that are applied to requests that match this rule.<br><p> <br><p> The effects of ordering of multiple behaviors are currently unspecified. This can change in the future based on feedback during the alpha stage.<br><p> <br><p> Conformance-levels at this level are defined based on the type of filter:<br><p> <br><p> - ALL core filters MUST be supported by all implementations that support<br><p>   GRPCRoute.<br><p> - Implementers are encouraged to support extended filters. - Implementation-specific custom filters have no API guarantees across<br><p>   implementations.<br><p> <br><p> Specifying the same filter multiple times is not supported unless explicitly indicated in the filter.<br><p> <br><p> If an implementation cannot support a combination of filters, it must clearly document that limitation. In cases where incompatible or unsupported filters are specified and cause the `Accepted` condition to be set to status `False`, implementations may use the `IncompatibleFilters` reason to specify this configuration error.<br><p> <br><p> Support: Core
     */
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GRPCRouteFilter> getFilters() {
        return filters;
    }

    /**
     * Filters define the filters that are applied to requests that match this rule.<br><p> <br><p> The effects of ordering of multiple behaviors are currently unspecified. This can change in the future based on feedback during the alpha stage.<br><p> <br><p> Conformance-levels at this level are defined based on the type of filter:<br><p> <br><p> - ALL core filters MUST be supported by all implementations that support<br><p>   GRPCRoute.<br><p> - Implementers are encouraged to support extended filters. - Implementation-specific custom filters have no API guarantees across<br><p>   implementations.<br><p> <br><p> Specifying the same filter multiple times is not supported unless explicitly indicated in the filter.<br><p> <br><p> If an implementation cannot support a combination of filters, it must clearly document that limitation. In cases where incompatible or unsupported filters are specified and cause the `Accepted` condition to be set to status `False`, implementations may use the `IncompatibleFilters` reason to specify this configuration error.<br><p> <br><p> Support: Core
     */
    @JsonProperty("filters")
    public void setFilters(List<GRPCRouteFilter> filters) {
        this.filters = filters;
    }

    /**
     * Matches define conditions used for matching the rule against incoming gRPC requests. Each match is independent, i.e. this rule will be matched if &#42;&#42;any&#42;&#42; one of the matches is satisfied.<br><p> <br><p> For example, take the following matches configuration:<br><p> <br><p> ``` matches: - method:<br><p>     service: foo.bar<br><p>   headers:<br><p>     values:<br><p>       version: 2<br><p> - method:<br><p>     service: foo.bar.v2<br><p> ```<br><p> <br><p> For a request to match against this rule, it MUST satisfy EITHER of the two conditions:<br><p> <br><p> - service of foo.bar AND contains the header `version: 2` - service of foo.bar.v2<br><p> <br><p> See the documentation for GRPCRouteMatch on how to specify multiple match conditions to be ANDed together.<br><p> <br><p> If no matches are specified, the implementation MUST match every gRPC request.<br><p> <br><p> Proxy or Load Balancer routing configuration generated from GRPCRoutes MUST prioritize rules based on the following criteria, continuing on ties. Merging MUST not be done between GRPCRoutes and HTTPRoutes. Precedence MUST be given to the rule with the largest number of:<br><p> <br><p> &#42; Characters in a matching non-wildcard hostname. &#42; Characters in a matching hostname. &#42; Characters in a matching service. &#42; Characters in a matching method. &#42; Header matches.<br><p> <br><p> If ties still exist across multiple Routes, matching precedence MUST be determined in order of the following criteria, continuing on ties:<br><p> <br><p> &#42; The oldest Route based on creation timestamp. &#42; The Route appearing first in alphabetical order by<br><p>   "{namespace}/{name}".<br><p> <br><p> If ties still exist within the Route that has been given precedence, matching precedence MUST be granted to the first matching rule meeting the above criteria.
     */
    @JsonProperty("matches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GRPCRouteMatch> getMatches() {
        return matches;
    }

    /**
     * Matches define conditions used for matching the rule against incoming gRPC requests. Each match is independent, i.e. this rule will be matched if &#42;&#42;any&#42;&#42; one of the matches is satisfied.<br><p> <br><p> For example, take the following matches configuration:<br><p> <br><p> ``` matches: - method:<br><p>     service: foo.bar<br><p>   headers:<br><p>     values:<br><p>       version: 2<br><p> - method:<br><p>     service: foo.bar.v2<br><p> ```<br><p> <br><p> For a request to match against this rule, it MUST satisfy EITHER of the two conditions:<br><p> <br><p> - service of foo.bar AND contains the header `version: 2` - service of foo.bar.v2<br><p> <br><p> See the documentation for GRPCRouteMatch on how to specify multiple match conditions to be ANDed together.<br><p> <br><p> If no matches are specified, the implementation MUST match every gRPC request.<br><p> <br><p> Proxy or Load Balancer routing configuration generated from GRPCRoutes MUST prioritize rules based on the following criteria, continuing on ties. Merging MUST not be done between GRPCRoutes and HTTPRoutes. Precedence MUST be given to the rule with the largest number of:<br><p> <br><p> &#42; Characters in a matching non-wildcard hostname. &#42; Characters in a matching hostname. &#42; Characters in a matching service. &#42; Characters in a matching method. &#42; Header matches.<br><p> <br><p> If ties still exist across multiple Routes, matching precedence MUST be determined in order of the following criteria, continuing on ties:<br><p> <br><p> &#42; The oldest Route based on creation timestamp. &#42; The Route appearing first in alphabetical order by<br><p>   "{namespace}/{name}".<br><p> <br><p> If ties still exist within the Route that has been given precedence, matching precedence MUST be granted to the first matching rule meeting the above criteria.
     */
    @JsonProperty("matches")
    public void setMatches(List<GRPCRouteMatch> matches) {
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
     * GRPCRouteRule defines the semantics for matching a gRPC request based on conditions (matches), processing it (filters), and forwarding the request to an API object (backendRefs).
     */
    @JsonProperty("sessionPersistence")
    public SessionPersistence getSessionPersistence() {
        return sessionPersistence;
    }

    /**
     * GRPCRouteRule defines the semantics for matching a gRPC request based on conditions (matches), processing it (filters), and forwarding the request to an API object (backendRefs).
     */
    @JsonProperty("sessionPersistence")
    public void setSessionPersistence(SessionPersistence sessionPersistence) {
        this.sessionPersistence = sessionPersistence;
    }

    @JsonIgnore
    public GRPCRouteRuleBuilder edit() {
        return new GRPCRouteRuleBuilder(this);
    }

    @JsonIgnore
    public GRPCRouteRuleBuilder toBuilder() {
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
