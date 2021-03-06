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

package org.jetbrains.kotlin.idea.codeInsight.surroundWith.expression;

import com.intellij.codeInsight.CodeInsightUtilBase;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.descriptors.ClassDescriptor;
import org.jetbrains.kotlin.descriptors.ClassKind;
import org.jetbrains.kotlin.descriptors.ClassifierDescriptor;
import org.jetbrains.kotlin.idea.JetBundle;
import org.jetbrains.kotlin.idea.codeInsight.surroundWith.KotlinSurrounderUtils;
import org.jetbrains.kotlin.psi.JetExpression;
import org.jetbrains.kotlin.psi.JetWhenCondition;
import org.jetbrains.kotlin.psi.JetWhenEntry;
import org.jetbrains.kotlin.psi.JetWhenExpression;
import org.jetbrains.kotlin.types.JetType;

import static org.jetbrains.kotlin.psi.PsiPackage.JetPsiFactory;

public class KotlinWhenSurrounder extends KotlinExpressionSurrounder {
    @Override
    public String getTemplateDescription() {
        return JetBundle.message("surround.with.when.template");
    }

    @Override
    public boolean isApplicable(@NotNull JetExpression expression) {
        return true;
    }

    @Nullable
    @Override
    public TextRange surroundExpression(@NotNull Project project, @NotNull Editor editor, @NotNull JetExpression expression) {
        JetWhenExpression whenExpression = (JetWhenExpression) JetPsiFactory(expression).createExpression(getCodeTemplate(expression));
        JetExpression subjectExpression = whenExpression.getSubjectExpression();
        assert subjectExpression != null : "JetExpression should exists for " + whenExpression.getText() + " expression";
        subjectExpression.replace(expression);

        expression = (JetExpression) expression.replace(whenExpression);

        CodeInsightUtilBase.forcePsiPostprocessAndRestoreElement(expression);

        JetWhenEntry whenEntry = ((JetWhenExpression) expression).getEntries().get(0);
        JetWhenCondition whenEntryCondition = whenEntry.getConditions()[0];
        assert whenEntryCondition != null : "JetExpression for first entry should exists: " + expression.getText();
        TextRange whenRange = whenEntryCondition.getTextRange();
        editor.getDocument().deleteString(whenRange.getStartOffset(), whenRange.getEndOffset());
        int offset = whenRange.getStartOffset();
        return new TextRange(offset, offset);
    }

    private String getCodeTemplate(JetExpression expression) {
        JetType type = KotlinSurrounderUtils.getExpressionType(expression);
        if (type != null) {
            ClassifierDescriptor descriptor = type.getConstructor().getDeclarationDescriptor();
            if (descriptor instanceof ClassDescriptor && ((ClassDescriptor) descriptor).getKind() == ClassKind.ENUM_CLASS) {
                return "when(a) { \nb -> {}\n}";
            }
        }
        return "when(a) { \nb -> {}\n else -> {}\n}";
    }


}
