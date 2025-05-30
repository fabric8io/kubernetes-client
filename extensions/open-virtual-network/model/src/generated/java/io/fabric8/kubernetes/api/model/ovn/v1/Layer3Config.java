
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "joinSubnets",
    "mtu",
    "role",
    "subnets"
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

}
