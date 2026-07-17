package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
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
public class MetaDataFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.MetaDataFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<FromPoolBuilder> dnsServersFromIPPool = new ArrayList<FromPoolBuilder>();
  private ArrayList<MetaDataFromAnnotationBuilder> fromAnnotations = new ArrayList<MetaDataFromAnnotationBuilder>();
  private ArrayList<MetaDataHostInterfaceBuilder> fromHostInterfaces = new ArrayList<MetaDataHostInterfaceBuilder>();
  private ArrayList<MetaDataFromLabelBuilder> fromLabels = new ArrayList<MetaDataFromLabelBuilder>();
  private ArrayList<FromPoolBuilder> gatewaysFromIPPool = new ArrayList<FromPoolBuilder>();
  private ArrayList<MetaDataIndexBuilder> indexes = new ArrayList<MetaDataIndexBuilder>();
  private ArrayList<FromPoolBuilder> ipAddressesFromIPPool = new ArrayList<FromPoolBuilder>();
  private ArrayList<MetaDataNamespaceBuilder> namespaces = new ArrayList<MetaDataNamespaceBuilder>();
  private ArrayList<MetaDataObjectNameBuilder> objectNames = new ArrayList<MetaDataObjectNameBuilder>();
  private ArrayList<FromPoolBuilder> prefixesFromIPPool = new ArrayList<FromPoolBuilder>();
  private ArrayList<MetaDataStringBuilder> strings = new ArrayList<MetaDataStringBuilder>();

  public MetaDataFluent() {
  }
  
  public MetaDataFluent(MetaData instance) {
    this.copyInstance(instance);
  }

  public A addAllToDnsServersFromIPPool(Collection<FromPool> items) {
    if (this.dnsServersFromIPPool == null) {
      this.dnsServersFromIPPool = new ArrayList();
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("dnsServersFromIPPool").add(builder);
        this.dnsServersFromIPPool.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFromAnnotations(Collection<MetaDataFromAnnotation> items) {
    if (this.fromAnnotations == null) {
      this.fromAnnotations = new ArrayList();
    }
    for (MetaDataFromAnnotation item : items) {
        MetaDataFromAnnotationBuilder builder = new MetaDataFromAnnotationBuilder(item);
        _visitables.get("fromAnnotations").add(builder);
        this.fromAnnotations.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFromHostInterfaces(Collection<MetaDataHostInterface> items) {
    if (this.fromHostInterfaces == null) {
      this.fromHostInterfaces = new ArrayList();
    }
    for (MetaDataHostInterface item : items) {
        MetaDataHostInterfaceBuilder builder = new MetaDataHostInterfaceBuilder(item);
        _visitables.get("fromHostInterfaces").add(builder);
        this.fromHostInterfaces.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFromLabels(Collection<MetaDataFromLabel> items) {
    if (this.fromLabels == null) {
      this.fromLabels = new ArrayList();
    }
    for (MetaDataFromLabel item : items) {
        MetaDataFromLabelBuilder builder = new MetaDataFromLabelBuilder(item);
        _visitables.get("fromLabels").add(builder);
        this.fromLabels.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToGatewaysFromIPPool(Collection<FromPool> items) {
    if (this.gatewaysFromIPPool == null) {
      this.gatewaysFromIPPool = new ArrayList();
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("gatewaysFromIPPool").add(builder);
        this.gatewaysFromIPPool.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIndexes(Collection<MetaDataIndex> items) {
    if (this.indexes == null) {
      this.indexes = new ArrayList();
    }
    for (MetaDataIndex item : items) {
        MetaDataIndexBuilder builder = new MetaDataIndexBuilder(item);
        _visitables.get("indexes").add(builder);
        this.indexes.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIpAddressesFromIPPool(Collection<FromPool> items) {
    if (this.ipAddressesFromIPPool == null) {
      this.ipAddressesFromIPPool = new ArrayList();
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("ipAddressesFromIPPool").add(builder);
        this.ipAddressesFromIPPool.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToNamespaces(Collection<MetaDataNamespace> items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (MetaDataNamespace item : items) {
        MetaDataNamespaceBuilder builder = new MetaDataNamespaceBuilder(item);
        _visitables.get("namespaces").add(builder);
        this.namespaces.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToObjectNames(Collection<MetaDataObjectName> items) {
    if (this.objectNames == null) {
      this.objectNames = new ArrayList();
    }
    for (MetaDataObjectName item : items) {
        MetaDataObjectNameBuilder builder = new MetaDataObjectNameBuilder(item);
        _visitables.get("objectNames").add(builder);
        this.objectNames.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPrefixesFromIPPool(Collection<FromPool> items) {
    if (this.prefixesFromIPPool == null) {
      this.prefixesFromIPPool = new ArrayList();
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("prefixesFromIPPool").add(builder);
        this.prefixesFromIPPool.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToStrings(Collection<MetaDataString> items) {
    if (this.strings == null) {
      this.strings = new ArrayList();
    }
    for (MetaDataString item : items) {
        MetaDataStringBuilder builder = new MetaDataStringBuilder(item);
        _visitables.get("strings").add(builder);
        this.strings.add(builder);
    }
    return (A) this;
  }
  
  public DnsServersFromIPPoolNested<A> addNewDnsServersFromIPPool() {
    return new DnsServersFromIPPoolNested(-1, null);
  }
  
  public A addNewDnsServersFromIPPool(String apiGroup,String key,String kind,String name) {
    return (A) this.addToDnsServersFromIPPool(new FromPool(apiGroup, key, kind, name));
  }
  
  public DnsServersFromIPPoolNested<A> addNewDnsServersFromIPPoolLike(FromPool item) {
    return new DnsServersFromIPPoolNested(-1, item);
  }
  
  public FromAnnotationsNested<A> addNewFromAnnotation() {
    return new FromAnnotationsNested(-1, null);
  }
  
  public A addNewFromAnnotation(String annotation,String key,String object) {
    return (A) this.addToFromAnnotations(new MetaDataFromAnnotation(annotation, key, object));
  }
  
  public FromAnnotationsNested<A> addNewFromAnnotationLike(MetaDataFromAnnotation item) {
    return new FromAnnotationsNested(-1, item);
  }
  
  public FromHostInterfacesNested<A> addNewFromHostInterface() {
    return new FromHostInterfacesNested(-1, null);
  }
  
  public A addNewFromHostInterface(Boolean fromBootMAC,String _interface,String key) {
    return (A) this.addToFromHostInterfaces(new MetaDataHostInterface(fromBootMAC, _interface, key));
  }
  
  public FromHostInterfacesNested<A> addNewFromHostInterfaceLike(MetaDataHostInterface item) {
    return new FromHostInterfacesNested(-1, item);
  }
  
  public FromLabelsNested<A> addNewFromLabel() {
    return new FromLabelsNested(-1, null);
  }
  
  public A addNewFromLabel(String key,String label,String object) {
    return (A) this.addToFromLabels(new MetaDataFromLabel(key, label, object));
  }
  
  public FromLabelsNested<A> addNewFromLabelLike(MetaDataFromLabel item) {
    return new FromLabelsNested(-1, item);
  }
  
  public GatewaysFromIPPoolNested<A> addNewGatewaysFromIPPool() {
    return new GatewaysFromIPPoolNested(-1, null);
  }
  
  public A addNewGatewaysFromIPPool(String apiGroup,String key,String kind,String name) {
    return (A) this.addToGatewaysFromIPPool(new FromPool(apiGroup, key, kind, name));
  }
  
  public GatewaysFromIPPoolNested<A> addNewGatewaysFromIPPoolLike(FromPool item) {
    return new GatewaysFromIPPoolNested(-1, item);
  }
  
  public IndexesNested<A> addNewIndex() {
    return new IndexesNested(-1, null);
  }
  
  public A addNewIndex(String key,Integer offset,String prefix,Integer step,String suffix) {
    return (A) this.addToIndexes(new MetaDataIndex(key, offset, prefix, step, suffix));
  }
  
  public IndexesNested<A> addNewIndexLike(MetaDataIndex item) {
    return new IndexesNested(-1, item);
  }
  
  public IpAddressesFromIPPoolNested<A> addNewIpAddressesFromIPPool() {
    return new IpAddressesFromIPPoolNested(-1, null);
  }
  
  public A addNewIpAddressesFromIPPool(String apiGroup,String key,String kind,String name) {
    return (A) this.addToIpAddressesFromIPPool(new FromPool(apiGroup, key, kind, name));
  }
  
  public IpAddressesFromIPPoolNested<A> addNewIpAddressesFromIPPoolLike(FromPool item) {
    return new IpAddressesFromIPPoolNested(-1, item);
  }
  
  public NamespacesNested<A> addNewNamespace() {
    return new NamespacesNested(-1, null);
  }
  
  public A addNewNamespace(String key) {
    return (A) this.addToNamespaces(new MetaDataNamespace(key));
  }
  
  public NamespacesNested<A> addNewNamespaceLike(MetaDataNamespace item) {
    return new NamespacesNested(-1, item);
  }
  
  public ObjectNamesNested<A> addNewObjectName() {
    return new ObjectNamesNested(-1, null);
  }
  
  public A addNewObjectName(String key,String object) {
    return (A) this.addToObjectNames(new MetaDataObjectName(key, object));
  }
  
  public ObjectNamesNested<A> addNewObjectNameLike(MetaDataObjectName item) {
    return new ObjectNamesNested(-1, item);
  }
  
  public PrefixesFromIPPoolNested<A> addNewPrefixesFromIPPool() {
    return new PrefixesFromIPPoolNested(-1, null);
  }
  
  public A addNewPrefixesFromIPPool(String apiGroup,String key,String kind,String name) {
    return (A) this.addToPrefixesFromIPPool(new FromPool(apiGroup, key, kind, name));
  }
  
  public PrefixesFromIPPoolNested<A> addNewPrefixesFromIPPoolLike(FromPool item) {
    return new PrefixesFromIPPoolNested(-1, item);
  }
  
  public StringsNested<A> addNewString() {
    return new StringsNested(-1, null);
  }
  
  public A addNewString(String key,String value) {
    return (A) this.addToStrings(new MetaDataString(key, value));
  }
  
  public StringsNested<A> addNewStringLike(MetaDataString item) {
    return new StringsNested(-1, item);
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
  
  public A addToDnsServersFromIPPool(FromPool... items) {
    if (this.dnsServersFromIPPool == null) {
      this.dnsServersFromIPPool = new ArrayList();
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("dnsServersFromIPPool").add(builder);
        this.dnsServersFromIPPool.add(builder);
    }
    return (A) this;
  }
  
  public A addToDnsServersFromIPPool(int index,FromPool item) {
    if (this.dnsServersFromIPPool == null) {
      this.dnsServersFromIPPool = new ArrayList();
    }
    FromPoolBuilder builder = new FromPoolBuilder(item);
    if (index < 0 || index >= dnsServersFromIPPool.size()) {
        _visitables.get("dnsServersFromIPPool").add(builder);
        dnsServersFromIPPool.add(builder);
    } else {
        _visitables.get("dnsServersFromIPPool").add(builder);
        dnsServersFromIPPool.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFromAnnotations(MetaDataFromAnnotation... items) {
    if (this.fromAnnotations == null) {
      this.fromAnnotations = new ArrayList();
    }
    for (MetaDataFromAnnotation item : items) {
        MetaDataFromAnnotationBuilder builder = new MetaDataFromAnnotationBuilder(item);
        _visitables.get("fromAnnotations").add(builder);
        this.fromAnnotations.add(builder);
    }
    return (A) this;
  }
  
  public A addToFromAnnotations(int index,MetaDataFromAnnotation item) {
    if (this.fromAnnotations == null) {
      this.fromAnnotations = new ArrayList();
    }
    MetaDataFromAnnotationBuilder builder = new MetaDataFromAnnotationBuilder(item);
    if (index < 0 || index >= fromAnnotations.size()) {
        _visitables.get("fromAnnotations").add(builder);
        fromAnnotations.add(builder);
    } else {
        _visitables.get("fromAnnotations").add(builder);
        fromAnnotations.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFromHostInterfaces(MetaDataHostInterface... items) {
    if (this.fromHostInterfaces == null) {
      this.fromHostInterfaces = new ArrayList();
    }
    for (MetaDataHostInterface item : items) {
        MetaDataHostInterfaceBuilder builder = new MetaDataHostInterfaceBuilder(item);
        _visitables.get("fromHostInterfaces").add(builder);
        this.fromHostInterfaces.add(builder);
    }
    return (A) this;
  }
  
  public A addToFromHostInterfaces(int index,MetaDataHostInterface item) {
    if (this.fromHostInterfaces == null) {
      this.fromHostInterfaces = new ArrayList();
    }
    MetaDataHostInterfaceBuilder builder = new MetaDataHostInterfaceBuilder(item);
    if (index < 0 || index >= fromHostInterfaces.size()) {
        _visitables.get("fromHostInterfaces").add(builder);
        fromHostInterfaces.add(builder);
    } else {
        _visitables.get("fromHostInterfaces").add(builder);
        fromHostInterfaces.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFromLabels(MetaDataFromLabel... items) {
    if (this.fromLabels == null) {
      this.fromLabels = new ArrayList();
    }
    for (MetaDataFromLabel item : items) {
        MetaDataFromLabelBuilder builder = new MetaDataFromLabelBuilder(item);
        _visitables.get("fromLabels").add(builder);
        this.fromLabels.add(builder);
    }
    return (A) this;
  }
  
  public A addToFromLabels(int index,MetaDataFromLabel item) {
    if (this.fromLabels == null) {
      this.fromLabels = new ArrayList();
    }
    MetaDataFromLabelBuilder builder = new MetaDataFromLabelBuilder(item);
    if (index < 0 || index >= fromLabels.size()) {
        _visitables.get("fromLabels").add(builder);
        fromLabels.add(builder);
    } else {
        _visitables.get("fromLabels").add(builder);
        fromLabels.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToGatewaysFromIPPool(FromPool... items) {
    if (this.gatewaysFromIPPool == null) {
      this.gatewaysFromIPPool = new ArrayList();
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("gatewaysFromIPPool").add(builder);
        this.gatewaysFromIPPool.add(builder);
    }
    return (A) this;
  }
  
  public A addToGatewaysFromIPPool(int index,FromPool item) {
    if (this.gatewaysFromIPPool == null) {
      this.gatewaysFromIPPool = new ArrayList();
    }
    FromPoolBuilder builder = new FromPoolBuilder(item);
    if (index < 0 || index >= gatewaysFromIPPool.size()) {
        _visitables.get("gatewaysFromIPPool").add(builder);
        gatewaysFromIPPool.add(builder);
    } else {
        _visitables.get("gatewaysFromIPPool").add(builder);
        gatewaysFromIPPool.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIndexes(MetaDataIndex... items) {
    if (this.indexes == null) {
      this.indexes = new ArrayList();
    }
    for (MetaDataIndex item : items) {
        MetaDataIndexBuilder builder = new MetaDataIndexBuilder(item);
        _visitables.get("indexes").add(builder);
        this.indexes.add(builder);
    }
    return (A) this;
  }
  
  public A addToIndexes(int index,MetaDataIndex item) {
    if (this.indexes == null) {
      this.indexes = new ArrayList();
    }
    MetaDataIndexBuilder builder = new MetaDataIndexBuilder(item);
    if (index < 0 || index >= indexes.size()) {
        _visitables.get("indexes").add(builder);
        indexes.add(builder);
    } else {
        _visitables.get("indexes").add(builder);
        indexes.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIpAddressesFromIPPool(FromPool... items) {
    if (this.ipAddressesFromIPPool == null) {
      this.ipAddressesFromIPPool = new ArrayList();
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("ipAddressesFromIPPool").add(builder);
        this.ipAddressesFromIPPool.add(builder);
    }
    return (A) this;
  }
  
  public A addToIpAddressesFromIPPool(int index,FromPool item) {
    if (this.ipAddressesFromIPPool == null) {
      this.ipAddressesFromIPPool = new ArrayList();
    }
    FromPoolBuilder builder = new FromPoolBuilder(item);
    if (index < 0 || index >= ipAddressesFromIPPool.size()) {
        _visitables.get("ipAddressesFromIPPool").add(builder);
        ipAddressesFromIPPool.add(builder);
    } else {
        _visitables.get("ipAddressesFromIPPool").add(builder);
        ipAddressesFromIPPool.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToNamespaces(MetaDataNamespace... items) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    for (MetaDataNamespace item : items) {
        MetaDataNamespaceBuilder builder = new MetaDataNamespaceBuilder(item);
        _visitables.get("namespaces").add(builder);
        this.namespaces.add(builder);
    }
    return (A) this;
  }
  
  public A addToNamespaces(int index,MetaDataNamespace item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    MetaDataNamespaceBuilder builder = new MetaDataNamespaceBuilder(item);
    if (index < 0 || index >= namespaces.size()) {
        _visitables.get("namespaces").add(builder);
        namespaces.add(builder);
    } else {
        _visitables.get("namespaces").add(builder);
        namespaces.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToObjectNames(MetaDataObjectName... items) {
    if (this.objectNames == null) {
      this.objectNames = new ArrayList();
    }
    for (MetaDataObjectName item : items) {
        MetaDataObjectNameBuilder builder = new MetaDataObjectNameBuilder(item);
        _visitables.get("objectNames").add(builder);
        this.objectNames.add(builder);
    }
    return (A) this;
  }
  
  public A addToObjectNames(int index,MetaDataObjectName item) {
    if (this.objectNames == null) {
      this.objectNames = new ArrayList();
    }
    MetaDataObjectNameBuilder builder = new MetaDataObjectNameBuilder(item);
    if (index < 0 || index >= objectNames.size()) {
        _visitables.get("objectNames").add(builder);
        objectNames.add(builder);
    } else {
        _visitables.get("objectNames").add(builder);
        objectNames.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPrefixesFromIPPool(FromPool... items) {
    if (this.prefixesFromIPPool == null) {
      this.prefixesFromIPPool = new ArrayList();
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("prefixesFromIPPool").add(builder);
        this.prefixesFromIPPool.add(builder);
    }
    return (A) this;
  }
  
  public A addToPrefixesFromIPPool(int index,FromPool item) {
    if (this.prefixesFromIPPool == null) {
      this.prefixesFromIPPool = new ArrayList();
    }
    FromPoolBuilder builder = new FromPoolBuilder(item);
    if (index < 0 || index >= prefixesFromIPPool.size()) {
        _visitables.get("prefixesFromIPPool").add(builder);
        prefixesFromIPPool.add(builder);
    } else {
        _visitables.get("prefixesFromIPPool").add(builder);
        prefixesFromIPPool.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToStrings(MetaDataString... items) {
    if (this.strings == null) {
      this.strings = new ArrayList();
    }
    for (MetaDataString item : items) {
        MetaDataStringBuilder builder = new MetaDataStringBuilder(item);
        _visitables.get("strings").add(builder);
        this.strings.add(builder);
    }
    return (A) this;
  }
  
  public A addToStrings(int index,MetaDataString item) {
    if (this.strings == null) {
      this.strings = new ArrayList();
    }
    MetaDataStringBuilder builder = new MetaDataStringBuilder(item);
    if (index < 0 || index >= strings.size()) {
        _visitables.get("strings").add(builder);
        strings.add(builder);
    } else {
        _visitables.get("strings").add(builder);
        strings.add(index, builder);
    }
    return (A) this;
  }
  
  public List<FromPool> buildDnsServersFromIPPool() {
    return this.dnsServersFromIPPool != null ? build(dnsServersFromIPPool) : null;
  }
  
  public FromPool buildDnsServersFromIPPool(int index) {
    return this.dnsServersFromIPPool.get(index).build();
  }
  
  public FromPool buildFirstDnsServersFromIPPool() {
    return this.dnsServersFromIPPool.get(0).build();
  }
  
  public MetaDataFromAnnotation buildFirstFromAnnotation() {
    return this.fromAnnotations.get(0).build();
  }
  
  public MetaDataHostInterface buildFirstFromHostInterface() {
    return this.fromHostInterfaces.get(0).build();
  }
  
  public MetaDataFromLabel buildFirstFromLabel() {
    return this.fromLabels.get(0).build();
  }
  
  public FromPool buildFirstGatewaysFromIPPool() {
    return this.gatewaysFromIPPool.get(0).build();
  }
  
  public MetaDataIndex buildFirstIndex() {
    return this.indexes.get(0).build();
  }
  
  public FromPool buildFirstIpAddressesFromIPPool() {
    return this.ipAddressesFromIPPool.get(0).build();
  }
  
  public MetaDataNamespace buildFirstNamespace() {
    return this.namespaces.get(0).build();
  }
  
  public MetaDataObjectName buildFirstObjectName() {
    return this.objectNames.get(0).build();
  }
  
  public FromPool buildFirstPrefixesFromIPPool() {
    return this.prefixesFromIPPool.get(0).build();
  }
  
  public MetaDataString buildFirstString() {
    return this.strings.get(0).build();
  }
  
  public MetaDataFromAnnotation buildFromAnnotation(int index) {
    return this.fromAnnotations.get(index).build();
  }
  
  public List<MetaDataFromAnnotation> buildFromAnnotations() {
    return this.fromAnnotations != null ? build(fromAnnotations) : null;
  }
  
  public MetaDataHostInterface buildFromHostInterface(int index) {
    return this.fromHostInterfaces.get(index).build();
  }
  
  public List<MetaDataHostInterface> buildFromHostInterfaces() {
    return this.fromHostInterfaces != null ? build(fromHostInterfaces) : null;
  }
  
  public MetaDataFromLabel buildFromLabel(int index) {
    return this.fromLabels.get(index).build();
  }
  
  public List<MetaDataFromLabel> buildFromLabels() {
    return this.fromLabels != null ? build(fromLabels) : null;
  }
  
  public List<FromPool> buildGatewaysFromIPPool() {
    return this.gatewaysFromIPPool != null ? build(gatewaysFromIPPool) : null;
  }
  
  public FromPool buildGatewaysFromIPPool(int index) {
    return this.gatewaysFromIPPool.get(index).build();
  }
  
  public MetaDataIndex buildIndex(int index) {
    return this.indexes.get(index).build();
  }
  
  public List<MetaDataIndex> buildIndexes() {
    return this.indexes != null ? build(indexes) : null;
  }
  
  public List<FromPool> buildIpAddressesFromIPPool() {
    return this.ipAddressesFromIPPool != null ? build(ipAddressesFromIPPool) : null;
  }
  
  public FromPool buildIpAddressesFromIPPool(int index) {
    return this.ipAddressesFromIPPool.get(index).build();
  }
  
  public FromPool buildLastDnsServersFromIPPool() {
    return this.dnsServersFromIPPool.get(dnsServersFromIPPool.size() - 1).build();
  }
  
  public MetaDataFromAnnotation buildLastFromAnnotation() {
    return this.fromAnnotations.get(fromAnnotations.size() - 1).build();
  }
  
  public MetaDataHostInterface buildLastFromHostInterface() {
    return this.fromHostInterfaces.get(fromHostInterfaces.size() - 1).build();
  }
  
  public MetaDataFromLabel buildLastFromLabel() {
    return this.fromLabels.get(fromLabels.size() - 1).build();
  }
  
  public FromPool buildLastGatewaysFromIPPool() {
    return this.gatewaysFromIPPool.get(gatewaysFromIPPool.size() - 1).build();
  }
  
  public MetaDataIndex buildLastIndex() {
    return this.indexes.get(indexes.size() - 1).build();
  }
  
  public FromPool buildLastIpAddressesFromIPPool() {
    return this.ipAddressesFromIPPool.get(ipAddressesFromIPPool.size() - 1).build();
  }
  
  public MetaDataNamespace buildLastNamespace() {
    return this.namespaces.get(namespaces.size() - 1).build();
  }
  
  public MetaDataObjectName buildLastObjectName() {
    return this.objectNames.get(objectNames.size() - 1).build();
  }
  
  public FromPool buildLastPrefixesFromIPPool() {
    return this.prefixesFromIPPool.get(prefixesFromIPPool.size() - 1).build();
  }
  
  public MetaDataString buildLastString() {
    return this.strings.get(strings.size() - 1).build();
  }
  
  public FromPool buildMatchingDnsServersFromIPPool(Predicate<FromPoolBuilder> predicate) {
      for (FromPoolBuilder item : dnsServersFromIPPool) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MetaDataFromAnnotation buildMatchingFromAnnotation(Predicate<MetaDataFromAnnotationBuilder> predicate) {
      for (MetaDataFromAnnotationBuilder item : fromAnnotations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MetaDataHostInterface buildMatchingFromHostInterface(Predicate<MetaDataHostInterfaceBuilder> predicate) {
      for (MetaDataHostInterfaceBuilder item : fromHostInterfaces) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MetaDataFromLabel buildMatchingFromLabel(Predicate<MetaDataFromLabelBuilder> predicate) {
      for (MetaDataFromLabelBuilder item : fromLabels) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public FromPool buildMatchingGatewaysFromIPPool(Predicate<FromPoolBuilder> predicate) {
      for (FromPoolBuilder item : gatewaysFromIPPool) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MetaDataIndex buildMatchingIndex(Predicate<MetaDataIndexBuilder> predicate) {
      for (MetaDataIndexBuilder item : indexes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public FromPool buildMatchingIpAddressesFromIPPool(Predicate<FromPoolBuilder> predicate) {
      for (FromPoolBuilder item : ipAddressesFromIPPool) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MetaDataNamespace buildMatchingNamespace(Predicate<MetaDataNamespaceBuilder> predicate) {
      for (MetaDataNamespaceBuilder item : namespaces) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MetaDataObjectName buildMatchingObjectName(Predicate<MetaDataObjectNameBuilder> predicate) {
      for (MetaDataObjectNameBuilder item : objectNames) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public FromPool buildMatchingPrefixesFromIPPool(Predicate<FromPoolBuilder> predicate) {
      for (FromPoolBuilder item : prefixesFromIPPool) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MetaDataString buildMatchingString(Predicate<MetaDataStringBuilder> predicate) {
      for (MetaDataStringBuilder item : strings) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MetaDataNamespace buildNamespace(int index) {
    return this.namespaces.get(index).build();
  }
  
  public List<MetaDataNamespace> buildNamespaces() {
    return this.namespaces != null ? build(namespaces) : null;
  }
  
  public MetaDataObjectName buildObjectName(int index) {
    return this.objectNames.get(index).build();
  }
  
  public List<MetaDataObjectName> buildObjectNames() {
    return this.objectNames != null ? build(objectNames) : null;
  }
  
  public List<FromPool> buildPrefixesFromIPPool() {
    return this.prefixesFromIPPool != null ? build(prefixesFromIPPool) : null;
  }
  
  public FromPool buildPrefixesFromIPPool(int index) {
    return this.prefixesFromIPPool.get(index).build();
  }
  
  public MetaDataString buildString(int index) {
    return this.strings.get(index).build();
  }
  
  public List<MetaDataString> buildStrings() {
    return this.strings != null ? build(strings) : null;
  }
  
  protected void copyInstance(MetaData instance) {
    instance = instance != null ? instance : new MetaData();
    if (instance != null) {
        this.withDnsServersFromIPPool(instance.getDnsServersFromIPPool());
        this.withFromAnnotations(instance.getFromAnnotations());
        this.withFromHostInterfaces(instance.getFromHostInterfaces());
        this.withFromLabels(instance.getFromLabels());
        this.withGatewaysFromIPPool(instance.getGatewaysFromIPPool());
        this.withIndexes(instance.getIndexes());
        this.withIpAddressesFromIPPool(instance.getIpAddressesFromIPPool());
        this.withNamespaces(instance.getNamespaces());
        this.withObjectNames(instance.getObjectNames());
        this.withPrefixesFromIPPool(instance.getPrefixesFromIPPool());
        this.withStrings(instance.getStrings());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DnsServersFromIPPoolNested<A> editDnsServersFromIPPool(int index) {
    if (dnsServersFromIPPool.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dnsServersFromIPPool"));
    }
    return this.setNewDnsServersFromIPPoolLike(index, this.buildDnsServersFromIPPool(index));
  }
  
  public DnsServersFromIPPoolNested<A> editFirstDnsServersFromIPPool() {
    if (dnsServersFromIPPool.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dnsServersFromIPPool"));
    }
    return this.setNewDnsServersFromIPPoolLike(0, this.buildDnsServersFromIPPool(0));
  }
  
  public FromAnnotationsNested<A> editFirstFromAnnotation() {
    if (fromAnnotations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "fromAnnotations"));
    }
    return this.setNewFromAnnotationLike(0, this.buildFromAnnotation(0));
  }
  
  public FromHostInterfacesNested<A> editFirstFromHostInterface() {
    if (fromHostInterfaces.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "fromHostInterfaces"));
    }
    return this.setNewFromHostInterfaceLike(0, this.buildFromHostInterface(0));
  }
  
  public FromLabelsNested<A> editFirstFromLabel() {
    if (fromLabels.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "fromLabels"));
    }
    return this.setNewFromLabelLike(0, this.buildFromLabel(0));
  }
  
  public GatewaysFromIPPoolNested<A> editFirstGatewaysFromIPPool() {
    if (gatewaysFromIPPool.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "gatewaysFromIPPool"));
    }
    return this.setNewGatewaysFromIPPoolLike(0, this.buildGatewaysFromIPPool(0));
  }
  
  public IndexesNested<A> editFirstIndex() {
    if (indexes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "indexes"));
    }
    return this.setNewIndexLike(0, this.buildIndex(0));
  }
  
  public IpAddressesFromIPPoolNested<A> editFirstIpAddressesFromIPPool() {
    if (ipAddressesFromIPPool.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ipAddressesFromIPPool"));
    }
    return this.setNewIpAddressesFromIPPoolLike(0, this.buildIpAddressesFromIPPool(0));
  }
  
  public NamespacesNested<A> editFirstNamespace() {
    if (namespaces.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "namespaces"));
    }
    return this.setNewNamespaceLike(0, this.buildNamespace(0));
  }
  
  public ObjectNamesNested<A> editFirstObjectName() {
    if (objectNames.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "objectNames"));
    }
    return this.setNewObjectNameLike(0, this.buildObjectName(0));
  }
  
  public PrefixesFromIPPoolNested<A> editFirstPrefixesFromIPPool() {
    if (prefixesFromIPPool.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "prefixesFromIPPool"));
    }
    return this.setNewPrefixesFromIPPoolLike(0, this.buildPrefixesFromIPPool(0));
  }
  
  public StringsNested<A> editFirstString() {
    if (strings.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "strings"));
    }
    return this.setNewStringLike(0, this.buildString(0));
  }
  
  public FromAnnotationsNested<A> editFromAnnotation(int index) {
    if (fromAnnotations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "fromAnnotations"));
    }
    return this.setNewFromAnnotationLike(index, this.buildFromAnnotation(index));
  }
  
  public FromHostInterfacesNested<A> editFromHostInterface(int index) {
    if (fromHostInterfaces.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "fromHostInterfaces"));
    }
    return this.setNewFromHostInterfaceLike(index, this.buildFromHostInterface(index));
  }
  
  public FromLabelsNested<A> editFromLabel(int index) {
    if (fromLabels.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "fromLabels"));
    }
    return this.setNewFromLabelLike(index, this.buildFromLabel(index));
  }
  
  public GatewaysFromIPPoolNested<A> editGatewaysFromIPPool(int index) {
    if (gatewaysFromIPPool.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "gatewaysFromIPPool"));
    }
    return this.setNewGatewaysFromIPPoolLike(index, this.buildGatewaysFromIPPool(index));
  }
  
  public IndexesNested<A> editIndex(int index) {
    if (indexes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "indexes"));
    }
    return this.setNewIndexLike(index, this.buildIndex(index));
  }
  
  public IpAddressesFromIPPoolNested<A> editIpAddressesFromIPPool(int index) {
    if (ipAddressesFromIPPool.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ipAddressesFromIPPool"));
    }
    return this.setNewIpAddressesFromIPPoolLike(index, this.buildIpAddressesFromIPPool(index));
  }
  
  public DnsServersFromIPPoolNested<A> editLastDnsServersFromIPPool() {
    int index = dnsServersFromIPPool.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dnsServersFromIPPool"));
    }
    return this.setNewDnsServersFromIPPoolLike(index, this.buildDnsServersFromIPPool(index));
  }
  
  public FromAnnotationsNested<A> editLastFromAnnotation() {
    int index = fromAnnotations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "fromAnnotations"));
    }
    return this.setNewFromAnnotationLike(index, this.buildFromAnnotation(index));
  }
  
  public FromHostInterfacesNested<A> editLastFromHostInterface() {
    int index = fromHostInterfaces.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "fromHostInterfaces"));
    }
    return this.setNewFromHostInterfaceLike(index, this.buildFromHostInterface(index));
  }
  
  public FromLabelsNested<A> editLastFromLabel() {
    int index = fromLabels.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "fromLabels"));
    }
    return this.setNewFromLabelLike(index, this.buildFromLabel(index));
  }
  
  public GatewaysFromIPPoolNested<A> editLastGatewaysFromIPPool() {
    int index = gatewaysFromIPPool.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "gatewaysFromIPPool"));
    }
    return this.setNewGatewaysFromIPPoolLike(index, this.buildGatewaysFromIPPool(index));
  }
  
  public IndexesNested<A> editLastIndex() {
    int index = indexes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "indexes"));
    }
    return this.setNewIndexLike(index, this.buildIndex(index));
  }
  
  public IpAddressesFromIPPoolNested<A> editLastIpAddressesFromIPPool() {
    int index = ipAddressesFromIPPool.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ipAddressesFromIPPool"));
    }
    return this.setNewIpAddressesFromIPPoolLike(index, this.buildIpAddressesFromIPPool(index));
  }
  
  public NamespacesNested<A> editLastNamespace() {
    int index = namespaces.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "namespaces"));
    }
    return this.setNewNamespaceLike(index, this.buildNamespace(index));
  }
  
  public ObjectNamesNested<A> editLastObjectName() {
    int index = objectNames.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "objectNames"));
    }
    return this.setNewObjectNameLike(index, this.buildObjectName(index));
  }
  
  public PrefixesFromIPPoolNested<A> editLastPrefixesFromIPPool() {
    int index = prefixesFromIPPool.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "prefixesFromIPPool"));
    }
    return this.setNewPrefixesFromIPPoolLike(index, this.buildPrefixesFromIPPool(index));
  }
  
  public StringsNested<A> editLastString() {
    int index = strings.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "strings"));
    }
    return this.setNewStringLike(index, this.buildString(index));
  }
  
  public DnsServersFromIPPoolNested<A> editMatchingDnsServersFromIPPool(Predicate<FromPoolBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dnsServersFromIPPool.size();i++) {
      if (predicate.test(dnsServersFromIPPool.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dnsServersFromIPPool"));
    }
    return this.setNewDnsServersFromIPPoolLike(index, this.buildDnsServersFromIPPool(index));
  }
  
  public FromAnnotationsNested<A> editMatchingFromAnnotation(Predicate<MetaDataFromAnnotationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < fromAnnotations.size();i++) {
      if (predicate.test(fromAnnotations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "fromAnnotations"));
    }
    return this.setNewFromAnnotationLike(index, this.buildFromAnnotation(index));
  }
  
  public FromHostInterfacesNested<A> editMatchingFromHostInterface(Predicate<MetaDataHostInterfaceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < fromHostInterfaces.size();i++) {
      if (predicate.test(fromHostInterfaces.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "fromHostInterfaces"));
    }
    return this.setNewFromHostInterfaceLike(index, this.buildFromHostInterface(index));
  }
  
  public FromLabelsNested<A> editMatchingFromLabel(Predicate<MetaDataFromLabelBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < fromLabels.size();i++) {
      if (predicate.test(fromLabels.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "fromLabels"));
    }
    return this.setNewFromLabelLike(index, this.buildFromLabel(index));
  }
  
  public GatewaysFromIPPoolNested<A> editMatchingGatewaysFromIPPool(Predicate<FromPoolBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < gatewaysFromIPPool.size();i++) {
      if (predicate.test(gatewaysFromIPPool.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "gatewaysFromIPPool"));
    }
    return this.setNewGatewaysFromIPPoolLike(index, this.buildGatewaysFromIPPool(index));
  }
  
  public IndexesNested<A> editMatchingIndex(Predicate<MetaDataIndexBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < indexes.size();i++) {
      if (predicate.test(indexes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "indexes"));
    }
    return this.setNewIndexLike(index, this.buildIndex(index));
  }
  
  public IpAddressesFromIPPoolNested<A> editMatchingIpAddressesFromIPPool(Predicate<FromPoolBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ipAddressesFromIPPool.size();i++) {
      if (predicate.test(ipAddressesFromIPPool.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ipAddressesFromIPPool"));
    }
    return this.setNewIpAddressesFromIPPoolLike(index, this.buildIpAddressesFromIPPool(index));
  }
  
  public NamespacesNested<A> editMatchingNamespace(Predicate<MetaDataNamespaceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < namespaces.size();i++) {
      if (predicate.test(namespaces.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "namespaces"));
    }
    return this.setNewNamespaceLike(index, this.buildNamespace(index));
  }
  
  public ObjectNamesNested<A> editMatchingObjectName(Predicate<MetaDataObjectNameBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < objectNames.size();i++) {
      if (predicate.test(objectNames.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "objectNames"));
    }
    return this.setNewObjectNameLike(index, this.buildObjectName(index));
  }
  
  public PrefixesFromIPPoolNested<A> editMatchingPrefixesFromIPPool(Predicate<FromPoolBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < prefixesFromIPPool.size();i++) {
      if (predicate.test(prefixesFromIPPool.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "prefixesFromIPPool"));
    }
    return this.setNewPrefixesFromIPPoolLike(index, this.buildPrefixesFromIPPool(index));
  }
  
  public StringsNested<A> editMatchingString(Predicate<MetaDataStringBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < strings.size();i++) {
      if (predicate.test(strings.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "strings"));
    }
    return this.setNewStringLike(index, this.buildString(index));
  }
  
  public NamespacesNested<A> editNamespace(int index) {
    if (namespaces.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "namespaces"));
    }
    return this.setNewNamespaceLike(index, this.buildNamespace(index));
  }
  
  public ObjectNamesNested<A> editObjectName(int index) {
    if (objectNames.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "objectNames"));
    }
    return this.setNewObjectNameLike(index, this.buildObjectName(index));
  }
  
  public PrefixesFromIPPoolNested<A> editPrefixesFromIPPool(int index) {
    if (prefixesFromIPPool.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "prefixesFromIPPool"));
    }
    return this.setNewPrefixesFromIPPoolLike(index, this.buildPrefixesFromIPPool(index));
  }
  
  public StringsNested<A> editString(int index) {
    if (strings.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "strings"));
    }
    return this.setNewStringLike(index, this.buildString(index));
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
    MetaDataFluent that = (MetaDataFluent) o;
    if (!(Objects.equals(dnsServersFromIPPool, that.dnsServersFromIPPool))) {
      return false;
    }
    if (!(Objects.equals(fromAnnotations, that.fromAnnotations))) {
      return false;
    }
    if (!(Objects.equals(fromHostInterfaces, that.fromHostInterfaces))) {
      return false;
    }
    if (!(Objects.equals(fromLabels, that.fromLabels))) {
      return false;
    }
    if (!(Objects.equals(gatewaysFromIPPool, that.gatewaysFromIPPool))) {
      return false;
    }
    if (!(Objects.equals(indexes, that.indexes))) {
      return false;
    }
    if (!(Objects.equals(ipAddressesFromIPPool, that.ipAddressesFromIPPool))) {
      return false;
    }
    if (!(Objects.equals(namespaces, that.namespaces))) {
      return false;
    }
    if (!(Objects.equals(objectNames, that.objectNames))) {
      return false;
    }
    if (!(Objects.equals(prefixesFromIPPool, that.prefixesFromIPPool))) {
      return false;
    }
    if (!(Objects.equals(strings, that.strings))) {
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
  
  public boolean hasDnsServersFromIPPool() {
    return this.dnsServersFromIPPool != null && !(this.dnsServersFromIPPool.isEmpty());
  }
  
  public boolean hasFromAnnotations() {
    return this.fromAnnotations != null && !(this.fromAnnotations.isEmpty());
  }
  
  public boolean hasFromHostInterfaces() {
    return this.fromHostInterfaces != null && !(this.fromHostInterfaces.isEmpty());
  }
  
  public boolean hasFromLabels() {
    return this.fromLabels != null && !(this.fromLabels.isEmpty());
  }
  
  public boolean hasGatewaysFromIPPool() {
    return this.gatewaysFromIPPool != null && !(this.gatewaysFromIPPool.isEmpty());
  }
  
  public boolean hasIndexes() {
    return this.indexes != null && !(this.indexes.isEmpty());
  }
  
  public boolean hasIpAddressesFromIPPool() {
    return this.ipAddressesFromIPPool != null && !(this.ipAddressesFromIPPool.isEmpty());
  }
  
  public boolean hasMatchingDnsServersFromIPPool(Predicate<FromPoolBuilder> predicate) {
      for (FromPoolBuilder item : dnsServersFromIPPool) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFromAnnotation(Predicate<MetaDataFromAnnotationBuilder> predicate) {
      for (MetaDataFromAnnotationBuilder item : fromAnnotations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFromHostInterface(Predicate<MetaDataHostInterfaceBuilder> predicate) {
      for (MetaDataHostInterfaceBuilder item : fromHostInterfaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFromLabel(Predicate<MetaDataFromLabelBuilder> predicate) {
      for (MetaDataFromLabelBuilder item : fromLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGatewaysFromIPPool(Predicate<FromPoolBuilder> predicate) {
      for (FromPoolBuilder item : gatewaysFromIPPool) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIndex(Predicate<MetaDataIndexBuilder> predicate) {
      for (MetaDataIndexBuilder item : indexes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIpAddressesFromIPPool(Predicate<FromPoolBuilder> predicate) {
      for (FromPoolBuilder item : ipAddressesFromIPPool) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNamespace(Predicate<MetaDataNamespaceBuilder> predicate) {
      for (MetaDataNamespaceBuilder item : namespaces) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingObjectName(Predicate<MetaDataObjectNameBuilder> predicate) {
      for (MetaDataObjectNameBuilder item : objectNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPrefixesFromIPPool(Predicate<FromPoolBuilder> predicate) {
      for (FromPoolBuilder item : prefixesFromIPPool) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingString(Predicate<MetaDataStringBuilder> predicate) {
      for (MetaDataStringBuilder item : strings) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaces() {
    return this.namespaces != null && !(this.namespaces.isEmpty());
  }
  
  public boolean hasObjectNames() {
    return this.objectNames != null && !(this.objectNames.isEmpty());
  }
  
  public boolean hasPrefixesFromIPPool() {
    return this.prefixesFromIPPool != null && !(this.prefixesFromIPPool.isEmpty());
  }
  
  public boolean hasStrings() {
    return this.strings != null && !(this.strings.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(dnsServersFromIPPool, fromAnnotations, fromHostInterfaces, fromLabels, gatewaysFromIPPool, indexes, ipAddressesFromIPPool, namespaces, objectNames, prefixesFromIPPool, strings, additionalProperties);
  }
  
  public A removeAllFromDnsServersFromIPPool(Collection<FromPool> items) {
    if (this.dnsServersFromIPPool == null) {
      return (A) this;
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("dnsServersFromIPPool").remove(builder);
        this.dnsServersFromIPPool.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFromAnnotations(Collection<MetaDataFromAnnotation> items) {
    if (this.fromAnnotations == null) {
      return (A) this;
    }
    for (MetaDataFromAnnotation item : items) {
        MetaDataFromAnnotationBuilder builder = new MetaDataFromAnnotationBuilder(item);
        _visitables.get("fromAnnotations").remove(builder);
        this.fromAnnotations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFromHostInterfaces(Collection<MetaDataHostInterface> items) {
    if (this.fromHostInterfaces == null) {
      return (A) this;
    }
    for (MetaDataHostInterface item : items) {
        MetaDataHostInterfaceBuilder builder = new MetaDataHostInterfaceBuilder(item);
        _visitables.get("fromHostInterfaces").remove(builder);
        this.fromHostInterfaces.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFromLabels(Collection<MetaDataFromLabel> items) {
    if (this.fromLabels == null) {
      return (A) this;
    }
    for (MetaDataFromLabel item : items) {
        MetaDataFromLabelBuilder builder = new MetaDataFromLabelBuilder(item);
        _visitables.get("fromLabels").remove(builder);
        this.fromLabels.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromGatewaysFromIPPool(Collection<FromPool> items) {
    if (this.gatewaysFromIPPool == null) {
      return (A) this;
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("gatewaysFromIPPool").remove(builder);
        this.gatewaysFromIPPool.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIndexes(Collection<MetaDataIndex> items) {
    if (this.indexes == null) {
      return (A) this;
    }
    for (MetaDataIndex item : items) {
        MetaDataIndexBuilder builder = new MetaDataIndexBuilder(item);
        _visitables.get("indexes").remove(builder);
        this.indexes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIpAddressesFromIPPool(Collection<FromPool> items) {
    if (this.ipAddressesFromIPPool == null) {
      return (A) this;
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("ipAddressesFromIPPool").remove(builder);
        this.ipAddressesFromIPPool.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromNamespaces(Collection<MetaDataNamespace> items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (MetaDataNamespace item : items) {
        MetaDataNamespaceBuilder builder = new MetaDataNamespaceBuilder(item);
        _visitables.get("namespaces").remove(builder);
        this.namespaces.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromObjectNames(Collection<MetaDataObjectName> items) {
    if (this.objectNames == null) {
      return (A) this;
    }
    for (MetaDataObjectName item : items) {
        MetaDataObjectNameBuilder builder = new MetaDataObjectNameBuilder(item);
        _visitables.get("objectNames").remove(builder);
        this.objectNames.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPrefixesFromIPPool(Collection<FromPool> items) {
    if (this.prefixesFromIPPool == null) {
      return (A) this;
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("prefixesFromIPPool").remove(builder);
        this.prefixesFromIPPool.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromStrings(Collection<MetaDataString> items) {
    if (this.strings == null) {
      return (A) this;
    }
    for (MetaDataString item : items) {
        MetaDataStringBuilder builder = new MetaDataStringBuilder(item);
        _visitables.get("strings").remove(builder);
        this.strings.remove(builder);
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
  
  public A removeFromDnsServersFromIPPool(FromPool... items) {
    if (this.dnsServersFromIPPool == null) {
      return (A) this;
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("dnsServersFromIPPool").remove(builder);
        this.dnsServersFromIPPool.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFromAnnotations(MetaDataFromAnnotation... items) {
    if (this.fromAnnotations == null) {
      return (A) this;
    }
    for (MetaDataFromAnnotation item : items) {
        MetaDataFromAnnotationBuilder builder = new MetaDataFromAnnotationBuilder(item);
        _visitables.get("fromAnnotations").remove(builder);
        this.fromAnnotations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFromHostInterfaces(MetaDataHostInterface... items) {
    if (this.fromHostInterfaces == null) {
      return (A) this;
    }
    for (MetaDataHostInterface item : items) {
        MetaDataHostInterfaceBuilder builder = new MetaDataHostInterfaceBuilder(item);
        _visitables.get("fromHostInterfaces").remove(builder);
        this.fromHostInterfaces.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFromLabels(MetaDataFromLabel... items) {
    if (this.fromLabels == null) {
      return (A) this;
    }
    for (MetaDataFromLabel item : items) {
        MetaDataFromLabelBuilder builder = new MetaDataFromLabelBuilder(item);
        _visitables.get("fromLabels").remove(builder);
        this.fromLabels.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromGatewaysFromIPPool(FromPool... items) {
    if (this.gatewaysFromIPPool == null) {
      return (A) this;
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("gatewaysFromIPPool").remove(builder);
        this.gatewaysFromIPPool.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIndexes(MetaDataIndex... items) {
    if (this.indexes == null) {
      return (A) this;
    }
    for (MetaDataIndex item : items) {
        MetaDataIndexBuilder builder = new MetaDataIndexBuilder(item);
        _visitables.get("indexes").remove(builder);
        this.indexes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIpAddressesFromIPPool(FromPool... items) {
    if (this.ipAddressesFromIPPool == null) {
      return (A) this;
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("ipAddressesFromIPPool").remove(builder);
        this.ipAddressesFromIPPool.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromNamespaces(MetaDataNamespace... items) {
    if (this.namespaces == null) {
      return (A) this;
    }
    for (MetaDataNamespace item : items) {
        MetaDataNamespaceBuilder builder = new MetaDataNamespaceBuilder(item);
        _visitables.get("namespaces").remove(builder);
        this.namespaces.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromObjectNames(MetaDataObjectName... items) {
    if (this.objectNames == null) {
      return (A) this;
    }
    for (MetaDataObjectName item : items) {
        MetaDataObjectNameBuilder builder = new MetaDataObjectNameBuilder(item);
        _visitables.get("objectNames").remove(builder);
        this.objectNames.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPrefixesFromIPPool(FromPool... items) {
    if (this.prefixesFromIPPool == null) {
      return (A) this;
    }
    for (FromPool item : items) {
        FromPoolBuilder builder = new FromPoolBuilder(item);
        _visitables.get("prefixesFromIPPool").remove(builder);
        this.prefixesFromIPPool.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromStrings(MetaDataString... items) {
    if (this.strings == null) {
      return (A) this;
    }
    for (MetaDataString item : items) {
        MetaDataStringBuilder builder = new MetaDataStringBuilder(item);
        _visitables.get("strings").remove(builder);
        this.strings.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDnsServersFromIPPool(Predicate<FromPoolBuilder> predicate) {
    if (dnsServersFromIPPool == null) {
      return (A) this;
    }
    Iterator<FromPoolBuilder> each = dnsServersFromIPPool.iterator();
    List visitables = _visitables.get("dnsServersFromIPPool");
    while (each.hasNext()) {
        FromPoolBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromFromAnnotations(Predicate<MetaDataFromAnnotationBuilder> predicate) {
    if (fromAnnotations == null) {
      return (A) this;
    }
    Iterator<MetaDataFromAnnotationBuilder> each = fromAnnotations.iterator();
    List visitables = _visitables.get("fromAnnotations");
    while (each.hasNext()) {
        MetaDataFromAnnotationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromFromHostInterfaces(Predicate<MetaDataHostInterfaceBuilder> predicate) {
    if (fromHostInterfaces == null) {
      return (A) this;
    }
    Iterator<MetaDataHostInterfaceBuilder> each = fromHostInterfaces.iterator();
    List visitables = _visitables.get("fromHostInterfaces");
    while (each.hasNext()) {
        MetaDataHostInterfaceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromFromLabels(Predicate<MetaDataFromLabelBuilder> predicate) {
    if (fromLabels == null) {
      return (A) this;
    }
    Iterator<MetaDataFromLabelBuilder> each = fromLabels.iterator();
    List visitables = _visitables.get("fromLabels");
    while (each.hasNext()) {
        MetaDataFromLabelBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromGatewaysFromIPPool(Predicate<FromPoolBuilder> predicate) {
    if (gatewaysFromIPPool == null) {
      return (A) this;
    }
    Iterator<FromPoolBuilder> each = gatewaysFromIPPool.iterator();
    List visitables = _visitables.get("gatewaysFromIPPool");
    while (each.hasNext()) {
        FromPoolBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromIndexes(Predicate<MetaDataIndexBuilder> predicate) {
    if (indexes == null) {
      return (A) this;
    }
    Iterator<MetaDataIndexBuilder> each = indexes.iterator();
    List visitables = _visitables.get("indexes");
    while (each.hasNext()) {
        MetaDataIndexBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromIpAddressesFromIPPool(Predicate<FromPoolBuilder> predicate) {
    if (ipAddressesFromIPPool == null) {
      return (A) this;
    }
    Iterator<FromPoolBuilder> each = ipAddressesFromIPPool.iterator();
    List visitables = _visitables.get("ipAddressesFromIPPool");
    while (each.hasNext()) {
        FromPoolBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromNamespaces(Predicate<MetaDataNamespaceBuilder> predicate) {
    if (namespaces == null) {
      return (A) this;
    }
    Iterator<MetaDataNamespaceBuilder> each = namespaces.iterator();
    List visitables = _visitables.get("namespaces");
    while (each.hasNext()) {
        MetaDataNamespaceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromObjectNames(Predicate<MetaDataObjectNameBuilder> predicate) {
    if (objectNames == null) {
      return (A) this;
    }
    Iterator<MetaDataObjectNameBuilder> each = objectNames.iterator();
    List visitables = _visitables.get("objectNames");
    while (each.hasNext()) {
        MetaDataObjectNameBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPrefixesFromIPPool(Predicate<FromPoolBuilder> predicate) {
    if (prefixesFromIPPool == null) {
      return (A) this;
    }
    Iterator<FromPoolBuilder> each = prefixesFromIPPool.iterator();
    List visitables = _visitables.get("prefixesFromIPPool");
    while (each.hasNext()) {
        FromPoolBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromStrings(Predicate<MetaDataStringBuilder> predicate) {
    if (strings == null) {
      return (A) this;
    }
    Iterator<MetaDataStringBuilder> each = strings.iterator();
    List visitables = _visitables.get("strings");
    while (each.hasNext()) {
        MetaDataStringBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DnsServersFromIPPoolNested<A> setNewDnsServersFromIPPoolLike(int index,FromPool item) {
    return new DnsServersFromIPPoolNested(index, item);
  }
  
  public FromAnnotationsNested<A> setNewFromAnnotationLike(int index,MetaDataFromAnnotation item) {
    return new FromAnnotationsNested(index, item);
  }
  
  public FromHostInterfacesNested<A> setNewFromHostInterfaceLike(int index,MetaDataHostInterface item) {
    return new FromHostInterfacesNested(index, item);
  }
  
  public FromLabelsNested<A> setNewFromLabelLike(int index,MetaDataFromLabel item) {
    return new FromLabelsNested(index, item);
  }
  
  public GatewaysFromIPPoolNested<A> setNewGatewaysFromIPPoolLike(int index,FromPool item) {
    return new GatewaysFromIPPoolNested(index, item);
  }
  
  public IndexesNested<A> setNewIndexLike(int index,MetaDataIndex item) {
    return new IndexesNested(index, item);
  }
  
  public IpAddressesFromIPPoolNested<A> setNewIpAddressesFromIPPoolLike(int index,FromPool item) {
    return new IpAddressesFromIPPoolNested(index, item);
  }
  
  public NamespacesNested<A> setNewNamespaceLike(int index,MetaDataNamespace item) {
    return new NamespacesNested(index, item);
  }
  
  public ObjectNamesNested<A> setNewObjectNameLike(int index,MetaDataObjectName item) {
    return new ObjectNamesNested(index, item);
  }
  
  public PrefixesFromIPPoolNested<A> setNewPrefixesFromIPPoolLike(int index,FromPool item) {
    return new PrefixesFromIPPoolNested(index, item);
  }
  
  public StringsNested<A> setNewStringLike(int index,MetaDataString item) {
    return new StringsNested(index, item);
  }
  
  public A setToDnsServersFromIPPool(int index,FromPool item) {
    if (this.dnsServersFromIPPool == null) {
      this.dnsServersFromIPPool = new ArrayList();
    }
    FromPoolBuilder builder = new FromPoolBuilder(item);
    if (index < 0 || index >= dnsServersFromIPPool.size()) {
        _visitables.get("dnsServersFromIPPool").add(builder);
        dnsServersFromIPPool.add(builder);
    } else {
        _visitables.get("dnsServersFromIPPool").add(builder);
        dnsServersFromIPPool.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFromAnnotations(int index,MetaDataFromAnnotation item) {
    if (this.fromAnnotations == null) {
      this.fromAnnotations = new ArrayList();
    }
    MetaDataFromAnnotationBuilder builder = new MetaDataFromAnnotationBuilder(item);
    if (index < 0 || index >= fromAnnotations.size()) {
        _visitables.get("fromAnnotations").add(builder);
        fromAnnotations.add(builder);
    } else {
        _visitables.get("fromAnnotations").add(builder);
        fromAnnotations.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFromHostInterfaces(int index,MetaDataHostInterface item) {
    if (this.fromHostInterfaces == null) {
      this.fromHostInterfaces = new ArrayList();
    }
    MetaDataHostInterfaceBuilder builder = new MetaDataHostInterfaceBuilder(item);
    if (index < 0 || index >= fromHostInterfaces.size()) {
        _visitables.get("fromHostInterfaces").add(builder);
        fromHostInterfaces.add(builder);
    } else {
        _visitables.get("fromHostInterfaces").add(builder);
        fromHostInterfaces.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFromLabels(int index,MetaDataFromLabel item) {
    if (this.fromLabels == null) {
      this.fromLabels = new ArrayList();
    }
    MetaDataFromLabelBuilder builder = new MetaDataFromLabelBuilder(item);
    if (index < 0 || index >= fromLabels.size()) {
        _visitables.get("fromLabels").add(builder);
        fromLabels.add(builder);
    } else {
        _visitables.get("fromLabels").add(builder);
        fromLabels.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToGatewaysFromIPPool(int index,FromPool item) {
    if (this.gatewaysFromIPPool == null) {
      this.gatewaysFromIPPool = new ArrayList();
    }
    FromPoolBuilder builder = new FromPoolBuilder(item);
    if (index < 0 || index >= gatewaysFromIPPool.size()) {
        _visitables.get("gatewaysFromIPPool").add(builder);
        gatewaysFromIPPool.add(builder);
    } else {
        _visitables.get("gatewaysFromIPPool").add(builder);
        gatewaysFromIPPool.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIndexes(int index,MetaDataIndex item) {
    if (this.indexes == null) {
      this.indexes = new ArrayList();
    }
    MetaDataIndexBuilder builder = new MetaDataIndexBuilder(item);
    if (index < 0 || index >= indexes.size()) {
        _visitables.get("indexes").add(builder);
        indexes.add(builder);
    } else {
        _visitables.get("indexes").add(builder);
        indexes.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIpAddressesFromIPPool(int index,FromPool item) {
    if (this.ipAddressesFromIPPool == null) {
      this.ipAddressesFromIPPool = new ArrayList();
    }
    FromPoolBuilder builder = new FromPoolBuilder(item);
    if (index < 0 || index >= ipAddressesFromIPPool.size()) {
        _visitables.get("ipAddressesFromIPPool").add(builder);
        ipAddressesFromIPPool.add(builder);
    } else {
        _visitables.get("ipAddressesFromIPPool").add(builder);
        ipAddressesFromIPPool.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToNamespaces(int index,MetaDataNamespace item) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList();
    }
    MetaDataNamespaceBuilder builder = new MetaDataNamespaceBuilder(item);
    if (index < 0 || index >= namespaces.size()) {
        _visitables.get("namespaces").add(builder);
        namespaces.add(builder);
    } else {
        _visitables.get("namespaces").add(builder);
        namespaces.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToObjectNames(int index,MetaDataObjectName item) {
    if (this.objectNames == null) {
      this.objectNames = new ArrayList();
    }
    MetaDataObjectNameBuilder builder = new MetaDataObjectNameBuilder(item);
    if (index < 0 || index >= objectNames.size()) {
        _visitables.get("objectNames").add(builder);
        objectNames.add(builder);
    } else {
        _visitables.get("objectNames").add(builder);
        objectNames.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPrefixesFromIPPool(int index,FromPool item) {
    if (this.prefixesFromIPPool == null) {
      this.prefixesFromIPPool = new ArrayList();
    }
    FromPoolBuilder builder = new FromPoolBuilder(item);
    if (index < 0 || index >= prefixesFromIPPool.size()) {
        _visitables.get("prefixesFromIPPool").add(builder);
        prefixesFromIPPool.add(builder);
    } else {
        _visitables.get("prefixesFromIPPool").add(builder);
        prefixesFromIPPool.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToStrings(int index,MetaDataString item) {
    if (this.strings == null) {
      this.strings = new ArrayList();
    }
    MetaDataStringBuilder builder = new MetaDataStringBuilder(item);
    if (index < 0 || index >= strings.size()) {
        _visitables.get("strings").add(builder);
        strings.add(builder);
    } else {
        _visitables.get("strings").add(builder);
        strings.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dnsServersFromIPPool == null) && !(dnsServersFromIPPool.isEmpty())) {
        sb.append("dnsServersFromIPPool:");
        sb.append(dnsServersFromIPPool);
        sb.append(",");
    }
    if (!(fromAnnotations == null) && !(fromAnnotations.isEmpty())) {
        sb.append("fromAnnotations:");
        sb.append(fromAnnotations);
        sb.append(",");
    }
    if (!(fromHostInterfaces == null) && !(fromHostInterfaces.isEmpty())) {
        sb.append("fromHostInterfaces:");
        sb.append(fromHostInterfaces);
        sb.append(",");
    }
    if (!(fromLabels == null) && !(fromLabels.isEmpty())) {
        sb.append("fromLabels:");
        sb.append(fromLabels);
        sb.append(",");
    }
    if (!(gatewaysFromIPPool == null) && !(gatewaysFromIPPool.isEmpty())) {
        sb.append("gatewaysFromIPPool:");
        sb.append(gatewaysFromIPPool);
        sb.append(",");
    }
    if (!(indexes == null) && !(indexes.isEmpty())) {
        sb.append("indexes:");
        sb.append(indexes);
        sb.append(",");
    }
    if (!(ipAddressesFromIPPool == null) && !(ipAddressesFromIPPool.isEmpty())) {
        sb.append("ipAddressesFromIPPool:");
        sb.append(ipAddressesFromIPPool);
        sb.append(",");
    }
    if (!(namespaces == null) && !(namespaces.isEmpty())) {
        sb.append("namespaces:");
        sb.append(namespaces);
        sb.append(",");
    }
    if (!(objectNames == null) && !(objectNames.isEmpty())) {
        sb.append("objectNames:");
        sb.append(objectNames);
        sb.append(",");
    }
    if (!(prefixesFromIPPool == null) && !(prefixesFromIPPool.isEmpty())) {
        sb.append("prefixesFromIPPool:");
        sb.append(prefixesFromIPPool);
        sb.append(",");
    }
    if (!(strings == null) && !(strings.isEmpty())) {
        sb.append("strings:");
        sb.append(strings);
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
  
  public A withDnsServersFromIPPool(List<FromPool> dnsServersFromIPPool) {
    if (this.dnsServersFromIPPool != null) {
      this._visitables.get("dnsServersFromIPPool").clear();
    }
    if (dnsServersFromIPPool != null) {
        this.dnsServersFromIPPool = new ArrayList();
        for (FromPool item : dnsServersFromIPPool) {
          this.addToDnsServersFromIPPool(item);
        }
    } else {
      this.dnsServersFromIPPool = null;
    }
    return (A) this;
  }
  
  public A withDnsServersFromIPPool(FromPool... dnsServersFromIPPool) {
    if (this.dnsServersFromIPPool != null) {
        this.dnsServersFromIPPool.clear();
        _visitables.remove("dnsServersFromIPPool");
    }
    if (dnsServersFromIPPool != null) {
      for (FromPool item : dnsServersFromIPPool) {
        this.addToDnsServersFromIPPool(item);
      }
    }
    return (A) this;
  }
  
  public A withFromAnnotations(List<MetaDataFromAnnotation> fromAnnotations) {
    if (this.fromAnnotations != null) {
      this._visitables.get("fromAnnotations").clear();
    }
    if (fromAnnotations != null) {
        this.fromAnnotations = new ArrayList();
        for (MetaDataFromAnnotation item : fromAnnotations) {
          this.addToFromAnnotations(item);
        }
    } else {
      this.fromAnnotations = null;
    }
    return (A) this;
  }
  
  public A withFromAnnotations(MetaDataFromAnnotation... fromAnnotations) {
    if (this.fromAnnotations != null) {
        this.fromAnnotations.clear();
        _visitables.remove("fromAnnotations");
    }
    if (fromAnnotations != null) {
      for (MetaDataFromAnnotation item : fromAnnotations) {
        this.addToFromAnnotations(item);
      }
    }
    return (A) this;
  }
  
  public A withFromHostInterfaces(List<MetaDataHostInterface> fromHostInterfaces) {
    if (this.fromHostInterfaces != null) {
      this._visitables.get("fromHostInterfaces").clear();
    }
    if (fromHostInterfaces != null) {
        this.fromHostInterfaces = new ArrayList();
        for (MetaDataHostInterface item : fromHostInterfaces) {
          this.addToFromHostInterfaces(item);
        }
    } else {
      this.fromHostInterfaces = null;
    }
    return (A) this;
  }
  
  public A withFromHostInterfaces(MetaDataHostInterface... fromHostInterfaces) {
    if (this.fromHostInterfaces != null) {
        this.fromHostInterfaces.clear();
        _visitables.remove("fromHostInterfaces");
    }
    if (fromHostInterfaces != null) {
      for (MetaDataHostInterface item : fromHostInterfaces) {
        this.addToFromHostInterfaces(item);
      }
    }
    return (A) this;
  }
  
  public A withFromLabels(List<MetaDataFromLabel> fromLabels) {
    if (this.fromLabels != null) {
      this._visitables.get("fromLabels").clear();
    }
    if (fromLabels != null) {
        this.fromLabels = new ArrayList();
        for (MetaDataFromLabel item : fromLabels) {
          this.addToFromLabels(item);
        }
    } else {
      this.fromLabels = null;
    }
    return (A) this;
  }
  
  public A withFromLabels(MetaDataFromLabel... fromLabels) {
    if (this.fromLabels != null) {
        this.fromLabels.clear();
        _visitables.remove("fromLabels");
    }
    if (fromLabels != null) {
      for (MetaDataFromLabel item : fromLabels) {
        this.addToFromLabels(item);
      }
    }
    return (A) this;
  }
  
  public A withGatewaysFromIPPool(List<FromPool> gatewaysFromIPPool) {
    if (this.gatewaysFromIPPool != null) {
      this._visitables.get("gatewaysFromIPPool").clear();
    }
    if (gatewaysFromIPPool != null) {
        this.gatewaysFromIPPool = new ArrayList();
        for (FromPool item : gatewaysFromIPPool) {
          this.addToGatewaysFromIPPool(item);
        }
    } else {
      this.gatewaysFromIPPool = null;
    }
    return (A) this;
  }
  
  public A withGatewaysFromIPPool(FromPool... gatewaysFromIPPool) {
    if (this.gatewaysFromIPPool != null) {
        this.gatewaysFromIPPool.clear();
        _visitables.remove("gatewaysFromIPPool");
    }
    if (gatewaysFromIPPool != null) {
      for (FromPool item : gatewaysFromIPPool) {
        this.addToGatewaysFromIPPool(item);
      }
    }
    return (A) this;
  }
  
  public A withIndexes(List<MetaDataIndex> indexes) {
    if (this.indexes != null) {
      this._visitables.get("indexes").clear();
    }
    if (indexes != null) {
        this.indexes = new ArrayList();
        for (MetaDataIndex item : indexes) {
          this.addToIndexes(item);
        }
    } else {
      this.indexes = null;
    }
    return (A) this;
  }
  
  public A withIndexes(MetaDataIndex... indexes) {
    if (this.indexes != null) {
        this.indexes.clear();
        _visitables.remove("indexes");
    }
    if (indexes != null) {
      for (MetaDataIndex item : indexes) {
        this.addToIndexes(item);
      }
    }
    return (A) this;
  }
  
  public A withIpAddressesFromIPPool(List<FromPool> ipAddressesFromIPPool) {
    if (this.ipAddressesFromIPPool != null) {
      this._visitables.get("ipAddressesFromIPPool").clear();
    }
    if (ipAddressesFromIPPool != null) {
        this.ipAddressesFromIPPool = new ArrayList();
        for (FromPool item : ipAddressesFromIPPool) {
          this.addToIpAddressesFromIPPool(item);
        }
    } else {
      this.ipAddressesFromIPPool = null;
    }
    return (A) this;
  }
  
  public A withIpAddressesFromIPPool(FromPool... ipAddressesFromIPPool) {
    if (this.ipAddressesFromIPPool != null) {
        this.ipAddressesFromIPPool.clear();
        _visitables.remove("ipAddressesFromIPPool");
    }
    if (ipAddressesFromIPPool != null) {
      for (FromPool item : ipAddressesFromIPPool) {
        this.addToIpAddressesFromIPPool(item);
      }
    }
    return (A) this;
  }
  
  public A withNamespaces(List<MetaDataNamespace> namespaces) {
    if (this.namespaces != null) {
      this._visitables.get("namespaces").clear();
    }
    if (namespaces != null) {
        this.namespaces = new ArrayList();
        for (MetaDataNamespace item : namespaces) {
          this.addToNamespaces(item);
        }
    } else {
      this.namespaces = null;
    }
    return (A) this;
  }
  
  public A withNamespaces(MetaDataNamespace... namespaces) {
    if (this.namespaces != null) {
        this.namespaces.clear();
        _visitables.remove("namespaces");
    }
    if (namespaces != null) {
      for (MetaDataNamespace item : namespaces) {
        this.addToNamespaces(item);
      }
    }
    return (A) this;
  }
  
  public A withObjectNames(List<MetaDataObjectName> objectNames) {
    if (this.objectNames != null) {
      this._visitables.get("objectNames").clear();
    }
    if (objectNames != null) {
        this.objectNames = new ArrayList();
        for (MetaDataObjectName item : objectNames) {
          this.addToObjectNames(item);
        }
    } else {
      this.objectNames = null;
    }
    return (A) this;
  }
  
  public A withObjectNames(MetaDataObjectName... objectNames) {
    if (this.objectNames != null) {
        this.objectNames.clear();
        _visitables.remove("objectNames");
    }
    if (objectNames != null) {
      for (MetaDataObjectName item : objectNames) {
        this.addToObjectNames(item);
      }
    }
    return (A) this;
  }
  
  public A withPrefixesFromIPPool(List<FromPool> prefixesFromIPPool) {
    if (this.prefixesFromIPPool != null) {
      this._visitables.get("prefixesFromIPPool").clear();
    }
    if (prefixesFromIPPool != null) {
        this.prefixesFromIPPool = new ArrayList();
        for (FromPool item : prefixesFromIPPool) {
          this.addToPrefixesFromIPPool(item);
        }
    } else {
      this.prefixesFromIPPool = null;
    }
    return (A) this;
  }
  
  public A withPrefixesFromIPPool(FromPool... prefixesFromIPPool) {
    if (this.prefixesFromIPPool != null) {
        this.prefixesFromIPPool.clear();
        _visitables.remove("prefixesFromIPPool");
    }
    if (prefixesFromIPPool != null) {
      for (FromPool item : prefixesFromIPPool) {
        this.addToPrefixesFromIPPool(item);
      }
    }
    return (A) this;
  }
  
  public A withStrings(List<MetaDataString> strings) {
    if (this.strings != null) {
      this._visitables.get("strings").clear();
    }
    if (strings != null) {
        this.strings = new ArrayList();
        for (MetaDataString item : strings) {
          this.addToStrings(item);
        }
    } else {
      this.strings = null;
    }
    return (A) this;
  }
  
  public A withStrings(MetaDataString... strings) {
    if (this.strings != null) {
        this.strings.clear();
        _visitables.remove("strings");
    }
    if (strings != null) {
      for (MetaDataString item : strings) {
        this.addToStrings(item);
      }
    }
    return (A) this;
  }
  public class DnsServersFromIPPoolNested<N> extends FromPoolFluent<DnsServersFromIPPoolNested<N>> implements Nested<N>{
  
    FromPoolBuilder builder;
    int index;
  
    DnsServersFromIPPoolNested(int index,FromPool item) {
      this.index = index;
      this.builder = new FromPoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MetaDataFluent.this.setToDnsServersFromIPPool(index, builder.build());
    }
    
    public N endDnsServersFromIPPool() {
      return and();
    }
    
  }
  public class FromAnnotationsNested<N> extends MetaDataFromAnnotationFluent<FromAnnotationsNested<N>> implements Nested<N>{
  
    MetaDataFromAnnotationBuilder builder;
    int index;
  
    FromAnnotationsNested(int index,MetaDataFromAnnotation item) {
      this.index = index;
      this.builder = new MetaDataFromAnnotationBuilder(this, item);
    }
  
    public N and() {
      return (N) MetaDataFluent.this.setToFromAnnotations(index, builder.build());
    }
    
    public N endFromAnnotation() {
      return and();
    }
    
  }
  public class FromHostInterfacesNested<N> extends MetaDataHostInterfaceFluent<FromHostInterfacesNested<N>> implements Nested<N>{
  
    MetaDataHostInterfaceBuilder builder;
    int index;
  
    FromHostInterfacesNested(int index,MetaDataHostInterface item) {
      this.index = index;
      this.builder = new MetaDataHostInterfaceBuilder(this, item);
    }
  
    public N and() {
      return (N) MetaDataFluent.this.setToFromHostInterfaces(index, builder.build());
    }
    
    public N endFromHostInterface() {
      return and();
    }
    
  }
  public class FromLabelsNested<N> extends MetaDataFromLabelFluent<FromLabelsNested<N>> implements Nested<N>{
  
    MetaDataFromLabelBuilder builder;
    int index;
  
    FromLabelsNested(int index,MetaDataFromLabel item) {
      this.index = index;
      this.builder = new MetaDataFromLabelBuilder(this, item);
    }
  
    public N and() {
      return (N) MetaDataFluent.this.setToFromLabels(index, builder.build());
    }
    
    public N endFromLabel() {
      return and();
    }
    
  }
  public class GatewaysFromIPPoolNested<N> extends FromPoolFluent<GatewaysFromIPPoolNested<N>> implements Nested<N>{
  
    FromPoolBuilder builder;
    int index;
  
    GatewaysFromIPPoolNested(int index,FromPool item) {
      this.index = index;
      this.builder = new FromPoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MetaDataFluent.this.setToGatewaysFromIPPool(index, builder.build());
    }
    
    public N endGatewaysFromIPPool() {
      return and();
    }
    
  }
  public class IndexesNested<N> extends MetaDataIndexFluent<IndexesNested<N>> implements Nested<N>{
  
    MetaDataIndexBuilder builder;
    int index;
  
    IndexesNested(int index,MetaDataIndex item) {
      this.index = index;
      this.builder = new MetaDataIndexBuilder(this, item);
    }
  
    public N and() {
      return (N) MetaDataFluent.this.setToIndexes(index, builder.build());
    }
    
    public N endIndex() {
      return and();
    }
    
  }
  public class IpAddressesFromIPPoolNested<N> extends FromPoolFluent<IpAddressesFromIPPoolNested<N>> implements Nested<N>{
  
    FromPoolBuilder builder;
    int index;
  
    IpAddressesFromIPPoolNested(int index,FromPool item) {
      this.index = index;
      this.builder = new FromPoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MetaDataFluent.this.setToIpAddressesFromIPPool(index, builder.build());
    }
    
    public N endIpAddressesFromIPPool() {
      return and();
    }
    
  }
  public class NamespacesNested<N> extends MetaDataNamespaceFluent<NamespacesNested<N>> implements Nested<N>{
  
    MetaDataNamespaceBuilder builder;
    int index;
  
    NamespacesNested(int index,MetaDataNamespace item) {
      this.index = index;
      this.builder = new MetaDataNamespaceBuilder(this, item);
    }
  
    public N and() {
      return (N) MetaDataFluent.this.setToNamespaces(index, builder.build());
    }
    
    public N endNamespace() {
      return and();
    }
    
  }
  public class ObjectNamesNested<N> extends MetaDataObjectNameFluent<ObjectNamesNested<N>> implements Nested<N>{
  
    MetaDataObjectNameBuilder builder;
    int index;
  
    ObjectNamesNested(int index,MetaDataObjectName item) {
      this.index = index;
      this.builder = new MetaDataObjectNameBuilder(this, item);
    }
  
    public N and() {
      return (N) MetaDataFluent.this.setToObjectNames(index, builder.build());
    }
    
    public N endObjectName() {
      return and();
    }
    
  }
  public class PrefixesFromIPPoolNested<N> extends FromPoolFluent<PrefixesFromIPPoolNested<N>> implements Nested<N>{
  
    FromPoolBuilder builder;
    int index;
  
    PrefixesFromIPPoolNested(int index,FromPool item) {
      this.index = index;
      this.builder = new FromPoolBuilder(this, item);
    }
  
    public N and() {
      return (N) MetaDataFluent.this.setToPrefixesFromIPPool(index, builder.build());
    }
    
    public N endPrefixesFromIPPool() {
      return and();
    }
    
  }
  public class StringsNested<N> extends MetaDataStringFluent<StringsNested<N>> implements Nested<N>{
  
    MetaDataStringBuilder builder;
    int index;
  
    StringsNested(int index,MetaDataString item) {
      this.index = index;
      this.builder = new MetaDataStringBuilder(this, item);
    }
  
    public N and() {
      return (N) MetaDataFluent.this.setToStrings(index, builder.build());
    }
    
    public N endString() {
      return and();
    }
    
  }
}