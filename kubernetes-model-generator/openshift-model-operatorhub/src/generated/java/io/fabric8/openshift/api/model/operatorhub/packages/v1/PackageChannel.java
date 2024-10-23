
package io.fabric8.openshift.api.model.operatorhub.packages.v1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currentCSV",
    "currentCSVDesc",
    "deprecation",
    "entries",
    "name"
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
@Generated("jsonschema2pojo")
public class PackageChannel implements Editable<PackageChannelBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("currentCSV")
    public String getCurrentCSV() {
        return currentCSV;
    }

    @JsonProperty("currentCSV")
    public void setCurrentCSV(String currentCSV) {
        this.currentCSV = currentCSV;
    }

    @JsonProperty("currentCSVDesc")
    public CSVDescription getCurrentCSVDesc() {
        return currentCSVDesc;
    }

    @JsonProperty("currentCSVDesc")
    public void setCurrentCSVDesc(CSVDescription currentCSVDesc) {
        this.currentCSVDesc = currentCSVDesc;
    }

    @JsonProperty("deprecation")
    public Deprecation getDeprecation() {
        return deprecation;
    }

    @JsonProperty("deprecation")
    public void setDeprecation(Deprecation deprecation) {
        this.deprecation = deprecation;
    }

    @JsonProperty("entries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ChannelEntry> getEntries() {
        return entries;
    }

    @JsonProperty("entries")
    public void setEntries(List<ChannelEntry> entries) {
        this.entries = entries;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

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
