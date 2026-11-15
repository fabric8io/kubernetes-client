
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * HTTPRouteRetry defines retry configuration for an HTTPRoute.<br><p> <br><p> Implementations SHOULD retry when a retry stanza is configured and the connection could not be established (e.g., connect timeout, connection refused, TLS handshake failure), or the backend explicitly rejected the request before processing it (e.g., HTTP/2 REFUSED_STREAM, gRPC UNAVAILABLE)<br><p> <br><p> Implementations SHOULD NOT retry by default on failures where the request may have been processed (e.g., a connection reset after the request was sent). Implementations that do retry on such conditions MUST clearly document this behavior, as it is unsafe for non-idempotent requests.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attempts",
    "backoff",
    "codes"
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
public class HTTPRouteRetry implements Editable<HTTPRouteRetryBuilder>, KubernetesResource
{

    @JsonProperty("attempts")
    private Integer attempts;
    @JsonProperty("backoff")
    private String backoff;
    @JsonProperty("codes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Integer> codes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRouteRetry() {
    }

    public HTTPRouteRetry(Integer attempts, String backoff, List<Integer> codes) {
        super();
        this.attempts = attempts;
        this.backoff = backoff;
        this.codes = codes;
    }

    /**
     * Attempts specifies the maximum number of times an individual request from the Gateway to a backend should be retried in addition to the initial request.<br><p> <br><p> If the maximum number of retries has been attempted without a successful response from the backend, the Gateway MUST return an error.<br><p> <br><p> An explicit zero value MUST disable retries.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("attempts")
    public Integer getAttempts() {
        return attempts;
    }

    /**
     * Attempts specifies the maximum number of times an individual request from the Gateway to a backend should be retried in addition to the initial request.<br><p> <br><p> If the maximum number of retries has been attempted without a successful response from the backend, the Gateway MUST return an error.<br><p> <br><p> An explicit zero value MUST disable retries.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("attempts")
    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    /**
     * Backoff specifies the base interval for a backoff strategy between retry attempts and is represented in Gateway API Duration formatting. The duration a Gateway waits before a retry attempt is determined by the base interval and the implementation's retry strategy.<br><p> <br><p> Implementations MAY add random jitter and MAY cap the delay at an implementation-defined maximum, which SHOULD NOT be less than the base interval. The precise backoff curve and jitter calculation are implementation-specific and not exposed in the Gateway API specification. Implementations typically apply exponential backoff with jitter to mitigate thundering-herd issues.<br><p> <br><p> If a Request timeout (`rules[].timeouts.request`) is configured on the route, the entire duration of the initial request and any retry attempts MUST not exceed the Request timeout duration. If any retry attempts are still in progress when the Request timeout duration has been reached, these SHOULD be canceled if possible and the Gateway MUST immediately return a timeout error.<br><p> <br><p> If a BackendRequest timeout (`rules[].timeouts.backendRequest`) is configured on the route, any retry attempts which reach the configured BackendRequest timeout duration without a response SHOULD be canceled if possible and the Gateway SHOULD schedule the next retry attempt according to the configured backoff.<br><p> <br><p> If a BackendRequest timeout is _not_ configured on the route, retry attempts MAY time out after an implementation default duration, or MAY remain pending until a configured Request timeout or implementation default duration for total request time is reached.<br><p> <br><p> When this field is unspecified, the backoff strategy and base interval are implementation-specific.<br><p> <br><p> Implementations which retry immediately with no backoff MUST NOT advertise support for this field and MUST set the Accepted Condition for the Route to `status: False` with a Reason of `UnsupportedValue` when this field is set.<br><p> <br><p> Support: Implementation-specific
     */
    @JsonProperty("backoff")
    public String getBackoff() {
        return backoff;
    }

    /**
     * Backoff specifies the base interval for a backoff strategy between retry attempts and is represented in Gateway API Duration formatting. The duration a Gateway waits before a retry attempt is determined by the base interval and the implementation's retry strategy.<br><p> <br><p> Implementations MAY add random jitter and MAY cap the delay at an implementation-defined maximum, which SHOULD NOT be less than the base interval. The precise backoff curve and jitter calculation are implementation-specific and not exposed in the Gateway API specification. Implementations typically apply exponential backoff with jitter to mitigate thundering-herd issues.<br><p> <br><p> If a Request timeout (`rules[].timeouts.request`) is configured on the route, the entire duration of the initial request and any retry attempts MUST not exceed the Request timeout duration. If any retry attempts are still in progress when the Request timeout duration has been reached, these SHOULD be canceled if possible and the Gateway MUST immediately return a timeout error.<br><p> <br><p> If a BackendRequest timeout (`rules[].timeouts.backendRequest`) is configured on the route, any retry attempts which reach the configured BackendRequest timeout duration without a response SHOULD be canceled if possible and the Gateway SHOULD schedule the next retry attempt according to the configured backoff.<br><p> <br><p> If a BackendRequest timeout is _not_ configured on the route, retry attempts MAY time out after an implementation default duration, or MAY remain pending until a configured Request timeout or implementation default duration for total request time is reached.<br><p> <br><p> When this field is unspecified, the backoff strategy and base interval are implementation-specific.<br><p> <br><p> Implementations which retry immediately with no backoff MUST NOT advertise support for this field and MUST set the Accepted Condition for the Route to `status: False` with a Reason of `UnsupportedValue` when this field is set.<br><p> <br><p> Support: Implementation-specific
     */
    @JsonProperty("backoff")
    public void setBackoff(String backoff) {
        this.backoff = backoff;
    }

    /**
     * Codes defines the HTTP response status codes for which a backend request should be retried.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("codes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Integer> getCodes() {
        return codes;
    }

    /**
     * Codes defines the HTTP response status codes for which a backend request should be retried.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("codes")
    public void setCodes(List<Integer> codes) {
        this.codes = codes;
    }

    @JsonIgnore
    public HTTPRouteRetryBuilder edit() {
        return new HTTPRouteRetryBuilder(this);
    }

    @JsonIgnore
    public HTTPRouteRetryBuilder toBuilder() {
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
