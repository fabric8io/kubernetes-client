
package io.fabric8.openshift.api.model.installer.ovirt.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "affinityGroups",
    "api_vip",
    "defaultMachinePlatform",
    "ingress_vip",
    "ovirt_cluster_id",
    "ovirt_network_name",
    "ovirt_storage_domain_id",
    "vnicProfileID"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class Platform implements KubernetesResource
{

    @JsonProperty("affinityGroups")
    private List<AffinityGroup> affinityGroups = new ArrayList<AffinityGroup>();
    @JsonProperty("api_vip")
    private String apiVip;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("ingress_vip")
    private String ingressVip;
    @JsonProperty("ovirt_cluster_id")
    private String ovirtClusterId;
    @JsonProperty("ovirt_network_name")
    private String ovirtNetworkName;
    @JsonProperty("ovirt_storage_domain_id")
    private String ovirtStorageDomainId;
    @JsonProperty("vnicProfileID")
    private String vnicProfileID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    /**
     * 
     * @param ovirtStorageDomainId
     * @param vnicProfileID
     * @param apiVip
     * @param ingressVip
     * @param defaultMachinePlatform
     * @param ovirtNetworkName
     * @param ovirtClusterId
     * @param affinityGroups
     */
    public Platform(List<AffinityGroup> affinityGroups, String apiVip, MachinePool defaultMachinePlatform, String ingressVip, String ovirtClusterId, String ovirtNetworkName, String ovirtStorageDomainId, String vnicProfileID) {
        super();
        this.affinityGroups = affinityGroups;
        this.apiVip = apiVip;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.ingressVip = ingressVip;
        this.ovirtClusterId = ovirtClusterId;
        this.ovirtNetworkName = ovirtNetworkName;
        this.ovirtStorageDomainId = ovirtStorageDomainId;
        this.vnicProfileID = vnicProfileID;
    }

    @JsonProperty("affinityGroups")
    public List<AffinityGroup> getAffinityGroups() {
        return affinityGroups;
    }

    @JsonProperty("affinityGroups")
    public void setAffinityGroups(List<AffinityGroup> affinityGroups) {
        this.affinityGroups = affinityGroups;
    }

    @JsonProperty("api_vip")
    public String getApiVip() {
        return apiVip;
    }

    @JsonProperty("api_vip")
    public void setApiVip(String apiVip) {
        this.apiVip = apiVip;
    }

    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    @JsonProperty("ingress_vip")
    public String getIngressVip() {
        return ingressVip;
    }

    @JsonProperty("ingress_vip")
    public void setIngressVip(String ingressVip) {
        this.ingressVip = ingressVip;
    }

    @JsonProperty("ovirt_cluster_id")
    public String getOvirtClusterId() {
        return ovirtClusterId;
    }

    @JsonProperty("ovirt_cluster_id")
    public void setOvirtClusterId(String ovirtClusterId) {
        this.ovirtClusterId = ovirtClusterId;
    }

    @JsonProperty("ovirt_network_name")
    public String getOvirtNetworkName() {
        return ovirtNetworkName;
    }

    @JsonProperty("ovirt_network_name")
    public void setOvirtNetworkName(String ovirtNetworkName) {
        this.ovirtNetworkName = ovirtNetworkName;
    }

    @JsonProperty("ovirt_storage_domain_id")
    public String getOvirtStorageDomainId() {
        return ovirtStorageDomainId;
    }

    @JsonProperty("ovirt_storage_domain_id")
    public void setOvirtStorageDomainId(String ovirtStorageDomainId) {
        this.ovirtStorageDomainId = ovirtStorageDomainId;
    }

    @JsonProperty("vnicProfileID")
    public String getVnicProfileID() {
        return vnicProfileID;
    }

    @JsonProperty("vnicProfileID")
    public void setVnicProfileID(String vnicProfileID) {
        this.vnicProfileID = vnicProfileID;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
