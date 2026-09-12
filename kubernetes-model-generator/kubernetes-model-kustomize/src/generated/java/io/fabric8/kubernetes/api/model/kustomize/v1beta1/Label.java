
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
    "fields",
    "includeSelectors",
    "includeTemplates",
    "pairs"
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
public class Label implements Editable<LabelBuilder>, KubernetesResource
{

    @JsonProperty("fields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FieldSpec> fields = new ArrayList<>();
    @JsonProperty("includeSelectors")
    private Boolean includeSelectors;
    @JsonProperty("includeTemplates")
    private Boolean includeTemplates;
    @JsonProperty("pairs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> pairs = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Label() {
    }

    public Label(List<FieldSpec> fields, Boolean includeSelectors, Boolean includeTemplates, Map<String, String> pairs) {
        super();
        this.fields = fields;
        this.includeSelectors = includeSelectors;
        this.includeTemplates = includeTemplates;
        this.pairs = pairs;
    }

    @JsonProperty("fields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FieldSpec> getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(List<FieldSpec> fields) {
        this.fields = fields;
    }

    @JsonProperty("includeSelectors")
    public Boolean getIncludeSelectors() {
        return includeSelectors;
    }

    @JsonProperty("includeSelectors")
    public void setIncludeSelectors(Boolean includeSelectors) {
        this.includeSelectors = includeSelectors;
    }

    @JsonProperty("includeTemplates")
    public Boolean getIncludeTemplates() {
        return includeTemplates;
    }

    @JsonProperty("includeTemplates")
    public void setIncludeTemplates(Boolean includeTemplates) {
        this.includeTemplates = includeTemplates;
    }

    @JsonProperty("pairs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getPairs() {
        return pairs;
    }

    @JsonProperty("pairs")
    public void setPairs(Map<String, String> pairs) {
        this.pairs = pairs;
    }

    @JsonIgnore
    public LabelBuilder edit() {
        return new LabelBuilder(this);
    }

    @JsonIgnore
    public LabelBuilder toBuilder() {
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
        if (!(o instanceof Label)) {
            return false;
        }
        Label other = (Label) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$fields = this.getFields();
        Object other$fields = other.getFields();
        if (this$fields == null ? other$fields != null : !this$fields.equals(other$fields)) {
            return false;
        }
        Object this$includeSelectors = this.getIncludeSelectors();
        Object other$includeSelectors = other.getIncludeSelectors();
        if (this$includeSelectors == null ? other$includeSelectors != null : !this$includeSelectors.equals(other$includeSelectors)) {
            return false;
        }
        Object this$includeTemplates = this.getIncludeTemplates();
        Object other$includeTemplates = other.getIncludeTemplates();
        if (this$includeTemplates == null ? other$includeTemplates != null : !this$includeTemplates.equals(other$includeTemplates)) {
            return false;
        }
        Object this$pairs = this.getPairs();
        Object other$pairs = other.getPairs();
        if (this$pairs == null ? other$pairs != null : !this$pairs.equals(other$pairs)) {
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
        return other instanceof Label;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $fields = this.getFields();
        result = result * prime + ($fields == null ? 43 : $fields.hashCode());
        Object $includeSelectors = this.getIncludeSelectors();
        result = result * prime + ($includeSelectors == null ? 43 : $includeSelectors.hashCode());
        Object $includeTemplates = this.getIncludeTemplates();
        result = result * prime + ($includeTemplates == null ? 43 : $includeTemplates.hashCode());
        Object $pairs = this.getPairs();
        result = result * prime + ($pairs == null ? 43 : $pairs.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Label(" + "fields=" + this.getFields() + ", includeSelectors=" + this.getIncludeSelectors() + ", includeTemplates=" + this.getIncludeTemplates() + ", pairs=" + this.getPairs() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
