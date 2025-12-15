
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * SecurityGroup defines an Azure security group.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "securityRules",
    "tags"
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
public class SecurityGroup implements Editable<SecurityGroupBuilder>, KubernetesResource
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("securityRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecurityRule> securityRules = new ArrayList<>();
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> tags = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SecurityGroup() {
    }

    public SecurityGroup(String id, String name, List<SecurityRule> securityRules, Map<String, String> tags) {
        super();
        this.id = id;
        this.name = name;
        this.securityRules = securityRules;
        this.tags = tags;
    }

    /**
     * ID is the Azure resource ID of the security group. READ-ONLY
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * ID is the Azure resource ID of the security group. READ-ONLY
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * SecurityGroup defines an Azure security group.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * SecurityGroup defines an Azure security group.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * SecurityGroup defines an Azure security group.
     */
    @JsonProperty("securityRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SecurityRule> getSecurityRules() {
        return securityRules;
    }

    /**
     * SecurityGroup defines an Azure security group.
     */
    @JsonProperty("securityRules")
    public void setSecurityRules(List<SecurityRule> securityRules) {
        this.securityRules = securityRules;
    }

    /**
     * SecurityGroup defines an Azure security group.
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getTags() {
        return tags;
    }

    /**
     * SecurityGroup defines an Azure security group.
     */
    @JsonProperty("tags")
    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    @JsonIgnore
    public SecurityGroupBuilder edit() {
        return new SecurityGroupBuilder(this);
    }

    @JsonIgnore
    public SecurityGroupBuilder toBuilder() {
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
