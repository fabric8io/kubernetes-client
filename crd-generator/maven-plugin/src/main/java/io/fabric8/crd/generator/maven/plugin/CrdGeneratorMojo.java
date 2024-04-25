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
package io.fabric8.crd.generator.maven.plugin;

import io.fabric8.crdv2.generator.CRDGenerationInfo;
import io.fabric8.crdv2.generator.CRDGenerator;
import io.fabric8.crdv2.generator.CustomResourceInfo;
import io.fabric8.kubernetes.client.CustomResource;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.DirectoryScanner;
import org.codehaus.plexus.util.Scanner;
import org.jboss.jandex.ClassInfo;
import org.jboss.jandex.ClassSummary;
import org.jboss.jandex.DotName;
import org.jboss.jandex.Index;
import org.jboss.jandex.Indexer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.zip.ZipFile;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.PROCESS_CLASSES, requiresDependencyCollection = ResolutionScope.COMPILE_PLUS_RUNTIME, requiresDependencyResolution = ResolutionScope.COMPILE_PLUS_RUNTIME)
public class CrdGeneratorMojo extends AbstractMojo {

  @Parameter(defaultValue = "${project}", required = true, readonly = true)
  private MavenProject mavenProject;

  /**
   * The input directory to be used to scan for CustomResource classes
   */
  @Parameter(property = "fabric8.crd-generator.classesDirectory", defaultValue = "${project.build.outputDirectory}", readonly = true)
  File classesDirectory;

  /**
   * Process the classes found in these file sets, after considering the specified includes and
   * excludes, if any. The format is:
   *
   * <pre>
   * &lt;fileSets&gt;
   *   &lt;fileSet&gt;
   *     &lt;directory&gt;path-or-expression&lt;/directory&gt;
   *     &lt;includes&gt;
   *       &lt;include&gt;some/thing/*.good&lt;/include&gt;
   *     &lt;/includes&gt;
   *     &lt;excludes&gt;
   *       &lt;exclude&gt;some/thing/*.bad&lt;/exclude&gt;
   *     &lt;/excludes&gt;
   *   &lt;/fileSet&gt;
   * &lt;/fileSets&gt;
   * </pre>
   *
   * Instead of the <code>directory</code> element, a <code>dependency</code> element may be used.
   * In that case, if the project has a corresponding dependency, classes in its artifact are
   * processed. The <code>dependency</code> element must specify a <code>groupId</code> and an
   * <code>artifactId</code> and may specify a <code>classifier</code>:
   *
   * <pre>
   * &lt;fileSets&gt;
   *   &lt;fileSet&gt;
   *     &lt;dependency&gt;
   *       &lt;groupId&gt;com.example&lt;/groupId&gt;
   *       &lt;artifactId&gt;my-project&lt;/artifactId&gt;
   *       &lt;classifier&gt;tests&lt;/artifactId&gt;
   *     &lt;/dependency&gt;
   *     &lt;includes&gt;
   *       &lt;include&gt;some/thing/*.good&lt;/include&gt;
   *     &lt;/includes&gt;
   *     &lt;excludes&gt;
   *       &lt;exclude&gt;some/thing/*.bad&lt;/exclude&gt;
   *     &lt;/excludes&gt;
   *   &lt;/fileSet&gt;
   * &lt;/fileSets&gt;
   * </pre>
   *
   * NOTE: Standard globbing expressions are supported in includes/excludes.
   */
  @Parameter
  private List<FileSet> fileSets;

  /**
   * If true, and if a file set rooted in the <code>target/classes</code> directory is not defined
   * explicitly, an implied file set rooted in the <code>target/classes</code> directory will be
   * used.
   */
  @Parameter(property = "fabric8.crd-generator.processDefaultFileSet", defaultValue = "true")
  private boolean processDefaultFileSet;

  @Parameter(property = "fabric8.crd-generator.outputDirectory", defaultValue = "${project.build.outputDirectory}/META-INF/fabric8/")
  private File outputDirectory;

  /**
   * Print verbose output (debug output without needing to enable -X for the whole build).
   */
  @Parameter(defaultValue = "false")
  private boolean verbose;

  /**
   * Skip execution if set.
   */
  @Parameter(property = "fabric8.crd-generator.skip", defaultValue = "false")
  private boolean skip;

  private ClassLoader classLoader;

  @Override
  public void execute() throws MojoExecutionException {
    if (skip) {
      getLog().info("CRD-Generator execution skipped");
      return;
    }

    List<FileSet> fileSets = getFileSets();
    Index index = createIndex(fileSets);
    CustomResourceInfo[] customResourceInfos = getCustomResources(index);

    try {
      Files.createDirectories(outputDirectory.toPath());
    } catch (IOException e) {
      throw new MojoExecutionException("Could not create output directory: " + e.getMessage());
    }

    CRDGenerator crdGenerator = new CRDGenerator()
        .customResources(customResourceInfos)
        .inOutputDir(outputDirectory);

    CRDGenerationInfo crdGenerationInfo = crdGenerator.detailedGenerate();
    crdGenerationInfo.getCRDDetailsPerNameAndVersion().forEach((crdName, versionToInfo) -> {
      getLog().info("Generated CRD " + crdName + ":");
      versionToInfo.forEach(
          (version, info) -> getLog().info(" " + version + " -> " + info.getFilePath()));
    });
  }

  private List<FileSet> getFileSets() {
    List<FileSet> sets = Optional.ofNullable(fileSets)
        .map(LinkedList::new)
        .orElseGet(LinkedList::new);

    if (processDefaultFileSet) {
      boolean explicitlyConfigured = false;
      for (FileSet fileset : sets) {
        if (fileset.getDirectory() != null && fileset.getDirectory().equals(classesDirectory)) {
          explicitlyConfigured = true;
          break;
        }
      }

      if (!explicitlyConfigured) {
        FileSet fs = new FileSet();
        fs.setDirectory(classesDirectory);
        fs.setIncludes(Collections.singletonList("**/*.class"));
        sets.add(fs);
      }
    }

    return sets;
  }

  private Index createIndex(List<FileSet> fileSets) throws MojoExecutionException {
    Indexer indexer = new Indexer();
    for (FileSet fileSet : fileSets) {
      if (fileSet.getDirectory() == null && fileSet.getDependency() == null) {
        throw new MojoExecutionException("File set must specify either directory or dependency");
      }
      if (fileSet.getDirectory() != null && fileSet.getDependency() != null) {
        throw new MojoExecutionException("File set may not specify both directory and dependency");
      }

      if (fileSet.getDirectory() != null) {
        indexDirectory(indexer, fileSet);
      } else if (fileSet.getDependency() != null) {
        indexDependency(indexer, fileSet);
      }
    }
    return indexer.complete();
  }

  private CustomResourceInfo[] getCustomResources(Index index) {
    Collection<ClassInfo> customResourcesClassInfos = index.getAllKnownSubclasses(DotName.createSimple(CustomResource.class));

    if (isVerbose()) {
      getLog().info("Found " + customResourcesClassInfos.size() + " CustomResource classes");
    }

    return customResourcesClassInfos.stream()
        .map(ClassInfo::toString)
        .peek(s -> {
          if (isVerbose()) {
            getLog().info("Loading CustomResource " + s);
          }
        })
        .map(this::loadCustomResourceClass)
        .map(this::createCustomResourceInfo)
        .toArray(CustomResourceInfo[]::new);
  }

  private CustomResourceInfo createCustomResourceInfo(
      Class<CustomResource<?, ?>> customResourceClass) {
    return CustomResourceInfo.fromClass(customResourceClass);
  }

  @SuppressWarnings("unchecked")
  private Class<CustomResource<?, ?>> loadCustomResourceClass(String className) {
    Class<?> clazz = loadClass(className);
    return (Class<CustomResource<?, ?>>) clazz;
  }

  private Class<?> loadClass(String className) {
    try {
      return getClassLoader().loadClass(className);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  private ClassLoader getClassLoader() {
    if (classLoader != null) {
      return classLoader;
    }
    classLoader = initClassLoader();
    return classLoader;
  }

  private ClassLoader initClassLoader() {
    try {
      URL[] runtimeUrls = mavenProject.getRuntimeClasspathElements().stream()
          .map(e -> {
            try {
              return new File(e).toURI().toURL();
            } catch (MalformedURLException ex) {
              throw new RuntimeException(ex);
            }
          }).toArray(URL[]::new);
      return new URLClassLoader(runtimeUrls, Thread.currentThread().getContextClassLoader());

    } catch (DependencyResolutionRequiredException e) {
      throw new RuntimeException(e);
    }
  }

  private void indexDependency(Indexer indexer, FileSet fileSet) throws MojoExecutionException {
    Dependency dependency = fileSet.getDependency();
    if (dependency.getGroupId() == null) {
      throw new MojoExecutionException("Dependency in file set must specify groupId");
    }
    if (dependency.getArtifactId() == null) {
      throw new MojoExecutionException("Dependency in file set must specify artifactId");
    }

    Artifact artifact = null;
    for (Artifact candidate : mavenProject.getArtifacts()) {
      if (candidate.getGroupId().equals(dependency.getGroupId())
          && candidate.getArtifactId().equals(dependency.getArtifactId())
          && (dependency.getClassifier() == null || candidate.getClassifier()
              .equals(dependency.getClassifier()))) {
        artifact = candidate;
        break;
      }
    }
    if (artifact == null) {
      getLog().warn(
          "Skipping file set, artifact not found among this project dependencies: " + dependency);
      return;
    }

    File archive = artifact.getFile();
    if (archive == null) {
      getLog().warn(
          "Skipping file set, artifact file does not exist for dependency: " + dependency);
      return;
    }

    ArchiveScanner scanner = new ArchiveScanner(archive);
    String[] files = findFilesToIndex(fileSet, scanner);
    try (ZipFile zip = new ZipFile(archive)) {
      for (String file : files) {
        if (file.endsWith(".class")) {
          try (InputStream in = zip.getInputStream(zip.getEntry(file))) {
            ClassSummary info = indexer.indexWithSummary(in);
            if (isVerbose() && info != null) {
              getLog().info(
                  "Indexed " + info.name() + " (" + info.annotationsCount() + " annotations)");
            }
          }
        }
      }
    } catch (IOException e) {
      throw new MojoExecutionException(e.getMessage(), e);
    }
  }

  private void indexDirectory(Indexer indexer, FileSet fileSet) throws MojoExecutionException {
    File dir = fileSet.getDirectory();
    if (!dir.exists()) {
      getLog().warn("Skipping file set, directory does not exist: " + fileSet.getDirectory());
      return;
    }

    DirectoryScanner scanner = new DirectoryScanner();
    scanner.setBasedir(dir);
    String[] files = findFilesToIndex(fileSet, scanner);
    getLog().info("Found " + files.length + " files in directory: " + dir);
    for (String file : files) {
      if (file.endsWith(".class")) {
        try (InputStream in = Files.newInputStream(new File(dir, file).toPath())) {
          ClassSummary info = indexer.indexWithSummary(in);
          if (isVerbose() && info != null) {
            getLog().info(
                "Indexed " + info.name() + " (" + info.annotationsCount() + " annotations)");
          }
        } catch (Exception e) {
          throw new MojoExecutionException(e.getMessage(), e);
        }
      }
    }
  }

  private String[] findFilesToIndex(FileSet fileSet, Scanner scanner) {
    // order files to get reproducible result
    scanner.setFilenameComparator(String::compareTo);

    if (fileSet.isUseDefaultExcludes()) {
      scanner.addDefaultExcludes();
    }

    List<String> includes = fileSet.getIncludes();
    if (includes != null) {
      scanner.setIncludes(includes.toArray(new String[0]));
    }

    List<String> excludes = fileSet.getExcludes();
    if (excludes != null) {
      scanner.setExcludes(excludes.toArray(new String[0]));
    }

    scanner.scan();
    return scanner.getIncludedFiles();
  }

  private boolean isVerbose() {
    return verbose || getLog().isDebugEnabled();
  }

}
