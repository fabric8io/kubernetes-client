
package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

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
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AWSProviderSpec contains the required information to create a user policy in AWS.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "statementEntries",
    "stsIAMRoleARN"
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
@Version("v1")
@Group("cloudcredential.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AWSProviderSpec implements Editable<AWSProviderSpecBuilder>, KubernetesResource, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "cloudcredential.openshift.io/v1";
    @JsonProperty("kind")
    private String kind = "AWSProviderSpec";
    @JsonProperty("statementEntries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StatementEntry> statementEntries = new ArrayList<>();
    @JsonProperty("stsIAMRoleARN")
    private String stsIAMRoleARN;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSProviderSpec() {
    }

    public AWSProviderSpec(String apiVersion, String kind, List<StatementEntry> statementEntries, String stsIAMRoleARN) {
        super();
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.statementEntries = statementEntries;
        this.stsIAMRoleARN = stsIAMRoleARN;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * StatementEntries contains a list of policy statements that should be associated with this credentials access key.
     */
    @JsonProperty("statementEntries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StatementEntry> getStatementEntries() {
        return statementEntries;
    }

    /**
     * StatementEntries contains a list of policy statements that should be associated with this credentials access key.
     */
    @JsonProperty("statementEntries")
    public void setStatementEntries(List<StatementEntry> statementEntries) {
        this.statementEntries = statementEntries;
    }

    /**
     * stsIAMRoleARN is the Amazon Resource Name (ARN) of an IAM Role which was created manually for the associated CredentialsRequest. The presence of an stsIAMRoleARN within the AWSProviderSpec initiates creation of a secret containing IAM Role details necessary for assuming the IAM Role via Amazon's Secure Token Service.
     */
    @JsonProperty("stsIAMRoleARN")
    public String getStsIAMRoleARN() {
        return stsIAMRoleARN;
    }

    /**
     * stsIAMRoleARN is the Amazon Resource Name (ARN) of an IAM Role which was created manually for the associated CredentialsRequest. The presence of an stsIAMRoleARN within the AWSProviderSpec initiates creation of a secret containing IAM Role details necessary for assuming the IAM Role via Amazon's Secure Token Service.
     */
    @JsonProperty("stsIAMRoleARN")
    public void setStsIAMRoleARN(String stsIAMRoleARN) {
        this.stsIAMRoleARN = stsIAMRoleARN;
    }

    @JsonIgnore
    public AWSProviderSpecBuilder edit() {
        return new AWSProviderSpecBuilder(this);
    }

    @JsonIgnore
    public AWSProviderSpecBuilder toBuilder() {
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
        if (!(o instanceof AWSProviderSpec)) {
            return false;
        }
        AWSProviderSpec other = (AWSProviderSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$statementEntries = this.getStatementEntries();
        Object other$statementEntries = other.getStatementEntries();
        if (this$statementEntries == null ? other$statementEntries != null : !this$statementEntries.equals(other$statementEntries)) {
            return false;
        }
        Object this$stsIAMRoleARN = this.getStsIAMRoleARN();
        Object other$stsIAMRoleARN = other.getStsIAMRoleARN();
        if (this$stsIAMRoleARN == null ? other$stsIAMRoleARN != null : !this$stsIAMRoleARN.equals(other$stsIAMRoleARN)) {
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
        return other instanceof AWSProviderSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $statementEntries = this.getStatementEntries();
        result = result * prime + ($statementEntries == null ? 43 : $statementEntries.hashCode());
        Object $stsIAMRoleARN = this.getStsIAMRoleARN();
        result = result * prime + ($stsIAMRoleARN == null ? 43 : $stsIAMRoleARN.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSProviderSpec(" + "apiVersion=" + this.getApiVersion() + ", kind=" + this.getKind() + ", statementEntries=" + this.getStatementEntries() + ", stsIAMRoleARN=" + this.getStsIAMRoleARN() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
