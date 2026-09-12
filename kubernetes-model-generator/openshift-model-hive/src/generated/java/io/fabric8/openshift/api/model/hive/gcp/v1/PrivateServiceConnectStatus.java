
package io.fabric8.openshift.api.model.hive.gcp.v1;

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
 * PrivateServiceConnectStatus contains the observed state for PrivateServiceConnect resources.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "endpoint",
    "endpointAddress",
    "serviceAttachment",
    "serviceAttachmentFirewall",
    "serviceAttachmentSubnet"
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
public class PrivateServiceConnectStatus implements Editable<PrivateServiceConnectStatusBuilder>, KubernetesResource
{

    @JsonProperty("endpoint")
    private String endpoint;
    @JsonProperty("endpointAddress")
    private String endpointAddress;
    @JsonProperty("serviceAttachment")
    private String serviceAttachment;
    @JsonProperty("serviceAttachmentFirewall")
    private String serviceAttachmentFirewall;
    @JsonProperty("serviceAttachmentSubnet")
    private String serviceAttachmentSubnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PrivateServiceConnectStatus() {
    }

    public PrivateServiceConnectStatus(String endpoint, String endpointAddress, String serviceAttachment, String serviceAttachmentFirewall, String serviceAttachmentSubnet) {
        super();
        this.endpoint = endpoint;
        this.endpointAddress = endpointAddress;
        this.serviceAttachment = serviceAttachment;
        this.serviceAttachmentFirewall = serviceAttachmentFirewall;
        this.serviceAttachmentSubnet = serviceAttachmentSubnet;
    }

    /**
     * Endpoint is the selfLink of the endpoint created for the cluster.
     */
    @JsonProperty("endpoint")
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Endpoint is the selfLink of the endpoint created for the cluster.
     */
    @JsonProperty("endpoint")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * EndpointAddress is the selfLink of the address created for the cluster endpoint.
     */
    @JsonProperty("endpointAddress")
    public String getEndpointAddress() {
        return endpointAddress;
    }

    /**
     * EndpointAddress is the selfLink of the address created for the cluster endpoint.
     */
    @JsonProperty("endpointAddress")
    public void setEndpointAddress(String endpointAddress) {
        this.endpointAddress = endpointAddress;
    }

    /**
     * ServiceAttachment is the selfLink of the service attachment created for the clsuter.
     */
    @JsonProperty("serviceAttachment")
    public String getServiceAttachment() {
        return serviceAttachment;
    }

    /**
     * ServiceAttachment is the selfLink of the service attachment created for the clsuter.
     */
    @JsonProperty("serviceAttachment")
    public void setServiceAttachment(String serviceAttachment) {
        this.serviceAttachment = serviceAttachment;
    }

    /**
     * ServiceAttachmentFirewall is the selfLink of the firewall that allows traffic between the service attachment and the cluster's internal api load balancer.
     */
    @JsonProperty("serviceAttachmentFirewall")
    public String getServiceAttachmentFirewall() {
        return serviceAttachmentFirewall;
    }

    /**
     * ServiceAttachmentFirewall is the selfLink of the firewall that allows traffic between the service attachment and the cluster's internal api load balancer.
     */
    @JsonProperty("serviceAttachmentFirewall")
    public void setServiceAttachmentFirewall(String serviceAttachmentFirewall) {
        this.serviceAttachmentFirewall = serviceAttachmentFirewall;
    }

    /**
     * ServiceAttachmentSubnet is the selfLink of the subnet that will contain the service attachment.
     */
    @JsonProperty("serviceAttachmentSubnet")
    public String getServiceAttachmentSubnet() {
        return serviceAttachmentSubnet;
    }

    /**
     * ServiceAttachmentSubnet is the selfLink of the subnet that will contain the service attachment.
     */
    @JsonProperty("serviceAttachmentSubnet")
    public void setServiceAttachmentSubnet(String serviceAttachmentSubnet) {
        this.serviceAttachmentSubnet = serviceAttachmentSubnet;
    }

    @JsonIgnore
    public PrivateServiceConnectStatusBuilder edit() {
        return new PrivateServiceConnectStatusBuilder(this);
    }

    @JsonIgnore
    public PrivateServiceConnectStatusBuilder toBuilder() {
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
        if (!(o instanceof PrivateServiceConnectStatus)) {
            return false;
        }
        PrivateServiceConnectStatus other = (PrivateServiceConnectStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$endpoint = this.getEndpoint();
        Object other$endpoint = other.getEndpoint();
        if (this$endpoint == null ? other$endpoint != null : !this$endpoint.equals(other$endpoint)) {
            return false;
        }
        Object this$endpointAddress = this.getEndpointAddress();
        Object other$endpointAddress = other.getEndpointAddress();
        if (this$endpointAddress == null ? other$endpointAddress != null : !this$endpointAddress.equals(other$endpointAddress)) {
            return false;
        }
        Object this$serviceAttachment = this.getServiceAttachment();
        Object other$serviceAttachment = other.getServiceAttachment();
        if (this$serviceAttachment == null ? other$serviceAttachment != null : !this$serviceAttachment.equals(other$serviceAttachment)) {
            return false;
        }
        Object this$serviceAttachmentFirewall = this.getServiceAttachmentFirewall();
        Object other$serviceAttachmentFirewall = other.getServiceAttachmentFirewall();
        if (this$serviceAttachmentFirewall == null ? other$serviceAttachmentFirewall != null : !this$serviceAttachmentFirewall.equals(other$serviceAttachmentFirewall)) {
            return false;
        }
        Object this$serviceAttachmentSubnet = this.getServiceAttachmentSubnet();
        Object other$serviceAttachmentSubnet = other.getServiceAttachmentSubnet();
        if (this$serviceAttachmentSubnet == null ? other$serviceAttachmentSubnet != null : !this$serviceAttachmentSubnet.equals(other$serviceAttachmentSubnet)) {
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
        return other instanceof PrivateServiceConnectStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $endpoint = this.getEndpoint();
        result = result * prime + ($endpoint == null ? 43 : $endpoint.hashCode());
        Object $endpointAddress = this.getEndpointAddress();
        result = result * prime + ($endpointAddress == null ? 43 : $endpointAddress.hashCode());
        Object $serviceAttachment = this.getServiceAttachment();
        result = result * prime + ($serviceAttachment == null ? 43 : $serviceAttachment.hashCode());
        Object $serviceAttachmentFirewall = this.getServiceAttachmentFirewall();
        result = result * prime + ($serviceAttachmentFirewall == null ? 43 : $serviceAttachmentFirewall.hashCode());
        Object $serviceAttachmentSubnet = this.getServiceAttachmentSubnet();
        result = result * prime + ($serviceAttachmentSubnet == null ? 43 : $serviceAttachmentSubnet.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PrivateServiceConnectStatus(" + "endpoint=" + this.getEndpoint() + ", endpointAddress=" + this.getEndpointAddress() + ", serviceAttachment=" + this.getServiceAttachment() + ", serviceAttachmentFirewall=" + this.getServiceAttachmentFirewall() + ", serviceAttachmentSubnet=" + this.getServiceAttachmentSubnet() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
