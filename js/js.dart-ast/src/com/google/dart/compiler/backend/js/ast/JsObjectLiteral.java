// Copyright (c) 2011, the Dart project authors.  Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.

package com.google.dart.compiler.backend.js.ast;

import com.google.dart.compiler.util.AstUtil;
import com.intellij.util.SmartList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class JsObjectLiteral extends JsLiteral {
    private final List<JsPropertyInitializer> properties;

    private final boolean multiline;

    public JsObjectLiteral() {
        this(new SmartList<JsPropertyInitializer>());
    }

    public JsObjectLiteral(boolean multiline) {
        this(new SmartList<JsPropertyInitializer>(), multiline);
    }

    public boolean isMultiline() {
        return multiline;
    }

    public JsObjectLiteral(List<JsPropertyInitializer> properties) {
        this(properties, false);
    }

    public JsObjectLiteral(List<JsPropertyInitializer> properties, boolean multiline) {
        this.properties = properties;
        this.multiline = multiline;
    }

    public List<JsPropertyInitializer> getPropertyInitializers() {
        return properties;
    }

    @Override
    public void accept(JsVisitor v) {
        v.visitObjectLiteral(this);
    }

    @Override
    public void acceptChildren(JsVisitor visitor) {
        visitor.acceptWithInsertRemove(properties);
    }

    @Override
    public void traverse(JsVisitorWithContext v, JsContext ctx) {
        if (v.visit(this, ctx)) {
            v.acceptList(properties);
        }
        v.endVisit(this, ctx);
    }

    @NotNull
    @Override
    public JsObjectLiteral deepCopy() {
        return new JsObjectLiteral(AstUtil.deepCopy(properties), multiline).withMetadataFrom(this);
    }
}
