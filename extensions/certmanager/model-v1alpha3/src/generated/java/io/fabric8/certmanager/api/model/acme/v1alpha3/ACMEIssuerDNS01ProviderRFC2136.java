
package io.fabric8.certmanager.api.model.acme.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "nameserver",
    "tsigAlgorithm",
    "tsigKeyName",
    "tsigSecretSecretRef"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class ACMEIssuerDNS01ProviderRFC2136 implements KubernetesResource
{

    @JsonProperty("nameserver")
    private String nameserver;
    @JsonProperty("tsigAlgorithm")
    private String tsigAlgorithm;
    @JsonProperty("tsigKeyName")
    private String tsigKeyName;
    @JsonProperty("tsigSecretSecretRef")
    private SecretKeySelector tsigSecretSecretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ACMEIssuerDNS01ProviderRFC2136() {
    }

    /**
     * 
     * @param tsigSecretSecretRef
     * @param tsigKeyName
     * @param nameserver
     * @param tsigAlgorithm
     */
    public ACMEIssuerDNS01ProviderRFC2136(String nameserver, String tsigAlgorithm, String tsigKeyName, SecretKeySelector tsigSecretSecretRef) {
        super();
        this.nameserver = nameserver;
        this.tsigAlgorithm = tsigAlgorithm;
        this.tsigKeyName = tsigKeyName;
        this.tsigSecretSecretRef = tsigSecretSecretRef;
    }

    @JsonProperty("nameserver")
    public String getNameserver() {
        return nameserver;
    }

    @JsonProperty("nameserver")
    public void setNameserver(String nameserver) {
        this.nameserver = nameserver;
    }

    @JsonProperty("tsigAlgorithm")
    public String getTsigAlgorithm() {
        return tsigAlgorithm;
    }

    @JsonProperty("tsigAlgorithm")
    public void setTsigAlgorithm(String tsigAlgorithm) {
        this.tsigAlgorithm = tsigAlgorithm;
    }

    @JsonProperty("tsigKeyName")
    public String getTsigKeyName() {
        return tsigKeyName;
    }

    @JsonProperty("tsigKeyName")
    public void setTsigKeyName(String tsigKeyName) {
        this.tsigKeyName = tsigKeyName;
    }

    @JsonProperty("tsigSecretSecretRef")
    public SecretKeySelector getTsigSecretSecretRef() {
        return tsigSecretSecretRef;
    }

    @JsonProperty("tsigSecretSecretRef")
    public void setTsigSecretSecretRef(SecretKeySelector tsigSecretSecretRef) {
        this.tsigSecretSecretRef = tsigSecretSecretRef;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
