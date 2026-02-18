/// usr/bin/env jbang "$0" "$@" ; exit $?
/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//JAVA 11+
//DEPS io.smallrye:jandex:3.5.0
//DEPS com.fasterxml.jackson.core:jackson-databind:2.20.0

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.AnnotationTarget;
import org.jboss.jandex.ClassInfo;
import org.jboss.jandex.DotName;
import org.jboss.jandex.IndexReader;
import org.jboss.jandex.IndexView;

import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * JBang script to generate GraalVM native-image metadata from Jandex indexes.
 *
 * Usage:
 *   jbang GenerateGraalvmMetadata.java <index-file> [options]
 *
 * Arguments:
 *   <index-file>                     Path to Jandex index file (required)
 *
 * Options:
 *   -o <file>                        Output file path (default: auto-detected from index location)
 *   -s <strategy>                    Inclusion strategy (default: JACKSON_ANNOTATIONS)
 *                                    Options: JACKSON_ANNOTATIONS, SUNDRIO_BUILDERS, KUBERNETES_RESOURCES,
 *                                            COMPREHENSIVE, PATTERN_BASED, ALL_PUBLIC_CLASSES, DIRECT_OBJECT_SUBCLASSES
 *   -i <pattern>                     Include pattern (can be specified multiple times)
 *   -e <pattern>                     Exclude pattern (can be specified multiple times)
 *   --no-merge                       Don't merge with existing reflect-config.json
 *   --no-constructors                Don't include all declared constructors
 *   --no-methods                     Don't include all declared methods
 *   --no-fields                      Don't include all declared fields
 *   -h, --help                       Show this help message
 *
 * Examples:
 *   jbang GenerateGraalvmMetadata.java target/classes/META-INF/jandex.idx
 *   jbang GenerateGraalvmMetadata.java target/classes/META-INF/jandex.idx -s COMPREHENSIVE
 *   jbang GenerateGraalvmMetadata.java target/classes/META-INF/jandex.idx -o output/reflect-config.json
 *   jbang GenerateGraalvmMetadata.java target/classes/META-INF/jandex.idx -i "io.fabric8.*" -e "*.internal.*"
 */
class GenerateGraalvmMetadata {

  public static void main(String[] args) {
    int exitCode = generate(args);
    System.exit(exitCode);
  }

  /**
   * Generate GraalVM metadata without calling System.exit().
   * Returns 0 on success, 1 on failure.
   * This method can be called from other scripts using jbang SOURCES directive.
   */
  static int generate(String[] args) {
    try {
      var config = parseArgs(args);
      if (config == null) {
        return 0; // Help was shown
      }

      if (!config.indexFile.exists()) {
        System.err.println("ERROR: Jandex index file not found: " + config.indexFile);
        System.err.println("Consider generating index with jandex-maven-plugin");
        return 1;
      }

      // Determine output file
      if (config.outputFile == null) {
        // index file is at: target/classes/META-INF/jandex.idx
        // we need: target/classes/META-INF/native-image/io.fabric8/<artifactId>/reflect-config.json
        var classesDir = config.indexFile.getParentFile().getParentFile().toPath(); // target/classes

        // Extract artifactId from pom.xml
        var moduleDir = classesDir.getParent().getParent().toFile(); // go up from target/classes to module root
        var artifactId = extractArtifactId(new File(moduleDir, "pom.xml"));
        if (artifactId == null) {
          artifactId = "kubernetes-client"; // fallback
        }

        config.outputFile = classesDir
          .resolve("META-INF/native-image/io.fabric8/" + artifactId + "/reflect-config.json")
          .toFile();
      }

      System.out.println("Generating GraalVM reflection configuration...");
      System.out.println("Index file: " + config.indexFile);
      System.out.println("Output file: " + config.outputFile);
      System.out.println("Strategy: " + config.strategy);

      // Scan classes
      var scanner = new JandexReflectionScanner(config.indexFile);
      var classes = scanner.findClasses(config.strategy, config.includePatterns, config.excludePatterns);

      if (classes.isEmpty()) {
        System.out.println("No classes found matching inclusion criteria");
        return 0;
      }

      System.out.println("Found " + classes.size() + " classes for reflection configuration");

      // Generate configuration
      var generator = new ReflectionConfigGenerator(
        config.allDeclaredConstructors,
        config.allDeclaredMethods,
        config.allDeclaredFields);

      generator.generate(classes, config.outputFile, config.mergeWithExisting);

      System.out.println("Successfully generated reflection configuration at: " + config.outputFile);
      return 0;

    } catch (Exception e) {
      System.err.println("ERROR: " + e.getMessage());
      e.printStackTrace();
      return 1;
    }
  }

  static Config parseArgs(String[] args) {
    if (args.length == 0 || args[0].equals("-h") || args[0].equals("--help")) {
      showHelp();
      return null;
    }

    var config = new Config();
    config.indexFile = new File(args[0]);

    for (int i = 1; i < args.length; i++) {
      var arg = args[i];
      switch (arg) {
        case "-o":
          config.outputFile = new File(args[++i]);
          break;
        case "-s":
          config.strategy = InclusionStrategy.valueOf(args[++i]);
          break;
        case "-i":
          config.includePatterns.add(args[++i]);
          break;
        case "-e":
          config.excludePatterns.add(args[++i]);
          break;
        case "--no-merge":
          config.mergeWithExisting = false;
          break;
        case "--no-constructors":
          config.allDeclaredConstructors = false;
          break;
        case "--no-methods":
          config.allDeclaredMethods = false;
          break;
        case "--no-fields":
          config.allDeclaredFields = false;
          break;
        case "-h":
        case "--help":
          showHelp();
          return null;
        default:
          System.err.println("Unknown option: " + arg);
          showHelp();
          System.exit(1);
      }
    }

    return config;
  }

  static String extractArtifactId(File pomFile) {
    if (!pomFile.exists()) {
      return null;
    }

    try {
      var dbFactory = DocumentBuilderFactory.newInstance();
      var dBuilder = dbFactory.newDocumentBuilder();
      var doc = dBuilder.parse(pomFile);
      doc.getDocumentElement().normalize();

      // Get the artifactId element that is a direct child of the root <project> element
      // (not from <parent> or <dependency> elements)
      var artifactIdNodes = doc.getElementsByTagName("artifactId");
      for (int i = 0; i < artifactIdNodes.getLength(); i++) {
        var node = artifactIdNodes.item(i);
        // Check if this artifactId's parent is <project> (not <parent>, <dependency>, etc.)
        if (node.getParentNode().getNodeName().equals("project")) {
          return node.getTextContent().trim();
        }
      }
    } catch (Exception e) {
      // If parsing fails, return null
      System.err.println("Warning: Could not extract artifactId from " + pomFile + ": " + e.getMessage());
    }

    return null;
  }

  static void showHelp() {
    System.out.println("GraalVM Metadata Generator");
    System.out.println();
    System.out.println("Usage: jbang GenerateGraalvmMetadata.java <index-file> [options]");
    System.out.println();
    System.out.println("Arguments:");
    System.out.println("  <index-file>                     Path to Jandex index file (required)");
    System.out.println();
    System.out.println("Options:");
    System.out.println("  -o <file>                        Output file path");
    System.out.println("                                   Default: target/classes/META-INF/native-image/");
    System.out.println("                                           io.fabric8/<artifactId>/reflect-config.json");
    System.out.println("  -s <strategy>                    Inclusion strategy (default: JACKSON_ANNOTATIONS)");
    System.out.println("                                   Options: JACKSON_ANNOTATIONS, SUNDRIO_BUILDERS,");
    System.out.println("                                           KUBERNETES_RESOURCES, COMPREHENSIVE,");
    System.out.println("                                           PATTERN_BASED, ALL_PUBLIC_CLASSES,");
    System.out.println("                                           DIRECT_OBJECT_SUBCLASSES");
    System.out.println("  -i <pattern>                     Include pattern (can be used multiple times)");
    System.out.println("  -e <pattern>                     Exclude pattern (can be used multiple times)");
    System.out.println("  --no-merge                       Don't merge with existing reflect-config.json");
    System.out.println("  --no-constructors                Don't include all declared constructors");
    System.out.println("  --no-methods                     Don't include all declared methods");
    System.out.println("  --no-fields                      Don't include all declared fields");
    System.out.println("  -h, --help                       Show this help message");
    System.out.println();
    System.out.println("Examples:");
    System.out.println("  jbang GenerateGraalvmMetadata.java target/classes/META-INF/jandex.idx");
    System.out.println("  jbang GenerateGraalvmMetadata.java target/classes/META-INF/jandex.idx -s COMPREHENSIVE");
    System.out.println("  jbang GenerateGraalvmMetadata.java target/classes/META-INF/jandex.idx -i \"io.fabric8.*\"");
  }

  static class Config {
    File indexFile;
    File outputFile;
    InclusionStrategy strategy = InclusionStrategy.JACKSON_ANNOTATIONS;
    List<String> includePatterns = new ArrayList<>();
    List<String> excludePatterns = new ArrayList<>();
    boolean mergeWithExisting = true;
    boolean allDeclaredConstructors = true;
    boolean allDeclaredMethods = true;
    boolean allDeclaredFields = true;
  }

  // ==================== Supporting Classes ====================

  enum InclusionStrategy {
    JACKSON_ANNOTATIONS,
    SUNDRIO_BUILDERS,
    KUBERNETES_RESOURCES,
    COMPREHENSIVE,
    PATTERN_BASED,
    ALL_PUBLIC_CLASSES,
    DIRECT_OBJECT_SUBCLASSES
  }

  static class JandexReflectionScanner {
    private static final DotName JSON_DESERIALIZE = DotName
      .createSimple("com.fasterxml.jackson.databind.annotation.JsonDeserialize");
    private static final DotName JSON_PROPERTY = DotName.createSimple("com.fasterxml.jackson.annotation.JsonProperty");
    private static final DotName JSON_SERIALIZE = DotName.createSimple("com.fasterxml.jackson.databind.annotation.JsonSerialize");
    private static final DotName JSON_TYPE_INFO = DotName.createSimple("com.fasterxml.jackson.annotation.JsonTypeInfo");
    private static final DotName JSON_SUB_TYPES = DotName.createSimple("com.fasterxml.jackson.annotation.JsonSubTypes");
    private static final DotName BUILDABLE = DotName.createSimple("io.sundr.builder.annotations.Buildable");
    private static final DotName HAS_METADATA = DotName.createSimple("io.fabric8.kubernetes.api.model.HasMetadata");

    private final IndexView index;

    public JandexReflectionScanner(File indexFile) throws IOException {
      try (InputStream in = new FileInputStream(indexFile)) {
        IndexReader reader = new IndexReader(in);
        this.index = reader.read();
      }
    }

    public Set<String> findClasses(InclusionStrategy strategy, List<String> includePatterns, List<String> excludePatterns) {
      var classes = new HashSet<String>();

      switch (strategy) {
        case JACKSON_ANNOTATIONS:
          classes.addAll(findJacksonAnnotatedClasses());
          break;
        case SUNDRIO_BUILDERS:
          classes.addAll(findSundrioBuilders());
          break;
        case KUBERNETES_RESOURCES:
          classes.addAll(findKubernetesResources());
          break;
        case COMPREHENSIVE:
          classes.addAll(findJacksonAnnotatedClasses());
          classes.addAll(findSundrioBuilders());
          classes.addAll(findKubernetesResources());
          break;
        case PATTERN_BASED:
          // Only use patterns, don't scan for annotations
          break;
        case ALL_PUBLIC_CLASSES:
          classes.addAll(findAllPublicClasses());
          break;
        case DIRECT_OBJECT_SUBCLASSES:
          classes.addAll(findDirectObjectSubclasses());
          break;
      }

      // Apply include patterns
      if (includePatterns != null && !includePatterns.isEmpty()) {
        var matchedByPatterns = findByPatterns(includePatterns);
        classes.addAll(matchedByPatterns);
      }

      // Apply exclude patterns
      if (excludePatterns != null && !excludePatterns.isEmpty()) {
        var excluded = findByPatterns(excludePatterns);
        classes.removeAll(excluded);
      }

      return classes;
    }

    private Set<String> findJacksonAnnotatedClasses() {
      var classes = new HashSet<String>();

      addClassesWithClassAnnotation(classes, JSON_DESERIALIZE);
      addClassesWithClassAnnotation(classes, JSON_SERIALIZE);
      addClassesWithClassAnnotation(classes, JSON_TYPE_INFO);
      addClassesWithClassAnnotation(classes, JSON_SUB_TYPES);
      addClassesWithMemberAnnotation(classes, JSON_PROPERTY);

      return classes;
    }

    private void addClassesWithClassAnnotation(Set<String> classes, DotName annotationName) {
      for (AnnotationInstance annotation : index.getAnnotations(annotationName)) {
        if (annotation.target().kind() == AnnotationTarget.Kind.CLASS) {
          classes.add(annotation.target().asClass().name().toString());
        }
      }
    }

    private void addClassesWithMemberAnnotation(Set<String> classes, DotName annotationName) {
      for (var annotation : index.getAnnotations(annotationName)) {
        var kind = annotation.target().kind();
        if (kind == AnnotationTarget.Kind.FIELD) {
          classes.add(annotation.target().asField().declaringClass().name().toString());
        } else if (kind == AnnotationTarget.Kind.METHOD) {
          classes.add(annotation.target().asMethod().declaringClass().name().toString());
        }
      }
    }

    private Set<String> findSundrioBuilders() {
      var classes = new HashSet<String>();

      for (var annotation : index.getAnnotations(BUILDABLE)) {
        if (annotation.target().kind() == AnnotationTarget.Kind.CLASS) {
          var className = annotation.target().asClass().name().toString();
          classes.add(className);

          // Add generated builder class
          var builderClassName = className + "Builder";
          if (index.getClassByName(DotName.createSimple(builderClassName)) != null) {
            classes.add(builderClassName);
          }
        }
      }

      return classes;
    }

    @SuppressWarnings("deprecation")
    private Set<String> findKubernetesResources() {
      var classes = new HashSet<String>();

      for (var classInfo : index.getAllKnownImplementors(HAS_METADATA)) {
        classes.add(classInfo.name().toString());
      }

      return classes;
    }

    private Set<String> findAllPublicClasses() {
      var classes = new HashSet<String>();

      for (var classInfo : index.getKnownClasses()) {
        if (java.lang.reflect.Modifier.isPublic(classInfo.flags())) {
          classes.add(classInfo.name().toString());
        }
      }

      return classes;
    }

    private Set<String> findDirectObjectSubclasses() {
      var classes = new HashSet<String>();
      var objectName = DotName.createSimple("java.lang.Object");

      for (var classInfo : index.getKnownClasses()) {
        if (classInfo.isInterface() || classInfo.isAnnotation()) {
          continue;
        }

        var superClass = classInfo.superName();
        if (superClass != null && superClass.equals(objectName)) {
          classes.add(classInfo.name().toString());
        }
      }

      return classes;
    }

    private Set<String> findByPatterns(List<String> patterns) {
      var classes = new HashSet<String>();

      if (patterns == null || patterns.isEmpty()) {
        return classes;
      }

      var compiledPatterns = patterns.stream()
        .map(p -> Pattern.compile(p.replace(".", "\\.").replace("*", ".*")))
        .collect(Collectors.toList());

      for (var classInfo : index.getKnownClasses()) {
        var className = classInfo.name().toString();
        for (var pattern : compiledPatterns) {
          if (pattern.matcher(className).matches()) {
            classes.add(className);
            break;
          }
        }
      }

      return classes;
    }
  }

  static class ReflectionConfigGenerator {
    private final ObjectMapper objectMapper;
    private final boolean allDeclaredConstructors;
    private final boolean allDeclaredMethods;
    private final boolean allDeclaredFields;

    public ReflectionConfigGenerator(boolean allDeclaredConstructors, boolean allDeclaredMethods,
                                     boolean allDeclaredFields) {
      this.allDeclaredConstructors = allDeclaredConstructors;
      this.allDeclaredMethods = allDeclaredMethods;
      this.allDeclaredFields = allDeclaredFields;

      this.objectMapper = new ObjectMapper();
      this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public void generate(Set<String> classes, File outputFile, boolean mergeWithExisting) throws IOException {
      var entries = new LinkedHashMap<String, ReflectionEntry>();

      // Load existing configuration if merging
      if (mergeWithExisting && outputFile.exists()) {
        var existing = loadExisting(outputFile);
        for (var entry : existing) {
          entries.put(entry.getName(), entry);
        }
      }

      // Add new classes
      for (var className : classes) {
        entries.computeIfAbsent(className, key -> {
          var entry = new ReflectionEntry(key);
          entry.setCondition(new ReflectionEntry.Condition(key));
          entry.setAllDeclaredConstructors(allDeclaredConstructors);
          entry.setAllDeclaredMethods(allDeclaredMethods);
          entry.setAllDeclaredFields(allDeclaredFields);
          return entry;
        });
      }

      // Sort by class name for stable output
      var sortedEntries = new ArrayList<>(entries.values());
      sortedEntries.sort(Comparator.comparing(ReflectionEntry::getName));

      // Ensure output directory exists
      var outputDir = outputFile.getParentFile();
      if (outputDir != null && !outputDir.exists()) {
        outputDir.mkdirs();
      }

      // Write to file
      objectMapper.writeValue(outputFile, sortedEntries);
    }

    private List<ReflectionEntry> loadExisting(File file) throws IOException {
      var entries = objectMapper.readValue(file, ReflectionEntry[].class);
      return Arrays.asList(entries);
    }
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  static class ReflectionEntry {
    @JsonProperty("condition")
    private Condition condition;

    @JsonProperty("name")
    private String name;

    @JsonProperty("allDeclaredConstructors")
    private Boolean allDeclaredConstructors;

    @JsonProperty("allDeclaredMethods")
    private Boolean allDeclaredMethods;

    @JsonProperty("allDeclaredFields")
    private Boolean allDeclaredFields;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Condition {
      @JsonProperty("typeReachable")
      private String typeReachable;

      public Condition() {
      }

      public Condition(String typeReachable) {
        this.typeReachable = typeReachable;
      }

      public String getTypeReachable() {
        return typeReachable;
      }

      public void setTypeReachable(String typeReachable) {
        this.typeReachable = typeReachable;
      }
    }

    public ReflectionEntry() {
    }

    public ReflectionEntry(String name) {
      this.name = name;
    }

    public Condition getCondition() {
      return condition;
    }

    public void setCondition(Condition condition) {
      this.condition = condition;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Boolean getAllDeclaredConstructors() {
      return allDeclaredConstructors;
    }

    public void setAllDeclaredConstructors(Boolean allDeclaredConstructors) {
      this.allDeclaredConstructors = allDeclaredConstructors;
    }

    public Boolean getAllDeclaredMethods() {
      return allDeclaredMethods;
    }

    public void setAllDeclaredMethods(Boolean allDeclaredMethods) {
      this.allDeclaredMethods = allDeclaredMethods;
    }

    public Boolean getAllDeclaredFields() {
      return allDeclaredFields;
    }

    public void setAllDeclaredFields(Boolean allDeclaredFields) {
      this.allDeclaredFields = allDeclaredFields;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      ReflectionEntry that = (ReflectionEntry) o;
      return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name);
    }

    @Override
    public String toString() {
      return "ReflectionEntry{" +
        "name='" + name + '\'' +
        ", allDeclaredConstructors=" + allDeclaredConstructors +
        ", allDeclaredMethods=" + allDeclaredMethods +
        ", allDeclaredFields=" + allDeclaredFields +
        '}';
    }
  }
}
