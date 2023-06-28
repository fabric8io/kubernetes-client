
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "createdAt",
    "port",
    "protocol",
    "serviceName",
    "serviceNamespace"
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
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class RegistryServiceStatus implements KubernetesResource
{

    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("port")
    private java.lang.String port;
    @JsonProperty("protocol")
    private java.lang.String protocol;
    @JsonProperty("serviceName")
    private java.lang.String serviceName;
    @JsonProperty("serviceNamespace")
    private java.lang.String serviceNamespace;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RegistryServiceStatus() {
    }

    public RegistryServiceStatus(String createdAt, java.lang.String port, java.lang.String protocol, java.lang.String serviceName, java.lang.String serviceNamespace) {
        super();
        this.createdAt = createdAt;
        this.port = port;
        this.protocol = protocol;
        this.serviceName = serviceName;
        this.serviceNamespace = serviceNamespace;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("port")
    public java.lang.String getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(java.lang.String port) {
        this.port = port;
    }

    @JsonProperty("protocol")
    public java.lang.String getProtocol() {
        return protocol;
    }

    @JsonProperty("protocol")
    public void setProtocol(java.lang.String protocol) {
        this.protocol = protocol;
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

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
