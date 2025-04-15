
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
