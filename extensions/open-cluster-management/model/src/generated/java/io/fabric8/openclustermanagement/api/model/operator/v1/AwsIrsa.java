
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
    "hubClusterArn",
    "managedClusterArn"
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
public class AwsIrsa implements Editable<AwsIrsaBuilder>, KubernetesResource
{

    @JsonProperty("hubClusterArn")
    private String hubClusterArn;
    @JsonProperty("managedClusterArn")
    private String managedClusterArn;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AwsIrsa() {
    }

    public AwsIrsa(String hubClusterArn, String managedClusterArn) {
        super();
        this.hubClusterArn = hubClusterArn;
        this.managedClusterArn = managedClusterArn;
    }

    /**
     * The arn of the hub cluster (ie: an EKS cluster). This will be required to pass information to hub, which hub will use to create IAM identities for this klusterlet. Example - arn:eks:us-west-2:12345678910:cluster/hub-cluster1.
     */
    @JsonProperty("hubClusterArn")
    public String getHubClusterArn() {
        return hubClusterArn;
    }

    /**
     * The arn of the hub cluster (ie: an EKS cluster). This will be required to pass information to hub, which hub will use to create IAM identities for this klusterlet. Example - arn:eks:us-west-2:12345678910:cluster/hub-cluster1.
     */
    @JsonProperty("hubClusterArn")
    public void setHubClusterArn(String hubClusterArn) {
        this.hubClusterArn = hubClusterArn;
    }

    /**
     * The arn of the managed cluster (ie: an EKS cluster). This will be required to generate the md5hash which will be used as a suffix to create IAM role on hub as well as used by kluslerlet-agent, to assume role suffixed with the md5hash, on startup. Example - arn:eks:us-west-2:12345678910:cluster/managed-cluster1.
     */
    @JsonProperty("managedClusterArn")
    public String getManagedClusterArn() {
        return managedClusterArn;
    }

    /**
     * The arn of the managed cluster (ie: an EKS cluster). This will be required to generate the md5hash which will be used as a suffix to create IAM role on hub as well as used by kluslerlet-agent, to assume role suffixed with the md5hash, on startup. Example - arn:eks:us-west-2:12345678910:cluster/managed-cluster1.
     */
    @JsonProperty("managedClusterArn")
    public void setManagedClusterArn(String managedClusterArn) {
        this.managedClusterArn = managedClusterArn;
    }

    @JsonIgnore
    public AwsIrsaBuilder edit() {
        return new AwsIrsaBuilder(this);
    }

    @JsonIgnore
    public AwsIrsaBuilder toBuilder() {
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
        if (!(o instanceof AwsIrsa)) {
            return false;
        }
        AwsIrsa other = (AwsIrsa) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hubClusterArn = this.getHubClusterArn();
        Object other$hubClusterArn = other.getHubClusterArn();
        if (this$hubClusterArn == null ? other$hubClusterArn != null : !this$hubClusterArn.equals(other$hubClusterArn)) {
            return false;
        }
        Object this$managedClusterArn = this.getManagedClusterArn();
        Object other$managedClusterArn = other.getManagedClusterArn();
        if (this$managedClusterArn == null ? other$managedClusterArn != null : !this$managedClusterArn.equals(other$managedClusterArn)) {
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
        return other instanceof AwsIrsa;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hubClusterArn = this.getHubClusterArn();
        result = result * prime + ($hubClusterArn == null ? 43 : $hubClusterArn.hashCode());
        Object $managedClusterArn = this.getManagedClusterArn();
        result = result * prime + ($managedClusterArn == null ? 43 : $managedClusterArn.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AwsIrsa(" + "hubClusterArn=" + this.getHubClusterArn() + ", managedClusterArn=" + this.getManagedClusterArn() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
