
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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

/**
 * HTTPRouteRetry defines retry configuration for an HTTPRoute.<br><p> <br><p> Implementations SHOULD retry on connection errors (disconnect, reset, timeout, TCP failure) if a retry stanza is configured.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
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
     * Attempts specifies the maximum number of times an individual request from the gateway to a backend should be retried.<br><p> <br><p> If the maximum number of retries has been attempted without a successful response from the backend, the Gateway MUST return an error.<br><p> <br><p> When this field is unspecified, the number of times to attempt to retry a backend request is implementation-specific.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("attempts")
    public Integer getAttempts() {
        return attempts;
    }

    /**
     * Attempts specifies the maximum number of times an individual request from the gateway to a backend should be retried.<br><p> <br><p> If the maximum number of retries has been attempted without a successful response from the backend, the Gateway MUST return an error.<br><p> <br><p> When this field is unspecified, the number of times to attempt to retry a backend request is implementation-specific.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("attempts")
    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    /**
     * Backoff specifies the minimum duration a Gateway should wait between retry attempts and is represented in Gateway API Duration formatting.<br><p> <br><p> For example, setting the `rules[].retry.backoff` field to the value `100ms` will cause a backend request to first be retried approximately 100 milliseconds after timing out or receiving a response code configured to be retryable.<br><p> <br><p> An implementation MAY use an exponential or alternative backoff strategy for subsequent retry attempts, MAY cap the maximum backoff duration to some amount greater than the specified minimum, and MAY add arbitrary jitter to stagger requests, as long as unsuccessful backend requests are not retried before the configured minimum duration.<br><p> <br><p> If a Request timeout (`rules[].timeouts.request`) is configured on the route, the entire duration of the initial request and any retry attempts MUST not exceed the Request timeout duration. If any retry attempts are still in progress when the Request timeout duration has been reached, these SHOULD be canceled if possible and the Gateway MUST immediately return a timeout error.<br><p> <br><p> If a BackendRequest timeout (`rules[].timeouts.backendRequest`) is configured on the route, any retry attempts which reach the configured BackendRequest timeout duration without a response SHOULD be canceled if possible and the Gateway should wait for at least the specified backoff duration before attempting to retry the backend request again.<br><p> <br><p> If a BackendRequest timeout is _not_ configured on the route, retry attempts MAY time out after an implementation default duration, or MAY remain pending until a configured Request timeout or implementation default duration for total request time is reached.<br><p> <br><p> When this field is unspecified, the time to wait between retry attempts is implementation-specific.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("backoff")
    public String getBackoff() {
        return backoff;
    }

    /**
     * Backoff specifies the minimum duration a Gateway should wait between retry attempts and is represented in Gateway API Duration formatting.<br><p> <br><p> For example, setting the `rules[].retry.backoff` field to the value `100ms` will cause a backend request to first be retried approximately 100 milliseconds after timing out or receiving a response code configured to be retryable.<br><p> <br><p> An implementation MAY use an exponential or alternative backoff strategy for subsequent retry attempts, MAY cap the maximum backoff duration to some amount greater than the specified minimum, and MAY add arbitrary jitter to stagger requests, as long as unsuccessful backend requests are not retried before the configured minimum duration.<br><p> <br><p> If a Request timeout (`rules[].timeouts.request`) is configured on the route, the entire duration of the initial request and any retry attempts MUST not exceed the Request timeout duration. If any retry attempts are still in progress when the Request timeout duration has been reached, these SHOULD be canceled if possible and the Gateway MUST immediately return a timeout error.<br><p> <br><p> If a BackendRequest timeout (`rules[].timeouts.backendRequest`) is configured on the route, any retry attempts which reach the configured BackendRequest timeout duration without a response SHOULD be canceled if possible and the Gateway should wait for at least the specified backoff duration before attempting to retry the backend request again.<br><p> <br><p> If a BackendRequest timeout is _not_ configured on the route, retry attempts MAY time out after an implementation default duration, or MAY remain pending until a configured Request timeout or implementation default duration for total request time is reached.<br><p> <br><p> When this field is unspecified, the time to wait between retry attempts is implementation-specific.<br><p> <br><p> Support: Extended
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
