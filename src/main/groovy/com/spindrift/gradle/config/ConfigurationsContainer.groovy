/**
 * Copyright 2012 Spindrift
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.spindrift.gradle.config

import groovy.lang.Closure

import org.gradle.util.ConfigureUtil

class ConfigurationsContainer {

  ScriptConfiguration configuration
  List<ScriptConfiguration> configurations=[]
  
  void parameters(Closure closure) {
    configuration = new ScriptConfiguration()
    ConfigureUtil.configure(closure, configuration)
    ScriptConfiguration script = new ScriptConfiguration.Builder()
      .file(configuration.file)
      .workspace(configuration.workspace)
      .project(configuration.project)
      .options(configuration.options.clone())
      .build()
    configurations << script
  }

}
