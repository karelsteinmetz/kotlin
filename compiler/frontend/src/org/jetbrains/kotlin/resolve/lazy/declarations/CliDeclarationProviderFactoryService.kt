/*
 * Copyright 2010-2015 JetBrains s.r.o.
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

package org.jetbrains.kotlin.resolve.lazy.declarations

import com.intellij.openapi.project.Project
import com.intellij.psi.search.GlobalSearchScope
import org.jetbrains.kotlin.psi.JetFile
import org.jetbrains.kotlin.storage.StorageManager
import org.jetbrains.kotlin.utils.sure
import java.util.ArrayList

public class CliDeclarationProviderFactoryService(private val sourceFiles: Collection<JetFile>) : DeclarationProviderFactoryService() {

    override fun create(
            project: Project,
            storageManager: StorageManager,
            syntheticFiles: Collection<JetFile>,
            filesScope: GlobalSearchScope
    ): DeclarationProviderFactory {
        val allFiles = ArrayList<JetFile>()
        sourceFiles.filterTo(allFiles) {
            val vFile = it.getVirtualFile().sure("Source files should be physical files")
            filesScope.contains(vFile)
        }
        allFiles addAll syntheticFiles
        return FileBasedDeclarationProviderFactory(storageManager, allFiles)
    }
}
