package io.fabric8.openclustermanagement.api.model.operator.v1;

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
public class ClusterManagerSpecFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.ClusterManagerSpecFluent<A>> extends BaseFluent<A>{

  private AddOnManagerConfigurationBuilder addOnManagerConfiguration;
  private String addOnManagerImagePullSpec;
  private Map<String,Object> additionalProperties;
  private ClusterManagerDeployOptionBuilder deployOption;
  private NodePlacementBuilder nodePlacement;
  private PlacementConfigurationBuilder placementConfiguration;
  private String placementImagePullSpec;
  private RegistrationHubConfigurationBuilder registrationConfiguration;
  private String registrationImagePullSpec;
  private ResourceRequirementBuilder resourceRequirement;
  private ServerConfigurationBuilder serverConfiguration;
  private WorkConfigurationBuilder workConfiguration;
  private String workImagePullSpec;

  public ClusterManagerSpecFluent() {
  }
  
  public ClusterManagerSpecFluent(ClusterManagerSpec instance) {
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
  
  public AddOnManagerConfiguration buildAddOnManagerConfiguration() {
    return this.addOnManagerConfiguration != null ? this.addOnManagerConfiguration.build() : null;
  }
  
  public ClusterManagerDeployOption buildDeployOption() {
    return this.deployOption != null ? this.deployOption.build() : null;
  }
  
  public NodePlacement buildNodePlacement() {
    return this.nodePlacement != null ? this.nodePlacement.build() : null;
  }
  
  public PlacementConfiguration buildPlacementConfiguration() {
    return this.placementConfiguration != null ? this.placementConfiguration.build() : null;
  }
  
  public RegistrationHubConfiguration buildRegistrationConfiguration() {
    return this.registrationConfiguration != null ? this.registrationConfiguration.build() : null;
  }
  
  public ResourceRequirement buildResourceRequirement() {
    return this.resourceRequirement != null ? this.resourceRequirement.build() : null;
  }
  
  public ServerConfiguration buildServerConfiguration() {
    return this.serverConfiguration != null ? this.serverConfiguration.build() : null;
  }
  
  public WorkConfiguration buildWorkConfiguration() {
    return this.workConfiguration != null ? this.workConfiguration.build() : null;
  }
  
  protected void copyInstance(ClusterManagerSpec instance) {
    instance = instance != null ? instance : new ClusterManagerSpec();
    if (instance != null) {
        this.withAddOnManagerConfiguration(instance.getAddOnManagerConfiguration());
        this.withAddOnManagerImagePullSpec(instance.getAddOnManagerImagePullSpec());
        this.withDeployOption(instance.getDeployOption());
        this.withNodePlacement(instance.getNodePlacement());
        this.withPlacementConfiguration(instance.getPlacementConfiguration());
        this.withPlacementImagePullSpec(instance.getPlacementImagePullSpec());
        this.withRegistrationConfiguration(instance.getRegistrationConfiguration());
        this.withRegistrationImagePullSpec(instance.getRegistrationImagePullSpec());
        this.withResourceRequirement(instance.getResourceRequirement());
        this.withServerConfiguration(instance.getServerConfiguration());
        this.withWorkConfiguration(instance.getWorkConfiguration());
        this.withWorkImagePullSpec(instance.getWorkImagePullSpec());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AddOnManagerConfigurationNested<A> editAddOnManagerConfiguration() {
    return this.withNewAddOnManagerConfigurationLike(Optional.ofNullable(this.buildAddOnManagerConfiguration()).orElse(null));
  }
  
  public DeployOptionNested<A> editDeployOption() {
    return this.withNewDeployOptionLike(Optional.ofNullable(this.buildDeployOption()).orElse(null));
  }
  
  public NodePlacementNested<A> editNodePlacement() {
    return this.withNewNodePlacementLike(Optional.ofNullable(this.buildNodePlacement()).orElse(null));
  }
  
  public AddOnManagerConfigurationNested<A> editOrNewAddOnManagerConfiguration() {
    return this.withNewAddOnManagerConfigurationLike(Optional.ofNullable(this.buildAddOnManagerConfiguration()).orElse(new AddOnManagerConfigurationBuilder().build()));
  }
  
  public AddOnManagerConfigurationNested<A> editOrNewAddOnManagerConfigurationLike(AddOnManagerConfiguration item) {
    return this.withNewAddOnManagerConfigurationLike(Optional.ofNullable(this.buildAddOnManagerConfiguration()).orElse(item));
  }
  
  public DeployOptionNested<A> editOrNewDeployOption() {
    return this.withNewDeployOptionLike(Optional.ofNullable(this.buildDeployOption()).orElse(new ClusterManagerDeployOptionBuilder().build()));
  }
  
  public DeployOptionNested<A> editOrNewDeployOptionLike(ClusterManagerDeployOption item) {
    return this.withNewDeployOptionLike(Optional.ofNullable(this.buildDeployOption()).orElse(item));
  }
  
  public NodePlacementNested<A> editOrNewNodePlacement() {
    return this.withNewNodePlacementLike(Optional.ofNullable(this.buildNodePlacement()).orElse(new NodePlacementBuilder().build()));
  }
  
  public NodePlacementNested<A> editOrNewNodePlacementLike(NodePlacement item) {
    return this.withNewNodePlacementLike(Optional.ofNullable(this.buildNodePlacement()).orElse(item));
  }
  
  public PlacementConfigurationNested<A> editOrNewPlacementConfiguration() {
    return this.withNewPlacementConfigurationLike(Optional.ofNullable(this.buildPlacementConfiguration()).orElse(new PlacementConfigurationBuilder().build()));
  }
  
  public PlacementConfigurationNested<A> editOrNewPlacementConfigurationLike(PlacementConfiguration item) {
    return this.withNewPlacementConfigurationLike(Optional.ofNullable(this.buildPlacementConfiguration()).orElse(item));
  }
  
  public RegistrationConfigurationNested<A> editOrNewRegistrationConfiguration() {
    return this.withNewRegistrationConfigurationLike(Optional.ofNullable(this.buildRegistrationConfiguration()).orElse(new RegistrationHubConfigurationBuilder().build()));
  }
  
  public RegistrationConfigurationNested<A> editOrNewRegistrationConfigurationLike(RegistrationHubConfiguration item) {
    return this.withNewRegistrationConfigurationLike(Optional.ofNullable(this.buildRegistrationConfiguration()).orElse(item));
  }
  
  public ResourceRequirementNested<A> editOrNewResourceRequirement() {
    return this.withNewResourceRequirementLike(Optional.ofNullable(this.buildResourceRequirement()).orElse(new ResourceRequirementBuilder().build()));
  }
  
  public ResourceRequirementNested<A> editOrNewResourceRequirementLike(ResourceRequirement item) {
    return this.withNewResourceRequirementLike(Optional.ofNullable(this.buildResourceRequirement()).orElse(item));
  }
  
  public ServerConfigurationNested<A> editOrNewServerConfiguration() {
    return this.withNewServerConfigurationLike(Optional.ofNullable(this.buildServerConfiguration()).orElse(new ServerConfigurationBuilder().build()));
  }
  
  public ServerConfigurationNested<A> editOrNewServerConfigurationLike(ServerConfiguration item) {
    return this.withNewServerConfigurationLike(Optional.ofNullable(this.buildServerConfiguration()).orElse(item));
  }
  
  public WorkConfigurationNested<A> editOrNewWorkConfiguration() {
    return this.withNewWorkConfigurationLike(Optional.ofNullable(this.buildWorkConfiguration()).orElse(new WorkConfigurationBuilder().build()));
  }
  
  public WorkConfigurationNested<A> editOrNewWorkConfigurationLike(WorkConfiguration item) {
    return this.withNewWorkConfigurationLike(Optional.ofNullable(this.buildWorkConfiguration()).orElse(item));
  }
  
  public PlacementConfigurationNested<A> editPlacementConfiguration() {
    return this.withNewPlacementConfigurationLike(Optional.ofNullable(this.buildPlacementConfiguration()).orElse(null));
  }
  
  public RegistrationConfigurationNested<A> editRegistrationConfiguration() {
    return this.withNewRegistrationConfigurationLike(Optional.ofNullable(this.buildRegistrationConfiguration()).orElse(null));
  }
  
  public ResourceRequirementNested<A> editResourceRequirement() {
    return this.withNewResourceRequirementLike(Optional.ofNullable(this.buildResourceRequirement()).orElse(null));
  }
  
  public ServerConfigurationNested<A> editServerConfiguration() {
    return this.withNewServerConfigurationLike(Optional.ofNullable(this.buildServerConfiguration()).orElse(null));
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
    ClusterManagerSpecFluent that = (ClusterManagerSpecFluent) o;
    if (!(Objects.equals(addOnManagerConfiguration, that.addOnManagerConfiguration))) {
      return false;
    }
    if (!(Objects.equals(addOnManagerImagePullSpec, that.addOnManagerImagePullSpec))) {
      return false;
    }
    if (!(Objects.equals(deployOption, that.deployOption))) {
      return false;
    }
    if (!(Objects.equals(nodePlacement, that.nodePlacement))) {
      return false;
    }
    if (!(Objects.equals(placementConfiguration, that.placementConfiguration))) {
      return false;
    }
    if (!(Objects.equals(placementImagePullSpec, that.placementImagePullSpec))) {
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
    if (!(Objects.equals(serverConfiguration, that.serverConfiguration))) {
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
  
  public String getAddOnManagerImagePullSpec() {
    return this.addOnManagerImagePullSpec;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getPlacementImagePullSpec() {
    return this.placementImagePullSpec;
  }
  
  public String getRegistrationImagePullSpec() {
    return this.registrationImagePullSpec;
  }
  
  public String getWorkImagePullSpec() {
    return this.workImagePullSpec;
  }
  
  public boolean hasAddOnManagerConfiguration() {
    return this.addOnManagerConfiguration != null;
  }
  
  public boolean hasAddOnManagerImagePullSpec() {
    return this.addOnManagerImagePullSpec != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDeployOption() {
    return this.deployOption != null;
  }
  
  public boolean hasNodePlacement() {
    return this.nodePlacement != null;
  }
  
  public boolean hasPlacementConfiguration() {
    return this.placementConfiguration != null;
  }
  
  public boolean hasPlacementImagePullSpec() {
    return this.placementImagePullSpec != null;
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
  
  public boolean hasServerConfiguration() {
    return this.serverConfiguration != null;
  }
  
  public boolean hasWorkConfiguration() {
    return this.workConfiguration != null;
  }
  
  public boolean hasWorkImagePullSpec() {
    return this.workImagePullSpec != null;
  }
  
  public int hashCode() {
    return Objects.hash(addOnManagerConfiguration, addOnManagerImagePullSpec, deployOption, nodePlacement, placementConfiguration, placementImagePullSpec, registrationConfiguration, registrationImagePullSpec, resourceRequirement, serverConfiguration, workConfiguration, workImagePullSpec, additionalProperties);
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
    if (!(addOnManagerConfiguration == null)) {
        sb.append("addOnManagerConfiguration:");
        sb.append(addOnManagerConfiguration);
        sb.append(",");
    }
    if (!(addOnManagerImagePullSpec == null)) {
        sb.append("addOnManagerImagePullSpec:");
        sb.append(addOnManagerImagePullSpec);
        sb.append(",");
    }
    if (!(deployOption == null)) {
        sb.append("deployOption:");
        sb.append(deployOption);
        sb.append(",");
    }
    if (!(nodePlacement == null)) {
        sb.append("nodePlacement:");
        sb.append(nodePlacement);
        sb.append(",");
    }
    if (!(placementConfiguration == null)) {
        sb.append("placementConfiguration:");
        sb.append(placementConfiguration);
        sb.append(",");
    }
    if (!(placementImagePullSpec == null)) {
        sb.append("placementImagePullSpec:");
        sb.append(placementImagePullSpec);
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
    if (!(serverConfiguration == null)) {
        sb.append("serverConfiguration:");
        sb.append(serverConfiguration);
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
  
  public A withAddOnManagerConfiguration(AddOnManagerConfiguration addOnManagerConfiguration) {
    this._visitables.remove("addOnManagerConfiguration");
    if (addOnManagerConfiguration != null) {
        this.addOnManagerConfiguration = new AddOnManagerConfigurationBuilder(addOnManagerConfiguration);
        this._visitables.get("addOnManagerConfiguration").add(this.addOnManagerConfiguration);
    } else {
        this.addOnManagerConfiguration = null;
        this._visitables.get("addOnManagerConfiguration").remove(this.addOnManagerConfiguration);
    }
    return (A) this;
  }
  
  public A withAddOnManagerImagePullSpec(String addOnManagerImagePullSpec) {
    this.addOnManagerImagePullSpec = addOnManagerImagePullSpec;
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withDeployOption(ClusterManagerDeployOption deployOption) {
    this._visitables.remove("deployOption");
    if (deployOption != null) {
        this.deployOption = new ClusterManagerDeployOptionBuilder(deployOption);
        this._visitables.get("deployOption").add(this.deployOption);
    } else {
        this.deployOption = null;
        this._visitables.get("deployOption").remove(this.deployOption);
    }
    return (A) this;
  }
  
  public AddOnManagerConfigurationNested<A> withNewAddOnManagerConfiguration() {
    return new AddOnManagerConfigurationNested(null);
  }
  
  public AddOnManagerConfigurationNested<A> withNewAddOnManagerConfigurationLike(AddOnManagerConfiguration item) {
    return new AddOnManagerConfigurationNested(item);
  }
  
  public DeployOptionNested<A> withNewDeployOption() {
    return new DeployOptionNested(null);
  }
  
  public DeployOptionNested<A> withNewDeployOptionLike(ClusterManagerDeployOption item) {
    return new DeployOptionNested(item);
  }
  
  public NodePlacementNested<A> withNewNodePlacement() {
    return new NodePlacementNested(null);
  }
  
  public NodePlacementNested<A> withNewNodePlacementLike(NodePlacement item) {
    return new NodePlacementNested(item);
  }
  
  public PlacementConfigurationNested<A> withNewPlacementConfiguration() {
    return new PlacementConfigurationNested(null);
  }
  
  public PlacementConfigurationNested<A> withNewPlacementConfigurationLike(PlacementConfiguration item) {
    return new PlacementConfigurationNested(item);
  }
  
  public RegistrationConfigurationNested<A> withNewRegistrationConfiguration() {
    return new RegistrationConfigurationNested(null);
  }
  
  public RegistrationConfigurationNested<A> withNewRegistrationConfigurationLike(RegistrationHubConfiguration item) {
    return new RegistrationConfigurationNested(item);
  }
  
  public ResourceRequirementNested<A> withNewResourceRequirement() {
    return new ResourceRequirementNested(null);
  }
  
  public ResourceRequirementNested<A> withNewResourceRequirementLike(ResourceRequirement item) {
    return new ResourceRequirementNested(item);
  }
  
  public ServerConfigurationNested<A> withNewServerConfiguration() {
    return new ServerConfigurationNested(null);
  }
  
  public ServerConfigurationNested<A> withNewServerConfigurationLike(ServerConfiguration item) {
    return new ServerConfigurationNested(item);
  }
  
  public WorkConfigurationNested<A> withNewWorkConfiguration() {
    return new WorkConfigurationNested(null);
  }
  
  public WorkConfigurationNested<A> withNewWorkConfigurationLike(WorkConfiguration item) {
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
  
  public A withPlacementConfiguration(PlacementConfiguration placementConfiguration) {
    this._visitables.remove("placementConfiguration");
    if (placementConfiguration != null) {
        this.placementConfiguration = new PlacementConfigurationBuilder(placementConfiguration);
        this._visitables.get("placementConfiguration").add(this.placementConfiguration);
    } else {
        this.placementConfiguration = null;
        this._visitables.get("placementConfiguration").remove(this.placementConfiguration);
    }
    return (A) this;
  }
  
  public A withPlacementImagePullSpec(String placementImagePullSpec) {
    this.placementImagePullSpec = placementImagePullSpec;
    return (A) this;
  }
  
  public A withRegistrationConfiguration(RegistrationHubConfiguration registrationConfiguration) {
    this._visitables.remove("registrationConfiguration");
    if (registrationConfiguration != null) {
        this.registrationConfiguration = new RegistrationHubConfigurationBuilder(registrationConfiguration);
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
  
  public A withServerConfiguration(ServerConfiguration serverConfiguration) {
    this._visitables.remove("serverConfiguration");
    if (serverConfiguration != null) {
        this.serverConfiguration = new ServerConfigurationBuilder(serverConfiguration);
        this._visitables.get("serverConfiguration").add(this.serverConfiguration);
    } else {
        this.serverConfiguration = null;
        this._visitables.get("serverConfiguration").remove(this.serverConfiguration);
    }
    return (A) this;
  }
  
  public A withWorkConfiguration(WorkConfiguration workConfiguration) {
    this._visitables.remove("workConfiguration");
    if (workConfiguration != null) {
        this.workConfiguration = new WorkConfigurationBuilder(workConfiguration);
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
  public class AddOnManagerConfigurationNested<N> extends AddOnManagerConfigurationFluent<AddOnManagerConfigurationNested<N>> implements Nested<N>{
  
    AddOnManagerConfigurationBuilder builder;
  
    AddOnManagerConfigurationNested(AddOnManagerConfiguration item) {
      this.builder = new AddOnManagerConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterManagerSpecFluent.this.withAddOnManagerConfiguration(builder.build());
    }
    
    public N endAddOnManagerConfiguration() {
      return and();
    }
    
  }
  public class DeployOptionNested<N> extends ClusterManagerDeployOptionFluent<DeployOptionNested<N>> implements Nested<N>{
  
    ClusterManagerDeployOptionBuilder builder;
  
    DeployOptionNested(ClusterManagerDeployOption item) {
      this.builder = new ClusterManagerDeployOptionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterManagerSpecFluent.this.withDeployOption(builder.build());
    }
    
    public N endDeployOption() {
      return and();
    }
    
  }
  public class NodePlacementNested<N> extends NodePlacementFluent<NodePlacementNested<N>> implements Nested<N>{
  
    NodePlacementBuilder builder;
  
    NodePlacementNested(NodePlacement item) {
      this.builder = new NodePlacementBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterManagerSpecFluent.this.withNodePlacement(builder.build());
    }
    
    public N endNodePlacement() {
      return and();
    }
    
  }
  public class PlacementConfigurationNested<N> extends PlacementConfigurationFluent<PlacementConfigurationNested<N>> implements Nested<N>{
  
    PlacementConfigurationBuilder builder;
  
    PlacementConfigurationNested(PlacementConfiguration item) {
      this.builder = new PlacementConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterManagerSpecFluent.this.withPlacementConfiguration(builder.build());
    }
    
    public N endPlacementConfiguration() {
      return and();
    }
    
  }
  public class RegistrationConfigurationNested<N> extends RegistrationHubConfigurationFluent<RegistrationConfigurationNested<N>> implements Nested<N>{
  
    RegistrationHubConfigurationBuilder builder;
  
    RegistrationConfigurationNested(RegistrationHubConfiguration item) {
      this.builder = new RegistrationHubConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterManagerSpecFluent.this.withRegistrationConfiguration(builder.build());
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
      return (N) ClusterManagerSpecFluent.this.withResourceRequirement(builder.build());
    }
    
    public N endResourceRequirement() {
      return and();
    }
    
  }
  public class ServerConfigurationNested<N> extends ServerConfigurationFluent<ServerConfigurationNested<N>> implements Nested<N>{
  
    ServerConfigurationBuilder builder;
  
    ServerConfigurationNested(ServerConfiguration item) {
      this.builder = new ServerConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterManagerSpecFluent.this.withServerConfiguration(builder.build());
    }
    
    public N endServerConfiguration() {
      return and();
    }
    
  }
  public class WorkConfigurationNested<N> extends WorkConfigurationFluent<WorkConfigurationNested<N>> implements Nested<N>{
  
    WorkConfigurationBuilder builder;
  
    WorkConfigurationNested(WorkConfiguration item) {
      this.builder = new WorkConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterManagerSpecFluent.this.withWorkConfiguration(builder.build());
    }
    
    public N endWorkConfiguration() {
      return and();
    }
    
  }
}