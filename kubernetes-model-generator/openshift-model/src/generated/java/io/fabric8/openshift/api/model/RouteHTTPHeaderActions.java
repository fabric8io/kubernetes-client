
package io.fabric8.openshift.api.model;

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

/**
 * RouteHTTPHeaderActions defines configuration for actions on HTTP request and response headers.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request",
    "response"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RouteHTTPHeaderActions implements Editable<RouteHTTPHeaderActionsBuilder>, KubernetesResource
{

    @JsonProperty("request")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RouteHTTPHeader> request = new ArrayList<>();
    @JsonProperty("response")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RouteHTTPHeader> response = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RouteHTTPHeaderActions() {
    }

    public RouteHTTPHeaderActions(List<RouteHTTPHeader> request, List<RouteHTTPHeader> response) {
        super();
        this.request = request;
        this.response = response;
    }

    /**
     * request is a list of HTTP request headers to modify. Currently, actions may define to either `Set` or `Delete` headers values. Actions defined here will modify the request headers of all requests made through a route. These actions are applied to a specific Route defined within a cluster i.e. connections made through a route. Currently, actions may define to either `Set` or `Delete` headers values. Route actions will be executed after IngressController actions for request headers. Actions are applied in sequence as defined in this list. A maximum of 20 request header actions may be configured. You can use this field to specify HTTP request headers that should be set or deleted when forwarding connections from the client to your application. Sample fetchers allowed are "req.hdr" and "ssl_c_der". Converters allowed are "lower" and "base64". Example header values: "%[req.hdr(X-target),lower]", "%{+Q}[ssl_c_der,base64]". Any request header configuration applied directly via a Route resource using this API will override header configuration for a header of the same name applied via spec.httpHeaders.actions on the IngressController or route annotation. Note: This field cannot be used if your route uses TLS passthrough.
     */
    @JsonProperty("request")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RouteHTTPHeader> getRequest() {
        return request;
    }

    /**
     * request is a list of HTTP request headers to modify. Currently, actions may define to either `Set` or `Delete` headers values. Actions defined here will modify the request headers of all requests made through a route. These actions are applied to a specific Route defined within a cluster i.e. connections made through a route. Currently, actions may define to either `Set` or `Delete` headers values. Route actions will be executed after IngressController actions for request headers. Actions are applied in sequence as defined in this list. A maximum of 20 request header actions may be configured. You can use this field to specify HTTP request headers that should be set or deleted when forwarding connections from the client to your application. Sample fetchers allowed are "req.hdr" and "ssl_c_der". Converters allowed are "lower" and "base64". Example header values: "%[req.hdr(X-target),lower]", "%{+Q}[ssl_c_der,base64]". Any request header configuration applied directly via a Route resource using this API will override header configuration for a header of the same name applied via spec.httpHeaders.actions on the IngressController or route annotation. Note: This field cannot be used if your route uses TLS passthrough.
     */
    @JsonProperty("request")
    public void setRequest(List<RouteHTTPHeader> request) {
        this.request = request;
    }

    /**
     * response is a list of HTTP response headers to modify. Currently, actions may define to either `Set` or `Delete` headers values. Actions defined here will modify the response headers of all requests made through a route. These actions are applied to a specific Route defined within a cluster i.e. connections made through a route. Route actions will be executed before IngressController actions for response headers. Actions are applied in sequence as defined in this list. A maximum of 20 response header actions may be configured. You can use this field to specify HTTP response headers that should be set or deleted when forwarding responses from your application to the client. Sample fetchers allowed are "res.hdr" and "ssl_c_der". Converters allowed are "lower" and "base64". Example header values: "%[res.hdr(X-target),lower]", "%{+Q}[ssl_c_der,base64]". Note: This field cannot be used if your route uses TLS passthrough.
     */
    @JsonProperty("response")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RouteHTTPHeader> getResponse() {
        return response;
    }

    /**
     * response is a list of HTTP response headers to modify. Currently, actions may define to either `Set` or `Delete` headers values. Actions defined here will modify the response headers of all requests made through a route. These actions are applied to a specific Route defined within a cluster i.e. connections made through a route. Route actions will be executed before IngressController actions for response headers. Actions are applied in sequence as defined in this list. A maximum of 20 response header actions may be configured. You can use this field to specify HTTP response headers that should be set or deleted when forwarding responses from your application to the client. Sample fetchers allowed are "res.hdr" and "ssl_c_der". Converters allowed are "lower" and "base64". Example header values: "%[res.hdr(X-target),lower]", "%{+Q}[ssl_c_der,base64]". Note: This field cannot be used if your route uses TLS passthrough.
     */
    @JsonProperty("response")
    public void setResponse(List<RouteHTTPHeader> response) {
        this.response = response;
    }

    @JsonIgnore
    public RouteHTTPHeaderActionsBuilder edit() {
        return new RouteHTTPHeaderActionsBuilder(this);
    }

    @JsonIgnore
    public RouteHTTPHeaderActionsBuilder toBuilder() {
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
