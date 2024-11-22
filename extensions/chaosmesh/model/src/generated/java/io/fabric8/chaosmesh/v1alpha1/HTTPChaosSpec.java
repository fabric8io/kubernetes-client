
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
public class HTTPChaosSpec implements Editable<HTTPChaosSpecBuilder> , KubernetesResource
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
    private Map<String, String> request_headers = new LinkedHashMap<>();
    @JsonProperty("response_headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> response_headers = new LinkedHashMap<>();
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
     * 
     */
    public HTTPChaosSpec() {
    }

    public HTTPChaosSpec(Boolean abort, Integer code, String delay, String duration, String method, String mode, PodHttpChaosPatchActions patch, String path, Integer port, String remoteCluster, PodHttpChaosReplaceActions replace, Map<String, String> request_headers, Map<String, String> response_headers, PodSelectorSpec selector, String target, PodHttpChaosTLS tls, String value) {
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
        this.request_headers = request_headers;
        this.response_headers = response_headers;
        this.selector = selector;
        this.target = target;
        this.tls = tls;
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
    public String getMode() {
        return mode;
    }

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

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    @JsonProperty("remoteCluster")
    public String getRemoteCluster() {
        return remoteCluster;
    }

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

    @JsonProperty("request_headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getRequest_headers() {
        return request_headers;
    }

    @JsonProperty("request_headers")
    public void setRequest_headers(Map<String, String> request_headers) {
        this.request_headers = request_headers;
    }

    @JsonProperty("response_headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getResponse_headers() {
        return response_headers;
    }

    @JsonProperty("response_headers")
    public void setResponse_headers(Map<String, String> response_headers) {
        this.response_headers = response_headers;
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
    public String getTarget() {
        return target;
    }

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

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

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
