
package io.fabric8.openshift.api.model.config.v1;

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
 * VSpherePlatformFailureDomainSpec holds the region and zone failure domain and the vCenter topology of that failure domain.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "region",
    "regionAffinity",
    "server",
    "topology",
    "zone",
    "zoneAffinity"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VSpherePlatformFailureDomainSpec implements Editable<VSpherePlatformFailureDomainSpecBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("region")
    private String region;
    @JsonProperty("regionAffinity")
    private VSphereFailureDomainRegionAffinity regionAffinity;
    @JsonProperty("server")
    private String server;
    @JsonProperty("topology")
    private VSpherePlatformTopology topology;
    @JsonProperty("zone")
    private String zone;
    @JsonProperty("zoneAffinity")
    private VSphereFailureDomainZoneAffinity zoneAffinity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VSpherePlatformFailureDomainSpec() {
    }

    public VSpherePlatformFailureDomainSpec(String name, String region, VSphereFailureDomainRegionAffinity regionAffinity, String server, VSpherePlatformTopology topology, String zone, VSphereFailureDomainZoneAffinity zoneAffinity) {
        super();
        this.name = name;
        this.region = region;
        this.regionAffinity = regionAffinity;
        this.server = server;
        this.topology = topology;
        this.zone = zone;
        this.zoneAffinity = zoneAffinity;
    }

    /**
     * name defines the arbitrary but unique name of a failure domain.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name defines the arbitrary but unique name of a failure domain.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * region defines the name of a region tag that will be attached to a vCenter datacenter. The tag category in vCenter must be named openshift-region.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * region defines the name of a region tag that will be attached to a vCenter datacenter. The tag category in vCenter must be named openshift-region.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * VSpherePlatformFailureDomainSpec holds the region and zone failure domain and the vCenter topology of that failure domain.
     */
    @JsonProperty("regionAffinity")
    public VSphereFailureDomainRegionAffinity getRegionAffinity() {
        return regionAffinity;
    }

    /**
     * VSpherePlatformFailureDomainSpec holds the region and zone failure domain and the vCenter topology of that failure domain.
     */
    @JsonProperty("regionAffinity")
    public void setRegionAffinity(VSphereFailureDomainRegionAffinity regionAffinity) {
        this.regionAffinity = regionAffinity;
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
     * VSpherePlatformFailureDomainSpec holds the region and zone failure domain and the vCenter topology of that failure domain.
     */
    @JsonProperty("topology")
    public VSpherePlatformTopology getTopology() {
        return topology;
    }

    /**
     * VSpherePlatformFailureDomainSpec holds the region and zone failure domain and the vCenter topology of that failure domain.
     */
    @JsonProperty("topology")
    public void setTopology(VSpherePlatformTopology topology) {
        this.topology = topology;
    }

    /**
     * zone defines the name of a zone tag that will be attached to a vCenter cluster. The tag category in vCenter must be named openshift-zone.
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * zone defines the name of a zone tag that will be attached to a vCenter cluster. The tag category in vCenter must be named openshift-zone.
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    /**
     * VSpherePlatformFailureDomainSpec holds the region and zone failure domain and the vCenter topology of that failure domain.
     */
    @JsonProperty("zoneAffinity")
    public VSphereFailureDomainZoneAffinity getZoneAffinity() {
        return zoneAffinity;
    }

    /**
     * VSpherePlatformFailureDomainSpec holds the region and zone failure domain and the vCenter topology of that failure domain.
     */
    @JsonProperty("zoneAffinity")
    public void setZoneAffinity(VSphereFailureDomainZoneAffinity zoneAffinity) {
        this.zoneAffinity = zoneAffinity;
    }

    @JsonIgnore
    public VSpherePlatformFailureDomainSpecBuilder edit() {
        return new VSpherePlatformFailureDomainSpecBuilder(this);
    }

    @JsonIgnore
    public VSpherePlatformFailureDomainSpecBuilder toBuilder() {
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
