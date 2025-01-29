
package io.fabric8.openshift.api.model.operator.v1;

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
    "internalJoinSubnet",
    "internalTransitSwitchSubnet"
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
public class IPv4OVNKubernetesConfig implements Editable<IPv4OVNKubernetesConfigBuilder>, KubernetesResource
{

    @JsonProperty("internalJoinSubnet")
    private String internalJoinSubnet;
    @JsonProperty("internalTransitSwitchSubnet")
    private String internalTransitSwitchSubnet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IPv4OVNKubernetesConfig() {
    }

    public IPv4OVNKubernetesConfig(String internalJoinSubnet, String internalTransitSwitchSubnet) {
        super();
        this.internalJoinSubnet = internalJoinSubnet;
        this.internalTransitSwitchSubnet = internalTransitSwitchSubnet;
    }

    /**
     * internalJoinSubnet is a v4 subnet used internally by ovn-kubernetes in case the default one is being already used by something else. It must not overlap with any other subnet being used by OpenShift or by the node network. The size of the subnet must be larger than the number of nodes. The value cannot be changed after installation. The current default value is 100.64.0.0/16 The subnet must be large enough to accomadate one IP per node in your cluster The value must be in proper IPV4 CIDR format
     */
    @JsonProperty("internalJoinSubnet")
    public String getInternalJoinSubnet() {
        return internalJoinSubnet;
    }

    /**
     * internalJoinSubnet is a v4 subnet used internally by ovn-kubernetes in case the default one is being already used by something else. It must not overlap with any other subnet being used by OpenShift or by the node network. The size of the subnet must be larger than the number of nodes. The value cannot be changed after installation. The current default value is 100.64.0.0/16 The subnet must be large enough to accomadate one IP per node in your cluster The value must be in proper IPV4 CIDR format
     */
    @JsonProperty("internalJoinSubnet")
    public void setInternalJoinSubnet(String internalJoinSubnet) {
        this.internalJoinSubnet = internalJoinSubnet;
    }

    /**
     * internalTransitSwitchSubnet is a v4 subnet in IPV4 CIDR format used internally by OVN-Kubernetes for the distributed transit switch in the OVN Interconnect architecture that connects the cluster routers on each node together to enable east west traffic. The subnet chosen should not overlap with other networks specified for OVN-Kubernetes as well as other networks used on the host. The value cannot be changed after installation. When ommitted, this means no opinion and the platform is left to choose a reasonable default which is subject to change over time. The current default subnet is 100.88.0.0/16 The subnet must be large enough to accomadate one IP per node in your cluster The value must be in proper IPV4 CIDR format
     */
    @JsonProperty("internalTransitSwitchSubnet")
    public String getInternalTransitSwitchSubnet() {
        return internalTransitSwitchSubnet;
    }

    /**
     * internalTransitSwitchSubnet is a v4 subnet in IPV4 CIDR format used internally by OVN-Kubernetes for the distributed transit switch in the OVN Interconnect architecture that connects the cluster routers on each node together to enable east west traffic. The subnet chosen should not overlap with other networks specified for OVN-Kubernetes as well as other networks used on the host. The value cannot be changed after installation. When ommitted, this means no opinion and the platform is left to choose a reasonable default which is subject to change over time. The current default subnet is 100.88.0.0/16 The subnet must be large enough to accomadate one IP per node in your cluster The value must be in proper IPV4 CIDR format
     */
    @JsonProperty("internalTransitSwitchSubnet")
    public void setInternalTransitSwitchSubnet(String internalTransitSwitchSubnet) {
        this.internalTransitSwitchSubnet = internalTransitSwitchSubnet;
    }

    @JsonIgnore
    public IPv4OVNKubernetesConfigBuilder edit() {
        return new IPv4OVNKubernetesConfigBuilder(this);
    }

    @JsonIgnore
    public IPv4OVNKubernetesConfigBuilder toBuilder() {
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
