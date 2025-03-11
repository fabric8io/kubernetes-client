
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
    "autoApprovedIdentities",
    "hubClusterArn",
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
public class AwsIrsaConfig implements Editable<AwsIrsaConfigBuilder>, KubernetesResource
{

    @JsonProperty("autoApprovedIdentities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> autoApprovedIdentities = new ArrayList<>();
    @JsonProperty("hubClusterArn")
    private String hubClusterArn;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> tags = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AwsIrsaConfig() {
    }

    public AwsIrsaConfig(List<String> autoApprovedIdentities, String hubClusterArn, List<String> tags) {
        super();
        this.autoApprovedIdentities = autoApprovedIdentities;
        this.hubClusterArn = hubClusterArn;
        this.tags = tags;
    }

    /**
     * AutoApprovedIdentities represent a list of approved arn patterns
     */
    @JsonProperty("autoApprovedIdentities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAutoApprovedIdentities() {
        return autoApprovedIdentities;
    }

    /**
     * AutoApprovedIdentities represent a list of approved arn patterns
     */
    @JsonProperty("autoApprovedIdentities")
    public void setAutoApprovedIdentities(List<String> autoApprovedIdentities) {
        this.autoApprovedIdentities = autoApprovedIdentities;
    }

    /**
     * This represents the hub cluster ARN Example - arn:eks:us-west-2:12345678910:cluster/hub-cluster1
     */
    @JsonProperty("hubClusterArn")
    public String getHubClusterArn() {
        return hubClusterArn;
    }

    /**
     * This represents the hub cluster ARN Example - arn:eks:us-west-2:12345678910:cluster/hub-cluster1
     */
    @JsonProperty("hubClusterArn")
    public void setHubClusterArn(String hubClusterArn) {
        this.hubClusterArn = hubClusterArn;
    }

    /**
     * List of tags to be added to AWS resources created by hub while processing awsirsa registration request Example - "product:v1:tenant:app-name=My-App"
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTags() {
        return tags;
    }

    /**
     * List of tags to be added to AWS resources created by hub while processing awsirsa registration request Example - "product:v1:tenant:app-name=My-App"
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonIgnore
    public AwsIrsaConfigBuilder edit() {
        return new AwsIrsaConfigBuilder(this);
    }

    @JsonIgnore
    public AwsIrsaConfigBuilder toBuilder() {
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
