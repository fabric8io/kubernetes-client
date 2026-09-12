
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fieldPaths",
    "options",
    "reject",
    "select"
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
public class TargetSelector implements Editable<TargetSelectorBuilder>, KubernetesResource
{

    @JsonProperty("fieldPaths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> fieldPaths = new ArrayList<>();
    @JsonProperty("options")
    private FieldOptions options;
    @JsonProperty("reject")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Selector> reject = new ArrayList<>();
    @JsonProperty("select")
    private Selector select;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TargetSelector() {
    }

    public TargetSelector(List<String> fieldPaths, FieldOptions options, List<Selector> reject, Selector select) {
        super();
        this.fieldPaths = fieldPaths;
        this.options = options;
        this.reject = reject;
        this.select = select;
    }

    @JsonProperty("fieldPaths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFieldPaths() {
        return fieldPaths;
    }

    @JsonProperty("fieldPaths")
    public void setFieldPaths(List<String> fieldPaths) {
        this.fieldPaths = fieldPaths;
    }

    @JsonProperty("options")
    public FieldOptions getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(FieldOptions options) {
        this.options = options;
    }

    @JsonProperty("reject")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Selector> getReject() {
        return reject;
    }

    @JsonProperty("reject")
    public void setReject(List<Selector> reject) {
        this.reject = reject;
    }

    @JsonProperty("select")
    public Selector getSelect() {
        return select;
    }

    @JsonProperty("select")
    public void setSelect(Selector select) {
        this.select = select;
    }

    @JsonIgnore
    public TargetSelectorBuilder edit() {
        return new TargetSelectorBuilder(this);
    }

    @JsonIgnore
    public TargetSelectorBuilder toBuilder() {
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
        if (!(o instanceof TargetSelector)) {
            return false;
        }
        TargetSelector other = (TargetSelector) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fieldPaths = this.getFieldPaths();
        Object other$fieldPaths = other.getFieldPaths();
        if (this$fieldPaths == null ? other$fieldPaths != null : !this$fieldPaths.equals(other$fieldPaths)) {
            return false;
        }
        Object this$options = this.getOptions();
        Object other$options = other.getOptions();
        if (this$options == null ? other$options != null : !this$options.equals(other$options)) {
            return false;
        }
        Object this$reject = this.getReject();
        Object other$reject = other.getReject();
        if (this$reject == null ? other$reject != null : !this$reject.equals(other$reject)) {
            return false;
        }
        Object this$select = this.getSelect();
        Object other$select = other.getSelect();
        if (this$select == null ? other$select != null : !this$select.equals(other$select)) {
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
        return other instanceof TargetSelector;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fieldPaths = this.getFieldPaths();
        result = result * prime + ($fieldPaths == null ? 43 : $fieldPaths.hashCode());
        Object $options = this.getOptions();
        result = result * prime + ($options == null ? 43 : $options.hashCode());
        Object $reject = this.getReject();
        result = result * prime + ($reject == null ? 43 : $reject.hashCode());
        Object $select = this.getSelect();
        result = result * prime + ($select == null ? 43 : $select.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TargetSelector(" + "fieldPaths=" + this.getFieldPaths() + ", options=" + this.getOptions() + ", reject=" + this.getReject() + ", select=" + this.getSelect() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
