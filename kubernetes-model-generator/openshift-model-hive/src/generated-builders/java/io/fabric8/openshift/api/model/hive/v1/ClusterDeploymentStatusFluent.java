package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ClusterDeploymentStatusFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterDeploymentStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiURL;
  private ArrayList<CertificateBundleStatusBuilder> certificateBundles = new ArrayList<CertificateBundleStatusBuilder>();
  private String cliImage;
  private ArrayList<ClusterDeploymentConditionBuilder> conditions = new ArrayList<ClusterDeploymentConditionBuilder>();
  private Integer installRestarts;
  private String installStartedTimestamp;
  private String installVersion;
  private String installedTimestamp;
  private String installerImage;
  private PlatformStatusBuilder platformStatus;
  private String powerState;
  private LocalObjectReferenceBuilder provisionRef;
  private String webConsoleURL;

  public ClusterDeploymentStatusFluent() {
  }
  
  public ClusterDeploymentStatusFluent(ClusterDeploymentStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToCertificateBundles(Collection<CertificateBundleStatus> items) {
    if (this.certificateBundles == null) {
      this.certificateBundles = new ArrayList();
    }
    for (CertificateBundleStatus item : items) {
        CertificateBundleStatusBuilder builder = new CertificateBundleStatusBuilder(item);
        _visitables.get("certificateBundles").add(builder);
        this.certificateBundles.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<ClusterDeploymentCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterDeploymentCondition item : items) {
        ClusterDeploymentConditionBuilder builder = new ClusterDeploymentConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public CertificateBundlesNested<A> addNewCertificateBundle() {
    return new CertificateBundlesNested(-1, null);
  }
  
  public A addNewCertificateBundle(Boolean generated,String name) {
    return (A) this.addToCertificateBundles(new CertificateBundleStatus(generated, name));
  }
  
  public CertificateBundlesNested<A> addNewCertificateBundleLike(CertificateBundleStatus item) {
    return new CertificateBundlesNested(-1, item);
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(ClusterDeploymentCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToCertificateBundles(CertificateBundleStatus... items) {
    if (this.certificateBundles == null) {
      this.certificateBundles = new ArrayList();
    }
    for (CertificateBundleStatus item : items) {
        CertificateBundleStatusBuilder builder = new CertificateBundleStatusBuilder(item);
        _visitables.get("certificateBundles").add(builder);
        this.certificateBundles.add(builder);
    }
    return (A) this;
  }
  
  public A addToCertificateBundles(int index,CertificateBundleStatus item) {
    if (this.certificateBundles == null) {
      this.certificateBundles = new ArrayList();
    }
    CertificateBundleStatusBuilder builder = new CertificateBundleStatusBuilder(item);
    if (index < 0 || index >= certificateBundles.size()) {
        _visitables.get("certificateBundles").add(builder);
        certificateBundles.add(builder);
    } else {
        _visitables.get("certificateBundles").add(builder);
        certificateBundles.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToConditions(ClusterDeploymentCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterDeploymentCondition item : items) {
        ClusterDeploymentConditionBuilder builder = new ClusterDeploymentConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,ClusterDeploymentCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterDeploymentConditionBuilder builder = new ClusterDeploymentConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public CertificateBundleStatus buildCertificateBundle(int index) {
    return this.certificateBundles.get(index).build();
  }
  
  public List<CertificateBundleStatus> buildCertificateBundles() {
    return this.certificateBundles != null ? build(certificateBundles) : null;
  }
  
  public ClusterDeploymentCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<ClusterDeploymentCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public CertificateBundleStatus buildFirstCertificateBundle() {
    return this.certificateBundles.get(0).build();
  }
  
  public ClusterDeploymentCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public CertificateBundleStatus buildLastCertificateBundle() {
    return this.certificateBundles.get(certificateBundles.size() - 1).build();
  }
  
  public ClusterDeploymentCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public CertificateBundleStatus buildMatchingCertificateBundle(Predicate<CertificateBundleStatusBuilder> predicate) {
      for (CertificateBundleStatusBuilder item : certificateBundles) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterDeploymentCondition buildMatchingCondition(Predicate<ClusterDeploymentConditionBuilder> predicate) {
      for (ClusterDeploymentConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PlatformStatus buildPlatformStatus() {
    return this.platformStatus != null ? this.platformStatus.build() : null;
  }
  
  public LocalObjectReference buildProvisionRef() {
    return this.provisionRef != null ? this.provisionRef.build() : null;
  }
  
  protected void copyInstance(ClusterDeploymentStatus instance) {
    instance = instance != null ? instance : new ClusterDeploymentStatus();
    if (instance != null) {
        this.withApiURL(instance.getApiURL());
        this.withCertificateBundles(instance.getCertificateBundles());
        this.withCliImage(instance.getCliImage());
        this.withConditions(instance.getConditions());
        this.withInstallRestarts(instance.getInstallRestarts());
        this.withInstallStartedTimestamp(instance.getInstallStartedTimestamp());
        this.withInstallVersion(instance.getInstallVersion());
        this.withInstalledTimestamp(instance.getInstalledTimestamp());
        this.withInstallerImage(instance.getInstallerImage());
        this.withPlatformStatus(instance.getPlatformStatus());
        this.withPowerState(instance.getPowerState());
        this.withProvisionRef(instance.getProvisionRef());
        this.withWebConsoleURL(instance.getWebConsoleURL());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CertificateBundlesNested<A> editCertificateBundle(int index) {
    if (certificateBundles.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "certificateBundles"));
    }
    return this.setNewCertificateBundleLike(index, this.buildCertificateBundle(index));
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public CertificateBundlesNested<A> editFirstCertificateBundle() {
    if (certificateBundles.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "certificateBundles"));
    }
    return this.setNewCertificateBundleLike(0, this.buildCertificateBundle(0));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public CertificateBundlesNested<A> editLastCertificateBundle() {
    int index = certificateBundles.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "certificateBundles"));
    }
    return this.setNewCertificateBundleLike(index, this.buildCertificateBundle(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public CertificateBundlesNested<A> editMatchingCertificateBundle(Predicate<CertificateBundleStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < certificateBundles.size();i++) {
      if (predicate.test(certificateBundles.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "certificateBundles"));
    }
    return this.setNewCertificateBundleLike(index, this.buildCertificateBundle(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<ClusterDeploymentConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public PlatformStatusNested<A> editOrNewPlatformStatus() {
    return this.withNewPlatformStatusLike(Optional.ofNullable(this.buildPlatformStatus()).orElse(new PlatformStatusBuilder().build()));
  }
  
  public PlatformStatusNested<A> editOrNewPlatformStatusLike(PlatformStatus item) {
    return this.withNewPlatformStatusLike(Optional.ofNullable(this.buildPlatformStatus()).orElse(item));
  }
  
  public ProvisionRefNested<A> editOrNewProvisionRef() {
    return this.withNewProvisionRefLike(Optional.ofNullable(this.buildProvisionRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public ProvisionRefNested<A> editOrNewProvisionRefLike(LocalObjectReference item) {
    return this.withNewProvisionRefLike(Optional.ofNullable(this.buildProvisionRef()).orElse(item));
  }
  
  public PlatformStatusNested<A> editPlatformStatus() {
    return this.withNewPlatformStatusLike(Optional.ofNullable(this.buildPlatformStatus()).orElse(null));
  }
  
  public ProvisionRefNested<A> editProvisionRef() {
    return this.withNewProvisionRefLike(Optional.ofNullable(this.buildProvisionRef()).orElse(null));
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
    ClusterDeploymentStatusFluent that = (ClusterDeploymentStatusFluent) o;
    if (!(Objects.equals(apiURL, that.apiURL))) {
      return false;
    }
    if (!(Objects.equals(certificateBundles, that.certificateBundles))) {
      return false;
    }
    if (!(Objects.equals(cliImage, that.cliImage))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(installRestarts, that.installRestarts))) {
      return false;
    }
    if (!(Objects.equals(installStartedTimestamp, that.installStartedTimestamp))) {
      return false;
    }
    if (!(Objects.equals(installVersion, that.installVersion))) {
      return false;
    }
    if (!(Objects.equals(installedTimestamp, that.installedTimestamp))) {
      return false;
    }
    if (!(Objects.equals(installerImage, that.installerImage))) {
      return false;
    }
    if (!(Objects.equals(platformStatus, that.platformStatus))) {
      return false;
    }
    if (!(Objects.equals(powerState, that.powerState))) {
      return false;
    }
    if (!(Objects.equals(provisionRef, that.provisionRef))) {
      return false;
    }
    if (!(Objects.equals(webConsoleURL, that.webConsoleURL))) {
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
  
  public String getApiURL() {
    return this.apiURL;
  }
  
  public String getCliImage() {
    return this.cliImage;
  }
  
  public Integer getInstallRestarts() {
    return this.installRestarts;
  }
  
  public String getInstallStartedTimestamp() {
    return this.installStartedTimestamp;
  }
  
  public String getInstallVersion() {
    return this.installVersion;
  }
  
  public String getInstalledTimestamp() {
    return this.installedTimestamp;
  }
  
  public String getInstallerImage() {
    return this.installerImage;
  }
  
  public String getPowerState() {
    return this.powerState;
  }
  
  public String getWebConsoleURL() {
    return this.webConsoleURL;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiURL() {
    return this.apiURL != null;
  }
  
  public boolean hasCertificateBundles() {
    return this.certificateBundles != null && !(this.certificateBundles.isEmpty());
  }
  
  public boolean hasCliImage() {
    return this.cliImage != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasInstallRestarts() {
    return this.installRestarts != null;
  }
  
  public boolean hasInstallStartedTimestamp() {
    return this.installStartedTimestamp != null;
  }
  
  public boolean hasInstallVersion() {
    return this.installVersion != null;
  }
  
  public boolean hasInstalledTimestamp() {
    return this.installedTimestamp != null;
  }
  
  public boolean hasInstallerImage() {
    return this.installerImage != null;
  }
  
  public boolean hasMatchingCertificateBundle(Predicate<CertificateBundleStatusBuilder> predicate) {
      for (CertificateBundleStatusBuilder item : certificateBundles) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<ClusterDeploymentConditionBuilder> predicate) {
      for (ClusterDeploymentConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPlatformStatus() {
    return this.platformStatus != null;
  }
  
  public boolean hasPowerState() {
    return this.powerState != null;
  }
  
  public boolean hasProvisionRef() {
    return this.provisionRef != null;
  }
  
  public boolean hasWebConsoleURL() {
    return this.webConsoleURL != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiURL, certificateBundles, cliImage, conditions, installRestarts, installStartedTimestamp, installVersion, installedTimestamp, installerImage, platformStatus, powerState, provisionRef, webConsoleURL, additionalProperties);
  }
  
  public A removeAllFromCertificateBundles(Collection<CertificateBundleStatus> items) {
    if (this.certificateBundles == null) {
      return (A) this;
    }
    for (CertificateBundleStatus item : items) {
        CertificateBundleStatusBuilder builder = new CertificateBundleStatusBuilder(item);
        _visitables.get("certificateBundles").remove(builder);
        this.certificateBundles.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<ClusterDeploymentCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterDeploymentCondition item : items) {
        ClusterDeploymentConditionBuilder builder = new ClusterDeploymentConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromCertificateBundles(CertificateBundleStatus... items) {
    if (this.certificateBundles == null) {
      return (A) this;
    }
    for (CertificateBundleStatus item : items) {
        CertificateBundleStatusBuilder builder = new CertificateBundleStatusBuilder(item);
        _visitables.get("certificateBundles").remove(builder);
        this.certificateBundles.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromConditions(ClusterDeploymentCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterDeploymentCondition item : items) {
        ClusterDeploymentConditionBuilder builder = new ClusterDeploymentConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCertificateBundles(Predicate<CertificateBundleStatusBuilder> predicate) {
    if (certificateBundles == null) {
      return (A) this;
    }
    Iterator<CertificateBundleStatusBuilder> each = certificateBundles.iterator();
    List visitables = _visitables.get("certificateBundles");
    while (each.hasNext()) {
        CertificateBundleStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<ClusterDeploymentConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<ClusterDeploymentConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        ClusterDeploymentConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CertificateBundlesNested<A> setNewCertificateBundleLike(int index,CertificateBundleStatus item) {
    return new CertificateBundlesNested(index, item);
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,ClusterDeploymentCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToCertificateBundles(int index,CertificateBundleStatus item) {
    if (this.certificateBundles == null) {
      this.certificateBundles = new ArrayList();
    }
    CertificateBundleStatusBuilder builder = new CertificateBundleStatusBuilder(item);
    if (index < 0 || index >= certificateBundles.size()) {
        _visitables.get("certificateBundles").add(builder);
        certificateBundles.add(builder);
    } else {
        _visitables.get("certificateBundles").add(builder);
        certificateBundles.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,ClusterDeploymentCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterDeploymentConditionBuilder builder = new ClusterDeploymentConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiURL == null)) {
        sb.append("apiURL:");
        sb.append(apiURL);
        sb.append(",");
    }
    if (!(certificateBundles == null) && !(certificateBundles.isEmpty())) {
        sb.append("certificateBundles:");
        sb.append(certificateBundles);
        sb.append(",");
    }
    if (!(cliImage == null)) {
        sb.append("cliImage:");
        sb.append(cliImage);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(installRestarts == null)) {
        sb.append("installRestarts:");
        sb.append(installRestarts);
        sb.append(",");
    }
    if (!(installStartedTimestamp == null)) {
        sb.append("installStartedTimestamp:");
        sb.append(installStartedTimestamp);
        sb.append(",");
    }
    if (!(installVersion == null)) {
        sb.append("installVersion:");
        sb.append(installVersion);
        sb.append(",");
    }
    if (!(installedTimestamp == null)) {
        sb.append("installedTimestamp:");
        sb.append(installedTimestamp);
        sb.append(",");
    }
    if (!(installerImage == null)) {
        sb.append("installerImage:");
        sb.append(installerImage);
        sb.append(",");
    }
    if (!(platformStatus == null)) {
        sb.append("platformStatus:");
        sb.append(platformStatus);
        sb.append(",");
    }
    if (!(powerState == null)) {
        sb.append("powerState:");
        sb.append(powerState);
        sb.append(",");
    }
    if (!(provisionRef == null)) {
        sb.append("provisionRef:");
        sb.append(provisionRef);
        sb.append(",");
    }
    if (!(webConsoleURL == null)) {
        sb.append("webConsoleURL:");
        sb.append(webConsoleURL);
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
  
  public A withApiURL(String apiURL) {
    this.apiURL = apiURL;
    return (A) this;
  }
  
  public A withCertificateBundles(List<CertificateBundleStatus> certificateBundles) {
    if (this.certificateBundles != null) {
      this._visitables.get("certificateBundles").clear();
    }
    if (certificateBundles != null) {
        this.certificateBundles = new ArrayList();
        for (CertificateBundleStatus item : certificateBundles) {
          this.addToCertificateBundles(item);
        }
    } else {
      this.certificateBundles = null;
    }
    return (A) this;
  }
  
  public A withCertificateBundles(CertificateBundleStatus... certificateBundles) {
    if (this.certificateBundles != null) {
        this.certificateBundles.clear();
        _visitables.remove("certificateBundles");
    }
    if (certificateBundles != null) {
      for (CertificateBundleStatus item : certificateBundles) {
        this.addToCertificateBundles(item);
      }
    }
    return (A) this;
  }
  
  public A withCliImage(String cliImage) {
    this.cliImage = cliImage;
    return (A) this;
  }
  
  public A withConditions(List<ClusterDeploymentCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (ClusterDeploymentCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(ClusterDeploymentCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (ClusterDeploymentCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withInstallRestarts(Integer installRestarts) {
    this.installRestarts = installRestarts;
    return (A) this;
  }
  
  public A withInstallStartedTimestamp(String installStartedTimestamp) {
    this.installStartedTimestamp = installStartedTimestamp;
    return (A) this;
  }
  
  public A withInstallVersion(String installVersion) {
    this.installVersion = installVersion;
    return (A) this;
  }
  
  public A withInstalledTimestamp(String installedTimestamp) {
    this.installedTimestamp = installedTimestamp;
    return (A) this;
  }
  
  public A withInstallerImage(String installerImage) {
    this.installerImage = installerImage;
    return (A) this;
  }
  
  public PlatformStatusNested<A> withNewPlatformStatus() {
    return new PlatformStatusNested(null);
  }
  
  public PlatformStatusNested<A> withNewPlatformStatusLike(PlatformStatus item) {
    return new PlatformStatusNested(item);
  }
  
  public ProvisionRefNested<A> withNewProvisionRef() {
    return new ProvisionRefNested(null);
  }
  
  public A withNewProvisionRef(String name) {
    return (A) this.withProvisionRef(new LocalObjectReference(name));
  }
  
  public ProvisionRefNested<A> withNewProvisionRefLike(LocalObjectReference item) {
    return new ProvisionRefNested(item);
  }
  
  public A withPlatformStatus(PlatformStatus platformStatus) {
    this._visitables.remove("platformStatus");
    if (platformStatus != null) {
        this.platformStatus = new PlatformStatusBuilder(platformStatus);
        this._visitables.get("platformStatus").add(this.platformStatus);
    } else {
        this.platformStatus = null;
        this._visitables.get("platformStatus").remove(this.platformStatus);
    }
    return (A) this;
  }
  
  public A withPowerState(String powerState) {
    this.powerState = powerState;
    return (A) this;
  }
  
  public A withProvisionRef(LocalObjectReference provisionRef) {
    this._visitables.remove("provisionRef");
    if (provisionRef != null) {
        this.provisionRef = new LocalObjectReferenceBuilder(provisionRef);
        this._visitables.get("provisionRef").add(this.provisionRef);
    } else {
        this.provisionRef = null;
        this._visitables.get("provisionRef").remove(this.provisionRef);
    }
    return (A) this;
  }
  
  public A withWebConsoleURL(String webConsoleURL) {
    this.webConsoleURL = webConsoleURL;
    return (A) this;
  }
  public class CertificateBundlesNested<N> extends CertificateBundleStatusFluent<CertificateBundlesNested<N>> implements Nested<N>{
  
    CertificateBundleStatusBuilder builder;
    int index;
  
    CertificateBundlesNested(int index,CertificateBundleStatus item) {
      this.index = index;
      this.builder = new CertificateBundleStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentStatusFluent.this.setToCertificateBundles(index, builder.build());
    }
    
    public N endCertificateBundle() {
      return and();
    }
    
  }
  public class ConditionsNested<N> extends ClusterDeploymentConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ClusterDeploymentConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,ClusterDeploymentCondition item) {
      this.index = index;
      this.builder = new ClusterDeploymentConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class PlatformStatusNested<N> extends PlatformStatusFluent<PlatformStatusNested<N>> implements Nested<N>{
  
    PlatformStatusBuilder builder;
  
    PlatformStatusNested(PlatformStatus item) {
      this.builder = new PlatformStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentStatusFluent.this.withPlatformStatus(builder.build());
    }
    
    public N endPlatformStatus() {
      return and();
    }
    
  }
  public class ProvisionRefNested<N> extends LocalObjectReferenceFluent<ProvisionRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    ProvisionRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeploymentStatusFluent.this.withProvisionRef(builder.build());
    }
    
    public N endProvisionRef() {
      return and();
    }
    
  }
}