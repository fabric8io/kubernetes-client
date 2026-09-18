
package io.fabric8.knative.internal.networking.v1alpha1;

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
 * HTTP01Challenge defines the status of a HTTP01 challenge that a certificate needs to fulfill.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "serviceName",
    "serviceNamespace",
    "servicePort",
    "url"
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
public class HTTP01Challenge implements Editable<HTTP01ChallengeBuilder>, KubernetesResource
{

    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("serviceNamespace")
    private String serviceNamespace;
    @JsonProperty("servicePort")
    private IntOrString servicePort;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTP01Challenge() {
    }

    public HTTP01Challenge(String serviceName, String serviceNamespace, IntOrString servicePort, String url) {
        super();
        this.serviceName = serviceName;
        this.serviceNamespace = serviceNamespace;
        this.servicePort = servicePort;
        this.url = url;
    }

    /**
     * ServiceName is the name of the service to serve HTTP01 challenge requests.
     */
    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    /**
     * ServiceName is the name of the service to serve HTTP01 challenge requests.
     */
    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * ServiceNamespace is the namespace of the service to serve HTTP01 challenge requests.
     */
    @JsonProperty("serviceNamespace")
    public String getServiceNamespace() {
        return serviceNamespace;
    }

    /**
     * ServiceNamespace is the namespace of the service to serve HTTP01 challenge requests.
     */
    @JsonProperty("serviceNamespace")
    public void setServiceNamespace(String serviceNamespace) {
        this.serviceNamespace = serviceNamespace;
    }

    /**
     * HTTP01Challenge defines the status of a HTTP01 challenge that a certificate needs to fulfill.
     */
    @JsonProperty("servicePort")
    public IntOrString getServicePort() {
        return servicePort;
    }

    /**
     * HTTP01Challenge defines the status of a HTTP01 challenge that a certificate needs to fulfill.
     */
    @JsonProperty("servicePort")
    public void setServicePort(IntOrString servicePort) {
        this.servicePort = servicePort;
    }

    /**
     * HTTP01Challenge defines the status of a HTTP01 challenge that a certificate needs to fulfill.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * HTTP01Challenge defines the status of a HTTP01 challenge that a certificate needs to fulfill.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public HTTP01ChallengeBuilder edit() {
        return new HTTP01ChallengeBuilder(this);
    }

    @JsonIgnore
    public HTTP01ChallengeBuilder toBuilder() {
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
        if (!(o instanceof HTTP01Challenge)) {
            return false;
        }
        HTTP01Challenge other = (HTTP01Challenge) o;
        if (!other.canEqual(this)) {
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
        Object this$servicePort = this.getServicePort();
        Object other$servicePort = other.getServicePort();
        if (this$servicePort == null ? other$servicePort != null : !this$servicePort.equals(other$servicePort)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
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
        return other instanceof HTTP01Challenge;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $serviceName = this.getServiceName();
        result = result * prime + ($serviceName == null ? 43 : $serviceName.hashCode());
        Object $serviceNamespace = this.getServiceNamespace();
        result = result * prime + ($serviceNamespace == null ? 43 : $serviceNamespace.hashCode());
        Object $servicePort = this.getServicePort();
        result = result * prime + ($servicePort == null ? 43 : $servicePort.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTP01Challenge(" + "serviceName=" + this.getServiceName() + ", serviceNamespace=" + this.getServiceNamespace() + ", servicePort=" + this.getServicePort() + ", url=" + this.getUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
