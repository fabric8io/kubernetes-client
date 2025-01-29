
package io.fabric8.kubernetes.api.model.ovn.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "ipamLifecycle",
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
public class Layer2Config implements Editable<Layer2ConfigBuilder>, KubernetesResource
{

    @JsonProperty("ipamLifecycle")
    private String ipamLifecycle;
    @JsonProperty("joinSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> joinSubnets = new ArrayList<>();
    @JsonProperty("mtu")
    private Integer mtu;
    @JsonProperty("role")
    private String role;
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subnets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Layer2Config() {
    }

    public Layer2Config(String ipamLifecycle, List<String> joinSubnets, Integer mtu, String role, List<String> subnets) {
        super();
        this.ipamLifecycle = ipamLifecycle;
        this.joinSubnets = joinSubnets;
        this.mtu = mtu;
        this.role = role;
        this.subnets = subnets;
    }

    @JsonProperty("ipamLifecycle")
    public String getIpamLifecycle() {
        return ipamLifecycle;
    }

    @JsonProperty("ipamLifecycle")
    public void setIpamLifecycle(String ipamLifecycle) {
        this.ipamLifecycle = ipamLifecycle;
    }

    @JsonProperty("joinSubnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getJoinSubnets() {
        return joinSubnets;
    }

    @JsonProperty("joinSubnets")
    public void setJoinSubnets(List<String> joinSubnets) {
        this.joinSubnets = joinSubnets;
    }

    @JsonProperty("mtu")
    public Integer getMtu() {
        return mtu;
    }

    @JsonProperty("mtu")
    public void setMtu(Integer mtu) {
        this.mtu = mtu;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubnets() {
        return subnets;
    }

    @JsonProperty("subnets")
    public void setSubnets(List<String> subnets) {
        this.subnets = subnets;
    }

    @JsonIgnore
    public Layer2ConfigBuilder edit() {
        return new Layer2ConfigBuilder(this);
    }

    @JsonIgnore
    public Layer2ConfigBuilder toBuilder() {
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
