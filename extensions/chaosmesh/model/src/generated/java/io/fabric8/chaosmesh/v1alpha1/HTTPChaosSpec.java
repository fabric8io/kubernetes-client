
package io.fabric8.chaosmesh.v1alpha1;

import java.util.LinkedHashMap;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "abort",
    "code",
    "delay",
    "duration",
    "method",
    "mode",
    "patch",
    "path",
    "port",
    "remoteCluster",
    "replace",
    "request_headers",
    "response_headers",
    "selector",
    "target",
    "tls",
    "value"
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
public class HTTPChaosSpec implements Editable<HTTPChaosSpecBuilder>, KubernetesResource
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
    private String mode;
    @JsonProperty("patch")
    private PodHttpChaosPatchActions patch;
    @JsonProperty("path")
    private String path;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("remoteCluster")
    private String remoteCluster;
    @JsonProperty("replace")
    private PodHttpChaosReplaceActions replace;
    @JsonProperty("request_headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> requestHeaders = new LinkedHashMap<>();
    @JsonProperty("response_headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> responseHeaders = new LinkedHashMap<>();
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("target")
    private String target;
    @JsonProperty("tls")
    private PodHttpChaosTLS tls;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPChaosSpec() {
    }

    public HTTPChaosSpec(Boolean abort, Integer code, String delay, String duration, String method, String mode, PodHttpChaosPatchActions patch, String path, Integer port, String remoteCluster, PodHttpChaosReplaceActions replace, Map<String, String> requestHeaders, Map<String, String> responseHeaders, PodSelectorSpec selector, String target, PodHttpChaosTLS tls, String value) {
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
        this.remoteCluster = remoteCluster;
        this.replace = replace;
        this.requestHeaders = requestHeaders;
        this.responseHeaders = responseHeaders;
        this.selector = selector;
        this.target = target;
        this.tls = tls;
        this.value = value;
    }

    /**
     * Abort is a rule to abort a http session.
     */
    @JsonProperty("abort")
    public Boolean getAbort() {
        return abort;
    }

    /**
     * Abort is a rule to abort a http session.
     */
    @JsonProperty("abort")
    public void setAbort(Boolean abort) {
        this.abort = abort;
    }

    /**
     * Code is a rule to select target by http status code in response.
     */
    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    /**
     * Code is a rule to select target by http status code in response.
     */
    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Delay represents the delay of the target request/response. A duration string is a possibly unsigned sequence of decimal numbers, each with optional fraction and a unit suffix, such as "300ms", "2h45m". Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
     */
    @JsonProperty("delay")
    public String getDelay() {
        return delay;
    }

    /**
     * Delay represents the delay of the target request/response. A duration string is a possibly unsigned sequence of decimal numbers, each with optional fraction and a unit suffix, such as "300ms", "2h45m". Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
     */
    @JsonProperty("delay")
    public void setDelay(String delay) {
        this.delay = delay;
    }

    /**
     * Duration represents the duration of the chaos action.
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * Duration represents the duration of the chaos action.
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Method is a rule to select target by http method in request.
     */
    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    /**
     * Method is a rule to select target by http method in request.
     */
    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
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

    /**
     * Path is a rule to select target by uri path in http request.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path is a rule to select target by uri path in http request.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Port represents the target port to be proxy of.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * Port represents the target port to be proxy of.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public String getRemoteCluster() {
        return remoteCluster;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public void setRemoteCluster(String remoteCluster) {
        this.remoteCluster = remoteCluster;
    }

    @JsonProperty("replace")
    public PodHttpChaosReplaceActions getReplace() {
        return replace;
    }

    @JsonProperty("replace")
    public void setReplace(PodHttpChaosReplaceActions replace) {
        this.replace = replace;
    }

    /**
     * RequestHeaders is a rule to select target by http headers in request. The key-value pairs represent header name and header value pairs.
     */
    @JsonProperty("request_headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    /**
     * RequestHeaders is a rule to select target by http headers in request. The key-value pairs represent header name and header value pairs.
     */
    @JsonProperty("request_headers")
    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    /**
     * ResponseHeaders is a rule to select target by http headers in response. The key-value pairs represent header name and header value pairs.
     */
    @JsonProperty("response_headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    /**
     * ResponseHeaders is a rule to select target by http headers in response. The key-value pairs represent header name and header value pairs.
     */
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

    /**
     * Target is the object to be selected and injected.
     */
    @JsonProperty("target")
    public String getTarget() {
        return target;
    }

    /**
     * Target is the object to be selected and injected.
     */
    @JsonProperty("target")
    public void setTarget(String target) {
        this.target = target;
    }

    @JsonProperty("tls")
    public PodHttpChaosTLS getTls() {
        return tls;
    }

    @JsonProperty("tls")
    public void setTls(PodHttpChaosTLS tls) {
        this.tls = tls;
    }

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of pods to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of pods to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public HTTPChaosSpecBuilder edit() {
        return new HTTPChaosSpecBuilder(this);
    }

    @JsonIgnore
    public HTTPChaosSpecBuilder toBuilder() {
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
