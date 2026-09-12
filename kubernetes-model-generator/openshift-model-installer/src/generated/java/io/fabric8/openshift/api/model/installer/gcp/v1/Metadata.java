
package io.fabric8.openshift.api.model.installer.gcp.v1;

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
 * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "endpoint",
    "firewallRulesManagement",
    "networkProjectID",
    "privateZoneDomain",
    "privateZoneProjectID",
    "projectID",
    "region"
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

    @JsonProperty("endpoint")
    private PSCEndpoint endpoint;
    @JsonProperty("firewallRulesManagement")
    private String firewallRulesManagement;
    @JsonProperty("networkProjectID")
    private String networkProjectID;
    @JsonProperty("privateZoneDomain")
    private String privateZoneDomain;
    @JsonProperty("privateZoneProjectID")
    private String privateZoneProjectID;
    @JsonProperty("projectID")
    private String projectID;
    @JsonProperty("region")
    private String region;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metadata() {
    }

    public Metadata(PSCEndpoint endpoint, String firewallRulesManagement, String networkProjectID, String privateZoneDomain, String privateZoneProjectID, String projectID, String region) {
        super();
        this.endpoint = endpoint;
        this.firewallRulesManagement = firewallRulesManagement;
        this.networkProjectID = networkProjectID;
        this.privateZoneDomain = privateZoneDomain;
        this.privateZoneProjectID = privateZoneProjectID;
        this.projectID = projectID;
        this.region = region;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("endpoint")
    public PSCEndpoint getEndpoint() {
        return endpoint;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("endpoint")
    public void setEndpoint(PSCEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("firewallRulesManagement")
    public String getFirewallRulesManagement() {
        return firewallRulesManagement;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("firewallRulesManagement")
    public void setFirewallRulesManagement(String firewallRulesManagement) {
        this.firewallRulesManagement = firewallRulesManagement;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("networkProjectID")
    public String getNetworkProjectID() {
        return networkProjectID;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("networkProjectID")
    public void setNetworkProjectID(String networkProjectID) {
        this.networkProjectID = networkProjectID;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("privateZoneDomain")
    public String getPrivateZoneDomain() {
        return privateZoneDomain;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("privateZoneDomain")
    public void setPrivateZoneDomain(String privateZoneDomain) {
        this.privateZoneDomain = privateZoneDomain;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("privateZoneProjectID")
    public String getPrivateZoneProjectID() {
        return privateZoneProjectID;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("privateZoneProjectID")
    public void setPrivateZoneProjectID(String privateZoneProjectID) {
        this.privateZoneProjectID = privateZoneProjectID;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Metadata contains GCP metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
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
        if (!(o instanceof Metadata)) {
            return false;
        }
        Metadata other = (Metadata) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$endpoint = this.getEndpoint();
        Object other$endpoint = other.getEndpoint();
        if (this$endpoint == null ? other$endpoint != null : !this$endpoint.equals(other$endpoint)) {
            return false;
        }
        Object this$firewallRulesManagement = this.getFirewallRulesManagement();
        Object other$firewallRulesManagement = other.getFirewallRulesManagement();
        if (this$firewallRulesManagement == null ? other$firewallRulesManagement != null : !this$firewallRulesManagement.equals(other$firewallRulesManagement)) {
            return false;
        }
        Object this$networkProjectID = this.getNetworkProjectID();
        Object other$networkProjectID = other.getNetworkProjectID();
        if (this$networkProjectID == null ? other$networkProjectID != null : !this$networkProjectID.equals(other$networkProjectID)) {
            return false;
        }
        Object this$privateZoneDomain = this.getPrivateZoneDomain();
        Object other$privateZoneDomain = other.getPrivateZoneDomain();
        if (this$privateZoneDomain == null ? other$privateZoneDomain != null : !this$privateZoneDomain.equals(other$privateZoneDomain)) {
            return false;
        }
        Object this$privateZoneProjectID = this.getPrivateZoneProjectID();
        Object other$privateZoneProjectID = other.getPrivateZoneProjectID();
        if (this$privateZoneProjectID == null ? other$privateZoneProjectID != null : !this$privateZoneProjectID.equals(other$privateZoneProjectID)) {
            return false;
        }
        Object this$projectID = this.getProjectID();
        Object other$projectID = other.getProjectID();
        if (this$projectID == null ? other$projectID != null : !this$projectID.equals(other$projectID)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
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
        return other instanceof Metadata;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $endpoint = this.getEndpoint();
        result = result * prime + ($endpoint == null ? 43 : $endpoint.hashCode());
        Object $firewallRulesManagement = this.getFirewallRulesManagement();
        result = result * prime + ($firewallRulesManagement == null ? 43 : $firewallRulesManagement.hashCode());
        Object $networkProjectID = this.getNetworkProjectID();
        result = result * prime + ($networkProjectID == null ? 43 : $networkProjectID.hashCode());
        Object $privateZoneDomain = this.getPrivateZoneDomain();
        result = result * prime + ($privateZoneDomain == null ? 43 : $privateZoneDomain.hashCode());
        Object $privateZoneProjectID = this.getPrivateZoneProjectID();
        result = result * prime + ($privateZoneProjectID == null ? 43 : $privateZoneProjectID.hashCode());
        Object $projectID = this.getProjectID();
        result = result * prime + ($projectID == null ? 43 : $projectID.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metadata(" + "endpoint=" + this.getEndpoint() + ", firewallRulesManagement=" + this.getFirewallRulesManagement() + ", networkProjectID=" + this.getNetworkProjectID() + ", privateZoneDomain=" + this.getPrivateZoneDomain() + ", privateZoneProjectID=" + this.getPrivateZoneProjectID() + ", projectID=" + this.getProjectID() + ", region=" + this.getRegion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
