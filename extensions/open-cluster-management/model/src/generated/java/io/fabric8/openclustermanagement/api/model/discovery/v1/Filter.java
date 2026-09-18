
package io.fabric8.openclustermanagement.api.model.discovery.v1;

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
 * Filter defines the criteria for discovering clusters based on specific attributes.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterTypes",
    "infrastructureProviders",
    "lastActive",
    "openShiftVersions",
    "regions"
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
public class Filter implements Editable<FilterBuilder>, KubernetesResource
{

    @JsonProperty("clusterTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> clusterTypes = new ArrayList<>();
    @JsonProperty("infrastructureProviders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> infrastructureProviders = new ArrayList<>();
    @JsonProperty("lastActive")
    private Integer lastActive;
    @JsonProperty("openShiftVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> openShiftVersions = new ArrayList<>();
    @JsonProperty("regions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> regions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Filter() {
    }

    public Filter(List<String> clusterTypes, List<String> infrastructureProviders, Integer lastActive, List<String> openShiftVersions, List<String> regions) {
        super();
        this.clusterTypes = clusterTypes;
        this.infrastructureProviders = infrastructureProviders;
        this.lastActive = lastActive;
        this.openShiftVersions = openShiftVersions;
        this.regions = regions;
    }

    /**
     * ClusterTypes is the list of cluster types to discover. These types represent the platform the cluster is running on, such as OpenShift Container Platform (OCP), Azure Red Hat OpenShift (ARO), or others.
     */
    @JsonProperty("clusterTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getClusterTypes() {
        return clusterTypes;
    }

    /**
     * ClusterTypes is the list of cluster types to discover. These types represent the platform the cluster is running on, such as OpenShift Container Platform (OCP), Azure Red Hat OpenShift (ARO), or others.
     */
    @JsonProperty("clusterTypes")
    public void setClusterTypes(List<String> clusterTypes) {
        this.clusterTypes = clusterTypes;
    }

    /**
     * InfrastructureProviders is the list of infrastructure providers to discover. This can be a list of cloud providers or platforms (e.g., AWS, Azure, GCP) where clusters might be running.
     */
    @JsonProperty("infrastructureProviders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getInfrastructureProviders() {
        return infrastructureProviders;
    }

    /**
     * InfrastructureProviders is the list of infrastructure providers to discover. This can be a list of cloud providers or platforms (e.g., AWS, Azure, GCP) where clusters might be running.
     */
    @JsonProperty("infrastructureProviders")
    public void setInfrastructureProviders(List<String> infrastructureProviders) {
        this.infrastructureProviders = infrastructureProviders;
    }

    /**
     * LastActive is the last active in days of clusters to discover, determined by activity timestamp
     */
    @JsonProperty("lastActive")
    public Integer getLastActive() {
        return lastActive;
    }

    /**
     * LastActive is the last active in days of clusters to discover, determined by activity timestamp
     */
    @JsonProperty("lastActive")
    public void setLastActive(Integer lastActive) {
        this.lastActive = lastActive;
    }

    /**
     * OpenShiftVersions is the list of release versions of OpenShift of the form "&lt;Major&gt;.&lt;Minor&gt;"
     */
    @JsonProperty("openShiftVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOpenShiftVersions() {
        return openShiftVersions;
    }

    /**
     * OpenShiftVersions is the list of release versions of OpenShift of the form "&lt;Major&gt;.&lt;Minor&gt;"
     */
    @JsonProperty("openShiftVersions")
    public void setOpenShiftVersions(List<String> openShiftVersions) {
        this.openShiftVersions = openShiftVersions;
    }

    /**
     * Regions is the list of regions where OpenShift clusters are located. This helps in filtering clusters based on geographic location or data center region, useful for compliance or latency requirements.
     */
    @JsonProperty("regions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRegions() {
        return regions;
    }

    /**
     * Regions is the list of regions where OpenShift clusters are located. This helps in filtering clusters based on geographic location or data center region, useful for compliance or latency requirements.
     */
    @JsonProperty("regions")
    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    @JsonIgnore
    public FilterBuilder edit() {
        return new FilterBuilder(this);
    }

    @JsonIgnore
    public FilterBuilder toBuilder() {
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
        if (!(o instanceof Filter)) {
            return false;
        }
        Filter other = (Filter) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterTypes = this.getClusterTypes();
        Object other$clusterTypes = other.getClusterTypes();
        if (this$clusterTypes == null ? other$clusterTypes != null : !this$clusterTypes.equals(other$clusterTypes)) {
            return false;
        }
        Object this$infrastructureProviders = this.getInfrastructureProviders();
        Object other$infrastructureProviders = other.getInfrastructureProviders();
        if (this$infrastructureProviders == null ? other$infrastructureProviders != null : !this$infrastructureProviders.equals(other$infrastructureProviders)) {
            return false;
        }
        Object this$lastActive = this.getLastActive();
        Object other$lastActive = other.getLastActive();
        if (this$lastActive == null ? other$lastActive != null : !this$lastActive.equals(other$lastActive)) {
            return false;
        }
        Object this$openShiftVersions = this.getOpenShiftVersions();
        Object other$openShiftVersions = other.getOpenShiftVersions();
        if (this$openShiftVersions == null ? other$openShiftVersions != null : !this$openShiftVersions.equals(other$openShiftVersions)) {
            return false;
        }
        Object this$regions = this.getRegions();
        Object other$regions = other.getRegions();
        if (this$regions == null ? other$regions != null : !this$regions.equals(other$regions)) {
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
        return other instanceof Filter;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterTypes = this.getClusterTypes();
        result = result * prime + ($clusterTypes == null ? 43 : $clusterTypes.hashCode());
        Object $infrastructureProviders = this.getInfrastructureProviders();
        result = result * prime + ($infrastructureProviders == null ? 43 : $infrastructureProviders.hashCode());
        Object $lastActive = this.getLastActive();
        result = result * prime + ($lastActive == null ? 43 : $lastActive.hashCode());
        Object $openShiftVersions = this.getOpenShiftVersions();
        result = result * prime + ($openShiftVersions == null ? 43 : $openShiftVersions.hashCode());
        Object $regions = this.getRegions();
        result = result * prime + ($regions == null ? 43 : $regions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Filter(" + "clusterTypes=" + this.getClusterTypes() + ", infrastructureProviders=" + this.getInfrastructureProviders() + ", lastActive=" + this.getLastActive() + ", openShiftVersions=" + this.getOpenShiftVersions() + ", regions=" + this.getRegions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
