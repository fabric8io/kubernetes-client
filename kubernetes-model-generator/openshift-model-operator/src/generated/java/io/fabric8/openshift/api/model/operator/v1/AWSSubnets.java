
package io.fabric8.openshift.api.model.operator.v1;

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

/**
 * AWSSubnets contains a list of references to AWS subnets by ID or name.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ids",
    "names"
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
public class AWSSubnets implements Editable<AWSSubnetsBuilder>, KubernetesResource
{

    @JsonProperty("ids")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ids = new ArrayList<>();
    @JsonProperty("names")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> names = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSSubnets() {
    }

    public AWSSubnets(List<String> ids, List<String> names) {
        super();
        this.ids = ids;
        this.names = names;
    }

    /**
     * ids specifies a list of AWS subnets by subnet ID. Subnet IDs must start with "subnet-", consist only of alphanumeric characters, must be exactly 24 characters long, must be unique, and the total number of subnets specified by ids and names must not exceed 10.
     */
    @JsonProperty("ids")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIds() {
        return ids;
    }

    /**
     * ids specifies a list of AWS subnets by subnet ID. Subnet IDs must start with "subnet-", consist only of alphanumeric characters, must be exactly 24 characters long, must be unique, and the total number of subnets specified by ids and names must not exceed 10.
     */
    @JsonProperty("ids")
    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    /**
     * names specifies a list of AWS subnets by subnet name. Subnet names must not start with "subnet-", must not include commas, must be under 256 characters in length, must be unique, and the total number of subnets specified by ids and names must not exceed 10.
     */
    @JsonProperty("names")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNames() {
        return names;
    }

    /**
     * names specifies a list of AWS subnets by subnet name. Subnet names must not start with "subnet-", must not include commas, must be under 256 characters in length, must be unique, and the total number of subnets specified by ids and names must not exceed 10.
     */
    @JsonProperty("names")
    public void setNames(List<String> names) {
        this.names = names;
    }

    @JsonIgnore
    public AWSSubnetsBuilder edit() {
        return new AWSSubnetsBuilder(this);
    }

    @JsonIgnore
    public AWSSubnetsBuilder toBuilder() {
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
