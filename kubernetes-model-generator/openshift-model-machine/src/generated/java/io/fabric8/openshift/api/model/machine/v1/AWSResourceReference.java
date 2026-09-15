
package io.fabric8.openshift.api.model.machine.v1;

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
 * AWSResourceReference is a reference to a specific AWS resource by ID, ARN, or filters. Only one of ID, ARN or Filters may be specified. Specifying more than one will result in a validation error.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "arn",
    "filters",
    "id",
    "type"
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
public class AWSResourceReference implements Editable<AWSResourceReferenceBuilder>, KubernetesResource
{

    @JsonProperty("arn")
    private String arn;
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AWSResourceFilter> filters = new ArrayList<>();
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSResourceReference() {
    }

    public AWSResourceReference(String arn, List<AWSResourceFilter> filters, String id, String type) {
        super();
        this.arn = arn;
        this.filters = filters;
        this.id = id;
        this.type = type;
    }

    /**
     * arn of resource.
     */
    @JsonProperty("arn")
    public String getArn() {
        return arn;
    }

    /**
     * arn of resource.
     */
    @JsonProperty("arn")
    public void setArn(String arn) {
        this.arn = arn;
    }

    /**
     * filters is a set of filters used to identify a resource.
     */
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AWSResourceFilter> getFilters() {
        return filters;
    }

    /**
     * filters is a set of filters used to identify a resource.
     */
    @JsonProperty("filters")
    public void setFilters(List<AWSResourceFilter> filters) {
        this.filters = filters;
    }

    /**
     * id of resource.
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * id of resource.
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * type determines how the reference will fetch the AWS resource.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type determines how the reference will fetch the AWS resource.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public AWSResourceReferenceBuilder edit() {
        return new AWSResourceReferenceBuilder(this);
    }

    @JsonIgnore
    public AWSResourceReferenceBuilder toBuilder() {
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
        if (!(o instanceof AWSResourceReference)) {
            return false;
        }
        AWSResourceReference other = (AWSResourceReference) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$arn = this.getArn();
        Object other$arn = other.getArn();
        if (this$arn == null ? other$arn != null : !this$arn.equals(other$arn)) {
            return false;
        }
        Object this$filters = this.getFilters();
        Object other$filters = other.getFilters();
        if (this$filters == null ? other$filters != null : !this$filters.equals(other$filters)) {
            return false;
        }
        Object this$id = this.getId();
        Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof AWSResourceReference;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $arn = this.getArn();
        result = result * prime + ($arn == null ? 43 : $arn.hashCode());
        Object $filters = this.getFilters();
        result = result * prime + ($filters == null ? 43 : $filters.hashCode());
        Object $id = this.getId();
        result = result * prime + ($id == null ? 43 : $id.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSResourceReference(" + "arn=" + this.getArn() + ", filters=" + this.getFilters() + ", id=" + this.getId() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
