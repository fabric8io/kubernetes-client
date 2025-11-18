
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
 * HTTPRouteTimeouts defines timeouts that can be configured for an HTTPRoute. Timeout values are represented with Gateway API Duration formatting.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backendRequest",
    "request"
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
public class HTTPRouteTimeouts implements Editable<HTTPRouteTimeoutsBuilder>, KubernetesResource
{

    @JsonProperty("backendRequest")
    private String backendRequest;
    @JsonProperty("request")
    private String request;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRouteTimeouts() {
    }

    public HTTPRouteTimeouts(String backendRequest, String request) {
        super();
        this.backendRequest = backendRequest;
        this.request = request;
    }

    /**
     * BackendRequest specifies a timeout for an individual request from the gateway to a backend. This covers the time from when the request first starts being sent from the gateway to when the full response has been received from the backend.<br><p> <br><p> Setting a timeout to the zero duration (e.g. "0s") SHOULD disable the timeout completely. Implementations that cannot completely disable the timeout MUST instead interpret the zero duration as the longest possible value to which the timeout can be set.<br><p> <br><p> An entire client HTTP transaction with a gateway, covered by the Request timeout, may result in more than one call from the gateway to the destination backend, for example, if automatic retries are supported.<br><p> <br><p> The value of BackendRequest must be a Gateway API Duration string as defined by GEP-2257.  When this field is unspecified, its behavior is implementation-specific; when specified, the value of BackendRequest must be no more than the value of the Request timeout (since the Request timeout encompasses the BackendRequest timeout).<br><p> <br><p> Support: Extended
     */
    @JsonProperty("backendRequest")
    public String getBackendRequest() {
        return backendRequest;
    }

    /**
     * BackendRequest specifies a timeout for an individual request from the gateway to a backend. This covers the time from when the request first starts being sent from the gateway to when the full response has been received from the backend.<br><p> <br><p> Setting a timeout to the zero duration (e.g. "0s") SHOULD disable the timeout completely. Implementations that cannot completely disable the timeout MUST instead interpret the zero duration as the longest possible value to which the timeout can be set.<br><p> <br><p> An entire client HTTP transaction with a gateway, covered by the Request timeout, may result in more than one call from the gateway to the destination backend, for example, if automatic retries are supported.<br><p> <br><p> The value of BackendRequest must be a Gateway API Duration string as defined by GEP-2257.  When this field is unspecified, its behavior is implementation-specific; when specified, the value of BackendRequest must be no more than the value of the Request timeout (since the Request timeout encompasses the BackendRequest timeout).<br><p> <br><p> Support: Extended
     */
    @JsonProperty("backendRequest")
    public void setBackendRequest(String backendRequest) {
        this.backendRequest = backendRequest;
    }

    /**
     * Request specifies the maximum duration for a gateway to respond to an HTTP request. If the gateway has not been able to respond before this deadline is met, the gateway MUST return a timeout error.<br><p> <br><p> For example, setting the `rules.timeouts.request` field to the value `10s` in an `HTTPRoute` will cause a timeout if a client request is taking longer than 10 seconds to complete.<br><p> <br><p> Setting a timeout to the zero duration (e.g. "0s") SHOULD disable the timeout completely. Implementations that cannot completely disable the timeout MUST instead interpret the zero duration as the longest possible value to which the timeout can be set.<br><p> <br><p> This timeout is intended to cover as close to the whole request-response transaction as possible although an implementation MAY choose to start the timeout after the entire request stream has been received instead of immediately after the transaction is initiated by the client.<br><p> <br><p> The value of Request is a Gateway API Duration string as defined by GEP-2257. When this field is unspecified, request timeout behavior is implementation-specific.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("request")
    public String getRequest() {
        return request;
    }

    /**
     * Request specifies the maximum duration for a gateway to respond to an HTTP request. If the gateway has not been able to respond before this deadline is met, the gateway MUST return a timeout error.<br><p> <br><p> For example, setting the `rules.timeouts.request` field to the value `10s` in an `HTTPRoute` will cause a timeout if a client request is taking longer than 10 seconds to complete.<br><p> <br><p> Setting a timeout to the zero duration (e.g. "0s") SHOULD disable the timeout completely. Implementations that cannot completely disable the timeout MUST instead interpret the zero duration as the longest possible value to which the timeout can be set.<br><p> <br><p> This timeout is intended to cover as close to the whole request-response transaction as possible although an implementation MAY choose to start the timeout after the entire request stream has been received instead of immediately after the transaction is initiated by the client.<br><p> <br><p> The value of Request is a Gateway API Duration string as defined by GEP-2257. When this field is unspecified, request timeout behavior is implementation-specific.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("request")
    public void setRequest(String request) {
        this.request = request;
    }

    @JsonIgnore
    public HTTPRouteTimeoutsBuilder edit() {
        return new HTTPRouteTimeoutsBuilder(this);
    }

    @JsonIgnore
    public HTTPRouteTimeoutsBuilder toBuilder() {
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
