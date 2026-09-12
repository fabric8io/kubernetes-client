
package io.fabric8.kubernetes.api.model.ovn.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "joinSubnets",
    "mtu",
    "role",
    "subnets"
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
public class Layer3Config implements Editable<Layer3ConfigBuilder>, KubernetesResource
{

    @JsonProperty("joinSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> joinSubnets = new ArrayList<>();
    @JsonProperty("mtu")
    private Integer mtu;
    @JsonProperty("role")
    private String role;
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Layer3Subnet> subnets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Layer3Config() {
    }

    public Layer3Config(List<String> joinSubnets, Integer mtu, String role, List<Layer3Subnet> subnets) {
        super();
        this.joinSubnets = joinSubnets;
        this.mtu = mtu;
        this.role = role;
        this.subnets = subnets;
    }

    /**
     * JoinSubnets are used inside the OVN network topology.<br><p> <br><p> Dual-stack clusters may set 2 subnets (one for each IP family), otherwise only 1 subnet is allowed. This field is only allowed for "Primary" network. It is not recommended to set this field without explicit need and understanding of the OVN network topology. When omitted, the platform will choose a reasonable default which is subject to change over time.
     */
    @JsonProperty("joinSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getJoinSubnets() {
        return joinSubnets;
    }

    /**
     * JoinSubnets are used inside the OVN network topology.<br><p> <br><p> Dual-stack clusters may set 2 subnets (one for each IP family), otherwise only 1 subnet is allowed. This field is only allowed for "Primary" network. It is not recommended to set this field without explicit need and understanding of the OVN network topology. When omitted, the platform will choose a reasonable default which is subject to change over time.
     */
    @JsonProperty("joinSubnets")
    public void setJoinSubnets(List<String> joinSubnets) {
        this.joinSubnets = joinSubnets;
    }

    /**
     * MTU is the maximum transmission unit for a network.<br><p> <br><p> MTU is optional, if not provided, the globally configured value in OVN-Kubernetes (defaults to 1400) is used for the network.
     */
    @JsonProperty("mtu")
    public Integer getMtu() {
        return mtu;
    }

    /**
     * MTU is the maximum transmission unit for a network.<br><p> <br><p> MTU is optional, if not provided, the globally configured value in OVN-Kubernetes (defaults to 1400) is used for the network.
     */
    @JsonProperty("mtu")
    public void setMtu(Integer mtu) {
        this.mtu = mtu;
    }

    /**
     * Role describes the network role in the pod.<br><p> <br><p> Allowed values are "Primary" and "Secondary". Primary network is automatically assigned to every pod created in the same namespace. Secondary network is only assigned to pods that use `k8s.v1.cni.cncf.io/networks` annotation to select given network.
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * Role describes the network role in the pod.<br><p> <br><p> Allowed values are "Primary" and "Secondary". Primary network is automatically assigned to every pod created in the same namespace. Secondary network is only assigned to pods that use `k8s.v1.cni.cncf.io/networks` annotation to select given network.
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Subnets are used for the pod network across the cluster.<br><p> <br><p> Dual-stack clusters may set 2 subnets (one for each IP family), otherwise only 1 subnet is allowed. Given subnet is split into smaller subnets for every node.
     */
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Layer3Subnet> getSubnets() {
        return subnets;
    }

    /**
     * Subnets are used for the pod network across the cluster.<br><p> <br><p> Dual-stack clusters may set 2 subnets (one for each IP family), otherwise only 1 subnet is allowed. Given subnet is split into smaller subnets for every node.
     */
    @JsonProperty("subnets")
    public void setSubnets(List<Layer3Subnet> subnets) {
        this.subnets = subnets;
    }

    @JsonIgnore
    public Layer3ConfigBuilder edit() {
        return new Layer3ConfigBuilder(this);
    }

    @JsonIgnore
    public Layer3ConfigBuilder toBuilder() {
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
        if (!(o instanceof Layer3Config)) {
            return false;
        }
        Layer3Config other = (Layer3Config) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$joinSubnets = this.getJoinSubnets();
        Object other$joinSubnets = other.getJoinSubnets();
        if (this$joinSubnets == null ? other$joinSubnets != null : !this$joinSubnets.equals(other$joinSubnets)) {
            return false;
        }
        Object this$mtu = this.getMtu();
        Object other$mtu = other.getMtu();
        if (this$mtu == null ? other$mtu != null : !this$mtu.equals(other$mtu)) {
            return false;
        }
        Object this$role = this.getRole();
        Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) {
            return false;
        }
        Object this$subnets = this.getSubnets();
        Object other$subnets = other.getSubnets();
        if (this$subnets == null ? other$subnets != null : !this$subnets.equals(other$subnets)) {
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
        return other instanceof Layer3Config;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $joinSubnets = this.getJoinSubnets();
        result = result * prime + ($joinSubnets == null ? 43 : $joinSubnets.hashCode());
        Object $mtu = this.getMtu();
        result = result * prime + ($mtu == null ? 43 : $mtu.hashCode());
        Object $role = this.getRole();
        result = result * prime + ($role == null ? 43 : $role.hashCode());
        Object $subnets = this.getSubnets();
        result = result * prime + ($subnets == null ? 43 : $subnets.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Layer3Config(" + "joinSubnets=" + this.getJoinSubnets() + ", mtu=" + this.getMtu() + ", role=" + this.getRole() + ", subnets=" + this.getSubnets() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
