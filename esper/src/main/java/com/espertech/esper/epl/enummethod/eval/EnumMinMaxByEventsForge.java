/*
 ***************************************************************************************
 *  Copyright (C) 2006 EsperTech, Inc. All rights reserved.                            *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 ***************************************************************************************
 */
package com.espertech.esper.epl.enummethod.eval;

import com.espertech.esper.codegen.base.CodegenClassScope;
import com.espertech.esper.codegen.base.CodegenMethodScope;
import com.espertech.esper.codegen.model.expression.CodegenExpression;
import com.espertech.esper.epl.enummethod.codegen.EnumForgeCodegenParams;
import com.espertech.esper.epl.expression.core.ExprForge;

public class EnumMinMaxByEventsForge extends EnumForgeBase {

    protected final boolean max;

    public EnumMinMaxByEventsForge(ExprForge innerExpression, int streamCountIncoming, boolean max) {
        super(innerExpression, streamCountIncoming);
        this.max = max;
    }

    public EnumEval getEnumEvaluator() {
        return new EnumMinMaxByEventsForgeEval(this, innerExpression.getExprEvaluator());
    }

    public CodegenExpression codegen(EnumForgeCodegenParams premade, CodegenMethodScope codegenMethodScope, CodegenClassScope codegenClassScope) {
        return EnumMinMaxByEventsForgeEval.codegen(this, premade, codegenMethodScope, codegenClassScope);
    }
}
