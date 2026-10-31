
package io.fabric8.openshift.api.model.hive.nutanix.v1;

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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * Platform stores any global configuration used for Nutanix platform
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certificatesSecretRef",
    "credentialsSecretRef",
    "failureDomains",
    "prismCentral"
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
public class Platform implements Editable<PlatformBuilder>, KubernetesResource
{

    @JsonProperty("certificatesSecretRef")
    private LocalObjectReference certificatesSecretRef;
    @JsonProperty("credentialsSecretRef")
    private LocalObjectReference credentialsSecretRef;
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FailureDomain> failureDomains = new ArrayList<>();
    @JsonProperty("prismCentral")
    private PrismEndpoint prismCentral;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(LocalObjectReference certificatesSecretRef, LocalObjectReference credentialsSecretRef, List<FailureDomain> failureDomains, PrismEndpoint prismCentral) {
        super();
        this.certificatesSecretRef = certificatesSecretRef;
        this.credentialsSecretRef = credentialsSecretRef;
        this.failureDomains = failureDomains;
        this.prismCentral = prismCentral;
    }

    /**
     * Platform stores any global configuration used for Nutanix platform
     */
    @JsonProperty("certificatesSecretRef")
    public LocalObjectReference getCertificatesSecretRef() {
        return certificatesSecretRef;
    }

    /**
     * Platform stores any global configuration used for Nutanix platform
     */
    @JsonProperty("certificatesSecretRef")
    public void setCertificatesSecretRef(LocalObjectReference certificatesSecretRef) {
        this.certificatesSecretRef = certificatesSecretRef;
    }

    /**
     * Platform stores any global configuration used for Nutanix platform
     */
    @JsonProperty("credentialsSecretRef")
    public LocalObjectReference getCredentialsSecretRef() {
        return credentialsSecretRef;
    }

    /**
     * Platform stores any global configuration used for Nutanix platform
     */
    @JsonProperty("credentialsSecretRef")
    public void setCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
        this.credentialsSecretRef = credentialsSecretRef;
    }

    /**
     * FailureDomains configures failure domains for the Nutanix platform. Required for using MachinePools
     */
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FailureDomain> getFailureDomains() {
        return failureDomains;
    }

    /**
     * FailureDomains configures failure domains for the Nutanix platform. Required for using MachinePools
     */
    @JsonProperty("failureDomains")
    public void setFailureDomains(List<FailureDomain> failureDomains) {
        this.failureDomains = failureDomains;
    }

    /**
     * Platform stores any global configuration used for Nutanix platform
     */
    @JsonProperty("prismCentral")
    public PrismEndpoint getPrismCentral() {
        return prismCentral;
    }

    /**
     * Platform stores any global configuration used for Nutanix platform
     */
    @JsonProperty("prismCentral")
    public void setPrismCentral(PrismEndpoint prismCentral) {
        this.prismCentral = prismCentral;
    }

    @JsonIgnore
    public PlatformBuilder edit() {
        return new PlatformBuilder(this);
    }

    @JsonIgnore
    public PlatformBuilder toBuilder() {
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
