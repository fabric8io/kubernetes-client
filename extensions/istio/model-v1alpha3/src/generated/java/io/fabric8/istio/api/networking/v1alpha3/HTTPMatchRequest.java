
package io.fabric8.istio.api.networking.v1alpha3;

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
public class HTTPMatchRequest implements Editable<HTTPMatchRequestBuilder> , KubernetesResource
{

    @JsonProperty("authority")
    private io.fabric8.istio.api.networking.v1alpha3.StringMatch authority;
    @JsonProperty("gateways")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> gateways = new ArrayList<java.lang.String>();
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch> headers = new LinkedHashMap<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch>();
    @JsonProperty("ignoreUriCase")
    private Boolean ignoreUriCase;
    @JsonProperty("method")
    private io.fabric8.istio.api.networking.v1alpha3.StringMatch method;
    @JsonProperty("name")
    private java.lang.String name;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("queryParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch> queryParams = new LinkedHashMap<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch>();
    @JsonProperty("scheme")
    private io.fabric8.istio.api.networking.v1alpha3.StringMatch scheme;
    @JsonProperty("sourceLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> sourceLabels = new LinkedHashMap<String, String>();
    @JsonProperty("sourceNamespace")
    private java.lang.String sourceNamespace;
    @JsonProperty("statPrefix")
    private java.lang.String statPrefix;
    @JsonProperty("uri")
    private io.fabric8.istio.api.networking.v1alpha3.StringMatch uri;
    @JsonProperty("withoutHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch> withoutHeaders = new LinkedHashMap<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HTTPMatchRequest() {
    }

    public HTTPMatchRequest(io.fabric8.istio.api.networking.v1alpha3.StringMatch authority, List<java.lang.String> gateways, Map<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch> headers, Boolean ignoreUriCase, io.fabric8.istio.api.networking.v1alpha3.StringMatch method, java.lang.String name, Integer port, Map<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch> queryParams, io.fabric8.istio.api.networking.v1alpha3.StringMatch scheme, Map<String, String> sourceLabels, java.lang.String sourceNamespace, java.lang.String statPrefix, io.fabric8.istio.api.networking.v1alpha3.StringMatch uri, Map<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch> withoutHeaders) {
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
    public io.fabric8.istio.api.networking.v1alpha3.StringMatch getAuthority() {
        return authority;
    }

    @JsonProperty("authority")
    public void setAuthority(io.fabric8.istio.api.networking.v1alpha3.StringMatch authority) {
        this.authority = authority;
    }

    @JsonProperty("gateways")
    public List<java.lang.String> getGateways() {
        return gateways;
    }

    @JsonProperty("gateways")
    public void setGateways(List<java.lang.String> gateways) {
        this.gateways = gateways;
    }

    @JsonProperty("headers")
    public Map<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch> getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(Map<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch> headers) {
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
    public io.fabric8.istio.api.networking.v1alpha3.StringMatch getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(io.fabric8.istio.api.networking.v1alpha3.StringMatch method) {
        this.method = method;
    }

    @JsonProperty("name")
    public java.lang.String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(java.lang.String name) {
        this.name = name;
    }

    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    @JsonProperty("queryParams")
    public Map<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch> getQueryParams() {
        return queryParams;
    }

    @JsonProperty("queryParams")
    public void setQueryParams(Map<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch> queryParams) {
        this.queryParams = queryParams;
    }

    @JsonProperty("scheme")
    public io.fabric8.istio.api.networking.v1alpha3.StringMatch getScheme() {
        return scheme;
    }

    @JsonProperty("scheme")
    public void setScheme(io.fabric8.istio.api.networking.v1alpha3.StringMatch scheme) {
        this.scheme = scheme;
    }

    @JsonProperty("sourceLabels")
    public Map<String, String> getSourceLabels() {
        return sourceLabels;
    }

    @JsonProperty("sourceLabels")
    public void setSourceLabels(Map<String, String> sourceLabels) {
        this.sourceLabels = sourceLabels;
    }

    @JsonProperty("sourceNamespace")
    public java.lang.String getSourceNamespace() {
        return sourceNamespace;
    }

    @JsonProperty("sourceNamespace")
    public void setSourceNamespace(java.lang.String sourceNamespace) {
        this.sourceNamespace = sourceNamespace;
    }

    @JsonProperty("statPrefix")
    public java.lang.String getStatPrefix() {
        return statPrefix;
    }

    @JsonProperty("statPrefix")
    public void setStatPrefix(java.lang.String statPrefix) {
        this.statPrefix = statPrefix;
    }

    @JsonProperty("uri")
    public io.fabric8.istio.api.networking.v1alpha3.StringMatch getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(io.fabric8.istio.api.networking.v1alpha3.StringMatch uri) {
        this.uri = uri;
    }

    @JsonProperty("withoutHeaders")
    public Map<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch> getWithoutHeaders() {
        return withoutHeaders;
    }

    @JsonProperty("withoutHeaders")
    public void setWithoutHeaders(Map<String, io.fabric8.istio.api.networking.v1alpha3.StringMatch> withoutHeaders) {
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
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
