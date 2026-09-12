
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
 * DNSZoneParams is a set of parameters used to find a DNS zone.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "BaseDomain",
    "InstallerCreated",
    "IsPublic",
    "Name",
    "Project"
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
public class DNSZoneParams implements Editable<DNSZoneParamsBuilder>, KubernetesResource
{

    @JsonProperty("BaseDomain")
    private String baseDomain;
    @JsonProperty("InstallerCreated")
    private Boolean installerCreated;
    @JsonProperty("IsPublic")
    private Boolean isPublic;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Project")
    private String project;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSZoneParams() {
    }

    public DNSZoneParams(String baseDomain, Boolean installerCreated, Boolean isPublic, String name, String project) {
        super();
        this.baseDomain = baseDomain;
        this.installerCreated = installerCreated;
        this.isPublic = isPublic;
        this.name = name;
        this.project = project;
    }

    /**
     * BaseDomain is the base domain of the DNS zone. Note that either `Name` or `BaseDomain` must be provided.
     */
    @JsonProperty("BaseDomain")
    public String getBaseDomain() {
        return baseDomain;
    }

    /**
     * BaseDomain is the base domain of the DNS zone. Note that either `Name` or `BaseDomain` must be provided.
     */
    @JsonProperty("BaseDomain")
    public void setBaseDomain(String baseDomain) {
        this.baseDomain = baseDomain;
    }

    /**
     * InstallerCreated is true when the DNS zone should be created by the OpenShift Installer (and will be owned by the OpenShift Installer).
     */
    @JsonProperty("InstallerCreated")
    public Boolean getInstallerCreated() {
        return installerCreated;
    }

    /**
     * InstallerCreated is true when the DNS zone should be created by the OpenShift Installer (and will be owned by the OpenShift Installer).
     */
    @JsonProperty("InstallerCreated")
    public void setInstallerCreated(Boolean installerCreated) {
        this.installerCreated = installerCreated;
    }

    /**
     * IsPublic is true if the DNS zone is public.
     */
    @JsonProperty("IsPublic")
    public Boolean getIsPublic() {
        return isPublic;
    }

    /**
     * IsPublic is true if the DNS zone is public.
     */
    @JsonProperty("IsPublic")
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * Name is the name of the DNS zone. When provided, the name will be used for the search. When empty any zone matching the other parameters will be returned. Note that either `Name` or `BaseDomain` must be provided.
     */
    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the DNS zone. When provided, the name will be used for the search. When empty any zone matching the other parameters will be returned. Note that either `Name` or `BaseDomain` must be provided.
     */
    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Project is the project of the DNS zone.
     */
    @JsonProperty("Project")
    public String getProject() {
        return project;
    }

    /**
     * Project is the project of the DNS zone.
     */
    @JsonProperty("Project")
    public void setProject(String project) {
        this.project = project;
    }

    @JsonIgnore
    public DNSZoneParamsBuilder edit() {
        return new DNSZoneParamsBuilder(this);
    }

    @JsonIgnore
    public DNSZoneParamsBuilder toBuilder() {
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
        if (!(o instanceof DNSZoneParams)) {
            return false;
        }
        DNSZoneParams other = (DNSZoneParams) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$baseDomain = this.getBaseDomain();
        Object other$baseDomain = other.getBaseDomain();
        if (this$baseDomain == null ? other$baseDomain != null : !this$baseDomain.equals(other$baseDomain)) {
            return false;
        }
        Object this$installerCreated = this.getInstallerCreated();
        Object other$installerCreated = other.getInstallerCreated();
        if (this$installerCreated == null ? other$installerCreated != null : !this$installerCreated.equals(other$installerCreated)) {
            return false;
        }
        Object this$isPublic = this.getIsPublic();
        Object other$isPublic = other.getIsPublic();
        if (this$isPublic == null ? other$isPublic != null : !this$isPublic.equals(other$isPublic)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$project = this.getProject();
        Object other$project = other.getProject();
        if (this$project == null ? other$project != null : !this$project.equals(other$project)) {
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
        return other instanceof DNSZoneParams;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $baseDomain = this.getBaseDomain();
        result = result * prime + ($baseDomain == null ? 43 : $baseDomain.hashCode());
        Object $installerCreated = this.getInstallerCreated();
        result = result * prime + ($installerCreated == null ? 43 : $installerCreated.hashCode());
        Object $isPublic = this.getIsPublic();
        result = result * prime + ($isPublic == null ? 43 : $isPublic.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $project = this.getProject();
        result = result * prime + ($project == null ? 43 : $project.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DNSZoneParams(" + "baseDomain=" + this.getBaseDomain() + ", installerCreated=" + this.getInstallerCreated() + ", isPublic=" + this.getIsPublic() + ", name=" + this.getName() + ", project=" + this.getProject() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
