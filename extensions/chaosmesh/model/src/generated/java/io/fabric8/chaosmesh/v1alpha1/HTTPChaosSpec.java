
package io.fabric8.chaosmesh.v1alpha1;

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
    "abort",
    "code",
    "delay",
    "duration",
    "method",
    "mode",
    "patch",
    "path",
    "port",
    "replace",
    "request_headers",
    "response_headers",
    "selector",
    "target",
    "value"
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
public class HTTPChaosSpec implements KubernetesResource
{

    @JsonProperty("abort")
    private Boolean abort;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("delay")
    private String delay;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("method")
    private String method;
    @JsonProperty("mode")
    private java.lang.String mode;
    @JsonProperty("patch")
    private PodHttpChaosPatchActions patch;
    @JsonProperty("path")
    private String path;
    @JsonProperty("port")
    private java.lang.Integer port;
    @JsonProperty("replace")
    private PodHttpChaosReplaceActions replace;
    @JsonProperty("request_headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> requestHeaders = new LinkedHashMap<String, String>();
    @JsonProperty("response_headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> responseHeaders = new LinkedHashMap<String, String>();
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("target")
    private java.lang.String target;
    @JsonProperty("value")
    private java.lang.String value;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HTTPChaosSpec() {
    }

    public HTTPChaosSpec(Boolean abort, Integer code, String delay, String duration, String method, java.lang.String mode, PodHttpChaosPatchActions patch, String path, java.lang.Integer port, PodHttpChaosReplaceActions replace, Map<String, String> requestHeaders, Map<String, String> responseHeaders, PodSelectorSpec selector, java.lang.String target, java.lang.String value) {
        super();
        this.abort = abort;
        this.code = code;
        this.delay = delay;
        this.duration = duration;
        this.method = method;
        this.mode = mode;
        this.patch = patch;
        this.path = path;
        this.port = port;
        this.replace = replace;
        this.requestHeaders = requestHeaders;
        this.responseHeaders = responseHeaders;
        this.selector = selector;
        this.target = target;
        this.value = value;
    }

    @JsonProperty("abort")
    public Boolean getAbort() {
        return abort;
    }

    @JsonProperty("abort")
    public void setAbort(Boolean abort) {
        this.abort = abort;
    }

    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
    }

    @JsonProperty("delay")
    public String getDelay() {
        return delay;
    }

    @JsonProperty("delay")
    public void setDelay(String delay) {
        this.delay = delay;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("mode")
    public java.lang.String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(java.lang.String mode) {
        this.mode = mode;
    }

    @JsonProperty("patch")
    public PodHttpChaosPatchActions getPatch() {
        return patch;
    }

    @JsonProperty("patch")
    public void setPatch(PodHttpChaosPatchActions patch) {
        this.patch = patch;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("port")
    public java.lang.Integer getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(java.lang.Integer port) {
        this.port = port;
    }

    @JsonProperty("replace")
    public PodHttpChaosReplaceActions getReplace() {
        return replace;
    }

    @JsonProperty("replace")
    public void setReplace(PodHttpChaosReplaceActions replace) {
        this.replace = replace;
    }

    @JsonProperty("request_headers")
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    @JsonProperty("request_headers")
    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    @JsonProperty("response_headers")
    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    @JsonProperty("response_headers")
    public void setResponseHeaders(Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    @JsonProperty("selector")
    public PodSelectorSpec getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(PodSelectorSpec selector) {
        this.selector = selector;
    }

    @JsonProperty("target")
    public java.lang.String getTarget() {
        return target;
    }

    @JsonProperty("target")
    public void setTarget(java.lang.String target) {
        this.target = target;
    }

    @JsonProperty("value")
    public java.lang.String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(java.lang.String value) {
        this.value = value;
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
