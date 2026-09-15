
package io.fabric8.kubernetes.api.model.extensions;

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

/**
 * IngressBackend describes all endpoints for a given service and port.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "serviceName",
    "servicePort"
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
public class IngressBackend implements Editable<IngressBackendBuilder>, KubernetesResource
{

    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("servicePort")
    private IntOrString servicePort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressBackend() {
    }

    public IngressBackend(String serviceName, IntOrString servicePort) {
        super();
        this.serviceName = serviceName;
        this.servicePort = servicePort;
    }

    /**
     * Specifies the name of the referenced service.
     */
    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Specifies the name of the referenced service.
     */
    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * IngressBackend describes all endpoints for a given service and port.
     */
    @JsonProperty("servicePort")
    public IntOrString getServicePort() {
        return servicePort;
    }

    /**
     * IngressBackend describes all endpoints for a given service and port.
     */
    @JsonProperty("servicePort")
    public void setServicePort(IntOrString servicePort) {
        this.servicePort = servicePort;
    }

    @JsonIgnore
    public IngressBackendBuilder edit() {
        return new IngressBackendBuilder(this);
    }

    @JsonIgnore
    public IngressBackendBuilder toBuilder() {
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
        if (!(o instanceof IngressBackend)) {
            return false;
        }
        IngressBackend other = (IngressBackend) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$serviceName = this.getServiceName();
        Object other$serviceName = other.getServiceName();
        if (this$serviceName == null ? other$serviceName != null : !this$serviceName.equals(other$serviceName)) {
            return false;
        }
        Object this$servicePort = this.getServicePort();
        Object other$servicePort = other.getServicePort();
        if (this$servicePort == null ? other$servicePort != null : !this$servicePort.equals(other$servicePort)) {
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
        return other instanceof IngressBackend;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $serviceName = this.getServiceName();
        result = result * prime + ($serviceName == null ? 43 : $serviceName.hashCode());
        Object $servicePort = this.getServicePort();
        result = result * prime + ($servicePort == null ? 43 : $servicePort.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IngressBackend(" + "serviceName=" + this.getServiceName() + ", servicePort=" + this.getServicePort() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
