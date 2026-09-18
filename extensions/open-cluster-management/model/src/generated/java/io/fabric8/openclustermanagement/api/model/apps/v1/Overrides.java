
package io.fabric8.openclustermanagement.api.model.apps.v1;

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
 * Overrides defines a list of contents that will be overridden to a given resource
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "packageAlias",
    "packageName",
    "packageOverrides"
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
public class Overrides implements Editable<OverridesBuilder>, KubernetesResource
{

    @JsonProperty("packageAlias")
    private String packageAlias;
    @JsonProperty("packageName")
    private String packageName;
    @JsonProperty("packageOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PackageOverride> packageOverrides = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Overrides() {
    }

    public Overrides(String packageAlias, String packageName, List<PackageOverride> packageOverrides) {
        super();
        this.packageAlias = packageAlias;
        this.packageName = packageName;
        this.packageOverrides = packageOverrides;
    }

    /**
     * PackageAlias defines the alias of the package name that will be onverriden
     */
    @JsonProperty("packageAlias")
    public String getPackageAlias() {
        return packageAlias;
    }

    /**
     * PackageAlias defines the alias of the package name that will be onverriden
     */
    @JsonProperty("packageAlias")
    public void setPackageAlias(String packageAlias) {
        this.packageAlias = packageAlias;
    }

    /**
     * PackageName defines the package name that will be onverriden
     */
    @JsonProperty("packageName")
    public String getPackageName() {
        return packageName;
    }

    /**
     * PackageName defines the package name that will be onverriden
     */
    @JsonProperty("packageName")
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * PackageOverrides defines a list of content for override
     */
    @JsonProperty("packageOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PackageOverride> getPackageOverrides() {
        return packageOverrides;
    }

    /**
     * PackageOverrides defines a list of content for override
     */
    @JsonProperty("packageOverrides")
    public void setPackageOverrides(List<PackageOverride> packageOverrides) {
        this.packageOverrides = packageOverrides;
    }

    @JsonIgnore
    public OverridesBuilder edit() {
        return new OverridesBuilder(this);
    }

    @JsonIgnore
    public OverridesBuilder toBuilder() {
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
        if (!(o instanceof Overrides)) {
            return false;
        }
        Overrides other = (Overrides) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$packageAlias = this.getPackageAlias();
        Object other$packageAlias = other.getPackageAlias();
        if (this$packageAlias == null ? other$packageAlias != null : !this$packageAlias.equals(other$packageAlias)) {
            return false;
        }
        Object this$packageName = this.getPackageName();
        Object other$packageName = other.getPackageName();
        if (this$packageName == null ? other$packageName != null : !this$packageName.equals(other$packageName)) {
            return false;
        }
        Object this$packageOverrides = this.getPackageOverrides();
        Object other$packageOverrides = other.getPackageOverrides();
        if (this$packageOverrides == null ? other$packageOverrides != null : !this$packageOverrides.equals(other$packageOverrides)) {
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
        return other instanceof Overrides;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $packageAlias = this.getPackageAlias();
        result = result * prime + ($packageAlias == null ? 43 : $packageAlias.hashCode());
        Object $packageName = this.getPackageName();
        result = result * prime + ($packageName == null ? 43 : $packageName.hashCode());
        Object $packageOverrides = this.getPackageOverrides();
        result = result * prime + ($packageOverrides == null ? 43 : $packageOverrides.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Overrides(" + "packageAlias=" + this.getPackageAlias() + ", packageName=" + this.getPackageName() + ", packageOverrides=" + this.getPackageOverrides() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
