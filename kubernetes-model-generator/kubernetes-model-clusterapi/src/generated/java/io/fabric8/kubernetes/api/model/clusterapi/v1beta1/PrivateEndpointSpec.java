
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * PrivateEndpointSpec configures an Azure Private Endpoint.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "applicationSecurityGroups",
    "customNetworkInterfaceName",
    "location",
    "manualApproval",
    "name",
    "privateIPAddresses",
    "privateLinkServiceConnections"
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
public class PrivateEndpointSpec implements Editable<PrivateEndpointSpecBuilder>, KubernetesResource
{

    @JsonProperty("applicationSecurityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> applicationSecurityGroups = new ArrayList<>();
    @JsonProperty("customNetworkInterfaceName")
    private String customNetworkInterfaceName;
    @JsonProperty("location")
    private String location;
    @JsonProperty("manualApproval")
    private Boolean manualApproval;
    @JsonProperty("name")
    private String name;
    @JsonProperty("privateIPAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> privateIPAddresses = new ArrayList<>();
    @JsonProperty("privateLinkServiceConnections")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrivateLinkServiceConnection> privateLinkServiceConnections = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PrivateEndpointSpec() {
    }

    public PrivateEndpointSpec(List<String> applicationSecurityGroups, String customNetworkInterfaceName, String location, Boolean manualApproval, String name, List<String> privateIPAddresses, List<PrivateLinkServiceConnection> privateLinkServiceConnections) {
        super();
        this.applicationSecurityGroups = applicationSecurityGroups;
        this.customNetworkInterfaceName = customNetworkInterfaceName;
        this.location = location;
        this.manualApproval = manualApproval;
        this.name = name;
        this.privateIPAddresses = privateIPAddresses;
        this.privateLinkServiceConnections = privateLinkServiceConnections;
    }

    /**
     * ApplicationSecurityGroups specifies the Application security group in which the private endpoint IP configuration is included.
     */
    @JsonProperty("applicationSecurityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApplicationSecurityGroups() {
        return applicationSecurityGroups;
    }

    /**
     * ApplicationSecurityGroups specifies the Application security group in which the private endpoint IP configuration is included.
     */
    @JsonProperty("applicationSecurityGroups")
    public void setApplicationSecurityGroups(List<String> applicationSecurityGroups) {
        this.applicationSecurityGroups = applicationSecurityGroups;
    }

    /**
     * CustomNetworkInterfaceName specifies the network interface name associated with the private endpoint.
     */
    @JsonProperty("customNetworkInterfaceName")
    public String getCustomNetworkInterfaceName() {
        return customNetworkInterfaceName;
    }

    /**
     * CustomNetworkInterfaceName specifies the network interface name associated with the private endpoint.
     */
    @JsonProperty("customNetworkInterfaceName")
    public void setCustomNetworkInterfaceName(String customNetworkInterfaceName) {
        this.customNetworkInterfaceName = customNetworkInterfaceName;
    }

    /**
     * Location specifies the region to create the private endpoint.
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * Location specifies the region to create the private endpoint.
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * ManualApproval specifies if the connection approval needs to be done manually or not. Set it true when the network admin does not have access to approve connections to the remote resource. Defaults to false.
     */
    @JsonProperty("manualApproval")
    public Boolean getManualApproval() {
        return manualApproval;
    }

    /**
     * ManualApproval specifies if the connection approval needs to be done manually or not. Set it true when the network admin does not have access to approve connections to the remote resource. Defaults to false.
     */
    @JsonProperty("manualApproval")
    public void setManualApproval(Boolean manualApproval) {
        this.manualApproval = manualApproval;
    }

    /**
     * Name specifies the name of the private endpoint.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name specifies the name of the private endpoint.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * PrivateIPAddresses specifies the IP addresses for the network interface associated with the private endpoint. They have to be part of the subnet where the private endpoint is linked.
     */
    @JsonProperty("privateIPAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPrivateIPAddresses() {
        return privateIPAddresses;
    }

    /**
     * PrivateIPAddresses specifies the IP addresses for the network interface associated with the private endpoint. They have to be part of the subnet where the private endpoint is linked.
     */
    @JsonProperty("privateIPAddresses")
    public void setPrivateIPAddresses(List<String> privateIPAddresses) {
        this.privateIPAddresses = privateIPAddresses;
    }

    /**
     * PrivateLinkServiceConnections specifies Private Link Service Connections of the private endpoint.
     */
    @JsonProperty("privateLinkServiceConnections")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrivateLinkServiceConnection> getPrivateLinkServiceConnections() {
        return privateLinkServiceConnections;
    }

    /**
     * PrivateLinkServiceConnections specifies Private Link Service Connections of the private endpoint.
     */
    @JsonProperty("privateLinkServiceConnections")
    public void setPrivateLinkServiceConnections(List<PrivateLinkServiceConnection> privateLinkServiceConnections) {
        this.privateLinkServiceConnections = privateLinkServiceConnections;
    }

    @JsonIgnore
    public PrivateEndpointSpecBuilder edit() {
        return new PrivateEndpointSpecBuilder(this);
    }

    @JsonIgnore
    public PrivateEndpointSpecBuilder toBuilder() {
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
