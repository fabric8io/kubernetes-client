
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "azure",
    "driverType",
    "gcp",
    "ibmcloud",
    "vSphere"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ClusterCSIDriverSpecDriverConfig implements Editable<ClusterCSIDriverSpecDriverConfigBuilder> , KubernetesResource
{

    @JsonProperty("aws")
    private ClusterCSIDriverSpecDCAws aws;
    @JsonProperty("azure")
    private ClusterCSIDriverSpecDCAzure azure;
    @JsonProperty("driverType")
    private String driverType;
    @JsonProperty("gcp")
    private ClusterCSIDriverSpecDCGcp gcp;
    @JsonProperty("ibmcloud")
    private ClusterCSIDriverSpecDCIbmcloud ibmcloud;
    @JsonProperty("vSphere")
    private ClusterCSIDriverSpecDCVSphere vSphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterCSIDriverSpecDriverConfig() {
    }

    public ClusterCSIDriverSpecDriverConfig(ClusterCSIDriverSpecDCAws aws, ClusterCSIDriverSpecDCAzure azure, String driverType, ClusterCSIDriverSpecDCGcp gcp, ClusterCSIDriverSpecDCIbmcloud ibmcloud, ClusterCSIDriverSpecDCVSphere vSphere) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.driverType = driverType;
        this.gcp = gcp;
        this.ibmcloud = ibmcloud;
        this.vSphere = vSphere;
    }

    @JsonProperty("aws")
    public ClusterCSIDriverSpecDCAws getAws() {
        return aws;
    }

    @JsonProperty("aws")
    public void setAws(ClusterCSIDriverSpecDCAws aws) {
        this.aws = aws;
    }

    @JsonProperty("azure")
    public ClusterCSIDriverSpecDCAzure getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(ClusterCSIDriverSpecDCAzure azure) {
        this.azure = azure;
    }

    @JsonProperty("driverType")
    public String getDriverType() {
        return driverType;
    }

    @JsonProperty("driverType")
    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    @JsonProperty("gcp")
    public ClusterCSIDriverSpecDCGcp getGcp() {
        return gcp;
    }

    @JsonProperty("gcp")
    public void setGcp(ClusterCSIDriverSpecDCGcp gcp) {
        this.gcp = gcp;
    }

    @JsonProperty("ibmcloud")
    public ClusterCSIDriverSpecDCIbmcloud getIbmcloud() {
        return ibmcloud;
    }

    @JsonProperty("ibmcloud")
    public void setIbmcloud(ClusterCSIDriverSpecDCIbmcloud ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    @JsonProperty("vSphere")
    public ClusterCSIDriverSpecDCVSphere getVSphere() {
        return vSphere;
    }

    @JsonProperty("vSphere")
    public void setVSphere(ClusterCSIDriverSpecDCVSphere vSphere) {
        this.vSphere = vSphere;
    }

    @JsonIgnore
    public ClusterCSIDriverSpecDriverConfigBuilder edit() {
        return new ClusterCSIDriverSpecDriverConfigBuilder(this);
    }

    @JsonIgnore
    public ClusterCSIDriverSpecDriverConfigBuilder toBuilder() {
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

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
