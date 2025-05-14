
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.GroupVersionKind;
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
    "ExceptionTotal",
    "GVK",
    "LabelExceptions",
    "Name",
    "NameExceptions"
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
public class BlockDeletionResource implements Editable<BlockDeletionResourceBuilder>, KubernetesResource
{

    @JsonProperty("ExceptionTotal")
    private Integer exceptionTotal;
    @JsonProperty("GVK")
    private GroupVersionKind gVK;
    @JsonProperty("LabelExceptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labelExceptions = new LinkedHashMap<>();
    @JsonProperty("Name")
    private String name;
    @JsonProperty("NameExceptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> nameExceptions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BlockDeletionResource() {
    }

    public BlockDeletionResource(Integer exceptionTotal, GroupVersionKind gVK, Map<String, String> labelExceptions, String name, List<String> nameExceptions) {
        super();
        this.exceptionTotal = exceptionTotal;
        this.gVK = gVK;
        this.labelExceptions = labelExceptions;
        this.name = name;
        this.nameExceptions = nameExceptions;
    }

    @JsonProperty("ExceptionTotal")
    public Integer getExceptionTotal() {
        return exceptionTotal;
    }

    @JsonProperty("ExceptionTotal")
    public void setExceptionTotal(Integer exceptionTotal) {
        this.exceptionTotal = exceptionTotal;
    }

    @JsonProperty("GVK")
    public GroupVersionKind getGVK() {
        return gVK;
    }

    @JsonProperty("GVK")
    public void setGVK(GroupVersionKind gVK) {
        this.gVK = gVK;
    }

    @JsonProperty("LabelExceptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabelExceptions() {
        return labelExceptions;
    }

    @JsonProperty("LabelExceptions")
    public void setLabelExceptions(Map<String, String> labelExceptions) {
        this.labelExceptions = labelExceptions;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("NameExceptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNameExceptions() {
        return nameExceptions;
    }

    @JsonProperty("NameExceptions")
    public void setNameExceptions(List<String> nameExceptions) {
        this.nameExceptions = nameExceptions;
    }

    @JsonIgnore
    public BlockDeletionResourceBuilder edit() {
        return new BlockDeletionResourceBuilder(this);
    }

    @JsonIgnore
    public BlockDeletionResourceBuilder toBuilder() {
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
