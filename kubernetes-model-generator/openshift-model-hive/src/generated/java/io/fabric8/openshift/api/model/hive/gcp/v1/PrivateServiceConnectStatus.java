
package io.fabric8.openshift.api.model.hive.gcp.v1;

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
    "endpoint",
    "endpointAddress",
    "serviceAttachment",
    "serviceAttachmentFirewall",
    "serviceAttachmentSubnet"
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
@Generated("jsonschema2pojo")
public class PrivateServiceConnectStatus implements Editable<PrivateServiceConnectStatusBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("endpoint")
    public String getEndpoint() {
        return endpoint;
    }

    @JsonProperty("endpoint")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @JsonProperty("endpointAddress")
    public String getEndpointAddress() {
        return endpointAddress;
    }

    @JsonProperty("endpointAddress")
    public void setEndpointAddress(String endpointAddress) {
        this.endpointAddress = endpointAddress;
    }

    @JsonProperty("serviceAttachment")
    public String getServiceAttachment() {
        return serviceAttachment;
    }

    @JsonProperty("serviceAttachment")
    public void setServiceAttachment(String serviceAttachment) {
        this.serviceAttachment = serviceAttachment;
    }

    @JsonProperty("serviceAttachmentFirewall")
    public String getServiceAttachmentFirewall() {
        return serviceAttachmentFirewall;
    }

    @JsonProperty("serviceAttachmentFirewall")
    public void setServiceAttachmentFirewall(String serviceAttachmentFirewall) {
        this.serviceAttachmentFirewall = serviceAttachmentFirewall;
    }

    @JsonProperty("serviceAttachmentSubnet")
    public String getServiceAttachmentSubnet() {
        return serviceAttachmentSubnet;
    }

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
