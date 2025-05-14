
package io.fabric8.openshift.api.model.operator.v1;

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
 * IPV4GatewayConfig holds the configuration paramaters for IPV4 connections in the GatewayConfig for OVN-Kubernetes
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "internalMasqueradeSubnet"
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
public class IPv4GatewayConfig implements Editable<IPv4GatewayConfigBuilder>, KubernetesResource
{

    @JsonProperty("internalMasqueradeSubnet")
    private String internalMasqueradeSubnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IPv4GatewayConfig() {
    }

    public IPv4GatewayConfig(String internalMasqueradeSubnet) {
        super();
        this.internalMasqueradeSubnet = internalMasqueradeSubnet;
    }

    /**
     * internalMasqueradeSubnet contains the masquerade addresses in IPV4 CIDR format used internally by ovn-kubernetes to enable host to service traffic. Each host in the cluster is configured with these addresses, as well as the shared gateway bridge interface. The values can be changed after installation. The subnet chosen should not overlap with other networks specified for OVN-Kubernetes as well as other networks used on the host. Additionally the subnet must be large enough to accommodate 6 IPs (maximum prefix length /29). When omitted, this means no opinion and the platform is left to choose a reasonable default which is subject to change over time. The current default subnet is 169.254.169.0/29 The value must be in proper IPV4 CIDR format
     */
    @JsonProperty("internalMasqueradeSubnet")
    public String getInternalMasqueradeSubnet() {
        return internalMasqueradeSubnet;
    }

    /**
     * internalMasqueradeSubnet contains the masquerade addresses in IPV4 CIDR format used internally by ovn-kubernetes to enable host to service traffic. Each host in the cluster is configured with these addresses, as well as the shared gateway bridge interface. The values can be changed after installation. The subnet chosen should not overlap with other networks specified for OVN-Kubernetes as well as other networks used on the host. Additionally the subnet must be large enough to accommodate 6 IPs (maximum prefix length /29). When omitted, this means no opinion and the platform is left to choose a reasonable default which is subject to change over time. The current default subnet is 169.254.169.0/29 The value must be in proper IPV4 CIDR format
     */
    @JsonProperty("internalMasqueradeSubnet")
    public void setInternalMasqueradeSubnet(String internalMasqueradeSubnet) {
        this.internalMasqueradeSubnet = internalMasqueradeSubnet;
    }

    @JsonIgnore
    public IPv4GatewayConfigBuilder edit() {
        return new IPv4GatewayConfigBuilder(this);
    }

    @JsonIgnore
    public IPv4GatewayConfigBuilder toBuilder() {
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
