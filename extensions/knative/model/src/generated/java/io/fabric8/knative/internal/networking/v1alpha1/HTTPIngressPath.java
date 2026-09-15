
package io.fabric8.knative.internal.networking.v1alpha1;

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

/**
 * HTTPIngressPath associates a path regex with a backend. Incoming URLs matching the path are forwarded to the backend.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "appendHeaders",
    "headers",
    "path",
    "rewriteHost",
    "splits"
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
public class HTTPIngressPath implements Editable<HTTPIngressPathBuilder>, KubernetesResource
{

    @JsonProperty("appendHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> appendHeaders = new LinkedHashMap<>();
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, HeaderMatch> headers = new LinkedHashMap<>();
    @JsonProperty("path")
    private String path;
    @JsonProperty("rewriteHost")
    private String rewriteHost;
    @JsonProperty("splits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressBackendSplit> splits = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPIngressPath() {
    }

    public HTTPIngressPath(Map<String, String> appendHeaders, Map<String, HeaderMatch> headers, String path, String rewriteHost, List<IngressBackendSplit> splits) {
        super();
        this.appendHeaders = appendHeaders;
        this.headers = headers;
        this.path = path;
        this.rewriteHost = rewriteHost;
        this.splits = splits;
    }

    /**
     * AppendHeaders allow specifying additional HTTP headers to add before forwarding a request to the destination service.<br><p> <br><p> NOTE: This differs from K8s Ingress which doesn't allow header appending.
     */
    @JsonProperty("appendHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAppendHeaders() {
        return appendHeaders;
    }

    /**
     * AppendHeaders allow specifying additional HTTP headers to add before forwarding a request to the destination service.<br><p> <br><p> NOTE: This differs from K8s Ingress which doesn't allow header appending.
     */
    @JsonProperty("appendHeaders")
    public void setAppendHeaders(Map<String, String> appendHeaders) {
        this.appendHeaders = appendHeaders;
    }

    /**
     * Headers defines header matching rules which is a map from a header name to HeaderMatch which specify a matching condition. When a request matched with all the header matching rules, the request is routed by the corresponding ingress rule. If it is empty, the headers are not used for matching
     */
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, HeaderMatch> getHeaders() {
        return headers;
    }

    /**
     * Headers defines header matching rules which is a map from a header name to HeaderMatch which specify a matching condition. When a request matched with all the header matching rules, the request is routed by the corresponding ingress rule. If it is empty, the headers are not used for matching
     */
    @JsonProperty("headers")
    public void setHeaders(Map<String, HeaderMatch> headers) {
        this.headers = headers;
    }

    /**
     * Path represents a literal prefix to which this rule should apply. Currently it can contain characters disallowed from the conventional "path" part of a URL as defined by RFC 3986. Paths must begin with a '/'. If unspecified, the path defaults to a catch all sending traffic to the backend.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path represents a literal prefix to which this rule should apply. Currently it can contain characters disallowed from the conventional "path" part of a URL as defined by RFC 3986. Paths must begin with a '/'. If unspecified, the path defaults to a catch all sending traffic to the backend.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * RewriteHost rewrites the incoming request's host header.<br><p> <br><p> This field is currently experimental and not supported by all Ingress implementations.
     */
    @JsonProperty("rewriteHost")
    public String getRewriteHost() {
        return rewriteHost;
    }

    /**
     * RewriteHost rewrites the incoming request's host header.<br><p> <br><p> This field is currently experimental and not supported by all Ingress implementations.
     */
    @JsonProperty("rewriteHost")
    public void setRewriteHost(String rewriteHost) {
        this.rewriteHost = rewriteHost;
    }

    /**
     * Splits defines the referenced service endpoints to which the traffic will be forwarded to.
     */
    @JsonProperty("splits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IngressBackendSplit> getSplits() {
        return splits;
    }

    /**
     * Splits defines the referenced service endpoints to which the traffic will be forwarded to.
     */
    @JsonProperty("splits")
    public void setSplits(List<IngressBackendSplit> splits) {
        this.splits = splits;
    }

    @JsonIgnore
    public HTTPIngressPathBuilder edit() {
        return new HTTPIngressPathBuilder(this);
    }

    @JsonIgnore
    public HTTPIngressPathBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HTTPIngressPath)) {
            return false;
        }
        HTTPIngressPath other = (HTTPIngressPath) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$appendHeaders = this.getAppendHeaders();
        Object other$appendHeaders = other.getAppendHeaders();
        if (this$appendHeaders == null ? other$appendHeaders != null : !this$appendHeaders.equals(other$appendHeaders)) {
            return false;
        }
        Object this$headers = this.getHeaders();
        Object other$headers = other.getHeaders();
        if (this$headers == null ? other$headers != null : !this$headers.equals(other$headers)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$rewriteHost = this.getRewriteHost();
        Object other$rewriteHost = other.getRewriteHost();
        if (this$rewriteHost == null ? other$rewriteHost != null : !this$rewriteHost.equals(other$rewriteHost)) {
            return false;
        }
        Object this$splits = this.getSplits();
        Object other$splits = other.getSplits();
        if (this$splits == null ? other$splits != null : !this$splits.equals(other$splits)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof HTTPIngressPath;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $appendHeaders = this.getAppendHeaders();
        result = result * prime + ($appendHeaders == null ? 43 : $appendHeaders.hashCode());
        Object $headers = this.getHeaders();
        result = result * prime + ($headers == null ? 43 : $headers.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $rewriteHost = this.getRewriteHost();
        result = result * prime + ($rewriteHost == null ? 43 : $rewriteHost.hashCode());
        Object $splits = this.getSplits();
        result = result * prime + ($splits == null ? 43 : $splits.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPIngressPath(" + "appendHeaders=" + this.getAppendHeaders() + ", headers=" + this.getHeaders() + ", path=" + this.getPath() + ", rewriteHost=" + this.getRewriteHost() + ", splits=" + this.getSplits() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
