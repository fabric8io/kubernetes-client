
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
    "ipv4",
    "ipv4DHCP",
    "ipv6",
    "ipv6DHCP",
    "ipv6SLAAC"
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
public class NetworkDataNetwork implements Editable<NetworkDataNetworkBuilder> , KubernetesResource
{

    @JsonProperty("ipv4")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataIPv4> ipv4 = new ArrayList<>();
    @JsonProperty("ipv4DHCP")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataIPv4DHCP> ipv4DHCP = new ArrayList<>();
    @JsonProperty("ipv6")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataIPv6> ipv6 = new ArrayList<>();
    @JsonProperty("ipv6DHCP")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataIPv6DHCP> ipv6DHCP = new ArrayList<>();
    @JsonProperty("ipv6SLAAC")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataIPv6DHCP> ipv6SLAAC = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NetworkDataNetwork() {
    }

    public NetworkDataNetwork(List<NetworkDataIPv4> ipv4, List<NetworkDataIPv4DHCP> ipv4DHCP, List<NetworkDataIPv6> ipv6, List<NetworkDataIPv6DHCP> ipv6DHCP, List<NetworkDataIPv6DHCP> ipv6SLAAC) {
        super();
        this.ipv4 = ipv4;
        this.ipv4DHCP = ipv4DHCP;
        this.ipv6 = ipv6;
        this.ipv6DHCP = ipv6DHCP;
        this.ipv6SLAAC = ipv6SLAAC;
    }

    @JsonProperty("ipv4")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataIPv4> getIpv4() {
        return ipv4;
    }

    @JsonProperty("ipv4")
    public void setIpv4(List<NetworkDataIPv4> ipv4) {
        this.ipv4 = ipv4;
    }

    @JsonProperty("ipv4DHCP")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataIPv4DHCP> getIpv4DHCP() {
        return ipv4DHCP;
    }

    @JsonProperty("ipv4DHCP")
    public void setIpv4DHCP(List<NetworkDataIPv4DHCP> ipv4DHCP) {
        this.ipv4DHCP = ipv4DHCP;
    }

    @JsonProperty("ipv6")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataIPv6> getIpv6() {
        return ipv6;
    }

    @JsonProperty("ipv6")
    public void setIpv6(List<NetworkDataIPv6> ipv6) {
        this.ipv6 = ipv6;
    }

    @JsonProperty("ipv6DHCP")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataIPv6DHCP> getIpv6DHCP() {
        return ipv6DHCP;
    }

    @JsonProperty("ipv6DHCP")
    public void setIpv6DHCP(List<NetworkDataIPv6DHCP> ipv6DHCP) {
        this.ipv6DHCP = ipv6DHCP;
    }

    @JsonProperty("ipv6SLAAC")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataIPv6DHCP> getIpv6SLAAC() {
        return ipv6SLAAC;
    }

    @JsonProperty("ipv6SLAAC")
    public void setIpv6SLAAC(List<NetworkDataIPv6DHCP> ipv6SLAAC) {
        this.ipv6SLAAC = ipv6SLAAC;
    }

    @JsonIgnore
    public NetworkDataNetworkBuilder edit() {
        return new NetworkDataNetworkBuilder(this);
    }

    @JsonIgnore
    public NetworkDataNetworkBuilder toBuilder() {
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
