
package io.fabric8.tekton.triggers.v1beta1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "body",
    "context",
    "extensions",
    "header",
    "interceptor_params"
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
public class InterceptorRequest implements Editable<InterceptorRequestBuilder>, KubernetesResource
{

    @JsonProperty("body")
    private String body;
    @JsonProperty("context")
    private TriggerContext context;
    @JsonProperty("extensions")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> extensions = new LinkedHashMap<>();
    @JsonProperty("header")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> header = new LinkedHashMap<>();
    @JsonProperty("interceptor_params")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> interceptorParams = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public InterceptorRequest() {
    }

    public InterceptorRequest(String body, TriggerContext context, Map<String, Object> extensions, Map<String, List<String>> header, Map<String, Object> interceptorParams) {
        super();
        this.body = body;
        this.context = context;
        this.extensions = extensions;
        this.header = header;
        this.interceptorParams = interceptorParams;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("context")
    public TriggerContext getContext() {
        return context;
    }

    @JsonProperty("context")
    public void setContext(TriggerContext context) {
        this.context = context;
    }

    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @JsonProperty("extensions")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }

    @JsonProperty("header")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getHeader() {
        return header;
    }

    @JsonProperty("header")
    public void setHeader(Map<String, List<String>> header) {
        this.header = header;
    }

    @JsonProperty("interceptor_params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Object> getInterceptorParams() {
        return interceptorParams;
    }

    @JsonProperty("interceptor_params")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    public void setInterceptorParams(Map<String, Object> interceptorParams) {
        this.interceptorParams = interceptorParams;
    }

    @JsonIgnore
    public InterceptorRequestBuilder edit() {
        return new InterceptorRequestBuilder(this);
    }

    @JsonIgnore
    public InterceptorRequestBuilder toBuilder() {
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
