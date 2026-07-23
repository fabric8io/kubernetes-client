package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointsJSONBuilder extends EndpointsJSONFluent<EndpointsJSONBuilder> implements VisitableBuilder<EndpointsJSON,EndpointsJSONBuilder>{

  EndpointsJSONFluent<?> fluent;

  public EndpointsJSONBuilder() {
    this(new EndpointsJSON());
  }
  
  public EndpointsJSONBuilder(EndpointsJSONFluent<?> fluent) {
    this(fluent, new EndpointsJSON());
  }
  
  public EndpointsJSONBuilder(EndpointsJSON instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointsJSONBuilder(EndpointsJSONFluent<?> fluent,EndpointsJSON instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EndpointsJSON build() {
    EndpointsJSON buildable = new EndpointsJSON(fluent.buildIBMCLOUDCISAPIENDPOINT(), fluent.buildIBMCLOUDCOSCONFIGENDPOINT(), fluent.buildIBMCLOUDCOSENDPOINT(), fluent.buildIBMCLOUDGSAPIENDPOINT(), fluent.buildIBMCLOUDGTAPIENDPOINT(), fluent.buildIBMCLOUDHPCSAPIENDPOINT(), fluent.buildIBMCLOUDIAMAPIENDPOINT(), fluent.buildIBMCLOUDISNGAPIENDPOINT(), fluent.buildIBMCLOUDKPAPIENDPOINT(), fluent.buildIBMCLOUDPRIVATEDNSAPIENDPOINT(), fluent.buildIBMCLOUDRESOURCECATALOGAPIENDPOINT(), fluent.buildIBMCLOUDRESOURCECONTROLLERAPIENDPOINT(), fluent.buildIBMCLOUDRESOURCEMANAGEMENTAPIENDPOINT());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}