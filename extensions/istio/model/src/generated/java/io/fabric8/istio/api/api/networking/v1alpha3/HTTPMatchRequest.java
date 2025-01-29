
package io.fabric8.istio.api.api.networking.v1alpha3;

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

    @JsonProperty("authority")
    public StringMatch getAuthority() {
        return authority;
    }

    @JsonProperty("authority")
    public void setAuthority(StringMatch authority) {
        this.authority = authority;
    }

    @JsonProperty("gateways")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGateways() {
        return gateways;
    }

    @JsonProperty("gateways")
    public void setGateways(List<String> gateways) {
        this.gateways = gateways;
    }

    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, StringMatch> getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(Map<String, StringMatch> headers) {
        this.headers = headers;
    }

    @JsonProperty("ignoreUriCase")
    public Boolean getIgnoreUriCase() {
        return ignoreUriCase;
    }

    @JsonProperty("ignoreUriCase")
    public void setIgnoreUriCase(Boolean ignoreUriCase) {
        this.ignoreUriCase = ignoreUriCase;
    }

    @JsonProperty("method")
    public StringMatch getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(StringMatch method) {
        this.method = method;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("port")
    public Long getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(Long port) {
        this.port = port;
    }

    @JsonProperty("queryParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, StringMatch> getQueryParams() {
        return queryParams;
    }

    @JsonProperty("queryParams")
    public void setQueryParams(Map<String, StringMatch> queryParams) {
        this.queryParams = queryParams;
    }

    @JsonProperty("scheme")
    public StringMatch getScheme() {
        return scheme;
    }

    @JsonProperty("scheme")
    public void setScheme(StringMatch scheme) {
        this.scheme = scheme;
    }

    @JsonProperty("sourceLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getSourceLabels() {
        return sourceLabels;
    }

    @JsonProperty("sourceLabels")
    public void setSourceLabels(Map<String, String> sourceLabels) {
        this.sourceLabels = sourceLabels;
    }

    @JsonProperty("sourceNamespace")
    public String getSourceNamespace() {
        return sourceNamespace;
    }

    @JsonProperty("sourceNamespace")
    public void setSourceNamespace(String sourceNamespace) {
        this.sourceNamespace = sourceNamespace;
    }

    @JsonProperty("statPrefix")
    public String getStatPrefix() {
        return statPrefix;
    }

    @JsonProperty("statPrefix")
    public void setStatPrefix(String statPrefix) {
        this.statPrefix = statPrefix;
    }

    @JsonProperty("uri")
    public StringMatch getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(StringMatch uri) {
        this.uri = uri;
    }

    @JsonProperty("withoutHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, StringMatch> getWithoutHeaders() {
        return withoutHeaders;
    }

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
