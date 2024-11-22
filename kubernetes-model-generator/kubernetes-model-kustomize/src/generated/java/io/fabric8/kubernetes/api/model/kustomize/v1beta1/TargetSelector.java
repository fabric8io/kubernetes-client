
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
    "fieldPaths",
    "options",
    "reject",
    "select"
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
public class TargetSelector implements Editable<TargetSelectorBuilder> , KubernetesResource
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
     * 
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
