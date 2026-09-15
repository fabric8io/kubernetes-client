
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "createdAt",
    "port",
    "protocol",
    "serviceName",
    "serviceNamespace"
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
public class RegistryServiceStatus implements Editable<RegistryServiceStatusBuilder>, KubernetesResource
{

    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("port")
    private String port;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("serviceNamespace")
    private String serviceNamespace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RegistryServiceStatus() {
    }

    public RegistryServiceStatus(String createdAt, String port, String protocol, String serviceName, String serviceNamespace) {
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
    public String getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(String port) {
        this.port = port;
    }

    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @JsonProperty("serviceNamespace")
    public String getServiceNamespace() {
        return serviceNamespace;
    }

    @JsonProperty("serviceNamespace")
    public void setServiceNamespace(String serviceNamespace) {
        this.serviceNamespace = serviceNamespace;
    }

    @JsonIgnore
    public RegistryServiceStatusBuilder edit() {
        return new RegistryServiceStatusBuilder(this);
    }

    @JsonIgnore
    public RegistryServiceStatusBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RegistryServiceStatus)) {
            return false;
        }
        RegistryServiceStatus other = (RegistryServiceStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$createdAt = this.getCreatedAt();
        Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$protocol = this.getProtocol();
        Object other$protocol = other.getProtocol();
        if (this$protocol == null ? other$protocol != null : !this$protocol.equals(other$protocol)) {
            return false;
        }
        Object this$serviceName = this.getServiceName();
        Object other$serviceName = other.getServiceName();
        if (this$serviceName == null ? other$serviceName != null : !this$serviceName.equals(other$serviceName)) {
            return false;
        }
        Object this$serviceNamespace = this.getServiceNamespace();
        Object other$serviceNamespace = other.getServiceNamespace();
        if (this$serviceNamespace == null ? other$serviceNamespace != null : !this$serviceNamespace.equals(other$serviceNamespace)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof RegistryServiceStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $createdAt = this.getCreatedAt();
        result = result * prime + ($createdAt == null ? 43 : $createdAt.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $protocol = this.getProtocol();
        result = result * prime + ($protocol == null ? 43 : $protocol.hashCode());
        Object $serviceName = this.getServiceName();
        result = result * prime + ($serviceName == null ? 43 : $serviceName.hashCode());
        Object $serviceNamespace = this.getServiceNamespace();
        result = result * prime + ($serviceNamespace == null ? 43 : $serviceNamespace.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RegistryServiceStatus(" + "createdAt=" + this.getCreatedAt() + ", port=" + this.getPort() + ", protocol=" + this.getProtocol() + ", serviceName=" + this.getServiceName() + ", serviceNamespace=" + this.getServiceNamespace() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
