package io.fabric8.openclustermanagement.api.model.operator.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class KlusterletSpecFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.KlusterletSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clusterName;
  private KlusterletDeployOptionBuilder deployOption;
  private ArrayList<ServerURLBuilder> externalServerURLs = new ArrayList<ServerURLBuilder>();
  private HubApiServerHostAliasBuilder hubApiServerHostAlias;
  private String imagePullSpec;
  private String namespace;
  private NodePlacementBuilder nodePlacement;
  private String priorityClassName;
  private RegistrationConfigurationBuilder registrationConfiguration;
  private String registrationImagePullSpec;
  private ResourceRequirementBuilder resourceRequirement;
  private WorkAgentConfigurationBuilder workConfiguration;
  private String workImagePullSpec;

  public KlusterletSpecFluent() {
  }
  
  public KlusterletSpecFluent(KlusterletSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToExternalServerURLs(Collection<ServerURL> items) {
    if (this.externalServerURLs == null) {
      this.externalServerURLs = new ArrayList();
    }
    for (ServerURL item : items) {
        ServerURLBuilder builder = new ServerURLBuilder(item);
        _visitables.get("externalServerURLs").add(builder);
        this.externalServerURLs.add(builder);
    }
    return (A) this;
  }
  
  public ExternalServerURLsNested<A> addNewExternalServerURL() {
    return new ExternalServerURLsNested(-1, null);
  }
  
  public A addNewExternalServerURL(String caBundle,String url) {
    return (A) this.addToExternalServerURLs(new ServerURL(caBundle, url));
  }
  
  public ExternalServerURLsNested<A> addNewExternalServerURLLike(ServerURL item) {
    return new ExternalServerURLsNested(-1, item);
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
  
  public A addToExternalServerURLs(ServerURL... items) {
    if (this.externalServerURLs == null) {
      this.externalServerURLs = new ArrayList();
    }
    for (ServerURL item : items) {
        ServerURLBuilder builder = new ServerURLBuilder(item);
        _visitables.get("externalServerURLs").add(builder);
        this.externalServerURLs.add(builder);
    }
    return (A) this;
  }
  
  public A addToExternalServerURLs(int index,ServerURL item) {
    if (this.externalServerURLs == null) {
      this.externalServerURLs = new ArrayList();
    }
    ServerURLBuilder builder = new ServerURLBuilder(item);
    if (index < 0 || index >= externalServerURLs.size()) {
        _visitables.get("externalServerURLs").add(builder);
        externalServerURLs.add(builder);
    } else {
        _visitables.get("externalServerURLs").add(builder);
        externalServerURLs.add(index, builder);
    }
    return (A) this;
  }
  
  public KlusterletDeployOption buildDeployOption() {
    return this.deployOption != null ? this.deployOption.build() : null;
  }
  
  public ServerURL buildExternalServerURL(int index) {
    return this.externalServerURLs.get(index).build();
  }
  
  public List<ServerURL> buildExternalServerURLs() {
    return this.externalServerURLs != null ? build(externalServerURLs) : null;
  }
  
  public ServerURL buildFirstExternalServerURL() {
    return this.externalServerURLs.get(0).build();
  }
  
  public HubApiServerHostAlias buildHubApiServerHostAlias() {
    return this.hubApiServerHostAlias != null ? this.hubApiServerHostAlias.build() : null;
  }
  
  public ServerURL buildLastExternalServerURL() {
    return this.externalServerURLs.get(externalServerURLs.size() - 1).build();
  }
  
  public ServerURL buildMatchingExternalServerURL(Predicate<ServerURLBuilder> predicate) {
      for (ServerURLBuilder item : externalServerURLs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NodePlacement buildNodePlacement() {
    return this.nodePlacement != null ? this.nodePlacement.build() : null;
  }
  
  public RegistrationConfiguration buildRegistrationConfiguration() {
    return this.registrationConfiguration != null ? this.registrationConfiguration.build() : null;
  }
  
  public ResourceRequirement buildResourceRequirement() {
    return this.resourceRequirement != null ? this.resourceRequirement.build() : null;
  }
  
  public WorkAgentConfiguration buildWorkConfiguration() {
    return this.workConfiguration != null ? this.workConfiguration.build() : null;
  }
  
  protected void copyInstance(KlusterletSpec instance) {
    instance = instance != null ? instance : new KlusterletSpec();
    if (instance != null) {
        this.withClusterName(instance.getClusterName());
        this.withDeployOption(instance.getDeployOption());
        this.withExternalServerURLs(instance.getExternalServerURLs());
        this.withHubApiServerHostAlias(instance.getHubApiServerHostAlias());
        this.withImagePullSpec(instance.getImagePullSpec());
        this.withNamespace(instance.getNamespace());
        this.withNodePlacement(instance.getNodePlacement());
        this.withPriorityClassName(instance.getPriorityClassName());
        this.withRegistrationConfiguration(instance.getRegistrationConfiguration());
        this.withRegistrationImagePullSpec(instance.getRegistrationImagePullSpec());
        this.withResourceRequirement(instance.getResourceRequirement());
        this.withWorkConfiguration(instance.getWorkConfiguration());
        this.withWorkImagePullSpec(instance.getWorkImagePullSpec());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DeployOptionNested<A> editDeployOption() {
    return this.withNewDeployOptionLike(Optional.ofNullable(this.buildDeployOption()).orElse(null));
  }
  
  public ExternalServerURLsNested<A> editExternalServerURL(int index) {
    if (externalServerURLs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "externalServerURLs"));
    }
    return this.setNewExternalServerURLLike(index, this.buildExternalServerURL(index));
  }
  
  public ExternalServerURLsNested<A> editFirstExternalServerURL() {
    if (externalServerURLs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "externalServerURLs"));
    }
    return this.setNewExternalServerURLLike(0, this.buildExternalServerURL(0));
  }
  
  public HubApiServerHostAliasNested<A> editHubApiServerHostAlias() {
    return this.withNewHubApiServerHostAliasLike(Optional.ofNullable(this.buildHubApiServerHostAlias()).orElse(null));
  }
  
  public ExternalServerURLsNested<A> editLastExternalServerURL() {
    int index = externalServerURLs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "externalServerURLs"));
    }
    return this.setNewExternalServerURLLike(index, this.buildExternalServerURL(index));
  }
  
  public ExternalServerURLsNested<A> editMatchingExternalServerURL(Predicate<ServerURLBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < externalServerURLs.size();i++) {
      if (predicate.test(externalServerURLs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "externalServerURLs"));
    }
    return this.setNewExternalServerURLLike(index, this.buildExternalServerURL(index));
  }
  
  public NodePlacementNested<A> editNodePlacement() {
    return this.withNewNodePlacementLike(Optional.ofNullable(this.buildNodePlacement()).orElse(null));
  }
  
  public DeployOptionNested<A> editOrNewDeployOption() {
    return this.withNewDeployOptionLike(Optional.ofNullable(this.buildDeployOption()).orElse(new KlusterletDeployOptionBuilder().build()));
  }
  
  public DeployOptionNested<A> editOrNewDeployOptionLike(KlusterletDeployOption item) {
    return this.withNewDeployOptionLike(Optional.ofNullable(this.buildDeployOption()).orElse(item));
  }
  
  public HubApiServerHostAliasNested<A> editOrNewHubApiServerHostAlias() {
    return this.withNewHubApiServerHostAliasLike(Optional.ofNullable(this.buildHubApiServerHostAlias()).orElse(new HubApiServerHostAliasBuilder().build()));
  }
  
  public HubApiServerHostAliasNested<A> editOrNewHubApiServerHostAliasLike(HubApiServerHostAlias item) {
    return this.withNewHubApiServerHostAliasLike(Optional.ofNullable(this.buildHubApiServerHostAlias()).orElse(item));
  }
  
  public NodePlacementNested<A> editOrNewNodePlacement() {
    return this.withNewNodePlacementLike(Optional.ofNullable(this.buildNodePlacement()).orElse(new NodePlacementBuilder().build()));
  }
  
  public NodePlacementNested<A> editOrNewNodePlacementLike(NodePlacement item) {
    return this.withNewNodePlacementLike(Optional.ofNullable(this.buildNodePlacement()).orElse(item));
  }
  
  public RegistrationConfigurationNested<A> editOrNewRegistrationConfiguration() {
    return this.withNewRegistrationConfigurationLike(Optional.ofNullable(this.buildRegistrationConfiguration()).orElse(new RegistrationConfigurationBuilder().build()));
  }
  
  public RegistrationConfigurationNested<A> editOrNewRegistrationConfigurationLike(RegistrationConfiguration item) {
    return this.withNewRegistrationConfigurationLike(Optional.ofNullable(this.buildRegistrationConfiguration()).orElse(item));
  }
  
  public ResourceRequirementNested<A> editOrNewResourceRequirement() {
    return this.withNewResourceRequirementLike(Optional.ofNullable(this.buildResourceRequirement()).orElse(new ResourceRequirementBuilder().build()));
  }
  
  public ResourceRequirementNested<A> editOrNewResourceRequirementLike(ResourceRequirement item) {
    return this.withNewResourceRequirementLike(Optional.ofNullable(this.buildResourceRequirement()).orElse(item));
  }
  
  public WorkConfigurationNested<A> editOrNewWorkConfiguration() {
    return this.withNewWorkConfigurationLike(Optional.ofNullable(this.buildWorkConfiguration()).orElse(new WorkAgentConfigurationBuilder().build()));
  }
  
  public WorkConfigurationNested<A> editOrNewWorkConfigurationLike(WorkAgentConfiguration item) {
    return this.withNewWorkConfigurationLike(Optional.ofNullable(this.buildWorkConfiguration()).orElse(item));
  }
  
  public RegistrationConfigurationNested<A> editRegistrationConfiguration() {
    return this.withNewRegistrationConfigurationLike(Optional.ofNullable(this.buildRegistrationConfiguration()).orElse(null));
  }
  
  public ResourceRequirementNested<A> editResourceRequirement() {
    return this.withNewResourceRequirementLike(Optional.ofNullable(this.buildResourceRequirement()).orElse(null));
  }
  
  public WorkConfigurationNested<A> editWorkConfiguration() {
    return this.withNewWorkConfigurationLike(Optional.ofNullable(this.buildWorkConfiguration()).orElse(null));
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
    KlusterletSpecFluent that = (KlusterletSpecFluent) o;
    if (!(Objects.equals(clusterName, that.clusterName))) {
      return false;
    }
    if (!(Objects.equals(deployOption, that.deployOption))) {
      return false;
    }
    if (!(Objects.equals(externalServerURLs, that.externalServerURLs))) {
      return false;
    }
    if (!(Objects.equals(hubApiServerHostAlias, that.hubApiServerHostAlias))) {
      return false;
    }
    if (!(Objects.equals(imagePullSpec, that.imagePullSpec))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(nodePlacement, that.nodePlacement))) {
      return false;
    }
    if (!(Objects.equals(priorityClassName, that.priorityClassName))) {
      return false;
    }
    if (!(Objects.equals(registrationConfiguration, that.registrationConfiguration))) {
      return false;
    }
    if (!(Objects.equals(registrationImagePullSpec, that.registrationImagePullSpec))) {
      return false;
    }
    if (!(Objects.equals(resourceRequirement, that.resourceRequirement))) {
      return false;
    }
    if (!(Objects.equals(workConfiguration, that.workConfiguration))) {
      return false;
    }
    if (!(Objects.equals(workImagePullSpec, that.workImagePullSpec))) {
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
  
  public String getClusterName() {
    return this.clusterName;
  }
  
  public String getImagePullSpec() {
    return this.imagePullSpec;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String getPriorityClassName() {
    return this.priorityClassName;
  }
  
  public String getRegistrationImagePullSpec() {
    return this.registrationImagePullSpec;
  }
  
  public String getWorkImagePullSpec() {
    return this.workImagePullSpec;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterName() {
    return this.clusterName != null;
  }
  
  public boolean hasDeployOption() {
    return this.deployOption != null;
  }
  
  public boolean hasExternalServerURLs() {
    return this.externalServerURLs != null && !(this.externalServerURLs.isEmpty());
  }
  
  public boolean hasHubApiServerHostAlias() {
    return this.hubApiServerHostAlias != null;
  }
  
  public boolean hasImagePullSpec() {
    return this.imagePullSpec != null;
  }
  
  public boolean hasMatchingExternalServerURL(Predicate<ServerURLBuilder> predicate) {
      for (ServerURLBuilder item : externalServerURLs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasNodePlacement() {
    return this.nodePlacement != null;
  }
  
  public boolean hasPriorityClassName() {
    return this.priorityClassName != null;
  }
  
  public boolean hasRegistrationConfiguration() {
    return this.registrationConfiguration != null;
  }
  
  public boolean hasRegistrationImagePullSpec() {
    return this.registrationImagePullSpec != null;
  }
  
  public boolean hasResourceRequirement() {
    return this.resourceRequirement != null;
  }
  
  public boolean hasWorkConfiguration() {
    return this.workConfiguration != null;
  }
  
  public boolean hasWorkImagePullSpec() {
    return this.workImagePullSpec != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterName, deployOption, externalServerURLs, hubApiServerHostAlias, imagePullSpec, namespace, nodePlacement, priorityClassName, registrationConfiguration, registrationImagePullSpec, resourceRequirement, workConfiguration, workImagePullSpec, additionalProperties);
  }
  
  public A removeAllFromExternalServerURLs(Collection<ServerURL> items) {
    if (this.externalServerURLs == null) {
      return (A) this;
    }
    for (ServerURL item : items) {
        ServerURLBuilder builder = new ServerURLBuilder(item);
        _visitables.get("externalServerURLs").remove(builder);
        this.externalServerURLs.remove(builder);
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
  
  public A removeFromExternalServerURLs(ServerURL... items) {
    if (this.externalServerURLs == null) {
      return (A) this;
    }
    for (ServerURL item : items) {
        ServerURLBuilder builder = new ServerURLBuilder(item);
        _visitables.get("externalServerURLs").remove(builder);
        this.externalServerURLs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromExternalServerURLs(Predicate<ServerURLBuilder> predicate) {
    if (externalServerURLs == null) {
      return (A) this;
    }
    Iterator<ServerURLBuilder> each = externalServerURLs.iterator();
    List visitables = _visitables.get("externalServerURLs");
    while (each.hasNext()) {
        ServerURLBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ExternalServerURLsNested<A> setNewExternalServerURLLike(int index,ServerURL item) {
    return new ExternalServerURLsNested(index, item);
  }
  
  public A setToExternalServerURLs(int index,ServerURL item) {
    if (this.externalServerURLs == null) {
      this.externalServerURLs = new ArrayList();
    }
    ServerURLBuilder builder = new ServerURLBuilder(item);
    if (index < 0 || index >= externalServerURLs.size()) {
        _visitables.get("externalServerURLs").add(builder);
        externalServerURLs.add(builder);
    } else {
        _visitables.get("externalServerURLs").add(builder);
        externalServerURLs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterName == null)) {
        sb.append("clusterName:");
        sb.append(clusterName);
        sb.append(",");
    }
    if (!(deployOption == null)) {
        sb.append("deployOption:");
        sb.append(deployOption);
        sb.append(",");
    }
    if (!(externalServerURLs == null) && !(externalServerURLs.isEmpty())) {
        sb.append("externalServerURLs:");
        sb.append(externalServerURLs);
        sb.append(",");
    }
    if (!(hubApiServerHostAlias == null)) {
        sb.append("hubApiServerHostAlias:");
        sb.append(hubApiServerHostAlias);
        sb.append(",");
    }
    if (!(imagePullSpec == null)) {
        sb.append("imagePullSpec:");
        sb.append(imagePullSpec);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(nodePlacement == null)) {
        sb.append("nodePlacement:");
        sb.append(nodePlacement);
        sb.append(",");
    }
    if (!(priorityClassName == null)) {
        sb.append("priorityClassName:");
        sb.append(priorityClassName);
        sb.append(",");
    }
    if (!(registrationConfiguration == null)) {
        sb.append("registrationConfiguration:");
        sb.append(registrationConfiguration);
        sb.append(",");
    }
    if (!(registrationImagePullSpec == null)) {
        sb.append("registrationImagePullSpec:");
        sb.append(registrationImagePullSpec);
        sb.append(",");
    }
    if (!(resourceRequirement == null)) {
        sb.append("resourceRequirement:");
        sb.append(resourceRequirement);
        sb.append(",");
    }
    if (!(workConfiguration == null)) {
        sb.append("workConfiguration:");
        sb.append(workConfiguration);
        sb.append(",");
    }
    if (!(workImagePullSpec == null)) {
        sb.append("workImagePullSpec:");
        sb.append(workImagePullSpec);
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
  
  public A withClusterName(String clusterName) {
    this.clusterName = clusterName;
    return (A) this;
  }
  
  public A withDeployOption(KlusterletDeployOption deployOption) {
    this._visitables.remove("deployOption");
    if (deployOption != null) {
        this.deployOption = new KlusterletDeployOptionBuilder(deployOption);
        this._visitables.get("deployOption").add(this.deployOption);
    } else {
        this.deployOption = null;
        this._visitables.get("deployOption").remove(this.deployOption);
    }
    return (A) this;
  }
  
  public A withExternalServerURLs(List<ServerURL> externalServerURLs) {
    if (this.externalServerURLs != null) {
      this._visitables.get("externalServerURLs").clear();
    }
    if (externalServerURLs != null) {
        this.externalServerURLs = new ArrayList();
        for (ServerURL item : externalServerURLs) {
          this.addToExternalServerURLs(item);
        }
    } else {
      this.externalServerURLs = null;
    }
    return (A) this;
  }
  
  public A withExternalServerURLs(ServerURL... externalServerURLs) {
    if (this.externalServerURLs != null) {
        this.externalServerURLs.clear();
        _visitables.remove("externalServerURLs");
    }
    if (externalServerURLs != null) {
      for (ServerURL item : externalServerURLs) {
        this.addToExternalServerURLs(item);
      }
    }
    return (A) this;
  }
  
  public A withHubApiServerHostAlias(HubApiServerHostAlias hubApiServerHostAlias) {
    this._visitables.remove("hubApiServerHostAlias");
    if (hubApiServerHostAlias != null) {
        this.hubApiServerHostAlias = new HubApiServerHostAliasBuilder(hubApiServerHostAlias);
        this._visitables.get("hubApiServerHostAlias").add(this.hubApiServerHostAlias);
    } else {
        this.hubApiServerHostAlias = null;
        this._visitables.get("hubApiServerHostAlias").remove(this.hubApiServerHostAlias);
    }
    return (A) this;
  }
  
  public A withImagePullSpec(String imagePullSpec) {
    this.imagePullSpec = imagePullSpec;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public DeployOptionNested<A> withNewDeployOption() {
    return new DeployOptionNested(null);
  }
  
  public A withNewDeployOption(String mode) {
    return (A) this.withDeployOption(new KlusterletDeployOption(mode));
  }
  
  public DeployOptionNested<A> withNewDeployOptionLike(KlusterletDeployOption item) {
    return new DeployOptionNested(item);
  }
  
  public HubApiServerHostAliasNested<A> withNewHubApiServerHostAlias() {
    return new HubApiServerHostAliasNested(null);
  }
  
  public A withNewHubApiServerHostAlias(String hostname,String ip) {
    return (A) this.withHubApiServerHostAlias(new HubApiServerHostAlias(hostname, ip));
  }
  
  public HubApiServerHostAliasNested<A> withNewHubApiServerHostAliasLike(HubApiServerHostAlias item) {
    return new HubApiServerHostAliasNested(item);
  }
  
  public NodePlacementNested<A> withNewNodePlacement() {
    return new NodePlacementNested(null);
  }
  
  public NodePlacementNested<A> withNewNodePlacementLike(NodePlacement item) {
    return new NodePlacementNested(item);
  }
  
  public RegistrationConfigurationNested<A> withNewRegistrationConfiguration() {
    return new RegistrationConfigurationNested(null);
  }
  
  public RegistrationConfigurationNested<A> withNewRegistrationConfigurationLike(RegistrationConfiguration item) {
    return new RegistrationConfigurationNested(item);
  }
  
  public ResourceRequirementNested<A> withNewResourceRequirement() {
    return new ResourceRequirementNested(null);
  }
  
  public ResourceRequirementNested<A> withNewResourceRequirementLike(ResourceRequirement item) {
    return new ResourceRequirementNested(item);
  }
  
  public WorkConfigurationNested<A> withNewWorkConfiguration() {
    return new WorkConfigurationNested(null);
  }
  
  public WorkConfigurationNested<A> withNewWorkConfigurationLike(WorkAgentConfiguration item) {
    return new WorkConfigurationNested(item);
  }
  
  public A withNodePlacement(NodePlacement nodePlacement) {
    this._visitables.remove("nodePlacement");
    if (nodePlacement != null) {
        this.nodePlacement = new NodePlacementBuilder(nodePlacement);
        this._visitables.get("nodePlacement").add(this.nodePlacement);
    } else {
        this.nodePlacement = null;
        this._visitables.get("nodePlacement").remove(this.nodePlacement);
    }
    return (A) this;
  }
  
  public A withPriorityClassName(String priorityClassName) {
    this.priorityClassName = priorityClassName;
    return (A) this;
  }
  
  public A withRegistrationConfiguration(RegistrationConfiguration registrationConfiguration) {
    this._visitables.remove("registrationConfiguration");
    if (registrationConfiguration != null) {
        this.registrationConfiguration = new RegistrationConfigurationBuilder(registrationConfiguration);
        this._visitables.get("registrationConfiguration").add(this.registrationConfiguration);
    } else {
        this.registrationConfiguration = null;
        this._visitables.get("registrationConfiguration").remove(this.registrationConfiguration);
    }
    return (A) this;
  }
  
  public A withRegistrationImagePullSpec(String registrationImagePullSpec) {
    this.registrationImagePullSpec = registrationImagePullSpec;
    return (A) this;
  }
  
  public A withResourceRequirement(ResourceRequirement resourceRequirement) {
    this._visitables.remove("resourceRequirement");
    if (resourceRequirement != null) {
        this.resourceRequirement = new ResourceRequirementBuilder(resourceRequirement);
        this._visitables.get("resourceRequirement").add(this.resourceRequirement);
    } else {
        this.resourceRequirement = null;
        this._visitables.get("resourceRequirement").remove(this.resourceRequirement);
    }
    return (A) this;
  }
  
  public A withWorkConfiguration(WorkAgentConfiguration workConfiguration) {
    this._visitables.remove("workConfiguration");
    if (workConfiguration != null) {
        this.workConfiguration = new WorkAgentConfigurationBuilder(workConfiguration);
        this._visitables.get("workConfiguration").add(this.workConfiguration);
    } else {
        this.workConfiguration = null;
        this._visitables.get("workConfiguration").remove(this.workConfiguration);
    }
    return (A) this;
  }
  
  public A withWorkImagePullSpec(String workImagePullSpec) {
    this.workImagePullSpec = workImagePullSpec;
    return (A) this;
  }
  public class DeployOptionNested<N> extends KlusterletDeployOptionFluent<DeployOptionNested<N>> implements Nested<N>{
  
    KlusterletDeployOptionBuilder builder;
  
    DeployOptionNested(KlusterletDeployOption item) {
      this.builder = new KlusterletDeployOptionBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletSpecFluent.this.withDeployOption(builder.build());
    }
    
    public N endDeployOption() {
      return and();
    }
    
  }
  public class ExternalServerURLsNested<N> extends ServerURLFluent<ExternalServerURLsNested<N>> implements Nested<N>{
  
    ServerURLBuilder builder;
    int index;
  
    ExternalServerURLsNested(int index,ServerURL item) {
      this.index = index;
      this.builder = new ServerURLBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletSpecFluent.this.setToExternalServerURLs(index, builder.build());
    }
    
    public N endExternalServerURL() {
      return and();
    }
    
  }
  public class HubApiServerHostAliasNested<N> extends HubApiServerHostAliasFluent<HubApiServerHostAliasNested<N>> implements Nested<N>{
  
    HubApiServerHostAliasBuilder builder;
  
    HubApiServerHostAliasNested(HubApiServerHostAlias item) {
      this.builder = new HubApiServerHostAliasBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletSpecFluent.this.withHubApiServerHostAlias(builder.build());
    }
    
    public N endHubApiServerHostAlias() {
      return and();
    }
    
  }
  public class NodePlacementNested<N> extends NodePlacementFluent<NodePlacementNested<N>> implements Nested<N>{
  
    NodePlacementBuilder builder;
  
    NodePlacementNested(NodePlacement item) {
      this.builder = new NodePlacementBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletSpecFluent.this.withNodePlacement(builder.build());
    }
    
    public N endNodePlacement() {
      return and();
    }
    
  }
  public class RegistrationConfigurationNested<N> extends RegistrationConfigurationFluent<RegistrationConfigurationNested<N>> implements Nested<N>{
  
    RegistrationConfigurationBuilder builder;
  
    RegistrationConfigurationNested(RegistrationConfiguration item) {
      this.builder = new RegistrationConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletSpecFluent.this.withRegistrationConfiguration(builder.build());
    }
    
    public N endRegistrationConfiguration() {
      return and();
    }
    
  }
  public class ResourceRequirementNested<N> extends ResourceRequirementFluent<ResourceRequirementNested<N>> implements Nested<N>{
  
    ResourceRequirementBuilder builder;
  
    ResourceRequirementNested(ResourceRequirement item) {
      this.builder = new ResourceRequirementBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletSpecFluent.this.withResourceRequirement(builder.build());
    }
    
    public N endResourceRequirement() {
      return and();
    }
    
  }
  public class WorkConfigurationNested<N> extends WorkAgentConfigurationFluent<WorkConfigurationNested<N>> implements Nested<N>{
  
    WorkAgentConfigurationBuilder builder;
  
    WorkConfigurationNested(WorkAgentConfiguration item) {
      this.builder = new WorkAgentConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) KlusterletSpecFluent.this.withWorkConfiguration(builder.build());
    }
    
    public N endWorkConfiguration() {
      return and();
    }
    
  }
}