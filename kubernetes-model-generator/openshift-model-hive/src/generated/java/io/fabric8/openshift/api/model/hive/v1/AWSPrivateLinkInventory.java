
package io.fabric8.openshift.api.model.hive.v1;

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

/**
 * AWSPrivateLinkInventory is a VPC and its corresponding subnets in an AWS region. This VPC will be used to create an AWS VPC Endpoint whenever there is a VPC Endpoint Service created for a ClusterDeployment.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "region",
    "subnets",
    "vpcID"
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
public class AWSPrivateLinkInventory implements Editable<AWSPrivateLinkInventoryBuilder>, KubernetesResource
{

    @JsonProperty("region")
    private String region;
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AWSPrivateLinkSubnet> subnets = new ArrayList<>();
    @JsonProperty("vpcID")
    private String vpcID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSPrivateLinkInventory() {
    }

    public AWSPrivateLinkInventory(String region, List<AWSPrivateLinkSubnet> subnets, String vpcID) {
        super();
        this.region = region;
        this.subnets = subnets;
        this.vpcID = vpcID;
    }

    /**
     * AWSPrivateLinkInventory is a VPC and its corresponding subnets in an AWS region. This VPC will be used to create an AWS VPC Endpoint whenever there is a VPC Endpoint Service created for a ClusterDeployment.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * AWSPrivateLinkInventory is a VPC and its corresponding subnets in an AWS region. This VPC will be used to create an AWS VPC Endpoint whenever there is a VPC Endpoint Service created for a ClusterDeployment.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * AWSPrivateLinkInventory is a VPC and its corresponding subnets in an AWS region. This VPC will be used to create an AWS VPC Endpoint whenever there is a VPC Endpoint Service created for a ClusterDeployment.
     */
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AWSPrivateLinkSubnet> getSubnets() {
        return subnets;
    }

    /**
     * AWSPrivateLinkInventory is a VPC and its corresponding subnets in an AWS region. This VPC will be used to create an AWS VPC Endpoint whenever there is a VPC Endpoint Service created for a ClusterDeployment.
     */
    @JsonProperty("subnets")
    public void setSubnets(List<AWSPrivateLinkSubnet> subnets) {
        this.subnets = subnets;
    }

    /**
     * AWSPrivateLinkInventory is a VPC and its corresponding subnets in an AWS region. This VPC will be used to create an AWS VPC Endpoint whenever there is a VPC Endpoint Service created for a ClusterDeployment.
     */
    @JsonProperty("vpcID")
    public String getVpcID() {
        return vpcID;
    }

    /**
     * AWSPrivateLinkInventory is a VPC and its corresponding subnets in an AWS region. This VPC will be used to create an AWS VPC Endpoint whenever there is a VPC Endpoint Service created for a ClusterDeployment.
     */
    @JsonProperty("vpcID")
    public void setVpcID(String vpcID) {
        this.vpcID = vpcID;
    }

    @JsonIgnore
    public AWSPrivateLinkInventoryBuilder edit() {
        return new AWSPrivateLinkInventoryBuilder(this);
    }

    @JsonIgnore
    public AWSPrivateLinkInventoryBuilder toBuilder() {
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
