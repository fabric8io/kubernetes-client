
package io.fabric8.openshift.api.model.machine.v1;

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
import io.fabric8.kubernetes.api.builder.Editable;
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
    "gcp",
    "openstack",
    "platform"
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
public class FailureDomains implements Editable<FailureDomainsBuilder> , KubernetesResource
{

    @JsonProperty("aws")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AWSFailureDomain> aws = new ArrayList<AWSFailureDomain>();
    @JsonProperty("azure")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AzureFailureDomain> azure = new ArrayList<AzureFailureDomain>();
    @JsonProperty("gcp")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GCPFailureDomain> gcp = new ArrayList<GCPFailureDomain>();
    @JsonProperty("openstack")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OpenStackFailureDomain> openstack = new ArrayList<OpenStackFailureDomain>();
    @JsonProperty("platform")
    private String platform;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public FailureDomains() {
    }

    public FailureDomains(List<AWSFailureDomain> aws, List<AzureFailureDomain> azure, List<GCPFailureDomain> gcp, List<OpenStackFailureDomain> openstack, String platform) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.gcp = gcp;
        this.openstack = openstack;
        this.platform = platform;
    }

    @JsonProperty("aws")
    public List<AWSFailureDomain> getAws() {
        return aws;
    }

    @JsonProperty("aws")
    public void setAws(List<AWSFailureDomain> aws) {
        this.aws = aws;
    }

    @JsonProperty("azure")
    public List<AzureFailureDomain> getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(List<AzureFailureDomain> azure) {
        this.azure = azure;
    }

    @JsonProperty("gcp")
    public List<GCPFailureDomain> getGcp() {
        return gcp;
    }

    @JsonProperty("gcp")
    public void setGcp(List<GCPFailureDomain> gcp) {
        this.gcp = gcp;
    }

    @JsonProperty("openstack")
    public List<OpenStackFailureDomain> getOpenstack() {
        return openstack;
    }

    @JsonProperty("openstack")
    public void setOpenstack(List<OpenStackFailureDomain> openstack) {
        this.openstack = openstack;
    }

    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @JsonIgnore
    public FailureDomainsBuilder edit() {
        return new FailureDomainsBuilder(this);
    }

    @JsonIgnore
    public FailureDomainsBuilder toBuilder() {
        return edit();
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
