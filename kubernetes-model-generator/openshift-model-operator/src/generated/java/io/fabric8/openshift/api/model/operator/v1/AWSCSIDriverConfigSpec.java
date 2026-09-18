
package io.fabric8.openshift.api.model.operator.v1;

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
 * AWSCSIDriverConfigSpec defines properties that can be configured for the AWS CSI driver.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "efsVolumeMetrics",
    "kmsKeyARN"
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
public class AWSCSIDriverConfigSpec implements Editable<AWSCSIDriverConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("efsVolumeMetrics")
    private AWSEFSVolumeMetrics efsVolumeMetrics;
    @JsonProperty("kmsKeyARN")
    private String kmsKeyARN;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSCSIDriverConfigSpec() {
    }

    public AWSCSIDriverConfigSpec(AWSEFSVolumeMetrics efsVolumeMetrics, String kmsKeyARN) {
        super();
        this.efsVolumeMetrics = efsVolumeMetrics;
        this.kmsKeyARN = kmsKeyARN;
    }

    /**
     * AWSCSIDriverConfigSpec defines properties that can be configured for the AWS CSI driver.
     */
    @JsonProperty("efsVolumeMetrics")
    public AWSEFSVolumeMetrics getEfsVolumeMetrics() {
        return efsVolumeMetrics;
    }

    /**
     * AWSCSIDriverConfigSpec defines properties that can be configured for the AWS CSI driver.
     */
    @JsonProperty("efsVolumeMetrics")
    public void setEfsVolumeMetrics(AWSEFSVolumeMetrics efsVolumeMetrics) {
        this.efsVolumeMetrics = efsVolumeMetrics;
    }

    /**
     * kmsKeyARN sets the cluster default storage class to encrypt volumes with a user-defined KMS key, rather than the default KMS key used by AWS. The value may be either the ARN or Alias ARN of a KMS key.
     */
    @JsonProperty("kmsKeyARN")
    public String getKmsKeyARN() {
        return kmsKeyARN;
    }

    /**
     * kmsKeyARN sets the cluster default storage class to encrypt volumes with a user-defined KMS key, rather than the default KMS key used by AWS. The value may be either the ARN or Alias ARN of a KMS key.
     */
    @JsonProperty("kmsKeyARN")
    public void setKmsKeyARN(String kmsKeyARN) {
        this.kmsKeyARN = kmsKeyARN;
    }

    @JsonIgnore
    public AWSCSIDriverConfigSpecBuilder edit() {
        return new AWSCSIDriverConfigSpecBuilder(this);
    }

    @JsonIgnore
    public AWSCSIDriverConfigSpecBuilder toBuilder() {
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
        if (!(o instanceof AWSCSIDriverConfigSpec)) {
            return false;
        }
        AWSCSIDriverConfigSpec other = (AWSCSIDriverConfigSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$efsVolumeMetrics = this.getEfsVolumeMetrics();
        Object other$efsVolumeMetrics = other.getEfsVolumeMetrics();
        if (this$efsVolumeMetrics == null ? other$efsVolumeMetrics != null : !this$efsVolumeMetrics.equals(other$efsVolumeMetrics)) {
            return false;
        }
        Object this$kmsKeyARN = this.getKmsKeyARN();
        Object other$kmsKeyARN = other.getKmsKeyARN();
        if (this$kmsKeyARN == null ? other$kmsKeyARN != null : !this$kmsKeyARN.equals(other$kmsKeyARN)) {
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
        return other instanceof AWSCSIDriverConfigSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $efsVolumeMetrics = this.getEfsVolumeMetrics();
        result = result * prime + ($efsVolumeMetrics == null ? 43 : $efsVolumeMetrics.hashCode());
        Object $kmsKeyARN = this.getKmsKeyARN();
        result = result * prime + ($kmsKeyARN == null ? 43 : $kmsKeyARN.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AWSCSIDriverConfigSpec(" + "efsVolumeMetrics=" + this.getEfsVolumeMetrics() + ", kmsKeyARN=" + this.getKmsKeyARN() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
