
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
 * ListenerFilters is the container for pre-routing filter lists on a Listener.<br><p> <br><p> Today only the request phase (Requests) is defined. In the future a connection-oriented phase (Connection) may be added.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "requests"
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
public class ListenerFilters implements Editable<ListenerFiltersBuilder>, KubernetesResource
{

    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ListenerFilter> requests = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ListenerFilters() {
    }

    public ListenerFilters(List<ListenerFilter> requests) {
        super();
        this.requests = requests;
    }

    /**
     * Implementations MUST execute the filters in the exact order they appear here and MUST NOT reorder them. If an implementation can not implement the filters in the order they are specified, the implementation MUST set the "Accepted" Listener condition to "false" with the "InvalidListenerFilterOrder" reason.<br><p> <br><p> Requests only apply to connections with a visible HTTP stream and metadata (Protocol=HTTP, or Protocol=HTTPS with TLS terminated at the Gateway).<br><p> <br><p> Requests may mutate inputs that route matching consumes (path, request headers, method, computed metadata), with the explicit exception of the `Host` and `:authority` headers. If a ListenerFilter attempts to modify either header, implementations MUST NOT allow that modification to take effect. Implementations SHOULD satisfy this by ignoring the mutation and continuing to process the request with the original value; they MAY instead fail the request with a 5xx response. Implementations MUST evaluate route matching exactly once after the last ListenerFilter has run.<br><p> <br><p> Requests MUST NOT be interpreted as changing which Listener handles the request. Listener selection is decided from inputs the client committed to before any pre-routing filter runs: TLS SNI (for HTTPS) or the request's initial Host header (for HTTP). Because filters cannot modify Host or :authority, the input to cleartext-HTTP Listener selection cannot change; Listener selection therefore does not need to be re-evaluated after pre-routing filters run, and MUST NOT be.
     */
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ListenerFilter> getRequests() {
        return requests;
    }

    /**
     * Implementations MUST execute the filters in the exact order they appear here and MUST NOT reorder them. If an implementation can not implement the filters in the order they are specified, the implementation MUST set the "Accepted" Listener condition to "false" with the "InvalidListenerFilterOrder" reason.<br><p> <br><p> Requests only apply to connections with a visible HTTP stream and metadata (Protocol=HTTP, or Protocol=HTTPS with TLS terminated at the Gateway).<br><p> <br><p> Requests may mutate inputs that route matching consumes (path, request headers, method, computed metadata), with the explicit exception of the `Host` and `:authority` headers. If a ListenerFilter attempts to modify either header, implementations MUST NOT allow that modification to take effect. Implementations SHOULD satisfy this by ignoring the mutation and continuing to process the request with the original value; they MAY instead fail the request with a 5xx response. Implementations MUST evaluate route matching exactly once after the last ListenerFilter has run.<br><p> <br><p> Requests MUST NOT be interpreted as changing which Listener handles the request. Listener selection is decided from inputs the client committed to before any pre-routing filter runs: TLS SNI (for HTTPS) or the request's initial Host header (for HTTP). Because filters cannot modify Host or :authority, the input to cleartext-HTTP Listener selection cannot change; Listener selection therefore does not need to be re-evaluated after pre-routing filters run, and MUST NOT be.
     */
    @JsonProperty("requests")
    public void setRequests(List<ListenerFilter> requests) {
        this.requests = requests;
    }

    @JsonIgnore
    public ListenerFiltersBuilder edit() {
        return new ListenerFiltersBuilder(this);
    }

    @JsonIgnore
    public ListenerFiltersBuilder toBuilder() {
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
