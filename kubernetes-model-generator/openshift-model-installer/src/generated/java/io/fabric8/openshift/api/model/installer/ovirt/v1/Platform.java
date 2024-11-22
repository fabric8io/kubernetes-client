
package io.fabric8.openshift.api.model.installer.ovirt.v1;

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
import io.fabric8.openshift.api.model.config.v1.OvirtPlatformLoadBalancer;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "affinityGroups",
    "api_vip",
    "api_vips",
    "defaultMachinePlatform",
    "ingress_vip",
    "ingress_vips",
    "loadBalancer",
    "ovirt_cluster_id",
    "ovirt_network_name",
    "ovirt_storage_domain_id",
    "vnicProfileID"
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
public class Platform implements Editable<PlatformBuilder> , KubernetesResource
{

    @JsonProperty("affinityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AffinityGroup> affinityGroups = new ArrayList<>();
    @JsonProperty("api_vip")
    private String api_vip;
    @JsonProperty("api_vips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> api_vips = new ArrayList<>();
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("ingress_vip")
    private String ingress_vip;
    @JsonProperty("ingress_vips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingress_vips = new ArrayList<>();
    @JsonProperty("loadBalancer")
    private OvirtPlatformLoadBalancer loadBalancer;
    @JsonProperty("ovirt_cluster_id")
    private String ovirt_cluster_id;
    @JsonProperty("ovirt_network_name")
    private String ovirt_network_name;
    @JsonProperty("ovirt_storage_domain_id")
    private String ovirt_storage_domain_id;
    @JsonProperty("vnicProfileID")
    private String vnicProfileID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    public Platform(List<AffinityGroup> affinityGroups, String api_vip, List<String> api_vips, MachinePool defaultMachinePlatform, String ingress_vip, List<String> ingress_vips, OvirtPlatformLoadBalancer loadBalancer, String ovirt_cluster_id, String ovirt_network_name, String ovirt_storage_domain_id, String vnicProfileID) {
        super();
        this.affinityGroups = affinityGroups;
        this.api_vip = api_vip;
        this.api_vips = api_vips;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.ingress_vip = ingress_vip;
        this.ingress_vips = ingress_vips;
        this.loadBalancer = loadBalancer;
        this.ovirt_cluster_id = ovirt_cluster_id;
        this.ovirt_network_name = ovirt_network_name;
        this.ovirt_storage_domain_id = ovirt_storage_domain_id;
        this.vnicProfileID = vnicProfileID;
    }

    @JsonProperty("affinityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AffinityGroup> getAffinityGroups() {
        return affinityGroups;
    }

    @JsonProperty("affinityGroups")
    public void setAffinityGroups(List<AffinityGroup> affinityGroups) {
        this.affinityGroups = affinityGroups;
    }

    @JsonProperty("api_vip")
    public String getApi_vip() {
        return api_vip;
    }

    @JsonProperty("api_vip")
    public void setApi_vip(String api_vip) {
        this.api_vip = api_vip;
    }

    @JsonProperty("api_vips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApi_vips() {
        return api_vips;
    }

    @JsonProperty("api_vips")
    public void setApi_vips(List<String> api_vips) {
        this.api_vips = api_vips;
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
    public String getIngress_vip() {
        return ingress_vip;
    }

    @JsonProperty("ingress_vip")
    public void setIngress_vip(String ingress_vip) {
        this.ingress_vip = ingress_vip;
    }

    @JsonProperty("ingress_vips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIngress_vips() {
        return ingress_vips;
    }

    @JsonProperty("ingress_vips")
    public void setIngress_vips(List<String> ingress_vips) {
        this.ingress_vips = ingress_vips;
    }

    @JsonProperty("loadBalancer")
    public OvirtPlatformLoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    @JsonProperty("loadBalancer")
    public void setLoadBalancer(OvirtPlatformLoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    @JsonProperty("ovirt_cluster_id")
    public String getOvirt_cluster_id() {
        return ovirt_cluster_id;
    }

    @JsonProperty("ovirt_cluster_id")
    public void setOvirt_cluster_id(String ovirt_cluster_id) {
        this.ovirt_cluster_id = ovirt_cluster_id;
    }

    @JsonProperty("ovirt_network_name")
    public String getOvirt_network_name() {
        return ovirt_network_name;
    }

    @JsonProperty("ovirt_network_name")
    public void setOvirt_network_name(String ovirt_network_name) {
        this.ovirt_network_name = ovirt_network_name;
    }

    @JsonProperty("ovirt_storage_domain_id")
    public String getOvirt_storage_domain_id() {
        return ovirt_storage_domain_id;
    }

    @JsonProperty("ovirt_storage_domain_id")
    public void setOvirt_storage_domain_id(String ovirt_storage_domain_id) {
        this.ovirt_storage_domain_id = ovirt_storage_domain_id;
    }

    @JsonProperty("vnicProfileID")
    public String getVnicProfileID() {
        return vnicProfileID;
    }

    @JsonProperty("vnicProfileID")
    public void setVnicProfileID(String vnicProfileID) {
        this.vnicProfileID = vnicProfileID;
    }

    @JsonIgnore
    public PlatformBuilder edit() {
        return new PlatformBuilder(this);
    }

    @JsonIgnore
    public PlatformBuilder toBuilder() {
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
