
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
 * IngressControllerCaptureHTTPHeaders specifies which HTTP headers the IngressController captures.
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
public class IngressControllerCaptureHTTPHeaders implements Editable<IngressControllerCaptureHTTPHeadersBuilder>, KubernetesResource
{

    @JsonProperty("request")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressControllerCaptureHTTPHeader> request = new ArrayList<>();
    @JsonProperty("response")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressControllerCaptureHTTPHeader> response = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressControllerCaptureHTTPHeaders() {
    }

    public IngressControllerCaptureHTTPHeaders(List<IngressControllerCaptureHTTPHeader> request, List<IngressControllerCaptureHTTPHeader> response) {
        super();
        this.request = request;
        this.response = response;
    }

    /**
     * request specifies which HTTP request headers to capture.<br><p> <br><p> If this field is empty, no request headers are captured.
     */
    @JsonProperty("request")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IngressControllerCaptureHTTPHeader> getRequest() {
        return request;
    }

    /**
     * request specifies which HTTP request headers to capture.<br><p> <br><p> If this field is empty, no request headers are captured.
     */
    @JsonProperty("request")
    public void setRequest(List<IngressControllerCaptureHTTPHeader> request) {
        this.request = request;
    }

    /**
     * response specifies which HTTP response headers to capture.<br><p> <br><p> If this field is empty, no response headers are captured.
     */
    @JsonProperty("response")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IngressControllerCaptureHTTPHeader> getResponse() {
        return response;
    }

    /**
     * response specifies which HTTP response headers to capture.<br><p> <br><p> If this field is empty, no response headers are captured.
     */
    @JsonProperty("response")
    public void setResponse(List<IngressControllerCaptureHTTPHeader> response) {
        this.response = response;
    }

    @JsonIgnore
    public IngressControllerCaptureHTTPHeadersBuilder edit() {
        return new IngressControllerCaptureHTTPHeadersBuilder(this);
    }

    @JsonIgnore
    public IngressControllerCaptureHTTPHeadersBuilder toBuilder() {
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
