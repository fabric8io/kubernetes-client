package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class FailureDomainsFluent<A extends io.fabric8.openshift.api.model.machine.v1.FailureDomainsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<AWSFailureDomainBuilder> aws = new ArrayList<AWSFailureDomainBuilder>();
  private ArrayList<AzureFailureDomainBuilder> azure = new ArrayList<AzureFailureDomainBuilder>();
  private ArrayList<GCPFailureDomainBuilder> gcp = new ArrayList<GCPFailureDomainBuilder>();
  private ArrayList<NutanixFailureDomainReferenceBuilder> nutanix = new ArrayList<NutanixFailureDomainReferenceBuilder>();
  private ArrayList<OpenStackFailureDomainBuilder> openstack = new ArrayList<OpenStackFailureDomainBuilder>();
  private String platform;
  private ArrayList<VSphereFailureDomainBuilder> vsphere = new ArrayList<VSphereFailureDomainBuilder>();

  public FailureDomainsFluent() {
  }
  
  public FailureDomainsFluent(FailureDomains instance) {
    this.copyInstance(instance);
  }

  public A addAllToAws(Collection<AWSFailureDomain> items) {
    if (this.aws == null) {
      this.aws = new ArrayList();
    }
    for (AWSFailureDomain item : items) {
        AWSFailureDomainBuilder builder = new AWSFailureDomainBuilder(item);
        _visitables.get("aws").add(builder);
        this.aws.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToAzure(Collection<AzureFailureDomain> items) {
    if (this.azure == null) {
      this.azure = new ArrayList();
    }
    for (AzureFailureDomain item : items) {
        AzureFailureDomainBuilder builder = new AzureFailureDomainBuilder(item);
        _visitables.get("azure").add(builder);
        this.azure.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToGcp(Collection<GCPFailureDomain> items) {
    if (this.gcp == null) {
      this.gcp = new ArrayList();
    }
    for (GCPFailureDomain item : items) {
        GCPFailureDomainBuilder builder = new GCPFailureDomainBuilder(item);
        _visitables.get("gcp").add(builder);
        this.gcp.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToNutanix(Collection<NutanixFailureDomainReference> items) {
    if (this.nutanix == null) {
      this.nutanix = new ArrayList();
    }
    for (NutanixFailureDomainReference item : items) {
        NutanixFailureDomainReferenceBuilder builder = new NutanixFailureDomainReferenceBuilder(item);
        _visitables.get("nutanix").add(builder);
        this.nutanix.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToOpenstack(Collection<OpenStackFailureDomain> items) {
    if (this.openstack == null) {
      this.openstack = new ArrayList();
    }
    for (OpenStackFailureDomain item : items) {
        OpenStackFailureDomainBuilder builder = new OpenStackFailureDomainBuilder(item);
        _visitables.get("openstack").add(builder);
        this.openstack.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVsphere(Collection<VSphereFailureDomain> items) {
    if (this.vsphere == null) {
      this.vsphere = new ArrayList();
    }
    for (VSphereFailureDomain item : items) {
        VSphereFailureDomainBuilder builder = new VSphereFailureDomainBuilder(item);
        _visitables.get("vsphere").add(builder);
        this.vsphere.add(builder);
    }
    return (A) this;
  }
  
  public AwsNested<A> addNewAw() {
    return new AwsNested(-1, null);
  }
  
  public AwsNested<A> addNewAwLike(AWSFailureDomain item) {
    return new AwsNested(-1, item);
  }
  
  public AzureNested<A> addNewAzure() {
    return new AzureNested(-1, null);
  }
  
  public A addNewAzure(String subnet,String zone) {
    return (A) this.addToAzure(new AzureFailureDomain(subnet, zone));
  }
  
  public AzureNested<A> addNewAzureLike(AzureFailureDomain item) {
    return new AzureNested(-1, item);
  }
  
  public GcpNested<A> addNewGcp() {
    return new GcpNested(-1, null);
  }
  
  public A addNewGcp(String zone) {
    return (A) this.addToGcp(new GCPFailureDomain(zone));
  }
  
  public GcpNested<A> addNewGcpLike(GCPFailureDomain item) {
    return new GcpNested(-1, item);
  }
  
  public NutanixNested<A> addNewNutanix() {
    return new NutanixNested(-1, null);
  }
  
  public A addNewNutanix(String name) {
    return (A) this.addToNutanix(new NutanixFailureDomainReference(name));
  }
  
  public NutanixNested<A> addNewNutanixLike(NutanixFailureDomainReference item) {
    return new NutanixNested(-1, item);
  }
  
  public OpenstackNested<A> addNewOpenstack() {
    return new OpenstackNested(-1, null);
  }
  
  public OpenstackNested<A> addNewOpenstackLike(OpenStackFailureDomain item) {
    return new OpenstackNested(-1, item);
  }
  
  public VsphereNested<A> addNewVsphere() {
    return new VsphereNested(-1, null);
  }
  
  public A addNewVsphere(String name) {
    return (A) this.addToVsphere(new VSphereFailureDomain(name));
  }
  
  public VsphereNested<A> addNewVsphereLike(VSphereFailureDomain item) {
    return new VsphereNested(-1, item);
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
  
  public A addToAws(AWSFailureDomain... items) {
    if (this.aws == null) {
      this.aws = new ArrayList();
    }
    for (AWSFailureDomain item : items) {
        AWSFailureDomainBuilder builder = new AWSFailureDomainBuilder(item);
        _visitables.get("aws").add(builder);
        this.aws.add(builder);
    }
    return (A) this;
  }
  
  public A addToAws(int index,AWSFailureDomain item) {
    if (this.aws == null) {
      this.aws = new ArrayList();
    }
    AWSFailureDomainBuilder builder = new AWSFailureDomainBuilder(item);
    if (index < 0 || index >= aws.size()) {
        _visitables.get("aws").add(builder);
        aws.add(builder);
    } else {
        _visitables.get("aws").add(builder);
        aws.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToAzure(AzureFailureDomain... items) {
    if (this.azure == null) {
      this.azure = new ArrayList();
    }
    for (AzureFailureDomain item : items) {
        AzureFailureDomainBuilder builder = new AzureFailureDomainBuilder(item);
        _visitables.get("azure").add(builder);
        this.azure.add(builder);
    }
    return (A) this;
  }
  
  public A addToAzure(int index,AzureFailureDomain item) {
    if (this.azure == null) {
      this.azure = new ArrayList();
    }
    AzureFailureDomainBuilder builder = new AzureFailureDomainBuilder(item);
    if (index < 0 || index >= azure.size()) {
        _visitables.get("azure").add(builder);
        azure.add(builder);
    } else {
        _visitables.get("azure").add(builder);
        azure.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToGcp(GCPFailureDomain... items) {
    if (this.gcp == null) {
      this.gcp = new ArrayList();
    }
    for (GCPFailureDomain item : items) {
        GCPFailureDomainBuilder builder = new GCPFailureDomainBuilder(item);
        _visitables.get("gcp").add(builder);
        this.gcp.add(builder);
    }
    return (A) this;
  }
  
  public A addToGcp(int index,GCPFailureDomain item) {
    if (this.gcp == null) {
      this.gcp = new ArrayList();
    }
    GCPFailureDomainBuilder builder = new GCPFailureDomainBuilder(item);
    if (index < 0 || index >= gcp.size()) {
        _visitables.get("gcp").add(builder);
        gcp.add(builder);
    } else {
        _visitables.get("gcp").add(builder);
        gcp.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToNutanix(NutanixFailureDomainReference... items) {
    if (this.nutanix == null) {
      this.nutanix = new ArrayList();
    }
    for (NutanixFailureDomainReference item : items) {
        NutanixFailureDomainReferenceBuilder builder = new NutanixFailureDomainReferenceBuilder(item);
        _visitables.get("nutanix").add(builder);
        this.nutanix.add(builder);
    }
    return (A) this;
  }
  
  public A addToNutanix(int index,NutanixFailureDomainReference item) {
    if (this.nutanix == null) {
      this.nutanix = new ArrayList();
    }
    NutanixFailureDomainReferenceBuilder builder = new NutanixFailureDomainReferenceBuilder(item);
    if (index < 0 || index >= nutanix.size()) {
        _visitables.get("nutanix").add(builder);
        nutanix.add(builder);
    } else {
        _visitables.get("nutanix").add(builder);
        nutanix.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToOpenstack(OpenStackFailureDomain... items) {
    if (this.openstack == null) {
      this.openstack = new ArrayList();
    }
    for (OpenStackFailureDomain item : items) {
        OpenStackFailureDomainBuilder builder = new OpenStackFailureDomainBuilder(item);
        _visitables.get("openstack").add(builder);
        this.openstack.add(builder);
    }
    return (A) this;
  }
  
  public A addToOpenstack(int index,OpenStackFailureDomain item) {
    if (this.openstack == null) {
      this.openstack = new ArrayList();
    }
    OpenStackFailureDomainBuilder builder = new OpenStackFailureDomainBuilder(item);
    if (index < 0 || index >= openstack.size()) {
        _visitables.get("openstack").add(builder);
        openstack.add(builder);
    } else {
        _visitables.get("openstack").add(builder);
        openstack.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVsphere(VSphereFailureDomain... items) {
    if (this.vsphere == null) {
      this.vsphere = new ArrayList();
    }
    for (VSphereFailureDomain item : items) {
        VSphereFailureDomainBuilder builder = new VSphereFailureDomainBuilder(item);
        _visitables.get("vsphere").add(builder);
        this.vsphere.add(builder);
    }
    return (A) this;
  }
  
  public A addToVsphere(int index,VSphereFailureDomain item) {
    if (this.vsphere == null) {
      this.vsphere = new ArrayList();
    }
    VSphereFailureDomainBuilder builder = new VSphereFailureDomainBuilder(item);
    if (index < 0 || index >= vsphere.size()) {
        _visitables.get("vsphere").add(builder);
        vsphere.add(builder);
    } else {
        _visitables.get("vsphere").add(builder);
        vsphere.add(index, builder);
    }
    return (A) this;
  }
  
  public AWSFailureDomain buildAw(int index) {
    return this.aws.get(index).build();
  }
  
  public List<AWSFailureDomain> buildAws() {
    return this.aws != null ? build(aws) : null;
  }
  
  public List<AzureFailureDomain> buildAzure() {
    return this.azure != null ? build(azure) : null;
  }
  
  public AzureFailureDomain buildAzure(int index) {
    return this.azure.get(index).build();
  }
  
  public AWSFailureDomain buildFirstAw() {
    return this.aws.get(0).build();
  }
  
  public AzureFailureDomain buildFirstAzure() {
    return this.azure.get(0).build();
  }
  
  public GCPFailureDomain buildFirstGcp() {
    return this.gcp.get(0).build();
  }
  
  public NutanixFailureDomainReference buildFirstNutanix() {
    return this.nutanix.get(0).build();
  }
  
  public OpenStackFailureDomain buildFirstOpenstack() {
    return this.openstack.get(0).build();
  }
  
  public VSphereFailureDomain buildFirstVsphere() {
    return this.vsphere.get(0).build();
  }
  
  public List<GCPFailureDomain> buildGcp() {
    return this.gcp != null ? build(gcp) : null;
  }
  
  public GCPFailureDomain buildGcp(int index) {
    return this.gcp.get(index).build();
  }
  
  public AWSFailureDomain buildLastAw() {
    return this.aws.get(aws.size() - 1).build();
  }
  
  public AzureFailureDomain buildLastAzure() {
    return this.azure.get(azure.size() - 1).build();
  }
  
  public GCPFailureDomain buildLastGcp() {
    return this.gcp.get(gcp.size() - 1).build();
  }
  
  public NutanixFailureDomainReference buildLastNutanix() {
    return this.nutanix.get(nutanix.size() - 1).build();
  }
  
  public OpenStackFailureDomain buildLastOpenstack() {
    return this.openstack.get(openstack.size() - 1).build();
  }
  
  public VSphereFailureDomain buildLastVsphere() {
    return this.vsphere.get(vsphere.size() - 1).build();
  }
  
  public AWSFailureDomain buildMatchingAw(Predicate<AWSFailureDomainBuilder> predicate) {
      for (AWSFailureDomainBuilder item : aws) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AzureFailureDomain buildMatchingAzure(Predicate<AzureFailureDomainBuilder> predicate) {
      for (AzureFailureDomainBuilder item : azure) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GCPFailureDomain buildMatchingGcp(Predicate<GCPFailureDomainBuilder> predicate) {
      for (GCPFailureDomainBuilder item : gcp) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NutanixFailureDomainReference buildMatchingNutanix(Predicate<NutanixFailureDomainReferenceBuilder> predicate) {
      for (NutanixFailureDomainReferenceBuilder item : nutanix) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OpenStackFailureDomain buildMatchingOpenstack(Predicate<OpenStackFailureDomainBuilder> predicate) {
      for (OpenStackFailureDomainBuilder item : openstack) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VSphereFailureDomain buildMatchingVsphere(Predicate<VSphereFailureDomainBuilder> predicate) {
      for (VSphereFailureDomainBuilder item : vsphere) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<NutanixFailureDomainReference> buildNutanix() {
    return this.nutanix != null ? build(nutanix) : null;
  }
  
  public NutanixFailureDomainReference buildNutanix(int index) {
    return this.nutanix.get(index).build();
  }
  
  public List<OpenStackFailureDomain> buildOpenstack() {
    return this.openstack != null ? build(openstack) : null;
  }
  
  public OpenStackFailureDomain buildOpenstack(int index) {
    return this.openstack.get(index).build();
  }
  
  public List<VSphereFailureDomain> buildVsphere() {
    return this.vsphere != null ? build(vsphere) : null;
  }
  
  public VSphereFailureDomain buildVsphere(int index) {
    return this.vsphere.get(index).build();
  }
  
  protected void copyInstance(FailureDomains instance) {
    instance = instance != null ? instance : new FailureDomains();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withAzure(instance.getAzure());
        this.withGcp(instance.getGcp());
        this.withNutanix(instance.getNutanix());
        this.withOpenstack(instance.getOpenstack());
        this.withPlatform(instance.getPlatform());
        this.withVsphere(instance.getVsphere());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsNested<A> editAw(int index) {
    if (aws.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "aws"));
    }
    return this.setNewAwLike(index, this.buildAw(index));
  }
  
  public AzureNested<A> editAzure(int index) {
    if (azure.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "azure"));
    }
    return this.setNewAzureLike(index, this.buildAzure(index));
  }
  
  public AwsNested<A> editFirstAw() {
    if (aws.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "aws"));
    }
    return this.setNewAwLike(0, this.buildAw(0));
  }
  
  public AzureNested<A> editFirstAzure() {
    if (azure.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "azure"));
    }
    return this.setNewAzureLike(0, this.buildAzure(0));
  }
  
  public GcpNested<A> editFirstGcp() {
    if (gcp.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "gcp"));
    }
    return this.setNewGcpLike(0, this.buildGcp(0));
  }
  
  public NutanixNested<A> editFirstNutanix() {
    if (nutanix.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "nutanix"));
    }
    return this.setNewNutanixLike(0, this.buildNutanix(0));
  }
  
  public OpenstackNested<A> editFirstOpenstack() {
    if (openstack.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "openstack"));
    }
    return this.setNewOpenstackLike(0, this.buildOpenstack(0));
  }
  
  public VsphereNested<A> editFirstVsphere() {
    if (vsphere.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "vsphere"));
    }
    return this.setNewVsphereLike(0, this.buildVsphere(0));
  }
  
  public GcpNested<A> editGcp(int index) {
    if (gcp.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "gcp"));
    }
    return this.setNewGcpLike(index, this.buildGcp(index));
  }
  
  public AwsNested<A> editLastAw() {
    int index = aws.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "aws"));
    }
    return this.setNewAwLike(index, this.buildAw(index));
  }
  
  public AzureNested<A> editLastAzure() {
    int index = azure.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "azure"));
    }
    return this.setNewAzureLike(index, this.buildAzure(index));
  }
  
  public GcpNested<A> editLastGcp() {
    int index = gcp.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "gcp"));
    }
    return this.setNewGcpLike(index, this.buildGcp(index));
  }
  
  public NutanixNested<A> editLastNutanix() {
    int index = nutanix.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "nutanix"));
    }
    return this.setNewNutanixLike(index, this.buildNutanix(index));
  }
  
  public OpenstackNested<A> editLastOpenstack() {
    int index = openstack.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "openstack"));
    }
    return this.setNewOpenstackLike(index, this.buildOpenstack(index));
  }
  
  public VsphereNested<A> editLastVsphere() {
    int index = vsphere.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "vsphere"));
    }
    return this.setNewVsphereLike(index, this.buildVsphere(index));
  }
  
  public AwsNested<A> editMatchingAw(Predicate<AWSFailureDomainBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < aws.size();i++) {
      if (predicate.test(aws.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "aws"));
    }
    return this.setNewAwLike(index, this.buildAw(index));
  }
  
  public AzureNested<A> editMatchingAzure(Predicate<AzureFailureDomainBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < azure.size();i++) {
      if (predicate.test(azure.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "azure"));
    }
    return this.setNewAzureLike(index, this.buildAzure(index));
  }
  
  public GcpNested<A> editMatchingGcp(Predicate<GCPFailureDomainBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < gcp.size();i++) {
      if (predicate.test(gcp.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "gcp"));
    }
    return this.setNewGcpLike(index, this.buildGcp(index));
  }
  
  public NutanixNested<A> editMatchingNutanix(Predicate<NutanixFailureDomainReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < nutanix.size();i++) {
      if (predicate.test(nutanix.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "nutanix"));
    }
    return this.setNewNutanixLike(index, this.buildNutanix(index));
  }
  
  public OpenstackNested<A> editMatchingOpenstack(Predicate<OpenStackFailureDomainBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < openstack.size();i++) {
      if (predicate.test(openstack.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "openstack"));
    }
    return this.setNewOpenstackLike(index, this.buildOpenstack(index));
  }
  
  public VsphereNested<A> editMatchingVsphere(Predicate<VSphereFailureDomainBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < vsphere.size();i++) {
      if (predicate.test(vsphere.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "vsphere"));
    }
    return this.setNewVsphereLike(index, this.buildVsphere(index));
  }
  
  public NutanixNested<A> editNutanix(int index) {
    if (nutanix.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "nutanix"));
    }
    return this.setNewNutanixLike(index, this.buildNutanix(index));
  }
  
  public OpenstackNested<A> editOpenstack(int index) {
    if (openstack.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "openstack"));
    }
    return this.setNewOpenstackLike(index, this.buildOpenstack(index));
  }
  
  public VsphereNested<A> editVsphere(int index) {
    if (vsphere.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "vsphere"));
    }
    return this.setNewVsphereLike(index, this.buildVsphere(index));
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
    FailureDomainsFluent that = (FailureDomainsFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(azure, that.azure))) {
      return false;
    }
    if (!(Objects.equals(gcp, that.gcp))) {
      return false;
    }
    if (!(Objects.equals(nutanix, that.nutanix))) {
      return false;
    }
    if (!(Objects.equals(openstack, that.openstack))) {
      return false;
    }
    if (!(Objects.equals(platform, that.platform))) {
      return false;
    }
    if (!(Objects.equals(vsphere, that.vsphere))) {
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
  
  public String getPlatform() {
    return this.platform;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAws() {
    return this.aws != null && !(this.aws.isEmpty());
  }
  
  public boolean hasAzure() {
    return this.azure != null && !(this.azure.isEmpty());
  }
  
  public boolean hasGcp() {
    return this.gcp != null && !(this.gcp.isEmpty());
  }
  
  public boolean hasMatchingAw(Predicate<AWSFailureDomainBuilder> predicate) {
      for (AWSFailureDomainBuilder item : aws) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingAzure(Predicate<AzureFailureDomainBuilder> predicate) {
      for (AzureFailureDomainBuilder item : azure) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGcp(Predicate<GCPFailureDomainBuilder> predicate) {
      for (GCPFailureDomainBuilder item : gcp) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNutanix(Predicate<NutanixFailureDomainReferenceBuilder> predicate) {
      for (NutanixFailureDomainReferenceBuilder item : nutanix) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingOpenstack(Predicate<OpenStackFailureDomainBuilder> predicate) {
      for (OpenStackFailureDomainBuilder item : openstack) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVsphere(Predicate<VSphereFailureDomainBuilder> predicate) {
      for (VSphereFailureDomainBuilder item : vsphere) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNutanix() {
    return this.nutanix != null && !(this.nutanix.isEmpty());
  }
  
  public boolean hasOpenstack() {
    return this.openstack != null && !(this.openstack.isEmpty());
  }
  
  public boolean hasPlatform() {
    return this.platform != null;
  }
  
  public boolean hasVsphere() {
    return this.vsphere != null && !(this.vsphere.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(aws, azure, gcp, nutanix, openstack, platform, vsphere, additionalProperties);
  }
  
  public A removeAllFromAws(Collection<AWSFailureDomain> items) {
    if (this.aws == null) {
      return (A) this;
    }
    for (AWSFailureDomain item : items) {
        AWSFailureDomainBuilder builder = new AWSFailureDomainBuilder(item);
        _visitables.get("aws").remove(builder);
        this.aws.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromAzure(Collection<AzureFailureDomain> items) {
    if (this.azure == null) {
      return (A) this;
    }
    for (AzureFailureDomain item : items) {
        AzureFailureDomainBuilder builder = new AzureFailureDomainBuilder(item);
        _visitables.get("azure").remove(builder);
        this.azure.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromGcp(Collection<GCPFailureDomain> items) {
    if (this.gcp == null) {
      return (A) this;
    }
    for (GCPFailureDomain item : items) {
        GCPFailureDomainBuilder builder = new GCPFailureDomainBuilder(item);
        _visitables.get("gcp").remove(builder);
        this.gcp.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromNutanix(Collection<NutanixFailureDomainReference> items) {
    if (this.nutanix == null) {
      return (A) this;
    }
    for (NutanixFailureDomainReference item : items) {
        NutanixFailureDomainReferenceBuilder builder = new NutanixFailureDomainReferenceBuilder(item);
        _visitables.get("nutanix").remove(builder);
        this.nutanix.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromOpenstack(Collection<OpenStackFailureDomain> items) {
    if (this.openstack == null) {
      return (A) this;
    }
    for (OpenStackFailureDomain item : items) {
        OpenStackFailureDomainBuilder builder = new OpenStackFailureDomainBuilder(item);
        _visitables.get("openstack").remove(builder);
        this.openstack.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVsphere(Collection<VSphereFailureDomain> items) {
    if (this.vsphere == null) {
      return (A) this;
    }
    for (VSphereFailureDomain item : items) {
        VSphereFailureDomainBuilder builder = new VSphereFailureDomainBuilder(item);
        _visitables.get("vsphere").remove(builder);
        this.vsphere.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromAws(AWSFailureDomain... items) {
    if (this.aws == null) {
      return (A) this;
    }
    for (AWSFailureDomain item : items) {
        AWSFailureDomainBuilder builder = new AWSFailureDomainBuilder(item);
        _visitables.get("aws").remove(builder);
        this.aws.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAzure(AzureFailureDomain... items) {
    if (this.azure == null) {
      return (A) this;
    }
    for (AzureFailureDomain item : items) {
        AzureFailureDomainBuilder builder = new AzureFailureDomainBuilder(item);
        _visitables.get("azure").remove(builder);
        this.azure.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromGcp(GCPFailureDomain... items) {
    if (this.gcp == null) {
      return (A) this;
    }
    for (GCPFailureDomain item : items) {
        GCPFailureDomainBuilder builder = new GCPFailureDomainBuilder(item);
        _visitables.get("gcp").remove(builder);
        this.gcp.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromNutanix(NutanixFailureDomainReference... items) {
    if (this.nutanix == null) {
      return (A) this;
    }
    for (NutanixFailureDomainReference item : items) {
        NutanixFailureDomainReferenceBuilder builder = new NutanixFailureDomainReferenceBuilder(item);
        _visitables.get("nutanix").remove(builder);
        this.nutanix.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromOpenstack(OpenStackFailureDomain... items) {
    if (this.openstack == null) {
      return (A) this;
    }
    for (OpenStackFailureDomain item : items) {
        OpenStackFailureDomainBuilder builder = new OpenStackFailureDomainBuilder(item);
        _visitables.get("openstack").remove(builder);
        this.openstack.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVsphere(VSphereFailureDomain... items) {
    if (this.vsphere == null) {
      return (A) this;
    }
    for (VSphereFailureDomain item : items) {
        VSphereFailureDomainBuilder builder = new VSphereFailureDomainBuilder(item);
        _visitables.get("vsphere").remove(builder);
        this.vsphere.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAws(Predicate<AWSFailureDomainBuilder> predicate) {
    if (aws == null) {
      return (A) this;
    }
    Iterator<AWSFailureDomainBuilder> each = aws.iterator();
    List visitables = _visitables.get("aws");
    while (each.hasNext()) {
        AWSFailureDomainBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromAzure(Predicate<AzureFailureDomainBuilder> predicate) {
    if (azure == null) {
      return (A) this;
    }
    Iterator<AzureFailureDomainBuilder> each = azure.iterator();
    List visitables = _visitables.get("azure");
    while (each.hasNext()) {
        AzureFailureDomainBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromGcp(Predicate<GCPFailureDomainBuilder> predicate) {
    if (gcp == null) {
      return (A) this;
    }
    Iterator<GCPFailureDomainBuilder> each = gcp.iterator();
    List visitables = _visitables.get("gcp");
    while (each.hasNext()) {
        GCPFailureDomainBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromNutanix(Predicate<NutanixFailureDomainReferenceBuilder> predicate) {
    if (nutanix == null) {
      return (A) this;
    }
    Iterator<NutanixFailureDomainReferenceBuilder> each = nutanix.iterator();
    List visitables = _visitables.get("nutanix");
    while (each.hasNext()) {
        NutanixFailureDomainReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromOpenstack(Predicate<OpenStackFailureDomainBuilder> predicate) {
    if (openstack == null) {
      return (A) this;
    }
    Iterator<OpenStackFailureDomainBuilder> each = openstack.iterator();
    List visitables = _visitables.get("openstack");
    while (each.hasNext()) {
        OpenStackFailureDomainBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVsphere(Predicate<VSphereFailureDomainBuilder> predicate) {
    if (vsphere == null) {
      return (A) this;
    }
    Iterator<VSphereFailureDomainBuilder> each = vsphere.iterator();
    List visitables = _visitables.get("vsphere");
    while (each.hasNext()) {
        VSphereFailureDomainBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AwsNested<A> setNewAwLike(int index,AWSFailureDomain item) {
    return new AwsNested(index, item);
  }
  
  public AzureNested<A> setNewAzureLike(int index,AzureFailureDomain item) {
    return new AzureNested(index, item);
  }
  
  public GcpNested<A> setNewGcpLike(int index,GCPFailureDomain item) {
    return new GcpNested(index, item);
  }
  
  public NutanixNested<A> setNewNutanixLike(int index,NutanixFailureDomainReference item) {
    return new NutanixNested(index, item);
  }
  
  public OpenstackNested<A> setNewOpenstackLike(int index,OpenStackFailureDomain item) {
    return new OpenstackNested(index, item);
  }
  
  public VsphereNested<A> setNewVsphereLike(int index,VSphereFailureDomain item) {
    return new VsphereNested(index, item);
  }
  
  public A setToAws(int index,AWSFailureDomain item) {
    if (this.aws == null) {
      this.aws = new ArrayList();
    }
    AWSFailureDomainBuilder builder = new AWSFailureDomainBuilder(item);
    if (index < 0 || index >= aws.size()) {
        _visitables.get("aws").add(builder);
        aws.add(builder);
    } else {
        _visitables.get("aws").add(builder);
        aws.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToAzure(int index,AzureFailureDomain item) {
    if (this.azure == null) {
      this.azure = new ArrayList();
    }
    AzureFailureDomainBuilder builder = new AzureFailureDomainBuilder(item);
    if (index < 0 || index >= azure.size()) {
        _visitables.get("azure").add(builder);
        azure.add(builder);
    } else {
        _visitables.get("azure").add(builder);
        azure.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToGcp(int index,GCPFailureDomain item) {
    if (this.gcp == null) {
      this.gcp = new ArrayList();
    }
    GCPFailureDomainBuilder builder = new GCPFailureDomainBuilder(item);
    if (index < 0 || index >= gcp.size()) {
        _visitables.get("gcp").add(builder);
        gcp.add(builder);
    } else {
        _visitables.get("gcp").add(builder);
        gcp.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToNutanix(int index,NutanixFailureDomainReference item) {
    if (this.nutanix == null) {
      this.nutanix = new ArrayList();
    }
    NutanixFailureDomainReferenceBuilder builder = new NutanixFailureDomainReferenceBuilder(item);
    if (index < 0 || index >= nutanix.size()) {
        _visitables.get("nutanix").add(builder);
        nutanix.add(builder);
    } else {
        _visitables.get("nutanix").add(builder);
        nutanix.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToOpenstack(int index,OpenStackFailureDomain item) {
    if (this.openstack == null) {
      this.openstack = new ArrayList();
    }
    OpenStackFailureDomainBuilder builder = new OpenStackFailureDomainBuilder(item);
    if (index < 0 || index >= openstack.size()) {
        _visitables.get("openstack").add(builder);
        openstack.add(builder);
    } else {
        _visitables.get("openstack").add(builder);
        openstack.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVsphere(int index,VSphereFailureDomain item) {
    if (this.vsphere == null) {
      this.vsphere = new ArrayList();
    }
    VSphereFailureDomainBuilder builder = new VSphereFailureDomainBuilder(item);
    if (index < 0 || index >= vsphere.size()) {
        _visitables.get("vsphere").add(builder);
        vsphere.add(builder);
    } else {
        _visitables.get("vsphere").add(builder);
        vsphere.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(aws == null) && !(aws.isEmpty())) {
        sb.append("aws:");
        sb.append(aws);
        sb.append(",");
    }
    if (!(azure == null) && !(azure.isEmpty())) {
        sb.append("azure:");
        sb.append(azure);
        sb.append(",");
    }
    if (!(gcp == null) && !(gcp.isEmpty())) {
        sb.append("gcp:");
        sb.append(gcp);
        sb.append(",");
    }
    if (!(nutanix == null) && !(nutanix.isEmpty())) {
        sb.append("nutanix:");
        sb.append(nutanix);
        sb.append(",");
    }
    if (!(openstack == null) && !(openstack.isEmpty())) {
        sb.append("openstack:");
        sb.append(openstack);
        sb.append(",");
    }
    if (!(platform == null)) {
        sb.append("platform:");
        sb.append(platform);
        sb.append(",");
    }
    if (!(vsphere == null) && !(vsphere.isEmpty())) {
        sb.append("vsphere:");
        sb.append(vsphere);
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
  
  public A withAws(List<AWSFailureDomain> aws) {
    if (this.aws != null) {
      this._visitables.get("aws").clear();
    }
    if (aws != null) {
        this.aws = new ArrayList();
        for (AWSFailureDomain item : aws) {
          this.addToAws(item);
        }
    } else {
      this.aws = null;
    }
    return (A) this;
  }
  
  public A withAws(AWSFailureDomain... aws) {
    if (this.aws != null) {
        this.aws.clear();
        _visitables.remove("aws");
    }
    if (aws != null) {
      for (AWSFailureDomain item : aws) {
        this.addToAws(item);
      }
    }
    return (A) this;
  }
  
  public A withAzure(List<AzureFailureDomain> azure) {
    if (this.azure != null) {
      this._visitables.get("azure").clear();
    }
    if (azure != null) {
        this.azure = new ArrayList();
        for (AzureFailureDomain item : azure) {
          this.addToAzure(item);
        }
    } else {
      this.azure = null;
    }
    return (A) this;
  }
  
  public A withAzure(AzureFailureDomain... azure) {
    if (this.azure != null) {
        this.azure.clear();
        _visitables.remove("azure");
    }
    if (azure != null) {
      for (AzureFailureDomain item : azure) {
        this.addToAzure(item);
      }
    }
    return (A) this;
  }
  
  public A withGcp(List<GCPFailureDomain> gcp) {
    if (this.gcp != null) {
      this._visitables.get("gcp").clear();
    }
    if (gcp != null) {
        this.gcp = new ArrayList();
        for (GCPFailureDomain item : gcp) {
          this.addToGcp(item);
        }
    } else {
      this.gcp = null;
    }
    return (A) this;
  }
  
  public A withGcp(GCPFailureDomain... gcp) {
    if (this.gcp != null) {
        this.gcp.clear();
        _visitables.remove("gcp");
    }
    if (gcp != null) {
      for (GCPFailureDomain item : gcp) {
        this.addToGcp(item);
      }
    }
    return (A) this;
  }
  
  public A withNutanix(List<NutanixFailureDomainReference> nutanix) {
    if (this.nutanix != null) {
      this._visitables.get("nutanix").clear();
    }
    if (nutanix != null) {
        this.nutanix = new ArrayList();
        for (NutanixFailureDomainReference item : nutanix) {
          this.addToNutanix(item);
        }
    } else {
      this.nutanix = null;
    }
    return (A) this;
  }
  
  public A withNutanix(NutanixFailureDomainReference... nutanix) {
    if (this.nutanix != null) {
        this.nutanix.clear();
        _visitables.remove("nutanix");
    }
    if (nutanix != null) {
      for (NutanixFailureDomainReference item : nutanix) {
        this.addToNutanix(item);
      }
    }
    return (A) this;
  }
  
  public A withOpenstack(List<OpenStackFailureDomain> openstack) {
    if (this.openstack != null) {
      this._visitables.get("openstack").clear();
    }
    if (openstack != null) {
        this.openstack = new ArrayList();
        for (OpenStackFailureDomain item : openstack) {
          this.addToOpenstack(item);
        }
    } else {
      this.openstack = null;
    }
    return (A) this;
  }
  
  public A withOpenstack(OpenStackFailureDomain... openstack) {
    if (this.openstack != null) {
        this.openstack.clear();
        _visitables.remove("openstack");
    }
    if (openstack != null) {
      for (OpenStackFailureDomain item : openstack) {
        this.addToOpenstack(item);
      }
    }
    return (A) this;
  }
  
  public A withPlatform(String platform) {
    this.platform = platform;
    return (A) this;
  }
  
  public A withVsphere(List<VSphereFailureDomain> vsphere) {
    if (this.vsphere != null) {
      this._visitables.get("vsphere").clear();
    }
    if (vsphere != null) {
        this.vsphere = new ArrayList();
        for (VSphereFailureDomain item : vsphere) {
          this.addToVsphere(item);
        }
    } else {
      this.vsphere = null;
    }
    return (A) this;
  }
  
  public A withVsphere(VSphereFailureDomain... vsphere) {
    if (this.vsphere != null) {
        this.vsphere.clear();
        _visitables.remove("vsphere");
    }
    if (vsphere != null) {
      for (VSphereFailureDomain item : vsphere) {
        this.addToVsphere(item);
      }
    }
    return (A) this;
  }
  public class AwsNested<N> extends AWSFailureDomainFluent<AwsNested<N>> implements Nested<N>{
  
    AWSFailureDomainBuilder builder;
    int index;
  
    AwsNested(int index,AWSFailureDomain item) {
      this.index = index;
      this.builder = new AWSFailureDomainBuilder(this, item);
    }
  
    public N and() {
      return (N) FailureDomainsFluent.this.setToAws(index, builder.build());
    }
    
    public N endAw() {
      return and();
    }
    
  }
  public class AzureNested<N> extends AzureFailureDomainFluent<AzureNested<N>> implements Nested<N>{
  
    AzureFailureDomainBuilder builder;
    int index;
  
    AzureNested(int index,AzureFailureDomain item) {
      this.index = index;
      this.builder = new AzureFailureDomainBuilder(this, item);
    }
  
    public N and() {
      return (N) FailureDomainsFluent.this.setToAzure(index, builder.build());
    }
    
    public N endAzure() {
      return and();
    }
    
  }
  public class GcpNested<N> extends GCPFailureDomainFluent<GcpNested<N>> implements Nested<N>{
  
    GCPFailureDomainBuilder builder;
    int index;
  
    GcpNested(int index,GCPFailureDomain item) {
      this.index = index;
      this.builder = new GCPFailureDomainBuilder(this, item);
    }
  
    public N and() {
      return (N) FailureDomainsFluent.this.setToGcp(index, builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
  public class NutanixNested<N> extends NutanixFailureDomainReferenceFluent<NutanixNested<N>> implements Nested<N>{
  
    NutanixFailureDomainReferenceBuilder builder;
    int index;
  
    NutanixNested(int index,NutanixFailureDomainReference item) {
      this.index = index;
      this.builder = new NutanixFailureDomainReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) FailureDomainsFluent.this.setToNutanix(index, builder.build());
    }
    
    public N endNutanix() {
      return and();
    }
    
  }
  public class OpenstackNested<N> extends OpenStackFailureDomainFluent<OpenstackNested<N>> implements Nested<N>{
  
    OpenStackFailureDomainBuilder builder;
    int index;
  
    OpenstackNested(int index,OpenStackFailureDomain item) {
      this.index = index;
      this.builder = new OpenStackFailureDomainBuilder(this, item);
    }
  
    public N and() {
      return (N) FailureDomainsFluent.this.setToOpenstack(index, builder.build());
    }
    
    public N endOpenstack() {
      return and();
    }
    
  }
  public class VsphereNested<N> extends VSphereFailureDomainFluent<VsphereNested<N>> implements Nested<N>{
  
    VSphereFailureDomainBuilder builder;
    int index;
  
    VsphereNested(int index,VSphereFailureDomain item) {
      this.index = index;
      this.builder = new VSphereFailureDomainBuilder(this, item);
    }
  
    public N and() {
      return (N) FailureDomainsFluent.this.setToVsphere(index, builder.build());
    }
    
    public N endVsphere() {
      return and();
    }
    
  }
}