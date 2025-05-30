
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
 * EncryptionAlibaba this a union type in kube parlance.  Depending on the value for the AlibabaEncryptionMethod, different pointers may be used
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kms",
    "method"
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
public class EncryptionAlibaba implements Editable<EncryptionAlibabaBuilder>, KubernetesResource
{

    @JsonProperty("kms")
    private KMSEncryptionAlibaba kms;
    @JsonProperty("method")
    private String method;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EncryptionAlibaba() {
    }

    public EncryptionAlibaba(KMSEncryptionAlibaba kms, String method) {
        super();
        this.kms = kms;
        this.method = method;
    }

    /**
     * EncryptionAlibaba this a union type in kube parlance.  Depending on the value for the AlibabaEncryptionMethod, different pointers may be used
     */
    @JsonProperty("kms")
    public KMSEncryptionAlibaba getKms() {
        return kms;
    }

    /**
     * EncryptionAlibaba this a union type in kube parlance.  Depending on the value for the AlibabaEncryptionMethod, different pointers may be used
     */
    @JsonProperty("kms")
    public void setKms(KMSEncryptionAlibaba kms) {
        this.kms = kms;
    }

    /**
     * Method defines the different encrytion modes available Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default is `AES256`.
     */
    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    /**
     * Method defines the different encrytion modes available Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default is `AES256`.
     */
    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonIgnore
    public EncryptionAlibabaBuilder edit() {
        return new EncryptionAlibabaBuilder(this);
    }

    @JsonIgnore
    public EncryptionAlibabaBuilder toBuilder() {
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
