
package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

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
 * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "IBMCLOUD_CIS_API_ENDPOINT",
    "IBMCLOUD_COS_CONFIG_ENDPOINT",
    "IBMCLOUD_COS_ENDPOINT",
    "IBMCLOUD_GS_API_ENDPOINT",
    "IBMCLOUD_GT_API_ENDPOINT",
    "IBMCLOUD_HPCS_API_ENDPOINT",
    "IBMCLOUD_IAM_API_ENDPOINT",
    "IBMCLOUD_IS_NG_API_ENDPOINT",
    "IBMCLOUD_KP_API_ENDPOINT",
    "IBMCLOUD_PRIVATE_DNS_API_ENDPOINT",
    "IBMCLOUD_RESOURCE_CATALOG_API_ENDPOINT",
    "IBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT",
    "IBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT"
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
    @JsonProperty("IBMCLOUD_COS_ENDPOINT")
    private EndpointsVisibility iBMCLOUDCOSENDPOINT;
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
    @JsonProperty("IBMCLOUD_RESOURCE_CATALOG_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUDRESOURCECATALOGAPIENDPOINT;
    @JsonProperty("IBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUDRESOURCECONTROLLERAPIENDPOINT;
    @JsonProperty("IBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT")
    private EndpointsVisibility iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EndpointsJSON() {
    }

    public EndpointsJSON(EndpointsVisibility iBMCLOUDCISAPIENDPOINT, EndpointsVisibility iBMCLOUDCOSCONFIGENDPOINT, EndpointsVisibility iBMCLOUDCOSENDPOINT, EndpointsVisibility iBMCLOUDGSAPIENDPOINT, EndpointsVisibility iBMCLOUDGTAPIENDPOINT, EndpointsVisibility iBMCLOUDHPCSAPIENDPOINT, EndpointsVisibility iBMCLOUDIAMAPIENDPOINT, EndpointsVisibility iBMCLOUDISNGAPIENDPOINT, EndpointsVisibility iBMCLOUDKPAPIENDPOINT, EndpointsVisibility iBMCLOUDPRIVATEDNSAPIENDPOINT, EndpointsVisibility iBMCLOUDRESOURCECATALOGAPIENDPOINT, EndpointsVisibility iBMCLOUDRESOURCECONTROLLERAPIENDPOINT, EndpointsVisibility iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT) {
        super();
        this.iBMCLOUDCISAPIENDPOINT = iBMCLOUDCISAPIENDPOINT;
        this.iBMCLOUDCOSCONFIGENDPOINT = iBMCLOUDCOSCONFIGENDPOINT;
        this.iBMCLOUDCOSENDPOINT = iBMCLOUDCOSENDPOINT;
        this.iBMCLOUDGSAPIENDPOINT = iBMCLOUDGSAPIENDPOINT;
        this.iBMCLOUDGTAPIENDPOINT = iBMCLOUDGTAPIENDPOINT;
        this.iBMCLOUDHPCSAPIENDPOINT = iBMCLOUDHPCSAPIENDPOINT;
        this.iBMCLOUDIAMAPIENDPOINT = iBMCLOUDIAMAPIENDPOINT;
        this.iBMCLOUDISNGAPIENDPOINT = iBMCLOUDISNGAPIENDPOINT;
        this.iBMCLOUDKPAPIENDPOINT = iBMCLOUDKPAPIENDPOINT;
        this.iBMCLOUDPRIVATEDNSAPIENDPOINT = iBMCLOUDPRIVATEDNSAPIENDPOINT;
        this.iBMCLOUDRESOURCECATALOGAPIENDPOINT = iBMCLOUDRESOURCECATALOGAPIENDPOINT;
        this.iBMCLOUDRESOURCECONTROLLERAPIENDPOINT = iBMCLOUDRESOURCECONTROLLERAPIENDPOINT;
        this.iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT = iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_CIS_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDCISAPIENDPOINT() {
        return iBMCLOUDCISAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_CIS_API_ENDPOINT")
    public void setIBMCLOUDCISAPIENDPOINT(EndpointsVisibility iBMCLOUDCISAPIENDPOINT) {
        this.iBMCLOUDCISAPIENDPOINT = iBMCLOUDCISAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_COS_CONFIG_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDCOSCONFIGENDPOINT() {
        return iBMCLOUDCOSCONFIGENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_COS_CONFIG_ENDPOINT")
    public void setIBMCLOUDCOSCONFIGENDPOINT(EndpointsVisibility iBMCLOUDCOSCONFIGENDPOINT) {
        this.iBMCLOUDCOSCONFIGENDPOINT = iBMCLOUDCOSCONFIGENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_COS_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDCOSENDPOINT() {
        return iBMCLOUDCOSENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_COS_ENDPOINT")
    public void setIBMCLOUDCOSENDPOINT(EndpointsVisibility iBMCLOUDCOSENDPOINT) {
        this.iBMCLOUDCOSENDPOINT = iBMCLOUDCOSENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_GS_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDGSAPIENDPOINT() {
        return iBMCLOUDGSAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_GS_API_ENDPOINT")
    public void setIBMCLOUDGSAPIENDPOINT(EndpointsVisibility iBMCLOUDGSAPIENDPOINT) {
        this.iBMCLOUDGSAPIENDPOINT = iBMCLOUDGSAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_GT_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDGTAPIENDPOINT() {
        return iBMCLOUDGTAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_GT_API_ENDPOINT")
    public void setIBMCLOUDGTAPIENDPOINT(EndpointsVisibility iBMCLOUDGTAPIENDPOINT) {
        this.iBMCLOUDGTAPIENDPOINT = iBMCLOUDGTAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_HPCS_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDHPCSAPIENDPOINT() {
        return iBMCLOUDHPCSAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_HPCS_API_ENDPOINT")
    public void setIBMCLOUDHPCSAPIENDPOINT(EndpointsVisibility iBMCLOUDHPCSAPIENDPOINT) {
        this.iBMCLOUDHPCSAPIENDPOINT = iBMCLOUDHPCSAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_IAM_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDIAMAPIENDPOINT() {
        return iBMCLOUDIAMAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_IAM_API_ENDPOINT")
    public void setIBMCLOUDIAMAPIENDPOINT(EndpointsVisibility iBMCLOUDIAMAPIENDPOINT) {
        this.iBMCLOUDIAMAPIENDPOINT = iBMCLOUDIAMAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_IS_NG_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDISNGAPIENDPOINT() {
        return iBMCLOUDISNGAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_IS_NG_API_ENDPOINT")
    public void setIBMCLOUDISNGAPIENDPOINT(EndpointsVisibility iBMCLOUDISNGAPIENDPOINT) {
        this.iBMCLOUDISNGAPIENDPOINT = iBMCLOUDISNGAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_KP_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDKPAPIENDPOINT() {
        return iBMCLOUDKPAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_KP_API_ENDPOINT")
    public void setIBMCLOUDKPAPIENDPOINT(EndpointsVisibility iBMCLOUDKPAPIENDPOINT) {
        this.iBMCLOUDKPAPIENDPOINT = iBMCLOUDKPAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_PRIVATE_DNS_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDPRIVATEDNSAPIENDPOINT() {
        return iBMCLOUDPRIVATEDNSAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_PRIVATE_DNS_API_ENDPOINT")
    public void setIBMCLOUDPRIVATEDNSAPIENDPOINT(EndpointsVisibility iBMCLOUDPRIVATEDNSAPIENDPOINT) {
        this.iBMCLOUDPRIVATEDNSAPIENDPOINT = iBMCLOUDPRIVATEDNSAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_RESOURCE_CATALOG_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDRESOURCECATALOGAPIENDPOINT() {
        return iBMCLOUDRESOURCECATALOGAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_RESOURCE_CATALOG_API_ENDPOINT")
    public void setIBMCLOUDRESOURCECATALOGAPIENDPOINT(EndpointsVisibility iBMCLOUDRESOURCECATALOGAPIENDPOINT) {
        this.iBMCLOUDRESOURCECATALOGAPIENDPOINT = iBMCLOUDRESOURCECATALOGAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDRESOURCECONTROLLERAPIENDPOINT() {
        return iBMCLOUDRESOURCECONTROLLERAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_RESOURCE_CONTROLLER_API_ENDPOINT")
    public void setIBMCLOUDRESOURCECONTROLLERAPIENDPOINT(EndpointsVisibility iBMCLOUDRESOURCECONTROLLERAPIENDPOINT) {
        this.iBMCLOUDRESOURCECONTROLLERAPIENDPOINT = iBMCLOUDRESOURCECONTROLLERAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
    @JsonProperty("IBMCLOUD_RESOURCE_MANAGEMENT_API_ENDPOINT")
    public EndpointsVisibility getIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT() {
        return iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT;
    }

    /**
     * EndpointsJSON represents the JSON format to override IBM Cloud Terraform provider utilized service endpoints. https://registry.terraform.io/providers/IBM-Cloud/ibm/latest/docs/guides/custom-service-endpoints#file-structure-for-endpoints-file
     */
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
        if (!(o instanceof EndpointsJSON)) {
            return false;
        }
        EndpointsJSON other = (EndpointsJSON) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$iBMCLOUDCISAPIENDPOINT = this.getIBMCLOUDCISAPIENDPOINT();
        Object other$iBMCLOUDCISAPIENDPOINT = other.getIBMCLOUDCISAPIENDPOINT();
        if (this$iBMCLOUDCISAPIENDPOINT == null ? other$iBMCLOUDCISAPIENDPOINT != null : !this$iBMCLOUDCISAPIENDPOINT.equals(other$iBMCLOUDCISAPIENDPOINT)) {
            return false;
        }
        Object this$iBMCLOUDCOSCONFIGENDPOINT = this.getIBMCLOUDCOSCONFIGENDPOINT();
        Object other$iBMCLOUDCOSCONFIGENDPOINT = other.getIBMCLOUDCOSCONFIGENDPOINT();
        if (this$iBMCLOUDCOSCONFIGENDPOINT == null ? other$iBMCLOUDCOSCONFIGENDPOINT != null : !this$iBMCLOUDCOSCONFIGENDPOINT.equals(other$iBMCLOUDCOSCONFIGENDPOINT)) {
            return false;
        }
        Object this$iBMCLOUDCOSENDPOINT = this.getIBMCLOUDCOSENDPOINT();
        Object other$iBMCLOUDCOSENDPOINT = other.getIBMCLOUDCOSENDPOINT();
        if (this$iBMCLOUDCOSENDPOINT == null ? other$iBMCLOUDCOSENDPOINT != null : !this$iBMCLOUDCOSENDPOINT.equals(other$iBMCLOUDCOSENDPOINT)) {
            return false;
        }
        Object this$iBMCLOUDGSAPIENDPOINT = this.getIBMCLOUDGSAPIENDPOINT();
        Object other$iBMCLOUDGSAPIENDPOINT = other.getIBMCLOUDGSAPIENDPOINT();
        if (this$iBMCLOUDGSAPIENDPOINT == null ? other$iBMCLOUDGSAPIENDPOINT != null : !this$iBMCLOUDGSAPIENDPOINT.equals(other$iBMCLOUDGSAPIENDPOINT)) {
            return false;
        }
        Object this$iBMCLOUDGTAPIENDPOINT = this.getIBMCLOUDGTAPIENDPOINT();
        Object other$iBMCLOUDGTAPIENDPOINT = other.getIBMCLOUDGTAPIENDPOINT();
        if (this$iBMCLOUDGTAPIENDPOINT == null ? other$iBMCLOUDGTAPIENDPOINT != null : !this$iBMCLOUDGTAPIENDPOINT.equals(other$iBMCLOUDGTAPIENDPOINT)) {
            return false;
        }
        Object this$iBMCLOUDHPCSAPIENDPOINT = this.getIBMCLOUDHPCSAPIENDPOINT();
        Object other$iBMCLOUDHPCSAPIENDPOINT = other.getIBMCLOUDHPCSAPIENDPOINT();
        if (this$iBMCLOUDHPCSAPIENDPOINT == null ? other$iBMCLOUDHPCSAPIENDPOINT != null : !this$iBMCLOUDHPCSAPIENDPOINT.equals(other$iBMCLOUDHPCSAPIENDPOINT)) {
            return false;
        }
        Object this$iBMCLOUDIAMAPIENDPOINT = this.getIBMCLOUDIAMAPIENDPOINT();
        Object other$iBMCLOUDIAMAPIENDPOINT = other.getIBMCLOUDIAMAPIENDPOINT();
        if (this$iBMCLOUDIAMAPIENDPOINT == null ? other$iBMCLOUDIAMAPIENDPOINT != null : !this$iBMCLOUDIAMAPIENDPOINT.equals(other$iBMCLOUDIAMAPIENDPOINT)) {
            return false;
        }
        Object this$iBMCLOUDISNGAPIENDPOINT = this.getIBMCLOUDISNGAPIENDPOINT();
        Object other$iBMCLOUDISNGAPIENDPOINT = other.getIBMCLOUDISNGAPIENDPOINT();
        if (this$iBMCLOUDISNGAPIENDPOINT == null ? other$iBMCLOUDISNGAPIENDPOINT != null : !this$iBMCLOUDISNGAPIENDPOINT.equals(other$iBMCLOUDISNGAPIENDPOINT)) {
            return false;
        }
        Object this$iBMCLOUDKPAPIENDPOINT = this.getIBMCLOUDKPAPIENDPOINT();
        Object other$iBMCLOUDKPAPIENDPOINT = other.getIBMCLOUDKPAPIENDPOINT();
        if (this$iBMCLOUDKPAPIENDPOINT == null ? other$iBMCLOUDKPAPIENDPOINT != null : !this$iBMCLOUDKPAPIENDPOINT.equals(other$iBMCLOUDKPAPIENDPOINT)) {
            return false;
        }
        Object this$iBMCLOUDPRIVATEDNSAPIENDPOINT = this.getIBMCLOUDPRIVATEDNSAPIENDPOINT();
        Object other$iBMCLOUDPRIVATEDNSAPIENDPOINT = other.getIBMCLOUDPRIVATEDNSAPIENDPOINT();
        if (this$iBMCLOUDPRIVATEDNSAPIENDPOINT == null ? other$iBMCLOUDPRIVATEDNSAPIENDPOINT != null : !this$iBMCLOUDPRIVATEDNSAPIENDPOINT.equals(other$iBMCLOUDPRIVATEDNSAPIENDPOINT)) {
            return false;
        }
        Object this$iBMCLOUDRESOURCECATALOGAPIENDPOINT = this.getIBMCLOUDRESOURCECATALOGAPIENDPOINT();
        Object other$iBMCLOUDRESOURCECATALOGAPIENDPOINT = other.getIBMCLOUDRESOURCECATALOGAPIENDPOINT();
        if (this$iBMCLOUDRESOURCECATALOGAPIENDPOINT == null ? other$iBMCLOUDRESOURCECATALOGAPIENDPOINT != null : !this$iBMCLOUDRESOURCECATALOGAPIENDPOINT.equals(other$iBMCLOUDRESOURCECATALOGAPIENDPOINT)) {
            return false;
        }
        Object this$iBMCLOUDRESOURCECONTROLLERAPIENDPOINT = this.getIBMCLOUDRESOURCECONTROLLERAPIENDPOINT();
        Object other$iBMCLOUDRESOURCECONTROLLERAPIENDPOINT = other.getIBMCLOUDRESOURCECONTROLLERAPIENDPOINT();
        if (this$iBMCLOUDRESOURCECONTROLLERAPIENDPOINT == null ? other$iBMCLOUDRESOURCECONTROLLERAPIENDPOINT != null : !this$iBMCLOUDRESOURCECONTROLLERAPIENDPOINT.equals(other$iBMCLOUDRESOURCECONTROLLERAPIENDPOINT)) {
            return false;
        }
        Object this$iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT = this.getIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT();
        Object other$iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT = other.getIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT();
        if (this$iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT == null ? other$iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT != null : !this$iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT.equals(other$iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT)) {
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
        return other instanceof EndpointsJSON;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $iBMCLOUDCISAPIENDPOINT = this.getIBMCLOUDCISAPIENDPOINT();
        result = result * prime + ($iBMCLOUDCISAPIENDPOINT == null ? 43 : $iBMCLOUDCISAPIENDPOINT.hashCode());
        Object $iBMCLOUDCOSCONFIGENDPOINT = this.getIBMCLOUDCOSCONFIGENDPOINT();
        result = result * prime + ($iBMCLOUDCOSCONFIGENDPOINT == null ? 43 : $iBMCLOUDCOSCONFIGENDPOINT.hashCode());
        Object $iBMCLOUDCOSENDPOINT = this.getIBMCLOUDCOSENDPOINT();
        result = result * prime + ($iBMCLOUDCOSENDPOINT == null ? 43 : $iBMCLOUDCOSENDPOINT.hashCode());
        Object $iBMCLOUDGSAPIENDPOINT = this.getIBMCLOUDGSAPIENDPOINT();
        result = result * prime + ($iBMCLOUDGSAPIENDPOINT == null ? 43 : $iBMCLOUDGSAPIENDPOINT.hashCode());
        Object $iBMCLOUDGTAPIENDPOINT = this.getIBMCLOUDGTAPIENDPOINT();
        result = result * prime + ($iBMCLOUDGTAPIENDPOINT == null ? 43 : $iBMCLOUDGTAPIENDPOINT.hashCode());
        Object $iBMCLOUDHPCSAPIENDPOINT = this.getIBMCLOUDHPCSAPIENDPOINT();
        result = result * prime + ($iBMCLOUDHPCSAPIENDPOINT == null ? 43 : $iBMCLOUDHPCSAPIENDPOINT.hashCode());
        Object $iBMCLOUDIAMAPIENDPOINT = this.getIBMCLOUDIAMAPIENDPOINT();
        result = result * prime + ($iBMCLOUDIAMAPIENDPOINT == null ? 43 : $iBMCLOUDIAMAPIENDPOINT.hashCode());
        Object $iBMCLOUDISNGAPIENDPOINT = this.getIBMCLOUDISNGAPIENDPOINT();
        result = result * prime + ($iBMCLOUDISNGAPIENDPOINT == null ? 43 : $iBMCLOUDISNGAPIENDPOINT.hashCode());
        Object $iBMCLOUDKPAPIENDPOINT = this.getIBMCLOUDKPAPIENDPOINT();
        result = result * prime + ($iBMCLOUDKPAPIENDPOINT == null ? 43 : $iBMCLOUDKPAPIENDPOINT.hashCode());
        Object $iBMCLOUDPRIVATEDNSAPIENDPOINT = this.getIBMCLOUDPRIVATEDNSAPIENDPOINT();
        result = result * prime + ($iBMCLOUDPRIVATEDNSAPIENDPOINT == null ? 43 : $iBMCLOUDPRIVATEDNSAPIENDPOINT.hashCode());
        Object $iBMCLOUDRESOURCECATALOGAPIENDPOINT = this.getIBMCLOUDRESOURCECATALOGAPIENDPOINT();
        result = result * prime + ($iBMCLOUDRESOURCECATALOGAPIENDPOINT == null ? 43 : $iBMCLOUDRESOURCECATALOGAPIENDPOINT.hashCode());
        Object $iBMCLOUDRESOURCECONTROLLERAPIENDPOINT = this.getIBMCLOUDRESOURCECONTROLLERAPIENDPOINT();
        result = result * prime + ($iBMCLOUDRESOURCECONTROLLERAPIENDPOINT == null ? 43 : $iBMCLOUDRESOURCECONTROLLERAPIENDPOINT.hashCode());
        Object $iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT = this.getIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT();
        result = result * prime + ($iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT == null ? 43 : $iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EndpointsJSON(" + "iBMCLOUDCISAPIENDPOINT=" + this.getIBMCLOUDCISAPIENDPOINT() + ", iBMCLOUDCOSCONFIGENDPOINT=" + this.getIBMCLOUDCOSCONFIGENDPOINT() + ", iBMCLOUDCOSENDPOINT=" + this.getIBMCLOUDCOSENDPOINT() + ", iBMCLOUDGSAPIENDPOINT=" + this.getIBMCLOUDGSAPIENDPOINT() + ", iBMCLOUDGTAPIENDPOINT=" + this.getIBMCLOUDGTAPIENDPOINT() + ", iBMCLOUDHPCSAPIENDPOINT=" + this.getIBMCLOUDHPCSAPIENDPOINT() + ", iBMCLOUDIAMAPIENDPOINT=" + this.getIBMCLOUDIAMAPIENDPOINT() + ", iBMCLOUDISNGAPIENDPOINT=" + this.getIBMCLOUDISNGAPIENDPOINT() + ", iBMCLOUDKPAPIENDPOINT=" + this.getIBMCLOUDKPAPIENDPOINT() + ", iBMCLOUDPRIVATEDNSAPIENDPOINT=" + this.getIBMCLOUDPRIVATEDNSAPIENDPOINT() + ", iBMCLOUDRESOURCECATALOGAPIENDPOINT=" + this.getIBMCLOUDRESOURCECATALOGAPIENDPOINT() + ", iBMCLOUDRESOURCECONTROLLERAPIENDPOINT=" + this.getIBMCLOUDRESOURCECONTROLLERAPIENDPOINT() + ", iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT=" + this.getIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
