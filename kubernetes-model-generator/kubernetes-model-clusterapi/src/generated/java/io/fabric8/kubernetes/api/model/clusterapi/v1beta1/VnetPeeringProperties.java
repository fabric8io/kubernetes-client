
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * VnetPeeringProperties specifies virtual network peering properties.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowForwardedTraffic",
    "allowGatewayTransit",
    "allowVirtualNetworkAccess",
    "useRemoteGateways"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class VnetPeeringProperties implements Editable<VnetPeeringPropertiesBuilder>, KubernetesResource
{

    @JsonProperty("allowForwardedTraffic")
    private Boolean allowForwardedTraffic;
    @JsonProperty("allowGatewayTransit")
    private Boolean allowGatewayTransit;
    @JsonProperty("allowVirtualNetworkAccess")
    private Boolean allowVirtualNetworkAccess;
    @JsonProperty("useRemoteGateways")
    private Boolean useRemoteGateways;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VnetPeeringProperties() {
    }

    public VnetPeeringProperties(Boolean allowForwardedTraffic, Boolean allowGatewayTransit, Boolean allowVirtualNetworkAccess, Boolean useRemoteGateways) {
        super();
        this.allowForwardedTraffic = allowForwardedTraffic;
        this.allowGatewayTransit = allowGatewayTransit;
        this.allowVirtualNetworkAccess = allowVirtualNetworkAccess;
        this.useRemoteGateways = useRemoteGateways;
    }

    /**
     * AllowForwardedTraffic specifies whether the forwarded traffic from the VMs in the local virtual network will be allowed/disallowed in remote virtual network.
     */
    @JsonProperty("allowForwardedTraffic")
    public Boolean getAllowForwardedTraffic() {
        return allowForwardedTraffic;
    }

    /**
     * AllowForwardedTraffic specifies whether the forwarded traffic from the VMs in the local virtual network will be allowed/disallowed in remote virtual network.
     */
    @JsonProperty("allowForwardedTraffic")
    public void setAllowForwardedTraffic(Boolean allowForwardedTraffic) {
        this.allowForwardedTraffic = allowForwardedTraffic;
    }

    /**
     * AllowGatewayTransit specifies if gateway links can be used in remote virtual networking to link to this virtual network.
     */
    @JsonProperty("allowGatewayTransit")
    public Boolean getAllowGatewayTransit() {
        return allowGatewayTransit;
    }

    /**
     * AllowGatewayTransit specifies if gateway links can be used in remote virtual networking to link to this virtual network.
     */
    @JsonProperty("allowGatewayTransit")
    public void setAllowGatewayTransit(Boolean allowGatewayTransit) {
        this.allowGatewayTransit = allowGatewayTransit;
    }

    /**
     * AllowVirtualNetworkAccess specifies whether the VMs in the local virtual network space would be able to access the VMs in remote virtual network space.
     */
    @JsonProperty("allowVirtualNetworkAccess")
    public Boolean getAllowVirtualNetworkAccess() {
        return allowVirtualNetworkAccess;
    }

    /**
     * AllowVirtualNetworkAccess specifies whether the VMs in the local virtual network space would be able to access the VMs in remote virtual network space.
     */
    @JsonProperty("allowVirtualNetworkAccess")
    public void setAllowVirtualNetworkAccess(Boolean allowVirtualNetworkAccess) {
        this.allowVirtualNetworkAccess = allowVirtualNetworkAccess;
    }

    /**
     * UseRemoteGateways specifies if remote gateways can be used on this virtual network. If the flag is set to true, and allowGatewayTransit on remote peering is also set to true, the virtual network will use the gateways of the remote virtual network for transit. Only one peering can have this flag set to true. This flag cannot be set if virtual network already has a gateway.
     */
    @JsonProperty("useRemoteGateways")
    public Boolean getUseRemoteGateways() {
        return useRemoteGateways;
    }

    /**
     * UseRemoteGateways specifies if remote gateways can be used on this virtual network. If the flag is set to true, and allowGatewayTransit on remote peering is also set to true, the virtual network will use the gateways of the remote virtual network for transit. Only one peering can have this flag set to true. This flag cannot be set if virtual network already has a gateway.
     */
    @JsonProperty("useRemoteGateways")
    public void setUseRemoteGateways(Boolean useRemoteGateways) {
        this.useRemoteGateways = useRemoteGateways;
    }

    @JsonIgnore
    public VnetPeeringPropertiesBuilder edit() {
        return new VnetPeeringPropertiesBuilder(this);
    }

    @JsonIgnore
    public VnetPeeringPropertiesBuilder toBuilder() {
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
