package com.dream.boot.thymeleaf.dialect;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

public class StringReplaceDialect extends AbstractDialect implements IExpressionObjectDialect {

    private final IExpressionObjectFactory stringReplaceExpressionFactory = new StringReplaceExpressionFactory();

    public StringReplaceDialect() {
        super("CUSTOMER_STRING_UTIL");
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return stringReplaceExpressionFactory;
    }
}
