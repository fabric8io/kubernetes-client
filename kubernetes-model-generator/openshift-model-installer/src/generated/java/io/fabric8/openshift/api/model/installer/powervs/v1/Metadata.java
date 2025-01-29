
package io.fabric8.openshift.api.model.installer.powervs.v1;

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
import io.fabric8.openshift.api.model.config.v1.PowerVSServiceEndpoint;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "BaseDomain",
    "cisInstanceCRN",
    "dnsInstanceCRN",
    "powerVSResourceGroup",
    "region",
    "serviceEndpoints",
    "serviceInstanceGUID",
    "transitGatewayName",
    "vpcRegion",
    "zone"
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
public class Metadata implements Editable<MetadataBuilder>, KubernetesResource
{

    @JsonProperty("BaseDomain")
    private String baseDomain;
    @JsonProperty("cisInstanceCRN")
    private String cisInstanceCRN;
    @JsonProperty("dnsInstanceCRN")
    private String dnsInstanceCRN;
    @JsonProperty("powerVSResourceGroup")
    private String powerVSResourceGroup;
    @JsonProperty("region")
    private String region;
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PowerVSServiceEndpoint> serviceEndpoints = new ArrayList<>();
    @JsonProperty("serviceInstanceGUID")
    private String serviceInstanceGUID;
    @JsonProperty("transitGatewayName")
    private String transitGatewayName;
    @JsonProperty("vpcRegion")
    private String vpcRegion;
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metadata() {
    }

    public Metadata(String baseDomain, String cisInstanceCRN, String dnsInstanceCRN, String powerVSResourceGroup, String region, List<PowerVSServiceEndpoint> serviceEndpoints, String serviceInstanceGUID, String transitGatewayName, String vpcRegion, String zone) {
        super();
        this.baseDomain = baseDomain;
        this.cisInstanceCRN = cisInstanceCRN;
        this.dnsInstanceCRN = dnsInstanceCRN;
        this.powerVSResourceGroup = powerVSResourceGroup;
        this.region = region;
        this.serviceEndpoints = serviceEndpoints;
        this.serviceInstanceGUID = serviceInstanceGUID;
        this.transitGatewayName = transitGatewayName;
        this.vpcRegion = vpcRegion;
        this.zone = zone;
    }

    @JsonProperty("BaseDomain")
    public String getBaseDomain() {
        return baseDomain;
    }

    @JsonProperty("BaseDomain")
    public void setBaseDomain(String baseDomain) {
        this.baseDomain = baseDomain;
    }

    @JsonProperty("cisInstanceCRN")
    public String getCisInstanceCRN() {
        return cisInstanceCRN;
    }

    @JsonProperty("cisInstanceCRN")
    public void setCisInstanceCRN(String cisInstanceCRN) {
        this.cisInstanceCRN = cisInstanceCRN;
    }

    @JsonProperty("dnsInstanceCRN")
    public String getDnsInstanceCRN() {
        return dnsInstanceCRN;
    }

    @JsonProperty("dnsInstanceCRN")
    public void setDnsInstanceCRN(String dnsInstanceCRN) {
        this.dnsInstanceCRN = dnsInstanceCRN;
    }

    @JsonProperty("powerVSResourceGroup")
    public String getPowerVSResourceGroup() {
        return powerVSResourceGroup;
    }

    @JsonProperty("powerVSResourceGroup")
    public void setPowerVSResourceGroup(String powerVSResourceGroup) {
        this.powerVSResourceGroup = powerVSResourceGroup;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PowerVSServiceEndpoint> getServiceEndpoints() {
        return serviceEndpoints;
    }

    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<PowerVSServiceEndpoint> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

    @JsonProperty("serviceInstanceGUID")
    public String getServiceInstanceGUID() {
        return serviceInstanceGUID;
    }

    @JsonProperty("serviceInstanceGUID")
    public void setServiceInstanceGUID(String serviceInstanceGUID) {
        this.serviceInstanceGUID = serviceInstanceGUID;
    }

    @JsonProperty("transitGatewayName")
    public String getTransitGatewayName() {
        return transitGatewayName;
    }

    @JsonProperty("transitGatewayName")
    public void setTransitGatewayName(String transitGatewayName) {
        this.transitGatewayName = transitGatewayName;
    }

    @JsonProperty("vpcRegion")
    public String getVpcRegion() {
        return vpcRegion;
    }

    @JsonProperty("vpcRegion")
    public void setVpcRegion(String vpcRegion) {
        this.vpcRegion = vpcRegion;
    }

    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonIgnore
    public MetadataBuilder edit() {
        return new MetadataBuilder(this);
    }

    @JsonIgnore
    public MetadataBuilder toBuilder() {
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
