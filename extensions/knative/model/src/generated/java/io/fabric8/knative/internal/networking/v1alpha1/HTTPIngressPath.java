
package io.fabric8.knative.internal.networking.v1alpha1;

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
    "appendHeaders",
    "headers",
    "path",
    "rewriteHost",
    "splits"
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
public class HTTPIngressPath implements Editable<HTTPIngressPathBuilder> , KubernetesResource
{

    @JsonProperty("appendHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> appendHeaders = new LinkedHashMap<String, String>();
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, HeaderMatch> headers = new LinkedHashMap<String, HeaderMatch>();
    @JsonProperty("path")
    private java.lang.String path;
    @JsonProperty("rewriteHost")
    private java.lang.String rewriteHost;
    @JsonProperty("splits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressBackendSplit> splits = new ArrayList<IngressBackendSplit>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HTTPIngressPath() {
    }

    public HTTPIngressPath(Map<String, String> appendHeaders, Map<String, HeaderMatch> headers, java.lang.String path, java.lang.String rewriteHost, List<IngressBackendSplit> splits) {
        super();
        this.appendHeaders = appendHeaders;
        this.headers = headers;
        this.path = path;
        this.rewriteHost = rewriteHost;
        this.splits = splits;
    }

    @JsonProperty("appendHeaders")
    public Map<String, String> getAppendHeaders() {
        return appendHeaders;
    }

    @JsonProperty("appendHeaders")
    public void setAppendHeaders(Map<String, String> appendHeaders) {
        this.appendHeaders = appendHeaders;
    }

    @JsonProperty("headers")
    public Map<String, HeaderMatch> getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(Map<String, HeaderMatch> headers) {
        this.headers = headers;
    }

    @JsonProperty("path")
    public java.lang.String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(java.lang.String path) {
        this.path = path;
    }

    @JsonProperty("rewriteHost")
    public java.lang.String getRewriteHost() {
        return rewriteHost;
    }

    @JsonProperty("rewriteHost")
    public void setRewriteHost(java.lang.String rewriteHost) {
        this.rewriteHost = rewriteHost;
    }

    @JsonProperty("splits")
    public List<IngressBackendSplit> getSplits() {
        return splits;
    }

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
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
