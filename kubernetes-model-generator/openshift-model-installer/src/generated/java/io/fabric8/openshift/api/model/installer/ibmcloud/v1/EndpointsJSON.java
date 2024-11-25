
package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "IBMCLOUD_CIS_API_ENDPOINT",
    "IBMCLOUD_COS_CONFIG_ENDPOINT",
    "IBMCLOUD_GS_API_ENDPOINT",
    "IBMCLOUD_GT_API_ENDPOINT",
    "IBMCLOUD_HPCS_API_ENDPOINT",
    "IBMCLOUD_IAM_API_ENDPOINT",
    "IBMCLOUD_IS_NG_API_ENDPOINT",
    "IBMCLOUD_KP_API_ENDPOINT",
    "IBMCLOUD_PRIVATE_DNS_API_ENDPOINT",
    "IBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT",
    "IBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT"
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
public class EndpointsJSON implements Editable<EndpointsJSONBuilder>, KubernetesResource
{

    @JsonProperty("IBMCLOUD_CIS_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUDCISAPIENDPOINT;
    @JsonProperty("IBMCLOUD_COS_CONFIG_ENDPOINT")
    private EndpointsVisibility iBMCLOUDCOSCONFIGENDPOINT;
    @JsonProperty("IBMCLOUD_GS_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUDGSAPIENDPOINT;
    @JsonProperty("IBMCLOUD_GT_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUDGTAPIENDPOINT;
    @JsonProperty("IBMCLOUD_HPCS_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUDHPCSAPIENDPOINT;
    @JsonProperty("IBMCLOUD_IAM_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUDIAMAPIENDPOINT;
    @JsonProperty("IBMCLOUD_IS_NG_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUDISNGAPIENDPOINT;
    @JsonProperty("IBMCLOUD_KP_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUDKPAPIENDPOINT;
    @JsonProperty("IBMCLOUD_PRIVATE_DNS_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUDPRIVATEDNSAPIENDPOINT;
    @JsonProperty("IBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUDRESOURCECONTROLLERAPIENDPOINT;
    @JsonProperty("IBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EndpointsJSON() {
    }

    public EndpointsJSON(EndpointsVisibility iBMCLOUDCISAPIENDPOINT, EndpointsVisibility iBMCLOUDCOSCONFIGENDPOINT, EndpointsVisibility iBMCLOUDGSAPIENDPOINT, EndpointsVisibility iBMCLOUDGTAPIENDPOINT, EndpointsVisibility iBMCLOUDHPCSAPIENDPOINT, EndpointsVisibility iBMCLOUDIAMAPIENDPOINT, EndpointsVisibility iBMCLOUDISNGAPIENDPOINT, EndpointsVisibility iBMCLOUDKPAPIENDPOINT, EndpointsVisibility iBMCLOUDPRIVATEDNSAPIENDPOINT, EndpointsVisibility iBMCLOUDRESOURCECONTROLLERAPIENDPOINT, EndpointsVisibility iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT) {
        super();
        this.iBMCLOUDCISAPIENDPOINT = iBMCLOUDCISAPIENDPOINT;
        this.iBMCLOUDCOSCONFIGENDPOINT = iBMCLOUDCOSCONFIGENDPOINT;
        this.iBMCLOUDGSAPIENDPOINT = iBMCLOUDGSAPIENDPOINT;
        this.iBMCLOUDGTAPIENDPOINT = iBMCLOUDGTAPIENDPOINT;
        this.iBMCLOUDHPCSAPIENDPOINT = iBMCLOUDHPCSAPIENDPOINT;
        this.iBMCLOUDIAMAPIENDPOINT = iBMCLOUDIAMAPIENDPOINT;
        this.iBMCLOUDISNGAPIENDPOINT = iBMCLOUDISNGAPIENDPOINT;
        this.iBMCLOUDKPAPIENDPOINT = iBMCLOUDKPAPIENDPOINT;
        this.iBMCLOUDPRIVATEDNSAPIENDPOINT = iBMCLOUDPRIVATEDNSAPIENDPOINT;
        this.iBMCLOUDRESOURCECONTROLLERAPIENDPOINT = iBMCLOUDRESOURCECONTROLLERAPIENDPOINT;
        this.iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT = iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_CIS_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDCISAPIENDPOINT() {
        return iBMCLOUDCISAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_CIS_API_ENDPOINT")
    public void setIBMCLOUDCISAPIENDPOINT(EndpointsVisibility iBMCLOUDCISAPIENDPOINT) {
        this.iBMCLOUDCISAPIENDPOINT = iBMCLOUDCISAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_COS_CONFIG_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDCOSCONFIGENDPOINT() {
        return iBMCLOUDCOSCONFIGENDPOINT;
    }

    @JsonProperty("IBMCLOUD_COS_CONFIG_ENDPOINT")
    public void setIBMCLOUDCOSCONFIGENDPOINT(EndpointsVisibility iBMCLOUDCOSCONFIGENDPOINT) {
        this.iBMCLOUDCOSCONFIGENDPOINT = iBMCLOUDCOSCONFIGENDPOINT;
    }

    @JsonProperty("IBMCLOUD_GS_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDGSAPIENDPOINT() {
        return iBMCLOUDGSAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_GS_API_ENDPOINT")
    public void setIBMCLOUDGSAPIENDPOINT(EndpointsVisibility iBMCLOUDGSAPIENDPOINT) {
        this.iBMCLOUDGSAPIENDPOINT = iBMCLOUDGSAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_GT_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDGTAPIENDPOINT() {
        return iBMCLOUDGTAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_GT_API_ENDPOINT")
    public void setIBMCLOUDGTAPIENDPOINT(EndpointsVisibility iBMCLOUDGTAPIENDPOINT) {
        this.iBMCLOUDGTAPIENDPOINT = iBMCLOUDGTAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_HPCS_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDHPCSAPIENDPOINT() {
        return iBMCLOUDHPCSAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_HPCS_API_ENDPOINT")
    public void setIBMCLOUDHPCSAPIENDPOINT(EndpointsVisibility iBMCLOUDHPCSAPIENDPOINT) {
        this.iBMCLOUDHPCSAPIENDPOINT = iBMCLOUDHPCSAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_IAM_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDIAMAPIENDPOINT() {
        return iBMCLOUDIAMAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_IAM_API_ENDPOINT")
    public void setIBMCLOUDIAMAPIENDPOINT(EndpointsVisibility iBMCLOUDIAMAPIENDPOINT) {
        this.iBMCLOUDIAMAPIENDPOINT = iBMCLOUDIAMAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_IS_NG_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDISNGAPIENDPOINT() {
        return iBMCLOUDISNGAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_IS_NG_API_ENDPOINT")
    public void setIBMCLOUDISNGAPIENDPOINT(EndpointsVisibility iBMCLOUDISNGAPIENDPOINT) {
        this.iBMCLOUDISNGAPIENDPOINT = iBMCLOUDISNGAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_KP_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDKPAPIENDPOINT() {
        return iBMCLOUDKPAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_KP_API_ENDPOINT")
    public void setIBMCLOUDKPAPIENDPOINT(EndpointsVisibility iBMCLOUDKPAPIENDPOINT) {
        this.iBMCLOUDKPAPIENDPOINT = iBMCLOUDKPAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_PRIVATE_DNS_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDPRIVATEDNSAPIENDPOINT() {
        return iBMCLOUDPRIVATEDNSAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_PRIVATE_DNS_API_ENDPOINT")
    public void setIBMCLOUDPRIVATEDNSAPIENDPOINT(EndpointsVisibility iBMCLOUDPRIVATEDNSAPIENDPOINT) {
        this.iBMCLOUDPRIVATEDNSAPIENDPOINT = iBMCLOUDPRIVATEDNSAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDRESOURCECONTROLLERAPIENDPOINT() {
        return iBMCLOUDRESOURCECONTROLLERAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT")
    public void setIBMCLOUDRESOURCECONTROLLERAPIENDPOINT(EndpointsVisibility iBMCLOUDRESOURCECONTROLLERAPIENDPOINT) {
        this.iBMCLOUDRESOURCECONTROLLERAPIENDPOINT = iBMCLOUDRESOURCECONTROLLERAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT() {
        return iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT;
    }

    @JsonProperty("IBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT")
    public void setIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT(EndpointsVisibility iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT) {
        this.iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT = iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT;
    }

    @JsonIgnore
    public EndpointsJSONBuilder edit() {
        return new EndpointsJSONBuilder(this);
    }

    @JsonIgnore
    public EndpointsJSONBuilder toBuilder() {
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
