
package io.fabric8.openshift.api.model.installer.aws.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * CPUOptions defines CPU-related settings for the instance, including the confidential computing policy. If provided, it must not be empty — at least one field must be set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "confidentialCompute"
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
public class CPUOptions implements Editable<CPUOptionsBuilder>, KubernetesResource
{

    @JsonProperty("confidentialCompute")
    private String confidentialCompute;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CPUOptions() {
    }

    public CPUOptions(String confidentialCompute) {
        super();
        this.confidentialCompute = confidentialCompute;
    }

    /**
     * ConfidentialCompute specifies whether confidential computing should be enabled for the instance, and, if so, which confidential computing technology to use. Valid values are: Disabled, AMDEncryptedVirtualizationNestedPaging and omitted. When set to Disabled, confidential computing will be disabled for the instance. When set to AMDEncryptedVirtualizationNestedPaging, AMD SEV-SNP will be used as the confidential computing technology for the instance. In this case, ensure the following conditions are met: 1) The selected instance type supports AMD SEV-SNP. 2) The selected AWS region supports AMD SEV-SNP. 3) The selected AMI supports AMD SEV-SNP. More details can be checked at https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/sev-snp.html When omitted, this means no opinion and the AWS platform is left to choose a reasonable default, which is subject to change without notice. The current default is Disabled.
     */
    @JsonProperty("confidentialCompute")
    public String getConfidentialCompute() {
        return confidentialCompute;
    }

    /**
     * ConfidentialCompute specifies whether confidential computing should be enabled for the instance, and, if so, which confidential computing technology to use. Valid values are: Disabled, AMDEncryptedVirtualizationNestedPaging and omitted. When set to Disabled, confidential computing will be disabled for the instance. When set to AMDEncryptedVirtualizationNestedPaging, AMD SEV-SNP will be used as the confidential computing technology for the instance. In this case, ensure the following conditions are met: 1) The selected instance type supports AMD SEV-SNP. 2) The selected AWS region supports AMD SEV-SNP. 3) The selected AMI supports AMD SEV-SNP. More details can be checked at https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/sev-snp.html When omitted, this means no opinion and the AWS platform is left to choose a reasonable default, which is subject to change without notice. The current default is Disabled.
     */
    @JsonProperty("confidentialCompute")
    public void setConfidentialCompute(String confidentialCompute) {
        this.confidentialCompute = confidentialCompute;
    }

    @JsonIgnore
    public CPUOptionsBuilder edit() {
        return new CPUOptionsBuilder(this);
    }

    @JsonIgnore
    public CPUOptionsBuilder toBuilder() {
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
