package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class EndpointsJSONFluent<A extends io.fabric8.openshift.api.model.installer.ibmcloud.v1.EndpointsJSONFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private EndpointsVisibilityBuilder iBMCLOUDCISAPIENDPOINT;
  private EndpointsVisibilityBuilder iBMCLOUDCOSCONFIGENDPOINT;
  private EndpointsVisibilityBuilder iBMCLOUDCOSENDPOINT;
  private EndpointsVisibilityBuilder iBMCLOUDGSAPIENDPOINT;
  private EndpointsVisibilityBuilder iBMCLOUDGTAPIENDPOINT;
  private EndpointsVisibilityBuilder iBMCLOUDHPCSAPIENDPOINT;
  private EndpointsVisibilityBuilder iBMCLOUDIAMAPIENDPOINT;
  private EndpointsVisibilityBuilder iBMCLOUDISNGAPIENDPOINT;
  private EndpointsVisibilityBuilder iBMCLOUDKPAPIENDPOINT;
  private EndpointsVisibilityBuilder iBMCLOUDPRIVATEDNSAPIENDPOINT;
  private EndpointsVisibilityBuilder iBMCLOUDRESOURCECATALOGAPIENDPOINT;
  private EndpointsVisibilityBuilder iBMCLOUDRESOURCECONTROLLERAPIENDPOINT;
  private EndpointsVisibilityBuilder iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT;

  public EndpointsJSONFluent() {
  }
  
  public EndpointsJSONFluent(EndpointsJSON instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public EndpointsVisibility buildIBMCLOUDCISAPIENDPOINT() {
    return this.iBMCLOUDCISAPIENDPOINT != null ? this.iBMCLOUDCISAPIENDPOINT.build() : null;
  }
  
  public EndpointsVisibility buildIBMCLOUDCOSCONFIGENDPOINT() {
    return this.iBMCLOUDCOSCONFIGENDPOINT != null ? this.iBMCLOUDCOSCONFIGENDPOINT.build() : null;
  }
  
  public EndpointsVisibility buildIBMCLOUDCOSENDPOINT() {
    return this.iBMCLOUDCOSENDPOINT != null ? this.iBMCLOUDCOSENDPOINT.build() : null;
  }
  
  public EndpointsVisibility buildIBMCLOUDGSAPIENDPOINT() {
    return this.iBMCLOUDGSAPIENDPOINT != null ? this.iBMCLOUDGSAPIENDPOINT.build() : null;
  }
  
  public EndpointsVisibility buildIBMCLOUDGTAPIENDPOINT() {
    return this.iBMCLOUDGTAPIENDPOINT != null ? this.iBMCLOUDGTAPIENDPOINT.build() : null;
  }
  
  public EndpointsVisibility buildIBMCLOUDHPCSAPIENDPOINT() {
    return this.iBMCLOUDHPCSAPIENDPOINT != null ? this.iBMCLOUDHPCSAPIENDPOINT.build() : null;
  }
  
  public EndpointsVisibility buildIBMCLOUDIAMAPIENDPOINT() {
    return this.iBMCLOUDIAMAPIENDPOINT != null ? this.iBMCLOUDIAMAPIENDPOINT.build() : null;
  }
  
  public EndpointsVisibility buildIBMCLOUDISNGAPIENDPOINT() {
    return this.iBMCLOUDISNGAPIENDPOINT != null ? this.iBMCLOUDISNGAPIENDPOINT.build() : null;
  }
  
  public EndpointsVisibility buildIBMCLOUDKPAPIENDPOINT() {
    return this.iBMCLOUDKPAPIENDPOINT != null ? this.iBMCLOUDKPAPIENDPOINT.build() : null;
  }
  
  public EndpointsVisibility buildIBMCLOUDPRIVATEDNSAPIENDPOINT() {
    return this.iBMCLOUDPRIVATEDNSAPIENDPOINT != null ? this.iBMCLOUDPRIVATEDNSAPIENDPOINT.build() : null;
  }
  
  public EndpointsVisibility buildIBMCLOUDRESOURCECATALOGAPIENDPOINT() {
    return this.iBMCLOUDRESOURCECATALOGAPIENDPOINT != null ? this.iBMCLOUDRESOURCECATALOGAPIENDPOINT.build() : null;
  }
  
  public EndpointsVisibility buildIBMCLOUDRESOURCECONTROLLERAPIENDPOINT() {
    return this.iBMCLOUDRESOURCECONTROLLERAPIENDPOINT != null ? this.iBMCLOUDRESOURCECONTROLLERAPIENDPOINT.build() : null;
  }
  
  public EndpointsVisibility buildIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT() {
    return this.iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT != null ? this.iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT.build() : null;
  }
  
  protected void copyInstance(EndpointsJSON instance) {
    instance = instance != null ? instance : new EndpointsJSON();
    if (instance != null) {
        this.withIBMCLOUDCISAPIENDPOINT(instance.getIBMCLOUDCISAPIENDPOINT());
        this.withIBMCLOUDCOSCONFIGENDPOINT(instance.getIBMCLOUDCOSCONFIGENDPOINT());
        this.withIBMCLOUDCOSENDPOINT(instance.getIBMCLOUDCOSENDPOINT());
        this.withIBMCLOUDGSAPIENDPOINT(instance.getIBMCLOUDGSAPIENDPOINT());
        this.withIBMCLOUDGTAPIENDPOINT(instance.getIBMCLOUDGTAPIENDPOINT());
        this.withIBMCLOUDHPCSAPIENDPOINT(instance.getIBMCLOUDHPCSAPIENDPOINT());
        this.withIBMCLOUDIAMAPIENDPOINT(instance.getIBMCLOUDIAMAPIENDPOINT());
        this.withIBMCLOUDISNGAPIENDPOINT(instance.getIBMCLOUDISNGAPIENDPOINT());
        this.withIBMCLOUDKPAPIENDPOINT(instance.getIBMCLOUDKPAPIENDPOINT());
        this.withIBMCLOUDPRIVATEDNSAPIENDPOINT(instance.getIBMCLOUDPRIVATEDNSAPIENDPOINT());
        this.withIBMCLOUDRESOURCECATALOGAPIENDPOINT(instance.getIBMCLOUDRESOURCECATALOGAPIENDPOINT());
        this.withIBMCLOUDRESOURCECONTROLLERAPIENDPOINT(instance.getIBMCLOUDRESOURCECONTROLLERAPIENDPOINT());
        this.withIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT(instance.getIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IBMCLOUDCISAPIENDPOINTNested<A> editIBMCLOUDCISAPIENDPOINT() {
    return this.withNewIBMCLOUDCISAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDCISAPIENDPOINT()).orElse(null));
  }
  
  public IBMCLOUDCOSCONFIGENDPOINTNested<A> editIBMCLOUDCOSCONFIGENDPOINT() {
    return this.withNewIBMCLOUDCOSCONFIGENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDCOSCONFIGENDPOINT()).orElse(null));
  }
  
  public IBMCLOUDCOSENDPOINTNested<A> editIBMCLOUDCOSENDPOINT() {
    return this.withNewIBMCLOUDCOSENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDCOSENDPOINT()).orElse(null));
  }
  
  public IBMCLOUDGSAPIENDPOINTNested<A> editIBMCLOUDGSAPIENDPOINT() {
    return this.withNewIBMCLOUDGSAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDGSAPIENDPOINT()).orElse(null));
  }
  
  public IBMCLOUDGTAPIENDPOINTNested<A> editIBMCLOUDGTAPIENDPOINT() {
    return this.withNewIBMCLOUDGTAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDGTAPIENDPOINT()).orElse(null));
  }
  
  public IBMCLOUDHPCSAPIENDPOINTNested<A> editIBMCLOUDHPCSAPIENDPOINT() {
    return this.withNewIBMCLOUDHPCSAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDHPCSAPIENDPOINT()).orElse(null));
  }
  
  public IBMCLOUDIAMAPIENDPOINTNested<A> editIBMCLOUDIAMAPIENDPOINT() {
    return this.withNewIBMCLOUDIAMAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDIAMAPIENDPOINT()).orElse(null));
  }
  
  public IBMCLOUDISNGAPIENDPOINTNested<A> editIBMCLOUDISNGAPIENDPOINT() {
    return this.withNewIBMCLOUDISNGAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDISNGAPIENDPOINT()).orElse(null));
  }
  
  public IBMCLOUDKPAPIENDPOINTNested<A> editIBMCLOUDKPAPIENDPOINT() {
    return this.withNewIBMCLOUDKPAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDKPAPIENDPOINT()).orElse(null));
  }
  
  public IBMCLOUDPRIVATEDNSAPIENDPOINTNested<A> editIBMCLOUDPRIVATEDNSAPIENDPOINT() {
    return this.withNewIBMCLOUDPRIVATEDNSAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDPRIVATEDNSAPIENDPOINT()).orElse(null));
  }
  
  public IBMCLOUDRESOURCECATALOGAPIENDPOINTNested<A> editIBMCLOUDRESOURCECATALOGAPIENDPOINT() {
    return this.withNewIBMCLOUDRESOURCECATALOGAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDRESOURCECATALOGAPIENDPOINT()).orElse(null));
  }
  
  public IBMCLOUDRESOURCECONTROLLERAPIENDPOINTNested<A> editIBMCLOUDRESOURCECONTROLLERAPIENDPOINT() {
    return this.withNewIBMCLOUDRESOURCECONTROLLERAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDRESOURCECONTROLLERAPIENDPOINT()).orElse(null));
  }
  
  public IBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTNested<A> editIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT() {
    return this.withNewIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT()).orElse(null));
  }
  
  public IBMCLOUDCISAPIENDPOINTNested<A> editOrNewIBMCLOUDCISAPIENDPOINT() {
    return this.withNewIBMCLOUDCISAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDCISAPIENDPOINT()).orElse(new EndpointsVisibilityBuilder().build()));
  }
  
  public IBMCLOUDCISAPIENDPOINTNested<A> editOrNewIBMCLOUDCISAPIENDPOINTLike(EndpointsVisibility item) {
    return this.withNewIBMCLOUDCISAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDCISAPIENDPOINT()).orElse(item));
  }
  
  public IBMCLOUDCOSCONFIGENDPOINTNested<A> editOrNewIBMCLOUDCOSCONFIGENDPOINT() {
    return this.withNewIBMCLOUDCOSCONFIGENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDCOSCONFIGENDPOINT()).orElse(new EndpointsVisibilityBuilder().build()));
  }
  
  public IBMCLOUDCOSCONFIGENDPOINTNested<A> editOrNewIBMCLOUDCOSCONFIGENDPOINTLike(EndpointsVisibility item) {
    return this.withNewIBMCLOUDCOSCONFIGENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDCOSCONFIGENDPOINT()).orElse(item));
  }
  
  public IBMCLOUDCOSENDPOINTNested<A> editOrNewIBMCLOUDCOSENDPOINT() {
    return this.withNewIBMCLOUDCOSENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDCOSENDPOINT()).orElse(new EndpointsVisibilityBuilder().build()));
  }
  
  public IBMCLOUDCOSENDPOINTNested<A> editOrNewIBMCLOUDCOSENDPOINTLike(EndpointsVisibility item) {
    return this.withNewIBMCLOUDCOSENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDCOSENDPOINT()).orElse(item));
  }
  
  public IBMCLOUDGSAPIENDPOINTNested<A> editOrNewIBMCLOUDGSAPIENDPOINT() {
    return this.withNewIBMCLOUDGSAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDGSAPIENDPOINT()).orElse(new EndpointsVisibilityBuilder().build()));
  }
  
  public IBMCLOUDGSAPIENDPOINTNested<A> editOrNewIBMCLOUDGSAPIENDPOINTLike(EndpointsVisibility item) {
    return this.withNewIBMCLOUDGSAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDGSAPIENDPOINT()).orElse(item));
  }
  
  public IBMCLOUDGTAPIENDPOINTNested<A> editOrNewIBMCLOUDGTAPIENDPOINT() {
    return this.withNewIBMCLOUDGTAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDGTAPIENDPOINT()).orElse(new EndpointsVisibilityBuilder().build()));
  }
  
  public IBMCLOUDGTAPIENDPOINTNested<A> editOrNewIBMCLOUDGTAPIENDPOINTLike(EndpointsVisibility item) {
    return this.withNewIBMCLOUDGTAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDGTAPIENDPOINT()).orElse(item));
  }
  
  public IBMCLOUDHPCSAPIENDPOINTNested<A> editOrNewIBMCLOUDHPCSAPIENDPOINT() {
    return this.withNewIBMCLOUDHPCSAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDHPCSAPIENDPOINT()).orElse(new EndpointsVisibilityBuilder().build()));
  }
  
  public IBMCLOUDHPCSAPIENDPOINTNested<A> editOrNewIBMCLOUDHPCSAPIENDPOINTLike(EndpointsVisibility item) {
    return this.withNewIBMCLOUDHPCSAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDHPCSAPIENDPOINT()).orElse(item));
  }
  
  public IBMCLOUDIAMAPIENDPOINTNested<A> editOrNewIBMCLOUDIAMAPIENDPOINT() {
    return this.withNewIBMCLOUDIAMAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDIAMAPIENDPOINT()).orElse(new EndpointsVisibilityBuilder().build()));
  }
  
  public IBMCLOUDIAMAPIENDPOINTNested<A> editOrNewIBMCLOUDIAMAPIENDPOINTLike(EndpointsVisibility item) {
    return this.withNewIBMCLOUDIAMAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDIAMAPIENDPOINT()).orElse(item));
  }
  
  public IBMCLOUDISNGAPIENDPOINTNested<A> editOrNewIBMCLOUDISNGAPIENDPOINT() {
    return this.withNewIBMCLOUDISNGAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDISNGAPIENDPOINT()).orElse(new EndpointsVisibilityBuilder().build()));
  }
  
  public IBMCLOUDISNGAPIENDPOINTNested<A> editOrNewIBMCLOUDISNGAPIENDPOINTLike(EndpointsVisibility item) {
    return this.withNewIBMCLOUDISNGAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDISNGAPIENDPOINT()).orElse(item));
  }
  
  public IBMCLOUDKPAPIENDPOINTNested<A> editOrNewIBMCLOUDKPAPIENDPOINT() {
    return this.withNewIBMCLOUDKPAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDKPAPIENDPOINT()).orElse(new EndpointsVisibilityBuilder().build()));
  }
  
  public IBMCLOUDKPAPIENDPOINTNested<A> editOrNewIBMCLOUDKPAPIENDPOINTLike(EndpointsVisibility item) {
    return this.withNewIBMCLOUDKPAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDKPAPIENDPOINT()).orElse(item));
  }
  
  public IBMCLOUDPRIVATEDNSAPIENDPOINTNested<A> editOrNewIBMCLOUDPRIVATEDNSAPIENDPOINT() {
    return this.withNewIBMCLOUDPRIVATEDNSAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDPRIVATEDNSAPIENDPOINT()).orElse(new EndpointsVisibilityBuilder().build()));
  }
  
  public IBMCLOUDPRIVATEDNSAPIENDPOINTNested<A> editOrNewIBMCLOUDPRIVATEDNSAPIENDPOINTLike(EndpointsVisibility item) {
    return this.withNewIBMCLOUDPRIVATEDNSAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDPRIVATEDNSAPIENDPOINT()).orElse(item));
  }
  
  public IBMCLOUDRESOURCECATALOGAPIENDPOINTNested<A> editOrNewIBMCLOUDRESOURCECATALOGAPIENDPOINT() {
    return this.withNewIBMCLOUDRESOURCECATALOGAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDRESOURCECATALOGAPIENDPOINT()).orElse(new EndpointsVisibilityBuilder().build()));
  }
  
  public IBMCLOUDRESOURCECATALOGAPIENDPOINTNested<A> editOrNewIBMCLOUDRESOURCECATALOGAPIENDPOINTLike(EndpointsVisibility item) {
    return this.withNewIBMCLOUDRESOURCECATALOGAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDRESOURCECATALOGAPIENDPOINT()).orElse(item));
  }
  
  public IBMCLOUDRESOURCECONTROLLERAPIENDPOINTNested<A> editOrNewIBMCLOUDRESOURCECONTROLLERAPIENDPOINT() {
    return this.withNewIBMCLOUDRESOURCECONTROLLERAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDRESOURCECONTROLLERAPIENDPOINT()).orElse(new EndpointsVisibilityBuilder().build()));
  }
  
  public IBMCLOUDRESOURCECONTROLLERAPIENDPOINTNested<A> editOrNewIBMCLOUDRESOURCECONTROLLERAPIENDPOINTLike(EndpointsVisibility item) {
    return this.withNewIBMCLOUDRESOURCECONTROLLERAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDRESOURCECONTROLLERAPIENDPOINT()).orElse(item));
  }
  
  public IBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTNested<A> editOrNewIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT() {
    return this.withNewIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT()).orElse(new EndpointsVisibilityBuilder().build()));
  }
  
  public IBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTNested<A> editOrNewIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTLike(EndpointsVisibility item) {
    return this.withNewIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTLike(Optional.ofNullable(this.buildIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT()).orElse(item));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    EndpointsJSONFluent that = (EndpointsJSONFluent) o;
    if (!(Objects.equals(iBMCLOUDCISAPIENDPOINT, that.iBMCLOUDCISAPIENDPOINT))) {
      return false;
    }
    if (!(Objects.equals(iBMCLOUDCOSCONFIGENDPOINT, that.iBMCLOUDCOSCONFIGENDPOINT))) {
      return false;
    }
    if (!(Objects.equals(iBMCLOUDCOSENDPOINT, that.iBMCLOUDCOSENDPOINT))) {
      return false;
    }
    if (!(Objects.equals(iBMCLOUDGSAPIENDPOINT, that.iBMCLOUDGSAPIENDPOINT))) {
      return false;
    }
    if (!(Objects.equals(iBMCLOUDGTAPIENDPOINT, that.iBMCLOUDGTAPIENDPOINT))) {
      return false;
    }
    if (!(Objects.equals(iBMCLOUDHPCSAPIENDPOINT, that.iBMCLOUDHPCSAPIENDPOINT))) {
      return false;
    }
    if (!(Objects.equals(iBMCLOUDIAMAPIENDPOINT, that.iBMCLOUDIAMAPIENDPOINT))) {
      return false;
    }
    if (!(Objects.equals(iBMCLOUDISNGAPIENDPOINT, that.iBMCLOUDISNGAPIENDPOINT))) {
      return false;
    }
    if (!(Objects.equals(iBMCLOUDKPAPIENDPOINT, that.iBMCLOUDKPAPIENDPOINT))) {
      return false;
    }
    if (!(Objects.equals(iBMCLOUDPRIVATEDNSAPIENDPOINT, that.iBMCLOUDPRIVATEDNSAPIENDPOINT))) {
      return false;
    }
    if (!(Objects.equals(iBMCLOUDRESOURCECATALOGAPIENDPOINT, that.iBMCLOUDRESOURCECATALOGAPIENDPOINT))) {
      return false;
    }
    if (!(Objects.equals(iBMCLOUDRESOURCECONTROLLERAPIENDPOINT, that.iBMCLOUDRESOURCECONTROLLERAPIENDPOINT))) {
      return false;
    }
    if (!(Objects.equals(iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT, that.iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIBMCLOUDCISAPIENDPOINT() {
    return this.iBMCLOUDCISAPIENDPOINT != null;
  }
  
  public boolean hasIBMCLOUDCOSCONFIGENDPOINT() {
    return this.iBMCLOUDCOSCONFIGENDPOINT != null;
  }
  
  public boolean hasIBMCLOUDCOSENDPOINT() {
    return this.iBMCLOUDCOSENDPOINT != null;
  }
  
  public boolean hasIBMCLOUDGSAPIENDPOINT() {
    return this.iBMCLOUDGSAPIENDPOINT != null;
  }
  
  public boolean hasIBMCLOUDGTAPIENDPOINT() {
    return this.iBMCLOUDGTAPIENDPOINT != null;
  }
  
  public boolean hasIBMCLOUDHPCSAPIENDPOINT() {
    return this.iBMCLOUDHPCSAPIENDPOINT != null;
  }
  
  public boolean hasIBMCLOUDIAMAPIENDPOINT() {
    return this.iBMCLOUDIAMAPIENDPOINT != null;
  }
  
  public boolean hasIBMCLOUDISNGAPIENDPOINT() {
    return this.iBMCLOUDISNGAPIENDPOINT != null;
  }
  
  public boolean hasIBMCLOUDKPAPIENDPOINT() {
    return this.iBMCLOUDKPAPIENDPOINT != null;
  }
  
  public boolean hasIBMCLOUDPRIVATEDNSAPIENDPOINT() {
    return this.iBMCLOUDPRIVATEDNSAPIENDPOINT != null;
  }
  
  public boolean hasIBMCLOUDRESOURCECATALOGAPIENDPOINT() {
    return this.iBMCLOUDRESOURCECATALOGAPIENDPOINT != null;
  }
  
  public boolean hasIBMCLOUDRESOURCECONTROLLERAPIENDPOINT() {
    return this.iBMCLOUDRESOURCECONTROLLERAPIENDPOINT != null;
  }
  
  public boolean hasIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT() {
    return this.iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT != null;
  }
  
  public int hashCode() {
    return Objects.hash(iBMCLOUDCISAPIENDPOINT, iBMCLOUDCOSCONFIGENDPOINT, iBMCLOUDCOSENDPOINT, iBMCLOUDGSAPIENDPOINT, iBMCLOUDGTAPIENDPOINT, iBMCLOUDHPCSAPIENDPOINT, iBMCLOUDIAMAPIENDPOINT, iBMCLOUDISNGAPIENDPOINT, iBMCLOUDKPAPIENDPOINT, iBMCLOUDPRIVATEDNSAPIENDPOINT, iBMCLOUDRESOURCECATALOGAPIENDPOINT, iBMCLOUDRESOURCECONTROLLERAPIENDPOINT, iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(iBMCLOUDCISAPIENDPOINT == null)) {
        sb.append("iBMCLOUDCISAPIENDPOINT:");
        sb.append(iBMCLOUDCISAPIENDPOINT);
        sb.append(",");
    }
    if (!(iBMCLOUDCOSCONFIGENDPOINT == null)) {
        sb.append("iBMCLOUDCOSCONFIGENDPOINT:");
        sb.append(iBMCLOUDCOSCONFIGENDPOINT);
        sb.append(",");
    }
    if (!(iBMCLOUDCOSENDPOINT == null)) {
        sb.append("iBMCLOUDCOSENDPOINT:");
        sb.append(iBMCLOUDCOSENDPOINT);
        sb.append(",");
    }
    if (!(iBMCLOUDGSAPIENDPOINT == null)) {
        sb.append("iBMCLOUDGSAPIENDPOINT:");
        sb.append(iBMCLOUDGSAPIENDPOINT);
        sb.append(",");
    }
    if (!(iBMCLOUDGTAPIENDPOINT == null)) {
        sb.append("iBMCLOUDGTAPIENDPOINT:");
        sb.append(iBMCLOUDGTAPIENDPOINT);
        sb.append(",");
    }
    if (!(iBMCLOUDHPCSAPIENDPOINT == null)) {
        sb.append("iBMCLOUDHPCSAPIENDPOINT:");
        sb.append(iBMCLOUDHPCSAPIENDPOINT);
        sb.append(",");
    }
    if (!(iBMCLOUDIAMAPIENDPOINT == null)) {
        sb.append("iBMCLOUDIAMAPIENDPOINT:");
        sb.append(iBMCLOUDIAMAPIENDPOINT);
        sb.append(",");
    }
    if (!(iBMCLOUDISNGAPIENDPOINT == null)) {
        sb.append("iBMCLOUDISNGAPIENDPOINT:");
        sb.append(iBMCLOUDISNGAPIENDPOINT);
        sb.append(",");
    }
    if (!(iBMCLOUDKPAPIENDPOINT == null)) {
        sb.append("iBMCLOUDKPAPIENDPOINT:");
        sb.append(iBMCLOUDKPAPIENDPOINT);
        sb.append(",");
    }
    if (!(iBMCLOUDPRIVATEDNSAPIENDPOINT == null)) {
        sb.append("iBMCLOUDPRIVATEDNSAPIENDPOINT:");
        sb.append(iBMCLOUDPRIVATEDNSAPIENDPOINT);
        sb.append(",");
    }
    if (!(iBMCLOUDRESOURCECATALOGAPIENDPOINT == null)) {
        sb.append("iBMCLOUDRESOURCECATALOGAPIENDPOINT:");
        sb.append(iBMCLOUDRESOURCECATALOGAPIENDPOINT);
        sb.append(",");
    }
    if (!(iBMCLOUDRESOURCECONTROLLERAPIENDPOINT == null)) {
        sb.append("iBMCLOUDRESOURCECONTROLLERAPIENDPOINT:");
        sb.append(iBMCLOUDRESOURCECONTROLLERAPIENDPOINT);
        sb.append(",");
    }
    if (!(iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT == null)) {
        sb.append("iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT:");
        sb.append(iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withIBMCLOUDCISAPIENDPOINT(EndpointsVisibility iBMCLOUDCISAPIENDPOINT) {
    this._visitables.remove("iBMCLOUDCISAPIENDPOINT");
    if (iBMCLOUDCISAPIENDPOINT != null) {
        this.iBMCLOUDCISAPIENDPOINT = new EndpointsVisibilityBuilder(iBMCLOUDCISAPIENDPOINT);
        this._visitables.get("iBMCLOUDCISAPIENDPOINT").add(this.iBMCLOUDCISAPIENDPOINT);
    } else {
        this.iBMCLOUDCISAPIENDPOINT = null;
        this._visitables.get("iBMCLOUDCISAPIENDPOINT").remove(this.iBMCLOUDCISAPIENDPOINT);
    }
    return (A) this;
  }
  
  public A withIBMCLOUDCOSCONFIGENDPOINT(EndpointsVisibility iBMCLOUDCOSCONFIGENDPOINT) {
    this._visitables.remove("iBMCLOUDCOSCONFIGENDPOINT");
    if (iBMCLOUDCOSCONFIGENDPOINT != null) {
        this.iBMCLOUDCOSCONFIGENDPOINT = new EndpointsVisibilityBuilder(iBMCLOUDCOSCONFIGENDPOINT);
        this._visitables.get("iBMCLOUDCOSCONFIGENDPOINT").add(this.iBMCLOUDCOSCONFIGENDPOINT);
    } else {
        this.iBMCLOUDCOSCONFIGENDPOINT = null;
        this._visitables.get("iBMCLOUDCOSCONFIGENDPOINT").remove(this.iBMCLOUDCOSCONFIGENDPOINT);
    }
    return (A) this;
  }
  
  public A withIBMCLOUDCOSENDPOINT(EndpointsVisibility iBMCLOUDCOSENDPOINT) {
    this._visitables.remove("iBMCLOUDCOSENDPOINT");
    if (iBMCLOUDCOSENDPOINT != null) {
        this.iBMCLOUDCOSENDPOINT = new EndpointsVisibilityBuilder(iBMCLOUDCOSENDPOINT);
        this._visitables.get("iBMCLOUDCOSENDPOINT").add(this.iBMCLOUDCOSENDPOINT);
    } else {
        this.iBMCLOUDCOSENDPOINT = null;
        this._visitables.get("iBMCLOUDCOSENDPOINT").remove(this.iBMCLOUDCOSENDPOINT);
    }
    return (A) this;
  }
  
  public A withIBMCLOUDGSAPIENDPOINT(EndpointsVisibility iBMCLOUDGSAPIENDPOINT) {
    this._visitables.remove("iBMCLOUDGSAPIENDPOINT");
    if (iBMCLOUDGSAPIENDPOINT != null) {
        this.iBMCLOUDGSAPIENDPOINT = new EndpointsVisibilityBuilder(iBMCLOUDGSAPIENDPOINT);
        this._visitables.get("iBMCLOUDGSAPIENDPOINT").add(this.iBMCLOUDGSAPIENDPOINT);
    } else {
        this.iBMCLOUDGSAPIENDPOINT = null;
        this._visitables.get("iBMCLOUDGSAPIENDPOINT").remove(this.iBMCLOUDGSAPIENDPOINT);
    }
    return (A) this;
  }
  
  public A withIBMCLOUDGTAPIENDPOINT(EndpointsVisibility iBMCLOUDGTAPIENDPOINT) {
    this._visitables.remove("iBMCLOUDGTAPIENDPOINT");
    if (iBMCLOUDGTAPIENDPOINT != null) {
        this.iBMCLOUDGTAPIENDPOINT = new EndpointsVisibilityBuilder(iBMCLOUDGTAPIENDPOINT);
        this._visitables.get("iBMCLOUDGTAPIENDPOINT").add(this.iBMCLOUDGTAPIENDPOINT);
    } else {
        this.iBMCLOUDGTAPIENDPOINT = null;
        this._visitables.get("iBMCLOUDGTAPIENDPOINT").remove(this.iBMCLOUDGTAPIENDPOINT);
    }
    return (A) this;
  }
  
  public A withIBMCLOUDHPCSAPIENDPOINT(EndpointsVisibility iBMCLOUDHPCSAPIENDPOINT) {
    this._visitables.remove("iBMCLOUDHPCSAPIENDPOINT");
    if (iBMCLOUDHPCSAPIENDPOINT != null) {
        this.iBMCLOUDHPCSAPIENDPOINT = new EndpointsVisibilityBuilder(iBMCLOUDHPCSAPIENDPOINT);
        this._visitables.get("iBMCLOUDHPCSAPIENDPOINT").add(this.iBMCLOUDHPCSAPIENDPOINT);
    } else {
        this.iBMCLOUDHPCSAPIENDPOINT = null;
        this._visitables.get("iBMCLOUDHPCSAPIENDPOINT").remove(this.iBMCLOUDHPCSAPIENDPOINT);
    }
    return (A) this;
  }
  
  public A withIBMCLOUDIAMAPIENDPOINT(EndpointsVisibility iBMCLOUDIAMAPIENDPOINT) {
    this._visitables.remove("iBMCLOUDIAMAPIENDPOINT");
    if (iBMCLOUDIAMAPIENDPOINT != null) {
        this.iBMCLOUDIAMAPIENDPOINT = new EndpointsVisibilityBuilder(iBMCLOUDIAMAPIENDPOINT);
        this._visitables.get("iBMCLOUDIAMAPIENDPOINT").add(this.iBMCLOUDIAMAPIENDPOINT);
    } else {
        this.iBMCLOUDIAMAPIENDPOINT = null;
        this._visitables.get("iBMCLOUDIAMAPIENDPOINT").remove(this.iBMCLOUDIAMAPIENDPOINT);
    }
    return (A) this;
  }
  
  public A withIBMCLOUDISNGAPIENDPOINT(EndpointsVisibility iBMCLOUDISNGAPIENDPOINT) {
    this._visitables.remove("iBMCLOUDISNGAPIENDPOINT");
    if (iBMCLOUDISNGAPIENDPOINT != null) {
        this.iBMCLOUDISNGAPIENDPOINT = new EndpointsVisibilityBuilder(iBMCLOUDISNGAPIENDPOINT);
        this._visitables.get("iBMCLOUDISNGAPIENDPOINT").add(this.iBMCLOUDISNGAPIENDPOINT);
    } else {
        this.iBMCLOUDISNGAPIENDPOINT = null;
        this._visitables.get("iBMCLOUDISNGAPIENDPOINT").remove(this.iBMCLOUDISNGAPIENDPOINT);
    }
    return (A) this;
  }
  
  public A withIBMCLOUDKPAPIENDPOINT(EndpointsVisibility iBMCLOUDKPAPIENDPOINT) {
    this._visitables.remove("iBMCLOUDKPAPIENDPOINT");
    if (iBMCLOUDKPAPIENDPOINT != null) {
        this.iBMCLOUDKPAPIENDPOINT = new EndpointsVisibilityBuilder(iBMCLOUDKPAPIENDPOINT);
        this._visitables.get("iBMCLOUDKPAPIENDPOINT").add(this.iBMCLOUDKPAPIENDPOINT);
    } else {
        this.iBMCLOUDKPAPIENDPOINT = null;
        this._visitables.get("iBMCLOUDKPAPIENDPOINT").remove(this.iBMCLOUDKPAPIENDPOINT);
    }
    return (A) this;
  }
  
  public A withIBMCLOUDPRIVATEDNSAPIENDPOINT(EndpointsVisibility iBMCLOUDPRIVATEDNSAPIENDPOINT) {
    this._visitables.remove("iBMCLOUDPRIVATEDNSAPIENDPOINT");
    if (iBMCLOUDPRIVATEDNSAPIENDPOINT != null) {
        this.iBMCLOUDPRIVATEDNSAPIENDPOINT = new EndpointsVisibilityBuilder(iBMCLOUDPRIVATEDNSAPIENDPOINT);
        this._visitables.get("iBMCLOUDPRIVATEDNSAPIENDPOINT").add(this.iBMCLOUDPRIVATEDNSAPIENDPOINT);
    } else {
        this.iBMCLOUDPRIVATEDNSAPIENDPOINT = null;
        this._visitables.get("iBMCLOUDPRIVATEDNSAPIENDPOINT").remove(this.iBMCLOUDPRIVATEDNSAPIENDPOINT);
    }
    return (A) this;
  }
  
  public A withIBMCLOUDRESOURCECATALOGAPIENDPOINT(EndpointsVisibility iBMCLOUDRESOURCECATALOGAPIENDPOINT) {
    this._visitables.remove("iBMCLOUDRESOURCECATALOGAPIENDPOINT");
    if (iBMCLOUDRESOURCECATALOGAPIENDPOINT != null) {
        this.iBMCLOUDRESOURCECATALOGAPIENDPOINT = new EndpointsVisibilityBuilder(iBMCLOUDRESOURCECATALOGAPIENDPOINT);
        this._visitables.get("iBMCLOUDRESOURCECATALOGAPIENDPOINT").add(this.iBMCLOUDRESOURCECATALOGAPIENDPOINT);
    } else {
        this.iBMCLOUDRESOURCECATALOGAPIENDPOINT = null;
        this._visitables.get("iBMCLOUDRESOURCECATALOGAPIENDPOINT").remove(this.iBMCLOUDRESOURCECATALOGAPIENDPOINT);
    }
    return (A) this;
  }
  
  public A withIBMCLOUDRESOURCECONTROLLERAPIENDPOINT(EndpointsVisibility iBMCLOUDRESOURCECONTROLLERAPIENDPOINT) {
    this._visitables.remove("iBMCLOUDRESOURCECONTROLLERAPIENDPOINT");
    if (iBMCLOUDRESOURCECONTROLLERAPIENDPOINT != null) {
        this.iBMCLOUDRESOURCECONTROLLERAPIENDPOINT = new EndpointsVisibilityBuilder(iBMCLOUDRESOURCECONTROLLERAPIENDPOINT);
        this._visitables.get("iBMCLOUDRESOURCECONTROLLERAPIENDPOINT").add(this.iBMCLOUDRESOURCECONTROLLERAPIENDPOINT);
    } else {
        this.iBMCLOUDRESOURCECONTROLLERAPIENDPOINT = null;
        this._visitables.get("iBMCLOUDRESOURCECONTROLLERAPIENDPOINT").remove(this.iBMCLOUDRESOURCECONTROLLERAPIENDPOINT);
    }
    return (A) this;
  }
  
  public A withIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT(EndpointsVisibility iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT) {
    this._visitables.remove("iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT");
    if (iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT != null) {
        this.iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT = new EndpointsVisibilityBuilder(iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT);
        this._visitables.get("iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT").add(this.iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT);
    } else {
        this.iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT = null;
        this._visitables.get("iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT").remove(this.iBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT);
    }
    return (A) this;
  }
  
  public IBMCLOUDCISAPIENDPOINTNested<A> withNewIBMCLOUDCISAPIENDPOINT() {
    return new IBMCLOUDCISAPIENDPOINTNested(null);
  }
  
  public IBMCLOUDCISAPIENDPOINTNested<A> withNewIBMCLOUDCISAPIENDPOINTLike(EndpointsVisibility item) {
    return new IBMCLOUDCISAPIENDPOINTNested(item);
  }
  
  public IBMCLOUDCOSCONFIGENDPOINTNested<A> withNewIBMCLOUDCOSCONFIGENDPOINT() {
    return new IBMCLOUDCOSCONFIGENDPOINTNested(null);
  }
  
  public IBMCLOUDCOSCONFIGENDPOINTNested<A> withNewIBMCLOUDCOSCONFIGENDPOINTLike(EndpointsVisibility item) {
    return new IBMCLOUDCOSCONFIGENDPOINTNested(item);
  }
  
  public IBMCLOUDCOSENDPOINTNested<A> withNewIBMCLOUDCOSENDPOINT() {
    return new IBMCLOUDCOSENDPOINTNested(null);
  }
  
  public IBMCLOUDCOSENDPOINTNested<A> withNewIBMCLOUDCOSENDPOINTLike(EndpointsVisibility item) {
    return new IBMCLOUDCOSENDPOINTNested(item);
  }
  
  public IBMCLOUDGSAPIENDPOINTNested<A> withNewIBMCLOUDGSAPIENDPOINT() {
    return new IBMCLOUDGSAPIENDPOINTNested(null);
  }
  
  public IBMCLOUDGSAPIENDPOINTNested<A> withNewIBMCLOUDGSAPIENDPOINTLike(EndpointsVisibility item) {
    return new IBMCLOUDGSAPIENDPOINTNested(item);
  }
  
  public IBMCLOUDGTAPIENDPOINTNested<A> withNewIBMCLOUDGTAPIENDPOINT() {
    return new IBMCLOUDGTAPIENDPOINTNested(null);
  }
  
  public IBMCLOUDGTAPIENDPOINTNested<A> withNewIBMCLOUDGTAPIENDPOINTLike(EndpointsVisibility item) {
    return new IBMCLOUDGTAPIENDPOINTNested(item);
  }
  
  public IBMCLOUDHPCSAPIENDPOINTNested<A> withNewIBMCLOUDHPCSAPIENDPOINT() {
    return new IBMCLOUDHPCSAPIENDPOINTNested(null);
  }
  
  public IBMCLOUDHPCSAPIENDPOINTNested<A> withNewIBMCLOUDHPCSAPIENDPOINTLike(EndpointsVisibility item) {
    return new IBMCLOUDHPCSAPIENDPOINTNested(item);
  }
  
  public IBMCLOUDIAMAPIENDPOINTNested<A> withNewIBMCLOUDIAMAPIENDPOINT() {
    return new IBMCLOUDIAMAPIENDPOINTNested(null);
  }
  
  public IBMCLOUDIAMAPIENDPOINTNested<A> withNewIBMCLOUDIAMAPIENDPOINTLike(EndpointsVisibility item) {
    return new IBMCLOUDIAMAPIENDPOINTNested(item);
  }
  
  public IBMCLOUDISNGAPIENDPOINTNested<A> withNewIBMCLOUDISNGAPIENDPOINT() {
    return new IBMCLOUDISNGAPIENDPOINTNested(null);
  }
  
  public IBMCLOUDISNGAPIENDPOINTNested<A> withNewIBMCLOUDISNGAPIENDPOINTLike(EndpointsVisibility item) {
    return new IBMCLOUDISNGAPIENDPOINTNested(item);
  }
  
  public IBMCLOUDKPAPIENDPOINTNested<A> withNewIBMCLOUDKPAPIENDPOINT() {
    return new IBMCLOUDKPAPIENDPOINTNested(null);
  }
  
  public IBMCLOUDKPAPIENDPOINTNested<A> withNewIBMCLOUDKPAPIENDPOINTLike(EndpointsVisibility item) {
    return new IBMCLOUDKPAPIENDPOINTNested(item);
  }
  
  public IBMCLOUDPRIVATEDNSAPIENDPOINTNested<A> withNewIBMCLOUDPRIVATEDNSAPIENDPOINT() {
    return new IBMCLOUDPRIVATEDNSAPIENDPOINTNested(null);
  }
  
  public IBMCLOUDPRIVATEDNSAPIENDPOINTNested<A> withNewIBMCLOUDPRIVATEDNSAPIENDPOINTLike(EndpointsVisibility item) {
    return new IBMCLOUDPRIVATEDNSAPIENDPOINTNested(item);
  }
  
  public IBMCLOUDRESOURCECATALOGAPIENDPOINTNested<A> withNewIBMCLOUDRESOURCECATALOGAPIENDPOINT() {
    return new IBMCLOUDRESOURCECATALOGAPIENDPOINTNested(null);
  }
  
  public IBMCLOUDRESOURCECATALOGAPIENDPOINTNested<A> withNewIBMCLOUDRESOURCECATALOGAPIENDPOINTLike(EndpointsVisibility item) {
    return new IBMCLOUDRESOURCECATALOGAPIENDPOINTNested(item);
  }
  
  public IBMCLOUDRESOURCECONTROLLERAPIENDPOINTNested<A> withNewIBMCLOUDRESOURCECONTROLLERAPIENDPOINT() {
    return new IBMCLOUDRESOURCECONTROLLERAPIENDPOINTNested(null);
  }
  
  public IBMCLOUDRESOURCECONTROLLERAPIENDPOINTNested<A> withNewIBMCLOUDRESOURCECONTROLLERAPIENDPOINTLike(EndpointsVisibility item) {
    return new IBMCLOUDRESOURCECONTROLLERAPIENDPOINTNested(item);
  }
  
  public IBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTNested<A> withNewIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT() {
    return new IBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTNested(null);
  }
  
  public IBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTNested<A> withNewIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTLike(EndpointsVisibility item) {
    return new IBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTNested(item);
  }
  public class IBMCLOUDCISAPIENDPOINTNested<N> extends EndpointsVisibilityFluent<IBMCLOUDCISAPIENDPOINTNested<N>> implements Nested<N>{
  
    EndpointsVisibilityBuilder builder;
  
    IBMCLOUDCISAPIENDPOINTNested(EndpointsVisibility item) {
      this.builder = new EndpointsVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsJSONFluent.this.withIBMCLOUDCISAPIENDPOINT(builder.build());
    }
    
    public N endIBMCLOUDCISAPIENDPOINT() {
      return and();
    }
    
  }
  public class IBMCLOUDCOSCONFIGENDPOINTNested<N> extends EndpointsVisibilityFluent<IBMCLOUDCOSCONFIGENDPOINTNested<N>> implements Nested<N>{
  
    EndpointsVisibilityBuilder builder;
  
    IBMCLOUDCOSCONFIGENDPOINTNested(EndpointsVisibility item) {
      this.builder = new EndpointsVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsJSONFluent.this.withIBMCLOUDCOSCONFIGENDPOINT(builder.build());
    }
    
    public N endIBMCLOUDCOSCONFIGENDPOINT() {
      return and();
    }
    
  }
  public class IBMCLOUDCOSENDPOINTNested<N> extends EndpointsVisibilityFluent<IBMCLOUDCOSENDPOINTNested<N>> implements Nested<N>{
  
    EndpointsVisibilityBuilder builder;
  
    IBMCLOUDCOSENDPOINTNested(EndpointsVisibility item) {
      this.builder = new EndpointsVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsJSONFluent.this.withIBMCLOUDCOSENDPOINT(builder.build());
    }
    
    public N endIBMCLOUDCOSENDPOINT() {
      return and();
    }
    
  }
  public class IBMCLOUDGSAPIENDPOINTNested<N> extends EndpointsVisibilityFluent<IBMCLOUDGSAPIENDPOINTNested<N>> implements Nested<N>{
  
    EndpointsVisibilityBuilder builder;
  
    IBMCLOUDGSAPIENDPOINTNested(EndpointsVisibility item) {
      this.builder = new EndpointsVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsJSONFluent.this.withIBMCLOUDGSAPIENDPOINT(builder.build());
    }
    
    public N endIBMCLOUDGSAPIENDPOINT() {
      return and();
    }
    
  }
  public class IBMCLOUDGTAPIENDPOINTNested<N> extends EndpointsVisibilityFluent<IBMCLOUDGTAPIENDPOINTNested<N>> implements Nested<N>{
  
    EndpointsVisibilityBuilder builder;
  
    IBMCLOUDGTAPIENDPOINTNested(EndpointsVisibility item) {
      this.builder = new EndpointsVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsJSONFluent.this.withIBMCLOUDGTAPIENDPOINT(builder.build());
    }
    
    public N endIBMCLOUDGTAPIENDPOINT() {
      return and();
    }
    
  }
  public class IBMCLOUDHPCSAPIENDPOINTNested<N> extends EndpointsVisibilityFluent<IBMCLOUDHPCSAPIENDPOINTNested<N>> implements Nested<N>{
  
    EndpointsVisibilityBuilder builder;
  
    IBMCLOUDHPCSAPIENDPOINTNested(EndpointsVisibility item) {
      this.builder = new EndpointsVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsJSONFluent.this.withIBMCLOUDHPCSAPIENDPOINT(builder.build());
    }
    
    public N endIBMCLOUDHPCSAPIENDPOINT() {
      return and();
    }
    
  }
  public class IBMCLOUDIAMAPIENDPOINTNested<N> extends EndpointsVisibilityFluent<IBMCLOUDIAMAPIENDPOINTNested<N>> implements Nested<N>{
  
    EndpointsVisibilityBuilder builder;
  
    IBMCLOUDIAMAPIENDPOINTNested(EndpointsVisibility item) {
      this.builder = new EndpointsVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsJSONFluent.this.withIBMCLOUDIAMAPIENDPOINT(builder.build());
    }
    
    public N endIBMCLOUDIAMAPIENDPOINT() {
      return and();
    }
    
  }
  public class IBMCLOUDISNGAPIENDPOINTNested<N> extends EndpointsVisibilityFluent<IBMCLOUDISNGAPIENDPOINTNested<N>> implements Nested<N>{
  
    EndpointsVisibilityBuilder builder;
  
    IBMCLOUDISNGAPIENDPOINTNested(EndpointsVisibility item) {
      this.builder = new EndpointsVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsJSONFluent.this.withIBMCLOUDISNGAPIENDPOINT(builder.build());
    }
    
    public N endIBMCLOUDISNGAPIENDPOINT() {
      return and();
    }
    
  }
  public class IBMCLOUDKPAPIENDPOINTNested<N> extends EndpointsVisibilityFluent<IBMCLOUDKPAPIENDPOINTNested<N>> implements Nested<N>{
  
    EndpointsVisibilityBuilder builder;
  
    IBMCLOUDKPAPIENDPOINTNested(EndpointsVisibility item) {
      this.builder = new EndpointsVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsJSONFluent.this.withIBMCLOUDKPAPIENDPOINT(builder.build());
    }
    
    public N endIBMCLOUDKPAPIENDPOINT() {
      return and();
    }
    
  }
  public class IBMCLOUDPRIVATEDNSAPIENDPOINTNested<N> extends EndpointsVisibilityFluent<IBMCLOUDPRIVATEDNSAPIENDPOINTNested<N>> implements Nested<N>{
  
    EndpointsVisibilityBuilder builder;
  
    IBMCLOUDPRIVATEDNSAPIENDPOINTNested(EndpointsVisibility item) {
      this.builder = new EndpointsVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsJSONFluent.this.withIBMCLOUDPRIVATEDNSAPIENDPOINT(builder.build());
    }
    
    public N endIBMCLOUDPRIVATEDNSAPIENDPOINT() {
      return and();
    }
    
  }
  public class IBMCLOUDRESOURCECATALOGAPIENDPOINTNested<N> extends EndpointsVisibilityFluent<IBMCLOUDRESOURCECATALOGAPIENDPOINTNested<N>> implements Nested<N>{
  
    EndpointsVisibilityBuilder builder;
  
    IBMCLOUDRESOURCECATALOGAPIENDPOINTNested(EndpointsVisibility item) {
      this.builder = new EndpointsVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsJSONFluent.this.withIBMCLOUDRESOURCECATALOGAPIENDPOINT(builder.build());
    }
    
    public N endIBMCLOUDRESOURCECATALOGAPIENDPOINT() {
      return and();
    }
    
  }
  public class IBMCLOUDRESOURCECONTROLLERAPIENDPOINTNested<N> extends EndpointsVisibilityFluent<IBMCLOUDRESOURCECONTROLLERAPIENDPOINTNested<N>> implements Nested<N>{
  
    EndpointsVisibilityBuilder builder;
  
    IBMCLOUDRESOURCECONTROLLERAPIENDPOINTNested(EndpointsVisibility item) {
      this.builder = new EndpointsVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsJSONFluent.this.withIBMCLOUDRESOURCECONTROLLERAPIENDPOINT(builder.build());
    }
    
    public N endIBMCLOUDRESOURCECONTROLLERAPIENDPOINT() {
      return and();
    }
    
  }
  public class IBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTNested<N> extends EndpointsVisibilityFluent<IBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTNested<N>> implements Nested<N>{
  
    EndpointsVisibilityBuilder builder;
  
    IBMCLOUDRESOURCEMANAGEMENTAPIENDPOINTNested(EndpointsVisibility item) {
      this.builder = new EndpointsVisibilityBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointsJSONFluent.this.withIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT(builder.build());
    }
    
    public N endIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT() {
      return and();
    }
    
  }
}