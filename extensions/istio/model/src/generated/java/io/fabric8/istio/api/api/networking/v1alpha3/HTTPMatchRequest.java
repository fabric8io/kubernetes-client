
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
 * HttpMatchRequest specifies a set of criteria to be met in order for the rule to be applied to the HTTP request. For example, the following restricts the rule to match only requests where the URL path starts with /ratings/v2/ and the request contains a custom `end-user` header with value `jason`.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - headers:<br><p> 	      end-user:<br><p> 	        exact: jason<br><p> 	    uri:<br><p> 	      prefix: "/ratings/v2/"<br><p> 	    ignoreUriCase: true<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> <br><p> ```<br><p> <br><p> HTTPMatchRequest CANNOT be empty. &#42;&#42;Note:&#42;&#42; 1. If a root VirtualService have matched any property (path, header etc.) by regex, delegate VirtualServices should not have any other matches on the same property. 2. If a delegate VirtualService have matched any property (path, header etc.) by regex, root VirtualServices should not have any other matches on the same property.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authority",
    "gateways",
    "headers",
    "ignoreUriCase",
    "method",
    "name",
    "port",
    "queryParams",
    "scheme",
    "sourceLabels",
    "sourceNamespace",
    "statPrefix",
    "uri",
    "withoutHeaders"
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
public class HTTPMatchRequest implements Editable<HTTPMatchRequestBuilder>, KubernetesResource
{

    @JsonProperty("authority")
    private StringMatch authority;
    @JsonProperty("gateways")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> gateways = new ArrayList<>();
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, StringMatch> headers = new LinkedHashMap<>();
    @JsonProperty("ignoreUriCase")
    private Boolean ignoreUriCase;
    @JsonProperty("method")
    private StringMatch method;
    @JsonProperty("name")
    private String name;
    @JsonProperty("port")
    private Long port;
    @JsonProperty("queryParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, StringMatch> queryParams = new LinkedHashMap<>();
    @JsonProperty("scheme")
    private StringMatch scheme;
    @JsonProperty("sourceLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> sourceLabels = new LinkedHashMap<>();
    @JsonProperty("sourceNamespace")
    private String sourceNamespace;
    @JsonProperty("statPrefix")
    private String statPrefix;
    @JsonProperty("uri")
    private StringMatch uri;
    @JsonProperty("withoutHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, StringMatch> withoutHeaders = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPMatchRequest() {
    }

    public HTTPMatchRequest(StringMatch authority, List<String> gateways, Map<String, StringMatch> headers, Boolean ignoreUriCase, StringMatch method, String name, Long port, Map<String, StringMatch> queryParams, StringMatch scheme, Map<String, String> sourceLabels, String sourceNamespace, String statPrefix, StringMatch uri, Map<String, StringMatch> withoutHeaders) {
        super();
        this.authority = authority;
        this.gateways = gateways;
        this.headers = headers;
        this.ignoreUriCase = ignoreUriCase;
        this.method = method;
        this.name = name;
        this.port = port;
        this.queryParams = queryParams;
        this.scheme = scheme;
        this.sourceLabels = sourceLabels;
        this.sourceNamespace = sourceNamespace;
        this.statPrefix = statPrefix;
        this.uri = uri;
        this.withoutHeaders = withoutHeaders;
    }

    /**
     * HttpMatchRequest specifies a set of criteria to be met in order for the rule to be applied to the HTTP request. For example, the following restricts the rule to match only requests where the URL path starts with /ratings/v2/ and the request contains a custom `end-user` header with value `jason`.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - headers:<br><p> 	      end-user:<br><p> 	        exact: jason<br><p> 	    uri:<br><p> 	      prefix: "/ratings/v2/"<br><p> 	    ignoreUriCase: true<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> <br><p> ```<br><p> <br><p> HTTPMatchRequest CANNOT be empty. &#42;&#42;Note:&#42;&#42; 1. If a root VirtualService have matched any property (path, header etc.) by regex, delegate VirtualServices should not have any other matches on the same property. 2. If a delegate VirtualService have matched any property (path, header etc.) by regex, root VirtualServices should not have any other matches on the same property.
     */
    @JsonProperty("authority")
    public StringMatch getAuthority() {
        return authority;
    }

    /**
     * HttpMatchRequest specifies a set of criteria to be met in order for the rule to be applied to the HTTP request. For example, the following restricts the rule to match only requests where the URL path starts with /ratings/v2/ and the request contains a custom `end-user` header with value `jason`.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - headers:<br><p> 	      end-user:<br><p> 	        exact: jason<br><p> 	    uri:<br><p> 	      prefix: "/ratings/v2/"<br><p> 	    ignoreUriCase: true<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> <br><p> ```<br><p> <br><p> HTTPMatchRequest CANNOT be empty. &#42;&#42;Note:&#42;&#42; 1. If a root VirtualService have matched any property (path, header etc.) by regex, delegate VirtualServices should not have any other matches on the same property. 2. If a delegate VirtualService have matched any property (path, header etc.) by regex, root VirtualServices should not have any other matches on the same property.
     */
    @JsonProperty("authority")
    public void setAuthority(StringMatch authority) {
        this.authority = authority;
    }

    /**
     * Names of gateways where the rule should be applied. Gateway names in the top-level `gateways` field of the VirtualService (if any) are overridden. The gateway match is independent of sourceLabels.
     */
    @JsonProperty("gateways")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGateways() {
        return gateways;
    }

    /**
     * Names of gateways where the rule should be applied. Gateway names in the top-level `gateways` field of the VirtualService (if any) are overridden. The gateway match is independent of sourceLabels.
     */
    @JsonProperty("gateways")
    public void setGateways(List<String> gateways) {
        this.gateways = gateways;
    }

    /**
     * The header keys must be lowercase and use hyphen as the separator, e.g. _x-request-id_.<br><p> <br><p> Header values are case-sensitive and formatted as follows:<br><p> <br><p> - `exact: "value"` for exact string match<br><p> <br><p> - `prefix: "value"` for prefix-based match<br><p> <br><p> - `regex: "value"` for [RE2 style regex-based match](https://github.com/google/re2/wiki/Syntax).<br><p> <br><p> If the value is empty and only the name of header is specified, presence of the header is checked. To provide an empty value, use `{}`, for example:<br><p> <br><p> ```<br><p>   - match:<br><p>   - headers:<br><p>     myheader: {}<br><p> <br><p> ``` &#42;&#42;Note:&#42;&#42; The keys `uri`, `scheme`, `method`, and `authority` will be ignored.
     */
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, StringMatch> getHeaders() {
        return headers;
    }

    /**
     * The header keys must be lowercase and use hyphen as the separator, e.g. _x-request-id_.<br><p> <br><p> Header values are case-sensitive and formatted as follows:<br><p> <br><p> - `exact: "value"` for exact string match<br><p> <br><p> - `prefix: "value"` for prefix-based match<br><p> <br><p> - `regex: "value"` for [RE2 style regex-based match](https://github.com/google/re2/wiki/Syntax).<br><p> <br><p> If the value is empty and only the name of header is specified, presence of the header is checked. To provide an empty value, use `{}`, for example:<br><p> <br><p> ```<br><p>   - match:<br><p>   - headers:<br><p>     myheader: {}<br><p> <br><p> ``` &#42;&#42;Note:&#42;&#42; The keys `uri`, `scheme`, `method`, and `authority` will be ignored.
     */
    @JsonProperty("headers")
    public void setHeaders(Map<String, StringMatch> headers) {
        this.headers = headers;
    }

    /**
     * Flag to specify whether the URI matching should be case-insensitive.<br><p> <br><p> &#42;&#42;Note:&#42;&#42; The case will be ignored only in the case of `exact` and `prefix` URI matches.
     */
    @JsonProperty("ignoreUriCase")
    public Boolean getIgnoreUriCase() {
        return ignoreUriCase;
    }

    /**
     * Flag to specify whether the URI matching should be case-insensitive.<br><p> <br><p> &#42;&#42;Note:&#42;&#42; The case will be ignored only in the case of `exact` and `prefix` URI matches.
     */
    @JsonProperty("ignoreUriCase")
    public void setIgnoreUriCase(Boolean ignoreUriCase) {
        this.ignoreUriCase = ignoreUriCase;
    }

    /**
     * HttpMatchRequest specifies a set of criteria to be met in order for the rule to be applied to the HTTP request. For example, the following restricts the rule to match only requests where the URL path starts with /ratings/v2/ and the request contains a custom `end-user` header with value `jason`.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - headers:<br><p> 	      end-user:<br><p> 	        exact: jason<br><p> 	    uri:<br><p> 	      prefix: "/ratings/v2/"<br><p> 	    ignoreUriCase: true<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> <br><p> ```<br><p> <br><p> HTTPMatchRequest CANNOT be empty. &#42;&#42;Note:&#42;&#42; 1. If a root VirtualService have matched any property (path, header etc.) by regex, delegate VirtualServices should not have any other matches on the same property. 2. If a delegate VirtualService have matched any property (path, header etc.) by regex, root VirtualServices should not have any other matches on the same property.
     */
    @JsonProperty("method")
    public StringMatch getMethod() {
        return method;
    }

    /**
     * HttpMatchRequest specifies a set of criteria to be met in order for the rule to be applied to the HTTP request. For example, the following restricts the rule to match only requests where the URL path starts with /ratings/v2/ and the request contains a custom `end-user` header with value `jason`.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - headers:<br><p> 	      end-user:<br><p> 	        exact: jason<br><p> 	    uri:<br><p> 	      prefix: "/ratings/v2/"<br><p> 	    ignoreUriCase: true<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> <br><p> ```<br><p> <br><p> HTTPMatchRequest CANNOT be empty. &#42;&#42;Note:&#42;&#42; 1. If a root VirtualService have matched any property (path, header etc.) by regex, delegate VirtualServices should not have any other matches on the same property. 2. If a delegate VirtualService have matched any property (path, header etc.) by regex, root VirtualServices should not have any other matches on the same property.
     */
    @JsonProperty("method")
    public void setMethod(StringMatch method) {
        this.method = method;
    }

    /**
     * The name assigned to a match. The match's name will be concatenated with the parent route's name and will be logged in the access logs for requests matching this route.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The name assigned to a match. The match's name will be concatenated with the parent route's name and will be logged in the access logs for requests matching this route.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Specifies the ports on the host that is being addressed. Many services only expose a single port or label ports with the protocols they support, in these cases it is not required to explicitly select the port.
     */
    @JsonProperty("port")
    public Long getPort() {
        return port;
    }

    /**
     * Specifies the ports on the host that is being addressed. Many services only expose a single port or label ports with the protocols they support, in these cases it is not required to explicitly select the port.
     */
    @JsonProperty("port")
    public void setPort(Long port) {
        this.port = port;
    }

    /**
     * Query parameters for matching.<br><p> <br><p> Ex:<br><p> <br><p>   - For a query parameter like "?key=true", the map key would be "key" and<br><p>     the string match could be defined as `exact: "true"`.<br><p> <br><p>   - For a query parameter like "?key", the map key would be "key" and the<br><p>     string match could be defined as `exact: ""`.<br><p> <br><p>   - For a query parameter like "?key=abc" or "?key=abx", the map key would be "key" and the<br><p>     string match could be defined as `prefix: "ab"`.<br><p> <br><p>   - For a query parameter like "?key=123", the map key would be "key" and the<br><p>     string match could be defined as `regex: "\d+$"`. Note that this<br><p>     configuration will only match values like "123" but not "a123" or "123a".
     */
    @JsonProperty("queryParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, StringMatch> getQueryParams() {
        return queryParams;
    }

    /**
     * Query parameters for matching.<br><p> <br><p> Ex:<br><p> <br><p>   - For a query parameter like "?key=true", the map key would be "key" and<br><p>     the string match could be defined as `exact: "true"`.<br><p> <br><p>   - For a query parameter like "?key", the map key would be "key" and the<br><p>     string match could be defined as `exact: ""`.<br><p> <br><p>   - For a query parameter like "?key=abc" or "?key=abx", the map key would be "key" and the<br><p>     string match could be defined as `prefix: "ab"`.<br><p> <br><p>   - For a query parameter like "?key=123", the map key would be "key" and the<br><p>     string match could be defined as `regex: "\d+$"`. Note that this<br><p>     configuration will only match values like "123" but not "a123" or "123a".
     */
    @JsonProperty("queryParams")
    public void setQueryParams(Map<String, StringMatch> queryParams) {
        this.queryParams = queryParams;
    }

    /**
     * HttpMatchRequest specifies a set of criteria to be met in order for the rule to be applied to the HTTP request. For example, the following restricts the rule to match only requests where the URL path starts with /ratings/v2/ and the request contains a custom `end-user` header with value `jason`.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - headers:<br><p> 	      end-user:<br><p> 	        exact: jason<br><p> 	    uri:<br><p> 	      prefix: "/ratings/v2/"<br><p> 	    ignoreUriCase: true<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> <br><p> ```<br><p> <br><p> HTTPMatchRequest CANNOT be empty. &#42;&#42;Note:&#42;&#42; 1. If a root VirtualService have matched any property (path, header etc.) by regex, delegate VirtualServices should not have any other matches on the same property. 2. If a delegate VirtualService have matched any property (path, header etc.) by regex, root VirtualServices should not have any other matches on the same property.
     */
    @JsonProperty("scheme")
    public StringMatch getScheme() {
        return scheme;
    }

    /**
     * HttpMatchRequest specifies a set of criteria to be met in order for the rule to be applied to the HTTP request. For example, the following restricts the rule to match only requests where the URL path starts with /ratings/v2/ and the request contains a custom `end-user` header with value `jason`.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - headers:<br><p> 	      end-user:<br><p> 	        exact: jason<br><p> 	    uri:<br><p> 	      prefix: "/ratings/v2/"<br><p> 	    ignoreUriCase: true<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> <br><p> ```<br><p> <br><p> HTTPMatchRequest CANNOT be empty. &#42;&#42;Note:&#42;&#42; 1. If a root VirtualService have matched any property (path, header etc.) by regex, delegate VirtualServices should not have any other matches on the same property. 2. If a delegate VirtualService have matched any property (path, header etc.) by regex, root VirtualServices should not have any other matches on the same property.
     */
    @JsonProperty("scheme")
    public void setScheme(StringMatch scheme) {
        this.scheme = scheme;
    }

    /**
     * One or more labels that constrain the applicability of a rule to source (client) workloads with the given labels. If the VirtualService has a list of gateways specified in the top-level `gateways` field, it must include the reserved gateway `mesh` for this field to be applicable.<br><p> <br><p> &#42;&#42;Note:&#42;&#42; This is not a runtime match, but is a selector; it filters which workloads the VirtualService applies to.
     */
    @JsonProperty("sourceLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getSourceLabels() {
        return sourceLabels;
    }

    /**
     * One or more labels that constrain the applicability of a rule to source (client) workloads with the given labels. If the VirtualService has a list of gateways specified in the top-level `gateways` field, it must include the reserved gateway `mesh` for this field to be applicable.<br><p> <br><p> &#42;&#42;Note:&#42;&#42; This is not a runtime match, but is a selector; it filters which workloads the VirtualService applies to.
     */
    @JsonProperty("sourceLabels")
    public void setSourceLabels(Map<String, String> sourceLabels) {
        this.sourceLabels = sourceLabels;
    }

    /**
     * Source namespace constraining the applicability of a rule to workloads in that namespace. If the VirtualService has a list of gateways specified in the top-level `gateways` field, it must include the reserved gateway `mesh` for this field to be applicable.<br><p> <br><p> &#42;&#42;Note:&#42;&#42; This is not a runtime match, but is a selector; it filters which workloads the VirtualService applies to.
     */
    @JsonProperty("sourceNamespace")
    public String getSourceNamespace() {
        return sourceNamespace;
    }

    /**
     * Source namespace constraining the applicability of a rule to workloads in that namespace. If the VirtualService has a list of gateways specified in the top-level `gateways` field, it must include the reserved gateway `mesh` for this field to be applicable.<br><p> <br><p> &#42;&#42;Note:&#42;&#42; This is not a runtime match, but is a selector; it filters which workloads the VirtualService applies to.
     */
    @JsonProperty("sourceNamespace")
    public void setSourceNamespace(String sourceNamespace) {
        this.sourceNamespace = sourceNamespace;
    }

    /**
     * The human readable prefix to use when emitting statistics for this route. The statistics are generated with prefix route.&lt;stat_prefix&gt;. This should be set for highly critical routes that one wishes to get "per-route" statistics on. This prefix is only for proxy-level statistics (envoy_&#42;) and not service-level (istio_&#42;) statistics. Refer to https://www.envoyproxy.io/docs/envoy/latest/api-v3/config/route/v3/route_components.proto#envoy-v3-api-field-config-route-v3-route-stat-prefix for statistics that are generated when this is configured.
     */
    @JsonProperty("statPrefix")
    public String getStatPrefix() {
        return statPrefix;
    }

    /**
     * The human readable prefix to use when emitting statistics for this route. The statistics are generated with prefix route.&lt;stat_prefix&gt;. This should be set for highly critical routes that one wishes to get "per-route" statistics on. This prefix is only for proxy-level statistics (envoy_&#42;) and not service-level (istio_&#42;) statistics. Refer to https://www.envoyproxy.io/docs/envoy/latest/api-v3/config/route/v3/route_components.proto#envoy-v3-api-field-config-route-v3-route-stat-prefix for statistics that are generated when this is configured.
     */
    @JsonProperty("statPrefix")
    public void setStatPrefix(String statPrefix) {
        this.statPrefix = statPrefix;
    }

    /**
     * HttpMatchRequest specifies a set of criteria to be met in order for the rule to be applied to the HTTP request. For example, the following restricts the rule to match only requests where the URL path starts with /ratings/v2/ and the request contains a custom `end-user` header with value `jason`.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - headers:<br><p> 	      end-user:<br><p> 	        exact: jason<br><p> 	    uri:<br><p> 	      prefix: "/ratings/v2/"<br><p> 	    ignoreUriCase: true<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> <br><p> ```<br><p> <br><p> HTTPMatchRequest CANNOT be empty. &#42;&#42;Note:&#42;&#42; 1. If a root VirtualService have matched any property (path, header etc.) by regex, delegate VirtualServices should not have any other matches on the same property. 2. If a delegate VirtualService have matched any property (path, header etc.) by regex, root VirtualServices should not have any other matches on the same property.
     */
    @JsonProperty("uri")
    public StringMatch getUri() {
        return uri;
    }

    /**
     * HttpMatchRequest specifies a set of criteria to be met in order for the rule to be applied to the HTTP request. For example, the following restricts the rule to match only requests where the URL path starts with /ratings/v2/ and the request contains a custom `end-user` header with value `jason`.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - headers:<br><p> 	      end-user:<br><p> 	        exact: jason<br><p> 	    uri:<br><p> 	      prefix: "/ratings/v2/"<br><p> 	    ignoreUriCase: true<br><p> 	  route:<br><p> 	  - destination:<br><p> 	      host: ratings.prod.svc.cluster.local<br><p> <br><p> ```<br><p> <br><p> HTTPMatchRequest CANNOT be empty. &#42;&#42;Note:&#42;&#42; 1. If a root VirtualService have matched any property (path, header etc.) by regex, delegate VirtualServices should not have any other matches on the same property. 2. If a delegate VirtualService have matched any property (path, header etc.) by regex, root VirtualServices should not have any other matches on the same property.
     */
    @JsonProperty("uri")
    public void setUri(StringMatch uri) {
        this.uri = uri;
    }

    /**
     * withoutHeader has the same syntax with the header, but has opposite meaning. If a header is matched with a matching rule among withoutHeader, the traffic becomes not matched one.
     */
    @JsonProperty("withoutHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, StringMatch> getWithoutHeaders() {
        return withoutHeaders;
    }

    /**
     * withoutHeader has the same syntax with the header, but has opposite meaning. If a header is matched with a matching rule among withoutHeader, the traffic becomes not matched one.
     */
    @JsonProperty("withoutHeaders")
    public void setWithoutHeaders(Map<String, StringMatch> withoutHeaders) {
        this.withoutHeaders = withoutHeaders;
    }

    @JsonIgnore
    public HTTPMatchRequestBuilder edit() {
        return new HTTPMatchRequestBuilder(this);
    }

    @JsonIgnore
    public HTTPMatchRequestBuilder toBuilder() {
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
