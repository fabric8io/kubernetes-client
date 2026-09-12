
package io.fabric8.openshift.api.model.installer.vsphere.v1;

import java.util.LinkedHashMap;
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

/**
 * FailureDomain holds the region and zone failure domain and the vCenter topology of that failure domain.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "region",
    "regionType",
    "server",
    "topology",
    "zone",
    "zoneType"
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
public class FailureDomain implements Editable<FailureDomainBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("region")
    private String region;
    @JsonProperty("regionType")
    private String regionType;
    @JsonProperty("server")
    private String server;
    @JsonProperty("topology")
    private Topology topology;
    @JsonProperty("zone")
    private String zone;
    @JsonProperty("zoneType")
    private String zoneType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FailureDomain() {
    }

    public FailureDomain(String name, String region, String regionType, String server, Topology topology, String zone, String zoneType) {
        super();
        this.name = name;
        this.region = region;
        this.regionType = regionType;
        this.server = server;
        this.topology = topology;
        this.zone = zone;
        this.zoneType = zoneType;
    }

    /**
     * name defines the name of the FailureDomain This name is arbitrary but will be used in VSpherePlatformDeploymentZone for association.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name defines the name of the FailureDomain This name is arbitrary but will be used in VSpherePlatformDeploymentZone for association.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The region is the name of the tag in vCenter that is associated with the tag category `openshift-region`. The region name must match the tag name and must exist prior to installation. When the regionType is Datacenter the tag must be attached to the toplogy.datacenter object in vCenter. When the regionType is ComputeCluster the tag must be attached to the topology.computeCluster object in vCenter.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * The region is the name of the tag in vCenter that is associated with the tag category `openshift-region`. The region name must match the tag name and must exist prior to installation. When the regionType is Datacenter the tag must be attached to the toplogy.datacenter object in vCenter. When the regionType is ComputeCluster the tag must be attached to the topology.computeCluster object in vCenter.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * regionType is the type of failure domain region, the current values are "Datacenter" and "ComputeCluster" When regionType is Datacenter the zoneType must be ComputeCluster. When regionType is ComputeCluster the zoneType must be HostGroup
     */
    @JsonProperty("regionType")
    public String getRegionType() {
        return regionType;
    }

    /**
     * regionType is the type of failure domain region, the current values are "Datacenter" and "ComputeCluster" When regionType is Datacenter the zoneType must be ComputeCluster. When regionType is ComputeCluster the zoneType must be HostGroup
     */
    @JsonProperty("regionType")
    public void setRegionType(String regionType) {
        this.regionType = regionType;
    }

    /**
     * server is the fully-qualified domain name or the IP address of the vCenter server.
     */
    @JsonProperty("server")
    public String getServer() {
        return server;
    }

    /**
     * server is the fully-qualified domain name or the IP address of the vCenter server.
     */
    @JsonProperty("server")
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * FailureDomain holds the region and zone failure domain and the vCenter topology of that failure domain.
     */
    @JsonProperty("topology")
    public Topology getTopology() {
        return topology;
    }

    /**
     * FailureDomain holds the region and zone failure domain and the vCenter topology of that failure domain.
     */
    @JsonProperty("topology")
    public void setTopology(Topology topology) {
        this.topology = topology;
    }

    /**
     * The zone is the name of the tag in vCenter that is associated with the tag category `openshift-zone`. The zone name must match the tag name and must exist prior to installation. When zoneType is HostGroup the ESXi hosts defined in the provided in the topology.hostGroup field must be tagged. When the zoneType is ComputeCluster the tag must be attached to the topology.computeCluster object in vCenter.
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * The zone is the name of the tag in vCenter that is associated with the tag category `openshift-zone`. The zone name must match the tag name and must exist prior to installation. When zoneType is HostGroup the ESXi hosts defined in the provided in the topology.hostGroup field must be tagged. When the zoneType is ComputeCluster the tag must be attached to the topology.computeCluster object in vCenter.
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    /**
     * When zoneType is ComputeCluster the regionType must be Datacenter When zoneType is HostGroup the regionType must be ComputeCluster If the zoneType is HostGroup topology.hostGroup must be defined and exist in vCenter prior to installation.
     */
    @JsonProperty("zoneType")
    public String getZoneType() {
        return zoneType;
    }

    /**
     * When zoneType is ComputeCluster the regionType must be Datacenter When zoneType is HostGroup the regionType must be ComputeCluster If the zoneType is HostGroup topology.hostGroup must be defined and exist in vCenter prior to installation.
     */
    @JsonProperty("zoneType")
    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    @JsonIgnore
    public FailureDomainBuilder edit() {
        return new FailureDomainBuilder(this);
    }

    @JsonIgnore
    public FailureDomainBuilder toBuilder() {
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
        if (!(o instanceof FailureDomain)) {
            return false;
        }
        FailureDomain other = (FailureDomain) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$regionType = this.getRegionType();
        Object other$regionType = other.getRegionType();
        if (this$regionType == null ? other$regionType != null : !this$regionType.equals(other$regionType)) {
            return false;
        }
        Object this$server = this.getServer();
        Object other$server = other.getServer();
        if (this$server == null ? other$server != null : !this$server.equals(other$server)) {
            return false;
        }
        Object this$topology = this.getTopology();
        Object other$topology = other.getTopology();
        if (this$topology == null ? other$topology != null : !this$topology.equals(other$topology)) {
            return false;
        }
        Object this$zone = this.getZone();
        Object other$zone = other.getZone();
        if (this$zone == null ? other$zone != null : !this$zone.equals(other$zone)) {
            return false;
        }
        Object this$zoneType = this.getZoneType();
        Object other$zoneType = other.getZoneType();
        if (this$zoneType == null ? other$zoneType != null : !this$zoneType.equals(other$zoneType)) {
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
        return other instanceof FailureDomain;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $regionType = this.getRegionType();
        result = result * prime + ($regionType == null ? 43 : $regionType.hashCode());
        Object $server = this.getServer();
        result = result * prime + ($server == null ? 43 : $server.hashCode());
        Object $topology = this.getTopology();
        result = result * prime + ($topology == null ? 43 : $topology.hashCode());
        Object $zone = this.getZone();
        result = result * prime + ($zone == null ? 43 : $zone.hashCode());
        Object $zoneType = this.getZoneType();
        result = result * prime + ($zoneType == null ? 43 : $zoneType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FailureDomain(" + "name=" + this.getName() + ", region=" + this.getRegion() + ", regionType=" + this.getRegionType() + ", server=" + this.getServer() + ", topology=" + this.getTopology() + ", zone=" + this.getZone() + ", zoneType=" + this.getZoneType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
