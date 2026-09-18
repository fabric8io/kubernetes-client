
package io.fabric8.openshift.api.model.installer.aws.v1;

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

/**
 * Metadata contains AWS metadata (e.g. for uninstalling the cluster).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterDomain",
    "hostedZoneRole",
    "identifier",
    "region",
    "serviceEndpoints"
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

    @JsonProperty("clusterDomain")
    private String clusterDomain;
    @JsonProperty("hostedZoneRole")
    private String hostedZoneRole;
    @JsonProperty("identifier")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Map<String, String>> identifier = new ArrayList<>();
    @JsonProperty("region")
    private String region;
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ServiceEndpoint> serviceEndpoints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metadata() {
    }

    public Metadata(String clusterDomain, String hostedZoneRole, List<Map<String, String>> identifier, String region, List<ServiceEndpoint> serviceEndpoints) {
        super();
        this.clusterDomain = clusterDomain;
        this.hostedZoneRole = hostedZoneRole;
        this.identifier = identifier;
        this.region = region;
        this.serviceEndpoints = serviceEndpoints;
    }

    /**
     * ClusterDomain is the domain for the cluster.
     */
    @JsonProperty("clusterDomain")
    public String getClusterDomain() {
        return clusterDomain;
    }

    /**
     * ClusterDomain is the domain for the cluster.
     */
    @JsonProperty("clusterDomain")
    public void setClusterDomain(String clusterDomain) {
        this.clusterDomain = clusterDomain;
    }

    /**
     * HostedZoneRole is the role to assume when performing operations on a hosted zone owned by another account.
     */
    @JsonProperty("hostedZoneRole")
    public String getHostedZoneRole() {
        return hostedZoneRole;
    }

    /**
     * HostedZoneRole is the role to assume when performing operations on a hosted zone owned by another account.
     */
    @JsonProperty("hostedZoneRole")
    public void setHostedZoneRole(String hostedZoneRole) {
        this.hostedZoneRole = hostedZoneRole;
    }

    /**
     * Identifier holds a slice of filter maps.  The maps hold the key/value pairs for the tags we will be matching against.  A resource matches the map if all of the key/value pairs are in its tags.  A resource matches Identifier if it matches any of the maps.
     */
    @JsonProperty("identifier")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Map<String, String>> getIdentifier() {
        return identifier;
    }

    /**
     * Identifier holds a slice of filter maps.  The maps hold the key/value pairs for the tags we will be matching against.  A resource matches the map if all of the key/value pairs are in its tags.  A resource matches Identifier if it matches any of the maps.
     */
    @JsonProperty("identifier")
    public void setIdentifier(List<Map<String, String>> identifier) {
        this.identifier = identifier;
    }

    /**
     * Metadata contains AWS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Metadata contains AWS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * ServiceEndpoints list contains custom endpoints which will override default service endpoint of AWS Services. There must be only one ServiceEndpoint for a service.
     */
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ServiceEndpoint> getServiceEndpoints() {
        return serviceEndpoints;
    }

    /**
     * ServiceEndpoints list contains custom endpoints which will override default service endpoint of AWS Services. There must be only one ServiceEndpoint for a service.
     */
    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<ServiceEndpoint> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
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
        Object this$clusterDomain = this.getClusterDomain();
        Object other$clusterDomain = other.getClusterDomain();
        if (this$clusterDomain == null ? other$clusterDomain != null : !this$clusterDomain.equals(other$clusterDomain)) {
            return false;
        }
        Object this$hostedZoneRole = this.getHostedZoneRole();
        Object other$hostedZoneRole = other.getHostedZoneRole();
        if (this$hostedZoneRole == null ? other$hostedZoneRole != null : !this$hostedZoneRole.equals(other$hostedZoneRole)) {
            return false;
        }
        Object this$identifier = this.getIdentifier();
        Object other$identifier = other.getIdentifier();
        if (this$identifier == null ? other$identifier != null : !this$identifier.equals(other$identifier)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$serviceEndpoints = this.getServiceEndpoints();
        Object other$serviceEndpoints = other.getServiceEndpoints();
        if (this$serviceEndpoints == null ? other$serviceEndpoints != null : !this$serviceEndpoints.equals(other$serviceEndpoints)) {
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
        Object $clusterDomain = this.getClusterDomain();
        result = result * prime + ($clusterDomain == null ? 43 : $clusterDomain.hashCode());
        Object $hostedZoneRole = this.getHostedZoneRole();
        result = result * prime + ($hostedZoneRole == null ? 43 : $hostedZoneRole.hashCode());
        Object $identifier = this.getIdentifier();
        result = result * prime + ($identifier == null ? 43 : $identifier.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $serviceEndpoints = this.getServiceEndpoints();
        result = result * prime + ($serviceEndpoints == null ? 43 : $serviceEndpoints.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metadata(" + "clusterDomain=" + this.getClusterDomain() + ", hostedZoneRole=" + this.getHostedZoneRole() + ", identifier=" + this.getIdentifier() + ", region=" + this.getRegion() + ", serviceEndpoints=" + this.getServiceEndpoints() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
