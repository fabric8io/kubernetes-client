package io.fabric8.openclustermanagement.api.model.agent.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class KlusterletAddonConfigSpecFluent<A extends io.fabric8.openclustermanagement.api.model.agent.v1.KlusterletAddonConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private KlusterletAddonAgentConfigSpecBuilder applicationManager;
  private KlusterletAddonAgentConfigSpecBuilder certPolicyController;
  private Map<String,String> clusterLabels;
  private String clusterName;
  private String clusterNamespace;
  private KlusterletAddonAgentConfigSpecBuilder iamPolicyController;
  private KlusterletAddonAgentConfigSpecBuilder policyController;
  private ProxyConfigBuilder proxyConfig;
  private KlusterletAddonAgentConfigSpecBuilder searchCollector;
  private String version;

  public KlusterletAddonConfigSpecFluent() {
  }
  
  public KlusterletAddonConfigSpecFluent(KlusterletAddonConfigSpec instance) {
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
  
  public A addToClusterLabels(Map<String,String> map) {
    if (this.clusterLabels == null && map != null) {
      this.clusterLabels = new LinkedHashMap();
    }
    if (map != null) {
      this.clusterLabels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToClusterLabels(String key,String value) {
    if (this.clusterLabels == null && key != null && value != null) {
      this.clusterLabels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.clusterLabels.put(key, value);
    }
    return (A) this;
  }
  
  public KlusterletAddonAgentConfigSpec buildApplicationManager() {
    return this.applicationManager != null ? this.applicationManager.build() : null;
  }
  
  public KlusterletAddonAgentConfigSpec buildCertPolicyController() {
    return this.certPolicyController != null ? this.certPolicyController.build() : null;
  }
  
  public KlusterletAddonAgentConfigSpec buildIamPolicyController() {
    return this.iamPolicyController != null ? this.iamPolicyController.build() : null;
  }
  
  public KlusterletAddonAgentConfigSpec buildPolicyController() {
    return this.policyController != null ? this.policyController.build() : null;
  }
  
  public ProxyConfig buildProxyConfig() {
    return this.proxyConfig != null ? this.proxyConfig.build() : null;
  }
  
  public KlusterletAddonAgentConfigSpec buildSearchCollector() {
    return this.searchCollector != null ? this.searchCollector.build() : null;
  }
  
  protected void copyInstance(KlusterletAddonConfigSpec instance) {
    instance = instance != null ? instance : new KlusterletAddonConfigSpec();
    if (instance != null) {
        this.withApplicationManager(instance.getApplicationManager());
        this.withCertPolicyController(instance.getCertPolicyController());
        this.withClusterLabels(instance.getClusterLabels());
        this.withClusterName(instance.getClusterName());
        this.withClusterNamespace(instance.getClusterNamespace());
        this.withIamPolicyController(instance.getIamPolicyController());
        this.withPolicyController(instance.getPolicyController());
        this.withProxyConfig(instance.getProxyConfig());
        this.withSearchCollector(instance.getSearchCollector());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ApplicationManagerNested<A> editApplicationManager() {
    return this.withNewApplicationManagerLike(Optional.ofNullable(this.buildApplicationManager()).orElse(null));
  }
  
  public CertPolicyControllerNested<A> editCertPolicyController() {
    return this.withNewCertPolicyControllerLike(Optional.ofNullable(this.buildCertPolicyController()).orElse(null));
  }
  
  public IamPolicyControllerNested<A> editIamPolicyController() {
    return this.withNewIamPolicyControllerLike(Optional.ofNullable(this.buildIamPolicyController()).orElse(null));
  }
  
  public ApplicationManagerNested<A> editOrNewApplicationManager() {
    return this.withNewApplicationManagerLike(Optional.ofNullable(this.buildApplicationManager()).orElse(new KlusterletAddonAgentConfigSpecBuilder().build()));
  }
  
  public ApplicationManagerNested<A> editOrNewApplicationManagerLike(KlusterletAddonAgentConfigSpec item) {
    return this.withNewApplicationManagerLike(Optional.ofNullable(this.buildApplicationManager()).orElse(item));
  }
  
  public CertPolicyControllerNested<A> editOrNewCertPolicyController() {
    return this.withNewCertPolicyControllerLike(Optional.ofNullable(this.buildCertPolicyController()).orElse(new KlusterletAddonAgentConfigSpecBuilder().build()));
  }
  
  public CertPolicyControllerNested<A> editOrNewCertPolicyControllerLike(KlusterletAddonAgentConfigSpec item) {
    return this.withNewCertPolicyControllerLike(Optional.ofNullable(this.buildCertPolicyController()).orElse(item));
  }
  
  public IamPolicyControllerNested<A> editOrNewIamPolicyController() {
    return this.withNewIamPolicyControllerLike(Optional.ofNullable(this.buildIamPolicyController()).orElse(new KlusterletAddonAgentConfigSpecBuilder().build()));
  }
  
  public IamPolicyControllerNested<A> editOrNewIamPolicyControllerLike(KlusterletAddonAgentConfigSpec item) {
    return this.withNewIamPolicyControllerLike(Optional.ofNullable(this.buildIamPolicyController()).orElse(item));
  }
  
  public PolicyControllerNested<A> editOrNewPolicyController() {
    return this.withNewPolicyControllerLike(Optional.ofNullable(this.buildPolicyController()).orElse(new KlusterletAddonAgentConfigSpecBuilder().build()));
  }
  
  public PolicyControllerNested<A> editOrNewPolicyControllerLike(KlusterletAddonAgentConfigSpec item) {
    return this.withNewPolicyControllerLike(Optional.ofNullable(this.buildPolicyController()).orElse(item));
  }
  
  public ProxyConfigNested<A> editOrNewProxyConfig() {
    return this.withNewProxyConfigLike(Optional.ofNullable(this.buildProxyConfig()).orElse(new ProxyConfigBuilder().build()));
  }
  
  public ProxyConfigNested<A> editOrNewProxyConfigLike(ProxyConfig item) {
    return this.withNewProxyConfigLike(Optional.ofNullable(this.buildProxyConfig()).orElse(item));
  }
  
  public SearchCollectorNested<A> editOrNewSearchCollector() {
    return this.withNewSearchCollectorLike(Optional.ofNullable(this.buildSearchCollector()).orElse(new KlusterletAddonAgentConfigSpecBuilder().build()));
  }
  
  public SearchCollectorNested<A> editOrNewSearchCollectorLike(KlusterletAddonAgentConfigSpec item) {
    return this.withNewSearchCollectorLike(Optional.ofNullable(this.buildSearchCollector()).orElse(item));
  }
  
  public PolicyControllerNested<A> editPolicyController() {
    return this.withNewPolicyControllerLike(Optional.ofNullable(this.buildPolicyController()).orElse(null));
  }
  
  public ProxyConfigNested<A> editProxyConfig() {
    return this.withNewProxyConfigLike(Optional.ofNullable(this.buildProxyConfig()).orElse(null));
  }
  
  public SearchCollectorNested<A> editSearchCollector() {
    return this.withNewSearchCollectorLike(Optional.ofNullable(this.buildSearchCollector()).orElse(null));
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
    KlusterletAddonConfigSpecFluent that = (KlusterletAddonConfigSpecFluent) o;
    if (!(Objects.equals(applicationManager, that.applicationManager))) {
      return false;
    }
    if (!(Objects.equals(certPolicyController, that.certPolicyController))) {
      return false;
    }
    if (!(Objects.equals(clusterLabels, that.clusterLabels))) {
      return false;
    }
    if (!(Objects.equals(clusterName, that.clusterName))) {
      return false;
    }
    if (!(Objects.equals(clusterNamespace, that.clusterNamespace))) {
      return false;
    }
    if (!(Objects.equals(iamPolicyController, that.iamPolicyController))) {
      return false;
    }
    if (!(Objects.equals(policyController, that.policyController))) {
      return false;
    }
    if (!(Objects.equals(proxyConfig, that.proxyConfig))) {
      return false;
    }
    if (!(Objects.equals(searchCollector, that.searchCollector))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public Map<String,String> getClusterLabels() {
    return this.clusterLabels;
  }
  
  public String getClusterName() {
    return this.clusterName;
  }
  
  public String getClusterNamespace() {
    return this.clusterNamespace;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApplicationManager() {
    return this.applicationManager != null;
  }
  
  public boolean hasCertPolicyController() {
    return this.certPolicyController != null;
  }
  
  public boolean hasClusterLabels() {
    return this.clusterLabels != null;
  }
  
  public boolean hasClusterName() {
    return this.clusterName != null;
  }
  
  public boolean hasClusterNamespace() {
    return this.clusterNamespace != null;
  }
  
  public boolean hasIamPolicyController() {
    return this.iamPolicyController != null;
  }
  
  public boolean hasPolicyController() {
    return this.policyController != null;
  }
  
  public boolean hasProxyConfig() {
    return this.proxyConfig != null;
  }
  
  public boolean hasSearchCollector() {
    return this.searchCollector != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(applicationManager, certPolicyController, clusterLabels, clusterName, clusterNamespace, iamPolicyController, policyController, proxyConfig, searchCollector, version, additionalProperties);
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
  
  public A removeFromClusterLabels(String key) {
    if (this.clusterLabels == null) {
      return (A) this;
    }
    if (key != null && this.clusterLabels != null) {
      this.clusterLabels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromClusterLabels(Map<String,String> map) {
    if (this.clusterLabels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.clusterLabels != null) {
          this.clusterLabels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(applicationManager == null)) {
        sb.append("applicationManager:");
        sb.append(applicationManager);
        sb.append(",");
    }
    if (!(certPolicyController == null)) {
        sb.append("certPolicyController:");
        sb.append(certPolicyController);
        sb.append(",");
    }
    if (!(clusterLabels == null) && !(clusterLabels.isEmpty())) {
        sb.append("clusterLabels:");
        sb.append(clusterLabels);
        sb.append(",");
    }
    if (!(clusterName == null)) {
        sb.append("clusterName:");
        sb.append(clusterName);
        sb.append(",");
    }
    if (!(clusterNamespace == null)) {
        sb.append("clusterNamespace:");
        sb.append(clusterNamespace);
        sb.append(",");
    }
    if (!(iamPolicyController == null)) {
        sb.append("iamPolicyController:");
        sb.append(iamPolicyController);
        sb.append(",");
    }
    if (!(policyController == null)) {
        sb.append("policyController:");
        sb.append(policyController);
        sb.append(",");
    }
    if (!(proxyConfig == null)) {
        sb.append("proxyConfig:");
        sb.append(proxyConfig);
        sb.append(",");
    }
    if (!(searchCollector == null)) {
        sb.append("searchCollector:");
        sb.append(searchCollector);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withApplicationManager(KlusterletAddonAgentConfigSpec applicationManager) {
    this._visitables.remove("applicationManager");
    if (applicationManager != null) {
        this.applicationManager = new KlusterletAddonAgentConfigSpecBuilder(applicationManager);
        this._visitables.get("applicationManager").add(this.applicationManager);
    } else {
        this.applicationManager = null;
        this._visitables.get("applicationManager").remove(this.applicationManager);
    }
    return (A) this;
  }
  
  public A withCertPolicyController(KlusterletAddonAgentConfigSpec certPolicyController) {
    this._visitables.remove("certPolicyController");
    if (certPolicyController != null) {
        this.certPolicyController = new KlusterletAddonAgentConfigSpecBuilder(certPolicyController);
        this._visitables.get("certPolicyController").add(this.certPolicyController);
    } else {
        this.certPolicyController = null;
        this._visitables.get("certPolicyController").remove(this.certPolicyController);
    }
    return (A) this;
  }
  
  public <K,V>A withClusterLabels(Map<String,String> clusterLabels) {
    if (clusterLabels == null) {
      this.clusterLabels = null;
    } else {
      this.clusterLabels = new LinkedHashMap(clusterLabels);
    }
    return (A) this;
  }
  
  public A withClusterName(String clusterName) {
    this.clusterName = clusterName;
    return (A) this;
  }
  
  public A withClusterNamespace(String clusterNamespace) {
    this.clusterNamespace = clusterNamespace;
    return (A) this;
  }
  
  public A withIamPolicyController(KlusterletAddonAgentConfigSpec iamPolicyController) {
    this._visitables.remove("iamPolicyController");
    if (iamPolicyController != null) {
        this.iamPolicyController = new KlusterletAddonAgentConfigSpecBuilder(iamPolicyController);
        this._visitables.get("iamPolicyController").add(this.iamPolicyController);
    } else {
        this.iamPolicyController = null;
        this._visitables.get("iamPolicyController").remove(this.iamPolicyController);
    }
    return (A) this;
  }
  
  public ApplicationManagerNested<A> withNewApplicationManager() {
    return new ApplicationManagerNested(null);
  }
  
  public A withNewApplicationManager(Boolean enabled,String proxyPolicy) {
    return (A) this.withApplicationManager(new KlusterletAddonAgentConfigSpec(enabled, proxyPolicy));
  }
  
  public ApplicationManagerNested<A> withNewApplicationManagerLike(KlusterletAddonAgentConfigSpec item) {
    return new ApplicationManagerNested(item);
  }
  
  public CertPolicyControllerNested<A> withNewCertPolicyController() {
    return new CertPolicyControllerNested(null);
  }
  
  public A withNewCertPolicyController(Boolean enabled,String proxyPolicy) {
    return (A) this.withCertPolicyController(new KlusterletAddonAgentConfigSpec(enabled, proxyPolicy));
  }
  
  public CertPolicyControllerNested<A> withNewCertPolicyControllerLike(KlusterletAddonAgentConfigSpec item) {
    return new CertPolicyControllerNested(item);
  }
  
  public IamPolicyControllerNested<A> withNewIamPolicyController() {
    return new IamPolicyControllerNested(null);
  }
  
  public A withNewIamPolicyController(Boolean enabled,String proxyPolicy) {
    return (A) this.withIamPolicyController(new KlusterletAddonAgentConfigSpec(enabled, proxyPolicy));
  }
  
  public IamPolicyControllerNested<A> withNewIamPolicyControllerLike(KlusterletAddonAgentConfigSpec item) {
    return new IamPolicyControllerNested(item);
  }
  
  public PolicyControllerNested<A> withNewPolicyController() {
    return new PolicyControllerNested(null);
  }
  
  public A withNewPolicyController(Boolean enabled,String proxyPolicy) {
    return (A) this.withPolicyController(new KlusterletAddonAgentConfigSpec(enabled, proxyPolicy));
  }
  
  public PolicyControllerNested<A> withNewPolicyControllerLike(KlusterletAddonAgentConfigSpec item) {
    return new PolicyControllerNested(item);
  }
  
  public ProxyConfigNested<A> withNewProxyConfig() {
    return new ProxyConfigNested(null);
  }
  
  public A withNewProxyConfig(String httpProxy,String httpsProxy,String noProxy) {
    return (A) this.withProxyConfig(new ProxyConfig(httpProxy, httpsProxy, noProxy));
  }
  
  public ProxyConfigNested<A> withNewProxyConfigLike(ProxyConfig item) {
    return new ProxyConfigNested(item);
  }
  
  public SearchCollectorNested<A> withNewSearchCollector() {
    return new SearchCollectorNested(null);
  }
  
  public A withNewSearchCollector(Boolean enabled,String proxyPolicy) {
    return (A) this.withSearchCollector(new KlusterletAddonAgentConfigSpec(enabled, proxyPolicy));
  }
  
  public SearchCollectorNested<A> withNewSearchCollectorLike(KlusterletAddonAgentConfigSpec item) {
    return new SearchCollectorNested(item);
  }
  
  public A withPolicyController(KlusterletAddonAgentConfigSpec policyController) {
    this._visitables.remove("policyController");
    if (policyController != null) {
        this.policyController = new KlusterletAddonAgentConfigSpecBuilder(policyController);
        this._visitables.get("policyController").add(this.policyController);
    } else {
        this.policyController = null;
        this._visitables.get("policyController").remove(this.policyController);
    }
    return (A) this;
  }
  
  public A withProxyConfig(ProxyConfig proxyConfig) {
    this._visitables.remove("proxyConfig");
    if (proxyConfig != null) {
        this.proxyConfig = new ProxyConfigBuilder(proxyConfig);
        this._visitables.get("proxyConfig").add(this.proxyConfig);
    } else {
        this.proxyConfig = null;
        this._visitables.get("proxyConfig").remove(this.proxyConfig);
    }
    return (A) this;
  }
  
  public A withSearchCollector(KlusterletAddonAgentConfigSpec searchCollector) {
    this._visitables.remove("searchCollector");
    if (searchCollector != null) {
        this.searchCollector = new KlusterletAddonAgentConfigSpecBuilder(searchCollector);
        this._visitables.get("searchCollector").add(this.searchCollector);
    } else {
        this.searchCollector = null;
        this._visitables.get("searchCollector").remove(this.searchCollector);
    }
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class ApplicationManagerNested<N> extends KlusterletAddonAgentConfigSpecFluent<ApplicationManagerNested<N>> implements Nested<N>{
  
    KlusterletAddonAgentConfigSpecBuilder builder;
  
    ApplicationManagerNested(KlusterletAddonAgentConfigSpec item) {
      this.builder = new KlusterletAddonAgentConfigSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletAddonConfigSpecFluent.this.withApplicationManager(builder.build());
    }
    
    public N endApplicationManager() {
      return and();
    }
    
  }
  public class CertPolicyControllerNested<N> extends KlusterletAddonAgentConfigSpecFluent<CertPolicyControllerNested<N>> implements Nested<N>{
  
    KlusterletAddonAgentConfigSpecBuilder builder;
  
    CertPolicyControllerNested(KlusterletAddonAgentConfigSpec item) {
      this.builder = new KlusterletAddonAgentConfigSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletAddonConfigSpecFluent.this.withCertPolicyController(builder.build());
    }
    
    public N endCertPolicyController() {
      return and();
    }
    
  }
  public class IamPolicyControllerNested<N> extends KlusterletAddonAgentConfigSpecFluent<IamPolicyControllerNested<N>> implements Nested<N>{
  
    KlusterletAddonAgentConfigSpecBuilder builder;
  
    IamPolicyControllerNested(KlusterletAddonAgentConfigSpec item) {
      this.builder = new KlusterletAddonAgentConfigSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletAddonConfigSpecFluent.this.withIamPolicyController(builder.build());
    }
    
    public N endIamPolicyController() {
      return and();
    }
    
  }
  public class PolicyControllerNested<N> extends KlusterletAddonAgentConfigSpecFluent<PolicyControllerNested<N>> implements Nested<N>{
  
    KlusterletAddonAgentConfigSpecBuilder builder;
  
    PolicyControllerNested(KlusterletAddonAgentConfigSpec item) {
      this.builder = new KlusterletAddonAgentConfigSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletAddonConfigSpecFluent.this.withPolicyController(builder.build());
    }
    
    public N endPolicyController() {
      return and();
    }
    
  }
  public class ProxyConfigNested<N> extends ProxyConfigFluent<ProxyConfigNested<N>> implements Nested<N>{
  
    ProxyConfigBuilder builder;
  
    ProxyConfigNested(ProxyConfig item) {
      this.builder = new ProxyConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletAddonConfigSpecFluent.this.withProxyConfig(builder.build());
    }
    
    public N endProxyConfig() {
      return and();
    }
    
  }
  public class SearchCollectorNested<N> extends KlusterletAddonAgentConfigSpecFluent<SearchCollectorNested<N>> implements Nested<N>{
  
    KlusterletAddonAgentConfigSpecBuilder builder;
  
    SearchCollectorNested(KlusterletAddonAgentConfigSpec item) {
      this.builder = new KlusterletAddonAgentConfigSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletAddonConfigSpecFluent.this.withSearchCollector(builder.build());
    }
    
    public N endSearchCollector() {
      return and();
    }
    
  }
}