
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
    "autoApprovedIdentities",
    "hubClusterArn",
    "tags"
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
        if (!(o instanceof AwsIrsaConfig)) {
            return false;
        }
        AwsIrsaConfig other = (AwsIrsaConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$autoApprovedIdentities = this.getAutoApprovedIdentities();
        Object other$autoApprovedIdentities = other.getAutoApprovedIdentities();
        if (this$autoApprovedIdentities == null ? other$autoApprovedIdentities != null : !this$autoApprovedIdentities.equals(other$autoApprovedIdentities)) {
            return false;
        }
        Object this$hubClusterArn = this.getHubClusterArn();
        Object other$hubClusterArn = other.getHubClusterArn();
        if (this$hubClusterArn == null ? other$hubClusterArn != null : !this$hubClusterArn.equals(other$hubClusterArn)) {
            return false;
        }
        Object this$tags = this.getTags();
        Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) {
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
        return other instanceof AwsIrsaConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $autoApprovedIdentities = this.getAutoApprovedIdentities();
        result = result * prime + ($autoApprovedIdentities == null ? 43 : $autoApprovedIdentities.hashCode());
        Object $hubClusterArn = this.getHubClusterArn();
        result = result * prime + ($hubClusterArn == null ? 43 : $hubClusterArn.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AwsIrsaConfig(" + "autoApprovedIdentities=" + this.getAutoApprovedIdentities() + ", hubClusterArn=" + this.getHubClusterArn() + ", tags=" + this.getTags() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
