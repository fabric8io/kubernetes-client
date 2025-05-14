
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
     * A fixed IPv4 address for the NIC.
     */
    @JsonProperty("fixedIp")
    public String getFixedIp() {
        return fixedIp;
    }

    /**
     * A fixed IPv4 address for the NIC.
     */
    @JsonProperty("fixedIp")
    public void setFixedIp(String fixedIp) {
        this.fixedIp = fixedIp;
    }

    /**
     * NoAllowedAddressPairs disables creation of allowed address pairs for the network ports
     */
    @JsonProperty("noAllowedAddressPairs")
    public Boolean getNoAllowedAddressPairs() {
        return noAllowedAddressPairs;
    }

    /**
     * NoAllowedAddressPairs disables creation of allowed address pairs for the network ports
     */
    @JsonProperty("noAllowedAddressPairs")
    public void setNoAllowedAddressPairs(Boolean noAllowedAddressPairs) {
        this.noAllowedAddressPairs = noAllowedAddressPairs;
    }

    /**
     * PortSecurity optionally enables or disables security on ports managed by OpenStack
     */
    @JsonProperty("portSecurity")
    public Boolean getPortSecurity() {
        return portSecurity;
    }

    /**
     * PortSecurity optionally enables or disables security on ports managed by OpenStack
     */
    @JsonProperty("portSecurity")
    public void setPortSecurity(Boolean portSecurity) {
        this.portSecurity = portSecurity;
    }

    /**
     * PortTags allows users to specify a list of tags to add to ports created in a given network
     */
    @JsonProperty("portTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPortTags() {
        return portTags;
    }

    /**
     * PortTags allows users to specify a list of tags to add to ports created in a given network
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

}
