
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.infrastructure.v1beta1;

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

/**
 * SubnetClassSpec defines the SubnetSpec properties that may be shared across several Azure clusters.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cidrBlocks",
    "name",
    "privateEndpoints",
    "role",
    "serviceEndpoints"
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
public class SubnetClassSpec implements Editable<SubnetClassSpecBuilder>, KubernetesResource
{

    @JsonProperty("cidrBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> cidrBlocks = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("privateEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PrivateEndpointSpec> privateEndpoints = new ArrayList<>();
    @JsonProperty("role")
    private String role;
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ServiceEndpointSpec> serviceEndpoints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubnetClassSpec() {
    }

    public SubnetClassSpec(List<String> cidrBlocks, String name, List<PrivateEndpointSpec> privateEndpoints, String role, List<ServiceEndpointSpec> serviceEndpoints) {
        super();
        this.cidrBlocks = cidrBlocks;
        this.name = name;
        this.privateEndpoints = privateEndpoints;
        this.role = role;
        this.serviceEndpoints = serviceEndpoints;
    }

    /**
     * CIDRBlocks defines the subnet's address space, specified as one or more address prefixes in CIDR notation.
     */
    @JsonProperty("cidrBlocks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCidrBlocks() {
        return cidrBlocks;
    }

    /**
     * CIDRBlocks defines the subnet's address space, specified as one or more address prefixes in CIDR notation.
     */
    @JsonProperty("cidrBlocks")
    public void setCidrBlocks(List<String> cidrBlocks) {
        this.cidrBlocks = cidrBlocks;
    }

    /**
     * Name defines a name for the subnet resource.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name defines a name for the subnet resource.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * PrivateEndpoints defines a list of private endpoints that should be attached to this subnet.
     */
    @JsonProperty("privateEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PrivateEndpointSpec> getPrivateEndpoints() {
        return privateEndpoints;
    }

    /**
     * PrivateEndpoints defines a list of private endpoints that should be attached to this subnet.
     */
    @JsonProperty("privateEndpoints")
    public void setPrivateEndpoints(List<PrivateEndpointSpec> privateEndpoints) {
        this.privateEndpoints = privateEndpoints;
    }

    /**
     * Role defines the subnet role (eg. Node, ControlPlane)
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * Role defines the subnet role (eg. Node, ControlPlane)
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * ServiceEndpoints is a slice of Virtual Network service endpoints to enable for the subnets.
     */
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ServiceEndpointSpec> getServiceEndpoints() {
        return serviceEndpoints;
    }

    /**
     * ServiceEndpoints is a slice of Virtual Network service endpoints to enable for the subnets.
     */
    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<ServiceEndpointSpec> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

    @JsonIgnore
    public SubnetClassSpecBuilder edit() {
        return new SubnetClassSpecBuilder(this);
    }

    @JsonIgnore
    public SubnetClassSpecBuilder toBuilder() {
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
