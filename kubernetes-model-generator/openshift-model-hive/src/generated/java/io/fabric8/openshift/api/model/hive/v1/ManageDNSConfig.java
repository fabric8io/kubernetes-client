
package io.fabric8.openshift.api.model.hive.v1;

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
 * ManageDNSConfig contains the domain being managed, and the cloud-specific details for accessing/managing the domain.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "azure",
    "domains",
    "gcp"
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
public class ManageDNSConfig implements Editable<ManageDNSConfigBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    private ManageDNSAWSConfig aws;
    @JsonProperty("azure")
    private ManageDNSAzureConfig azure;
    @JsonProperty("domains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> domains = new ArrayList<>();
    @JsonProperty("gcp")
    private ManageDNSGCPConfig gcp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ManageDNSConfig() {
    }

    public ManageDNSConfig(ManageDNSAWSConfig aws, ManageDNSAzureConfig azure, List<String> domains, ManageDNSGCPConfig gcp) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.domains = domains;
        this.gcp = gcp;
    }

    /**
     * ManageDNSConfig contains the domain being managed, and the cloud-specific details for accessing/managing the domain.
     */
    @JsonProperty("aws")
    public ManageDNSAWSConfig getAws() {
        return aws;
    }

    /**
     * ManageDNSConfig contains the domain being managed, and the cloud-specific details for accessing/managing the domain.
     */
    @JsonProperty("aws")
    public void setAws(ManageDNSAWSConfig aws) {
        this.aws = aws;
    }

    /**
     * ManageDNSConfig contains the domain being managed, and the cloud-specific details for accessing/managing the domain.
     */
    @JsonProperty("azure")
    public ManageDNSAzureConfig getAzure() {
        return azure;
    }

    /**
     * ManageDNSConfig contains the domain being managed, and the cloud-specific details for accessing/managing the domain.
     */
    @JsonProperty("azure")
    public void setAzure(ManageDNSAzureConfig azure) {
        this.azure = azure;
    }

    /**
     * Domains is the list of domains that hive will be managing entries for with the provided credentials.
     */
    @JsonProperty("domains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDomains() {
        return domains;
    }

    /**
     * Domains is the list of domains that hive will be managing entries for with the provided credentials.
     */
    @JsonProperty("domains")
    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    /**
     * ManageDNSConfig contains the domain being managed, and the cloud-specific details for accessing/managing the domain.
     */
    @JsonProperty("gcp")
    public ManageDNSGCPConfig getGcp() {
        return gcp;
    }

    /**
     * ManageDNSConfig contains the domain being managed, and the cloud-specific details for accessing/managing the domain.
     */
    @JsonProperty("gcp")
    public void setGcp(ManageDNSGCPConfig gcp) {
        this.gcp = gcp;
    }

    @JsonIgnore
    public ManageDNSConfigBuilder edit() {
        return new ManageDNSConfigBuilder(this);
    }

    @JsonIgnore
    public ManageDNSConfigBuilder toBuilder() {
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
