
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "create",
    "delimiter",
    "encoding",
    "index"
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
public class FieldOptions implements Editable<FieldOptionsBuilder>, KubernetesResource
{

    @JsonProperty("create")
    private Boolean create;
    @JsonProperty("delimiter")
    private String delimiter;
    @JsonProperty("encoding")
    private String encoding;
    @JsonProperty("index")
    private Integer index;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FieldOptions() {
    }

    public FieldOptions(Boolean create, String delimiter, String encoding, Integer index) {
        super();
        this.create = create;
        this.delimiter = delimiter;
        this.encoding = encoding;
        this.index = index;
    }

    @JsonProperty("create")
    public Boolean getCreate() {
        return create;
    }

    @JsonProperty("create")
    public void setCreate(Boolean create) {
        this.create = create;
    }

    @JsonProperty("delimiter")
    public String getDelimiter() {
        return delimiter;
    }

    @JsonProperty("delimiter")
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @JsonProperty("encoding")
    public String getEncoding() {
        return encoding;
    }

    @JsonProperty("encoding")
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    @JsonProperty("index")
    public Integer getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(Integer index) {
        this.index = index;
    }

    @JsonIgnore
    public FieldOptionsBuilder edit() {
        return new FieldOptionsBuilder(this);
    }

    @JsonIgnore
    public FieldOptionsBuilder toBuilder() {
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
        if (!(o instanceof FieldOptions)) {
            return false;
        }
        FieldOptions other = (FieldOptions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$create = this.getCreate();
        Object other$create = other.getCreate();
        if (this$create == null ? other$create != null : !this$create.equals(other$create)) {
            return false;
        }
        Object this$delimiter = this.getDelimiter();
        Object other$delimiter = other.getDelimiter();
        if (this$delimiter == null ? other$delimiter != null : !this$delimiter.equals(other$delimiter)) {
            return false;
        }
        Object this$encoding = this.getEncoding();
        Object other$encoding = other.getEncoding();
        if (this$encoding == null ? other$encoding != null : !this$encoding.equals(other$encoding)) {
            return false;
        }
        Object this$index = this.getIndex();
        Object other$index = other.getIndex();
        if (this$index == null ? other$index != null : !this$index.equals(other$index)) {
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
        return other instanceof FieldOptions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $create = this.getCreate();
        result = result * prime + ($create == null ? 43 : $create.hashCode());
        Object $delimiter = this.getDelimiter();
        result = result * prime + ($delimiter == null ? 43 : $delimiter.hashCode());
        Object $encoding = this.getEncoding();
        result = result * prime + ($encoding == null ? 43 : $encoding.hashCode());
        Object $index = this.getIndex();
        result = result * prime + ($index == null ? 43 : $index.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FieldOptions(" + "create=" + this.getCreate() + ", delimiter=" + this.getDelimiter() + ", encoding=" + this.getEncoding() + ", index=" + this.getIndex() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
