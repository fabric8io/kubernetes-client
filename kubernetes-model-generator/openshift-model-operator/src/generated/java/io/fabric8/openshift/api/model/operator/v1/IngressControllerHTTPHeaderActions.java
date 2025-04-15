
package io.fabric8.openshift.api.model.operator.v1;

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

/**
 * IngressControllerHTTPHeaderActions defines configuration for actions on HTTP request and response headers.
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class IngressControllerHTTPHeaderActions implements Editable<IngressControllerHTTPHeaderActionsBuilder>, KubernetesResource
{

    @JsonProperty("request")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressControllerHTTPHeader> request = new ArrayList<>();
    @JsonProperty("response")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressControllerHTTPHeader> response = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressControllerHTTPHeaderActions() {
    }

    public IngressControllerHTTPHeaderActions(List<IngressControllerHTTPHeader> request, List<IngressControllerHTTPHeader> response) {
        super();
        this.request = request;
        this.response = response;
    }

    /**
     * request is a list of HTTP request headers to modify. Actions defined here will modify the request headers of all requests passing through an ingress controller. These actions are applied to all Routes i.e. for all connections handled by the ingress controller defined within a cluster. IngressController actions for request headers will be executed before Route actions. Currently, actions may define to either `Set` or `Delete` headers values. Actions are applied in sequence as defined in this list. A maximum of 20 request header actions may be configured. Sample fetchers allowed are "req.hdr" and "ssl_c_der". Converters allowed are "lower" and "base64". Example header values: "%[req.hdr(X-target),lower]", "%{+Q}[ssl_c_der,base64]".
     */
    @JsonProperty("request")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IngressControllerHTTPHeader> getRequest() {
        return request;
    }

    /**
     * request is a list of HTTP request headers to modify. Actions defined here will modify the request headers of all requests passing through an ingress controller. These actions are applied to all Routes i.e. for all connections handled by the ingress controller defined within a cluster. IngressController actions for request headers will be executed before Route actions. Currently, actions may define to either `Set` or `Delete` headers values. Actions are applied in sequence as defined in this list. A maximum of 20 request header actions may be configured. Sample fetchers allowed are "req.hdr" and "ssl_c_der". Converters allowed are "lower" and "base64". Example header values: "%[req.hdr(X-target),lower]", "%{+Q}[ssl_c_der,base64]".
     */
    @JsonProperty("request")
    public void setRequest(List<IngressControllerHTTPHeader> request) {
        this.request = request;
    }

    /**
     * response is a list of HTTP response headers to modify. Actions defined here will modify the response headers of all requests passing through an ingress controller. These actions are applied to all Routes i.e. for all connections handled by the ingress controller defined within a cluster. IngressController actions for response headers will be executed after Route actions. Currently, actions may define to either `Set` or `Delete` headers values. Actions are applied in sequence as defined in this list. A maximum of 20 response header actions may be configured. Sample fetchers allowed are "res.hdr" and "ssl_c_der". Converters allowed are "lower" and "base64". Example header values: "%[res.hdr(X-target),lower]", "%{+Q}[ssl_c_der,base64]".
     */
    @JsonProperty("response")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IngressControllerHTTPHeader> getResponse() {
        return response;
    }

    /**
     * response is a list of HTTP response headers to modify. Actions defined here will modify the response headers of all requests passing through an ingress controller. These actions are applied to all Routes i.e. for all connections handled by the ingress controller defined within a cluster. IngressController actions for response headers will be executed after Route actions. Currently, actions may define to either `Set` or `Delete` headers values. Actions are applied in sequence as defined in this list. A maximum of 20 response header actions may be configured. Sample fetchers allowed are "res.hdr" and "ssl_c_der". Converters allowed are "lower" and "base64". Example header values: "%[res.hdr(X-target),lower]", "%{+Q}[ssl_c_der,base64]".
     */
    @JsonProperty("response")
    public void setResponse(List<IngressControllerHTTPHeader> response) {
        this.response = response;
    }

    @JsonIgnore
    public IngressControllerHTTPHeaderActionsBuilder edit() {
        return new IngressControllerHTTPHeaderActionsBuilder(this);
    }

    @JsonIgnore
    public IngressControllerHTTPHeaderActionsBuilder toBuilder() {
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
