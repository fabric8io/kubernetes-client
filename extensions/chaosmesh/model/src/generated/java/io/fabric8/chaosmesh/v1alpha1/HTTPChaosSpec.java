
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HTTPChaosSpec)) {
            return false;
        }
        HTTPChaosSpec other = (HTTPChaosSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$abort = this.getAbort();
        Object other$abort = other.getAbort();
        if (this$abort == null ? other$abort != null : !this$abort.equals(other$abort)) {
            return false;
        }
        Object this$code = this.getCode();
        Object other$code = other.getCode();
        if (this$code == null ? other$code != null : !this$code.equals(other$code)) {
            return false;
        }
        Object this$delay = this.getDelay();
        Object other$delay = other.getDelay();
        if (this$delay == null ? other$delay != null : !this$delay.equals(other$delay)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        Object this$method = this.getMethod();
        Object other$method = other.getMethod();
        if (this$method == null ? other$method != null : !this$method.equals(other$method)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$patch = this.getPatch();
        Object other$patch = other.getPatch();
        if (this$patch == null ? other$patch != null : !this$patch.equals(other$patch)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$remoteCluster = this.getRemoteCluster();
        Object other$remoteCluster = other.getRemoteCluster();
        if (this$remoteCluster == null ? other$remoteCluster != null : !this$remoteCluster.equals(other$remoteCluster)) {
            return false;
        }
        Object this$replace = this.getReplace();
        Object other$replace = other.getReplace();
        if (this$replace == null ? other$replace != null : !this$replace.equals(other$replace)) {
            return false;
        }
        Object this$requestHeaders = this.getRequestHeaders();
        Object other$requestHeaders = other.getRequestHeaders();
        if (this$requestHeaders == null ? other$requestHeaders != null : !this$requestHeaders.equals(other$requestHeaders)) {
            return false;
        }
        Object this$responseHeaders = this.getResponseHeaders();
        Object other$responseHeaders = other.getResponseHeaders();
        if (this$responseHeaders == null ? other$responseHeaders != null : !this$responseHeaders.equals(other$responseHeaders)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$target = this.getTarget();
        Object other$target = other.getTarget();
        if (this$target == null ? other$target != null : !this$target.equals(other$target)) {
            return false;
        }
        Object this$tls = this.getTls();
        Object other$tls = other.getTls();
        if (this$tls == null ? other$tls != null : !this$tls.equals(other$tls)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
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
        return other instanceof HTTPChaosSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $abort = this.getAbort();
        result = result * prime + ($abort == null ? 43 : $abort.hashCode());
        Object $code = this.getCode();
        result = result * prime + ($code == null ? 43 : $code.hashCode());
        Object $delay = this.getDelay();
        result = result * prime + ($delay == null ? 43 : $delay.hashCode());
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $method = this.getMethod();
        result = result * prime + ($method == null ? 43 : $method.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $patch = this.getPatch();
        result = result * prime + ($patch == null ? 43 : $patch.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $remoteCluster = this.getRemoteCluster();
        result = result * prime + ($remoteCluster == null ? 43 : $remoteCluster.hashCode());
        Object $replace = this.getReplace();
        result = result * prime + ($replace == null ? 43 : $replace.hashCode());
        Object $requestHeaders = this.getRequestHeaders();
        result = result * prime + ($requestHeaders == null ? 43 : $requestHeaders.hashCode());
        Object $responseHeaders = this.getResponseHeaders();
        result = result * prime + ($responseHeaders == null ? 43 : $responseHeaders.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $target = this.getTarget();
        result = result * prime + ($target == null ? 43 : $target.hashCode());
        Object $tls = this.getTls();
        result = result * prime + ($tls == null ? 43 : $tls.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPChaosSpec(" + "abort=" + this.getAbort() + ", code=" + this.getCode() + ", delay=" + this.getDelay() + ", duration=" + this.getDuration() + ", method=" + this.getMethod() + ", mode=" + this.getMode() + ", patch=" + this.getPatch() + ", path=" + this.getPath() + ", port=" + this.getPort() + ", remoteCluster=" + this.getRemoteCluster() + ", replace=" + this.getReplace() + ", requestHeaders=" + this.getRequestHeaders() + ", responseHeaders=" + this.getResponseHeaders() + ", selector=" + this.getSelector() + ", target=" + this.getTarget() + ", tls=" + this.getTls() + ", value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
