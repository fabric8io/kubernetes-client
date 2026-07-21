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
public class RegistrationHubConfigurationFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.RegistrationHubConfigurationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> autoApproveUsers = new ArrayList<String>();
  private ArrayList<FeatureGateBuilder> featureGates = new ArrayList<FeatureGateBuilder>();
  private ImporterConfigurationBuilder importerConfiguration;
  private ArrayList<RegistrationDriverHubBuilder> registrationDrivers = new ArrayList<RegistrationDriverHubBuilder>();

  public RegistrationHubConfigurationFluent() {
  }
  
  public RegistrationHubConfigurationFluent(RegistrationHubConfiguration instance) {
    this.copyInstance(instance);
  }

  public A addAllToAutoApproveUsers(Collection<String> items) {
    if (this.autoApproveUsers == null) {
      this.autoApproveUsers = new ArrayList();
    }
    for (String item : items) {
      this.autoApproveUsers.add(item);
    }
    return (A) this;
  }
  
  public A addAllToFeatureGates(Collection<FeatureGate> items) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    for (FeatureGate item : items) {
        FeatureGateBuilder builder = new FeatureGateBuilder(item);
        _visitables.get("featureGates").add(builder);
        this.featureGates.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRegistrationDrivers(Collection<RegistrationDriverHub> items) {
    if (this.registrationDrivers == null) {
      this.registrationDrivers = new ArrayList();
    }
    for (RegistrationDriverHub item : items) {
        RegistrationDriverHubBuilder builder = new RegistrationDriverHubBuilder(item);
        _visitables.get("registrationDrivers").add(builder);
        this.registrationDrivers.add(builder);
    }
    return (A) this;
  }
  
  public FeatureGatesNested<A> addNewFeatureGate() {
    return new FeatureGatesNested(-1, null);
  }
  
  public A addNewFeatureGate(String feature,String mode) {
    return (A) this.addToFeatureGates(new FeatureGate(feature, mode));
  }
  
  public FeatureGatesNested<A> addNewFeatureGateLike(FeatureGate item) {
    return new FeatureGatesNested(-1, item);
  }
  
  public RegistrationDriversNested<A> addNewRegistrationDriver() {
    return new RegistrationDriversNested(-1, null);
  }
  
  public RegistrationDriversNested<A> addNewRegistrationDriverLike(RegistrationDriverHub item) {
    return new RegistrationDriversNested(-1, item);
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
  
  public A addToAutoApproveUsers(String... items) {
    if (this.autoApproveUsers == null) {
      this.autoApproveUsers = new ArrayList();
    }
    for (String item : items) {
      this.autoApproveUsers.add(item);
    }
    return (A) this;
  }
  
  public A addToAutoApproveUsers(int index,String item) {
    if (this.autoApproveUsers == null) {
      this.autoApproveUsers = new ArrayList();
    }
    this.autoApproveUsers.add(index, item);
    return (A) this;
  }
  
  public A addToFeatureGates(FeatureGate... items) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    for (FeatureGate item : items) {
        FeatureGateBuilder builder = new FeatureGateBuilder(item);
        _visitables.get("featureGates").add(builder);
        this.featureGates.add(builder);
    }
    return (A) this;
  }
  
  public A addToFeatureGates(int index,FeatureGate item) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    FeatureGateBuilder builder = new FeatureGateBuilder(item);
    if (index < 0 || index >= featureGates.size()) {
        _visitables.get("featureGates").add(builder);
        featureGates.add(builder);
    } else {
        _visitables.get("featureGates").add(builder);
        featureGates.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRegistrationDrivers(RegistrationDriverHub... items) {
    if (this.registrationDrivers == null) {
      this.registrationDrivers = new ArrayList();
    }
    for (RegistrationDriverHub item : items) {
        RegistrationDriverHubBuilder builder = new RegistrationDriverHubBuilder(item);
        _visitables.get("registrationDrivers").add(builder);
        this.registrationDrivers.add(builder);
    }
    return (A) this;
  }
  
  public A addToRegistrationDrivers(int index,RegistrationDriverHub item) {
    if (this.registrationDrivers == null) {
      this.registrationDrivers = new ArrayList();
    }
    RegistrationDriverHubBuilder builder = new RegistrationDriverHubBuilder(item);
    if (index < 0 || index >= registrationDrivers.size()) {
        _visitables.get("registrationDrivers").add(builder);
        registrationDrivers.add(builder);
    } else {
        _visitables.get("registrationDrivers").add(builder);
        registrationDrivers.add(index, builder);
    }
    return (A) this;
  }
  
  public FeatureGate buildFeatureGate(int index) {
    return this.featureGates.get(index).build();
  }
  
  public List<FeatureGate> buildFeatureGates() {
    return this.featureGates != null ? build(featureGates) : null;
  }
  
  public FeatureGate buildFirstFeatureGate() {
    return this.featureGates.get(0).build();
  }
  
  public RegistrationDriverHub buildFirstRegistrationDriver() {
    return this.registrationDrivers.get(0).build();
  }
  
  public ImporterConfiguration buildImporterConfiguration() {
    return this.importerConfiguration != null ? this.importerConfiguration.build() : null;
  }
  
  public FeatureGate buildLastFeatureGate() {
    return this.featureGates.get(featureGates.size() - 1).build();
  }
  
  public RegistrationDriverHub buildLastRegistrationDriver() {
    return this.registrationDrivers.get(registrationDrivers.size() - 1).build();
  }
  
  public FeatureGate buildMatchingFeatureGate(Predicate<FeatureGateBuilder> predicate) {
      for (FeatureGateBuilder item : featureGates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RegistrationDriverHub buildMatchingRegistrationDriver(Predicate<RegistrationDriverHubBuilder> predicate) {
      for (RegistrationDriverHubBuilder item : registrationDrivers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RegistrationDriverHub buildRegistrationDriver(int index) {
    return this.registrationDrivers.get(index).build();
  }
  
  public List<RegistrationDriverHub> buildRegistrationDrivers() {
    return this.registrationDrivers != null ? build(registrationDrivers) : null;
  }
  
  protected void copyInstance(RegistrationHubConfiguration instance) {
    instance = instance != null ? instance : new RegistrationHubConfiguration();
    if (instance != null) {
        this.withAutoApproveUsers(instance.getAutoApproveUsers());
        this.withFeatureGates(instance.getFeatureGates());
        this.withImporterConfiguration(instance.getImporterConfiguration());
        this.withRegistrationDrivers(instance.getRegistrationDrivers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FeatureGatesNested<A> editFeatureGate(int index) {
    if (featureGates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "featureGates"));
    }
    return this.setNewFeatureGateLike(index, this.buildFeatureGate(index));
  }
  
  public FeatureGatesNested<A> editFirstFeatureGate() {
    if (featureGates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "featureGates"));
    }
    return this.setNewFeatureGateLike(0, this.buildFeatureGate(0));
  }
  
  public RegistrationDriversNested<A> editFirstRegistrationDriver() {
    if (registrationDrivers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "registrationDrivers"));
    }
    return this.setNewRegistrationDriverLike(0, this.buildRegistrationDriver(0));
  }
  
  public ImporterConfigurationNested<A> editImporterConfiguration() {
    return this.withNewImporterConfigurationLike(Optional.ofNullable(this.buildImporterConfiguration()).orElse(null));
  }
  
  public FeatureGatesNested<A> editLastFeatureGate() {
    int index = featureGates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "featureGates"));
    }
    return this.setNewFeatureGateLike(index, this.buildFeatureGate(index));
  }
  
  public RegistrationDriversNested<A> editLastRegistrationDriver() {
    int index = registrationDrivers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "registrationDrivers"));
    }
    return this.setNewRegistrationDriverLike(index, this.buildRegistrationDriver(index));
  }
  
  public FeatureGatesNested<A> editMatchingFeatureGate(Predicate<FeatureGateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < featureGates.size();i++) {
      if (predicate.test(featureGates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "featureGates"));
    }
    return this.setNewFeatureGateLike(index, this.buildFeatureGate(index));
  }
  
  public RegistrationDriversNested<A> editMatchingRegistrationDriver(Predicate<RegistrationDriverHubBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < registrationDrivers.size();i++) {
      if (predicate.test(registrationDrivers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "registrationDrivers"));
    }
    return this.setNewRegistrationDriverLike(index, this.buildRegistrationDriver(index));
  }
  
  public ImporterConfigurationNested<A> editOrNewImporterConfiguration() {
    return this.withNewImporterConfigurationLike(Optional.ofNullable(this.buildImporterConfiguration()).orElse(new ImporterConfigurationBuilder().build()));
  }
  
  public ImporterConfigurationNested<A> editOrNewImporterConfigurationLike(ImporterConfiguration item) {
    return this.withNewImporterConfigurationLike(Optional.ofNullable(this.buildImporterConfiguration()).orElse(item));
  }
  
  public RegistrationDriversNested<A> editRegistrationDriver(int index) {
    if (registrationDrivers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "registrationDrivers"));
    }
    return this.setNewRegistrationDriverLike(index, this.buildRegistrationDriver(index));
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
    RegistrationHubConfigurationFluent that = (RegistrationHubConfigurationFluent) o;
    if (!(Objects.equals(autoApproveUsers, that.autoApproveUsers))) {
      return false;
    }
    if (!(Objects.equals(featureGates, that.featureGates))) {
      return false;
    }
    if (!(Objects.equals(importerConfiguration, that.importerConfiguration))) {
      return false;
    }
    if (!(Objects.equals(registrationDrivers, that.registrationDrivers))) {
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
  
  public String getAutoApproveUser(int index) {
    return this.autoApproveUsers.get(index);
  }
  
  public List<String> getAutoApproveUsers() {
    return this.autoApproveUsers;
  }
  
  public String getFirstAutoApproveUser() {
    return this.autoApproveUsers.get(0);
  }
  
  public String getLastAutoApproveUser() {
    return this.autoApproveUsers.get(autoApproveUsers.size() - 1);
  }
  
  public String getMatchingAutoApproveUser(Predicate<String> predicate) {
      for (String item : autoApproveUsers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAutoApproveUsers() {
    return this.autoApproveUsers != null && !(this.autoApproveUsers.isEmpty());
  }
  
  public boolean hasFeatureGates() {
    return this.featureGates != null && !(this.featureGates.isEmpty());
  }
  
  public boolean hasImporterConfiguration() {
    return this.importerConfiguration != null;
  }
  
  public boolean hasMatchingAutoApproveUser(Predicate<String> predicate) {
      for (String item : autoApproveUsers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFeatureGate(Predicate<FeatureGateBuilder> predicate) {
      for (FeatureGateBuilder item : featureGates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRegistrationDriver(Predicate<RegistrationDriverHubBuilder> predicate) {
      for (RegistrationDriverHubBuilder item : registrationDrivers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRegistrationDrivers() {
    return this.registrationDrivers != null && !(this.registrationDrivers.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(autoApproveUsers, featureGates, importerConfiguration, registrationDrivers, additionalProperties);
  }
  
  public A removeAllFromAutoApproveUsers(Collection<String> items) {
    if (this.autoApproveUsers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.autoApproveUsers.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromFeatureGates(Collection<FeatureGate> items) {
    if (this.featureGates == null) {
      return (A) this;
    }
    for (FeatureGate item : items) {
        FeatureGateBuilder builder = new FeatureGateBuilder(item);
        _visitables.get("featureGates").remove(builder);
        this.featureGates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRegistrationDrivers(Collection<RegistrationDriverHub> items) {
    if (this.registrationDrivers == null) {
      return (A) this;
    }
    for (RegistrationDriverHub item : items) {
        RegistrationDriverHubBuilder builder = new RegistrationDriverHubBuilder(item);
        _visitables.get("registrationDrivers").remove(builder);
        this.registrationDrivers.remove(builder);
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
  
  public A removeFromAutoApproveUsers(String... items) {
    if (this.autoApproveUsers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.autoApproveUsers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromFeatureGates(FeatureGate... items) {
    if (this.featureGates == null) {
      return (A) this;
    }
    for (FeatureGate item : items) {
        FeatureGateBuilder builder = new FeatureGateBuilder(item);
        _visitables.get("featureGates").remove(builder);
        this.featureGates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRegistrationDrivers(RegistrationDriverHub... items) {
    if (this.registrationDrivers == null) {
      return (A) this;
    }
    for (RegistrationDriverHub item : items) {
        RegistrationDriverHubBuilder builder = new RegistrationDriverHubBuilder(item);
        _visitables.get("registrationDrivers").remove(builder);
        this.registrationDrivers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFeatureGates(Predicate<FeatureGateBuilder> predicate) {
    if (featureGates == null) {
      return (A) this;
    }
    Iterator<FeatureGateBuilder> each = featureGates.iterator();
    List visitables = _visitables.get("featureGates");
    while (each.hasNext()) {
        FeatureGateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRegistrationDrivers(Predicate<RegistrationDriverHubBuilder> predicate) {
    if (registrationDrivers == null) {
      return (A) this;
    }
    Iterator<RegistrationDriverHubBuilder> each = registrationDrivers.iterator();
    List visitables = _visitables.get("registrationDrivers");
    while (each.hasNext()) {
        RegistrationDriverHubBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FeatureGatesNested<A> setNewFeatureGateLike(int index,FeatureGate item) {
    return new FeatureGatesNested(index, item);
  }
  
  public RegistrationDriversNested<A> setNewRegistrationDriverLike(int index,RegistrationDriverHub item) {
    return new RegistrationDriversNested(index, item);
  }
  
  public A setToAutoApproveUsers(int index,String item) {
    if (this.autoApproveUsers == null) {
      this.autoApproveUsers = new ArrayList();
    }
    this.autoApproveUsers.set(index, item);
    return (A) this;
  }
  
  public A setToFeatureGates(int index,FeatureGate item) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    FeatureGateBuilder builder = new FeatureGateBuilder(item);
    if (index < 0 || index >= featureGates.size()) {
        _visitables.get("featureGates").add(builder);
        featureGates.add(builder);
    } else {
        _visitables.get("featureGates").add(builder);
        featureGates.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRegistrationDrivers(int index,RegistrationDriverHub item) {
    if (this.registrationDrivers == null) {
      this.registrationDrivers = new ArrayList();
    }
    RegistrationDriverHubBuilder builder = new RegistrationDriverHubBuilder(item);
    if (index < 0 || index >= registrationDrivers.size()) {
        _visitables.get("registrationDrivers").add(builder);
        registrationDrivers.add(builder);
    } else {
        _visitables.get("registrationDrivers").add(builder);
        registrationDrivers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(autoApproveUsers == null) && !(autoApproveUsers.isEmpty())) {
        sb.append("autoApproveUsers:");
        sb.append(autoApproveUsers);
        sb.append(",");
    }
    if (!(featureGates == null) && !(featureGates.isEmpty())) {
        sb.append("featureGates:");
        sb.append(featureGates);
        sb.append(",");
    }
    if (!(importerConfiguration == null)) {
        sb.append("importerConfiguration:");
        sb.append(importerConfiguration);
        sb.append(",");
    }
    if (!(registrationDrivers == null) && !(registrationDrivers.isEmpty())) {
        sb.append("registrationDrivers:");
        sb.append(registrationDrivers);
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
  
  public A withAutoApproveUsers(List<String> autoApproveUsers) {
    if (autoApproveUsers != null) {
        this.autoApproveUsers = new ArrayList();
        for (String item : autoApproveUsers) {
          this.addToAutoApproveUsers(item);
        }
    } else {
      this.autoApproveUsers = null;
    }
    return (A) this;
  }
  
  public A withAutoApproveUsers(String... autoApproveUsers) {
    if (this.autoApproveUsers != null) {
        this.autoApproveUsers.clear();
        _visitables.remove("autoApproveUsers");
    }
    if (autoApproveUsers != null) {
      for (String item : autoApproveUsers) {
        this.addToAutoApproveUsers(item);
      }
    }
    return (A) this;
  }
  
  public A withFeatureGates(List<FeatureGate> featureGates) {
    if (this.featureGates != null) {
      this._visitables.get("featureGates").clear();
    }
    if (featureGates != null) {
        this.featureGates = new ArrayList();
        for (FeatureGate item : featureGates) {
          this.addToFeatureGates(item);
        }
    } else {
      this.featureGates = null;
    }
    return (A) this;
  }
  
  public A withFeatureGates(FeatureGate... featureGates) {
    if (this.featureGates != null) {
        this.featureGates.clear();
        _visitables.remove("featureGates");
    }
    if (featureGates != null) {
      for (FeatureGate item : featureGates) {
        this.addToFeatureGates(item);
      }
    }
    return (A) this;
  }
  
  public A withImporterConfiguration(ImporterConfiguration importerConfiguration) {
    this._visitables.remove("importerConfiguration");
    if (importerConfiguration != null) {
        this.importerConfiguration = new ImporterConfigurationBuilder(importerConfiguration);
        this._visitables.get("importerConfiguration").add(this.importerConfiguration);
    } else {
        this.importerConfiguration = null;
        this._visitables.get("importerConfiguration").remove(this.importerConfiguration);
    }
    return (A) this;
  }
  
  public ImporterConfigurationNested<A> withNewImporterConfiguration() {
    return new ImporterConfigurationNested(null);
  }
  
  public ImporterConfigurationNested<A> withNewImporterConfigurationLike(ImporterConfiguration item) {
    return new ImporterConfigurationNested(item);
  }
  
  public A withRegistrationDrivers(List<RegistrationDriverHub> registrationDrivers) {
    if (this.registrationDrivers != null) {
      this._visitables.get("registrationDrivers").clear();
    }
    if (registrationDrivers != null) {
        this.registrationDrivers = new ArrayList();
        for (RegistrationDriverHub item : registrationDrivers) {
          this.addToRegistrationDrivers(item);
        }
    } else {
      this.registrationDrivers = null;
    }
    return (A) this;
  }
  
  public A withRegistrationDrivers(RegistrationDriverHub... registrationDrivers) {
    if (this.registrationDrivers != null) {
        this.registrationDrivers.clear();
        _visitables.remove("registrationDrivers");
    }
    if (registrationDrivers != null) {
      for (RegistrationDriverHub item : registrationDrivers) {
        this.addToRegistrationDrivers(item);
      }
    }
    return (A) this;
  }
  public class FeatureGatesNested<N> extends FeatureGateFluent<FeatureGatesNested<N>> implements Nested<N>{
  
    FeatureGateBuilder builder;
    int index;
  
    FeatureGatesNested(int index,FeatureGate item) {
      this.index = index;
      this.builder = new FeatureGateBuilder(this, item);
    }
  
    public N and() {
      return (N) RegistrationHubConfigurationFluent.this.setToFeatureGates(index, builder.build());
    }
    
    public N endFeatureGate() {
      return and();
    }
    
  }
  public class ImporterConfigurationNested<N> extends ImporterConfigurationFluent<ImporterConfigurationNested<N>> implements Nested<N>{
  
    ImporterConfigurationBuilder builder;
  
    ImporterConfigurationNested(ImporterConfiguration item) {
      this.builder = new ImporterConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) RegistrationHubConfigurationFluent.this.withImporterConfiguration(builder.build());
    }
    
    public N endImporterConfiguration() {
      return and();
    }
    
  }
  public class RegistrationDriversNested<N> extends RegistrationDriverHubFluent<RegistrationDriversNested<N>> implements Nested<N>{
  
    RegistrationDriverHubBuilder builder;
    int index;
  
    RegistrationDriversNested(int index,RegistrationDriverHub item) {
      this.index = index;
      this.builder = new RegistrationDriverHubBuilder(this, item);
    }
  
    public N and() {
      return (N) RegistrationHubConfigurationFluent.this.setToRegistrationDrivers(index, builder.build());
    }
    
    public N endRegistrationDriver() {
      return and();
    }
    
  }
}