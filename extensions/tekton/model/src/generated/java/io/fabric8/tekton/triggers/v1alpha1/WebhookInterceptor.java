
package io.fabric8.tekton.triggers.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.tekton.v1beta1.Param;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * WebhookInterceptor provides a webhook to intercept and pre-process events
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "header",
    "objectRef",
    "url"
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
public class WebhookInterceptor implements Editable<WebhookInterceptorBuilder>, KubernetesResource
{

    @JsonProperty("header")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Param> header = new ArrayList<>();
    @JsonProperty("objectRef")
    private ObjectReference objectRef;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WebhookInterceptor() {
    }

    public WebhookInterceptor(List<Param> header, ObjectReference objectRef, String url) {
        super();
        this.header = header;
        this.objectRef = objectRef;
        this.url = url;
    }

    /**
     * Header is a group of key-value pairs that can be appended to the interceptor request headers. This allows the interceptor to make decisions specific to an EventListenerTrigger.
     */
    @JsonProperty("header")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Param> getHeader() {
        return header;
    }

    /**
     * Header is a group of key-value pairs that can be appended to the interceptor request headers. This allows the interceptor to make decisions specific to an EventListenerTrigger.
     */
    @JsonProperty("header")
    public void setHeader(List<Param> header) {
        this.header = header;
    }

    /**
     * WebhookInterceptor provides a webhook to intercept and pre-process events
     */
    @JsonProperty("objectRef")
    public ObjectReference getObjectRef() {
        return objectRef;
    }

    /**
     * WebhookInterceptor provides a webhook to intercept and pre-process events
     */
    @JsonProperty("objectRef")
    public void setObjectRef(ObjectReference objectRef) {
        this.objectRef = objectRef;
    }

    /**
     * WebhookInterceptor provides a webhook to intercept and pre-process events
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * WebhookInterceptor provides a webhook to intercept and pre-process events
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public WebhookInterceptorBuilder edit() {
        return new WebhookInterceptorBuilder(this);
    }

    @JsonIgnore
    public WebhookInterceptorBuilder toBuilder() {
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
