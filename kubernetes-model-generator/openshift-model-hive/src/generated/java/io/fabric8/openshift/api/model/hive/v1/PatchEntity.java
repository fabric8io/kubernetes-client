
package io.fabric8.openshift.api.model.hive.v1;

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
 * PatchEntity represent a json patch (RFC 6902) to be applied to the install-config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "from",
    "op",
    "path",
    "value"
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
public class PatchEntity implements Editable<PatchEntityBuilder>, KubernetesResource
{

    @JsonProperty("from")
    private String from;
    @JsonProperty("op")
    private String op;
    @JsonProperty("path")
    private String path;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PatchEntity() {
    }

    public PatchEntity(String from, String op, String path, String value) {
        super();
        this.from = from;
        this.op = op;
        this.path = path;
        this.value = value;
    }

    /**
     * From is the json path to copy or move the value from
     */
    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    /**
     * From is the json path to copy or move the value from
     */
    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Op is the operation to perform: add, remove, replace, move, copy, test
     */
    @JsonProperty("op")
    public String getOp() {
        return op;
    }

    /**
     * Op is the operation to perform: add, remove, replace, move, copy, test
     */
    @JsonProperty("op")
    public void setOp(String op) {
        this.op = op;
    }

    /**
     * Path is the json path to the value to be modified
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path is the json path to the value to be modified
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Value is the value to be used in the operation
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Value is the value to be used in the operation
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public PatchEntityBuilder edit() {
        return new PatchEntityBuilder(this);
    }

    @JsonIgnore
    public PatchEntityBuilder toBuilder() {
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
        if (!(o instanceof PatchEntity)) {
            return false;
        }
        PatchEntity other = (PatchEntity) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$from = this.getFrom();
        Object other$from = other.getFrom();
        if (this$from == null ? other$from != null : !this$from.equals(other$from)) {
            return false;
        }
        Object this$op = this.getOp();
        Object other$op = other.getOp();
        if (this$op == null ? other$op != null : !this$op.equals(other$op)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
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
        return other instanceof PatchEntity;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $from = this.getFrom();
        result = result * prime + ($from == null ? 43 : $from.hashCode());
        Object $op = this.getOp();
        result = result * prime + ($op == null ? 43 : $op.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PatchEntity(" + "from=" + this.getFrom() + ", op=" + this.getOp() + ", path=" + this.getPath() + ", value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
