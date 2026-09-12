
package io.fabric8.openshift.api.model.operatorhub.packages.v1;

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
 * PackageChannel defines a single channel under a package, pointing to a version of that package.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currentCSV",
    "currentCSVDesc",
    "deprecation",
    "entries",
    "name"
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
public class PackageChannel implements Editable<PackageChannelBuilder>, KubernetesResource
{

    @JsonProperty("currentCSV")
    private String currentCSV;
    @JsonProperty("currentCSVDesc")
    private CSVDescription currentCSVDesc;
    @JsonProperty("deprecation")
    private Deprecation deprecation;
    @JsonProperty("entries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ChannelEntry> entries = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PackageChannel() {
    }

    public PackageChannel(String currentCSV, CSVDescription currentCSVDesc, Deprecation deprecation, List<ChannelEntry> entries, String name) {
        super();
        this.currentCSV = currentCSV;
        this.currentCSVDesc = currentCSVDesc;
        this.deprecation = deprecation;
        this.entries = entries;
        this.name = name;
    }

    /**
     * CurrentCSV defines a reference to the CSV holding the version of this package currently for the channel.
     */
    @JsonProperty("currentCSV")
    public String getCurrentCSV() {
        return currentCSV;
    }

    /**
     * CurrentCSV defines a reference to the CSV holding the version of this package currently for the channel.
     */
    @JsonProperty("currentCSV")
    public void setCurrentCSV(String currentCSV) {
        this.currentCSV = currentCSV;
    }

    /**
     * PackageChannel defines a single channel under a package, pointing to a version of that package.
     */
    @JsonProperty("currentCSVDesc")
    public CSVDescription getCurrentCSVDesc() {
        return currentCSVDesc;
    }

    /**
     * PackageChannel defines a single channel under a package, pointing to a version of that package.
     */
    @JsonProperty("currentCSVDesc")
    public void setCurrentCSVDesc(CSVDescription currentCSVDesc) {
        this.currentCSVDesc = currentCSVDesc;
    }

    /**
     * PackageChannel defines a single channel under a package, pointing to a version of that package.
     */
    @JsonProperty("deprecation")
    public Deprecation getDeprecation() {
        return deprecation;
    }

    /**
     * PackageChannel defines a single channel under a package, pointing to a version of that package.
     */
    @JsonProperty("deprecation")
    public void setDeprecation(Deprecation deprecation) {
        this.deprecation = deprecation;
    }

    /**
     * Entries lists all CSVs in the channel, with their upgrade edges.
     */
    @JsonProperty("entries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ChannelEntry> getEntries() {
        return entries;
    }

    /**
     * Entries lists all CSVs in the channel, with their upgrade edges.
     */
    @JsonProperty("entries")
    public void setEntries(List<ChannelEntry> entries) {
        this.entries = entries;
    }

    /**
     * Name is the name of the channel, e.g. `alpha` or `stable`
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the channel, e.g. `alpha` or `stable`
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public PackageChannelBuilder edit() {
        return new PackageChannelBuilder(this);
    }

    @JsonIgnore
    public PackageChannelBuilder toBuilder() {
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
        if (!(o instanceof PackageChannel)) {
            return false;
        }
        PackageChannel other = (PackageChannel) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$currentCSV = this.getCurrentCSV();
        Object other$currentCSV = other.getCurrentCSV();
        if (this$currentCSV == null ? other$currentCSV != null : !this$currentCSV.equals(other$currentCSV)) {
            return false;
        }
        Object this$currentCSVDesc = this.getCurrentCSVDesc();
        Object other$currentCSVDesc = other.getCurrentCSVDesc();
        if (this$currentCSVDesc == null ? other$currentCSVDesc != null : !this$currentCSVDesc.equals(other$currentCSVDesc)) {
            return false;
        }
        Object this$deprecation = this.getDeprecation();
        Object other$deprecation = other.getDeprecation();
        if (this$deprecation == null ? other$deprecation != null : !this$deprecation.equals(other$deprecation)) {
            return false;
        }
        Object this$entries = this.getEntries();
        Object other$entries = other.getEntries();
        if (this$entries == null ? other$entries != null : !this$entries.equals(other$entries)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof PackageChannel;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $currentCSV = this.getCurrentCSV();
        result = result * prime + ($currentCSV == null ? 43 : $currentCSV.hashCode());
        Object $currentCSVDesc = this.getCurrentCSVDesc();
        result = result * prime + ($currentCSVDesc == null ? 43 : $currentCSVDesc.hashCode());
        Object $deprecation = this.getDeprecation();
        result = result * prime + ($deprecation == null ? 43 : $deprecation.hashCode());
        Object $entries = this.getEntries();
        result = result * prime + ($entries == null ? 43 : $entries.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PackageChannel(" + "currentCSV=" + this.getCurrentCSV() + ", currentCSVDesc=" + this.getCurrentCSVDesc() + ", deprecation=" + this.getDeprecation() + ", entries=" + this.getEntries() + ", name=" + this.getName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
