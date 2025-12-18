
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.infrastructure.v1beta1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * NetworkInterface defines a network interface.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acceleratedNetworking",
    "privateIPConfigs",
    "subnetName"
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
public class NetworkInterface implements Editable<NetworkInterfaceBuilder>, KubernetesResource
{

    @JsonProperty("acceleratedNetworking")
    private Boolean acceleratedNetworking;
    @JsonProperty("privateIPConfigs")
    private Integer privateIPConfigs;
    @JsonProperty("subnetName")
    private String subnetName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkInterface() {
    }

    public NetworkInterface(Boolean acceleratedNetworking, Integer privateIPConfigs, String subnetName) {
        super();
        this.acceleratedNetworking = acceleratedNetworking;
        this.privateIPConfigs = privateIPConfigs;
        this.subnetName = subnetName;
    }

    /**
     * AcceleratedNetworking enables or disables Azure accelerated networking. If omitted, it will be set based on whether the requested VMSize supports accelerated networking. If AcceleratedNetworking is set to true with a VMSize that does not support it, Azure will return an error.
     */
    @JsonProperty("acceleratedNetworking")
    public Boolean getAcceleratedNetworking() {
        return acceleratedNetworking;
    }

    /**
     * AcceleratedNetworking enables or disables Azure accelerated networking. If omitted, it will be set based on whether the requested VMSize supports accelerated networking. If AcceleratedNetworking is set to true with a VMSize that does not support it, Azure will return an error.
     */
    @JsonProperty("acceleratedNetworking")
    public void setAcceleratedNetworking(Boolean acceleratedNetworking) {
        this.acceleratedNetworking = acceleratedNetworking;
    }

    /**
     * PrivateIPConfigs specifies the number of private IP addresses to attach to the interface. Defaults to 1 if not specified.
     */
    @JsonProperty("privateIPConfigs")
    public Integer getPrivateIPConfigs() {
        return privateIPConfigs;
    }

    /**
     * PrivateIPConfigs specifies the number of private IP addresses to attach to the interface. Defaults to 1 if not specified.
     */
    @JsonProperty("privateIPConfigs")
    public void setPrivateIPConfigs(Integer privateIPConfigs) {
        this.privateIPConfigs = privateIPConfigs;
    }

    /**
     * SubnetName specifies the subnet in which the new network interface will be placed.
     */
    @JsonProperty("subnetName")
    public String getSubnetName() {
        return subnetName;
    }

    /**
     * SubnetName specifies the subnet in which the new network interface will be placed.
     */
    @JsonProperty("subnetName")
    public void setSubnetName(String subnetName) {
        this.subnetName = subnetName;
    }

    @JsonIgnore
    public NetworkInterfaceBuilder edit() {
        return new NetworkInterfaceBuilder(this);
    }

    @JsonIgnore
    public NetworkInterfaceBuilder toBuilder() {
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

}
