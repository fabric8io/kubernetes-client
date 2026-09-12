
package io.fabric8.openshift.api.model.machine.v1alpha1;

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
    "filter",
    "fixedIp",
    "noAllowedAddressPairs",
    "portSecurity",
    "portTags",
    "profile",
    "subnets",
    "uuid",
    "vnicType"
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
public class NetworkParam implements Editable<NetworkParamBuilder>, KubernetesResource
{

    @JsonProperty("filter")
    private Filter filter;
    @JsonProperty("fixedIp")
    private String fixedIp;
    @JsonProperty("noAllowedAddressPairs")
    private Boolean noAllowedAddressPairs;
    @JsonProperty("portSecurity")
    private Boolean portSecurity;
    @JsonProperty("portTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> portTags = new ArrayList<>();
    @JsonProperty("profile")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> profile = new LinkedHashMap<>();
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubnetParam> subnets = new ArrayList<>();
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("vnicType")
    private String vnicType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkParam() {
    }

    public NetworkParam(Filter filter, String fixedIp, Boolean noAllowedAddressPairs, Boolean portSecurity, List<String> portTags, Map<String, String> profile, List<SubnetParam> subnets, String uuid, String vnicType) {
        super();
        this.filter = filter;
        this.fixedIp = fixedIp;
        this.noAllowedAddressPairs = noAllowedAddressPairs;
        this.portSecurity = portSecurity;
        this.portTags = portTags;
        this.profile = profile;
        this.subnets = subnets;
        this.uuid = uuid;
        this.vnicType = vnicType;
    }

    @JsonProperty("filter")
    public Filter getFilter() {
        return filter;
    }

    @JsonProperty("filter")
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    /**
     * A fixed IPv4 address for the NIC. Deprecated: fixedIP is silently ignored. Use subnets instead.
     */
    @JsonProperty("fixedIp")
    public String getFixedIp() {
        return fixedIp;
    }

    /**
     * A fixed IPv4 address for the NIC. Deprecated: fixedIP is silently ignored. Use subnets instead.
     */
    @JsonProperty("fixedIp")
    public void setFixedIp(String fixedIp) {
        this.fixedIp = fixedIp;
    }

    /**
     * noAllowedAddressPairs disables creation of allowed address pairs for the network ports
     */
    @JsonProperty("noAllowedAddressPairs")
    public Boolean getNoAllowedAddressPairs() {
        return noAllowedAddressPairs;
    }

    /**
     * noAllowedAddressPairs disables creation of allowed address pairs for the network ports
     */
    @JsonProperty("noAllowedAddressPairs")
    public void setNoAllowedAddressPairs(Boolean noAllowedAddressPairs) {
        this.noAllowedAddressPairs = noAllowedAddressPairs;
    }

    /**
     * portSecurity optionally enables or disables security on ports managed by OpenStack
     */
    @JsonProperty("portSecurity")
    public Boolean getPortSecurity() {
        return portSecurity;
    }

    /**
     * portSecurity optionally enables or disables security on ports managed by OpenStack
     */
    @JsonProperty("portSecurity")
    public void setPortSecurity(Boolean portSecurity) {
        this.portSecurity = portSecurity;
    }

    /**
     * portTags allows users to specify a list of tags to add to ports created in a given network
     */
    @JsonProperty("portTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPortTags() {
        return portTags;
    }

    /**
     * portTags allows users to specify a list of tags to add to ports created in a given network
     */
    @JsonProperty("portTags")
    public void setPortTags(List<String> portTags) {
        this.portTags = portTags;
    }

    /**
     * A dictionary that enables the application running on the specified host to pass and receive virtual network interface (VIF) port-specific information to the plug-in.
     */
    @JsonProperty("profile")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getProfile() {
        return profile;
    }

    /**
     * A dictionary that enables the application running on the specified host to pass and receive virtual network interface (VIF) port-specific information to the plug-in.
     */
    @JsonProperty("profile")
    public void setProfile(Map<String, String> profile) {
        this.profile = profile;
    }

    /**
     * Subnet within a network to use
     */
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubnetParam> getSubnets() {
        return subnets;
    }

    /**
     * Subnet within a network to use
     */
    @JsonProperty("subnets")
    public void setSubnets(List<SubnetParam> subnets) {
        this.subnets = subnets;
    }

    /**
     * The UUID of the network. Required if you omit the port attribute.
     */
    @JsonProperty("uuid")
    public String getUuid() {
        return uuid;
    }

    /**
     * The UUID of the network. Required if you omit the port attribute.
     */
    @JsonProperty("uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * The virtual network interface card (vNIC) type that is bound to the neutron port.
     */
    @JsonProperty("vnicType")
    public String getVnicType() {
        return vnicType;
    }

    /**
     * The virtual network interface card (vNIC) type that is bound to the neutron port.
     */
    @JsonProperty("vnicType")
    public void setVnicType(String vnicType) {
        this.vnicType = vnicType;
    }

    @JsonIgnore
    public NetworkParamBuilder edit() {
        return new NetworkParamBuilder(this);
    }

    @JsonIgnore
    public NetworkParamBuilder toBuilder() {
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
        if (!(o instanceof NetworkParam)) {
            return false;
        }
        NetworkParam other = (NetworkParam) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$filter = this.getFilter();
        Object other$filter = other.getFilter();
        if (this$filter == null ? other$filter != null : !this$filter.equals(other$filter)) {
            return false;
        }
        Object this$fixedIp = this.getFixedIp();
        Object other$fixedIp = other.getFixedIp();
        if (this$fixedIp == null ? other$fixedIp != null : !this$fixedIp.equals(other$fixedIp)) {
            return false;
        }
        Object this$noAllowedAddressPairs = this.getNoAllowedAddressPairs();
        Object other$noAllowedAddressPairs = other.getNoAllowedAddressPairs();
        if (this$noAllowedAddressPairs == null ? other$noAllowedAddressPairs != null : !this$noAllowedAddressPairs.equals(other$noAllowedAddressPairs)) {
            return false;
        }
        Object this$portSecurity = this.getPortSecurity();
        Object other$portSecurity = other.getPortSecurity();
        if (this$portSecurity == null ? other$portSecurity != null : !this$portSecurity.equals(other$portSecurity)) {
            return false;
        }
        Object this$portTags = this.getPortTags();
        Object other$portTags = other.getPortTags();
        if (this$portTags == null ? other$portTags != null : !this$portTags.equals(other$portTags)) {
            return false;
        }
        Object this$profile = this.getProfile();
        Object other$profile = other.getProfile();
        if (this$profile == null ? other$profile != null : !this$profile.equals(other$profile)) {
            return false;
        }
        Object this$subnets = this.getSubnets();
        Object other$subnets = other.getSubnets();
        if (this$subnets == null ? other$subnets != null : !this$subnets.equals(other$subnets)) {
            return false;
        }
        Object this$uuid = this.getUuid();
        Object other$uuid = other.getUuid();
        if (this$uuid == null ? other$uuid != null : !this$uuid.equals(other$uuid)) {
            return false;
        }
        Object this$vnicType = this.getVnicType();
        Object other$vnicType = other.getVnicType();
        if (this$vnicType == null ? other$vnicType != null : !this$vnicType.equals(other$vnicType)) {
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
        return other instanceof NetworkParam;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $filter = this.getFilter();
        result = result * prime + ($filter == null ? 43 : $filter.hashCode());
        Object $fixedIp = this.getFixedIp();
        result = result * prime + ($fixedIp == null ? 43 : $fixedIp.hashCode());
        Object $noAllowedAddressPairs = this.getNoAllowedAddressPairs();
        result = result * prime + ($noAllowedAddressPairs == null ? 43 : $noAllowedAddressPairs.hashCode());
        Object $portSecurity = this.getPortSecurity();
        result = result * prime + ($portSecurity == null ? 43 : $portSecurity.hashCode());
        Object $portTags = this.getPortTags();
        result = result * prime + ($portTags == null ? 43 : $portTags.hashCode());
        Object $profile = this.getProfile();
        result = result * prime + ($profile == null ? 43 : $profile.hashCode());
        Object $subnets = this.getSubnets();
        result = result * prime + ($subnets == null ? 43 : $subnets.hashCode());
        Object $uuid = this.getUuid();
        result = result * prime + ($uuid == null ? 43 : $uuid.hashCode());
        Object $vnicType = this.getVnicType();
        result = result * prime + ($vnicType == null ? 43 : $vnicType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkParam(" + "filter=" + this.getFilter() + ", fixedIp=" + this.getFixedIp() + ", noAllowedAddressPairs=" + this.getNoAllowedAddressPairs() + ", portSecurity=" + this.getPortSecurity() + ", portTags=" + this.getPortTags() + ", profile=" + this.getProfile() + ", subnets=" + this.getSubnets() + ", uuid=" + this.getUuid() + ", vnicType=" + this.getVnicType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
