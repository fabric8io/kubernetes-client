
package io.fabric8.knative.internal.networking.v1alpha1;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "appendHeaders",
    "percent",
    "serviceName",
    "serviceNamespace",
    "servicePort"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(io.fabric8.kubernetes.api.model.IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class IngressBackendSplit implements Editable<IngressBackendSplitBuilder> , KubernetesResource
{

    @JsonProperty("appendHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> appendHeaders = new LinkedHashMap<String, String>();
    @JsonProperty("percent")
    private Integer percent;
    @JsonProperty("serviceName")
    private java.lang.String serviceName;
    @JsonProperty("serviceNamespace")
    private java.lang.String serviceNamespace;
    @JsonProperty("servicePort")
    private io.fabric8.kubernetes.api.model.IntOrString servicePort;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngressBackendSplit() {
    }

    public IngressBackendSplit(Map<String, String> appendHeaders, Integer percent, java.lang.String serviceName, java.lang.String serviceNamespace, io.fabric8.kubernetes.api.model.IntOrString servicePort) {
        super();
        this.appendHeaders = appendHeaders;
        this.percent = percent;
        this.serviceName = serviceName;
        this.serviceNamespace = serviceNamespace;
        this.servicePort = servicePort;
    }

    @JsonProperty("appendHeaders")
    public Map<String, String> getAppendHeaders() {
        return appendHeaders;
    }

    @JsonProperty("appendHeaders")
    public void setAppendHeaders(Map<String, String> appendHeaders) {
        this.appendHeaders = appendHeaders;
    }

    @JsonProperty("percent")
    public Integer getPercent() {
        return percent;
    }

    @JsonProperty("percent")
    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    @JsonProperty("serviceName")
    public java.lang.String getServiceName() {
        return serviceName;
    }

    @JsonProperty("serviceName")
    public void setServiceName(java.lang.String serviceName) {
        this.serviceName = serviceName;
    }

    @JsonProperty("serviceNamespace")
    public java.lang.String getServiceNamespace() {
        return serviceNamespace;
    }

    @JsonProperty("serviceNamespace")
    public void setServiceNamespace(java.lang.String serviceNamespace) {
        this.serviceNamespace = serviceNamespace;
    }

    @JsonProperty("servicePort")
    public io.fabric8.kubernetes.api.model.IntOrString getServicePort() {
        return servicePort;
    }

    @JsonProperty("servicePort")
    public void setServicePort(io.fabric8.kubernetes.api.model.IntOrString servicePort) {
        this.servicePort = servicePort;
    }

    @JsonIgnore
    public IngressBackendSplitBuilder edit() {
        return new IngressBackendSplitBuilder(this);
    }

    @JsonIgnore
    public IngressBackendSplitBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
