package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelector;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorBuilder;
import io.fabric8.certmanager.api.model.meta.v1.SecretKeySelectorFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class ACMEIssuerFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String caBundle;
  private Boolean disableAccountKeyGeneration;
  private String email;
  private Boolean enableDurationFeature;
  private ACMEExternalAccountBindingBuilder externalAccountBinding;
  private String preferredChain;
  private SecretKeySelectorBuilder privateKeySecretRef;
  private String profile;
  private String server;
  private Boolean skipTLSVerify;
  private ArrayList<ACMEChallengeSolverBuilder> solvers = new ArrayList<ACMEChallengeSolverBuilder>();

  public ACMEIssuerFluent() {
  }
  
  public ACMEIssuerFluent(ACMEIssuer instance) {
    this.copyInstance(instance);
  }

  public A addAllToSolvers(Collection<ACMEChallengeSolver> items) {
    if (this.solvers == null) {
      this.solvers = new ArrayList();
    }
    for (ACMEChallengeSolver item : items) {
        ACMEChallengeSolverBuilder builder = new ACMEChallengeSolverBuilder(item);
        _visitables.get("solvers").add(builder);
        this.solvers.add(builder);
    }
    return (A) this;
  }
  
  public SolversNested<A> addNewSolver() {
    return new SolversNested(-1, null);
  }
  
  public SolversNested<A> addNewSolverLike(ACMEChallengeSolver item) {
    return new SolversNested(-1, item);
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
  
  public A addToSolvers(ACMEChallengeSolver... items) {
    if (this.solvers == null) {
      this.solvers = new ArrayList();
    }
    for (ACMEChallengeSolver item : items) {
        ACMEChallengeSolverBuilder builder = new ACMEChallengeSolverBuilder(item);
        _visitables.get("solvers").add(builder);
        this.solvers.add(builder);
    }
    return (A) this;
  }
  
  public A addToSolvers(int index,ACMEChallengeSolver item) {
    if (this.solvers == null) {
      this.solvers = new ArrayList();
    }
    ACMEChallengeSolverBuilder builder = new ACMEChallengeSolverBuilder(item);
    if (index < 0 || index >= solvers.size()) {
        _visitables.get("solvers").add(builder);
        solvers.add(builder);
    } else {
        _visitables.get("solvers").add(builder);
        solvers.add(index, builder);
    }
    return (A) this;
  }
  
  public ACMEExternalAccountBinding buildExternalAccountBinding() {
    return this.externalAccountBinding != null ? this.externalAccountBinding.build() : null;
  }
  
  public ACMEChallengeSolver buildFirstSolver() {
    return this.solvers.get(0).build();
  }
  
  public ACMEChallengeSolver buildLastSolver() {
    return this.solvers.get(solvers.size() - 1).build();
  }
  
  public ACMEChallengeSolver buildMatchingSolver(Predicate<ACMEChallengeSolverBuilder> predicate) {
      for (ACMEChallengeSolverBuilder item : solvers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SecretKeySelector buildPrivateKeySecretRef() {
    return this.privateKeySecretRef != null ? this.privateKeySecretRef.build() : null;
  }
  
  public ACMEChallengeSolver buildSolver(int index) {
    return this.solvers.get(index).build();
  }
  
  public List<ACMEChallengeSolver> buildSolvers() {
    return this.solvers != null ? build(solvers) : null;
  }
  
  protected void copyInstance(ACMEIssuer instance) {
    instance = instance != null ? instance : new ACMEIssuer();
    if (instance != null) {
        this.withCaBundle(instance.getCaBundle());
        this.withDisableAccountKeyGeneration(instance.getDisableAccountKeyGeneration());
        this.withEmail(instance.getEmail());
        this.withEnableDurationFeature(instance.getEnableDurationFeature());
        this.withExternalAccountBinding(instance.getExternalAccountBinding());
        this.withPreferredChain(instance.getPreferredChain());
        this.withPrivateKeySecretRef(instance.getPrivateKeySecretRef());
        this.withProfile(instance.getProfile());
        this.withServer(instance.getServer());
        this.withSkipTLSVerify(instance.getSkipTLSVerify());
        this.withSolvers(instance.getSolvers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExternalAccountBindingNested<A> editExternalAccountBinding() {
    return this.withNewExternalAccountBindingLike(Optional.ofNullable(this.buildExternalAccountBinding()).orElse(null));
  }
  
  public SolversNested<A> editFirstSolver() {
    if (solvers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "solvers"));
    }
    return this.setNewSolverLike(0, this.buildSolver(0));
  }
  
  public SolversNested<A> editLastSolver() {
    int index = solvers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "solvers"));
    }
    return this.setNewSolverLike(index, this.buildSolver(index));
  }
  
  public SolversNested<A> editMatchingSolver(Predicate<ACMEChallengeSolverBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < solvers.size();i++) {
      if (predicate.test(solvers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "solvers"));
    }
    return this.setNewSolverLike(index, this.buildSolver(index));
  }
  
  public ExternalAccountBindingNested<A> editOrNewExternalAccountBinding() {
    return this.withNewExternalAccountBindingLike(Optional.ofNullable(this.buildExternalAccountBinding()).orElse(new ACMEExternalAccountBindingBuilder().build()));
  }
  
  public ExternalAccountBindingNested<A> editOrNewExternalAccountBindingLike(ACMEExternalAccountBinding item) {
    return this.withNewExternalAccountBindingLike(Optional.ofNullable(this.buildExternalAccountBinding()).orElse(item));
  }
  
  public PrivateKeySecretRefNested<A> editOrNewPrivateKeySecretRef() {
    return this.withNewPrivateKeySecretRefLike(Optional.ofNullable(this.buildPrivateKeySecretRef()).orElse(new SecretKeySelectorBuilder().build()));
  }
  
  public PrivateKeySecretRefNested<A> editOrNewPrivateKeySecretRefLike(SecretKeySelector item) {
    return this.withNewPrivateKeySecretRefLike(Optional.ofNullable(this.buildPrivateKeySecretRef()).orElse(item));
  }
  
  public PrivateKeySecretRefNested<A> editPrivateKeySecretRef() {
    return this.withNewPrivateKeySecretRefLike(Optional.ofNullable(this.buildPrivateKeySecretRef()).orElse(null));
  }
  
  public SolversNested<A> editSolver(int index) {
    if (solvers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "solvers"));
    }
    return this.setNewSolverLike(index, this.buildSolver(index));
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
    ACMEIssuerFluent that = (ACMEIssuerFluent) o;
    if (!(Objects.equals(caBundle, that.caBundle))) {
      return false;
    }
    if (!(Objects.equals(disableAccountKeyGeneration, that.disableAccountKeyGeneration))) {
      return false;
    }
    if (!(Objects.equals(email, that.email))) {
      return false;
    }
    if (!(Objects.equals(enableDurationFeature, that.enableDurationFeature))) {
      return false;
    }
    if (!(Objects.equals(externalAccountBinding, that.externalAccountBinding))) {
      return false;
    }
    if (!(Objects.equals(preferredChain, that.preferredChain))) {
      return false;
    }
    if (!(Objects.equals(privateKeySecretRef, that.privateKeySecretRef))) {
      return false;
    }
    if (!(Objects.equals(profile, that.profile))) {
      return false;
    }
    if (!(Objects.equals(server, that.server))) {
      return false;
    }
    if (!(Objects.equals(skipTLSVerify, that.skipTLSVerify))) {
      return false;
    }
    if (!(Objects.equals(solvers, that.solvers))) {
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
  
  public String getCaBundle() {
    return this.caBundle;
  }
  
  public Boolean getDisableAccountKeyGeneration() {
    return this.disableAccountKeyGeneration;
  }
  
  public String getEmail() {
    return this.email;
  }
  
  public Boolean getEnableDurationFeature() {
    return this.enableDurationFeature;
  }
  
  public String getPreferredChain() {
    return this.preferredChain;
  }
  
  public String getProfile() {
    return this.profile;
  }
  
  public String getServer() {
    return this.server;
  }
  
  public Boolean getSkipTLSVerify() {
    return this.skipTLSVerify;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCaBundle() {
    return this.caBundle != null;
  }
  
  public boolean hasDisableAccountKeyGeneration() {
    return this.disableAccountKeyGeneration != null;
  }
  
  public boolean hasEmail() {
    return this.email != null;
  }
  
  public boolean hasEnableDurationFeature() {
    return this.enableDurationFeature != null;
  }
  
  public boolean hasExternalAccountBinding() {
    return this.externalAccountBinding != null;
  }
  
  public boolean hasMatchingSolver(Predicate<ACMEChallengeSolverBuilder> predicate) {
      for (ACMEChallengeSolverBuilder item : solvers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPreferredChain() {
    return this.preferredChain != null;
  }
  
  public boolean hasPrivateKeySecretRef() {
    return this.privateKeySecretRef != null;
  }
  
  public boolean hasProfile() {
    return this.profile != null;
  }
  
  public boolean hasServer() {
    return this.server != null;
  }
  
  public boolean hasSkipTLSVerify() {
    return this.skipTLSVerify != null;
  }
  
  public boolean hasSolvers() {
    return this.solvers != null && !(this.solvers.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(caBundle, disableAccountKeyGeneration, email, enableDurationFeature, externalAccountBinding, preferredChain, privateKeySecretRef, profile, server, skipTLSVerify, solvers, additionalProperties);
  }
  
  public A removeAllFromSolvers(Collection<ACMEChallengeSolver> items) {
    if (this.solvers == null) {
      return (A) this;
    }
    for (ACMEChallengeSolver item : items) {
        ACMEChallengeSolverBuilder builder = new ACMEChallengeSolverBuilder(item);
        _visitables.get("solvers").remove(builder);
        this.solvers.remove(builder);
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
  
  public A removeFromSolvers(ACMEChallengeSolver... items) {
    if (this.solvers == null) {
      return (A) this;
    }
    for (ACMEChallengeSolver item : items) {
        ACMEChallengeSolverBuilder builder = new ACMEChallengeSolverBuilder(item);
        _visitables.get("solvers").remove(builder);
        this.solvers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSolvers(Predicate<ACMEChallengeSolverBuilder> predicate) {
    if (solvers == null) {
      return (A) this;
    }
    Iterator<ACMEChallengeSolverBuilder> each = solvers.iterator();
    List visitables = _visitables.get("solvers");
    while (each.hasNext()) {
        ACMEChallengeSolverBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SolversNested<A> setNewSolverLike(int index,ACMEChallengeSolver item) {
    return new SolversNested(index, item);
  }
  
  public A setToSolvers(int index,ACMEChallengeSolver item) {
    if (this.solvers == null) {
      this.solvers = new ArrayList();
    }
    ACMEChallengeSolverBuilder builder = new ACMEChallengeSolverBuilder(item);
    if (index < 0 || index >= solvers.size()) {
        _visitables.get("solvers").add(builder);
        solvers.add(builder);
    } else {
        _visitables.get("solvers").add(builder);
        solvers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(caBundle == null)) {
        sb.append("caBundle:");
        sb.append(caBundle);
        sb.append(",");
    }
    if (!(disableAccountKeyGeneration == null)) {
        sb.append("disableAccountKeyGeneration:");
        sb.append(disableAccountKeyGeneration);
        sb.append(",");
    }
    if (!(email == null)) {
        sb.append("email:");
        sb.append(email);
        sb.append(",");
    }
    if (!(enableDurationFeature == null)) {
        sb.append("enableDurationFeature:");
        sb.append(enableDurationFeature);
        sb.append(",");
    }
    if (!(externalAccountBinding == null)) {
        sb.append("externalAccountBinding:");
        sb.append(externalAccountBinding);
        sb.append(",");
    }
    if (!(preferredChain == null)) {
        sb.append("preferredChain:");
        sb.append(preferredChain);
        sb.append(",");
    }
    if (!(privateKeySecretRef == null)) {
        sb.append("privateKeySecretRef:");
        sb.append(privateKeySecretRef);
        sb.append(",");
    }
    if (!(profile == null)) {
        sb.append("profile:");
        sb.append(profile);
        sb.append(",");
    }
    if (!(server == null)) {
        sb.append("server:");
        sb.append(server);
        sb.append(",");
    }
    if (!(skipTLSVerify == null)) {
        sb.append("skipTLSVerify:");
        sb.append(skipTLSVerify);
        sb.append(",");
    }
    if (!(solvers == null) && !(solvers.isEmpty())) {
        sb.append("solvers:");
        sb.append(solvers);
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
  
  public A withCaBundle(String caBundle) {
    this.caBundle = caBundle;
    return (A) this;
  }
  
  public A withDisableAccountKeyGeneration() {
    return withDisableAccountKeyGeneration(true);
  }
  
  public A withDisableAccountKeyGeneration(Boolean disableAccountKeyGeneration) {
    this.disableAccountKeyGeneration = disableAccountKeyGeneration;
    return (A) this;
  }
  
  public A withEmail(String email) {
    this.email = email;
    return (A) this;
  }
  
  public A withEnableDurationFeature() {
    return withEnableDurationFeature(true);
  }
  
  public A withEnableDurationFeature(Boolean enableDurationFeature) {
    this.enableDurationFeature = enableDurationFeature;
    return (A) this;
  }
  
  public A withExternalAccountBinding(ACMEExternalAccountBinding externalAccountBinding) {
    this._visitables.remove("externalAccountBinding");
    if (externalAccountBinding != null) {
        this.externalAccountBinding = new ACMEExternalAccountBindingBuilder(externalAccountBinding);
        this._visitables.get("externalAccountBinding").add(this.externalAccountBinding);
    } else {
        this.externalAccountBinding = null;
        this._visitables.get("externalAccountBinding").remove(this.externalAccountBinding);
    }
    return (A) this;
  }
  
  public ExternalAccountBindingNested<A> withNewExternalAccountBinding() {
    return new ExternalAccountBindingNested(null);
  }
  
  public ExternalAccountBindingNested<A> withNewExternalAccountBindingLike(ACMEExternalAccountBinding item) {
    return new ExternalAccountBindingNested(item);
  }
  
  public PrivateKeySecretRefNested<A> withNewPrivateKeySecretRef() {
    return new PrivateKeySecretRefNested(null);
  }
  
  public A withNewPrivateKeySecretRef(String key,String name) {
    return (A) this.withPrivateKeySecretRef(new SecretKeySelector(key, name));
  }
  
  public PrivateKeySecretRefNested<A> withNewPrivateKeySecretRefLike(SecretKeySelector item) {
    return new PrivateKeySecretRefNested(item);
  }
  
  public A withPreferredChain(String preferredChain) {
    this.preferredChain = preferredChain;
    return (A) this;
  }
  
  public A withPrivateKeySecretRef(SecretKeySelector privateKeySecretRef) {
    this._visitables.remove("privateKeySecretRef");
    if (privateKeySecretRef != null) {
        this.privateKeySecretRef = new SecretKeySelectorBuilder(privateKeySecretRef);
        this._visitables.get("privateKeySecretRef").add(this.privateKeySecretRef);
    } else {
        this.privateKeySecretRef = null;
        this._visitables.get("privateKeySecretRef").remove(this.privateKeySecretRef);
    }
    return (A) this;
  }
  
  public A withProfile(String profile) {
    this.profile = profile;
    return (A) this;
  }
  
  public A withServer(String server) {
    this.server = server;
    return (A) this;
  }
  
  public A withSkipTLSVerify() {
    return withSkipTLSVerify(true);
  }
  
  public A withSkipTLSVerify(Boolean skipTLSVerify) {
    this.skipTLSVerify = skipTLSVerify;
    return (A) this;
  }
  
  public A withSolvers(List<ACMEChallengeSolver> solvers) {
    if (this.solvers != null) {
      this._visitables.get("solvers").clear();
    }
    if (solvers != null) {
        this.solvers = new ArrayList();
        for (ACMEChallengeSolver item : solvers) {
          this.addToSolvers(item);
        }
    } else {
      this.solvers = null;
    }
    return (A) this;
  }
  
  public A withSolvers(ACMEChallengeSolver... solvers) {
    if (this.solvers != null) {
        this.solvers.clear();
        _visitables.remove("solvers");
    }
    if (solvers != null) {
      for (ACMEChallengeSolver item : solvers) {
        this.addToSolvers(item);
      }
    }
    return (A) this;
  }
  public class ExternalAccountBindingNested<N> extends ACMEExternalAccountBindingFluent<ExternalAccountBindingNested<N>> implements Nested<N>{
  
    ACMEExternalAccountBindingBuilder builder;
  
    ExternalAccountBindingNested(ACMEExternalAccountBinding item) {
      this.builder = new ACMEExternalAccountBindingBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerFluent.this.withExternalAccountBinding(builder.build());
    }
    
    public N endExternalAccountBinding() {
      return and();
    }
    
  }
  public class PrivateKeySecretRefNested<N> extends SecretKeySelectorFluent<PrivateKeySecretRefNested<N>> implements Nested<N>{
  
    SecretKeySelectorBuilder builder;
  
    PrivateKeySecretRefNested(SecretKeySelector item) {
      this.builder = new SecretKeySelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerFluent.this.withPrivateKeySecretRef(builder.build());
    }
    
    public N endPrivateKeySecretRef() {
      return and();
    }
    
  }
  public class SolversNested<N> extends ACMEChallengeSolverFluent<SolversNested<N>> implements Nested<N>{
  
    ACMEChallengeSolverBuilder builder;
    int index;
  
    SolversNested(int index,ACMEChallengeSolver item) {
      this.index = index;
      this.builder = new ACMEChallengeSolverBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEIssuerFluent.this.setToSolvers(index, builder.build());
    }
    
    public N endSolver() {
      return and();
    }
    
  }
}