
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ExceptionTotal",
    "GVK",
    "LabelExceptions",
    "Name",
    "NameExceptions"
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BlockDeletionResource)) {
            return false;
        }
        BlockDeletionResource other = (BlockDeletionResource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$exceptionTotal = this.getExceptionTotal();
        Object other$exceptionTotal = other.getExceptionTotal();
        if (this$exceptionTotal == null ? other$exceptionTotal != null : !this$exceptionTotal.equals(other$exceptionTotal)) {
            return false;
        }
        Object this$gVK = this.getGVK();
        Object other$gVK = other.getGVK();
        if (this$gVK == null ? other$gVK != null : !this$gVK.equals(other$gVK)) {
            return false;
        }
        Object this$labelExceptions = this.getLabelExceptions();
        Object other$labelExceptions = other.getLabelExceptions();
        if (this$labelExceptions == null ? other$labelExceptions != null : !this$labelExceptions.equals(other$labelExceptions)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$nameExceptions = this.getNameExceptions();
        Object other$nameExceptions = other.getNameExceptions();
        if (this$nameExceptions == null ? other$nameExceptions != null : !this$nameExceptions.equals(other$nameExceptions)) {
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
        return other instanceof BlockDeletionResource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $exceptionTotal = this.getExceptionTotal();
        result = result * prime + ($exceptionTotal == null ? 43 : $exceptionTotal.hashCode());
        Object $gVK = this.getGVK();
        result = result * prime + ($gVK == null ? 43 : $gVK.hashCode());
        Object $labelExceptions = this.getLabelExceptions();
        result = result * prime + ($labelExceptions == null ? 43 : $labelExceptions.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $nameExceptions = this.getNameExceptions();
        result = result * prime + ($nameExceptions == null ? 43 : $nameExceptions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BlockDeletionResource(" + "exceptionTotal=" + this.getExceptionTotal() + ", gVK=" + this.getGVK() + ", labelExceptions=" + this.getLabelExceptions() + ", name=" + this.getName() + ", nameExceptions=" + this.getNameExceptions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
