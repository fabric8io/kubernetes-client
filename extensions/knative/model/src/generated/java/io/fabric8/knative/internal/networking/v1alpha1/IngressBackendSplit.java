
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
 * IngressBackendSplit describes all endpoints for a given service and port.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "appendHeaders",
    "percent",
    "serviceName",
    "serviceNamespace",
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
public class IngressBackendSplit implements Editable<IngressBackendSplitBuilder>, KubernetesResource
{

    @JsonProperty("appendHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> appendHeaders = new LinkedHashMap<>();
    @JsonProperty("percent")
    private Integer percent;
    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("serviceNamespace")
    private String serviceNamespace;
    @JsonProperty("servicePort")
    private IntOrString servicePort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressBackendSplit() {
    }

    public IngressBackendSplit(Map<String, String> appendHeaders, Integer percent, String serviceName, String serviceNamespace, IntOrString servicePort) {
        super();
        this.appendHeaders = appendHeaders;
        this.percent = percent;
        this.serviceName = serviceName;
        this.serviceNamespace = serviceNamespace;
        this.servicePort = servicePort;
    }

    /**
     * AppendHeaders allow specifying additional HTTP headers to add before forwarding a request to the destination service.<br><p> <br><p> NOTE: This differs from K8s Ingress which doesn't allow header appending.
     */
    @JsonProperty("appendHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAppendHeaders() {
        return appendHeaders;
    }

    /**
     * AppendHeaders allow specifying additional HTTP headers to add before forwarding a request to the destination service.<br><p> <br><p> NOTE: This differs from K8s Ingress which doesn't allow header appending.
     */
    @JsonProperty("appendHeaders")
    public void setAppendHeaders(Map<String, String> appendHeaders) {
        this.appendHeaders = appendHeaders;
    }

    /**
     * Specifies the split percentage, a number between 0 and 100.  If only one split is specified, we default to 100.<br><p> <br><p> NOTE: This differs from K8s Ingress to allow percentage split.
     */
    @JsonProperty("percent")
    public Integer getPercent() {
        return percent;
    }

    /**
     * Specifies the split percentage, a number between 0 and 100.  If only one split is specified, we default to 100.<br><p> <br><p> NOTE: This differs from K8s Ingress to allow percentage split.
     */
    @JsonProperty("percent")
    public void setPercent(Integer percent) {
        this.percent = percent;
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
     * Specifies the namespace of the referenced service.<br><p> <br><p> NOTE: This differs from K8s Ingress to allow routing to different namespaces.
     */
    @JsonProperty("serviceNamespace")
    public String getServiceNamespace() {
        return serviceNamespace;
    }

    /**
     * Specifies the namespace of the referenced service.<br><p> <br><p> NOTE: This differs from K8s Ingress to allow routing to different namespaces.
     */
    @JsonProperty("serviceNamespace")
    public void setServiceNamespace(String serviceNamespace) {
        this.serviceNamespace = serviceNamespace;
    }

    /**
     * IngressBackendSplit describes all endpoints for a given service and port.
     */
    @JsonProperty("servicePort")
    public IntOrString getServicePort() {
        return servicePort;
    }

    /**
     * IngressBackendSplit describes all endpoints for a given service and port.
     */
    @JsonProperty("servicePort")
    public void setServicePort(IntOrString servicePort) {
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
        if (!(o instanceof IngressBackendSplit)) {
            return false;
        }
        IngressBackendSplit other = (IngressBackendSplit) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$appendHeaders = this.getAppendHeaders();
        Object other$appendHeaders = other.getAppendHeaders();
        if (this$appendHeaders == null ? other$appendHeaders != null : !this$appendHeaders.equals(other$appendHeaders)) {
            return false;
        }
        Object this$percent = this.getPercent();
        Object other$percent = other.getPercent();
        if (this$percent == null ? other$percent != null : !this$percent.equals(other$percent)) {
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
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof IngressBackendSplit;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $appendHeaders = this.getAppendHeaders();
        result = result * prime + ($appendHeaders == null ? 43 : $appendHeaders.hashCode());
        Object $percent = this.getPercent();
        result = result * prime + ($percent == null ? 43 : $percent.hashCode());
        Object $serviceName = this.getServiceName();
        result = result * prime + ($serviceName == null ? 43 : $serviceName.hashCode());
        Object $serviceNamespace = this.getServiceNamespace();
        result = result * prime + ($serviceNamespace == null ? 43 : $serviceNamespace.hashCode());
        Object $servicePort = this.getServicePort();
        result = result * prime + ($servicePort == null ? 43 : $servicePort.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IngressBackendSplit(" + "appendHeaders=" + this.getAppendHeaders() + ", percent=" + this.getPercent() + ", serviceName=" + this.getServiceName() + ", serviceNamespace=" + this.getServiceNamespace() + ", servicePort=" + this.getServicePort() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
