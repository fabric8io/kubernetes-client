
package io.fabric8.openshift.api.model.hive.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "aws",
    "azure",
    "domains",
    "gcp"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ManageDNSConfig implements KubernetesResource
{

    @JsonProperty("aws")
    private ManageDNSAWSConfig aws;
    @JsonProperty("azure")
    private ManageDNSAzureConfig azure;
    @JsonProperty("domains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> domains = new ArrayList<String>();
    @JsonProperty("gcp")
    private ManageDNSGCPConfig gcp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
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

    @JsonProperty("aws")
    public ManageDNSAWSConfig getAws() {
        return aws;
    }

    @JsonProperty("aws")
    public void setAws(ManageDNSAWSConfig aws) {
        this.aws = aws;
    }

    @JsonProperty("azure")
    public ManageDNSAzureConfig getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(ManageDNSAzureConfig azure) {
        this.azure = azure;
    }

    @JsonProperty("domains")
    public List<String> getDomains() {
        return domains;
    }

    @JsonProperty("domains")
    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    @JsonProperty("gcp")
    public ManageDNSGCPConfig getGcp() {
        return gcp;
    }

    @JsonProperty("gcp")
    public void setGcp(ManageDNSGCPConfig gcp) {
        this.gcp = gcp;
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
